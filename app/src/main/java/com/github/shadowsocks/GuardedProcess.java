package com.github.shadowsocks;

import android.os.Build;
import android.util.Log;

import com.github.shadowsocks.utils.Commandline;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Semaphore;

/**
 * Created by terry on 2017/5/5.
 */

public class GuardedProcess {
    private static final String TAG = GuardedProcess.class.getSimpleName();
    private volatile Thread guardThread;
    private volatile boolean isDestroyed;
    private volatile Process process;
    private volatile boolean isRestart = false;
    private String[] mCmdList;

    public GuardedProcess(String[] cmdList) {
        mCmdList = cmdList;
    }

    GuardedProcess start() {
        final Semaphore semaphore = new Semaphore(1);
        try {
            semaphore.acquire();

            guardThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!isDestroyed) {
                        if (BuildConfig.DEBUG) {
                            Log.d(TAG, "start process: " + Commandline.toString(mCmdList));
                        }
                        long startTime = System.currentTimeMillis();

                        try {
                            process = new ProcessBuilder(mCmdList)
                                    .redirectErrorStream(true)
                                    .directory(ShadowsocksApplication.app.getFilesDir())
                                    .start();

                            final InputStream is = process.getInputStream();
                            new StreamLogger(is).start();
                            semaphore.release();
                            process.waitFor();

                        } catch (IOException e) {

                        } catch (InterruptedException e) {
                            if (BuildConfig.DEBUG) Log.d(TAG, "thread interrupt, destroy process: " + Commandline.toString(mCmdList));
                            destroyProcess();
                        } finally {
                            semaphore.release();
                        }
                    }
                }
            });
            guardThread.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }

    public void destroy() {
        isDestroyed = true;
        guardThread.interrupt();
        destroyProcess();
        try {
            guardThread.join();
        } catch (InterruptedException e) {

        }
    }

    public void destroyProcess() {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                JniHelper.sigtermCompat(process);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        process.destroy();
    }


    public void restart() {
        synchronized(this) {
            isRestart = true;
            destroyProcess();
        }
    }

    public int waitFor() throws InterruptedException {
        guardThread.join();
        return 0;
    }

    public static class StreamLogger extends Thread {
        private InputStream mInputStream;

        public StreamLogger(InputStream is) {
            mInputStream = is;
        }

        @Override
        public void run() {

        }
    }
}

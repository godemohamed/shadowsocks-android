package com.github.shadowsocks.acl;

/**
 * Created by terry on 2017/5/20.
 */
import android.support.annotation.NonNull;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;

import java.util.concurrent.TimeUnit;

import okio.Source;

public class AclSyncJob extends Job {
    public static final String TAG = AclSyncJob.class.getSimpleName();

    public static int schedule(String route) {
        JobRequest jobRequest = new JobRequest.Builder(AclSyncJob.TAG + ':' + route)
                .setExecutionWindow(TimeUnit.SECONDS.toMillis(10), TimeUnit.DAYS.toMillis(28))
                .setRequirementsEnforced(true)
                .setRequiredNetworkType(JobRequest.NetworkType.UNMETERED)
                .setRequiresCharging(true)
                .setUpdateCurrent(true)
                .build();
        return jobRequest.schedule();
    }

    @NonNull
    @Override
    protected Result onRunJob(Params params) {

        return null;
    }
}

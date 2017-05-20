package com.github.shadowsocks;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;

import com.github.shadowsocks.plugin.PluginOptions;
import com.github.shadowsocks.utils.Constants;
import com.github.shadowsocks.utils.TrafficMonitorThread;

import java.util.HashSet;
import java.util.List;
import java.util.Timer;

/**
 * Created by terry on 2017/5/14.
 */

public interface BaseService {
    public boolean closeReceiverRegistered = false;

    public Constants.State state = Constants.State.STOPPED;

    public Profile profile = null;

    public PluginOptions plugin = null;

    public String pluginPath = null;

    public Timer timer = null;

    public TrafficMonitorThread trafficMonitorThread = null;

    public final RemoteCallbackList<IShadowsocksServiceCallback> callbacks = new RemoteCallbackList<IShadowsocksServiceCallback>();

    public final HashSet<IBinder> bandwidthListeners = new HashSet<IBinder>();

    public Handler handler = null;

    public Handler restartHandler = null;

    public final IShadowsocksService.Stub binder = new IShadowsocksService.Stub() {
        @Override
        public int getState() throws RemoteException {
            return state.ordinal();
        }

        @Override
        public String getProfileName() throws RemoteException {
            return null;
        }

        @Override
        public void registerCallback(IShadowsocksServiceCallback cb) throws RemoteException {

        }

        @Override
        public void startListeningForBandwidth(IShadowsocksServiceCallback cb) throws RemoteException {

        }

        @Override
        public void stopListeningForBandwidth(IShadowsocksServiceCallback cb) throws RemoteException {

        }

        @Override
        public void unregisterCallback(IShadowsocksServiceCallback cb) throws RemoteException {

        }

        @Override
        public void use(int profileId) throws RemoteException {

        }

        @Override
        public void useSync(int profileId) throws RemoteException {

        }
    };

    public final BroadcastReceiver closeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    };

    public List<String> buildPluginCommandLine(BaseService service);

    public void changeState(int state, String msg);

    public void changeState(int state);

    public void checkProfile(Profile profile);

    public void setBinder(IShadowsocksService.Stub stub);

    public void startRunner(Profile profile);

    public void stopRunner(boolean stopService, String msg);

    public void connect();

    public void updateTrafficTotal(long tx, long rx);

    public Constants.State getState();

    public void updateTrafficRate();

    public static class BaseServiceInner {

        public static List<String> buildPluginCommandLine() {
            return null;
        }

        public static void connect(BaseService baseService) {
            if ("198.199.101.152".equals(profile.getHost())) {

            }
        }

        public static  String buildShadowsocksConfig(BaseService service, String file) {
            return null;
        }

    }

}

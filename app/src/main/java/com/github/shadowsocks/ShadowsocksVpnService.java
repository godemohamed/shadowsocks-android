package com.github.shadowsocks;

import android.net.VpnService;

import com.github.shadowsocks.utils.Constants;

import java.util.List;

/**
 * Created by terry on 2017/5/14.
 */

public class ShadowsocksVpnService extends VpnService implements BaseService {

    @Override
    public List<String> buildPluginCommandLine(BaseService service) {
        return null;
    }

    @Override
    public void changeState(int state, String msg) {

    }

    @Override
    public void changeState(int state) {

    }

    @Override
    public void checkProfile(Profile profile) {

    }

    @Override
    public void setBinder(IShadowsocksService.Stub stub) {

    }

    @Override
    public void startRunner(Profile profile) {

    }

    @Override
    public void stopRunner(boolean stopService, String msg) {

    }

    @Override
    public void connect() {

    }

    @Override
    public void updateTrafficTotal(long tx, long rx) {

    }

    @Override
    public Constants.State getState() {
        return null;
    }

    @Override
    public void updateTrafficRate() {

    }


}

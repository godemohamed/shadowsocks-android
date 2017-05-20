package com.github.shadowsocks;

import android.annotation.TargetApi;
import android.os.Binder;
import android.os.Build;

import java.util.Date;

/**
 * Created by terry on 2017/5/18.
 */

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public class Profile {

    private boolean bypass;

    private final Date date = new Date();

    private String host = "198.199.101.152";

    private int id;

    private String individual = "";

    private boolean ipv6;

    private int localPort = Binder.getCallingUserHandle().hashCode() + 1080;

    private String method = "aes-256-cfb";

    private String name = "";

    private String password = "u1rRWTssNv0p";

    private String plugin;

    private boolean proxyApps;

    private String remoteDns = "8.8.8.8";

    private int remotePort = 8388;

    private String route = "all";

    private long rx;

    private long tx;

    private boolean udpdns;

    private long userOrder;

    public boolean isBypass() {
        return bypass;
    }

    public void setBypass(boolean bypass) {
        this.bypass = bypass;
    }

    public Date getDate() {
        return date;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndividual() {
        return individual;
    }

    public void setIndividual(String individual) {
        this.individual = individual;
    }

    public boolean isIpv6() {
        return ipv6;
    }

    public void setIpv6(boolean ipv6) {
        this.ipv6 = ipv6;
    }

    public int getLocalPort() {
        return localPort;
    }

    public void setLocalPort(int localPort) {
        this.localPort = localPort;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlugin() {
        return plugin;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }

    public boolean isProxyApps() {
        return proxyApps;
    }

    public void setProxyApps(boolean proxyApps) {
        this.proxyApps = proxyApps;
    }

    public String getRemoteDns() {
        return remoteDns;
    }

    public void setRemoteDns(String remoteDns) {
        this.remoteDns = remoteDns;
    }

    public int getRemotePort() {
        return remotePort;
    }

    public void setRemotePort(int remotePort) {
        this.remotePort = remotePort;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public long getRx() {
        return rx;
    }

    public void setRx(long rx) {
        this.rx = rx;
    }

    public long getTx() {
        return tx;
    }

    public void setTx(long tx) {
        this.tx = tx;
    }

    public boolean isUdpdns() {
        return udpdns;
    }

    public void setUdpdns(boolean udpdns) {
        this.udpdns = udpdns;
    }

    public long getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(long userOrder) {
        this.userOrder = userOrder;
    }
}

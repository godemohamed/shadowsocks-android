package com.github.shadowsocks.database;

import android.annotation.TargetApi;
import android.os.Binder;
import android.os.Build;
import android.text.TextUtils;

import java.util.Date;

/**
 * Created by terry on 2017/5/15.
 */

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public class Profile {
    private int id;
    private String name;
    private String host = "198.199.101.152";
    private int localPort = 1080 + Binder.getCallingUserHandle().hashCode();
    private int remotePort = 8388;
    private String password = "u1rRWTssNv0p";
    private String method = "\"aes-256-cfb\"";
    private String route = "all";
    private String remoteDns = "8.8.8.8";
    private boolean proxyApps;
    private boolean bypass;
    private boolean udpdns;
    private boolean ipv6;
    private String individual;
    private long tx;
    private long rx;
    private Date date;
    private long userOrder;
    private String plugin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getLocalPort() {
        return localPort;
    }

    public void setLocalPort(int localPort) {
        this.localPort = localPort;
    }

    public int getRemotePort() {
        return remotePort;
    }

    public void setRemotePort(int remotePort) {
        this.remotePort = remotePort;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRemoteDns() {
        return remoteDns;
    }

    public void setRemoteDns(String remoteDns) {
        this.remoteDns = remoteDns;
    }

    public boolean isProxyApps() {
        return proxyApps;
    }

    public void setProxyApps(boolean proxyApps) {
        this.proxyApps = proxyApps;
    }

    public boolean isBypass() {
        return bypass;
    }

    public void setBypass(boolean bypass) {
        this.bypass = bypass;
    }

    public boolean isUdpdns() {
        return udpdns;
    }

    public void setUdpdns(boolean udpdns) {
        this.udpdns = udpdns;
    }

    public boolean isIpv6() {
        return ipv6;
    }

    public void setIpv6(boolean ipv6) {
        this.ipv6 = ipv6;
    }

    public String getIndividual() {
        return individual;
    }

    public void setIndividual(String individual) {
        this.individual = individual;
    }

    public long getTx() {
        return tx;
    }

    public void setTx(long tx) {
        this.tx = tx;
    }

    public long getRx() {
        return rx;
    }

    public void setRx(long rx) {
        this.rx = rx;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(long userOrder) {
        this.userOrder = userOrder;
    }

    public String getPlugin() {
        return plugin;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }

    public String formattedAddress() {
        String formattedString = "";

        if (host.contains(":")) {
            formattedString = String.format("[%s]:%d", host, remotePort);
        } else {
            formattedString = String.format("%s:%d", host, remotePort);
        }

        return formattedString;
    }

    public boolean nameIsEmpty() {
        return TextUtils.isEmpty(name);
    }

    public String getName() {
        if (nameIsEmpty()) {
            return formattedAddress();
        } else {
            return name;
        }
    }
}

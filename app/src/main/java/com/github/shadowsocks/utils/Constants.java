package com.github.shadowsocks.utils;

/**
 * Created by terry on 2017/5/18.
 */

public class Constants {
    public enum State {
        IDLE, CONNECTING, CONNECTED, STOPPING, STOPPED;
    }

    public static class Executable {
        public final static String REDSOCKS = "redsocks";
        public final static String PDNSD = "pdnsd";
        public final static String SS_LOCAL = "ss-local";
        public final static String SS_TUNNEL = "ss-tunnel";
        public final static String TUN2SOCKS = "tun2socks";
        public final static String[] EXECUTABLES = new String[] {SS_LOCAL, SS_TUNNEL, PDNSD, REDSOCKS, TUN2SOCKS};
    }

    public static class ConfigUtils {
        public static final String REDSOCKS = "base {\\n log_debug = off;\n log_info = off;\n log = stderr;\n daemon = off;\n redirector = iptables;\n}\nredsocks {\n local_ip = 127.0.0.1;\n local_port = 8123;\n ip = 127.0.0.1;\n port = %d;\n type = socks5;\n}\n";
        public static final String PDNSD_LOCAL = "\n      |global {\n      | perm_cache = 2048;\n      | %s\n      | cache_dir = \"%s\";\n      | server_ip = %s;\n      | server_port = %d;\n      | query_method = tcp_only;\n      | min_ttl = 15m;\n      | max_ttl = 1w;\n      | timeout = 10;\n      | daemon = off;\n      |}\n      |\n      |server {\n      | label = \"local\";\n      | ip = 127.0.0.1;\n      | port = %d;\n      | reject = %s;\n      | reject_policy = negate;\n      | reject_recursively = on;\n      |}\n      |\n      |rr {\n      | name=localhost;\n      | reverse=on;\n      | a=127.0.0.1;\n      | owner=localhost;\n      | soa=localhost,root.localhost,42,86400,900,86400,86400;\n      |}\n    ";
        public static final String PDNSD_DIRECT = "\n      |global {\n      | perm_cache = 2048;\n      | %s\n      | cache_dir = \"%s\";\n      | server_ip = %s;\n      | server_port = %d;\n      | query_method = udp_only;\n      | min_ttl = 15m;\n      | max_ttl = 1w;\n      | timeout = 10;\n      | daemon = off;\n      | par_queries = 4;\n      |}\n      |\n      |server {\n      | label = \"remote-servers\";\n      | ip = %s;\n      | timeout = 3;\n      | query_method = udp_only;\n      | %s\n      | policy = included;\n      | reject = %s;\n      | reject_policy = fail;\n      | reject_recursively = on;\n      |}\n      |\n      |server {\n      | label = \"local-server\";\n      | ip = 127.0.0.1;\n      | query_method = tcp_only;\n      | port = %d;\n      | reject = %s;\n      | reject_policy = negate;\n      | reject_recursively = on;\n      |}\n      |\n      |rr {\n      | name=localhost;\n      | reverse=on;\n      | a=127.0.0.1;\n      | owner=localhost;\n      | soa=localhost,root.localhost,42,86400,900,86400,86400;\n      |}\n    ";
    }
    
    public static class Key {
        public static final String id = "profileId";
        public static final String name = "profileName";
        
        public static final String individual = "Proxyed";

        public static final String isNAT = "isNAT";
        public static final String route = "route";

        public static final String isAutoConnect = "isAutoConnect";

        public static final String proxyApps = "isProxyApps";
        public static final String bypass = "isBypassApps";
        public static final String udpdns = "isUdpDns";
        public static final String ipv6 = "isIpv6";

        public static final String host = "proxy";
        public static final String password = "sitekey";
        public static final String method = "encMethod";
        public static final String remotePort = "remotePortNum";
        public static final String localPort = "localPortNum";
        public static final String remoteDns = "remoteDns";

        public static final String plugin = "plugin";
        public static final String pluginConfigure = "plugin.configure";

        public static final String dirty = "profileDirty";

        public static final String tfo = "tcp_fastopen";
        public static final String currentVersionCode = "currentVersionCode";
    }
    
    public static class Action {
        public static final String SERVICE = "com.github.shadowsocks.SERVICE";
        public static final String CLOSE = "com.github.shadowsocks.CLOSE";

        public static final String EXTRA_PROFILE_ID = "com.github.shadowsocks.EXTRA_PROFILE_ID";
    }
}

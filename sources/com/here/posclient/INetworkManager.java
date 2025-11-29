package com.here.posclient;

public interface INetworkManager {

    public static class Connection {
        public boolean isConnected;
        public boolean isRoaming;
        public MeterStatus meteredStatus = MeterStatus.UNKNOWN;
        public Type type = Type.NONE;

        public enum MeterStatus {
            UNKNOWN,
            NOT_METERED,
            METERED
        }

        public enum Type {
            NONE,
            WIFI,
            MOBILE,
            ETHERNET,
            OTHER
        }

        public boolean isSame(Connection connection) {
            return connection != null && this.type == connection.type && this.meteredStatus == connection.meteredStatus && this.isRoaming == connection.isRoaming;
        }

        public boolean isSameType(Connection connection) {
            return connection != null && this.type == connection.type;
        }

        public String toString() {
            return "Connection [" + "type=" + this.type.name() + ";roaming=" + this.isRoaming + ";meteredStatus=" + this.meteredStatus.name() + ";connected=" + this.isConnected + "]";
        }
    }

    public static class Proxy {
        public String address = null;
        public int port = 8080;
    }

    Connection[] getConnections();

    Connection getDataConnection();

    Proxy getProxy(String str);
}

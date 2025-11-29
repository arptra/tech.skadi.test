package com.upuphone.runasone.channel.proxy.client.nat;

import java.util.HashMap;

public class UDPMap {
    public static MapEntity _FROM = new MapEntity();
    public static MapEntity _TO = new MapEntity();

    public static class Address {
        public int ip;
        public short port;
    }

    public static class MapEntity {
        private HashMap<Short, Address> map;

        public synchronized void clear() {
            this.map.clear();
        }

        public Address find(short s) {
            return this.map.get(Short.valueOf(s));
        }

        public void map(short s, int i, short s2) {
            Address address = this.map.get(Short.valueOf(s));
            if (address == null) {
                address = new Address();
                this.map.put(Short.valueOf(s), address);
            }
            address.ip = i;
            address.port = s2;
        }

        public void remove(short s) {
            this.map.remove(Short.valueOf(s));
        }

        private MapEntity() {
            this.map = new HashMap<>();
        }
    }

    public static String tostring() {
        return "";
    }
}

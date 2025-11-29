package com.android.net.module.util;

public abstract class DnsPacket {

    public class DnsHeader {
    }

    public class DnsRecord {
    }

    public static class ParseException extends RuntimeException {
        public String reason;

        public ParseException(String str) {
            super(str);
            this.reason = str;
        }

        public ParseException(String str, Throwable th) {
            super(str, th);
            this.reason = str;
        }
    }
}

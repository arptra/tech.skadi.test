package com.here.posclient;

public class CellularStatus {
    public long interfaceIndex = 0;
    public long status = 0;

    public static final class StatusCode {
        public static final long DCH_FLAG = 4096;
        public static final long DENIED = 2;
        public static final long HOME = 3;
        public static final long NR_CAPABLE_FLAG = 8192;
        public static final long ROAMING = 4;
        public static final long UNKNOWN = 0;
        public static final long UNREGISTERED = 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        long j = this.status & -12289;
        if (j == 1) {
            sb.append("UNREGISTERED");
        } else if (j == 2) {
            sb.append("DENIED");
        } else if (j == 3) {
            sb.append("HOME");
        } else if (j == 4) {
            sb.append("ROAMING");
        } else if (j == 0) {
            sb.append("UNKNOWN");
        } else {
            sb.append("UNRECOGNIZED");
        }
        if ((this.status & 4096) != 0) {
            sb.append(", DCH");
        }
        if ((this.status & 8192) != 0) {
            sb.append(", NR CAP");
        }
        return sb.toString();
    }
}

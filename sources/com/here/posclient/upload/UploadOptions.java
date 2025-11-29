package com.here.posclient.upload;

public class UploadOptions {
    private static final String TAG = "posclient.upload.UploadOptions";
    public int batteryLevel = 0;
    public ConnectionType connectionType = ConnectionType.UNSPECIFIED;
    public long flags = 0;

    public enum ConnectionType {
        UNSPECIFIED,
        WIFI,
        MOBILE
    }

    public interface Flag {
        public static final int IGNORE_AGE = 2;
        public static final int IGNORE_UPLOAD_QUOTA = 1;
        public static final int NONE = 0;
        public static final int SIMULATE_UPLOAD = 4;
    }

    public UploadOptions setBatteryLevel(int i) {
        this.batteryLevel = i;
        return this;
    }

    public UploadOptions setConnectionType(ConnectionType connectionType2) {
        this.connectionType = connectionType2;
        return this;
    }

    public UploadOptions setFlags(long j) {
        this.flags = j;
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("UploadOptions [");
        stringBuffer.append("connection type: ");
        stringBuffer.append(this.connectionType.toString());
        stringBuffer.append("battery level: ");
        stringBuffer.append(this.batteryLevel);
        stringBuffer.append("flags: ");
        stringBuffer.append(Long.toHexString(this.flags));
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

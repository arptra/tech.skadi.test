package com.here.posclient.analytics;

public class RadiomapCounters extends Counters {
    public final long downloadCount;
    public final long downloadFileSize;
    public final long errors;

    public RadiomapCounters(int i, long[] jArr) {
        super(i);
        this.errors = jArr[0];
        this.downloadCount = jArr[1];
        this.downloadFileSize = jArr[2];
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("RadiomapCounters [");
        stringBuffer.append("event: ");
        stringBuffer.append(this.event);
        stringBuffer.append(", errors: ");
        stringBuffer.append(this.errors);
        stringBuffer.append(", downloadCount: ");
        stringBuffer.append(this.downloadCount);
        stringBuffer.append(", downloadFileSize: ");
        stringBuffer.append(this.downloadFileSize);
        stringBuffer.append("kB");
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

package org.libpag;

public class PAGVideoRange {
    public long endTime;
    public long playDuration;
    public boolean reversed;
    public long startTime;

    public PAGVideoRange(long j, long j2, long j3, boolean z) {
        this.startTime = j;
        this.endTime = j2;
        this.playDuration = j3;
        this.reversed = z;
    }
}

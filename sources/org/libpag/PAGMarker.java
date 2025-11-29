package org.libpag;

public class PAGMarker {
    public String mComment;
    public long mDuration;
    public long mStartTime;

    public PAGMarker(long j, long j2, String str) {
        this.mStartTime = j;
        this.mDuration = j2;
        this.mComment = str;
    }
}

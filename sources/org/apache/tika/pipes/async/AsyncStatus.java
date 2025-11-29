package org.apache.tika.pipes.async;

import java.time.Instant;
import java.util.Map;
import org.apache.tika.pipes.pipesiterator.TotalCountResult;

public class AsyncStatus {

    /* renamed from: a  reason: collision with root package name */
    public final Instant f3303a;
    public Instant b;
    public TotalCountResult c;
    public Map d;
    public ASYNC_STATUS e;
    public String f;

    public enum ASYNC_STATUS {
        STARTED,
        COMPLETED,
        CRASHED
    }

    public String toString() {
        return "AsyncStatus{started=" + this.f3303a + ", lastUpdate=" + this.b + ", totalCountResult=" + this.c + ", statusCounts=" + this.d + ", asyncStatus=" + this.e + ", crashMessage='" + this.f + '\'' + '}';
    }
}

package org.apache.tika.pipes.pipesiterator;

public class TotalCountResult {
    public static TotalCountResult c = new TotalCountResult(-1, STATUS.UNSUPPORTED);

    /* renamed from: a  reason: collision with root package name */
    public long f3309a;
    public STATUS b;

    public enum STATUS {
        UNSUPPORTED,
        EXCEPTION,
        NOT_COMPLETED,
        COMPLETED
    }

    public TotalCountResult(long j, STATUS status) {
        this.f3309a = j;
        this.b = status;
    }

    public String toString() {
        return "TotalCountResult{totalCount=" + this.f3309a + ", status=" + this.b + '}';
    }
}

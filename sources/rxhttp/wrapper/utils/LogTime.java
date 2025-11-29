package rxhttp.wrapper.utils;

import java.util.concurrent.TimeUnit;

public class LogTime {

    /* renamed from: a  reason: collision with root package name */
    public final long f3573a = System.nanoTime();

    public long a() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.f3573a);
    }
}

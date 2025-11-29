package zmq.poll;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import zmq.util.Clock;
import zmq.util.MultiMap;

abstract class PollerBase implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f3655a = new AtomicInteger(0);
    public final MultiMap b = new MultiMap();
    public final Thread c;
    public boolean d;

    public static final class TimerInfo {

        /* renamed from: a  reason: collision with root package name */
        public final IPollEvents f3656a;
        public final int b;
        public boolean c;

        public TimerInfo(IPollEvents iPollEvents, int i) {
            this.f3656a = iPollEvents;
            this.b = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof TimerInfo)) {
                return false;
            }
            TimerInfo timerInfo = (TimerInfo) obj;
            return this.b == timerInfo.b && this.f3656a.equals(timerInfo.f3656a);
        }

        public int hashCode() {
            return ((this.b + 31) * 31) + this.f3656a.hashCode();
        }

        public String toString() {
            return "TimerInfo [id=" + this.b + ", sink=" + this.f3656a + "]";
        }
    }

    public PollerBase(String str) {
        this.c = e(str);
    }

    public void a(long j, IPollEvents iPollEvents, int i) {
        long d2 = d() + j;
        this.b.e(Long.valueOf(d2), new TimerInfo(iPollEvents, i));
        this.d = true;
    }

    public void b(int i) {
        this.f3655a.addAndGet(i);
    }

    public void c(IPollEvents iPollEvents, int i) {
        TimerInfo timerInfo = (TimerInfo) this.b.b(new TimerInfo(iPollEvents, i));
        if (timerInfo != null) {
            boolean unused = timerInfo.c = true;
        }
    }

    public long d() {
        return Clock.a();
    }

    public Thread e(String str) {
        Thread thread = new Thread(this, str);
        thread.setDaemon(true);
        return thread;
    }

    public long f() {
        this.d = false;
        if (this.b.f()) {
            return 0;
        }
        long d2 = d();
        for (Map.Entry entry : this.b.a()) {
            TimerInfo timerInfo = (TimerInfo) entry.getKey();
            if (timerInfo.c) {
                this.b.h((Long) entry.getValue(), timerInfo);
            } else {
                Long l = (Long) entry.getValue();
                if (l.longValue() > d2) {
                    return l.longValue() - d2;
                }
                this.b.h(l, timerInfo);
                timerInfo.f3656a.g(timerInfo.b);
            }
        }
        for (Map.Entry value : this.b.a()) {
            Long l2 = (Long) value.getValue();
            if (!this.b.d(l2)) {
                this.b.g(l2);
            }
        }
        if (this.d) {
            return f();
        }
        return 0;
    }

    public int g() {
        return this.f3655a.get();
    }
}

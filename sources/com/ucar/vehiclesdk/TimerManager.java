package com.ucar.vehiclesdk;

import com.easy.logger.EasyLog;
import java.util.Timer;
import java.util.TimerTask;

public class TimerManager {

    /* renamed from: a  reason: collision with root package name */
    public ITimeOutListener f5358a;
    public TimerTask b;
    public Timer c;
    public TimerTask d;
    public Timer e;

    public interface ITimeOutListener {
        void a();

        void b();
    }

    public void b() {
        if (this.c != null) {
            EasyLog.a("TimerManager", "cancel connect timer");
            this.c.cancel();
            this.b = null;
            this.c = null;
        }
    }

    public void c() {
        if (this.e != null) {
            EasyLog.a("TimerManager", "cancel heart beat timer");
            this.e.cancel();
            this.d = null;
            this.e = null;
        }
    }

    public final void d() {
        this.b = new TimerTask() {
            public void run() {
                EasyLog.a("TimerManager", "connect time out");
                if (TimerManager.this.f5358a != null) {
                    TimerManager.this.f5358a.b();
                }
            }
        };
        this.c = new Timer();
    }

    public final void e() {
        this.d = new TimerTask() {
            public void run() {
                EasyLog.a("TimerManager", "heart beat time out");
                if (TimerManager.this.f5358a != null) {
                    TimerManager.this.f5358a.a();
                }
            }
        };
        this.e = new Timer();
    }

    public void f() {
        d();
        if (this.c != null) {
            EasyLog.a("TimerManager", "schedule connect timer");
            this.c.schedule(this.b, 10000);
        }
    }

    public void g() {
        e();
        if (this.e != null) {
            EasyLog.a("TimerManager", "schedule heart beat timer");
            this.e.schedule(this.d, 7000);
        }
    }
}

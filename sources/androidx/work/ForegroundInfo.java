package androidx.work;

import android.app.Notification;

public final class ForegroundInfo {

    /* renamed from: a  reason: collision with root package name */
    public final int f2055a;
    public final int b;
    public final Notification c;

    public ForegroundInfo(int i, Notification notification, int i2) {
        this.f2055a = i;
        this.c = notification;
        this.b = i2;
    }

    public int a() {
        return this.b;
    }

    public Notification b() {
        return this.c;
    }

    public int c() {
        return this.f2055a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ForegroundInfo.class != obj.getClass()) {
            return false;
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) obj;
        if (this.f2055a == foregroundInfo.f2055a && this.b == foregroundInfo.b) {
            return this.c.equals(foregroundInfo.c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f2055a * 31) + this.b) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{" + "mNotificationId=" + this.f2055a + ", mForegroundServiceType=" + this.b + ", mNotification=" + this.c + '}';
    }
}

package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.net.Uri;

@Deprecated
public class BrowserActionItem {

    /* renamed from: a  reason: collision with root package name */
    public final String f390a;
    public final PendingIntent b;
    public int c;
    public Uri d;
    public Runnable e;

    public PendingIntent a() {
        PendingIntent pendingIntent = this.b;
        if (pendingIntent != null) {
            return pendingIntent;
        }
        throw new IllegalStateException("Can't call getAction on BrowserActionItem with null action.");
    }

    public int b() {
        return this.c;
    }

    public Uri c() {
        return this.d;
    }

    public Runnable d() {
        return this.e;
    }

    public String e() {
        return this.f390a;
    }
}

package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f750a;
    public final /* synthetic */ Location b;

    public /* synthetic */ a(Consumer consumer, Location location) {
        this.f750a = consumer;
        this.b = location;
    }

    public final void run() {
        this.f750a.accept(this.b);
    }
}

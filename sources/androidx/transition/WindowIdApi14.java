package androidx.transition;

import android.os.IBinder;

class WindowIdApi14 implements WindowIdImpl {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f1889a;

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi14) && ((WindowIdApi14) obj).f1889a.equals(this.f1889a);
    }

    public int hashCode() {
        return this.f1889a.hashCode();
    }
}

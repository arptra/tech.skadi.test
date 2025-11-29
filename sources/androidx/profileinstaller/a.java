package androidx.profileinstaller;

import android.view.Choreographer;

public final /* synthetic */ class a implements Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f1717a;

    public /* synthetic */ a(Runnable runnable) {
        this.f1717a = runnable;
    }

    public final void doFrame(long j) {
        this.f1717a.run();
    }
}

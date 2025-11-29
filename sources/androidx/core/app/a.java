package androidx.core.app;

import android.app.SharedElementCallback;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;

public final /* synthetic */ class a implements SharedElementCallback.OnSharedElementsReadyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedElementCallback.OnSharedElementsReadyListener f684a;

    public /* synthetic */ a(SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.f684a = onSharedElementsReadyListener;
    }

    public final void a() {
        ActivityCompat.Api23Impl.a(this.f684a);
    }
}

package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class d implements WindowInsetsController.OnControllableInsetsChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f939a;

    public /* synthetic */ d(AtomicBoolean atomicBoolean) {
        this.f939a = atomicBoolean;
    }

    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i) {
        SoftwareKeyboardControllerCompat.Impl30.f(this.f939a, windowInsetsController, i);
    }
}

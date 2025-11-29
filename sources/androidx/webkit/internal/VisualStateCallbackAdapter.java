package androidx.webkit.internal;

import androidx.webkit.WebViewCompat;
import org.chromium.support_lib_boundary.VisualStateCallbackBoundaryInterface;

public class VisualStateCallbackAdapter implements VisualStateCallbackBoundaryInterface {

    /* renamed from: a  reason: collision with root package name */
    public final WebViewCompat.VisualStateCallback f1977a;

    public void onComplete(long j) {
        this.f1977a.onComplete(j);
    }
}

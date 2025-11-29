package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat;

class CallbackWithHandler {

    /* renamed from: a  reason: collision with root package name */
    public final FontsContractCompat.FontRequestCallback f783a;
    public final Handler b;

    public CallbackWithHandler(FontsContractCompat.FontRequestCallback fontRequestCallback, Handler handler) {
        this.f783a = fontRequestCallback;
        this.b = handler;
    }

    public final void a(final int i) {
        final FontsContractCompat.FontRequestCallback fontRequestCallback = this.f783a;
        this.b.post(new Runnable() {
            public void run() {
                fontRequestCallback.a(i);
            }
        });
    }

    public void b(FontRequestWorker.TypefaceResult typefaceResult) {
        if (typefaceResult.a()) {
            c(typefaceResult.f795a);
        } else {
            a(typefaceResult.b);
        }
    }

    public final void c(final Typeface typeface) {
        final FontsContractCompat.FontRequestCallback fontRequestCallback = this.f783a;
        this.b.post(new Runnable() {
            public void run() {
                fontRequestCallback.b(typeface);
            }
        });
    }
}

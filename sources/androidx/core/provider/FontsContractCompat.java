package androidx.core.provider;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

public class FontsContractCompat {

    public static final class Columns implements BaseColumns {
    }

    public static class FontFamilyResult {

        /* renamed from: a  reason: collision with root package name */
        public final int f796a;
        public final FontInfo[] b;

        public FontFamilyResult(int i, FontInfo[] fontInfoArr) {
            this.f796a = i;
            this.b = fontInfoArr;
        }

        public static FontFamilyResult a(int i, FontInfo[] fontInfoArr) {
            return new FontFamilyResult(i, fontInfoArr);
        }

        public FontInfo[] b() {
            return this.b;
        }

        public int c() {
            return this.f796a;
        }
    }

    public static class FontInfo {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f797a;
        public final int b;
        public final int c;
        public final boolean d;
        public final int e;

        public FontInfo(Uri uri, int i, int i2, boolean z, int i3) {
            this.f797a = (Uri) Preconditions.h(uri);
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        public static FontInfo a(Uri uri, int i, int i2, boolean z, int i3) {
            return new FontInfo(uri, i, i2, z, i3);
        }

        public int b() {
            return this.e;
        }

        public int c() {
            return this.b;
        }

        public Uri d() {
            return this.f797a;
        }

        public int e() {
            return this.c;
        }

        public boolean f() {
            return this.d;
        }
    }

    public static class FontRequestCallback {

        @RestrictTo
        @Retention(RetentionPolicy.SOURCE)
        public @interface FontRequestFailReason {
        }

        public void a(int i) {
        }

        public void b(Typeface typeface) {
        }
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, FontInfo[] fontInfoArr) {
        return TypefaceCompat.b(context, cancellationSignal, fontInfoArr, 0);
    }

    public static FontFamilyResult b(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) {
        return FontProvider.e(context, fontRequest, cancellationSignal);
    }

    public static Typeface c(Context context, FontRequest fontRequest, int i, boolean z, int i2, Handler handler, FontRequestCallback fontRequestCallback) {
        CallbackWithHandler callbackWithHandler = new CallbackWithHandler(fontRequestCallback, handler);
        return z ? FontRequestWorker.e(context, fontRequest, callbackWithHandler, i, i2) : FontRequestWorker.d(context, fontRequest, i, (Executor) null, callbackWithHandler);
    }
}

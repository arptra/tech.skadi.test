package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontsContractCompat;
import com.meizu.common.util.LunarCalendar;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

class FontRequestWorker {

    /* renamed from: a  reason: collision with root package name */
    public static final LruCache f790a = new LruCache(16);
    public static final ExecutorService b = RequestExecutor.a("fonts-androidx", 10, 10000);
    public static final Object c = new Object();
    public static final SimpleArrayMap d = new SimpleArrayMap();

    public static String a(FontRequest fontRequest, int i) {
        return fontRequest.d() + LunarCalendar.DATE_SEPARATOR + i;
    }

    public static int b(FontsContractCompat.FontFamilyResult fontFamilyResult) {
        int i = 1;
        if (fontFamilyResult.c() != 0) {
            return fontFamilyResult.c() != 1 ? -3 : -2;
        }
        FontsContractCompat.FontInfo[] b2 = fontFamilyResult.b();
        if (!(b2 == null || b2.length == 0)) {
            int length = b2.length;
            i = 0;
            int i2 = 0;
            while (i2 < length) {
                int b3 = b2[i2].b();
                if (b3 == 0) {
                    i2++;
                } else if (b3 < 0) {
                    return -3;
                } else {
                    return b3;
                }
            }
        }
        return i;
    }

    public static TypefaceResult c(String str, Context context, FontRequest fontRequest, int i) {
        LruCache lruCache = f790a;
        Typeface typeface = (Typeface) lruCache.get(str);
        if (typeface != null) {
            return new TypefaceResult(typeface);
        }
        try {
            FontsContractCompat.FontFamilyResult e = FontProvider.e(context, fontRequest, (CancellationSignal) null);
            int b2 = b(e);
            if (b2 != 0) {
                return new TypefaceResult(b2);
            }
            Typeface b3 = TypefaceCompat.b(context, (CancellationSignal) null, e.b(), i);
            if (b3 == null) {
                return new TypefaceResult(-3);
            }
            lruCache.put(str, b3);
            return new TypefaceResult(b3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new TypefaceResult(-1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        r9 = new androidx.core.provider.FontRequestWorker.AnonymousClass3();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r8 != null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        r8 = b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        androidx.core.provider.RequestExecutor.b(r8, r9, new androidx.core.provider.FontRequestWorker.AnonymousClass4());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface d(final android.content.Context r5, final androidx.core.provider.FontRequest r6, final int r7, java.util.concurrent.Executor r8, final androidx.core.provider.CallbackWithHandler r9) {
        /*
            java.lang.String r0 = a(r6, r7)
            androidx.collection.LruCache r1 = f790a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0017
            androidx.core.provider.FontRequestWorker$TypefaceResult r5 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r5.<init>((android.graphics.Typeface) r1)
            r9.b(r5)
            return r1
        L_0x0017:
            androidx.core.provider.FontRequestWorker$2 r1 = new androidx.core.provider.FontRequestWorker$2
            r1.<init>()
            java.lang.Object r9 = c
            monitor-enter(r9)
            androidx.collection.SimpleArrayMap r2 = d     // Catch:{ all -> 0x002f }
            java.lang.Object r3 = r2.get(r0)     // Catch:{ all -> 0x002f }
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ all -> 0x002f }
            r4 = 0
            if (r3 == 0) goto L_0x0031
            r3.add(r1)     // Catch:{ all -> 0x002f }
            monitor-exit(r9)     // Catch:{ all -> 0x002f }
            return r4
        L_0x002f:
            r5 = move-exception
            goto L_0x004f
        L_0x0031:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x002f }
            r3.<init>()     // Catch:{ all -> 0x002f }
            r3.add(r1)     // Catch:{ all -> 0x002f }
            r2.put(r0, r3)     // Catch:{ all -> 0x002f }
            monitor-exit(r9)     // Catch:{ all -> 0x002f }
            androidx.core.provider.FontRequestWorker$3 r9 = new androidx.core.provider.FontRequestWorker$3
            r9.<init>(r0, r5, r6, r7)
            if (r8 != 0) goto L_0x0046
            java.util.concurrent.ExecutorService r8 = b
        L_0x0046:
            androidx.core.provider.FontRequestWorker$4 r5 = new androidx.core.provider.FontRequestWorker$4
            r5.<init>(r0)
            androidx.core.provider.RequestExecutor.b(r8, r9, r5)
            return r4
        L_0x004f:
            monitor-exit(r9)     // Catch:{ all -> 0x002f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontRequestWorker.d(android.content.Context, androidx.core.provider.FontRequest, int, java.util.concurrent.Executor, androidx.core.provider.CallbackWithHandler):android.graphics.Typeface");
    }

    public static Typeface e(final Context context, final FontRequest fontRequest, CallbackWithHandler callbackWithHandler, final int i, int i2) {
        final String a2 = a(fontRequest, i);
        Typeface typeface = (Typeface) f790a.get(a2);
        if (typeface != null) {
            callbackWithHandler.b(new TypefaceResult(typeface));
            return typeface;
        } else if (i2 == -1) {
            TypefaceResult c2 = c(a2, context, fontRequest, i);
            callbackWithHandler.b(c2);
            return c2.f795a;
        } else {
            try {
                TypefaceResult typefaceResult = (TypefaceResult) RequestExecutor.c(b, new Callable<TypefaceResult>() {
                    /* renamed from: a */
                    public TypefaceResult call() {
                        return FontRequestWorker.c(a2, context, fontRequest, i);
                    }
                }, i2);
                callbackWithHandler.b(typefaceResult);
                return typefaceResult.f795a;
            } catch (InterruptedException unused) {
                callbackWithHandler.b(new TypefaceResult(-3));
                return null;
            }
        }
    }

    public static final class TypefaceResult {

        /* renamed from: a  reason: collision with root package name */
        public final Typeface f795a;
        public final int b;

        public TypefaceResult(int i) {
            this.f795a = null;
            this.b = i;
        }

        public boolean a() {
            return this.b == 0;
        }

        public TypefaceResult(Typeface typeface) {
            this.f795a = typeface;
            this.b = 0;
        }
    }
}

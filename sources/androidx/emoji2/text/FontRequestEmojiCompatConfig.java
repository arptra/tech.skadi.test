package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.RestrictTo;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    public static final FontProviderHelper j = new FontProviderHelper();

    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {

        /* renamed from: a  reason: collision with root package name */
        public final long f1205a;
        public long b;

        public long a() {
            if (this.b == 0) {
                this.b = SystemClock.uptimeMillis();
                return 0;
            }
            long uptimeMillis = SystemClock.uptimeMillis() - this.b;
            if (uptimeMillis > this.f1205a) {
                return -1;
            }
            return Math.min(Math.max(uptimeMillis, 1000), this.f1205a - uptimeMillis);
        }
    }

    @RestrictTo
    public static class FontProviderHelper {
        public Typeface a(Context context, FontsContractCompat.FontInfo fontInfo) {
            return FontsContractCompat.a(context, (CancellationSignal) null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        public FontsContractCompat.FontFamilyResult b(Context context, FontRequest fontRequest) {
            return FontsContractCompat.b(context, (CancellationSignal) null, fontRequest);
        }

        public void c(Context context, Uri uri, ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void d(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    public static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {

        /* renamed from: a  reason: collision with root package name */
        public final Context f1206a;
        public final FontRequest b;
        public final FontProviderHelper c;
        public final Object d = new Object();
        public Handler e;
        public Executor f;
        public ThreadPoolExecutor g;
        public RetryPolicy h;
        public EmojiCompat.MetadataRepoLoaderCallback i;
        public ContentObserver j;
        public Runnable k;

        public FontRequestMetadataLoader(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
            Preconditions.i(context, "Context cannot be null");
            Preconditions.i(fontRequest, "FontRequest cannot be null");
            this.f1206a = context.getApplicationContext();
            this.b = fontRequest;
            this.c = fontProviderHelper;
        }

        public void a(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.i(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.d) {
                this.i = metadataRepoLoaderCallback;
            }
            d();
        }

        public final void b() {
            synchronized (this.d) {
                try {
                    this.i = null;
                    ContentObserver contentObserver = this.j;
                    if (contentObserver != null) {
                        this.c.d(this.f1206a, contentObserver);
                        this.j = null;
                    }
                    Handler handler = this.e;
                    if (handler != null) {
                        handler.removeCallbacks(this.k);
                    }
                    this.e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f = null;
                    this.g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r0 = e();
            r1 = r0.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
            if (r1 != 2) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
            r2 = r7.d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r3 = r7.h;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x001d, code lost:
            if (r3 == null) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x001f, code lost:
            r3 = r3.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0027, code lost:
            if (r3 < 0) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
            f(r0.d(), r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0032, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0034, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0038, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x003a, code lost:
            if (r1 != 0) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            androidx.core.os.TraceCompat.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
            r1 = r7.c.a(r7.f1206a, r0);
            r0 = androidx.core.graphics.TypefaceCompatUtil.f(r7.f1206a, (android.os.CancellationSignal) null, r0.d());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0054, code lost:
            if (r0 == null) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0056, code lost:
            if (r1 == null) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0058, code lost:
            r0 = androidx.emoji2.text.MetadataRepo.b(r1, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            androidx.core.os.TraceCompat.b();
            r1 = r7.d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0061, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            r2 = r7.i;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0064, code lost:
            if (r2 == null) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0066, code lost:
            r2.b(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x006a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x006c, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0073, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x007c, code lost:
            throw new java.lang.RuntimeException("Unable to open file.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            androidx.core.os.TraceCompat.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0080, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x009c, code lost:
            throw new java.lang.RuntimeException("fetchFonts result is not OK. (" + r1 + ")");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x009f, code lost:
            monitor-enter(r7.d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            r2 = r7.i;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00a2, code lost:
            if (r2 != null) goto L_0x00a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00a4, code lost:
            r2.a(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x00a8, code lost:
            r7 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00ab, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x00b0, code lost:
            throw r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c() {
            /*
                r7 = this;
                java.lang.Object r0 = r7.d
                monitor-enter(r0)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r1 = r7.i     // Catch:{ all -> 0x0009 }
                if (r1 != 0) goto L_0x000c
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                return
            L_0x0009:
                r7 = move-exception
                goto L_0x00b1
            L_0x000c:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                androidx.core.provider.FontsContractCompat$FontInfo r0 = r7.e()     // Catch:{ all -> 0x0038 }
                int r1 = r0.b()     // Catch:{ all -> 0x0038 }
                r2 = 2
                if (r1 != r2) goto L_0x003a
                java.lang.Object r2 = r7.d     // Catch:{ all -> 0x0038 }
                monitor-enter(r2)     // Catch:{ all -> 0x0038 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$RetryPolicy r3 = r7.h     // Catch:{ all -> 0x0032 }
                if (r3 == 0) goto L_0x0034
                long r3 = r3.a()     // Catch:{ all -> 0x0032 }
                r5 = 0
                int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r5 < 0) goto L_0x0034
                android.net.Uri r0 = r0.d()     // Catch:{ all -> 0x0032 }
                r7.f(r0, r3)     // Catch:{ all -> 0x0032 }
                monitor-exit(r2)     // Catch:{ all -> 0x0032 }
                return
            L_0x0032:
                r0 = move-exception
                goto L_0x0036
            L_0x0034:
                monitor-exit(r2)     // Catch:{ all -> 0x0032 }
                goto L_0x003a
            L_0x0036:
                monitor-exit(r2)     // Catch:{ all -> 0x0032 }
                throw r0     // Catch:{ all -> 0x0038 }
            L_0x0038:
                r0 = move-exception
                goto L_0x009d
            L_0x003a:
                if (r1 != 0) goto L_0x0081
                java.lang.String r1 = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface"
                androidx.core.os.TraceCompat.a(r1)     // Catch:{ all -> 0x0073 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$FontProviderHelper r1 = r7.c     // Catch:{ all -> 0x0073 }
                android.content.Context r2 = r7.f1206a     // Catch:{ all -> 0x0073 }
                android.graphics.Typeface r1 = r1.a(r2, r0)     // Catch:{ all -> 0x0073 }
                android.content.Context r2 = r7.f1206a     // Catch:{ all -> 0x0073 }
                android.net.Uri r0 = r0.d()     // Catch:{ all -> 0x0073 }
                r3 = 0
                java.nio.ByteBuffer r0 = androidx.core.graphics.TypefaceCompatUtil.f(r2, r3, r0)     // Catch:{ all -> 0x0073 }
                if (r0 == 0) goto L_0x0075
                if (r1 == 0) goto L_0x0075
                androidx.emoji2.text.MetadataRepo r0 = androidx.emoji2.text.MetadataRepo.b(r1, r0)     // Catch:{ all -> 0x0073 }
                androidx.core.os.TraceCompat.b()     // Catch:{ all -> 0x0038 }
                java.lang.Object r1 = r7.d     // Catch:{ all -> 0x0038 }
                monitor-enter(r1)     // Catch:{ all -> 0x0038 }
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r7.i     // Catch:{ all -> 0x006a }
                if (r2 == 0) goto L_0x006c
                r2.b(r0)     // Catch:{ all -> 0x006a }
                goto L_0x006c
            L_0x006a:
                r0 = move-exception
                goto L_0x0071
            L_0x006c:
                monitor-exit(r1)     // Catch:{ all -> 0x006a }
                r7.b()     // Catch:{ all -> 0x0038 }
                goto L_0x00ae
            L_0x0071:
                monitor-exit(r1)     // Catch:{ all -> 0x006a }
                throw r0     // Catch:{ all -> 0x0038 }
            L_0x0073:
                r0 = move-exception
                goto L_0x007d
            L_0x0075:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0073 }
                java.lang.String r1 = "Unable to open file."
                r0.<init>(r1)     // Catch:{ all -> 0x0073 }
                throw r0     // Catch:{ all -> 0x0073 }
            L_0x007d:
                androidx.core.os.TraceCompat.b()     // Catch:{ all -> 0x0038 }
                throw r0     // Catch:{ all -> 0x0038 }
            L_0x0081:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0038 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0038 }
                r2.<init>()     // Catch:{ all -> 0x0038 }
                java.lang.String r3 = "fetchFonts result is not OK. ("
                r2.append(r3)     // Catch:{ all -> 0x0038 }
                r2.append(r1)     // Catch:{ all -> 0x0038 }
                java.lang.String r1 = ")"
                r2.append(r1)     // Catch:{ all -> 0x0038 }
                java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0038 }
                r0.<init>(r1)     // Catch:{ all -> 0x0038 }
                throw r0     // Catch:{ all -> 0x0038 }
            L_0x009d:
                java.lang.Object r1 = r7.d
                monitor-enter(r1)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r7.i     // Catch:{ all -> 0x00a8 }
                if (r2 == 0) goto L_0x00aa
                r2.a(r0)     // Catch:{ all -> 0x00a8 }
                goto L_0x00aa
            L_0x00a8:
                r7 = move-exception
                goto L_0x00af
            L_0x00aa:
                monitor-exit(r1)     // Catch:{ all -> 0x00a8 }
                r7.b()
            L_0x00ae:
                return
            L_0x00af:
                monitor-exit(r1)     // Catch:{ all -> 0x00a8 }
                throw r7
            L_0x00b1:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.c():void");
        }

        public void d() {
            synchronized (this.d) {
                try {
                    if (this.i != null) {
                        if (this.f == null) {
                            ThreadPoolExecutor b2 = ConcurrencyHelpers.b("emojiCompat");
                            this.g = b2;
                            this.f = b2;
                        }
                        this.f.execute(new c(this));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final FontsContractCompat.FontInfo e() {
            try {
                FontsContractCompat.FontFamilyResult b2 = this.c.b(this.f1206a, this.b);
                if (b2.c() == 0) {
                    FontsContractCompat.FontInfo[] b3 = b2.b();
                    if (b3 != null && b3.length != 0) {
                        return b3[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException("fetchFonts failed (" + b2.c() + ")");
            } catch (PackageManager.NameNotFoundException e2) {
                throw new RuntimeException("provider not found", e2);
            }
        }

        public final void f(Uri uri, long j2) {
            synchronized (this.d) {
                try {
                    Handler handler = this.e;
                    if (handler == null) {
                        handler = ConcurrencyHelpers.d();
                        this.e = handler;
                    }
                    if (this.j == null) {
                        AnonymousClass1 r2 = new ContentObserver(handler) {
                            public void onChange(boolean z, Uri uri) {
                                FontRequestMetadataLoader.this.d();
                            }
                        };
                        this.j = r2;
                        this.c.c(this.f1206a, uri, r2);
                    }
                    if (this.k == null) {
                        this.k = new d(this);
                    }
                    handler.postDelayed(this.k, j2);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void g(Executor executor) {
            synchronized (this.d) {
                this.f = executor;
            }
        }
    }

    public static abstract class RetryPolicy {
        public abstract long a();
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest, j));
    }

    public FontRequestEmojiCompatConfig c(Executor executor) {
        ((FontRequestMetadataLoader) a()).g(executor);
        return this;
    }
}

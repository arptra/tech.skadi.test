package com.geetest.captcha;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bJ\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bJ\u0018\u0010\u0017\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bJ\u0018\u0010\u0018\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u000bJ\u0016\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000bJ\u001a\u0010\u001b\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0011J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bJ\u0018\u0010!\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bJ\u0018\u0010\"\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/geetest/captcha/utils/LogUtils;", "", "()V", "DEBUG", "", "ERROR", "INFO", "LEVEL", "NO_LOG", "PRINT_SIZE", "TAG", "", "VERBOSE", "WARN", "logger", "Lcom/geetest/captcha/utils/LogUtils$Logger;", "releaseLog", "", "d", "", "msg", "tag", "destroy", "e", "i", "init", "level", "log2sd", "printLongString", "data", "release", "setReleaseLog", "enable", "v", "w", "Logger", "captcha_release"}, k = 1, mv = {1, 4, 1})
public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static int f2858a = 4;
    public static a b = null;
    public static boolean c = true;
    public static final h0 d = new h0();

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0003J!\u0010\u000b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/geetest/captcha/utils/LogUtils$Logger;", "", "<init>", "()V", "", "checkLogFile", "destroy", "init", "", "tag", "msg", "log", "(Ljava/lang/String;Ljava/lang/String;)V", "content", "write", "(Ljava/lang/String;)V", "Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "getHandler", "()Landroid/os/Handler;", "handler", "Ljava/text/SimpleDateFormat;", "sdf", "Ljava/text/SimpleDateFormat;", "Landroid/os/HandlerThread;", "thread$delegate", "getThread", "()Landroid/os/HandlerThread;", "thread", "Companion", "Item", "captcha_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        public static final C0008a d = new C0008a();

        /* renamed from: a  reason: collision with root package name */
        public final Lazy f2859a = LazyKt.lazy(d.INSTANCE);
        public final Lazy b = LazyKt.lazy(new c(this));
        public final SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

        /* renamed from: com.geetest.captcha.h0$a$a  reason: collision with other inner class name */
        public static final class C0008a {
            public static final /* synthetic */ boolean a(C0008a aVar) {
                aVar.getClass();
                File file = new File(i0.f2862a + File.separator + "Geetest");
                if (file.exists()) {
                    File file2 = new File(file, "captcha_log.txt");
                    if (file2.exists() && file2.length() >= 10485760) {
                        return file2.delete();
                    }
                }
                return false;
            }
        }

        public static final class b {

            /* renamed from: a  reason: collision with root package name */
            public long f2860a;
            public String b;
            public String c;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/geetest/captcha/utils/LogUtils$Logger$handler$2$1", "invoke", "()Lcom/geetest/captcha/utils/LogUtils$Logger$handler$2$1;"}, k = 3, mv = {1, 4, 1})
        public static final class c extends Lambda implements Function0<C0009a> {
            public final /* synthetic */ a this$0;

            /* renamed from: com.geetest.captcha.h0$a$c$a  reason: collision with other inner class name */
            public static final class C0009a extends Handler {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f2861a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0009a(c cVar, Looper looper) {
                    super(looper);
                    this.f2861a = cVar;
                }

                public void handleMessage(Message message) {
                    Intrinsics.checkNotNullParameter(message, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
                    super.handleMessage(message);
                    try {
                        if (!Thread.interrupted()) {
                            int i = message.what;
                            if (i == 0) {
                                Object obj = message.obj;
                                if (obj != null) {
                                    b bVar = (b) obj;
                                    a aVar = this.f2861a.this$0;
                                    C0008a aVar2 = a.d;
                                    SimpleDateFormat simpleDateFormat = aVar.c;
                                    long j = bVar.f2860a;
                                    String str = simpleDateFormat.format(new Date(j)) + 9 + bVar.b + 10 + bVar.c + 10;
                                    Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().apply {\n…             }.toString()");
                                    a.c(aVar, str);
                                    return;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type com.geetest.captcha.utils.LogUtils.Logger.Item");
                            } else if (i == 1) {
                                C0008a.a(a.d);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(a aVar) {
                super(0);
                this.this$0 = aVar;
            }

            @NotNull
            public final C0009a invoke() {
                return new C0009a(this, this.this$0.f().getLooper());
            }
        }

        public static final class d extends Lambda implements Function0<HandlerThread> {
            public static final d INSTANCE = new d();

            public d() {
                super(0);
            }

            @NotNull
            public final HandlerThread invoke() {
                return new HandlerThread("Captcha Thread");
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x005b A[SYNTHETIC, Splitter:B:23:0x005b] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0061 A[SYNTHETIC, Splitter:B:29:0x0061] */
        /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final /* synthetic */ void c(com.geetest.captcha.h0.a r5, java.lang.String r6) {
            /*
                r5.getClass()
                r5 = 0
                java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                com.geetest.captcha.h0$a$a r1 = d     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                java.lang.String r1 = r1.getClass()     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                r0.<init>(r1)     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                boolean r1 = r0.exists()     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                if (r1 != 0) goto L_0x001b
                r0.mkdirs()     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                goto L_0x001b
            L_0x0019:
                r6 = move-exception
                goto L_0x0059
            L_0x001b:
                java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                java.lang.String r4 = "captcha_log.txt"
                r3.<init>(r0, r4)     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                r0 = 1
                r2.<init>(r3, r0)     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                java.lang.String r5 = "utf-8"
                java.nio.charset.Charset r5 = java.nio.charset.Charset.forName(r5)     // Catch:{ Exception -> 0x0057, all -> 0x004a }
                java.lang.String r0 = "Charset.forName(charsetName)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)     // Catch:{ Exception -> 0x0057, all -> 0x004a }
                if (r6 == 0) goto L_0x004c
                byte[] r5 = r6.getBytes(r5)     // Catch:{ Exception -> 0x0057, all -> 0x004a }
                java.lang.String r6 = "(this as java.lang.String).getBytes(charset)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ Exception -> 0x0057, all -> 0x004a }
                r1.write(r5)     // Catch:{ Exception -> 0x0057, all -> 0x004a }
                r1.close()     // Catch:{ IOException -> 0x0064 }
                goto L_0x0064
            L_0x004a:
                r5 = move-exception
                goto L_0x0054
            L_0x004c:
                java.lang.NullPointerException r5 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0057, all -> 0x004a }
                java.lang.String r6 = "null cannot be cast to non-null type java.lang.String"
                r5.<init>(r6)     // Catch:{ Exception -> 0x0057, all -> 0x004a }
                throw r5     // Catch:{ Exception -> 0x0057, all -> 0x004a }
            L_0x0054:
                r6 = r5
                r5 = r1
                goto L_0x0059
            L_0x0057:
                r5 = r1
                goto L_0x005f
            L_0x0059:
                if (r5 == 0) goto L_0x005e
                r5.close()     // Catch:{ IOException -> 0x005e }
            L_0x005e:
                throw r6
            L_0x005f:
                if (r5 == 0) goto L_0x0064
                r5.close()     // Catch:{ IOException -> 0x0064 }
            L_0x0064:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geetest.captcha.h0.a.c(com.geetest.captcha.h0$a, java.lang.String):void");
        }

        public final synchronized void b() {
            Message obtainMessage = e().obtainMessage();
            Intrinsics.checkNotNullExpressionValue(obtainMessage, "handler.obtainMessage()");
            obtainMessage.what = 1;
            e().sendMessage(obtainMessage);
        }

        public final synchronized void d(String str, String str2) {
            Message obtainMessage = e().obtainMessage();
            Intrinsics.checkNotNullExpressionValue(obtainMessage, "handler.obtainMessage()");
            obtainMessage.what = 0;
            b bVar = new b();
            bVar.f2860a = System.currentTimeMillis();
            bVar.b = str;
            bVar.c = str2;
            obtainMessage.obj = bVar;
            e().sendMessage(obtainMessage);
        }

        public final Handler e() {
            return (Handler) this.b.getValue();
        }

        public final HandlerThread f() {
            return (HandlerThread) this.f2859a.getValue();
        }

        public final synchronized void g() {
            f().start();
        }
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        if (f2858a <= 2) {
            Log.d("Captcha", str);
            f("Captcha", str);
        }
    }

    public final void b(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        if (f2858a <= 2) {
            Log.d(str, str2);
            f(str, str2);
        }
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        if (f2858a <= 5) {
            Log.e("Captcha", str);
            f("Captcha", str);
        }
    }

    public final void d(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        if (f2858a <= 3) {
            Log.i(str, str2);
            f(str, str2);
        }
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        if (c) {
            Log.i("Captcha", str);
        }
        f("Captcha", str);
    }

    public final void f(String str, String str2) {
        if (b == null) {
            a aVar = new a();
            b = aVar;
            aVar.g();
            a aVar2 = b;
            if (aVar2 != null) {
                aVar2.b();
            }
        }
        a aVar3 = b;
        if (aVar3 != null) {
            aVar3.d(str, str2);
        }
    }
}

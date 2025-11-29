package com.xingin.xhssharesdk.i;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.xingin.xhssharesdk.XhsShareConstants$XhsShareNoteErrorCode;
import com.xingin.xhssharesdk.XhsShareConstants$XhsShareNoteNewErrorCode;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.callback.XhsShareCallback;
import com.xingin.xhssharesdk.callback.XhsShareRegisterCallback;
import com.xingin.xhssharesdk.core.XhsShareActivity;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import com.xingin.xhssharesdk.log.IShareLogger;
import com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig;
import com.xingin.xhssharesdk.model.sharedata.XhsNote;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONException;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f8182a;
    public final String b;
    public final XhsShareGlobalConfig c;
    public com.xingin.xhssharesdk.m.a d;
    public XhsShareRegisterCallback e;
    public XhsShareCallback f;
    public String g;
    public e h = null;
    public volatile a i;
    public com.xingin.xhssharesdk.p.a j;
    public boolean k = false;
    public Handler l;
    public WeakReference m;
    public final a n = new a();
    public g o;
    public b p;

    public class a implements IShareLogger {
        public a() {
        }

        public final void d(String str, String str2) {
            if (c.this.c.isEnableLog()) {
                c.this.c.getShareLogger().d(str, str2);
            }
        }

        public final void e(String str, String str2, Throwable th) {
            if (c.this.c.isEnableLog()) {
                c.this.c.getShareLogger().e(str, str2, th);
            }
        }

        public final void i(String str, String str2) {
            if (c.this.c.isEnableLog()) {
                c.this.c.getShareLogger().i(str, str2);
            }
        }

        public final void v(String str, String str2) {
            if (c.this.c.isEnableLog()) {
                c.this.c.getShareLogger().v(str, str2);
            }
        }

        public final void w(String str, String str2, Throwable th) {
            if (c.this.c.isEnableLog()) {
                c.this.c.getShareLogger().w(str, str2, th);
            }
        }
    }

    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final String f8184a;

        public b(String str) {
            this.f8184a = str;
        }

        public final void run() {
            if (XhsShareSdk.f8171a != null) {
                c cVar = XhsShareSdk.f8171a;
                boolean equals = TextUtils.equals(this.f8184a, cVar.c());
                a aVar = cVar.n;
                aVar.d("XhsShare_Sdk", "delayInterruptRunnable run! sessionId equals: " + equals);
                if (equals) {
                    WeakReference weakReference = cVar.m;
                    if (weakReference == null || weakReference.get() == null) {
                        cVar.n.w("XhsShare_Sdk", "unregisterShareResultReceiverWithOutsideActivity, OutsideActivity is NULL!", (Throwable) null);
                    } else {
                        Activity activity = (Activity) cVar.m.get();
                        g gVar = cVar.o;
                        if (gVar != null) {
                            try {
                                activity.unregisterReceiver(gVar);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    cVar.g(cVar.c(), XhsShareConstants$XhsShareNoteNewErrorCode.GET_SHARE_RESULT_TIMEOUT, XhsShareConstants$XhsShareNoteErrorCode.UNKNOWN, "Get ShareResult from Xhs timeout!", (Throwable) null, true);
                    a aVar2 = cVar.n;
                    aVar2.e("XhsShare_Sdk", "[" + cVar.c() + "][new: -20400006][old:-10000001]Get ShareResult from Xhs timeout!", (Throwable) null);
                }
            }
        }
    }

    /* renamed from: com.xingin.xhssharesdk.i.c$c  reason: collision with other inner class name */
    public static class C0031c implements com.xingin.xhssharesdk.h.a {

        /* renamed from: a  reason: collision with root package name */
        public final com.xingin.xhssharesdk.h.a f8185a;

        public C0031c(XhsShareActivity.a aVar) {
            this.f8185a = aVar;
        }

        public final void a(String str, Uri uri) {
            com.xingin.xhssharesdk.p.b.a(new com.honey.account.j9.c(this, str, uri));
        }

        public final void b(String str, int i, int i2, String str2, Throwable th) {
            com.xingin.xhssharesdk.p.b.a(new com.honey.account.j9.d(this, str, i, i2, str2, th));
        }

        public final /* synthetic */ void e(String str, int i, int i2, String str2, Throwable th) {
            this.f8185a.b(str, i, i2, str2, th);
        }

        public final /* synthetic */ void f(String str, Uri uri) {
            this.f8185a.a(str, uri);
        }

        public /* synthetic */ C0031c(XhsShareActivity.a aVar, int i) {
            this(aVar);
        }
    }

    public static class d implements com.xingin.xhssharesdk.h.c {
        public final void a(com.xingin.xhssharesdk.m.b bVar) {
            b bVar2;
            if (XhsShareSdk.f8171a != null) {
                c cVar = XhsShareSdk.f8171a;
                boolean equals = TextUtils.equals(bVar.d, cVar.c());
                a aVar = cVar.n;
                aVar.d("XhsShare_Sdk", "OutsideReceiveShareResultCallback onReceive, equals is " + equals + " ,result is " + bVar);
                if (equals) {
                    Handler handler = cVar.l;
                    if (!(handler == null || (bVar2 = cVar.p) == null)) {
                        handler.removeCallbacks(bVar2);
                        cVar.p = null;
                        cVar.n.d("XhsShare_Sdk", "removeDelayInterruptRunnable");
                    }
                    WeakReference weakReference = cVar.m;
                    if (weakReference == null || weakReference.get() == null) {
                        cVar.n.w("XhsShare_Sdk", "unregisterShareResultReceiverWithOutsideActivity, OutsideActivity is NULL!", (Throwable) null);
                    } else {
                        Activity activity = (Activity) cVar.m.get();
                        g gVar = cVar.o;
                        if (gVar != null) {
                            try {
                                activity.unregisterReceiver(gVar);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    if (bVar.f8193a) {
                        cVar.i(bVar.d);
                        return;
                    }
                    Pair<Integer, Integer> errorCodeFromXhsShareResult = XhsShareSdkTools.getErrorCodeFromXhsShareResult(bVar);
                    cVar.g(bVar.d, ((Integer) errorCodeFromXhsShareResult.first).intValue(), ((Integer) errorCodeFromXhsShareResult.second).intValue(), bVar.c, (Throwable) null, true);
                    a aVar2 = cVar.n;
                    aVar2.e("XhsShare_Sdk", "[" + bVar.d + "][new: " + errorCodeFromXhsShareResult.first + "][old:" + errorCodeFromXhsShareResult.second + "]" + bVar.c, (Throwable) null);
                }
            }
        }
    }

    public class e extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final XhsNote f8186a;
        public final C0031c b;
        public final String c;
        public final long d;

        public e(XhsNote xhsNote, String str, long j, XhsShareActivity.a aVar) {
            this.f8186a = xhsNote;
            this.c = str;
            this.b = new C0031c(aVar, 0);
            this.d = j;
        }

        public final void run() {
            JSONException jSONException;
            String str;
            int i;
            int i2;
            String str2;
            C0031c cVar;
            super.run();
            try {
                c cVar2 = c.this;
                Context context = cVar2.f8182a;
                String h = cVar2.h();
                XhsNote xhsNote = this.f8186a;
                c cVar3 = c.this;
                this.b.a(this.c, f.a(c.this.f8182a, f.c(context, h, xhsNote, TextUtils.isEmpty(cVar3.c.getCacheDirPath()) ? XhsShareSdkTools.getDefaultCacheDirPath(cVar3.f8182a) : cVar3.c.getCacheDirPath()), this.c, this.d));
            } catch (com.xingin.xhssharesdk.l.a e2) {
                com.xingin.xhssharesdk.l.a aVar = e2;
                C0031c cVar4 = this.b;
                String str3 = this.c;
                cVar4.b(str3, XhsShareConstants$XhsShareNoteNewErrorCode.PROCESS_DATA_ERROR, XhsShareConstants$XhsShareNoteErrorCode.PROCESS_ERROR, "[" + aVar.f8191a + "]" + aVar.getMessage(), aVar);
            } catch (IOException e3) {
                jSONException = e3;
                cVar = this.b;
                str2 = this.c;
                i = XhsShareConstants$XhsShareNoteErrorCode.PROCESS_ERROR;
                str = "IO Exception!";
                i2 = XhsShareConstants$XhsShareNoteNewErrorCode.IO_ERROR;
                cVar.b(str2, i2, i, str, jSONException);
            } catch (InterruptedException e4) {
                jSONException = e4;
                cVar = this.b;
                str2 = this.c;
                i = XhsShareConstants$XhsShareNoteErrorCode.PROCESS_THREAD_INTERRUPTED;
                str = "ProcessDataThread has be interrupted!!";
                i2 = XhsShareConstants$XhsShareNoteNewErrorCode.INTERRUPTED_ERROR;
                cVar.b(str2, i2, i, str, jSONException);
            } catch (JSONException e5) {
                jSONException = e5;
                cVar = this.b;
                str2 = this.c;
                i = XhsShareConstants$XhsShareNoteErrorCode.GENERATE_JSON_ERROR;
                str = "Convert json error!";
                i2 = XhsShareConstants$XhsShareNoteNewErrorCode.JSON_ERROR;
                cVar.b(str2, i2, i, str, jSONException);
            }
        }
    }

    public c(Context context, String str, XhsShareGlobalConfig xhsShareGlobalConfig) {
        this.f8182a = context;
        this.b = str;
        this.c = xhsShareGlobalConfig;
    }

    public static void d(c cVar) {
        if (cVar.d != null) {
            SharedPreferences sharedPreferences = cVar.f8182a.getSharedPreferences("XHS_SHARE_SDK_SP", 0);
            try {
                sharedPreferences.edit().putString("XHS_SHARE_SDK_SP_KEY_TOKEN_CHECK_INFO", cVar.d.b().toString()).apply();
            } catch (JSONException e2) {
                cVar.n.w("XhsShare_Sdk", "TokenCheckInfo to Json error.", e2);
            }
        }
    }

    public final String c() {
        a aVar = this.i;
        return aVar != null ? aVar.f8180a : "";
    }

    public final /* synthetic */ void e(String str) {
        XhsShareCallback xhsShareCallback = this.f;
        if (xhsShareCallback != null) {
            xhsShareCallback.onSuccess(str);
        }
    }

    public final /* synthetic */ void f(String str, int i2, int i3, String str2, Throwable th) {
        XhsShareCallback xhsShareCallback = this.f;
        if (xhsShareCallback != null) {
            xhsShareCallback.onError2(str, i2, i3, str2, th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(java.lang.String r17, int r18, int r19, java.lang.String r20, java.lang.Throwable r21, boolean r22) {
        /*
            r16 = this;
            r7 = r16
            r6 = r21
            com.xingin.xhssharesdk.i.a r0 = r7.i
            r8 = 0
            if (r0 != 0) goto L_0x0013
            com.xingin.xhssharesdk.i.c$a r0 = r7.n
            java.lang.String r1 = "XhsShare_Sdk"
            java.lang.String r2 = "notifyShareError error, currentShareContext is NULL!"
            r0.e(r1, r2, r8)
            return
        L_0x0013:
            com.xingin.xhssharesdk.q.b r1 = r0.b
            java.lang.String r2 = r0.f8180a
            java.lang.String r3 = r1.f8201a
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            r4 = 0
            if (r3 != 0) goto L_0x003d
            java.lang.String r3 = r1.f8201a
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L_0x003d
            long r2 = r1.d
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0037
            java.lang.String r1 = "ShareTimelineTracker"
            java.lang.String r2 = "shareResultTimestamp has be assigned!"
            com.xingin.xhssharesdk.core.XhsShareSdk.d(r1, r2, r8)
            goto L_0x003d
        L_0x0037:
            long r2 = java.lang.System.currentTimeMillis()
            r1.d = r2
        L_0x003d:
            r1 = 0
            r0.c = r1
            android.content.Context r9 = r7.f8182a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r3 = r20
            r1.append(r3)
            java.lang.String r2 = "\t"
            r1.append(r2)
            if (r6 != 0) goto L_0x0056
            java.lang.String r2 = ""
            goto L_0x0067
        L_0x0056:
            java.io.StringWriter r2 = new java.io.StringWriter
            r2.<init>()
            java.io.PrintWriter r10 = new java.io.PrintWriter
            r10.<init>(r2)
            r6.printStackTrace(r10)
            java.lang.String r2 = r2.toString()
        L_0x0067:
            r1.append(r2)
            java.lang.String r13 = r1.toString()
            com.xingin.xhssharesdk.q.b r0 = r0.b
            long r1 = r0.c
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 <= 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            long r1 = r0.b
        L_0x0079:
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 <= 0) goto L_0x008a
            long r10 = r0.d
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x008a
            long r10 = r10 - r1
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x008a
            r14 = r10
            goto L_0x008d
        L_0x008a:
            r0 = -1
            r14 = r0
        L_0x008d:
            r11 = 0
            r10 = r17
            r12 = r18
            com.xingin.xhssharesdk.q.a.b(r9, r10, r11, r12, r13, r14)
            com.honey.account.j9.a r9 = new com.honey.account.j9.a
            r0 = r9
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6)
            com.xingin.xhssharesdk.p.b.a(r9)
            if (r22 == 0) goto L_0x00ec
            com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig r0 = r7.c
            boolean r0 = r0.isClearCacheWhenShareComplete()
            if (r0 != 0) goto L_0x00b5
            goto L_0x00ec
        L_0x00b5:
            com.xingin.xhssharesdk.p.a r0 = r7.j
            if (r0 == 0) goto L_0x00c4
            boolean r0 = r0.isAlive()
            if (r0 == 0) goto L_0x00c4
            com.xingin.xhssharesdk.p.a r0 = r7.j
            r0.interrupt()
        L_0x00c4:
            com.xingin.xhssharesdk.p.a r0 = new com.xingin.xhssharesdk.p.a
            java.io.File r1 = new java.io.File
            com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig r2 = r7.c
            java.lang.String r2 = r2.getCacheDirPath()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00db
            android.content.Context r2 = r7.f8182a
            java.lang.String r2 = com.xingin.xhssharesdk.XhsShareSdkTools.getDefaultCacheDirPath(r2)
            goto L_0x00e1
        L_0x00db:
            com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig r2 = r7.c
            java.lang.String r2 = r2.getCacheDirPath()
        L_0x00e1:
            r1.<init>(r2)
            r0.<init>(r1)
            r7.j = r0
            r0.start()
        L_0x00ec:
            r7.m = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xingin.xhssharesdk.i.c.g(java.lang.String, int, int, java.lang.String, java.lang.Throwable, boolean):void");
    }

    public final String h() {
        if (!TextUtils.isEmpty(this.c.getFileProviderAuthority())) {
            return this.c.getFileProviderAuthority();
        }
        return XhsShareSdkTools.getCurrentAppPackageName(this.f8182a) + ".provider";
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(java.lang.String r15) {
        /*
            r14 = this;
            com.xingin.xhssharesdk.i.a r0 = r14.i
            r1 = 0
            if (r0 != 0) goto L_0x000f
            com.xingin.xhssharesdk.i.c$a r14 = r14.n
            java.lang.String r15 = "XhsShare_Sdk"
            java.lang.String r0 = "notifyShareSuccess error, currentShareContext is NULL!"
            r14.e(r15, r0, r1)
            return
        L_0x000f:
            com.xingin.xhssharesdk.q.b r2 = r0.b
            java.lang.String r3 = r0.f8180a
            java.lang.String r4 = r2.f8201a
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r5 = 0
            if (r4 != 0) goto L_0x0039
            java.lang.String r4 = r2.f8201a
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 == 0) goto L_0x0039
            long r3 = r2.d
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0033
            java.lang.String r2 = "ShareTimelineTracker"
            java.lang.String r3 = "shareResultTimestamp has be assigned!"
            com.xingin.xhssharesdk.core.XhsShareSdk.d(r2, r3, r1)
            goto L_0x0039
        L_0x0033:
            long r3 = java.lang.System.currentTimeMillis()
            r2.d = r3
        L_0x0039:
            r2 = 0
            r0.c = r2
            android.content.Context r7 = r14.f8182a
            com.xingin.xhssharesdk.q.b r0 = r0.b
            long r2 = r0.c
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            long r2 = r0.b
        L_0x0049:
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x005a
            long r8 = r0.d
            int r0 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x005a
            long r8 = r8 - r2
            int r0 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x005a
            r12 = r8
            goto L_0x005d
        L_0x005a:
            r2 = -1
            r12 = r2
        L_0x005d:
            r9 = 1
            r10 = 0
            java.lang.String r11 = ""
            r8 = r15
            com.xingin.xhssharesdk.q.a.b(r7, r8, r9, r10, r11, r12)
            com.honey.account.j9.b r0 = new com.honey.account.j9.b
            r0.<init>(r14, r15)
            com.xingin.xhssharesdk.p.b.a(r0)
            com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig r15 = r14.c
            boolean r15 = r15.isClearCacheWhenShareComplete()
            if (r15 != 0) goto L_0x0076
            goto L_0x00ad
        L_0x0076:
            com.xingin.xhssharesdk.p.a r15 = r14.j
            if (r15 == 0) goto L_0x0085
            boolean r15 = r15.isAlive()
            if (r15 == 0) goto L_0x0085
            com.xingin.xhssharesdk.p.a r15 = r14.j
            r15.interrupt()
        L_0x0085:
            com.xingin.xhssharesdk.p.a r15 = new com.xingin.xhssharesdk.p.a
            java.io.File r0 = new java.io.File
            com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig r2 = r14.c
            java.lang.String r2 = r2.getCacheDirPath()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x009c
            android.content.Context r2 = r14.f8182a
            java.lang.String r2 = com.xingin.xhssharesdk.XhsShareSdkTools.getDefaultCacheDirPath(r2)
            goto L_0x00a2
        L_0x009c:
            com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig r2 = r14.c
            java.lang.String r2 = r2.getCacheDirPath()
        L_0x00a2:
            r0.<init>(r2)
            r15.<init>(r0)
            r14.j = r15
            r15.start()
        L_0x00ad:
            r14.m = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xingin.xhssharesdk.i.c.i(java.lang.String):void");
    }

    public final void j() {
        b bVar;
        if (this.l == null) {
            this.l = new Handler(Looper.getMainLooper());
        }
        Handler handler = this.l;
        if (!(handler == null || (bVar = this.p) == null)) {
            handler.removeCallbacks(bVar);
            this.p = null;
            this.n.d("XhsShare_Sdk", "removeDelayInterruptRunnable");
        }
        this.n.d("XhsShare_Sdk", "setupInterruptTimeout");
        b bVar2 = new b(c());
        this.p = bVar2;
        this.l.postDelayed(bVar2, 20000);
    }
}

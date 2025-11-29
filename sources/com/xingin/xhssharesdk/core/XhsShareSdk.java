package com.xingin.xhssharesdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.runasone.uupcast.CaptureType;
import com.xingin.xhssharesdk.XhsShareConstants$XhsShareNoteErrorCode;
import com.xingin.xhssharesdk.XhsShareConstants$XhsShareNoteNewErrorCode;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.b.e;
import com.xingin.xhssharesdk.b.i;
import com.xingin.xhssharesdk.callback.XhsShareCallback;
import com.xingin.xhssharesdk.i.a;
import com.xingin.xhssharesdk.i.c;
import com.xingin.xhssharesdk.model.sharedata.XhsNote;
import com.xingin.xhssharesdk.q.b;
import java.lang.ref.WeakReference;
import org.eclipse.jetty.util.URIUtil;
import org.json.JSONException;

public class XhsShareSdk {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f8171a;
    public static String b;

    public static void a(XhsShareCallback xhsShareCallback, a aVar, int i, String str) {
        if (xhsShareCallback != null) {
            xhsShareCallback.onError2(aVar.f8180a, i, XhsShareConstants$XhsShareNoteErrorCode.REPEAT_SHARE, str, (Throwable) null);
        }
    }

    public static void b(String str, String str2) {
        if (f8171a != null) {
            f8171a.n.d(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (f8171a != null) {
            f8171a.n.e(str, str2, th);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (f8171a != null) {
            f8171a.n.w(str, str2, th);
        }
    }

    @Keep
    private static String getCachePath() {
        if (f8171a == null) {
            return "";
        }
        c cVar = f8171a;
        return TextUtils.isEmpty(cVar.c.getCacheDirPath()) ? XhsShareSdkTools.getDefaultCacheDirPath(cVar.f8182a) : cVar.c.getCacheDirPath();
    }

    @Keep
    public static void openUrlInXhs(Context context, String str) {
        Uri uri;
        String str2;
        try {
            uri = Uri.parse(str);
        } catch (Throwable th) {
            c("XhsShare_Sdk", "Parse url error", th);
            uri = null;
        }
        if (uri != null) {
            if (XhsShareSdkTools.isXhsInstalled(context)) {
                String scheme = uri.getScheme();
                if (TextUtils.equals(URIUtil.HTTP, scheme) || TextUtils.equals(URIUtil.HTTPS, scheme)) {
                    try {
                        Uri parse = Uri.parse(str.replace("https://", "xhsdiscover://webview/"));
                        Intent intent = new Intent();
                        intent.setData(parse);
                        if (intent.resolveActivity(context.getPackageManager()) != null) {
                            context.startActivity(intent);
                            return;
                        }
                        throw new Exception("resolveActivity get null!");
                    } catch (Throwable th2) {
                        th = th2;
                        str2 = "Open url in Xhs error!";
                        c("XhsShare_Sdk", str2, th);
                    }
                } else {
                    c("XhsShare_Sdk", "Scheme must be http pr https url!", (Throwable) null);
                }
            } else {
                try {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.xiaohongshu.com/activity/sem/walle?groupid=64a3b9a0656df000019fdfd3&template=A050001&nocache=nocache&source=openplatform_default")));
                } catch (Throwable th3) {
                    th = th3;
                    str2 = "Open download url error!";
                }
            }
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    @androidx.annotation.Keep
    public static void registerApp(android.content.Context r9, java.lang.String r10, com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig r11, com.xingin.xhssharesdk.callback.XhsShareRegisterCallback r12) {
        /*
            com.xingin.xhssharesdk.i.c r0 = f8171a
            r1 = 0
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "XhsShare_Sdk"
            java.lang.String r2 = "The XhsShare has registered, can not register again!!"
            d(r0, r2, r1)
        L_0x000c:
            java.lang.String r0 = "XhsShare_Sdk"
            java.lang.String r2 = "Start register!"
            b(r0, r2)
            android.content.Context r9 = r9.getApplicationContext()
            com.xingin.xhssharesdk.i.c r0 = new com.xingin.xhssharesdk.i.c
            r0.<init>(r9, r10, r11)
            f8171a = r0
            com.xingin.xhssharesdk.i.c r10 = f8171a
            r10.e = r12
            java.lang.String r11 = r10.b
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            r12 = 0
            if (r11 == 0) goto L_0x003e
            com.xingin.xhssharesdk.i.c$a r11 = r10.n
            java.lang.String r0 = "XhsShare_Sdk"
            java.lang.String r2 = "Token can not be Empty!"
            r11.e(r0, r2, r1)
            com.xingin.xhssharesdk.callback.XhsShareRegisterCallback r10 = r10.e
            if (r10 == 0) goto L_0x0049
            java.lang.String r11 = "Token can not be Empty!"
            r10.onError(r12, r11, r1)
            goto L_0x0049
        L_0x003e:
            com.xingin.xhssharesdk.i.c$a r11 = r10.n
            com.xingin.xhssharesdk.o.b.f8196a = r11
            com.xingin.xhssharesdk.callback.XhsShareRegisterCallback r10 = r10.e
            if (r10 == 0) goto L_0x0049
            r10.onSuccess()
        L_0x0049:
            com.xingin.xhssharesdk.i.h r10 = new com.xingin.xhssharesdk.i.h
            r10.<init>()
            com.xingin.xhssharesdk.b.o.f8163a = r10
            java.lang.String r10 = ""
            int r11 = com.xingin.xhssharesdk.XhsShareSdkTools.getCurrentAppVersionCode(r9)     // Catch:{ NameNotFoundException -> 0x005d }
            java.lang.String r10 = com.xingin.xhssharesdk.XhsShareSdkTools.getCurrentAppVersionName(r9)     // Catch:{ NameNotFoundException -> 0x005b }
            goto L_0x0066
        L_0x005b:
            r0 = move-exception
            goto L_0x005f
        L_0x005d:
            r0 = move-exception
            r11 = -1
        L_0x005f:
            java.lang.String r2 = "XhsShare_Sdk"
            java.lang.String r3 = "GetVersion error"
            d(r2, r3, r0)
        L_0x0066:
            com.xingin.xhssharesdk.b.e r0 = com.xingin.xhssharesdk.b.e.h()
            java.lang.String r2 = android.os.Build.MODEL
            java.lang.String r3 = com.xingin.xhssharesdk.XhsShareSdkTools.getDid(r9)
            int r4 = android.os.Build.VERSION.SDK_INT
            java.lang.String r5 = android.os.Build.VERSION.RELEASE
            com.xingin.xhssharesdk.i.i r6 = new com.xingin.xhssharesdk.i.i
            r6.<init>()
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicBoolean r7 = r0.f8153a     // Catch:{ all -> 0x00e4 }
            r8 = 1
            boolean r12 = r7.compareAndSet(r12, r8)     // Catch:{ all -> 0x00e4 }
            if (r12 == 0) goto L_0x00e6
            r12 = 1663676756(0x6329b154, float:3.1302776E21)
            com.xingin.xhssharesdk.c.b.f8168a = r12     // Catch:{ all -> 0x00e4 }
            com.xingin.xhssharesdk.b.f r12 = new com.xingin.xhssharesdk.b.f     // Catch:{ all -> 0x00e4 }
            r12.<init>()     // Catch:{ all -> 0x00e4 }
            r12.f8154a = r3     // Catch:{ all -> 0x00e4 }
            r12.c = r4     // Catch:{ all -> 0x00e4 }
            r12.b = r5     // Catch:{ all -> 0x00e4 }
            r12.d = r2     // Catch:{ all -> 0x00e4 }
            r12.h = r6     // Catch:{ all -> 0x00e4 }
            r12.g = r11     // Catch:{ all -> 0x00e4 }
            r11 = 26
            r12.e = r11     // Catch:{ all -> 0x00e4 }
            r12.f = r10     // Catch:{ all -> 0x00e4 }
            com.xingin.xhssharesdk.b.f.i = r12     // Catch:{ all -> 0x00e4 }
            java.lang.Object[] r10 = new java.lang.Object[]{r12}     // Catch:{ all -> 0x00e4 }
            java.lang.String r11 = "init() TrackerConfig=%s"
            com.xingin.xhssharesdk.b.o.a(r11, r10)     // Catch:{ all -> 0x00e4 }
            com.xingin.xhssharesdk.b.k r10 = com.xingin.xhssharesdk.b.k.f     // Catch:{ all -> 0x00e4 }
            java.lang.String r11 = r12.f8154a     // Catch:{ all -> 0x00e4 }
            r10.f8159a = r11     // Catch:{ all -> 0x00e4 }
            java.lang.String r11 = r12.b     // Catch:{ all -> 0x00e4 }
            r10.b = r11     // Catch:{ all -> 0x00e4 }
            int r11 = r12.c     // Catch:{ all -> 0x00e4 }
            r10.c = r11     // Catch:{ all -> 0x00e4 }
            r10.d = r1     // Catch:{ all -> 0x00e4 }
            java.lang.String r11 = r12.d     // Catch:{ all -> 0x00e4 }
            r10.e = r11     // Catch:{ all -> 0x00e4 }
            com.xingin.xhssharesdk.b.h r10 = com.xingin.xhssharesdk.b.h.e     // Catch:{ all -> 0x00e4 }
            int r11 = r12.e     // Catch:{ all -> 0x00e4 }
            r10.b = r11     // Catch:{ all -> 0x00e4 }
            java.lang.String r11 = r12.f     // Catch:{ all -> 0x00e4 }
            r10.c = r11     // Catch:{ all -> 0x00e4 }
            int r11 = r12.g     // Catch:{ all -> 0x00e4 }
            r10.d = r11     // Catch:{ all -> 0x00e4 }
            com.xingin.xhssharesdk.b.q r10 = new com.xingin.xhssharesdk.b.q     // Catch:{ all -> 0x00e4 }
            com.xingin.xhssharesdk.b.r r11 = r0.d     // Catch:{ all -> 0x00e4 }
            r10.<init>(r9, r11)     // Catch:{ all -> 0x00e4 }
            r0.e = r10     // Catch:{ all -> 0x00e4 }
            com.xingin.xhssharesdk.b.s r9 = new com.xingin.xhssharesdk.b.s     // Catch:{ all -> 0x00e4 }
            com.xingin.xhssharesdk.b.r r10 = r0.d     // Catch:{ all -> 0x00e4 }
            com.xingin.xhssharesdk.b.q r11 = r0.e     // Catch:{ all -> 0x00e4 }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x00e4 }
            r0.f = r9     // Catch:{ all -> 0x00e4 }
            r0.c()     // Catch:{ all -> 0x00e4 }
            goto L_0x00f3
        L_0x00e4:
            r9 = move-exception
            goto L_0x00f5
        L_0x00e6:
            java.lang.String r9 = " %s tracker lite has been initialized"
            com.xingin.xhssharesdk.b.r r10 = r0.d     // Catch:{ all -> 0x00e4 }
            java.lang.String r10 = r10.f8165a     // Catch:{ all -> 0x00e4 }
            java.lang.Object[] r10 = new java.lang.Object[]{r10}     // Catch:{ all -> 0x00e4 }
            com.xingin.xhssharesdk.b.o.a(r9, r10)     // Catch:{ all -> 0x00e4 }
        L_0x00f3:
            monitor-exit(r0)
            return
        L_0x00f5:
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xingin.xhssharesdk.core.XhsShareSdk.registerApp(android.content.Context, java.lang.String, com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig, com.xingin.xhssharesdk.callback.XhsShareRegisterCallback):void");
    }

    @Keep
    public static void setShareCallback(@Nullable XhsShareCallback xhsShareCallback) {
        if (f8171a != null) {
            f8171a.f = xhsShareCallback;
        } else {
            c("XhsShare_Sdk", "setShareCallback invoke can not before registerApp invoke!", (Throwable) null);
        }
    }

    @NonNull
    @Keep
    public static String shareNote(Context context, XhsNote xhsNote) {
        boolean z;
        Context context2 = context;
        XhsNote xhsNote2 = xhsNote;
        String str = "";
        if (f8171a == null) {
            c("XhsShare_Sdk", "shareNote invoke can not before registerApp invoke!", (Throwable) null);
            return str;
        }
        a aVar = new a(xhsNote2);
        try {
            str = xhsNote.toJsonForDeeplink().toString();
        } catch (JSONException e) {
            d("XhsShare_Sdk", "note.toJsonForDeeplink() error!", e);
        }
        String str2 = aVar.f8180a;
        String noteType = xhsNote.getNoteType();
        e h = e.h();
        i.a a2 = com.xingin.xhssharesdk.q.a.a(context);
        a2.c = 3;
        a2.b = 30756;
        a2.d.put("session_id", str2);
        a2.d.put("share_type", "NOTE");
        a2.d.put("note_type", noteType);
        a2.d.put("note_data_json", str);
        h.d(a2);
        c cVar = f8171a;
        a aVar2 = cVar.i;
        boolean z2 = false;
        if (aVar2 == null ? false : aVar2.c) {
            z = false;
        } else {
            cVar.i = aVar;
            aVar.c = true;
            b bVar = aVar.b;
            if (!TextUtils.isEmpty(bVar.f8201a) && TextUtils.equals(aVar.f8180a, bVar.f8201a)) {
                if (bVar.b != 0) {
                    d("ShareTimelineTracker", "startShareTimestamp has be assigned!", (Throwable) null);
                } else {
                    bVar.b = System.currentTimeMillis();
                }
            }
            z = true;
        }
        if (!z) {
            d("XhsShare_Sdk", "Last share flow has not end!, isNeedRegisterReceiverWithOutsideActivity = " + f8171a.c.isNeedRegisterReceiverWithOutsideActivity(), (Throwable) null);
            if (f8171a.c.isNeedRegisterReceiverWithOutsideActivity()) {
                f8171a.g(f8171a.c(), XhsShareConstants$XhsShareNoteNewErrorCode.SHARE_NOT_GET_RESULT_FROM_XHS, XhsShareConstants$XhsShareNoteErrorCode.UNKNOWN, "Replace by new share.", (Throwable) null, false);
                c cVar2 = f8171a;
                a aVar3 = cVar2.i;
                if (!(aVar3 == null ? false : aVar3.c)) {
                    cVar2.i = aVar;
                    aVar.c = true;
                    b bVar2 = aVar.b;
                    String str3 = aVar.f8180a;
                    if (!TextUtils.isEmpty(bVar2.f8201a) && TextUtils.equals(str3, bVar2.f8201a)) {
                        z2 = true;
                    }
                    if (z2) {
                        if (bVar2.b != 0) {
                            d("ShareTimelineTracker", "startShareTimestamp has be assigned!", (Throwable) null);
                        } else {
                            bVar2.b = System.currentTimeMillis();
                        }
                    }
                    z2 = true;
                }
                b("XhsShare_Sdk", "setupShareContext Result is " + z2);
            } else {
                d("XhsShare_Sdk", "Last share not over yet!!", (Throwable) null);
                com.xingin.xhssharesdk.q.a.b(context, aVar.f8180a, false, XhsShareConstants$XhsShareNoteNewErrorCode.REPEAT_SHARE, "Last share not over yet!!", 0);
                com.xingin.xhssharesdk.p.b.a(new com.honey.account.i9.a(f8171a.f, aVar, XhsShareConstants$XhsShareNoteNewErrorCode.REPEAT_SHARE, "Last share not over yet!!"));
                return aVar.f8180a;
            }
        }
        b("XhsShare_Sdk", "Start Share, sessionId is " + aVar.f8180a);
        Intent intent = new Intent(context2, XhsShareActivity.class);
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        intent.putExtra("XHS_SHARE_NOTE_KEY", xhsNote2);
        intent.putExtra("XHS_SHARE_SESSION_ID", aVar.f8180a);
        intent.putExtra("XHS_SHARE_START_TIMESTAMP", aVar.b.b);
        intent.putExtra("XHS_SHARE_FLAG", "SHARE");
        try {
            context2.startActivity(intent);
            c cVar3 = f8171a;
            if (cVar3.c.isNeedRegisterReceiverWithOutsideActivity() && (context2 instanceof Activity)) {
                cVar3.n.d("XhsShare_Sdk", "setup OutsideActivity!");
                cVar3.m = new WeakReference((Activity) context2);
            }
        } catch (Throwable th) {
            XhsShareCallback xhsShareCallback = f8171a.f;
            if (xhsShareCallback != null) {
                xhsShareCallback.onError2(aVar.f8180a, XhsShareConstants$XhsShareNoteNewErrorCode.OPEN_XHS_SHARE_ACTIVITY_ERROR, XhsShareConstants$XhsShareNoteErrorCode.START_ACTIVITY_ERROR, "startActivity error", th);
            }
            f8171a.n.e("XhsShare_Sdk", "startActivity error", th);
        }
        return aVar.f8180a;
    }
}

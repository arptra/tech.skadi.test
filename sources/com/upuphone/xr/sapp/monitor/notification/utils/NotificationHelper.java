package com.upuphone.xr.sapp.monitor.notification.utils;

import android.app.KeyguardManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.service.notification.StatusBarNotification;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableKt;
import com.google.gson.Gson;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.monitor.notification.constants.PackageConfig;
import com.upuphone.xr.sapp.utils.AppInfoHelper;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u0006*\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u0019J\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00020 2\n\u0010$\u001a\u00060\"j\u0002`#H\u0002¢\u0006\u0004\b&\u0010'J\u0019\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b)\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060+8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010,¨\u0006."}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/utils/NotificationHelper;", "", "<init>", "()V", "Landroid/service/notification/StatusBarNotification;", "sbn", "", "e", "(Landroid/service/notification/StatusBarNotification;)Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "(Landroid/service/notification/StatusBarNotification;)Ljava/util/HashMap;", "Landroid/app/PendingIntent;", "intent", "Landroid/content/Intent;", "d", "(Landroid/app/PendingIntent;)Landroid/content/Intent;", "Landroid/app/Notification;", "mNotification", "", "f", "(Landroid/app/Notification;)[B", "packageName", "c", "(Ljava/lang/String;)Ljava/lang/String;", "h", "", "g", "()Z", "b", "(Landroid/app/Notification;)Ljava/lang/String;", "Landroid/view/View;", "view", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "", "j", "(Landroid/view/View;Ljava/lang/StringBuilder;)V", "Landroid/graphics/Bitmap;", "i", "(Landroid/view/View;)Landroid/graphics/Bitmap;", "", "[Ljava/lang/String;", "resourceEntryNameBlack", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nNotificationHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationHelper.kt\ncom/upuphone/xr/sapp/monitor/notification/utils/NotificationHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,349:1\n1#2:350\n53#3,4:351\n53#3,4:355\n980#4:359\n1011#4,4:360\n*S KotlinDebug\n*F\n+ 1 NotificationHelper.kt\ncom/upuphone/xr/sapp/monitor/notification/utils/NotificationHelper\n*L\n208#1:351,4\n281#1:355,4\n328#1:359\n328#1:360,4\n*E\n"})
public final class NotificationHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final NotificationHelper f7775a = new NotificationHelper();
    public static final String[] b = {"app_name_text", RtspHeaders.Values.TIME, "time_divider", "header_text", "header_text_divider", "header_text_secondary_divider"};

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0066, code lost:
        if (r0 == null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004a, code lost:
        if (r3 == null) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.HashMap a(android.service.notification.StatusBarNotification r10) {
        /*
            r9 = this;
            java.lang.String r0 = "sbn"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            android.app.Notification r0 = r10.getNotification()
            android.os.Bundle r0 = r0.extras
            r1 = 0
            if (r0 != 0) goto L_0x000f
            return r1
        L_0x000f:
            com.upuphone.xr.sapp.utils.PackageHelper r2 = new com.upuphone.xr.sapp.utils.PackageHelper
            r2.<init>()
            com.upuphone.xr.sapp.MainApplication$Companion r3 = com.upuphone.xr.sapp.MainApplication.k
            com.upuphone.xr.sapp.MainApplication r3 = r3.f()
            java.lang.String r4 = r9.e(r10)
            java.lang.String r2 = r2.c(r3, r4)
            java.lang.String r3 = "android.title"
            java.lang.CharSequence r3 = r0.getCharSequence(r3)
            java.lang.String r4 = "android.text"
            java.lang.CharSequence r0 = r0.getCharSequence(r4)
            r5 = 0
            java.lang.String r6 = ""
            if (r3 == 0) goto L_0x004c
            boolean r7 = r3 instanceof android.text.SpannableString
            if (r7 == 0) goto L_0x0046
            android.text.SpannableString r3 = (android.text.SpannableString) r3
            int r7 = r3.length()
            java.lang.CharSequence r3 = r3.subSequence(r5, r7)
            java.lang.String r3 = r3.toString()
            goto L_0x004a
        L_0x0046:
            java.lang.String r3 = r3.toString()
        L_0x004a:
            if (r3 != 0) goto L_0x004d
        L_0x004c:
            r3 = r6
        L_0x004d:
            if (r0 == 0) goto L_0x0068
            boolean r7 = r0 instanceof android.text.SpannableString
            if (r7 == 0) goto L_0x0062
            android.text.SpannableString r0 = (android.text.SpannableString) r0
            int r7 = r0.length()
            java.lang.CharSequence r0 = r0.subSequence(r5, r7)
            java.lang.String r0 = r0.toString()
            goto L_0x0066
        L_0x0062:
            java.lang.String r0 = r0.toString()
        L_0x0066:
            if (r0 != 0) goto L_0x0069
        L_0x0068:
            r0 = r6
        L_0x0069:
            com.upuphone.xr.sapp.monitor.notification.constants.PackageConfig r5 = com.upuphone.xr.sapp.monitor.notification.constants.PackageConfig.f7770a
            java.lang.String r7 = r10.getPackageName()
            java.lang.String r8 = "getPackageName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            boolean r5 = r5.a(r7)
            java.lang.String r7 = "NotificationHelper"
            if (r5 == 0) goto L_0x00cb
            android.app.Notification r5 = r10.getNotification()
            android.os.Bundle r5 = r5.extras
            java.lang.CharSequence r4 = r5.getCharSequence(r4)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            com.google.gson.Gson r5 = new com.google.gson.Gson
            r5.<init>()
            com.upuphone.xr.sapp.monitor.notification.utils.NotificationHelper$dealNotificationMsg$testData$1 r8 = new com.upuphone.xr.sapp.monitor.notification.utils.NotificationHelper$dealNotificationMsg$testData$1
            r8.<init>()
            java.lang.reflect.Type r8 = r8.getType()
            java.lang.Object r4 = r5.fromJson((java.lang.String) r4, (java.lang.reflect.Type) r8)
            java.util.HashMap r4 = (java.util.HashMap) r4
            java.lang.String r5 = "Package"
            boolean r5 = r4.containsKey(r5)
            if (r5 == 0) goto L_0x00b7
            java.lang.String r5 = "text"
            boolean r8 = r4.containsKey(r5)
            if (r8 == 0) goto L_0x00b7
            java.lang.Object r0 = r4.get(r5)
            java.lang.String r0 = java.lang.String.valueOf(r0)
        L_0x00b7:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "deal notification msg hit test data "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.upuphone.xr.interconnect.util.log.ILog.d(r7, r4)
        L_0x00cb:
            int r4 = r0.length()
            if (r4 != 0) goto L_0x011a
            android.app.Notification r10 = r10.getNotification()
            java.lang.String r0 = "getNotification(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
            java.lang.String r9 = r9.b(r10)
            java.lang.CharSequence r9 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r9)
            java.lang.String r9 = r9.toString()
            int r10 = r9.length()
            if (r10 != 0) goto L_0x00f8
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r2)
            if (r10 == 0) goto L_0x00f8
            java.lang.String r9 = "content isEmpty | title and content is appName"
            com.upuphone.xr.interconnect.util.log.ILog.d(r7, r9)
            return r1
        L_0x00f8:
            int r10 = r3.length()
            if (r10 != 0) goto L_0x010b
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r2)
            if (r10 == 0) goto L_0x010b
            java.lang.String r9 = "title isEmpty | title and content is appName"
            com.upuphone.xr.interconnect.util.log.ILog.d(r7, r9)
            return r1
        L_0x010b:
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r3)
            if (r10 == 0) goto L_0x0118
            java.lang.String r9 = "title and content are the same"
            com.upuphone.xr.interconnect.util.log.ILog.d(r7, r9)
            goto L_0x011b
        L_0x0118:
            r6 = r9
            goto L_0x011b
        L_0x011a:
            r6 = r0
        L_0x011b:
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r3)
            if (r9 == 0) goto L_0x012e
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r2)
            if (r9 == 0) goto L_0x012e
            java.lang.String r9 = "title and content is appName"
            com.upuphone.xr.interconnect.util.log.ILog.d(r7, r9)
            return r1
        L_0x012e:
            int r9 = r6.length()
            if (r9 != 0) goto L_0x0141
            int r9 = r3.length()
            if (r9 != 0) goto L_0x0141
            java.lang.String r9 = "title and content is empty"
            com.upuphone.xr.interconnect.util.log.ILog.d(r7, r9)
            return r1
        L_0x0141:
            int r9 = r6.length()
            java.lang.String r10 = "content"
            java.lang.String r0 = "title"
            if (r9 != 0) goto L_0x014d
            goto L_0x0153
        L_0x014d:
            int r9 = r3.length()
            if (r9 != 0) goto L_0x016b
        L_0x0153:
            kotlin.Pair r9 = kotlin.TuplesKt.to(r0, r2)
            int r0 = r3.length()
            if (r0 != 0) goto L_0x015e
            r3 = r6
        L_0x015e:
            kotlin.Pair r10 = kotlin.TuplesKt.to(r10, r3)
            kotlin.Pair[] r9 = new kotlin.Pair[]{r9, r10}
            java.util.HashMap r9 = kotlin.collections.MapsKt.hashMapOf(r9)
            return r9
        L_0x016b:
            kotlin.Pair r9 = kotlin.TuplesKt.to(r0, r3)
            kotlin.Pair r10 = kotlin.TuplesKt.to(r10, r6)
            kotlin.Pair[] r9 = new kotlin.Pair[]{r9, r10}
            java.util.HashMap r9 = kotlin.collections.MapsKt.hashMapOf(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.notification.utils.NotificationHelper.a(android.service.notification.StatusBarNotification):java.util.HashMap");
    }

    public final String b(Notification notification) {
        RemoteViews remoteViews = notification.contentView;
        if (remoteViews == null) {
            remoteViews = Notification.Builder.recoverBuilder(MainApplication.k.f(), notification).createContentView();
        }
        StringBuilder sb = new StringBuilder();
        if (remoteViews != null) {
            try {
                View apply = remoteViews.apply(MainApplication.k.f(), (ViewGroup) null);
                NotificationHelper notificationHelper = f7775a;
                Intrinsics.checkNotNull(apply);
                notificationHelper.j(apply, sb);
            } catch (Throwable th) {
                ILog.e("NotificationHelper", "getContentView--发生异常：" + th + "-->");
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        if (r1.equals("com.autonavi.minimap") == false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        if (r1.equals("com.baidu.BaiduMap") == false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0073, code lost:
        if (r1.equals("com.umetrip.android.msky.app") == false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0076, code lost:
        r0 = com.upuphone.xr.sapp.R.string.app_notify_important_flight_desc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007f, code lost:
        if (r1.equals("com.sdu.didi.psnger") == false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0082, code lost:
        r0 = com.upuphone.xr.sapp.R.string.app_notify_important_travel_desc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008b, code lost:
        if (r1.equals("com.sankuai.meituan.takeoutnew") == false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a0, code lost:
        if (r1.equals("me.ele") == false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a9, code lost:
        if (r1.equals("com.sankuai.meituan") == false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ab, code lost:
        r0 = com.upuphone.xr.sapp.R.string.app_notify_important_desc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ae, code lost:
        r0 = com.upuphone.xr.sapp.R.string.app_notify_important_takeaway_desc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b0, code lost:
        r0 = com.upuphone.xr.sapp.utils.GlobalExtKt.f().getResources().getString(r0);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "getString(...)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c1, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0030, code lost:
        if (r1.equals("ctrip.android.view") == false) goto L_0x00ab;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String c(java.lang.String r1) {
        /*
            r0 = this;
            java.lang.String r0 = "packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            int r0 = r1.hashCode()
            switch(r0) {
                case -1709882794: goto L_0x00a3;
                case -1079643320: goto L_0x009a;
                case -973170826: goto L_0x008e;
                case -949179023: goto L_0x0085;
                case -918490570: goto L_0x0079;
                case -899649745: goto L_0x006d;
                case -30315083: goto L_0x0061;
                case 361910168: goto L_0x0055;
                case 379189486: goto L_0x0048;
                case 744792033: goto L_0x003e;
                case 1254578009: goto L_0x0034;
                case 1310504938: goto L_0x002a;
                case 1335515207: goto L_0x001c;
                case 1380298910: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x00ab
        L_0x000e:
            java.lang.String r0 = "com.tencent.wemeet.app"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0018
            goto L_0x00ab
        L_0x0018:
            int r0 = com.upuphone.xr.sapp.R.string.app_notify_important_wemeet_desc
            goto L_0x00b0
        L_0x001c:
            java.lang.String r0 = "com.alibaba.android.rimet"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0026
            goto L_0x00ab
        L_0x0026:
            int r0 = com.upuphone.xr.sapp.R.string.app_notify_important_rimet_desc
            goto L_0x00b0
        L_0x002a:
            java.lang.String r0 = "ctrip.android.view"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0076
            goto L_0x00ab
        L_0x0034:
            java.lang.String r0 = "com.autonavi.minimap"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0082
            goto L_0x00ab
        L_0x003e:
            java.lang.String r0 = "com.baidu.BaiduMap"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0082
            goto L_0x00ab
        L_0x0048:
            java.lang.String r0 = "com.ss.android.lark"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x00ab
        L_0x0051:
            int r0 = com.upuphone.xr.sapp.R.string.app_notify_important_lark_desc
            goto L_0x00b0
        L_0x0055:
            java.lang.String r0 = "com.tencent.mobileqq"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x005e
            goto L_0x00ab
        L_0x005e:
            int r0 = com.upuphone.xr.sapp.R.string.app_notify_important_qq_desc
            goto L_0x00b0
        L_0x0061:
            java.lang.String r0 = "com.tencent.wework"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x006a
            goto L_0x00ab
        L_0x006a:
            int r0 = com.upuphone.xr.sapp.R.string.app_notify_important_wework_desc
            goto L_0x00b0
        L_0x006d:
            java.lang.String r0 = "com.umetrip.android.msky.app"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0076
            goto L_0x00ab
        L_0x0076:
            int r0 = com.upuphone.xr.sapp.R.string.app_notify_important_flight_desc
            goto L_0x00b0
        L_0x0079:
            java.lang.String r0 = "com.sdu.didi.psnger"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0082
            goto L_0x00ab
        L_0x0082:
            int r0 = com.upuphone.xr.sapp.R.string.app_notify_important_travel_desc
            goto L_0x00b0
        L_0x0085:
            java.lang.String r0 = "com.sankuai.meituan.takeoutnew"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00ae
            goto L_0x00ab
        L_0x008e:
            java.lang.String r0 = "com.tencent.mm"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x00ab
        L_0x0097:
            int r0 = com.upuphone.xr.sapp.R.string.app_notify_important_wechat_desc
            goto L_0x00b0
        L_0x009a:
            java.lang.String r0 = "me.ele"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00ae
            goto L_0x00ab
        L_0x00a3:
            java.lang.String r0 = "com.sankuai.meituan"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00ae
        L_0x00ab:
            int r0 = com.upuphone.xr.sapp.R.string.app_notify_important_desc
            goto L_0x00b0
        L_0x00ae:
            int r0 = com.upuphone.xr.sapp.R.string.app_notify_important_takeaway_desc
        L_0x00b0:
            android.content.Context r1 = com.upuphone.xr.sapp.utils.GlobalExtKt.f()
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r1 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.notification.utils.NotificationHelper.c(java.lang.String):java.lang.String");
    }

    public final Intent d(PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(pendingIntent, "intent");
        try {
            Object invoke = PendingIntent.class.getDeclaredMethod("getIntent", (Class[]) null).invoke(pendingIntent, (Object[]) null);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type android.content.Intent");
            return (Intent) invoke;
        } catch (Exception unused) {
            return null;
        }
    }

    public final String e(StatusBarNotification statusBarNotification) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "sbn");
        String packageName = statusBarNotification.getPackageName();
        PackageConfig packageConfig = PackageConfig.f7770a;
        String packageName2 = statusBarNotification.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName2, "getPackageName(...)");
        if (packageConfig.a(packageName2)) {
            HashMap hashMap = (HashMap) new Gson().fromJson(String.valueOf(statusBarNotification.getNotification().extras.getCharSequence("android.text")), new NotificationHelper$getRealPackage$testData$1().getType());
            if (hashMap.containsKey("Package") && hashMap.containsKey("text")) {
                packageName = String.valueOf(hashMap.get("Package"));
            }
            ILog.d("NotificationHelper", "get real package hit test data :" + packageName);
            Intrinsics.checkNotNull(packageName);
            return packageName;
        }
        try {
            String groupKey = statusBarNotification.getGroupKey();
            Intrinsics.checkNotNullExpressionValue(groupKey, "getGroupKey(...)");
            String str = (String) StringsKt.split$default((CharSequence) groupKey, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML}, false, 0, 6, (Object) null).get(1);
            if (!Intrinsics.areEqual((Object) packageName, (Object) str)) {
                ILog.d("NotificationHelper", "groupKey package names[" + str + "]  are inconsistent " + str);
                packageName = str;
            }
        } catch (Exception e) {
            String message = e.getMessage();
            ILog.d("NotificationHelper", "parse groupKey package err " + message);
        }
        Intrinsics.checkNotNull(packageName);
        return packageName;
    }

    public final byte[] f(Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "mNotification");
        RemoteViews remoteViews = notification.contentView;
        if (remoteViews == null) {
            remoteViews = Notification.Builder.recoverBuilder(MainApplication.k.f(), notification).createContentView();
        }
        if (remoteViews != null) {
            try {
                View apply = remoteViews.apply(MainApplication.k.f(), (ViewGroup) null);
                NotificationHelper notificationHelper = f7775a;
                Intrinsics.checkNotNull(apply);
                Bitmap i = notificationHelper.i(apply);
                Integer valueOf = i != null ? Integer.valueOf(i.getRowBytes()) : null;
                ILog.e("NotificationHelper", "traversalIconView--" + valueOf + "-->");
                if (i != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    AppInfoHelper.f7840a.c(i, 0.5f).compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
                    int length = byteArrayOutputStream.toByteArray().length;
                    ILog.e("NotificationHelper", "微信头像大小--" + length + "-->");
                    return byteArrayOutputStream.toByteArray();
                }
            } catch (Throwable th) {
                ILog.e("NotificationHelper", "getContentView--发生异常：" + th + "-->");
            }
        }
        return null;
    }

    public final boolean g() {
        Object systemService = MainApplication.k.f().getSystemService("keyguard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        return ((KeyguardManager) systemService).isKeyguardLocked();
    }

    public final String h(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ArrayList arrayList = new ArrayList(str.length());
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            int i3 = i2 + 1;
            if (i2 >= 2) {
                charAt = '*';
            }
            arrayList.add(Character.valueOf(charAt));
            i++;
            i2 = i3;
        }
        return CollectionsKt.joinToString$default(arrayList, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final Bitmap i(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                Bitmap i2 = f7775a.i(viewGroup.getChildAt(i));
                if (i2 != null) {
                    return i2;
                }
            }
            return null;
        } else if (!(view instanceof ImageView) || !Intrinsics.areEqual((Object) view.getClass().getName(), (Object) "flyme.widget.RoundImageView")) {
            return null;
        } else {
            Drawable drawable = ((ImageView) view).getDrawable();
            Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(...)");
            return DrawableKt.b(drawable, 0, 0, (Bitmap.Config) null, 7, (Object) null);
        }
    }

    public final void j(View view, StringBuilder sb) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            String resourceEntryName = viewGroup.getContext().getResources().getResourceEntryName(viewGroup.getId());
            int id = viewGroup.getId();
            ILog.i("NotificationHelper", "traversalViewGroup:id:" + id + " resourceEntryName:" + resourceEntryName);
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                f7775a.j(viewGroup.getChildAt(i), sb);
            }
        } else if (view instanceof TextView) {
            TextView textView = (TextView) view;
            CharSequence text = textView.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            if (text.length() > 0) {
                String resourceEntryName2 = textView.getContext().getResources().getResourceEntryName(textView.getId());
                int id2 = textView.getId();
                CharSequence text2 = textView.getText();
                ILog.i("NotificationHelper", "traversalView:id:" + id2 + " resourceEntryName:" + resourceEntryName2 + " content:" + text2 + "-->");
                if (!ArraysKt.contains((T[]) b, resourceEntryName2)) {
                    sb.append(textView.getText().toString());
                    sb.append(" ");
                }
            }
        }
    }
}

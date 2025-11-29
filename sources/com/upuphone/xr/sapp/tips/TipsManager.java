package com.upuphone.xr.sapp.tips;

import android.os.Handler;
import android.os.Looper;
import com.honey.account.u8.a;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/upuphone/xr/sapp/tips/TipsManager;", "", "<init>", "()V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$TipsFlutterApi;", "mTipsApi", "", "g", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$TipsFlutterApi;)V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$HomeTips;", "homeTips", "Lkotlin/Function0;", "btnClick", "j", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$HomeTips;Lkotlin/jvm/functions/Function0;)V", "Lcom/upuphone/xr/sapp/tips/TipsKey;", "key", "d", "(Lcom/upuphone/xr/sapp/tips/TipsKey;)V", "", "f", "(Ljava/lang/String;)V", "e", "func", "h", "(Lkotlin/jvm/functions/Function0;)V", "b", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$TipsFlutterApi;", "tipsApi", "", "Lcom/upuphone/xr/sapp/tips/TipsModel;", "c", "Ljava/util/List;", "tipsArray", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTipsManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TipsManager.kt\ncom/upuphone/xr/sapp/tips/TipsManager\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,120:1\n1282#2,2:121\n1282#2,2:123\n288#3,2:125\n*S KotlinDebug\n*F\n+ 1 TipsManager.kt\ncom/upuphone/xr/sapp/tips/TipsManager\n*L\n81#1:121,2\n94#1:123,2\n95#1:125,2\n*E\n"})
public final class TipsManager {

    /* renamed from: a  reason: collision with root package name */
    public static final TipsManager f7827a = new TipsManager();
    public static AndroidAppApi.TipsFlutterApi b;
    public static List c = new ArrayList();

    public static final void i(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$func");
        function0.invoke();
    }

    public final void d(TipsKey tipsKey) {
        Intrinsics.checkNotNullParameter(tipsKey, IntentKey.ACTIVITY.ACTION_KEY);
        ULog.Delegate delegate = ULog.f6446a;
        String name = tipsKey.name();
        delegate.a("TipsManager", "cancel Tips " + name);
        h(new TipsManager$cancelTips$1(tipsKey));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.upuphone.xr.sapp.tips.TipsModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.upuphone.xr.sapp.tips.TipsModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.upuphone.xr.sapp.tips.TipsModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.upuphone.xr.sapp.tips.TipsModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r5 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r5)
            com.upuphone.star.core.log.ULog$Delegate r5 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "deal Tips Click"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TipsManager"
            r5.a(r1, r0)
            com.upuphone.xr.sapp.tips.TipsKey[] r5 = com.upuphone.xr.sapp.tips.TipsKey.values()
            int r0 = r5.length
            r1 = 0
        L_0x0023:
            r2 = 0
            if (r1 >= r0) goto L_0x0036
            r3 = r5[r1]
            java.lang.String r4 = r3.name()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r4 == 0) goto L_0x0033
            goto L_0x0037
        L_0x0033:
            int r1 = r1 + 1
            goto L_0x0023
        L_0x0036:
            r3 = r2
        L_0x0037:
            if (r3 == 0) goto L_0x0060
            java.util.List r5 = c
            java.util.Iterator r5 = r5.iterator()
        L_0x003f:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0053
            java.lang.Object r6 = r5.next()
            r0 = r6
            com.upuphone.xr.sapp.tips.TipsModel r0 = (com.upuphone.xr.sapp.tips.TipsModel) r0
            com.upuphone.xr.sapp.tips.TipsKey r0 = r0.b()
            if (r0 != r3) goto L_0x003f
            r2 = r6
        L_0x0053:
            com.upuphone.xr.sapp.tips.TipsModel r2 = (com.upuphone.xr.sapp.tips.TipsModel) r2
            if (r2 == 0) goto L_0x0060
            kotlin.jvm.functions.Function0 r5 = r2.a()
            if (r5 == 0) goto L_0x0060
            r5.invoke()
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.tips.TipsManager.e(java.lang.String):void");
    }

    public final void f(String str) {
        TipsKey tipsKey;
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("TipsManager", "deal Tips Close Key" + str);
        TipsKey[] values = TipsKey.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                tipsKey = null;
                break;
            }
            tipsKey = values[i];
            if (Intrinsics.areEqual((Object) tipsKey.name(), (Object) str)) {
                break;
            }
            i++;
        }
        if (tipsKey != null && TipsKeyKt.c(tipsKey)) {
            DataStoreUtils.e.a().o("PERMISSION_CLOSE_KEY", Long.valueOf(System.currentTimeMillis()));
        }
        TipsKey d = TipsKeyKt.d(str);
        Intrinsics.checkNotNull(d);
        d(d);
    }

    public final void g(AndroidAppApi.TipsFlutterApi tipsFlutterApi) {
        Intrinsics.checkNotNullParameter(tipsFlutterApi, "mTipsApi");
        b = tipsFlutterApi;
    }

    public final void h(Function0 function0) {
        if (!Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper())) {
            new Handler(Looper.getMainLooper()).post(new a(function0));
        } else {
            function0.invoke();
        }
    }

    public final void j(AndroidAppApi.HomeTips homeTips, Function0 function0) {
        Intrinsics.checkNotNullParameter(homeTips, "homeTips");
        h(new TipsManager$showTips$1(homeTips, function0));
    }
}

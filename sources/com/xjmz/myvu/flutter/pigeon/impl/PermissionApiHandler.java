package com.xjmz.myvu.flutter.pigeon.impl;

import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.permission.PermissionHelper;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.xjmz.myvu.MYVUActivity;
import com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u001d\u0010\r\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ#\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/PermissionApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidPermissionApi$PermissionApi;", "<init>", "()V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidPermissionApi$Permission;", "permission", "Lcom/xjmz/myvu/flutter/pigeon/AndroidPermissionApi$Result;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidPermissionApi$PermissionResult;", "result", "", "f", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidPermissionApi$Permission;Lcom/xjmz/myvu/flutter/pigeon/AndroidPermissionApi$Result;)V", "d", "i", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidPermissionApi$Result;)V", "c", "", "success", "", "errorMsg", "p", "(ZLjava/lang/String;)Lcom/xjmz/myvu/flutter/pigeon/AndroidPermissionApi$PermissionResult;", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PermissionApiHandler implements AndroidPermissionApi.PermissionApi {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8351a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/PermissionApiHandler$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi$Permission[] r0 = com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi.Permission.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi$Permission r1 = com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi.Permission.RECORD_AUDIO     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi$Permission r1 = com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi.Permission.ALBUM     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi$Permission r1 = com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi.Permission.CAMERA     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi$Permission r1 = com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi.Permission.LOCATION     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi$Permission r1 = com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi.Permission.BACKGROUND_LOCATION     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.flutter.pigeon.impl.PermissionApiHandler.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ AndroidPermissionApi.PermissionResult q(PermissionApiHandler permissionApiHandler, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return permissionApiHandler.p(z, str);
    }

    public void c(AndroidPermissionApi.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("PermissionApiHandler", "requestBluetoothState");
        MYVUActivity r = MainApplication.k.f().r();
        if (r == null) {
            delegate.c("PermissionApiHandler", "requestBluetoothState, getMYVUActivity is null");
            result.success(p(false, "getMYVUActivity is null"));
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(r), (CoroutineContext) null, (CoroutineStart) null, new PermissionApiHandler$requestBluetoothState$1(r, result, this, (Continuation<? super PermissionApiHandler$requestBluetoothState$1>) null), 3, (Object) null);
    }

    public void d(AndroidPermissionApi.Permission permission, AndroidPermissionApi.Result result) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(result, "result");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("PermissionApiHandler", "checkPermission: " + permission);
        MYVUActivity r = MainApplication.k.f().r();
        if (r == null) {
            delegate.c("PermissionApiHandler", "checkPermission: " + permission + ", getMYVUActivity is null");
            result.success(p(false, "getMYVUActivity is null"));
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[permission.ordinal()];
        result.success(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? p(false, "unsupported") : q(this, PermissionHelper.f7819a.n(r, PermissionAndStateCheckUtils.f7907a.t()), (String) null, 2, (Object) null) : q(this, PermissionHelper.f7819a.n(r, PermissionAndStateCheckUtils.f7907a.A()), (String) null, 2, (Object) null) : q(this, PermissionHelper.f7819a.n(r, PermissionAndStateCheckUtils.f7907a.u()), (String) null, 2, (Object) null) : q(this, PermissionHelper.f7819a.n(r, PermissionAndStateCheckUtils.f7907a.l()), (String) null, 2, (Object) null) : q(this, PermissionHelper.f7819a.n(r, PermissionAndStateCheckUtils.f7907a.y()), (String) null, 2, (Object) null));
    }

    public void f(AndroidPermissionApi.Permission permission, AndroidPermissionApi.Result result) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(result, "result");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("PermissionApiHandler", "requestPermission: " + permission);
        MYVUActivity r = MainApplication.k.f().r();
        if (r == null) {
            delegate.c("PermissionApiHandler", "requestPermission: " + permission + ", getMYVUActivity is null");
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[permission.ordinal()];
        if (i == 1) {
            PermissionHelper.f7819a.r(r, PermissionAndStateCheckUtils.f7907a.y(), true, new PermissionApiHandler$requestPermission$1(result, this));
        } else if (i == 2) {
            PermissionHelper.f7819a.r(r, PermissionAndStateCheckUtils.f7907a.l(), true, new PermissionApiHandler$requestPermission$2(result, this));
        } else if (i == 3) {
            PermissionHelper.f7819a.r(r, PermissionAndStateCheckUtils.f7907a.u(), true, new PermissionApiHandler$requestPermission$3(result, this));
        } else if (i == 4) {
            PermissionHelper.f7819a.r(r, PermissionAndStateCheckUtils.f7907a.A(), true, new PermissionApiHandler$requestPermission$4(result, this));
        } else if (i != 5) {
            result.success(p(false, "unsupported"));
        } else {
            PermissionHelper.f7819a.r(r, PermissionAndStateCheckUtils.f7907a.A(), true, new PermissionApiHandler$requestPermission$5(r, result, this));
        }
    }

    public void i(AndroidPermissionApi.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("PermissionApiHandler", "checkSportPermission");
        boolean B = PermissionAndStateCheckUtils.f7907a.B();
        delegate.a("PermissionApiHandler", "isGPSEnabled: " + B);
        if (!B) {
            q(this, false, (String) null, 2, (Object) null);
        } else {
            d(AndroidPermissionApi.Permission.LOCATION, result);
        }
    }

    public final AndroidPermissionApi.PermissionResult p(boolean z, String str) {
        if (str == null) {
            str = z ? "success" : "fail";
        }
        AndroidPermissionApi.PermissionResult a2 = new AndroidPermissionApi.PermissionResult.Builder().c(Boolean.valueOf(z)).b(str).a();
        Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
        return a2;
    }
}

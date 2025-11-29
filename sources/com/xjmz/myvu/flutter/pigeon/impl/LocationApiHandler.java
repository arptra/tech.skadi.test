package com.xjmz.myvu.flutter.pigeon.impl;

import androidx.fragment.app.FragmentActivity;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.navi.lite.model.ILocation;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.xjmz.myvu.dialog.NormalTwoBtnDialog;
import com.xjmz.myvu.flutter.base.BaseFlutterFragment;
import com.xjmz.myvu.flutter.pigeon.AndroidLocationApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001eB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ#\u0010\u0014\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/LocationApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidLocationApi$LocationApi;", "Lcom/upuphone/ar/navi/lite/model/ILocation;", "Lcom/xjmz/myvu/flutter/base/BaseFlutterFragment;", "fragment", "<init>", "(Lcom/xjmz/myvu/flutter/base/BaseFlutterFragment;)V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidLocationApi$Result;", "", "result", "", "a", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidLocationApi$Result;)V", "e", "()V", "stopLocation", "Lcom/upuphone/ar/navi/lite/base/ULocation;", "location", "Lcom/upuphone/ar/navi/lite/base/PlaceBean;", "place", "q", "(Lcom/upuphone/ar/navi/lite/base/ULocation;Lcom/upuphone/ar/navi/lite/base/PlaceBean;)V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidLocationApi$LocationResultApi;", "k", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidLocationApi$LocationResultApi;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidLocationApi$Location;", "l", "(Lcom/upuphone/ar/navi/lite/base/ULocation;)Lcom/xjmz/myvu/flutter/pigeon/AndroidLocationApi$Location;", "Lcom/xjmz/myvu/flutter/base/BaseFlutterFragment;", "b", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nLocationApiHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocationApiHandler.kt\ncom/xjmz/myvu/flutter/pigeon/impl/LocationApiHandler\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,96:1\n1#2:97\n*E\n"})
public final class LocationApiHandler implements AndroidLocationApi.LocationApi, ILocation {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final BaseFlutterFragment f8349a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/LocationApiHandler$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public LocationApiHandler(BaseFlutterFragment baseFlutterFragment) {
        Intrinsics.checkNotNullParameter(baseFlutterFragment, "fragment");
        this.f8349a = baseFlutterFragment;
    }

    public void a(AndroidLocationApi.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (PermissionAndStateCheckUtils.f7907a.B()) {
            result.success(Boolean.TRUE);
            return;
        }
        FragmentActivity activity = this.f8349a.getActivity();
        if (activity == null) {
            result.success(Boolean.FALSE);
            return;
        }
        NormalTwoBtnDialog.Companion companion = NormalTwoBtnDialog.k;
        String string = activity.getString(R.string.glass_update_need_gps);
        String string2 = activity.getString(R.string.flyme_internal_app_permission_location_text);
        String string3 = activity.getString(R.string.open_notification);
        String string4 = activity.getString(R.string.cancel);
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNull(string2);
        Intrinsics.checkNotNull(string3);
        Intrinsics.checkNotNull(string4);
        NormalTwoBtnDialog.Companion.b(companion, activity, string, string2, string3, string4, new LocationApiHandler$isLocationServiceEnabled$1(activity), new LocationApiHandler$isLocationServiceEnabled$2(result), (Function0) null, false, false, 896, (Object) null);
    }

    public void e() {
        ULog.Delegate delegate = ULog.f6446a;
        String simpleName = this.f8349a.getClass().getSimpleName();
        delegate.g("LocationApiHandler", simpleName + " startLocation");
        MainApplication.Companion companion = MainApplication.k;
        NaviManager.getInstance(companion.f()).startContinueLocation(companion.f(), this);
    }

    public final AndroidLocationApi.LocationResultApi k() {
        return new AndroidLocationApi.LocationResultApi(this.f8349a.s0().getDartExecutor().getBinaryMessenger());
    }

    public final AndroidLocationApi.Location l(ULocation uLocation) {
        double d = 0.0d;
        AndroidLocationApi.Location.Builder c = new AndroidLocationApi.Location.Builder().e(Double.valueOf(uLocation != null ? uLocation.getLongitude() : 0.0d)).d(Double.valueOf(uLocation != null ? uLocation.getLatitude() : 0.0d)).f(Double.valueOf(uLocation != null ? uLocation.getSpeed() : 0.0d)).c(Double.valueOf(uLocation != null ? uLocation.getAltitude() : 0.0d));
        if (uLocation != null) {
            d = uLocation.getAccuracy();
        }
        AndroidLocationApi.Location a2 = c.b(Double.valueOf(d)).a();
        Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
        return a2;
    }

    public void q(ULocation uLocation, PlaceBean placeBean) {
        k().d(l(uLocation), new LocationVoidResult());
    }

    public void stopLocation() {
        ULog.Delegate delegate = ULog.f6446a;
        String simpleName = this.f8349a.getClass().getSimpleName();
        delegate.g("LocationApiHandler", simpleName + " stopLocation");
        NaviManager.getInstance(MainApplication.k.f()).stopContinueLocation(this);
    }
}

package com.xjmz.myvu;

import android.content.Context;
import androidx.navigation.ActivityKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.datatrack.ConnectEventReporter;
import com.upuphone.xr.sapp.entity.DeviceState;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/DeviceState;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class MYVUActivity$addDeviceBoundObserve$1 extends Lambda implements Function1<DeviceState, Unit> {
    final /* synthetic */ MYVUActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MYVUActivity$addDeviceBoundObserve$1(MYVUActivity mYVUActivity) {
        super(1);
        this.this$0 = mYVUActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DeviceState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DeviceState deviceState) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("MYVUActivity", "onDeviceBondStateChange newState is: " + deviceState);
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        String str = (String) DataStoreUtils.i(companion.a(), "sp_device_connect_history", "null", (Context) null, 4, (Object) null);
        if (deviceState != null && deviceState.getState() == 0 && !Intrinsics.areEqual((Object) str, (Object) "null")) {
            companion.a().o("sp_device_connect_history", "null");
            companion.a().o("sp_current_bond_device_id", "");
            GenericWindowManger.c.a().i();
            ConnectEventReporter connectEventReporter = ConnectEventReporter.b;
            boolean d = connectEventReporter.d();
            delegate.c("MYVUActivity", "cur state is unbound ConnectEventReporter.isNeedTipGlassUnbind = " + d);
            if (connectEventReporter.d()) {
                StaticMethodUtilsKt.A(this.this$0, CollectionsKt.arrayListOf(2014), false, false);
            } else {
                delegate.c("MYVUActivity", "empty_fragment to home when connectDevice != null");
                ActivityKt.a(this.this$0, R.id.android_navi).W(R.id.empty_fragment, false);
            }
            connectEventReporter.m(false);
        } else if (deviceState != null && deviceState.getState() == 2) {
            delegate.o("MYVUActivity", "STATE_BONDED dismissGenericWindow");
            GenericWindowManger.c.a().j(2014);
        }
    }
}

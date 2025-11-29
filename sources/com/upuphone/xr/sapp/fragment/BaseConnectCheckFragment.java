package com.upuphone.xr.sapp.fragment;

import androidx.lifecycle.viewmodel.CreationExtras;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0003R\u001b\u0010\u000f\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/BaseConnectCheckFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "A0", "D0", "onResume", "onPause", "B0", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "j", "Lkotlin/Lazy;", "C0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBaseConnectCheckFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseConnectCheckFragment.kt\ncom/upuphone/xr/sapp/fragment/BaseConnectCheckFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n*L\n1#1,51:1\n32#2,12:52\n*S KotlinDebug\n*F\n+ 1 BaseConnectCheckFragment.kt\ncom/upuphone/xr/sapp/fragment/BaseConnectCheckFragment\n*L\n14#1:52,12\n*E\n"})
public abstract class BaseConnectCheckFragment extends BaseFragment {
    public final Lazy j;

    public BaseConnectCheckFragment() {
        Class<DeviceControlModel> cls = DeviceControlModel.class;
        this.j = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    private final void A0() {
        C0().L().observe(getViewLifecycleOwner(), new BaseConnectCheckFragment$sam$androidx_lifecycle_Observer$0(new BaseConnectCheckFragment$addObserve$1(this)));
    }

    private final DeviceControlModel C0() {
        return (DeviceControlModel) this.j.getValue();
    }

    private final void D0() {
        C0().L().removeObservers(getViewLifecycleOwner());
    }

    public void B0() {
    }

    public void onPause() {
        D0();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        A0();
    }
}

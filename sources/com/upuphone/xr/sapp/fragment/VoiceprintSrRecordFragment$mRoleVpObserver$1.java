package com.upuphone.xr.sapp.fragment;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/fragment/VoiceprintSrRecordFragment$mRoleVpObserver$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "onPause", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onResume", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VoiceprintSrRecordFragment$mRoleVpObserver$1 implements DefaultLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VoiceprintSrRecordFragment f7019a;

    public VoiceprintSrRecordFragment$mRoleVpObserver$1(VoiceprintSrRecordFragment voiceprintSrRecordFragment) {
        this.f7019a = voiceprintSrRecordFragment;
    }

    public void onPause(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        super.onPause(lifecycleOwner);
        this.f7019a.m1("onPause 应用到后台");
        this.f7019a.s = false;
        Integer num = (Integer) this.f7019a.e1().L().getValue();
        if (num != null && num.intValue() == 0) {
            this.f7019a.e1().n0();
            this.f7019a.t = true;
        }
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        super.onResume(lifecycleOwner);
        this.f7019a.m1("onResume 应用到前台");
        this.f7019a.s = true;
        if (this.f7019a.t) {
            this.f7019a.e1().j0();
            this.f7019a.t = false;
        }
    }
}

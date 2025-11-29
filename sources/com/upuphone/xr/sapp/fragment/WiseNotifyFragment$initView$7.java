package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class WiseNotifyFragment$initView$7 extends Lambda implements Function0<Unit> {
    final /* synthetic */ WiseNotifyFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WiseNotifyFragment$initView$7(WiseNotifyFragment wiseNotifyFragment) {
        super(0);
        this.this$0 = wiseNotifyFragment;
    }

    public final void invoke() {
        WiseNotifyFragment wiseNotifyFragment = this.this$0;
        PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
        if (!StaticMethodUtilsKt.a(wiseNotifyFragment, permissionAndStateCheckUtils.r())) {
            this.this$0.v0(permissionAndStateCheckUtils.r(), "Calendar");
        } else {
            StaticMethodUtilsKt.t(this.this$0, R.id.scheduleDisplayFragment);
        }
    }
}

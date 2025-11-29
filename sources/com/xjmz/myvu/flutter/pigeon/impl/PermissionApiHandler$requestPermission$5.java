package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.xr.sapp.permission.PermissionHelper;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.xjmz.myvu.MYVUActivity;
import com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "location", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PermissionApiHandler$requestPermission$5 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ MYVUActivity $activity;
    final /* synthetic */ AndroidPermissionApi.Result<AndroidPermissionApi.PermissionResult> $result;
    final /* synthetic */ PermissionApiHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionApiHandler$requestPermission$5(MYVUActivity mYVUActivity, AndroidPermissionApi.Result<AndroidPermissionApi.PermissionResult> result, PermissionApiHandler permissionApiHandler) {
        super(1);
        this.$activity = mYVUActivity;
        this.$result = result;
        this.this$0 = permissionApiHandler;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            PermissionHelper permissionHelper = PermissionHelper.f7819a;
            MYVUActivity mYVUActivity = this.$activity;
            String[] t = PermissionAndStateCheckUtils.f7907a.t();
            final AndroidPermissionApi.Result<AndroidPermissionApi.PermissionResult> result = this.$result;
            final PermissionApiHandler permissionApiHandler = this.this$0;
            permissionHelper.r(mYVUActivity, t, true, new Function1<Boolean, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    result.success(PermissionApiHandler.q(permissionApiHandler, z, (String) null, 2, (Object) null));
                }
            });
            return;
        }
        this.$result.success(PermissionApiHandler.q(this.this$0, false, (String) null, 2, (Object) null));
    }
}

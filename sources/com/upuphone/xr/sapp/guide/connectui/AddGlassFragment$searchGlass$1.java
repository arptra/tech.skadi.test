package com.upuphone.xr.sapp.guide.connectui;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.DeviceState;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "deviceState", "Lcom/upuphone/xr/sapp/entity/DeviceState;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AddGlassFragment$searchGlass$1 extends Lambda implements Function1<DeviceState, Unit> {
    final /* synthetic */ AddGlassFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddGlassFragment$searchGlass$1(AddGlassFragment addGlassFragment) {
        super(1);
        this.this$0 = addGlassFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DeviceState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable DeviceState deviceState) {
        if (this.this$0.o0()) {
            PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
            Context requireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            if (!permissionAndStateCheckUtils.f(requireContext) && !this.this$0.C1()) {
                ULog.f6446a.c("AddGlassFragment", "searchGlass WINDOW_TYPE_LOCATION");
                this.this$0.R1();
                return;
            }
        }
        PermissionAndStateCheckUtils permissionAndStateCheckUtils2 = PermissionAndStateCheckUtils.f7907a;
        Context requireContext2 = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
        if (permissionAndStateCheckUtils2.f(requireContext2)) {
            this.this$0.o1();
        }
        this.this$0.m1();
        if (!this.this$0.B1()) {
            ULog.f6446a.a("AddGlassFragment", "reInit connect data");
            this.this$0.H1();
        }
        ULog.Delegate delegate = ULog.f6446a;
        long O0 = this.this$0.t;
        delegate.a("AddGlassFragment", "do searchGlass DeviceState info = " + deviceState + " and mCurrentTime is: " + O0);
        if ((deviceState != null ? deviceState.getTime() : 0) < this.this$0.t) {
            delegate.a("AddGlassFragment", "do searchGlass mCurrentTime > time ");
            return;
        }
        AddGlassFragment addGlassFragment = this.this$0;
        addGlassFragment.O1(deviceState, addGlassFragment.u1(deviceState));
    }
}

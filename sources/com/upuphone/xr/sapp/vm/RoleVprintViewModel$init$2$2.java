package com.upuphone.xr.sapp.vm;

import com.upuphone.xr.sapp.vm.RoleVprintViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "process", "", "expCode", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class RoleVprintViewModel$init$2$2 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ RoleVprintViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoleVprintViewModel$init$2$2(RoleVprintViewModel roleVprintViewModel) {
        super(2);
        this.this$0 = roleVprintViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2) {
        RoleVprintViewModel roleVprintViewModel = this.this$0;
        roleVprintViewModel.S("audioRecord process=" + i + ", expCode=" + i2);
        this.this$0.V(new RoleVprintViewModel.AudioData(2, (byte[]) null));
    }
}

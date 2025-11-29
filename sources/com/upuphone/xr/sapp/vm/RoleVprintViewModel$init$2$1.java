package com.upuphone.xr.sapp.vm;

import com.upuphone.xr.sapp.vm.RoleVprintViewModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class RoleVprintViewModel$init$2$1 extends Lambda implements Function1<byte[], Unit> {
    final /* synthetic */ RoleVprintViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoleVprintViewModel$init$2$1(RoleVprintViewModel roleVprintViewModel) {
        super(1);
        this.this$0 = roleVprintViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((byte[]) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "it");
        RoleVprintViewModel roleVprintViewModel = this.this$0;
        byte[] k = roleVprintViewModel.g;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        roleVprintViewModel.g = ArraysKt.plus(k, copyOf);
        while (this.this$0.g.length >= 3200) {
            this.this$0.V(new RoleVprintViewModel.AudioData(1, ArraysKt.sliceArray(this.this$0.g, RangesKt.until(0, 3200))));
            RoleVprintViewModel roleVprintViewModel2 = this.this$0;
            roleVprintViewModel2.g = ArraysKt.sliceArray(roleVprintViewModel2.g, RangesKt.until(3200, this.this$0.g.length));
        }
    }
}

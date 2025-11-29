package com.upuphone.xr.sapp.vu.ota;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "progress", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuGlassUpdateHelper$update$2$installResult$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ int $index;
    final /* synthetic */ Function1<Integer, Unit> $onProgress;
    final /* synthetic */ float $segment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassUpdateHelper$update$2$installResult$1(Function1<? super Integer, Unit> function1, int i, float f) {
        super(1);
        this.$onProgress = function1;
        this.$index = i;
        this.$segment = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.$onProgress.invoke(Integer.valueOf((int) (((float) ((this.$index * 100) + i)) * this.$segment)));
    }
}

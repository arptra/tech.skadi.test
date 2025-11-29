package com.upuphone.xr.sapp.vu.vm;

import com.upuphone.star.core.log.ULog;
import com.xjmz.myvu.common.ViewGlassControlResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuGlassesModel$listenBrightness$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ VuGlassesModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesModel$listenBrightness$1(VuGlassesModel vuGlassesModel) {
        super(1);
        this.this$0 = vuGlassesModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer num) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("VuGlassesModel", "resViewGlassBrightness: " + num);
        this.this$0.D().d(Long.valueOf((long) num.intValue()), new ViewGlassControlResult());
    }
}

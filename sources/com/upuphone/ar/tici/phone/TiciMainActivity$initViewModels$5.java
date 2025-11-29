package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012>\u0010\u0002\u001a:\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004 \u0005*\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Triple;", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TiciMainActivity$initViewModels$5 extends Lambda implements Function1<Triple<? extends Boolean, ? extends Boolean, ? extends Boolean>, Unit> {
    final /* synthetic */ TiciMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMainActivity$initViewModels$5(TiciMainActivity ticiMainActivity) {
        super(1);
        this.this$0 = ticiMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Triple<Boolean, Boolean, Boolean>) (Triple) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Triple<Boolean, Boolean, Boolean> triple) {
        Boolean first = triple.getFirst();
        Boolean second = triple.getSecond();
        Boolean third = triple.getThird();
        CommonExtKt.e("glassTiciRunningState-> isGlassRunning: " + first + ", isAutoTiciRunnnig: " + second + ", isFinish: " + third, "TiciMainActivity");
        TiciMainActivity ticiMainActivity = this.this$0;
        Boolean first2 = triple.getFirst();
        boolean z = false;
        boolean booleanValue = first2 != null ? first2.booleanValue() : false;
        Boolean second2 = triple.getSecond();
        boolean booleanValue2 = second2 != null ? second2.booleanValue() : false;
        Boolean third2 = triple.getThird();
        if (third2 != null) {
            z = third2.booleanValue();
        }
        ticiMainActivity.Y0(booleanValue, booleanValue2, z);
    }
}

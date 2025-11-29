package com.upuphone.xr.sapp.fragment;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.view.StandbyComponentBottomSheet;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000120\u0010\u0002\u001a,\u0012\u0004\u0012\u00020\u0004 \u0006*\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00050\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class StandbyPositionFragment$addObserve$3 extends Lambda implements Function1<ArrayList<String>, Unit> {
    final /* synthetic */ StandbyPositionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StandbyPositionFragment$addObserve$3(StandbyPositionFragment standbyPositionFragment) {
        super(1);
        this.this$0 = standbyPositionFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<String>) (ArrayList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ArrayList<String> arrayList) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("StandbyPositionFragment", "viewModel.glassStandbyWidgetInfo = " + arrayList);
        StandbyComponentBottomSheet.Companion companion = StandbyComponentBottomSheet.e;
        arrayList.remove(companion.f());
        arrayList.remove(companion.b());
        StandbyPositionFragment standbyPositionFragment = this.this$0;
        Intrinsics.checkNotNull(arrayList);
        standbyPositionFragment.o = arrayList;
        StandbyPositionFragment standbyPositionFragment2 = this.this$0;
        standbyPositionFragment2.p1(standbyPositionFragment2.o);
    }
}

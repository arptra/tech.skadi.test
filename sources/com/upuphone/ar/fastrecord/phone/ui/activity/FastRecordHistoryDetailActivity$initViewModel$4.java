package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nFastRecordHistoryDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordHistoryDetailActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordHistoryDetailActivity$initViewModel$4\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,1520:1\n262#2,2:1521\n262#2,2:1523\n262#2,2:1525\n262#2,2:1527\n262#2,2:1529\n262#2,2:1531\n262#2,2:1533\n262#2,2:1535\n*S KotlinDebug\n*F\n+ 1 FastRecordHistoryDetailActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordHistoryDetailActivity$initViewModel$4\n*L\n1291#1:1521,2\n1292#1:1523,2\n1293#1:1525,2\n1294#1:1527,2\n1296#1:1529,2\n1297#1:1531,2\n1298#1:1533,2\n1299#1:1535,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryDetailActivity$initViewModel$4 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryDetailActivity$initViewModel$4(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        super(1);
        this.this$0 = fastRecordHistoryDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        if (Intrinsics.areEqual((Object) FastRecordDetailRecordHistoryViewModel.PLAY_STATE, (Object) str)) {
            this.this$0.getLayout().k.e.getDelImage().setVisibility(0);
            this.this$0.getLayout().k.e.getAiImg().setVisibility(0);
            this.this$0.getLayout().k.e.getSaveBtn().setVisibility(8);
            this.this$0.getLayout().k.e.getShare().setVisibility(0);
            return;
        }
        this.this$0.getLayout().k.e.getDelImage().setVisibility(8);
        this.this$0.getLayout().k.e.getAiImg().setVisibility(8);
        this.this$0.getLayout().k.e.getShare().setVisibility(8);
        this.this$0.getLayout().k.e.getSaveBtn().setVisibility(0);
    }
}

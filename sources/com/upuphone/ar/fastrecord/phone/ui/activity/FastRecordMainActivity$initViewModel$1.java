package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.widget.TextView;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ui.widget.RecordTabViewPager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nFastRecordMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordMainActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordMainActivity$initViewModel$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,558:1\n262#2,2:559\n262#2,2:561\n262#2,2:563\n262#2,2:565\n*S KotlinDebug\n*F\n+ 1 FastRecordMainActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordMainActivity$initViewModel$1\n*L\n312#1:559,2\n313#1:561,2\n316#1:563,2\n317#1:565,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000120\u0010\u0002\u001a,\u0012\u0004\u0012\u00020\u0004 \u0006*\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00050\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "recordData", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "Lkotlin/collections/ArrayList;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordMainActivity$initViewModel$1 extends Lambda implements Function1<ArrayList<RecordEntity>, Unit> {
    final /* synthetic */ FastRecordMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainActivity$initViewModel$1(FastRecordMainActivity fastRecordMainActivity) {
        super(1);
        this.this$0 = fastRecordMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<RecordEntity>) (ArrayList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ArrayList<RecordEntity> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            this.this$0.getLayout().k.getSearchImage().setVisibility(8);
            RecordTabViewPager recordTabViewPager = this.this$0.getLayout().i;
            Intrinsics.checkNotNullExpressionValue(recordTabViewPager, "recordViewPager");
            recordTabViewPager.setVisibility(8);
            TextView textView = this.this$0.getLayout().l;
            Intrinsics.checkNotNullExpressionValue(textView, "tvRecordTip");
            textView.setVisibility(0);
            return;
        }
        this.this$0.getLayout().k.getSearchImage().setVisibility(0);
        RecordTabViewPager recordTabViewPager2 = this.this$0.getLayout().i;
        Intrinsics.checkNotNullExpressionValue(recordTabViewPager2, "recordViewPager");
        recordTabViewPager2.setVisibility(0);
        TextView textView2 = this.this$0.getLayout().l;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvRecordTip");
        textView2.setVisibility(8);
    }
}

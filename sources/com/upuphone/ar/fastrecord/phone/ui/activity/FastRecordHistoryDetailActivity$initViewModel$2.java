package com.upuphone.ar.fastrecord.phone.ui.activity;

import androidx.core.content.ContextCompat;
import com.upuphone.ar.fastrecord.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryDetailActivity$initViewModel$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryDetailActivity$initViewModel$2(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        super(1);
        this.this$0 = fastRecordHistoryDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean bool) {
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue()) {
            this.this$0.getLayout().e.b.setImageDrawable(ContextCompat.getDrawable(this.this$0, R.drawable.bg_fast_record_history_item_center_pause));
        } else {
            this.this$0.getLayout().e.b.setImageDrawable(ContextCompat.getDrawable(this.this$0, R.drawable.bg_fast_record_history_item_center_play));
        }
    }
}

package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.upuphone.ar.fastrecord.phone.utils.RecordDateUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "position", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryDetailActivity$initRecordView$1 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryDetailActivity$initRecordView$1(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        super(1);
        this.this$0 = fastRecordHistoryDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) {
        this.this$0.getLayout().k.h.setText(RecordDateUtil.INSTANCE.getDateToString(j, "H:mm:ss"));
    }
}

package com.upuphone.ar.fastrecord.phone.ui.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryDetailActivity$initAsrRequestCallback$1$asrResultEmpty$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $recordId;
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryDetailActivity$initAsrRequestCallback$1$asrResultEmpty$1(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, long j) {
        super(0);
        this.this$0 = fastRecordHistoryDetailActivity;
        this.$recordId = j;
    }

    public final void invoke() {
        this.this$0.showEmptyAsrState();
        this.this$0.getViewModel().setIsEmptyAsrState(this.$recordId);
    }
}

package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryAsrOperator$startSingleAsr$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $pcmPath;
    final /* synthetic */ FastRecordHistoryAsrOperator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryAsrOperator$startSingleAsr$3(FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator, String str) {
        super(0);
        this.this$0 = fastRecordHistoryAsrOperator;
        this.$pcmPath = str;
    }

    public final void invoke() {
        this.this$0.startSendSceneData(this.$pcmPath);
    }
}

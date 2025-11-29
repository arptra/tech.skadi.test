package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.utils.RecordConstants;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.Src;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryAsrOperator$initTwoSocketAsr$1$onRemoteAsrResult$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AsrResult $asrResult;
    final /* synthetic */ FastRecordHistoryAsrOperator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryAsrOperator$initTwoSocketAsr$1$onRemoteAsrResult$1(FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator, AsrResult asrResult) {
        super(0);
        this.this$0 = fastRecordHistoryAsrOperator;
        this.$asrResult = asrResult;
    }

    public final void invoke() {
        String str;
        FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator = this.this$0;
        Src src = this.$asrResult.getSrc();
        if (src == null || (str = src.getContent()) == null) {
            str = "";
        }
        Src src2 = this.$asrResult.getSrc();
        long startTime = src2 != null ? src2.getStartTime() : 0;
        Src src3 = this.$asrResult.getSrc();
        fastRecordHistoryAsrOperator.savePhoneTypeVoiceWord(str, startTime, src3 != null ? src3.getEndTime() : 0, RecordConstants.SCENE_PHONE_MY_SELF, this.$asrResult.getExt());
    }
}

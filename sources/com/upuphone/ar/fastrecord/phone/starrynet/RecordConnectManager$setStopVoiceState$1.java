package com.upuphone.ar.fastrecord.phone.starrynet;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class RecordConnectManager$setStopVoiceState$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $recordId;
    final /* synthetic */ int $type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordConnectManager$setStopVoiceState$1(long j, int i) {
        super(0);
        this.$recordId = j;
        this.$type = i;
    }

    public final void invoke() {
        long j = this.$recordId;
        int i = this.$type;
        LogExt.logE("setStopVoiceState  updateUiState recordId = " + j + " ,type = " + i, "FastRecordInterConnectHelper");
        FastRecordManager.Companion.getInstance().appViewModel().updateStartRecordDetailIng(new RecordGlassStatus(this.$type, 2, this.$recordId));
    }
}

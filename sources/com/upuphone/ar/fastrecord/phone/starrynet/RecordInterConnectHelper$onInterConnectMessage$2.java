package com.upuphone.ar.fastrecord.phone.starrynet;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class RecordInterConnectHelper$onInterConnectMessage$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RecordGlassStatus $mRecordGlassStatus;
    final /* synthetic */ RecordInterConnectHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordInterConnectHelper$onInterConnectMessage$2(RecordGlassStatus recordGlassStatus, RecordInterConnectHelper recordInterConnectHelper) {
        super(0);
        this.$mRecordGlassStatus = recordGlassStatus;
        this.this$0 = recordInterConnectHelper;
    }

    public final void invoke() {
        RecordGlassStatus recordGlassStatus = this.$mRecordGlassStatus;
        LogExt.logE("stopRecordVoice  updateUiState mRecordGlassStatus = " + recordGlassStatus, "FastRecordInterConnectHelper");
        RecordInterConnectHelper recordInterConnectHelper = this.this$0;
        RecordGlassStatus recordGlassStatus2 = this.$mRecordGlassStatus;
        Intrinsics.checkNotNullExpressionValue(recordGlassStatus2, "$mRecordGlassStatus");
        recordInterConnectHelper.updateState(recordGlassStatus2);
    }
}

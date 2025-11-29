package com.upuphone.ar.fastrecord.phone.starrynet;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class RecordInterConnectHelper$onInterConnectMessage$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ RecordGlassStatus $mRecordGlassStatus;
    final /* synthetic */ RecordInterConnectHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordInterConnectHelper$onInterConnectMessage$1(RecordGlassStatus recordGlassStatus, RecordInterConnectHelper recordInterConnectHelper) {
        super(1);
        this.$mRecordGlassStatus = recordGlassStatus;
        this.this$0 = recordInterConnectHelper;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        LogExt.logW("start rec last result state = " + i, "FastRecordInterConnectHelper");
        this.$mRecordGlassStatus.setState(i);
        RecordInterConnectHelper recordInterConnectHelper = this.this$0;
        RecordGlassStatus recordGlassStatus = this.$mRecordGlassStatus;
        Intrinsics.checkNotNullExpressionValue(recordGlassStatus, "$mRecordGlassStatus");
        recordInterConnectHelper.updateState(recordGlassStatus);
    }
}

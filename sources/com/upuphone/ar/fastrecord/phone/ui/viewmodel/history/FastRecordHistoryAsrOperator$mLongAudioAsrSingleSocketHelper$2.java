package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.utils.RecordConstants;
import com.xjsd.xr.sapp.asr.UnifiedAsrHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryAsrOperator$mLongAudioAsrSingleSocketHelper$2 extends Lambda implements Function0<UnifiedAsrHelper> {
    public static final FastRecordHistoryAsrOperator$mLongAudioAsrSingleSocketHelper$2 INSTANCE = new FastRecordHistoryAsrOperator$mLongAudioAsrSingleSocketHelper$2();

    public FastRecordHistoryAsrOperator$mLongAudioAsrSingleSocketHelper$2() {
        super(0);
    }

    @NotNull
    public final UnifiedAsrHelper invoke() {
        return new UnifiedAsrHelper(RecordConstants.APP_NAME, false, 2, (DefaultConstructorMarker) null);
    }
}

package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "notEmptyData", "", "Lcom/upuphone/ar/fastrecord/phone/db/RecordVoiceWordEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordDetailRecordHistoryViewModel$getAllRecordVoiceWord$1$2$1 extends Lambda implements Function1<List<? extends RecordVoiceWordEntity>, Unit> {
    final /* synthetic */ long $recordId;
    final /* synthetic */ StringBuffer $stringBuffer;
    final /* synthetic */ FastRecordDetailRecordHistoryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDetailRecordHistoryViewModel$getAllRecordVoiceWord$1$2$1(FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel, long j, StringBuffer stringBuffer) {
        super(1);
        this.this$0 = fastRecordDetailRecordHistoryViewModel;
        this.$recordId = j;
        this.$stringBuffer = stringBuffer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<RecordVoiceWordEntity>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull List<RecordVoiceWordEntity> list) {
        Intrinsics.checkNotNullParameter(list, "notEmptyData");
        this.this$0.checkWordInfoState(this.$recordId, this.$stringBuffer, list);
    }
}

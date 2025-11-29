package com.upuphone.ar.transcribe.phone.activity;

import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.helper.TranscribeDBHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment$initViews$2", "Lcom/upuphone/ar/transcribe/phone/helper/TranscribeDBHelper$RecordChangeListener;", "notifyRecordAdd", "", "transcribeBean", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "notifyRecordDelete", "notifyRecordUpdate", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranscribeRecordFragment$initViews$2 implements TranscribeDBHelper.RecordChangeListener {
    final /* synthetic */ TranscribeRecordFragment this$0;

    public TranscribeRecordFragment$initViews$2(TranscribeRecordFragment transcribeRecordFragment) {
        this.this$0 = transcribeRecordFragment;
    }

    public void notifyRecordAdd(@NotNull TranscribeBean transcribeBean) {
        Intrinsics.checkNotNullParameter(transcribeBean, "transcribeBean");
        this.this$0.addRecords(transcribeBean);
    }

    public void notifyRecordDelete(@NotNull TranscribeBean transcribeBean) {
        Intrinsics.checkNotNullParameter(transcribeBean, "transcribeBean");
        this.this$0.deleteRecord(transcribeBean);
    }

    public void notifyRecordUpdate(@NotNull TranscribeBean transcribeBean) {
        Intrinsics.checkNotNullParameter(transcribeBean, "transcribeBean");
        this.this$0.updateRecord(transcribeBean);
    }
}

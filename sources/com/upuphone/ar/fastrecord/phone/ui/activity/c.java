package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.widget.TextView;
import com.upuphone.ar.fastrecord.phone.db.RecordContentHistoryTagEntity;
import com.upuphone.ar.fastrecord.phone.ui.widget.labels.RecordDetailHistoryTagView;

public final /* synthetic */ class c implements RecordDetailHistoryTagView.LabelTextProvider {
    public final CharSequence getLabelText(TextView textView, int i, Object obj) {
        return FastRecordTagScheduleDialog$initViewModel$3.invoke$lambda$1$lambda$0(textView, i, (RecordContentHistoryTagEntity) obj);
    }
}

package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.widget.TextView;
import com.upuphone.ar.fastrecord.phone.db.RecordContentTagEntity;
import com.upuphone.ar.fastrecord.phone.ui.widget.labels.RecordDetailInputTagView;

public final /* synthetic */ class d implements RecordDetailInputTagView.LabelTextProvider {
    public final CharSequence getLabelText(TextView textView, int i, Object obj) {
        return FastRecordTagScheduleDialog$initViewModel$4.invoke$lambda$1$lambda$0(textView, i, (RecordContentTagEntity) obj);
    }
}

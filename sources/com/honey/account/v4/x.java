package com.honey.account.v4;

import android.content.DialogInterface;
import android.widget.EditText;
import com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment;
import com.upuphone.ar.transcribe.phone.bean.ListItemBean;

public final /* synthetic */ class x implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f5279a;
    public final /* synthetic */ TranscribeRecordFragment b;
    public final /* synthetic */ ListItemBean c;

    public /* synthetic */ x(EditText editText, TranscribeRecordFragment transcribeRecordFragment, ListItemBean listItemBean) {
        this.f5279a = editText;
        this.b = transcribeRecordFragment;
        this.c = listItemBean;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranscribeRecordFragment.showRenameDialog$lambda$12(this.f5279a, this.b, this.c, dialogInterface, i);
    }
}

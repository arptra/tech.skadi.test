package com.honey.account.v4;

import android.view.View;
import android.widget.EditText;
import com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment;

public final /* synthetic */ class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f5277a;

    public /* synthetic */ v(EditText editText) {
        this.f5277a = editText;
    }

    public final void onClick(View view) {
        TranscribeRecordFragment.showRenameDialog$lambda$10(this.f5277a, view);
    }
}

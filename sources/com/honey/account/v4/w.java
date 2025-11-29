package com.honey.account.v4;

import android.view.View;
import android.widget.EditText;
import com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment;

public final /* synthetic */ class w implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f5278a;

    public /* synthetic */ w(EditText editText) {
        this.f5278a = editText;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        TranscribeRecordFragment.showRenameDialog$lambda$11(this.f5278a, view, i, i2, i3, i4, i5, i6, i7, i8);
    }
}

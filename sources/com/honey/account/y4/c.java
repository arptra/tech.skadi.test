package com.honey.account.y4;

import android.view.View;
import com.upuphone.ar.transcribe.phone.view.ClipboardEditText;

public final /* synthetic */ class c implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClipboardEditText f5312a;

    public /* synthetic */ c(ClipboardEditText clipboardEditText) {
        this.f5312a = clipboardEditText;
    }

    public final boolean onLongClick(View view) {
        return ClipboardEditText.o(this.f5312a, view);
    }
}

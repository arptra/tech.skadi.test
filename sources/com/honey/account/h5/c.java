package com.honey.account.h5;

import android.view.View;
import com.upuphone.ar.translation.phone.view.ClipboardEditText;

public final /* synthetic */ class c implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClipboardEditText f4510a;

    public /* synthetic */ c(ClipboardEditText clipboardEditText) {
        this.f4510a = clipboardEditText;
    }

    public final boolean onLongClick(View view) {
        return ClipboardEditText.o(this.f4510a, view);
    }
}

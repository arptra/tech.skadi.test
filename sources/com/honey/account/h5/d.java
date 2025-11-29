package com.honey.account.h5;

import android.view.View;
import com.upuphone.ar.translation.phone.view.ClipboardEditText;

public final /* synthetic */ class d implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClipboardEditText f4511a;

    public /* synthetic */ d(ClipboardEditText clipboardEditText) {
        this.f4511a = clipboardEditText;
    }

    public final void onFocusChange(View view, boolean z) {
        ClipboardEditText.p(this.f4511a, view, z);
    }
}

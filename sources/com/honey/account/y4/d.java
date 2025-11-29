package com.honey.account.y4;

import android.view.View;
import com.upuphone.ar.transcribe.phone.view.ClipboardEditText;

public final /* synthetic */ class d implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClipboardEditText f5313a;

    public /* synthetic */ d(ClipboardEditText clipboardEditText) {
        this.f5313a = clipboardEditText;
    }

    public final void onFocusChange(View view, boolean z) {
        ClipboardEditText.p(this.f5313a, view, z);
    }
}

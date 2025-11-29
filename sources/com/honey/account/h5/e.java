package com.honey.account.h5;

import android.content.ClipboardManager;
import com.upuphone.ar.translation.phone.view.ClipboardEditText;

public final /* synthetic */ class e implements ClipboardManager.OnPrimaryClipChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClipboardEditText f4512a;
    public final /* synthetic */ ClipboardManager b;

    public /* synthetic */ e(ClipboardEditText clipboardEditText, ClipboardManager clipboardManager) {
        this.f4512a = clipboardEditText;
        this.b = clipboardManager;
    }

    public final void onPrimaryClipChanged() {
        ClipboardEditText.g(this.f4512a, this.b);
    }
}

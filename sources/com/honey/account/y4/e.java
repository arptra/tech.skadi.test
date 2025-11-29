package com.honey.account.y4;

import android.content.ClipboardManager;
import com.upuphone.ar.transcribe.phone.view.ClipboardEditText;

public final /* synthetic */ class e implements ClipboardManager.OnPrimaryClipChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClipboardEditText f5314a;
    public final /* synthetic */ ClipboardManager b;

    public /* synthetic */ e(ClipboardEditText clipboardEditText, ClipboardManager clipboardManager) {
        this.f5314a = clipboardEditText;
        this.b = clipboardManager;
    }

    public final void onPrimaryClipChanged() {
        ClipboardEditText.f(this.f5314a, this.b);
    }
}

package com.geetest.captcha;

import android.content.DialogInterface;
import android.view.KeyEvent;

public final class e implements DialogInterface.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f2851a;

    public e(z zVar) {
        this.f2851a = zVar;
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent == null || keyEvent.getRepeatCount() != 0 || keyEvent.getAction() != 1) {
            return false;
        }
        this.f2851a.b();
        return false;
    }
}

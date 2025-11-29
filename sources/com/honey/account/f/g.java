package com.honey.account.f;

import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.view.KeyEventDispatcher;

public final /* synthetic */ class g implements KeyEventDispatcher.Component {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppCompatDialog f3050a;

    public /* synthetic */ g(AppCompatDialog appCompatDialog) {
        this.f3050a = appCompatDialog;
    }

    public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.f3050a.superDispatchKeyEvent(keyEvent);
    }
}

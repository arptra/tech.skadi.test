package com.honey.account.b9;

import android.view.KeyEvent;
import android.widget.TextView;
import com.upuphone.xr.sapp.vu.VuInputDialog;

public final /* synthetic */ class t implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuInputDialog f7143a;

    public /* synthetic */ t(VuInputDialog vuInputDialog) {
        this.f7143a = vuInputDialog;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return VuInputDialog.c(this.f7143a, textView, i, keyEvent);
    }
}

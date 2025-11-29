package com.honey.account.d4;

import android.view.KeyEvent;
import android.widget.TextView;
import com.upuphone.ar.navi.lite.AddressSettingActivity;

public final /* synthetic */ class l implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddressSettingActivity f4264a;

    public /* synthetic */ l(AddressSettingActivity addressSettingActivity) {
        this.f4264a = addressSettingActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return this.f4264a.G1(textView, i, keyEvent);
    }
}

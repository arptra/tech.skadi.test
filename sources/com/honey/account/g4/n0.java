package com.honey.account.g4;

import android.view.KeyEvent;
import android.widget.TextView;
import com.upuphone.ar.navi.lite.fragment.SearchFragment;

public final /* synthetic */ class n0 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchFragment f4449a;

    public /* synthetic */ n0(SearchFragment searchFragment) {
        this.f4449a = searchFragment;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return this.f4449a.p3(textView, i, keyEvent);
    }
}

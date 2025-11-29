package com.honey.account.o4;

import android.view.KeyEvent;
import android.widget.TextView;
import com.upuphone.ar.navi.lite.view.NaviTopView;

public final /* synthetic */ class q implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NaviTopView f4983a;

    public /* synthetic */ q(NaviTopView naviTopView) {
        this.f4983a = naviTopView;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return this.f4983a.w(textView, i, keyEvent);
    }
}

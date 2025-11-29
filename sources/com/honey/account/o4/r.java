package com.honey.account.o4;

import android.view.KeyEvent;
import android.widget.TextView;
import com.upuphone.ar.navi.lite.view.NaviTopView;

public final /* synthetic */ class r implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NaviTopView f4984a;

    public /* synthetic */ r(NaviTopView naviTopView) {
        this.f4984a = naviTopView;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return this.f4984a.x(textView, i, keyEvent);
    }
}

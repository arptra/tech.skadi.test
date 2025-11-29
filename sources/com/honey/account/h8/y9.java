package com.honey.account.h8;

import android.view.View;
import com.meizu.common.widget.CircularProgressButton;
import com.upuphone.xr.sapp.fragment.TouchpadFragment;

public final /* synthetic */ class y9 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TouchpadFragment f4824a;
    public final /* synthetic */ CircularProgressButton b;

    public /* synthetic */ y9(TouchpadFragment touchpadFragment, CircularProgressButton circularProgressButton) {
        this.f4824a = touchpadFragment;
        this.b = circularProgressButton;
    }

    public final void onClick(View view) {
        TouchpadFragment.b1(this.f4824a, this.b, view);
    }
}

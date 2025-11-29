package com.honey.account.h8;

import android.view.View;
import com.upuphone.xr.sapp.entity.H5Info;
import com.upuphone.xr.sapp.fragment.H5Fragment;

public final /* synthetic */ class r4 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5Info f4742a;
    public final /* synthetic */ H5Fragment b;

    public /* synthetic */ r4(H5Info h5Info, H5Fragment h5Fragment) {
        this.f4742a = h5Info;
        this.b = h5Fragment;
    }

    public final void onClick(View view) {
        H5Fragment.M0(this.f4742a, this.b, view);
    }
}

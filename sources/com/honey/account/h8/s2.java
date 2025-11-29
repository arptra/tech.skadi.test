package com.honey.account.h8;

import com.upuphone.xr.sapp.fragment.FeedBackFragment;
import com.upuphone.xr.sapp.view.CustomTimePicker;
import com.upuphone.xr.sapp.view.CustomTimePickerDialog;

public final /* synthetic */ class s2 implements CustomTimePickerDialog.OnTimeSetListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedBackFragment f4751a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ s2(FeedBackFragment feedBackFragment, int i, int i2, int i3) {
        this.f4751a = feedBackFragment;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public final void a(CustomTimePicker customTimePicker, int i, int i2) {
        FeedBackFragment.s1(this.f4751a, this.b, this.c, this.d, customTimePicker, i, i2);
    }
}

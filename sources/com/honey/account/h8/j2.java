package com.honey.account.h8;

import com.upuphone.xr.sapp.fragment.FeedBackFragment;
import com.upuphone.xr.sapp.view.CustomTimePicker;
import com.upuphone.xr.sapp.view.CustomTimePickerDialog;
import java.util.Calendar;

public final /* synthetic */ class j2 implements CustomTimePicker.OnTimeChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Calendar f4645a;
    public final /* synthetic */ CustomTimePickerDialog b;

    public /* synthetic */ j2(Calendar calendar, CustomTimePickerDialog customTimePickerDialog) {
        this.f4645a = calendar;
        this.b = customTimePickerDialog;
    }

    public final void a(CustomTimePicker customTimePicker, int i, int i2) {
        FeedBackFragment.t1(this.f4645a, this.b, customTimePicker, i, i2);
    }
}

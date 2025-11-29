package com.honey.account.h8;

import com.meizu.common.widget.DatePicker;
import com.meizu.common.widget.DatePickerDialog;
import com.upuphone.xr.sapp.fragment.FeedBackFragment;
import java.util.Calendar;

public final /* synthetic */ class r2 implements DatePickerDialog.OnDateSetListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedBackFragment f4740a;
    public final /* synthetic */ Calendar b;

    public /* synthetic */ r2(FeedBackFragment feedBackFragment, Calendar calendar) {
        this.f4740a = feedBackFragment;
        this.b = calendar;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        FeedBackFragment.r1(this.f4740a, this.b, datePicker, i, i2, i3);
    }
}

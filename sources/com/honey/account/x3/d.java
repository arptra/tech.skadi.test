package com.honey.account.x3;

import android.widget.EditText;
import com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordSummaryFragment;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f5296a;
    public final /* synthetic */ FastRecordSummaryFragment b;

    public /* synthetic */ d(EditText editText, FastRecordSummaryFragment fastRecordSummaryFragment) {
        this.f5296a = editText;
        this.b = fastRecordSummaryFragment;
    }

    public final void run() {
        FastRecordSummaryFragment.requestSoftInput$lambda$8(this.f5296a, this.b);
    }
}

package com.honey.account.f5;

import com.upuphone.ar.translation.phone.bean.IntelExtnSummary;
import com.upuphone.ar.translation.phone.fragment.SummaryFragment;

public final /* synthetic */ class g0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SummaryFragment f4381a;
    public final /* synthetic */ IntelExtnSummary b;

    public /* synthetic */ g0(SummaryFragment summaryFragment, IntelExtnSummary intelExtnSummary) {
        this.f4381a = summaryFragment;
        this.b = intelExtnSummary;
    }

    public final void run() {
        SummaryFragment.B0(this.f4381a, this.b);
    }
}

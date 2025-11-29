package com.honey.account.h8;

import android.widget.RadioGroup;
import com.upuphone.xr.sapp.fragment.OpinionFeedbackFragment;

public final /* synthetic */ class m7 implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OpinionFeedbackFragment f4687a;

    public /* synthetic */ m7(OpinionFeedbackFragment opinionFeedbackFragment) {
        this.f4687a = opinionFeedbackFragment;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        OpinionFeedbackFragment.Q0(this.f4687a, radioGroup, i);
    }
}

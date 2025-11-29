package com.honey.account.h8;

import android.widget.CompoundButton;
import com.upuphone.xr.sapp.fragment.WakeupRecordMainFragment;

public final /* synthetic */ class db implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WakeupRecordMainFragment f4577a;

    public /* synthetic */ db(WakeupRecordMainFragment wakeupRecordMainFragment) {
        this.f4577a = wakeupRecordMainFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        WakeupRecordMainFragment.O0(this.f4577a, compoundButton, z);
    }
}

package com.honey.account.h8;

import com.meizu.common.fastscrollletter.FastScrollLetter;
import com.upuphone.xr.sapp.fragment.PhoneNotifyFragment;

public final /* synthetic */ class m8 implements FastScrollLetter.FastScrollLetterCallBack {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PhoneNotifyFragment f4688a;

    public /* synthetic */ m8(PhoneNotifyFragment phoneNotifyFragment) {
        this.f4688a = phoneNotifyFragment;
    }

    public final int calculatePositionOffset(int i, int i2) {
        return PhoneNotifyFragment.d1(this.f4688a, i, i2);
    }
}

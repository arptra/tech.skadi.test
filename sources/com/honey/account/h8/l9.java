package com.honey.account.h8;

import android.content.DialogInterface;
import com.upuphone.xr.sapp.fragment.StandbyPositionFragment;
import java.util.LinkedHashMap;

public final /* synthetic */ class l9 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StandbyPositionFragment f4677a;
    public final /* synthetic */ LinkedHashMap b;

    public /* synthetic */ l9(StandbyPositionFragment standbyPositionFragment, LinkedHashMap linkedHashMap) {
        this.f4677a = standbyPositionFragment;
        this.b = linkedHashMap;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        StandbyPositionFragment.C1(this.f4677a, this.b, dialogInterface, i);
    }
}

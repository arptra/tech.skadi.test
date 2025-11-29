package com.honey.account.h8;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.upuphone.xr.sapp.fragment.VoiceprintSrInfoFragment;

public final /* synthetic */ class pa implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f4725a;

    public /* synthetic */ pa(FragmentActivity fragmentActivity) {
        this.f4725a = fragmentActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        VoiceprintSrInfoFragment.U0(this.f4725a, dialogInterface, i);
    }
}

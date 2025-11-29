package com.honey.account.o9;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.xjmz.myvu.account.AccountManager;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f7473a;

    public /* synthetic */ a(FragmentActivity fragmentActivity) {
        this.f7473a = fragmentActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AccountManager.z(this.f7473a, dialogInterface, i);
    }
}

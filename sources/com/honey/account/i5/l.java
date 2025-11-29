package com.honey.account.i5;

import android.app.Activity;
import android.content.DialogInterface;
import com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel;

public final /* synthetic */ class l implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f4849a;

    public /* synthetic */ l(Activity activity) {
        this.f4849a = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranslatorRecordViewModel.W(this.f4849a, dialogInterface, i);
    }
}

package com.honey.account.u3;

import android.content.DialogInterface;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordMainActivity;

public final /* synthetic */ class j0 implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordMainActivity f5180a;

    public /* synthetic */ j0(FastRecordMainActivity fastRecordMainActivity) {
        this.f5180a = fastRecordMainActivity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        FastRecordMainActivity.showShareLoadingDialog$lambda$10(this.f5180a, dialogInterface);
    }
}

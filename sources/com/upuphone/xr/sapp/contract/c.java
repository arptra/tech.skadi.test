package com.upuphone.xr.sapp.contract;

import android.widget.CompoundButton;
import com.upuphone.xr.sapp.databinding.DialogAppUserGuideBinding;

public final /* synthetic */ class c implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DialogAppUserGuideBinding f6710a;

    public /* synthetic */ c(DialogAppUserGuideBinding dialogAppUserGuideBinding) {
        this.f6710a = dialogAppUserGuideBinding;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        AppUserGuideDialogController$mUserGuideDialog$2.invoke$lambda$2(this.f6710a, compoundButton, z);
    }
}

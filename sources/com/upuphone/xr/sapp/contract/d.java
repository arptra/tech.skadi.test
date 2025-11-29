package com.upuphone.xr.sapp.contract;

import android.widget.CompoundButton;
import com.upuphone.xr.sapp.databinding.DialogAppUserGuideBinding;

public final /* synthetic */ class d implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DialogAppUserGuideBinding f6711a;

    public /* synthetic */ d(DialogAppUserGuideBinding dialogAppUserGuideBinding) {
        this.f6711a = dialogAppUserGuideBinding;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        AppUserGuideDialogController$mUserGuideDialog$2.invoke$lambda$3(this.f6711a, compoundButton, z);
    }
}

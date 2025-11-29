package com.honey.account.d5;

import android.content.DialogInterface;
import com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity;

public final /* synthetic */ class z implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorSettingActivity f4332a;

    public /* synthetic */ z(TranslatorSettingActivity translatorSettingActivity) {
        this.f4332a = translatorSettingActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranslatorSettingActivity.showLocationReminder$lambda$15(this.f4332a, dialogInterface, i);
    }
}

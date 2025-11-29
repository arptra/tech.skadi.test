package com.honey.account.d5;

import android.content.DialogInterface;
import com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity;

public final /* synthetic */ class a0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorSettingActivity f4303a;

    public /* synthetic */ a0(TranslatorSettingActivity translatorSettingActivity) {
        this.f4303a = translatorSettingActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranslatorSettingActivity.showLocationReminder$lambda$16(this.f4303a, dialogInterface, i);
    }
}

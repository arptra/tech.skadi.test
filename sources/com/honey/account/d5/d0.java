package com.honey.account.d5;

import android.content.DialogInterface;
import com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity;

public final /* synthetic */ class d0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorSettingActivity f4309a;

    public /* synthetic */ d0(TranslatorSettingActivity translatorSettingActivity) {
        this.f4309a = translatorSettingActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranslatorSettingActivity.createCallAudioDialog$lambda$2(this.f4309a, dialogInterface, i);
    }
}

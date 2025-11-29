package com.honey.account.d5;

import android.content.DialogInterface;
import com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity;

public final /* synthetic */ class u implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorSettingActivity f4327a;

    public /* synthetic */ u(TranslatorSettingActivity translatorSettingActivity) {
        this.f4327a = translatorSettingActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranslatorSettingActivity.createBroadcastAudioMyselfDialog$lambda$6(this.f4327a, dialogInterface, i);
    }
}

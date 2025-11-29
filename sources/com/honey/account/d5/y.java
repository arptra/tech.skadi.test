package com.honey.account.d5;

import android.content.DialogInterface;
import com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity;

public final /* synthetic */ class y implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorSettingActivity f4331a;

    public /* synthetic */ y(TranslatorSettingActivity translatorSettingActivity) {
        this.f4331a = translatorSettingActivity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        TranslatorSettingActivity.createBroadcastAudioMyselfDialog$lambda$8(this.f4331a, dialogInterface);
    }
}

package com.honey.account.d5;

import android.content.DialogInterface;
import com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity;

public final /* synthetic */ class f0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorSettingActivity f4312a;

    public /* synthetic */ f0(TranslatorSettingActivity translatorSettingActivity) {
        this.f4312a = translatorSettingActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranslatorSettingActivity.createBroadcastAudioOtherDialog$lambda$11(this.f4312a, dialogInterface, i);
    }
}

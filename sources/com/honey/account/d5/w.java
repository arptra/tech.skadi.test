package com.honey.account.d5;

import android.content.DialogInterface;
import com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity;

public final /* synthetic */ class w implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorSettingActivity f4329a;

    public /* synthetic */ w(TranslatorSettingActivity translatorSettingActivity) {
        this.f4329a = translatorSettingActivity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        TranslatorSettingActivity.createBroadcastAudioOtherDialog$lambda$13(this.f4329a, dialogInterface);
    }
}

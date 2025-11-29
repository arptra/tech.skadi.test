package com.honey.account.d5;

import android.content.DialogInterface;
import com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity;
import com.upuphone.ar.translation.phone.adapter.BroadcastAudioTypeAdapter;

public final /* synthetic */ class v implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BroadcastAudioTypeAdapter f4328a;
    public final /* synthetic */ TranslatorSettingActivity b;

    public /* synthetic */ v(BroadcastAudioTypeAdapter broadcastAudioTypeAdapter, TranslatorSettingActivity translatorSettingActivity) {
        this.f4328a = broadcastAudioTypeAdapter;
        this.b = translatorSettingActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranslatorSettingActivity.createBroadcastAudioOtherDialog$lambda$12(this.f4328a, this.b, dialogInterface, i);
    }
}

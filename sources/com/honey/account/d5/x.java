package com.honey.account.d5;

import android.content.DialogInterface;
import com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity;
import com.upuphone.ar.translation.phone.adapter.BroadcastAudioTypeAdapter;

public final /* synthetic */ class x implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BroadcastAudioTypeAdapter f4330a;
    public final /* synthetic */ TranslatorSettingActivity b;

    public /* synthetic */ x(BroadcastAudioTypeAdapter broadcastAudioTypeAdapter, TranslatorSettingActivity translatorSettingActivity) {
        this.f4330a = broadcastAudioTypeAdapter;
        this.b = translatorSettingActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranslatorSettingActivity.createBroadcastAudioMyselfDialog$lambda$7(this.f4330a, this.b, dialogInterface, i);
    }
}

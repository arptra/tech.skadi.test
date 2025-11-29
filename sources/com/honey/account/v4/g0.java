package com.honey.account.v4;

import android.content.DialogInterface;
import com.upuphone.ar.transcribe.phone.activity.TranscribeSettingActivity;

public final /* synthetic */ class g0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeSettingActivity f5252a;

    public /* synthetic */ g0(TranscribeSettingActivity transcribeSettingActivity) {
        this.f5252a = transcribeSettingActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranscribeSettingActivity.showLocationReminder$lambda$2(this.f5252a, dialogInterface, i);
    }
}

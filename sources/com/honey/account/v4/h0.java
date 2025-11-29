package com.honey.account.v4;

import android.content.DialogInterface;
import com.upuphone.ar.transcribe.phone.activity.TranscribeSettingActivity;

public final /* synthetic */ class h0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeSettingActivity f5254a;

    public /* synthetic */ h0(TranscribeSettingActivity transcribeSettingActivity) {
        this.f5254a = transcribeSettingActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranscribeSettingActivity.showLocationReminder$lambda$3(this.f5254a, dialogInterface, i);
    }
}

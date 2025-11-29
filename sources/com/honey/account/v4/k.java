package com.honey.account.v4;

import android.content.DialogInterface;
import com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity;

public final /* synthetic */ class k implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeDetailActivity f5258a;

    public /* synthetic */ k(TranscribeDetailActivity transcribeDetailActivity) {
        this.f5258a = transcribeDetailActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranscribeDetailActivity.showRecordEditedDialog$lambda$12(this.f5258a, dialogInterface, i);
    }
}

package com.honey.account.v4;

import android.content.DialogInterface;
import com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity;

public final /* synthetic */ class n implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeDetailActivity f5263a;

    public /* synthetic */ n(TranscribeDetailActivity transcribeDetailActivity) {
        this.f5263a = transcribeDetailActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranscribeDetailActivity.deleteData$lambda$4(this.f5263a, dialogInterface, i);
    }
}

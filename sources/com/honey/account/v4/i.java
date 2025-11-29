package com.honey.account.v4;

import android.content.DialogInterface;
import com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity;

public final /* synthetic */ class i implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeDetailActivity f5255a;

    public /* synthetic */ i(TranscribeDetailActivity transcribeDetailActivity) {
        this.f5255a = transcribeDetailActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranscribeDetailActivity.shareRecord$lambda$8(this.f5255a, dialogInterface, i);
    }
}

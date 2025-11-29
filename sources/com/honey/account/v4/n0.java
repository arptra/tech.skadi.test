package com.honey.account.v4;

import android.content.DialogInterface;
import com.upuphone.ar.transcribe.phone.activity.TranscribeStartActivity;

public final /* synthetic */ class n0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeStartActivity f5264a;

    public /* synthetic */ n0(TranscribeStartActivity transcribeStartActivity) {
        this.f5264a = transcribeStartActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranscribeStartActivity.showDeleteDialog$lambda$16(this.f5264a, dialogInterface, i);
    }
}

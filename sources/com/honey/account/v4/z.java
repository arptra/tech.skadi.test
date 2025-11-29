package com.honey.account.v4;

import android.content.DialogInterface;
import com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment;

public final /* synthetic */ class z implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeRecordFragment f5280a;

    public /* synthetic */ z(TranscribeRecordFragment transcribeRecordFragment) {
        this.f5280a = transcribeRecordFragment;
    }

    public final void onShow(DialogInterface dialogInterface) {
        TranscribeRecordFragment.showRenameDialog$lambda$14(this.f5280a, dialogInterface);
    }
}

package com.honey.account.x4;

import android.content.Context;
import android.content.DialogInterface;
import com.upuphone.ar.transcribe.phone.helper.MuteAudioHelper;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f5305a;

    public /* synthetic */ a(Context context) {
        this.f5305a = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        MuteAudioHelper.g(this.f5305a, dialogInterface, i);
    }
}

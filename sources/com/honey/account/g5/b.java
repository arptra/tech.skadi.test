package com.honey.account.g5;

import android.content.DialogInterface;
import androidx.appcompat.app.AppCompatActivity;
import com.upuphone.ar.translation.phone.helper.MuteAudioHelper;

public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppCompatActivity f4464a;

    public /* synthetic */ b(AppCompatActivity appCompatActivity) {
        this.f4464a = appCompatActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        MuteAudioHelper.g(this.f4464a, dialogInterface, i);
    }
}

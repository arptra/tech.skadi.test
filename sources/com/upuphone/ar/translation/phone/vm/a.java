package com.upuphone.ar.translation.phone.vm;

import android.content.DialogInterface;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorMainViewModel f6345a;

    public /* synthetic */ a(TranslatorMainViewModel translatorMainViewModel) {
        this.f6345a = translatorMainViewModel;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranslatorMainViewModel$showRecordDeleteDialog$1.invokeSuspend$lambda$0(this.f6345a, dialogInterface, i);
    }
}

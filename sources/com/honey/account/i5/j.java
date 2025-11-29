package com.honey.account.i5;

import android.app.Activity;
import android.content.DialogInterface;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel;

public final /* synthetic */ class j implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorRecordViewModel f4848a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ NoteBean c;

    public /* synthetic */ j(TranslatorRecordViewModel translatorRecordViewModel, Activity activity, NoteBean noteBean) {
        this.f4848a = translatorRecordViewModel;
        this.b = activity;
        this.c = noteBean;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranslatorRecordViewModel.q(this.f4848a, this.b, this.c, dialogInterface, i);
    }
}

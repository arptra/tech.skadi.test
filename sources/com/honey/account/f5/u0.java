package com.honey.account.f5;

import android.content.DialogInterface;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.databinding.AlertDialogInputSingleTextBinding;
import com.upuphone.ar.translation.phone.fragment.TransRecordFragment;

public final /* synthetic */ class u0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NoteBean f4409a;
    public final /* synthetic */ TransRecordFragment b;
    public final /* synthetic */ AlertDialogInputSingleTextBinding c;

    public /* synthetic */ u0(NoteBean noteBean, TransRecordFragment transRecordFragment, AlertDialogInputSingleTextBinding alertDialogInputSingleTextBinding) {
        this.f4409a = noteBean;
        this.b = transRecordFragment;
        this.c = alertDialogInputSingleTextBinding;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TransRecordFragment.I0(this.f4409a, this.b, this.c, dialogInterface, i);
    }
}

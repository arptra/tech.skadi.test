package com.honey.account.f5;

import android.content.DialogInterface;
import com.upuphone.ar.translation.phone.fragment.DialogueTranslationFragment;

public final /* synthetic */ class q implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DialogueTranslationFragment f4400a;

    public /* synthetic */ q(DialogueTranslationFragment dialogueTranslationFragment) {
        this.f4400a = dialogueTranslationFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DialogueTranslationFragment.D1(this.f4400a, dialogInterface, i);
    }
}

package com.honey.account.f5;

import com.upuphone.ar.translation.phone.bean.TranslationLanguage;
import com.upuphone.ar.translation.phone.fragment.DialogueTranslationFragment;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslationLanguage f4396a;
    public final /* synthetic */ DialogueTranslationFragment b;

    public /* synthetic */ o(TranslationLanguage translationLanguage, DialogueTranslationFragment dialogueTranslationFragment) {
        this.f4396a = translationLanguage;
        this.b = dialogueTranslationFragment;
    }

    public final void run() {
        DialogueTranslationFragment.N1(this.f4396a, this.b);
    }
}

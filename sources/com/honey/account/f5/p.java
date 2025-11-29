package com.honey.account.f5;

import com.upuphone.ar.translation.phone.bean.TranslationLanguage;
import com.upuphone.ar.translation.phone.fragment.DialogueTranslationFragment;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslationLanguage f4398a;
    public final /* synthetic */ DialogueTranslationFragment b;

    public /* synthetic */ p(TranslationLanguage translationLanguage, DialogueTranslationFragment dialogueTranslationFragment) {
        this.f4398a = translationLanguage;
        this.b = dialogueTranslationFragment;
    }

    public final void run() {
        DialogueTranslationFragment.O1(this.f4398a, this.b);
    }
}

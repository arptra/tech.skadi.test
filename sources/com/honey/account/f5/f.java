package com.honey.account.f5;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.upuphone.ar.translation.phone.fragment.DialogueTranslationFragment;

public final /* synthetic */ class f implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f4380a;

    public /* synthetic */ f(FragmentActivity fragmentActivity) {
        this.f4380a = fragmentActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DialogueTranslationFragment.u1(this.f4380a, dialogInterface, i);
    }
}

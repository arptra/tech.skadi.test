package com.honey.account.f5;

import android.content.DialogInterface;
import com.upuphone.ar.translation.phone.fragment.SpeechTranscribeFragment;

public final /* synthetic */ class d0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SpeechTranscribeFragment f4379a;

    public /* synthetic */ d0(SpeechTranscribeFragment speechTranscribeFragment) {
        this.f4379a = speechTranscribeFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SpeechTranscribeFragment.a1(this.f4379a, dialogInterface, i);
    }
}

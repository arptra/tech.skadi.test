package com.honey.account.i5;

import android.media.MediaPlayer;
import com.upuphone.ar.translation.phone.vm.TranslatorSettingsViewModel;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class o implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f4851a;

    public /* synthetic */ o(Function0 function0) {
        this.f4851a = function0;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        TranslatorSettingsViewModel.q(this.f4851a, mediaPlayer);
    }
}

package com.honey.account.i5;

import android.media.MediaPlayer;
import com.upuphone.ar.translation.phone.vm.DialogueTranslationViewModel;

public final /* synthetic */ class c implements MediaPlayer.OnPreparedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaPlayer f4844a;

    public /* synthetic */ c(MediaPlayer mediaPlayer) {
        this.f4844a = mediaPlayer;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        DialogueTranslationViewModel.Q(this.f4844a, mediaPlayer);
    }
}

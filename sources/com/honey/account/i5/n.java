package com.honey.account.i5;

import android.media.MediaPlayer;
import com.upuphone.ar.translation.phone.vm.TranslatorSettingsViewModel;

public final /* synthetic */ class n implements MediaPlayer.OnPreparedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaPlayer f4850a;

    public /* synthetic */ n(MediaPlayer mediaPlayer) {
        this.f4850a = mediaPlayer;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        TranslatorSettingsViewModel.p(this.f4850a, mediaPlayer);
    }
}

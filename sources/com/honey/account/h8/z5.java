package com.honey.account.h8;

import android.media.MediaPlayer;
import com.upuphone.xr.sapp.fragment.MediaFragment;

public final /* synthetic */ class z5 implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaFragment f4832a;

    public /* synthetic */ z5(MediaFragment mediaFragment) {
        this.f4832a = mediaFragment;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        MediaFragment.I0(this.f4832a, mediaPlayer);
    }
}

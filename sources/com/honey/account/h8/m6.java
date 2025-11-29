package com.honey.account.h8;

import android.media.MediaPlayer;
import com.upuphone.xr.sapp.fragment.MediaShowListFragment;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class m6 implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f4686a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ Ref.ObjectRef c;

    public /* synthetic */ m6(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3) {
        this.f4686a = objectRef;
        this.b = objectRef2;
        this.c = objectRef3;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        MediaShowListFragment.MediaShowAdapter.j(this.f4686a, this.b, this.c, mediaPlayer);
    }
}

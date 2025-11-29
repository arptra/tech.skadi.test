package com.ucar.vehiclesdk.player;

import android.media.MediaCodec;
import com.ucar.vehiclesdk.player.VideoPlayerV2;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoPlayerV2.AnonymousClass1 f5478a;
    public final /* synthetic */ MediaCodec b;
    public final /* synthetic */ int c;

    public /* synthetic */ c(VideoPlayerV2.AnonymousClass1 r1, MediaCodec mediaCodec, int i) {
        this.f5478a = r1;
        this.b = mediaCodec;
        this.c = i;
    }

    public final void run() {
        this.f5478a.b(this.b, this.c);
    }
}

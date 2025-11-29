package com.honey.account.k3;

import com.ucar.vehiclesdk.UCarCommon;
import com.ucar.vehiclesdk.player.AudioPlayerMgr;
import java.nio.ByteBuffer;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioPlayerMgr f4897a;
    public final /* synthetic */ UCarCommon.AudioType b;
    public final /* synthetic */ ByteBuffer c;

    public /* synthetic */ b(AudioPlayerMgr audioPlayerMgr, UCarCommon.AudioType audioType, ByteBuffer byteBuffer) {
        this.f4897a = audioPlayerMgr;
        this.b = audioType;
        this.c = byteBuffer;
    }

    public final void run() {
        this.f4897a.E(this.b, this.c);
    }
}

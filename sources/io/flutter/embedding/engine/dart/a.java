package io.flutter.embedding.engine.dart;

import io.flutter.embedding.engine.dart.DartMessenger;
import java.nio.ByteBuffer;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DartMessenger f8797a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ DartMessenger.HandlerInfo d;
    public final /* synthetic */ ByteBuffer e;
    public final /* synthetic */ long f;

    public /* synthetic */ a(DartMessenger dartMessenger, String str, int i, DartMessenger.HandlerInfo handlerInfo, ByteBuffer byteBuffer, long j) {
        this.f8797a = dartMessenger;
        this.b = str;
        this.c = i;
        this.d = handlerInfo;
        this.e = byteBuffer;
        this.f = j;
    }

    public final void run() {
        this.f8797a.lambda$dispatchMessageToQueue$0(this.b, this.c, this.d, this.e, this.f);
    }
}

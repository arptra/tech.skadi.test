package io.flutter.embedding.engine.dart;

import io.flutter.embedding.engine.dart.DartMessenger;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DartMessenger.SerialTaskQueue f8798a;

    public /* synthetic */ b(DartMessenger.SerialTaskQueue serialTaskQueue) {
        this.f8798a = serialTaskQueue;
    }

    public final void run() {
        this.f8798a.lambda$dispatch$0();
    }
}

package io.flutter.embedding.engine.dart;

import io.flutter.embedding.engine.dart.DartMessenger;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DartMessenger.SerialTaskQueue f8799a;

    public /* synthetic */ c(DartMessenger.SerialTaskQueue serialTaskQueue) {
        this.f8799a = serialTaskQueue;
    }

    public final void run() {
        this.f8799a.lambda$flush$1();
    }
}

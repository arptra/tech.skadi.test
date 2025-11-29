package com.honey.account.wa;

import android.view.KeyEvent;
import io.flutter.embedding.android.KeyEmbedderResponder;
import io.flutter.embedding.android.KeyboardMap;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KeyEmbedderResponder f7653a;
    public final /* synthetic */ KeyboardMap.KeyPair b;
    public final /* synthetic */ KeyEvent c;

    public /* synthetic */ j(KeyEmbedderResponder keyEmbedderResponder, KeyboardMap.KeyPair keyPair, KeyEvent keyEvent) {
        this.f7653a = keyEmbedderResponder;
        this.b = keyPair;
        this.c = keyEvent;
    }

    public final void run() {
        this.f7653a.lambda$synchronizePressingKey$1(this.b, this.c);
    }
}

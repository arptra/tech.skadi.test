package com.honey.account.wa;

import android.view.KeyEvent;
import io.flutter.embedding.android.KeyEmbedderResponder;
import io.flutter.embedding.android.KeyboardMap;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KeyEmbedderResponder f7652a;
    public final /* synthetic */ KeyboardMap.KeyPair b;
    public final /* synthetic */ long c;
    public final /* synthetic */ KeyEvent d;

    public /* synthetic */ i(KeyEmbedderResponder keyEmbedderResponder, KeyboardMap.KeyPair keyPair, long j, KeyEvent keyEvent) {
        this.f7652a = keyEmbedderResponder;
        this.b = keyPair;
        this.c = j;
        this.d = keyEvent;
    }

    public final void run() {
        this.f7652a.lambda$synchronizePressingKey$0(this.b, this.c, this.d);
    }
}

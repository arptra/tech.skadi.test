package com.honey.account.wa;

import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;

public final /* synthetic */ class g implements KeyEventChannel.EventResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KeyboardManager.Responder.OnKeyEventHandledCallback f7650a;

    public /* synthetic */ g(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        this.f7650a = onKeyEventHandledCallback;
    }

    public final void onFrameworkResponse(boolean z) {
        this.f7650a.onKeyEventHandled(z);
    }
}

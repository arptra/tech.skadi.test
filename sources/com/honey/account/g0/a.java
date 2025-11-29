package com.honey.account.g0;

import androidx.window.embedding.ExtensionEmbeddingBackend;
import java.util.List;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionEmbeddingBackend.SplitListenerWrapper f3054a;
    public final /* synthetic */ List b;

    public /* synthetic */ a(ExtensionEmbeddingBackend.SplitListenerWrapper splitListenerWrapper, List list) {
        this.f3054a = splitListenerWrapper;
        this.b = list;
    }

    public final void run() {
        ExtensionEmbeddingBackend.SplitListenerWrapper.c(this.f3054a, this.b);
    }
}

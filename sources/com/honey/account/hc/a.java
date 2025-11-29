package com.honey.account.hc;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.tika.embedder.ExternalEmbedder;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InputStream f9727a;
    public final /* synthetic */ OutputStream b;

    public /* synthetic */ a(InputStream inputStream, OutputStream outputStream) {
        this.f9727a = inputStream;
        this.b = outputStream;
    }

    public final void run() {
        ExternalEmbedder.lambda$multiThreadedStreamCopy$0(this.f9727a, this.b);
    }
}

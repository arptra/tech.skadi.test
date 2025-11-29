package com.honey.account.kc;

import java.io.InputStream;
import org.apache.tika.parser.external.ExternalParser;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Process f3218a;
    public final /* synthetic */ InputStream b;

    public /* synthetic */ c(Process process, InputStream inputStream) {
        this.f3218a = process;
        this.b = inputStream;
    }

    public final void run() {
        ExternalParser.lambda$sendInput$1(this.f3218a, this.b);
    }
}

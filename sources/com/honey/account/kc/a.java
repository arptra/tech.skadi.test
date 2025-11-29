package com.honey.account.kc;

import java.io.InputStream;
import org.apache.tika.parser.external.ExternalParser;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InputStream f3216a;

    public /* synthetic */ a(InputStream inputStream) {
        this.f3216a = inputStream;
    }

    public final void run() {
        ExternalParser.lambda$ignoreStream$0(this.f3216a);
    }
}

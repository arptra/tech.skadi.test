package com.honey.account.kc;

import java.io.InputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.external.ExternalParser;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExternalParser f3217a;
    public final /* synthetic */ InputStream b;
    public final /* synthetic */ Metadata c;

    public /* synthetic */ b(ExternalParser externalParser, InputStream inputStream, Metadata metadata) {
        this.f3217a = externalParser;
        this.b = inputStream;
        this.c = metadata;
    }

    public final void run() {
        this.f3217a.lambda$extractMetadata$2(this.b, this.c);
    }
}

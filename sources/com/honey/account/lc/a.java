package com.honey.account.lc;

import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.tika.parser.strings.StringsParser;
import org.xml.sax.ContentHandler;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InputStream f3219a;
    public final /* synthetic */ ContentHandler b;
    public final /* synthetic */ AtomicInteger c;

    public /* synthetic */ a(InputStream inputStream, ContentHandler contentHandler, AtomicInteger atomicInteger) {
        this.f3219a = inputStream;
        this.b = contentHandler;
        this.c = atomicInteger;
    }

    public final void run() {
        StringsParser.lambda$logStream$0(this.f3219a, this.b, this.c);
    }
}

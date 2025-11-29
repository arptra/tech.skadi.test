package org.apache.tika.language.detect;

import java.io.Writer;

public class LanguageWriter extends Writer {

    /* renamed from: a  reason: collision with root package name */
    public final LanguageDetector f9665a;

    public void close() {
    }

    public void flush() {
    }

    public void write(char[] cArr, int i, int i2) {
        this.f9665a.a(cArr, i, i2);
    }
}

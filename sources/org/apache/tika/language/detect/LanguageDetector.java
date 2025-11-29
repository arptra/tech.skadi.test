package org.apache.tika.language.detect;

import org.apache.tika.config.ServiceLoader;

public abstract class LanguageDetector {

    /* renamed from: a  reason: collision with root package name */
    public static final ServiceLoader f9663a = new ServiceLoader();

    public abstract void a(char[] cArr, int i, int i2);
}

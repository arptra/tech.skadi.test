package org.apache.tika.language.detect;

import java.util.Locale;

public class LanguageResult {
    public static final LanguageResult d = new LanguageResult("", LanguageConfidence.NONE, 0.0f);

    /* renamed from: a  reason: collision with root package name */
    public final String f9664a;
    public final LanguageConfidence b;
    public final float c;

    public LanguageResult(String str, LanguageConfidence languageConfidence, float f) {
        this.f9664a = str;
        this.b = languageConfidence;
        this.c = f;
    }

    public String toString() {
        return String.format(Locale.US, "%s: %s (%f)", new Object[]{this.f9664a, this.b, Float.valueOf(this.c)});
    }
}

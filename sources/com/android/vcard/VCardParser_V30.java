package com.android.vcard;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class VCardParser_V30 extends VCardParser {
    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"BEGIN", "END", "LOGO", "PHOTO", "LABEL", "FN", "TITLE", "SOUND", "VERSION", "TEL", "EMAIL", "TZ", "GEO", "NOTE", "URL", "BDAY", "ROLE", "REV", "UID", "KEY", "MAILER", "NAME", "PROFILE", "SOURCE", "NICKNAME", "CLASS", "SORT-STRING", "CATEGORIES", "PRODID", "IMPP"})));
    public static final Set c = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"7BIT", "8BIT", "BASE64", "B"})));

    /* renamed from: a  reason: collision with root package name */
    public final VCardParserImpl_V30 f2394a = new VCardParserImpl_V30();

    public void a(VCardInterpreter vCardInterpreter) {
        this.f2394a.a(vCardInterpreter);
    }

    public void b(InputStream inputStream) {
        this.f2394a.D(inputStream);
    }
}

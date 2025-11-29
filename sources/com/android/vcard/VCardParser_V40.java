package com.android.vcard;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class VCardParser_V40 extends VCardParser {
    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"BEGIN", "END", "VERSION", "SOURCE", "KIND", "FN", "N", "NICKNAME", "PHOTO", "BDAY", "ANNIVERSARY", "GENDER", "ADR", "TEL", "EMAIL", "IMPP", "LANG", "TZ", "GEO", "TITLE", "ROLE", "LOGO", "ORG", "MEMBER", "RELATED", "CATEGORIES", "NOTE", "PRODID", "REV", "SOUND", "UID", "CLIENTPIDMAP", "URL", "KEY", "FBURL", "CALENDRURI", "CALURI", "XML"})));
    public static final Set c = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"8BIT", "B"})));

    /* renamed from: a  reason: collision with root package name */
    public final VCardParserImpl_V40 f2395a;

    public void a(VCardInterpreter vCardInterpreter) {
        this.f2395a.a(vCardInterpreter);
    }

    public void b(InputStream inputStream) {
        this.f2395a.D(inputStream);
    }
}

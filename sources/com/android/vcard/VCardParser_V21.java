package com.android.vcard;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class VCardParser_V21 extends VCardParser {
    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"BEGIN", "END", "LOGO", "PHOTO", "LABEL", "FN", "TITLE", "SOUND", "VERSION", "TEL", "EMAIL", "TZ", "GEO", "NOTE", "URL", "BDAY", "ROLE", "REV", "UID", "KEY", "MAILER"})));
    public static final Set c = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"DOM", "INTL", "POSTAL", "PARCEL", "HOME", "WORK", "PREF", "VOICE", "FAX", "MSG", "CELL", "PAGER", "BBS", "MODEM", "CAR", "ISDN", "VIDEO", "AOL", "APPLELINK", "ATTMAIL", "CIS", "EWORLD", "INTERNET", "IBMMAIL", "MCIMAIL", "POWERSHARE", "PRODIGY", "TLX", "X400", "GIF", "CGM", "WMF", "BMP", "MET", "PMB", "DIB", "PICT", "TIFF", "PDF", "PS", "JPEG", "QTIME", "MPEG", "MPEG2", "AVI", "WAVE", "AIFF", "PCM", "X509", "PGP"})));
    public static final Set d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"INLINE", "URL", "CONTENT-ID", "CID"})));
    public static final Set e = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"7BIT", "8BIT", "QUOTED-PRINTABLE", "BASE64", "B"})));

    /* renamed from: a  reason: collision with root package name */
    public final VCardParserImpl_V21 f2393a = new VCardParserImpl_V21();

    public void a(VCardInterpreter vCardInterpreter) {
        this.f2393a.a(vCardInterpreter);
    }

    public void b(InputStream inputStream) {
        this.f2393a.D(inputStream);
    }
}

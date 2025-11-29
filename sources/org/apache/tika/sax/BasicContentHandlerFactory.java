package org.apache.tika.sax;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Locale;
import org.apache.tika.parser.ParseContext;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.DefaultHandler;

public class BasicContentHandlerFactory implements ContentHandlerFactory, WriteLimiter {
    private final ParseContext parseContext;
    private final boolean throwOnWriteLimitReached;
    private final HANDLER_TYPE type;
    private final int writeLimit;

    /* renamed from: org.apache.tika.sax.BasicContentHandlerFactory$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3317a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.apache.tika.sax.BasicContentHandlerFactory$HANDLER_TYPE[] r0 = org.apache.tika.sax.BasicContentHandlerFactory.HANDLER_TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3317a = r0
                org.apache.tika.sax.BasicContentHandlerFactory$HANDLER_TYPE r1 = org.apache.tika.sax.BasicContentHandlerFactory.HANDLER_TYPE.TEXT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3317a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.tika.sax.BasicContentHandlerFactory$HANDLER_TYPE r1 = org.apache.tika.sax.BasicContentHandlerFactory.HANDLER_TYPE.HTML     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3317a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.tika.sax.BasicContentHandlerFactory$HANDLER_TYPE r1 = org.apache.tika.sax.BasicContentHandlerFactory.HANDLER_TYPE.XML     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3317a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.apache.tika.sax.BasicContentHandlerFactory$HANDLER_TYPE r1 = org.apache.tika.sax.BasicContentHandlerFactory.HANDLER_TYPE.BODY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.sax.BasicContentHandlerFactory.AnonymousClass1.<clinit>():void");
        }
    }

    public enum HANDLER_TYPE {
        BODY,
        IGNORE,
        TEXT,
        HTML,
        XML
    }

    public BasicContentHandlerFactory(HANDLER_TYPE handler_type, int i) {
        this(handler_type, i, true, (ParseContext) null);
    }

    private ContentHandler getFormatHandler() {
        int i = AnonymousClass1.f3317a[this.type.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? new ToTextContentHandler() : new ToXMLContentHandler() : new ToHTMLContentHandler() : new ToTextContentHandler();
    }

    public static HANDLER_TYPE parseHandlerType(String str, HANDLER_TYPE handler_type) {
        if (str == null) {
            return handler_type;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        lowerCase.hashCode();
        char c = 65535;
        switch (lowerCase.hashCode()) {
            case -1190396462:
                if (lowerCase.equals("ignore")) {
                    c = 0;
                    break;
                }
                break;
            case 115312:
                if (lowerCase.equals("txt")) {
                    c = 1;
                    break;
                }
                break;
            case 118807:
                if (lowerCase.equals("xml")) {
                    c = 2;
                    break;
                }
                break;
            case 3029410:
                if (lowerCase.equals("body")) {
                    c = 3;
                    break;
                }
                break;
            case 3213227:
                if (lowerCase.equals("html")) {
                    c = 4;
                    break;
                }
                break;
            case 3556653:
                if (lowerCase.equals("text")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return HANDLER_TYPE.IGNORE;
            case 1:
                return HANDLER_TYPE.TEXT;
            case 2:
                return HANDLER_TYPE.XML;
            case 3:
                return HANDLER_TYPE.BODY;
            case 4:
                return HANDLER_TYPE.HTML;
            case 5:
                return HANDLER_TYPE.TEXT;
            default:
                return handler_type;
        }
    }

    public ContentHandler getNewContentHandler() {
        HANDLER_TYPE handler_type = this.type;
        if (handler_type == HANDLER_TYPE.BODY) {
            return new BodyContentHandler((ContentHandler) new WriteOutContentHandler(new ToTextContentHandler(), this.writeLimit, this.throwOnWriteLimitReached, this.parseContext));
        }
        if (handler_type == HANDLER_TYPE.IGNORE) {
            return new DefaultHandler();
        }
        ContentHandler formatHandler = getFormatHandler();
        if (this.writeLimit < 0) {
            return formatHandler;
        }
        return new WriteOutContentHandler(formatHandler, this.writeLimit, this.throwOnWriteLimitReached, this.parseContext);
    }

    public HANDLER_TYPE getType() {
        return this.type;
    }

    public int getWriteLimit() {
        return this.writeLimit;
    }

    public boolean isThrowOnWriteLimitReached() {
        return this.throwOnWriteLimitReached;
    }

    public BasicContentHandlerFactory(HANDLER_TYPE handler_type, int i, boolean z, ParseContext parseContext2) {
        this.type = handler_type;
        this.writeLimit = i;
        this.throwOnWriteLimitReached = z;
        this.parseContext = parseContext2;
        if (!z && parseContext2 == null) {
            throw new IllegalArgumentException("parse context must not be null if throwOnWriteLimitReached is false");
        }
    }

    public ContentHandler getNewContentHandler(OutputStream outputStream, String str) throws UnsupportedEncodingException {
        return getNewContentHandler(outputStream, Charset.forName(str));
    }

    public ContentHandler getNewContentHandler(OutputStream outputStream, Charset charset) {
        HANDLER_TYPE handler_type = this.type;
        if (handler_type == HANDLER_TYPE.IGNORE) {
            return new DefaultHandler();
        }
        try {
            if (this.writeLimit > -1) {
                int i = AnonymousClass1.f3317a[handler_type.ordinal()];
                if (i == 1) {
                    return new WriteOutContentHandler((ContentHandler) new ToTextContentHandler(outputStream, charset.name()), this.writeLimit);
                }
                if (i == 2) {
                    return new WriteOutContentHandler((ContentHandler) new ToHTMLContentHandler(outputStream, charset.name()), this.writeLimit);
                }
                if (i == 3) {
                    return new WriteOutContentHandler((ContentHandler) new ToXMLContentHandler(outputStream, charset.name()), this.writeLimit);
                }
                if (i != 4) {
                    return new WriteOutContentHandler((ContentHandler) new ToTextContentHandler(outputStream, charset.name()), this.writeLimit);
                }
                return new WriteOutContentHandler((ContentHandler) new BodyContentHandler((Writer) new OutputStreamWriter(outputStream, charset)), this.writeLimit);
            }
            int i2 = AnonymousClass1.f3317a[handler_type.ordinal()];
            if (i2 == 1) {
                return new ToTextContentHandler(outputStream, charset.name());
            }
            if (i2 == 2) {
                return new ToHTMLContentHandler(outputStream, charset.name());
            }
            if (i2 == 3) {
                return new ToXMLContentHandler(outputStream, charset.name());
            }
            if (i2 != 4) {
                return new ToTextContentHandler(outputStream, charset.name());
            }
            return new BodyContentHandler((Writer) new OutputStreamWriter(outputStream, charset));
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("couldn't find charset for name: " + charset);
        }
    }
}

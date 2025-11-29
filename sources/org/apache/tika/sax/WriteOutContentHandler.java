package org.apache.tika.sax;

import java.io.StringWriter;
import java.io.Writer;
import org.apache.tika.exception.WriteLimitReachedException;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.ParseRecord;
import org.xml.sax.ContentHandler;

public class WriteOutContentHandler extends ContentHandlerDecorator {
    public final int b;
    public int c;
    public boolean d;
    public ParseContext e;
    public boolean f;

    public WriteOutContentHandler(ContentHandler contentHandler, int i) {
        super(contentHandler);
        this.c = 0;
        this.d = true;
        this.e = null;
        this.b = i;
    }

    private void c() {
        this.f = true;
        this.c = this.b;
        if (!this.d) {
            ParseRecord parseRecord = (ParseRecord) this.e.get(ParseRecord.class);
            if (parseRecord != null) {
                parseRecord.k(true);
                return;
            }
            return;
        }
        throw new WriteLimitReachedException(this.b);
    }

    public void characters(char[] cArr, int i, int i2) {
        if (!this.f) {
            int i3 = this.b;
            if (i3 != -1) {
                int i4 = this.c;
                if (i4 + i2 > i3) {
                    super.characters(cArr, i, i3 - i4);
                    c();
                    return;
                }
            }
            super.characters(cArr, i, i2);
            this.c += i2;
        }
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) {
        if (!this.f) {
            int i3 = this.b;
            if (i3 != -1) {
                int i4 = this.c;
                if (i4 + i2 > i3) {
                    super.ignorableWhitespace(cArr, i, i3 - i4);
                    c();
                    return;
                }
            }
            super.ignorableWhitespace(cArr, i, i2);
            this.c += i2;
        }
    }

    public WriteOutContentHandler(Writer writer, int i) {
        this((ContentHandler) new ToTextContentHandler(writer), i);
    }

    public WriteOutContentHandler(Writer writer) {
        this(writer, -1);
    }

    public WriteOutContentHandler(int i) {
        this((Writer) new StringWriter(), i);
    }

    public WriteOutContentHandler() {
        this(100000);
    }

    public WriteOutContentHandler(ContentHandler contentHandler, int i, boolean z, ParseContext parseContext) {
        super(contentHandler);
        this.c = 0;
        this.b = i;
        this.d = z;
        this.e = parseContext;
    }
}

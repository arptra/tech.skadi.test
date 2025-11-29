package org.apache.tika.sax;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.helpers.DefaultHandler;

public class TextContentHandler extends DefaultHandler {
    public static final char[] c = {' '};

    /* renamed from: a  reason: collision with root package name */
    public final ContentHandler f3331a;
    public final boolean b;

    public void characters(char[] cArr, int i, int i2) {
        this.f3331a.characters(cArr, i, i2);
    }

    public void endDocument() {
        this.f3331a.endDocument();
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) {
        this.f3331a.ignorableWhitespace(cArr, i, i2);
    }

    public void setDocumentLocator(Locator locator) {
        this.f3331a.setDocumentLocator(locator);
    }

    public void startDocument() {
        this.f3331a.startDocument();
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (this.b) {
            ContentHandler contentHandler = this.f3331a;
            char[] cArr = c;
            contentHandler.characters(cArr, 0, cArr.length);
        }
    }

    public String toString() {
        return this.f3331a.toString();
    }
}

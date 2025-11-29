package org.apache.tika.sax;

import org.xml.sax.Attributes;

public class ExpandedTitleContentHandler extends ContentHandlerDecorator {
    public boolean b;

    public void characters(char[] cArr, int i, int i2) {
        if (!this.b || i2 != 0) {
            super.characters(cArr, i, i2);
            return;
        }
        try {
            super.characters(new char[0], 0, 1);
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
    }

    public void endElement(String str, String str2, String str3) {
        super.endElement(str, str2, str3);
        if ("TITLE".equalsIgnoreCase(str2) && "http://www.w3.org/1999/xhtml".equals(str)) {
            this.b = false;
        }
    }

    public void startDocument() {
        super.startDocument();
        this.b = false;
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        super.startElement(str, str2, str3, attributes);
        if ("TITLE".equalsIgnoreCase(str2) && "http://www.w3.org/1999/xhtml".equals(str)) {
            this.b = true;
        }
    }
}

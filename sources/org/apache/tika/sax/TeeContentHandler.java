package org.apache.tika.sax;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.helpers.DefaultHandler;

public class TeeContentHandler extends DefaultHandler {

    /* renamed from: a  reason: collision with root package name */
    public final ContentHandler[] f3330a;

    public TeeContentHandler(ContentHandler... contentHandlerArr) {
        this.f3330a = contentHandlerArr;
    }

    public void characters(char[] cArr, int i, int i2) {
        for (ContentHandler characters : this.f3330a) {
            characters.characters(cArr, i, i2);
        }
    }

    public void endDocument() {
        for (ContentHandler endDocument : this.f3330a) {
            endDocument.endDocument();
        }
    }

    public void endElement(String str, String str2, String str3) {
        for (ContentHandler endElement : this.f3330a) {
            endElement.endElement(str, str2, str3);
        }
    }

    public void endPrefixMapping(String str) {
        for (ContentHandler endPrefixMapping : this.f3330a) {
            endPrefixMapping.endPrefixMapping(str);
        }
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) {
        for (ContentHandler ignorableWhitespace : this.f3330a) {
            ignorableWhitespace.ignorableWhitespace(cArr, i, i2);
        }
    }

    public void processingInstruction(String str, String str2) {
        for (ContentHandler processingInstruction : this.f3330a) {
            processingInstruction.processingInstruction(str, str2);
        }
    }

    public void setDocumentLocator(Locator locator) {
        for (ContentHandler documentLocator : this.f3330a) {
            documentLocator.setDocumentLocator(locator);
        }
    }

    public void skippedEntity(String str) {
        for (ContentHandler skippedEntity : this.f3330a) {
            skippedEntity.skippedEntity(str);
        }
    }

    public void startDocument() {
        for (ContentHandler startDocument : this.f3330a) {
            startDocument.startDocument();
        }
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        for (ContentHandler startElement : this.f3330a) {
            startElement.startElement(str, str2, str3, attributes);
        }
    }

    public void startPrefixMapping(String str, String str2) {
        for (ContentHandler startPrefixMapping : this.f3330a) {
            startPrefixMapping.startPrefixMapping(str, str2);
        }
    }
}

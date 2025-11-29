package org.apache.tika.sax;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ContentHandlerDecorator extends DefaultHandler {

    /* renamed from: a  reason: collision with root package name */
    public ContentHandler f3319a;

    public ContentHandlerDecorator(ContentHandler contentHandler) {
        this.f3319a = contentHandler;
    }

    public void a(SAXException sAXException) {
        throw sAXException;
    }

    public void b(ContentHandler contentHandler) {
        this.f3319a = contentHandler;
    }

    public void characters(char[] cArr, int i, int i2) {
        try {
            this.f3319a.characters(cArr, i, i2);
        } catch (SAXException e) {
            a(e);
        }
    }

    public void endDocument() {
        try {
            this.f3319a.endDocument();
        } catch (SAXException e) {
            a(e);
        }
    }

    public void endElement(String str, String str2, String str3) {
        try {
            this.f3319a.endElement(str, str2, str3);
        } catch (SAXException e) {
            a(e);
        }
    }

    public void endPrefixMapping(String str) {
        try {
            this.f3319a.endPrefixMapping(str);
        } catch (SAXException e) {
            a(e);
        }
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) {
        try {
            this.f3319a.ignorableWhitespace(cArr, i, i2);
        } catch (SAXException e) {
            a(e);
        }
    }

    public void processingInstruction(String str, String str2) {
        try {
            this.f3319a.processingInstruction(str, str2);
        } catch (SAXException e) {
            a(e);
        }
    }

    public void setDocumentLocator(Locator locator) {
        this.f3319a.setDocumentLocator(locator);
    }

    public void skippedEntity(String str) {
        try {
            this.f3319a.skippedEntity(str);
        } catch (SAXException e) {
            a(e);
        }
    }

    public void startDocument() {
        try {
            this.f3319a.startDocument();
        } catch (SAXException e) {
            a(e);
        }
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        try {
            this.f3319a.startElement(str, str2, str3, attributes);
        } catch (SAXException e) {
            a(e);
        }
    }

    public void startPrefixMapping(String str, String str2) {
        try {
            this.f3319a.startPrefixMapping(str, str2);
        } catch (SAXException e) {
            a(e);
        }
    }

    public String toString() {
        return this.f3319a.toString();
    }
}

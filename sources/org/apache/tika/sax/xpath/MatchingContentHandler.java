package org.apache.tika.sax.xpath;

import java.util.LinkedList;
import org.apache.tika.sax.ContentHandlerDecorator;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.AttributesImpl;

public class MatchingContentHandler extends ContentHandlerDecorator {
    public final LinkedList b = new LinkedList();
    public Matcher c;

    public MatchingContentHandler(ContentHandler contentHandler, Matcher matcher) {
        super(contentHandler);
        this.c = matcher;
    }

    public void characters(char[] cArr, int i, int i2) {
        if (this.c.d()) {
            super.characters(cArr, i, i2);
        }
    }

    public void endElement(String str, String str2, String str3) {
        if (this.c.c()) {
            super.endElement(str, str2, str3);
        }
        if (!this.b.isEmpty()) {
            this.c = (Matcher) this.b.removeFirst();
        }
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) {
        if (this.c.d()) {
            super.ignorableWhitespace(cArr, i, i2);
        }
    }

    public void processingInstruction(String str, String str2) {
    }

    public void skippedEntity(String str) {
        if (this.c.d()) {
            super.skippedEntity(str);
        }
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.b.addFirst(this.c);
        this.c = this.c.a(str, str2);
        AttributesImpl attributesImpl = new AttributesImpl();
        for (int i = 0; i < attributes.getLength(); i++) {
            String uri = attributes.getURI(i);
            String localName = attributes.getLocalName(i);
            if (this.c.b(uri, localName)) {
                attributesImpl.addAttribute(uri, localName, attributes.getQName(i), attributes.getType(i), attributes.getValue(i));
            }
        }
        if (this.c.c() || attributesImpl.getLength() > 0) {
            super.startElement(str, str2, str3, attributesImpl);
            if (!this.c.c()) {
                this.c = new CompositeMatcher(this.c, ElementMatcher.b);
            }
        }
    }
}

package org.apache.tika.sax;

import org.xml.sax.ContentHandler;

public class EmbeddedContentHandler extends ContentHandlerDecorator {
    public EmbeddedContentHandler(ContentHandler contentHandler) {
        super(contentHandler);
    }

    public void endDocument() {
    }

    public void startDocument() {
    }
}

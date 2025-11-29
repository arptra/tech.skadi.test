package org.apache.tika.sax;

public class EndDocumentShieldingContentHandler extends ContentHandlerDecorator {
    public boolean b;

    public void endDocument() {
        this.b = true;
    }
}

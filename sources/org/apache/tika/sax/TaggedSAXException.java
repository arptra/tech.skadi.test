package org.apache.tika.sax;

import org.xml.sax.SAXException;

public class TaggedSAXException extends SAXException {
    private final Object tag;

    public TaggedSAXException(SAXException sAXException, Object obj) {
        super(sAXException.getMessage(), sAXException);
        this.tag = obj;
    }

    public Object getTag() {
        return this.tag;
    }

    public SAXException getCause() {
        return (SAXException) super.getCause();
    }
}

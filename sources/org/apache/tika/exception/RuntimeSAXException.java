package org.apache.tika.exception;

import org.xml.sax.SAXException;

public class RuntimeSAXException extends RuntimeException {
    public RuntimeSAXException(SAXException sAXException) {
        super(sAXException);
    }
}

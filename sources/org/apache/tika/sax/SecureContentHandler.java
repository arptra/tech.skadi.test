package org.apache.tika.sax;

import java.io.IOException;
import java.util.LinkedList;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class SecureContentHandler extends ContentHandlerDecorator {
    public final TikaInputStream b;
    public final LinkedList c = new LinkedList();
    public long d = 0;
    public int e = 0;
    public long f = 1000000;
    public long g = 100;
    public int h = 100;
    public int i = 10;

    public class SecureSAXException extends SAXException {
        private static final long serialVersionUID = 2285245380321771445L;

        public SecureSAXException(String str) throws SAXException {
            super(str);
        }

        public boolean isCausedBy(SecureContentHandler secureContentHandler) {
            return SecureContentHandler.this == secureContentHandler;
        }
    }

    public SecureContentHandler(ContentHandler contentHandler, TikaInputStream tikaInputStream) {
        super(contentHandler);
        this.b = tikaInputStream;
    }

    public void c(int i2) {
        this.d += (long) i2;
        long d2 = d();
        long j = this.d;
        if (j > this.f && j > this.g * d2) {
            throw new SecureSAXException("Suspected zip bomb: " + d2 + " input bytes produced " + this.d + " output characters");
        }
    }

    public void characters(char[] cArr, int i2, int i3) {
        c(i3);
        super.characters(cArr, i2, i3);
    }

    public final long d() {
        try {
            return this.b.U() ? this.b.w() : this.b.S();
        } catch (IOException e2) {
            throw new SAXException("Unable to get stream length", e2);
        }
    }

    public void e(long j) {
        this.g = j;
    }

    public void endElement(String str, String str2, String str3) {
        super.endElement(str, str2, str3);
        if (!this.c.isEmpty() && ((Integer) this.c.getLast()).intValue() == this.e) {
            this.c.removeLast();
        }
        this.e--;
    }

    public void f(int i2) {
        this.h = i2;
    }

    public void g(int i2) {
        this.i = i2;
    }

    public void h(long j) {
        this.f = j;
    }

    public void i(SAXException sAXException) {
        if ((sAXException instanceof SecureSAXException) && ((SecureSAXException) sAXException).isCausedBy(this)) {
            throw new TikaException("Zip bomb detected!", sAXException);
        }
    }

    public void ignorableWhitespace(char[] cArr, int i2, int i3) {
        c(i3);
        super.ignorableWhitespace(cArr, i2, i3);
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        int i2 = this.e + 1;
        this.e = i2;
        if (i2 < this.h) {
            if ("div".equals(str3) && "package-entry".equals(attributes.getValue("class"))) {
                this.c.addLast(Integer.valueOf(this.e));
                if (this.c.size() >= this.i) {
                    throw new SecureSAXException("Suspected zip bomb: " + this.c.size() + " levels of package entry nesting");
                }
            }
            super.startElement(str, str2, str3, attributes);
            return;
        }
        throw new SecureSAXException("Suspected zip bomb: " + this.e + " levels of XML element nesting");
    }
}

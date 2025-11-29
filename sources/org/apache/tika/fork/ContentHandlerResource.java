package org.apache.tika.fork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

class ContentHandlerResource implements ForkResource {

    /* renamed from: a  reason: collision with root package name */
    public final ContentHandler f10063a;

    public ContentHandlerResource(ContentHandler contentHandler) {
        this.f10063a = contentHandler;
    }

    public Throwable a(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        try {
            b(dataInputStream);
            return null;
        } catch (SAXException e) {
            return e;
        }
    }

    public final void b(DataInputStream dataInputStream) {
        AttributesImpl attributesImpl;
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        if (readUnsignedByte == 1) {
            this.f10063a.startDocument();
        } else if (readUnsignedByte == 2) {
            this.f10063a.endDocument();
        } else if (readUnsignedByte == 3) {
            this.f10063a.startPrefixMapping(d(dataInputStream), d(dataInputStream));
        } else if (readUnsignedByte == 4) {
            this.f10063a.endPrefixMapping(d(dataInputStream));
        } else {
            if (readUnsignedByte == 5) {
                String d = d(dataInputStream);
                String d2 = d(dataInputStream);
                String d3 = d(dataInputStream);
                int readInt = dataInputStream.readInt();
                if (readInt >= 0) {
                    attributesImpl = new AttributesImpl();
                    for (int i = 0; i < readInt; i++) {
                        attributesImpl.addAttribute(d(dataInputStream), d(dataInputStream), d(dataInputStream), d(dataInputStream), d(dataInputStream));
                    }
                } else {
                    attributesImpl = null;
                }
                this.f10063a.startElement(d, d2, d3, attributesImpl);
            } else if (readUnsignedByte == 6) {
                this.f10063a.endElement(d(dataInputStream), d(dataInputStream), d(dataInputStream));
            } else if (readUnsignedByte == 7) {
                char[] c = c(dataInputStream);
                this.f10063a.characters(c, 0, c.length);
            } else if (readUnsignedByte == 8) {
                char[] c2 = c(dataInputStream);
                this.f10063a.characters(c2, 0, c2.length);
            } else if (readUnsignedByte == 9) {
                this.f10063a.processingInstruction(d(dataInputStream), d(dataInputStream));
            } else if (readUnsignedByte == 10) {
                this.f10063a.skippedEntity(d(dataInputStream));
            }
        }
    }

    public final char[] c(DataInputStream dataInputStream) {
        return e(dataInputStream).toCharArray();
    }

    public final String d(DataInputStream dataInputStream) {
        if (dataInputStream.readBoolean()) {
            return e(dataInputStream);
        }
        return null;
    }

    public final String e(DataInputStream dataInputStream) {
        int readInt = dataInputStream.readInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < readInt; i++) {
            sb.append(dataInputStream.readUTF());
        }
        return sb.toString();
    }
}

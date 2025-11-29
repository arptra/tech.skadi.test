package org.apache.tika.fork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

class ContentHandlerProxy implements ContentHandler, ForkProxy {
    public static final int CHARACTERS = 7;
    public static final int END_DOCUMENT = 2;
    public static final int END_ELEMENT = 6;
    public static final int END_PREFIX_MAPPING = 4;
    public static final int IGNORABLE_WHITESPACE = 8;
    public static final int PROCESSING_INSTRUCTION = 9;
    public static final int SKIPPED_ENTITY = 10;
    public static final int START_DOCUMENT = 1;
    public static final int START_ELEMENT = 5;
    public static final int START_PREFIX_MAPPING = 3;
    private static final long serialVersionUID = 737511106054617524L;
    private transient DataOutputStream output;
    private final int resource;

    public ContentHandlerProxy(int i) {
        this.resource = i;
    }

    private void doneSending() throws SAXException {
        try {
            this.output.flush();
        } catch (IOException e) {
            throw new SAXException("Unexpected fork proxy problem", e);
        }
    }

    private void sendCharacters(char[] cArr, int i, int i2) throws SAXException {
        try {
            writeString(new String(cArr, i, i2));
        } catch (IOException e) {
            throw new SAXException("Unexpected fork proxy problem", e);
        }
    }

    private void sendRequest(int i) throws SAXException {
        try {
            this.output.writeByte(3);
            this.output.writeByte(this.resource);
            this.output.writeByte(i);
        } catch (IOException e) {
            throw new SAXException("Unexpected fork proxy problem", e);
        }
    }

    private void sendString(String str) throws SAXException {
        if (str != null) {
            try {
                this.output.writeBoolean(true);
                writeString(str);
            } catch (IOException e) {
                throw new SAXException("Unexpected fork proxy problem", e);
            }
        } else {
            this.output.writeBoolean(false);
        }
    }

    private void writeString(String str) throws IOException {
        int ceil = (int) Math.ceil(((double) str.length()) / ((double) 21845));
        this.output.writeInt(ceil);
        int i = 0;
        while (i < ceil) {
            this.output.writeUTF(str.substring(i * 21845, i < ceil + -1 ? (i + 1) * 21845 : str.length()));
            i++;
        }
    }

    public void characters(char[] cArr, int i, int i2) throws SAXException {
        sendRequest(7);
        sendCharacters(cArr, i, i2);
        doneSending();
    }

    public void endDocument() throws SAXException {
        sendRequest(2);
        doneSending();
    }

    public void endElement(String str, String str2, String str3) throws SAXException {
        sendRequest(6);
        sendString(str);
        sendString(str2);
        sendString(str3);
        doneSending();
    }

    public void endPrefixMapping(String str) throws SAXException {
        sendRequest(4);
        sendString(str);
        doneSending();
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
        sendRequest(8);
        sendCharacters(cArr, i, i2);
        doneSending();
    }

    public void init(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        this.output = dataOutputStream;
    }

    public void processingInstruction(String str, String str2) throws SAXException {
        sendRequest(9);
        sendString(str);
        sendString(str2);
        doneSending();
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void skippedEntity(String str) throws SAXException {
        sendRequest(10);
        sendString(str);
        doneSending();
    }

    public void startDocument() throws SAXException {
        sendRequest(1);
        doneSending();
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        sendRequest(5);
        sendString(str);
        sendString(str2);
        sendString(str3);
        int length = attributes != null ? attributes.getLength() : -1;
        try {
            this.output.writeInt(length);
            for (int i = 0; i < length; i++) {
                sendString(attributes.getURI(i));
                sendString(attributes.getLocalName(i));
                sendString(attributes.getQName(i));
                sendString(attributes.getType(i));
                sendString(attributes.getValue(i));
            }
            doneSending();
        } catch (IOException e) {
            throw new SAXException("Unexpected fork proxy problem", e);
        }
    }

    public void startPrefixMapping(String str, String str2) throws SAXException {
        sendRequest(3);
        sendString(str);
        sendString(str2);
        doneSending();
    }
}

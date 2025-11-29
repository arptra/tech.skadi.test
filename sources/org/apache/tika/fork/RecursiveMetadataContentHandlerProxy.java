package org.apache.tika.fork;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.sax.AbstractRecursiveParserWrapperHandler;
import org.apache.tika.sax.ContentHandlerFactory;
import org.apache.tika.sax.RecursiveParserWrapperHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

class RecursiveMetadataContentHandlerProxy extends RecursiveParserWrapperHandler implements ForkProxy {
    public static final byte COMPLETE = 5;
    public static final byte EMBEDDED_DOCUMENT = 1;
    public static final byte HANDLER_AND_METADATA = 3;
    public static final byte MAIN_DOCUMENT = 2;
    public static final byte METADATA_ONLY = 4;
    private static final long serialVersionUID = 737511106054617524L;
    private transient DataOutputStream output;
    private final int resource;

    public RecursiveMetadataContentHandlerProxy(int i, ContentHandlerFactory contentHandlerFactory) {
        super(contentHandlerFactory);
        this.resource = i;
    }

    private void doneSending() throws SAXException {
        try {
            this.output.flush();
        } catch (IOException e) {
            throw new SAXException("Unexpected fork proxy problem", e);
        }
    }

    private void proxyBackToClient(int i, ContentHandler contentHandler, Metadata metadata) throws SAXException {
        byte[] bArr;
        boolean z;
        try {
            this.output.write(3);
            this.output.writeByte(this.resource);
            this.output.writeByte(i);
            if (contentHandler instanceof Serializable) {
                try {
                    bArr = serialize(contentHandler);
                    z = true;
                } catch (NotSerializableException unused) {
                    z = false;
                    bArr = null;
                }
                if (z) {
                    this.output.write(3);
                    sendBytes(bArr);
                    send(metadata);
                    this.output.writeByte(5);
                    doneSending();
                    return;
                }
            }
            metadata.set(TikaCoreProperties.g, contentHandler.toString());
            this.output.writeByte(4);
            send(metadata);
            this.output.writeByte(5);
            doneSending();
        } catch (IOException e) {
            throw new SAXException(e);
        } catch (Throwable th) {
            doneSending();
            throw th;
        }
    }

    private void send(Object obj) throws IOException {
        sendBytes(serialize(obj));
    }

    private void sendBytes(byte[] bArr) throws IOException {
        this.output.writeInt(bArr.length);
        this.output.write(bArr);
        this.output.flush();
    }

    private byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        try {
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            objectOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void endDocument(ContentHandler contentHandler, Metadata metadata) throws SAXException {
        if (hasHitMaximumEmbeddedResources()) {
            metadata.set(AbstractRecursiveParserWrapperHandler.EMBEDDED_RESOURCE_LIMIT_REACHED, BooleanUtils.TRUE);
        }
        proxyBackToClient(2, contentHandler, metadata);
    }

    public void endEmbeddedDocument(ContentHandler contentHandler, Metadata metadata) throws SAXException {
        proxyBackToClient(1, contentHandler, metadata);
    }

    public void init(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        this.output = dataOutputStream;
    }
}

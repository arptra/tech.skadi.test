package io.netty.handler.codec.serialization;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;

class CompactObjectInputStream extends ObjectInputStream {
    private final ClassResolver classResolver;

    public CompactObjectInputStream(InputStream inputStream, ClassResolver classResolver2) throws IOException {
        super(inputStream);
        this.classResolver = classResolver2;
    }

    public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        int read = read();
        if (read < 0) {
            throw new EOFException();
        } else if (read == 0) {
            return super.readClassDescriptor();
        } else {
            if (read == 1) {
                return ObjectStreamClass.lookupAny(this.classResolver.resolve(readUTF()));
            }
            throw new StreamCorruptedException("Unexpected class descriptor type: " + read);
        }
    }

    public void readStreamHeader() throws IOException {
        byte readByte = readByte() & 255;
        if (readByte != 5) {
            throw new StreamCorruptedException("Unsupported version: " + readByte);
        }
    }

    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        try {
            return this.classResolver.resolve(objectStreamClass.getName());
        } catch (ClassNotFoundException unused) {
            return super.resolveClass(objectStreamClass);
        }
    }
}

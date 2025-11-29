package org.apache.tika.fork;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

class ForkObjectInputStream extends ObjectInputStream {

    /* renamed from: a  reason: collision with root package name */
    public final ClassLoader f10065a;

    public ForkObjectInputStream(InputStream inputStream, ClassLoader classLoader) {
        super(inputStream);
        this.f10065a = classLoader;
    }

    public static Object a(DataInputStream dataInputStream, ClassLoader classLoader) {
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(bArr);
        return new ForkObjectInputStream(new ByteArrayInputStream(bArr), classLoader).readObject();
    }

    public static void b(Object obj, DataOutputStream dataOutputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        try {
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            dataOutputStream.writeInt(byteArray.length);
            dataOutputStream.write(byteArray);
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public Class resolveClass(ObjectStreamClass objectStreamClass) {
        return Class.forName(objectStreamClass.getName(), false, this.f10065a);
    }
}

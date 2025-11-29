package org.apache.tika.fork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

class ClassLoaderResource implements ForkResource {

    /* renamed from: a  reason: collision with root package name */
    public final ClassLoader f10062a;

    public ClassLoaderResource(ClassLoader classLoader) {
        this.f10062a = classLoader;
    }

    public Throwable a(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        byte readByte = dataInputStream.readByte();
        String readUTF = dataInputStream.readUTF();
        if (readByte == 1) {
            InputStream resourceAsStream = this.f10062a.getResourceAsStream(readUTF);
            if (resourceAsStream != null) {
                dataOutputStream.writeBoolean(true);
                b(dataOutputStream, resourceAsStream);
            } else {
                dataOutputStream.writeBoolean(false);
            }
        } else if (readByte == 2) {
            Enumeration<URL> resources = this.f10062a.getResources(readUTF);
            while (resources.hasMoreElements()) {
                dataOutputStream.writeBoolean(true);
                b(dataOutputStream, resources.nextElement().openStream());
            }
            dataOutputStream.writeBoolean(false);
        }
        dataOutputStream.flush();
        return null;
    }

    public final void b(DataOutputStream dataOutputStream, InputStream inputStream) {
        try {
            byte[] bArr = new byte[65535];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    dataOutputStream.writeShort(read);
                    dataOutputStream.write(bArr, 0, read);
                } else {
                    dataOutputStream.writeShort(0);
                    inputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }
}

package org.apache.tika.fork;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

class ClassLoaderProxy extends ClassLoader implements ForkProxy {
    private static final long serialVersionUID = -7303109260448540420L;
    private transient DataInputStream input;
    private final Set<String> notFound = new HashSet();
    private transient DataOutputStream output;
    private final int resource;

    public ClassLoaderProxy(int i) {
        this.resource = i;
    }

    private void definePackageIfNecessary(String str, Class<?> cls) {
        String packageName = toPackageName(str);
        if (packageName != null && getPackage(packageName) == null) {
            definePackage(packageName, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (URL) null);
        }
    }

    private byte[] readStream() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[65535];
            while (true) {
                int readUnsignedShort = this.input.readUnsignedShort();
                if (readUnsignedShort > 0) {
                    this.input.readFully(bArr, 0, readUnsignedShort);
                    byteArrayOutputStream.write(bArr, 0, readUnsignedShort);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private String toPackageName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            return str.substring(0, lastIndexOf);
        }
        return null;
    }

    public synchronized Class<?> findClass(String str) throws ClassNotFoundException {
        Class<?> defineClass;
        try {
            this.output.write(3);
            this.output.write(this.resource);
            this.output.write(1);
            DataOutputStream dataOutputStream = this.output;
            dataOutputStream.writeUTF(str.replace('.', '/') + ".class");
            this.output.flush();
            if (this.input.readBoolean()) {
                byte[] readStream = readStream();
                defineClass = defineClass(str, readStream, 0, readStream.length);
                definePackageIfNecessary(str, defineClass);
            } else {
                throw new ClassNotFoundException("Unable to find class " + str);
            }
        } catch (IOException e) {
            throw new ClassNotFoundException("Unable to load class " + str, e);
        }
        return defineClass;
    }

    public synchronized URL findResource(String str) {
        if (this.notFound.contains(str)) {
            return null;
        }
        try {
            this.output.write(3);
            this.output.write(this.resource);
            this.output.write(1);
            this.output.writeUTF(str);
            this.output.flush();
            if (this.input.readBoolean()) {
                return MemoryURLStreamHandler.a(readStream());
            }
            this.notFound.add(str);
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    public synchronized Enumeration<URL> findResources(String str) throws IOException {
        ArrayList arrayList;
        try {
            this.output.write(3);
            this.output.write(this.resource);
            this.output.write(2);
            this.output.writeUTF(str);
            this.output.flush();
            arrayList = new ArrayList();
            while (this.input.readBoolean()) {
                arrayList.add(MemoryURLStreamHandler.a(readStream()));
            }
        } catch (Throwable th) {
            throw th;
        }
        return Collections.enumeration(arrayList);
    }

    public void init(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        this.input = dataInputStream;
        this.output = dataOutputStream;
    }
}

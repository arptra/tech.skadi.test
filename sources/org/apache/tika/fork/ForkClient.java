package org.apache.tika.fork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.NotSerializableException;
import java.io.OutputStream;
import java.lang.ProcessBuilder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tika.exception.TikaException;
import org.apache.tika.sax.AbstractRecursiveParserWrapperHandler;
import org.apache.tika.sax.RecursiveParserWrapperHandler;
import org.apache.tika.utils.ProcessUtils;
import org.xml.sax.ContentHandler;

class ForkClient {
    public static final AtomicInteger i = new AtomicInteger(0);

    /* renamed from: a  reason: collision with root package name */
    public final List f10064a;
    public final ClassLoader b;
    public final File c;
    public final Process d;
    public final DataOutputStream e;
    public final DataInputStream f;
    public final int g;
    public volatile int h;

    public ForkClient(Path path, ParserFactoryFactory parserFactoryFactory, List list, TimeoutLimits timeoutLimits) {
        this(path, parserFactoryFactory, (ClassLoader) null, list, timeoutLimits);
    }

    public static File c() {
        File file = Files.createTempFile("apache-tika-fork-", ".jar", new FileAttribute[0]).toFile();
        try {
            d(file);
            return file;
        } catch (Throwable th) {
            file.delete();
            throw th;
        }
    }

    public static void d(File file) {
        InputStream resourceAsStream;
        Class<ForkServer> cls = ForkServer.class;
        JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(file));
        try {
            jarOutputStream.putNextEntry(new ZipEntry("META-INF/MANIFEST.MF"));
            jarOutputStream.write(("Main-Class: " + cls.getName() + StringUtils.LF).getBytes(StandardCharsets.UTF_8));
            Class[] clsArr = {ForkServer.class, ForkObjectInputStream.class, ForkProxy.class, ClassLoaderProxy.class, MemoryURLConnection.class, MemoryURLStreamHandler.class, MemoryURLStreamHandlerFactory.class, MemoryURLStreamRecord.class, TikaException.class};
            ClassLoader classLoader = cls.getClassLoader();
            for (int i2 = 0; i2 < 9; i2++) {
                Class cls2 = clsArr[i2];
                String str = cls2.getName().replace('.', '/') + ".class";
                resourceAsStream = classLoader.getResourceAsStream(str);
                jarOutputStream.putNextEntry(new JarEntry(str));
                IOUtils.copy(resourceAsStream, (OutputStream) jarOutputStream);
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
            }
            jarOutputStream.close();
            return;
            throw th;
            throw th;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
    }

    public synchronized Throwable a(String str, Object... objArr) {
        ArrayList arrayList;
        try {
            this.h++;
            arrayList = new ArrayList(this.f10064a);
            this.e.writeByte(1);
            this.e.writeUTF(str);
            for (Object g2 : objArr) {
                g(g2, arrayList);
            }
        } catch (Throwable th) {
            throw th;
        }
        return h(arrayList);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:1|2|(1:4)|7|(1:9)|10|11|(3:13|14|15)|16|17|(1:19)|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0028, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0012 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x001e */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0016 A[Catch:{ all -> 0x0009 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0022 A[Catch:{ all -> 0x0009 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.io.DataOutputStream r0 = r1.e     // Catch:{ IOException -> 0x0012 }
            if (r0 == 0) goto L_0x000b
            r0.close()     // Catch:{ IOException -> 0x0012 }
            goto L_0x000b
        L_0x0009:
            r0 = move-exception
            goto L_0x0027
        L_0x000b:
            java.io.DataInputStream r0 = r1.f     // Catch:{ IOException -> 0x0012 }
            if (r0 == 0) goto L_0x0012
            r0.close()     // Catch:{ IOException -> 0x0012 }
        L_0x0012:
            java.lang.Process r0 = r1.d     // Catch:{ all -> 0x0009 }
            if (r0 == 0) goto L_0x001e
            r0.destroyForcibly()     // Catch:{ all -> 0x0009 }
            java.lang.Process r0 = r1.d     // Catch:{ InterruptedException -> 0x001e }
            r0.waitFor()     // Catch:{ InterruptedException -> 0x001e }
        L_0x001e:
            java.io.File r0 = r1.c     // Catch:{ all -> 0x0009 }
            if (r0 == 0) goto L_0x0025
            r0.delete()     // Catch:{ all -> 0x0009 }
        L_0x0025:
            monitor-exit(r1)
            return
        L_0x0027:
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.fork.ForkClient.b():void");
    }

    public int e() {
        return this.h;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean f() {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            java.io.DataOutputStream r1 = r3.e     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            r2 = 2
            r1.writeByte(r2)     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            java.io.DataOutputStream r1 = r3.e     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            r1.flush()     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            java.io.DataInputStream r1 = r3.f     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            int r1 = r1.read()     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            if (r1 != r2) goto L_0x0016
            r0 = 1
        L_0x0016:
            monitor-exit(r3)
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x001b:
            monitor-exit(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.fork.ForkClient.f():boolean");
    }

    public final void g(Object obj, List list) {
        int size = list.size();
        if (obj instanceof InputStream) {
            list.add(new InputStreamResource((InputStream) obj));
            obj = new InputStreamProxy(size);
        } else if (obj instanceof RecursiveParserWrapperHandler) {
            RecursiveParserWrapperHandler recursiveParserWrapperHandler = (RecursiveParserWrapperHandler) obj;
            list.add(new RecursiveMetadataContentHandlerResource(recursiveParserWrapperHandler));
            obj = new RecursiveMetadataContentHandlerProxy(size, recursiveParserWrapperHandler.getContentHandlerFactory());
        } else if ((obj instanceof ContentHandler) && !(obj instanceof AbstractRecursiveParserWrapperHandler)) {
            list.add(new ContentHandlerResource((ContentHandler) obj));
            obj = new ContentHandlerProxy(size);
        } else if (obj instanceof ClassLoader) {
            list.add(new ClassLoaderResource((ClassLoader) obj));
            obj = new ClassLoaderProxy(size);
        }
        try {
            ForkObjectInputStream.b(obj, this.e);
            h(list);
        } catch (NotSerializableException e2) {
            throw new TikaException("Unable to serialize " + obj.getClass().getSimpleName() + " to pass to the Forked Parser", e2);
        }
    }

    public final Throwable h(List list) {
        this.e.flush();
        while (!Thread.currentThread().isInterrupted()) {
            int read = this.f.read();
            if (read == -1) {
                throw new IOException("Lost connection to a forked server process");
            } else if (read == 3) {
                ((ForkResource) list.get(this.f.readUnsignedByte())).a(this.f, this.e);
            } else if (((byte) read) != -1) {
                return null;
            } else {
                try {
                    return (Throwable) ForkObjectInputStream.a(this.f, this.b);
                } catch (ClassNotFoundException e2) {
                    throw new IOException("Unable to deserialize an exception", e2);
                }
            }
        }
        throw new IOException(new InterruptedException());
    }

    public final void i() {
        int read;
        do {
            read = this.f.read();
            byte b2 = (byte) read;
            if (b2 != 4) {
                if (b2 == 5) {
                    throw new IOException("Server had a catastrophic initialization failure");
                }
            } else {
                return;
            }
        } while (read != -1);
        throw new IOException("EOF while waiting for start beacon");
    }

    public ForkClient(Path path, ParserFactoryFactory parserFactoryFactory, ClassLoader classLoader, List list, TimeoutLimits timeoutLimits) {
        String str;
        ArrayList arrayList = new ArrayList();
        this.f10064a = arrayList;
        this.g = i.incrementAndGet();
        this.h = 0;
        this.c = null;
        this.b = null;
        ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
        ArrayList arrayList2 = new ArrayList(list);
        arrayList2.add("-cp");
        String path2 = path.toAbsolutePath().toString();
        if (!path2.endsWith("/")) {
            str = path2 + "/*";
        } else {
            str = path2 + "/";
        }
        arrayList2.add(ProcessUtils.b(str));
        arrayList2.add("org.apache.tika.fork.ForkServer");
        arrayList2.add(Long.toString(timeoutLimits.b()));
        arrayList2.add(Long.toString(timeoutLimits.a()));
        arrayList2.add(Long.toString(timeoutLimits.c()));
        processBuilder.command(arrayList2);
        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
        try {
            Process start = processBuilder.start();
            this.d = start;
            DataOutputStream dataOutputStream = new DataOutputStream(start.getOutputStream());
            this.e = dataOutputStream;
            this.f = new DataInputStream(start.getInputStream());
            i();
            if (classLoader != null) {
                dataOutputStream.writeByte(8);
            } else {
                dataOutputStream.writeByte(6);
            }
            dataOutputStream.flush();
            g(parserFactoryFactory, arrayList);
            if (classLoader != null) {
                g(classLoader, arrayList);
            }
            i();
        } catch (Throwable th) {
            b();
            throw th;
        }
    }

    public ForkClient(ClassLoader classLoader, Object obj, List list, TimeoutLimits timeoutLimits) {
        ArrayList arrayList = new ArrayList();
        this.f10064a = arrayList;
        this.g = i.incrementAndGet();
        this.h = 0;
        try {
            this.b = classLoader;
            File c2 = c();
            this.c = c2;
            ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
            ArrayList arrayList2 = new ArrayList(list);
            arrayList2.add("-jar");
            arrayList2.add(c2.getPath());
            arrayList2.add(Long.toString(timeoutLimits.b()));
            arrayList2.add(Long.toString(timeoutLimits.a()));
            arrayList2.add(Long.toString(timeoutLimits.c()));
            processBuilder.command(arrayList2);
            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
            Process start = processBuilder.start();
            this.d = start;
            DataOutputStream dataOutputStream = new DataOutputStream(start.getOutputStream());
            this.e = dataOutputStream;
            this.f = new DataInputStream(start.getInputStream());
            i();
            dataOutputStream.writeByte(7);
            dataOutputStream.flush();
            g(classLoader, arrayList);
            g(obj, arrayList);
            i();
        } catch (Throwable th) {
            b();
            throw th;
        }
    }
}

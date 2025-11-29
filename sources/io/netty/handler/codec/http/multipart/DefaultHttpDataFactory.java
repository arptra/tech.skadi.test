package io.netty.handler.codec.http.multipart;

import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DefaultHttpDataFactory implements HttpDataFactory {
    public static final long MAXSIZE = -1;
    public static final long MINSIZE = 16384;
    private String baseDir;
    private Charset charset;
    private final boolean checkSize;
    private boolean deleteOnExit;
    private long maxSize;
    private long minSize;
    private final Map<HttpRequest, List<HttpData>> requestFileDeleteMap;
    private final boolean useDisk;

    public DefaultHttpDataFactory() {
        this.maxSize = -1;
        this.charset = HttpConstants.DEFAULT_CHARSET;
        this.requestFileDeleteMap = Collections.synchronizedMap(new IdentityHashMap());
        this.useDisk = false;
        this.checkSize = true;
        this.minSize = 16384;
    }

    private static void checkHttpDataSize(HttpData httpData) {
        try {
            httpData.checkSize(httpData.length());
        } catch (IOException unused) {
            throw new IllegalArgumentException("Attribute bigger than maxSize allowed");
        }
    }

    private List<HttpData> getList(HttpRequest httpRequest) {
        List<HttpData> list = this.requestFileDeleteMap.get(httpRequest);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        this.requestFileDeleteMap.put(httpRequest, arrayList);
        return arrayList;
    }

    public void cleanAllHttpData() {
        Iterator<Map.Entry<HttpRequest, List<HttpData>>> it = this.requestFileDeleteMap.entrySet().iterator();
        while (it.hasNext()) {
            for (HttpData release : (List) it.next().getValue()) {
                release.release();
            }
            it.remove();
        }
    }

    public void cleanAllHttpDatas() {
        cleanAllHttpData();
    }

    public void cleanRequestHttpData(HttpRequest httpRequest) {
        List<HttpData> remove = this.requestFileDeleteMap.remove(httpRequest);
        if (remove != null) {
            for (HttpData release : remove) {
                release.release();
            }
        }
    }

    public void cleanRequestHttpDatas(HttpRequest httpRequest) {
        cleanRequestHttpData(httpRequest);
    }

    public Attribute createAttribute(HttpRequest httpRequest, String str) {
        if (this.useDisk) {
            DiskAttribute diskAttribute = new DiskAttribute(str, this.charset, this.baseDir, this.deleteOnExit);
            diskAttribute.setMaxSize(this.maxSize);
            getList(httpRequest).add(diskAttribute);
            return diskAttribute;
        } else if (this.checkSize) {
            MixedAttribute mixedAttribute = new MixedAttribute(str, this.minSize, this.charset, this.baseDir, this.deleteOnExit);
            mixedAttribute.setMaxSize(this.maxSize);
            getList(httpRequest).add(mixedAttribute);
            return mixedAttribute;
        } else {
            MemoryAttribute memoryAttribute = new MemoryAttribute(str);
            memoryAttribute.setMaxSize(this.maxSize);
            return memoryAttribute;
        }
    }

    public FileUpload createFileUpload(HttpRequest httpRequest, String str, String str2, String str3, String str4, Charset charset2, long j) {
        if (this.useDisk) {
            DiskFileUpload diskFileUpload = new DiskFileUpload(str, str2, str3, str4, charset2, j, this.baseDir, this.deleteOnExit);
            diskFileUpload.setMaxSize(this.maxSize);
            checkHttpDataSize(diskFileUpload);
            getList(httpRequest).add(diskFileUpload);
            return diskFileUpload;
        } else if (this.checkSize) {
            MixedFileUpload mixedFileUpload = new MixedFileUpload(str, str2, str3, str4, charset2, j, this.minSize, this.baseDir, this.deleteOnExit);
            mixedFileUpload.setMaxSize(this.maxSize);
            checkHttpDataSize(mixedFileUpload);
            getList(httpRequest).add(mixedFileUpload);
            return mixedFileUpload;
        } else {
            MemoryFileUpload memoryFileUpload = new MemoryFileUpload(str, str2, str3, str4, charset2, j);
            memoryFileUpload.setMaxSize(this.maxSize);
            checkHttpDataSize(memoryFileUpload);
            return memoryFileUpload;
        }
    }

    public void removeHttpDataFromClean(HttpRequest httpRequest, InterfaceHttpData interfaceHttpData) {
        List list;
        if ((interfaceHttpData instanceof HttpData) && (list = this.requestFileDeleteMap.get(httpRequest)) != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((HttpData) it.next()) == interfaceHttpData) {
                    it.remove();
                    if (list.isEmpty()) {
                        this.requestFileDeleteMap.remove(httpRequest);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void setBaseDir(String str) {
        this.baseDir = str;
    }

    public void setDeleteOnExit(boolean z) {
        this.deleteOnExit = z;
    }

    public void setMaxLimit(long j) {
        this.maxSize = j;
    }

    public DefaultHttpDataFactory(Charset charset2) {
        this();
        this.charset = charset2;
    }

    public DefaultHttpDataFactory(boolean z) {
        this.maxSize = -1;
        this.charset = HttpConstants.DEFAULT_CHARSET;
        this.requestFileDeleteMap = Collections.synchronizedMap(new IdentityHashMap());
        this.useDisk = z;
        this.checkSize = false;
    }

    public Attribute createAttribute(HttpRequest httpRequest, String str, long j) {
        if (this.useDisk) {
            DiskAttribute diskAttribute = new DiskAttribute(str, j, this.charset, this.baseDir, this.deleteOnExit);
            diskAttribute.setMaxSize(this.maxSize);
            getList(httpRequest).add(diskAttribute);
            return diskAttribute;
        } else if (this.checkSize) {
            MixedAttribute mixedAttribute = new MixedAttribute(str, j, this.minSize, this.charset, this.baseDir, this.deleteOnExit);
            mixedAttribute.setMaxSize(this.maxSize);
            getList(httpRequest).add(mixedAttribute);
            return mixedAttribute;
        } else {
            MemoryAttribute memoryAttribute = new MemoryAttribute(str, j);
            memoryAttribute.setMaxSize(this.maxSize);
            return memoryAttribute;
        }
    }

    public DefaultHttpDataFactory(boolean z, Charset charset2) {
        this(z);
        this.charset = charset2;
    }

    public DefaultHttpDataFactory(long j) {
        this.maxSize = -1;
        this.charset = HttpConstants.DEFAULT_CHARSET;
        this.requestFileDeleteMap = Collections.synchronizedMap(new IdentityHashMap());
        this.useDisk = false;
        this.checkSize = true;
        this.minSize = j;
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [io.netty.handler.codec.http.multipart.Attribute, io.netty.handler.codec.http.multipart.HttpData, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v3, types: [io.netty.handler.codec.http.multipart.MixedAttribute] */
    /* JADX WARNING: type inference failed for: r1v3, types: [io.netty.handler.codec.http.multipart.DiskAttribute] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.netty.handler.codec.http.multipart.Attribute createAttribute(io.netty.handler.codec.http.HttpRequest r12, java.lang.String r13, java.lang.String r14) {
        /*
            r11 = this;
            boolean r0 = r11.useDisk
            if (r0 == 0) goto L_0x0038
            io.netty.handler.codec.http.multipart.DiskAttribute r0 = new io.netty.handler.codec.http.multipart.DiskAttribute     // Catch:{ IOException -> 0x0018 }
            java.nio.charset.Charset r4 = r11.charset     // Catch:{ IOException -> 0x0018 }
            java.lang.String r5 = r11.baseDir     // Catch:{ IOException -> 0x0018 }
            boolean r6 = r11.deleteOnExit     // Catch:{ IOException -> 0x0018 }
            r1 = r0
            r2 = r13
            r3 = r14
            r1.<init>((java.lang.String) r2, (java.lang.String) r3, (java.nio.charset.Charset) r4, (java.lang.String) r5, (boolean) r6)     // Catch:{ IOException -> 0x0018 }
            long r1 = r11.maxSize     // Catch:{ IOException -> 0x0018 }
            r0.setMaxSize(r1)     // Catch:{ IOException -> 0x0018 }
            goto L_0x002d
        L_0x0018:
            io.netty.handler.codec.http.multipart.MixedAttribute r0 = new io.netty.handler.codec.http.multipart.MixedAttribute
            long r6 = r11.minSize
            java.nio.charset.Charset r8 = r11.charset
            java.lang.String r9 = r11.baseDir
            boolean r10 = r11.deleteOnExit
            r3 = r0
            r4 = r13
            r5 = r14
            r3.<init>((java.lang.String) r4, (java.lang.String) r5, (long) r6, (java.nio.charset.Charset) r8, (java.lang.String) r9, (boolean) r10)
            long r13 = r11.maxSize
            r0.setMaxSize(r13)
        L_0x002d:
            checkHttpDataSize(r0)
            java.util.List r11 = r11.getList(r12)
            r11.add(r0)
            return r0
        L_0x0038:
            boolean r0 = r11.checkSize
            if (r0 == 0) goto L_0x005c
            io.netty.handler.codec.http.multipart.MixedAttribute r0 = new io.netty.handler.codec.http.multipart.MixedAttribute
            long r4 = r11.minSize
            java.nio.charset.Charset r6 = r11.charset
            java.lang.String r7 = r11.baseDir
            boolean r8 = r11.deleteOnExit
            r1 = r0
            r2 = r13
            r3 = r14
            r1.<init>((java.lang.String) r2, (java.lang.String) r3, (long) r4, (java.nio.charset.Charset) r6, (java.lang.String) r7, (boolean) r8)
            long r13 = r11.maxSize
            r0.setMaxSize(r13)
            checkHttpDataSize(r0)
            java.util.List r11 = r11.getList(r12)
            r11.add(r0)
            return r0
        L_0x005c:
            io.netty.handler.codec.http.multipart.MemoryAttribute r12 = new io.netty.handler.codec.http.multipart.MemoryAttribute     // Catch:{ IOException -> 0x006c }
            java.nio.charset.Charset r0 = r11.charset     // Catch:{ IOException -> 0x006c }
            r12.<init>((java.lang.String) r13, (java.lang.String) r14, (java.nio.charset.Charset) r0)     // Catch:{ IOException -> 0x006c }
            long r13 = r11.maxSize     // Catch:{ IOException -> 0x006c }
            r12.setMaxSize(r13)     // Catch:{ IOException -> 0x006c }
            checkHttpDataSize(r12)     // Catch:{ IOException -> 0x006c }
            return r12
        L_0x006c:
            r11 = move-exception
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.DefaultHttpDataFactory.createAttribute(io.netty.handler.codec.http.HttpRequest, java.lang.String, java.lang.String):io.netty.handler.codec.http.multipart.Attribute");
    }

    public DefaultHttpDataFactory(long j, Charset charset2) {
        this(j);
        this.charset = charset2;
    }
}

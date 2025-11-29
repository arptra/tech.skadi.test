package org.apache.tika.fork;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class MemoryURLStreamHandler extends URLStreamHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicInteger f10069a = new AtomicInteger();
    public static final List b = new LinkedList();

    public static URL a(byte[] bArr) {
        try {
            int incrementAndGet = f10069a.incrementAndGet();
            URL url = new URL("tika-in-memory", "localhost", "/" + incrementAndGet);
            MemoryURLStreamRecord memoryURLStreamRecord = new MemoryURLStreamRecord();
            memoryURLStreamRecord.f10070a = new WeakReference(url);
            memoryURLStreamRecord.b = bArr;
            b.add(memoryURLStreamRecord);
            return url;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public URLConnection openConnection(URL url) {
        Iterator it = b.iterator();
        while (it.hasNext()) {
            MemoryURLStreamRecord memoryURLStreamRecord = (MemoryURLStreamRecord) it.next();
            URL url2 = (URL) memoryURLStreamRecord.f10070a.get();
            if (url2 == null) {
                it.remove();
            } else if (url2 == url) {
                return new MemoryURLConnection(url, memoryURLStreamRecord.b);
            }
        }
        throw new IOException("Unknown URL: " + url);
    }
}

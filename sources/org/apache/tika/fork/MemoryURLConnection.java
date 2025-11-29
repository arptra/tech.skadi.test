package org.apache.tika.fork;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

class MemoryURLConnection extends URLConnection {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f10068a;

    public MemoryURLConnection(URL url, byte[] bArr) {
        super(url);
        this.f10068a = bArr;
    }

    public void connect() {
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.f10068a);
    }
}

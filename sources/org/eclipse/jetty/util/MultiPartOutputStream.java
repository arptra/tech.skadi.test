package org.eclipse.jetty.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MultiPartOutputStream extends FilterOutputStream {
    public static String MULTIPART_MIXED = "multipart/mixed";
    public static String MULTIPART_X_MIXED_REPLACE = "multipart/x-mixed-replace";
    private static final byte[] __CRLF = {13, 10};
    private static final byte[] __DASHDASH = {45, 45};
    private String boundary;
    private byte[] boundaryBytes;
    private boolean inPart = false;

    public MultiPartOutputStream(OutputStream outputStream) throws IOException {
        super(outputStream);
        String str = "jetty" + System.identityHashCode(this) + Long.toString(System.currentTimeMillis(), 36);
        this.boundary = str;
        this.boundaryBytes = str.getBytes("ISO-8859-1");
        this.inPart = false;
    }

    public void close() throws IOException {
        if (this.inPart) {
            this.out.write(__CRLF);
        }
        OutputStream outputStream = this.out;
        byte[] bArr = __DASHDASH;
        outputStream.write(bArr);
        this.out.write(this.boundaryBytes);
        this.out.write(bArr);
        this.out.write(__CRLF);
        this.inPart = false;
        super.close();
    }

    public String getBoundary() {
        return this.boundary;
    }

    public OutputStream getOut() {
        return this.out;
    }

    public void startPart(String str) throws IOException {
        if (this.inPart) {
            this.out.write(__CRLF);
        }
        this.inPart = true;
        this.out.write(__DASHDASH);
        this.out.write(this.boundaryBytes);
        OutputStream outputStream = this.out;
        byte[] bArr = __CRLF;
        outputStream.write(bArr);
        if (str != null) {
            OutputStream outputStream2 = this.out;
            outputStream2.write(("Content-Type: " + str).getBytes("ISO-8859-1"));
        }
        this.out.write(bArr);
        this.out.write(bArr);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
    }

    public void startPart(String str, String[] strArr) throws IOException {
        if (this.inPart) {
            this.out.write(__CRLF);
        }
        this.inPart = true;
        this.out.write(__DASHDASH);
        this.out.write(this.boundaryBytes);
        OutputStream outputStream = this.out;
        byte[] bArr = __CRLF;
        outputStream.write(bArr);
        if (str != null) {
            OutputStream outputStream2 = this.out;
            outputStream2.write(("Content-Type: " + str).getBytes("ISO-8859-1"));
        }
        this.out.write(bArr);
        int i = 0;
        while (strArr != null && i < strArr.length) {
            this.out.write(strArr[i].getBytes("ISO-8859-1"));
            this.out.write(__CRLF);
            i++;
        }
        this.out.write(__CRLF);
    }
}

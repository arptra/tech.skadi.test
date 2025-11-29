package org.eclipse.jetty.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class MultiPartInputStream {
    private static final Logger LOG = Log.getLogger((Class<?>) MultiPartInputStream.class);
    public static final MultipartConfigElement __DEFAULT_MULTIPART_CONFIG = new MultipartConfigElement(System.getProperty("java.io.tmpdir"));
    protected MultipartConfigElement _config;
    protected String _contentType;
    protected File _contextTmpDir;
    protected boolean _deleteOnExit;
    protected InputStream _in;
    protected MultiMap<String> _parts;
    protected File _tmpDir;

    public static class Base64InputStream extends InputStream {
        byte[] _buffer;
        ReadLineInputStream _in;
        String _line;
        int _pos;

        public Base64InputStream(ReadLineInputStream readLineInputStream) {
            this._in = readLineInputStream;
        }

        public int read() throws IOException {
            byte[] bArr = this._buffer;
            if (bArr == null || this._pos >= bArr.length) {
                String readLine = this._in.readLine();
                this._line = readLine;
                if (readLine == null) {
                    return -1;
                }
                if (readLine.startsWith("--")) {
                    this._buffer = (this._line + "\r\n").getBytes();
                } else if (this._line.length() == 0) {
                    this._buffer = "\r\n".getBytes();
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(((this._line.length() * 4) / 3) + 2);
                    B64Code.decode(this._line, byteArrayOutputStream);
                    byteArrayOutputStream.write(13);
                    byteArrayOutputStream.write(10);
                    this._buffer = byteArrayOutputStream.toByteArray();
                }
                this._pos = 0;
            }
            byte[] bArr2 = this._buffer;
            int i = this._pos;
            this._pos = i + 1;
            return bArr2[i];
        }
    }

    public MultiPartInputStream(InputStream inputStream, String str, MultipartConfigElement multipartConfigElement, File file) {
        this._in = new ReadLineInputStream(inputStream);
        this._contentType = str;
        this._config = multipartConfigElement;
        this._contextTmpDir = file;
        if (file == null) {
            this._contextTmpDir = new File(System.getProperty("java.io.tmpdir"));
        }
        if (this._config == null) {
            this._config = new MultipartConfigElement(this._contextTmpDir.getAbsolutePath());
        }
    }

    private String filenameValue(String str) {
        String trim = str.substring(str.indexOf(61) + 1).trim();
        if (!trim.matches(".??[a-z,A-Z]\\:\\\\[^\\\\].*")) {
            return QuotedStringTokenizer.unquoteOnly(trim, true);
        }
        char charAt = trim.charAt(0);
        if (charAt == '\"' || charAt == '\'') {
            trim = trim.substring(1);
        }
        char charAt2 = trim.charAt(trim.length() - 1);
        return (charAt2 == '\"' || charAt2 == '\'') ? trim.substring(0, trim.length() - 1) : trim;
    }

    private String value(String str, boolean z) {
        return QuotedStringTokenizer.unquoteOnly(str.substring(str.indexOf(61) + 1).trim());
    }

    public void deleteParts() throws MultiException {
        Collection<Part> parsedParts = getParsedParts();
        MultiException multiException = new MultiException();
        Iterator<Part> it = parsedParts.iterator();
        while (it.hasNext()) {
            try {
                ((Part) it.next()).cleanUp();
            } catch (Exception e) {
                multiException.add(e);
            }
        }
        this._parts.clear();
        multiException.ifExceptionThrowMulti();
    }

    public Collection<Part> getParsedParts() {
        MultiMap<String> multiMap = this._parts;
        if (multiMap == null) {
            return Collections.emptyList();
        }
        Collection<Object> values = multiMap.values();
        ArrayList arrayList = new ArrayList();
        for (Object list : values) {
            arrayList.addAll(LazyList.getList(list, false));
        }
        return arrayList;
    }

    public Part getPart(String str) throws IOException, ServletException {
        parse();
        return (Part) this._parts.getValue(str, 0);
    }

    public Collection<Part> getParts() throws IOException, ServletException {
        parse();
        Collection<Object> values = this._parts.values();
        ArrayList arrayList = new ArrayList();
        for (Object list : values) {
            arrayList.addAll(LazyList.getList(list, false));
        }
        return arrayList;
    }

    public boolean isDeleteOnExit() {
        return this._deleteOnExit;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0217, code lost:
        if (r14 != r6[r7]) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0219, code lost:
        r7 = r7 + 1;
        r5 = -2;
        r12 = -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x021e, code lost:
        if (r11 == false) goto L_0x0225;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0220, code lost:
        r3.write(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0225, code lost:
        if (r13 == false) goto L_0x022a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0227, code lost:
        r3.write(10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x022a, code lost:
        if (r7 <= 0) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x022c, code lost:
        r3.write(r6, 0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0230, code lost:
        r3.write(r14);
        r7 = -1;
        r5 = -2;
        r11 = false;
        r12 = -2;
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0239, code lost:
        if (r14 != r12) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x023b, code lost:
        r4.mark(1);
        r12 = r4.read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0243, code lost:
        if (r12 == 10) goto L_0x0249;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0245, code lost:
        r4.reset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0248, code lost:
        r12 = -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0249, code lost:
        if (r7 <= 0) goto L_0x0254;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x024e, code lost:
        if (r7 < (r6.length - 2)) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0251, code lost:
        r21 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0254, code lost:
        r21 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0259, code lost:
        if (r7 != (r6.length - 1)) goto L_0x026e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x025b, code lost:
        if (r11 == false) goto L_0x0262;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x025d, code lost:
        r3.write(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0262, code lost:
        if (r13 == false) goto L_0x0267;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0264, code lost:
        r3.write(10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0267, code lost:
        r3.write(r6, 0, r7);
        r7 = -1;
        r11 = false;
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x026e, code lost:
        if (r7 > 0) goto L_0x0297;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0271, code lost:
        if (r14 != -1) goto L_0x0274;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0274, code lost:
        if (r11 == false) goto L_0x027b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0276, code lost:
        r3.write(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x027b, code lost:
        if (r13 == false) goto L_0x0280;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x027d, code lost:
        r3.write(10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0282, code lost:
        if (r14 != 13) goto L_0x0287;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0284, code lost:
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0287, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0288, code lost:
        if (r14 == 10) goto L_0x028f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x028a, code lost:
        if (r12 != 10) goto L_0x028d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x028d, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x028f, code lost:
        r11 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0291, code lost:
        if (r12 != 10) goto L_0x0294;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0293, code lost:
        r12 = -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0294, code lost:
        r5 = -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0298, code lost:
        if (r7 != r6.length) goto L_0x029c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x029a, code lost:
        r8 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x029c, code lost:
        r3.close();
        r3 = r20;
        r5 = r21;
        r4 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02a7, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02aa, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02b2, code lost:
        throw new java.io.IOException("Missing content-disposition");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0120, code lost:
        if (r13 == null) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0122, code lost:
        r12 = new org.eclipse.jetty.util.QuotedStringTokenizer(r13, r4, r7, r5);
        r16 = r7;
        r7 = null;
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x012f, code lost:
        if (r12.hasMoreTokens() == false) goto L_0x0170;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0131, code lost:
        r5 = r12.nextToken().trim();
        r20 = r3;
        r3 = r5.toLowerCase(java.util.Locale.ENGLISH);
        r22 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0149, code lost:
        if (r5.startsWith("form-data") == false) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x014b, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0154, code lost:
        if (r3.startsWith("name=") == false) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0156, code lost:
        r13 = value(r5, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0163, code lost:
        if (r3.startsWith("filename=") == false) goto L_0x016a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0165, code lost:
        r7 = filenameValue(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x016a, code lost:
        r3 = r20;
        r4 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0170, code lost:
        r20 = r3;
        r22 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0174, code lost:
        if (r16 != false) goto L_0x0177;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0177, code lost:
        if (r13 != null) goto L_0x0180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0179, code lost:
        r3 = r20;
        r4 = r22;
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x017e, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0180, code lost:
        r3 = new org.eclipse.jetty.util.MultiPartInputStream.MultiPart(r0, r13, r7);
        r3.setHeaders(r11);
        r3.setContentType(r14);
        r0._parts.add(r13, r3);
        r3.open();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0199, code lost:
        if (io.netty.handler.codec.http.HttpHeaders.Values.BASE64.equalsIgnoreCase(r15) == false) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x019b, code lost:
        r4 = new org.eclipse.jetty.util.MultiPartInputStream.Base64InputStream((org.eclipse.jetty.util.ReadLineInputStream) r0._in);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01ab, code lost:
        if (io.netty.handler.codec.http.HttpHeaders.Values.QUOTED_PRINTABLE.equalsIgnoreCase(r15) == false) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01ad, code lost:
        r4 = new org.eclipse.jetty.util.MultiPartInputStream.AnonymousClass1(r0, r0._in);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01b5, code lost:
        r4 = r0._in;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01b7, code lost:
        r5 = -2;
        r12 = -2;
        r7 = false;
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01bb, code lost:
        r13 = r11;
        r11 = r7;
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01be, code lost:
        if (r12 == r5) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01c0, code lost:
        r14 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r14 = r4.read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c9, code lost:
        if (r14 == -1) goto L_0x0249;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01cb, code lost:
        r9 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01d9, code lost:
        if (r0._config.getMaxRequestSize() <= 0) goto L_0x01e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01e3, code lost:
        if (r9 > r0._config.getMaxRequestSize()) goto L_0x01e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e5, code lost:
        r12 = 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0205, code lost:
        throw new java.lang.IllegalStateException("Request exceeds maxRequestSize (" + r0._config.getMaxRequestSize() + ")");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0206, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0209, code lost:
        if (r14 == 13) goto L_0x0239;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x020b, code lost:
        if (r14 != 10) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x020d, code lost:
        r12 = 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0210, code lost:
        if (r7 < 0) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0213, code lost:
        if (r7 >= r6.length) goto L_0x021e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse() throws java.io.IOException, javax.servlet.ServletException {
        /*
            r25 = this;
            r0 = r25
            java.lang.String r1 = "Badly formatted multipart request"
            org.eclipse.jetty.util.MultiMap<java.lang.String> r2 = r0._parts
            if (r2 == 0) goto L_0x0009
            return
        L_0x0009:
            org.eclipse.jetty.util.MultiMap r2 = new org.eclipse.jetty.util.MultiMap
            r2.<init>()
            r0._parts = r2
            java.lang.String r2 = r0._contentType
            if (r2 == 0) goto L_0x0365
            java.lang.String r3 = "multipart/form-data"
            boolean r2 = r2.startsWith(r3)
            if (r2 != 0) goto L_0x001e
            goto L_0x0365
        L_0x001e:
            javax.servlet.MultipartConfigElement r2 = r0._config
            java.lang.String r2 = r2.getLocation()
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x002d
            java.io.File r2 = r0._contextTmpDir
            r0._tmpDir = r2
            goto L_0x0061
        L_0x002d:
            javax.servlet.MultipartConfigElement r2 = r0._config
            java.lang.String r2 = r2.getLocation()
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x003e
            java.io.File r2 = r0._contextTmpDir
            r0._tmpDir = r2
            goto L_0x0061
        L_0x003e:
            java.io.File r2 = new java.io.File
            javax.servlet.MultipartConfigElement r4 = r0._config
            java.lang.String r4 = r4.getLocation()
            r2.<init>(r4)
            boolean r4 = r2.isAbsolute()
            if (r4 == 0) goto L_0x0052
            r0._tmpDir = r2
            goto L_0x0061
        L_0x0052:
            java.io.File r2 = new java.io.File
            java.io.File r4 = r0._contextTmpDir
            javax.servlet.MultipartConfigElement r5 = r0._config
            java.lang.String r5 = r5.getLocation()
            r2.<init>(r4, r5)
            r0._tmpDir = r2
        L_0x0061:
            java.io.File r2 = r0._tmpDir
            boolean r2 = r2.exists()
            if (r2 != 0) goto L_0x006e
            java.io.File r2 = r0._tmpDir
            r2.mkdirs()
        L_0x006e:
            java.lang.String r2 = r0._contentType
            java.lang.String r4 = "boundary="
            int r2 = r2.indexOf(r4)
            java.lang.String r4 = ";"
            r5 = 1
            if (r2 < 0) goto L_0x009c
            java.lang.String r6 = r0._contentType
            int r6 = r6.indexOf(r4, r2)
            if (r6 >= 0) goto L_0x0089
            java.lang.String r6 = r0._contentType
            int r6 = r6.length()
        L_0x0089:
            java.lang.String r7 = r0._contentType
            java.lang.String r2 = r7.substring(r2, r6)
            java.lang.String r2 = r0.value(r2, r5)
            java.lang.String r2 = r2.trim()
            java.lang.String r2 = org.eclipse.jetty.util.QuotedStringTokenizer.unquote(r2)
            goto L_0x009d
        L_0x009c:
            r2 = r3
        L_0x009d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "--"
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "ISO-8859-1"
            byte[] r6 = r6.getBytes(r7)
            r7 = 0
            java.io.InputStream r8 = r0._in     // Catch:{ IOException -> 0x035b }
            org.eclipse.jetty.util.ReadLineInputStream r8 = (org.eclipse.jetty.util.ReadLineInputStream) r8     // Catch:{ IOException -> 0x035b }
            java.lang.String r8 = r8.readLine()     // Catch:{ IOException -> 0x035b }
            if (r8 == 0) goto L_0x0353
            java.lang.String r8 = r8.trim()
            r9 = r7
        L_0x00d3:
            if (r8 == 0) goto L_0x00f5
            boolean r10 = r8.equals(r2)
            if (r10 != 0) goto L_0x00f5
            if (r9 != 0) goto L_0x00e5
            org.eclipse.jetty.util.log.Logger r8 = LOG
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r8.warn((java.lang.String) r1, (java.lang.Object[]) r9)
            r9 = r5
        L_0x00e5:
            java.io.InputStream r8 = r0._in
            org.eclipse.jetty.util.ReadLineInputStream r8 = (org.eclipse.jetty.util.ReadLineInputStream) r8
            java.lang.String r8 = r8.readLine()
            if (r8 != 0) goto L_0x00f0
            goto L_0x00d3
        L_0x00f0:
            java.lang.String r8 = r8.trim()
            goto L_0x00d3
        L_0x00f5:
            if (r8 == 0) goto L_0x034b
            int r1 = r8.length()
            if (r1 == 0) goto L_0x034b
            r8 = r7
            r9 = 0
        L_0x0100:
            if (r8 != 0) goto L_0x0340
            org.eclipse.jetty.util.MultiMap r11 = new org.eclipse.jetty.util.MultiMap
            r11.<init>()
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x010a:
            java.io.InputStream r12 = r0._in
            org.eclipse.jetty.util.ReadLineInputStream r12 = (org.eclipse.jetty.util.ReadLineInputStream) r12
            java.lang.String r12 = r12.readLine()
            if (r12 != 0) goto L_0x0116
            goto L_0x0340
        L_0x0116:
            boolean r17 = r3.equals(r12)
            java.lang.String r1 = ")"
            java.lang.String r2 = "Request exceeds maxRequestSize ("
            if (r17 == 0) goto L_0x02b3
            if (r13 == 0) goto L_0x02ab
            org.eclipse.jetty.util.QuotedStringTokenizer r12 = new org.eclipse.jetty.util.QuotedStringTokenizer
            r12.<init>(r13, r4, r7, r5)
            r16 = r7
            r7 = 0
            r13 = 0
        L_0x012b:
            boolean r20 = r12.hasMoreTokens()
            if (r20 == 0) goto L_0x0170
            java.lang.String r20 = r12.nextToken()
            java.lang.String r5 = r20.trim()
            r20 = r3
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r3 = r5.toLowerCase(r3)
            r22 = r4
            java.lang.String r4 = "form-data"
            boolean r4 = r5.startsWith(r4)
            if (r4 == 0) goto L_0x014e
            r16 = 1
            goto L_0x016a
        L_0x014e:
            java.lang.String r4 = "name="
            boolean r4 = r3.startsWith(r4)
            if (r4 == 0) goto L_0x015d
            r4 = 1
            java.lang.String r3 = r0.value(r5, r4)
            r13 = r3
            goto L_0x016a
        L_0x015d:
            java.lang.String r4 = "filename="
            boolean r3 = r3.startsWith(r4)
            if (r3 == 0) goto L_0x016a
            java.lang.String r3 = r0.filenameValue(r5)
            r7 = r3
        L_0x016a:
            r3 = r20
            r4 = r22
            r5 = 1
            goto L_0x012b
        L_0x0170:
            r20 = r3
            r22 = r4
            if (r16 != 0) goto L_0x0177
            goto L_0x0179
        L_0x0177:
            if (r13 != 0) goto L_0x0180
        L_0x0179:
            r3 = r20
            r4 = r22
            r5 = 1
        L_0x017e:
            r7 = 0
            goto L_0x0100
        L_0x0180:
            org.eclipse.jetty.util.MultiPartInputStream$MultiPart r3 = new org.eclipse.jetty.util.MultiPartInputStream$MultiPart
            r3.<init>(r13, r7)
            r3.setHeaders(r11)
            r3.setContentType(r14)
            org.eclipse.jetty.util.MultiMap<java.lang.String> r4 = r0._parts
            r4.add(r13, r3)
            r3.open()
            java.lang.String r4 = "base64"
            boolean r4 = r4.equalsIgnoreCase(r15)
            if (r4 == 0) goto L_0x01a5
            org.eclipse.jetty.util.MultiPartInputStream$Base64InputStream r4 = new org.eclipse.jetty.util.MultiPartInputStream$Base64InputStream
            java.io.InputStream r5 = r0._in
            org.eclipse.jetty.util.ReadLineInputStream r5 = (org.eclipse.jetty.util.ReadLineInputStream) r5
            r4.<init>(r5)
            goto L_0x01b7
        L_0x01a5:
            java.lang.String r4 = "quoted-printable"
            boolean r4 = r4.equalsIgnoreCase(r15)
            if (r4 == 0) goto L_0x01b5
            org.eclipse.jetty.util.MultiPartInputStream$1 r4 = new org.eclipse.jetty.util.MultiPartInputStream$1
            java.io.InputStream r5 = r0._in
            r4.<init>(r5)
            goto L_0x01b7
        L_0x01b5:
            java.io.InputStream r4 = r0._in
        L_0x01b7:
            r5 = -2
            r12 = r5
            r7 = 0
            r11 = 0
        L_0x01bb:
            r13 = r11
            r11 = r7
            r7 = 0
        L_0x01be:
            if (r12 == r5) goto L_0x01c2
            r14 = r12
            goto L_0x01c6
        L_0x01c2:
            int r14 = r4.read()     // Catch:{ all -> 0x0206 }
        L_0x01c6:
            r15 = -1
            r5 = 10
            if (r14 == r15) goto L_0x0249
            r23 = 1
            long r9 = r9 + r23
            javax.servlet.MultipartConfigElement r12 = r0._config     // Catch:{ all -> 0x0206 }
            long r23 = r12.getMaxRequestSize()     // Catch:{ all -> 0x0206 }
            r18 = 0
            int r12 = (r23 > r18 ? 1 : (r23 == r18 ? 0 : -1))
            if (r12 <= 0) goto L_0x01e5
            javax.servlet.MultipartConfigElement r12 = r0._config     // Catch:{ all -> 0x0206 }
            long r23 = r12.getMaxRequestSize()     // Catch:{ all -> 0x0206 }
            int r12 = (r9 > r23 ? 1 : (r9 == r23 ? 0 : -1))
            if (r12 > 0) goto L_0x01e8
        L_0x01e5:
            r12 = 13
            goto L_0x0209
        L_0x01e8:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0206 }
            r5.<init>()     // Catch:{ all -> 0x0206 }
            r5.append(r2)     // Catch:{ all -> 0x0206 }
            javax.servlet.MultipartConfigElement r0 = r0._config     // Catch:{ all -> 0x0206 }
            long r6 = r0.getMaxRequestSize()     // Catch:{ all -> 0x0206 }
            r5.append(r6)     // Catch:{ all -> 0x0206 }
            r5.append(r1)     // Catch:{ all -> 0x0206 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0206 }
            r4.<init>(r0)     // Catch:{ all -> 0x0206 }
            throw r4     // Catch:{ all -> 0x0206 }
        L_0x0206:
            r0 = move-exception
            goto L_0x02a7
        L_0x0209:
            if (r14 == r12) goto L_0x0239
            if (r14 != r5) goto L_0x0210
            r12 = 13
            goto L_0x0239
        L_0x0210:
            if (r7 < 0) goto L_0x021e
            int r12 = r6.length     // Catch:{ all -> 0x0206 }
            if (r7 >= r12) goto L_0x021e
            byte r12 = r6[r7]     // Catch:{ all -> 0x0206 }
            if (r14 != r12) goto L_0x021e
            int r7 = r7 + 1
            r5 = -2
            r12 = -2
            goto L_0x01be
        L_0x021e:
            if (r11 == 0) goto L_0x0225
            r11 = 13
            r3.write((int) r11)     // Catch:{ all -> 0x0206 }
        L_0x0225:
            if (r13 == 0) goto L_0x022a
            r3.write((int) r5)     // Catch:{ all -> 0x0206 }
        L_0x022a:
            if (r7 <= 0) goto L_0x0230
            r5 = 0
            r3.write(r6, r5, r7)     // Catch:{ all -> 0x0206 }
        L_0x0230:
            r3.write((int) r14)     // Catch:{ all -> 0x0206 }
            r7 = r15
            r5 = -2
            r11 = 0
            r12 = -2
            r13 = 0
            goto L_0x01be
        L_0x0239:
            if (r14 != r12) goto L_0x0248
            r12 = 1
            r4.mark(r12)     // Catch:{ all -> 0x0206 }
            int r12 = r4.read()     // Catch:{ all -> 0x0206 }
            if (r12 == r5) goto L_0x0249
            r4.reset()     // Catch:{ all -> 0x0206 }
        L_0x0248:
            r12 = -2
        L_0x0249:
            if (r7 <= 0) goto L_0x0254
            int r15 = r6.length     // Catch:{ all -> 0x0206 }
            int r15 = r15 + -2
            if (r7 < r15) goto L_0x0251
            goto L_0x0254
        L_0x0251:
            r21 = 1
            goto L_0x025b
        L_0x0254:
            int r15 = r6.length     // Catch:{ all -> 0x0206 }
            r21 = 1
            int r15 = r15 + -1
            if (r7 != r15) goto L_0x026e
        L_0x025b:
            if (r11 == 0) goto L_0x0262
            r11 = 13
            r3.write((int) r11)     // Catch:{ all -> 0x0206 }
        L_0x0262:
            if (r13 == 0) goto L_0x0267
            r3.write((int) r5)     // Catch:{ all -> 0x0206 }
        L_0x0267:
            r11 = 0
            r3.write(r6, r11, r7)     // Catch:{ all -> 0x0206 }
            r7 = -1
            r11 = 0
            r13 = 0
        L_0x026e:
            if (r7 > 0) goto L_0x0297
            r15 = -1
            if (r14 != r15) goto L_0x0274
            goto L_0x0297
        L_0x0274:
            if (r11 == 0) goto L_0x027b
            r7 = 13
            r3.write((int) r7)     // Catch:{ all -> 0x0206 }
        L_0x027b:
            if (r13 == 0) goto L_0x0280
            r3.write((int) r5)     // Catch:{ all -> 0x0206 }
        L_0x0280:
            r7 = 13
            if (r14 != r7) goto L_0x0287
            r7 = r21
            goto L_0x0288
        L_0x0287:
            r7 = 0
        L_0x0288:
            if (r14 == r5) goto L_0x028f
            if (r12 != r5) goto L_0x028d
            goto L_0x028f
        L_0x028d:
            r11 = 0
            goto L_0x0291
        L_0x028f:
            r11 = r21
        L_0x0291:
            if (r12 != r5) goto L_0x0294
            r12 = -2
        L_0x0294:
            r5 = -2
            goto L_0x01bb
        L_0x0297:
            int r1 = r6.length     // Catch:{ all -> 0x0206 }
            if (r7 != r1) goto L_0x029c
            r8 = r21
        L_0x029c:
            r3.close()
            r3 = r20
            r5 = r21
            r4 = r22
            goto L_0x017e
        L_0x02a7:
            r3.close()
            throw r0
        L_0x02ab:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Missing content-disposition"
            r0.<init>(r1)
            throw r0
        L_0x02b3:
            r20 = r3
            r22 = r4
            r21 = r5
            int r3 = r12.length()
            long r3 = (long) r3
            long r9 = r9 + r3
            javax.servlet.MultipartConfigElement r3 = r0._config
            long r3 = r3.getMaxRequestSize()
            r18 = 0
            int r3 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r3 <= 0) goto L_0x02f4
            javax.servlet.MultipartConfigElement r3 = r0._config
            long r3 = r3.getMaxRequestSize()
            int r3 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x02d6
            goto L_0x02f4
        L_0x02d6:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            javax.servlet.MultipartConfigElement r0 = r0._config
            long r5 = r0.getMaxRequestSize()
            r4.append(r5)
            r4.append(r1)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            throw r3
        L_0x02f4:
            r1 = 58
            r2 = 0
            int r1 = r12.indexOf(r1, r2)
            if (r1 <= 0) goto L_0x0337
            java.lang.String r3 = r12.substring(r2, r1)
            java.lang.String r2 = r3.trim()
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r2 = r2.toLowerCase(r3)
            int r1 = r1 + 1
            int r3 = r12.length()
            java.lang.String r1 = r12.substring(r1, r3)
            java.lang.String r1 = r1.trim()
            r11.put(r2, r1)
            java.lang.String r3 = "content-disposition"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0325
            r13 = r1
        L_0x0325:
            java.lang.String r3 = "content-type"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x032e
            r14 = r1
        L_0x032e:
            java.lang.String r3 = "content-transfer-encoding"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0337
            r15 = r1
        L_0x0337:
            r3 = r20
            r5 = r21
            r4 = r22
            r7 = 0
            goto L_0x010a
        L_0x0340:
            if (r8 == 0) goto L_0x0343
            return
        L_0x0343:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Incomplete parts"
            r0.<init>(r1)
            throw r0
        L_0x034b:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Missing initial multi part boundary"
            r0.<init>(r1)
            throw r0
        L_0x0353:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Missing content for multipart request"
            r0.<init>(r1)
            throw r0
        L_0x035b:
            r0 = move-exception
            org.eclipse.jetty.util.log.Logger r2 = LOG
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r2.warn((java.lang.String) r1, (java.lang.Object[]) r3)
            throw r0
        L_0x0365:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.MultiPartInputStream.parse():void");
    }

    public void setDeleteOnExit(boolean z) {
        this._deleteOnExit = z;
    }

    public class MultiPart implements Part {
        protected ByteArrayOutputStream2 _bout;
        protected String _contentType;
        protected File _file;
        protected String _filename;
        protected MultiMap<String> _headers;
        protected String _name;
        protected OutputStream _out;
        protected long _size = 0;
        protected boolean _temporary = true;

        public MultiPart(String str, String str2) throws IOException {
            this._name = str;
            this._filename = str2;
        }

        public void cleanUp() throws IOException {
            File file;
            if (this._temporary && (file = this._file) != null && file.exists()) {
                this._file.delete();
            }
        }

        public void close() throws IOException {
            this._out.close();
        }

        public void createFile() throws IOException {
            OutputStream outputStream;
            File createTempFile = File.createTempFile("MultiPart", "", MultiPartInputStream.this._tmpDir);
            this._file = createTempFile;
            createTempFile.setReadable(false, false);
            this._file.setReadable(true, true);
            if (MultiPartInputStream.this._deleteOnExit) {
                this._file.deleteOnExit();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this._file));
            if (this._size > 0 && (outputStream = this._out) != null) {
                outputStream.flush();
                this._bout.writeTo(bufferedOutputStream);
                this._out.close();
                this._bout = null;
            }
            this._out = bufferedOutputStream;
        }

        public void delete() throws IOException {
            File file = this._file;
            if (file != null && file.exists()) {
                this._file.delete();
            }
        }

        public byte[] getBytes() {
            ByteArrayOutputStream2 byteArrayOutputStream2 = this._bout;
            if (byteArrayOutputStream2 != null) {
                return byteArrayOutputStream2.toByteArray();
            }
            return null;
        }

        public String getContentDispositionFilename() {
            return this._filename;
        }

        public String getContentType() {
            return this._contentType;
        }

        public File getFile() {
            return this._file;
        }

        public String getHeader(String str) {
            if (str == null) {
                return null;
            }
            return (String) this._headers.getValue(str.toLowerCase(Locale.ENGLISH), 0);
        }

        public Collection<String> getHeaderNames() {
            return this._headers.keySet();
        }

        public Collection<String> getHeaders(String str) {
            return this._headers.getValues(str);
        }

        public InputStream getInputStream() throws IOException {
            return this._file != null ? new BufferedInputStream(new FileInputStream(this._file)) : new ByteArrayInputStream(this._bout.getBuf(), 0, this._bout.size());
        }

        public String getName() {
            return this._name;
        }

        public long getSize() {
            return this._size;
        }

        public void open() throws IOException {
            String str = this._filename;
            if (str == null || str.trim().length() <= 0) {
                ByteArrayOutputStream2 byteArrayOutputStream2 = new ByteArrayOutputStream2();
                this._bout = byteArrayOutputStream2;
                this._out = byteArrayOutputStream2;
                return;
            }
            createFile();
        }

        public void setContentType(String str) {
            this._contentType = str;
        }

        public void setHeaders(MultiMap<String> multiMap) {
            this._headers = multiMap;
        }

        public void write(int i) throws IOException {
            if (MultiPartInputStream.this._config.getMaxFileSize() <= 0 || this._size + 1 <= MultiPartInputStream.this._config.getMaxFileSize()) {
                if (MultiPartInputStream.this._config.getFileSizeThreshold() > 0 && this._size + 1 > ((long) MultiPartInputStream.this._config.getFileSizeThreshold()) && this._file == null) {
                    createFile();
                }
                this._out.write(i);
                this._size++;
                return;
            }
            throw new IllegalStateException("Multipart Mime part " + this._name + " exceeds max filesize");
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (MultiPartInputStream.this._config.getMaxFileSize() <= 0 || this._size + ((long) i2) <= MultiPartInputStream.this._config.getMaxFileSize()) {
                if (MultiPartInputStream.this._config.getFileSizeThreshold() > 0 && this._size + ((long) i2) > ((long) MultiPartInputStream.this._config.getFileSizeThreshold()) && this._file == null) {
                    createFile();
                }
                this._out.write(bArr, i, i2);
                this._size += (long) i2;
                return;
            }
            throw new IllegalStateException("Multipart Mime part " + this._name + " exceeds max filesize");
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void write(java.lang.String r4) throws java.io.IOException {
            /*
                r3 = this;
                java.io.File r0 = r3._file
                r1 = 0
                if (r0 != 0) goto L_0x0039
                r3._temporary = r1
                java.io.File r0 = new java.io.File
                org.eclipse.jetty.util.MultiPartInputStream r1 = org.eclipse.jetty.util.MultiPartInputStream.this
                java.io.File r1 = r1._tmpDir
                r0.<init>(r1, r4)
                r3._file = r0
                r4 = 0
                java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x002f }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x002f }
                java.io.File r2 = r3._file     // Catch:{ all -> 0x002f }
                r1.<init>(r2)     // Catch:{ all -> 0x002f }
                r0.<init>(r1)     // Catch:{ all -> 0x002f }
                org.eclipse.jetty.util.ByteArrayOutputStream2 r1 = r3._bout     // Catch:{ all -> 0x002d }
                r1.writeTo(r0)     // Catch:{ all -> 0x002d }
                r0.flush()     // Catch:{ all -> 0x002d }
                r0.close()
                r3._bout = r4
                goto L_0x004e
            L_0x002d:
                r1 = move-exception
                goto L_0x0031
            L_0x002f:
                r1 = move-exception
                r0 = r4
            L_0x0031:
                if (r0 == 0) goto L_0x0036
                r0.close()
            L_0x0036:
                r3._bout = r4
                throw r1
            L_0x0039:
                r3._temporary = r1
                java.io.File r0 = new java.io.File
                org.eclipse.jetty.util.MultiPartInputStream r1 = org.eclipse.jetty.util.MultiPartInputStream.this
                java.io.File r1 = r1._tmpDir
                r0.<init>(r1, r4)
                java.io.File r4 = r3._file
                boolean r4 = r4.renameTo(r0)
                if (r4 == 0) goto L_0x004e
                r3._file = r0
            L_0x004e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.MultiPartInputStream.MultiPart.write(java.lang.String):void");
        }
    }
}

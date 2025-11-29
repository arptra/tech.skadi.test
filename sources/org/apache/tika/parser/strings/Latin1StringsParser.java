package org.apache.tika.parser.strings;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AbstractParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.XHTMLContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class Latin1StringsParser extends AbstractParser {
    private static int BUF_SIZE = 65536;
    private static final Set<MediaType> SUPPORTED_TYPES = getTypes();
    private static final boolean[] isChar = getCharMap();
    private static final long serialVersionUID = 1;
    private int inPos;
    private int inSize;
    private byte[] input;
    private int minSize = 4;
    private int outPos;
    private byte[] output;
    private int tmpPos;
    private XHTMLContentHandler xhtml;

    public Latin1StringsParser() {
        int i = BUF_SIZE;
        this.output = new byte[i];
        this.input = new byte[i];
        this.tmpPos = 0;
        this.outPos = 0;
        this.inSize = 0;
        this.inPos = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x001e A[LOOP:1: B:2:0x0011->B:4:0x001e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0024 A[EDGE_INSN: B:67:0x0024->B:5:0x0024 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0112 A[EDGE_INSN: B:69:0x0112->B:56:0x0112 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void doParse(java.io.InputStream r9, org.xml.sax.ContentHandler r10, org.apache.tika.metadata.Metadata r11, org.apache.tika.parser.ParseContext r12) throws java.io.IOException, org.xml.sax.SAXException {
        /*
            r8 = this;
            r12 = 0
            r8.tmpPos = r12
            r8.outPos = r12
            org.apache.tika.sax.XHTMLContentHandler r0 = new org.apache.tika.sax.XHTMLContentHandler
            r0.<init>(r10, r11)
            r8.xhtml = r0
            r0.startDocument()
        L_0x000f:
            r8.inSize = r12
        L_0x0011:
            byte[] r10 = r8.input
            int r11 = r8.inSize
            int r0 = BUF_SIZE
            int r0 = r0 - r11
            int r10 = r9.read(r10, r11, r0)
            if (r10 <= 0) goto L_0x0024
            int r11 = r8.inSize
            int r11 = r11 + r10
            r8.inSize = r11
            goto L_0x0011
        L_0x0024:
            r8.inPos = r12
        L_0x0026:
            int r11 = r8.inPos
            int r0 = r8.inSize
            r1 = 10
            if (r11 >= r0) goto L_0x0112
            byte[] r2 = r8.input
            int r3 = r11 + 1
            r8.inPos = r3
            byte r4 = r2[r11]
            r5 = -61
            r6 = -65
            r7 = 1
            if (r4 != r5) goto L_0x0075
            if (r3 >= r0) goto L_0x0046
            int r11 = r11 + 2
            r8.inPos = r11
            byte r11 = r2[r3]
            goto L_0x004b
        L_0x0046:
            int r11 = r9.read()
            byte r11 = (byte) r11
        L_0x004b:
            r0 = -128(0xffffffffffffff80, float:NaN)
            if (r11 < r0) goto L_0x005f
            if (r11 > r6) goto L_0x005f
            byte[] r0 = r8.output
            int r2 = r8.tmpPos
            int r3 = r2 + 1
            r8.tmpPos = r3
            int r11 = r11 + 64
            byte r11 = (byte) r11
            r0[r2] = r11
            goto L_0x006b
        L_0x005f:
            byte[] r0 = r8.output
            int r2 = r8.tmpPos
            int r3 = r2 + 1
            r8.tmpPos = r3
            r0[r2] = r4
            r4 = r11
            r7 = r12
        L_0x006b:
            int r11 = r8.tmpPos
            int r0 = BUF_SIZE
            if (r11 != r0) goto L_0x00af
            r8.flushBuffer()
            goto L_0x00af
        L_0x0075:
            r5 = -62
            if (r4 != r5) goto L_0x00ae
            if (r3 >= r0) goto L_0x0082
            int r11 = r11 + 2
            r8.inPos = r11
            byte r11 = r2[r3]
            goto L_0x0087
        L_0x0082:
            int r11 = r9.read()
            byte r11 = (byte) r11
        L_0x0087:
            r0 = -96
            if (r11 < r0) goto L_0x0098
            if (r11 > r6) goto L_0x0098
            byte[] r0 = r8.output
            int r2 = r8.tmpPos
            int r3 = r2 + 1
            r8.tmpPos = r3
            r0[r2] = r11
            goto L_0x00a4
        L_0x0098:
            byte[] r0 = r8.output
            int r2 = r8.tmpPos
            int r3 = r2 + 1
            r8.tmpPos = r3
            r0[r2] = r4
            r4 = r11
            r7 = r12
        L_0x00a4:
            int r11 = r8.tmpPos
            int r0 = BUF_SIZE
            if (r11 != r0) goto L_0x00af
            r8.flushBuffer()
            goto L_0x00af
        L_0x00ae:
            r7 = r12
        L_0x00af:
            if (r7 != 0) goto L_0x0026
            boolean r11 = isChar(r4)
            if (r11 == 0) goto L_0x00ca
            byte[] r11 = r8.output
            int r0 = r8.tmpPos
            int r1 = r0 + 1
            r8.tmpPos = r1
            r11[r0] = r4
            int r11 = BUF_SIZE
            if (r1 != r11) goto L_0x0026
            r8.flushBuffer()
            goto L_0x0026
        L_0x00ca:
            if (r4 != 0) goto L_0x00f1
            int r11 = r8.inPos
            r0 = 3
            if (r11 < r0) goto L_0x00dd
            byte[] r0 = r8.input
            int r11 = r11 + -3
            byte r11 = r0[r11]
            boolean r11 = isChar(r11)
            if (r11 != 0) goto L_0x00f1
        L_0x00dd:
            int r11 = r8.inPos
            int r0 = r11 + 1
            int r2 = r8.inSize
            if (r0 >= r2) goto L_0x0026
            byte[] r0 = r8.input
            int r11 = r11 + 1
            byte r11 = r0[r11]
            boolean r11 = isChar(r11)
            if (r11 == 0) goto L_0x0026
        L_0x00f1:
            int r11 = r8.tmpPos
            int r0 = r8.outPos
            int r2 = r11 - r0
            int r3 = r8.minSize
            if (r2 < r3) goto L_0x010e
            byte[] r0 = r8.output
            int r2 = r11 + 1
            r8.tmpPos = r2
            r0[r11] = r1
            r8.outPos = r2
            int r11 = BUF_SIZE
            if (r2 != r11) goto L_0x0026
            r8.flushBuffer()
            goto L_0x0026
        L_0x010e:
            r8.tmpPos = r0
            goto L_0x0026
        L_0x0112:
            r11 = -1
            if (r10 == r11) goto L_0x011f
            java.lang.Thread r10 = java.lang.Thread.currentThread()
            boolean r10 = r10.isInterrupted()
            if (r10 == 0) goto L_0x000f
        L_0x011f:
            int r9 = r8.tmpPos
            int r10 = r8.outPos
            int r10 = r9 - r10
            int r11 = r8.minSize
            if (r10 < r11) goto L_0x0133
            byte[] r10 = r8.output
            int r11 = r9 + 1
            r8.tmpPos = r11
            r10[r9] = r1
            r8.outPos = r11
        L_0x0133:
            org.apache.tika.sax.XHTMLContentHandler r9 = r8.xhtml
            java.lang.String r10 = new java.lang.String
            byte[] r11 = r8.output
            int r0 = r8.outPos
            java.lang.String r1 = "windows-1252"
            r10.<init>(r11, r12, r0, r1)
            r9.m(r10)
            org.apache.tika.sax.XHTMLContentHandler r8 = r8.xhtml
            r8.endDocument()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.parser.strings.Latin1StringsParser.doParse(java.io.InputStream, org.xml.sax.ContentHandler, org.apache.tika.metadata.Metadata, org.apache.tika.parser.ParseContext):void");
    }

    private void flushBuffer() throws UnsupportedEncodingException, SAXException {
        int i = this.tmpPos;
        int i2 = i - this.outPos;
        int i3 = this.minSize;
        if (i2 >= i3) {
            this.outPos = i - i3;
        }
        this.xhtml.m(new String(this.output, 0, this.outPos, "windows-1252"));
        int i4 = this.tmpPos;
        int i5 = this.outPos;
        if (i4 - i5 >= 0) {
            byte[] bArr = this.output;
            System.arraycopy(bArr, i5, bArr, 0, i4 - i5);
        }
        this.tmpPos -= this.outPos;
        this.outPos = 0;
    }

    private static boolean[] getCharMap() {
        boolean[] zArr = new boolean[256];
        for (int i = -128; i <= 127; i++) {
            if ((i >= 32 && i <= 126) || ((i >= -64 && i <= -2) || i == 10 || i == 13 || i == 9)) {
                zArr[i & 255] = true;
            }
        }
        return zArr;
    }

    private static Set<MediaType> getTypes() {
        HashSet hashSet = new HashSet();
        hashSet.add(MediaType.OCTET_STREAM);
        return hashSet;
    }

    private static final boolean isChar(byte b) {
        return isChar[b & 255];
    }

    public int getMinSize() {
        return this.minSize;
    }

    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return SUPPORTED_TYPES;
    }

    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException {
        new Latin1StringsParser().doParse(inputStream, contentHandler, metadata, parseContext);
    }

    public void setMinSize(int i) {
        this.minSize = i;
    }
}

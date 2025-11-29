package com.hp.hpl.sparta.xpath;

import java.io.IOException;
import java.io.Reader;

public class SimpleStreamTokenizer {
    private static final int QUOTE = -6;
    public static final int TT_EOF = -1;
    public static final int TT_NUMBER = -2;
    public static final int TT_WORD = -3;
    private static final int WHITESPACE = -5;
    private final StringBuffer buf_ = new StringBuffer();
    private final int[] charType_ = new int[256];
    private char inQuote_;
    private int nextType_;
    public int nval = Integer.MIN_VALUE;
    private boolean pushedBack_;
    private final Reader reader_;
    public String sval = "";
    public int ttype = Integer.MIN_VALUE;

    public SimpleStreamTokenizer(Reader reader) throws IOException {
        int i = 0;
        this.pushedBack_ = false;
        this.inQuote_ = 0;
        this.reader_ = reader;
        while (true) {
            int[] iArr = this.charType_;
            if (i >= iArr.length) {
                nextToken();
                return;
            }
            if ((65 <= i && i <= 90) || ((97 <= i && i <= 122) || i == 45)) {
                iArr[i] = -3;
            } else if (48 <= i && i <= 57) {
                iArr[i] = -2;
            } else if (i < 0 || i > 32) {
                iArr[i] = i;
            } else {
                iArr[i] = -5;
            }
            i = (char) (i + 1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int nextToken() throws java.io.IOException {
        /*
            r12 = this;
            boolean r0 = r12.pushedBack_
            r1 = 0
            if (r0 == 0) goto L_0x000a
            r12.pushedBack_ = r1
            int r12 = r12.ttype
            return r12
        L_0x000a:
            int r0 = r12.nextType_
            r12.ttype = r0
        L_0x000e:
            r0 = r1
        L_0x000f:
            java.io.Reader r2 = r12.reader_
            int r2 = r2.read()
            r3 = -1
            if (r2 != r3) goto L_0x0026
            char r4 = r12.inQuote_
            if (r4 != 0) goto L_0x001e
            r4 = r3
            goto L_0x002a
        L_0x001e:
            java.io.IOException r12 = new java.io.IOException
            java.lang.String r0 = "Unterminated quote"
            r12.<init>(r0)
            throw r12
        L_0x0026:
            int[] r4 = r12.charType_
            r4 = r4[r2]
        L_0x002a:
            char r5 = r12.inQuote_
            r6 = -5
            r7 = 1
            if (r5 != 0) goto L_0x0034
            if (r4 != r6) goto L_0x0034
            r8 = r7
            goto L_0x0035
        L_0x0034:
            r8 = r1
        L_0x0035:
            if (r0 != 0) goto L_0x003c
            if (r8 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r0 = r1
            goto L_0x003d
        L_0x003c:
            r0 = r7
        L_0x003d:
            if (r8 != 0) goto L_0x000f
            r8 = 34
            r9 = 39
            if (r4 == r9) goto L_0x0047
            if (r4 != r8) goto L_0x0051
        L_0x0047:
            if (r5 != 0) goto L_0x004d
            char r5 = (char) r4
            r12.inQuote_ = r5
            goto L_0x0051
        L_0x004d:
            if (r5 != r4) goto L_0x0051
            r12.inQuote_ = r1
        L_0x0051:
            char r5 = r12.inQuote_
            if (r5 == 0) goto L_0x0056
            r4 = r5
        L_0x0056:
            if (r0 != 0) goto L_0x0065
            int r0 = r12.ttype
            if (r0 < r3) goto L_0x0060
            if (r0 == r9) goto L_0x0060
            if (r0 != r8) goto L_0x0065
        L_0x0060:
            if (r0 == r4) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r0 = r1
            goto L_0x0066
        L_0x0065:
            r0 = r7
        L_0x0066:
            r3 = -2
            r5 = -3
            if (r0 == 0) goto L_0x00ac
            int r10 = r12.ttype
            if (r10 == r5) goto L_0x009b
            if (r10 == r3) goto L_0x008e
            if (r10 == r8) goto L_0x0075
            if (r10 == r9) goto L_0x0075
            goto L_0x00a2
        L_0x0075:
            java.lang.StringBuffer r10 = r12.buf_
            java.lang.String r10 = r10.toString()
            java.lang.StringBuffer r11 = r12.buf_
            int r11 = r11.length()
            int r11 = r11 - r7
            java.lang.String r7 = r10.substring(r7, r11)
        L_0x0086:
            r12.sval = r7
        L_0x0088:
            java.lang.StringBuffer r7 = r12.buf_
            r7.setLength(r1)
            goto L_0x00a2
        L_0x008e:
            java.lang.StringBuffer r7 = r12.buf_
            java.lang.String r7 = r7.toString()
            int r7 = java.lang.Integer.parseInt(r7)
            r12.nval = r7
            goto L_0x0088
        L_0x009b:
            java.lang.StringBuffer r7 = r12.buf_
            java.lang.String r7 = r7.toString()
            goto L_0x0086
        L_0x00a2:
            if (r4 == r6) goto L_0x00ac
            r6 = -6
            if (r4 != r6) goto L_0x00a9
            r6 = r2
            goto L_0x00aa
        L_0x00a9:
            r6 = r4
        L_0x00aa:
            r12.nextType_ = r6
        L_0x00ac:
            if (r4 == r5) goto L_0x00b5
            if (r4 == r3) goto L_0x00b5
            if (r4 == r8) goto L_0x00b5
            if (r4 == r9) goto L_0x00b5
            goto L_0x00bb
        L_0x00b5:
            java.lang.StringBuffer r3 = r12.buf_
            char r2 = (char) r2
            r3.append(r2)
        L_0x00bb:
            if (r0 == 0) goto L_0x000e
            int r12 = r12.ttype
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.xpath.SimpleStreamTokenizer.nextToken():int");
    }

    public void ordinaryChar(char c) {
        this.charType_[c] = c;
    }

    public void pushBack() {
        this.pushedBack_ = true;
    }

    public String toString() {
        int i = this.ttype;
        if (i != -3) {
            if (i == -2) {
                return Integer.toString(this.nval);
            }
            if (i == -1) {
                return "(EOF)";
            }
            if (i != 34) {
                if (i != 39) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("'");
                    stringBuffer.append((char) this.ttype);
                    stringBuffer.append("'");
                    return stringBuffer.toString();
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("'");
                stringBuffer2.append(this.sval);
                stringBuffer2.append("'");
                return stringBuffer2.toString();
            }
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("\"");
        stringBuffer3.append(this.sval);
        stringBuffer3.append("\"");
        return stringBuffer3.toString();
    }

    public void wordChars(char c, char c2) {
        while (c <= c2) {
            this.charType_[c] = -3;
            c = (char) (c + 1);
        }
    }
}

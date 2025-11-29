package com.hp.hpl.sparta;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

class ParseByteStream implements ParseSource {
    private ParseCharStream parseSource_;

    public ParseByteStream(String str, InputStream inputStream, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, IOException {
        String str3 = str;
        InputStream inputStream2 = inputStream;
        ParseLog parseLog2 = parseLog == null ? ParseSource.DEFAULT_LOG : parseLog;
        if (inputStream.markSupported()) {
            inputStream2.mark(ParseSource.MAXLOOKAHEAD);
            byte[] bArr = new byte[4];
            String guessEncoding = str2 == null ? guessEncoding(str3, bArr, inputStream2.read(bArr), parseLog2) : str2;
            try {
                inputStream.reset();
                try {
                    this.parseSource_ = new ParseCharStream(str, (Reader) new InputStreamReader(inputStream2, fixEncoding(guessEncoding)), parseLog2, guessEncoding, parseHandler);
                } catch (IOException unused) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Problem reading with assumed encoding of ");
                    stringBuffer.append(guessEncoding);
                    stringBuffer.append(" so restarting with ");
                    stringBuffer.append("euc-jp");
                    parseLog2.note(stringBuffer.toString(), str3, 1);
                    inputStream.reset();
                    this.parseSource_ = new ParseCharStream(str, (Reader) new InputStreamReader(inputStream2, fixEncoding("euc-jp")), parseLog2, (String) null, parseHandler);
                }
            } catch (UnsupportedEncodingException unused2) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("\"");
                stringBuffer2.append("euc-jp");
                stringBuffer2.append("\" is not a supported encoding");
                throw new ParseException(parseLog2, str, 1, 0, "euc-jp", stringBuffer2.toString());
            } catch (EncodingMismatchException e) {
                String declaredEncoding = e.getDeclaredEncoding();
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Encoding declaration of ");
                stringBuffer3.append(declaredEncoding);
                stringBuffer3.append(" is different that assumed ");
                stringBuffer3.append(guessEncoding);
                stringBuffer3.append(" so restarting the parsing with the new encoding");
                parseLog2.note(stringBuffer3.toString(), str3, 1);
                inputStream.reset();
                try {
                    this.parseSource_ = new ParseCharStream(str, (Reader) new InputStreamReader(inputStream2, fixEncoding(declaredEncoding)), parseLog2, (String) null, parseHandler);
                } catch (UnsupportedEncodingException unused3) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("\"");
                    stringBuffer4.append(declaredEncoding);
                    stringBuffer4.append("\" is not a supported encoding");
                    throw new ParseException(parseLog2, str, 1, 0, declaredEncoding, stringBuffer4.toString());
                }
            }
        } else {
            throw new Error("Precondition violation: the InputStream passed to ParseByteStream must support mark");
        }
    }

    private static boolean equals(byte[] bArr, int i) {
        return bArr[0] == ((byte) (i >>> 24)) && bArr[1] == ((byte) ((i >>> 16) & 255)) && bArr[2] == ((byte) ((i >>> 8) & 255)) && bArr[3] == ((byte) (i & 255));
    }

    private static String fixEncoding(String str) {
        return str.toLowerCase().equals("utf8") ? "UTF-8" : str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String guessEncoding(java.lang.String r5, byte[] r6, int r7, com.hp.hpl.sparta.ParseLog r8) throws java.io.IOException {
        /*
            r0 = 4
            r1 = 0
            r2 = 1
            java.lang.String r3 = "UTF-8"
            if (r7 == r0) goto L_0x002d
            if (r7 > 0) goto L_0x000c
            java.lang.String r7 = "no characters in input"
            goto L_0x0027
        L_0x000c:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r4 = "less than 4 characters in input: \""
            r0.append(r4)
            java.lang.String r4 = new java.lang.String
            r4.<init>(r6, r1, r7)
            r0.append(r4)
            java.lang.String r7 = "\""
            r0.append(r7)
            java.lang.String r7 = r0.toString()
        L_0x0027:
            r8.error(r7, r5, r2)
        L_0x002a:
            r7 = r3
            goto L_0x00b2
        L_0x002d:
            r7 = 65279(0xfeff, float:9.1475E-41)
            boolean r7 = equals((byte[]) r6, (int) r7)
            if (r7 != 0) goto L_0x00b0
            r7 = -131072(0xfffffffffffe0000, float:NaN)
            boolean r7 = equals((byte[]) r6, (int) r7)
            if (r7 != 0) goto L_0x00b0
            r7 = 65534(0xfffe, float:9.1833E-41)
            boolean r7 = equals((byte[]) r6, (int) r7)
            if (r7 != 0) goto L_0x00b0
            r7 = -16842752(0xfffffffffeff0000, float:-1.6947657E38)
            boolean r7 = equals((byte[]) r6, (int) r7)
            if (r7 != 0) goto L_0x00b0
            r7 = 60
            boolean r7 = equals((byte[]) r6, (int) r7)
            if (r7 != 0) goto L_0x00b0
            r7 = 1006632960(0x3c000000, float:0.0078125)
            boolean r7 = equals((byte[]) r6, (int) r7)
            if (r7 != 0) goto L_0x00b0
            r7 = 15360(0x3c00, float:2.1524E-41)
            boolean r7 = equals((byte[]) r6, (int) r7)
            if (r7 != 0) goto L_0x00b0
            r7 = 3932160(0x3c0000, float:5.51013E-39)
            boolean r7 = equals((byte[]) r6, (int) r7)
            if (r7 == 0) goto L_0x0070
            goto L_0x00b0
        L_0x0070:
            r7 = 3932223(0x3c003f, float:5.510218E-39)
            boolean r7 = equals((byte[]) r6, (int) r7)
            if (r7 == 0) goto L_0x007c
            java.lang.String r7 = "UTF-16BE"
            goto L_0x00b2
        L_0x007c:
            r7 = 1006649088(0x3c003f00, float:0.00782752)
            boolean r7 = equals((byte[]) r6, (int) r7)
            if (r7 == 0) goto L_0x0088
            java.lang.String r7 = "UTF-16LE"
            goto L_0x00b2
        L_0x0088:
            r7 = 1010792557(0x3c3f786d, float:0.011686427)
            boolean r7 = equals((byte[]) r6, (int) r7)
            if (r7 == 0) goto L_0x0092
            goto L_0x002a
        L_0x0092:
            r7 = 1282385812(0x4c6fa794, float:6.2824016E7)
            boolean r7 = equals((byte[]) r6, (int) r7)
            if (r7 == 0) goto L_0x009e
            java.lang.String r7 = "EBCDIC"
            goto L_0x00b2
        L_0x009e:
            r7 = -2
            boolean r7 = equals((byte[]) r6, (short) r7)
            if (r7 != 0) goto L_0x00ad
            r7 = -257(0xfffffffffffffeff, float:NaN)
            boolean r7 = equals((byte[]) r6, (short) r7)
            if (r7 == 0) goto L_0x002a
        L_0x00ad:
            java.lang.String r7 = "UTF-16"
            goto L_0x00b2
        L_0x00b0:
            java.lang.String r7 = "UCS-4"
        L_0x00b2:
            boolean r0 = r7.equals(r3)
            if (r0 != 0) goto L_0x0102
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r3 = "From start "
            r0.append(r3)
            byte r1 = r6[r1]
            java.lang.String r1 = hex(r1)
            r0.append(r1)
            java.lang.String r1 = " "
            r0.append(r1)
            byte r3 = r6[r2]
            java.lang.String r3 = hex(r3)
            r0.append(r3)
            r0.append(r1)
            r3 = 2
            byte r3 = r6[r3]
            java.lang.String r3 = hex(r3)
            r0.append(r3)
            r0.append(r1)
            r1 = 3
            byte r6 = r6[r1]
            java.lang.String r6 = hex(r6)
            r0.append(r6)
            java.lang.String r6 = " deduced encoding = "
            r0.append(r6)
            r0.append(r7)
            java.lang.String r6 = r0.toString()
            r8.note(r6, r5, r2)
        L_0x0102:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.ParseByteStream.guessEncoding(java.lang.String, byte[], int, com.hp.hpl.sparta.ParseLog):java.lang.String");
    }

    private static String hex(byte b) {
        String hexString = Integer.toHexString(b);
        int length = hexString.length();
        if (length != 1) {
            return length != 2 ? hexString.substring(hexString.length() - 2) : hexString;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("0");
        stringBuffer.append(hexString);
        return stringBuffer.toString();
    }

    public int getLineNumber() {
        return this.parseSource_.getLineNumber();
    }

    public String getSystemId() {
        return this.parseSource_.getSystemId();
    }

    public String toString() {
        return this.parseSource_.toString();
    }

    private static boolean equals(byte[] bArr, short s) {
        return bArr[0] == ((byte) (s >>> 8)) && bArr[1] == ((byte) (s & 255));
    }
}

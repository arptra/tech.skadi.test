package com.hp.hpl.sparta;

public class ParseException extends Exception {
    private Throwable cause_;
    private int lineNumber_;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ParseException(com.hp.hpl.sparta.ParseCharStream r3, char r4, char r5) {
        /*
            r2 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "got '"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = "' instead of expected '"
            r0.append(r4)
            r0.append(r5)
            java.lang.String r4 = "'"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r2.<init>((com.hp.hpl.sparta.ParseCharStream) r3, (java.lang.String) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.ParseException.<init>(com.hp.hpl.sparta.ParseCharStream, char, char):void");
    }

    public static String charRepr(int i) {
        if (i == -1) {
            return "EOF";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("");
        stringBuffer.append((char) i);
        return stringBuffer.toString();
    }

    private static String toMessage(String str, int i, int i2, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("(");
        stringBuffer.append(i);
        stringBuffer.append("): \n");
        stringBuffer.append(str2);
        stringBuffer.append("\nLast character read was '");
        stringBuffer.append(charRepr(i2));
        stringBuffer.append("'\n");
        stringBuffer.append(str3);
        return stringBuffer.toString();
    }

    private static String toString(char[] cArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cArr[0]);
        for (int i = 1; i < cArr.length; i++) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("or ");
            stringBuffer2.append(cArr[i]);
            stringBuffer.append(stringBuffer2.toString());
        }
        return stringBuffer.toString();
    }

    public Throwable getCause() {
        return this.cause_;
    }

    public int getLineNumber() {
        return this.lineNumber_;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ParseException(com.hp.hpl.sparta.ParseCharStream r3, char r4, java.lang.String r5) {
        /*
            r2 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "got '"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = "' instead of "
            r0.append(r4)
            r0.append(r5)
            java.lang.String r4 = " as expected"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r2.<init>((com.hp.hpl.sparta.ParseCharStream) r3, (java.lang.String) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.ParseException.<init>(com.hp.hpl.sparta.ParseCharStream, char, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ParseException(com.hp.hpl.sparta.ParseCharStream r3, char r4, char[] r5) {
        /*
            r2 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "got '"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = "' instead of "
            r0.append(r4)
            java.lang.String r4 = toString(r5)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r2.<init>((com.hp.hpl.sparta.ParseCharStream) r3, (java.lang.String) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.ParseException.<init>(com.hp.hpl.sparta.ParseCharStream, char, char[]):void");
    }

    public ParseException(ParseCharStream parseCharStream, String str) {
        this(parseCharStream.getLog(), parseCharStream.getSystemId(), parseCharStream.getLineNumber(), parseCharStream.getLastCharRead(), parseCharStream.getHistory(), str);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ParseException(com.hp.hpl.sparta.ParseCharStream r3, java.lang.String r4, java.lang.String r5) {
        /*
            r2 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "got \""
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = "\" instead of \""
            r0.append(r4)
            r0.append(r5)
            java.lang.String r4 = "\" as expected"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r2.<init>((com.hp.hpl.sparta.ParseCharStream) r3, (java.lang.String) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.ParseException.<init>(com.hp.hpl.sparta.ParseCharStream, java.lang.String, java.lang.String):void");
    }

    public ParseException(ParseCharStream parseCharStream, String str, char[] cArr) {
        this(parseCharStream, str, new String(cArr));
    }

    public ParseException(ParseLog parseLog, String str, int i, int i2, String str2, String str3) {
        this(str, i, i2, str2, str3);
        parseLog.error(str3, str, i);
    }

    public ParseException(String str) {
        super(str);
        this.lineNumber_ = -1;
        this.cause_ = null;
    }

    public ParseException(String str, int i, int i2, String str2, String str3) {
        super(toMessage(str, i, i2, str2, str3));
        this.cause_ = null;
        this.lineNumber_ = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ParseException(java.lang.String r2, java.lang.Throwable r3) {
        /*
            r1 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r0.append(r2)
            java.lang.String r2 = " "
            r0.append(r2)
            r0.append(r3)
            java.lang.String r2 = r0.toString()
            r1.<init>(r2)
            r2 = -1
            r1.lineNumber_ = r2
            r1.cause_ = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.ParseException.<init>(java.lang.String, java.lang.Throwable):void");
    }
}

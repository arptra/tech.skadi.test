package com.hp.hpl.sparta.xpath;

import java.io.IOException;

public class XPathException extends Exception {
    private Throwable cause_;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public XPathException(com.hp.hpl.sparta.xpath.XPath r2, java.lang.Exception r3) {
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
            r1.cause_ = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.xpath.XPathException.<init>(com.hp.hpl.sparta.xpath.XPath, java.lang.Exception):void");
    }

    private static String toString(SimpleStreamTokenizer simpleStreamTokenizer) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(tokenToString(simpleStreamTokenizer));
            if (simpleStreamTokenizer.ttype != -1) {
                simpleStreamTokenizer.nextToken();
                stringBuffer.append(tokenToString(simpleStreamTokenizer));
                simpleStreamTokenizer.pushBack();
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("(cannot get  info: ");
            stringBuffer2.append(e);
            stringBuffer2.append(")");
            return stringBuffer2.toString();
        }
    }

    private static String tokenToString(SimpleStreamTokenizer simpleStreamTokenizer) {
        StringBuffer stringBuffer;
        int i = simpleStreamTokenizer.ttype;
        if (i == -3) {
            return simpleStreamTokenizer.sval;
        }
        if (i == -2) {
            stringBuffer = new StringBuffer();
            stringBuffer.append(simpleStreamTokenizer.nval);
        } else if (i == -1) {
            return "<end of expression>";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append((char) simpleStreamTokenizer.ttype);
        }
        stringBuffer.append("");
        return stringBuffer.toString();
    }

    public Throwable getCause() {
        return this.cause_;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public XPathException(com.hp.hpl.sparta.xpath.XPath r2, java.lang.String r3) {
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
            r2 = 0
            r1.cause_ = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.xpath.XPathException.<init>(com.hp.hpl.sparta.xpath.XPath, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public XPathException(com.hp.hpl.sparta.xpath.XPath r2, java.lang.String r3, com.hp.hpl.sparta.xpath.SimpleStreamTokenizer r4, java.lang.String r5) {
        /*
            r1 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r0.append(r3)
            java.lang.String r3 = " got \""
            r0.append(r3)
            java.lang.String r3 = toString(r4)
            r0.append(r3)
            java.lang.String r3 = "\" instead of expected "
            r0.append(r3)
            r0.append(r5)
            java.lang.String r3 = r0.toString()
            r1.<init>((com.hp.hpl.sparta.xpath.XPath) r2, (java.lang.String) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.xpath.XPathException.<init>(com.hp.hpl.sparta.xpath.XPath, java.lang.String, com.hp.hpl.sparta.xpath.SimpleStreamTokenizer, java.lang.String):void");
    }
}

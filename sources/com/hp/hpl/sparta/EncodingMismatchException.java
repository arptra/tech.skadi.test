package com.hp.hpl.sparta;

public class EncodingMismatchException extends ParseException {
    private String declaredEncoding_;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EncodingMismatchException(java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            r7 = this;
            int r0 = r9.length()
            int r0 = r0 + -1
            char r4 = r9.charAt(r0)
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "encoding '"
            r0.append(r1)
            r0.append(r9)
            java.lang.String r1 = "' declared instead of of "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r10 = " as expected"
            r0.append(r10)
            java.lang.String r6 = r0.toString()
            r3 = 0
            r1 = r7
            r2 = r8
            r5 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            r7.declaredEncoding_ = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.EncodingMismatchException.<init>(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public String getDeclaredEncoding() {
        return this.declaredEncoding_;
    }
}

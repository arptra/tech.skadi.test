package io.netty.handler.codec;

public class UnsupportedMessageTypeException extends CodecException {
    private static final long serialVersionUID = 2799598826487038726L;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public UnsupportedMessageTypeException(java.lang.Object r1, java.lang.Class<?>... r2) {
        /*
            r0 = this;
            if (r1 != 0) goto L_0x0005
            java.lang.String r1 = "null"
            goto L_0x000d
        L_0x0005:
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
        L_0x000d:
            java.lang.String r1 = message(r1, r2)
            r0.<init>((java.lang.String) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.UnsupportedMessageTypeException.<init>(java.lang.Object, java.lang.Class[]):void");
    }

    private static String message(String str, Class<?>... clsArr) {
        Class<?> cls;
        StringBuilder sb = new StringBuilder(str);
        if (clsArr != null && clsArr.length > 0) {
            sb.append(" (expected: ");
            sb.append(clsArr[0].getName());
            int i = 1;
            while (i < clsArr.length && (cls = clsArr[i]) != null) {
                sb.append(", ");
                sb.append(cls.getName());
                i++;
            }
            sb.append(')');
        }
        return sb.toString();
    }

    public UnsupportedMessageTypeException() {
    }

    public UnsupportedMessageTypeException(String str, Throwable th) {
        super(str, th);
    }

    public UnsupportedMessageTypeException(String str) {
        super(str);
    }

    public UnsupportedMessageTypeException(Throwable th) {
        super(th);
    }
}

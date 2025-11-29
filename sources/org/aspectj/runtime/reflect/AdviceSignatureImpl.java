package org.aspectj.runtime.reflect;

import java.lang.reflect.Method;
import org.aspectj.lang.reflect.AdviceSignature;

class AdviceSignatureImpl extends CodeSignatureImpl implements AdviceSignature {
    private Method adviceMethod = null;
    Class<?> returnType;

    public AdviceSignatureImpl(int i, String str, Class<?> cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class<?> cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.returnType = cls2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String toAdviceName(java.lang.String r3) {
        /*
            r2 = this;
            r2 = 36
            int r2 = r3.indexOf(r2)
            r0 = -1
            if (r2 != r0) goto L_0x000a
            return r3
        L_0x000a:
            java.util.StringTokenizer r2 = new java.util.StringTokenizer
            java.lang.String r0 = "$"
            r2.<init>(r3, r0)
        L_0x0011:
            boolean r0 = r2.hasMoreTokens()
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = r2.nextToken()
            java.lang.String r1 = "before"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x0033
            java.lang.String r1 = "after"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x0033
            java.lang.String r1 = "around"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x0011
        L_0x0033:
            return r0
        L_0x0034:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.aspectj.runtime.reflect.AdviceSignatureImpl.toAdviceName(java.lang.String):java.lang.String");
    }

    public String createToString(StringMaker stringMaker) {
        StringBuffer stringBuffer = new StringBuffer();
        if (stringMaker.includeArgs) {
            stringBuffer.append(stringMaker.makeTypeName(getReturnType()));
        }
        if (stringMaker.includeArgs) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(stringMaker.makePrimaryTypeName(getDeclaringType(), getDeclaringTypeName()));
        stringBuffer.append(".");
        stringBuffer.append(toAdviceName(getName()));
        stringMaker.addSignature(stringBuffer, getParameterTypes());
        stringMaker.addThrows(stringBuffer, getExceptionTypes());
        return stringBuffer.toString();
    }

    public Method getAdvice() {
        if (this.adviceMethod == null) {
            try {
                this.adviceMethod = getDeclaringType().getDeclaredMethod(getName(), getParameterTypes());
            } catch (Exception unused) {
            }
        }
        return this.adviceMethod;
    }

    public Class getReturnType() {
        if (this.returnType == null) {
            this.returnType = extractType(6);
        }
        return this.returnType;
    }

    public AdviceSignatureImpl(String str) {
        super(str);
    }
}

package org.aspectj.runtime.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import org.aspectj.lang.reflect.InitializerSignature;

class InitializerSignatureImpl extends CodeSignatureImpl implements InitializerSignature {
    private Constructor<?> constructor;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InitializerSignatureImpl(int r9, java.lang.Class<?> r10) {
        /*
            r8 = this;
            boolean r0 = java.lang.reflect.Modifier.isStatic(r9)
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = "<clinit>"
        L_0x0008:
            r3 = r0
            goto L_0x000d
        L_0x000a:
            java.lang.String r0 = "<init>"
            goto L_0x0008
        L_0x000d:
            java.lang.Class[] r7 = org.aspectj.runtime.reflect.SignatureImpl.EMPTY_CLASS_ARRAY
            java.lang.String[] r6 = org.aspectj.runtime.reflect.SignatureImpl.EMPTY_STRING_ARRAY
            r1 = r8
            r2 = r9
            r4 = r10
            r5 = r7
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.aspectj.runtime.reflect.InitializerSignatureImpl.<init>(int, java.lang.Class):void");
    }

    public String createToString(StringMaker stringMaker) {
        return stringMaker.makeModifiersString(getModifiers()) + stringMaker.makePrimaryTypeName(getDeclaringType(), getDeclaringTypeName()) + "." + getName();
    }

    public Constructor getInitializer() {
        if (this.constructor == null) {
            try {
                this.constructor = getDeclaringType().getDeclaredConstructor(getParameterTypes());
            } catch (Exception unused) {
            }
        }
        return this.constructor;
    }

    public String getName() {
        return Modifier.isStatic(getModifiers()) ? "<clinit>" : "<init>";
    }

    public InitializerSignatureImpl(String str) {
        super(str);
    }
}

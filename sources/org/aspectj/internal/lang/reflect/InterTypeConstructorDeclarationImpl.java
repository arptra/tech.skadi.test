package org.aspectj.internal.lang.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.InterTypeConstructorDeclaration;

public class InterTypeConstructorDeclarationImpl extends InterTypeDeclarationImpl implements InterTypeConstructorDeclaration {
    private Method baseMethod;

    public InterTypeConstructorDeclarationImpl(AjType<?> ajType, String str, int i, Method method) {
        super(ajType, str, i);
        this.baseMethod = method;
    }

    public AjType<?>[] getExceptionTypes() {
        Class[] exceptionTypes = this.baseMethod.getExceptionTypes();
        AjType<?>[] ajTypeArr = new AjType[exceptionTypes.length];
        for (int i = 0; i < exceptionTypes.length; i++) {
            ajTypeArr[i] = AjTypeSystem.getAjType(exceptionTypes[i]);
        }
        return ajTypeArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: org.aspectj.lang.reflect.AjType[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.reflect.Type[] getGenericParameterTypes() {
        /*
            r4 = this;
            java.lang.reflect.Method r4 = r4.baseMethod
            java.lang.reflect.Type[] r4 = r4.getGenericParameterTypes()
            int r0 = r4.length
            r1 = 1
            int r0 = r0 - r1
            org.aspectj.lang.reflect.AjType[] r0 = new org.aspectj.lang.reflect.AjType[r0]
        L_0x000b:
            int r2 = r4.length
            if (r1 >= r2) goto L_0x0026
            r2 = r4[r1]
            boolean r3 = r2 instanceof java.lang.Class
            if (r3 == 0) goto L_0x001f
            int r3 = r1 + -1
            java.lang.Class r2 = (java.lang.Class) r2
            org.aspectj.lang.reflect.AjType r2 = org.aspectj.lang.reflect.AjTypeSystem.getAjType(r2)
            r0[r3] = r2
            goto L_0x0023
        L_0x001f:
            int r3 = r1 + -1
            r0[r3] = r2
        L_0x0023:
            int r1 = r1 + 1
            goto L_0x000b
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.aspectj.internal.lang.reflect.InterTypeConstructorDeclarationImpl.getGenericParameterTypes():java.lang.reflect.Type[]");
    }

    public AjType<?>[] getParameterTypes() {
        Class[] parameterTypes = this.baseMethod.getParameterTypes();
        AjType<?>[] ajTypeArr = new AjType[(parameterTypes.length - 1)];
        for (int i = 1; i < parameterTypes.length; i++) {
            ajTypeArr[i - 1] = AjTypeSystem.getAjType(parameterTypes[i]);
        }
        return ajTypeArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Modifier.toString(getModifiers()));
        sb.append(" ");
        sb.append(this.targetTypeName);
        sb.append(".new");
        sb.append("(");
        AjType[] parameterTypes = getParameterTypes();
        for (int i = 0; i < parameterTypes.length - 1; i++) {
            sb.append(parameterTypes[i].toString());
            sb.append(", ");
        }
        if (parameterTypes.length > 0) {
            sb.append(parameterTypes[parameterTypes.length - 1].toString());
        }
        sb.append(")");
        return sb.toString();
    }
}

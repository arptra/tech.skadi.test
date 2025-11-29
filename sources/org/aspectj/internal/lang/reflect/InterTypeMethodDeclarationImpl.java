package org.aspectj.internal.lang.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.InterTypeMethodDeclaration;

public class InterTypeMethodDeclarationImpl extends InterTypeDeclarationImpl implements InterTypeMethodDeclaration {
    private Method baseMethod;
    private AjType<?>[] exceptionTypes;
    private Type[] genericParameterTypes;
    private Type genericReturnType;
    private String name;
    private int parameterAdjustmentFactor = 1;
    private AjType<?>[] parameterTypes;
    private AjType<?> returnType;

    public InterTypeMethodDeclarationImpl(AjType<?> ajType, String str, int i, String str2, Method method) {
        super(ajType, str, i);
        this.name = str2;
        this.baseMethod = method;
    }

    public AjType<?>[] getExceptionTypes() {
        Class[] exceptionTypes2 = this.baseMethod.getExceptionTypes();
        AjType<?>[] ajTypeArr = new AjType[exceptionTypes2.length];
        for (int i = 0; i < exceptionTypes2.length; i++) {
            ajTypeArr[i] = AjTypeSystem.getAjType(exceptionTypes2[i]);
        }
        return ajTypeArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: org.aspectj.lang.reflect.AjType[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.reflect.Type[] getGenericParameterTypes() {
        /*
            r5 = this;
            java.lang.reflect.Method r0 = r5.baseMethod
            java.lang.reflect.Type[] r0 = r0.getGenericParameterTypes()
            int r1 = r0.length
            int r2 = r5.parameterAdjustmentFactor
            int r1 = r1 - r2
            org.aspectj.lang.reflect.AjType[] r1 = new org.aspectj.lang.reflect.AjType[r1]
        L_0x000c:
            int r3 = r0.length
            if (r2 >= r3) goto L_0x002b
            r3 = r0[r2]
            boolean r4 = r3 instanceof java.lang.Class
            if (r4 == 0) goto L_0x0022
            int r4 = r5.parameterAdjustmentFactor
            int r4 = r2 - r4
            java.lang.Class r3 = (java.lang.Class) r3
            org.aspectj.lang.reflect.AjType r3 = org.aspectj.lang.reflect.AjTypeSystem.getAjType(r3)
            r1[r4] = r3
            goto L_0x0028
        L_0x0022:
            int r4 = r5.parameterAdjustmentFactor
            int r4 = r2 - r4
            r1[r4] = r3
        L_0x0028:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x002b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.aspectj.internal.lang.reflect.InterTypeMethodDeclarationImpl.getGenericParameterTypes():java.lang.reflect.Type[]");
    }

    public Type getGenericReturnType() {
        Type genericReturnType2 = this.baseMethod.getGenericReturnType();
        return genericReturnType2 instanceof Class ? AjTypeSystem.getAjType((Class) genericReturnType2) : genericReturnType2;
    }

    public String getName() {
        return this.name;
    }

    public AjType<?>[] getParameterTypes() {
        Class[] parameterTypes2 = this.baseMethod.getParameterTypes();
        int length = parameterTypes2.length;
        int i = this.parameterAdjustmentFactor;
        AjType<?>[] ajTypeArr = new AjType[(length - i)];
        while (i < parameterTypes2.length) {
            ajTypeArr[i - this.parameterAdjustmentFactor] = AjTypeSystem.getAjType(parameterTypes2[i]);
            i++;
        }
        return ajTypeArr;
    }

    public AjType<?> getReturnType() {
        return AjTypeSystem.getAjType(this.baseMethod.getReturnType());
    }

    public TypeVariable<Method>[] getTypeParameters() {
        return this.baseMethod.getTypeParameters();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Modifier.toString(getModifiers()));
        sb.append(" ");
        sb.append(getReturnType().toString());
        sb.append(" ");
        sb.append(this.targetTypeName);
        sb.append(".");
        sb.append(getName());
        sb.append("(");
        AjType[] parameterTypes2 = getParameterTypes();
        for (int i = 0; i < parameterTypes2.length - 1; i++) {
            sb.append(parameterTypes2[i].toString());
            sb.append(", ");
        }
        if (parameterTypes2.length > 0) {
            sb.append(parameterTypes2[parameterTypes2.length - 1].toString());
        }
        sb.append(")");
        return sb.toString();
    }

    public InterTypeMethodDeclarationImpl(AjType<?> ajType, AjType<?> ajType2, Method method, int i) {
        super(ajType, ajType2, i);
        this.name = method.getName();
        this.baseMethod = method;
    }
}

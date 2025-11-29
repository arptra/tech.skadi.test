package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class JavaLoadingKt {
    private static final boolean isMethodWithOneObjectParameter(JavaMethod javaMethod) {
        FqName fqName;
        JavaValueParameter javaValueParameter = (JavaValueParameter) CollectionsKt.singleOrNull(javaMethod.getValueParameters());
        JavaClassifierType javaClassifierType = null;
        JavaType type = javaValueParameter != null ? javaValueParameter.getType() : null;
        if (type instanceof JavaClassifierType) {
            javaClassifierType = (JavaClassifierType) type;
        }
        if (javaClassifierType == null) {
            return false;
        }
        JavaClassifier classifier = javaClassifierType.getClassifier();
        return (classifier instanceof JavaClass) && (fqName = ((JavaClass) classifier).getFqName()) != null && Intrinsics.areEqual((Object) fqName.asString(), (Object) "java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        if (r0.equals("toString") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0022, code lost:
        if (r0.equals("hashCode") == false) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean isObjectMethod(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod r3) {
        /*
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r3.getName()
            java.lang.String r0 = r0.asString()
            int r1 = r0.hashCode()
            r2 = -1776922004(0xffffffff9616526c, float:-1.2142911E-25)
            if (r1 == r2) goto L_0x0033
            r2 = -1295482945(0xffffffffb2c87fbf, float:-2.3341157E-8)
            if (r1 == r2) goto L_0x0025
            r2 = 147696667(0x8cdac1b, float:1.23784505E-33)
            if (r1 == r2) goto L_0x001c
            goto L_0x0044
        L_0x001c:
            java.lang.String r1 = "hashCode"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003b
            goto L_0x0044
        L_0x0025:
            java.lang.String r1 = "equals"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002e
            goto L_0x0044
        L_0x002e:
            boolean r3 = isMethodWithOneObjectParameter(r3)
            goto L_0x0045
        L_0x0033:
            java.lang.String r1 = "toString"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0044
        L_0x003b:
            java.util.List r3 = r3.getValueParameters()
            boolean r3 = r3.isEmpty()
            goto L_0x0045
        L_0x0044:
            r3 = 0
        L_0x0045:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLoadingKt.isObjectMethod(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod):boolean");
    }

    public static final boolean isObjectMethodInInterface(@NotNull JavaMember javaMember) {
        Intrinsics.checkNotNullParameter(javaMember, "<this>");
        return javaMember.getContainingClass().isInterface() && (javaMember instanceof JavaMethod) && isObjectMethod((JavaMethod) javaMember);
    }
}

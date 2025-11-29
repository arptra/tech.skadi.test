package org.aspectj.internal.lang.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.reflect.Advice;
import org.aspectj.lang.reflect.AdviceKind;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.PointcutExpression;

public class AdviceImpl implements Advice {
    private static final String AJC_INTERNAL = "org.aspectj.runtime.internal";
    private final Method adviceMethod;
    private AjType[] exceptionTypes;
    private Type[] genericParameterTypes;
    private boolean hasExtraParam = false;
    private final AdviceKind kind;
    private AjType[] parameterTypes;
    private PointcutExpression pointcutExpression;

    /* renamed from: org.aspectj.internal.lang.reflect.AdviceImpl$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$aspectj$lang$reflect$AdviceKind;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.aspectj.lang.reflect.AdviceKind[] r0 = org.aspectj.lang.reflect.AdviceKind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$aspectj$lang$reflect$AdviceKind = r0
                org.aspectj.lang.reflect.AdviceKind r1 = org.aspectj.lang.reflect.AdviceKind.AFTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$aspectj$lang$reflect$AdviceKind     // Catch:{ NoSuchFieldError -> 0x001d }
                org.aspectj.lang.reflect.AdviceKind r1 = org.aspectj.lang.reflect.AdviceKind.AFTER_RETURNING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$aspectj$lang$reflect$AdviceKind     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.aspectj.lang.reflect.AdviceKind r1 = org.aspectj.lang.reflect.AdviceKind.AFTER_THROWING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$aspectj$lang$reflect$AdviceKind     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.aspectj.lang.reflect.AdviceKind r1 = org.aspectj.lang.reflect.AdviceKind.AROUND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$aspectj$lang$reflect$AdviceKind     // Catch:{ NoSuchFieldError -> 0x003e }
                org.aspectj.lang.reflect.AdviceKind r1 = org.aspectj.lang.reflect.AdviceKind.BEFORE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.aspectj.internal.lang.reflect.AdviceImpl.AnonymousClass1.<clinit>():void");
        }
    }

    public AdviceImpl(Method method, String str, AdviceKind adviceKind) {
        this.kind = adviceKind;
        this.adviceMethod = method;
        this.pointcutExpression = new PointcutExpressionImpl(str);
    }

    public AjType getDeclaringType() {
        return AjTypeSystem.getAjType(this.adviceMethod.getDeclaringClass());
    }

    public AjType<?>[] getExceptionTypes() {
        if (this.exceptionTypes == null) {
            Class[] exceptionTypes2 = this.adviceMethod.getExceptionTypes();
            this.exceptionTypes = new AjType[exceptionTypes2.length];
            for (int i = 0; i < exceptionTypes2.length; i++) {
                this.exceptionTypes[i] = AjTypeSystem.getAjType(exceptionTypes2[i]);
            }
        }
        return this.exceptionTypes;
    }

    public Type[] getGenericParameterTypes() {
        if (this.genericParameterTypes == null) {
            Type[] genericParameterTypes2 = this.adviceMethod.getGenericParameterTypes();
            int i = 0;
            int i2 = 0;
            for (Type type : genericParameterTypes2) {
                if ((type instanceof Class) && ((Class) type).getPackage().getName().equals(AJC_INTERNAL)) {
                    i2++;
                }
            }
            this.genericParameterTypes = new Type[(genericParameterTypes2.length - i2)];
            while (true) {
                Type[] typeArr = this.genericParameterTypes;
                if (i >= typeArr.length) {
                    break;
                }
                Type type2 = genericParameterTypes2[i];
                if (type2 instanceof Class) {
                    typeArr[i] = AjTypeSystem.getAjType((Class) type2);
                } else {
                    typeArr[i] = type2;
                }
                i++;
            }
        }
        return this.genericParameterTypes;
    }

    public AdviceKind getKind() {
        return this.kind;
    }

    public String getName() {
        String name = this.adviceMethod.getName();
        if (!name.startsWith("ajc$")) {
            return name;
        }
        AdviceName adviceName = (AdviceName) this.adviceMethod.getAnnotation(AdviceName.class);
        return adviceName != null ? adviceName.value() : "";
    }

    public AjType<?>[] getParameterTypes() {
        if (this.parameterTypes == null) {
            Class[] parameterTypes2 = this.adviceMethod.getParameterTypes();
            int i = 0;
            int i2 = 0;
            for (Class cls : parameterTypes2) {
                if (cls.getPackage().getName().equals(AJC_INTERNAL)) {
                    i2++;
                }
            }
            this.parameterTypes = new AjType[(parameterTypes2.length - i2)];
            while (true) {
                AjType[] ajTypeArr = this.parameterTypes;
                if (i >= ajTypeArr.length) {
                    break;
                }
                ajTypeArr[i] = AjTypeSystem.getAjType(parameterTypes2[i]);
                i++;
            }
        }
        return this.parameterTypes;
    }

    public PointcutExpression getPointcutExpression() {
        return this.pointcutExpression;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a6, code lost:
        if (r10 != 3) goto L_0x00dc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r12 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r12.getName()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0020
            java.lang.String r1 = "@AdviceName(\""
            r0.append(r1)
            java.lang.String r1 = r12.getName()
            r0.append(r1)
            java.lang.String r1 = "\") "
            r0.append(r1)
        L_0x0020:
            org.aspectj.lang.reflect.AdviceKind r1 = r12.getKind()
            org.aspectj.lang.reflect.AdviceKind r2 = org.aspectj.lang.reflect.AdviceKind.AROUND
            java.lang.String r3 = " "
            if (r1 != r2) goto L_0x003a
            java.lang.reflect.Method r1 = r12.adviceMethod
            java.lang.reflect.Type r1 = r1.getGenericReturnType()
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            r0.append(r3)
        L_0x003a:
            int[] r1 = org.aspectj.internal.lang.reflect.AdviceImpl.AnonymousClass1.$SwitchMap$org$aspectj$lang$reflect$AdviceKind
            org.aspectj.lang.reflect.AdviceKind r2 = r12.getKind()
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 3
            r4 = 2
            java.lang.String r5 = "after("
            r6 = 1
            if (r1 == r6) goto L_0x006c
            if (r1 == r4) goto L_0x0068
            if (r1 == r2) goto L_0x0064
            r5 = 4
            if (r1 == r5) goto L_0x005e
            r5 = 5
            if (r1 == r5) goto L_0x0058
            goto L_0x006f
        L_0x0058:
            java.lang.String r1 = "before("
            r0.append(r1)
            goto L_0x006f
        L_0x005e:
            java.lang.String r1 = "around("
            r0.append(r1)
            goto L_0x006f
        L_0x0064:
            r0.append(r5)
            goto L_0x006f
        L_0x0068:
            r0.append(r5)
            goto L_0x006f
        L_0x006c:
            r0.append(r5)
        L_0x006f:
            org.aspectj.lang.reflect.AjType[] r1 = r12.getParameterTypes()
            int r5 = r1.length
            boolean r7 = r12.hasExtraParam
            if (r7 == 0) goto L_0x007a
            int r5 = r5 + -1
        L_0x007a:
            r7 = 0
            r8 = r7
        L_0x007c:
            java.lang.String r9 = ","
            if (r8 >= r5) goto L_0x0091
            r10 = r1[r8]
            java.lang.String r10 = r10.getName()
            r0.append(r10)
            int r8 = r8 + 1
            if (r8 >= r5) goto L_0x007c
            r0.append(r9)
            goto L_0x007c
        L_0x0091:
            java.lang.String r8 = ") "
            r0.append(r8)
            int[] r10 = org.aspectj.internal.lang.reflect.AdviceImpl.AnonymousClass1.$SwitchMap$org$aspectj$lang$reflect$AdviceKind
            org.aspectj.lang.reflect.AdviceKind r11 = r12.getKind()
            int r11 = r11.ordinal()
            r10 = r10[r11]
            java.lang.String r11 = "("
            if (r10 == r4) goto L_0x00a9
            if (r10 == r2) goto L_0x00c3
            goto L_0x00dc
        L_0x00a9:
            java.lang.String r2 = "returning"
            r0.append(r2)
            boolean r2 = r12.hasExtraParam
            if (r2 == 0) goto L_0x00c3
            r0.append(r11)
            int r2 = r5 + -1
            r2 = r1[r2]
            java.lang.String r2 = r2.getName()
            r0.append(r2)
            r0.append(r8)
        L_0x00c3:
            java.lang.String r2 = "throwing"
            r0.append(r2)
            boolean r2 = r12.hasExtraParam
            if (r2 == 0) goto L_0x00dc
            r0.append(r11)
            int r5 = r5 - r6
            r1 = r1[r5]
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            r0.append(r8)
        L_0x00dc:
            org.aspectj.lang.reflect.AjType[] r1 = r12.getExceptionTypes()
            int r2 = r1.length
            if (r2 <= 0) goto L_0x0100
            java.lang.String r2 = "throws "
            r0.append(r2)
        L_0x00e8:
            int r2 = r1.length
            if (r7 >= r2) goto L_0x00fd
            r2 = r1[r7]
            java.lang.String r2 = r2.getName()
            r0.append(r2)
            int r7 = r7 + 1
            int r2 = r1.length
            if (r7 >= r2) goto L_0x00e8
            r0.append(r9)
            goto L_0x00e8
        L_0x00fd:
            r0.append(r3)
        L_0x0100:
            java.lang.String r1 = ": "
            r0.append(r1)
            org.aspectj.lang.reflect.PointcutExpression r12 = r12.getPointcutExpression()
            java.lang.String r12 = r12.asString()
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.aspectj.internal.lang.reflect.AdviceImpl.toString():java.lang.String");
    }

    public AdviceImpl(Method method, String str, AdviceKind adviceKind, String str2) {
        this(method, str, adviceKind);
    }
}

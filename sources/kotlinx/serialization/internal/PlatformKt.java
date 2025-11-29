package kotlinx.serialization.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;

@Metadata(d1 = {"\u0000D\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\u001a+\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001aM\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\n\b\u0001\u0010\u0006*\u0004\u0018\u00018\u0000*\u0012\u0012\u0004\u0012\u00028\u00010\u0007j\b\u0012\u0004\u0012\u00028\u0001`\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\u000e\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001aO\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\u0010\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00030\n\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0003H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001aO\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00132\"\u0010\u0010\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00030\n\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0003H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aO\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00132\"\u0010\u0010\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00030\n\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0015\u001a%\u0010\u0017\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a#\u0010\u001a\u001a\u00020\u0019\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u001c\u001a\u00020\u0019\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002¢\u0006\u0004\b\u001c\u0010\u001b\u001a+\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001aQ\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u00132\"\u0010\u0010\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00030\n\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0003H\u0002¢\u0006\u0004\b \u0010\u0015\u001aM\u0010\"\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010!\u001a\u00020\u00002\"\u0010\u0010\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00030\n\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0003H\u0002¢\u0006\u0004\b\"\u0010#\u001a!\u0010&\u001a\u0004\u0018\u00010\u0000*\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'\u001a)\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002¢\u0006\u0004\b(\u0010\u001e\u001a+\u0010)\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002¢\u0006\u0004\b)\u0010\u001e\u001a\u001d\u0010+\u001a\u00020\u00192\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0000¢\u0006\u0004\b+\u0010,¨\u0006-"}, d2 = {"", "T", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "b", "(Lkotlin/reflect/KClass;)Lkotlinx/serialization/KSerializer;", "E", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eClass", "", "p", "(Ljava/util/ArrayList;Lkotlin/reflect/KClass;)[Ljava/lang/Object;", "", "o", "(Lkotlin/reflect/KClass;)Ljava/lang/Void;", "args", "d", "(Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "Ljava/lang/Class;", "c", "(Ljava/lang/Class;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "f", "g", "(Ljava/lang/Class;)Ljava/lang/Object;", "", "l", "(Ljava/lang/Class;)Z", "m", "i", "(Ljava/lang/Class;)Lkotlinx/serialization/KSerializer;", "jClass", "k", "companion", "j", "(Ljava/lang/Object;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "", "companionName", "a", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "e", "h", "rootClass", "n", "(Lkotlin/reflect/KClass;)Z", "kotlinx-serialization-core"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPlatform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Platform.kt\nkotlinx/serialization/internal/PlatformKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,174:1\n1#2:175\n3133#3,11:176\n1282#3,2:187\n3133#3,11:190\n3133#3,11:201\n26#4:189\n*S KotlinDebug\n*F\n+ 1 Platform.kt\nkotlinx/serialization/internal/PlatformKt\n*L\n70#1:176,11\n78#1:187,2\n161#1:190,11\n166#1:201,11\n129#1:189\n*E\n"})
public final class PlatformKt {
    public static final Object a(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final KSerializer b(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return d(kClass, new KSerializer[0]);
    }

    public static final KSerializer c(Class cls, KSerializer... kSerializerArr) {
        KSerializer i;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(kSerializerArr, "args");
        if (cls.isEnum() && l(cls)) {
            return e(cls);
        }
        if (cls.isInterface() && (i = i(cls)) != null) {
            return i;
        }
        KSerializer k = k(cls, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
        if (k != null) {
            return k;
        }
        KSerializer h = h(cls);
        if (h != null) {
            return h;
        }
        KSerializer f = f(cls, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
        if (f != null) {
            return f;
        }
        if (m(cls)) {
            return new PolymorphicSerializer(JvmClassMappingKt.getKotlinClass(cls));
        }
        return null;
    }

    public static final KSerializer d(KClass kClass, KSerializer... kSerializerArr) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(kSerializerArr, "args");
        return c(JvmClassMappingKt.getJavaClass(kClass), (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    public static final KSerializer e(Class cls) {
        Object[] enumConstants = cls.getEnumConstants();
        String canonicalName = cls.getCanonicalName();
        Intrinsics.checkNotNullExpressionValue(canonicalName, "getCanonicalName(...)");
        Intrinsics.checkNotNull(enumConstants, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new EnumSerializer(canonicalName, (Enum[]) enumConstants);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        r7 = r3.getField("INSTANCE");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlinx.serialization.KSerializer f(java.lang.Class r7, kotlinx.serialization.KSerializer... r8) {
        /*
            java.lang.Object r0 = g(r7)
            if (r0 == 0) goto L_0x0014
            int r1 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r1)
            kotlinx.serialization.KSerializer[] r8 = (kotlinx.serialization.KSerializer[]) r8
            kotlinx.serialization.KSerializer r8 = j(r0, r8)
            if (r8 == 0) goto L_0x0014
            return r8
        L_0x0014:
            r8 = 0
            java.lang.Class[] r7 = r7.getDeclaredClasses()     // Catch:{ NoSuchFieldException -> 0x0055 }
            java.lang.String r0 = "getDeclaredClasses(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ NoSuchFieldException -> 0x0055 }
            int r0 = r7.length     // Catch:{ NoSuchFieldException -> 0x0055 }
            r1 = 0
            r3 = r8
            r2 = r1
        L_0x0022:
            if (r1 >= r0) goto L_0x003b
            r4 = r7[r1]     // Catch:{ NoSuchFieldException -> 0x0055 }
            java.lang.String r5 = r4.getSimpleName()     // Catch:{ NoSuchFieldException -> 0x0055 }
            java.lang.String r6 = "$serializer"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)     // Catch:{ NoSuchFieldException -> 0x0055 }
            if (r5 == 0) goto L_0x0038
            if (r2 == 0) goto L_0x0036
        L_0x0034:
            r3 = r8
            goto L_0x003e
        L_0x0036:
            r2 = 1
            r3 = r4
        L_0x0038:
            int r1 = r1 + 1
            goto L_0x0022
        L_0x003b:
            if (r2 != 0) goto L_0x003e
            goto L_0x0034
        L_0x003e:
            if (r3 == 0) goto L_0x004d
            java.lang.String r7 = "INSTANCE"
            java.lang.reflect.Field r7 = r3.getField(r7)     // Catch:{ NoSuchFieldException -> 0x0055 }
            if (r7 == 0) goto L_0x004d
            java.lang.Object r7 = r7.get(r8)     // Catch:{ NoSuchFieldException -> 0x0055 }
            goto L_0x004e
        L_0x004d:
            r7 = r8
        L_0x004e:
            boolean r0 = r7 instanceof kotlinx.serialization.KSerializer     // Catch:{ NoSuchFieldException -> 0x0055 }
            if (r0 == 0) goto L_0x0055
            kotlinx.serialization.KSerializer r7 = (kotlinx.serialization.KSerializer) r7     // Catch:{ NoSuchFieldException -> 0x0055 }
            r8 = r7
        L_0x0055:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.f(java.lang.Class, kotlinx.serialization.KSerializer[]):kotlinx.serialization.KSerializer");
    }

    public static final Object g(Class cls) {
        Class cls2;
        Class[] declaredClasses = cls.getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(declaredClasses, "getDeclaredClasses(...)");
        int length = declaredClasses.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                cls2 = null;
                break;
            }
            cls2 = declaredClasses[i];
            if (cls2.getAnnotation(NamedCompanion.class) != null) {
                break;
            }
            i++;
        }
        if (cls2 == null) {
            return null;
        }
        String simpleName = cls2.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return a(cls, simpleName);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (r5 == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009d, code lost:
        if (r4 == false) goto L_0x0096;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlinx.serialization.KSerializer h(java.lang.Class r11) {
        /*
            java.lang.String r0 = r11.getCanonicalName()
            r1 = 0
            if (r0 == 0) goto L_0x00ae
            java.lang.String r2 = "java."
            r3 = 0
            r4 = 2
            boolean r2 = kotlin.text.StringsKt.startsWith$default(r0, r2, r3, r4, r1)
            if (r2 != 0) goto L_0x00ae
            java.lang.String r2 = "kotlin."
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r2, r3, r4, r1)
            if (r0 == 0) goto L_0x001b
            goto L_0x00ae
        L_0x001b:
            java.lang.reflect.Field[] r0 = r11.getDeclaredFields()
            java.lang.String r2 = "getDeclaredFields(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            int r2 = r0.length
            r6 = r1
            r4 = r3
            r5 = r4
        L_0x0028:
            r7 = 1
            if (r4 >= r2) goto L_0x0056
            r8 = r0[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "INSTANCE"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x0053
            java.lang.Class r9 = r8.getType()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r11)
            if (r9 == 0) goto L_0x0053
            int r9 = r8.getModifiers()
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)
            if (r9 == 0) goto L_0x0053
            if (r5 == 0) goto L_0x0051
        L_0x004f:
            r6 = r1
            goto L_0x0059
        L_0x0051:
            r5 = r7
            r6 = r8
        L_0x0053:
            int r4 = r4 + 1
            goto L_0x0028
        L_0x0056:
            if (r5 != 0) goto L_0x0059
            goto L_0x004f
        L_0x0059:
            if (r6 != 0) goto L_0x005c
            return r1
        L_0x005c:
            java.lang.Object r0 = r6.get(r1)
            java.lang.reflect.Method[] r11 = r11.getMethods()
            java.lang.String r2 = "getMethods(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r2)
            int r2 = r11.length
            r5 = r1
            r4 = r3
        L_0x006c:
            if (r3 >= r2) goto L_0x009d
            r6 = r11[r3]
            java.lang.String r8 = r6.getName()
            java.lang.String r9 = "serializer"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x009a
            java.lang.Class[] r8 = r6.getParameterTypes()
            java.lang.String r9 = "getParameterTypes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            int r8 = r8.length
            if (r8 != 0) goto L_0x009a
            java.lang.Class r8 = r6.getReturnType()
            java.lang.Class<kotlinx.serialization.KSerializer> r9 = kotlinx.serialization.KSerializer.class
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x009a
            if (r4 == 0) goto L_0x0098
        L_0x0096:
            r5 = r1
            goto L_0x00a0
        L_0x0098:
            r5 = r6
            r4 = r7
        L_0x009a:
            int r3 = r3 + 1
            goto L_0x006c
        L_0x009d:
            if (r4 != 0) goto L_0x00a0
            goto L_0x0096
        L_0x00a0:
            if (r5 != 0) goto L_0x00a3
            return r1
        L_0x00a3:
            java.lang.Object r11 = r5.invoke(r0, r1)
            boolean r0 = r11 instanceof kotlinx.serialization.KSerializer
            if (r0 == 0) goto L_0x00ae
            r1 = r11
            kotlinx.serialization.KSerializer r1 = (kotlinx.serialization.KSerializer) r1
        L_0x00ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.h(java.lang.Class):kotlinx.serialization.KSerializer");
    }

    public static final KSerializer i(Class cls) {
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        if (serializable == null || Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(serializable.with()), (Object) Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class))) {
            return new PolymorphicSerializer(JvmClassMappingKt.getKotlinClass(cls));
        }
        return null;
    }

    public static final KSerializer j(Object obj, KSerializer... kSerializerArr) {
        Class[] clsArr;
        try {
            if (kSerializerArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = kSerializerArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i = 0; i < length; i++) {
                    clsArr2[i] = KSerializer.class;
                }
                clsArr = clsArr2;
            }
            Object invoke = obj.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(obj, Arrays.copyOf(kSerializerArr, kSerializerArr.length));
            if (invoke instanceof KSerializer) {
                return (KSerializer) invoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause != null) {
                String message = cause.getMessage();
                if (message == null) {
                    message = e.getMessage();
                }
                throw new InvocationTargetException(cause, message);
            }
            throw e;
        }
    }

    public static final KSerializer k(Class cls, KSerializer... kSerializerArr) {
        Object a2 = a(cls, "Companion");
        if (a2 == null) {
            return null;
        }
        return j(a2, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    public static final boolean l(Class cls) {
        return cls.getAnnotation(Serializable.class) == null && cls.getAnnotation(Polymorphic.class) == null;
    }

    public static final boolean m(Class cls) {
        if (cls.getAnnotation(Polymorphic.class) != null) {
            return true;
        }
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        return serializable != null && Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(serializable.with()), (Object) Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class));
    }

    public static final boolean n(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "rootClass");
        return JvmClassMappingKt.getJavaClass(kClass).isArray();
    }

    public static final Void o(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Platform_commonKt.f(kClass);
        throw new KotlinNothingValueException();
    }

    public static final Object[] p(ArrayList arrayList, KClass kClass) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "eClass");
        Object newInstance = Array.newInstance(JvmClassMappingKt.getJavaClass(kClass), arrayList.size());
        Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        Object[] array = arrayList.toArray((Object[]) newInstance);
        Intrinsics.checkNotNullExpressionValue(array, "toArray(...)");
        return array;
    }
}

package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JavaBeanInfo {
    public final Method buildMethod;
    public final Class<?> builderClass;
    public final Class<?> clazz;
    public final Constructor<?> creatorConstructor;
    public Type[] creatorConstructorParameterTypes;
    public String[] creatorConstructorParameters;
    public final Constructor<?> defaultConstructor;
    public final int defaultConstructorParameterSize;
    public final Method factoryMethod;
    public final FieldInfo[] fields;
    public final JSONType jsonType;

    /* renamed from: kotlin  reason: collision with root package name */
    public boolean f2352kotlin;
    public Constructor<?> kotlinDefaultConstructor;
    public String[] orders;
    public final int parserFeatures;
    public final FieldInfo[] sortedFields;
    public final String typeKey;
    public final String typeName;

    public JavaBeanInfo(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, JSONType jSONType, List<FieldInfo> list) {
        JSONField jSONField;
        this.clazz = cls;
        this.builderClass = cls2;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.parserFeatures = TypeUtils.getParserFeatures(cls);
        this.buildMethod = method2;
        this.jsonType = jSONType;
        if (jSONType != null) {
            String typeName2 = jSONType.typeName();
            String typeKey2 = jSONType.typeKey();
            this.typeKey = typeKey2.length() <= 0 ? null : typeKey2;
            if (typeName2.length() != 0) {
                this.typeName = typeName2;
            } else {
                this.typeName = cls.getName();
            }
            String[] orders2 = jSONType.orders();
            this.orders = orders2.length == 0 ? null : orders2;
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            this.orders = null;
        }
        FieldInfo[] fieldInfoArr = new FieldInfo[list.size()];
        this.fields = fieldInfoArr;
        list.toArray(fieldInfoArr);
        FieldInfo[] fieldInfoArr2 = new FieldInfo[fieldInfoArr.length];
        int i = 0;
        if (this.orders != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (FieldInfo fieldInfo : fieldInfoArr) {
                linkedHashMap.put(fieldInfo.name, fieldInfo);
            }
            int i2 = 0;
            for (String str : this.orders) {
                FieldInfo fieldInfo2 = (FieldInfo) linkedHashMap.get(str);
                if (fieldInfo2 != null) {
                    fieldInfoArr2[i2] = fieldInfo2;
                    linkedHashMap.remove(str);
                    i2++;
                }
            }
            for (FieldInfo fieldInfo3 : linkedHashMap.values()) {
                fieldInfoArr2[i2] = fieldInfo3;
                i2++;
            }
        } else {
            System.arraycopy(fieldInfoArr, 0, fieldInfoArr2, 0, fieldInfoArr.length);
            Arrays.sort(fieldInfoArr2);
        }
        this.sortedFields = Arrays.equals(this.fields, fieldInfoArr2) ? this.fields : fieldInfoArr2;
        if (constructor != null) {
            this.defaultConstructorParameterSize = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.defaultConstructorParameterSize = method.getParameterTypes().length;
        } else {
            this.defaultConstructorParameterSize = 0;
        }
        if (constructor2 != null) {
            this.creatorConstructorParameterTypes = constructor2.getParameterTypes();
            boolean isKotlin = TypeUtils.isKotlin(cls);
            this.f2352kotlin = isKotlin;
            if (isKotlin) {
                this.creatorConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
                try {
                    this.kotlinDefaultConstructor = cls.getConstructor((Class[]) null);
                } catch (Throwable unused) {
                }
                Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations((Constructor) constructor2);
                int i3 = 0;
                while (i3 < this.creatorConstructorParameters.length && i3 < parameterAnnotations.length) {
                    Annotation[] annotationArr = parameterAnnotations[i3];
                    int length = annotationArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            jSONField = null;
                            break;
                        }
                        Annotation annotation = annotationArr[i4];
                        if (annotation instanceof JSONField) {
                            jSONField = (JSONField) annotation;
                            break;
                        }
                        i4++;
                    }
                    if (jSONField != null) {
                        String name = jSONField.name();
                        if (name.length() > 0) {
                            this.creatorConstructorParameters[i3] = name;
                        }
                    }
                    i3++;
                }
                return;
            }
            if (this.creatorConstructorParameterTypes.length == this.fields.length) {
                while (true) {
                    Type[] typeArr = this.creatorConstructorParameterTypes;
                    if (i >= typeArr.length) {
                        return;
                    }
                    if (typeArr[i] != this.fields[i].fieldClass) {
                        break;
                    }
                    i++;
                }
            }
            this.creatorConstructorParameters = ASMUtils.lookupParameterNames(constructor2);
        }
    }

    public static boolean add(List<FieldInfo> list, FieldInfo fieldInfo) {
        int size = list.size() - 1;
        while (size >= 0) {
            FieldInfo fieldInfo2 = list.get(size);
            if (!fieldInfo2.name.equals(fieldInfo.name) || (fieldInfo2.getOnly && !fieldInfo.getOnly)) {
                size--;
            } else if (fieldInfo2.fieldClass.isAssignableFrom(fieldInfo.fieldClass)) {
                list.set(size, fieldInfo);
                return true;
            } else if (fieldInfo2.compareTo(fieldInfo) >= 0) {
                return false;
            } else {
                list.set(size, fieldInfo);
                return true;
            }
        }
        list.add(fieldInfo);
        return true;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy) {
        return build(cls, type, propertyNamingStrategy, false, TypeUtils.compatibleWithJavaBean, false);
    }

    private static Map<TypeVariable, Type> buildGenericInfo(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = null;
        if (superclass == null) {
            return null;
        }
        while (true) {
            Class<? super Object> cls2 = superclass;
            Class<?> cls3 = cls;
            cls = cls2;
            if (cls == null || cls == Object.class) {
                return hashMap;
            }
            if (cls3.getGenericSuperclass() instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) cls3.getGenericSuperclass()).getActualTypeArguments();
                TypeVariable[] typeParameters = cls.getTypeParameters();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    if (hashMap.containsKey(actualTypeArguments[i])) {
                        hashMap.put(typeParameters[i], hashMap.get(actualTypeArguments[i]));
                    } else {
                        hashMap.put(typeParameters[i], actualTypeArguments[i]);
                    }
                }
            }
            superclass = cls.getSuperclass();
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (java.util.concurrent.atomic.AtomicBoolean.class.equals(r2) == false) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void computeFields(java.lang.Class<?> r20, java.lang.reflect.Type r21, com.alibaba.fastjson.PropertyNamingStrategy r22, java.util.List<com.alibaba.fastjson.util.FieldInfo> r23, java.lang.reflect.Field[] r24) {
        /*
            r0 = r22
            r1 = r24
            java.util.Map r15 = buildGenericInfo(r20)
            int r14 = r1.length
            r16 = 0
            r13 = r16
        L_0x000d:
            if (r13 >= r14) goto L_0x00dc
            r5 = r1[r13]
            int r2 = r5.getModifiers()
            r3 = r2 & 8
            if (r3 == 0) goto L_0x0021
        L_0x0019:
            r2 = r23
            r17 = r13
            r18 = r14
            goto L_0x00d6
        L_0x0021:
            r2 = r2 & 16
            if (r2 == 0) goto L_0x0051
            java.lang.Class r2 = r5.getType()
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            boolean r3 = r3.isAssignableFrom(r2)
            if (r3 != 0) goto L_0x0051
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            boolean r3 = r3.isAssignableFrom(r2)
            if (r3 != 0) goto L_0x0051
            java.lang.Class<java.util.concurrent.atomic.AtomicLong> r3 = java.util.concurrent.atomic.AtomicLong.class
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L_0x0051
            java.lang.Class<java.util.concurrent.atomic.AtomicInteger> r3 = java.util.concurrent.atomic.AtomicInteger.class
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L_0x0051
            java.lang.Class<java.util.concurrent.atomic.AtomicBoolean> r3 = java.util.concurrent.atomic.AtomicBoolean.class
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0019
        L_0x0051:
            java.util.Iterator r2 = r23.iterator()
        L_0x0055:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x006e
            java.lang.Object r3 = r2.next()
            com.alibaba.fastjson.util.FieldInfo r3 = (com.alibaba.fastjson.util.FieldInfo) r3
            java.lang.String r3 = r3.name
            java.lang.String r4 = r5.getName()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0055
            goto L_0x0019
        L_0x006e:
            java.lang.String r2 = r5.getName()
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r3 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r3 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Field) r5, r3)
            r12 = r3
            com.alibaba.fastjson.annotation.JSONField r12 = (com.alibaba.fastjson.annotation.JSONField) r12
            if (r12 == 0) goto L_0x00aa
            boolean r3 = r12.deserialize()
            if (r3 != 0) goto L_0x0084
            goto L_0x0019
        L_0x0084:
            int r3 = r12.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r12.serialzeFeatures()
            int r4 = com.alibaba.fastjson.serializer.SerializerFeature.of(r4)
            com.alibaba.fastjson.parser.Feature[] r6 = r12.parseFeatures()
            int r6 = com.alibaba.fastjson.parser.Feature.of(r6)
            java.lang.String r7 = r12.name()
            int r7 = r7.length()
            if (r7 == 0) goto L_0x00a6
            java.lang.String r2 = r12.name()
        L_0x00a6:
            r8 = r3
            r9 = r4
            r10 = r6
            goto L_0x00ae
        L_0x00aa:
            r8 = r16
            r9 = r8
            r10 = r9
        L_0x00ae:
            if (r0 == 0) goto L_0x00b4
            java.lang.String r2 = r0.translate(r2)
        L_0x00b4:
            r3 = r2
            com.alibaba.fastjson.util.FieldInfo r11 = new com.alibaba.fastjson.util.FieldInfo
            r17 = 0
            r18 = 0
            r4 = 0
            r2 = r11
            r6 = r20
            r7 = r21
            r19 = r11
            r11 = r17
            r17 = r13
            r13 = r18
            r18 = r14
            r14 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r2 = r23
            r3 = r19
            add(r2, r3)
        L_0x00d6:
            int r13 = r17 + 1
            r14 = r18
            goto L_0x000d
        L_0x00dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.JavaBeanInfo.computeFields(java.lang.Class, java.lang.reflect.Type, com.alibaba.fastjson.PropertyNamingStrategy, java.util.List, java.lang.reflect.Field[]):void");
    }

    public static Class<?> getBuilderClass(JSONType jSONType) {
        return getBuilderClass((Class<?>) null, jSONType);
    }

    public static Constructor<?> getCreatorConstructor(Constructor[] constructorArr) {
        Constructor<?> constructor = null;
        for (Constructor<?> constructor2 : constructorArr) {
            if (((JSONCreator) constructor2.getAnnotation(JSONCreator.class)) != null) {
                if (constructor == null) {
                    constructor = constructor2;
                } else {
                    throw new JSONException("multi-JSONCreator");
                }
            }
        }
        if (constructor != null) {
            return constructor;
        }
        for (Constructor<?> constructor3 : constructorArr) {
            Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations((Constructor) constructor3);
            if (parameterAnnotations.length != 0) {
                int length = parameterAnnotations.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        Annotation[] annotationArr = parameterAnnotations[i];
                        int length2 = annotationArr.length;
                        int i2 = 0;
                        while (i2 < length2) {
                            if (annotationArr[i2] instanceof JSONField) {
                                i++;
                            } else {
                                i2++;
                            }
                        }
                        break;
                    } else if (constructor == null) {
                        constructor = constructor3;
                    } else {
                        throw new JSONException("multi-JSONCreator");
                    }
                }
            }
        }
        return constructor;
    }

    public static Constructor<?> getDefaultConstructor(Class<?> cls, Constructor<?>[] constructorArr) {
        Constructor<?> constructor = null;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        int length = constructorArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Constructor<?> constructor2 = constructorArr[i];
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
            i++;
        }
        if (constructor != null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return constructor;
        }
        for (Constructor<?> constructor3 : constructorArr) {
            Class[] parameterTypes = constructor3.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                return constructor3;
            }
        }
        return constructor;
    }

    private static Method getFactoryMethod(Class<?> cls, Method[] methodArr, boolean z) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((JSONCreator) TypeUtils.getAnnotation(method2, JSONCreator.class)) != null) {
                if (method == null) {
                    method = method2;
                } else {
                    throw new JSONException("multi-JSONCreator");
                }
            }
        }
        if (method != null || !z) {
            return method;
        }
        for (Method method3 : methodArr) {
            if (TypeUtils.isJacksonCreator(method3)) {
                return method3;
            }
        }
        return method;
    }

    private static FieldInfo getField(List<FieldInfo> list, String str) {
        for (FieldInfo next : list) {
            if (next.name.equals(str)) {
                return next;
            }
            Field field = next.field;
            if (field != null && next.getAnnotation() != null && field.getName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, boolean z, boolean z2) {
        return build(cls, type, propertyNamingStrategy, z, z2, false);
    }

    public static Class<?> getBuilderClass(Class<?> cls, JSONType jSONType) {
        Class<?> builder;
        if (cls != null && cls.getName().equals("org.springframework.security.web.savedrequest.DefaultSavedRequest")) {
            return TypeUtils.loadClass("org.springframework.security.web.savedrequest.DefaultSavedRequest$Builder");
        }
        if (jSONType == null || (builder = jSONType.builder()) == Void.class) {
            return null;
        }
        return builder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r0 = r12.naming();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:437:0x0afe, code lost:
        if (r1.deserialize() == false) goto L_0x0b00;
     */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0357  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x035c  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0363  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x044c  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0594  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x05a1  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x079a  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x07a5  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x08ba  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x08ef  */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0986  */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x0998  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x099e  */
    /* JADX WARNING: Removed duplicated region for block: B:440:0x0b16  */
    /* JADX WARNING: Removed duplicated region for block: B:443:0x0b22  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alibaba.fastjson.util.JavaBeanInfo build(java.lang.Class<?> r57, java.lang.reflect.Type r58, com.alibaba.fastjson.PropertyNamingStrategy r59, boolean r60, boolean r61, boolean r62) {
        /*
            r13 = r57
            r14 = r58
            r9 = r62
            r15 = 1
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r0 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r0 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r13, r0)
            r12 = r0
            com.alibaba.fastjson.annotation.JSONType r12 = (com.alibaba.fastjson.annotation.JSONType) r12
            if (r12 == 0) goto L_0x001e
            com.alibaba.fastjson.PropertyNamingStrategy r0 = r12.naming()
            if (r0 == 0) goto L_0x001e
            com.alibaba.fastjson.PropertyNamingStrategy r1 = com.alibaba.fastjson.PropertyNamingStrategy.CamelCase
            if (r0 == r1) goto L_0x001e
            r11 = r0
            goto L_0x0020
        L_0x001e:
            r11 = r59
        L_0x0020:
            java.lang.Class r10 = getBuilderClass(r13, r12)
            java.lang.reflect.Field[] r8 = r57.getDeclaredFields()
            java.lang.reflect.Method[] r7 = r57.getMethods()
            java.util.Map r16 = buildGenericInfo(r57)
            boolean r17 = com.alibaba.fastjson.util.TypeUtils.isKotlin(r57)
            java.lang.reflect.Constructor[] r0 = r57.getDeclaredConstructors()
            if (r17 == 0) goto L_0x0041
            int r1 = r0.length
            if (r1 != r15) goto L_0x003e
            goto L_0x0041
        L_0x003e:
            r18 = 0
            goto L_0x0053
        L_0x0041:
            if (r10 != 0) goto L_0x004a
            java.lang.reflect.Constructor r1 = getDefaultConstructor(r13, r0)
        L_0x0047:
            r18 = r1
            goto L_0x0053
        L_0x004a:
            java.lang.reflect.Constructor[] r1 = r10.getDeclaredConstructors()
            java.lang.reflect.Constructor r1 = getDefaultConstructor(r10, r1)
            goto L_0x0047
        L_0x0053:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r19 = 0
            r20 = 0
            if (r60 == 0) goto L_0x0085
            r0 = r13
        L_0x005f:
            if (r0 == 0) goto L_0x006d
            java.lang.reflect.Field[] r1 = r0.getDeclaredFields()
            computeFields(r13, r14, r11, r5, r1)
            java.lang.Class r0 = r0.getSuperclass()
            goto L_0x005f
        L_0x006d:
            if (r18 == 0) goto L_0x0072
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r18)
        L_0x0072:
            com.alibaba.fastjson.util.JavaBeanInfo r9 = new com.alibaba.fastjson.util.JavaBeanInfo
            r4 = 0
            r0 = r9
            r1 = r57
            r2 = r10
            r3 = r18
            r8 = r5
            r5 = r20
            r6 = r19
            r7 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x0085:
            boolean r1 = r57.isInterface()
            if (r1 != 0) goto L_0x0098
            int r1 = r57.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isAbstract(r1)
            if (r1 == 0) goto L_0x0096
            goto L_0x0098
        L_0x0096:
            r1 = 0
            goto L_0x0099
        L_0x0098:
            r1 = r15
        L_0x0099:
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            r59 = r11
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r15 = com.alibaba.fastjson.annotation.JSONField.class
            if (r18 != 0) goto L_0x00a7
            if (r10 == 0) goto L_0x00a9
        L_0x00a7:
            if (r1 == 0) goto L_0x0463
        L_0x00a9:
            java.lang.reflect.Constructor r22 = getCreatorConstructor(r0)
            if (r22 == 0) goto L_0x01a6
            if (r1 != 0) goto L_0x01a6
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r22)
            java.lang.Class[] r9 = r22.getParameterTypes()
            int r0 = r9.length
            if (r0 <= 0) goto L_0x018f
            java.lang.annotation.Annotation[][] r1 = com.alibaba.fastjson.util.TypeUtils.getParameterAnnotations((java.lang.reflect.Constructor) r22)
            r0 = 0
            r23 = 0
        L_0x00c2:
            int r4 = r9.length
            if (r0 >= r4) goto L_0x018f
            int r4 = r1.length
            if (r0 >= r4) goto L_0x018f
            r4 = r1[r0]
            int r6 = r4.length
            r14 = 0
        L_0x00cc:
            r62 = r1
            if (r14 >= r6) goto L_0x00e2
            r1 = r4[r14]
            r27 = r2
            boolean r2 = r1 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r2 == 0) goto L_0x00db
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            goto L_0x00e5
        L_0x00db:
            r1 = 1
            int r14 = r14 + r1
            r1 = r62
            r2 = r27
            goto L_0x00cc
        L_0x00e2:
            r27 = r2
            r1 = 0
        L_0x00e5:
            r4 = r9[r0]
            java.lang.reflect.Type[] r2 = r22.getGenericParameterTypes()
            r6 = r2[r0]
            if (r1 == 0) goto L_0x0110
            java.lang.String r2 = r1.name()
            java.lang.reflect.Field r2 = com.alibaba.fastjson.util.TypeUtils.getField(r13, r2, r8)
            int r14 = r1.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r28 = r1.serialzeFeatures()
            int r28 = com.alibaba.fastjson.serializer.SerializerFeature.of(r28)
            com.alibaba.fastjson.parser.Feature[] r29 = r1.parseFeatures()
            int r29 = com.alibaba.fastjson.parser.Feature.of(r29)
            java.lang.String r1 = r1.name()
            goto L_0x0117
        L_0x0110:
            r1 = 0
            r2 = 0
            r14 = 0
            r28 = 0
            r29 = 0
        L_0x0117:
            if (r1 == 0) goto L_0x011f
            int r30 = r1.length()
            if (r30 != 0) goto L_0x0127
        L_0x011f:
            if (r23 != 0) goto L_0x0125
            java.lang.String[] r23 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(r22)
        L_0x0125:
            r1 = r23[r0]
        L_0x0127:
            if (r2 != 0) goto L_0x014e
            if (r23 != 0) goto L_0x0131
            if (r17 == 0) goto L_0x0138
            java.lang.String[] r23 = com.alibaba.fastjson.util.TypeUtils.getKoltinConstructorParameters(r57)
        L_0x0131:
            r30 = r2
            r31 = r3
            r2 = r23
            goto L_0x013d
        L_0x0138:
            java.lang.String[] r23 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(r22)
            goto L_0x0131
        L_0x013d:
            int r3 = r2.length
            if (r3 <= r0) goto L_0x014b
            r3 = r2[r0]
            java.lang.reflect.Field r3 = com.alibaba.fastjson.util.TypeUtils.getField(r13, r3, r8)
            r23 = r2
            r30 = r3
            goto L_0x0152
        L_0x014b:
            r23 = r2
            goto L_0x0152
        L_0x014e:
            r30 = r2
            r31 = r3
        L_0x0152:
            com.alibaba.fastjson.util.FieldInfo r3 = new com.alibaba.fastjson.util.FieldInfo
            r32 = r0
            r0 = r3
            r33 = r62
            r34 = r15
            r15 = r27
            r2 = r57
            r62 = r9
            r35 = r31
            r9 = r3
            r3 = r4
            r15 = 0
            r4 = r6
            r6 = r5
            r5 = r30
            r15 = r6
            r6 = r14
            r14 = r7
            r7 = r28
            r25 = r11
            r11 = r8
            r8 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            add(r15, r9)
            r0 = 1
            int r1 = r32 + 1
            r9 = r62
            r0 = r1
            r8 = r11
            r7 = r14
            r5 = r15
            r11 = r25
            r2 = r27
            r1 = r33
            r15 = r34
            r3 = r35
            goto L_0x00c2
        L_0x018f:
            r27 = r2
            r35 = r3
            r14 = r7
            r25 = r11
            r34 = r15
            r15 = r5
            r11 = r8
        L_0x019a:
            r29 = r25
            r37 = r27
            r36 = r35
            r27 = r11
            r11 = r34
            goto L_0x0470
        L_0x01a6:
            r27 = r2
            r35 = r3
            r14 = r7
            r25 = r11
            r34 = r15
            r15 = r5
            r11 = r8
            java.lang.reflect.Method r20 = getFactoryMethod(r13, r14, r9)
            if (r20 == 0) goto L_0x026d
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r20)
            java.lang.Class[] r8 = r20.getParameterTypes()
            int r0 = r8.length
            if (r0 <= 0) goto L_0x019a
            java.lang.annotation.Annotation[][] r14 = com.alibaba.fastjson.util.TypeUtils.getParameterAnnotations((java.lang.reflect.Method) r20)
            r6 = 0
            r7 = 0
        L_0x01c7:
            int r0 = r8.length
            if (r7 >= r0) goto L_0x025c
            r0 = r14[r7]
            int r1 = r0.length
            r4 = 0
        L_0x01ce:
            if (r4 >= r1) goto L_0x01dd
            r2 = r0[r4]
            boolean r3 = r2 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r3 == 0) goto L_0x01da
            r0 = r2
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            goto L_0x01de
        L_0x01da:
            r2 = 1
            int r4 = r4 + r2
            goto L_0x01ce
        L_0x01dd:
            r0 = 0
        L_0x01de:
            if (r0 != 0) goto L_0x01f1
            if (r9 == 0) goto L_0x01e9
            boolean r1 = com.alibaba.fastjson.util.TypeUtils.isJacksonCreator(r20)
            if (r1 == 0) goto L_0x01e9
            goto L_0x01f1
        L_0x01e9:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "illegal json creator"
            r0.<init>(r1)
            throw r0
        L_0x01f1:
            if (r0 == 0) goto L_0x0212
            java.lang.String r1 = r0.name()
            int r2 = r0.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r3 = r0.serialzeFeatures()
            int r3 = com.alibaba.fastjson.serializer.SerializerFeature.of(r3)
            com.alibaba.fastjson.parser.Feature[] r0 = r0.parseFeatures()
            int r0 = com.alibaba.fastjson.parser.Feature.of(r0)
            r18 = r0
            r16 = r2
            r17 = r3
            goto L_0x0219
        L_0x0212:
            r1 = 0
            r16 = 0
            r17 = 0
            r18 = 0
        L_0x0219:
            if (r1 == 0) goto L_0x0225
            int r0 = r1.length()
            if (r0 != 0) goto L_0x0222
            goto L_0x0225
        L_0x0222:
            r19 = r6
            goto L_0x022f
        L_0x0225:
            if (r6 != 0) goto L_0x022b
            java.lang.String[] r6 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(r20)
        L_0x022b:
            r0 = r6[r7]
            r1 = r0
            goto L_0x0222
        L_0x022f:
            r3 = r8[r7]
            java.lang.reflect.Type[] r0 = r20.getGenericParameterTypes()
            r4 = r0[r7]
            java.lang.reflect.Field r5 = com.alibaba.fastjson.util.TypeUtils.getField(r13, r1, r11)
            com.alibaba.fastjson.util.FieldInfo r6 = new com.alibaba.fastjson.util.FieldInfo
            r0 = r6
            r2 = r57
            r9 = r6
            r6 = r16
            r16 = r7
            r7 = r17
            r17 = r8
            r8 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            add(r15, r9)
            r0 = 1
            int r7 = r16 + 1
            r9 = r62
            r8 = r17
            r6 = r19
            goto L_0x01c7
        L_0x025c:
            com.alibaba.fastjson.util.JavaBeanInfo r9 = new com.alibaba.fastjson.util.JavaBeanInfo
            r4 = 0
            r6 = 0
            r3 = 0
            r0 = r9
            r1 = r57
            r2 = r10
            r5 = r20
            r7 = r12
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x026d:
            if (r1 != 0) goto L_0x019a
            java.lang.String r9 = r57.getName()
            if (r17 == 0) goto L_0x028c
            int r1 = r0.length
            if (r1 <= 0) goto L_0x028c
            java.lang.String[] r1 = com.alibaba.fastjson.util.TypeUtils.getKoltinConstructorParameters(r57)
            java.lang.reflect.Constructor r0 = com.alibaba.fastjson.util.TypeUtils.getKoltinConstructor(r0, r1)
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r0)
            r22 = r0
            r7 = r1
            r8 = r25
        L_0x0288:
            r5 = r27
            goto L_0x0355
        L_0x028c:
            int r1 = r0.length
            r4 = 0
            r6 = 0
        L_0x028f:
            if (r4 >= r1) goto L_0x0350
            r2 = r0[r4]
            java.lang.Class[] r3 = r2.getParameterTypes()
            java.lang.String r5 = "org.springframework.security.web.authentication.WebAuthenticationDetails"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x02c3
            int r5 = r3.length
            r7 = 2
            if (r5 != r7) goto L_0x02c0
            r5 = 0
            r7 = r3[r5]
            r8 = r25
            if (r7 != r8) goto L_0x02ba
            r5 = 1
            r3 = r3[r5]
            if (r3 != r8) goto L_0x02ba
            r2.setAccessible(r5)
            java.lang.String[] r1 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(r2)
            r7 = r1
            r22 = r2
            goto L_0x0288
        L_0x02ba:
            r23 = r0
            r5 = r27
            goto L_0x0346
        L_0x02c0:
            r8 = r25
            goto L_0x02ba
        L_0x02c3:
            r8 = r25
            java.lang.String r5 = "org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x0303
            int r5 = r3.length
            r7 = 3
            if (r5 != r7) goto L_0x02ba
            r5 = 0
            r7 = r3[r5]
            r5 = r27
            r23 = r0
            if (r7 != r5) goto L_0x0346
            r7 = 1
            r0 = r3[r7]
            if (r0 != r5) goto L_0x0346
            r0 = 2
            r3 = r3[r0]
            r0 = r35
            if (r3 != r0) goto L_0x0300
            r2.setAccessible(r7)
            r1 = 3
            java.lang.String[] r3 = new java.lang.String[r1]
            java.lang.String r1 = "principal"
            r4 = 0
            r3[r4] = r1
            java.lang.String r1 = "credentials"
            r3[r7] = r1
            java.lang.String r1 = "authorities"
            r4 = 2
            r3[r4] = r1
            r35 = r0
            r22 = r2
            r7 = r3
            goto L_0x0355
        L_0x0300:
            r35 = r0
            goto L_0x0346
        L_0x0303:
            r23 = r0
            r5 = r27
            r0 = r35
            java.lang.String r7 = "org.springframework.security.core.authority.SimpleGrantedAuthority"
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L_0x0326
            int r7 = r3.length
            r35 = r0
            r0 = 1
            if (r7 != r0) goto L_0x0346
            r7 = 0
            r3 = r3[r7]
            if (r3 != r8) goto L_0x0346
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String r3 = "authority"
            r1[r7] = r3
            r7 = r1
            r22 = r2
            goto L_0x0355
        L_0x0326:
            r35 = r0
            r0 = 1
            int r3 = r2.getModifiers()
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0346
            java.lang.String[] r0 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(r2)
            if (r0 == 0) goto L_0x0346
            int r3 = r0.length
            if (r3 != 0) goto L_0x033a
            goto L_0x0346
        L_0x033a:
            if (r22 == 0) goto L_0x0343
            if (r6 == 0) goto L_0x0343
            int r3 = r0.length
            int r7 = r6.length
            if (r3 > r7) goto L_0x0343
            goto L_0x0346
        L_0x0343:
            r6 = r0
            r22 = r2
        L_0x0346:
            r0 = 1
            int r4 = r4 + r0
            r27 = r5
            r25 = r8
            r0 = r23
            goto L_0x028f
        L_0x0350:
            r8 = r25
            r5 = r27
            r7 = r6
        L_0x0355:
            if (r7 == 0) goto L_0x035c
            java.lang.Class[] r6 = r22.getParameterTypes()
            goto L_0x035d
        L_0x035c:
            r6 = 0
        L_0x035d:
            if (r7 == 0) goto L_0x044c
            int r0 = r6.length
            int r1 = r7.length
            if (r0 != r1) goto L_0x044c
            java.lang.annotation.Annotation[][] r23 = com.alibaba.fastjson.util.TypeUtils.getParameterAnnotations((java.lang.reflect.Constructor) r22)
            r4 = 0
        L_0x0368:
            int r0 = r6.length
            if (r4 >= r0) goto L_0x0423
            r0 = r23[r4]
            r1 = r7[r4]
            int r2 = r0.length
            r3 = 0
        L_0x0371:
            if (r3 >= r2) goto L_0x0388
            r25 = r2
            r2 = r0[r3]
            r62 = r0
            boolean r0 = r2 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r0 == 0) goto L_0x0381
            r0 = r2
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            goto L_0x0389
        L_0x0381:
            r0 = 1
            int r3 = r3 + r0
            r0 = r62
            r2 = r25
            goto L_0x0371
        L_0x0388:
            r0 = 0
        L_0x0389:
            r3 = r6[r4]
            java.lang.reflect.Type[] r2 = r22.getGenericParameterTypes()
            r25 = r2[r4]
            java.lang.reflect.Field r2 = com.alibaba.fastjson.util.TypeUtils.getField(r13, r1, r11)
            if (r2 == 0) goto L_0x03a4
            if (r0 != 0) goto L_0x03a4
            r27 = r11
            r11 = r34
            java.lang.annotation.Annotation r0 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Field) r2, r11)
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            goto L_0x03a8
        L_0x03a4:
            r27 = r11
            r11 = r34
        L_0x03a8:
            if (r0 != 0) goto L_0x03cc
            java.lang.String r0 = "org.springframework.security.core.userdetails.User"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x03c5
            java.lang.String r0 = "password"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x03c5
            com.alibaba.fastjson.parser.Feature r0 = com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty
            int r0 = r0.mask
            r30 = r0
            r28 = 0
            r29 = 0
            goto L_0x03ee
        L_0x03c5:
            r28 = 0
            r29 = 0
            r30 = 0
            goto L_0x03ee
        L_0x03cc:
            java.lang.String r28 = r0.name()
            int r29 = r28.length()
            if (r29 == 0) goto L_0x03d8
            r1 = r28
        L_0x03d8:
            int r28 = r0.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r29 = r0.serialzeFeatures()
            int r29 = com.alibaba.fastjson.serializer.SerializerFeature.of(r29)
            com.alibaba.fastjson.parser.Feature[] r0 = r0.parseFeatures()
            int r0 = com.alibaba.fastjson.parser.Feature.of(r0)
            r30 = r0
        L_0x03ee:
            com.alibaba.fastjson.util.FieldInfo r0 = new com.alibaba.fastjson.util.FieldInfo
            r62 = r0
            r36 = r35
            r31 = r2
            r2 = r57
            r32 = r4
            r4 = r25
            r37 = r5
            r5 = r31
            r25 = r6
            r6 = r28
            r28 = r7
            r7 = r29
            r29 = r8
            r8 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            add(r15, r0)
            r0 = 1
            int r4 = r32 + 1
            r34 = r11
            r6 = r25
            r11 = r27
            r7 = r28
            r8 = r29
            r5 = r37
            goto L_0x0368
        L_0x0423:
            r37 = r5
            r29 = r8
            r27 = r11
            r11 = r34
            r36 = r35
            if (r17 != 0) goto L_0x0470
            java.lang.String r0 = r57.getName()
            java.lang.String r1 = "javax.servlet.http.Cookie"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0470
            com.alibaba.fastjson.util.JavaBeanInfo r9 = new com.alibaba.fastjson.util.JavaBeanInfo
            r5 = 0
            r6 = 0
            r3 = 0
            r0 = r9
            r1 = r57
            r2 = r10
            r4 = r22
            r7 = r12
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x044c:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "default constructor not found. "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0463:
            r37 = r2
            r36 = r3
            r14 = r7
            r27 = r8
            r29 = r11
            r11 = r15
            r15 = r5
            r22 = 0
        L_0x0470:
            if (r18 == 0) goto L_0x0475
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r18)
        L_0x0475:
            java.lang.String r9 = "set"
            if (r10 == 0) goto L_0x0671
            java.lang.Class<com.alibaba.fastjson.annotation.JSONPOJOBuilder> r8 = com.alibaba.fastjson.annotation.JSONPOJOBuilder.class
            java.lang.annotation.Annotation r0 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r10, r8)
            com.alibaba.fastjson.annotation.JSONPOJOBuilder r0 = (com.alibaba.fastjson.annotation.JSONPOJOBuilder) r0
            if (r0 == 0) goto L_0x0488
            java.lang.String r6 = r0.withPrefix()
            goto L_0x0489
        L_0x0488:
            r6 = 0
        L_0x0489:
            if (r6 != 0) goto L_0x048d
            java.lang.String r6 = "with"
        L_0x048d:
            r7 = r6
            java.lang.reflect.Method[] r6 = r10.getMethods()
            int r5 = r6.length
            r4 = 0
        L_0x0494:
            if (r4 >= r5) goto L_0x062d
            r2 = r6[r4]
            int r0 = r2.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            if (r0 == 0) goto L_0x04bd
        L_0x04a2:
            r42 = r59
            r32 = r4
            r33 = r5
            r34 = r6
            r17 = r7
            r39 = r8
            r47 = r9
            r41 = r10
            r45 = r11
            r43 = r27
            r44 = r29
            r0 = 1
            r27 = r12
            goto L_0x0613
        L_0x04bd:
            java.lang.Class r0 = r2.getReturnType()
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x04c8
            goto L_0x04a2
        L_0x04c8:
            java.lang.annotation.Annotation r0 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Method) r2, r11)
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            if (r0 != 0) goto L_0x04d4
            com.alibaba.fastjson.annotation.JSONField r0 = com.alibaba.fastjson.util.TypeUtils.getSuperMethodAnnotation(r13, r2)
        L_0x04d4:
            r17 = r0
            if (r17 == 0) goto L_0x0566
            boolean r0 = r17.deserialize()
            if (r0 != 0) goto L_0x04df
            goto L_0x04a2
        L_0x04df:
            int r23 = r17.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r17.serialzeFeatures()
            int r25 = com.alibaba.fastjson.serializer.SerializerFeature.of(r0)
            com.alibaba.fastjson.parser.Feature[] r0 = r17.parseFeatures()
            int r28 = com.alibaba.fastjson.parser.Feature.of(r0)
            java.lang.String r0 = r17.name()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x0547
            java.lang.String r1 = r17.name()
            com.alibaba.fastjson.util.FieldInfo r3 = new com.alibaba.fastjson.util.FieldInfo
            r30 = 0
            r31 = 0
            r32 = 0
            r0 = r3
            r38 = r3
            r3 = r32
            r32 = r4
            r4 = r57
            r33 = r5
            r5 = r58
            r34 = r6
            r6 = r23
            r62 = r7
            r7 = r25
            r39 = r8
            r8 = r28
            r40 = r9
            r9 = r17
            r41 = r10
            r10 = r30
            r42 = r59
            r45 = r11
            r43 = r27
            r44 = r29
            r11 = r31
            r27 = r12
            r12 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r38
            add(r15, r0)
            r17 = r62
            r47 = r40
        L_0x0544:
            r0 = 1
            goto L_0x0613
        L_0x0547:
            r42 = r59
            r32 = r4
            r33 = r5
            r34 = r6
            r62 = r7
            r39 = r8
            r40 = r9
            r41 = r10
            r45 = r11
            r43 = r27
            r44 = r29
            r27 = r12
            r6 = r23
            r7 = r25
            r8 = r28
            goto L_0x0581
        L_0x0566:
            r42 = r59
            r32 = r4
            r33 = r5
            r34 = r6
            r62 = r7
            r39 = r8
            r40 = r9
            r41 = r10
            r45 = r11
            r43 = r27
            r44 = r29
            r27 = r12
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0581:
            java.lang.String r0 = r2.getName()
            r12 = r40
            boolean r1 = r0.startsWith(r12)
            if (r1 == 0) goto L_0x05a1
            int r1 = r0.length()
            r3 = 3
            if (r1 <= r3) goto L_0x05a1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r0 = r0.substring(r3)
            r1.<init>(r0)
        L_0x059d:
            r11 = r62
        L_0x059f:
            r0 = 0
            goto L_0x05d3
        L_0x05a1:
            int r1 = r62.length()
            if (r1 != 0) goto L_0x05ad
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            goto L_0x059d
        L_0x05ad:
            r11 = r62
            boolean r1 = r0.startsWith(r11)
            if (r1 != 0) goto L_0x05ba
        L_0x05b5:
            r17 = r11
            r47 = r12
            goto L_0x0544
        L_0x05ba:
            int r1 = r0.length()
            int r3 = r11.length()
            if (r1 > r3) goto L_0x05c5
            goto L_0x05b5
        L_0x05c5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r3 = r11.length()
            java.lang.String r0 = r0.substring(r3)
            r1.<init>(r0)
            goto L_0x059f
        L_0x05d3:
            char r3 = r1.charAt(r0)
            int r4 = r11.length()
            if (r4 == 0) goto L_0x05e4
            boolean r4 = java.lang.Character.isUpperCase(r3)
            if (r4 != 0) goto L_0x05e4
            goto L_0x05b5
        L_0x05e4:
            char r3 = java.lang.Character.toLowerCase(r3)
            r1.setCharAt(r0, r3)
            java.lang.String r1 = r1.toString()
            com.alibaba.fastjson.util.FieldInfo r10 = new com.alibaba.fastjson.util.FieldInfo
            r23 = 0
            r25 = 0
            r3 = 0
            r0 = r10
            r4 = r57
            r5 = r58
            r9 = r17
            r46 = r10
            r10 = r23
            r17 = r11
            r11 = r25
            r47 = r12
            r12 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r46
            add(r15, r0)
            goto L_0x0544
        L_0x0613:
            int r4 = r32 + 1
            r7 = r17
            r12 = r27
            r5 = r33
            r6 = r34
            r8 = r39
            r10 = r41
            r59 = r42
            r27 = r43
            r29 = r44
            r11 = r45
            r9 = r47
            goto L_0x0494
        L_0x062d:
            r42 = r59
            r0 = r8
            r47 = r9
            r45 = r11
            r43 = r27
            r44 = r29
            r27 = r12
            r12 = r10
            java.lang.annotation.Annotation r0 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r12, r0)
            com.alibaba.fastjson.annotation.JSONPOJOBuilder r0 = (com.alibaba.fastjson.annotation.JSONPOJOBuilder) r0
            if (r0 == 0) goto L_0x0648
            java.lang.String r6 = r0.buildMethod()
            goto L_0x0649
        L_0x0648:
            r6 = 0
        L_0x0649:
            if (r6 == 0) goto L_0x0654
            int r0 = r6.length()
            if (r0 != 0) goto L_0x0652
            goto L_0x0654
        L_0x0652:
            r11 = 0
            goto L_0x0657
        L_0x0654:
            java.lang.String r6 = "build"
            goto L_0x0652
        L_0x0657:
            java.lang.reflect.Method r19 = r12.getMethod(r6, r11)     // Catch:{ NoSuchMethodException | SecurityException -> 0x065b }
        L_0x065b:
            if (r19 != 0) goto L_0x0663
            java.lang.String r0 = "create"
            java.lang.reflect.Method r19 = r12.getMethod(r0, r11)     // Catch:{ NoSuchMethodException | SecurityException -> 0x0663 }
        L_0x0663:
            if (r19 == 0) goto L_0x0669
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r19)
            goto L_0x067f
        L_0x0669:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "buildMethod not found."
            r0.<init>(r1)
            throw r0
        L_0x0671:
            r42 = r59
            r47 = r9
            r45 = r11
            r43 = r27
            r44 = r29
            r11 = 0
            r27 = r12
            r12 = r10
        L_0x067f:
            int r10 = r14.length
            r9 = 0
        L_0x0681:
            r8 = 4
            if (r9 >= r10) goto L_0x09ee
            r2 = r14[r9]
            java.lang.String r0 = r2.getName()
            int r1 = r2.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)
            if (r1 == 0) goto L_0x06b1
        L_0x0694:
            r33 = r9
            r34 = r10
            r29 = r11
            r30 = r12
            r17 = r14
            r32 = r37
        L_0x06a0:
            r52 = r42
            r31 = r44
            r51 = r45
            r40 = r47
            r0 = 1
            r26 = 0
            r28 = 2
        L_0x06ad:
            r35 = 3
            goto L_0x09d8
        L_0x06b1:
            java.lang.Class r1 = r2.getReturnType()
            java.lang.Class r3 = java.lang.Void.TYPE
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x06c8
            java.lang.Class r3 = r2.getDeclaringClass()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x06c8
            goto L_0x0694
        L_0x06c8:
            java.lang.Class r1 = r2.getDeclaringClass()
            r7 = r37
            if (r1 != r7) goto L_0x06dd
            r32 = r7
            r33 = r9
            r34 = r10
            r29 = r11
            r30 = r12
            r17 = r14
            goto L_0x06a0
        L_0x06dd:
            java.lang.Class[] r1 = r2.getParameterTypes()
            int r3 = r1.length
            if (r3 == 0) goto L_0x09bc
            int r3 = r1.length
            r6 = 2
            if (r3 <= r6) goto L_0x0702
            r28 = r6
            r32 = r7
            r33 = r9
            r34 = r10
            r29 = r11
            r30 = r12
            r17 = r14
            r52 = r42
            r31 = r44
            r51 = r45
            r40 = r47
        L_0x06fe:
            r0 = 1
        L_0x06ff:
            r26 = 0
            goto L_0x06ad
        L_0x0702:
            r5 = r45
            java.lang.annotation.Annotation r3 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Method) r2, r5)
            r17 = r3
            com.alibaba.fastjson.annotation.JSONField r17 = (com.alibaba.fastjson.annotation.JSONField) r17
            r21 = 0
            r23 = 0
            r25 = 0
            if (r17 == 0) goto L_0x0786
            int r3 = r1.length
            if (r3 != r6) goto L_0x0786
            r3 = 0
            r4 = r1[r3]
            r3 = r44
            if (r4 != r3) goto L_0x0775
            r4 = 1
            r6 = r1[r4]
            if (r6 != r7) goto L_0x0764
            com.alibaba.fastjson.util.FieldInfo r8 = new com.alibaba.fastjson.util.FieldInfo
            r29 = 0
            r30 = 0
            java.lang.String r1 = ""
            r4 = 0
            r0 = r8
            r31 = r3
            r3 = r4
            r4 = r57
            r6 = r5
            r5 = r58
            r48 = r6
            r28 = 2
            r6 = r21
            r32 = r7
            r7 = r23
            r49 = r8
            r8 = r25
            r33 = r9
            r9 = r17
            r34 = r10
            r10 = r29
            r29 = r11
            r11 = r30
            r30 = r12
            r12 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r49
            add(r15, r0)
        L_0x075b:
            r17 = r14
        L_0x075d:
            r52 = r42
            r40 = r47
        L_0x0761:
            r51 = r48
            goto L_0x06fe
        L_0x0764:
            r31 = r3
            r48 = r5
            r32 = r7
            r33 = r9
            r34 = r10
            r29 = r11
            r30 = r12
            r28 = 2
            goto L_0x0796
        L_0x0775:
            r31 = r3
            r48 = r5
            r28 = r6
            r32 = r7
            r33 = r9
            r34 = r10
            r29 = r11
            r30 = r12
            goto L_0x0796
        L_0x0786:
            r48 = r5
            r28 = r6
            r32 = r7
            r33 = r9
            r34 = r10
            r29 = r11
            r30 = r12
            r31 = r44
        L_0x0796:
            int r3 = r1.length
            r4 = 1
            if (r3 == r4) goto L_0x07a5
            r0 = r4
            r17 = r14
            r52 = r42
            r40 = r47
            r51 = r48
            goto L_0x06ff
        L_0x07a5:
            if (r17 != 0) goto L_0x07ad
            com.alibaba.fastjson.annotation.JSONField r3 = com.alibaba.fastjson.util.TypeUtils.getSuperMethodAnnotation(r13, r2)
            r9 = r3
            goto L_0x07af
        L_0x07ad:
            r9 = r17
        L_0x07af:
            if (r9 != 0) goto L_0x07b8
            int r3 = r0.length()
            if (r3 >= r8) goto L_0x07b8
        L_0x07b7:
            goto L_0x075b
        L_0x07b8:
            if (r9 == 0) goto L_0x0808
            boolean r3 = r9.deserialize()
            if (r3 != 0) goto L_0x07c1
            goto L_0x07b7
        L_0x07c1:
            int r6 = r9.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r3 = r9.serialzeFeatures()
            int r7 = com.alibaba.fastjson.serializer.SerializerFeature.of(r3)
            com.alibaba.fastjson.parser.Feature[] r3 = r9.parseFeatures()
            int r10 = com.alibaba.fastjson.parser.Feature.of(r3)
            java.lang.String r3 = r9.name()
            int r3 = r3.length()
            if (r3 == 0) goto L_0x07ff
            java.lang.String r1 = r9.name()
            com.alibaba.fastjson.util.FieldInfo r12 = new com.alibaba.fastjson.util.FieldInfo
            r11 = 0
            r17 = 0
            r3 = 0
            r0 = r12
            r4 = r57
            r5 = r58
            r8 = r10
            r10 = r11
            r11 = r17
            r17 = r14
            r14 = r12
            r12 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            add(r15, r14)
            goto L_0x075d
        L_0x07ff:
            r17 = r14
            r21 = r6
            r23 = r7
            r25 = r10
            goto L_0x080a
        L_0x0808:
            r17 = r14
        L_0x080a:
            r14 = r47
            if (r9 != 0) goto L_0x081b
            boolean r3 = r0.startsWith(r14)
            if (r3 == 0) goto L_0x0815
            goto L_0x081b
        L_0x0815:
            r40 = r14
            r52 = r42
            goto L_0x0761
        L_0x081b:
            if (r30 == 0) goto L_0x081e
            goto L_0x0815
        L_0x081e:
            r12 = 3
            char r3 = r0.charAt(r12)
            boolean r4 = java.lang.Character.isUpperCase(r3)
            if (r4 != 0) goto L_0x082d
            r4 = 512(0x200, float:7.175E-43)
            if (r3 <= r4) goto L_0x0830
        L_0x082d:
            r11 = r43
            goto L_0x088f
        L_0x0830:
            r4 = 95
            if (r3 != r4) goto L_0x084f
            java.lang.String r3 = r0.substring(r8)
            r11 = r43
            java.lang.reflect.Field r6 = com.alibaba.fastjson.util.TypeUtils.getField(r13, r3, r11)
            if (r6 != 0) goto L_0x08b8
            java.lang.String r0 = r0.substring(r12)
            java.lang.reflect.Field r6 = com.alibaba.fastjson.util.TypeUtils.getField(r13, r0, r11)
            if (r6 != 0) goto L_0x084c
            goto L_0x08b8
        L_0x084c:
            r3 = r0
            goto L_0x08b8
        L_0x084f:
            r11 = r43
            r4 = 102(0x66, float:1.43E-43)
            if (r3 != r4) goto L_0x085c
            java.lang.String r3 = r0.substring(r12)
        L_0x0859:
            r6 = r29
            goto L_0x08b8
        L_0x085c:
            int r3 = r0.length()
            r4 = 5
            if (r3 < r4) goto L_0x0876
            char r3 = r0.charAt(r8)
            boolean r3 = java.lang.Character.isUpperCase(r3)
            if (r3 == 0) goto L_0x0876
            java.lang.String r0 = r0.substring(r12)
            java.lang.String r3 = com.alibaba.fastjson.util.TypeUtils.decapitalize(r0)
            goto L_0x0859
        L_0x0876:
            java.lang.String r3 = r0.substring(r12)
            java.lang.reflect.Field r6 = com.alibaba.fastjson.util.TypeUtils.getField(r13, r3, r11)
            if (r6 != 0) goto L_0x08b8
            r43 = r11
            r35 = r12
            r40 = r14
            r52 = r42
            r51 = r48
            r0 = 1
            r26 = 0
            goto L_0x09d8
        L_0x088f:
            boolean r3 = com.alibaba.fastjson.util.TypeUtils.compatibleWithJavaBean
            if (r3 == 0) goto L_0x089c
            java.lang.String r0 = r0.substring(r12)
            java.lang.String r3 = com.alibaba.fastjson.util.TypeUtils.decapitalize(r0)
            goto L_0x0859
        L_0x089c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            char r4 = r0.charAt(r12)
            char r4 = java.lang.Character.toLowerCase(r4)
            r3.append(r4)
            java.lang.String r0 = r0.substring(r8)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            goto L_0x0859
        L_0x08b8:
            if (r6 != 0) goto L_0x08be
            java.lang.reflect.Field r6 = com.alibaba.fastjson.util.TypeUtils.getField(r13, r3, r11)
        L_0x08be:
            r10 = 0
            if (r6 != 0) goto L_0x08ed
            r0 = r1[r10]
            java.lang.Class r1 = java.lang.Boolean.TYPE
            if (r0 != r1) goto L_0x08ed
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "is"
            r0.append(r1)
            char r1 = r3.charAt(r10)
            char r1 = java.lang.Character.toUpperCase(r1)
            r0.append(r1)
            r1 = 1
            java.lang.String r4 = r3.substring(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.reflect.Field r0 = com.alibaba.fastjson.util.TypeUtils.getField(r13, r0, r11)
            r6 = r0
        L_0x08ed:
            if (r6 == 0) goto L_0x0986
            r8 = r48
            java.lang.annotation.Annotation r0 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Field) r6, r8)
            r24 = r0
            com.alibaba.fastjson.annotation.JSONField r24 = (com.alibaba.fastjson.annotation.JSONField) r24
            if (r24 == 0) goto L_0x0974
            boolean r0 = r24.deserialize()
            if (r0 != 0) goto L_0x0910
            r51 = r8
            r26 = r10
            r43 = r11
            r35 = r12
            r40 = r14
        L_0x090b:
            r52 = r42
        L_0x090d:
            r0 = 1
            goto L_0x09d8
        L_0x0910:
            int r7 = r24.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r24.serialzeFeatures()
            int r21 = com.alibaba.fastjson.serializer.SerializerFeature.of(r0)
            com.alibaba.fastjson.parser.Feature[] r0 = r24.parseFeatures()
            int r23 = com.alibaba.fastjson.parser.Feature.of(r0)
            java.lang.String r0 = r24.name()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x095e
            java.lang.String r1 = r24.name()
            com.alibaba.fastjson.util.FieldInfo r5 = new com.alibaba.fastjson.util.FieldInfo
            r25 = 0
            r0 = r5
            r3 = r6
            r4 = r57
            r6 = r5
            r5 = r58
            r50 = r6
            r6 = r7
            r7 = r21
            r51 = r8
            r8 = r23
            r26 = r10
            r10 = r24
            r40 = r14
            r14 = r11
            r11 = r25
            r35 = r12
            r12 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r50
            add(r15, r0)
            r43 = r14
            goto L_0x090b
        L_0x095e:
            r51 = r8
            r26 = r10
            r35 = r12
            r40 = r14
            r14 = r11
            r8 = r23
            r10 = r24
            r12 = r42
            r56 = r21
            r21 = r7
            r7 = r56
            goto L_0x0996
        L_0x0974:
            r51 = r8
            r26 = r10
            r35 = r12
            r40 = r14
            r14 = r11
            r7 = r23
            r10 = r24
            r8 = r25
        L_0x0983:
            r12 = r42
            goto L_0x0996
        L_0x0986:
            r26 = r10
            r35 = r12
            r40 = r14
            r51 = r48
            r14 = r11
            r7 = r23
            r8 = r25
            r10 = r29
            goto L_0x0983
        L_0x0996:
            if (r12 == 0) goto L_0x099e
            java.lang.String r0 = r12.translate(r3)
            r1 = r0
            goto L_0x099f
        L_0x099e:
            r1 = r3
        L_0x099f:
            com.alibaba.fastjson.util.FieldInfo r11 = new com.alibaba.fastjson.util.FieldInfo
            r23 = 0
            r0 = r11
            r3 = r6
            r4 = r57
            r5 = r58
            r6 = r21
            r43 = r14
            r14 = r11
            r11 = r23
            r52 = r12
            r12 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            add(r15, r14)
            goto L_0x090d
        L_0x09bc:
            r32 = r7
            r33 = r9
            r34 = r10
            r29 = r11
            r30 = r12
            r17 = r14
            r52 = r42
            r31 = r44
            r51 = r45
            r40 = r47
            r26 = 0
            r28 = 2
            r35 = 3
            goto L_0x090d
        L_0x09d8:
            int r9 = r33 + 1
            r14 = r17
            r11 = r29
            r12 = r30
            r44 = r31
            r37 = r32
            r10 = r34
            r47 = r40
            r45 = r51
            r42 = r52
            goto L_0x0681
        L_0x09ee:
            r30 = r12
            r52 = r42
            r51 = r45
            r26 = 0
            r35 = 3
            java.lang.reflect.Field[] r0 = r57.getFields()
            r14 = r58
            r11 = r35
            r12 = r52
            computeFields(r13, r14, r12, r15, r0)
            java.lang.reflect.Method[] r10 = r57.getMethods()
            int r9 = r10.length
            r7 = r26
        L_0x0a0c:
            if (r7 >= r9) goto L_0x0b77
            r2 = r10[r7]
            java.lang.String r0 = r2.getName()
            int r1 = r0.length()
            if (r1 >= r8) goto L_0x0a2f
        L_0x0a1a:
            r25 = r7
            r26 = r8
            r28 = r9
            r17 = r10
            r21 = r11
            r55 = r12
            r29 = r36
        L_0x0a28:
            r54 = r43
            r24 = r51
        L_0x0a2c:
            r0 = 1
            goto L_0x0b63
        L_0x0a2f:
            int r1 = r2.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)
            if (r1 == 0) goto L_0x0a3a
            goto L_0x0a1a
        L_0x0a3a:
            if (r30 != 0) goto L_0x0a1a
            java.lang.String r1 = "get"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x0a1a
            char r1 = r0.charAt(r11)
            boolean r1 = java.lang.Character.isUpperCase(r1)
            if (r1 == 0) goto L_0x0a1a
            java.lang.Class[] r1 = r2.getParameterTypes()
            int r1 = r1.length
            if (r1 == 0) goto L_0x0a56
            goto L_0x0a1a
        L_0x0a56:
            java.lang.Class r1 = r2.getReturnType()
            r6 = r36
            boolean r1 = r6.isAssignableFrom(r1)
            if (r1 != 0) goto L_0x0a86
            java.lang.Class<java.util.Map> r1 = java.util.Map.class
            java.lang.Class r3 = r2.getReturnType()
            boolean r1 = r1.isAssignableFrom(r3)
            if (r1 != 0) goto L_0x0a86
            java.lang.Class<java.util.concurrent.atomic.AtomicBoolean> r1 = java.util.concurrent.atomic.AtomicBoolean.class
            java.lang.Class r3 = r2.getReturnType()
            if (r1 == r3) goto L_0x0a86
            java.lang.Class<java.util.concurrent.atomic.AtomicInteger> r1 = java.util.concurrent.atomic.AtomicInteger.class
            java.lang.Class r3 = r2.getReturnType()
            if (r1 == r3) goto L_0x0a86
            java.lang.Class<java.util.concurrent.atomic.AtomicLong> r1 = java.util.concurrent.atomic.AtomicLong.class
            java.lang.Class r3 = r2.getReturnType()
            if (r1 != r3) goto L_0x0a89
        L_0x0a86:
            r5 = r51
            goto L_0x0a98
        L_0x0a89:
            r29 = r6
            r25 = r7
            r26 = r8
            r28 = r9
            r17 = r10
            r21 = r11
            r55 = r12
            goto L_0x0a28
        L_0x0a98:
            java.lang.annotation.Annotation r1 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Method) r2, r5)
            r17 = r1
            com.alibaba.fastjson.annotation.JSONField r17 = (com.alibaba.fastjson.annotation.JSONField) r17
            if (r17 == 0) goto L_0x0abc
            boolean r1 = r17.deserialize()
            if (r1 == 0) goto L_0x0abc
            r24 = r5
            r29 = r6
            r25 = r7
            r26 = r8
            r28 = r9
            r17 = r10
            r21 = r11
            r55 = r12
            r54 = r43
            goto L_0x0a2c
        L_0x0abc:
            if (r17 == 0) goto L_0x0acf
            java.lang.String r1 = r17.name()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0acf
            java.lang.String r0 = r17.name()
            r4 = r43
            goto L_0x0b14
        L_0x0acf:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            char r3 = r0.charAt(r11)
            char r3 = java.lang.Character.toLowerCase(r3)
            r1.append(r3)
            java.lang.String r0 = r0.substring(r8)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r4 = r43
            java.lang.reflect.Field r1 = com.alibaba.fastjson.util.TypeUtils.getField(r13, r0, r4)
            if (r1 == 0) goto L_0x0b14
            java.lang.annotation.Annotation r1 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Field) r1, r5)
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            if (r1 == 0) goto L_0x0b14
            boolean r1 = r1.deserialize()
            if (r1 != 0) goto L_0x0b14
        L_0x0b00:
            r54 = r4
            r24 = r5
            r29 = r6
            r25 = r7
            r26 = r8
            r28 = r9
            r17 = r10
            r21 = r11
            r55 = r12
            goto L_0x0a2c
        L_0x0b14:
            if (r12 == 0) goto L_0x0b1a
            java.lang.String r0 = r12.translate(r0)
        L_0x0b1a:
            r1 = r0
            com.alibaba.fastjson.util.FieldInfo r0 = getField(r15, r1)
            if (r0 == 0) goto L_0x0b22
            goto L_0x0b00
        L_0x0b22:
            com.alibaba.fastjson.util.FieldInfo r3 = new com.alibaba.fastjson.util.FieldInfo
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r28 = 0
            r0 = r3
            r53 = r3
            r3 = r24
            r54 = r4
            r4 = r57
            r24 = r5
            r5 = r58
            r29 = r6
            r6 = r25
            r25 = r7
            r7 = r26
            r26 = r8
            r8 = r28
            r28 = r9
            r9 = r17
            r17 = r10
            r10 = r21
            r21 = r11
            r11 = r23
            r55 = r12
            r12 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r53
            add(r15, r0)
            goto L_0x0a2c
        L_0x0b63:
            int r7 = r25 + 1
            r10 = r17
            r11 = r21
            r51 = r24
            r8 = r26
            r9 = r28
            r36 = r29
            r43 = r54
            r12 = r55
            goto L_0x0a0c
        L_0x0b77:
            r55 = r12
            r54 = r43
            r0 = 1
            int r1 = r15.size()
            if (r1 != 0) goto L_0x0b9c
            boolean r1 = com.alibaba.fastjson.util.TypeUtils.isXmlField(r57)
            if (r1 == 0) goto L_0x0b89
            goto L_0x0b8b
        L_0x0b89:
            r0 = r60
        L_0x0b8b:
            if (r0 == 0) goto L_0x0b9c
            r0 = r13
        L_0x0b8e:
            if (r0 == 0) goto L_0x0b9c
            r2 = r54
            r1 = r55
            computeFields(r13, r14, r1, r15, r2)
            java.lang.Class r0 = r0.getSuperclass()
            goto L_0x0b8e
        L_0x0b9c:
            com.alibaba.fastjson.util.JavaBeanInfo r9 = new com.alibaba.fastjson.util.JavaBeanInfo
            r0 = r9
            r1 = r57
            r2 = r30
            r3 = r18
            r4 = r22
            r5 = r20
            r6 = r19
            r7 = r27
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.JavaBeanInfo.build(java.lang.Class, java.lang.reflect.Type, com.alibaba.fastjson.PropertyNamingStrategy, boolean, boolean, boolean):com.alibaba.fastjson.util.JavaBeanInfo");
    }
}

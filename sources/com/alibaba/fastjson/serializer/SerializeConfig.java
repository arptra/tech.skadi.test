package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.spi.Module;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class SerializeConfig {
    private static boolean awtError = false;
    public static final SerializeConfig globalInstance = new SerializeConfig();
    private static boolean guavaError = false;
    private static boolean jdk8Error = false;
    private static boolean jodaError = false;
    private static boolean jsonnullError = false;
    private static boolean jsonobjectError = false;
    private static boolean oracleJdbcError = false;
    private static boolean springfoxError = false;
    private boolean asm;
    private ASMSerializerFactory asmFactory;
    private long[] denyClasses;
    private final boolean fieldBased;
    private final IdentityHashMap<Type, IdentityHashMap<Type, ObjectSerializer>> mixInSerializers;
    private List<Module> modules;
    public PropertyNamingStrategy propertyNamingStrategy;
    private final IdentityHashMap<Type, ObjectSerializer> serializers;
    protected String typeKey;

    public SerializeConfig() {
        this(8192);
    }

    private final JavaBeanSerializer createASMSerializer(SerializeBeanInfo serializeBeanInfo) throws Exception {
        JavaBeanSerializer createJavaBeanSerializer = this.asmFactory.createJavaBeanSerializer(serializeBeanInfo);
        int i = 0;
        while (true) {
            FieldSerializer[] fieldSerializerArr = createJavaBeanSerializer.sortedGetters;
            if (i >= fieldSerializerArr.length) {
                return createJavaBeanSerializer;
            }
            Class<?> cls = fieldSerializerArr[i].fieldInfo.fieldClass;
            if (cls.isEnum() && !(getObjectWriter(cls) instanceof EnumSerializer)) {
                createJavaBeanSerializer.writeDirect = false;
            }
            i++;
        }
    }

    public static SerializeConfig getGlobalInstance() {
        return globalInstance;
    }

    private void initSerializers() {
        put((Type) Boolean.class, (ObjectSerializer) BooleanCodec.instance);
        put((Type) Character.class, (ObjectSerializer) CharacterCodec.instance);
        put((Type) Byte.class, (ObjectSerializer) IntegerCodec.instance);
        put((Type) Short.class, (ObjectSerializer) IntegerCodec.instance);
        put((Type) Integer.class, (ObjectSerializer) IntegerCodec.instance);
        put((Type) Long.class, (ObjectSerializer) LongCodec.instance);
        put((Type) Float.class, (ObjectSerializer) FloatCodec.instance);
        put((Type) Double.class, (ObjectSerializer) DoubleSerializer.instance);
        put((Type) BigDecimal.class, (ObjectSerializer) BigDecimalCodec.instance);
        put((Type) BigInteger.class, (ObjectSerializer) BigIntegerCodec.instance);
        put((Type) String.class, (ObjectSerializer) StringCodec.instance);
        put((Type) byte[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) short[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) int[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) long[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) float[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) double[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) boolean[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) char[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) Object[].class, (ObjectSerializer) ObjectArrayCodec.instance);
        MiscCodec miscCodec = MiscCodec.instance;
        put((Type) Class.class, (ObjectSerializer) miscCodec);
        put((Type) SimpleDateFormat.class, (ObjectSerializer) miscCodec);
        put((Type) Currency.class, (ObjectSerializer) new MiscCodec());
        put((Type) TimeZone.class, (ObjectSerializer) miscCodec);
        put((Type) InetAddress.class, (ObjectSerializer) miscCodec);
        put((Type) Inet4Address.class, (ObjectSerializer) miscCodec);
        put((Type) Inet6Address.class, (ObjectSerializer) miscCodec);
        put((Type) InetSocketAddress.class, (ObjectSerializer) miscCodec);
        put((Type) File.class, (ObjectSerializer) miscCodec);
        AppendableSerializer appendableSerializer = AppendableSerializer.instance;
        put((Type) Appendable.class, (ObjectSerializer) appendableSerializer);
        put((Type) StringBuffer.class, (ObjectSerializer) appendableSerializer);
        put((Type) StringBuilder.class, (ObjectSerializer) appendableSerializer);
        ToStringSerializer toStringSerializer = ToStringSerializer.instance;
        put((Type) Charset.class, (ObjectSerializer) toStringSerializer);
        put((Type) Pattern.class, (ObjectSerializer) toStringSerializer);
        put((Type) Locale.class, (ObjectSerializer) toStringSerializer);
        put((Type) URI.class, (ObjectSerializer) toStringSerializer);
        put((Type) URL.class, (ObjectSerializer) toStringSerializer);
        put((Type) UUID.class, (ObjectSerializer) toStringSerializer);
        AtomicCodec atomicCodec = AtomicCodec.instance;
        put((Type) AtomicBoolean.class, (ObjectSerializer) atomicCodec);
        put((Type) AtomicInteger.class, (ObjectSerializer) atomicCodec);
        put((Type) AtomicLong.class, (ObjectSerializer) atomicCodec);
        ReferenceCodec referenceCodec = ReferenceCodec.instance;
        put((Type) AtomicReference.class, (ObjectSerializer) referenceCodec);
        put((Type) AtomicIntegerArray.class, (ObjectSerializer) atomicCodec);
        put((Type) AtomicLongArray.class, (ObjectSerializer) atomicCodec);
        put((Type) WeakReference.class, (ObjectSerializer) referenceCodec);
        put((Type) SoftReference.class, (ObjectSerializer) referenceCodec);
        put((Type) LinkedList.class, (ObjectSerializer) CollectionCodec.instance);
    }

    public void addFilter(Class<?> cls, SerializeFilter serializeFilter) {
        ObjectSerializer objectWriter = getObjectWriter(cls);
        if (objectWriter instanceof SerializeFilterable) {
            SerializeFilterable serializeFilterable = (SerializeFilterable) objectWriter;
            if (this == globalInstance || serializeFilterable != MapSerializer.instance) {
                serializeFilterable.addFilter(serializeFilter);
                return;
            }
            MapSerializer mapSerializer = new MapSerializer();
            put((Type) cls, (ObjectSerializer) mapSerializer);
            mapSerializer.addFilter(serializeFilter);
        }
    }

    public void clearSerializers() {
        this.serializers.clear();
        initSerializers();
    }

    public void config(Class<?> cls, SerializerFeature serializerFeature, boolean z) {
        ObjectSerializer objectWriter = getObjectWriter(cls, false);
        if (objectWriter == null) {
            SerializeBeanInfo buildBeanInfo = TypeUtils.buildBeanInfo(cls, (Map<String, String>) null, this.propertyNamingStrategy);
            if (z) {
                buildBeanInfo.features = serializerFeature.mask | buildBeanInfo.features;
            } else {
                buildBeanInfo.features = (~serializerFeature.mask) & buildBeanInfo.features;
            }
            put((Type) cls, createJavaBeanSerializer(buildBeanInfo));
        } else if (objectWriter instanceof JavaBeanSerializer) {
            SerializeBeanInfo serializeBeanInfo = ((JavaBeanSerializer) objectWriter).beanInfo;
            int i = serializeBeanInfo.features;
            if (z) {
                serializeBeanInfo.features = serializerFeature.mask | i;
            } else {
                serializeBeanInfo.features = (~serializerFeature.mask) & i;
            }
            if (i != serializeBeanInfo.features && objectWriter.getClass() != JavaBeanSerializer.class) {
                put((Type) cls, createJavaBeanSerializer(serializeBeanInfo));
            }
        }
    }

    public void configEnumAsJavaBean(Class<? extends Enum>... clsArr) {
        for (Class<? extends Enum> cls : clsArr) {
            put((Type) cls, createJavaBeanSerializer((Class<?>) cls));
        }
    }

    public final ObjectSerializer createJavaBeanSerializer(Class<?> cls) {
        String name = cls.getName();
        if (Arrays.binarySearch(this.denyClasses, TypeUtils.fnv1a_64(name)) < 0) {
            SerializeBeanInfo buildBeanInfo = TypeUtils.buildBeanInfo(cls, (Map<String, String>) null, this.propertyNamingStrategy, this.fieldBased);
            if (buildBeanInfo.fields.length != 0 || !Iterable.class.isAssignableFrom(cls)) {
                return createJavaBeanSerializer(buildBeanInfo);
            }
            return MiscCodec.instance;
        }
        throw new JSONException("not support class : " + name);
    }

    public final ObjectSerializer get(Type type) {
        Type mixInAnnotations = JSON.getMixInAnnotations(type);
        if (mixInAnnotations == null) {
            return this.serializers.get(type);
        }
        IdentityHashMap identityHashMap = this.mixInSerializers.get(type);
        if (identityHashMap == null) {
            return null;
        }
        return (ObjectSerializer) identityHashMap.get(mixInAnnotations);
    }

    public ObjectSerializer getObjectWriter(Class<?> cls) {
        return getObjectWriter(cls, true);
    }

    public String getTypeKey() {
        return this.typeKey;
    }

    public boolean isAsmEnable() {
        return this.asm;
    }

    public boolean put(Object obj, Object obj2) {
        return put((Type) obj, (ObjectSerializer) obj2);
    }

    public void register(Module module) {
        this.modules.add(module);
    }

    public void setAsmEnable(boolean z) {
        if (!ASMUtils.IS_ANDROID) {
            this.asm = z;
        }
    }

    public void setPropertyNamingStrategy(PropertyNamingStrategy propertyNamingStrategy2) {
        this.propertyNamingStrategy = propertyNamingStrategy2;
    }

    public void setTypeKey(String str) {
        this.typeKey = str;
    }

    public SerializeConfig(boolean z) {
        this(8192, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:278:0x0471  */
    /* JADX WARNING: Removed duplicated region for block: B:309:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.fastjson.serializer.ObjectSerializer getObjectWriter(java.lang.Class<?> r26, boolean r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            java.lang.String r2 = "java.util.concurrent.atomic.DoubleAdder"
            java.lang.String r3 = "java.util.concurrent.atomic.LongAdder"
            r4 = 1
            com.alibaba.fastjson.serializer.ObjectSerializer r5 = r25.get(r26)
            java.lang.Class<com.alibaba.fastjson.serializer.AutowiredObjectSerializer> r6 = com.alibaba.fastjson.serializer.AutowiredObjectSerializer.class
            if (r5 != 0) goto L_0x004e
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ ClassCastException -> 0x004a }
            java.lang.ClassLoader r5 = r5.getContextClassLoader()     // Catch:{ ClassCastException -> 0x004a }
            java.util.Set r5 = com.alibaba.fastjson.util.ServiceLoader.load(r6, (java.lang.ClassLoader) r5)     // Catch:{ ClassCastException -> 0x004a }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ ClassCastException -> 0x004a }
        L_0x0021:
            boolean r7 = r5.hasNext()     // Catch:{ ClassCastException -> 0x004a }
            if (r7 == 0) goto L_0x004a
            java.lang.Object r7 = r5.next()     // Catch:{ ClassCastException -> 0x004a }
            boolean r8 = r7 instanceof com.alibaba.fastjson.serializer.AutowiredObjectSerializer     // Catch:{ ClassCastException -> 0x004a }
            if (r8 != 0) goto L_0x0030
            goto L_0x0021
        L_0x0030:
            com.alibaba.fastjson.serializer.AutowiredObjectSerializer r7 = (com.alibaba.fastjson.serializer.AutowiredObjectSerializer) r7     // Catch:{ ClassCastException -> 0x004a }
            java.util.Set r8 = r7.getAutowiredFor()     // Catch:{ ClassCastException -> 0x004a }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ ClassCastException -> 0x004a }
        L_0x003a:
            boolean r9 = r8.hasNext()     // Catch:{ ClassCastException -> 0x004a }
            if (r9 == 0) goto L_0x0021
            java.lang.Object r9 = r8.next()     // Catch:{ ClassCastException -> 0x004a }
            java.lang.reflect.Type r9 = (java.lang.reflect.Type) r9     // Catch:{ ClassCastException -> 0x004a }
            r0.put((java.lang.reflect.Type) r9, (com.alibaba.fastjson.serializer.ObjectSerializer) r7)     // Catch:{ ClassCastException -> 0x004a }
            goto L_0x003a
        L_0x004a:
            com.alibaba.fastjson.serializer.ObjectSerializer r5 = r25.get(r26)
        L_0x004e:
            if (r5 != 0) goto L_0x0095
            java.lang.Class<com.alibaba.fastjson.JSON> r7 = com.alibaba.fastjson.JSON.class
            java.lang.ClassLoader r7 = r7.getClassLoader()
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r8 = r8.getContextClassLoader()
            if (r7 == r8) goto L_0x0095
            java.util.Set r5 = com.alibaba.fastjson.util.ServiceLoader.load(r6, (java.lang.ClassLoader) r7)     // Catch:{ ClassCastException -> 0x0091 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ ClassCastException -> 0x0091 }
        L_0x0068:
            boolean r6 = r5.hasNext()     // Catch:{ ClassCastException -> 0x0091 }
            if (r6 == 0) goto L_0x0091
            java.lang.Object r6 = r5.next()     // Catch:{ ClassCastException -> 0x0091 }
            boolean r7 = r6 instanceof com.alibaba.fastjson.serializer.AutowiredObjectSerializer     // Catch:{ ClassCastException -> 0x0091 }
            if (r7 != 0) goto L_0x0077
            goto L_0x0068
        L_0x0077:
            com.alibaba.fastjson.serializer.AutowiredObjectSerializer r6 = (com.alibaba.fastjson.serializer.AutowiredObjectSerializer) r6     // Catch:{ ClassCastException -> 0x0091 }
            java.util.Set r7 = r6.getAutowiredFor()     // Catch:{ ClassCastException -> 0x0091 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ ClassCastException -> 0x0091 }
        L_0x0081:
            boolean r8 = r7.hasNext()     // Catch:{ ClassCastException -> 0x0091 }
            if (r8 == 0) goto L_0x0068
            java.lang.Object r8 = r7.next()     // Catch:{ ClassCastException -> 0x0091 }
            java.lang.reflect.Type r8 = (java.lang.reflect.Type) r8     // Catch:{ ClassCastException -> 0x0091 }
            r0.put((java.lang.reflect.Type) r8, (com.alibaba.fastjson.serializer.ObjectSerializer) r6)     // Catch:{ ClassCastException -> 0x0091 }
            goto L_0x0081
        L_0x0091:
            com.alibaba.fastjson.serializer.ObjectSerializer r5 = r25.get(r26)
        L_0x0095:
            java.util.List<com.alibaba.fastjson.spi.Module> r6 = r0.modules
            java.util.Iterator r6 = r6.iterator()
        L_0x009b:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00b1
            java.lang.Object r5 = r6.next()
            com.alibaba.fastjson.spi.Module r5 = (com.alibaba.fastjson.spi.Module) r5
            com.alibaba.fastjson.serializer.ObjectSerializer r5 = r5.createSerializer(r0, r1)
            if (r5 == 0) goto L_0x009b
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r5)
            return r5
        L_0x00b1:
            if (r5 != 0) goto L_0x0475
            java.lang.String r6 = r26.getName()
            java.lang.Class<java.util.Map> r7 = java.util.Map.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x00c7
            com.alibaba.fastjson.serializer.MapSerializer r2 = com.alibaba.fastjson.serializer.MapSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
        L_0x00c4:
            r5 = r2
            goto L_0x046f
        L_0x00c7:
            java.lang.Class<java.util.List> r7 = java.util.List.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x00d5
            com.alibaba.fastjson.serializer.ListSerializer r2 = com.alibaba.fastjson.serializer.ListSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x00d5:
            java.lang.Class<java.util.Collection> r7 = java.util.Collection.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x00e3
            com.alibaba.fastjson.serializer.CollectionCodec r2 = com.alibaba.fastjson.serializer.CollectionCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x00e3:
            java.lang.Class<java.util.Date> r7 = java.util.Date.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x00f1
            com.alibaba.fastjson.serializer.DateCodec r2 = com.alibaba.fastjson.serializer.DateCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x00f1:
            java.lang.Class<com.alibaba.fastjson.JSONAware> r7 = com.alibaba.fastjson.JSONAware.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x00ff
            com.alibaba.fastjson.serializer.JSONAwareSerializer r2 = com.alibaba.fastjson.serializer.JSONAwareSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x00ff:
            java.lang.Class<com.alibaba.fastjson.serializer.JSONSerializable> r7 = com.alibaba.fastjson.serializer.JSONSerializable.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x010d
            com.alibaba.fastjson.serializer.JSONSerializableSerializer r2 = com.alibaba.fastjson.serializer.JSONSerializableSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x010d:
            java.lang.Class<com.alibaba.fastjson.JSONStreamAware> r7 = com.alibaba.fastjson.JSONStreamAware.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x011b
            com.alibaba.fastjson.serializer.MiscCodec r2 = com.alibaba.fastjson.serializer.MiscCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x011b:
            boolean r7 = r26.isEnum()
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r8 = com.alibaba.fastjson.annotation.JSONType.class
            if (r7 == 0) goto L_0x013f
            java.lang.annotation.Annotation r2 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r1, r8)
            com.alibaba.fastjson.annotation.JSONType r2 = (com.alibaba.fastjson.annotation.JSONType) r2
            if (r2 == 0) goto L_0x0139
            boolean r2 = r2.serializeEnumAsJavaBean()
            if (r2 == 0) goto L_0x0139
            com.alibaba.fastjson.serializer.ObjectSerializer r2 = r25.createJavaBeanSerializer((java.lang.Class<?>) r26)
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x0139:
            com.alibaba.fastjson.serializer.EnumSerializer r2 = com.alibaba.fastjson.serializer.EnumSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x013f:
            java.lang.Class r7 = r26.getSuperclass()
            if (r7 == 0) goto L_0x0169
            boolean r9 = r7.isEnum()
            if (r9 == 0) goto L_0x0169
            java.lang.annotation.Annotation r2 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r7, r8)
            com.alibaba.fastjson.annotation.JSONType r2 = (com.alibaba.fastjson.annotation.JSONType) r2
            if (r2 == 0) goto L_0x0162
            boolean r2 = r2.serializeEnumAsJavaBean()
            if (r2 == 0) goto L_0x0162
            com.alibaba.fastjson.serializer.ObjectSerializer r2 = r25.createJavaBeanSerializer((java.lang.Class<?>) r26)
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x0162:
            com.alibaba.fastjson.serializer.EnumSerializer r2 = com.alibaba.fastjson.serializer.EnumSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x0169:
            boolean r7 = r26.isArray()
            if (r7 == 0) goto L_0x0182
            java.lang.Class r2 = r26.getComponentType()
            com.alibaba.fastjson.serializer.ObjectSerializer r3 = r0.getObjectWriter(r2)
            com.alibaba.fastjson.serializer.ArraySerializer r4 = new com.alibaba.fastjson.serializer.ArraySerializer
            r4.<init>(r2, r3)
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r4)
            r5 = r4
            goto L_0x046f
        L_0x0182:
            java.lang.Class<java.lang.Throwable> r7 = java.lang.Throwable.class
            boolean r7 = r7.isAssignableFrom(r1)
            r8 = 0
            if (r7 == 0) goto L_0x01a5
            com.alibaba.fastjson.PropertyNamingStrategy r2 = r0.propertyNamingStrategy
            com.alibaba.fastjson.serializer.SerializeBeanInfo r2 = com.alibaba.fastjson.util.TypeUtils.buildBeanInfo(r1, r8, r2)
            int r3 = r2.features
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName
            int r4 = r4.mask
            r3 = r3 | r4
            r2.features = r3
            com.alibaba.fastjson.serializer.JavaBeanSerializer r3 = new com.alibaba.fastjson.serializer.JavaBeanSerializer
            r3.<init>((com.alibaba.fastjson.serializer.SerializeBeanInfo) r2)
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r3)
            r5 = r3
            goto L_0x046f
        L_0x01a5:
            java.lang.Class<java.util.TimeZone> r7 = java.util.TimeZone.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 != 0) goto L_0x0468
            java.lang.Class<java.util.Map$Entry> r7 = java.util.Map.Entry.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x01b7
            goto L_0x0468
        L_0x01b7:
            java.lang.Class<java.lang.Appendable> r7 = java.lang.Appendable.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x01c6
            com.alibaba.fastjson.serializer.AppendableSerializer r2 = com.alibaba.fastjson.serializer.AppendableSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x01c6:
            java.lang.Class<java.nio.charset.Charset> r7 = java.nio.charset.Charset.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x01d5
            com.alibaba.fastjson.serializer.ToStringSerializer r2 = com.alibaba.fastjson.serializer.ToStringSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x01d5:
            java.lang.Class<java.util.Enumeration> r7 = java.util.Enumeration.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x01e4
            com.alibaba.fastjson.serializer.EnumerationSerializer r2 = com.alibaba.fastjson.serializer.EnumerationSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x01e4:
            java.lang.Class<java.util.Calendar> r7 = java.util.Calendar.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 != 0) goto L_0x0461
            java.lang.Class<javax.xml.datatype.XMLGregorianCalendar> r7 = javax.xml.datatype.XMLGregorianCalendar.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x01f6
            goto L_0x0461
        L_0x01f6:
            boolean r7 = com.alibaba.fastjson.util.TypeUtils.isClob(r26)
            if (r7 == 0) goto L_0x0203
            com.alibaba.fastjson.serializer.ClobSeriliazer r2 = com.alibaba.fastjson.serializer.ClobSeriliazer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x0203:
            boolean r7 = com.alibaba.fastjson.util.TypeUtils.isPath(r26)
            if (r7 == 0) goto L_0x0210
            com.alibaba.fastjson.serializer.ToStringSerializer r2 = com.alibaba.fastjson.serializer.ToStringSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x0210:
            java.lang.Class<java.util.Iterator> r7 = java.util.Iterator.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x021f
            com.alibaba.fastjson.serializer.MiscCodec r2 = com.alibaba.fastjson.serializer.MiscCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x021f:
            java.lang.Class<org.w3c.dom.Node> r7 = org.w3c.dom.Node.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x022e
            com.alibaba.fastjson.serializer.MiscCodec r2 = com.alibaba.fastjson.serializer.MiscCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x022e:
            java.lang.String r7 = "java.awt."
            boolean r7 = r6.startsWith(r7)
            r9 = 4
            r10 = 0
            if (r7 == 0) goto L_0x0267
            boolean r7 = com.alibaba.fastjson.serializer.AwtCodec.support(r26)
            if (r7 == 0) goto L_0x0267
            boolean r7 = awtError
            if (r7 != 0) goto L_0x0267
            java.lang.String r7 = "java.awt.Color"
            java.lang.String r11 = "java.awt.Font"
            java.lang.String r12 = "java.awt.Point"
            java.lang.String r13 = "java.awt.Rectangle"
            java.lang.String[] r7 = new java.lang.String[]{r7, r11, r12, r13}     // Catch:{ all -> 0x0265 }
            r11 = r10
        L_0x024f:
            if (r11 >= r9) goto L_0x0267
            r12 = r7[r11]     // Catch:{ all -> 0x0265 }
            boolean r13 = r12.equals(r6)     // Catch:{ all -> 0x0265 }
            if (r13 == 0) goto L_0x0263
            java.lang.Class r7 = java.lang.Class.forName(r12)     // Catch:{ all -> 0x0265 }
            com.alibaba.fastjson.serializer.AwtCodec r5 = com.alibaba.fastjson.serializer.AwtCodec.instance     // Catch:{ all -> 0x0265 }
            r0.put((java.lang.reflect.Type) r7, (com.alibaba.fastjson.serializer.ObjectSerializer) r5)     // Catch:{ all -> 0x0265 }
            return r5
        L_0x0263:
            int r11 = r11 + r4
            goto L_0x024f
        L_0x0265:
            awtError = r4
        L_0x0267:
            boolean r7 = jdk8Error
            r11 = 11
            r12 = 2
            if (r7 != 0) goto L_0x02f9
            java.lang.String r7 = "java.time."
            boolean r7 = r6.startsWith(r7)
            java.lang.String r13 = "java.util.Optional"
            if (r7 != 0) goto L_0x028a
            boolean r7 = r6.startsWith(r13)
            if (r7 != 0) goto L_0x028a
            boolean r7 = r6.equals(r3)
            if (r7 != 0) goto L_0x028a
            boolean r7 = r6.equals(r2)
            if (r7 == 0) goto L_0x02f9
        L_0x028a:
            java.lang.String r14 = "java.time.LocalDateTime"
            java.lang.String r15 = "java.time.LocalDate"
            java.lang.String r16 = "java.time.LocalTime"
            java.lang.String r17 = "java.time.ZonedDateTime"
            java.lang.String r18 = "java.time.OffsetDateTime"
            java.lang.String r19 = "java.time.OffsetTime"
            java.lang.String r20 = "java.time.ZoneOffset"
            java.lang.String r21 = "java.time.ZoneRegion"
            java.lang.String r22 = "java.time.Period"
            java.lang.String r23 = "java.time.Duration"
            java.lang.String r24 = "java.time.Instant"
            java.lang.String[] r7 = new java.lang.String[]{r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24}     // Catch:{ all -> 0x02f7 }
            r14 = r10
        L_0x02a5:
            if (r14 >= r11) goto L_0x02bb
            r15 = r7[r14]     // Catch:{ all -> 0x02f7 }
            boolean r16 = r15.equals(r6)     // Catch:{ all -> 0x02f7 }
            if (r16 == 0) goto L_0x02b9
            java.lang.Class r2 = java.lang.Class.forName(r15)     // Catch:{ all -> 0x02f7 }
            com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec r5 = com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec.instance     // Catch:{ all -> 0x02f7 }
            r0.put((java.lang.reflect.Type) r2, (com.alibaba.fastjson.serializer.ObjectSerializer) r5)     // Catch:{ all -> 0x02f7 }
            return r5
        L_0x02b9:
            int r14 = r14 + r4
            goto L_0x02a5
        L_0x02bb:
            java.lang.String r7 = "java.util.OptionalDouble"
            java.lang.String r14 = "java.util.OptionalInt"
            java.lang.String r15 = "java.util.OptionalLong"
            java.lang.String[] r7 = new java.lang.String[]{r13, r7, r14, r15}     // Catch:{ all -> 0x02f7 }
            r13 = r10
        L_0x02c6:
            if (r13 >= r9) goto L_0x02dc
            r14 = r7[r13]     // Catch:{ all -> 0x02f7 }
            boolean r15 = r14.equals(r6)     // Catch:{ all -> 0x02f7 }
            if (r15 == 0) goto L_0x02da
            java.lang.Class r2 = java.lang.Class.forName(r14)     // Catch:{ all -> 0x02f7 }
            com.alibaba.fastjson.parser.deserializer.OptionalCodec r5 = com.alibaba.fastjson.parser.deserializer.OptionalCodec.instance     // Catch:{ all -> 0x02f7 }
            r0.put((java.lang.reflect.Type) r2, (com.alibaba.fastjson.serializer.ObjectSerializer) r5)     // Catch:{ all -> 0x02f7 }
            return r5
        L_0x02da:
            int r13 = r13 + r4
            goto L_0x02c6
        L_0x02dc:
            java.lang.String[] r2 = new java.lang.String[]{r3, r2}     // Catch:{ all -> 0x02f7 }
            r3 = r10
        L_0x02e1:
            if (r3 >= r12) goto L_0x02f9
            r7 = r2[r3]     // Catch:{ all -> 0x02f7 }
            boolean r9 = r7.equals(r6)     // Catch:{ all -> 0x02f7 }
            if (r9 == 0) goto L_0x02f5
            java.lang.Class r2 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x02f7 }
            com.alibaba.fastjson.serializer.AdderSerializer r5 = com.alibaba.fastjson.serializer.AdderSerializer.instance     // Catch:{ all -> 0x02f7 }
            r0.put((java.lang.reflect.Type) r2, (com.alibaba.fastjson.serializer.ObjectSerializer) r5)     // Catch:{ all -> 0x02f7 }
            return r5
        L_0x02f5:
            int r3 = r3 + r4
            goto L_0x02e1
        L_0x02f7:
            jdk8Error = r4
        L_0x02f9:
            boolean r2 = oracleJdbcError
            if (r2 != 0) goto L_0x0326
            java.lang.String r2 = "oracle.sql."
            boolean r2 = r6.startsWith(r2)
            if (r2 == 0) goto L_0x0326
            java.lang.String r2 = "oracle.sql.DATE"
            java.lang.String r3 = "oracle.sql.TIMESTAMP"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x0324 }
            r3 = r10
        L_0x030e:
            if (r3 >= r12) goto L_0x0326
            r7 = r2[r3]     // Catch:{ all -> 0x0324 }
            boolean r9 = r7.equals(r6)     // Catch:{ all -> 0x0324 }
            if (r9 == 0) goto L_0x0322
            java.lang.Class r2 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x0324 }
            com.alibaba.fastjson.serializer.DateCodec r5 = com.alibaba.fastjson.serializer.DateCodec.instance     // Catch:{ all -> 0x0324 }
            r0.put((java.lang.reflect.Type) r2, (com.alibaba.fastjson.serializer.ObjectSerializer) r5)     // Catch:{ all -> 0x0324 }
            return r5
        L_0x0322:
            int r3 = r3 + r4
            goto L_0x030e
        L_0x0324:
            oracleJdbcError = r4
        L_0x0326:
            boolean r2 = springfoxError
            if (r2 != 0) goto L_0x033e
            java.lang.String r2 = "springfox.documentation.spring.web.json.Json"
            boolean r3 = r6.equals(r2)
            if (r3 == 0) goto L_0x033e
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x033c }
            com.alibaba.fastjson.support.springfox.SwaggerJsonSerializer r5 = com.alibaba.fastjson.support.springfox.SwaggerJsonSerializer.instance     // Catch:{ ClassNotFoundException -> 0x033c }
            r0.put((java.lang.reflect.Type) r2, (com.alibaba.fastjson.serializer.ObjectSerializer) r5)     // Catch:{ ClassNotFoundException -> 0x033c }
            return r5
        L_0x033c:
            springfoxError = r4
        L_0x033e:
            boolean r2 = guavaError
            if (r2 != 0) goto L_0x0372
            java.lang.String r2 = "com.google.common.collect."
            boolean r2 = r6.startsWith(r2)
            if (r2 == 0) goto L_0x0372
            java.lang.String r2 = "com.google.common.collect.HashMultimap"
            java.lang.String r3 = "com.google.common.collect.LinkedListMultimap"
            java.lang.String r7 = "com.google.common.collect.LinkedHashMultimap"
            java.lang.String r9 = "com.google.common.collect.ArrayListMultimap"
            java.lang.String r13 = "com.google.common.collect.TreeMultimap"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r7, r9, r13}     // Catch:{ ClassNotFoundException -> 0x0370 }
            r3 = r10
        L_0x0359:
            r7 = 5
            if (r3 >= r7) goto L_0x0372
            r7 = r2[r3]     // Catch:{ ClassNotFoundException -> 0x0370 }
            boolean r9 = r7.equals(r6)     // Catch:{ ClassNotFoundException -> 0x0370 }
            if (r9 == 0) goto L_0x036e
            java.lang.Class r2 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x0370 }
            com.alibaba.fastjson.serializer.GuavaCodec r5 = com.alibaba.fastjson.serializer.GuavaCodec.instance     // Catch:{ ClassNotFoundException -> 0x0370 }
            r0.put((java.lang.reflect.Type) r2, (com.alibaba.fastjson.serializer.ObjectSerializer) r5)     // Catch:{ ClassNotFoundException -> 0x0370 }
            return r5
        L_0x036e:
            int r3 = r3 + r4
            goto L_0x0359
        L_0x0370:
            guavaError = r4
        L_0x0372:
            boolean r2 = jsonnullError
            if (r2 != 0) goto L_0x038a
            java.lang.String r2 = "net.sf.json.JSONNull"
            boolean r3 = r6.equals(r2)
            if (r3 == 0) goto L_0x038a
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0388 }
            com.alibaba.fastjson.serializer.MiscCodec r5 = com.alibaba.fastjson.serializer.MiscCodec.instance     // Catch:{ ClassNotFoundException -> 0x0388 }
            r0.put((java.lang.reflect.Type) r2, (com.alibaba.fastjson.serializer.ObjectSerializer) r5)     // Catch:{ ClassNotFoundException -> 0x0388 }
            return r5
        L_0x0388:
            jsonnullError = r4
        L_0x038a:
            boolean r2 = jsonobjectError
            if (r2 != 0) goto L_0x03a2
            java.lang.String r2 = "org.json.JSONObject"
            boolean r3 = r6.equals(r2)
            if (r3 == 0) goto L_0x03a2
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x03a0 }
            com.alibaba.fastjson.serializer.JSONObjectCodec r5 = com.alibaba.fastjson.serializer.JSONObjectCodec.instance     // Catch:{ ClassNotFoundException -> 0x03a0 }
            r0.put((java.lang.reflect.Type) r2, (com.alibaba.fastjson.serializer.ObjectSerializer) r5)     // Catch:{ ClassNotFoundException -> 0x03a0 }
            return r5
        L_0x03a0:
            jsonobjectError = r4
        L_0x03a2:
            boolean r2 = jodaError
            if (r2 != 0) goto L_0x03e1
            java.lang.String r2 = "org.joda."
            boolean r2 = r6.startsWith(r2)
            if (r2 == 0) goto L_0x03e1
            java.lang.String r13 = "org.joda.time.LocalDate"
            java.lang.String r14 = "org.joda.time.LocalDateTime"
            java.lang.String r15 = "org.joda.time.LocalTime"
            java.lang.String r16 = "org.joda.time.Instant"
            java.lang.String r17 = "org.joda.time.DateTime"
            java.lang.String r18 = "org.joda.time.Period"
            java.lang.String r19 = "org.joda.time.Duration"
            java.lang.String r20 = "org.joda.time.DateTimeZone"
            java.lang.String r21 = "org.joda.time.UTCDateTimeZone"
            java.lang.String r22 = "org.joda.time.tz.CachedDateTimeZone"
            java.lang.String r23 = "org.joda.time.tz.FixedDateTimeZone"
            java.lang.String[] r2 = new java.lang.String[]{r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23}     // Catch:{ ClassNotFoundException -> 0x03df }
            r3 = r10
        L_0x03c9:
            if (r3 >= r11) goto L_0x03e1
            r7 = r2[r3]     // Catch:{ ClassNotFoundException -> 0x03df }
            boolean r9 = r7.equals(r6)     // Catch:{ ClassNotFoundException -> 0x03df }
            if (r9 == 0) goto L_0x03dd
            java.lang.Class r2 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x03df }
            com.alibaba.fastjson.serializer.JodaCodec r5 = com.alibaba.fastjson.serializer.JodaCodec.instance     // Catch:{ ClassNotFoundException -> 0x03df }
            r0.put((java.lang.reflect.Type) r2, (com.alibaba.fastjson.serializer.ObjectSerializer) r5)     // Catch:{ ClassNotFoundException -> 0x03df }
            return r5
        L_0x03dd:
            int r3 = r3 + r4
            goto L_0x03c9
        L_0x03df:
            jodaError = r4
        L_0x03e1:
            java.lang.String r2 = "java.nio.HeapByteBuffer"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x03ef
            com.alibaba.fastjson.serializer.ByteBufferCodec r2 = com.alibaba.fastjson.serializer.ByteBufferCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            return r2
        L_0x03ef:
            java.lang.String r2 = "org.javamoney.moneta.Money"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x03fd
            com.alibaba.fastjson.support.moneta.MonetaCodec r2 = com.alibaba.fastjson.support.moneta.MonetaCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            return r2
        L_0x03fd:
            java.lang.Class[] r2 = r26.getInterfaces()
            int r3 = r2.length
            if (r3 != r4) goto L_0x0414
            r3 = r2[r10]
            boolean r3 = r3.isAnnotation()
            if (r3 == 0) goto L_0x0414
            com.alibaba.fastjson.serializer.AnnotationSerializer r2 = com.alibaba.fastjson.serializer.AnnotationSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            com.alibaba.fastjson.serializer.AnnotationSerializer r0 = com.alibaba.fastjson.serializer.AnnotationSerializer.instance
            return r0
        L_0x0414:
            boolean r3 = com.alibaba.fastjson.util.TypeUtils.isProxy(r26)
            if (r3 == 0) goto L_0x0426
            java.lang.Class r2 = r26.getSuperclass()
            com.alibaba.fastjson.serializer.ObjectSerializer r2 = r0.getObjectWriter(r2)
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            return r2
        L_0x0426:
            boolean r3 = java.lang.reflect.Proxy.isProxyClass(r26)
            if (r3 == 0) goto L_0x0456
            int r3 = r2.length
            if (r3 != r12) goto L_0x0432
            r8 = r2[r4]
            goto L_0x044c
        L_0x0432:
            int r3 = r2.length
            r6 = r8
        L_0x0434:
            if (r10 >= r3) goto L_0x044b
            r7 = r2[r10]
            java.lang.String r9 = r7.getName()
            java.lang.String r11 = "org.springframework.aop."
            boolean r9 = r9.startsWith(r11)
            if (r9 == 0) goto L_0x0445
            goto L_0x0449
        L_0x0445:
            if (r6 == 0) goto L_0x0448
            goto L_0x044c
        L_0x0448:
            r6 = r7
        L_0x0449:
            int r10 = r10 + r4
            goto L_0x0434
        L_0x044b:
            r8 = r6
        L_0x044c:
            if (r8 == 0) goto L_0x0456
            com.alibaba.fastjson.serializer.ObjectSerializer r2 = r0.getObjectWriter(r8)
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            return r2
        L_0x0456:
            if (r27 == 0) goto L_0x046f
            com.alibaba.fastjson.serializer.ObjectSerializer r2 = r25.createJavaBeanSerializer((java.lang.Class<?>) r26)
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x0461:
            com.alibaba.fastjson.serializer.CalendarCodec r2 = com.alibaba.fastjson.serializer.CalendarCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x0468:
            com.alibaba.fastjson.serializer.MiscCodec r2 = com.alibaba.fastjson.serializer.MiscCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c4
        L_0x046f:
            if (r5 != 0) goto L_0x0475
            com.alibaba.fastjson.serializer.ObjectSerializer r5 = r25.get(r26)
        L_0x0475:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeConfig.getObjectWriter(java.lang.Class, boolean):com.alibaba.fastjson.serializer.ObjectSerializer");
    }

    public boolean put(Type type, ObjectSerializer objectSerializer) {
        Type mixInAnnotations = JSON.getMixInAnnotations(type);
        if (mixInAnnotations == null) {
            return this.serializers.put(type, objectSerializer);
        }
        IdentityHashMap identityHashMap = this.mixInSerializers.get(type);
        if (identityHashMap == null) {
            identityHashMap = new IdentityHashMap(4);
            this.mixInSerializers.put(type, identityHashMap);
        }
        return identityHashMap.put(mixInAnnotations, objectSerializer);
    }

    public SerializeConfig(int i) {
        this(i, false);
    }

    public SerializeConfig(int i, boolean z) {
        this.asm = !ASMUtils.IS_ANDROID;
        this.typeKey = JSON.DEFAULT_TYPE_KEY;
        this.denyClasses = new long[]{4165360493669296979L, 4446674157046724083L};
        this.modules = new ArrayList();
        this.fieldBased = z;
        this.serializers = new IdentityHashMap<>(i);
        this.mixInSerializers = new IdentityHashMap<>(16);
        try {
            if (this.asm) {
                this.asmFactory = new ASMSerializerFactory();
            }
        } catch (Throwable unused) {
            this.asm = false;
        }
        initSerializers();
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0149 A[SYNTHETIC, Splitter:B:108:0x0149] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.fastjson.serializer.ObjectSerializer createJavaBeanSerializer(com.alibaba.fastjson.serializer.SerializeBeanInfo r15) {
        /*
            r14 = this;
            com.alibaba.fastjson.annotation.JSONType r0 = r15.jsonType
            boolean r1 = r14.asm
            r2 = 0
            if (r1 == 0) goto L_0x000d
            boolean r1 = r14.fieldBased
            if (r1 != 0) goto L_0x000d
            r1 = 1
            goto L_0x000e
        L_0x000d:
            r1 = r2
        L_0x000e:
            java.lang.Class<java.lang.Void> r3 = java.lang.Void.class
            if (r0 == 0) goto L_0x0055
            java.lang.Class r4 = r0.serializer()
            if (r4 == r3) goto L_0x0023
            java.lang.Object r4 = r4.newInstance()     // Catch:{ all -> 0x0023 }
            boolean r5 = r4 instanceof com.alibaba.fastjson.serializer.ObjectSerializer     // Catch:{ all -> 0x0023 }
            if (r5 == 0) goto L_0x0023
            com.alibaba.fastjson.serializer.ObjectSerializer r4 = (com.alibaba.fastjson.serializer.ObjectSerializer) r4     // Catch:{ all -> 0x0023 }
            return r4
        L_0x0023:
            boolean r4 = r0.asm()
            if (r4 != 0) goto L_0x002a
            r1 = r2
        L_0x002a:
            if (r1 == 0) goto L_0x004b
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r0.serialzeFeatures()
            int r5 = r4.length
            r6 = r2
        L_0x0032:
            if (r6 >= r5) goto L_0x004b
            r7 = r4[r6]
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNonStringValueAsString
            if (r8 == r7) goto L_0x004a
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString
            if (r8 == r7) goto L_0x004a
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue
            if (r8 == r7) goto L_0x004a
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            if (r8 != r7) goto L_0x0047
            goto L_0x004a
        L_0x0047:
            int r6 = r6 + 1
            goto L_0x0032
        L_0x004a:
            r1 = r2
        L_0x004b:
            if (r1 == 0) goto L_0x0055
            java.lang.Class[] r0 = r0.serialzeFilters()
            int r0 = r0.length
            if (r0 == 0) goto L_0x0055
            r1 = r2
        L_0x0055:
            java.lang.Class<?> r0 = r15.beanType
            int r4 = r0.getModifiers()
            boolean r4 = java.lang.reflect.Modifier.isPublic(r4)
            if (r4 != 0) goto L_0x0067
            com.alibaba.fastjson.serializer.JavaBeanSerializer r14 = new com.alibaba.fastjson.serializer.JavaBeanSerializer
            r14.<init>((com.alibaba.fastjson.serializer.SerializeBeanInfo) r15)
            return r14
        L_0x0067:
            if (r1 == 0) goto L_0x0073
            com.alibaba.fastjson.serializer.ASMSerializerFactory r4 = r14.asmFactory
            com.alibaba.fastjson.util.ASMClassLoader r4 = r4.classLoader
            boolean r4 = r4.isExternalClass(r0)
            if (r4 != 0) goto L_0x007b
        L_0x0073:
            java.lang.Class<java.io.Serializable> r4 = java.io.Serializable.class
            if (r0 == r4) goto L_0x007b
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            if (r0 != r4) goto L_0x007c
        L_0x007b:
            r1 = r2
        L_0x007c:
            if (r1 == 0) goto L_0x0089
            java.lang.String r4 = r0.getSimpleName()
            boolean r4 = com.alibaba.fastjson.util.ASMUtils.checkName(r4)
            if (r4 != 0) goto L_0x0089
            r1 = r2
        L_0x0089:
            if (r1 == 0) goto L_0x0094
            java.lang.Class<?> r4 = r15.beanType
            boolean r4 = r4.isInterface()
            if (r4 == 0) goto L_0x0094
            r1 = r2
        L_0x0094:
            if (r1 == 0) goto L_0x0146
            com.alibaba.fastjson.util.FieldInfo[] r4 = r15.fields
            int r5 = r4.length
            r6 = r2
        L_0x009a:
            if (r6 >= r5) goto L_0x0146
            r7 = r4[r6]
            java.lang.reflect.Field r8 = r7.field
            if (r8 == 0) goto L_0x00b0
            java.lang.Class r8 = r8.getType()
            java.lang.Class<?> r9 = r7.fieldClass
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x00b0
            goto L_0x0147
        L_0x00b0:
            java.lang.reflect.Method r8 = r7.method
            if (r8 == 0) goto L_0x00c2
            java.lang.Class r9 = r8.getReturnType()
            java.lang.Class<?> r10 = r7.fieldClass
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x00c2
            goto L_0x0147
        L_0x00c2:
            com.alibaba.fastjson.annotation.JSONField r9 = r7.getAnnotation()
            if (r9 != 0) goto L_0x00ca
            goto L_0x0142
        L_0x00ca:
            java.lang.String r10 = r9.format()
            int r11 = r10.length()
            if (r11 == 0) goto L_0x00e2
            java.lang.Class<?> r7 = r7.fieldClass
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            if (r7 != r11) goto L_0x0147
            java.lang.String r7 = "trim"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x0147
        L_0x00e2:
            java.lang.String r7 = r9.name()
            boolean r7 = com.alibaba.fastjson.util.ASMUtils.checkName(r7)
            if (r7 == 0) goto L_0x0147
            boolean r7 = r9.jsonDirect()
            if (r7 != 0) goto L_0x0147
            java.lang.Class r7 = r9.serializeUsing()
            if (r7 != r3) goto L_0x0147
            boolean r7 = r9.unwrapped()
            if (r7 == 0) goto L_0x00ff
            goto L_0x0147
        L_0x00ff:
            com.alibaba.fastjson.serializer.SerializerFeature[] r7 = r9.serialzeFeatures()
            int r10 = r7.length
            r11 = r2
        L_0x0105:
            if (r11 >= r10) goto L_0x0122
            r12 = r7[r11]
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNonStringValueAsString
            if (r13 == r12) goto L_0x0121
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString
            if (r13 == r12) goto L_0x0121
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue
            if (r13 == r12) goto L_0x0121
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            if (r13 == r12) goto L_0x0121
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName
            if (r13 != r12) goto L_0x011e
            goto L_0x0121
        L_0x011e:
            int r11 = r11 + 1
            goto L_0x0105
        L_0x0121:
            r1 = r2
        L_0x0122:
            boolean r7 = com.alibaba.fastjson.util.TypeUtils.isAnnotationPresentOneToMany(r8)
            if (r7 != 0) goto L_0x0147
            boolean r7 = com.alibaba.fastjson.util.TypeUtils.isAnnotationPresentManyToMany(r8)
            if (r7 == 0) goto L_0x012f
            goto L_0x0147
        L_0x012f:
            java.lang.String r7 = r9.defaultValue()
            if (r7 == 0) goto L_0x0142
            java.lang.String r7 = ""
            java.lang.String r8 = r9.defaultValue()
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0142
            goto L_0x0147
        L_0x0142:
            int r6 = r6 + 1
            goto L_0x009a
        L_0x0146:
            r2 = r1
        L_0x0147:
            if (r2 == 0) goto L_0x0178
            com.alibaba.fastjson.serializer.JavaBeanSerializer r14 = r14.createASMSerializer(r15)     // Catch:{ ClassCastException | ClassFormatError | ClassNotFoundException -> 0x0178, OutOfMemoryError -> 0x0168, all -> 0x0150 }
            if (r14 == 0) goto L_0x0178
            return r14
        L_0x0150:
            r14 = move-exception
            com.alibaba.fastjson.JSONException r15 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "create asm serializer error, verson 1.2.67, class "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r15.<init>(r0, r14)
            throw r15
        L_0x0168:
            r14 = move-exception
            java.lang.String r0 = r14.getMessage()
            java.lang.String r1 = "Metaspace"
            int r0 = r0.indexOf(r1)
            r1 = -1
            if (r0 != r1) goto L_0x0177
            goto L_0x0178
        L_0x0177:
            throw r14
        L_0x0178:
            com.alibaba.fastjson.serializer.JavaBeanSerializer r14 = new com.alibaba.fastjson.serializer.JavaBeanSerializer
            r14.<init>((com.alibaba.fastjson.serializer.SerializeBeanInfo) r15)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeConfig.createJavaBeanSerializer(com.alibaba.fastjson.serializer.SerializeBeanInfo):com.alibaba.fastjson.serializer.ObjectSerializer");
    }
}

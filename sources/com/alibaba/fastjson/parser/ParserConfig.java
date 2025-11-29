package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory;
import com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JSONPDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.NumberDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimeDeserializer;
import com.alibaba.fastjson.serializer.AtomicCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BigIntegerCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharArrayCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.ReferenceCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.spi.Module;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.MzContactsContract;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.lang3.BooleanUtils;

public class ParserConfig {
    public static final String AUTOTYPE_ACCEPT = "fastjson.parser.autoTypeAccept";
    public static final String AUTOTYPE_SUPPORT_PROPERTY = "fastjson.parser.autoTypeSupport";
    public static final boolean AUTO_SUPPORT = BooleanUtils.TRUE.equals(IOUtils.getStringProperty(AUTOTYPE_SUPPORT_PROPERTY));
    private static final String[] AUTO_TYPE_ACCEPT_LIST;
    public static final String[] DENYS = splitItemsFormProperty(IOUtils.getStringProperty(DENY_PROPERTY));
    public static final String[] DENYS_INTERNAL = splitItemsFormProperty(IOUtils.getStringProperty(DENY_PROPERTY_INTERNAL));
    public static final String DENY_PROPERTY = "fastjson.parser.deny";
    public static final String DENY_PROPERTY_INTERNAL = "fastjson.parser.deny.internal";
    private static final long[] INTERNAL_WHITELIST_HASHCODES = {-9013707057526259810L, -8773806119481270567L, -8421588593326113468L, -8070393259084821111L, -7858127399773263546L, -7043543676283957292L, -6976602508726000783L, -6293031534589903644L, -6081111809668363619L, -5779433778261875721L, -5399450433995651784L, -4540135604787511831L, -4207865850564917696L, -3950343444501679205L, -3714900953609113456L, -3393714734093696063L, -3378497329992063044L, -2631228350337215662L, -2551988546877734201L, -2473987886800209058L, -2265617974881722705L, -1759511109484434299L, -1477946458560579955L, -816725787720647462L, -520183782617964618L, 59775428743665658L, 484499585846206473L, 532945107123976213L, 711449177569584898L, 829148494126372070L, 956883420092542580L, 1233162291719202522L, 1696465274354442213L, 1863557081881630420L, 2238472697200138595L, 2380202963256720577L, 2643099543618286743L, 2793877891138577121L, 3804572268889088203L, 4567982875926242015L, 4784070066737926537L, 4960004821520561233L, 5348524593377618456L, 5454920836284873808L, 5695987590363189151L, 6073645722991901167L, 6114875255374330593L, 6137737446243999215L, 6160752908990493848L, 6939315124833099497L, 7048426940343117278L, 7267793227937552092L, 8331868837379820532L, 8357451534615459155L, 8890227807433646566L, 9166532985682478006L, 9215131087512669423L};
    private static boolean awtError = false;
    public static ParserConfig global = new ParserConfig();
    private static boolean guavaError = false;
    private static boolean jdk8Error = false;
    private static boolean jodaError = false;
    private long[] acceptHashCodes;
    private boolean asmEnable;
    protected ASMDeserializerFactory asmFactory;
    private boolean autoTypeSupport;
    public boolean compatibleWithJavaBean;
    protected ClassLoader defaultClassLoader;
    private long[] denyHashCodes;
    private final IdentityHashMap<Type, ObjectDeserializer> deserializers;
    public final boolean fieldBased;
    private long[] internalDenyHashCodes;
    private boolean jacksonCompatible;
    private final IdentityHashMap<Type, IdentityHashMap<Type, ObjectDeserializer>> mixInDeserializers;
    private List<Module> modules;
    public PropertyNamingStrategy propertyNamingStrategy;
    public final SymbolTable symbolTable;
    private final ConcurrentMap<String, Class<?>> typeMapping;

    static {
        String[] splitItemsFormProperty = splitItemsFormProperty(IOUtils.getStringProperty(AUTOTYPE_ACCEPT));
        if (splitItemsFormProperty == null) {
            splitItemsFormProperty = new String[0];
        }
        AUTO_TYPE_ACCEPT_LIST = splitItemsFormProperty;
    }

    public ParserConfig() {
        this(false);
    }

    private void addItemsToAccept(String[] strArr) {
        if (strArr != null) {
            for (String addAccept : strArr) {
                addAccept(addAccept);
            }
        }
    }

    private void addItemsToDeny(String[] strArr) {
        if (strArr != null) {
            for (String addDeny : strArr) {
                addDeny(addDeny);
            }
        }
    }

    private void addItemsToDeny0(String[] strArr) {
        if (strArr != null) {
            for (String addDenyInternal : strArr) {
                addDenyInternal(addDenyInternal);
            }
        }
    }

    public static Field getFieldFromCache(String str, Map<String, Field> map) {
        Field field = map.get(str);
        if (field == null) {
            field = map.get(AccountConstantKt.DEFAULT_SEGMENT + str);
        }
        if (field == null) {
            field = map.get("m_" + str);
        }
        if (field != null) {
            return field;
        }
        char charAt = str.charAt(0);
        if (charAt >= 'a' && charAt <= 'z') {
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] - ' ');
            field = map.get(new String(charArray));
        }
        if (str.length() <= 2) {
            return field;
        }
        char charAt2 = str.charAt(1);
        if (str.length() <= 2 || charAt < 'a' || charAt > 'z' || charAt2 < 'A' || charAt2 > 'Z') {
            return field;
        }
        for (Map.Entry next : map.entrySet()) {
            if (str.equalsIgnoreCase((String) next.getKey())) {
                return (Field) next.getValue();
            }
        }
        return field;
    }

    public static ParserConfig getGlobalInstance() {
        return global;
    }

    private void initDeserializers() {
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap = this.deserializers;
        MiscCodec miscCodec = MiscCodec.instance;
        identityHashMap.put(SimpleDateFormat.class, miscCodec);
        this.deserializers.put(Timestamp.class, SqlDateDeserializer.instance_timestamp);
        this.deserializers.put(Date.class, SqlDateDeserializer.instance);
        this.deserializers.put(Time.class, TimeDeserializer.instance);
        this.deserializers.put(java.util.Date.class, DateCodec.instance);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap2 = this.deserializers;
        CalendarCodec calendarCodec = CalendarCodec.instance;
        identityHashMap2.put(Calendar.class, calendarCodec);
        this.deserializers.put(XMLGregorianCalendar.class, calendarCodec);
        this.deserializers.put(JSONObject.class, MapDeserializer.instance);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap3 = this.deserializers;
        CollectionCodec collectionCodec = CollectionCodec.instance;
        identityHashMap3.put(JSONArray.class, collectionCodec);
        this.deserializers.put(Map.class, MapDeserializer.instance);
        this.deserializers.put(HashMap.class, MapDeserializer.instance);
        this.deserializers.put(LinkedHashMap.class, MapDeserializer.instance);
        this.deserializers.put(TreeMap.class, MapDeserializer.instance);
        this.deserializers.put(ConcurrentMap.class, MapDeserializer.instance);
        this.deserializers.put(ConcurrentHashMap.class, MapDeserializer.instance);
        this.deserializers.put(Collection.class, collectionCodec);
        this.deserializers.put(List.class, collectionCodec);
        this.deserializers.put(ArrayList.class, collectionCodec);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap4 = this.deserializers;
        JavaObjectDeserializer javaObjectDeserializer = JavaObjectDeserializer.instance;
        identityHashMap4.put(Object.class, javaObjectDeserializer);
        this.deserializers.put(String.class, StringCodec.instance);
        this.deserializers.put(StringBuffer.class, StringCodec.instance);
        this.deserializers.put(StringBuilder.class, StringCodec.instance);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap5 = this.deserializers;
        Class cls = Character.TYPE;
        CharacterCodec characterCodec = CharacterCodec.instance;
        identityHashMap5.put(cls, characterCodec);
        this.deserializers.put(Character.class, characterCodec);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap6 = this.deserializers;
        Class cls2 = Byte.TYPE;
        NumberDeserializer numberDeserializer = NumberDeserializer.instance;
        identityHashMap6.put(cls2, numberDeserializer);
        this.deserializers.put(Byte.class, numberDeserializer);
        this.deserializers.put(Short.TYPE, numberDeserializer);
        this.deserializers.put(Short.class, numberDeserializer);
        this.deserializers.put(Integer.TYPE, IntegerCodec.instance);
        this.deserializers.put(Integer.class, IntegerCodec.instance);
        this.deserializers.put(Long.TYPE, LongCodec.instance);
        this.deserializers.put(Long.class, LongCodec.instance);
        this.deserializers.put(BigInteger.class, BigIntegerCodec.instance);
        this.deserializers.put(BigDecimal.class, BigDecimalCodec.instance);
        this.deserializers.put(Float.TYPE, FloatCodec.instance);
        this.deserializers.put(Float.class, FloatCodec.instance);
        this.deserializers.put(Double.TYPE, numberDeserializer);
        this.deserializers.put(Double.class, numberDeserializer);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap7 = this.deserializers;
        Class cls3 = Boolean.TYPE;
        BooleanCodec booleanCodec = BooleanCodec.instance;
        identityHashMap7.put(cls3, booleanCodec);
        this.deserializers.put(Boolean.class, booleanCodec);
        this.deserializers.put(Class.class, miscCodec);
        this.deserializers.put(char[].class, new CharArrayCodec());
        this.deserializers.put(AtomicBoolean.class, booleanCodec);
        this.deserializers.put(AtomicInteger.class, IntegerCodec.instance);
        this.deserializers.put(AtomicLong.class, LongCodec.instance);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap8 = this.deserializers;
        ReferenceCodec referenceCodec = ReferenceCodec.instance;
        identityHashMap8.put(AtomicReference.class, referenceCodec);
        this.deserializers.put(WeakReference.class, referenceCodec);
        this.deserializers.put(SoftReference.class, referenceCodec);
        this.deserializers.put(UUID.class, miscCodec);
        this.deserializers.put(TimeZone.class, miscCodec);
        this.deserializers.put(Locale.class, miscCodec);
        this.deserializers.put(Currency.class, miscCodec);
        this.deserializers.put(Inet4Address.class, miscCodec);
        this.deserializers.put(Inet6Address.class, miscCodec);
        this.deserializers.put(InetSocketAddress.class, miscCodec);
        this.deserializers.put(File.class, miscCodec);
        this.deserializers.put(URI.class, miscCodec);
        this.deserializers.put(URL.class, miscCodec);
        this.deserializers.put(Pattern.class, miscCodec);
        this.deserializers.put(Charset.class, miscCodec);
        this.deserializers.put(JSONPath.class, miscCodec);
        this.deserializers.put(Number.class, numberDeserializer);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap9 = this.deserializers;
        AtomicCodec atomicCodec = AtomicCodec.instance;
        identityHashMap9.put(AtomicIntegerArray.class, atomicCodec);
        this.deserializers.put(AtomicLongArray.class, atomicCodec);
        this.deserializers.put(StackTraceElement.class, StackTraceElementDeserializer.instance);
        this.deserializers.put(Serializable.class, javaObjectDeserializer);
        this.deserializers.put(Cloneable.class, javaObjectDeserializer);
        this.deserializers.put(Comparable.class, javaObjectDeserializer);
        this.deserializers.put(Closeable.class, javaObjectDeserializer);
        this.deserializers.put(JSONPObject.class, new JSONPDeserializer());
    }

    public static boolean isPrimitive2(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == java.util.Date.class || cls == Date.class || cls == Time.class || cls == Timestamp.class || cls.isEnum();
    }

    public static void parserAllFieldToCache(Class<?> cls, Map<String, Field> map) {
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            if (!map.containsKey(name)) {
                map.put(name, field);
            }
        }
        if (cls.getSuperclass() != null && cls.getSuperclass() != Object.class) {
            parserAllFieldToCache(cls.getSuperclass(), map);
        }
    }

    private static String[] splitItemsFormProperty(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
    }

    public void addAccept(String str) {
        if (str != null && str.length() != 0) {
            long fnv1a_64 = TypeUtils.fnv1a_64(str);
            if (Arrays.binarySearch(this.acceptHashCodes, fnv1a_64) < 0) {
                long[] jArr = this.acceptHashCodes;
                int length = jArr.length;
                long[] jArr2 = new long[(length + 1)];
                jArr2[length] = fnv1a_64;
                System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
                Arrays.sort(jArr2);
                this.acceptHashCodes = jArr2;
            }
        }
    }

    public void addDeny(String str) {
        if (str != null && str.length() != 0) {
            long fnv1a_64 = TypeUtils.fnv1a_64(str);
            if (Arrays.binarySearch(this.denyHashCodes, fnv1a_64) < 0) {
                long[] jArr = this.denyHashCodes;
                int length = jArr.length;
                long[] jArr2 = new long[(length + 1)];
                jArr2[length] = fnv1a_64;
                System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
                Arrays.sort(jArr2);
                this.denyHashCodes = jArr2;
            }
        }
    }

    public void addDenyInternal(String str) {
        if (str != null && str.length() != 0) {
            long fnv1a_64 = TypeUtils.fnv1a_64(str);
            long[] jArr = this.internalDenyHashCodes;
            if (jArr == null) {
                this.internalDenyHashCodes = new long[]{fnv1a_64};
            } else if (Arrays.binarySearch(jArr, fnv1a_64) < 0) {
                long[] jArr2 = this.internalDenyHashCodes;
                int length = jArr2.length;
                long[] jArr3 = new long[(1 + length)];
                jArr3[length] = fnv1a_64;
                System.arraycopy(jArr2, 0, jArr3, 0, jArr2.length);
                Arrays.sort(jArr3);
                this.internalDenyHashCodes = jArr3;
            }
        }
    }

    public Class<?> checkAutoType(Class cls) {
        if (get(cls) != null) {
            return cls;
        }
        return checkAutoType(cls.getName(), (Class<?>) null, JSON.DEFAULT_PARSER_FEATURE);
    }

    public void clearDeserializers() {
        this.deserializers.clear();
        initDeserializers();
    }

    public void configFromPropety(Properties properties) {
        addItemsToDeny(splitItemsFormProperty(properties.getProperty(DENY_PROPERTY)));
        addItemsToAccept(splitItemsFormProperty(properties.getProperty(AUTOTYPE_ACCEPT)));
        String property = properties.getProperty(AUTOTYPE_SUPPORT_PROPERTY);
        if (BooleanUtils.TRUE.equals(property)) {
            this.autoTypeSupport = true;
        } else if (BooleanUtils.FALSE.equals(property)) {
            this.autoTypeSupport = false;
        }
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, FieldInfo fieldInfo) {
        Class<?> deserializeUsing;
        Class<?> cls = javaBeanInfo.clazz;
        Class<?> cls2 = fieldInfo.fieldClass;
        JSONField annotation = fieldInfo.getAnnotation();
        Class<?> cls3 = null;
        if (!(annotation == null || (deserializeUsing = annotation.deserializeUsing()) == Void.class)) {
            cls3 = deserializeUsing;
        }
        return (cls3 == null && (cls2 == List.class || cls2 == ArrayList.class)) ? new ArrayListTypeFieldDeserializer(parserConfig, cls, fieldInfo) : new DefaultFieldDeserializer(parserConfig, cls, fieldInfo);
    }

    public ObjectDeserializer createJavaBeanDeserializer(Class<?> cls, Type type) {
        JSONField annotation;
        Method method;
        ASMDeserializerFactory aSMDeserializerFactory;
        boolean z = this.asmEnable & (!this.fieldBased);
        Class<Void> cls2 = Void.class;
        boolean z2 = false;
        if (z) {
            JSONType jSONType = (JSONType) TypeUtils.getAnnotation(cls, JSONType.class);
            if (jSONType != null) {
                Class<?> deserializer = jSONType.deserializer();
                if (deserializer != cls2) {
                    try {
                        Object newInstance = deserializer.newInstance();
                        if (newInstance instanceof ObjectDeserializer) {
                            return (ObjectDeserializer) newInstance;
                        }
                    } catch (Throwable unused) {
                    }
                }
                z = jSONType.asm();
            }
            if (z) {
                Class<?> builderClass = JavaBeanInfo.getBuilderClass(cls, jSONType);
                if (builderClass == null) {
                    builderClass = cls;
                }
                while (true) {
                    if (Modifier.isPublic(builderClass.getModifiers())) {
                        builderClass = builderClass.getSuperclass();
                        if (builderClass != Object.class) {
                            if (builderClass == null) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            }
        }
        if (cls.getTypeParameters().length != 0) {
            z = false;
        }
        if (z && (aSMDeserializerFactory = this.asmFactory) != null && aSMDeserializerFactory.classLoader.isExternalClass(cls)) {
            z = false;
        }
        if (z) {
            z = ASMUtils.checkName(cls.getSimpleName());
        }
        if (z) {
            if (cls.isInterface()) {
                z = false;
            }
            JavaBeanInfo build = JavaBeanInfo.build(cls, type, this.propertyNamingStrategy, false, TypeUtils.compatibleWithJavaBean, this.jacksonCompatible);
            if (z && build.fields.length > 200) {
                z = false;
            }
            Constructor<?> constructor = build.defaultConstructor;
            if (z && constructor == null && !cls.isInterface()) {
                z = false;
            }
            FieldInfo[] fieldInfoArr = build.fields;
            int length = fieldInfoArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                FieldInfo fieldInfo = fieldInfoArr[i];
                if (!fieldInfo.getOnly) {
                    Class<?> cls3 = fieldInfo.fieldClass;
                    if (!Modifier.isPublic(cls3.getModifiers()) || ((cls3.isMemberClass() && !Modifier.isStatic(cls3.getModifiers())) || ((fieldInfo.getMember() != null && !ASMUtils.checkName(fieldInfo.getMember().getName())) || (((annotation = fieldInfo.getAnnotation()) != null && (!ASMUtils.checkName(annotation.name()) || annotation.format().length() != 0 || annotation.deserializeUsing() != cls2 || annotation.parseFeatures().length != 0 || annotation.unwrapped())) || (((method = fieldInfo.method) != null && method.getParameterTypes().length > 1) || (cls3.isEnum() && !(getDeserializer((Type) cls3) instanceof EnumDeserializer))))))) {
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            z = false;
        }
        if (z && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
            z = false;
        }
        if (!z || !TypeUtils.isXmlField(cls)) {
            z2 = z;
        }
        if (!z2) {
            return new JavaBeanDeserializer(this, cls, type);
        }
        JavaBeanInfo build2 = JavaBeanInfo.build(cls, type, this.propertyNamingStrategy);
        try {
            return this.asmFactory.createJavaBeanDeserializer(this, build2);
        } catch (NoSuchMethodException unused2) {
            return new JavaBeanDeserializer(this, cls, type);
        } catch (JSONException unused3) {
            return new JavaBeanDeserializer(this, build2);
        } catch (Exception e) {
            throw new JSONException("create asm deserializer error, " + cls.getName(), e);
        }
    }

    public ObjectDeserializer get(Type type) {
        Type mixInAnnotations = JSON.getMixInAnnotations(type);
        if (mixInAnnotations == null) {
            return this.deserializers.get(type);
        }
        IdentityHashMap identityHashMap = this.mixInDeserializers.get(type);
        if (identityHashMap == null) {
            return null;
        }
        return (ObjectDeserializer) identityHashMap.get(mixInAnnotations);
    }

    public ClassLoader getDefaultClassLoader() {
        return this.defaultClassLoader;
    }

    public IdentityHashMap<Type, ObjectDeserializer> getDerializers() {
        return this.deserializers;
    }

    public ObjectDeserializer getDeserializer(Type type) {
        ObjectDeserializer objectDeserializer = get(type);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        if (type instanceof Class) {
            return getDeserializer((Class) type, type);
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return getDeserializer((Class) rawType, type);
            }
            return getDeserializer(rawType);
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return getDeserializer(upperBounds[0]);
            }
        }
        return JavaObjectDeserializer.instance;
    }

    public IdentityHashMap<Type, ObjectDeserializer> getDeserializers() {
        return this.deserializers;
    }

    public void initJavaBeanDeserializers(Class<?>... clsArr) {
        if (clsArr != null) {
            for (Class<?> cls : clsArr) {
                if (cls != null) {
                    putDeserializer(cls, createJavaBeanDeserializer(cls, cls));
                }
            }
        }
    }

    public boolean isAsmEnable() {
        return this.asmEnable;
    }

    public boolean isAutoTypeSupport() {
        return this.autoTypeSupport;
    }

    public boolean isJacksonCompatible() {
        return this.jacksonCompatible;
    }

    public boolean isPrimitive(Class<?> cls) {
        return isPrimitive2(cls);
    }

    public void putDeserializer(Type type, ObjectDeserializer objectDeserializer) {
        Type mixInAnnotations = JSON.getMixInAnnotations(type);
        if (mixInAnnotations != null) {
            IdentityHashMap identityHashMap = this.mixInDeserializers.get(type);
            if (identityHashMap == null) {
                identityHashMap = new IdentityHashMap(4);
                this.mixInDeserializers.put(type, identityHashMap);
            }
            identityHashMap.put(mixInAnnotations, objectDeserializer);
            return;
        }
        this.deserializers.put(type, objectDeserializer);
    }

    public void register(String str, Class cls) {
        this.typeMapping.putIfAbsent(str, cls);
    }

    public void setAsmEnable(boolean z) {
        this.asmEnable = z;
    }

    public void setAutoTypeSupport(boolean z) {
        this.autoTypeSupport = z;
    }

    public void setDefaultClassLoader(ClassLoader classLoader) {
        this.defaultClassLoader = classLoader;
    }

    public void setJacksonCompatible(boolean z) {
        this.jacksonCompatible = z;
    }

    public ParserConfig(boolean z) {
        this((ASMDeserializerFactory) null, (ClassLoader) null, z);
    }

    public void register(Module module) {
        this.modules.add(module);
    }

    public ParserConfig(ClassLoader classLoader) {
        this((ASMDeserializerFactory) null, classLoader, false);
    }

    public Class<?> checkAutoType(String str, Class<?> cls) {
        return checkAutoType(str, cls, JSON.DEFAULT_PARSER_FEATURE);
    }

    public ParserConfig(ASMDeserializerFactory aSMDeserializerFactory) {
        this(aSMDeserializerFactory, (ClassLoader) null, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:117:0x024b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x024c, code lost:
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0251, code lost:
        r13 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x024b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:112:0x0234] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0311  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<?> checkAutoType(java.lang.String r24, java.lang.Class<?> r25, int r26) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = 0
            if (r1 != 0) goto L_0x000a
            return r3
        L_0x000a:
            int r4 = r24.length()
            r5 = 192(0xc0, float:2.69E-43)
            java.lang.String r6 = "autoType is not support. "
            if (r4 >= r5) goto L_0x0353
            int r4 = r24.length()
            r5 = 3
            if (r4 < r5) goto L_0x0353
            r4 = 0
            r7 = 1
            if (r2 != 0) goto L_0x0021
        L_0x001f:
            r8 = r4
            goto L_0x003f
        L_0x0021:
            java.lang.Class<java.lang.Object> r8 = java.lang.Object.class
            if (r2 == r8) goto L_0x001f
            java.lang.Class<java.io.Serializable> r8 = java.io.Serializable.class
            if (r2 == r8) goto L_0x001f
            java.lang.Class<java.lang.Cloneable> r8 = java.lang.Cloneable.class
            if (r2 == r8) goto L_0x001f
            java.lang.Class<java.io.Closeable> r8 = java.io.Closeable.class
            if (r2 == r8) goto L_0x001f
            java.lang.Class<java.util.EventListener> r8 = java.util.EventListener.class
            if (r2 == r8) goto L_0x001f
            java.lang.Class<java.lang.Iterable> r8 = java.lang.Iterable.class
            if (r2 == r8) goto L_0x001f
            java.lang.Class<java.util.Collection> r8 = java.util.Collection.class
            if (r2 != r8) goto L_0x003e
            goto L_0x001f
        L_0x003e:
            r8 = r7
        L_0x003f:
            r9 = 36
            r10 = 46
            java.lang.String r9 = r1.replace(r9, r10)
            char r11 = r9.charAt(r4)
            long r11 = (long) r11
            r13 = -3750763034362895579(0xcbf29ce484222325, double:-7.302176725335867E57)
            long r11 = r11 ^ r13
            r15 = 1099511628211(0x100000001b3, double:5.43230922702E-312)
            long r11 = r11 * r15
            r17 = -5808493101479473382(0xaf64164c86024f1a, double:-2.1176223865607047E-80)
            int r17 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r17 == 0) goto L_0x033d
            int r17 = r9.length()
            int r3 = r17 + -1
            char r3 = r9.charAt(r3)
            r17 = r6
            long r5 = (long) r3
            long r5 = r5 ^ r11
            long r5 = r5 * r15
            r11 = 655701488918567152(0x9198507b5af98f0, double:7.914409534561175E-265)
            int r3 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r3 == 0) goto L_0x0326
            char r3 = r9.charAt(r4)
            long r5 = (long) r3
            long r5 = r5 ^ r13
            long r5 = r5 * r15
            char r3 = r9.charAt(r7)
            long r11 = (long) r3
            long r5 = r5 ^ r11
            long r5 = r5 * r15
            r3 = 2
            char r3 = r9.charAt(r3)
            long r11 = (long) r3
            long r5 = r5 ^ r11
            long r5 = r5 * r15
            long r11 = com.alibaba.fastjson.util.TypeUtils.fnv1a_64(r9)
            long[] r3 = INTERNAL_WHITELIST_HASHCODES
            int r3 = java.util.Arrays.binarySearch(r3, r11)
            if (r3 < 0) goto L_0x009d
            r3 = r7
            goto L_0x009e
        L_0x009d:
            r3 = r4
        L_0x009e:
            long[] r13 = r0.internalDenyHashCodes
            if (r13 == 0) goto L_0x00dc
            r19 = r5
            r13 = 3
        L_0x00a5:
            int r14 = r9.length()
            if (r13 >= r14) goto L_0x00dc
            char r14 = r9.charAt(r13)
            r21 = r5
            long r4 = (long) r14
            long r4 = r19 ^ r4
            long r4 = r4 * r15
            long[] r6 = r0.internalDenyHashCodes
            int r6 = java.util.Arrays.binarySearch(r6, r4)
            if (r6 >= 0) goto L_0x00c5
            int r13 = r13 + 1
            r19 = r4
            r5 = r21
            r4 = 0
            goto L_0x00a5
        L_0x00c5:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r4 = r17
            r2.append(r4)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x00dc:
            r21 = r5
            r4 = r17
            if (r3 != 0) goto L_0x0142
            boolean r5 = r0.autoTypeSupport
            if (r5 != 0) goto L_0x00e8
            if (r8 == 0) goto L_0x0142
        L_0x00e8:
            r13 = r21
            r5 = 3
        L_0x00eb:
            int r6 = r9.length()
            if (r5 >= r6) goto L_0x0142
            char r6 = r9.charAt(r5)
            r19 = r11
            long r10 = (long) r6
            long r10 = r10 ^ r13
            long r13 = r10 * r15
            long[] r6 = r0.acceptHashCodes
            int r6 = java.util.Arrays.binarySearch(r6, r13)
            if (r6 < 0) goto L_0x010c
            java.lang.ClassLoader r6 = r0.defaultClassLoader
            java.lang.Class r6 = com.alibaba.fastjson.util.TypeUtils.loadClass(r1, r6, r7)
            if (r6 == 0) goto L_0x010c
            return r6
        L_0x010c:
            long[] r6 = r0.denyHashCodes
            int r6 = java.util.Arrays.binarySearch(r6, r13)
            if (r6 < 0) goto L_0x013a
            java.lang.Class r6 = com.alibaba.fastjson.util.TypeUtils.getClassFromMapping(r24)
            if (r6 != 0) goto L_0x013a
            long[] r6 = r0.acceptHashCodes
            r10 = r19
            int r6 = java.util.Arrays.binarySearch(r6, r10)
            if (r6 < 0) goto L_0x0125
            goto L_0x013c
        L_0x0125:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x013a:
            r10 = r19
        L_0x013c:
            int r5 = r5 + 1
            r11 = r10
            r10 = 46
            goto L_0x00eb
        L_0x0142:
            java.lang.Class r5 = com.alibaba.fastjson.util.TypeUtils.getClassFromMapping(r24)
            if (r5 != 0) goto L_0x014e
            com.alibaba.fastjson.util.IdentityHashMap<java.lang.reflect.Type, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer> r5 = r0.deserializers
            java.lang.Class r5 = r5.findClass(r1)
        L_0x014e:
            if (r5 != 0) goto L_0x0158
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r5 = r0.typeMapping
            java.lang.Object r5 = r5.get(r1)
            java.lang.Class r5 = (java.lang.Class) r5
        L_0x0158:
            if (r3 == 0) goto L_0x0160
            java.lang.ClassLoader r3 = r0.defaultClassLoader
            java.lang.Class r5 = com.alibaba.fastjson.util.TypeUtils.loadClass(r1, r3, r7)
        L_0x0160:
            java.lang.String r3 = " -> "
            java.lang.String r6 = "type not match. "
            if (r5 == 0) goto L_0x0193
            if (r2 == 0) goto L_0x0192
            java.lang.Class<java.util.HashMap> r0 = java.util.HashMap.class
            if (r5 == r0) goto L_0x0192
            boolean r0 = r2.isAssignableFrom(r5)
            if (r0 == 0) goto L_0x0173
            goto L_0x0192
        L_0x0173:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = r25.getName()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r0.<init>(r1)
            throw r0
        L_0x0192:
            return r5
        L_0x0193:
            boolean r10 = r0.autoTypeSupport
            if (r10 != 0) goto L_0x01ff
            r10 = 3
        L_0x0198:
            int r11 = r9.length()
            if (r10 >= r11) goto L_0x01ff
            char r11 = r9.charAt(r10)
            long r11 = (long) r11
            long r11 = r21 ^ r11
            long r11 = r11 * r15
            long[] r13 = r0.denyHashCodes
            int r13 = java.util.Arrays.binarySearch(r13, r11)
            if (r13 >= 0) goto L_0x01ea
            long[] r13 = r0.acceptHashCodes
            int r13 = java.util.Arrays.binarySearch(r13, r11)
            if (r13 < 0) goto L_0x01e5
            java.lang.ClassLoader r0 = r0.defaultClassLoader
            java.lang.Class r0 = com.alibaba.fastjson.util.TypeUtils.loadClass(r1, r0, r7)
            if (r2 == 0) goto L_0x01e4
            boolean r4 = r2.isAssignableFrom(r0)
            if (r4 != 0) goto L_0x01c5
            goto L_0x01e4
        L_0x01c5:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = r25.getName()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r0.<init>(r1)
            throw r0
        L_0x01e4:
            return r0
        L_0x01e5:
            int r10 = r10 + 1
            r21 = r11
            goto L_0x0198
        L_0x01ea:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x01ff:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0224, all -> 0x0221 }
            r9.<init>()     // Catch:{ Exception -> 0x0224, all -> 0x0221 }
            r10 = 47
            r11 = 46
            java.lang.String r10 = r1.replace(r11, r10)     // Catch:{ Exception -> 0x0224, all -> 0x0221 }
            r9.append(r10)     // Catch:{ Exception -> 0x0224, all -> 0x0221 }
            java.lang.String r10 = ".class"
            r9.append(r10)     // Catch:{ Exception -> 0x0224, all -> 0x0221 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0224, all -> 0x0221 }
            java.lang.ClassLoader r10 = r0.defaultClassLoader     // Catch:{ Exception -> 0x0224, all -> 0x0221 }
            if (r10 == 0) goto L_0x0228
            java.io.InputStream r9 = r10.getResourceAsStream(r9)     // Catch:{ Exception -> 0x0224, all -> 0x0221 }
            goto L_0x0232
        L_0x0221:
            r0 = move-exception
            r3 = 0
            goto L_0x0259
        L_0x0224:
            r13 = 0
            r18 = 0
            goto L_0x025d
        L_0x0228:
            java.lang.Class<com.alibaba.fastjson.parser.ParserConfig> r10 = com.alibaba.fastjson.parser.ParserConfig.class
            java.lang.ClassLoader r10 = r10.getClassLoader()     // Catch:{ Exception -> 0x0224, all -> 0x0221 }
            java.io.InputStream r9 = r10.getResourceAsStream(r9)     // Catch:{ Exception -> 0x0224, all -> 0x0221 }
        L_0x0232:
            if (r9 == 0) goto L_0x0253
            com.alibaba.fastjson.asm.ClassReader r10 = new com.alibaba.fastjson.asm.ClassReader     // Catch:{ Exception -> 0x0251, all -> 0x024b }
            r10.<init>(r9, r7)     // Catch:{ Exception -> 0x0251, all -> 0x024b }
            com.alibaba.fastjson.asm.TypeCollector r11 = new com.alibaba.fastjson.asm.TypeCollector     // Catch:{ Exception -> 0x0251, all -> 0x024b }
            java.lang.String r12 = "<clinit>"
            r13 = 0
            java.lang.Class[] r14 = new java.lang.Class[r13]     // Catch:{ Exception -> 0x024e, all -> 0x024b }
            r11.<init>(r12, r14)     // Catch:{ Exception -> 0x024e, all -> 0x024b }
            r10.accept(r11)     // Catch:{ Exception -> 0x024e, all -> 0x024b }
            boolean r10 = r11.hasJsonType()     // Catch:{ Exception -> 0x024e, all -> 0x024b }
            goto L_0x0255
        L_0x024b:
            r0 = move-exception
            r3 = r9
            goto L_0x0259
        L_0x024e:
            r18 = r9
            goto L_0x025d
        L_0x0251:
            r13 = 0
            goto L_0x024e
        L_0x0253:
            r13 = 0
            r10 = r13
        L_0x0255:
            com.alibaba.fastjson.util.IOUtils.close(r9)
            goto L_0x0261
        L_0x0259:
            com.alibaba.fastjson.util.IOUtils.close(r3)
            throw r0
        L_0x025d:
            com.alibaba.fastjson.util.IOUtils.close(r18)
            r10 = r13
        L_0x0261:
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.SupportAutoType
            int r9 = r9.mask
            boolean r11 = r0.autoTypeSupport
            if (r11 != 0) goto L_0x0275
            r11 = r26 & r9
            if (r11 != 0) goto L_0x0275
            int r11 = com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0273
            goto L_0x0275
        L_0x0273:
            r9 = r13
            goto L_0x0276
        L_0x0275:
            r9 = r7
        L_0x0276:
            if (r9 != 0) goto L_0x027c
            if (r10 != 0) goto L_0x027c
            if (r8 == 0) goto L_0x0287
        L_0x027c:
            if (r9 != 0) goto L_0x0280
            if (r10 == 0) goto L_0x0281
        L_0x0280:
            r13 = r7
        L_0x0281:
            java.lang.ClassLoader r5 = r0.defaultClassLoader
            java.lang.Class r5 = com.alibaba.fastjson.util.TypeUtils.loadClass(r1, r5, r13)
        L_0x0287:
            if (r5 == 0) goto L_0x0309
            if (r10 == 0) goto L_0x028f
            com.alibaba.fastjson.util.TypeUtils.addMapping(r1, r5)
            return r5
        L_0x028f:
            java.lang.Class<java.lang.ClassLoader> r7 = java.lang.ClassLoader.class
            boolean r7 = r7.isAssignableFrom(r5)
            if (r7 != 0) goto L_0x02f4
            java.lang.Class<javax.sql.DataSource> r7 = javax.sql.DataSource.class
            boolean r7 = r7.isAssignableFrom(r5)
            if (r7 != 0) goto L_0x02f4
            java.lang.Class<javax.sql.RowSet> r7 = javax.sql.RowSet.class
            boolean r7 = r7.isAssignableFrom(r5)
            if (r7 != 0) goto L_0x02f4
            if (r2 == 0) goto L_0x02d2
            boolean r0 = r2.isAssignableFrom(r5)
            if (r0 == 0) goto L_0x02b3
            com.alibaba.fastjson.util.TypeUtils.addMapping(r1, r5)
            return r5
        L_0x02b3:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = r25.getName()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r0.<init>(r1)
            throw r0
        L_0x02d2:
            com.alibaba.fastjson.PropertyNamingStrategy r0 = r0.propertyNamingStrategy
            com.alibaba.fastjson.util.JavaBeanInfo r0 = com.alibaba.fastjson.util.JavaBeanInfo.build(r5, r5, r0)
            java.lang.reflect.Constructor<?> r0 = r0.creatorConstructor
            if (r0 == 0) goto L_0x0309
            if (r9 != 0) goto L_0x02df
            goto L_0x0309
        L_0x02df:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x02f4:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0309:
            if (r9 == 0) goto L_0x0311
            if (r5 == 0) goto L_0x0310
            com.alibaba.fastjson.util.TypeUtils.addMapping(r1, r5)
        L_0x0310:
            return r5
        L_0x0311:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0326:
            r4 = r17
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x033d:
            r4 = r6
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0353:
            r4 = r6
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.ParserConfig.checkAutoType(java.lang.String, java.lang.Class, int):java.lang.Class");
    }

    private ParserConfig(ASMDeserializerFactory aSMDeserializerFactory, ClassLoader classLoader, boolean z) {
        this.deserializers = new IdentityHashMap<>();
        this.mixInDeserializers = new IdentityHashMap<>(16);
        this.typeMapping = new ConcurrentHashMap(16, 0.75f, 1);
        this.asmEnable = !ASMUtils.IS_ANDROID;
        this.symbolTable = new SymbolTable(4096);
        this.autoTypeSupport = AUTO_SUPPORT;
        this.jacksonCompatible = false;
        this.compatibleWithJavaBean = TypeUtils.compatibleWithJavaBean;
        this.modules = new ArrayList();
        this.denyHashCodes = new long[]{-9164606388214699518L, -8720046426850100497L, -8649961213709896794L, -8165637398350707645L, -8109300701639721088L, -7966123100503199569L, -7921218830998286408L, -7775351613326101303L, -7768608037458185275L, -7766605818834748097L, -6835437086156813536L, -6316154655839304624L, -6179589609550493385L, -6025144546313590215L, -5939269048541779808L, -5885964883385605994L, -5764804792063216819L, -5472097725414717105L, -5194641081268104286L, -4837536971810737970L, -4608341446948126581L, -4438775680185074100L, -4082057040235125754L, -3975378478825053783L, -3935185854875733362L, -3319207949486691020L, -2439930098895578154L, -2378990704010641148L, -2364987994247679115L, -2262244760619952081L, -2192804397019347313L, -2095516571388852610L, -1872417015366588117L, -1650485814983027158L, -1589194880214235129L, -905177026366752536L, -831789045734283466L, -582813228520337988L, -254670111376247151L, -190281065685395680L, -26639035867733124L, -9822483067882491L, 4750336058574309L, 33238344207745342L, 218512992947536312L, 313864100207897507L, 386461436234701831L, 823641066473609950L, 1073634739308289776L, 1153291637701043748L, 1203232727967308606L, 1459860845934817624L, 1502845958873959152L, 1534439610567445754L, 1698504441317515818L, 1818089308493370394L, 2164696723069287854L, 2653453629929770569L, 2660670623866180977L, 2731823439467737506L, 2836431254737891113L, 3089451460101527857L, 3114862868117605599L, 3256258368248066264L, 3547627781654598988L, 3637939656440441093L, 3688179072722109200L, 3718352661124136681L, 3730752432285826863L, 3794316665763266033L, 4046190361520671643L, 4147696707147271408L, 4254584350247334433L, 4814658433570175913L, 4841947709850912914L, 4904007817188630457L, 5100336081510080343L, 5274044858141538265L, 5347909877633654828L, 5450448828334921485L, 5474268165959054640L, 5596129856135573697L, 5688200883751798389L, 5751393439502795295L, 5944107969236155580L, 6280357960959217660L, 6456855723474196908L, 6511035576063254270L, 6534946468240507089L, 6734240326434096246L, 6742705432718011780L, 6854854816081053523L, 7123326897294507060L, 7179336928365889465L, 7375862386996623731L, 7442624256860549330L, 7658177784286215602L, 8055461369741094911L, 8389032537095247355L, 8409640769019589119L, 8488266005336625107L, 8537233257283452655L, 8838294710098435315L};
        long[] jArr = new long[AUTO_TYPE_ACCEPT_LIST.length];
        int i = 0;
        while (true) {
            String[] strArr = AUTO_TYPE_ACCEPT_LIST;
            if (i >= strArr.length) {
                break;
            }
            jArr[i] = TypeUtils.fnv1a_64(strArr[i]);
            i++;
        }
        Arrays.sort(jArr);
        this.acceptHashCodes = jArr;
        this.fieldBased = z;
        if (aSMDeserializerFactory == null && !ASMUtils.IS_ANDROID) {
            if (classLoader == null) {
                try {
                    aSMDeserializerFactory = new ASMDeserializerFactory(new ASMClassLoader());
                } catch (ExceptionInInitializerError | NoClassDefFoundError | AccessControlException unused) {
                }
            } else {
                aSMDeserializerFactory = new ASMDeserializerFactory(classLoader);
            }
        }
        this.asmFactory = aSMDeserializerFactory;
        if (aSMDeserializerFactory == null) {
            this.asmEnable = false;
        }
        initDeserializers();
        addItemsToDeny(DENYS);
        addItemsToDeny0(DENYS_INTERNAL);
        addItemsToAccept(AUTO_TYPE_ACCEPT_LIST);
    }

    /* JADX WARNING: type inference failed for: r25v0, types: [java.lang.reflect.Type] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.fastjson.parser.deserializer.ObjectDeserializer getDeserializer(java.lang.Class<?> r24, java.lang.reflect.Type r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            java.lang.String r3 = "java.util.Optional"
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r0.get(r2)
            if (r4 == 0) goto L_0x000f
            return r4
        L_0x000f:
            if (r2 != 0) goto L_0x0012
            r2 = r1
        L_0x0012:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r0.get(r2)
            if (r4 == 0) goto L_0x0019
            return r4
        L_0x0019:
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r5 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r6 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r1, r5)
            com.alibaba.fastjson.annotation.JSONType r6 = (com.alibaba.fastjson.annotation.JSONType) r6
            if (r6 == 0) goto L_0x0030
            java.lang.Class r6 = r6.mappingTo()
            java.lang.Class<java.lang.Void> r7 = java.lang.Void.class
            if (r6 == r7) goto L_0x0030
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r0.getDeserializer(r6, r6)
            return r0
        L_0x0030:
            boolean r6 = r2 instanceof java.lang.reflect.WildcardType
            if (r6 != 0) goto L_0x003c
            boolean r6 = r2 instanceof java.lang.reflect.TypeVariable
            if (r6 != 0) goto L_0x003c
            boolean r6 = r2 instanceof java.lang.reflect.ParameterizedType
            if (r6 == 0) goto L_0x0040
        L_0x003c:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r23.get(r24)
        L_0x0040:
            if (r4 == 0) goto L_0x0043
            return r4
        L_0x0043:
            java.util.List<com.alibaba.fastjson.spi.Module> r6 = r0.modules
            java.util.Iterator r6 = r6.iterator()
        L_0x0049:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x005f
            java.lang.Object r4 = r6.next()
            com.alibaba.fastjson.spi.Module r4 = (com.alibaba.fastjson.spi.Module) r4
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r4.createDeserializer(r0, r1)
            if (r4 == 0) goto L_0x0049
            r0.putDeserializer(r2, r4)
            return r4
        L_0x005f:
            java.lang.String r6 = r24.getName()
            r7 = 36
            r8 = 46
            java.lang.String r6 = r6.replace(r7, r8)
            java.lang.String r7 = "java.awt."
            boolean r7 = r6.startsWith(r7)
            r8 = 4
            r9 = 0
            r10 = 1
            if (r7 == 0) goto L_0x00a8
            boolean r7 = com.alibaba.fastjson.serializer.AwtCodec.support(r24)
            if (r7 == 0) goto L_0x00a8
            boolean r7 = awtError
            if (r7 != 0) goto L_0x00a8
            java.lang.String r4 = "java.awt.Rectangle"
            java.lang.String r7 = "java.awt.Color"
            java.lang.String r11 = "java.awt.Point"
            java.lang.String r12 = "java.awt.Font"
            java.lang.String[] r4 = new java.lang.String[]{r11, r12, r4, r7}
            r7 = r9
        L_0x008d:
            if (r7 >= r8) goto L_0x00a6
            r11 = r4[r7]     // Catch:{ all -> 0x00a4 }
            boolean r12 = r11.equals(r6)     // Catch:{ all -> 0x00a4 }
            if (r12 == 0) goto L_0x00a1
            java.lang.Class r4 = java.lang.Class.forName(r11)     // Catch:{ all -> 0x00a4 }
            com.alibaba.fastjson.serializer.AwtCodec r7 = com.alibaba.fastjson.serializer.AwtCodec.instance     // Catch:{ all -> 0x00a4 }
            r0.putDeserializer(r4, r7)     // Catch:{ all -> 0x00a4 }
            return r7
        L_0x00a1:
            int r7 = r7 + 1
            goto L_0x008d
        L_0x00a4:
            awtError = r10
        L_0x00a6:
            com.alibaba.fastjson.serializer.AwtCodec r4 = com.alibaba.fastjson.serializer.AwtCodec.instance
        L_0x00a8:
            boolean r7 = jdk8Error
            if (r7 != 0) goto L_0x0114
            java.lang.String r7 = "java.time."
            boolean r7 = r6.startsWith(r7)     // Catch:{ all -> 0x0112 }
            if (r7 == 0) goto L_0x00ea
            java.lang.String r11 = "java.time.LocalDateTime"
            java.lang.String r12 = "java.time.LocalDate"
            java.lang.String r13 = "java.time.LocalTime"
            java.lang.String r14 = "java.time.ZonedDateTime"
            java.lang.String r15 = "java.time.OffsetDateTime"
            java.lang.String r16 = "java.time.OffsetTime"
            java.lang.String r17 = "java.time.ZoneOffset"
            java.lang.String r18 = "java.time.ZoneRegion"
            java.lang.String r19 = "java.time.ZoneId"
            java.lang.String r20 = "java.time.Period"
            java.lang.String r21 = "java.time.Duration"
            java.lang.String r22 = "java.time.Instant"
            java.lang.String[] r3 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22}     // Catch:{ all -> 0x0112 }
            r7 = r9
        L_0x00d1:
            r8 = 12
            if (r7 >= r8) goto L_0x0114
            r8 = r3[r7]     // Catch:{ all -> 0x0112 }
            boolean r11 = r8.equals(r6)     // Catch:{ all -> 0x0112 }
            if (r11 == 0) goto L_0x00e7
            java.lang.Class r3 = java.lang.Class.forName(r8)     // Catch:{ all -> 0x0112 }
            com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec r4 = com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec.instance     // Catch:{ all -> 0x0112 }
            r0.putDeserializer(r3, r4)     // Catch:{ all -> 0x0112 }
            return r4
        L_0x00e7:
            int r7 = r7 + 1
            goto L_0x00d1
        L_0x00ea:
            boolean r7 = r6.startsWith(r3)     // Catch:{ all -> 0x0112 }
            if (r7 == 0) goto L_0x0114
            java.lang.String r7 = "java.util.OptionalDouble"
            java.lang.String r11 = "java.util.OptionalInt"
            java.lang.String r12 = "java.util.OptionalLong"
            java.lang.String[] r3 = new java.lang.String[]{r3, r7, r11, r12}     // Catch:{ all -> 0x0112 }
            r7 = r9
        L_0x00fb:
            if (r7 >= r8) goto L_0x0114
            r11 = r3[r7]     // Catch:{ all -> 0x0112 }
            boolean r12 = r11.equals(r6)     // Catch:{ all -> 0x0112 }
            if (r12 == 0) goto L_0x010f
            java.lang.Class r3 = java.lang.Class.forName(r11)     // Catch:{ all -> 0x0112 }
            com.alibaba.fastjson.parser.deserializer.OptionalCodec r4 = com.alibaba.fastjson.parser.deserializer.OptionalCodec.instance     // Catch:{ all -> 0x0112 }
            r0.putDeserializer(r3, r4)     // Catch:{ all -> 0x0112 }
            return r4
        L_0x010f:
            int r7 = r7 + 1
            goto L_0x00fb
        L_0x0112:
            jdk8Error = r10
        L_0x0114:
            boolean r3 = jodaError
            if (r3 != 0) goto L_0x0152
            java.lang.String r3 = "org.joda.time."
            boolean r3 = r6.startsWith(r3)     // Catch:{ all -> 0x0150 }
            if (r3 == 0) goto L_0x0152
            java.lang.String r11 = "org.joda.time.DateTime"
            java.lang.String r12 = "org.joda.time.LocalDate"
            java.lang.String r13 = "org.joda.time.LocalDateTime"
            java.lang.String r14 = "org.joda.time.LocalTime"
            java.lang.String r15 = "org.joda.time.Instant"
            java.lang.String r16 = "org.joda.time.Period"
            java.lang.String r17 = "org.joda.time.Duration"
            java.lang.String r18 = "org.joda.time.DateTimeZone"
            java.lang.String r19 = "org.joda.time.format.DateTimeFormatter"
            java.lang.String[] r3 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19}     // Catch:{ all -> 0x0150 }
            r7 = r9
        L_0x0137:
            r8 = 9
            if (r7 >= r8) goto L_0x0152
            r8 = r3[r7]     // Catch:{ all -> 0x0150 }
            boolean r11 = r8.equals(r6)     // Catch:{ all -> 0x0150 }
            if (r11 == 0) goto L_0x014d
            java.lang.Class r3 = java.lang.Class.forName(r8)     // Catch:{ all -> 0x0150 }
            com.alibaba.fastjson.serializer.JodaCodec r4 = com.alibaba.fastjson.serializer.JodaCodec.instance     // Catch:{ all -> 0x0150 }
            r0.putDeserializer(r3, r4)     // Catch:{ all -> 0x0150 }
            return r4
        L_0x014d:
            int r7 = r7 + 1
            goto L_0x0137
        L_0x0150:
            jodaError = r10
        L_0x0152:
            boolean r3 = guavaError
            if (r3 != 0) goto L_0x0187
            java.lang.String r3 = "com.google.common.collect."
            boolean r3 = r6.startsWith(r3)
            if (r3 == 0) goto L_0x0187
            java.lang.String r3 = "com.google.common.collect.HashMultimap"
            java.lang.String r7 = "com.google.common.collect.LinkedListMultimap"
            java.lang.String r8 = "com.google.common.collect.LinkedHashMultimap"
            java.lang.String r11 = "com.google.common.collect.ArrayListMultimap"
            java.lang.String r12 = "com.google.common.collect.TreeMultimap"
            java.lang.String[] r3 = new java.lang.String[]{r3, r7, r8, r11, r12}     // Catch:{ ClassNotFoundException -> 0x0185 }
            r7 = r9
        L_0x016d:
            r8 = 5
            if (r7 >= r8) goto L_0x0187
            r8 = r3[r7]     // Catch:{ ClassNotFoundException -> 0x0185 }
            boolean r11 = r8.equals(r6)     // Catch:{ ClassNotFoundException -> 0x0185 }
            if (r11 == 0) goto L_0x0182
            java.lang.Class r3 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x0185 }
            com.alibaba.fastjson.serializer.GuavaCodec r4 = com.alibaba.fastjson.serializer.GuavaCodec.instance     // Catch:{ ClassNotFoundException -> 0x0185 }
            r0.putDeserializer(r3, r4)     // Catch:{ ClassNotFoundException -> 0x0185 }
            return r4
        L_0x0182:
            int r7 = r7 + 1
            goto L_0x016d
        L_0x0185:
            guavaError = r10
        L_0x0187:
            java.lang.String r3 = "java.nio.ByteBuffer"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x0194
            com.alibaba.fastjson.serializer.ByteBufferCodec r4 = com.alibaba.fastjson.serializer.ByteBufferCodec.instance
            r0.putDeserializer(r1, r4)
        L_0x0194:
            java.lang.String r3 = "java.nio.file.Path"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x01a1
            com.alibaba.fastjson.serializer.MiscCodec r4 = com.alibaba.fastjson.serializer.MiscCodec.instance
            r0.putDeserializer(r1, r4)
        L_0x01a1:
            java.lang.Class<java.util.Map$Entry> r3 = java.util.Map.Entry.class
            if (r1 != r3) goto L_0x01aa
            com.alibaba.fastjson.serializer.MiscCodec r4 = com.alibaba.fastjson.serializer.MiscCodec.instance
            r0.putDeserializer(r1, r4)
        L_0x01aa:
            java.lang.String r3 = "org.javamoney.moneta.Money"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x01b7
            com.alibaba.fastjson.support.moneta.MonetaCodec r4 = com.alibaba.fastjson.support.moneta.MonetaCodec.instance
            r0.putDeserializer(r1, r4)
        L_0x01b7:
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r3 = r3.getContextClassLoader()
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer> r6 = com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer.class
            java.util.Set r3 = com.alibaba.fastjson.util.ServiceLoader.load(r6, (java.lang.ClassLoader) r3)     // Catch:{ Exception -> 0x01ed }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x01ed }
        L_0x01c9:
            boolean r6 = r3.hasNext()     // Catch:{ Exception -> 0x01ed }
            if (r6 == 0) goto L_0x01ed
            java.lang.Object r6 = r3.next()     // Catch:{ Exception -> 0x01ed }
            com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer r6 = (com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer) r6     // Catch:{ Exception -> 0x01ed }
            java.util.Set r7 = r6.getAutowiredFor()     // Catch:{ Exception -> 0x01ed }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x01ed }
        L_0x01dd:
            boolean r8 = r7.hasNext()     // Catch:{ Exception -> 0x01ed }
            if (r8 == 0) goto L_0x01c9
            java.lang.Object r8 = r7.next()     // Catch:{ Exception -> 0x01ed }
            java.lang.reflect.Type r8 = (java.lang.reflect.Type) r8     // Catch:{ Exception -> 0x01ed }
            r0.putDeserializer(r8, r6)     // Catch:{ Exception -> 0x01ed }
            goto L_0x01dd
        L_0x01ed:
            if (r4 != 0) goto L_0x01f3
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r0.get(r2)
        L_0x01f3:
            if (r4 == 0) goto L_0x01f6
            return r4
        L_0x01f6:
            boolean r3 = r24.isEnum()
            if (r3 == 0) goto L_0x0236
            boolean r3 = r0.jacksonCompatible
            if (r3 == 0) goto L_0x021a
            java.lang.reflect.Method[] r3 = r24.getMethods()
            int r4 = r3.length
        L_0x0205:
            if (r9 >= r4) goto L_0x021a
            r6 = r3[r9]
            boolean r6 = com.alibaba.fastjson.util.TypeUtils.isJacksonCreator(r6)
            if (r6 == 0) goto L_0x0217
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r1 = r0.createJavaBeanDeserializer(r1, r2)
            r0.putDeserializer(r2, r1)
            return r1
        L_0x0217:
            int r9 = r9 + 1
            goto L_0x0205
        L_0x021a:
            java.lang.annotation.Annotation r3 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r1, r5)
            com.alibaba.fastjson.annotation.JSONType r3 = (com.alibaba.fastjson.annotation.JSONType) r3
            if (r3 == 0) goto L_0x0230
            java.lang.Class r3 = r3.deserializer()
            java.lang.Object r3 = r3.newInstance()     // Catch:{ all -> 0x0230 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r3 = (com.alibaba.fastjson.parser.deserializer.ObjectDeserializer) r3     // Catch:{ all -> 0x0230 }
            r0.putDeserializer(r1, r3)     // Catch:{ all -> 0x0230 }
            return r3
        L_0x0230:
            com.alibaba.fastjson.parser.deserializer.EnumDeserializer r3 = new com.alibaba.fastjson.parser.deserializer.EnumDeserializer
            r3.<init>(r1)
            goto L_0x0292
        L_0x0236:
            boolean r3 = r24.isArray()
            if (r3 == 0) goto L_0x023f
            com.alibaba.fastjson.serializer.ObjectArrayCodec r3 = com.alibaba.fastjson.serializer.ObjectArrayCodec.instance
            goto L_0x0292
        L_0x023f:
            java.lang.Class<java.util.Set> r3 = java.util.Set.class
            if (r1 == r3) goto L_0x0290
            java.lang.Class<java.util.HashSet> r3 = java.util.HashSet.class
            if (r1 == r3) goto L_0x0290
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            if (r1 == r3) goto L_0x0290
            java.lang.Class<java.util.List> r4 = java.util.List.class
            if (r1 == r4) goto L_0x0290
            java.lang.Class<java.util.ArrayList> r4 = java.util.ArrayList.class
            if (r1 != r4) goto L_0x0254
            goto L_0x0290
        L_0x0254:
            boolean r3 = r3.isAssignableFrom(r1)
            if (r3 == 0) goto L_0x025d
            com.alibaba.fastjson.serializer.CollectionCodec r3 = com.alibaba.fastjson.serializer.CollectionCodec.instance
            goto L_0x0292
        L_0x025d:
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            boolean r3 = r3.isAssignableFrom(r1)
            if (r3 == 0) goto L_0x0268
            com.alibaba.fastjson.parser.deserializer.MapDeserializer r3 = com.alibaba.fastjson.parser.deserializer.MapDeserializer.instance
            goto L_0x0292
        L_0x0268:
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            boolean r3 = r3.isAssignableFrom(r1)
            if (r3 == 0) goto L_0x0276
            com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer r3 = new com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer
            r3.<init>(r0, r1)
            goto L_0x0292
        L_0x0276:
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.PropertyProcessable> r3 = com.alibaba.fastjson.parser.deserializer.PropertyProcessable.class
            boolean r3 = r3.isAssignableFrom(r1)
            if (r3 == 0) goto L_0x0284
            com.alibaba.fastjson.parser.deserializer.PropertyProcessableDeserializer r3 = new com.alibaba.fastjson.parser.deserializer.PropertyProcessableDeserializer
            r3.<init>(r1)
            goto L_0x0292
        L_0x0284:
            java.lang.Class<java.net.InetAddress> r3 = java.net.InetAddress.class
            if (r1 != r3) goto L_0x028b
            com.alibaba.fastjson.serializer.MiscCodec r3 = com.alibaba.fastjson.serializer.MiscCodec.instance
            goto L_0x0292
        L_0x028b:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r3 = r0.createJavaBeanDeserializer(r1, r2)
            goto L_0x0292
        L_0x0290:
            com.alibaba.fastjson.serializer.CollectionCodec r3 = com.alibaba.fastjson.serializer.CollectionCodec.instance
        L_0x0292:
            r0.putDeserializer(r2, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.ParserConfig.getDeserializer(java.lang.Class, java.lang.reflect.Type):com.alibaba.fastjson.parser.deserializer.ObjectDeserializer");
    }

    public ObjectDeserializer getDeserializer(FieldInfo fieldInfo) {
        return getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
    }
}

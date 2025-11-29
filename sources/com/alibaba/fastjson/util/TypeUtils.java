package com.alibaba.fastjson.util;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.SerializeBeanInfo;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Path;
import java.security.AccessControlException;
import java.sql.Clob;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.time.DurationKt;
import org.apache.commons.lang3.BooleanUtils;

public class TypeUtils {
    private static final Pattern NUMBER_WITH_TRAILING_ZEROS_PATTERN = Pattern.compile("\\.0*$");
    private static volatile boolean classXmlAccessorType_error = false;
    private static volatile Class class_Clob = null;
    private static volatile boolean class_Clob_error = false;
    private static Class<? extends Annotation> class_JacksonCreator = null;
    private static boolean class_JacksonCreator_error = false;
    private static Class<? extends Annotation> class_ManyToMany = null;
    private static boolean class_ManyToMany_error = false;
    private static Class<? extends Annotation> class_OneToMany = null;
    private static boolean class_OneToMany_error = false;
    private static volatile Class class_XmlAccessType = null;
    private static volatile Class class_XmlAccessorType = null;
    public static boolean compatibleWithFieldName;
    public static boolean compatibleWithJavaBean;
    private static volatile Field field_XmlAccessType_FIELD = null;
    private static volatile Object field_XmlAccessType_FIELD_VALUE = null;
    private static volatile Map<Class, String[]> kotlinIgnores;
    private static volatile boolean kotlinIgnores_error;
    private static volatile boolean kotlin_class_klass_error;
    private static volatile boolean kotlin_error;
    private static volatile Constructor kotlin_kclass_constructor;
    private static volatile Method kotlin_kclass_getConstructors;
    private static volatile Method kotlin_kfunction_getParameters;
    private static volatile Method kotlin_kparameter_getName;
    private static volatile Class kotlin_metadata;
    private static volatile boolean kotlin_metadata_error;
    private static ConcurrentMap<String, Class<?>> mappings = new ConcurrentHashMap(256, 0.75f, 1);
    private static Method method_HibernateIsInitialized = null;
    private static boolean method_HibernateIsInitialized_error = false;
    private static volatile Method method_XmlAccessorType_value = null;
    private static Class<?> optionalClass;
    private static boolean optionalClassInited = false;
    private static Method oracleDateMethod;
    private static boolean oracleDateMethodInited = false;
    private static Method oracleTimestampMethod;
    private static boolean oracleTimestampMethodInited = false;
    private static Class<?> pathClass;
    private static boolean pathClass_error = false;
    private static boolean setAccessibleEnable = true;
    private static Class<? extends Annotation> transientClass;
    private static boolean transientClassInited = false;

    static {
        compatibleWithJavaBean = false;
        compatibleWithFieldName = false;
        try {
            compatibleWithJavaBean = BooleanUtils.TRUE.equals(IOUtils.getStringProperty(IOUtils.FASTJSON_COMPATIBLEWITHJAVABEAN));
            compatibleWithFieldName = BooleanUtils.TRUE.equals(IOUtils.getStringProperty(IOUtils.FASTJSON_COMPATIBLEWITHFIELDNAME));
        } catch (Throwable unused) {
        }
        addBaseClassMappings();
    }

    private static void addBaseClassMappings() {
        mappings.put("byte", Byte.TYPE);
        mappings.put("short", Short.TYPE);
        mappings.put("int", Integer.TYPE);
        mappings.put("long", Long.TYPE);
        mappings.put("float", Float.TYPE);
        mappings.put("double", Double.TYPE);
        mappings.put("boolean", Boolean.TYPE);
        mappings.put("char", Character.TYPE);
        Class<byte[]> cls = byte[].class;
        mappings.put("[byte", cls);
        Class<short[]> cls2 = short[].class;
        mappings.put("[short", cls2);
        Class<int[]> cls3 = int[].class;
        mappings.put("[int", cls3);
        Class<long[]> cls4 = long[].class;
        mappings.put("[long", cls4);
        Class<float[]> cls5 = float[].class;
        mappings.put("[float", cls5);
        Class<double[]> cls6 = double[].class;
        mappings.put("[double", cls6);
        Class<boolean[]> cls7 = boolean[].class;
        mappings.put("[boolean", cls7);
        Class<char[]> cls8 = char[].class;
        mappings.put("[char", cls8);
        mappings.put("[B", cls);
        mappings.put("[S", cls2);
        mappings.put("[I", cls3);
        mappings.put("[J", cls4);
        mappings.put("[F", cls5);
        mappings.put("[D", cls6);
        mappings.put("[C", cls8);
        mappings.put("[Z", cls7);
        Class[] clsArr = {Object.class, Cloneable.class, loadClass("java.lang.AutoCloseable"), Exception.class, RuntimeException.class, IllegalAccessError.class, IllegalAccessException.class, IllegalArgumentException.class, IllegalMonitorStateException.class, IllegalStateException.class, IllegalThreadStateException.class, IndexOutOfBoundsException.class, InstantiationError.class, InstantiationException.class, InternalError.class, InterruptedException.class, LinkageError.class, NegativeArraySizeException.class, NoClassDefFoundError.class, NoSuchFieldError.class, NoSuchFieldException.class, NoSuchMethodError.class, NoSuchMethodException.class, NullPointerException.class, NumberFormatException.class, OutOfMemoryError.class, SecurityException.class, StackOverflowError.class, StringIndexOutOfBoundsException.class, TypeNotPresentException.class, VerifyError.class, StackTraceElement.class, HashMap.class, Hashtable.class, TreeMap.class, IdentityHashMap.class, WeakHashMap.class, LinkedHashMap.class, HashSet.class, LinkedHashSet.class, TreeSet.class, ArrayList.class, TimeUnit.class, ConcurrentHashMap.class, AtomicInteger.class, AtomicLong.class, Collections.EMPTY_MAP.getClass(), Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Number.class, String.class, BigDecimal.class, BigInteger.class, BitSet.class, Calendar.class, Date.class, Locale.class, UUID.class, Time.class, java.sql.Date.class, Timestamp.class, SimpleDateFormat.class, JSONObject.class, JSONPObject.class, JSONArray.class};
        for (int i = 0; i < 71; i++) {
            Class cls9 = clsArr[i];
            if (cls9 != null) {
                mappings.put(cls9.getName(), cls9);
            }
        }
    }

    public static void addMapping(String str, Class<?> cls) {
        mappings.put(str, cls);
    }

    public static SerializeBeanInfo buildBeanInfo(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy) {
        return buildBeanInfo(cls, map, propertyNamingStrategy, false);
    }

    public static byte byteValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0;
        }
        int scale = bigDecimal.scale();
        return (scale < -100 || scale > 100) ? bigDecimal.byteValueExact() : bigDecimal.byteValue();
    }

    public static <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
        T t;
        int i = 0;
        if (obj == null) {
            if (cls == Integer.TYPE) {
                return 0;
            }
            if (cls == Long.TYPE) {
                return 0L;
            }
            if (cls == Short.TYPE) {
                return (short) 0;
            }
            if (cls == Byte.TYPE) {
                return (byte) 0;
            }
            if (cls == Float.TYPE) {
                return Float.valueOf(0.0f);
            }
            if (cls == Double.TYPE) {
                return Double.valueOf(0.0d);
            }
            if (cls == Boolean.TYPE) {
                return Boolean.FALSE;
            }
            return null;
        } else if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        } else if (cls == obj.getClass()) {
            return obj;
        } else {
            if (!(obj instanceof Map)) {
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection<Object> collection = (Collection) obj;
                        T newInstance = Array.newInstance(cls.getComponentType(), collection.size());
                        for (Object cast : collection) {
                            Array.set(newInstance, i, cast(cast, cls.getComponentType(), parserConfig));
                            i++;
                        }
                        return newInstance;
                    } else if (cls == byte[].class) {
                        return castToBytes(obj);
                    }
                }
                if (cls.isAssignableFrom(obj.getClass())) {
                    return obj;
                }
                if (cls == Boolean.TYPE || cls == Boolean.class) {
                    return castToBoolean(obj);
                }
                if (cls == Byte.TYPE || cls == Byte.class) {
                    return castToByte(obj);
                }
                if (cls == Character.TYPE || cls == Character.class) {
                    return castToChar(obj);
                }
                if (cls == Short.TYPE || cls == Short.class) {
                    return castToShort(obj);
                }
                if (cls == Integer.TYPE || cls == Integer.class) {
                    return castToInt(obj);
                }
                if (cls == Long.TYPE || cls == Long.class) {
                    return castToLong(obj);
                }
                if (cls == Float.TYPE || cls == Float.class) {
                    return castToFloat(obj);
                }
                if (cls == Double.TYPE || cls == Double.class) {
                    return castToDouble(obj);
                }
                if (cls == String.class) {
                    return castToString(obj);
                }
                if (cls == BigDecimal.class) {
                    return castToBigDecimal(obj);
                }
                if (cls == BigInteger.class) {
                    return castToBigInteger(obj);
                }
                if (cls == Date.class) {
                    return castToDate(obj);
                }
                if (cls == java.sql.Date.class) {
                    return castToSqlDate(obj);
                }
                if (cls == Time.class) {
                    return castToSqlTime(obj);
                }
                if (cls == Timestamp.class) {
                    return castToTimestamp(obj);
                }
                if (cls.isEnum()) {
                    return castToEnum(obj, cls, parserConfig);
                }
                Class<Calendar> cls2 = Calendar.class;
                if (cls2.isAssignableFrom(cls)) {
                    Date castToDate = castToDate(obj);
                    if (cls == cls2) {
                        t = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                    } else {
                        try {
                            t = (Calendar) cls.newInstance();
                        } catch (Exception e) {
                            throw new JSONException("can not cast to : " + cls.getName(), e);
                        }
                    }
                    t.setTime(castToDate);
                    return t;
                }
                String name = cls.getName();
                if (name.equals("javax.xml.datatype.XMLGregorianCalendar")) {
                    Date castToDate2 = castToDate(obj);
                    Calendar instance = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                    instance.setTime(castToDate2);
                    return CalendarCodec.instance.createXMLGregorianCalendar(instance);
                }
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                        return null;
                    }
                    if (cls == Currency.class) {
                        return Currency.getInstance(str);
                    }
                    if (cls == Locale.class) {
                        return toLocale(str);
                    }
                    if (name.startsWith("java.time.")) {
                        return JSON.parseObject(JSON.toJSONString(str), cls);
                    }
                }
                if (parserConfig.get(cls) != null) {
                    return JSON.parseObject(JSON.toJSONString(obj), cls);
                }
                throw new JSONException("can not cast to : " + cls.getName());
            } else if (cls == Map.class) {
                return obj;
            } else {
                Map map = (Map) obj;
                if (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) {
                    return castToJavaBean(map, cls, parserConfig);
                }
                return obj;
            }
        }
    }

    public static BigDecimal castToBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0) {
            return null;
        }
        if (!(obj instanceof Map) || ((Map) obj).size() != 0) {
            return new BigDecimal(obj2);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        r1 = (java.math.BigDecimal) r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.math.BigInteger castToBigInteger(java.lang.Object r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r4 instanceof java.math.BigInteger
            if (r1 == 0) goto L_0x000b
            java.math.BigInteger r4 = (java.math.BigInteger) r4
            return r4
        L_0x000b:
            boolean r1 = r4 instanceof java.lang.Float
            if (r1 != 0) goto L_0x004d
            boolean r1 = r4 instanceof java.lang.Double
            if (r1 == 0) goto L_0x0014
            goto L_0x004d
        L_0x0014:
            boolean r1 = r4 instanceof java.math.BigDecimal
            if (r1 == 0) goto L_0x002c
            r1 = r4
            java.math.BigDecimal r1 = (java.math.BigDecimal) r1
            int r2 = r1.scale()
            r3 = -1000(0xfffffffffffffc18, float:NaN)
            if (r2 <= r3) goto L_0x002c
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 >= r3) goto L_0x002c
            java.math.BigInteger r4 = r1.toBigInteger()
            return r4
        L_0x002c:
            java.lang.String r4 = r4.toString()
            int r1 = r4.length()
            if (r1 == 0) goto L_0x004c
            java.lang.String r1 = "null"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x004c
            java.lang.String r1 = "NULL"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0047
            goto L_0x004c
        L_0x0047:
            java.math.BigInteger r0 = new java.math.BigInteger
            r0.<init>(r4)
        L_0x004c:
            return r0
        L_0x004d:
            java.lang.Number r4 = (java.lang.Number) r4
            long r0 = r4.longValue()
            java.math.BigInteger r4 = java.math.BigInteger.valueOf(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.castToBigInteger(java.lang.Object):java.math.BigInteger");
    }

    public static Boolean castToBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        boolean z = false;
        if (obj instanceof BigDecimal) {
            if (intValue((BigDecimal) obj) == 1) {
                z = true;
            }
            return Boolean.valueOf(z);
        } else if (obj instanceof Number) {
            if (((Number) obj).intValue() == 1) {
                z = true;
            }
            return Boolean.valueOf(z);
        } else {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                    return null;
                }
                if (BooleanUtils.TRUE.equalsIgnoreCase(str) || "1".equals(str)) {
                    return Boolean.TRUE;
                }
                if (BooleanUtils.FALSE.equalsIgnoreCase(str) || "0".equals(str)) {
                    return Boolean.FALSE;
                }
                if ("Y".equalsIgnoreCase(str) || ExifInterface.GPS_DIRECTION_TRUE.equals(str)) {
                    return Boolean.TRUE;
                }
                if ("F".equalsIgnoreCase(str) || "N".equals(str)) {
                    return Boolean.FALSE;
                }
            }
            throw new JSONException("can not cast to boolean, value : " + obj);
        }
    }

    public static Byte castToByte(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Byte.valueOf(byteValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static byte[] castToBytes(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return IOUtils.decodeBase64((String) obj);
        }
        throw new JSONException("can not cast to byte[], value : " + obj);
    }

    public static Character castToChar(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw new JSONException("can not cast to char, value : " + obj);
        }
        throw new JSONException("can not cast to char, value : " + obj);
    }

    public static Date castToDate(Object obj) {
        return castToDate(obj, (String) null);
    }

    public static Double castToDouble(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            if (obj2.indexOf(44) != -1) {
                obj2 = obj2.replaceAll(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, "");
            }
            return Double.valueOf(Double.parseDouble(obj2));
        }
        throw new JSONException("can not cast to double, value : " + obj);
    }

    public static <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                if (parserConfig == null) {
                    parserConfig = ParserConfig.getGlobalInstance();
                }
                ObjectDeserializer deserializer = parserConfig.getDeserializer((Type) cls);
                return deserializer instanceof EnumDeserializer ? ((EnumDeserializer) deserializer).getEnumByHashCode(fnv1a_64(str)) : Enum.valueOf(cls, str);
            }
            if (obj instanceof BigDecimal) {
                int intValue = intValue((BigDecimal) obj);
                T[] enumConstants = cls.getEnumConstants();
                if (intValue < enumConstants.length) {
                    return enumConstants[intValue];
                }
            }
            if (obj instanceof Number) {
                int intValue2 = ((Number) obj).intValue();
                T[] enumConstants2 = cls.getEnumConstants();
                if (intValue2 < enumConstants2.length) {
                    return enumConstants2[intValue2];
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e) {
            throw new JSONException("can not cast to : " + cls.getName(), e);
        }
    }

    public static Float castToFloat(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            if (obj2.indexOf(44) != -1) {
                obj2 = obj2.replaceAll(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, "");
            }
            return Float.valueOf(Float.parseFloat(obj2));
        }
        throw new JSONException("can not cast to float, value : " + obj);
    }

    public static Integer castToInt(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof BigDecimal) {
            return Integer.valueOf(intValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.indexOf(44) != -1) {
                str = str.replaceAll(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, "");
            }
            Matcher matcher = NUMBER_WITH_TRAILING_ZEROS_PATTERN.matcher(str);
            if (matcher.find()) {
                str = matcher.replaceAll("");
            }
            return Integer.valueOf(Integer.parseInt(str));
        } else if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                    Iterator it = map.values().iterator();
                    it.next();
                    return castToInt(it.next());
                }
            }
            throw new JSONException("can not cast to int, value : " + obj);
        }
    }

    public static <T> T castToJavaBean(Object obj, Class<T> cls) {
        return cast(obj, cls, ParserConfig.getGlobalInstance());
    }

    public static LocalDateTime castToLocalDateTime(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        if (str == null) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        return LocalDateTime.parse(obj.toString(), DateTimeFormatter.ofPattern(str));
    }

    public static Long castToLong(Object obj) {
        Calendar calendar = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Long.valueOf(longValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.indexOf(44) != -1) {
                str = str.replaceAll(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, "");
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                JSONScanner jSONScanner = new JSONScanner(str);
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    calendar = jSONScanner.getCalendar();
                }
                jSONScanner.close();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return castToLong(it.next());
            }
        }
        throw new JSONException("can not cast to long, value : " + obj);
    }

    public static Short castToShort(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Short.valueOf(shortValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        throw new JSONException("can not cast to short, value : " + obj);
    }

    public static java.sql.Date castToSqlDate(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.sql.Date) {
            return (java.sql.Date) obj;
        }
        if (obj instanceof Date) {
            return new java.sql.Date(((Date) obj).getTime());
        }
        if (obj instanceof Calendar) {
            return new java.sql.Date(((Calendar) obj).getTimeInMillis());
        }
        long longValue = obj instanceof BigDecimal ? longValue((BigDecimal) obj) : obj instanceof Number ? ((Number) obj).longValue() : 0;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (isNumber(str)) {
                longValue = Long.parseLong(str);
            } else {
                JSONScanner jSONScanner = new JSONScanner(str);
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    longValue = jSONScanner.getCalendar().getTime().getTime();
                } else {
                    throw new JSONException("can not cast to Timestamp, value : " + str);
                }
            }
        }
        if (longValue > 0) {
            return new java.sql.Date(longValue);
        }
        throw new JSONException("can not cast to Date, value : " + obj);
    }

    public static Time castToSqlTime(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Time) {
            return (Time) obj;
        }
        if (obj instanceof Date) {
            return new Time(((Date) obj).getTime());
        }
        if (obj instanceof Calendar) {
            return new Time(((Calendar) obj).getTimeInMillis());
        }
        long longValue = obj instanceof BigDecimal ? longValue((BigDecimal) obj) : obj instanceof Number ? ((Number) obj).longValue() : 0;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equalsIgnoreCase(str)) {
                return null;
            }
            if (isNumber(str)) {
                longValue = Long.parseLong(str);
            } else {
                JSONScanner jSONScanner = new JSONScanner(str);
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    longValue = jSONScanner.getCalendar().getTime().getTime();
                } else {
                    throw new JSONException("can not cast to Timestamp, value : " + str);
                }
            }
        }
        if (longValue > 0) {
            return new Time(longValue);
        }
        throw new JSONException("can not cast to Date, value : " + obj);
    }

    public static String castToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static Timestamp castToTimestamp(Object obj) {
        Object obj2 = obj;
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof Calendar) {
            return new Timestamp(((Calendar) obj2).getTimeInMillis());
        }
        if (obj2 instanceof Timestamp) {
            return (Timestamp) obj2;
        }
        if (obj2 instanceof Date) {
            return new Timestamp(((Date) obj2).getTime());
        }
        long longValue = obj2 instanceof BigDecimal ? longValue((BigDecimal) obj2) : obj2 instanceof Number ? ((Number) obj2).longValue() : 0;
        if (obj2 instanceof String) {
            String str = (String) obj2;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.endsWith(".000000000")) {
                str = str.substring(0, str.length() - 10);
            } else if (str.endsWith(".000000")) {
                str = str.substring(0, str.length() - 7);
            }
            if (str.length() == 29 && str.charAt(4) == '-' && str.charAt(7) == '-' && str.charAt(10) == ' ' && str.charAt(13) == ':' && str.charAt(16) == ':' && str.charAt(19) == '.') {
                return new Timestamp(num(str.charAt(0), str.charAt(1), str.charAt(2), str.charAt(3)) - 1900, num(str.charAt(5), str.charAt(6)) - 1, num(str.charAt(8), str.charAt(9)), num(str.charAt(11), str.charAt(12)), num(str.charAt(14), str.charAt(15)), num(str.charAt(17), str.charAt(18)), num(str.charAt(20), str.charAt(21), str.charAt(22), str.charAt(23), str.charAt(24), str.charAt(25), str.charAt(26), str.charAt(27), str.charAt(28)));
            } else if (isNumber(str)) {
                longValue = Long.parseLong(str);
            } else {
                JSONScanner jSONScanner = new JSONScanner(str);
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    longValue = jSONScanner.getCalendar().getTime().getTime();
                } else {
                    throw new JSONException("can not cast to Timestamp, value : " + str);
                }
            }
        }
        if (longValue > 0) {
            return new Timestamp(longValue);
        }
        throw new JSONException("can not cast to Timestamp, value : " + obj2);
    }

    public static Type checkPrimitiveArray(GenericArrayType genericArrayType) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        String str = "[";
        while (genericComponentType instanceof GenericArrayType) {
            genericComponentType = ((GenericArrayType) genericComponentType).getGenericComponentType();
            str = str + str;
        }
        if (!(genericComponentType instanceof Class)) {
            return genericArrayType;
        }
        Class cls = (Class) genericComponentType;
        if (!cls.isPrimitive()) {
            return genericArrayType;
        }
        try {
            if (cls == Boolean.TYPE) {
                return Class.forName(str + "Z");
            } else if (cls == Character.TYPE) {
                return Class.forName(str + "C");
            } else if (cls == Byte.TYPE) {
                return Class.forName(str + "B");
            } else if (cls == Short.TYPE) {
                return Class.forName(str + ExifInterface.LATITUDE_SOUTH);
            } else if (cls == Integer.TYPE) {
                return Class.forName(str + "I");
            } else if (cls == Long.TYPE) {
                return Class.forName(str + "J");
            } else if (cls == Float.TYPE) {
                return Class.forName(str + "F");
            } else if (cls != Double.TYPE) {
                return genericArrayType;
            } else {
                return Class.forName(str + "D");
            }
        } catch (ClassNotFoundException unused) {
            return genericArrayType;
        }
    }

    public static void clearClassMapping() {
        mappings.clear();
        addBaseClassMappings();
    }

    private static void computeFields(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, Map<String, FieldInfo> map2, Field[] fieldArr) {
        String str;
        int i;
        int i2;
        int i3;
        Map<String, String> map3 = map;
        PropertyNamingStrategy propertyNamingStrategy2 = propertyNamingStrategy;
        Map<String, FieldInfo> map4 = map2;
        for (Field field : fieldArr) {
            if (!Modifier.isStatic(field.getModifiers())) {
                JSONField jSONField = (JSONField) getAnnotation(field, JSONField.class);
                String name = field.getName();
                String str2 = null;
                if (jSONField == null) {
                    str = null;
                    i3 = 0;
                    i2 = 0;
                    i = 0;
                } else if (jSONField.serialize()) {
                    int ordinal = jSONField.ordinal();
                    int of = SerializerFeature.of(jSONField.serialzeFeatures());
                    int of2 = Feature.of(jSONField.parseFeatures());
                    if (jSONField.name().length() != 0) {
                        name = jSONField.name();
                    }
                    if (jSONField.label().length() != 0) {
                        str2 = jSONField.label();
                    }
                    str = str2;
                    i3 = ordinal;
                    i2 = of;
                    i = of2;
                }
                if (map3 == null || (name = map3.get(name)) != null) {
                    if (propertyNamingStrategy2 != null) {
                        name = propertyNamingStrategy2.translate(name);
                    }
                    String str3 = name;
                    if (!map4.containsKey(str3)) {
                        FieldInfo fieldInfo = r7;
                        FieldInfo fieldInfo2 = new FieldInfo(str3, (Method) null, field, cls, (Type) null, i3, i2, i, (JSONField) null, jSONField, str);
                        map4.put(str3, fieldInfo);
                    }
                }
            }
        }
    }

    public static List<FieldInfo> computeGetters(Class<?> cls, Map<String, String> map) {
        return computeGetters(cls, map, true);
    }

    public static List<FieldInfo> computeGettersWithFieldBase(Class<?> cls, Map<String, String> map, boolean z, PropertyNamingStrategy propertyNamingStrategy) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            computeFields(cls2, map, propertyNamingStrategy, linkedHashMap, cls2.getDeclaredFields());
        }
        return getFieldInfos(cls, z, linkedHashMap);
    }

    private static Map<TypeVariable, Type> createActualTypeMap(TypeVariable[] typeVariableArr, Type[] typeArr) {
        int length = typeVariableArr.length;
        HashMap hashMap = new HashMap(length);
        for (int i = 0; i < length; i++) {
            hashMap.put(typeVariableArr[i], typeArr[i]);
        }
        return hashMap;
    }

    public static Collection createCollection(Type type) {
        Class<?> rawClass = getRawClass(type);
        if (rawClass == AbstractCollection.class || rawClass == Collection.class) {
            return new ArrayList();
        }
        if (rawClass.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (rawClass.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (rawClass.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (rawClass.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (rawClass.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        } else if (rawClass.isAssignableFrom(Queue.class) || rawClass.isAssignableFrom(Deque.class)) {
            return new LinkedList();
        } else {
            try {
                return (Collection) rawClass.newInstance();
            } catch (Exception unused) {
                throw new JSONException("create instance error, class " + rawClass.getName());
            }
        }
    }

    public static String decapitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static long fnv1a_64(String str) {
        long j = -3750763034362895579L;
        for (int i = 0; i < str.length(); i++) {
            j = (j ^ ((long) str.charAt(i))) * 1099511628211L;
        }
        return j;
    }

    public static long fnv1a_64_lower(String str) {
        long j = -3750763034362895579L;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!(charAt == '_' || charAt == '-')) {
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = (char) (charAt + ' ');
                }
                j = (j ^ ((long) charAt)) * 1099511628211L;
            }
        }
        return j;
    }

    private static Type getActualType(Type type, Map<TypeVariable, Type> map) {
        return type instanceof TypeVariable ? map.get(type) : type instanceof ParameterizedType ? makeParameterizedType(getRawClass(type), ((ParameterizedType) type).getActualTypeArguments(), map) : type instanceof GenericArrayType ? new GenericArrayTypeImpl(getActualType(((GenericArrayType) type).getGenericComponentType(), map)) : type;
    }

    public static <A extends Annotation> A getAnnotation(Class<?> cls, Class<A> cls2) {
        A annotation = cls.getAnnotation(cls2);
        Type mixInAnnotations = JSON.getMixInAnnotations(cls);
        Class cls3 = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls3 != null) {
            A annotation2 = cls3.getAnnotation(cls2);
            if (annotation2 == null && cls3.getAnnotations().length > 0) {
                for (Annotation annotationType : cls3.getAnnotations()) {
                    annotation2 = annotationType.annotationType().getAnnotation(cls2);
                    if (annotation2 != null) {
                        break;
                    }
                }
            }
            if (annotation2 != null) {
                return annotation2;
            }
        }
        if (annotation == null && cls.getAnnotations().length > 0) {
            for (Annotation annotationType2 : cls.getAnnotations()) {
                annotation = annotationType2.annotationType().getAnnotation(cls2);
                if (annotation != null) {
                    break;
                }
            }
        }
        return annotation;
    }

    public static Class<?> getClass(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            Type type2 = ((TypeVariable) type).getBounds()[0];
            return type2 instanceof Class ? (Class) type2 : getClass(type2);
        } else if (!(type instanceof WildcardType)) {
            return Object.class;
        } else {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            return upperBounds.length == 1 ? getClass(upperBounds[0]) : Object.class;
        }
    }

    public static Class<?> getClassFromMapping(String str) {
        return mappings.get(str);
    }

    public static Class<?> getCollectionItemClass(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        if (type2 instanceof Class) {
            Class<?> cls = (Class) type2;
            if (Modifier.isPublic(cls.getModifiers())) {
                return cls;
            }
            throw new JSONException("can not create ASMParser");
        }
        throw new JSONException("can not create ASMParser");
    }

    public static Type getCollectionItemType(Type type) {
        if (type instanceof ParameterizedType) {
            return getCollectionItemType((ParameterizedType) type);
        }
        if (type instanceof Class) {
            return getCollectionItemType((Class<?>) (Class) type);
        }
        return Object.class;
    }

    private static Type getCollectionSuperType(Class<?> cls) {
        Type type = null;
        for (Type type2 : cls.getGenericInterfaces()) {
            Class<?> rawClass = getRawClass(type2);
            Class<Collection> cls2 = Collection.class;
            if (rawClass == cls2) {
                return type2;
            }
            if (cls2.isAssignableFrom(rawClass)) {
                type = type2;
            }
        }
        return type == null ? cls.getGenericSuperclass() : type;
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr) {
        char charAt;
        char charAt2;
        for (Field field : fieldArr) {
            String name = field.getName();
            if (str.equals(name)) {
                return field;
            }
            if (str.length() > 2 && (charAt = str.charAt(0)) >= 'a' && charAt <= 'z' && (charAt2 = str.charAt(1)) >= 'A' && charAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return getField(superclass, str, superclass.getDeclaredFields());
    }

    private static List<FieldInfo> getFieldInfos(Class<?> cls, boolean z, Map<String, FieldInfo> map) {
        ArrayList arrayList = new ArrayList();
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        String[] orders = jSONType != null ? jSONType.orders() : null;
        if (orders == null || orders.length <= 0) {
            for (FieldInfo add : map.values()) {
                arrayList.add(add);
            }
            if (z) {
                Collections.sort(arrayList);
            }
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap(arrayList.size());
            for (FieldInfo next : map.values()) {
                linkedHashMap.put(next.name, next);
            }
            for (String str : orders) {
                FieldInfo fieldInfo = (FieldInfo) linkedHashMap.get(str);
                if (fieldInfo != null) {
                    arrayList.add(fieldInfo);
                    linkedHashMap.remove(str);
                }
            }
            for (FieldInfo add2 : linkedHashMap.values()) {
                arrayList.add(add2);
            }
        }
        return arrayList;
    }

    public static Type getGenericParamType(Type type) {
        return (!(type instanceof ParameterizedType) && (type instanceof Class)) ? getGenericParamType(((Class) type).getGenericSuperclass()) : type;
    }

    public static Constructor getKoltinConstructor(Constructor[] constructorArr) {
        return getKoltinConstructor(constructorArr, (String[]) null);
    }

    public static String[] getKoltinConstructorParameters(Class cls) {
        Class<KClassImpl> cls2 = KClassImpl.class;
        if (kotlin_kclass_constructor == null && !kotlin_class_klass_error) {
            try {
                int i = KClassImpl.f3704a;
                kotlin_kclass_constructor = cls2.getConstructor(new Class[]{Class.class});
            } catch (Throwable unused) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kclass_constructor == null) {
            return null;
        }
        if (kotlin_kclass_getConstructors == null && !kotlin_class_klass_error) {
            try {
                int i2 = KClassImpl.f3704a;
                kotlin_kclass_getConstructors = cls2.getMethod("getConstructors", (Class[]) null);
            } catch (Throwable unused2) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kfunction_getParameters == null && !kotlin_class_klass_error) {
            try {
                kotlin_kfunction_getParameters = KFunction.class.getMethod("getParameters", (Class[]) null);
            } catch (Throwable unused3) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kparameter_getName == null && !kotlin_class_klass_error) {
            try {
                kotlin_kparameter_getName = KParameter.class.getMethod("getName", (Class[]) null);
            } catch (Throwable unused4) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_error) {
            return null;
        }
        try {
            Iterator it = ((Iterable) kotlin_kclass_getConstructors.invoke(kotlin_kclass_constructor.newInstance(new Object[]{cls}), (Object[]) null)).iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object next = it.next();
                List list = (List) kotlin_kfunction_getParameters.invoke(next, (Object[]) null);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it.hasNext();
            }
            if (obj == null) {
                return null;
            }
            List list2 = (List) kotlin_kfunction_getParameters.invoke(obj, (Object[]) null);
            String[] strArr = new String[list2.size()];
            for (int i3 = 0; i3 < list2.size(); i3++) {
                strArr[i3] = (String) kotlin_kparameter_getName.invoke(list2.get(i3), (Object[]) null);
            }
            return strArr;
        } catch (Throwable th) {
            th.printStackTrace();
            kotlin_error = true;
            return null;
        }
    }

    public static Annotation[][] getParameterAnnotations(Method method) {
        Annotation[][] parameterAnnotations;
        Annotation[][] parameterAnnotations2 = method.getParameterAnnotations();
        Type mixInAnnotations = JSON.getMixInAnnotations(method.getDeclaringClass());
        Method method2 = null;
        Class<? super Object> cls = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls != null) {
            String name = method.getName();
            Class[] parameterTypes = method.getParameterTypes();
            while (true) {
                if (cls == null || cls == Object.class) {
                    break;
                }
                try {
                    method2 = cls.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (NoSuchMethodException unused) {
                    cls = cls.getSuperclass();
                }
            }
            if (!(method2 == null || (parameterAnnotations = method2.getParameterAnnotations()) == null)) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    public static int getParserFeatures(Class<?> cls) {
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return Feature.of(jSONType.parseFeatures());
    }

    private static String getPropertyNameByCompatibleFieldName(Map<String, Field> map, String str, String str2, int i) {
        if (!compatibleWithFieldName || map.containsKey(str2)) {
            return str2;
        }
        String substring = str.substring(i);
        return map.containsKey(substring) ? substring : str2;
    }

    public static Class<?> getRawClass(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getRawClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return getRawClass(upperBounds[0]);
            }
            throw new JSONException("TODO");
        }
        throw new JSONException("TODO");
    }

    public static int getSerializeFeatures(Class<?> cls) {
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return SerializerFeature.of(jSONType.serialzeFeatures());
    }

    public static JSONField getSuperMethodAnnotation(Class<?> cls, Method method) {
        Class[] interfaces = cls.getInterfaces();
        Class<JSONField> cls2 = JSONField.class;
        if (interfaces.length > 0) {
            Class[] parameterTypes = method.getParameterTypes();
            for (Class methods : interfaces) {
                for (Method method2 : methods.getMethods()) {
                    Class[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        int i = 0;
                        while (true) {
                            if (i >= parameterTypes.length) {
                                JSONField jSONField = (JSONField) getAnnotation(method2, cls2);
                                if (jSONField != null) {
                                    return jSONField;
                                }
                            } else if (!parameterTypes2[i].equals(parameterTypes[i])) {
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= parameterTypes3.length) {
                            JSONField jSONField2 = (JSONField) getAnnotation(method3, cls2);
                            if (jSONField2 != null) {
                                return jSONField2;
                            }
                        } else if (!parameterTypes4[i2].equals(parameterTypes3[i2])) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
        }
        return null;
    }

    private static Type getWildcardTypeUpperBounds(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length > 0 ? upperBounds[0] : Object.class;
    }

    public static Annotation getXmlAccessorType(Class cls) {
        if (class_XmlAccessorType == null && !classXmlAccessorType_error) {
            try {
                class_XmlAccessorType = Class.forName("javax.xml.bind.annotation.XmlAccessorType");
            } catch (Throwable unused) {
                classXmlAccessorType_error = true;
            }
        }
        if (class_XmlAccessorType == null) {
            return null;
        }
        return getAnnotation((Class<?>) cls, class_XmlAccessorType);
    }

    public static int intValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0;
        }
        int scale = bigDecimal.scale();
        return (scale < -100 || scale > 100) ? bigDecimal.intValueExact() : bigDecimal.intValue();
    }

    public static boolean isAnnotationPresentManyToMany(Method method) {
        if (method == null) {
            return false;
        }
        if (class_ManyToMany == null && !class_ManyToMany_error) {
            try {
                class_ManyToMany = Class.forName("javax.persistence.ManyToMany");
            } catch (Throwable unused) {
                class_ManyToMany_error = true;
            }
        }
        if (class_ManyToMany != null) {
            return method.isAnnotationPresent(class_OneToMany) || method.isAnnotationPresent(class_ManyToMany);
        }
        return false;
    }

    public static boolean isAnnotationPresentOneToMany(Method method) {
        if (method == null) {
            return false;
        }
        if (class_OneToMany == null && !class_OneToMany_error) {
            try {
                class_OneToMany = Class.forName("javax.persistence.OneToMany");
            } catch (Throwable unused) {
                class_OneToMany_error = true;
            }
        }
        Class<? extends Annotation> cls = class_OneToMany;
        return cls != null && method.isAnnotationPresent(cls);
    }

    public static boolean isClob(Class cls) {
        if (class_Clob == null && !class_Clob_error) {
            try {
                class_Clob = Clob.class;
            } catch (Throwable unused) {
                class_Clob_error = true;
            }
        }
        if (class_Clob == null) {
            return false;
        }
        return class_Clob.isAssignableFrom(cls);
    }

    public static boolean isGenericParamType(Type type) {
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Type genericSuperclass = ((Class) type).getGenericSuperclass();
        return genericSuperclass != Object.class && isGenericParamType(genericSuperclass);
    }

    public static boolean isHibernateInitialized(Object obj) {
        if (obj == null) {
            return false;
        }
        if (method_HibernateIsInitialized == null && !method_HibernateIsInitialized_error) {
            try {
                method_HibernateIsInitialized = Class.forName("org.hibernate.Hibernate").getMethod("isInitialized", new Class[]{Object.class});
            } catch (Throwable unused) {
                method_HibernateIsInitialized_error = true;
            }
        }
        Method method = method_HibernateIsInitialized;
        if (method != null) {
            try {
                return ((Boolean) method.invoke((Object) null, new Object[]{obj})).booleanValue();
            } catch (Throwable unused2) {
            }
        }
        return true;
    }

    private static boolean isJSONTypeIgnore(Class<?> cls, String str) {
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType != null) {
            String[] includes = jSONType.includes();
            if (includes.length > 0) {
                for (String equals : includes) {
                    if (str.equals(equals)) {
                        return false;
                    }
                }
                return true;
            }
            String[] ignores = jSONType.ignores();
            for (String equals2 : ignores) {
                if (str.equals(equals2)) {
                    return true;
                }
            }
        }
        if (cls.getSuperclass() == Object.class || cls.getSuperclass() == null) {
            return false;
        }
        return isJSONTypeIgnore(cls.getSuperclass(), str);
    }

    public static boolean isJacksonCreator(Method method) {
        if (method == null) {
            return false;
        }
        if (class_JacksonCreator == null && !class_JacksonCreator_error) {
            try {
                class_JacksonCreator = JsonCreator.class;
            } catch (Throwable unused) {
                class_JacksonCreator_error = true;
            }
        }
        Class<? extends Annotation> cls = class_JacksonCreator;
        return cls != null && method.isAnnotationPresent(cls);
    }

    public static boolean isKotlin(Class cls) {
        if (kotlin_metadata == null && !kotlin_metadata_error) {
            try {
                kotlin_metadata = Metadata.class;
            } catch (Throwable unused) {
                kotlin_metadata_error = true;
            }
        }
        return kotlin_metadata != null && cls.isAnnotationPresent(kotlin_metadata);
    }

    private static boolean isKotlinIgnore(Class cls, String str) {
        if (kotlinIgnores == null && !kotlinIgnores_error) {
            try {
                HashMap hashMap = new HashMap();
                CharRange.Companion companion = CharRange.Companion;
                hashMap.put(CharRange.class, new String[]{"getEndInclusive", "isEmpty"});
                IntRange.Companion companion2 = IntRange.Companion;
                hashMap.put(IntRange.class, new String[]{"getEndInclusive", "isEmpty"});
                LongRange.Companion companion3 = LongRange.Companion;
                hashMap.put(LongRange.class, new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.ClosedFloatRange"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.ClosedDoubleRange"), new String[]{"getEndInclusive", "isEmpty"});
                kotlinIgnores = hashMap;
            } catch (Throwable unused) {
                kotlinIgnores_error = true;
            }
        }
        if (kotlinIgnores == null) {
            return false;
        }
        String[] strArr = kotlinIgnores.get(cls);
        return strArr != null && Arrays.binarySearch(strArr, str) >= 0;
    }

    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '+' || charAt == '-') {
                if (i != 0) {
                    return false;
                }
            } else if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isPath(Class<?> cls) {
        if (pathClass == null && !pathClass_error) {
            try {
                pathClass = Path.class;
            } catch (Throwable unused) {
                pathClass_error = true;
            }
        }
        Class<?> cls2 = pathClass;
        if (cls2 != null) {
            return cls2.isAssignableFrom(cls);
        }
        return false;
    }

    public static boolean isProxy(Class<?> cls) {
        for (Class name : cls.getInterfaces()) {
            String name2 = name.getName();
            if (name2.equals("net.sf.cglib.proxy.Factory") || name2.equals("org.springframework.cglib.proxy.Factory") || name2.equals("javassist.util.proxy.ProxyObject") || name2.equals("org.apache.ibatis.javassist.util.proxy.ProxyObject") || name2.equals("org.hibernate.proxy.HibernateProxy")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTransient(Method method) {
        if (method == null) {
            return false;
        }
        if (!transientClassInited) {
            try {
                transientClass = Class.forName("java.beans.Transient");
            } catch (Exception unused) {
            } catch (Throwable th) {
                transientClassInited = true;
                throw th;
            }
            transientClassInited = true;
        }
        Class<? extends Annotation> cls = transientClass;
        return (cls == null || getAnnotation(method, cls) == null) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x004e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isXmlField(java.lang.Class r5) {
        /*
            java.lang.Class r0 = class_XmlAccessorType
            r1 = 1
            if (r0 != 0) goto L_0x0014
            boolean r0 = classXmlAccessorType_error
            if (r0 != 0) goto L_0x0014
            java.lang.String r0 = "javax.xml.bind.annotation.XmlAccessorType"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x0012 }
            class_XmlAccessorType = r0     // Catch:{ all -> 0x0012 }
            goto L_0x0014
        L_0x0012:
            classXmlAccessorType_error = r1
        L_0x0014:
            java.lang.Class r0 = class_XmlAccessorType
            r2 = 0
            if (r0 != 0) goto L_0x001a
            return r2
        L_0x001a:
            java.lang.Class r0 = class_XmlAccessorType
            java.lang.annotation.Annotation r5 = getAnnotation((java.lang.Class<?>) r5, r0)
            if (r5 != 0) goto L_0x0023
            return r2
        L_0x0023:
            java.lang.reflect.Method r0 = method_XmlAccessorType_value
            r3 = 0
            if (r0 != 0) goto L_0x0039
            boolean r0 = classXmlAccessorType_error
            if (r0 != 0) goto L_0x0039
            java.lang.Class r0 = class_XmlAccessorType     // Catch:{ all -> 0x0037 }
            java.lang.String r4 = "value"
            java.lang.reflect.Method r0 = r0.getMethod(r4, r3)     // Catch:{ all -> 0x0037 }
            method_XmlAccessorType_value = r0     // Catch:{ all -> 0x0037 }
            goto L_0x0039
        L_0x0037:
            classXmlAccessorType_error = r1
        L_0x0039:
            java.lang.reflect.Method r0 = method_XmlAccessorType_value
            if (r0 != 0) goto L_0x003e
            return r2
        L_0x003e:
            boolean r0 = classXmlAccessorType_error
            if (r0 != 0) goto L_0x004b
            java.lang.reflect.Method r0 = method_XmlAccessorType_value     // Catch:{ all -> 0x0049 }
            java.lang.Object r5 = r0.invoke(r5, r3)     // Catch:{ all -> 0x0049 }
            goto L_0x004c
        L_0x0049:
            classXmlAccessorType_error = r1
        L_0x004b:
            r5 = r3
        L_0x004c:
            if (r5 != 0) goto L_0x004f
            return r2
        L_0x004f:
            java.lang.Class r0 = class_XmlAccessType
            if (r0 != 0) goto L_0x0074
            boolean r0 = classXmlAccessorType_error
            if (r0 != 0) goto L_0x0074
            java.lang.String r0 = "javax.xml.bind.annotation.XmlAccessType"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x0072 }
            class_XmlAccessType = r0     // Catch:{ all -> 0x0072 }
            java.lang.Class r0 = class_XmlAccessType     // Catch:{ all -> 0x0072 }
            java.lang.String r4 = "FIELD"
            java.lang.reflect.Field r0 = r0.getField(r4)     // Catch:{ all -> 0x0072 }
            field_XmlAccessType_FIELD = r0     // Catch:{ all -> 0x0072 }
            java.lang.reflect.Field r0 = field_XmlAccessType_FIELD     // Catch:{ all -> 0x0072 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0072 }
            field_XmlAccessType_FIELD_VALUE = r0     // Catch:{ all -> 0x0072 }
            goto L_0x0074
        L_0x0072:
            classXmlAccessorType_error = r1
        L_0x0074:
            java.lang.Object r0 = field_XmlAccessType_FIELD_VALUE
            if (r5 != r0) goto L_0x0079
            goto L_0x007a
        L_0x0079:
            r1 = r2
        L_0x007a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.isXmlField(java.lang.Class):boolean");
    }

    public static Class<?> loadClass(String str) {
        return loadClass(str, (ClassLoader) null);
    }

    public static long longExtractValue(Number number) {
        return number instanceof BigDecimal ? ((BigDecimal) number).longValueExact() : number.longValue();
    }

    public static long longValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0;
        }
        int scale = bigDecimal.scale();
        return (scale < -100 || scale > 100) ? bigDecimal.longValueExact() : bigDecimal.longValue();
    }

    private static ParameterizedType makeParameterizedType(Class<?> cls, Type[] typeArr, Map<TypeVariable, Type> map) {
        int length = typeArr.length;
        Type[] typeArr2 = new Type[length];
        for (int i = 0; i < length; i++) {
            typeArr2[i] = getActualType(typeArr[i], map);
        }
        return new ParameterizedTypeImpl(typeArr2, (Type) null, cls);
    }

    public static int num(char c, char c2) {
        if (c < '0' || c > '9' || c2 < '0' || c2 > '9') {
            return -1;
        }
        return ((c - '0') * 10) + (c2 - '0');
    }

    public static double parseDouble(String str) {
        double d;
        double d2;
        int length = str.length();
        if (length > 10) {
            return Double.parseDouble(str);
        }
        long j = 0;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '-' && i2 == 0) {
                z = true;
            } else if (charAt == '.') {
                if (i != 0) {
                    return Double.parseDouble(str);
                }
                i = (length - i2) - 1;
            } else if (charAt < '0' || charAt > '9') {
                return Double.parseDouble(str);
            } else {
                j = (j * 10) + ((long) (charAt - '0'));
            }
        }
        if (z) {
            j = -j;
        }
        switch (i) {
            case 0:
                return (double) j;
            case 1:
                d = (double) j;
                d2 = 10.0d;
                break;
            case 2:
                d = (double) j;
                d2 = 100.0d;
                break;
            case 3:
                d = (double) j;
                d2 = 1000.0d;
                break;
            case 4:
                d = (double) j;
                d2 = 10000.0d;
                break;
            case 5:
                d = (double) j;
                d2 = 100000.0d;
                break;
            case 6:
                d = (double) j;
                d2 = 1000000.0d;
                break;
            case 7:
                d = (double) j;
                d2 = 1.0E7d;
                break;
            case 8:
                d = (double) j;
                d2 = 1.0E8d;
                break;
            case 9:
                d = (double) j;
                d2 = 1.0E9d;
                break;
            default:
                return Double.parseDouble(str);
        }
        return d / d2;
    }

    public static float parseFloat(String str) {
        float f;
        float f2;
        int length = str.length();
        if (length >= 10) {
            return Float.parseFloat(str);
        }
        long j = 0;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '-' && i2 == 0) {
                z = true;
            } else if (charAt == '.') {
                if (i != 0) {
                    return Float.parseFloat(str);
                }
                i = (length - i2) - 1;
            } else if (charAt < '0' || charAt > '9') {
                return Float.parseFloat(str);
            } else {
                j = (j * 10) + ((long) (charAt - '0'));
            }
        }
        if (z) {
            j = -j;
        }
        switch (i) {
            case 0:
                return (float) j;
            case 1:
                f = (float) j;
                f2 = 10.0f;
                break;
            case 2:
                f = (float) j;
                f2 = 100.0f;
                break;
            case 3:
                f = (float) j;
                f2 = 1000.0f;
                break;
            case 4:
                f = (float) j;
                f2 = 10000.0f;
                break;
            case 5:
                f = (float) j;
                f2 = 100000.0f;
                break;
            case 6:
                f = (float) j;
                f2 = 1000000.0f;
                break;
            case 7:
                f = (float) j;
                f2 = 1.0E7f;
                break;
            case 8:
                f = (float) j;
                f2 = 1.0E8f;
                break;
            case 9:
                f = (float) j;
                f2 = 1.0E9f;
                break;
            default:
                return Float.parseFloat(str);
        }
        return f / f2;
    }

    public static void setAccessible(AccessibleObject accessibleObject) {
        if (setAccessibleEnable && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (AccessControlException unused) {
                setAccessibleEnable = false;
            }
        }
    }

    public static short shortValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0;
        }
        int scale = bigDecimal.scale();
        return (scale < -100 || scale > 100) ? bigDecimal.shortValueExact() : bigDecimal.shortValue();
    }

    public static Locale toLocale(String str) {
        String[] split = str.split(AccountConstantKt.DEFAULT_SEGMENT);
        return split.length == 1 ? new Locale(split[0]) : split.length == 2 ? new Locale(split[0], split[1]) : new Locale(split[0], split[1], split[2]);
    }

    public static Type unwrapOptional(Type type) {
        if (!optionalClassInited) {
            try {
                optionalClass = Class.forName("java.util.Optional");
            } catch (Exception unused) {
            } catch (Throwable th) {
                optionalClassInited = true;
                throw th;
            }
            optionalClassInited = true;
        }
        if (!(type instanceof ParameterizedType)) {
            return type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return parameterizedType.getRawType() == optionalClass ? parameterizedType.getActualTypeArguments()[0] : type;
    }

    /* JADX WARNING: type inference failed for: r16v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alibaba.fastjson.serializer.SerializeBeanInfo buildBeanInfo(java.lang.Class<?> r16, java.util.Map<java.lang.String, java.lang.String> r17, com.alibaba.fastjson.PropertyNamingStrategy r18, boolean r19) {
        /*
            r6 = r16
            r7 = r17
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r0 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r1 = getAnnotation((java.lang.Class<?>) r6, r0)
            r8 = r1
            com.alibaba.fastjson.annotation.JSONType r8 = (com.alibaba.fastjson.annotation.JSONType) r8
            r1 = 0
            r2 = 0
            if (r8 == 0) goto L_0x0087
            java.lang.String[] r3 = r8.orders()
            java.lang.String r4 = r8.typeName()
            int r5 = r4.length()
            if (r5 != 0) goto L_0x0020
            r4 = r2
        L_0x0020:
            com.alibaba.fastjson.PropertyNamingStrategy r5 = r8.naming()
            com.alibaba.fastjson.PropertyNamingStrategy r9 = com.alibaba.fastjson.PropertyNamingStrategy.CamelCase
            if (r5 == r9) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r5 = r18
        L_0x002b:
            com.alibaba.fastjson.serializer.SerializerFeature[] r9 = r8.serialzeFeatures()
            int r9 = com.alibaba.fastjson.serializer.SerializerFeature.of(r9)
            java.lang.Class r10 = r16.getSuperclass()
            r11 = r2
        L_0x0038:
            if (r10 == 0) goto L_0x0057
            java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
            if (r10 == r12) goto L_0x0057
            java.lang.annotation.Annotation r12 = getAnnotation((java.lang.Class<?>) r10, r0)
            com.alibaba.fastjson.annotation.JSONType r12 = (com.alibaba.fastjson.annotation.JSONType) r12
            if (r12 != 0) goto L_0x0047
            goto L_0x0057
        L_0x0047:
            java.lang.String r11 = r12.typeKey()
            int r12 = r11.length()
            if (r12 == 0) goto L_0x0052
            goto L_0x0057
        L_0x0052:
            java.lang.Class r10 = r10.getSuperclass()
            goto L_0x0038
        L_0x0057:
            java.lang.Class[] r10 = r16.getInterfaces()
            int r12 = r10.length
            r13 = r1
        L_0x005d:
            if (r13 >= r12) goto L_0x0077
            r14 = r10[r13]
            java.lang.annotation.Annotation r14 = getAnnotation((java.lang.Class<?>) r14, r0)
            com.alibaba.fastjson.annotation.JSONType r14 = (com.alibaba.fastjson.annotation.JSONType) r14
            if (r14 == 0) goto L_0x0074
            java.lang.String r11 = r14.typeKey()
            int r14 = r11.length()
            if (r14 == 0) goto L_0x0074
            goto L_0x0077
        L_0x0074:
            int r13 = r13 + 1
            goto L_0x005d
        L_0x0077:
            if (r11 == 0) goto L_0x0080
            int r0 = r11.length()
            if (r0 != 0) goto L_0x0080
            goto L_0x0081
        L_0x0080:
            r2 = r11
        L_0x0081:
            r11 = r2
            r10 = r4
            r12 = r5
            r13 = r9
            r9 = r3
            goto L_0x008d
        L_0x0087:
            r12 = r18
            r13 = r1
            r9 = r2
            r10 = r9
            r11 = r10
        L_0x008d:
            java.util.HashMap r14 = new java.util.HashMap
            r14.<init>()
            com.alibaba.fastjson.parser.ParserConfig.parserAllFieldToCache(r6, r14)
            if (r19 == 0) goto L_0x009c
            java.util.List r0 = computeGettersWithFieldBase(r6, r7, r1, r12)
            goto L_0x00a8
        L_0x009c:
            r4 = 0
            r0 = r16
            r1 = r8
            r2 = r17
            r3 = r14
            r5 = r12
            java.util.List r0 = computeGetters(r0, r1, r2, r3, r4, r5)
        L_0x00a8:
            int r1 = r0.size()
            com.alibaba.fastjson.util.FieldInfo[] r15 = new com.alibaba.fastjson.util.FieldInfo[r1]
            r0.toArray(r15)
            if (r9 == 0) goto L_0x00cb
            int r1 = r9.length
            if (r1 == 0) goto L_0x00cb
            if (r19 == 0) goto L_0x00be
            r0 = 1
            java.util.List r0 = computeGettersWithFieldBase(r6, r7, r0, r12)
            goto L_0x00d4
        L_0x00be:
            r4 = 1
            r0 = r16
            r1 = r8
            r2 = r17
            r3 = r14
            r5 = r12
            java.util.List r0 = computeGetters(r0, r1, r2, r3, r4, r5)
            goto L_0x00d4
        L_0x00cb:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            java.util.Collections.sort(r1)
            r0 = r1
        L_0x00d4:
            int r1 = r0.size()
            com.alibaba.fastjson.util.FieldInfo[] r1 = new com.alibaba.fastjson.util.FieldInfo[r1]
            r0.toArray(r1)
            boolean r0 = java.util.Arrays.equals(r1, r15)
            if (r0 == 0) goto L_0x00e5
            r7 = r15
            goto L_0x00e6
        L_0x00e5:
            r7 = r1
        L_0x00e6:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r9 = new com.alibaba.fastjson.serializer.SerializeBeanInfo
            r0 = r9
            r1 = r16
            r2 = r8
            r3 = r10
            r4 = r11
            r5 = r13
            r6 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.buildBeanInfo(java.lang.Class, java.util.Map, com.alibaba.fastjson.PropertyNamingStrategy, boolean):com.alibaba.fastjson.serializer.SerializeBeanInfo");
    }

    public static Date castToDate(Object obj, String str) {
        long j;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof BigDecimal) {
            return new Date(longValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            long longValue = ((Number) obj).longValue();
            if ("unixtime".equals(str)) {
                longValue *= 1000;
            }
            return new Date(longValue);
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            JSONScanner jSONScanner = new JSONScanner(str2);
            try {
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    return jSONScanner.getCalendar().getTime();
                }
                jSONScanner.close();
                if (str2.startsWith("/Date(") && str2.endsWith(")/")) {
                    str2 = str2.substring(6, str2.length() - 2);
                }
                if (str2.indexOf(45) > 0 || str2.indexOf(43) > 0) {
                    if (str == null) {
                        if (str2.length() == JSON.DEFFAULT_DATE_FORMAT.length() || (str2.length() == 22 && JSON.DEFFAULT_DATE_FORMAT.equals("yyyyMMddHHmmssSSSZ"))) {
                            str = JSON.DEFFAULT_DATE_FORMAT;
                        } else if (str2.length() == 10) {
                            str = "yyyy-MM-dd";
                        } else if (str2.length() == 19) {
                            str = "yyyy-MM-dd HH:mm:ss";
                        } else if (str2.length() == 29 && str2.charAt(26) == ':' && str2.charAt(28) == '0') {
                            str = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
                        } else if (str2.length() == 23 && str2.charAt(19) == ',') {
                            str = "yyyy-MM-dd HH:mm:ss,SSS";
                        } else {
                            str = "yyyy-MM-dd HH:mm:ss.SSS";
                        }
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, JSON.defaultLocale);
                    simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                    try {
                        return simpleDateFormat.parse(str2);
                    } catch (ParseException unused) {
                        throw new JSONException("can not cast to Date, value : " + str2);
                    }
                } else if (str2.length() == 0) {
                    return null;
                } else {
                    j = Long.parseLong(str2);
                }
            } finally {
                jSONScanner.close();
            }
        } else {
            j = -1;
        }
        if (j != -1) {
            return new Date(j);
        }
        Class<?> cls = obj.getClass();
        if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
            if (oracleTimestampMethod == null && !oracleTimestampMethodInited) {
                try {
                    oracleTimestampMethod = cls.getMethod("toJdbc", (Class[]) null);
                } catch (NoSuchMethodException unused2) {
                } catch (Throwable th) {
                    oracleTimestampMethodInited = true;
                    throw th;
                }
                oracleTimestampMethodInited = true;
            }
            try {
                return (Date) oracleTimestampMethod.invoke(obj, (Object[]) null);
            } catch (Exception e) {
                throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", e);
            }
        } else if ("oracle.sql.DATE".equals(cls.getName())) {
            if (oracleDateMethod == null && !oracleDateMethodInited) {
                try {
                    oracleDateMethod = cls.getMethod("toJdbc", (Class[]) null);
                } catch (NoSuchMethodException unused3) {
                } catch (Throwable th2) {
                    oracleDateMethodInited = true;
                    throw th2;
                }
                oracleDateMethodInited = true;
            }
            try {
                return (Date) oracleDateMethod.invoke(obj, (Object[]) null);
            } catch (Exception e2) {
                throw new JSONException("can not cast oracle.sql.DATE to Date", e2);
            }
        } else {
            throw new JSONException("can not cast to Date, value : " + obj);
        }
    }

    /* JADX WARNING: type inference failed for: r0v10, types: [com.alibaba.fastjson.parser.deserializer.ObjectDeserializer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T castToJavaBean(java.util.Map<java.lang.String, java.lang.Object> r4, java.lang.Class<T> r5, com.alibaba.fastjson.parser.ParserConfig r6) {
        /*
            java.lang.Class<java.lang.StackTraceElement> r0 = java.lang.StackTraceElement.class
            if (r5 != r0) goto L_0x0040
            java.lang.String r5 = "className"
            java.lang.Object r5 = r4.get(r5)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0033 }
            java.lang.String r6 = "methodName"
            java.lang.Object r6 = r4.get(r6)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0033 }
            java.lang.String r0 = "fileName"
            java.lang.Object r0 = r4.get(r0)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0033 }
            java.lang.String r1 = "lineNumber"
            java.lang.Object r4 = r4.get(r1)     // Catch:{ Exception -> 0x0033 }
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ Exception -> 0x0033 }
            if (r4 != 0) goto L_0x0028
            r4 = 0
            goto L_0x003a
        L_0x0028:
            boolean r1 = r4 instanceof java.math.BigDecimal     // Catch:{ Exception -> 0x0033 }
            if (r1 == 0) goto L_0x0036
            java.math.BigDecimal r4 = (java.math.BigDecimal) r4     // Catch:{ Exception -> 0x0033 }
            int r4 = r4.intValueExact()     // Catch:{ Exception -> 0x0033 }
            goto L_0x003a
        L_0x0033:
            r4 = move-exception
            goto L_0x0152
        L_0x0036:
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0033 }
        L_0x003a:
            java.lang.StackTraceElement r1 = new java.lang.StackTraceElement     // Catch:{ Exception -> 0x0033 }
            r1.<init>(r5, r6, r0, r4)     // Catch:{ Exception -> 0x0033 }
            return r1
        L_0x0040:
            java.lang.String r0 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ Exception -> 0x0033 }
            java.lang.Object r0 = r4.get(r0)     // Catch:{ Exception -> 0x0033 }
            boolean r1 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x0033 }
            r2 = 0
            if (r1 == 0) goto L_0x0079
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0033 }
            if (r6 != 0) goto L_0x0051
            com.alibaba.fastjson.parser.ParserConfig r6 = com.alibaba.fastjson.parser.ParserConfig.global     // Catch:{ Exception -> 0x0033 }
        L_0x0051:
            java.lang.Class r1 = r6.checkAutoType(r0, r2)     // Catch:{ Exception -> 0x0033 }
            if (r1 == 0) goto L_0x0062
            boolean r0 = r1.equals(r5)     // Catch:{ Exception -> 0x0033 }
            if (r0 != 0) goto L_0x0079
            java.lang.Object r4 = castToJavaBean(r4, r1, r6)     // Catch:{ Exception -> 0x0033 }
            return r4
        L_0x0062:
            java.lang.ClassNotFoundException r4 = new java.lang.ClassNotFoundException     // Catch:{ Exception -> 0x0033 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0033 }
            r5.<init>()     // Catch:{ Exception -> 0x0033 }
            r5.append(r0)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r6 = " not found"
            r5.append(r6)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0033 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0033 }
            throw r4     // Catch:{ Exception -> 0x0033 }
        L_0x0079:
            boolean r0 = r5.isInterface()     // Catch:{ Exception -> 0x0033 }
            if (r0 == 0) goto L_0x00b2
            boolean r0 = r4 instanceof com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x0033 }
            if (r0 == 0) goto L_0x0086
            com.alibaba.fastjson.JSONObject r4 = (com.alibaba.fastjson.JSONObject) r4     // Catch:{ Exception -> 0x0033 }
            goto L_0x008c
        L_0x0086:
            com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x0033 }
            r0.<init>((java.util.Map<java.lang.String, java.lang.Object>) r4)     // Catch:{ Exception -> 0x0033 }
            r4 = r0
        L_0x008c:
            if (r6 != 0) goto L_0x0092
            com.alibaba.fastjson.parser.ParserConfig r6 = com.alibaba.fastjson.parser.ParserConfig.getGlobalInstance()     // Catch:{ Exception -> 0x0033 }
        L_0x0092:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r6 = r6.get(r5)     // Catch:{ Exception -> 0x0033 }
            if (r6 == 0) goto L_0x00a1
            java.lang.String r4 = com.alibaba.fastjson.JSON.toJSONString(r4)     // Catch:{ Exception -> 0x0033 }
            java.lang.Object r4 = com.alibaba.fastjson.JSON.parseObject((java.lang.String) r4, r5)     // Catch:{ Exception -> 0x0033 }
            return r4
        L_0x00a1:
            java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x0033 }
            java.lang.ClassLoader r6 = r6.getContextClassLoader()     // Catch:{ Exception -> 0x0033 }
            java.lang.Class[] r5 = new java.lang.Class[]{r5}     // Catch:{ Exception -> 0x0033 }
            java.lang.Object r4 = java.lang.reflect.Proxy.newProxyInstance(r6, r5, r4)     // Catch:{ Exception -> 0x0033 }
            return r4
        L_0x00b2:
            java.lang.Class<java.util.Locale> r0 = java.util.Locale.class
            if (r5 != r0) goto L_0x00dc
            java.lang.String r0 = "language"
            java.lang.Object r0 = r4.get(r0)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r1 = "country"
            java.lang.Object r1 = r4.get(r1)     // Catch:{ Exception -> 0x0033 }
            boolean r3 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x0033 }
            if (r3 == 0) goto L_0x00dc
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0033 }
            boolean r3 = r1 instanceof java.lang.String     // Catch:{ Exception -> 0x0033 }
            if (r3 == 0) goto L_0x00d4
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0033 }
            java.util.Locale r4 = new java.util.Locale     // Catch:{ Exception -> 0x0033 }
            r4.<init>(r0, r1)     // Catch:{ Exception -> 0x0033 }
            return r4
        L_0x00d4:
            if (r1 != 0) goto L_0x00dc
            java.util.Locale r4 = new java.util.Locale     // Catch:{ Exception -> 0x0033 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0033 }
            return r4
        L_0x00dc:
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            if (r5 != r0) goto L_0x00e9
            boolean r0 = r4 instanceof com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x0033 }
            if (r0 == 0) goto L_0x00e9
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0033 }
            return r4
        L_0x00e9:
            java.lang.Class<com.alibaba.fastjson.JSON> r0 = com.alibaba.fastjson.JSON.class
            if (r5 != r0) goto L_0x00f2
            boolean r0 = r4 instanceof com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x0033 }
            if (r0 == 0) goto L_0x00f2
            return r4
        L_0x00f2:
            java.lang.Class<java.util.LinkedHashMap> r0 = java.util.LinkedHashMap.class
            if (r5 != r0) goto L_0x010e
            boolean r0 = r4 instanceof com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x0033 }
            if (r0 == 0) goto L_0x010e
            r0 = r4
            com.alibaba.fastjson.JSONObject r0 = (com.alibaba.fastjson.JSONObject) r0     // Catch:{ Exception -> 0x0033 }
            java.util.Map r0 = r0.getInnerMap()     // Catch:{ Exception -> 0x0033 }
            boolean r1 = r0 instanceof java.util.LinkedHashMap     // Catch:{ Exception -> 0x0033 }
            if (r1 == 0) goto L_0x0106
            return r0
        L_0x0106:
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x0033 }
            r1.<init>()     // Catch:{ Exception -> 0x0033 }
            r1.putAll(r0)     // Catch:{ Exception -> 0x0033 }
        L_0x010e:
            boolean r0 = r5.isInstance(r4)     // Catch:{ Exception -> 0x0033 }
            if (r0 == 0) goto L_0x0115
            return r4
        L_0x0115:
            java.lang.Class<com.alibaba.fastjson.JSONObject> r0 = com.alibaba.fastjson.JSONObject.class
            if (r5 != r0) goto L_0x011f
            com.alibaba.fastjson.JSONObject r5 = new com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x0033 }
            r5.<init>((java.util.Map<java.lang.String, java.lang.Object>) r4)     // Catch:{ Exception -> 0x0033 }
            return r5
        L_0x011f:
            if (r6 != 0) goto L_0x0125
            com.alibaba.fastjson.parser.ParserConfig r6 = com.alibaba.fastjson.parser.ParserConfig.getGlobalInstance()     // Catch:{ Exception -> 0x0033 }
        L_0x0125:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r6.getDeserializer((java.lang.reflect.Type) r5)     // Catch:{ Exception -> 0x0033 }
            boolean r1 = r0 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer     // Catch:{ Exception -> 0x0033 }
            if (r1 == 0) goto L_0x0130
            r2 = r0
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r2 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r2     // Catch:{ Exception -> 0x0033 }
        L_0x0130:
            if (r2 == 0) goto L_0x0137
            java.lang.Object r4 = r2.createInstance((java.util.Map<java.lang.String, java.lang.Object>) r4, (com.alibaba.fastjson.parser.ParserConfig) r6)     // Catch:{ Exception -> 0x0033 }
            return r4
        L_0x0137:
            com.alibaba.fastjson.JSONException r4 = new com.alibaba.fastjson.JSONException     // Catch:{ Exception -> 0x0033 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0033 }
            r6.<init>()     // Catch:{ Exception -> 0x0033 }
            java.lang.String r0 = "can not get javaBeanDeserializer. "
            r6.append(r0)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x0033 }
            r6.append(r5)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x0033 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0033 }
            throw r4     // Catch:{ Exception -> 0x0033 }
        L_0x0152:
            com.alibaba.fastjson.JSONException r5 = new com.alibaba.fastjson.JSONException
            java.lang.String r6 = r4.getMessage()
            r5.<init>(r6, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.castToJavaBean(java.util.Map, java.lang.Class, com.alibaba.fastjson.parser.ParserConfig):java.lang.Object");
    }

    public static List<FieldInfo> computeGetters(Class<?> cls, Map<String, String> map, boolean z) {
        HashMap hashMap = new HashMap();
        ParserConfig.parserAllFieldToCache(cls, hashMap);
        return computeGetters(cls, (JSONType) getAnnotation(cls, JSONType.class), map, hashMap, z, PropertyNamingStrategy.CamelCase);
    }

    public static Constructor getKoltinConstructor(Constructor[] constructorArr, String[] strArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            Class[] parameterTypes = constructor2.getParameterTypes();
            if ((strArr == null || parameterTypes.length == strArr.length) && ((parameterTypes.length <= 0 || !parameterTypes[parameterTypes.length - 1].getName().equals("kotlin.jvm.internal.DefaultConstructorMarker")) && (constructor == null || constructor.getParameterTypes().length < parameterTypes.length))) {
                constructor = constructor2;
            }
        }
        return constructor;
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader) {
        return loadClass(str, classLoader, false);
    }

    public static int num(char c, char c2, char c3, char c4) {
        if (c < '0' || c > '9' || c2 < '0' || c2 > '9' || c3 < '0' || c3 > '9' || c4 < '0' || c4 > '9') {
            return -1;
        }
        return ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0');
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0082 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0088 A[Catch:{ all -> 0x008d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Class<?> loadClass(java.lang.String r5, java.lang.ClassLoader r6, boolean r7) {
        /*
            if (r5 == 0) goto L_0x008e
            int r0 = r5.length()
            if (r0 == 0) goto L_0x008e
            int r0 = r5.length()
            r1 = 128(0x80, float:1.794E-43)
            if (r0 <= r1) goto L_0x0012
            goto L_0x008e
        L_0x0012:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r0 = mappings
            java.lang.Object r0 = r0.get(r5)
            java.lang.Class r0 = (java.lang.Class) r0
            if (r0 == 0) goto L_0x001d
            return r0
        L_0x001d:
            r1 = 0
            char r2 = r5.charAt(r1)
            r3 = 91
            r4 = 1
            if (r2 != r3) goto L_0x0038
            java.lang.String r5 = r5.substring(r4)
            java.lang.Class r5 = loadClass(r5, r6)
            java.lang.Object r5 = java.lang.reflect.Array.newInstance(r5, r1)
            java.lang.Class r5 = r5.getClass()
            return r5
        L_0x0038:
            java.lang.String r1 = "L"
            boolean r1 = r5.startsWith(r1)
            if (r1 == 0) goto L_0x0056
            java.lang.String r1 = ";"
            boolean r1 = r5.endsWith(r1)
            if (r1 == 0) goto L_0x0056
            int r7 = r5.length()
            int r7 = r7 - r4
            java.lang.String r5 = r5.substring(r4, r7)
            java.lang.Class r5 = loadClass(r5, r6)
            return r5
        L_0x0056:
            if (r6 == 0) goto L_0x006a
            java.lang.Class r0 = r6.loadClass(r5)     // Catch:{ all -> 0x0064 }
            if (r7 == 0) goto L_0x0066
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r1 = mappings     // Catch:{ all -> 0x0064 }
            r1.put(r5, r0)     // Catch:{ all -> 0x0064 }
            goto L_0x0066
        L_0x0064:
            r1 = move-exception
            goto L_0x0067
        L_0x0066:
            return r0
        L_0x0067:
            r1.printStackTrace()
        L_0x006a:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0082 }
            java.lang.ClassLoader r1 = r1.getContextClassLoader()     // Catch:{ all -> 0x0082 }
            if (r1 == 0) goto L_0x0082
            if (r1 == r6) goto L_0x0082
            java.lang.Class r0 = r1.loadClass(r5)     // Catch:{ all -> 0x0082 }
            if (r7 == 0) goto L_0x0081
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r6 = mappings     // Catch:{ all -> 0x0082 }
            r6.put(r5, r0)     // Catch:{ all -> 0x0082 }
        L_0x0081:
            return r0
        L_0x0082:
            java.lang.Class r0 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x008d }
            if (r7 == 0) goto L_0x008d
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r6 = mappings     // Catch:{ all -> 0x008d }
            r6.put(r5, r0)     // Catch:{ all -> 0x008d }
        L_0x008d:
            return r0
        L_0x008e:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.loadClass(java.lang.String, java.lang.ClassLoader, boolean):java.lang.Class");
    }

    public static int num(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9) {
        if (c < '0' || c > '9' || c2 < '0' || c2 > '9' || c3 < '0' || c3 > '9' || c4 < '0' || c4 > '9' || c5 < '0' || c5 > '9' || c6 < '0' || c6 > '9' || c7 < '0' || c7 > '9' || c8 < '0' || c8 > '9' || c9 < '0' || c9 > '9') {
            return -1;
        }
        return ((c - '0') * RecordInterConnectHelper.MAX_CANCEL_RECORD_ID) + ((c2 - '0') * 10000000) + ((c3 - '0') * DurationKt.NANOS_IN_MILLIS) + ((c4 - '0') * 100000) + ((c5 - '0') * 10000) + ((c6 - '0') * 1000) + ((c7 - '0') * 100) + ((c8 - '0') * 10) + (c9 - '0');
    }

    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02ab, code lost:
        if (r3 == null) goto L_0x01f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0455, code lost:
        r1 = r13.substring(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0472, code lost:
        if (r3 == null) goto L_0x03f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x04ca, code lost:
        if (r1 == null) goto L_0x03f5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0416  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0445  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x047e  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0234  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.alibaba.fastjson.util.FieldInfo> computeGetters(java.lang.Class<?> r39, com.alibaba.fastjson.annotation.JSONType r40, java.util.Map<java.lang.String, java.lang.String> r41, java.util.Map<java.lang.String, java.lang.reflect.Field> r42, boolean r43, com.alibaba.fastjson.PropertyNamingStrategy r44) {
        /*
            r12 = r39
            r13 = r41
            r14 = r42
            r15 = r44
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
            r10.<init>()
            boolean r16 = isKotlin(r39)
            java.lang.reflect.Method[] r9 = r39.getMethods()
            int r8 = r9.length
            r17 = 0
            r0 = r17
            r1 = r0
            r2 = r1
            r3 = r2
            r6 = 0
        L_0x001e:
            if (r6 >= r8) goto L_0x0546
            r5 = r9[r6]
            java.lang.String r4 = r5.getName()
            int r18 = r5.getModifiers()
            boolean r18 = java.lang.reflect.Modifier.isStatic(r18)
            if (r18 == 0) goto L_0x0031
            goto L_0x0081
        L_0x0031:
            java.lang.Class r11 = r5.getReturnType()
            java.lang.Class r7 = java.lang.Void.TYPE
            boolean r7 = r11.equals(r7)
            if (r7 == 0) goto L_0x003e
            goto L_0x0081
        L_0x003e:
            java.lang.Class[] r7 = r5.getParameterTypes()
            int r7 = r7.length
            if (r7 == 0) goto L_0x0046
            goto L_0x0081
        L_0x0046:
            java.lang.Class r7 = r5.getReturnType()
            java.lang.Class<java.lang.ClassLoader> r11 = java.lang.ClassLoader.class
            if (r7 != r11) goto L_0x004f
            goto L_0x0081
        L_0x004f:
            java.lang.String r7 = "getMetaClass"
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto L_0x0068
            java.lang.Class r7 = r5.getReturnType()
            java.lang.String r7 = r7.getName()
            java.lang.String r11 = "groovy.lang.MetaClass"
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x0068
            goto L_0x0081
        L_0x0068:
            java.lang.String r7 = "getSuppressed"
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto L_0x0079
            java.lang.Class r7 = r5.getDeclaringClass()
            java.lang.Class<java.lang.Throwable> r11 = java.lang.Throwable.class
            if (r7 != r11) goto L_0x0079
            goto L_0x0081
        L_0x0079:
            if (r16 == 0) goto L_0x008e
            boolean r7 = isKotlinIgnore(r12, r4)
            if (r7 == 0) goto L_0x008e
        L_0x0081:
            r24 = r6
            r31 = r8
            r32 = r9
            r12 = r10
            r18 = 0
            r21 = 1
            goto L_0x0539
        L_0x008e:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r11 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r19 = getAnnotation((java.lang.reflect.Method) r5, r11)
            com.alibaba.fastjson.annotation.JSONField r19 = (com.alibaba.fastjson.annotation.JSONField) r19
            if (r19 != 0) goto L_0x009e
            com.alibaba.fastjson.annotation.JSONField r19 = getSuperMethodAnnotation(r12, r5)
        L_0x009e:
            r20 = r1
            java.lang.String r1 = "get"
            r21 = r10
            if (r19 != 0) goto L_0x0179
            if (r16 == 0) goto L_0x0179
            if (r0 != 0) goto L_0x00f1
            java.lang.reflect.Constructor[] r0 = r39.getDeclaredConstructors()
            java.lang.reflect.Constructor r22 = getKoltinConstructor(r0)
            if (r22 == 0) goto L_0x00ef
            java.lang.annotation.Annotation[][] r3 = getParameterAnnotations((java.lang.reflect.Constructor) r22)
            java.lang.String[] r10 = getKoltinConstructorParameters(r39)
            if (r10 == 0) goto L_0x00e8
            int r2 = r10.length
            java.lang.String[] r2 = new java.lang.String[r2]
            r23 = r0
            int r0 = r10.length
            r20 = r3
            r3 = 0
            java.lang.System.arraycopy(r10, r3, r2, r3, r0)
            java.util.Arrays.sort(r2)
            int r0 = r10.length
            short[] r0 = new short[r0]
            r24 = r6
        L_0x00d2:
            int r6 = r10.length
            if (r3 >= r6) goto L_0x00e1
            r6 = r10[r3]
            int r6 = java.util.Arrays.binarySearch(r2, r6)
            r0[r6] = r3
            r6 = 1
            int r3 = r3 + r6
            short r3 = (short) r3
            goto L_0x00d2
        L_0x00e1:
            r10 = r2
            r3 = r20
            r2 = r0
            r0 = r23
            goto L_0x00f5
        L_0x00e8:
            r23 = r0
            r20 = r3
            r24 = r6
            goto L_0x00f5
        L_0x00ef:
            r23 = r0
        L_0x00f1:
            r24 = r6
            r10 = r20
        L_0x00f5:
            if (r10 == 0) goto L_0x0170
            if (r2 == 0) goto L_0x0170
            boolean r6 = r4.startsWith(r1)
            if (r6 == 0) goto L_0x0170
            r6 = 3
            java.lang.String r20 = r4.substring(r6)
            java.lang.String r6 = decapitalize(r20)
            int r20 = java.util.Arrays.binarySearch(r10, r6)
            r23 = r0
            r25 = r7
            if (r20 >= 0) goto L_0x0124
            r0 = 0
        L_0x0113:
            int r7 = r10.length
            if (r0 >= r7) goto L_0x0124
            r7 = r10[r0]
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x0121
            r20 = r0
            goto L_0x0124
        L_0x0121:
            r7 = 1
            int r0 = r0 + r7
            goto L_0x0113
        L_0x0124:
            if (r20 < 0) goto L_0x0169
            short r0 = r2[r20]
            r0 = r3[r0]
            if (r0 == 0) goto L_0x014c
            int r7 = r0.length
            r20 = r2
            r2 = 0
        L_0x0130:
            r26 = r3
            if (r2 >= r7) goto L_0x0140
            r3 = r0[r2]
            r27 = r0
            boolean r0 = r3 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r0 == 0) goto L_0x0143
            r19 = r3
            com.alibaba.fastjson.annotation.JSONField r19 = (com.alibaba.fastjson.annotation.JSONField) r19
        L_0x0140:
            r28 = 1
            goto L_0x0151
        L_0x0143:
            r28 = 1
            int r2 = r2 + 1
            r3 = r26
            r0 = r27
            goto L_0x0130
        L_0x014c:
            r20 = r2
            r26 = r3
            goto L_0x0140
        L_0x0151:
            if (r19 != 0) goto L_0x0166
            java.lang.reflect.Field r0 = com.alibaba.fastjson.parser.ParserConfig.getFieldFromCache(r6, r14)
            if (r0 == 0) goto L_0x0166
            java.lang.annotation.Annotation r0 = getAnnotation((java.lang.reflect.Field) r0, r11)
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            r27 = r0
        L_0x0161:
            r19 = r20
            r20 = r10
            goto L_0x0187
        L_0x0166:
            r27 = r19
            goto L_0x0161
        L_0x0169:
            r20 = r2
            r26 = r3
        L_0x016d:
            r28 = 1
            goto L_0x0166
        L_0x0170:
            r23 = r0
            r20 = r2
            r26 = r3
            r25 = r7
            goto L_0x016d
        L_0x0179:
            r24 = r6
            r25 = r7
            r28 = 1
            r23 = r0
            r26 = r3
            r27 = r19
            r19 = r2
        L_0x0187:
            r29 = 0
            if (r27 == 0) goto L_0x021c
            boolean r0 = r27.serialize()
            if (r0 != 0) goto L_0x019d
        L_0x0191:
            r31 = r8
            r32 = r9
            r12 = r21
            r21 = r28
            r18 = 0
            goto L_0x0531
        L_0x019d:
            int r6 = r27.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r27.serialzeFeatures()
            int r7 = com.alibaba.fastjson.serializer.SerializerFeature.of(r0)
            com.alibaba.fastjson.parser.Feature[] r0 = r27.parseFeatures()
            int r10 = com.alibaba.fastjson.parser.Feature.of(r0)
            java.lang.String r0 = r27.name()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x0201
            java.lang.String r0 = r27.name()
            if (r13 == 0) goto L_0x01ca
            java.lang.Object r0 = r13.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x01ca
            goto L_0x0191
        L_0x01ca:
            r11 = r0
            com.alibaba.fastjson.util.FieldInfo r4 = new com.alibaba.fastjson.util.FieldInfo
            r22 = 0
            r25 = 0
            r3 = 0
            r0 = r4
            r1 = r11
            r2 = r5
            r18 = 0
            r5 = r4
            r4 = r39
            r30 = r5
            r5 = r22
            r31 = r8
            r8 = r10
            r32 = r9
            r9 = r27
            r33 = r21
            r10 = r25
            r15 = r11
            r13 = r28
            r11 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r30
            r9 = r33
            r9.put(r15, r0)
        L_0x01f8:
            r15 = r44
            r12 = r9
            r21 = r13
            r13 = r41
            goto L_0x0531
        L_0x0201:
            r31 = r8
            r32 = r9
            r9 = r21
            r13 = r28
            r18 = 0
            java.lang.String r0 = r27.label()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x0219
            java.lang.String r29 = r27.label()
        L_0x0219:
            r0 = r7
            r7 = r6
            goto L_0x022a
        L_0x021c:
            r31 = r8
            r32 = r9
            r9 = r21
            r13 = r28
            r18 = 0
            r0 = r18
            r7 = r0
            r10 = r7
        L_0x022a:
            boolean r1 = r4.startsWith(r1)
            r15 = 102(0x66, float:1.43E-43)
            r8 = 95
            if (r1 == 0) goto L_0x03dc
            int r1 = r4.length()
            r2 = 4
            if (r1 >= r2) goto L_0x023c
        L_0x023b:
            goto L_0x01f8
        L_0x023c:
            java.lang.String r1 = "getClass"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0245
            goto L_0x023b
        L_0x0245:
            java.lang.String r1 = "getDeclaringClass"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0254
            boolean r1 = r39.isEnum()
            if (r1 == 0) goto L_0x0254
            goto L_0x023b
        L_0x0254:
            r1 = 3
            char r3 = r4.charAt(r1)
            boolean r6 = java.lang.Character.isUpperCase(r3)
            if (r6 != 0) goto L_0x02ae
            r6 = 512(0x200, float:7.175E-43)
            if (r3 <= r6) goto L_0x0264
            goto L_0x02ae
        L_0x0264:
            if (r3 != r8) goto L_0x0280
            java.lang.String r2 = r4.substring(r2)
            java.lang.Object r3 = r14.get(r2)
            java.lang.reflect.Field r3 = (java.lang.reflect.Field) r3
            if (r3 != 0) goto L_0x02db
            java.lang.String r3 = r4.substring(r1)
            java.lang.reflect.Field r6 = com.alibaba.fastjson.parser.ParserConfig.getFieldFromCache(r3, r14)
            if (r6 != 0) goto L_0x027d
            goto L_0x027e
        L_0x027d:
            r2 = r3
        L_0x027e:
            r3 = r6
            goto L_0x02db
        L_0x0280:
            if (r3 != r15) goto L_0x0289
            java.lang.String r2 = r4.substring(r1)
        L_0x0286:
            r3 = r17
            goto L_0x02db
        L_0x0289:
            int r3 = r4.length()
            r6 = 5
            if (r3 < r6) goto L_0x02a3
            char r2 = r4.charAt(r2)
            boolean r2 = java.lang.Character.isUpperCase(r2)
            if (r2 == 0) goto L_0x02a3
            java.lang.String r2 = r4.substring(r1)
            java.lang.String r2 = decapitalize(r2)
            goto L_0x0286
        L_0x02a3:
            java.lang.String r2 = r4.substring(r1)
            java.lang.reflect.Field r3 = com.alibaba.fastjson.parser.ParserConfig.getFieldFromCache(r2, r14)
            if (r3 != 0) goto L_0x02db
            goto L_0x023b
        L_0x02ae:
            boolean r3 = compatibleWithJavaBean
            if (r3 == 0) goto L_0x02bb
            java.lang.String r2 = r4.substring(r1)
            java.lang.String r2 = decapitalize(r2)
            goto L_0x02d6
        L_0x02bb:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            char r6 = r4.charAt(r1)
            char r6 = java.lang.Character.toLowerCase(r6)
            r3.append(r6)
            java.lang.String r2 = r4.substring(r2)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
        L_0x02d6:
            java.lang.String r2 = getPropertyNameByCompatibleFieldName(r14, r4, r2, r1)
            goto L_0x0286
        L_0x02db:
            boolean r1 = isJSONTypeIgnore(r12, r2)
            if (r1 == 0) goto L_0x02e3
            goto L_0x023b
        L_0x02e3:
            if (r3 != 0) goto L_0x02e9
            java.lang.reflect.Field r3 = com.alibaba.fastjson.parser.ParserConfig.getFieldFromCache(r2, r14)
        L_0x02e9:
            if (r3 != 0) goto L_0x030c
            int r1 = r2.length()
            if (r1 <= r13) goto L_0x030c
            char r1 = r2.charAt(r13)
            r6 = 65
            if (r1 < r6) goto L_0x030c
            r6 = 90
            if (r1 > r6) goto L_0x030c
            r6 = 3
            java.lang.String r1 = r4.substring(r6)
            java.lang.String r1 = decapitalize(r1)
            java.lang.reflect.Field r1 = com.alibaba.fastjson.parser.ParserConfig.getFieldFromCache(r1, r14)
            r3 = r1
            goto L_0x030d
        L_0x030c:
            r6 = 3
        L_0x030d:
            if (r3 == 0) goto L_0x037d
            java.lang.annotation.Annotation r1 = getAnnotation((java.lang.reflect.Field) r3, r11)
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            if (r1 == 0) goto L_0x0378
            boolean r0 = r1.serialize()
            if (r0 != 0) goto L_0x031f
            goto L_0x023b
        L_0x031f:
            int r7 = r1.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r1.serialzeFeatures()
            int r0 = com.alibaba.fastjson.serializer.SerializerFeature.of(r0)
            com.alibaba.fastjson.parser.Feature[] r10 = r1.parseFeatures()
            int r10 = com.alibaba.fastjson.parser.Feature.of(r10)
            java.lang.String r21 = r1.name()
            int r21 = r21.length()
            if (r21 == 0) goto L_0x035a
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            java.lang.String r6 = r1.name()
            r21 = r13
            r13 = r41
            if (r13 == 0) goto L_0x0356
            java.lang.Object r6 = r13.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x0356
        L_0x0351:
            r15 = r44
            r12 = r9
            goto L_0x0531
        L_0x0356:
            r25 = r2
            r2 = r6
            goto L_0x035e
        L_0x035a:
            r21 = r13
            r13 = r41
        L_0x035e:
            java.lang.String r6 = r1.label()
            int r6 = r6.length()
            if (r6 == 0) goto L_0x036c
            java.lang.String r29 = r1.label()
        L_0x036c:
            r28 = r7
            r7 = r25
            r30 = r29
            r25 = r0
            r29 = r10
            r10 = r1
            goto L_0x038d
        L_0x0378:
            r21 = r13
            r13 = r41
            goto L_0x036c
        L_0x037d:
            r21 = r13
            r13 = r41
            r28 = r7
            r7 = r25
            r30 = r29
            r25 = r0
            r29 = r10
            r10 = r17
        L_0x038d:
            if (r13 == 0) goto L_0x0399
            java.lang.Object r0 = r13.get(r2)
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x0399
            goto L_0x0351
        L_0x0399:
            r6 = r44
            if (r6 == 0) goto L_0x03a7
            boolean r0 = r7.booleanValue()
            if (r0 != 0) goto L_0x03a7
            java.lang.String r2 = r6.translate(r2)
        L_0x03a7:
            r7 = r2
            com.alibaba.fastjson.util.FieldInfo r2 = new com.alibaba.fastjson.util.FieldInfo
            r33 = 0
            r0 = r2
            r1 = r7
            r15 = r2
            r2 = r5
            r13 = r4
            r4 = r39
            r34 = r5
            r5 = r33
            r22 = 3
            r6 = r28
            r35 = r7
            r7 = r25
            r8 = r29
            r36 = r9
            r9 = r27
            r37 = r11
            r11 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r2 = r35
            r11 = r36
            r11.put(r2, r15)
            r0 = r25
            r7 = r28
            r10 = r29
            r29 = r30
            goto L_0x03e4
        L_0x03dc:
            r34 = r5
            r37 = r11
            r21 = r13
            r13 = r4
            r11 = r9
        L_0x03e4:
            java.lang.String r1 = "is"
            boolean r1 = r13.startsWith(r1)
            if (r1 == 0) goto L_0x03f3
            int r1 = r13.length()
            r2 = 3
            if (r1 >= r2) goto L_0x03fa
        L_0x03f3:
            r13 = r41
        L_0x03f5:
            r15 = r44
        L_0x03f7:
            r12 = r11
            goto L_0x0531
        L_0x03fa:
            java.lang.Class r1 = r34.getReturnType()
            java.lang.Class r3 = java.lang.Boolean.TYPE
            if (r1 == r3) goto L_0x040b
            java.lang.Class r1 = r34.getReturnType()
            java.lang.Class<java.lang.Boolean> r3 = java.lang.Boolean.class
            if (r1 == r3) goto L_0x040b
            goto L_0x03f3
        L_0x040b:
            r1 = 2
            char r3 = r13.charAt(r1)
            boolean r4 = java.lang.Character.isUpperCase(r3)
            if (r4 == 0) goto L_0x0445
            boolean r3 = compatibleWithJavaBean
            if (r3 == 0) goto L_0x0423
            java.lang.String r2 = r13.substring(r1)
            java.lang.String r2 = decapitalize(r2)
            goto L_0x043e
        L_0x0423:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            char r4 = r13.charAt(r1)
            char r4 = java.lang.Character.toLowerCase(r4)
            r3.append(r4)
            java.lang.String r2 = r13.substring(r2)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
        L_0x043e:
            java.lang.String r1 = getPropertyNameByCompatibleFieldName(r14, r13, r2, r1)
        L_0x0442:
            r3 = r17
            goto L_0x0476
        L_0x0445:
            r4 = 95
            if (r3 != r4) goto L_0x0461
            java.lang.String r2 = r13.substring(r2)
            java.lang.Object r3 = r14.get(r2)
            java.lang.reflect.Field r3 = (java.lang.reflect.Field) r3
            if (r3 != 0) goto L_0x045f
            java.lang.String r1 = r13.substring(r1)
            java.lang.reflect.Field r3 = com.alibaba.fastjson.parser.ParserConfig.getFieldFromCache(r1, r14)
            if (r3 != 0) goto L_0x0476
        L_0x045f:
            r1 = r2
            goto L_0x0476
        L_0x0461:
            r2 = 102(0x66, float:1.43E-43)
            if (r3 != r2) goto L_0x046a
            java.lang.String r1 = r13.substring(r1)
            goto L_0x0442
        L_0x046a:
            java.lang.String r1 = r13.substring(r1)
            java.lang.reflect.Field r3 = com.alibaba.fastjson.parser.ParserConfig.getFieldFromCache(r1, r14)
            if (r3 != 0) goto L_0x0476
        L_0x0474:
            goto L_0x03f3
        L_0x0476:
            boolean r2 = isJSONTypeIgnore(r12, r1)
            if (r2 == 0) goto L_0x047e
            goto L_0x03f3
        L_0x047e:
            if (r3 != 0) goto L_0x0484
            java.lang.reflect.Field r3 = com.alibaba.fastjson.parser.ParserConfig.getFieldFromCache(r1, r14)
        L_0x0484:
            if (r3 != 0) goto L_0x048b
            java.lang.reflect.Field r2 = com.alibaba.fastjson.parser.ParserConfig.getFieldFromCache(r13, r14)
            r3 = r2
        L_0x048b:
            if (r3 == 0) goto L_0x04f1
            r2 = r37
            java.lang.annotation.Annotation r2 = getAnnotation((java.lang.reflect.Field) r3, r2)
            com.alibaba.fastjson.annotation.JSONField r2 = (com.alibaba.fastjson.annotation.JSONField) r2
            if (r2 == 0) goto L_0x04ea
            boolean r0 = r2.serialize()
            if (r0 != 0) goto L_0x049e
            goto L_0x0474
        L_0x049e:
            int r0 = r2.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r2.serialzeFeatures()
            int r4 = com.alibaba.fastjson.serializer.SerializerFeature.of(r4)
            com.alibaba.fastjson.parser.Feature[] r5 = r2.parseFeatures()
            int r5 = com.alibaba.fastjson.parser.Feature.of(r5)
            java.lang.String r6 = r2.name()
            int r6 = r6.length()
            if (r6 == 0) goto L_0x04ce
            java.lang.String r1 = r2.name()
            r13 = r41
            if (r13 == 0) goto L_0x04d0
            java.lang.Object r1 = r13.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x04d0
        L_0x04cc:
            goto L_0x03f5
        L_0x04ce:
            r13 = r41
        L_0x04d0:
            java.lang.String r6 = r2.label()
            int r6 = r6.length()
            if (r6 == 0) goto L_0x04e5
            java.lang.String r6 = r2.label()
            r10 = r2
            r7 = r4
            r8 = r5
            r29 = r6
            r6 = r0
            goto L_0x04f8
        L_0x04e5:
            r6 = r0
            r10 = r2
            r7 = r4
            r8 = r5
            goto L_0x04f8
        L_0x04ea:
            r13 = r41
            r6 = r7
            r8 = r10
            r7 = r0
            r10 = r2
            goto L_0x04f8
        L_0x04f1:
            r13 = r41
            r6 = r7
            r8 = r10
            r10 = r17
            r7 = r0
        L_0x04f8:
            if (r13 == 0) goto L_0x0504
            java.lang.Object r0 = r13.get(r1)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0504
            goto L_0x04cc
        L_0x0504:
            r15 = r44
            if (r15 == 0) goto L_0x050c
            java.lang.String r1 = r15.translate(r1)
        L_0x050c:
            r9 = r1
            boolean r0 = r11.containsKey(r9)
            if (r0 == 0) goto L_0x0515
            goto L_0x03f7
        L_0x0515:
            com.alibaba.fastjson.util.FieldInfo r5 = new com.alibaba.fastjson.util.FieldInfo
            r22 = 0
            r0 = r5
            r1 = r9
            r2 = r34
            r4 = r39
            r14 = r5
            r5 = r22
            r38 = r9
            r9 = r27
            r12 = r11
            r11 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r1 = r38
            r12.put(r1, r14)
        L_0x0531:
            r2 = r19
            r1 = r20
            r0 = r23
            r3 = r26
        L_0x0539:
            int r6 = r24 + 1
            r14 = r42
            r10 = r12
            r8 = r31
            r9 = r32
            r12 = r39
            goto L_0x001e
        L_0x0546:
            r12 = r10
            java.lang.reflect.Field[] r0 = r39.getFields()
            r1 = r39
            r2 = r12
            computeFields(r1, r13, r15, r2, r0)
            r0 = r43
            java.util.List r0 = getFieldInfos(r1, r0, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.computeGetters(java.lang.Class, com.alibaba.fastjson.annotation.JSONType, java.util.Map, java.util.Map, boolean, com.alibaba.fastjson.PropertyNamingStrategy):java.util.List");
    }

    private static Type getCollectionItemType(Class<?> cls) {
        if (cls.getName().startsWith("java.")) {
            return Object.class;
        }
        return getCollectionItemType(getCollectionSuperType(cls));
    }

    private static Type getCollectionItemType(ParameterizedType parameterizedType) {
        Type rawType = parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (rawType == Collection.class) {
            return getWildcardTypeUpperBounds(actualTypeArguments[0]);
        }
        Class cls = (Class) rawType;
        Map<TypeVariable, Type> createActualTypeMap = createActualTypeMap(cls.getTypeParameters(), actualTypeArguments);
        Type collectionSuperType = getCollectionSuperType(cls);
        if (!(collectionSuperType instanceof ParameterizedType)) {
            return getCollectionItemType((Class<?>) (Class) collectionSuperType);
        }
        Class<?> rawClass = getRawClass(collectionSuperType);
        Type[] actualTypeArguments2 = ((ParameterizedType) collectionSuperType).getActualTypeArguments();
        if (actualTypeArguments2.length > 0) {
            return getCollectionItemType(makeParameterizedType(rawClass, actualTypeArguments2, createActualTypeMap));
        }
        return getCollectionItemType(rawClass);
    }

    public static <A extends Annotation> A getAnnotation(Field field, Class<A> cls) {
        A annotation;
        A annotation2 = field.getAnnotation(cls);
        Type mixInAnnotations = JSON.getMixInAnnotations(field.getDeclaringClass());
        Field field2 = null;
        Class<? super Object> cls2 = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls2 != null) {
            String name = field.getName();
            while (true) {
                if (cls2 == null || cls2 == Object.class) {
                    break;
                }
                try {
                    field2 = cls2.getDeclaredField(name);
                    break;
                } catch (NoSuchFieldException unused) {
                    cls2 = cls2.getSuperclass();
                }
            }
            if (!(field2 == null || (annotation = field2.getAnnotation(cls)) == null)) {
                return annotation;
            }
        }
        return annotation2;
    }

    public static Annotation[][] getParameterAnnotations(Constructor constructor) {
        Annotation[][] parameterAnnotations;
        Constructor<Object> declaredConstructor;
        Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
        Type mixInAnnotations = JSON.getMixInAnnotations(constructor.getDeclaringClass());
        Constructor<Object> constructor2 = null;
        Class<Object> cls = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls != null) {
            Class[] parameterTypes = constructor.getParameterTypes();
            ArrayList arrayList = new ArrayList(2);
            for (Class<?> enclosingClass = cls.getEnclosingClass(); enclosingClass != null; enclosingClass = enclosingClass.getEnclosingClass()) {
                arrayList.add(enclosingClass);
            }
            int size = arrayList.size();
            Class<? super Object> cls2 = cls;
            while (true) {
                if (cls2 != null && cls2 != Object.class) {
                    if (size == 0) {
                        declaredConstructor = cls.getDeclaredConstructor(parameterTypes);
                        break;
                    }
                    try {
                        Class[] clsArr = new Class[(parameterTypes.length + size)];
                        System.arraycopy(parameterTypes, 0, clsArr, size, parameterTypes.length);
                        for (int i = size; i > 0; i--) {
                            int i2 = i - 1;
                            clsArr[i2] = (Class) arrayList.get(i2);
                        }
                        declaredConstructor = cls.getDeclaredConstructor(clsArr);
                    } catch (NoSuchMethodException unused) {
                        size--;
                        cls2 = cls2.getSuperclass();
                    }
                } else {
                    break;
                }
            }
            constructor2 = declaredConstructor;
            if (!(constructor2 == null || (parameterAnnotations = constructor2.getParameterAnnotations()) == null)) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    public static <A extends Annotation> A getAnnotation(Method method, Class<A> cls) {
        A annotation;
        A annotation2 = method.getAnnotation(cls);
        Type mixInAnnotations = JSON.getMixInAnnotations(method.getDeclaringClass());
        Method method2 = null;
        Class<? super Object> cls2 = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls2 != null) {
            String name = method.getName();
            Class[] parameterTypes = method.getParameterTypes();
            while (true) {
                if (cls2 == null || cls2 == Object.class) {
                    break;
                }
                try {
                    method2 = cls2.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (NoSuchMethodException unused) {
                    cls2 = cls2.getSuperclass();
                }
            }
            if (!(method2 == null || (annotation = method2.getAnnotation(cls)) == null)) {
                return annotation;
            }
        }
        return annotation2;
    }

    public static <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
        if (obj == null) {
            return null;
        }
        if (type instanceof Class) {
            return cast(obj, (Class) type, parserConfig);
        }
        if (type instanceof ParameterizedType) {
            return cast(obj, (ParameterizedType) type, parserConfig);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    public static <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        T t;
        Object obj2;
        Object obj3;
        Type rawType = parameterizedType.getRawType();
        Class<JSONObject> cls = JSONObject.class;
        Class<ArrayList> cls2 = ArrayList.class;
        Class<List> cls3 = List.class;
        if (rawType == cls3 || rawType == cls2) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List list = (List) obj;
                T arrayList = new ArrayList(list.size());
                for (int i = 0; i < list.size(); i++) {
                    Object obj4 = list.get(i);
                    if (!(type instanceof Class)) {
                        obj3 = cast(obj4, type, parserConfig);
                    } else if (obj4 == null || obj4.getClass() != cls) {
                        obj3 = cast(obj4, (Class) type, parserConfig);
                    } else {
                        obj3 = ((JSONObject) obj4).toJavaObject((Class) type, parserConfig, 0);
                    }
                    arrayList.add(obj3);
                }
                return arrayList;
            }
        }
        Class<TreeSet> cls4 = TreeSet.class;
        Class<HashSet> cls5 = HashSet.class;
        Class<Set> cls6 = Set.class;
        if (rawType == cls6 || rawType == cls5 || rawType == cls4 || rawType == Collection.class || rawType == cls3 || rawType == cls2) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                if (rawType == cls6 || rawType == cls5) {
                    t = new HashSet();
                } else if (rawType == cls4) {
                    t = new TreeSet();
                } else {
                    t = new ArrayList();
                }
                for (Object next : (Iterable) obj) {
                    if (!(type2 instanceof Class)) {
                        obj2 = cast(next, type2, parserConfig);
                    } else if (next == null || next.getClass() != cls) {
                        obj2 = cast(next, (Class) type2, parserConfig);
                    } else {
                        obj2 = ((JSONObject) next).toJavaObject((Class) type2, parserConfig, 0);
                    }
                    t.add(obj2);
                }
                return t;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type3 = parameterizedType.getActualTypeArguments()[0];
            Type type4 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                T hashMap = new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    hashMap.put(cast(entry.getKey(), type3, parserConfig), cast(entry.getValue(), type4, parserConfig));
                }
                return hashMap;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return cast(obj, rawType, parserConfig);
        }
        if (rawType == Map.Entry.class && (obj instanceof Map)) {
            Map map = (Map) obj;
            if (map.size() == 1) {
                return (Map.Entry) map.entrySet().iterator().next();
            }
        }
        if (rawType instanceof Class) {
            if (parserConfig == null) {
                parserConfig = ParserConfig.global;
            }
            ObjectDeserializer deserializer = parserConfig.getDeserializer(rawType);
            if (deserializer != null) {
                return deserializer.deserialze(new DefaultJSONParser(JSON.toJSONString(obj), parserConfig), parameterizedType, (Object) null);
            }
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }
}

package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    protected final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private Map<String, FieldDeserializer> fieldDeserializerMap;
    private final FieldDeserializer[] fieldDeserializers;
    private transient long[] hashArray;
    private transient short[] hashArrayMapping;
    private transient long[] smartMatchHashArray;
    private transient short[] smartMatchHashArrayMapping;
    protected final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this(parserConfig, cls, cls);
    }

    private Object createFactoryInstance(ParserConfig parserConfig, Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return this.beanInfo.factoryMethod.invoke((Object) null, new Object[]{obj});
    }

    public static JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (Class deserializer : jSONType.seeAlso()) {
            ObjectDeserializer deserializer2 = parserConfig.getDeserializer((Type) deserializer);
            if (deserializer2 instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer2;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    public static boolean isSetFlag(int i, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        int i2 = i / 32;
        int i3 = i % 32;
        if (i2 < iArr.length) {
            if (((1 << i3) & iArr[i2]) != 0) {
                return true;
            }
        }
        return false;
    }

    public static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
        int i = jSONLexerBase.token();
        if (i == 8) {
            jSONLexerBase.nextToken(16);
            jSONLexerBase.token();
            return;
        }
        if (i != 14) {
            defaultJSONParser.throwException(i);
        }
        if (jSONLexerBase.getCurrent() == '[') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(14);
        } else {
            jSONLexerBase.nextToken(14);
        }
        if (jSONLexerBase.token() == 15) {
            jSONLexerBase.nextToken();
            return;
        }
        int i2 = 0;
        while (true) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type, Integer.valueOf(i2)));
            i2++;
            if (jSONLexerBase.token() != 16) {
                break;
            } else if (jSONLexerBase.getCurrent() == '[') {
                jSONLexerBase.next();
                jSONLexerBase.setToken(14);
            } else {
                jSONLexerBase.nextToken(14);
            }
        }
        int i3 = jSONLexerBase.token();
        if (i3 != 15) {
            defaultJSONParser.throwException(i3);
        }
        if (jSONLexerBase.getCurrent() == ',') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(16);
            return;
        }
        jSONLexerBase.nextToken(16);
    }

    public void check(JSONLexer jSONLexer, int i) {
        if (jSONLexer.token() != i) {
            throw new JSONException("syntax error");
        }
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object obj;
        if (!(type instanceof Class) || !this.clazz.isInterface()) {
            JavaBeanInfo javaBeanInfo = this.beanInfo;
            Constructor<?> constructor = javaBeanInfo.defaultConstructor;
            Object obj2 = null;
            if (constructor == null && javaBeanInfo.factoryMethod == null) {
                return null;
            }
            Method method = javaBeanInfo.factoryMethod;
            if (method != null && javaBeanInfo.defaultConstructorParameterSize > 0) {
                return null;
            }
            try {
                if (javaBeanInfo.defaultConstructorParameterSize != 0) {
                    ParseContext context = defaultJSONParser.getContext();
                    if (context != null) {
                        if (context.object != null) {
                            if (type instanceof Class) {
                                String name = ((Class) type).getName();
                                String substring = name.substring(0, name.lastIndexOf(36));
                                Object obj3 = context.object;
                                String name2 = obj3.getClass().getName();
                                if (!name2.equals(substring)) {
                                    ParseContext parseContext = context.parent;
                                    if (parseContext == null || parseContext.object == null || (!"java.util.ArrayList".equals(name2) && !"java.util.List".equals(name2) && !"java.util.Collection".equals(name2) && !"java.util.Map".equals(name2) && !"java.util.HashMap".equals(name2))) {
                                        obj2 = obj3;
                                    } else if (parseContext.object.getClass().getName().equals(substring)) {
                                        obj2 = parseContext.object;
                                    }
                                    obj3 = obj2;
                                }
                                if (obj3 == null || ((obj3 instanceof Collection) && ((Collection) obj3).isEmpty())) {
                                    throw new JSONException("can't create non-static inner class instance.");
                                }
                                obj = constructor.newInstance(new Object[]{obj3});
                            } else {
                                throw new JSONException("can't create non-static inner class instance.");
                            }
                        }
                    }
                    throw new JSONException("can't create non-static inner class instance.");
                } else if (constructor != null) {
                    obj = constructor.newInstance((Object[]) null);
                } else {
                    obj = method.invoke((Object) null, (Object[]) null);
                }
                if (defaultJSONParser != null && defaultJSONParser.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                    for (FieldInfo fieldInfo : this.beanInfo.fields) {
                        if (fieldInfo.fieldClass == String.class) {
                            try {
                                fieldInfo.set(obj, "");
                            } catch (Exception e) {
                                throw new JSONException("create instance error, class " + this.clazz.getName(), e);
                            }
                        }
                    }
                }
                return obj;
            } catch (JSONException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new JSONException("create instance error, class " + this.clazz.getName(), e3);
            }
        } else {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return deserialze(defaultJSONParser, type, obj, 0);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 14) {
            String scanTypeName = jSONLexer.scanTypeName(defaultJSONParser.symbolTable);
            if (scanTypeName != null) {
                Object seeAlso = getSeeAlso(defaultJSONParser.getConfig(), this.beanInfo, scanTypeName);
                if (seeAlso == null) {
                    seeAlso = defaultJSONParser.getConfig().getDeserializer((Type) defaultJSONParser.getConfig().checkAutoType(scanTypeName, TypeUtils.getClass(type), jSONLexer.getFeatures()));
                }
                if (seeAlso instanceof JavaBeanDeserializer) {
                    return ((JavaBeanDeserializer) seeAlso).deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
                }
            }
            T createInstance = createInstance(defaultJSONParser, type);
            int length = this.sortedFieldDeserializers.length;
            int i = 0;
            while (true) {
                int i2 = 16;
                if (i >= length) {
                    break;
                }
                char c = i == length + -1 ? ']' : StringUtil.COMMA;
                FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
                Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                if (cls == Integer.TYPE) {
                    fieldDeserializer.setValue((Object) createInstance, jSONLexer.scanInt(c));
                } else if (cls == String.class) {
                    fieldDeserializer.setValue((Object) createInstance, jSONLexer.scanString(c));
                } else if (cls == Long.TYPE) {
                    fieldDeserializer.setValue((Object) createInstance, jSONLexer.scanLong(c));
                } else if (cls.isEnum()) {
                    char current = jSONLexer.getCurrent();
                    fieldDeserializer.setValue((Object) createInstance, (Object) (current == '\"' || current == 'n') ? jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c) : (current < '0' || current > '9') ? scanEnum(jSONLexer, c) : ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c)));
                } else if (cls == Boolean.TYPE) {
                    fieldDeserializer.setValue((Object) createInstance, jSONLexer.scanBoolean(c));
                } else if (cls == Float.TYPE) {
                    fieldDeserializer.setValue((Object) createInstance, (Object) Float.valueOf(jSONLexer.scanFloat(c)));
                } else if (cls == Double.TYPE) {
                    fieldDeserializer.setValue((Object) createInstance, (Object) Double.valueOf(jSONLexer.scanDouble(c)));
                } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                    fieldDeserializer.setValue((Object) createInstance, (Object) new Date(jSONLexer.scanLong(c)));
                } else if (cls == BigDecimal.class) {
                    fieldDeserializer.setValue((Object) createInstance, (Object) jSONLexer.scanDecimal(c));
                } else {
                    jSONLexer.nextToken(14);
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    fieldDeserializer.setValue((Object) createInstance, defaultJSONParser.parseObject(fieldInfo.fieldType, (Object) fieldInfo.name));
                    if (jSONLexer.token() == 15) {
                        break;
                    }
                    if (c == ']') {
                        i2 = 15;
                    }
                    check(jSONLexer, i2);
                }
                i++;
            }
            jSONLexer.nextToken(16);
            return createInstance;
        }
        throw new JSONException("error");
    }

    public int getFastMatchToken() {
        return 12;
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        return getFieldDeserializer(str, (int[]) null);
    }

    public Type getFieldType(int i) {
        return this.sortedFieldDeserializers[i].fieldInfo.fieldType;
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        return parseField(defaultJSONParser, str, obj, type, map, (int[]) null);
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i) {
        return parseRest(defaultJSONParser, type, obj, obj2, i, new int[0]);
    }

    public Enum<?> scanEnum(JSONLexer jSONLexer, char c) {
        throw new JSONException("illegal enum. " + jSONLexer.info());
    }

    public FieldDeserializer smartMatch(String str) {
        return smartMatch(str, (int[]) null);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy, parserConfig.fieldBased, parserConfig.compatibleWithJavaBean, parserConfig.isJacksonCompatible()));
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i) {
        return deserialze(defaultJSONParser, type, obj, (Object) null, i, (int[]) null);
    }

    public FieldDeserializer getFieldDeserializer(String str, int[] iArr) {
        FieldDeserializer fieldDeserializer;
        if (str == null) {
            return null;
        }
        Map<String, FieldDeserializer> map = this.fieldDeserializerMap;
        if (map != null && (fieldDeserializer = map.get(str)) != null) {
            return fieldDeserializer;
        }
        int length = this.sortedFieldDeserializers.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedFieldDeserializers[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo > 0) {
                length = i2 - 1;
            } else if (isSetFlag(i2, iArr)) {
                return null;
            } else {
                return this.sortedFieldDeserializers[i2];
            }
        }
        Map<String, FieldDeserializer> map2 = this.alterNameFieldDeserializers;
        if (map2 != null) {
            return map2.get(str);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0114  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean parseField(com.alibaba.fastjson.parser.DefaultJSONParser r22, java.lang.String r23, java.lang.Object r24, java.lang.reflect.Type r25, java.util.Map<java.lang.String, java.lang.Object> r26, int[] r27) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r11 = r23
            r12 = r24
            r13 = r25
            r14 = r26
            r15 = r27
            com.alibaba.fastjson.parser.JSONLexer r10 = r1.lexer
            com.alibaba.fastjson.parser.Feature r2 = com.alibaba.fastjson.parser.Feature.DisableFieldSmartMatch
            int r2 = r2.mask
            boolean r3 = r10.isEnabled((int) r2)
            if (r3 != 0) goto L_0x0027
            com.alibaba.fastjson.util.JavaBeanInfo r3 = r0.beanInfo
            int r3 = r3.parserFeatures
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0022
            goto L_0x0027
        L_0x0022:
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r2 = r0.smartMatch(r11, r15)
            goto L_0x002b
        L_0x0027:
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r2 = r0.getFieldDeserializer((java.lang.String) r11)
        L_0x002b:
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.SupportNonPublicField
            int r3 = r3.mask
            r16 = 0
            r9 = 1
            if (r2 != 0) goto L_0x0042
            boolean r4 = r10.isEnabled((int) r3)
            if (r4 != 0) goto L_0x0049
            com.alibaba.fastjson.util.JavaBeanInfo r4 = r0.beanInfo
            int r4 = r4.parserFeatures
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0042
            goto L_0x0049
        L_0x0042:
            r18 = r2
            r19 = r9
            r15 = r10
            goto L_0x010f
        L_0x0049:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Object> r3 = r0.extraFieldDeserializers
            if (r3 != 0) goto L_0x00b9
            java.util.concurrent.ConcurrentHashMap r3 = new java.util.concurrent.ConcurrentHashMap
            r4 = 1061158912(0x3f400000, float:0.75)
            r3.<init>(r9, r4, r9)
            java.lang.Class<?> r4 = r0.clazz
        L_0x0056:
            if (r4 == 0) goto L_0x00b4
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            if (r4 == r5) goto L_0x00b4
            java.lang.reflect.Field[] r5 = r4.getDeclaredFields()
            int r6 = r5.length
            r7 = r16
        L_0x0063:
            if (r7 >= r6) goto L_0x00ac
            r8 = r5[r7]
            java.lang.String r9 = r8.getName()
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r18 = r0.getFieldDeserializer((java.lang.String) r9)
            if (r18 == 0) goto L_0x0076
        L_0x0071:
            r18 = r2
            r19 = r5
            goto L_0x00a4
        L_0x0076:
            int r18 = r8.getModifiers()
            r19 = r18 & 16
            if (r19 != 0) goto L_0x0071
            r18 = r18 & 8
            if (r18 == 0) goto L_0x0083
            goto L_0x0071
        L_0x0083:
            r18 = r2
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r2 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r2 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Field) r8, r2)
            com.alibaba.fastjson.annotation.JSONField r2 = (com.alibaba.fastjson.annotation.JSONField) r2
            if (r2 == 0) goto L_0x009f
            java.lang.String r2 = r2.name()
            r19 = r5
            java.lang.String r5 = ""
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x00a1
            r9 = r2
            goto L_0x00a1
        L_0x009f:
            r19 = r5
        L_0x00a1:
            r3.put(r9, r8)
        L_0x00a4:
            int r7 = r7 + 1
            r2 = r18
            r5 = r19
            r9 = 1
            goto L_0x0063
        L_0x00ac:
            r18 = r2
            java.lang.Class r4 = r4.getSuperclass()
            r9 = 1
            goto L_0x0056
        L_0x00b4:
            r18 = r2
            r0.extraFieldDeserializers = r3
            goto L_0x00bb
        L_0x00b9:
            r18 = r2
        L_0x00bb:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Object> r2 = r0.extraFieldDeserializers
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L_0x010c
            boolean r3 = r2 instanceof com.alibaba.fastjson.parser.deserializer.FieldDeserializer
            if (r3 == 0) goto L_0x00cd
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r2 = (com.alibaba.fastjson.parser.deserializer.FieldDeserializer) r2
            r15 = r10
            r19 = 1
            goto L_0x0111
        L_0x00cd:
            r7 = r2
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            r9 = 1
            r7.setAccessible(r9)
            com.alibaba.fastjson.util.FieldInfo r8 = new com.alibaba.fastjson.util.FieldInfo
            java.lang.Class r4 = r7.getDeclaringClass()
            java.lang.Class r5 = r7.getType()
            java.lang.reflect.Type r6 = r7.getGenericType()
            r17 = 0
            r18 = 0
            r19 = 0
            r2 = r8
            r3 = r23
            r20 = r8
            r8 = r19
            r19 = r9
            r9 = r17
            r15 = r10
            r10 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer r2 = new com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer
            com.alibaba.fastjson.parser.ParserConfig r3 = r22.getConfig()
            java.lang.Class<?> r4 = r0.clazz
            r5 = r20
            r2.<init>(r3, r4, r5)
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Object> r3 = r0.extraFieldDeserializers
            r3.put(r11, r2)
            goto L_0x0111
        L_0x010c:
            r15 = r10
            r19 = 1
        L_0x010f:
            r2 = r18
        L_0x0111:
            r3 = -1
            if (r2 != 0) goto L_0x0204
            com.alibaba.fastjson.parser.Feature r2 = com.alibaba.fastjson.parser.Feature.IgnoreNotMatch
            boolean r2 = r15.isEnabled((com.alibaba.fastjson.parser.Feature) r2)
            if (r2 == 0) goto L_0x01df
            r4 = r3
            r2 = r16
        L_0x011f:
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r5 = r0.sortedFieldDeserializers
            int r6 = r5.length
            if (r2 >= r6) goto L_0x01c9
            r5 = r5[r2]
            com.alibaba.fastjson.util.FieldInfo r6 = r5.fieldInfo
            boolean r7 = r6.unwrapped
            if (r7 == 0) goto L_0x01c5
            boolean r7 = r5 instanceof com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer
            if (r7 == 0) goto L_0x01c5
            java.lang.reflect.Field r7 = r6.field
            java.lang.String r8 = "parse unwrapped field error."
            if (r7 == 0) goto L_0x01a2
            r7 = r5
            com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer r7 = (com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer) r7
            com.alibaba.fastjson.parser.ParserConfig r9 = r22.getConfig()
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r9 = r7.getFieldValueDeserilizer(r9)
            boolean r10 = r9 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer
            if (r10 == 0) goto L_0x0175
            r10 = r9
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r10 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r10
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r10 = r10.getFieldDeserializer((java.lang.String) r11)
            if (r10 == 0) goto L_0x01c5
            java.lang.reflect.Field r4 = r6.field     // Catch:{ Exception -> 0x0162 }
            java.lang.Object r4 = r4.get(r12)     // Catch:{ Exception -> 0x0162 }
            if (r4 != 0) goto L_0x0164
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r9 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r9     // Catch:{ Exception -> 0x0162 }
            java.lang.reflect.Type r4 = r6.fieldType     // Catch:{ Exception -> 0x0162 }
            java.lang.Object r4 = r9.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r1, (java.lang.reflect.Type) r4)     // Catch:{ Exception -> 0x0162 }
            r5.setValue((java.lang.Object) r12, (java.lang.Object) r4)     // Catch:{ Exception -> 0x0162 }
            goto L_0x0164
        L_0x0162:
            r0 = move-exception
            goto L_0x016f
        L_0x0164:
            int r5 = r7.getFastMatchToken()     // Catch:{ Exception -> 0x0162 }
            r15.nextTokenWithColon(r5)     // Catch:{ Exception -> 0x0162 }
            r10.parseField(r1, r4, r13, r14)     // Catch:{ Exception -> 0x0162 }
            goto L_0x01bc
        L_0x016f:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            r1.<init>(r8, r0)
            throw r1
        L_0x0175:
            boolean r7 = r9 instanceof com.alibaba.fastjson.parser.deserializer.MapDeserializer
            if (r7 == 0) goto L_0x01c5
            com.alibaba.fastjson.parser.deserializer.MapDeserializer r9 = (com.alibaba.fastjson.parser.deserializer.MapDeserializer) r9
            java.lang.reflect.Field r4 = r6.field     // Catch:{ Exception -> 0x018f }
            java.lang.Object r4 = r4.get(r12)     // Catch:{ Exception -> 0x018f }
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x018f }
            if (r4 != 0) goto L_0x0191
            java.lang.reflect.Type r4 = r6.fieldType     // Catch:{ Exception -> 0x018f }
            java.util.Map r4 = r9.createMap(r4)     // Catch:{ Exception -> 0x018f }
            r5.setValue((java.lang.Object) r12, (java.lang.Object) r4)     // Catch:{ Exception -> 0x018f }
            goto L_0x0191
        L_0x018f:
            r0 = move-exception
            goto L_0x019c
        L_0x0191:
            r15.nextTokenWithColon()     // Catch:{ Exception -> 0x018f }
            java.lang.Object r5 = r22.parse(r23)     // Catch:{ Exception -> 0x018f }
            r4.put(r11, r5)     // Catch:{ Exception -> 0x018f }
            goto L_0x01bc
        L_0x019c:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            r1.<init>(r8, r0)
            throw r1
        L_0x01a2:
            java.lang.reflect.Method r5 = r6.method
            java.lang.Class[] r5 = r5.getParameterTypes()
            int r5 = r5.length
            r7 = 2
            if (r5 != r7) goto L_0x01c5
            r15.nextTokenWithColon()
            java.lang.Object r4 = r22.parse(r23)
            java.lang.reflect.Method r5 = r6.method     // Catch:{ Exception -> 0x01be }
            java.lang.Object[] r4 = new java.lang.Object[]{r11, r4}     // Catch:{ Exception -> 0x01be }
            r5.invoke(r12, r4)     // Catch:{ Exception -> 0x01be }
        L_0x01bc:
            r4 = r2
            goto L_0x01c5
        L_0x01be:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            r1.<init>(r8, r0)
            throw r1
        L_0x01c5:
            int r2 = r2 + 1
            goto L_0x011f
        L_0x01c9:
            if (r4 == r3) goto L_0x01db
            r5 = r27
            if (r5 == 0) goto L_0x01da
            int r0 = r4 / 32
            int r4 = r4 % 32
            r1 = r5[r0]
            int r2 = r19 << r4
            r1 = r1 | r2
            r5[r0] = r1
        L_0x01da:
            return r19
        L_0x01db:
            r1.parseExtra(r12, r11)
            return r16
        L_0x01df:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "setter not found, class "
            r2.append(r3)
            java.lang.Class<?> r0 = r0.clazz
            java.lang.String r0 = r0.getName()
            r2.append(r0)
            java.lang.String r0 = ", property "
            r2.append(r0)
            r2.append(r11)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0204:
            r5 = r27
            r4 = r15
            r6 = r16
        L_0x0209:
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r7 = r0.sortedFieldDeserializers
            int r8 = r7.length
            if (r6 >= r8) goto L_0x0216
            r7 = r7[r6]
            if (r7 != r2) goto L_0x0213
            goto L_0x0217
        L_0x0213:
            int r6 = r6 + 1
            goto L_0x0209
        L_0x0216:
            r6 = r3
        L_0x0217:
            if (r6 == r3) goto L_0x022d
            if (r5 == 0) goto L_0x022d
            java.lang.String r0 = "_"
            boolean r0 = r11.startsWith(r0)
            if (r0 == 0) goto L_0x022d
            boolean r0 = isSetFlag(r6, r5)
            if (r0 == 0) goto L_0x022d
            r1.parseExtra(r12, r11)
            return r16
        L_0x022d:
            int r0 = r2.getFastMatchToken()
            r4.nextTokenWithColon(r0)
            r2.parseField(r1, r12, r13, r14)
            if (r5 == 0) goto L_0x0244
            int r0 = r6 / 32
            int r6 = r6 % 32
            r1 = r5[r0]
            int r2 = r19 << r6
            r1 = r1 | r2
            r5[r0] = r1
        L_0x0244:
            return r19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.parseField(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.String, java.lang.Object, java.lang.reflect.Type, java.util.Map, int[]):boolean");
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i, int[] iArr) {
        return deserialze(defaultJSONParser, type, obj, obj2, i, iArr);
    }

    public Enum scanEnum(JSONLexerBase jSONLexerBase, char[] cArr, ObjectDeserializer objectDeserializer) {
        EnumDeserializer enumDeserializer = objectDeserializer instanceof EnumDeserializer ? (EnumDeserializer) objectDeserializer : null;
        if (enumDeserializer == null) {
            jSONLexerBase.matchStat = -1;
            return null;
        }
        long scanEnumSymbol = jSONLexerBase.scanEnumSymbol(cArr);
        if (jSONLexerBase.matchStat <= 0) {
            return null;
        }
        Enum enumByHashCode = enumDeserializer.getEnumByHashCode(scanEnumSymbol);
        if (enumByHashCode == null) {
            if (scanEnumSymbol == -3750763034362895579L) {
                return null;
            }
            if (jSONLexerBase.isEnabled(Feature.ErrorOnEnumNotMatch)) {
                throw new JSONException("not match enum value, " + enumDeserializer.enumClass);
            }
        }
        return enumByHashCode;
    }

    public FieldDeserializer smartMatch(String str, int[] iArr) {
        boolean z;
        if (str == null) {
            return null;
        }
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str, iArr);
        if (fieldDeserializer == null) {
            long fnv1a_64_lower = TypeUtils.fnv1a_64_lower(str);
            int i = 0;
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i2 = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i2 >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i2] = TypeUtils.fnv1a_64_lower(fieldDeserializerArr[i2].fieldInfo.name);
                    i2++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, fnv1a_64_lower);
            if (binarySearch < 0) {
                z = str.startsWith("is");
                if (z) {
                    binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(str.substring(2)));
                }
            } else {
                z = false;
            }
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    short[] sArr = new short[this.smartMatchHashArray.length];
                    Arrays.fill(sArr, -1);
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(fieldDeserializerArr2[i].fieldInfo.name));
                        if (binarySearch2 >= 0) {
                            sArr[binarySearch2] = (short) i;
                        }
                        i++;
                    }
                    this.smartMatchHashArrayMapping = sArr;
                }
                short s = this.smartMatchHashArrayMapping[binarySearch];
                if (s != -1 && !isSetFlag(s, iArr)) {
                    fieldDeserializer = this.sortedFieldDeserializers[s];
                }
            }
            if (fieldDeserializer != null) {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                if ((fieldInfo.parserFeatures & Feature.DisableFieldSmartMatch.mask) != 0) {
                    return null;
                }
                Class<?> cls = fieldInfo.fieldClass;
                if (!(!z || cls == Boolean.TYPE || cls == Boolean.class)) {
                    return null;
                }
            }
        }
        return fieldDeserializer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0203, code lost:
        if (r13 == -2) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0328, code lost:
        if (r5 == -2) goto L_0x032a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x0358, code lost:
        if (r5 == -2) goto L_0x035a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:331:0x03f8, code lost:
        if (r11.isEnabled(com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas) != false) goto L_0x0301;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:?, code lost:
        r11.nextTokenWithColon(4);
        r0 = r11.token();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x040e, code lost:
        if (r0 != 4) goto L_0x04bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x0410, code lost:
        r0 = r11.stringVal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x041a, code lost:
        if ("@".equals(r0) == false) goto L_0x0423;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x041c, code lost:
        r1 = r15.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x0429, code lost:
        if ("..".equals(r0) == false) goto L_0x043f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x042b, code lost:
        r1 = r15.parent;
        r2 = r1.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x042f, code lost:
        if (r2 == null) goto L_0x0433;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x0431, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x0433, code lost:
        r9.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r1, r0));
        r9.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x0445, code lost:
        if ("$".equals(r0) == false) goto L_0x045f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x0447, code lost:
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x0448, code lost:
        r2 = r1.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x044a, code lost:
        if (r2 == null) goto L_0x044e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x044c, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x044e, code lost:
        r2 = r1.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x0450, code lost:
        if (r2 == null) goto L_0x0453;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x0453, code lost:
        r9.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r1, r0));
        r9.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x0465, code lost:
        if (r0.indexOf(92) <= 0) goto L_0x0489;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x0467, code lost:
        r2 = new java.lang.StringBuilder();
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x0471, code lost:
        if (r4 >= r0.length()) goto L_0x0485;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x0473, code lost:
        r5 = r0.charAt(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x0477, code lost:
        if (r5 != '\\') goto L_0x047f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x0479, code lost:
        r4 = r4 + 1;
        r5 = r0.charAt(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x047f, code lost:
        r2.append(r5);
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x0485, code lost:
        r0 = r2.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x0489, code lost:
        r1 = r9.resolveReference(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x048d, code lost:
        if (r1 == null) goto L_0x0490;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x0490, code lost:
        r9.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r15, r0));
        r9.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x049b, code lost:
        r1 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:?, code lost:
        r11.nextToken(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x04a5, code lost:
        if (r11.token() != 13) goto L_0x04b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x04a7, code lost:
        r11.nextToken(16);
        r9.setContext(r15, r1, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x04af, code lost:
        if (r3 == null) goto L_0x04b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x04b1, code lost:
        r3.object = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x04b3, code lost:
        r9.setContext(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x04b6, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x04be, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:0x04d9, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:404:0x0513, code lost:
        r7 = r28;
        r1 = getSeeAlso(r7, r8.beanInfo, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x051b, code lost:
        if (r1 != null) goto L_0x0532;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:407:?, code lost:
        r14 = r7.checkAutoType(r0, com.alibaba.fastjson.util.TypeUtils.getClass(r34), r11.getFeatures());
        r1 = r33.getConfig().getDeserializer(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:408:0x0532, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:?, code lost:
        r2 = r1.deserialze(r9, r14, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:411:0x0539, code lost:
        if ((r1 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L_0x0546;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:?, code lost:
        r1 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x053d, code lost:
        if (r4 == null) goto L_0x0546;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x053f, code lost:
        r1.getFieldDeserializer(r4).setValue((java.lang.Object) r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x0546, code lost:
        if (r3 == null) goto L_0x054c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x0548, code lost:
        r3.object = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:418:0x054c, code lost:
        r9.setContext(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:419:0x054f, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:506:0x06ae, code lost:
        r0 = r18;
        r6 = r21;
        r3 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:615:0x07ff, code lost:
        if (r7[r4].fieldClass != r12) goto L_0x0833;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:617:?, code lost:
        r4 = (r5 = r8.beanInfo).kotlinDefaultConstructor;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:618:0x0803, code lost:
        if (r4 == null) goto L_0x0833;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:619:0x0805, code lost:
        r4 = r4.newInstance((java.lang.Object[]) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:620:0x080a, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:623:0x080c, code lost:
        if (r5 >= r1.length) goto L_0x082b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:624:0x080e, code lost:
        r6 = r1[r5];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:625:0x0810, code lost:
        if (r6 == null) goto L_0x0828;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:626:0x0812, code lost:
        r7 = r8.beanInfo.fields;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:627:0x0816, code lost:
        if (r7 == null) goto L_0x0828;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:629:0x0819, code lost:
        if (r5 >= r7.length) goto L_0x0828;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:630:0x081b, code lost:
        r7[r5].set(r4, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:631:0x0821, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:632:0x0822, code lost:
        r14 = r3;
        r6 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:633:0x0826, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:634:0x0828, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:635:0x082b, code lost:
        r1 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:636:0x082d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:637:0x082e, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:651:0x088b, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error, " + r2 + ", " + r8.beanInfo.creatorConstructor.toGenericString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:696:0x092a, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r11.token()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0102, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0121, code lost:
        throw new com.alibaba.fastjson.JSONException(r0.getMessage(), r0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:14:0x0039, B:80:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0327 A[Catch:{ all -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x03a5  */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x03d1 A[SYNTHETIC, Splitter:B:320:0x03d1] */
    /* JADX WARNING: Removed duplicated region for block: B:433:0x0592  */
    /* JADX WARNING: Removed duplicated region for block: B:435:0x059f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:456:0x05eb  */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0649 A[Catch:{ all -> 0x05b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:502:0x06a3 A[Catch:{ all -> 0x0688 }] */
    /* JADX WARNING: Removed duplicated region for block: B:503:0x06a5 A[Catch:{ all -> 0x0688 }] */
    /* JADX WARNING: Removed duplicated region for block: B:642:0x083d A[SYNTHETIC, Splitter:B:642:0x083d] */
    /* JADX WARNING: Removed duplicated region for block: B:704:0x093d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r33, java.lang.reflect.Type r34, java.lang.Object r35, java.lang.Object r36, int r37, int[] r38) {
        /*
            r32 = this;
            r8 = r32
            r9 = r33
            r0 = r34
            r10 = r35
            java.lang.Class<com.alibaba.fastjson.JSON> r1 = com.alibaba.fastjson.JSON.class
            if (r0 == r1) goto L_0x0943
            java.lang.Class<com.alibaba.fastjson.JSONObject> r1 = com.alibaba.fastjson.JSONObject.class
            if (r0 != r1) goto L_0x0012
            goto L_0x0943
        L_0x0012:
            com.alibaba.fastjson.parser.JSONLexer r1 = r9.lexer
            r11 = r1
            com.alibaba.fastjson.parser.JSONLexerBase r11 = (com.alibaba.fastjson.parser.JSONLexerBase) r11
            com.alibaba.fastjson.parser.ParserConfig r12 = r33.getConfig()
            int r1 = r11.token()
            r2 = 8
            r13 = 16
            r14 = 0
            if (r1 != r2) goto L_0x002a
            r11.nextToken(r13)
            return r14
        L_0x002a:
            com.alibaba.fastjson.parser.ParseContext r2 = r33.getContext()
            if (r36 == 0) goto L_0x0034
            if (r2 == 0) goto L_0x0034
            com.alibaba.fastjson.parser.ParseContext r2 = r2.parent
        L_0x0034:
            r15 = r2
            r7 = 13
            if (r1 != r7) goto L_0x004e
            r11.nextToken(r13)     // Catch:{ all -> 0x0043 }
            if (r36 != 0) goto L_0x0048
            java.lang.Object r0 = r32.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r33, (java.lang.reflect.Type) r34)     // Catch:{ all -> 0x0043 }
            goto L_0x004a
        L_0x0043:
            r0 = move-exception
        L_0x0044:
            r6 = r36
            goto L_0x093b
        L_0x0048:
            r0 = r36
        L_0x004a:
            r9.setContext(r15)
            return r0
        L_0x004e:
            r2 = 14
            if (r1 != r2) goto L_0x006f
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.SupportArrayToBean     // Catch:{ all -> 0x0043 }
            int r4 = r3.mask     // Catch:{ all -> 0x0043 }
            com.alibaba.fastjson.util.JavaBeanInfo r5 = r8.beanInfo     // Catch:{ all -> 0x0043 }
            int r5 = r5.parserFeatures     // Catch:{ all -> 0x0043 }
            r5 = r5 & r4
            if (r5 != 0) goto L_0x0067
            boolean r3 = r11.isEnabled((com.alibaba.fastjson.parser.Feature) r3)     // Catch:{ all -> 0x0043 }
            if (r3 != 0) goto L_0x0067
            r3 = r37 & r4
            if (r3 == 0) goto L_0x006f
        L_0x0067:
            java.lang.Object r0 = r32.deserialzeArrayMapping(r33, r34, r35, r36)     // Catch:{ all -> 0x0043 }
            r9.setContext(r15)
            return r0
        L_0x006f:
            r3 = 12
            java.lang.Class<java.lang.Integer> r6 = java.lang.Integer.class
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r7 = 5
            r4 = 4
            if (r1 == r3) goto L_0x015f
            if (r1 == r13) goto L_0x015f
            boolean r0 = r11.isBlankInput()     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0085
            r9.setContext(r15)
            return r14
        L_0x0085:
            if (r1 != r4) goto L_0x00bf
            java.lang.String r0 = r11.stringVal()     // Catch:{ all -> 0x0043 }
            int r3 = r0.length()     // Catch:{ all -> 0x0043 }
            if (r3 != 0) goto L_0x0098
            r11.nextToken()     // Catch:{ all -> 0x0043 }
            r9.setContext(r15)
            return r14
        L_0x0098:
            com.alibaba.fastjson.util.JavaBeanInfo r3 = r8.beanInfo     // Catch:{ all -> 0x0043 }
            com.alibaba.fastjson.annotation.JSONType r3 = r3.jsonType     // Catch:{ all -> 0x0043 }
            if (r3 == 0) goto L_0x00bc
            java.lang.Class[] r3 = r3.seeAlso()     // Catch:{ all -> 0x0043 }
            int r7 = r3.length     // Catch:{ all -> 0x0043 }
            r13 = 0
        L_0x00a4:
            if (r13 >= r7) goto L_0x00bc
            r4 = r3[r13]     // Catch:{ all -> 0x0043 }
            java.lang.Class<java.lang.Enum> r2 = java.lang.Enum.class
            boolean r2 = r2.isAssignableFrom(r4)     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x00b8
            java.lang.Enum r0 = java.lang.Enum.valueOf(r4, r0)     // Catch:{ IllegalArgumentException -> 0x00b8 }
            r9.setContext(r15)
            return r0
        L_0x00b8:
            int r13 = r13 + 1
            r4 = 4
            goto L_0x00a4
        L_0x00bc:
            r0 = 14
            goto L_0x00c5
        L_0x00bf:
            if (r1 != r7) goto L_0x00bc
            r11.getCalendar()     // Catch:{ all -> 0x0043 }
            goto L_0x00bc
        L_0x00c5:
            if (r1 != r0) goto L_0x00d9
            char r0 = r11.getCurrent()     // Catch:{ all -> 0x0043 }
            r2 = 93
            if (r0 != r2) goto L_0x00d9
            r11.next()     // Catch:{ all -> 0x0043 }
            r11.nextToken()     // Catch:{ all -> 0x0043 }
            r9.setContext(r15)
            return r14
        L_0x00d9:
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r8.beanInfo     // Catch:{ all -> 0x0043 }
            java.lang.reflect.Method r2 = r0.factoryMethod     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0122
            com.alibaba.fastjson.util.FieldInfo[] r0 = r0.fields     // Catch:{ all -> 0x0043 }
            int r2 = r0.length     // Catch:{ all -> 0x0043 }
            r3 = 1
            if (r2 != r3) goto L_0x0122
            r2 = 0
            r0 = r0[r2]     // Catch:{ Exception -> 0x0102 }
            java.lang.Class<?> r0 = r0.fieldClass     // Catch:{ Exception -> 0x0102 }
            if (r0 != r6) goto L_0x0104
            r2 = 2
            if (r1 != r2) goto L_0x0122
            int r0 = r11.intValue()     // Catch:{ Exception -> 0x0102 }
            r11.nextToken()     // Catch:{ Exception -> 0x0102 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0102 }
            java.lang.Object r0 = r8.createFactoryInstance(r12, r0)     // Catch:{ Exception -> 0x0102 }
            r9.setContext(r15)
            return r0
        L_0x0102:
            r0 = move-exception
            goto L_0x0118
        L_0x0104:
            if (r0 != r5) goto L_0x0122
            r0 = 4
            if (r1 != r0) goto L_0x0122
            java.lang.String r0 = r11.stringVal()     // Catch:{ Exception -> 0x0102 }
            r11.nextToken()     // Catch:{ Exception -> 0x0102 }
            java.lang.Object r0 = r8.createFactoryInstance(r12, r0)     // Catch:{ Exception -> 0x0102 }
            r9.setContext(r15)
            return r0
        L_0x0118:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0043 }
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x0043 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0043 }
            throw r1     // Catch:{ all -> 0x0043 }
        L_0x0122:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r0.<init>()     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "syntax error, expect {, actual "
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = r11.tokenName()     // Catch:{ all -> 0x0043 }
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = ", pos "
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            int r1 = r11.pos()     // Catch:{ all -> 0x0043 }
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            boolean r1 = r10 instanceof java.lang.String     // Catch:{ all -> 0x0043 }
            if (r1 == 0) goto L_0x014b
            java.lang.String r1 = ", fieldName "
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            r0.append(r10)     // Catch:{ all -> 0x0043 }
        L_0x014b:
            java.lang.String r1 = ", fastjson-version "
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "1.2.67"
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0043 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0043 }
            r1.<init>(r0)     // Catch:{ all -> 0x0043 }
            throw r1     // Catch:{ all -> 0x0043 }
        L_0x015f:
            int r1 = r9.resolveStatus     // Catch:{ all -> 0x0937 }
            r2 = 2
            if (r1 != r2) goto L_0x0168
            r3 = 0
            r9.resolveStatus = r3     // Catch:{ all -> 0x0043 }
            goto L_0x0169
        L_0x0168:
            r3 = 0
        L_0x0169:
            com.alibaba.fastjson.util.JavaBeanInfo r1 = r8.beanInfo     // Catch:{ all -> 0x0937 }
            java.lang.String r4 = r1.typeKey     // Catch:{ all -> 0x0937 }
            r1 = r36
            r2 = r38
            r7 = r3
            r20 = r14
            r3 = r20
            r14 = r7
        L_0x0177:
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r13 = r8.sortedFieldDeserializers     // Catch:{ all -> 0x0933 }
            int r0 = r13.length     // Catch:{ all -> 0x0933 }
            if (r14 >= r0) goto L_0x01ab
            r0 = 16
            if (r7 >= r0) goto L_0x01ab
            r0 = r13[r14]     // Catch:{ all -> 0x01a2 }
            com.alibaba.fastjson.util.FieldInfo r13 = r0.fieldInfo     // Catch:{ all -> 0x01a2 }
            r36 = r14
            java.lang.Class<?> r14 = r13.fieldClass     // Catch:{ all -> 0x01a2 }
            com.alibaba.fastjson.annotation.JSONField r21 = r13.getAnnotation()     // Catch:{ all -> 0x01a2 }
            if (r21 == 0) goto L_0x01a7
            r38 = r13
            boolean r13 = r0 instanceof com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer     // Catch:{ all -> 0x01a2 }
            if (r13 == 0) goto L_0x01a9
            r13 = r0
            com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer r13 = (com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer) r13     // Catch:{ all -> 0x01a2 }
            boolean r13 = r13.customDeserilizer     // Catch:{ all -> 0x01a2 }
        L_0x0199:
            r31 = r14
            r14 = r38
            r38 = r2
            r2 = r31
            goto L_0x01b5
        L_0x01a2:
            r0 = move-exception
            r6 = r1
        L_0x01a4:
            r14 = r3
            goto L_0x093b
        L_0x01a7:
            r38 = r13
        L_0x01a9:
            r13 = 0
            goto L_0x0199
        L_0x01ab:
            r36 = r14
            r38 = r2
            r0 = 0
            r2 = 0
            r13 = 0
            r14 = 0
            r21 = 0
        L_0x01b5:
            r22 = 0
            r24 = 0
            r25 = 0
            if (r0 == 0) goto L_0x03c3
            r27 = r1
            char[] r1 = r14.name_chars     // Catch:{ all -> 0x01d3 }
            if (r13 == 0) goto L_0x01d9
            boolean r13 = r11.matchField((char[]) r1)     // Catch:{ all -> 0x01d3 }
            if (r13 == 0) goto L_0x01d9
            r29 = r5
            r28 = r12
        L_0x01cd:
            r1 = 0
            r5 = 1
        L_0x01cf:
            r12 = 5
        L_0x01d0:
            r13 = 0
            goto L_0x03cf
        L_0x01d3:
            r0 = move-exception
            r14 = r3
            r6 = r27
            goto L_0x093b
        L_0x01d9:
            java.lang.Class r13 = java.lang.Integer.TYPE     // Catch:{ all -> 0x01d3 }
            r28 = r12
            r12 = -2
            if (r2 == r13) goto L_0x01e2
            if (r2 != r6) goto L_0x01e6
        L_0x01e2:
            r29 = r5
            goto L_0x038f
        L_0x01e6:
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ all -> 0x01d3 }
            if (r2 == r13) goto L_0x01ee
            java.lang.Class<java.lang.Long> r13 = java.lang.Long.class
            if (r2 != r13) goto L_0x01f2
        L_0x01ee:
            r29 = r5
            goto L_0x0373
        L_0x01f2:
            if (r2 != r5) goto L_0x0222
            java.lang.String r1 = r11.scanFieldString(r1)     // Catch:{ all -> 0x01d3 }
            int r13 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            if (r13 <= 0) goto L_0x0203
        L_0x01fc:
            r29 = r5
            r5 = 1
            r12 = 5
        L_0x0200:
            r13 = 1
            goto L_0x03cf
        L_0x0203:
            if (r13 != r12) goto L_0x021e
        L_0x0205:
            int r7 = r7 + 1
            r13 = r34
            r17 = r4
            r12 = r5
            r19 = r6
            r18 = r20
            r0 = r28
        L_0x0212:
            r1 = 1
            r2 = 16
            r4 = 0
            r14 = 13
        L_0x0218:
            r16 = 5
        L_0x021a:
            r20 = r38
            goto L_0x08fa
        L_0x021e:
            r29 = r5
            r5 = 0
            goto L_0x01cf
        L_0x0222:
            java.lang.Class<java.util.Date> r13 = java.util.Date.class
            if (r2 != r13) goto L_0x0236
            java.lang.String r13 = r14.format     // Catch:{ all -> 0x01d3 }
            if (r13 != 0) goto L_0x0236
            java.util.Date r1 = r11.scanFieldDate(r1)     // Catch:{ all -> 0x01d3 }
            int r13 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            if (r13 <= 0) goto L_0x0233
            goto L_0x01fc
        L_0x0233:
            if (r13 != r12) goto L_0x021e
            goto L_0x0205
        L_0x0236:
            java.lang.Class<java.math.BigDecimal> r13 = java.math.BigDecimal.class
            if (r2 != r13) goto L_0x0246
            java.math.BigDecimal r1 = r11.scanFieldDecimal(r1)     // Catch:{ all -> 0x01d3 }
            int r13 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            if (r13 <= 0) goto L_0x0243
            goto L_0x01fc
        L_0x0243:
            if (r13 != r12) goto L_0x021e
            goto L_0x0205
        L_0x0246:
            java.lang.Class<java.math.BigInteger> r13 = java.math.BigInteger.class
            if (r2 != r13) goto L_0x0256
            java.math.BigInteger r1 = r11.scanFieldBigInteger(r1)     // Catch:{ all -> 0x01d3 }
            int r13 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            if (r13 <= 0) goto L_0x0253
            goto L_0x01fc
        L_0x0253:
            if (r13 != r12) goto L_0x021e
            goto L_0x0205
        L_0x0256:
            java.lang.Class r13 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x01d3 }
            if (r2 == r13) goto L_0x025e
            java.lang.Class<java.lang.Boolean> r13 = java.lang.Boolean.class
            if (r2 != r13) goto L_0x0262
        L_0x025e:
            r29 = r5
            goto L_0x035b
        L_0x0262:
            java.lang.Class r13 = java.lang.Float.TYPE     // Catch:{ all -> 0x01d3 }
            if (r2 == r13) goto L_0x026a
            java.lang.Class<java.lang.Float> r13 = java.lang.Float.class
            if (r2 != r13) goto L_0x026e
        L_0x026a:
            r29 = r5
            goto L_0x033f
        L_0x026e:
            java.lang.Class r13 = java.lang.Double.TYPE     // Catch:{ all -> 0x01d3 }
            if (r2 == r13) goto L_0x0309
            java.lang.Class<java.lang.Double> r13 = java.lang.Double.class
            if (r2 != r13) goto L_0x0278
            goto L_0x0309
        L_0x0278:
            boolean r13 = r2.isEnum()     // Catch:{ all -> 0x01d3 }
            if (r13 == 0) goto L_0x02ba
            com.alibaba.fastjson.parser.ParserConfig r13 = r33.getConfig()     // Catch:{ all -> 0x01d3 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r13 = r13.getDeserializer((java.lang.reflect.Type) r2)     // Catch:{ all -> 0x01d3 }
            boolean r13 = r13 instanceof com.alibaba.fastjson.parser.deserializer.EnumDeserializer     // Catch:{ all -> 0x01d3 }
            if (r13 == 0) goto L_0x02ba
            if (r21 == 0) goto L_0x0294
            java.lang.Class r13 = r21.deserializeUsing()     // Catch:{ all -> 0x01d3 }
            java.lang.Class<java.lang.Void> r12 = java.lang.Void.class
            if (r13 != r12) goto L_0x02ba
        L_0x0294:
            boolean r12 = r0 instanceof com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer     // Catch:{ all -> 0x01d3 }
            if (r12 == 0) goto L_0x02b5
            r12 = r0
            com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer r12 = (com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer) r12     // Catch:{ all -> 0x01d3 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r12 = r12.fieldValueDeserilizer     // Catch:{ all -> 0x01d3 }
            java.lang.Enum r1 = r8.scanEnum(r11, r1, r12)     // Catch:{ all -> 0x01d3 }
            int r12 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            if (r12 <= 0) goto L_0x02a8
            r12 = 1
            r13 = 1
            goto L_0x02af
        L_0x02a8:
            r13 = -2
            if (r12 != r13) goto L_0x02ad
            goto L_0x0205
        L_0x02ad:
            r12 = 0
            r13 = 0
        L_0x02af:
            r29 = r5
            r5 = r12
        L_0x02b2:
            r12 = 5
            goto L_0x03cf
        L_0x02b5:
            r29 = r5
        L_0x02b7:
            r12 = 5
            goto L_0x03cb
        L_0x02ba:
            java.lang.Class<int[]> r12 = int[].class
            if (r2 != r12) goto L_0x02cd
            int[] r1 = r11.scanFieldIntArray(r1)     // Catch:{ all -> 0x01d3 }
            int r12 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            if (r12 <= 0) goto L_0x02c8
            goto L_0x01fc
        L_0x02c8:
            r13 = -2
            if (r12 != r13) goto L_0x021e
            goto L_0x0205
        L_0x02cd:
            java.lang.Class<float[]> r12 = float[].class
            if (r2 != r12) goto L_0x02e0
            float[] r1 = r11.scanFieldFloatArray(r1)     // Catch:{ all -> 0x01d3 }
            int r12 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            if (r12 <= 0) goto L_0x02db
            goto L_0x01fc
        L_0x02db:
            r13 = -2
            if (r12 != r13) goto L_0x021e
            goto L_0x0205
        L_0x02e0:
            java.lang.Class<float[][]> r12 = float[][].class
            if (r2 != r12) goto L_0x02f3
            float[][] r1 = r11.scanFieldFloatArray2(r1)     // Catch:{ all -> 0x01d3 }
            int r12 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            if (r12 <= 0) goto L_0x02ee
            goto L_0x01fc
        L_0x02ee:
            r13 = -2
            if (r12 != r13) goto L_0x021e
            goto L_0x0205
        L_0x02f3:
            boolean r1 = r11.matchField((char[]) r1)     // Catch:{ all -> 0x01d3 }
            r29 = r5
            if (r1 == 0) goto L_0x02fd
            goto L_0x01cd
        L_0x02fd:
            r21 = r6
            r30 = r7
        L_0x0301:
            r6 = r27
            r7 = r28
            r1 = 13
            goto L_0x056b
        L_0x0309:
            double r12 = r11.scanFieldDouble(r1)     // Catch:{ all -> 0x01d3 }
            int r1 = (r12 > r25 ? 1 : (r12 == r25 ? 0 : -1))
            if (r1 != 0) goto L_0x031a
            int r1 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            r29 = r5
            r5 = 5
            if (r1 != r5) goto L_0x031c
            r1 = 0
            goto L_0x0320
        L_0x031a:
            r29 = r5
        L_0x031c:
            java.lang.Double r1 = java.lang.Double.valueOf(r12)     // Catch:{ all -> 0x01d3 }
        L_0x0320:
            int r5 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            if (r5 <= 0) goto L_0x0327
        L_0x0324:
            r5 = 1
            r12 = 1
            goto L_0x033c
        L_0x0327:
            r12 = -2
            if (r5 != r12) goto L_0x033a
        L_0x032a:
            int r7 = r7 + 1
            r13 = r34
            r17 = r4
            r19 = r6
            r18 = r20
            r0 = r28
            r12 = r29
            goto L_0x0212
        L_0x033a:
            r5 = 0
            r12 = 0
        L_0x033c:
            r13 = r12
            goto L_0x02b2
        L_0x033f:
            float r1 = r11.scanFieldFloat(r1)     // Catch:{ all -> 0x01d3 }
            int r5 = (r1 > r24 ? 1 : (r1 == r24 ? 0 : -1))
            if (r5 != 0) goto L_0x034e
            int r5 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            r12 = 5
            if (r5 != r12) goto L_0x034e
            r1 = 0
            goto L_0x0352
        L_0x034e:
            java.lang.Float r1 = java.lang.Float.valueOf(r1)     // Catch:{ all -> 0x01d3 }
        L_0x0352:
            int r5 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            if (r5 <= 0) goto L_0x0357
            goto L_0x0324
        L_0x0357:
            r12 = -2
            if (r5 != r12) goto L_0x033a
        L_0x035a:
            goto L_0x032a
        L_0x035b:
            boolean r1 = r11.scanFieldBoolean(r1)     // Catch:{ all -> 0x01d3 }
            int r5 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            r12 = 5
            if (r5 != r12) goto L_0x0366
            r1 = 0
            goto L_0x036a
        L_0x0366:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x01d3 }
        L_0x036a:
            int r5 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            if (r5 <= 0) goto L_0x036f
            goto L_0x0324
        L_0x036f:
            r12 = -2
            if (r5 != r12) goto L_0x033a
            goto L_0x035a
        L_0x0373:
            long r12 = r11.scanFieldLong(r1)     // Catch:{ all -> 0x01d3 }
            int r1 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r1 != 0) goto L_0x0382
            int r1 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            r5 = 5
            if (r1 != r5) goto L_0x0382
            r1 = 0
            goto L_0x0386
        L_0x0382:
            java.lang.Long r1 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x01d3 }
        L_0x0386:
            int r5 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            if (r5 <= 0) goto L_0x038b
            goto L_0x0324
        L_0x038b:
            r12 = -2
            if (r5 != r12) goto L_0x033a
            goto L_0x035a
        L_0x038f:
            int r1 = r11.scanFieldInt(r1)     // Catch:{ all -> 0x01d3 }
            if (r1 != 0) goto L_0x039c
            int r5 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            r12 = 5
            if (r5 != r12) goto L_0x039d
            r1 = 0
            goto L_0x03a1
        L_0x039c:
            r12 = 5
        L_0x039d:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x01d3 }
        L_0x03a1:
            int r5 = r11.matchStat     // Catch:{ all -> 0x01d3 }
            if (r5 <= 0) goto L_0x03a8
            r5 = 1
            goto L_0x0200
        L_0x03a8:
            r13 = -2
            if (r5 != r13) goto L_0x03cc
            int r7 = r7 + 1
            r13 = r34
            r17 = r4
            r19 = r6
            r16 = r12
            r18 = r20
            r0 = r28
            r12 = r29
            r1 = 1
            r2 = 16
            r4 = 0
            r14 = 13
            goto L_0x021a
        L_0x03c3:
            r27 = r1
            r29 = r5
            r28 = r12
            goto L_0x02b7
        L_0x03cb:
            r1 = 0
        L_0x03cc:
            r5 = 0
            goto L_0x01d0
        L_0x03cf:
            if (r5 != 0) goto L_0x0592
            com.alibaba.fastjson.parser.SymbolTable r12 = r9.symbolTable     // Catch:{ all -> 0x0550 }
            java.lang.String r12 = r11.scanSymbol(r12)     // Catch:{ all -> 0x0550 }
            if (r12 != 0) goto L_0x03fc
            r21 = r6
            int r6 = r11.token()     // Catch:{ all -> 0x01d3 }
            r30 = r7
            r7 = 13
            if (r6 != r7) goto L_0x03ee
            r7 = 16
            r11.nextToken(r7)     // Catch:{ all -> 0x01d3 }
            r6 = r27
            goto L_0x0560
        L_0x03ee:
            r7 = 16
            if (r6 != r7) goto L_0x0400
            com.alibaba.fastjson.parser.Feature r6 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x01d3 }
            boolean r6 = r11.isEnabled((com.alibaba.fastjson.parser.Feature) r6)     // Catch:{ all -> 0x01d3 }
            if (r6 == 0) goto L_0x0400
            goto L_0x0301
        L_0x03fc:
            r21 = r6
            r30 = r7
        L_0x0400:
            java.lang.String r6 = "$ref"
            if (r6 != r12) goto L_0x04da
            if (r15 == 0) goto L_0x04da
            r6 = 4
            r11.nextTokenWithColon(r6)     // Catch:{ all -> 0x01d3 }
            int r0 = r11.token()     // Catch:{ all -> 0x01d3 }
            if (r0 != r6) goto L_0x04bf
            java.lang.String r0 = r11.stringVal()     // Catch:{ all -> 0x01d3 }
            java.lang.String r1 = "@"
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x01d3 }
            if (r1 == 0) goto L_0x0423
            java.lang.Object r0 = r15.object     // Catch:{ all -> 0x01d3 }
            r1 = r0
        L_0x041f:
            r0 = 13
            goto L_0x049e
        L_0x0423:
            java.lang.String r1 = ".."
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x01d3 }
            if (r1 == 0) goto L_0x043f
            com.alibaba.fastjson.parser.ParseContext r1 = r15.parent     // Catch:{ all -> 0x01d3 }
            java.lang.Object r2 = r1.object     // Catch:{ all -> 0x01d3 }
            if (r2 == 0) goto L_0x0433
        L_0x0431:
            r1 = r2
            goto L_0x041f
        L_0x0433:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r2 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x01d3 }
            r2.<init>(r1, r0)     // Catch:{ all -> 0x01d3 }
            r9.addResolveTask(r2)     // Catch:{ all -> 0x01d3 }
            r0 = 1
            r9.resolveStatus = r0     // Catch:{ all -> 0x01d3 }
            goto L_0x049b
        L_0x043f:
            java.lang.String r1 = "$"
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x01d3 }
            if (r1 == 0) goto L_0x045f
            r1 = r15
        L_0x0448:
            com.alibaba.fastjson.parser.ParseContext r2 = r1.parent     // Catch:{ all -> 0x01d3 }
            if (r2 == 0) goto L_0x044e
            r1 = r2
            goto L_0x0448
        L_0x044e:
            java.lang.Object r2 = r1.object     // Catch:{ all -> 0x01d3 }
            if (r2 == 0) goto L_0x0453
            goto L_0x0431
        L_0x0453:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r2 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x01d3 }
            r2.<init>(r1, r0)     // Catch:{ all -> 0x01d3 }
            r9.addResolveTask(r2)     // Catch:{ all -> 0x01d3 }
            r0 = 1
            r9.resolveStatus = r0     // Catch:{ all -> 0x01d3 }
            goto L_0x049b
        L_0x045f:
            r1 = 92
            int r2 = r0.indexOf(r1)     // Catch:{ all -> 0x01d3 }
            if (r2 <= 0) goto L_0x0489
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d3 }
            r2.<init>()     // Catch:{ all -> 0x01d3 }
            r4 = 0
        L_0x046d:
            int r5 = r0.length()     // Catch:{ all -> 0x01d3 }
            if (r4 >= r5) goto L_0x0485
            char r5 = r0.charAt(r4)     // Catch:{ all -> 0x01d3 }
            if (r5 != r1) goto L_0x047f
            int r4 = r4 + 1
            char r5 = r0.charAt(r4)     // Catch:{ all -> 0x01d3 }
        L_0x047f:
            r2.append(r5)     // Catch:{ all -> 0x01d3 }
            r5 = 1
            int r4 = r4 + r5
            goto L_0x046d
        L_0x0485:
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x01d3 }
        L_0x0489:
            java.lang.Object r1 = r9.resolveReference(r0)     // Catch:{ all -> 0x01d3 }
            if (r1 == 0) goto L_0x0490
            goto L_0x041f
        L_0x0490:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r1 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x01d3 }
            r1.<init>(r15, r0)     // Catch:{ all -> 0x01d3 }
            r9.addResolveTask(r1)     // Catch:{ all -> 0x01d3 }
            r0 = 1
            r9.resolveStatus = r0     // Catch:{ all -> 0x01d3 }
        L_0x049b:
            r1 = r27
            goto L_0x041f
        L_0x049e:
            r11.nextToken(r0)     // Catch:{ all -> 0x01a2 }
            int r2 = r11.token()     // Catch:{ all -> 0x01a2 }
            if (r2 != r0) goto L_0x04b7
            r0 = 16
            r11.nextToken(r0)     // Catch:{ all -> 0x01a2 }
            r9.setContext(r15, r1, r10)     // Catch:{ all -> 0x01a2 }
            if (r3 == 0) goto L_0x04b3
            r3.object = r1
        L_0x04b3:
            r9.setContext(r15)
            return r1
        L_0x04b7:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x01a2 }
            java.lang.String r2 = "illegal ref"
            r0.<init>(r2)     // Catch:{ all -> 0x01a2 }
            throw r0     // Catch:{ all -> 0x01a2 }
        L_0x04bf:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x01d3 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d3 }
            r2.<init>()     // Catch:{ all -> 0x01d3 }
            java.lang.String r4 = "illegal ref, "
            r2.append(r4)     // Catch:{ all -> 0x01d3 }
            java.lang.String r0 = com.alibaba.fastjson.parser.JSONToken.name(r0)     // Catch:{ all -> 0x01d3 }
            r2.append(r0)     // Catch:{ all -> 0x01d3 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x01d3 }
            r1.<init>(r0)     // Catch:{ all -> 0x01d3 }
            throw r1     // Catch:{ all -> 0x01d3 }
        L_0x04da:
            if (r4 == 0) goto L_0x04e5
            boolean r6 = r4.equals(r12)     // Catch:{ all -> 0x01d3 }
            if (r6 != 0) goto L_0x04e3
            goto L_0x04e5
        L_0x04e3:
            r0 = 4
            goto L_0x04ea
        L_0x04e5:
            java.lang.String r6 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x0550 }
            if (r6 != r12) goto L_0x058b
            goto L_0x04e3
        L_0x04ea:
            r11.nextTokenWithColon(r0)     // Catch:{ all -> 0x0550 }
            int r1 = r11.token()     // Catch:{ all -> 0x0550 }
            if (r1 != r0) goto L_0x0581
            java.lang.String r0 = r11.stringVal()     // Catch:{ all -> 0x0550 }
            r1 = 16
            r11.nextToken(r1)     // Catch:{ all -> 0x0550 }
            com.alibaba.fastjson.util.JavaBeanInfo r1 = r8.beanInfo     // Catch:{ all -> 0x0550 }
            java.lang.String r1 = r1.typeName     // Catch:{ all -> 0x0550 }
            boolean r1 = r0.equals(r1)     // Catch:{ all -> 0x0550 }
            if (r1 != 0) goto L_0x050e
            com.alibaba.fastjson.parser.Feature r1 = com.alibaba.fastjson.parser.Feature.IgnoreAutoType     // Catch:{ all -> 0x0550 }
            boolean r1 = r9.isEnabled(r1)     // Catch:{ all -> 0x0550 }
            if (r1 == 0) goto L_0x0513
        L_0x050e:
            r6 = r27
            r7 = r28
            goto L_0x0555
        L_0x0513:
            com.alibaba.fastjson.util.JavaBeanInfo r1 = r8.beanInfo     // Catch:{ all -> 0x0550 }
            r7 = r28
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r1 = getSeeAlso(r7, r1, r0)     // Catch:{ all -> 0x0550 }
            if (r1 != 0) goto L_0x0532
            java.lang.Class r1 = com.alibaba.fastjson.util.TypeUtils.getClass(r34)     // Catch:{ all -> 0x01d3 }
            int r2 = r11.getFeatures()     // Catch:{ all -> 0x01d3 }
            java.lang.Class r14 = r7.checkAutoType(r0, r1, r2)     // Catch:{ all -> 0x01d3 }
            com.alibaba.fastjson.parser.ParserConfig r1 = r33.getConfig()     // Catch:{ all -> 0x01d3 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r1 = r1.getDeserializer((java.lang.reflect.Type) r14)     // Catch:{ all -> 0x01d3 }
            goto L_0x0533
        L_0x0532:
            r14 = 0
        L_0x0533:
            java.lang.Object r2 = r1.deserialze(r9, r14, r10)     // Catch:{ all -> 0x0550 }
            boolean r5 = r1 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer     // Catch:{ all -> 0x0550 }
            if (r5 == 0) goto L_0x0546
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r1 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r1     // Catch:{ all -> 0x01d3 }
            if (r4 == 0) goto L_0x0546
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r1 = r1.getFieldDeserializer((java.lang.String) r4)     // Catch:{ all -> 0x01d3 }
            r1.setValue((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ all -> 0x01d3 }
        L_0x0546:
            if (r3 == 0) goto L_0x054c
            r6 = r27
            r3.object = r6
        L_0x054c:
            r9.setContext(r15)
            return r2
        L_0x0550:
            r0 = move-exception
            r6 = r27
            goto L_0x01a4
        L_0x0555:
            int r0 = r11.token()     // Catch:{ all -> 0x0568 }
            r1 = 13
            if (r0 != r1) goto L_0x056b
            r11.nextToken()     // Catch:{ all -> 0x0568 }
        L_0x0560:
            r13 = r34
            r0 = r20
            r12 = r29
            goto L_0x06b4
        L_0x0568:
            r0 = move-exception
            goto L_0x01a4
        L_0x056b:
            r13 = r34
            r14 = r1
            r17 = r4
            r27 = r6
            r0 = r7
            r18 = r20
            r19 = r21
            r12 = r29
            r7 = r30
            r1 = 1
            r2 = 16
            r4 = 0
            goto L_0x0218
        L_0x0581:
            r6 = r27
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0568 }
            java.lang.String r1 = "syntax error"
            r0.<init>(r1)     // Catch:{ all -> 0x0568 }
            throw r0     // Catch:{ all -> 0x0568 }
        L_0x058b:
            r6 = r27
            r7 = r28
            r16 = 13
            goto L_0x059d
        L_0x0592:
            r21 = r6
            r30 = r7
            r6 = r27
            r7 = r28
            r16 = 13
            r12 = 0
        L_0x059d:
            if (r6 != 0) goto L_0x05e4
            if (r20 != 0) goto L_0x05e4
            java.lang.Object r6 = r32.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r33, (java.lang.reflect.Type) r34)     // Catch:{ all -> 0x05e0 }
            if (r6 != 0) goto L_0x05bb
            r27 = r3
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x05b6 }
            r28 = r4
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r4 = r8.fieldDeserializers     // Catch:{ all -> 0x05b6 }
            int r4 = r4.length     // Catch:{ all -> 0x05b6 }
            r3.<init>(r4)     // Catch:{ all -> 0x05b6 }
            r20 = r3
            goto L_0x05bf
        L_0x05b6:
            r0 = move-exception
        L_0x05b7:
            r14 = r27
            goto L_0x093b
        L_0x05bb:
            r27 = r3
            r28 = r4
        L_0x05bf:
            com.alibaba.fastjson.parser.ParseContext r3 = r9.setContext(r15, r6, r10)     // Catch:{ all -> 0x05b6 }
            if (r38 != 0) goto L_0x05d9
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r4 = r8.fieldDeserializers     // Catch:{ all -> 0x0568 }
            int r4 = r4.length     // Catch:{ all -> 0x0568 }
            int r4 = r4 / 32
            r19 = 1
            int r4 = r4 + 1
            int[] r4 = new int[r4]     // Catch:{ all -> 0x0568 }
            r27 = r3
            r31 = r20
            r20 = r4
            r4 = r31
            goto L_0x05e9
        L_0x05d9:
            r27 = r3
        L_0x05db:
            r4 = r20
            r20 = r38
            goto L_0x05e9
        L_0x05e0:
            r0 = move-exception
        L_0x05e1:
            r27 = r3
            goto L_0x05b7
        L_0x05e4:
            r27 = r3
            r28 = r4
            goto L_0x05db
        L_0x05e9:
            if (r5 == 0) goto L_0x0649
            if (r13 != 0) goto L_0x0605
            r13 = r34
            r0.parseField(r9, r6, r13, r4)     // Catch:{ all -> 0x05b6 }
        L_0x05f2:
            r18 = r4
            r0 = r7
            r14 = r16
            r19 = r21
            r17 = r28
            r12 = r29
            r28 = r30
            r16 = 5
            r21 = r6
            goto L_0x069b
        L_0x0605:
            r13 = r34
            if (r6 != 0) goto L_0x060f
            java.lang.String r0 = r14.name     // Catch:{ all -> 0x05b6 }
            r4.put(r0, r1)     // Catch:{ all -> 0x05b6 }
            goto L_0x062c
        L_0x060f:
            if (r1 != 0) goto L_0x0629
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x05b6 }
            if (r2 == r3) goto L_0x062c
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x05b6 }
            if (r2 == r3) goto L_0x062c
            java.lang.Class r3 = java.lang.Float.TYPE     // Catch:{ all -> 0x05b6 }
            if (r2 == r3) goto L_0x062c
            java.lang.Class r3 = java.lang.Double.TYPE     // Catch:{ all -> 0x05b6 }
            if (r2 == r3) goto L_0x062c
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x05b6 }
            if (r2 == r3) goto L_0x062c
            r0.setValue((java.lang.Object) r6, (java.lang.Object) r1)     // Catch:{ all -> 0x05b6 }
            goto L_0x062c
        L_0x0629:
            r0.setValue((java.lang.Object) r6, (java.lang.Object) r1)     // Catch:{ all -> 0x05b6 }
        L_0x062c:
            if (r20 == 0) goto L_0x063b
            int r14 = r36 / 32
            int r0 = r36 % 32
            r1 = r20[r14]     // Catch:{ all -> 0x05b6 }
            r2 = 1
            int r0 = r2 << r0
            r0 = r0 | r1
            r20[r14] = r0     // Catch:{ all -> 0x05b6 }
            goto L_0x063c
        L_0x063b:
            r2 = 1
        L_0x063c:
            int r0 = r11.matchStat     // Catch:{ all -> 0x05b6 }
            r5 = 4
            if (r0 != r5) goto L_0x05f2
            r18 = r4
            r21 = r6
            r12 = r29
            goto L_0x06ae
        L_0x0649:
            r13 = r34
            r2 = 1
            r5 = 4
            if (r4 != 0) goto L_0x0658
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x05b6 }
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r1 = r8.fieldDeserializers     // Catch:{ all -> 0x05b6 }
            int r1 = r1.length     // Catch:{ all -> 0x05b6 }
            r0.<init>(r1)     // Catch:{ all -> 0x05b6 }
            goto L_0x0659
        L_0x0658:
            r0 = r4
        L_0x0659:
            r1 = r32
            r3 = r2
            r14 = 0
            r2 = r33
            r3 = r12
            r18 = r4
            r12 = r5
            r17 = r28
            r4 = r6
            r12 = r29
            r5 = r34
            r19 = r21
            r21 = r6
            r6 = r0
            r0 = r7
            r14 = r16
            r28 = r30
            r16 = 5
            r7 = r20
            boolean r1 = r1.parseField(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0688 }
            if (r1 != 0) goto L_0x0693
            int r1 = r11.token()     // Catch:{ all -> 0x0688 }
            if (r1 != r14) goto L_0x068d
            r11.nextToken()     // Catch:{ all -> 0x0688 }
            goto L_0x06ae
        L_0x0688:
            r0 = move-exception
            r6 = r21
            goto L_0x05b7
        L_0x068d:
            r1 = 1
            r2 = 16
        L_0x0690:
            r4 = 0
            goto L_0x08f4
        L_0x0693:
            int r1 = r11.token()     // Catch:{ all -> 0x0688 }
            r2 = 17
            if (r1 == r2) goto L_0x092b
        L_0x069b:
            int r1 = r11.token()     // Catch:{ all -> 0x0688 }
            r2 = 16
            if (r1 != r2) goto L_0x06a5
            r1 = 1
            goto L_0x0690
        L_0x06a5:
            int r1 = r11.token()     // Catch:{ all -> 0x0688 }
            if (r1 != r14) goto L_0x08e4
            r11.nextToken(r2)     // Catch:{ all -> 0x0688 }
        L_0x06ae:
            r0 = r18
            r6 = r21
            r3 = r27
        L_0x06b4:
            if (r6 != 0) goto L_0x08be
            if (r0 != 0) goto L_0x06ca
            java.lang.Object r1 = r32.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r33, (java.lang.reflect.Type) r34)     // Catch:{ all -> 0x0568 }
            if (r3 != 0) goto L_0x06c2
            com.alibaba.fastjson.parser.ParseContext r3 = r9.setContext(r15, r1, r10)     // Catch:{ all -> 0x01a2 }
        L_0x06c2:
            if (r3 == 0) goto L_0x06c6
            r3.object = r1
        L_0x06c6:
            r9.setContext(r15)
            return r1
        L_0x06ca:
            com.alibaba.fastjson.util.JavaBeanInfo r1 = r8.beanInfo     // Catch:{ all -> 0x0568 }
            java.lang.String[] r2 = r1.creatorConstructorParameters     // Catch:{ all -> 0x0568 }
            java.lang.String r4 = ""
            if (r2 == 0) goto L_0x0773
            int r1 = r2.length     // Catch:{ all -> 0x0568 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0568 }
            r5 = 0
        L_0x06d6:
            int r7 = r2.length     // Catch:{ all -> 0x0568 }
            if (r5 >= r7) goto L_0x07e0
            r7 = r2[r5]     // Catch:{ all -> 0x0568 }
            java.lang.Object r7 = r0.remove(r7)     // Catch:{ all -> 0x0568 }
            if (r7 != 0) goto L_0x0739
            com.alibaba.fastjson.util.JavaBeanInfo r10 = r8.beanInfo     // Catch:{ all -> 0x0568 }
            java.lang.reflect.Type[] r11 = r10.creatorConstructorParameterTypes     // Catch:{ all -> 0x0568 }
            r11 = r11[r5]     // Catch:{ all -> 0x0568 }
            com.alibaba.fastjson.util.FieldInfo[] r10 = r10.fields     // Catch:{ all -> 0x0568 }
            r10 = r10[r5]     // Catch:{ all -> 0x0568 }
            java.lang.Class r13 = java.lang.Byte.TYPE     // Catch:{ all -> 0x0568 }
            if (r11 != r13) goto L_0x06f6
            r13 = 0
            java.lang.Byte r7 = java.lang.Byte.valueOf(r13)     // Catch:{ all -> 0x0568 }
            goto L_0x076d
        L_0x06f6:
            r13 = 0
            java.lang.Class r14 = java.lang.Short.TYPE     // Catch:{ all -> 0x0568 }
            if (r11 != r14) goto L_0x0701
            java.lang.Short r7 = java.lang.Short.valueOf(r13)     // Catch:{ all -> 0x0568 }
            goto L_0x076d
        L_0x0701:
            java.lang.Class r14 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0568 }
            if (r11 != r14) goto L_0x070a
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0568 }
            goto L_0x076d
        L_0x070a:
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ all -> 0x0568 }
            if (r11 != r13) goto L_0x0713
            java.lang.Long r7 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x0568 }
            goto L_0x076d
        L_0x0713:
            java.lang.Class r13 = java.lang.Float.TYPE     // Catch:{ all -> 0x0568 }
            if (r11 != r13) goto L_0x071c
            java.lang.Float r7 = java.lang.Float.valueOf(r24)     // Catch:{ all -> 0x0568 }
            goto L_0x076d
        L_0x071c:
            java.lang.Class r13 = java.lang.Double.TYPE     // Catch:{ all -> 0x0568 }
            if (r11 != r13) goto L_0x0725
            java.lang.Double r7 = java.lang.Double.valueOf(r25)     // Catch:{ all -> 0x0568 }
            goto L_0x076d
        L_0x0725:
            java.lang.Class r13 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0568 }
            if (r11 != r13) goto L_0x072c
            java.lang.Boolean r7 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0568 }
            goto L_0x076d
        L_0x072c:
            if (r11 != r12) goto L_0x076d
            int r10 = r10.parserFeatures     // Catch:{ all -> 0x0568 }
            com.alibaba.fastjson.parser.Feature r11 = com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty     // Catch:{ all -> 0x0568 }
            int r11 = r11.mask     // Catch:{ all -> 0x0568 }
            r10 = r10 & r11
            if (r10 == 0) goto L_0x076d
            r7 = r4
            goto L_0x076d
        L_0x0739:
            com.alibaba.fastjson.util.JavaBeanInfo r10 = r8.beanInfo     // Catch:{ all -> 0x0568 }
            java.lang.reflect.Type[] r10 = r10.creatorConstructorParameterTypes     // Catch:{ all -> 0x0568 }
            if (r10 == 0) goto L_0x076d
            int r11 = r10.length     // Catch:{ all -> 0x0568 }
            if (r5 >= r11) goto L_0x076d
            r10 = r10[r5]     // Catch:{ all -> 0x0568 }
            boolean r11 = r10 instanceof java.lang.Class     // Catch:{ all -> 0x0568 }
            if (r11 == 0) goto L_0x076d
            java.lang.Class r10 = (java.lang.Class) r10     // Catch:{ all -> 0x0568 }
            boolean r11 = r10.isInstance(r7)     // Catch:{ all -> 0x0568 }
            if (r11 != 0) goto L_0x076d
            boolean r11 = r7 instanceof java.util.List     // Catch:{ all -> 0x0568 }
            if (r11 == 0) goto L_0x076d
            r11 = r7
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x0568 }
            int r13 = r11.size()     // Catch:{ all -> 0x0568 }
            r14 = 1
            if (r13 != r14) goto L_0x076d
            r13 = 0
            java.lang.Object r14 = r11.get(r13)     // Catch:{ all -> 0x0568 }
            boolean r10 = r10.isInstance(r14)     // Catch:{ all -> 0x0568 }
            if (r10 == 0) goto L_0x076d
            java.lang.Object r7 = r11.get(r13)     // Catch:{ all -> 0x0568 }
        L_0x076d:
            r1[r5] = r7     // Catch:{ all -> 0x0568 }
            int r5 = r5 + 1
            goto L_0x06d6
        L_0x0773:
            com.alibaba.fastjson.util.FieldInfo[] r1 = r1.fields     // Catch:{ all -> 0x0568 }
            int r5 = r1.length     // Catch:{ all -> 0x0568 }
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x0568 }
            r10 = 0
        L_0x0779:
            if (r10 >= r5) goto L_0x07df
            r11 = r1[r10]     // Catch:{ all -> 0x0568 }
            java.lang.String r13 = r11.name     // Catch:{ all -> 0x0568 }
            java.lang.Object r13 = r0.get(r13)     // Catch:{ all -> 0x0568 }
            if (r13 != 0) goto L_0x07d6
            java.lang.reflect.Type r14 = r11.fieldType     // Catch:{ all -> 0x0568 }
            r16 = r1
            java.lang.Class r1 = java.lang.Byte.TYPE     // Catch:{ all -> 0x0568 }
            if (r14 != r1) goto L_0x0793
            r1 = 0
            java.lang.Byte r13 = java.lang.Byte.valueOf(r1)     // Catch:{ all -> 0x0568 }
            goto L_0x07d8
        L_0x0793:
            java.lang.Class r1 = java.lang.Short.TYPE     // Catch:{ all -> 0x0568 }
            if (r14 != r1) goto L_0x079d
            r1 = 0
            java.lang.Short r13 = java.lang.Short.valueOf(r1)     // Catch:{ all -> 0x0568 }
            goto L_0x07d8
        L_0x079d:
            java.lang.Class r1 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0568 }
            if (r14 != r1) goto L_0x07a7
            r1 = 0
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0568 }
            goto L_0x07d8
        L_0x07a7:
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x0568 }
            if (r14 != r1) goto L_0x07b0
            java.lang.Long r13 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x0568 }
            goto L_0x07d8
        L_0x07b0:
            java.lang.Class r1 = java.lang.Float.TYPE     // Catch:{ all -> 0x0568 }
            if (r14 != r1) goto L_0x07b9
            java.lang.Float r13 = java.lang.Float.valueOf(r24)     // Catch:{ all -> 0x0568 }
            goto L_0x07d8
        L_0x07b9:
            java.lang.Class r1 = java.lang.Double.TYPE     // Catch:{ all -> 0x0568 }
            if (r14 != r1) goto L_0x07c2
            java.lang.Double r13 = java.lang.Double.valueOf(r25)     // Catch:{ all -> 0x0568 }
            goto L_0x07d8
        L_0x07c2:
            java.lang.Class r1 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0568 }
            if (r14 != r1) goto L_0x07c9
            java.lang.Boolean r13 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0568 }
            goto L_0x07d8
        L_0x07c9:
            if (r14 != r12) goto L_0x07d8
            int r1 = r11.parserFeatures     // Catch:{ all -> 0x0568 }
            com.alibaba.fastjson.parser.Feature r11 = com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty     // Catch:{ all -> 0x0568 }
            int r11 = r11.mask     // Catch:{ all -> 0x0568 }
            r1 = r1 & r11
            if (r1 == 0) goto L_0x07d8
            r13 = r4
            goto L_0x07d8
        L_0x07d6:
            r16 = r1
        L_0x07d8:
            r7[r10] = r13     // Catch:{ all -> 0x0568 }
            int r10 = r10 + 1
            r1 = r16
            goto L_0x0779
        L_0x07df:
            r1 = r7
        L_0x07e0:
            com.alibaba.fastjson.util.JavaBeanInfo r4 = r8.beanInfo     // Catch:{ all -> 0x0568 }
            java.lang.reflect.Constructor<?> r5 = r4.creatorConstructor     // Catch:{ all -> 0x0568 }
            if (r5 == 0) goto L_0x088c
            boolean r4 = r4.f2352kotlin     // Catch:{ all -> 0x0568 }
            if (r4 == 0) goto L_0x0833
            r4 = 0
        L_0x07eb:
            int r5 = r1.length     // Catch:{ all -> 0x0568 }
            if (r4 >= r5) goto L_0x0833
            r5 = r1[r4]     // Catch:{ all -> 0x0568 }
            if (r5 != 0) goto L_0x0830
            com.alibaba.fastjson.util.JavaBeanInfo r5 = r8.beanInfo     // Catch:{ all -> 0x0568 }
            com.alibaba.fastjson.util.FieldInfo[] r7 = r5.fields     // Catch:{ all -> 0x0568 }
            if (r7 == 0) goto L_0x0830
            int r10 = r7.length     // Catch:{ all -> 0x0568 }
            if (r4 >= r10) goto L_0x0830
            r4 = r7[r4]     // Catch:{ all -> 0x0568 }
            java.lang.Class<?> r4 = r4.fieldClass     // Catch:{ all -> 0x0568 }
            if (r4 != r12) goto L_0x0833
            java.lang.reflect.Constructor<?> r4 = r5.kotlinDefaultConstructor     // Catch:{ Exception -> 0x082d }
            if (r4 == 0) goto L_0x0833
            r5 = 0
            java.lang.Object r4 = r4.newInstance(r5)     // Catch:{ Exception -> 0x082d }
            r5 = 0
        L_0x080b:
            int r6 = r1.length     // Catch:{ Exception -> 0x0826 }
            if (r5 >= r6) goto L_0x082b
            r6 = r1[r5]     // Catch:{ Exception -> 0x0826 }
            if (r6 == 0) goto L_0x0828
            com.alibaba.fastjson.util.JavaBeanInfo r7 = r8.beanInfo     // Catch:{ Exception -> 0x0826 }
            com.alibaba.fastjson.util.FieldInfo[] r7 = r7.fields     // Catch:{ Exception -> 0x0826 }
            if (r7 == 0) goto L_0x0828
            int r10 = r7.length     // Catch:{ Exception -> 0x0826 }
            if (r5 >= r10) goto L_0x0828
            r7 = r7[r5]     // Catch:{ Exception -> 0x0826 }
            r7.set(r4, r6)     // Catch:{ Exception -> 0x0826 }
            goto L_0x0828
        L_0x0821:
            r0 = move-exception
            r14 = r3
            r6 = r4
            goto L_0x093b
        L_0x0826:
            r0 = move-exception
            goto L_0x0865
        L_0x0828:
            int r5 = r5 + 1
            goto L_0x080b
        L_0x082b:
            r1 = r4
            goto L_0x083b
        L_0x082d:
            r0 = move-exception
            r4 = r6
            goto L_0x0865
        L_0x0830:
            int r4 = r4 + 1
            goto L_0x07eb
        L_0x0833:
            com.alibaba.fastjson.util.JavaBeanInfo r4 = r8.beanInfo     // Catch:{ Exception -> 0x082d }
            java.lang.reflect.Constructor<?> r4 = r4.creatorConstructor     // Catch:{ Exception -> 0x082d }
            java.lang.Object r1 = r4.newInstance(r1)     // Catch:{ Exception -> 0x082d }
        L_0x083b:
            if (r2 == 0) goto L_0x08b9
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x01a2 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x01a2 }
        L_0x0845:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x01a2 }
            if (r2 == 0) goto L_0x08b9
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x01a2 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x01a2 }
            java.lang.Object r4 = r2.getKey()     // Catch:{ all -> 0x01a2 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x01a2 }
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r4 = r8.getFieldDeserializer((java.lang.String) r4)     // Catch:{ all -> 0x01a2 }
            if (r4 == 0) goto L_0x0845
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x01a2 }
            r4.setValue((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x01a2 }
            goto L_0x0845
        L_0x0865:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0821 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0821 }
            r5.<init>()     // Catch:{ all -> 0x0821 }
            java.lang.String r6 = "create instance error, "
            r5.append(r6)     // Catch:{ all -> 0x0821 }
            r5.append(r2)     // Catch:{ all -> 0x0821 }
            java.lang.String r2 = ", "
            r5.append(r2)     // Catch:{ all -> 0x0821 }
            com.alibaba.fastjson.util.JavaBeanInfo r2 = r8.beanInfo     // Catch:{ all -> 0x0821 }
            java.lang.reflect.Constructor<?> r2 = r2.creatorConstructor     // Catch:{ all -> 0x0821 }
            java.lang.String r2 = r2.toGenericString()     // Catch:{ all -> 0x0821 }
            r5.append(r2)     // Catch:{ all -> 0x0821 }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x0821 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0821 }
            throw r1     // Catch:{ all -> 0x0821 }
        L_0x088c:
            java.lang.reflect.Method r0 = r4.factoryMethod     // Catch:{ all -> 0x0568 }
            if (r0 == 0) goto L_0x08b8
            r2 = 0
            java.lang.Object r0 = r0.invoke(r2, r1)     // Catch:{ Exception -> 0x0897 }
            r1 = r0
            goto L_0x08b9
        L_0x0897:
            r0 = move-exception
            r1 = r0
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0568 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0568 }
            r2.<init>()     // Catch:{ all -> 0x0568 }
            java.lang.String r4 = "create factory method error, "
            r2.append(r4)     // Catch:{ all -> 0x0568 }
            com.alibaba.fastjson.util.JavaBeanInfo r4 = r8.beanInfo     // Catch:{ all -> 0x0568 }
            java.lang.reflect.Method r4 = r4.factoryMethod     // Catch:{ all -> 0x0568 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0568 }
            r2.append(r4)     // Catch:{ all -> 0x0568 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0568 }
            r0.<init>(r2, r1)     // Catch:{ all -> 0x0568 }
            throw r0     // Catch:{ all -> 0x0568 }
        L_0x08b8:
            r1 = r6
        L_0x08b9:
            if (r3 == 0) goto L_0x08bf
            r3.object = r1     // Catch:{ all -> 0x01a2 }
            goto L_0x08bf
        L_0x08be:
            r1 = r6
        L_0x08bf:
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r8.beanInfo     // Catch:{ all -> 0x01a2 }
            java.lang.reflect.Method r0 = r0.buildMethod     // Catch:{ all -> 0x01a2 }
            if (r0 != 0) goto L_0x08cd
            if (r3 == 0) goto L_0x08c9
            r3.object = r1
        L_0x08c9:
            r9.setContext(r15)
            return r1
        L_0x08cd:
            r4 = 0
            java.lang.Object r0 = r0.invoke(r1, r4)     // Catch:{ Exception -> 0x08da }
            if (r3 == 0) goto L_0x08d6
            r3.object = r1
        L_0x08d6:
            r9.setContext(r15)
            return r0
        L_0x08da:
            r0 = move-exception
            r2 = r0
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x01a2 }
            java.lang.String r4 = "build object error"
            r0.<init>(r4, r2)     // Catch:{ all -> 0x01a2 }
            throw r0     // Catch:{ all -> 0x01a2 }
        L_0x08e4:
            r1 = 1
            r4 = 0
            int r3 = r11.token()     // Catch:{ all -> 0x0688 }
            r5 = 18
            if (r3 == r5) goto L_0x090c
            int r3 = r11.token()     // Catch:{ all -> 0x0688 }
            if (r3 == r1) goto L_0x090c
        L_0x08f4:
            r3 = r27
            r7 = r28
            r27 = r21
        L_0x08fa:
            int r5 = r36 + 1
            r14 = r5
            r5 = r12
            r4 = r17
            r6 = r19
            r2 = r20
            r1 = r27
            r12 = r0
            r0 = r13
            r20 = r18
            goto L_0x0177
        L_0x090c:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0688 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0688 }
            r1.<init>()     // Catch:{ all -> 0x0688 }
            java.lang.String r2 = "syntax error, unexpect token "
            r1.append(r2)     // Catch:{ all -> 0x0688 }
            int r2 = r11.token()     // Catch:{ all -> 0x0688 }
            java.lang.String r2 = com.alibaba.fastjson.parser.JSONToken.name(r2)     // Catch:{ all -> 0x0688 }
            r1.append(r2)     // Catch:{ all -> 0x0688 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0688 }
            r0.<init>(r1)     // Catch:{ all -> 0x0688 }
            throw r0     // Catch:{ all -> 0x0688 }
        L_0x092b:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0688 }
            java.lang.String r1 = "syntax error, unexpect token ':'"
            r0.<init>(r1)     // Catch:{ all -> 0x0688 }
            throw r0     // Catch:{ all -> 0x0688 }
        L_0x0933:
            r0 = move-exception
            r6 = r1
            goto L_0x05e1
        L_0x0937:
            r0 = move-exception
            r4 = r14
            goto L_0x0044
        L_0x093b:
            if (r14 == 0) goto L_0x093f
            r14.object = r6
        L_0x093f:
            r9.setContext(r15)
            throw r0
        L_0x0943:
            java.lang.Object r0 = r33.parse()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object, int, int[]):java.lang.Object");
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) {
        this.clazz = javaBeanInfo.clazz;
        this.beanInfo = javaBeanInfo;
        FieldInfo[] fieldInfoArr = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr.length];
        int length = fieldInfoArr.length;
        HashMap hashMap = null;
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, javaBeanInfo, fieldInfo);
            this.sortedFieldDeserializers[i] = createFieldDeserializer;
            if (length > 128) {
                if (this.fieldDeserializerMap == null) {
                    this.fieldDeserializerMap = new HashMap();
                }
                this.fieldDeserializerMap.put(fieldInfo.name, createFieldDeserializer);
            }
            for (String str : fieldInfo.alternateNames) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
        this.fieldDeserializers = new FieldDeserializer[fieldInfoArr2.length];
        int length2 = fieldInfoArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fieldDeserializers[i2] = getFieldDeserializer(javaBeanInfo.fields[i2].name);
        }
    }

    public FieldDeserializer getFieldDeserializer(long j) {
        int i = 0;
        if (this.hashArray == null) {
            long[] jArr = new long[this.sortedFieldDeserializers.length];
            int i2 = 0;
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i2 >= fieldDeserializerArr.length) {
                    break;
                }
                jArr[i2] = TypeUtils.fnv1a_64(fieldDeserializerArr[i2].fieldInfo.name);
                i2++;
            }
            Arrays.sort(jArr);
            this.hashArray = jArr;
        }
        int binarySearch = Arrays.binarySearch(this.hashArray, j);
        if (binarySearch < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, -1);
            while (true) {
                FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                if (i >= fieldDeserializerArr2.length) {
                    break;
                }
                int binarySearch2 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(fieldDeserializerArr2[i].fieldInfo.name));
                if (binarySearch2 >= 0) {
                    sArr[binarySearch2] = (short) i;
                }
                i++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[binarySearch];
        if (s != -1) {
            return this.sortedFieldDeserializers[s];
        }
        return null;
    }

    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        JavaBeanInfo javaBeanInfo;
        FieldInfo[] fieldInfoArr;
        Constructor<?> constructor;
        FieldInfo[] fieldInfoArr2;
        Integer num;
        Object obj;
        double d;
        float f;
        JavaBeanInfo javaBeanInfo2 = this.beanInfo;
        if (javaBeanInfo2.creatorConstructor == null && javaBeanInfo2.factoryMethod == null) {
            Object createInstance = createInstance((DefaultJSONParser) null, (Type) this.clazz);
            for (Map.Entry next : map.entrySet()) {
                Object value = next.getValue();
                FieldDeserializer smartMatch = smartMatch((String) next.getKey());
                if (smartMatch != null) {
                    FieldInfo fieldInfo = smartMatch.fieldInfo;
                    Field field = fieldInfo.field;
                    Type type = fieldInfo.fieldType;
                    if (fieldInfo.declaringClass != null) {
                        smartMatch.parseField(new DefaultJSONParser(JSON.toJSONString(value)), createInstance, type, (Map<String, Object>) null);
                    } else {
                        if (field != null) {
                            Class<?> type2 = field.getType();
                            if (type2 == Boolean.TYPE) {
                                if (value == Boolean.FALSE) {
                                    field.setBoolean(createInstance, false);
                                } else if (value == Boolean.TRUE) {
                                    field.setBoolean(createInstance, true);
                                }
                            } else if (type2 == Integer.TYPE) {
                                if (value instanceof Number) {
                                    field.setInt(createInstance, ((Number) value).intValue());
                                }
                            } else if (type2 == Long.TYPE) {
                                if (value instanceof Number) {
                                    field.setLong(createInstance, ((Number) value).longValue());
                                }
                            } else if (type2 == Float.TYPE) {
                                if (value instanceof Number) {
                                    field.setFloat(createInstance, ((Number) value).floatValue());
                                } else if (value instanceof String) {
                                    String str = (String) value;
                                    if (str.length() <= 10) {
                                        f = TypeUtils.parseFloat(str);
                                    } else {
                                        f = Float.parseFloat(str);
                                    }
                                    field.setFloat(createInstance, f);
                                }
                            } else if (type2 == Double.TYPE) {
                                if (value instanceof Number) {
                                    field.setDouble(createInstance, ((Number) value).doubleValue());
                                } else if (value instanceof String) {
                                    String str2 = (String) value;
                                    if (str2.length() <= 10) {
                                        d = TypeUtils.parseDouble(str2);
                                    } else {
                                        d = Double.parseDouble(str2);
                                    }
                                    field.setDouble(createInstance, d);
                                }
                            } else if (value != null && type == value.getClass()) {
                                field.set(createInstance, value);
                            }
                        }
                        String str3 = fieldInfo.format;
                        if (str3 != null && type == Date.class) {
                            obj = TypeUtils.castToDate(value, str3);
                        } else if (str3 != null && (type instanceof Class) && ((Class) type).getName().equals("java.time.LocalDateTime")) {
                            obj = TypeUtils.castToLocalDateTime(value, str3);
                        } else if (type instanceof ParameterizedType) {
                            obj = TypeUtils.cast(value, (ParameterizedType) type, parserConfig);
                        } else {
                            obj = TypeUtils.cast(value, type, parserConfig);
                        }
                        smartMatch.setValue(createInstance, obj);
                    }
                }
            }
            Method method = this.beanInfo.buildMethod;
            if (method == null) {
                return createInstance;
            }
            try {
                return method.invoke(createInstance, (Object[]) null);
            } catch (Exception e) {
                throw new JSONException("build object error", e);
            }
        } else {
            FieldInfo[] fieldInfoArr3 = javaBeanInfo2.fields;
            int length = fieldInfoArr3.length;
            Object[] objArr = new Object[length];
            HashMap hashMap = null;
            for (int i = 0; i < length; i++) {
                FieldInfo fieldInfo2 = fieldInfoArr3[i];
                char c = map.get(fieldInfo2.name);
                if (c == null) {
                    Class<?> cls = fieldInfo2.fieldClass;
                    if (cls == Integer.TYPE) {
                        c = 0;
                    } else if (cls == Long.TYPE) {
                        c = 0L;
                    } else if (cls == Short.TYPE) {
                        c = (short) 0;
                    } else if (cls == Byte.TYPE) {
                        c = (byte) 0;
                    } else if (cls == Float.TYPE) {
                        c = Float.valueOf(0.0f);
                    } else if (cls == Double.TYPE) {
                        c = Double.valueOf(0.0d);
                    } else if (cls == Character.TYPE) {
                        c = '0';
                    } else if (cls == Boolean.TYPE) {
                        c = Boolean.FALSE;
                    }
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(fieldInfo2.name, Integer.valueOf(i));
                }
                objArr[i] = c;
            }
            if (hashMap != null) {
                for (Map.Entry next2 : map.entrySet()) {
                    Object value2 = next2.getValue();
                    FieldDeserializer smartMatch2 = smartMatch((String) next2.getKey());
                    if (!(smartMatch2 == null || (num = (Integer) hashMap.get(smartMatch2.fieldInfo.name)) == null)) {
                        objArr[num.intValue()] = value2;
                    }
                }
            }
            JavaBeanInfo javaBeanInfo3 = this.beanInfo;
            if (javaBeanInfo3.creatorConstructor != null) {
                if (javaBeanInfo3.f2352kotlin) {
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            if (objArr[i2] != null || (fieldInfoArr = (javaBeanInfo = this.beanInfo).fields) == null || i2 >= fieldInfoArr.length) {
                                i2++;
                            } else if (fieldInfoArr[i2].fieldClass == String.class && (constructor = javaBeanInfo.kotlinDefaultConstructor) != null) {
                                try {
                                    Object newInstance = constructor.newInstance((Object[]) null);
                                    for (int i3 = 0; i3 < length; i3++) {
                                        Object obj2 = objArr[i3];
                                        if (!(obj2 == null || (fieldInfoArr2 = this.beanInfo.fields) == null || i3 >= fieldInfoArr2.length)) {
                                            fieldInfoArr2[i3].set(newInstance, obj2);
                                        }
                                    }
                                    return newInstance;
                                } catch (Exception e2) {
                                    throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e2);
                                }
                            }
                        }
                    }
                }
                try {
                    return this.beanInfo.creatorConstructor.newInstance(objArr);
                } catch (Exception e3) {
                    throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e3);
                }
            } else {
                Method method2 = javaBeanInfo3.factoryMethod;
                if (method2 == null) {
                    return null;
                }
                try {
                    return method2.invoke((Object) null, objArr);
                } catch (Exception e4) {
                    throw new JSONException("create factory method error, " + this.beanInfo.factoryMethod.toString(), e4);
                }
            }
        }
    }
}

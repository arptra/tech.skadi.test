package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    protected SerializeBeanInfo beanInfo;
    protected final FieldSerializer[] getters;
    private volatile transient long[] hashArray;
    private volatile transient short[] hashArrayMapping;
    protected final FieldSerializer[] sortedGetters;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public static Map<String, String> createAliasMap(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        List<LabelFilter> list = jSONSerializer.labelFilters;
        if (list != null) {
            for (LabelFilter apply : list) {
                if (!apply.apply(str)) {
                    return false;
                }
            }
        }
        List<LabelFilter> list2 = this.labelFilters;
        if (list2 == null) {
            return true;
        }
        for (LabelFilter apply2 : list2) {
            if (!apply2.apply(str)) {
                return false;
            }
        }
        return true;
    }

    public BeanContext getBeanContext(int i) {
        return this.sortedGetters[i].fieldContext;
    }

    public Set<String> getFieldNames(Object obj) throws Exception {
        HashSet hashSet = new HashSet();
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                hashSet.add(fieldSerializer.fieldInfo.name);
            }
        }
        return hashSet;
    }

    public FieldSerializer getFieldSerializer(String str) {
        if (str == null) {
            return null;
        }
        int length = this.sortedGetters.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedGetters[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo <= 0) {
                return this.sortedGetters[i2];
            } else {
                length = i2 - 1;
            }
        }
        return null;
    }

    public Type getFieldType(int i) {
        return this.sortedGetters[i].fieldInfo.fieldType;
    }

    public Object getFieldValue(Object obj, String str) {
        FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer != null) {
            try {
                return fieldSerializer.getPropertyValue(obj);
            } catch (InvocationTargetException e) {
                throw new JSONException("getFieldValue error." + str, e);
            } catch (IllegalAccessException e2) {
                throw new JSONException("getFieldValue error." + str, e2);
            }
        } else {
            throw new JSONException("field not found. " + str);
        }
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer propertyValue : this.sortedGetters) {
            arrayList.add(propertyValue.getPropertyValue(obj));
        }
        return arrayList;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            boolean isEnabled = SerializerFeature.isEnabled(fieldSerializer.features, SerializerFeature.SkipTransientField);
            FieldInfo fieldInfo = fieldSerializer.fieldInfo;
            if (!isEnabled || fieldInfo == null || !fieldInfo.fieldTransient) {
                if (fieldInfo.unwrapped) {
                    Object json = JSON.toJSON(fieldSerializer.getPropertyValue(obj));
                    if (json instanceof Map) {
                        linkedHashMap.putAll((Map) json);
                    } else {
                        linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
                    }
                } else {
                    linkedHashMap.put(fieldInfo.name, fieldSerializer.getPropertyValue(obj));
                }
            }
        }
        return linkedHashMap;
    }

    public List<Object> getObjectFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
        }
        return arrayList;
    }

    public int getSize(Object obj) throws Exception {
        int i = 0;
        for (FieldSerializer propertyValueDirect : this.sortedGetters) {
            if (propertyValueDirect.getPropertyValueDirect(obj) != null) {
                i++;
            }
        }
        return i;
    }

    public Class<?> getType() {
        return this.beanInfo.beanType;
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public char writeAfter(JSONSerializer jSONSerializer, Object obj, char c) {
        List<AfterFilter> list = jSONSerializer.afterFilters;
        if (list != null) {
            for (AfterFilter writeAfter : list) {
                c = writeAfter.writeAfter(jSONSerializer, obj, c);
            }
        }
        List<AfterFilter> list2 = this.afterFilters;
        if (list2 != null) {
            for (AfterFilter writeAfter2 : list2) {
                c = writeAfter2.writeAfter(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public char writeBefore(JSONSerializer jSONSerializer, Object obj, char c) {
        List<BeforeFilter> list = jSONSerializer.beforeFilters;
        if (list != null) {
            for (BeforeFilter writeBefore : list) {
                c = writeBefore.writeBefore(jSONSerializer, obj, c);
            }
        }
        List<BeforeFilter> list2 = this.beforeFilters;
        if (list2 != null) {
            for (BeforeFilter writeBefore2 : list2) {
                c = writeBefore2.writeBefore(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    public void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
        if (str == null) {
            str = jSONSerializer.config.typeKey;
        }
        jSONSerializer.out.writeFieldName(str, false);
        String str2 = this.beanInfo.typeName;
        if (str2 == null) {
            Class cls = obj.getClass();
            if (TypeUtils.isProxy(cls)) {
                cls = cls.getSuperclass();
            }
            str2 = cls.getName();
        }
        jSONSerializer.write(str2);
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeNoneASM(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i) {
        IdentityHashMap<Object, SerialContext> identityHashMap;
        SerialContext serialContext = jSONSerializer.context;
        int i2 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext == null || (serialContext.features & i2) != 0 || (i & i2) != 0 || (identityHashMap = jSONSerializer.references) == null || !identityHashMap.containsKey(obj)) {
            return false;
        }
        jSONSerializer.writeReference(obj);
        return true;
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer, int i) {
        int i2 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i2) == 0 && !jSONSerializer.out.beanToArray && (i & i2) == 0) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:226:0x02dd, code lost:
        if ((r8.beanInfo.features & r4) == 0) goto L_0x0371;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        r3 = r7;
        r5 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x03ad, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x04a1, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x04a2, code lost:
        r5 = r9;
        r30 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x04b2, code lost:
        r2 = r33;
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x04b7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x04b8, code lost:
        r5 = r9;
        r30 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:400:0x0508, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:406:0x0517, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:407:0x0518, code lost:
        r3 = r7;
        r5 = r9;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:?, code lost:
        r2 = r2 + ", fieldName : " + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:421:0x055c, code lost:
        if (r6.method != null) goto L_0x055e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:422:0x055e, code lost:
        r2 = r2 + ", method : " + r6.method.getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:423:0x0579, code lost:
        r2 = r2 + ", fieldName : " + r1.fieldInfo.name;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:426:0x0595, code lost:
        r2 = r2 + ", " + r0.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:429:0x05b1, code lost:
        r17 = r0.getCause();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:432:0x05b8, code lost:
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00f7, code lost:
        if (r11.fieldTransient != false) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0106, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0107, code lost:
        r5 = r9;
        r3 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x010c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x010d, code lost:
        r5 = r9;
        r2 = r10;
        r3 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x013c, code lost:
        if (r9.isWriteClassName(r12, r10) != false) goto L_0x00f9;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0146 A[SYNTHETIC, Splitter:B:100:0x0146] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005e A[Catch:{ Exception -> 0x0063, all -> 0x005e }, ExcHandler: all (th java.lang.Throwable), PHI: r7 r9 
      PHI: (r7v24 com.alibaba.fastjson.serializer.SerialContext) = (r7v2 com.alibaba.fastjson.serializer.SerialContext), (r7v2 com.alibaba.fastjson.serializer.SerialContext), (r7v0 com.alibaba.fastjson.serializer.SerialContext) binds: [B:57:0x00cd, B:58:?, B:25:0x005a] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v17 com.alibaba.fastjson.serializer.JSONSerializer) = (r9v1 com.alibaba.fastjson.serializer.JSONSerializer), (r9v1 com.alibaba.fastjson.serializer.JSONSerializer), (r9v0 com.alibaba.fastjson.serializer.JSONSerializer) binds: [B:57:0x00cd, B:58:?, B:25:0x005a] A[DONT_GENERATE, DONT_INLINE], Splitter:B:25:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x03ad A[Catch:{ Exception -> 0x03b0, all -> 0x03ad }, ExcHandler: all (th java.lang.Throwable), PHI: r5 r30 
      PHI: (r5v6 com.alibaba.fastjson.serializer.JSONSerializer) = (r5v5 com.alibaba.fastjson.serializer.JSONSerializer), (r5v27 com.alibaba.fastjson.serializer.JSONSerializer), (r5v50 com.alibaba.fastjson.serializer.JSONSerializer), (r5v50 com.alibaba.fastjson.serializer.JSONSerializer) binds: [B:394:0x04f1, B:293:0x03a6, B:377:0x04b0, B:378:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r30v1 com.alibaba.fastjson.serializer.SerialContext) = (r30v0 com.alibaba.fastjson.serializer.SerialContext), (r30v13 com.alibaba.fastjson.serializer.SerialContext), (r30v17 com.alibaba.fastjson.serializer.SerialContext), (r30v17 com.alibaba.fastjson.serializer.SerialContext) binds: [B:394:0x04f1, B:293:0x03a6, B:377:0x04b0, B:378:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:293:0x03a6] */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x0404 A[Catch:{ Exception -> 0x03b0, all -> 0x03ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x046e A[Catch:{ Exception -> 0x03b0, all -> 0x03ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x0481 A[Catch:{ Exception -> 0x03b0, all -> 0x03ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x0482 A[Catch:{ Exception -> 0x03b0, all -> 0x03ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x04a1 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:80:0x0118] */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x04f0  */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x050d A[Catch:{ Exception -> 0x0508, all -> 0x03ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x053f A[SYNTHETIC, Splitter:B:413:0x053f] */
    /* JADX WARNING: Removed duplicated region for block: B:417:0x0554 A[ADDED_TO_REGION, Catch:{ all -> 0x0552 }] */
    /* JADX WARNING: Removed duplicated region for block: B:426:0x0595 A[Catch:{ all -> 0x0552 }] */
    /* JADX WARNING: Removed duplicated region for block: B:429:0x05b1 A[Catch:{ all -> 0x0552 }] */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x05b7 A[Catch:{ all -> 0x0552 }] */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x05b8 A[Catch:{ all -> 0x0552 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b9 A[Catch:{ Exception -> 0x0063, all -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00bb A[Catch:{ Exception -> 0x0063, all -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d0 A[SYNTHETIC, Splitter:B:60:0x00d0] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0106 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:70:0x00f5] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0132 A[SYNTHETIC, Splitter:B:92:0x0132] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r32, java.lang.Object r33, java.lang.Object r34, java.lang.reflect.Type r35, int r36, boolean r37) throws java.io.IOException {
        /*
            r31 = this;
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r34
            r12 = r35
            r13 = r36
            com.alibaba.fastjson.serializer.SerializeWriter r14 = r9.out
            if (r10 != 0) goto L_0x0014
            r14.writeNull()
            return
        L_0x0014:
            boolean r0 = r8.writeReference(r9, r10, r13)
            if (r0 == 0) goto L_0x001b
            return
        L_0x001b:
            boolean r0 = r14.sortField
            if (r0 == 0) goto L_0x0023
            com.alibaba.fastjson.serializer.FieldSerializer[] r0 = r8.sortedGetters
        L_0x0021:
            r15 = r0
            goto L_0x0026
        L_0x0023:
            com.alibaba.fastjson.serializer.FieldSerializer[] r0 = r8.getters
            goto L_0x0021
        L_0x0026:
            com.alibaba.fastjson.serializer.SerialContext r7 = r9.context
            com.alibaba.fastjson.serializer.SerializeBeanInfo r0 = r8.beanInfo
            java.lang.Class<?> r0 = r0.beanType
            boolean r0 = r0.isEnum()
            if (r0 != 0) goto L_0x0042
            com.alibaba.fastjson.serializer.SerializeBeanInfo r0 = r8.beanInfo
            int r5 = r0.features
            r1 = r32
            r2 = r7
            r3 = r33
            r4 = r34
            r6 = r36
            r1.setContext(r2, r3, r4, r5, r6)
        L_0x0042:
            boolean r16 = r8.isWriteAsArray(r9, r13)
            if (r16 == 0) goto L_0x004b
            r0 = 91
            goto L_0x004d
        L_0x004b:
            r0 = 123(0x7b, float:1.72E-43)
        L_0x004d:
            if (r16 == 0) goto L_0x0053
            r1 = 93
        L_0x0051:
            r6 = r1
            goto L_0x0056
        L_0x0053:
            r1 = 125(0x7d, float:1.75E-43)
            goto L_0x0051
        L_0x0056:
            r17 = 0
            if (r37 != 0) goto L_0x006b
            r14.append((char) r0)     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            goto L_0x006b
        L_0x005e:
            r0 = move-exception
            r3 = r7
            r5 = r9
            goto L_0x05c0
        L_0x0063:
            r0 = move-exception
            r3 = r7
            r5 = r9
            r2 = r10
            r1 = r17
            goto L_0x051b
        L_0x006b:
            int r0 = r15.length     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            if (r0 <= 0) goto L_0x007c
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            boolean r0 = r14.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r0)     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            if (r0 == 0) goto L_0x007c
            r32.incrementIndent()     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            r32.println()     // Catch:{ Exception -> 0x0063, all -> 0x005e }
        L_0x007c:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r0 = r8.beanInfo     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            int r0 = r0.features     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            int r2 = r1.mask     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            r0 = r0 & r2
            r5 = 44
            if (r0 != 0) goto L_0x0093
            r0 = r13 & r2
            if (r0 != 0) goto L_0x0093
            boolean r0 = r9.isWriteClassName(r12, r10)     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            if (r0 == 0) goto L_0x00ae
        L_0x0093:
            java.lang.Class r0 = r33.getClass()     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            if (r0 == r12) goto L_0x00a2
            boolean r2 = r12 instanceof java.lang.reflect.WildcardType     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            if (r2 == 0) goto L_0x00a2
            java.lang.Class r2 = com.alibaba.fastjson.util.TypeUtils.getClass(r35)     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            goto L_0x00a3
        L_0x00a2:
            r2 = r12
        L_0x00a3:
            if (r0 == r2) goto L_0x00ae
            com.alibaba.fastjson.serializer.SerializeBeanInfo r0 = r8.beanInfo     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            java.lang.String r0 = r0.typeKey     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            r8.writeClassName(r9, r0, r10)     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            r0 = r5
            goto L_0x00af
        L_0x00ae:
            r0 = 0
        L_0x00af:
            boolean r18 = r14.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            char r0 = r8.writeBefore(r9, r10, r0)     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            if (r0 != r5) goto L_0x00bb
            r0 = 1
            goto L_0x00bc
        L_0x00bb:
            r0 = 0
        L_0x00bc:
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.SkipTransientField     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            boolean r19 = r14.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.IgnoreNonFieldGetter     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            boolean r20 = r14.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ Exception -> 0x0063, all -> 0x005e }
            r21 = r0
            r1 = r17
            r2 = 0
        L_0x00cd:
            int r0 = r15.length     // Catch:{ Exception -> 0x0517, all -> 0x005e }
            if (r2 >= r0) goto L_0x04e3
            r13 = r15[r2]     // Catch:{ Exception -> 0x04de, all -> 0x04d8 }
            com.alibaba.fastjson.util.FieldInfo r11 = r13.fieldInfo     // Catch:{ Exception -> 0x04de, all -> 0x04d8 }
            java.lang.reflect.Field r0 = r11.field     // Catch:{ Exception -> 0x04de, all -> 0x04d8 }
            r22 = r15
            java.lang.String r15 = r11.name     // Catch:{ Exception -> 0x04de, all -> 0x04d8 }
            r23 = r7
            java.lang.Class<?> r7 = r11.fieldClass     // Catch:{ Exception -> 0x04bc, all -> 0x04a1 }
            int r3 = r14.features     // Catch:{ Exception -> 0x04bc, all -> 0x04a1 }
            int r4 = r11.serialzeFeatures     // Catch:{ Exception -> 0x04bc, all -> 0x04a1 }
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes     // Catch:{ Exception -> 0x04bc, all -> 0x04a1 }
            boolean r25 = com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(r3, r4, r5)     // Catch:{ Exception -> 0x04bc, all -> 0x04a1 }
            boolean r3 = r14.quoteFieldNames     // Catch:{ Exception -> 0x04bc, all -> 0x04a1 }
            if (r3 == 0) goto L_0x00f1
            if (r25 != 0) goto L_0x00f1
            r26 = 1
            goto L_0x00f3
        L_0x00f1:
            r26 = 0
        L_0x00f3:
            if (r19 == 0) goto L_0x0113
            boolean r3 = r11.fieldTransient     // Catch:{ Exception -> 0x010c, all -> 0x0106 }
            if (r3 == 0) goto L_0x0113
        L_0x00f9:
            r28 = r2
            r29 = r6
            r5 = r9
            r30 = r23
            r3 = 44
            r4 = 1
            r9 = 0
            goto L_0x04c4
        L_0x0106:
            r0 = move-exception
            r5 = r9
            r3 = r23
            goto L_0x05c0
        L_0x010c:
            r0 = move-exception
            r5 = r9
            r2 = r10
            r3 = r23
            goto L_0x051b
        L_0x0113:
            if (r20 == 0) goto L_0x0118
            if (r0 != 0) goto L_0x0118
            goto L_0x00f9
        L_0x0118:
            boolean r0 = r8.applyName(r9, r10, r15)     // Catch:{ Exception -> 0x04bc, all -> 0x04a1 }
            if (r0 == 0) goto L_0x0129
            java.lang.String r0 = r11.label     // Catch:{ Exception -> 0x010c, all -> 0x0106 }
            boolean r0 = r8.applyLabel(r9, r0)     // Catch:{ Exception -> 0x010c, all -> 0x0106 }
            if (r0 != 0) goto L_0x0127
            goto L_0x0129
        L_0x0127:
            r0 = 0
            goto L_0x012c
        L_0x0129:
            if (r16 == 0) goto L_0x00f9
            r0 = 1
        L_0x012c:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r3 = r8.beanInfo     // Catch:{ Exception -> 0x04bc, all -> 0x04a1 }
            java.lang.String r3 = r3.typeKey     // Catch:{ Exception -> 0x04bc, all -> 0x04a1 }
            if (r3 == 0) goto L_0x013f
            boolean r3 = r15.equals(r3)     // Catch:{ Exception -> 0x010c, all -> 0x0106 }
            if (r3 == 0) goto L_0x013f
            boolean r3 = r9.isWriteClassName(r12, r10)     // Catch:{ Exception -> 0x010c, all -> 0x0106 }
            if (r3 == 0) goto L_0x013f
            goto L_0x00f9
        L_0x013f:
            if (r0 == 0) goto L_0x0146
            r27 = r1
        L_0x0143:
            r0 = r17
            goto L_0x015a
        L_0x0146:
            java.lang.Object r0 = r13.getPropertyValueDirect(r10)     // Catch:{ InvocationTargetException -> 0x014d }
            r27 = r1
            goto L_0x015a
        L_0x014d:
            r0 = move-exception
            r1 = r0
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.IgnoreErrorGetter     // Catch:{ Exception -> 0x04b7, all -> 0x04a1 }
            boolean r0 = r14.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r0)     // Catch:{ Exception -> 0x04b7, all -> 0x04a1 }
            if (r0 == 0) goto L_0x04ad
            r27 = r13
            goto L_0x0143
        L_0x015a:
            boolean r1 = r8.apply(r9, r10, r15, r0)     // Catch:{ Exception -> 0x04a7, all -> 0x04a1 }
            if (r1 != 0) goto L_0x016d
            r28 = r2
            r29 = r6
            r5 = r9
            r30 = r23
            r3 = 44
            r4 = 1
            r9 = 0
            goto L_0x0466
        L_0x016d:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            if (r7 != r5) goto L_0x018d
            java.lang.String r1 = "trim"
            java.lang.String r3 = r11.format     // Catch:{ Exception -> 0x0184, all -> 0x0106 }
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0184, all -> 0x0106 }
            if (r1 == 0) goto L_0x018d
            if (r0 == 0) goto L_0x018d
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0184, all -> 0x0106 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0184, all -> 0x0106 }
            goto L_0x018d
        L_0x0184:
            r0 = move-exception
            r5 = r9
            r2 = r10
            r3 = r23
            r1 = r27
            goto L_0x051b
        L_0x018d:
            java.lang.String r4 = r8.processKey(r9, r10, r15, r0)     // Catch:{ Exception -> 0x04a7, all -> 0x04a1 }
            com.alibaba.fastjson.serializer.BeanContext r3 = r13.fieldContext     // Catch:{ Exception -> 0x04a7, all -> 0x04a1 }
            r1 = r31
            r28 = r2
            r2 = r32
            r12 = 1
            r12 = r4
            r24 = 0
            r4 = r33
            r10 = r5
            r5 = r15
            r29 = r6
            r6 = r0
            r9 = r7
            r30 = r23
            r7 = r36
            java.lang.Object r1 = r1.processValue(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x02c9
            int r3 = r11.serialzeFeatures     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            com.alibaba.fastjson.annotation.JSONField r4 = r11.getAnnotation()     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            com.alibaba.fastjson.serializer.SerializeBeanInfo r5 = r8.beanInfo     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            com.alibaba.fastjson.annotation.JSONType r5 = r5.jsonType     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r5 == 0) goto L_0x01d9
            com.alibaba.fastjson.serializer.SerializerFeature[] r5 = r5.serialzeFeatures()     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            int r5 = com.alibaba.fastjson.serializer.SerializerFeature.of(r5)     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r3 = r3 | r5
            goto L_0x01d9
        L_0x01c7:
            r0 = move-exception
            r5 = r32
        L_0x01ca:
            r3 = r30
            goto L_0x05c0
        L_0x01ce:
            r0 = move-exception
            r5 = r32
        L_0x01d1:
            r2 = r33
            r1 = r27
        L_0x01d5:
            r3 = r30
            goto L_0x051b
        L_0x01d9:
            if (r4 == 0) goto L_0x01eb
            java.lang.String r5 = r4.defaultValue()     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            boolean r5 = r2.equals(r5)     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r5 != 0) goto L_0x01eb
            java.lang.String r1 = r4.defaultValue()     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            goto L_0x02c9
        L_0x01eb:
            java.lang.Class<java.lang.Boolean> r4 = java.lang.Boolean.class
            if (r9 != r4) goto L_0x0221
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            int r4 = r4.mask     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            int r5 = r5.mask     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r6 = r4 | r5
            if (r16 != 0) goto L_0x020d
            r7 = r3 & r6
            if (r7 != 0) goto L_0x020d
            int r7 = r14.features     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r6 = r6 & r7
            if (r6 != 0) goto L_0x020d
        L_0x0204:
            r5 = r32
            r9 = r24
            r3 = 44
            r4 = 1
            goto L_0x0466
        L_0x020d:
            r6 = r3 & r4
            if (r6 == 0) goto L_0x0215
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            goto L_0x02c9
        L_0x0215:
            int r6 = r14.features     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r4 = r4 & r6
            if (r4 == 0) goto L_0x02c9
            r3 = r3 & r5
            if (r3 != 0) goto L_0x02c9
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            goto L_0x02c9
        L_0x0221:
            if (r9 != r10) goto L_0x0249
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            int r4 = r4.mask     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            int r5 = r5.mask     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r6 = r4 | r5
            if (r16 != 0) goto L_0x0239
            r7 = r3 & r6
            if (r7 != 0) goto L_0x0239
            int r7 = r14.features     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r6 = r6 & r7
            if (r6 != 0) goto L_0x0239
            goto L_0x0204
        L_0x0239:
            r6 = r3 & r4
            if (r6 == 0) goto L_0x0240
        L_0x023d:
            r1 = r2
            goto L_0x02c9
        L_0x0240:
            int r6 = r14.features     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r4 = r4 & r6
            if (r4 == 0) goto L_0x02c9
            r3 = r3 & r5
            if (r3 != 0) goto L_0x02c9
            goto L_0x023d
        L_0x0249:
            java.lang.Class<java.lang.Number> r4 = java.lang.Number.class
            boolean r4 = r4.isAssignableFrom(r9)     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r4 == 0) goto L_0x027d
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            int r4 = r4.mask     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            int r5 = r5.mask     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r6 = r4 | r5
            if (r16 != 0) goto L_0x0267
            r7 = r3 & r6
            if (r7 != 0) goto L_0x0267
            int r7 = r14.features     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r6 = r6 & r7
            if (r6 != 0) goto L_0x0267
            goto L_0x0204
        L_0x0267:
            r6 = r3 & r4
            if (r6 == 0) goto L_0x0270
            java.lang.Integer r1 = java.lang.Integer.valueOf(r24)     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            goto L_0x02c9
        L_0x0270:
            int r6 = r14.features     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r4 = r4 & r6
            if (r4 == 0) goto L_0x02c9
            r3 = r3 & r5
            if (r3 != 0) goto L_0x02c9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r24)     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            goto L_0x02c9
        L_0x027d:
            java.lang.Class<java.util.Collection> r4 = java.util.Collection.class
            boolean r4 = r4.isAssignableFrom(r9)     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r4 == 0) goto L_0x02b2
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            int r4 = r4.mask     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            int r5 = r5.mask     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r6 = r4 | r5
            if (r16 != 0) goto L_0x029c
            r7 = r3 & r6
            if (r7 != 0) goto L_0x029c
            int r7 = r14.features     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r6 = r6 & r7
            if (r6 != 0) goto L_0x029c
            goto L_0x0204
        L_0x029c:
            r6 = r3 & r4
            if (r6 == 0) goto L_0x02a5
            java.util.List r1 = java.util.Collections.emptyList()     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            goto L_0x02c9
        L_0x02a5:
            int r6 = r14.features     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r4 = r4 & r6
            if (r4 == 0) goto L_0x02c9
            r3 = r3 & r5
            if (r3 != 0) goto L_0x02c9
            java.util.List r1 = java.util.Collections.emptyList()     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            goto L_0x02c9
        L_0x02b2:
            if (r16 != 0) goto L_0x02c9
            boolean r4 = r13.writeNull     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r4 != 0) goto L_0x02c9
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            int r5 = r4.mask     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            boolean r5 = r14.isEnabled((int) r5)     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r5 != 0) goto L_0x02c9
            int r4 = r4.mask     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r3 = r3 & r4
            if (r3 != 0) goto L_0x02c9
            goto L_0x0204
        L_0x02c9:
            if (r1 == 0) goto L_0x0371
            boolean r3 = r14.notWriteDefaultValue     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r3 != 0) goto L_0x02df
            int r3 = r11.serialzeFeatures     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            int r4 = r4.mask     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r3 = r3 & r4
            if (r3 != 0) goto L_0x02df
            com.alibaba.fastjson.serializer.SerializeBeanInfo r3 = r8.beanInfo     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            int r3 = r3.features     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0371
        L_0x02df:
            java.lang.Class<?> r3 = r11.fieldClass     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            java.lang.Class r4 = java.lang.Byte.TYPE     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r3 != r4) goto L_0x02f4
            boolean r4 = r1 instanceof java.lang.Byte     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r4 == 0) goto L_0x02f4
            r4 = r1
            java.lang.Byte r4 = (java.lang.Byte) r4     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            byte r4 = r4.byteValue()     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r4 != 0) goto L_0x02f4
            goto L_0x0204
        L_0x02f4:
            java.lang.Class r4 = java.lang.Short.TYPE     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r3 != r4) goto L_0x0307
            boolean r4 = r1 instanceof java.lang.Short     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r4 == 0) goto L_0x0307
            r4 = r1
            java.lang.Short r4 = (java.lang.Short) r4     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            short r4 = r4.shortValue()     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r4 != 0) goto L_0x0307
            goto L_0x0204
        L_0x0307:
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r3 != r4) goto L_0x031a
            boolean r4 = r1 instanceof java.lang.Integer     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r4 == 0) goto L_0x031a
            r4 = r1
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r4 != 0) goto L_0x031a
            goto L_0x0204
        L_0x031a:
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r3 != r4) goto L_0x0331
            boolean r4 = r1 instanceof java.lang.Long     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r4 == 0) goto L_0x0331
            r4 = r1
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x0331
            goto L_0x0204
        L_0x0331:
            java.lang.Class r4 = java.lang.Float.TYPE     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r3 != r4) goto L_0x0347
            boolean r4 = r1 instanceof java.lang.Float     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r4 == 0) goto L_0x0347
            r4 = r1
            java.lang.Float r4 = (java.lang.Float) r4     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            float r4 = r4.floatValue()     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x0347
            goto L_0x0204
        L_0x0347:
            java.lang.Class r4 = java.lang.Double.TYPE     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r3 != r4) goto L_0x035e
            boolean r4 = r1 instanceof java.lang.Double     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r4 == 0) goto L_0x035e
            r4 = r1
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            double r4 = r4.doubleValue()     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x035e
            goto L_0x0204
        L_0x035e:
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r3 != r4) goto L_0x0371
            boolean r3 = r1 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r3 == 0) goto L_0x0371
            r3 = r1
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r3 != 0) goto L_0x0371
            goto L_0x0204
        L_0x0371:
            if (r21 == 0) goto L_0x0397
            boolean r3 = r11.unwrapped     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r3 == 0) goto L_0x0386
            boolean r3 = r1 instanceof java.util.Map     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r3 == 0) goto L_0x0386
            r3 = r1
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            int r3 = r3.size()     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r3 != 0) goto L_0x0386
            goto L_0x0204
        L_0x0386:
            r3 = 44
            r14.write((int) r3)     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            boolean r4 = r14.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r4)     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            if (r4 == 0) goto L_0x0399
            r32.println()     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
            goto L_0x0399
        L_0x0397:
            r3 = 44
        L_0x0399:
            if (r12 == r15) goto L_0x03b3
            if (r16 != 0) goto L_0x03a4
            r4 = 1
            r14.writeFieldName(r12, r4)     // Catch:{ Exception -> 0x01ce, all -> 0x01c7 }
        L_0x03a1:
            r5 = r32
            goto L_0x03a6
        L_0x03a4:
            r4 = 1
            goto L_0x03a1
        L_0x03a6:
            r5.write((java.lang.Object) r1)     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
        L_0x03a9:
            r9 = r24
            goto L_0x0471
        L_0x03ad:
            r0 = move-exception
            goto L_0x01ca
        L_0x03b0:
            r0 = move-exception
            goto L_0x01d1
        L_0x03b3:
            r5 = r32
            r6 = r9
            r4 = 1
            if (r0 == r1) goto L_0x03c2
            if (r16 != 0) goto L_0x03be
            r13.writePrefix(r5)     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
        L_0x03be:
            r5.write((java.lang.Object) r1)     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            goto L_0x03a9
        L_0x03c2:
            if (r16 != 0) goto L_0x03ef
            java.lang.Class<java.util.Map> r0 = java.util.Map.class
            boolean r0 = r0.isAssignableFrom(r6)     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            boolean r7 = r6.isPrimitive()     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            if (r7 != 0) goto L_0x03dc
            java.lang.String r7 = r6.getName()     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            java.lang.String r9 = "java."
            boolean r7 = r7.startsWith(r9)     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            if (r7 == 0) goto L_0x03e0
        L_0x03dc:
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            if (r6 != r7) goto L_0x03e2
        L_0x03e0:
            r7 = r4
            goto L_0x03e4
        L_0x03e2:
            r7 = r24
        L_0x03e4:
            if (r18 != 0) goto L_0x03f2
            boolean r9 = r11.unwrapped     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            if (r9 == 0) goto L_0x03f2
            if (r0 != 0) goto L_0x03ef
            if (r7 != 0) goto L_0x03ef
            goto L_0x03f2
        L_0x03ef:
            r9 = r24
            goto L_0x0402
        L_0x03f2:
            if (r26 == 0) goto L_0x03fd
            char[] r0 = r11.name_chars     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            int r7 = r0.length     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            r9 = r24
            r14.write((char[]) r0, (int) r9, (int) r7)     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            goto L_0x0402
        L_0x03fd:
            r9 = r24
            r13.writePrefix(r5)     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
        L_0x0402:
            if (r16 != 0) goto L_0x046e
            com.alibaba.fastjson.annotation.JSONField r0 = r11.getAnnotation()     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            if (r6 != r10) goto L_0x0453
            if (r0 == 0) goto L_0x0414
            java.lang.Class r0 = r0.serializeUsing()     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            java.lang.Class<java.lang.Void> r6 = java.lang.Void.class
            if (r0 != r6) goto L_0x0453
        L_0x0414:
            if (r1 != 0) goto L_0x0446
            int r0 = r13.features     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            com.alibaba.fastjson.serializer.SerializeBeanInfo r6 = r8.beanInfo     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            com.alibaba.fastjson.annotation.JSONType r6 = r6.jsonType     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            if (r6 == 0) goto L_0x0427
            com.alibaba.fastjson.serializer.SerializerFeature[] r6 = r6.serialzeFeatures()     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            int r6 = com.alibaba.fastjson.serializer.SerializerFeature.of(r6)     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            r0 = r0 | r6
        L_0x0427:
            int r6 = r14.features     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            com.alibaba.fastjson.serializer.SerializerFeature r7 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            int r7 = r7.mask     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            r6 = r6 & r7
            if (r6 == 0) goto L_0x043b
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            int r6 = r6.mask     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            r6 = r6 & r0
            if (r6 != 0) goto L_0x043b
            r14.writeString((java.lang.String) r2)     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            goto L_0x0471
        L_0x043b:
            r0 = r0 & r7
            if (r0 == 0) goto L_0x0442
            r14.writeString((java.lang.String) r2)     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            goto L_0x0471
        L_0x0442:
            r14.writeNull()     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            goto L_0x0471
        L_0x0446:
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            if (r25 == 0) goto L_0x044f
            r14.writeStringWithSingleQuote((java.lang.String) r0)     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            goto L_0x0471
        L_0x044f:
            r14.writeStringWithDoubleQuote((java.lang.String) r0, (char) r9)     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            goto L_0x0471
        L_0x0453:
            boolean r0 = r11.unwrapped     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            if (r0 == 0) goto L_0x046a
            boolean r0 = r1 instanceof java.util.Map     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            if (r0 == 0) goto L_0x046a
            r0 = r1
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            int r0 = r0.size()     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            if (r0 != 0) goto L_0x046a
            r21 = r9
        L_0x0466:
            r1 = r27
            goto L_0x04c4
        L_0x046a:
            r13.writeValue(r5, r1)     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            goto L_0x0471
        L_0x046e:
            r13.writeValue(r5, r1)     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
        L_0x0471:
            boolean r0 = r11.unwrapped     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            if (r0 == 0) goto L_0x049e
            boolean r0 = r1 instanceof java.util.Map     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            if (r0 == 0) goto L_0x049e
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            int r0 = r1.size()     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            if (r0 != 0) goto L_0x0482
            goto L_0x0466
        L_0x0482:
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            boolean r0 = r5.isEnabled(r0)     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            if (r0 != 0) goto L_0x049e
            java.util.Collection r0 = r1.values()     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
        L_0x0492:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            if (r1 == 0) goto L_0x0466
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x03b0, all -> 0x03ad }
            if (r1 == 0) goto L_0x0492
        L_0x049e:
            r21 = r4
            goto L_0x0466
        L_0x04a1:
            r0 = move-exception
            r5 = r9
            r30 = r23
            goto L_0x01ca
        L_0x04a7:
            r0 = move-exception
            r5 = r9
            r30 = r23
            goto L_0x01d1
        L_0x04ad:
            r5 = r9
            r30 = r23
            throw r1     // Catch:{ Exception -> 0x04b1, all -> 0x03ad }
        L_0x04b1:
            r0 = move-exception
        L_0x04b2:
            r2 = r33
            r1 = r13
            goto L_0x01d5
        L_0x04b7:
            r0 = move-exception
            r5 = r9
            r30 = r23
            goto L_0x04b2
        L_0x04bc:
            r0 = move-exception
            r5 = r9
            r30 = r23
        L_0x04c0:
            r2 = r33
            goto L_0x01d5
        L_0x04c4:
            int r2 = r28 + 1
            r10 = r33
            r11 = r34
            r12 = r35
            r13 = r36
            r9 = r5
            r15 = r22
            r6 = r29
            r7 = r30
            r5 = r3
            goto L_0x00cd
        L_0x04d8:
            r0 = move-exception
            r30 = r7
            r5 = r9
            goto L_0x01ca
        L_0x04de:
            r0 = move-exception
            r30 = r7
            r5 = r9
            goto L_0x04c0
        L_0x04e3:
            r3 = r5
            r29 = r6
            r30 = r7
            r5 = r9
            r22 = r15
            r9 = 0
            r2 = r33
            if (r21 == 0) goto L_0x04f1
            r9 = r3
        L_0x04f1:
            r8.writeAfter(r5, r2, r9)     // Catch:{ Exception -> 0x0508, all -> 0x03ad }
            r3 = r22
            int r0 = r3.length     // Catch:{ Exception -> 0x0508, all -> 0x03ad }
            if (r0 <= 0) goto L_0x050b
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x0508, all -> 0x03ad }
            boolean r0 = r14.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r0)     // Catch:{ Exception -> 0x0508, all -> 0x03ad }
            if (r0 == 0) goto L_0x050b
            r32.decrementIdent()     // Catch:{ Exception -> 0x0508, all -> 0x03ad }
            r32.println()     // Catch:{ Exception -> 0x0508, all -> 0x03ad }
            goto L_0x050b
        L_0x0508:
            r0 = move-exception
            goto L_0x01d5
        L_0x050b:
            if (r37 != 0) goto L_0x0512
            r3 = r29
            r14.append((char) r3)     // Catch:{ Exception -> 0x0508, all -> 0x03ad }
        L_0x0512:
            r3 = r30
            r5.context = r3
            return
        L_0x0517:
            r0 = move-exception
            r3 = r7
            r5 = r9
            r2 = r10
        L_0x051b:
            java.lang.String r4 = "write javaBean error, fastjson version 1.2.67"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0552 }
            r6.<init>()     // Catch:{ all -> 0x0552 }
            r6.append(r4)     // Catch:{ all -> 0x0552 }
            java.lang.String r4 = ", class "
            r6.append(r4)     // Catch:{ all -> 0x0552 }
            java.lang.Class r2 = r33.getClass()     // Catch:{ all -> 0x0552 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0552 }
            r6.append(r2)     // Catch:{ all -> 0x0552 }
            java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x0552 }
            java.lang.String r4 = ", fieldName : "
            r6 = r34
            if (r6 == 0) goto L_0x0554
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0552 }
            r1.<init>()     // Catch:{ all -> 0x0552 }
            r1.append(r2)     // Catch:{ all -> 0x0552 }
            r1.append(r4)     // Catch:{ all -> 0x0552 }
            r1.append(r6)     // Catch:{ all -> 0x0552 }
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x0552 }
            goto L_0x058f
        L_0x0552:
            r0 = move-exception
            goto L_0x05c0
        L_0x0554:
            if (r1 == 0) goto L_0x058f
            com.alibaba.fastjson.util.FieldInfo r6 = r1.fieldInfo     // Catch:{ all -> 0x0552 }
            if (r6 == 0) goto L_0x058f
            java.lang.reflect.Method r7 = r6.method     // Catch:{ all -> 0x0552 }
            if (r7 == 0) goto L_0x0579
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0552 }
            r1.<init>()     // Catch:{ all -> 0x0552 }
            r1.append(r2)     // Catch:{ all -> 0x0552 }
            java.lang.String r2 = ", method : "
            r1.append(r2)     // Catch:{ all -> 0x0552 }
            java.lang.reflect.Method r2 = r6.method     // Catch:{ all -> 0x0552 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0552 }
            r1.append(r2)     // Catch:{ all -> 0x0552 }
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x0552 }
            goto L_0x058f
        L_0x0579:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0552 }
            r6.<init>()     // Catch:{ all -> 0x0552 }
            r6.append(r2)     // Catch:{ all -> 0x0552 }
            r6.append(r4)     // Catch:{ all -> 0x0552 }
            com.alibaba.fastjson.util.FieldInfo r1 = r1.fieldInfo     // Catch:{ all -> 0x0552 }
            java.lang.String r1 = r1.name     // Catch:{ all -> 0x0552 }
            r6.append(r1)     // Catch:{ all -> 0x0552 }
            java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x0552 }
        L_0x058f:
            java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x0552 }
            if (r1 == 0) goto L_0x05ad
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0552 }
            r1.<init>()     // Catch:{ all -> 0x0552 }
            r1.append(r2)     // Catch:{ all -> 0x0552 }
            java.lang.String r2 = ", "
            r1.append(r2)     // Catch:{ all -> 0x0552 }
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x0552 }
            r1.append(r2)     // Catch:{ all -> 0x0552 }
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x0552 }
        L_0x05ad:
            boolean r1 = r0 instanceof java.lang.reflect.InvocationTargetException     // Catch:{ all -> 0x0552 }
            if (r1 == 0) goto L_0x05b5
            java.lang.Throwable r17 = r0.getCause()     // Catch:{ all -> 0x0552 }
        L_0x05b5:
            if (r17 != 0) goto L_0x05b8
            goto L_0x05ba
        L_0x05b8:
            r0 = r17
        L_0x05ba:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0552 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0552 }
            throw r1     // Catch:{ all -> 0x0552 }
        L_0x05c0:
            r5.context = r3
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, (PropertyNamingStrategy) null));
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        FieldSerializer[] fieldSerializerArr;
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i = 0;
        while (true) {
            fieldSerializerArr = this.sortedGetters;
            if (i >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i]);
            i++;
        }
        FieldInfo[] fieldInfoArr = serializeBeanInfo.fields;
        if (fieldInfoArr == serializeBeanInfo.sortedFields) {
            this.getters = fieldSerializerArr;
        } else {
            this.getters = new FieldSerializer[fieldInfoArr.length];
            int i2 = 0;
            while (true) {
                if (i2 >= this.getters.length) {
                    break;
                }
                FieldSerializer fieldSerializer = getFieldSerializer(serializeBeanInfo.fields[i2].name);
                if (fieldSerializer == null) {
                    FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                    System.arraycopy(fieldSerializerArr2, 0, this.getters, 0, fieldSerializerArr2.length);
                    break;
                }
                this.getters[i2] = fieldSerializer;
                i2++;
            }
        }
        JSONType jSONType = serializeBeanInfo.jsonType;
        if (jSONType != null) {
            for (Class constructor : jSONType.serialzeFilters()) {
                try {
                    addFilter((SerializeFilter) constructor.getConstructor((Class[]) null).newInstance((Object[]) null));
                } catch (Exception unused) {
                }
            }
        }
    }

    public FieldSerializer getFieldSerializer(long j) {
        PropertyNamingStrategy[] propertyNamingStrategyArr;
        int binarySearch;
        if (this.hashArray == null) {
            propertyNamingStrategyArr = PropertyNamingStrategy.values();
            long[] jArr = new long[(this.sortedGetters.length * propertyNamingStrategyArr.length)];
            int i = 0;
            int i2 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr = this.sortedGetters;
                if (i >= fieldSerializerArr.length) {
                    break;
                }
                String str = fieldSerializerArr[i].fieldInfo.name;
                jArr[i2] = TypeUtils.fnv1a_64(str);
                i2++;
                for (PropertyNamingStrategy translate : propertyNamingStrategyArr) {
                    String translate2 = translate.translate(str);
                    if (!str.equals(translate2)) {
                        jArr[i2] = TypeUtils.fnv1a_64(translate2);
                        i2++;
                    }
                }
                i++;
            }
            Arrays.sort(jArr, 0, i2);
            this.hashArray = new long[i2];
            System.arraycopy(jArr, 0, this.hashArray, 0, i2);
        } else {
            propertyNamingStrategyArr = null;
        }
        int binarySearch2 = Arrays.binarySearch(this.hashArray, j);
        if (binarySearch2 < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            if (propertyNamingStrategyArr == null) {
                propertyNamingStrategyArr = PropertyNamingStrategy.values();
            }
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, -1);
            int i3 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                if (i3 >= fieldSerializerArr2.length) {
                    break;
                }
                String str2 = fieldSerializerArr2[i3].fieldInfo.name;
                int binarySearch3 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(str2));
                if (binarySearch3 >= 0) {
                    sArr[binarySearch3] = (short) i3;
                }
                for (PropertyNamingStrategy translate3 : propertyNamingStrategyArr) {
                    String translate4 = translate3.translate(str2);
                    if (!str2.equals(translate4) && (binarySearch = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(translate4))) >= 0) {
                        sArr[binarySearch] = (short) i3;
                    }
                }
                i3++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[binarySearch2];
        if (s != -1) {
            return this.sortedGetters[s];
        }
        return null;
    }

    public Object getFieldValue(Object obj, String str, long j, boolean z) {
        FieldSerializer fieldSerializer = getFieldSerializer(j);
        if (fieldSerializer != null) {
            try {
                return fieldSerializer.getPropertyValue(obj);
            } catch (InvocationTargetException e) {
                throw new JSONException("getFieldValue error." + str, e);
            } catch (IllegalAccessException e2) {
                throw new JSONException("getFieldValue error." + str, e2);
            }
        } else if (!z) {
            return null;
        } else {
            throw new JSONException("field not found. " + str);
        }
    }
}

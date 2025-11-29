package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
    private static final int NON_STRINGKEY_AS_STRING = SerializerFeature.of(new SerializerFeature[]{SerializerFeature.BrowserCompatible, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.BrowserSecure});
    public static MapSerializer instance = new MapSerializer();

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.alibaba.fastjson.serializer.JavaBeanSerializer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: java.util.TreeMap} */
    /* JADX WARNING: type inference failed for: r0v8, types: [boolean] */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0242, code lost:
        if (com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(r12.features, r11, com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue) == false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d2, code lost:
        if ((r1 instanceof java.lang.Number) == false) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00dc, code lost:
        if (r0.applyName(r8, r9, com.alibaba.fastjson.JSON.toJSONString(r1)) != false) goto L_0x00ed;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x023a A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0252 A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0269 A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0294 A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x029e A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:219:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a7 A[Catch:{ all -> 0x0056 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r24, java.lang.Object r25, java.lang.Object r26, java.lang.reflect.Type r27, int r28, boolean r29) throws java.io.IOException {
        /*
            r23 = this;
            r0 = r23
            r8 = r24
            r9 = r25
            r10 = r27
            r11 = r28
            com.alibaba.fastjson.serializer.SerializeWriter r12 = r8.out
            if (r9 != 0) goto L_0x0012
            r12.writeNull()
            return
        L_0x0012:
            r1 = r9
            java.util.Map r1 = (java.util.Map) r1
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.MapSortField
            int r2 = r2.mask
            int r3 = r12.features
            r3 = r3 & r2
            if (r3 != 0) goto L_0x0024
            r2 = r2 & r11
            if (r2 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r13 = r1
            goto L_0x003c
        L_0x0024:
            boolean r2 = r1 instanceof com.alibaba.fastjson.JSONObject
            if (r2 == 0) goto L_0x002e
            com.alibaba.fastjson.JSONObject r1 = (com.alibaba.fastjson.JSONObject) r1
            java.util.Map r1 = r1.getInnerMap()
        L_0x002e:
            boolean r2 = r1 instanceof java.util.SortedMap
            if (r2 != 0) goto L_0x0022
            boolean r2 = r1 instanceof java.util.LinkedHashMap
            if (r2 != 0) goto L_0x0022
            java.util.TreeMap r2 = new java.util.TreeMap     // Catch:{ Exception -> 0x0022 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0022 }
            r13 = r2
        L_0x003c:
            boolean r1 = r24.containsReference(r25)
            if (r1 == 0) goto L_0x0046
            r24.writeReference(r25)
            return
        L_0x0046:
            com.alibaba.fastjson.serializer.SerialContext r14 = r8.context
            r15 = 0
            r1 = r26
            r8.setContext(r14, r9, r1, r15)
            if (r29 != 0) goto L_0x0059
            r1 = 123(0x7b, float:1.72E-43)
            r12.write((int) r1)     // Catch:{ all -> 0x0056 }
            goto L_0x0059
        L_0x0056:
            r0 = move-exception
            goto L_0x0311
        L_0x0059:
            r24.incrementIndent()     // Catch:{ all -> 0x0056 }
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ all -> 0x0056 }
            boolean r1 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ all -> 0x0056 }
            r7 = 1
            if (r1 == 0) goto L_0x0090
            com.alibaba.fastjson.serializer.SerializeConfig r1 = r8.config     // Catch:{ all -> 0x0056 }
            java.lang.String r1 = r1.typeKey     // Catch:{ all -> 0x0056 }
            java.lang.Class r2 = r13.getClass()     // Catch:{ all -> 0x0056 }
            java.lang.Class<com.alibaba.fastjson.JSONObject> r3 = com.alibaba.fastjson.JSONObject.class
            if (r2 == r3) goto L_0x0079
            java.lang.Class<java.util.HashMap> r3 = java.util.HashMap.class
            if (r2 == r3) goto L_0x0079
            java.lang.Class<java.util.LinkedHashMap> r3 = java.util.LinkedHashMap.class
            if (r2 != r3) goto L_0x0080
        L_0x0079:
            boolean r2 = r13.containsKey(r1)     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0080
            goto L_0x0090
        L_0x0080:
            r12.writeFieldName(r1)     // Catch:{ all -> 0x0056 }
            java.lang.Class r1 = r25.getClass()     // Catch:{ all -> 0x0056 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0056 }
            r12.writeString((java.lang.String) r1)     // Catch:{ all -> 0x0056 }
            r1 = r15
            goto L_0x0091
        L_0x0090:
            r1 = r7
        L_0x0091:
            java.util.Set r2 = r13.entrySet()     // Catch:{ all -> 0x0056 }
            java.util.Iterator r16 = r2.iterator()     // Catch:{ all -> 0x0056 }
            r17 = 0
            r18 = r1
            r6 = r17
            r19 = r6
        L_0x00a1:
            boolean r1 = r16.hasNext()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x02f3
            java.lang.Object r1 = r16.next()     // Catch:{ all -> 0x0056 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x0056 }
            java.lang.Object r5 = r1.getValue()     // Catch:{ all -> 0x0056 }
            java.lang.Object r1 = r1.getKey()     // Catch:{ all -> 0x0056 }
            java.util.List<com.alibaba.fastjson.serializer.PropertyPreFilter> r2 = r8.propertyPreFilters     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x00ed
            int r2 = r2.size()     // Catch:{ all -> 0x0056 }
            if (r2 <= 0) goto L_0x00ed
            if (r1 == 0) goto L_0x00e3
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x00c6
            goto L_0x00e3
        L_0x00c6:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0056 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x00d4
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x00ed
        L_0x00d4:
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0056 }
            boolean r2 = r0.applyName(r8, r9, r2)     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x00ed
        L_0x00de:
            r22 = r6
            r0 = r7
            goto L_0x0244
        L_0x00e3:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0056 }
            boolean r2 = r0.applyName(r8, r9, r2)     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x00ed
            goto L_0x00de
        L_0x00ed:
            java.util.List<com.alibaba.fastjson.serializer.PropertyPreFilter> r2 = r0.propertyPreFilters     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0121
            int r2 = r2.size()     // Catch:{ all -> 0x0056 }
            if (r2 <= 0) goto L_0x0121
            if (r1 == 0) goto L_0x0117
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x00fe
            goto L_0x0117
        L_0x00fe:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0056 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x010c
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0121
        L_0x010c:
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0056 }
            boolean r2 = r0.applyName(r8, r9, r2)     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x0121
            goto L_0x00de
        L_0x0117:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0056 }
            boolean r2 = r0.applyName(r8, r9, r2)     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x0121
            goto L_0x00de
        L_0x0121:
            java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> r2 = r8.propertyFilters     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0155
            int r2 = r2.size()     // Catch:{ all -> 0x0056 }
            if (r2 <= 0) goto L_0x0155
            if (r1 == 0) goto L_0x014b
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0132
            goto L_0x014b
        L_0x0132:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0056 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x0140
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0155
        L_0x0140:
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0056 }
            boolean r2 = r0.apply(r8, r9, r2, r5)     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x0155
            goto L_0x00de
        L_0x014b:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0056 }
            boolean r2 = r0.apply(r8, r9, r2, r5)     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x0155
            goto L_0x00de
        L_0x0155:
            java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> r2 = r0.propertyFilters     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x018b
            int r2 = r2.size()     // Catch:{ all -> 0x0056 }
            if (r2 <= 0) goto L_0x018b
            if (r1 == 0) goto L_0x0180
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0166
            goto L_0x0180
        L_0x0166:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0056 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x0174
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x018b
        L_0x0174:
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0056 }
            boolean r2 = r0.apply(r8, r9, r2, r5)     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x018b
            goto L_0x00de
        L_0x0180:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0056 }
            boolean r2 = r0.apply(r8, r9, r2, r5)     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x018b
            goto L_0x00de
        L_0x018b:
            java.util.List<com.alibaba.fastjson.serializer.NameFilter> r2 = r8.nameFilters     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x01b9
            int r2 = r2.size()     // Catch:{ all -> 0x0056 }
            if (r2 <= 0) goto L_0x01b9
            if (r1 == 0) goto L_0x01b3
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x019c
            goto L_0x01b3
        L_0x019c:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0056 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x01aa
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x01b9
        L_0x01aa:
            java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0056 }
            java.lang.String r1 = r0.processKey(r8, r9, r1, r5)     // Catch:{ all -> 0x0056 }
            goto L_0x01b9
        L_0x01b3:
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0056 }
            java.lang.String r1 = r0.processKey(r8, r9, r1, r5)     // Catch:{ all -> 0x0056 }
        L_0x01b9:
            java.util.List<com.alibaba.fastjson.serializer.NameFilter> r2 = r0.nameFilters     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x01e0
            int r2 = r2.size()     // Catch:{ all -> 0x0056 }
            if (r2 <= 0) goto L_0x01e0
            if (r1 == 0) goto L_0x01e2
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x01ca
            goto L_0x01e2
        L_0x01ca:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0056 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x01d8
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x01e0
        L_0x01d8:
            java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0056 }
            java.lang.String r1 = r0.processKey(r8, r9, r1, r5)     // Catch:{ all -> 0x0056 }
        L_0x01e0:
            r4 = r1
            goto L_0x01e9
        L_0x01e2:
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0056 }
            java.lang.String r1 = r0.processKey(r8, r9, r1, r5)     // Catch:{ all -> 0x0056 }
            goto L_0x01e0
        L_0x01e9:
            if (r4 == 0) goto L_0x01ef
            boolean r1 = r4 instanceof java.lang.String     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x01f6
        L_0x01ef:
            r15 = r4
            r21 = r5
            r22 = r6
            r0 = r7
            goto L_0x0225
        L_0x01f6:
            boolean r1 = r4 instanceof java.util.Map     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x01fe
            boolean r1 = r4 instanceof java.util.Collection     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x0205
        L_0x01fe:
            r15 = r4
            r21 = r5
            r22 = r6
            r0 = r7
            goto L_0x0222
        L_0x0205:
            java.lang.String r20 = com.alibaba.fastjson.JSON.toJSONString(r4)     // Catch:{ all -> 0x0056 }
            r3 = 0
            r1 = r23
            r2 = r24
            r15 = r4
            r4 = r25
            r21 = r5
            r5 = r20
            r22 = r6
            r6 = r21
            r0 = r7
            r7 = r28
            java.lang.Object r1 = r1.processValue(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0056 }
        L_0x0220:
            r3 = r1
            goto L_0x0238
        L_0x0222:
            r3 = r21
            goto L_0x0238
        L_0x0225:
            r5 = r15
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0056 }
            r3 = 0
            r1 = r23
            r2 = r24
            r4 = r25
            r6 = r21
            r7 = r28
            java.lang.Object r1 = r1.processValue(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0056 }
            goto L_0x0220
        L_0x0238:
            if (r3 != 0) goto L_0x024c
            int r1 = r12.features     // Catch:{ all -> 0x0056 }
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ all -> 0x0056 }
            boolean r1 = com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(r1, r11, r2)     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x024c
        L_0x0244:
            r7 = r0
            r6 = r22
            r15 = 0
        L_0x0248:
            r0 = r23
            goto L_0x00a1
        L_0x024c:
            boolean r1 = r15 instanceof java.lang.String     // Catch:{ all -> 0x0056 }
            r2 = 44
            if (r1 == 0) goto L_0x0269
            r4 = r15
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0056 }
            if (r18 != 0) goto L_0x025a
            r12.write((int) r2)     // Catch:{ all -> 0x0056 }
        L_0x025a:
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ all -> 0x0056 }
            boolean r1 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x0265
            r24.println()     // Catch:{ all -> 0x0056 }
        L_0x0265:
            r12.writeFieldName(r4, r0)     // Catch:{ all -> 0x0056 }
            goto L_0x0292
        L_0x0269:
            if (r18 != 0) goto L_0x026e
            r12.write((int) r2)     // Catch:{ all -> 0x0056 }
        L_0x026e:
            int r1 = NON_STRINGKEY_AS_STRING     // Catch:{ all -> 0x0056 }
            boolean r1 = r12.isEnabled((int) r1)     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x027e
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNonStringKeyAsString     // Catch:{ all -> 0x0056 }
            boolean r1 = com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(r11, r1)     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x028a
        L_0x027e:
            boolean r1 = r15 instanceof java.lang.Enum     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x028a
            java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r15)     // Catch:{ all -> 0x0056 }
            r8.write((java.lang.String) r1)     // Catch:{ all -> 0x0056 }
            goto L_0x028d
        L_0x028a:
            r8.write((java.lang.Object) r15)     // Catch:{ all -> 0x0056 }
        L_0x028d:
            r1 = 58
            r12.write((int) r1)     // Catch:{ all -> 0x0056 }
        L_0x0292:
            if (r3 != 0) goto L_0x029e
            r12.writeNull()     // Catch:{ all -> 0x0056 }
            r7 = r0
            r6 = r22
            r15 = 0
            r18 = 0
            goto L_0x0248
        L_0x029e:
            java.lang.Class r1 = r3.getClass()     // Catch:{ all -> 0x0056 }
            r2 = r22
            if (r1 == r2) goto L_0x02ad
            com.alibaba.fastjson.serializer.ObjectSerializer r2 = r8.getObjectWriter(r1)     // Catch:{ all -> 0x0056 }
            r7 = r1
            r6 = r2
            goto L_0x02b0
        L_0x02ad:
            r7 = r2
            r6 = r19
        L_0x02b0:
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ all -> 0x0056 }
            boolean r1 = com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(r11, r1)     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x02df
            boolean r1 = r6 instanceof com.alibaba.fastjson.serializer.JavaBeanSerializer     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x02df
            boolean r1 = r10 instanceof java.lang.reflect.ParameterizedType     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x02cf
            r1 = r10
            java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1     // Catch:{ all -> 0x0056 }
            java.lang.reflect.Type[] r1 = r1.getActualTypeArguments()     // Catch:{ all -> 0x0056 }
            int r2 = r1.length     // Catch:{ all -> 0x0056 }
            r4 = 2
            if (r2 != r4) goto L_0x02cf
            r1 = r1[r0]     // Catch:{ all -> 0x0056 }
            r5 = r1
            goto L_0x02d1
        L_0x02cf:
            r5 = r17
        L_0x02d1:
            r1 = r6
            com.alibaba.fastjson.serializer.JavaBeanSerializer r1 = (com.alibaba.fastjson.serializer.JavaBeanSerializer) r1     // Catch:{ all -> 0x0056 }
            r2 = r24
            r4 = r15
            r19 = r6
            r6 = r28
            r1.writeNoneASM(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0056 }
            goto L_0x02ec
        L_0x02df:
            r19 = r6
            r5 = 0
            r1 = r19
            r2 = r24
            r4 = r15
            r6 = r28
            r1.write(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0056 }
        L_0x02ec:
            r6 = r7
            r15 = 0
            r18 = 0
            r7 = r0
            goto L_0x0248
        L_0x02f3:
            r8.context = r14
            r24.decrementIdent()
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat
            boolean r0 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r0)
            if (r0 == 0) goto L_0x0309
            int r0 = r13.size()
            if (r0 <= 0) goto L_0x0309
            r24.println()
        L_0x0309:
            if (r29 != 0) goto L_0x0310
            r0 = 125(0x7d, float:1.75E-43)
            r12.write((int) r0)
        L_0x0310:
            return
        L_0x0311:
            r8.context = r14
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.MapSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }
}

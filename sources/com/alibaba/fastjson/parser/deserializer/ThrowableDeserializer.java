package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.Constructor;

public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    private Throwable createException(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor constructor = null;
        Constructor constructor2 = null;
        Constructor constructor3 = null;
        for (Constructor constructor4 : cls.getConstructors()) {
            Class<Throwable>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else {
                Class<String> cls2 = String.class;
                if (parameterTypes.length == 1 && parameterTypes[0] == cls2) {
                    constructor2 = constructor4;
                } else if (parameterTypes.length == 2 && parameterTypes[0] == cls2 && parameterTypes[1] == Throwable.class) {
                    constructor = constructor4;
                }
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(new Object[]{str, th});
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(new Object[]{str});
        }
        if (constructor3 != null) {
            return (Throwable) constructor3.newInstance((Object[]) null);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r4.isAssignableFrom(r2) != false) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r17, java.lang.reflect.Type r18, java.lang.Object r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            com.alibaba.fastjson.parser.JSONLexer r3 = r1.lexer
            int r4 = r3.token()
            r5 = 0
            r6 = 8
            if (r4 != r6) goto L_0x0015
            r3.nextToken()
            return r5
        L_0x0015:
            int r4 = r17.getResolveStatus()
            r7 = 2
            java.lang.String r8 = "syntax error"
            if (r4 != r7) goto L_0x0023
            r4 = 0
            r1.setResolveStatus(r4)
            goto L_0x002b
        L_0x0023:
            int r4 = r3.token()
            r7 = 12
            if (r4 != r7) goto L_0x017a
        L_0x002b:
            java.lang.Class<java.lang.Throwable> r4 = java.lang.Throwable.class
            if (r2 == 0) goto L_0x003c
            boolean r7 = r2 instanceof java.lang.Class
            if (r7 == 0) goto L_0x003c
            java.lang.Class r2 = (java.lang.Class) r2
            boolean r7 = r4.isAssignableFrom(r2)
            if (r7 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r2 = r5
        L_0x003d:
            r7 = r5
            r9 = r7
            r10 = r9
            r11 = r10
        L_0x0041:
            com.alibaba.fastjson.parser.SymbolTable r12 = r17.getSymbolTable()
            java.lang.String r12 = r3.scanSymbol(r12)
            r13 = 13
            r14 = 16
            if (r12 != 0) goto L_0x0069
            int r15 = r3.token()
            if (r15 != r13) goto L_0x005a
            r3.nextToken(r14)
            goto L_0x00f2
        L_0x005a:
            int r15 = r3.token()
            if (r15 != r14) goto L_0x0069
            com.alibaba.fastjson.parser.Feature r15 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas
            boolean r15 = r3.isEnabled((com.alibaba.fastjson.parser.Feature) r15)
            if (r15 == 0) goto L_0x0069
            goto L_0x0041
        L_0x0069:
            r15 = 4
            r3.nextTokenWithColon(r15)
            java.lang.String r13 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY
            boolean r13 = r13.equals(r12)
            if (r13 == 0) goto L_0x0095
            int r2 = r3.token()
            if (r2 != r15) goto L_0x008f
            java.lang.String r2 = r3.stringVal()
            com.alibaba.fastjson.parser.ParserConfig r12 = r17.getConfig()
            int r13 = r3.getFeatures()
            java.lang.Class r2 = r12.checkAutoType(r2, r4, r13)
            r3.nextToken(r14)
            goto L_0x00e7
        L_0x008f:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r8)
            throw r0
        L_0x0095:
            java.lang.String r13 = "message"
            boolean r13 = r13.equals(r12)
            if (r13 == 0) goto L_0x00b9
            int r10 = r3.token()
            if (r10 != r6) goto L_0x00a5
            r10 = r5
            goto L_0x00af
        L_0x00a5:
            int r10 = r3.token()
            if (r10 != r15) goto L_0x00b3
            java.lang.String r10 = r3.stringVal()
        L_0x00af:
            r3.nextToken()
            goto L_0x00e7
        L_0x00b3:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r8)
            throw r0
        L_0x00b9:
            java.lang.String r13 = "cause"
            boolean r15 = r13.equals(r12)
            if (r15 == 0) goto L_0x00c8
            java.lang.Object r9 = r0.deserialze(r1, r5, r13)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            goto L_0x00e7
        L_0x00c8:
            java.lang.String r13 = "stackTrace"
            boolean r13 = r13.equals(r12)
            if (r13 == 0) goto L_0x00d9
            java.lang.Class<java.lang.StackTraceElement[]> r11 = java.lang.StackTraceElement[].class
            java.lang.Object r11 = r1.parseObject(r11)
            java.lang.StackTraceElement[] r11 = (java.lang.StackTraceElement[]) r11
            goto L_0x00e7
        L_0x00d9:
            if (r7 != 0) goto L_0x00e0
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
        L_0x00e0:
            java.lang.Object r13 = r17.parse()
            r7.put(r12, r13)
        L_0x00e7:
            int r12 = r3.token()
            r13 = 13
            if (r12 != r13) goto L_0x0041
            r3.nextToken(r14)
        L_0x00f2:
            if (r2 != 0) goto L_0x00fa
            java.lang.Exception r3 = new java.lang.Exception
            r3.<init>(r10, r9)
            goto L_0x010e
        L_0x00fa:
            boolean r3 = r4.isAssignableFrom(r2)
            if (r3 == 0) goto L_0x015f
            java.lang.Throwable r3 = r0.createException(r10, r9, r2)     // Catch:{ Exception -> 0x010c }
            if (r3 != 0) goto L_0x010e
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x010c }
            r3.<init>(r10, r9)     // Catch:{ Exception -> 0x010c }
            goto L_0x010e
        L_0x010c:
            r0 = move-exception
            goto L_0x0157
        L_0x010e:
            if (r11 == 0) goto L_0x0113
            r3.setStackTrace(r11)
        L_0x0113:
            if (r7 == 0) goto L_0x0156
            if (r2 == 0) goto L_0x012b
            java.lang.Class<?> r4 = r0.clazz
            if (r2 != r4) goto L_0x011c
            goto L_0x012c
        L_0x011c:
            com.alibaba.fastjson.parser.ParserConfig r0 = r17.getConfig()
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r0.getDeserializer((java.lang.reflect.Type) r2)
            boolean r1 = r0 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer
            if (r1 == 0) goto L_0x012b
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r0 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r0
            goto L_0x012c
        L_0x012b:
            r0 = r5
        L_0x012c:
            if (r0 == 0) goto L_0x0156
            java.util.Set r1 = r7.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0136:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0156
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r4 = r2.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r2 = r2.getValue()
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r4 = r0.getFieldDeserializer((java.lang.String) r4)
            if (r4 == 0) goto L_0x0136
            r4.setValue((java.lang.Object) r3, (java.lang.Object) r2)
            goto L_0x0136
        L_0x0156:
            return r3
        L_0x0157:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.String r2 = "create instance error"
            r1.<init>(r2, r0)
            throw r1
        L_0x015f:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "type not match, not Throwable. "
            r1.append(r3)
            java.lang.String r2 = r2.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x017a:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    public int getFastMatchToken() {
        return 12;
    }
}

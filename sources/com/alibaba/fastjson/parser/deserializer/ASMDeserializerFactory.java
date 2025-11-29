package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.api.ApiConstant;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class ASMDeserializerFactory implements Opcodes {
    static final String DefaultJSONParser = ASMUtils.type(DefaultJSONParser.class);
    static final String JSONLexerBase = ASMUtils.type(JSONLexerBase.class);
    public final ASMClassLoader classLoader;
    protected final AtomicLong seed = new AtomicLong();

    public ASMDeserializerFactory(ClassLoader classLoader2) {
        this.classLoader = classLoader2 instanceof ASMClassLoader ? (ASMClassLoader) classLoader2 : new ASMClassLoader(classLoader2);
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor) {
        _batchSet(context, methodVisitor, true);
    }

    private void _createInstance(Context context, MethodVisitor methodVisitor) {
        Constructor<?> constructor = context.beanInfo.defaultConstructor;
        if (Modifier.isPublic(constructor.getModifiers())) {
            methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(context.getInstClass()));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(constructor.getDeclaringClass()), "<init>", "()V");
            methodVisitor.visitVarInsn(58, context.var("instance"));
            return;
        }
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 0);
        Class<JavaBeanDeserializer> cls = JavaBeanDeserializer.class;
        methodVisitor.visitFieldInsn(180, ASMUtils.type(cls), "clazz", "Ljava/lang/Class;");
        String type = ASMUtils.type(cls);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, type, "createInstance", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
        methodVisitor.visitTypeInsn(192, ASMUtils.type(context.getInstClass()));
        methodVisitor.visitVarInsn(58, context.var("instance"));
    }

    private void _deserObject(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls, int i) {
        Context context2 = context;
        MethodVisitor methodVisitor2 = methodVisitor;
        FieldInfo fieldInfo2 = fieldInfo;
        _getFieldDeser(context, methodVisitor, fieldInfo);
        Label label = new Label();
        Label label2 = new Label();
        Class<JavaBeanDeserializer> cls2 = JavaBeanDeserializer.class;
        if ((fieldInfo2.parserFeatures & Feature.SupportArrayToBean.mask) != 0) {
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitTypeInsn(Opcodes.INSTANCEOF, ASMUtils.type(cls2));
            methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label);
            methodVisitor2.visitTypeInsn(192, ASMUtils.type(cls2));
            methodVisitor2.visitVarInsn(25, 1);
            if (fieldInfo2.fieldType instanceof Class) {
                methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo2.fieldClass)));
            } else {
                methodVisitor2.visitVarInsn(25, 0);
                methodVisitor2.visitLdcInsn(Integer.valueOf(i));
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(cls2), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            }
            methodVisitor2.visitLdcInsn(fieldInfo2.name);
            methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.parserFeatures));
            String type = ASMUtils.type(cls2);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, type, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
            methodVisitor2.visitTypeInsn(192, ASMUtils.type(cls));
            methodVisitor2.visitVarInsn(58, context2.var(fieldInfo2.name + "_asm"));
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label2);
            methodVisitor2.visitLabel(label);
        }
        methodVisitor2.visitVarInsn(25, 1);
        if (fieldInfo2.fieldType instanceof Class) {
            methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo2.fieldClass)));
        } else {
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitLdcInsn(Integer.valueOf(i));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(cls2), "getFieldType", "(I)Ljava/lang/reflect/Type;");
        }
        methodVisitor2.visitLdcInsn(fieldInfo2.name);
        String type2 = ASMUtils.type(ObjectDeserializer.class);
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEINTERFACE, type2, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor2.visitTypeInsn(192, ASMUtils.type(cls));
        methodVisitor2.visitVarInsn(58, context2.var(fieldInfo2.name + "_asm"));
        methodVisitor2.visitLabel(label2);
    }

    private void _deserialize_endCheck(Context context, MethodVisitor methodVisitor, Label label) {
        methodVisitor.visitIntInsn(21, context.var("matchedCount"));
        methodVisitor.visitJumpInsn(Opcodes.IFLE, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, ApiConstant.KEY_TOKEN, "()I");
        methodVisitor.visitLdcInsn(13);
        methodVisitor.visitJumpInsn(160, label);
        _quickNextTokenComma(context, methodVisitor);
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x0e33  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0e5a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void _deserialze(com.alibaba.fastjson.asm.ClassWriter r31, com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory.Context r32) {
        /*
            r30 = this;
            r8 = r30
            r9 = r32
            com.alibaba.fastjson.util.FieldInfo[] r0 = r32.fieldInfoList
            int r0 = r0.length
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            com.alibaba.fastjson.util.FieldInfo[] r0 = r32.fieldInfoList
            int r1 = r0.length
            r10 = 0
            r2 = r10
        L_0x0013:
            if (r2 >= r1) goto L_0x003d
            r3 = r0[r2]
            java.lang.Class<?> r4 = r3.fieldClass
            java.lang.reflect.Type r3 = r3.fieldType
            java.lang.Class r5 = java.lang.Character.TYPE
            if (r4 != r5) goto L_0x0020
            return
        L_0x0020:
            java.lang.Class<java.util.Collection> r5 = java.util.Collection.class
            boolean r4 = r5.isAssignableFrom(r4)
            if (r4 == 0) goto L_0x003a
            boolean r4 = r3 instanceof java.lang.reflect.ParameterizedType
            if (r4 == 0) goto L_0x0039
            java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
            java.lang.reflect.Type[] r3 = r3.getActualTypeArguments()
            r3 = r3[r10]
            boolean r3 = r3 instanceof java.lang.Class
            if (r3 == 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            return
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x0013
        L_0x003d:
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r32.beanInfo
            com.alibaba.fastjson.util.FieldInfo[] r1 = r0.sortedFields
            com.alibaba.fastjson.util.FieldInfo[] unused = r9.fieldInfoList = r1
            com.alibaba.fastjson.asm.MethodWriter r7 = new com.alibaba.fastjson.asm.MethodWriter
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "(L"
            r1.append(r2)
            java.lang.String r2 = DefaultJSONParser
            r1.append(r2)
            java.lang.String r3 = ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;"
            r1.append(r3)
            java.lang.String r15 = r1.toString()
            r16 = 0
            r17 = 0
            r13 = 1
            java.lang.String r14 = "deserialze"
            r11 = r7
            r12 = r31
            r11.<init>(r12, r13, r14, r15, r16, r17)
            com.alibaba.fastjson.asm.Label r11 = new com.alibaba.fastjson.asm.Label
            r11.<init>()
            com.alibaba.fastjson.asm.Label r12 = new com.alibaba.fastjson.asm.Label
            r12.<init>()
            com.alibaba.fastjson.asm.Label r13 = new com.alibaba.fastjson.asm.Label
            r13.<init>()
            com.alibaba.fastjson.asm.Label r14 = new com.alibaba.fastjson.asm.Label
            r14.<init>()
            r8.defineVarLexer(r9, r7)
            com.alibaba.fastjson.asm.Label r1 = new com.alibaba.fastjson.asm.Label
            r1.<init>()
            java.lang.String r15 = "lexer"
            int r3 = r9.var(r15)
            r6 = 25
            r7.visitVarInsn(r6, r3)
            java.lang.String r3 = JSONLexerBase
            java.lang.String r4 = "token"
            java.lang.String r5 = "()I"
            r10 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r10, r3, r4, r5)
            r4 = 14
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r7.visitLdcInsn(r4)
            r5 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r5, r1)
            int r0 = r0.parserFeatures
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.SupportArrayToBean
            int r5 = r4.mask
            r0 = r0 & r5
            r5 = 21
            r10 = 4
            if (r0 != 0) goto L_0x00da
            int r0 = r9.var(r15)
            r7.visitVarInsn(r6, r0)
            r7.visitVarInsn(r5, r10)
            int r0 = r4.mask
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.visitLdcInsn(r0)
            java.lang.String r0 = "isEnabled"
            java.lang.String r4 = "(II)Z"
            r5 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r5, r3, r0, r4)
            r0 = 153(0x99, float:2.14E-43)
            r7.visitJumpInsn(r0, r1)
        L_0x00da:
            r0 = 0
            r7.visitVarInsn(r6, r0)
            r5 = 1
            r7.visitVarInsn(r6, r5)
            r4 = 2
            r7.visitVarInsn(r6, r4)
            r0 = 3
            r7.visitVarInsn(r6, r0)
            r7.visitInsn(r5)
            java.lang.String r4 = r32.className
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "(L"
            r10.append(r0)
            r10.append(r2)
            java.lang.String r0 = ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"
            r10.append(r0)
            java.lang.String r0 = r10.toString()
            r10 = 183(0xb7, float:2.56E-43)
            java.lang.String r5 = "deserialzeArrayMapping"
            r7.visitMethodInsn(r10, r4, r5, r0)
            r0 = 176(0xb0, float:2.47E-43)
            r7.visitInsn(r0)
            r7.visitLabel(r1)
            int r0 = r9.var(r15)
            r7.visitVarInsn(r6, r0)
            com.alibaba.fastjson.parser.Feature r0 = com.alibaba.fastjson.parser.Feature.SortFeidFastMatch
            int r0 = r0.mask
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.visitLdcInsn(r0)
            java.lang.String r0 = "isEnabled"
            java.lang.String r1 = "(I)Z"
            r4 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r4, r3, r0, r1)
            com.alibaba.fastjson.asm.Label r0 = new com.alibaba.fastjson.asm.Label
            r0.<init>()
            r1 = 154(0x9a, float:2.16E-43)
            r7.visitJumpInsn(r1, r0)
            r1 = 200(0xc8, float:2.8E-43)
            r7.visitJumpInsn(r1, r12)
            r7.visitLabel(r0)
            int r0 = r9.var(r15)
            r7.visitVarInsn(r6, r0)
            java.lang.Class r0 = r32.clazz
            java.lang.String r0 = r0.getName()
            r7.visitLdcInsn(r0)
            java.lang.String r0 = "scanType"
            java.lang.String r1 = "(Ljava/lang/String;)I"
            r4 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r4, r3, r0, r1)
            r0 = -1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.visitLdcInsn(r0)
            com.alibaba.fastjson.asm.Label r0 = new com.alibaba.fastjson.asm.Label
            r0.<init>()
            r1 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r1, r0)
            r1 = 200(0xc8, float:2.8E-43)
            r7.visitJumpInsn(r1, r12)
            r7.visitLabel(r0)
            r0 = 1
            r7.visitVarInsn(r6, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "()"
            r0.append(r1)
            java.lang.Class<com.alibaba.fastjson.parser.ParseContext> r1 = com.alibaba.fastjson.parser.ParseContext.class
            java.lang.String r1 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "getContext"
            r4 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r4, r2, r1, r0)
            java.lang.String r0 = "mark_context"
            int r0 = r9.var(r0)
            r10 = 58
            r7.visitVarInsn(r10, r0)
            r0 = 3
            r7.visitInsn(r0)
            java.lang.String r0 = "matchedCount"
            int r0 = r9.var(r0)
            r5 = 54
            r7.visitVarInsn(r5, r0)
            r8._createInstance((com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory.Context) r9, (com.alibaba.fastjson.asm.MethodVisitor) r7)
            r0 = 1
            r7.visitVarInsn(r6, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "()"
            r0.append(r1)
            java.lang.Class<com.alibaba.fastjson.parser.ParseContext> r1 = com.alibaba.fastjson.parser.ParseContext.class
            java.lang.String r1 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "getContext"
            r4 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r4, r2, r1, r0)
            java.lang.String r0 = "context"
            int r0 = r9.var(r0)
            r7.visitVarInsn(r10, r0)
            r0 = 1
            r7.visitVarInsn(r6, r0)
            java.lang.String r0 = "context"
            int r0 = r9.var(r0)
            r7.visitVarInsn(r6, r0)
            java.lang.String r0 = "instance"
            int r0 = r9.var(r0)
            r7.visitVarInsn(r6, r0)
            r0 = 3
            r7.visitVarInsn(r6, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "("
            r0.append(r1)
            java.lang.Class<com.alibaba.fastjson.parser.ParseContext> r1 = com.alibaba.fastjson.parser.ParseContext.class
            java.lang.String r1 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r1)
            r0.append(r1)
            java.lang.String r1 = "Ljava/lang/Object;Ljava/lang/Object;)"
            r0.append(r1)
            java.lang.Class<com.alibaba.fastjson.parser.ParseContext> r1 = com.alibaba.fastjson.parser.ParseContext.class
            java.lang.String r1 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "setContext"
            r4 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r4, r2, r1, r0)
            java.lang.String r0 = "childContext"
            int r0 = r9.var(r0)
            r7.visitVarInsn(r10, r0)
            int r0 = r9.var(r15)
            r7.visitVarInsn(r6, r0)
            r4 = 180(0xb4, float:2.52E-43)
            java.lang.String r2 = "matchStat"
            java.lang.String r1 = "I"
            r7.visitFieldInsn(r4, r3, r2, r1)
            r0 = 4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r7.visitLdcInsn(r3)
            r0 = 159(0x9f, float:2.23E-43)
            r7.visitJumpInsn(r0, r13)
            r0 = 3
            r7.visitInsn(r0)
            int r3 = r9.var(r2)
            r7.visitIntInsn(r5, r3)
            com.alibaba.fastjson.util.FieldInfo[] r3 = r32.fieldInfoList
            int r3 = r3.length
            r4 = 0
        L_0x025f:
            if (r4 >= r3) goto L_0x0284
            r7.visitInsn(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r10 = "_asm_flag_"
            r0.append(r10)
            int r10 = r4 / 32
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r7.visitVarInsn(r5, r0)
            int r4 = r4 + 32
            r0 = 3
            r10 = 58
            goto L_0x025f
        L_0x0284:
            int r0 = r9.var(r15)
            r7.visitVarInsn(r6, r0)
            com.alibaba.fastjson.parser.Feature r0 = com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty
            int r0 = r0.mask
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.visitLdcInsn(r0)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r4 = "isEnabled"
            java.lang.String r10 = "(I)Z"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r4, r10)
            java.lang.String r0 = "initStringFieldAsEmpty"
            int r0 = r9.var(r0)
            r7.visitIntInsn(r5, r0)
            r0 = 0
        L_0x02ab:
            java.lang.String r10 = "_asm"
            if (r0 >= r3) goto L_0x03f5
            com.alibaba.fastjson.util.FieldInfo[] r4 = r32.fieldInfoList
            r4 = r4[r0]
            java.lang.Class<?> r6 = r4.fieldClass
            java.lang.Class r5 = java.lang.Boolean.TYPE
            if (r6 == r5) goto L_0x02c7
            java.lang.Class r5 = java.lang.Byte.TYPE
            if (r6 == r5) goto L_0x02c7
            java.lang.Class r5 = java.lang.Short.TYPE
            if (r6 == r5) goto L_0x02c7
            java.lang.Class r5 = java.lang.Integer.TYPE
            if (r6 != r5) goto L_0x02d2
        L_0x02c7:
            r26 = r11
            r23 = r12
            r24 = r13
            r25 = r14
            r5 = 3
            goto L_0x03c8
        L_0x02d2:
            java.lang.Class r5 = java.lang.Long.TYPE
            if (r6 != r5) goto L_0x0301
            r5 = 9
            r7.visitInsn(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r4 = r4.name
            r5.append(r4)
            r5.append(r10)
            java.lang.String r4 = r5.toString()
            r5 = 2
            int r4 = r9.var(r4, r5)
            r5 = 55
            r7.visitVarInsn(r5, r4)
        L_0x02f6:
            r26 = r11
            r23 = r12
            r24 = r13
            r25 = r14
        L_0x02fe:
            r5 = 3
            goto L_0x03e5
        L_0x0301:
            java.lang.Class r5 = java.lang.Float.TYPE
            if (r6 != r5) goto L_0x0325
            r5 = 11
            r7.visitInsn(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r4 = r4.name
            r5.append(r4)
            r5.append(r10)
            java.lang.String r4 = r5.toString()
            int r4 = r9.var(r4)
            r5 = 56
            r7.visitVarInsn(r5, r4)
            goto L_0x02f6
        L_0x0325:
            java.lang.Class r5 = java.lang.Double.TYPE
            if (r6 != r5) goto L_0x034a
            r5 = 14
            r7.visitInsn(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r4 = r4.name
            r5.append(r4)
            r5.append(r10)
            java.lang.String r4 = r5.toString()
            r5 = 2
            int r4 = r9.var(r4, r5)
            r5 = 57
            r7.visitVarInsn(r5, r4)
            goto L_0x02f6
        L_0x034a:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            if (r6 != r5) goto L_0x0397
            com.alibaba.fastjson.asm.Label r5 = new com.alibaba.fastjson.asm.Label
            r5.<init>()
            r23 = r12
            com.alibaba.fastjson.asm.Label r12 = new com.alibaba.fastjson.asm.Label
            r12.<init>()
            r24 = r13
            java.lang.String r13 = "initStringFieldAsEmpty"
            int r13 = r9.var(r13)
            r25 = r14
            r14 = 21
            r7.visitVarInsn(r14, r13)
            r13 = 153(0x99, float:2.14E-43)
            r7.visitJumpInsn(r13, r12)
            r8._setFlag(r7, r9, r0)
            int r13 = r9.var(r15)
            r14 = 25
            r7.visitVarInsn(r14, r13)
            java.lang.String r13 = JSONLexerBase
            java.lang.String r14 = "stringDefaultValue"
            r26 = r11
            java.lang.String r11 = "()Ljava/lang/String;"
            r8 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r8, r13, r14, r11)
            r8 = 167(0xa7, float:2.34E-43)
            r7.visitJumpInsn(r8, r5)
            r7.visitLabel(r12)
            r8 = 1
            r7.visitInsn(r8)
            r7.visitLabel(r5)
            goto L_0x03a3
        L_0x0397:
            r26 = r11
            r23 = r12
            r24 = r13
            r25 = r14
            r8 = 1
            r7.visitInsn(r8)
        L_0x03a3:
            r5 = 192(0xc0, float:2.69E-43)
            java.lang.String r6 = com.alibaba.fastjson.util.ASMUtils.type(r6)
            r7.visitTypeInsn(r5, r6)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r4 = r4.name
            r5.append(r4)
            r5.append(r10)
            java.lang.String r4 = r5.toString()
            int r4 = r9.var(r4)
            r5 = 58
            r7.visitVarInsn(r5, r4)
            goto L_0x02fe
        L_0x03c8:
            r7.visitInsn(r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r4 = r4.name
            r6.append(r4)
            r6.append(r10)
            java.lang.String r4 = r6.toString()
            int r4 = r9.var(r4)
            r6 = 54
            r7.visitVarInsn(r6, r4)
        L_0x03e5:
            int r0 = r0 + 1
            r8 = r30
            r12 = r23
            r13 = r24
            r14 = r25
            r11 = r26
            r5 = 54
            goto L_0x02ab
        L_0x03f5:
            r26 = r11
            r23 = r12
            r24 = r13
            r25 = r14
            r5 = 3
            r8 = 0
        L_0x03ff:
            if (r8 >= r3) goto L_0x0ed4
            com.alibaba.fastjson.util.FieldInfo[] r0 = r32.fieldInfoList
            r4 = r0[r8]
            java.lang.Class<?> r6 = r4.fieldClass
            java.lang.reflect.Type r0 = r4.fieldType
            com.alibaba.fastjson.asm.Label r11 = new com.alibaba.fastjson.asm.Label
            r11.<init>()
            java.lang.Class r12 = java.lang.Boolean.TYPE
            java.lang.String r13 = "[C"
            java.lang.String r14 = "_asm_prefix__"
            if (r6 != r12) goto L_0x0471
            int r0 = r9.var(r15)
            r6 = 25
            r7.visitVarInsn(r6, r0)
            r0 = 0
            r7.visitVarInsn(r6, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r12 = r4.name
            r6.append(r12)
            r6.append(r14)
            java.lang.String r6 = r6.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r12, r0, r6, r13)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r6 = "scanFieldBoolean"
            java.lang.String r12 = "([C)Z"
            r13 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r13, r0, r6, r12)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = r4.name
            r0.append(r4)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r4 = 54
            r7.visitVarInsn(r4, r0)
            r27 = r3
        L_0x0466:
            r29 = r8
            r28 = r11
            r8 = 1
        L_0x046b:
            r13 = 58
            r11 = r30
            goto L_0x0d93
        L_0x0471:
            java.lang.Class r12 = java.lang.Byte.TYPE
            java.lang.String r5 = "([C)I"
            r27 = r3
            java.lang.String r3 = "scanFieldInt"
            if (r6 != r12) goto L_0x04c4
            int r0 = r9.var(r15)
            r6 = 25
            r7.visitVarInsn(r6, r0)
            r0 = 0
            r7.visitVarInsn(r6, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r12 = r4.name
            r6.append(r12)
            r6.append(r14)
            java.lang.String r6 = r6.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r12, r0, r6, r13)
            java.lang.String r0 = JSONLexerBase
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.name
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r3 = 54
            r7.visitVarInsn(r3, r0)
            goto L_0x0466
        L_0x04c4:
            java.lang.Class<java.lang.Byte> r12 = java.lang.Byte.class
            r28 = r11
            java.lang.String r11 = "valueOf"
            r29 = r8
            r8 = 184(0xb8, float:2.58E-43)
            if (r6 != r12) goto L_0x0567
            int r0 = r9.var(r15)
            r6 = 25
            r7.visitVarInsn(r6, r0)
            r0 = 0
            r7.visitVarInsn(r6, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r12 = r4.name
            r6.append(r12)
            r6.append(r14)
            java.lang.String r6 = r6.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r12, r0, r6, r13)
            java.lang.String r0 = JSONLexerBase
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            java.lang.String r3 = "java/lang/Byte"
            java.lang.String r5 = "(B)Ljava/lang/Byte;"
            r7.visitMethodInsn(r8, r3, r11, r5)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r4.name
            r3.append(r5)
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            int r3 = r9.var(r3)
            r5 = 58
            r7.visitVarInsn(r5, r3)
            com.alibaba.fastjson.asm.Label r3 = new com.alibaba.fastjson.asm.Label
            r3.<init>()
            int r5 = r9.var(r15)
            r6 = 25
            r7.visitVarInsn(r6, r5)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r2, r1)
            r0 = 5
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.visitLdcInsn(r0)
            r0 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r0, r3)
            r0 = 1
            r7.visitInsn(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = r4.name
            r0.append(r4)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r4 = 58
            r7.visitVarInsn(r4, r0)
            r7.visitLabel(r3)
        L_0x0560:
            r11 = r30
            r8 = 1
            r13 = 58
            goto L_0x0d93
        L_0x0567:
            java.lang.Class r12 = java.lang.Short.TYPE
            if (r6 != r12) goto L_0x05b4
            int r0 = r9.var(r15)
            r6 = 25
            r7.visitVarInsn(r6, r0)
            r0 = 0
            r7.visitVarInsn(r6, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = r4.name
            r6.append(r8)
            r6.append(r14)
            java.lang.String r6 = r6.toString()
            r8 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r8, r0, r6, r13)
            java.lang.String r0 = JSONLexerBase
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.name
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r3 = 54
            r7.visitVarInsn(r3, r0)
            goto L_0x0560
        L_0x05b4:
            java.lang.Class<java.lang.Short> r12 = java.lang.Short.class
            if (r6 != r12) goto L_0x064a
            int r0 = r9.var(r15)
            r6 = 25
            r7.visitVarInsn(r6, r0)
            r0 = 0
            r7.visitVarInsn(r6, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r12 = r4.name
            r6.append(r12)
            r6.append(r14)
            java.lang.String r6 = r6.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r12, r0, r6, r13)
            java.lang.String r0 = JSONLexerBase
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            java.lang.String r3 = "java/lang/Short"
            java.lang.String r5 = "(S)Ljava/lang/Short;"
            r7.visitMethodInsn(r8, r3, r11, r5)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r4.name
            r3.append(r5)
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            int r3 = r9.var(r3)
            r5 = 58
            r7.visitVarInsn(r5, r3)
            com.alibaba.fastjson.asm.Label r3 = new com.alibaba.fastjson.asm.Label
            r3.<init>()
            int r5 = r9.var(r15)
            r6 = 25
            r7.visitVarInsn(r6, r5)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r2, r1)
            r0 = 5
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.visitLdcInsn(r0)
            r0 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r0, r3)
            r0 = 1
            r7.visitInsn(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = r4.name
            r0.append(r4)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r4 = 58
            r7.visitVarInsn(r4, r0)
            r7.visitLabel(r3)
            goto L_0x0560
        L_0x064a:
            java.lang.Class r12 = java.lang.Integer.TYPE
            if (r6 != r12) goto L_0x0698
            int r0 = r9.var(r15)
            r6 = 25
            r7.visitVarInsn(r6, r0)
            r0 = 0
            r7.visitVarInsn(r6, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = r4.name
            r6.append(r8)
            r6.append(r14)
            java.lang.String r6 = r6.toString()
            r8 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r8, r0, r6, r13)
            java.lang.String r0 = JSONLexerBase
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.name
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r3 = 54
            r7.visitVarInsn(r3, r0)
            goto L_0x0560
        L_0x0698:
            java.lang.Class<java.lang.Integer> r12 = java.lang.Integer.class
            if (r6 != r12) goto L_0x072e
            int r0 = r9.var(r15)
            r6 = 25
            r7.visitVarInsn(r6, r0)
            r0 = 0
            r7.visitVarInsn(r6, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r12 = r4.name
            r6.append(r12)
            r6.append(r14)
            java.lang.String r6 = r6.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r12, r0, r6, r13)
            java.lang.String r0 = JSONLexerBase
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            java.lang.String r3 = "java/lang/Integer"
            java.lang.String r5 = "(I)Ljava/lang/Integer;"
            r7.visitMethodInsn(r8, r3, r11, r5)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r4.name
            r3.append(r5)
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            int r3 = r9.var(r3)
            r5 = 58
            r7.visitVarInsn(r5, r3)
            com.alibaba.fastjson.asm.Label r3 = new com.alibaba.fastjson.asm.Label
            r3.<init>()
            int r5 = r9.var(r15)
            r6 = 25
            r7.visitVarInsn(r6, r5)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r2, r1)
            r0 = 5
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.visitLdcInsn(r0)
            r0 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r0, r3)
            r0 = 1
            r7.visitInsn(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = r4.name
            r0.append(r4)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r4 = 58
            r7.visitVarInsn(r4, r0)
            r7.visitLabel(r3)
            goto L_0x0560
        L_0x072e:
            java.lang.Class r3 = java.lang.Long.TYPE
            if (r6 != r3) goto L_0x0781
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r4.name
            r3.append(r5)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r13)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldLong"
            java.lang.String r5 = "([C)J"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.name
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            r3 = 2
            int r0 = r9.var(r0, r3)
            r3 = 55
            r7.visitVarInsn(r3, r0)
            goto L_0x0560
        L_0x0781:
            java.lang.Class<java.lang.Long> r3 = java.lang.Long.class
            if (r6 != r3) goto L_0x081b
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r4.name
            r3.append(r5)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r13)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldLong"
            java.lang.String r5 = "([C)J"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            java.lang.String r3 = "java/lang/Long"
            java.lang.String r5 = "(J)Ljava/lang/Long;"
            r7.visitMethodInsn(r8, r3, r11, r5)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r4.name
            r3.append(r5)
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            int r3 = r9.var(r3)
            r5 = 58
            r7.visitVarInsn(r5, r3)
            com.alibaba.fastjson.asm.Label r3 = new com.alibaba.fastjson.asm.Label
            r3.<init>()
            int r5 = r9.var(r15)
            r6 = 25
            r7.visitVarInsn(r6, r5)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r2, r1)
            r0 = 5
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.visitLdcInsn(r0)
            r0 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r0, r3)
            r0 = 1
            r7.visitInsn(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = r4.name
            r0.append(r4)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r4 = 58
            r7.visitVarInsn(r4, r0)
            r7.visitLabel(r3)
            goto L_0x0560
        L_0x081b:
            java.lang.Class r3 = java.lang.Float.TYPE
            if (r6 != r3) goto L_0x086d
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r4.name
            r3.append(r5)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r13)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldFloat"
            java.lang.String r5 = "([C)F"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.name
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r3 = 56
            r7.visitVarInsn(r3, r0)
            goto L_0x0560
        L_0x086d:
            java.lang.Class<java.lang.Float> r3 = java.lang.Float.class
            if (r6 != r3) goto L_0x0907
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r4.name
            r3.append(r5)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r13)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldFloat"
            java.lang.String r5 = "([C)F"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            java.lang.String r3 = "java/lang/Float"
            java.lang.String r5 = "(F)Ljava/lang/Float;"
            r7.visitMethodInsn(r8, r3, r11, r5)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r4.name
            r3.append(r5)
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            int r3 = r9.var(r3)
            r5 = 58
            r7.visitVarInsn(r5, r3)
            com.alibaba.fastjson.asm.Label r3 = new com.alibaba.fastjson.asm.Label
            r3.<init>()
            int r5 = r9.var(r15)
            r6 = 25
            r7.visitVarInsn(r6, r5)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r2, r1)
            r0 = 5
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.visitLdcInsn(r0)
            r0 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r0, r3)
            r0 = 1
            r7.visitInsn(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = r4.name
            r0.append(r4)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r4 = 58
            r7.visitVarInsn(r4, r0)
            r7.visitLabel(r3)
            goto L_0x0560
        L_0x0907:
            java.lang.Class r3 = java.lang.Double.TYPE
            if (r6 != r3) goto L_0x095a
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r4.name
            r3.append(r5)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r13)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldDouble"
            java.lang.String r5 = "([C)D"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.name
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            r5 = 2
            int r0 = r9.var(r0, r5)
            r3 = 57
            r7.visitVarInsn(r3, r0)
            goto L_0x0560
        L_0x095a:
            r5 = 2
            java.lang.Class<java.lang.Double> r3 = java.lang.Double.class
            if (r6 != r3) goto L_0x09f5
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = r4.name
            r3.append(r6)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r3, r13)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldDouble"
            java.lang.String r6 = "([C)D"
            r12 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r12, r0, r3, r6)
            java.lang.String r3 = "java/lang/Double"
            java.lang.String r6 = "(D)Ljava/lang/Double;"
            r7.visitMethodInsn(r8, r3, r11, r6)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = r4.name
            r3.append(r6)
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            int r3 = r9.var(r3)
            r6 = 58
            r7.visitVarInsn(r6, r3)
            com.alibaba.fastjson.asm.Label r3 = new com.alibaba.fastjson.asm.Label
            r3.<init>()
            int r6 = r9.var(r15)
            r8 = 25
            r7.visitVarInsn(r8, r6)
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r2, r1)
            r0 = 5
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.visitLdcInsn(r0)
            r0 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r0, r3)
            r8 = 1
            r7.visitInsn(r8)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = r4.name
            r0.append(r4)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r4 = 58
            r7.visitVarInsn(r4, r0)
            r7.visitLabel(r3)
            goto L_0x046b
        L_0x09f5:
            r8 = 1
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r6 != r3) goto L_0x0a4b
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = r4.name
            r3.append(r6)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r3, r13)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldString"
            java.lang.String r6 = "([C)Ljava/lang/String;"
            r11 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r11, r0, r3, r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.name
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r3 = 58
            r7.visitVarInsn(r3, r0)
        L_0x0a46:
            r11 = r30
        L_0x0a48:
            r13 = r3
            goto L_0x0d93
        L_0x0a4b:
            java.lang.Class<java.util.Date> r3 = java.util.Date.class
            if (r6 != r3) goto L_0x0a9c
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = r4.name
            r3.append(r6)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r3, r13)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldDate"
            java.lang.String r6 = "([C)Ljava/util/Date;"
            r11 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r11, r0, r3, r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.name
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x0a46
        L_0x0a9c:
            java.lang.Class<java.util.UUID> r3 = java.util.UUID.class
            if (r6 != r3) goto L_0x0aee
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = r4.name
            r3.append(r6)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r3, r13)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldUUID"
            java.lang.String r6 = "([C)Ljava/util/UUID;"
            r11 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r11, r0, r3, r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.name
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x0a46
        L_0x0aee:
            java.lang.Class<java.math.BigDecimal> r3 = java.math.BigDecimal.class
            if (r6 != r3) goto L_0x0b40
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = r4.name
            r3.append(r6)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r3, r13)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldDecimal"
            java.lang.String r6 = "([C)Ljava/math/BigDecimal;"
            r11 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r11, r0, r3, r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.name
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x0a46
        L_0x0b40:
            java.lang.Class<java.math.BigInteger> r3 = java.math.BigInteger.class
            if (r6 != r3) goto L_0x0b92
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = r4.name
            r3.append(r6)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r3, r13)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldBigInteger"
            java.lang.String r6 = "([C)Ljava/math/BigInteger;"
            r11 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r11, r0, r3, r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.name
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x0a46
        L_0x0b92:
            java.lang.Class<int[]> r3 = int[].class
            if (r6 != r3) goto L_0x0be4
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = r4.name
            r3.append(r6)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r3, r13)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldIntArray"
            java.lang.String r6 = "([C)[I"
            r11 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r11, r0, r3, r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.name
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x0a46
        L_0x0be4:
            java.lang.Class<float[]> r3 = float[].class
            if (r6 != r3) goto L_0x0c36
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = r4.name
            r3.append(r6)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r3, r13)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldFloatArray"
            java.lang.String r6 = "([C)[F"
            r11 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r11, r0, r3, r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.name
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x0a46
        L_0x0c36:
            java.lang.Class<float[][]> r3 = float[][].class
            if (r6 != r3) goto L_0x0c88
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = r4.name
            r3.append(r6)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r3, r13)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldFloatArray2"
            java.lang.String r6 = "([C)[[F"
            r11 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r11, r0, r3, r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.name
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x0a46
        L_0x0c88:
            boolean r3 = r6.isEnum()
            if (r3 == 0) goto L_0x0d15
            r3 = 0
            r11 = 25
            r7.visitVarInsn(r11, r3)
            int r0 = r9.var(r15)
            r7.visitVarInsn(r11, r0)
            r7.visitVarInsn(r11, r3)
            java.lang.String r0 = r32.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r11 = r4.name
            r3.append(r11)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r11 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r11, r0, r3, r13)
            r11 = r30
            r11._getFieldDeser(r9, r7, r4)
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer> r0 = com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.type(r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r12 = "(L"
            r3.append(r12)
            java.lang.String r12 = JSONLexerBase
            r3.append(r12)
            java.lang.String r12 = ";[C"
            r3.append(r12)
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.ObjectDeserializer> r12 = com.alibaba.fastjson.parser.deserializer.ObjectDeserializer.class
            java.lang.String r12 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r12)
            r3.append(r12)
            java.lang.String r12 = ")Ljava/lang/Enum;"
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            java.lang.String r12 = "scanEnum"
            r13 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r13, r0, r12, r3)
            r0 = 192(0xc0, float:2.69E-43)
            java.lang.String r3 = com.alibaba.fastjson.util.ASMUtils.type(r6)
            r7.visitTypeInsn(r0, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.name
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x0a48
        L_0x0d15:
            r11 = r30
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            boolean r3 = r3.isAssignableFrom(r6)
            if (r3 == 0) goto L_0x0e9a
            int r3 = r9.var(r15)
            r12 = 25
            r7.visitVarInsn(r12, r3)
            r3 = 0
            r7.visitVarInsn(r12, r3)
            java.lang.String r3 = r32.className
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r5 = r4.name
            r12.append(r5)
            r12.append(r14)
            java.lang.String r5 = r12.toString()
            r12 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r12, r3, r5, r13)
            java.lang.Class r12 = com.alibaba.fastjson.util.TypeUtils.getCollectionItemClass(r0)
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            if (r12 != r0) goto L_0x0e65
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r6)
            com.alibaba.fastjson.asm.Type r0 = com.alibaba.fastjson.asm.Type.getType(r0)
            r7.visitLdcInsn(r0)
            java.lang.String r0 = JSONLexerBase
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "([CLjava/lang/Class;)"
            r3.append(r5)
            java.lang.Class<java.util.Collection> r5 = java.util.Collection.class
            java.lang.String r5 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r5)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "scanFieldStringArray"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r5, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r4.name
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r13 = 58
            r7.visitVarInsn(r13, r0)
        L_0x0d93:
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = JSONLexerBase
            r4 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r4, r0, r2, r1)
            com.alibaba.fastjson.asm.Label r5 = new com.alibaba.fastjson.asm.Label
            r5.<init>()
            r6 = 158(0x9e, float:2.21E-43)
            r7.visitJumpInsn(r6, r5)
            r14 = r29
            r11._setFlag(r7, r9, r14)
            r7.visitLabel(r5)
            int r5 = r9.var(r15)
            r7.visitVarInsn(r3, r5)
            r7.visitFieldInsn(r4, r0, r2, r1)
            r3 = 89
            r7.visitInsn(r3)
            int r3 = r9.var(r2)
            r4 = 54
            r7.visitVarInsn(r4, r3)
            r3 = -1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7.visitLdcInsn(r3)
            r3 = 159(0x9f, float:2.23E-43)
            r5 = r26
            r7.visitJumpInsn(r3, r5)
            int r3 = r9.var(r15)
            r4 = 25
            r7.visitVarInsn(r4, r3)
            r3 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r3, r0, r2, r1)
            r3 = 158(0x9e, float:2.21E-43)
            r4 = r28
            r7.visitJumpInsn(r3, r4)
            java.lang.String r3 = "matchedCount"
            int r3 = r9.var(r3)
            r6 = 21
            r7.visitVarInsn(r6, r3)
            r3 = 4
            r7.visitInsn(r3)
            r12 = 96
            r7.visitInsn(r12)
            java.lang.String r12 = "matchedCount"
            int r12 = r9.var(r12)
            r8 = 54
            r7.visitVarInsn(r8, r12)
            int r12 = r9.var(r15)
            r8 = 25
            r7.visitVarInsn(r8, r12)
            r12 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r12, r0, r2, r1)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)
            r7.visitLdcInsn(r6)
            r6 = 159(0x9f, float:2.23E-43)
            r13 = r25
            r7.visitJumpInsn(r6, r13)
            r7.visitLabel(r4)
            int r4 = r27 + -1
            if (r14 != r4) goto L_0x0e5a
            int r4 = r9.var(r15)
            r7.visitVarInsn(r8, r4)
            r7.visitFieldInsn(r12, r0, r2, r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            r7.visitLdcInsn(r0)
            r3 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r3, r5)
            r21 = r1
            r25 = r2
            r18 = r3
            r31 = r10
            r19 = r12
        L_0x0e53:
            r22 = 54
            r12 = r7
            r10 = r8
            r8 = r5
            goto L_0x0ec1
        L_0x0e5a:
            r21 = r1
            r25 = r2
            r31 = r10
            r19 = r12
            r18 = 160(0xa0, float:2.24E-43)
            goto L_0x0e53
        L_0x0e65:
            r13 = r25
            r5 = r26
            r14 = r29
            r3 = 160(0xa0, float:2.24E-43)
            r8 = 3
            r18 = 21
            r20 = 180(0xb4, float:2.52E-43)
            r0 = r30
            r21 = r1
            r1 = r32
            r25 = r2
            r2 = r7
            r26 = r3
            r3 = r5
            r19 = r20
            r8 = 2
            r8 = r5
            r31 = r10
            r18 = r26
            r10 = 1
            r22 = 54
            r5 = r6
            r10 = 25
            r6 = r12
            r12 = r7
            r7 = r14
            r0._deserialze_list_obj(r1, r2, r3, r4, r5, r6, r7)
            int r3 = r27 + -1
            if (r14 != r3) goto L_0x0ec1
            r11._deserialize_endCheck(r9, r12, r8)
            goto L_0x0ec1
        L_0x0e9a:
            r21 = r1
            r12 = r7
            r31 = r10
            r13 = r25
            r8 = r26
            r14 = r29
            r10 = 25
            r18 = 160(0xa0, float:2.24E-43)
            r19 = 180(0xb4, float:2.52E-43)
            r22 = 54
            r25 = r2
            r0 = r30
            r1 = r32
            r2 = r12
            r3 = r8
            r5 = r6
            r6 = r14
            r0._deserialze_obj(r1, r2, r3, r4, r5, r6)
            int r3 = r27 + -1
            if (r14 != r3) goto L_0x0ec1
            r11._deserialize_endCheck(r9, r12, r8)
        L_0x0ec1:
            int r0 = r14 + 1
            r10 = r31
            r26 = r8
            r7 = r12
            r1 = r21
            r2 = r25
            r3 = r27
            r5 = 3
            r8 = r0
            r25 = r13
            goto L_0x03ff
        L_0x0ed4:
            r11 = r30
            r27 = r3
            r12 = r7
            r13 = r25
            r8 = r26
            r10 = 25
            r12.visitLabel(r13)
            java.lang.Class r0 = r32.clazz
            boolean r0 = r0.isInterface()
            if (r0 != 0) goto L_0x0efd
            java.lang.Class r0 = r32.clazz
            int r0 = r0.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isAbstract(r0)
            if (r0 != 0) goto L_0x0efd
            r11._batchSet(r9, r12)
        L_0x0efd:
            r0 = r24
            r12.visitLabel(r0)
            r11._setContext(r9, r12)
            java.lang.String r0 = "instance"
            int r0 = r9.var(r0)
            r12.visitVarInsn(r10, r0)
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r32.beanInfo
            java.lang.reflect.Method r0 = r0.buildMethod
            if (r0 == 0) goto L_0x0f40
            java.lang.Class r1 = r32.getInstClass()
            java.lang.String r1 = com.alibaba.fastjson.util.ASMUtils.type(r1)
            java.lang.String r2 = r0.getName()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "()"
            r3.append(r4)
            java.lang.Class r0 = r0.getReturnType()
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r0)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r3 = 182(0xb6, float:2.55E-43)
            r12.visitMethodInsn(r3, r1, r2, r0)
        L_0x0f40:
            r0 = 176(0xb0, float:2.47E-43)
            r12.visitInsn(r0)
            r12.visitLabel(r8)
            r11._batchSet(r9, r12)
            r0 = 0
            r12.visitVarInsn(r10, r0)
            r0 = 1
            r12.visitVarInsn(r10, r0)
            r0 = 2
            r12.visitVarInsn(r10, r0)
            r0 = 3
            r12.visitVarInsn(r10, r0)
            java.lang.String r0 = "instance"
            int r0 = r9.var(r0)
            r12.visitVarInsn(r10, r0)
            r0 = 21
            r1 = 4
            r12.visitVarInsn(r0, r1)
            int r3 = r27 / 32
            if (r27 == 0) goto L_0x0f74
            int r0 = r27 % 32
            if (r0 == 0) goto L_0x0f74
            int r3 = r3 + 1
        L_0x0f74:
            r0 = 1
            if (r3 != r0) goto L_0x0f7c
            r0 = 4
            r12.visitInsn(r0)
            goto L_0x0f81
        L_0x0f7c:
            r0 = 16
            r12.visitIntInsn(r0, r3)
        L_0x0f81:
            r0 = 188(0xbc, float:2.63E-43)
            r1 = 10
            r12.visitIntInsn(r0, r1)
            r0 = 0
        L_0x0f89:
            if (r0 >= r3) goto L_0x0fc6
            r1 = 89
            r12.visitInsn(r1)
            if (r0 != 0) goto L_0x0f97
            r1 = 3
            r12.visitInsn(r1)
            goto L_0x0fa4
        L_0x0f97:
            r1 = 1
            if (r0 != r1) goto L_0x0f9f
            r1 = 4
            r12.visitInsn(r1)
            goto L_0x0fa4
        L_0x0f9f:
            r1 = 16
            r12.visitIntInsn(r1, r0)
        L_0x0fa4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "_asm_flag_"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            int r1 = r9.var(r1)
            r2 = 21
            r12.visitVarInsn(r2, r1)
            r1 = 79
            r12.visitInsn(r1)
            int r0 = r0 + 1
            goto L_0x0f89
        L_0x0fc6:
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer> r0 = com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.type(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "(L"
            r1.append(r2)
            java.lang.String r2 = DefaultJSONParser
            r1.append(r2)
            java.lang.String r3 = ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;I[I)Ljava/lang/Object;"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "parseRest"
            r4 = 182(0xb6, float:2.55E-43)
            r12.visitMethodInsn(r4, r0, r3, r1)
            java.lang.Class r0 = r32.clazz
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.type(r0)
            r1 = 192(0xc0, float:2.69E-43)
            r12.visitTypeInsn(r1, r0)
            r0 = 176(0xb0, float:2.47E-43)
            r12.visitInsn(r0)
            r0 = r23
            r12.visitLabel(r0)
            r0 = 0
            r12.visitVarInsn(r10, r0)
            r0 = 1
            r12.visitVarInsn(r10, r0)
            r0 = 2
            r12.visitVarInsn(r10, r0)
            r0 = 3
            r12.visitVarInsn(r10, r0)
            r0 = 21
            r1 = 4
            r12.visitVarInsn(r0, r1)
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer> r0 = com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.type(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "(L"
            r1.append(r3)
            r1.append(r2)
            java.lang.String r2 = ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 183(0xb7, float:2.56E-43)
            java.lang.String r3 = "deserialze"
            r12.visitMethodInsn(r2, r0, r3, r1)
            r0 = 176(0xb0, float:2.47E-43)
            r12.visitInsn(r0)
            r0 = 10
            int r1 = r32.variantIndex
            r12.visitMaxs(r0, r1)
            r12.visitEnd()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory._deserialze(com.alibaba.fastjson.asm.ClassWriter, com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory$Context):void");
    }

    private void _deserialzeArrayMapping(ClassWriter classWriter, Context context) {
        Class<JavaBeanDeserializer> cls;
        char c;
        int i;
        int i2;
        boolean z;
        char c2;
        char c3;
        int i3;
        char c4;
        char c5;
        int i4;
        char c6;
        Context context2 = context;
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        String str = DefaultJSONParser;
        sb.append(str);
        sb.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, "deserialzeArrayMapping", sb.toString(), (String) null, (String[]) null);
        defineVarLexer(context2, methodWriter);
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getSymbolTable", "()" + ASMUtils.desc((Class<?>) SymbolTable.class));
        String str2 = JSONLexerBase;
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "scanTypeName", "(" + ASMUtils.desc((Class<?>) SymbolTable.class) + ")Ljava/lang/String;");
        methodWriter.visitVarInsn(58, context2.var("typeName"));
        Label label = new Label();
        methodWriter.visitVarInsn(25, context2.var("typeName"));
        methodWriter.visitJumpInsn(Opcodes.IFNULL, label);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getConfig", "()" + ASMUtils.desc((Class<?>) ParserConfig.class));
        methodWriter.visitVarInsn(25, 0);
        Class<JavaBeanDeserializer> cls2 = JavaBeanDeserializer.class;
        methodWriter.visitFieldInsn(180, ASMUtils.type(cls2), "beanInfo", ASMUtils.desc((Class<?>) JavaBeanInfo.class));
        methodWriter.visitVarInsn(25, context2.var("typeName"));
        String type = ASMUtils.type(cls2);
        methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, type, "getSeeAlso", "(" + ASMUtils.desc((Class<?>) ParserConfig.class) + ASMUtils.desc((Class<?>) JavaBeanInfo.class) + "Ljava/lang/String;)" + ASMUtils.desc((Class<?>) cls2));
        methodWriter.visitVarInsn(58, context2.var("userTypeDeser"));
        methodWriter.visitVarInsn(25, context2.var("userTypeDeser"));
        methodWriter.visitTypeInsn(Opcodes.INSTANCEOF, ASMUtils.type(cls2));
        methodWriter.visitJumpInsn(Opcodes.IFEQ, label);
        methodWriter.visitVarInsn(25, context2.var("userTypeDeser"));
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitVarInsn(25, 2);
        methodWriter.visitVarInsn(25, 3);
        methodWriter.visitVarInsn(25, 4);
        String type2 = ASMUtils.type(cls2);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, type2, "deserialzeArrayMapping", "(L" + str + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        methodWriter.visitInsn(176);
        methodWriter.visitLabel(label);
        _createInstance(context2, (MethodVisitor) methodWriter);
        FieldInfo[] fieldInfoArr = context.beanInfo.sortedFields;
        int length = fieldInfoArr.length;
        int i5 = 0;
        while (i5 < length) {
            boolean z2 = i5 == length + -1;
            int i6 = z2 ? 93 : 44;
            FieldInfo fieldInfo = fieldInfoArr[i5];
            Class<?> cls3 = fieldInfo.fieldClass;
            java.lang.reflect.Type type3 = fieldInfo.fieldType;
            int i7 = length;
            FieldInfo[] fieldInfoArr2 = fieldInfoArr;
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                cls = cls2;
                i = i7;
                c3 = 180;
                c2 = ':';
                z = true;
                c = 184;
                i2 = i5;
                String str3 = "_asm";
                methodWriter.visitVarInsn(25, context2.var("lexer"));
                methodWriter.visitVarInsn(16, i6);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanInt", "(C)I");
                methodWriter.visitVarInsn(54, context2.var(fieldInfo.name + str3));
            } else {
                boolean z3 = z2;
                String str4 = "(I)V";
                int i8 = i5;
                if (cls3 == Byte.class) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    String str5 = JSONLexerBase;
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "scanInt", "(C)I");
                    methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                    methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                    Label label2 = new Label();
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitFieldInsn(180, str5, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label2);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                    methodWriter.visitLabel(label2);
                } else if (cls3 == Short.class) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    String str6 = JSONLexerBase;
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str6, "scanInt", "(C)I");
                    methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                    methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                    Label label3 = new Label();
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitFieldInsn(180, str6, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label3);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                    methodWriter.visitLabel(label3);
                } else if (cls3 == Integer.class) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    String str7 = JSONLexerBase;
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str7, "scanInt", "(C)I");
                    methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                    Label label4 = new Label();
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitFieldInsn(180, str7, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label4);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                    methodWriter.visitLabel(label4);
                } else if (cls3 == Long.TYPE) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanLong", "(C)J");
                    methodWriter.visitVarInsn(55, context2.var(fieldInfo.name + "_asm", 2));
                } else if (cls3 == Long.class) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    String str8 = JSONLexerBase;
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, "scanLong", "(C)J");
                    methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                    methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                    Label label5 = new Label();
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitFieldInsn(180, str8, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label5);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                    methodWriter.visitLabel(label5);
                } else if (cls3 == Boolean.TYPE) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanBoolean", "(C)Z");
                    methodWriter.visitVarInsn(54, context2.var(fieldInfo.name + "_asm"));
                } else if (cls3 == Float.TYPE) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFloat", "(C)F");
                    methodWriter.visitVarInsn(56, context2.var(fieldInfo.name + "_asm"));
                } else if (cls3 == Float.class) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    String str9 = JSONLexerBase;
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str9, "scanFloat", "(C)F");
                    methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                    methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                    Label label6 = new Label();
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitFieldInsn(180, str9, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label6);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                    methodWriter.visitLabel(label6);
                } else if (cls3 == Double.TYPE) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanDouble", "(C)D");
                    methodWriter.visitVarInsn(57, context2.var(fieldInfo.name + "_asm", 2));
                } else if (cls3 == Double.class) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    String str10 = JSONLexerBase;
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str10, "scanDouble", "(C)D");
                    methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                    methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                    Label label7 = new Label();
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitFieldInsn(180, str10, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label7);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                    methodWriter.visitLabel(label7);
                } else if (cls3 == Character.TYPE) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
                    methodWriter.visitInsn(3);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "charAt", "(I)C");
                    methodWriter.visitVarInsn(54, context2.var(fieldInfo.name + "_asm"));
                } else {
                    if (cls3 == String.class) {
                        methodWriter.visitVarInsn(25, context2.var("lexer"));
                        methodWriter.visitVarInsn(16, i6);
                        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
                        c6 = ':';
                        methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                    } else if (cls3 == BigDecimal.class) {
                        methodWriter.visitVarInsn(25, context2.var("lexer"));
                        methodWriter.visitVarInsn(16, i6);
                        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanDecimal", "(C)Ljava/math/BigDecimal;");
                        c6 = ':';
                        methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                    } else if (cls3 == Date.class) {
                        methodWriter.visitVarInsn(25, context2.var("lexer"));
                        methodWriter.visitVarInsn(16, i6);
                        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanDate", "(C)Ljava/util/Date;");
                        c6 = ':';
                        methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                    } else if (cls3 == UUID.class) {
                        methodWriter.visitVarInsn(25, context2.var("lexer"));
                        methodWriter.visitVarInsn(16, i6);
                        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanUUID", "(C)Ljava/util/UUID;");
                        c6 = ':';
                        methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                    } else if (cls3.isEnum()) {
                        Label label8 = new Label();
                        Label label9 = new Label();
                        Label label10 = new Label();
                        Label label11 = new Label();
                        cls = cls2;
                        methodWriter.visitVarInsn(25, context2.var("lexer"));
                        String str11 = JSONLexerBase;
                        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str11, "getCurrent", "()C");
                        methodWriter.visitInsn(89);
                        methodWriter.visitVarInsn(54, context2.var("ch"));
                        methodWriter.visitLdcInsn(110);
                        methodWriter.visitJumpInsn(Opcodes.IF_ICMPEQ, label11);
                        methodWriter.visitVarInsn(21, context2.var("ch"));
                        methodWriter.visitLdcInsn(34);
                        methodWriter.visitJumpInsn(160, label8);
                        methodWriter.visitLabel(label11);
                        methodWriter.visitVarInsn(25, context2.var("lexer"));
                        methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                        methodWriter.visitVarInsn(25, 1);
                        String str12 = DefaultJSONParser;
                        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str12, "getSymbolTable", "()" + ASMUtils.desc((Class<?>) SymbolTable.class));
                        methodWriter.visitVarInsn(16, i6);
                        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str11, "scanEnum", "(Ljava/lang/Class;" + ASMUtils.desc((Class<?>) SymbolTable.class) + "C)Ljava/lang/Enum;");
                        methodWriter.visitJumpInsn(Opcodes.GOTO, label10);
                        methodWriter.visitLabel(label8);
                        methodWriter.visitVarInsn(21, context2.var("ch"));
                        methodWriter.visitLdcInsn(48);
                        methodWriter.visitJumpInsn(Opcodes.IF_ICMPLT, label9);
                        methodWriter.visitVarInsn(21, context2.var("ch"));
                        methodWriter.visitLdcInsn(57);
                        methodWriter.visitJumpInsn(Opcodes.IF_ICMPGT, label9);
                        _getFieldDeser(context2, methodWriter, fieldInfo);
                        methodWriter.visitTypeInsn(192, ASMUtils.type(EnumDeserializer.class));
                        methodWriter.visitVarInsn(25, context2.var("lexer"));
                        methodWriter.visitVarInsn(16, i6);
                        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str11, "scanInt", "(C)I");
                        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(EnumDeserializer.class), "valueOf", "(I)Ljava/lang/Enum;");
                        methodWriter.visitJumpInsn(Opcodes.GOTO, label10);
                        methodWriter.visitLabel(label9);
                        methodWriter.visitVarInsn(25, 0);
                        methodWriter.visitVarInsn(25, context2.var("lexer"));
                        methodWriter.visitVarInsn(16, i6);
                        String type4 = ASMUtils.type(cls);
                        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, type4, "scanEnum", "(L" + str11 + ";C)Ljava/lang/Enum;");
                        methodWriter.visitLabel(label10);
                        methodWriter.visitTypeInsn(192, ASMUtils.type(cls3));
                        methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + "_asm"));
                        c2 = ':';
                        i = i7;
                        i2 = i8;
                        c3 = 180;
                        z = true;
                        c = 184;
                    } else {
                        String str13 = "_asm";
                        cls = cls2;
                        if (Collection.class.isAssignableFrom(cls3)) {
                            Class<?> collectionItemClass = TypeUtils.getCollectionItemClass(type3);
                            if (collectionItemClass == String.class) {
                                if (cls3 == List.class || cls3 == Collections.class || cls3 == ArrayList.class) {
                                    methodWriter.visitTypeInsn(Opcodes.NEW, ASMUtils.type(ArrayList.class));
                                    methodWriter.visitInsn(89);
                                    methodWriter.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(ArrayList.class), "<init>", "()V");
                                } else {
                                    methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                                    methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
                                }
                                methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + str13));
                                methodWriter.visitVarInsn(25, context2.var("lexer"));
                                methodWriter.visitVarInsn(25, context2.var(fieldInfo.name + str13));
                                methodWriter.visitVarInsn(16, i6);
                                String str14 = JSONLexerBase;
                                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str14, "scanStringArray", "(Ljava/util/Collection;C)V");
                                Label label12 = new Label();
                                methodWriter.visitVarInsn(25, context2.var("lexer"));
                                methodWriter.visitFieldInsn(180, str14, "matchStat", "I");
                                methodWriter.visitLdcInsn(5);
                                methodWriter.visitJumpInsn(160, label12);
                                methodWriter.visitInsn(1);
                                methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + str13));
                                methodWriter.visitLabel(label12);
                                i4 = i8;
                                c5 = 184;
                            } else {
                                Label label13 = new Label();
                                methodWriter.visitVarInsn(25, context2.var("lexer"));
                                String str15 = JSONLexerBase;
                                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str15, ApiConstant.KEY_TOKEN, "()I");
                                methodWriter.visitVarInsn(54, context2.var(ApiConstant.KEY_TOKEN));
                                methodWriter.visitVarInsn(21, context2.var(ApiConstant.KEY_TOKEN));
                                int i9 = i8 == 0 ? 14 : 16;
                                methodWriter.visitLdcInsn(Integer.valueOf(i9));
                                methodWriter.visitJumpInsn(Opcodes.IF_ICMPEQ, label13);
                                methodWriter.visitVarInsn(25, 1);
                                methodWriter.visitLdcInsn(Integer.valueOf(i9));
                                String str16 = DefaultJSONParser;
                                String str17 = str4;
                                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str16, "throwException", str17);
                                methodWriter.visitLabel(label13);
                                Label label14 = new Label();
                                Label label15 = new Label();
                                methodWriter.visitVarInsn(25, context2.var("lexer"));
                                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str15, "getCurrent", "()C");
                                methodWriter.visitVarInsn(16, 91);
                                methodWriter.visitJumpInsn(160, label14);
                                methodWriter.visitVarInsn(25, context2.var("lexer"));
                                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str15, "next", "()C");
                                methodWriter.visitInsn(87);
                                methodWriter.visitVarInsn(25, context2.var("lexer"));
                                methodWriter.visitLdcInsn(14);
                                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str15, "setToken", str17);
                                methodWriter.visitJumpInsn(Opcodes.GOTO, label15);
                                methodWriter.visitLabel(label14);
                                methodWriter.visitVarInsn(25, context2.var("lexer"));
                                methodWriter.visitLdcInsn(14);
                                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str15, "nextToken", str17);
                                methodWriter.visitLabel(label15);
                                i4 = i8;
                                _newCollection(methodWriter, cls3, i4, false);
                                methodWriter.visitInsn(89);
                                methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + str13));
                                _getCollectionFieldItemDeser(context2, methodWriter, fieldInfo, collectionItemClass);
                                methodWriter.visitVarInsn(25, 1);
                                methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(collectionItemClass)));
                                methodWriter.visitVarInsn(25, 3);
                                String type5 = ASMUtils.type(cls);
                                c5 = 184;
                                methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, type5, "parseArray", "(Ljava/util/Collection;" + ASMUtils.desc((Class<?>) ObjectDeserializer.class) + "L" + str16 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                            }
                            i2 = i4;
                            c = c5;
                            i = i7;
                            c3 = 180;
                            c2 = ':';
                            z = true;
                        } else {
                            String str18 = str4;
                            int i10 = i8;
                            if (cls3.isArray()) {
                                methodWriter.visitVarInsn(25, context2.var("lexer"));
                                methodWriter.visitLdcInsn(14);
                                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "nextToken", str18);
                                z = true;
                                methodWriter.visitVarInsn(25, 1);
                                methodWriter.visitVarInsn(25, 0);
                                methodWriter.visitLdcInsn(Integer.valueOf(i10));
                                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(cls), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                                methodWriter.visitTypeInsn(192, ASMUtils.type(cls3));
                                methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + str13));
                                c2 = ':';
                                i2 = i10;
                                c = 184;
                                i = i7;
                                c3 = 180;
                            } else {
                                z = true;
                                Label label16 = new Label();
                                Label label17 = new Label();
                                if (cls3 == Date.class) {
                                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                                    String str19 = JSONLexerBase;
                                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str19, "getCurrent", "()C");
                                    methodWriter.visitLdcInsn(49);
                                    methodWriter.visitJumpInsn(160, label16);
                                    methodWriter.visitTypeInsn(Opcodes.NEW, ASMUtils.type(Date.class));
                                    methodWriter.visitInsn(89);
                                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                                    i3 = 16;
                                    methodWriter.visitVarInsn(16, i6);
                                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str19, "scanLong", "(C)J");
                                    methodWriter.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(Date.class), "<init>", "(J)V");
                                    c4 = ':';
                                    methodWriter.visitVarInsn(58, context2.var(fieldInfo.name + str13));
                                    methodWriter.visitJumpInsn(Opcodes.GOTO, label17);
                                } else {
                                    i3 = 16;
                                    c4 = ':';
                                }
                                methodWriter.visitLabel(label16);
                                _quickNextToken(context2, methodWriter, 14);
                                i2 = i10;
                                i = i7;
                                c = 184;
                                int i11 = i3;
                                c3 = 180;
                                _deserObject(context, methodWriter, fieldInfo, cls3, i2);
                                methodWriter.visitVarInsn(25, context2.var("lexer"));
                                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, ApiConstant.KEY_TOKEN, "()I");
                                methodWriter.visitLdcInsn(15);
                                methodWriter.visitJumpInsn(Opcodes.IF_ICMPEQ, label17);
                                methodWriter.visitVarInsn(25, 0);
                                methodWriter.visitVarInsn(25, context2.var("lexer"));
                                if (!z3) {
                                    methodWriter.visitLdcInsn(Integer.valueOf(i11));
                                } else {
                                    methodWriter.visitLdcInsn(15);
                                }
                                String type6 = ASMUtils.type(cls);
                                methodWriter.visitMethodInsn(Opcodes.INVOKESPECIAL, type6, "check", "(" + ASMUtils.desc((Class<?>) JSONLexer.class) + "I)V");
                                methodWriter.visitLabel(label17);
                            }
                        }
                    }
                    c2 = c6;
                    cls = cls2;
                    i = i7;
                    i2 = i8;
                    c3 = 180;
                    z = true;
                    c = 184;
                }
                cls = cls2;
                i = i7;
                i2 = i8;
                c3 = 180;
                c2 = ':';
                z = true;
                c = 184;
            }
            i5 = i2 + 1;
            char c7 = c3;
            length = i;
            char c8 = c;
            fieldInfoArr = fieldInfoArr2;
            cls2 = cls;
            boolean z4 = z;
            char c9 = c2;
            boolean z5 = z4;
        }
        String str20 = "(I)V";
        _batchSet(context2, methodWriter, false);
        Label label18 = new Label();
        Label label19 = new Label();
        Label label20 = new Label();
        Label label21 = new Label();
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        String str21 = JSONLexerBase;
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str21, "getCurrent", "()C");
        methodWriter.visitInsn(89);
        methodWriter.visitVarInsn(54, context2.var("ch"));
        methodWriter.visitVarInsn(16, 44);
        methodWriter.visitJumpInsn(160, label19);
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str21, "next", "()C");
        methodWriter.visitInsn(87);
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        methodWriter.visitLdcInsn(16);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str21, "setToken", str20);
        methodWriter.visitJumpInsn(Opcodes.GOTO, label21);
        methodWriter.visitLabel(label19);
        methodWriter.visitVarInsn(21, context2.var("ch"));
        methodWriter.visitVarInsn(16, 93);
        methodWriter.visitJumpInsn(160, label20);
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str21, "next", "()C");
        methodWriter.visitInsn(87);
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        methodWriter.visitLdcInsn(15);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str21, "setToken", str20);
        methodWriter.visitJumpInsn(Opcodes.GOTO, label21);
        methodWriter.visitLabel(label20);
        methodWriter.visitVarInsn(21, context2.var("ch"));
        methodWriter.visitVarInsn(16, 26);
        methodWriter.visitJumpInsn(160, label18);
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str21, "next", "()C");
        methodWriter.visitInsn(87);
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        methodWriter.visitLdcInsn(20);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str21, "setToken", str20);
        methodWriter.visitJumpInsn(Opcodes.GOTO, label21);
        methodWriter.visitLabel(label18);
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        methodWriter.visitLdcInsn(16);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str21, "nextToken", str20);
        methodWriter.visitLabel(label21);
        methodWriter.visitVarInsn(25, context2.var("instance"));
        methodWriter.visitInsn(176);
        methodWriter.visitMaxs(5, context.variantIndex);
        methodWriter.visitEnd();
    }

    private void _deserialze_list_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, Class<?> cls2, int i) {
        String str;
        String str2;
        String str3;
        Label label2;
        String str4;
        int i2;
        Context context2 = context;
        MethodVisitor methodVisitor2 = methodVisitor;
        Label label3 = label;
        FieldInfo fieldInfo2 = fieldInfo;
        Class<?> cls3 = cls;
        Class<?> cls4 = cls2;
        int i3 = i;
        Label label4 = new Label();
        String str5 = JSONLexerBase;
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "matchField", "([C)Z");
        methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label4);
        _setFlag(methodVisitor2, context2, i3);
        Label label5 = new Label();
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, ApiConstant.KEY_TOKEN, "()I");
        methodVisitor2.visitLdcInsn(8);
        methodVisitor2.visitJumpInsn(160, label5);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitLdcInsn(16);
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "nextToken", "(I)V");
        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label4);
        methodVisitor2.visitLabel(label5);
        Label label6 = new Label();
        Label label7 = new Label();
        Label label8 = label4;
        Label label9 = new Label();
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, ApiConstant.KEY_TOKEN, "()I");
        methodVisitor2.visitLdcInsn(21);
        methodVisitor2.visitJumpInsn(160, label7);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitLdcInsn(14);
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "nextToken", "(I)V");
        _newCollection(methodVisitor2, cls3, i3, true);
        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label6);
        methodVisitor2.visitLabel(label7);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, ApiConstant.KEY_TOKEN, "()I");
        methodVisitor2.visitLdcInsn(14);
        methodVisitor2.visitJumpInsn(Opcodes.IF_ICMPEQ, label9);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, ApiConstant.KEY_TOKEN, "()I");
        methodVisitor2.visitLdcInsn(12);
        methodVisitor2.visitJumpInsn(160, label);
        _newCollection(methodVisitor2, cls3, i3, false);
        StringBuilder sb = new StringBuilder();
        FieldInfo fieldInfo3 = fieldInfo;
        String str6 = ApiConstant.KEY_TOKEN;
        sb.append(fieldInfo3.name);
        sb.append("_asm");
        methodVisitor2.visitVarInsn(58, context2.var(sb.toString()));
        Class<?> cls5 = cls2;
        _getCollectionFieldItemDeser(context2, methodVisitor2, fieldInfo3, cls5);
        String str7 = str5;
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
        methodVisitor2.visitInsn(3);
        String str8 = "nextToken";
        String str9 = "(I)V";
        methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        Class<ObjectDeserializer> cls6 = ObjectDeserializer.class;
        String type = ASMUtils.type(cls6);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(L");
        String str10 = DefaultJSONParser;
        sb2.append(str10);
        String str11 = str10;
        sb2.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        String str12 = "lexer";
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEINTERFACE, type, "deserialze", sb2.toString());
        methodVisitor2.visitVarInsn(58, context2.var("list_item_value"));
        methodVisitor2.visitVarInsn(25, context2.var(fieldInfo3.name + "_asm"));
        methodVisitor2.visitVarInsn(25, context2.var("list_item_value"));
        if (cls.isInterface()) {
            str = "list_item_value";
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEINTERFACE, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            str = "list_item_value";
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        }
        methodVisitor2.visitInsn(87);
        Label label10 = label8;
        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label10);
        methodVisitor2.visitLabel(label9);
        _newCollection(methodVisitor2, cls3, i3, false);
        methodVisitor2.visitLabel(label6);
        methodVisitor2.visitVarInsn(58, context2.var(fieldInfo3.name + "_asm"));
        boolean isPrimitive2 = ParserConfig.isPrimitive2(fieldInfo3.fieldClass);
        _getCollectionFieldItemDeser(context2, methodVisitor2, fieldInfo3, cls5);
        if (isPrimitive2) {
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEINTERFACE, ASMUtils.type(cls6), "getFastMatchToken", "()I");
            methodVisitor2.visitVarInsn(54, context2.var("fastMatchToken"));
            str3 = str12;
            methodVisitor2.visitVarInsn(25, context2.var(str3));
            methodVisitor2.visitVarInsn(21, context2.var("fastMatchToken"));
            str2 = str7;
            label2 = label10;
            str4 = str9;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, str8, str4);
        } else {
            str2 = str7;
            String str13 = str8;
            str3 = str12;
            label2 = label10;
            str4 = str9;
            methodVisitor2.visitInsn(87);
            methodVisitor2.visitLdcInsn(12);
            methodVisitor2.visitVarInsn(54, context2.var("fastMatchToken"));
            _quickNextToken(context2, methodVisitor2, 12);
        }
        methodVisitor2.visitVarInsn(25, 1);
        String str14 = str4;
        String str15 = str11;
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str15, "getContext", "()" + ASMUtils.desc((Class<?>) ParseContext.class));
        methodVisitor2.visitVarInsn(58, context2.var("listContext"));
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitVarInsn(25, context2.var(fieldInfo3.name + "_asm"));
        methodVisitor2.visitLdcInsn(fieldInfo3.name);
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str15, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.desc((Class<?>) ParseContext.class));
        methodVisitor2.visitInsn(87);
        Label label11 = new Label();
        Label label12 = new Label();
        methodVisitor2.visitInsn(3);
        String str16 = "fastMatchToken";
        methodVisitor2.visitVarInsn(54, context2.var(ProtocolVersions.PROTOCOL_KEY_IDENTIFIER));
        methodVisitor2.visitLabel(label11);
        methodVisitor2.visitVarInsn(25, context2.var(str3));
        String str17 = str6;
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, str17, "()I");
        methodVisitor2.visitLdcInsn(15);
        methodVisitor2.visitJumpInsn(Opcodes.IF_ICMPEQ, label12);
        Label label13 = label12;
        methodVisitor2.visitVarInsn(25, 0);
        String access$300 = context.className;
        StringBuilder sb3 = new StringBuilder();
        boolean z = isPrimitive2;
        sb3.append(fieldInfo3.name);
        sb3.append("_asm_list_item_deser__");
        Label label14 = label11;
        methodVisitor2.visitFieldInsn(180, access$300, sb3.toString(), ASMUtils.desc((Class<?>) cls6));
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
        methodVisitor2.visitVarInsn(21, context2.var(ProtocolVersions.PROTOCOL_KEY_IDENTIFIER));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String type2 = ASMUtils.type(cls6);
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEINTERFACE, type2, "deserialze", "(L" + str15 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        String str18 = str;
        methodVisitor2.visitVarInsn(58, context2.var(str18));
        methodVisitor2.visitIincInsn(context2.var(ProtocolVersions.PROTOCOL_KEY_IDENTIFIER), 1);
        methodVisitor2.visitVarInsn(25, context2.var(fieldInfo3.name + "_asm"));
        methodVisitor2.visitVarInsn(25, context2.var(str18));
        if (cls.isInterface()) {
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEINTERFACE, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        }
        methodVisitor2.visitInsn(87);
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitVarInsn(25, context2.var(fieldInfo3.name + "_asm"));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str15, "checkListResolve", "(Ljava/util/Collection;)V");
        methodVisitor2.visitVarInsn(25, context2.var(str3));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, str17, "()I");
        methodVisitor2.visitLdcInsn(16);
        Label label15 = label14;
        methodVisitor2.visitJumpInsn(160, label15);
        if (z) {
            methodVisitor2.visitVarInsn(25, context2.var(str3));
            methodVisitor2.visitVarInsn(21, context2.var(str16));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, str8, str14);
            i2 = Opcodes.GOTO;
        } else {
            _quickNextToken(context2, methodVisitor2, 12);
            i2 = Opcodes.GOTO;
        }
        methodVisitor2.visitJumpInsn(i2, label15);
        methodVisitor2.visitLabel(label13);
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitVarInsn(25, context2.var("listContext"));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str15, "setContext", "(" + ASMUtils.desc((Class<?>) ParseContext.class) + ")V");
        methodVisitor2.visitVarInsn(25, context2.var(str3));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, str17, "()I");
        methodVisitor2.visitLdcInsn(15);
        methodVisitor2.visitJumpInsn(160, label);
        _quickNextTokenComma(context, methodVisitor);
        methodVisitor2.visitLabel(label2);
    }

    private void _deserialze_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, int i) {
        Context context2 = context;
        MethodVisitor methodVisitor2 = methodVisitor;
        FieldInfo fieldInfo2 = fieldInfo;
        Label label2 = new Label();
        Label label3 = new Label();
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitVarInsn(25, 0);
        String access$300 = context.className;
        methodVisitor2.visitFieldInsn(180, access$300, fieldInfo2.name + "_asm_prefix__", "[C");
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "matchField", "([C)Z");
        methodVisitor2.visitJumpInsn(Opcodes.IFNE, label2);
        methodVisitor2.visitInsn(1);
        methodVisitor2.visitVarInsn(58, context2.var(fieldInfo2.name + "_asm"));
        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label3);
        methodVisitor2.visitLabel(label2);
        int i2 = i;
        _setFlag(methodVisitor2, context2, i2);
        methodVisitor2.visitVarInsn(21, context2.var("matchedCount"));
        methodVisitor2.visitInsn(4);
        methodVisitor2.visitInsn(96);
        methodVisitor2.visitVarInsn(54, context2.var("matchedCount"));
        _deserObject(context, methodVisitor, fieldInfo, cls, i2);
        methodVisitor2.visitVarInsn(25, 1);
        String str = DefaultJSONParser;
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getResolveStatus", "()I");
        methodVisitor2.visitLdcInsn(1);
        methodVisitor2.visitJumpInsn(160, label3);
        methodVisitor2.visitVarInsn(25, 1);
        StringBuilder sb = new StringBuilder();
        sb.append("()");
        Class<DefaultJSONParser.ResolveTask> cls2 = DefaultJSONParser.ResolveTask.class;
        sb.append(ASMUtils.desc((Class<?>) cls2));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getLastResolveTask", sb.toString());
        methodVisitor2.visitVarInsn(58, context2.var("resolveTask"));
        methodVisitor2.visitVarInsn(25, context2.var("resolveTask"));
        methodVisitor2.visitVarInsn(25, 1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("()");
        Class<ParseContext> cls3 = ParseContext.class;
        sb2.append(ASMUtils.desc((Class<?>) cls3));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getContext", sb2.toString());
        methodVisitor2.visitFieldInsn(Opcodes.PUTFIELD, ASMUtils.type(cls2), "ownerContext", ASMUtils.desc((Class<?>) cls3));
        methodVisitor2.visitVarInsn(25, context2.var("resolveTask"));
        methodVisitor2.visitVarInsn(25, 0);
        methodVisitor2.visitLdcInsn(fieldInfo2.name);
        String type = ASMUtils.type(JavaBeanDeserializer.class);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("(Ljava/lang/String;)");
        Class<FieldDeserializer> cls4 = FieldDeserializer.class;
        sb3.append(ASMUtils.desc((Class<?>) cls4));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, type, "getFieldDeserializer", sb3.toString());
        methodVisitor2.visitFieldInsn(Opcodes.PUTFIELD, ASMUtils.type(cls2), "fieldDeserializer", ASMUtils.desc((Class<?>) cls4));
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitLdcInsn(0);
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "setResolveStatus", "(I)V");
        methodVisitor2.visitLabel(label3);
    }

    private void _getCollectionFieldItemDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String access$300 = context.className;
        Class<ObjectDeserializer> cls2 = ObjectDeserializer.class;
        methodVisitor.visitFieldInsn(180, access$300, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc((Class<?>) cls2));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        String str = DefaultJSONParser;
        StringBuilder sb = new StringBuilder();
        sb.append("()");
        Class<ParserConfig> cls3 = ParserConfig.class;
        sb.append(ASMUtils.desc((Class<?>) cls3));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getConfig", sb.toString());
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
        String type = ASMUtils.type(cls3);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, type, "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc((Class<?>) cls2));
        String access$3002 = context.className;
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, access$3002, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc((Class<?>) cls2));
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        String access$3003 = context.className;
        methodVisitor.visitFieldInsn(180, access$3003, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc((Class<?>) cls2));
    }

    private void _getFieldDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String access$300 = context.className;
        Class<ObjectDeserializer> cls = ObjectDeserializer.class;
        methodVisitor.visitFieldInsn(180, access$300, fieldInfo.name + "_asm_deser__", ASMUtils.desc((Class<?>) cls));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        String str = DefaultJSONParser;
        StringBuilder sb = new StringBuilder();
        sb.append("()");
        Class<ParserConfig> cls2 = ParserConfig.class;
        sb.append(ASMUtils.desc((Class<?>) cls2));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getConfig", sb.toString());
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        String type = ASMUtils.type(cls2);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, type, "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc((Class<?>) cls));
        String access$3002 = context.className;
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, access$3002, fieldInfo.name + "_asm_deser__", ASMUtils.desc((Class<?>) cls));
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        String access$3003 = context.className;
        methodVisitor.visitFieldInsn(180, access$3003, fieldInfo.name + "_asm_deser__", ASMUtils.desc((Class<?>) cls));
    }

    private void _init(ClassWriter classWriter, Context context) {
        ClassWriter classWriter2 = classWriter;
        for (FieldInfo fieldInfo : context.fieldInfoList) {
            new FieldWriter(classWriter2, 1, fieldInfo.name + "_asm_prefix__", "[C").visitEnd();
        }
        for (FieldInfo fieldInfo2 : context.fieldInfoList) {
            Class<?> cls = fieldInfo2.fieldClass;
            if (!cls.isPrimitive()) {
                Class<ObjectDeserializer> cls2 = ObjectDeserializer.class;
                if (Collection.class.isAssignableFrom(cls)) {
                    new FieldWriter(classWriter2, 1, fieldInfo2.name + "_asm_list_item_deser__", ASMUtils.desc((Class<?>) cls2)).visitEnd();
                } else {
                    new FieldWriter(classWriter2, 1, fieldInfo2.name + "_asm_deser__", ASMUtils.desc((Class<?>) cls2)).visitEnd();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<ParserConfig> cls3 = ParserConfig.class;
        sb.append(ASMUtils.desc((Class<?>) cls3));
        Class<JavaBeanInfo> cls4 = JavaBeanInfo.class;
        sb.append(ASMUtils.desc((Class<?>) cls4));
        sb.append(")V");
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, "<init>", sb.toString(), (String) null, (String[]) null);
        methodWriter.visitVarInsn(25, 0);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitVarInsn(25, 2);
        methodWriter.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(JavaBeanDeserializer.class), "<init>", "(" + ASMUtils.desc((Class<?>) cls3) + ASMUtils.desc((Class<?>) cls4) + ")V");
        int length = context.fieldInfoList.length;
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo3 = context.fieldInfoList[i];
            methodWriter.visitVarInsn(25, 0);
            methodWriter.visitLdcInsn("\"" + fieldInfo3.name + "\":");
            methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "toCharArray", "()[C");
            methodWriter.visitFieldInsn(Opcodes.PUTFIELD, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
        }
        methodWriter.visitInsn(Opcodes.RETURN);
        methodWriter.visitMaxs(4, 4);
        methodWriter.visitEnd();
    }

    private void _isFlag(MethodVisitor methodVisitor, Context context, int i, Label label) {
        methodVisitor.visitVarInsn(21, context.var("_asm_flag_" + (i / 32)));
        methodVisitor.visitLdcInsn(Integer.valueOf(1 << i));
        methodVisitor.visitInsn(126);
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
    }

    private void _loadAndSet(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Class<?> cls = fieldInfo.fieldClass;
        java.lang.reflect.Type type = fieldInfo.fieldType;
        if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(21, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Character.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(21, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(22, context.var(fieldInfo.name + "_asm", 2));
            if (fieldInfo.method != null) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(context.getInstClass()), fieldInfo.method.getName(), ASMUtils.desc(fieldInfo.method));
                if (!fieldInfo.method.getReturnType().equals(Void.TYPE)) {
                    methodVisitor.visitInsn(87);
                    return;
                }
                return;
            }
            methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.field.getName(), ASMUtils.desc(fieldInfo.fieldClass));
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(23, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(24, context.var(fieldInfo.name + "_asm", 2));
            _set(context, methodVisitor, fieldInfo);
        } else {
            Class<String> cls2 = String.class;
            if (cls == cls2) {
                methodVisitor.visitVarInsn(25, context.var("instance"));
                methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                _set(context, methodVisitor, fieldInfo);
            } else if (cls.isEnum()) {
                methodVisitor.visitVarInsn(25, context.var("instance"));
                methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                _set(context, methodVisitor, fieldInfo);
            } else if (Collection.class.isAssignableFrom(cls)) {
                methodVisitor.visitVarInsn(25, context.var("instance"));
                if (TypeUtils.getCollectionItemClass(type) == cls2) {
                    methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                    methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
                } else {
                    methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                }
                _set(context, methodVisitor, fieldInfo);
            } else {
                methodVisitor.visitVarInsn(25, context.var("instance"));
                methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                _set(context, methodVisitor, fieldInfo);
            }
        }
    }

    private void _newCollection(MethodVisitor methodVisitor, Class<?> cls, int i, boolean z) {
        if (!cls.isAssignableFrom(ArrayList.class) || z) {
            Class<LinkedList> cls2 = LinkedList.class;
            if (!cls.isAssignableFrom(cls2) || z) {
                Class<HashSet> cls3 = HashSet.class;
                if (cls.isAssignableFrom(cls3)) {
                    methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(cls3));
                    methodVisitor.visitInsn(89);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(cls3), "<init>", "()V");
                } else {
                    Class<TreeSet> cls4 = TreeSet.class;
                    if (cls.isAssignableFrom(cls4)) {
                        methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(cls4));
                        methodVisitor.visitInsn(89);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(cls4), "<init>", "()V");
                    } else {
                        Class<LinkedHashSet> cls5 = LinkedHashSet.class;
                        if (cls.isAssignableFrom(cls5)) {
                            methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(cls5));
                            methodVisitor.visitInsn(89);
                            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(cls5), "<init>", "()V");
                        } else if (z) {
                            methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(cls3));
                            methodVisitor.visitInsn(89);
                            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(cls3), "<init>", "()V");
                        } else {
                            methodVisitor.visitVarInsn(25, 0);
                            methodVisitor.visitLdcInsn(Integer.valueOf(i));
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
                        }
                    }
                }
            } else {
                methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(cls2));
                methodVisitor.visitInsn(89);
                methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(cls2), "<init>", "()V");
            }
        } else {
            methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/ArrayList");
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/ArrayList", "<init>", "()V");
        }
        methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
    }

    private void _quickNextToken(Context context, MethodVisitor methodVisitor, int i) {
        Label label = new Label();
        Label label2 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        String str = JSONLexerBase;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getCurrent", "()C");
        if (i == 12) {
            methodVisitor.visitVarInsn(16, 123);
        } else if (i == 14) {
            methodVisitor.visitVarInsn(16, 91);
        } else {
            throw new IllegalStateException();
        }
        methodVisitor.visitJumpInsn(160, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "next", "()C");
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(Integer.valueOf(i));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(Integer.valueOf(i));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "nextToken", "(I)V");
        methodVisitor.visitLabel(label2);
    }

    private void _quickNextTokenComma(Context context, MethodVisitor methodVisitor) {
        Context context2 = context;
        MethodVisitor methodVisitor2 = methodVisitor;
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        String str = JSONLexerBase;
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getCurrent", "()C");
        methodVisitor2.visitInsn(89);
        methodVisitor2.visitVarInsn(54, context2.var("ch"));
        methodVisitor2.visitVarInsn(16, 44);
        methodVisitor2.visitJumpInsn(160, label2);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "next", "()C");
        methodVisitor2.visitInsn(87);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitLdcInsn(16);
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "setToken", "(I)V");
        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label5);
        methodVisitor2.visitLabel(label2);
        methodVisitor2.visitVarInsn(21, context2.var("ch"));
        methodVisitor2.visitVarInsn(16, 125);
        methodVisitor2.visitJumpInsn(160, label3);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "next", "()C");
        methodVisitor2.visitInsn(87);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitLdcInsn(13);
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "setToken", "(I)V");
        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label5);
        methodVisitor2.visitLabel(label3);
        methodVisitor2.visitVarInsn(21, context2.var("ch"));
        methodVisitor2.visitVarInsn(16, 93);
        methodVisitor2.visitJumpInsn(160, label4);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "next", "()C");
        methodVisitor2.visitInsn(87);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitLdcInsn(15);
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "setToken", "(I)V");
        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label5);
        methodVisitor2.visitLabel(label4);
        methodVisitor2.visitVarInsn(21, context2.var("ch"));
        methodVisitor2.visitVarInsn(16, 26);
        methodVisitor2.visitJumpInsn(160, label);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitLdcInsn(20);
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "setToken", "(I)V");
        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label5);
        methodVisitor2.visitLabel(label);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "nextToken", "()V");
        methodVisitor2.visitLabel(label5);
    }

    private void _set(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Method method = fieldInfo.method;
        if (method != null) {
            methodVisitor.visitMethodInsn(method.getDeclaringClass().isInterface() ? Opcodes.INVOKEINTERFACE : Opcodes.INVOKEVIRTUAL, ASMUtils.type(fieldInfo.declaringClass), method.getName(), ASMUtils.desc(method));
            if (!fieldInfo.method.getReturnType().equals(Void.TYPE)) {
                methodVisitor.visitInsn(87);
                return;
            }
            return;
        }
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.field.getName(), ASMUtils.desc(fieldInfo.fieldClass));
    }

    private void _setContext(Context context, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var("context"));
        String str = DefaultJSONParser;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<ParseContext> cls = ParseContext.class;
        sb.append(ASMUtils.desc((Class<?>) cls));
        sb.append(")V");
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "setContext", sb.toString());
        Label label = new Label();
        methodVisitor.visitVarInsn(25, context.var("childContext"));
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label);
        methodVisitor.visitVarInsn(25, context.var("childContext"));
        methodVisitor.visitVarInsn(25, context.var("instance"));
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, ASMUtils.type(cls), "object", "Ljava/lang/Object;");
        methodVisitor.visitLabel(label);
    }

    private void _setFlag(MethodVisitor methodVisitor, Context context, int i) {
        String str = "_asm_flag_" + (i / 32);
        methodVisitor.visitVarInsn(21, context.var(str));
        methodVisitor.visitLdcInsn(Integer.valueOf(1 << i));
        methodVisitor.visitInsn(128);
        methodVisitor.visitVarInsn(54, context.var(str));
    }

    private void defineVarLexer(Context context, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitFieldInsn(180, DefaultJSONParser, "lexer", ASMUtils.desc((Class<?>) JSONLexer.class));
        methodVisitor.visitTypeInsn(192, JSONLexerBase);
        methodVisitor.visitVarInsn(58, context.var("lexer"));
    }

    public ObjectDeserializer createJavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) throws Exception {
        String str;
        Class<?> cls = javaBeanInfo.clazz;
        if (!cls.isPrimitive()) {
            String str2 = "FastjsonASMDeserializer_" + this.seed.incrementAndGet() + AccountConstantKt.DEFAULT_SEGMENT + cls.getSimpleName();
            Package packageR = ASMDeserializerFactory.class.getPackage();
            if (packageR != null) {
                String name = packageR.getName();
                String str3 = name.replace('.', '/') + "/" + str2;
                str = name + "." + str2;
                str2 = str3;
            } else {
                str = str2;
            }
            ClassWriter classWriter = new ClassWriter();
            classWriter.visit(49, 33, str2, ASMUtils.type(JavaBeanDeserializer.class), (String[]) null);
            _init(classWriter, new Context(str2, parserConfig, javaBeanInfo, 3));
            _createInstance(classWriter, new Context(str2, parserConfig, javaBeanInfo, 3));
            _deserialze(classWriter, new Context(str2, parserConfig, javaBeanInfo, 5));
            _deserialzeArrayMapping(classWriter, new Context(str2, parserConfig, javaBeanInfo, 4));
            byte[] byteArray = classWriter.toByteArray();
            return (ObjectDeserializer) this.classLoader.defineClassPublic(str, byteArray, 0, byteArray.length).getConstructor(new Class[]{ParserConfig.class, JavaBeanInfo.class}).newInstance(new Object[]{parserConfig, javaBeanInfo});
        }
        throw new IllegalArgumentException("not support type :" + cls.getName());
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor, boolean z) {
        int length = context.fieldInfoList.length;
        for (int i = 0; i < length; i++) {
            Label label = new Label();
            if (z) {
                _isFlag(methodVisitor, context, i, label);
            }
            _loadAndSet(context, methodVisitor, context.fieldInfoList[i]);
            if (z) {
                methodVisitor.visitLabel(label);
            }
        }
    }

    public static class Context {
        static final int fieldName = 3;
        static final int parser = 1;
        static final int type = 2;
        /* access modifiers changed from: private */
        public final JavaBeanInfo beanInfo;
        /* access modifiers changed from: private */
        public final String className;
        /* access modifiers changed from: private */
        public final Class<?> clazz;
        /* access modifiers changed from: private */
        public FieldInfo[] fieldInfoList;
        /* access modifiers changed from: private */
        public int variantIndex = -1;
        private final Map<String, Integer> variants = new HashMap();

        public Context(String str, ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, int i) {
            this.className = str;
            this.clazz = javaBeanInfo.clazz;
            this.variantIndex = i;
            this.beanInfo = javaBeanInfo;
            this.fieldInfoList = javaBeanInfo.fields;
        }

        public Class<?> getInstClass() {
            Class<?> cls = this.beanInfo.builderClass;
            return cls == null ? this.clazz : cls;
        }

        public int var(String str, int i) {
            if (this.variants.get(str) == null) {
                this.variants.put(str, Integer.valueOf(this.variantIndex));
                this.variantIndex += i;
            }
            return this.variants.get(str).intValue();
        }

        public int var(String str) {
            if (this.variants.get(str) == null) {
                Map<String, Integer> map = this.variants;
                int i = this.variantIndex;
                this.variantIndex = i + 1;
                map.put(str, Integer.valueOf(i));
            }
            return this.variants.get(str).intValue();
        }
    }

    private void _createInstance(ClassWriter classWriter, Context context) {
        if (Modifier.isPublic(context.beanInfo.defaultConstructor.getModifiers())) {
            MethodWriter methodWriter = new MethodWriter(classWriter, 1, "createInstance", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;", (String) null, (String[]) null);
            methodWriter.visitTypeInsn(Opcodes.NEW, ASMUtils.type(context.getInstClass()));
            methodWriter.visitInsn(89);
            methodWriter.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(context.getInstClass()), "<init>", "()V");
            methodWriter.visitInsn(176);
            methodWriter.visitMaxs(3, 3);
            methodWriter.visitEnd();
        }
    }
}

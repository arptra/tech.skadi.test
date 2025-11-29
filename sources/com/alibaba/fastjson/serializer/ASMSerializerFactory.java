package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.HttpUrl;

public class ASMSerializerFactory implements Opcodes {
    static final String JSONSerializer = ASMUtils.type(JSONSerializer.class);
    static final String JavaBeanSerializer;
    static final String JavaBeanSerializer_desc;
    static final String ObjectSerializer;
    static final String ObjectSerializer_desc;
    static final String SerialContext_desc = ASMUtils.desc((Class<?>) SerialContext.class);
    static final String SerializeFilterable_desc = ASMUtils.desc((Class<?>) SerializeFilterable.class);
    static final String SerializeWriter;
    static final String SerializeWriter_desc;
    protected final ASMClassLoader classLoader = new ASMClassLoader();
    private final AtomicLong seed = new AtomicLong();

    static {
        String type = ASMUtils.type(ObjectSerializer.class);
        ObjectSerializer = type;
        ObjectSerializer_desc = "L" + type + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD;
        String type2 = ASMUtils.type(SerializeWriter.class);
        SerializeWriter = type2;
        SerializeWriter_desc = "L" + type2 + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD;
        Class<JavaBeanSerializer> cls = JavaBeanSerializer.class;
        JavaBeanSerializer = ASMUtils.type(cls);
        JavaBeanSerializer_desc = "L" + ASMUtils.type(cls) + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD;
    }

    private void _after(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeAfter", "(L" + JSONSerializer + ";Ljava/lang/Object;C)C");
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _apply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Class<?> cls = fieldInfo.fieldClass;
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var("string"));
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var("list"));
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
        }
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "apply", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
    }

    private void _before(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeBefore", "(L" + JSONSerializer + ";Ljava/lang/Object;C)C");
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _decimal(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("decimal"));
        _filters(methodVisitor, fieldInfo, context, label);
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        methodVisitor.visitLabel(label2);
        methodVisitor.visitVarInsn(25, context.var("decimal"));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label3);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label4);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(25, context.var("decimal"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label4);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitLabel(label);
    }

    private void _double(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(57, context.var("double", 2));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(24, context.var("double", 2));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;D)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _enum(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label3);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitTypeInsn(192, "java/lang/Enum");
        methodVisitor.visitVarInsn(58, context.var("enum"));
        _filters(methodVisitor, fieldInfo, context, label3);
        methodVisitor.visitVarInsn(25, context.var("enum"));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
        methodVisitor.visitLabel(label);
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Enum", "name", "()Ljava/lang/String;");
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            String str = SerializeWriter;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "write", "(I)V");
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitInsn(3);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeFieldName", "(Ljava/lang/String;Z)V");
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        }
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label2);
        methodVisitor.visitLabel(label3);
    }

    private void _filters(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (fieldInfo.fieldTransient) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.SkipTransientField.mask));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label);
        }
        _notWriteDefault(methodVisitor, fieldInfo, context, label);
        if (!context.writeDirect) {
            _apply(methodVisitor, fieldInfo, context);
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            _processKey(methodVisitor, fieldInfo, context);
            _processValue(methodVisitor, fieldInfo, context, label);
        }
    }

    private void _float(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(56, context.var("float"));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(23, context.var("float"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;F)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _get(MethodVisitor methodVisitor, Context context, FieldInfo fieldInfo) {
        Method method = fieldInfo.method;
        if (method != null) {
            methodVisitor.visitVarInsn(25, context.var("entity"));
            Class<?> declaringClass = method.getDeclaringClass();
            methodVisitor.visitMethodInsn(declaringClass.isInterface() ? Opcodes.INVOKEINTERFACE : Opcodes.INVOKEVIRTUAL, ASMUtils.type(declaringClass), method.getName(), ASMUtils.desc(method));
            if (!method.getReturnType().equals(fieldInfo.fieldClass)) {
                methodVisitor.visitTypeInsn(192, ASMUtils.type(fieldInfo.fieldClass));
                return;
            }
            return;
        }
        methodVisitor.visitVarInsn(25, context.var("entity"));
        Field field = fieldInfo.field;
        methodVisitor.visitFieldInsn(180, ASMUtils.type(fieldInfo.declaringClass), field.getName(), ASMUtils.desc(field.getType()));
        if (!field.getType().equals(fieldInfo.fieldClass)) {
            methodVisitor.visitTypeInsn(192, ASMUtils.type(fieldInfo.fieldClass));
        }
    }

    private void _getFieldSer(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = ObjectSerializer_desc;
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_ser_", str);
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "getObjectWriter", "(Ljava/lang/Class;)" + str);
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, context.className, fieldInfo.name + "_asm_ser_", str);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_ser_", str);
    }

    private void _getListFieldItemSer(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = ObjectSerializer_desc;
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_list_item_ser_", str);
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "getObjectWriter", "(Ljava/lang/Class;)" + str);
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, context.className, fieldInfo.name + "_asm_list_item_ser_", str);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_list_item_ser_", str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void _if_write_null(com.alibaba.fastjson.asm.MethodVisitor r18, com.alibaba.fastjson.util.FieldInfo r19, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            java.lang.Class<?> r4 = r2.fieldClass
            com.alibaba.fastjson.asm.Label r5 = new com.alibaba.fastjson.asm.Label
            r5.<init>()
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            com.alibaba.fastjson.asm.Label r7 = new com.alibaba.fastjson.asm.Label
            r7.<init>()
            com.alibaba.fastjson.asm.Label r8 = new com.alibaba.fastjson.asm.Label
            r8.<init>()
            r1.visitLabel(r5)
            com.alibaba.fastjson.annotation.JSONField r2 = r19.getAnnotation()
            if (r2 == 0) goto L_0x0030
            com.alibaba.fastjson.serializer.SerializerFeature[] r2 = r2.serialzeFeatures()
            int r2 = com.alibaba.fastjson.serializer.SerializerFeature.of(r2)
            goto L_0x0031
        L_0x0030:
            r2 = 0
        L_0x0031:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r9 = r20.beanInfo
            com.alibaba.fastjson.annotation.JSONType r9 = r9.jsonType
            if (r9 == 0) goto L_0x0042
            com.alibaba.fastjson.serializer.SerializerFeature[] r9 = r9.serialzeFeatures()
            int r9 = com.alibaba.fastjson.serializer.SerializerFeature.of(r9)
            r2 = r2 | r9
        L_0x0042:
            java.lang.Class<java.lang.Boolean> r9 = java.lang.Boolean.class
            java.lang.Class<java.util.Collection> r10 = java.util.Collection.class
            java.lang.Class<java.lang.Number> r11 = java.lang.Number.class
            java.lang.Class<java.lang.String> r12 = java.lang.String.class
            if (r4 != r12) goto L_0x005a
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue
            int r13 = r13.getMask()
            com.alibaba.fastjson.serializer.SerializerFeature r14 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty
            int r14 = r14.getMask()
        L_0x0058:
            r13 = r13 | r14
            goto L_0x0091
        L_0x005a:
            boolean r13 = r11.isAssignableFrom(r4)
            if (r13 == 0) goto L_0x006d
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue
            int r13 = r13.getMask()
            com.alibaba.fastjson.serializer.SerializerFeature r14 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero
            int r14 = r14.getMask()
            goto L_0x0058
        L_0x006d:
            boolean r13 = r10.isAssignableFrom(r4)
            if (r13 == 0) goto L_0x0080
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue
            int r13 = r13.getMask()
            com.alibaba.fastjson.serializer.SerializerFeature r14 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty
            int r14 = r14.getMask()
            goto L_0x0058
        L_0x0080:
            if (r9 != r4) goto L_0x008f
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue
            int r13 = r13.getMask()
            com.alibaba.fastjson.serializer.SerializerFeature r14 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse
            int r14 = r14.getMask()
            goto L_0x0058
        L_0x008f:
            int r13 = com.alibaba.fastjson.serializer.SerializerFeature.WRITE_MAP_NULL_FEATURES
        L_0x0091:
            r14 = r2 & r13
            java.lang.String r5 = "out"
            r15 = 25
            if (r14 != 0) goto L_0x00ba
            int r14 = r3.var(r5)
            r1.visitVarInsn(r15, r14)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r1.visitLdcInsn(r13)
            java.lang.String r13 = SerializeWriter
            java.lang.String r14 = "isEnabled"
            java.lang.String r15 = "(I)Z"
            r16 = r8
            r8 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r8, r13, r14, r15)
            r8 = 153(0x99, float:2.14E-43)
            r1.visitJumpInsn(r8, r6)
            goto L_0x00bc
        L_0x00ba:
            r16 = r8
        L_0x00bc:
            r1.visitLabel(r7)
            int r7 = r3.var(r5)
            r8 = 25
            r1.visitVarInsn(r8, r7)
            java.lang.String r7 = "seperator"
            int r7 = r3.var(r7)
            r13 = 21
            r1.visitVarInsn(r13, r7)
            java.lang.String r7 = SerializeWriter
            java.lang.String r13 = "write"
            java.lang.String r14 = "(I)V"
            r15 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r15, r7, r13, r14)
            r0._writeFieldName(r1, r3)
            int r5 = r3.var(r5)
            r1.visitVarInsn(r8, r5)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.visitLdcInsn(r2)
            if (r4 == r12) goto L_0x0138
            java.lang.Class<java.lang.Character> r2 = java.lang.Character.class
            if (r4 != r2) goto L_0x00f6
            goto L_0x0138
        L_0x00f6:
            boolean r2 = r11.isAssignableFrom(r4)
            if (r2 == 0) goto L_0x0108
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero
            int r2 = r2.mask
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.visitLdcInsn(r2)
            goto L_0x0143
        L_0x0108:
            if (r4 != r9) goto L_0x0116
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse
            int r2 = r2.mask
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.visitLdcInsn(r2)
            goto L_0x0143
        L_0x0116:
            boolean r2 = r10.isAssignableFrom(r4)
            if (r2 != 0) goto L_0x012c
            boolean r2 = r4.isArray()
            if (r2 == 0) goto L_0x0123
            goto L_0x012c
        L_0x0123:
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.visitLdcInsn(r2)
            goto L_0x0143
        L_0x012c:
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty
            int r2 = r2.mask
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.visitLdcInsn(r2)
            goto L_0x0143
        L_0x0138:
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty
            int r2 = r2.mask
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.visitLdcInsn(r2)
        L_0x0143:
            java.lang.String r2 = "writeNull"
            java.lang.String r4 = "(II)V"
            r5 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r5, r7, r2, r4)
            r0._seperator(r1, r3)
            r0 = 167(0xa7, float:2.34E-43)
            r2 = r16
            r1.visitJumpInsn(r0, r2)
            r1.visitLabel(r6)
            r1.visitLabel(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ASMSerializerFactory._if_write_null(com.alibaba.fastjson.asm.MethodVisitor, com.alibaba.fastjson.util.FieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory$Context):void");
    }

    private void _int(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, int i, char c) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(54, i);
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(21, i);
        String str = SerializeWriter;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeFieldValue", "(CLjava/lang/String;" + c + ")V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _labelApply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(fieldInfo.label);
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "applyLabel", "(L" + JSONSerializer + ";Ljava/lang/String;)Z");
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
    }

    private void _list(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label;
        int i;
        int i2;
        int i3;
        Label label2;
        Label label3;
        Label label4;
        String str;
        String str2;
        FieldInfo fieldInfo2;
        Label label5;
        Label label6;
        String str3;
        Label label7;
        Label label8;
        String str4;
        MethodVisitor methodVisitor2 = methodVisitor;
        FieldInfo fieldInfo3 = fieldInfo;
        Context context2 = context;
        java.lang.reflect.Type collectionItemType = TypeUtils.getCollectionItemType(fieldInfo3.fieldType);
        Class<Serializable> cls2 = null;
        Class<Serializable> cls3 = collectionItemType instanceof Class ? (Class) collectionItemType : null;
        if (!(cls3 == Object.class || cls3 == Serializable.class)) {
            cls2 = cls3;
        }
        Label label9 = new Label();
        Label label10 = new Label();
        Label label11 = new Label();
        _nameApply(methodVisitor2, fieldInfo3, context2, label9);
        _get(methodVisitor2, context2, fieldInfo3);
        methodVisitor2.visitTypeInsn(192, "java/util/List");
        methodVisitor2.visitVarInsn(58, context2.var("list"));
        _filters(methodVisitor2, fieldInfo3, context2, label9);
        methodVisitor2.visitVarInsn(25, context2.var("list"));
        methodVisitor2.visitJumpInsn(Opcodes.IFNONNULL, label10);
        _if_write_null(methodVisitor2, fieldInfo3, context2);
        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label11);
        methodVisitor2.visitLabel(label10);
        methodVisitor2.visitVarInsn(25, context2.var("out"));
        methodVisitor2.visitVarInsn(21, context2.var("seperator"));
        String str5 = SerializeWriter;
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "write", "(I)V");
        _writeFieldName(methodVisitor2, context2);
        methodVisitor2.visitVarInsn(25, context2.var("list"));
        Label label12 = label9;
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "size", "()I");
        methodVisitor2.visitVarInsn(54, context2.var("size"));
        Label label13 = new Label();
        Label label14 = new Label();
        Label label15 = label11;
        methodVisitor2.visitVarInsn(21, context2.var("size"));
        methodVisitor2.visitInsn(3);
        methodVisitor2.visitJumpInsn(160, label13);
        methodVisitor2.visitVarInsn(25, context2.var("out"));
        methodVisitor2.visitLdcInsn(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "write", "(Ljava/lang/String;)V");
        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label14);
        methodVisitor2.visitLabel(label13);
        if (!context.nonContext) {
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context2.var("list"));
            methodVisitor2.visitVarInsn(25, Context.fieldName);
            label = label14;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
        } else {
            label = label14;
        }
        if (collectionItemType != String.class || !context.writeDirect) {
            methodVisitor2.visitVarInsn(25, context2.var("out"));
            methodVisitor2.visitVarInsn(16, 91);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "write", "(I)V");
            Label label16 = new Label();
            Label label17 = new Label();
            Label label18 = new Label();
            methodVisitor2.visitInsn(3);
            java.lang.reflect.Type type = collectionItemType;
            methodVisitor2.visitVarInsn(54, context2.var(ProtocolVersions.PROTOCOL_KEY_IDENTIFIER));
            methodVisitor2.visitLabel(label16);
            methodVisitor2.visitVarInsn(21, context2.var(ProtocolVersions.PROTOCOL_KEY_IDENTIFIER));
            methodVisitor2.visitVarInsn(21, context2.var("size"));
            methodVisitor2.visitJumpInsn(Opcodes.IF_ICMPGE, label18);
            methodVisitor2.visitVarInsn(21, context2.var(ProtocolVersions.PROTOCOL_KEY_IDENTIFIER));
            methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label17);
            methodVisitor2.visitVarInsn(25, context2.var("out"));
            methodVisitor2.visitVarInsn(16, 44);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "write", "(I)V");
            methodVisitor2.visitLabel(label17);
            methodVisitor2.visitVarInsn(25, context2.var("list"));
            methodVisitor2.visitVarInsn(21, context2.var(ProtocolVersions.PROTOCOL_KEY_IDENTIFIER));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "get", "(I)Ljava/lang/Object;");
            methodVisitor2.visitVarInsn(58, context2.var("list_item"));
            Label label19 = new Label();
            Label label20 = new Label();
            methodVisitor2.visitVarInsn(25, context2.var("list_item"));
            methodVisitor2.visitJumpInsn(Opcodes.IFNONNULL, label20);
            methodVisitor2.visitVarInsn(25, context2.var("out"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "writeNull", "()V");
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label19);
            methodVisitor2.visitLabel(label20);
            Label label21 = new Label();
            Label label22 = new Label();
            String str6 = str5;
            String str7 = "(I)V";
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                label3 = label16;
                label2 = label19;
                str = "out";
                label5 = label21;
                str2 = "write";
                label4 = label18;
                fieldInfo2 = fieldInfo;
                label6 = label22;
            } else {
                str = "out";
                methodVisitor2.visitVarInsn(25, context2.var("list_item"));
                label4 = label18;
                label3 = label16;
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) cls2)));
                methodVisitor2.visitJumpInsn(Opcodes.IF_ACMPNE, label22);
                fieldInfo2 = fieldInfo;
                _getListFieldItemSer(context2, methodVisitor2, fieldInfo2, cls2);
                methodVisitor2.visitVarInsn(58, context2.var("list_item_desc"));
                Label label23 = new Label();
                Label label24 = new Label();
                if (context.writeDirect) {
                    if (!context.nonContext || !context.writeDirect) {
                        label2 = label19;
                        label8 = label22;
                        str4 = "write";
                    } else {
                        label2 = label19;
                        str4 = "writeDirectNonContext";
                        label8 = label22;
                    }
                    label7 = label21;
                    methodVisitor2.visitVarInsn(25, context2.var("list_item_desc"));
                    String str8 = JavaBeanSerializer;
                    methodVisitor2.visitTypeInsn(Opcodes.INSTANCEOF, str8);
                    methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label23);
                    str3 = "write";
                    methodVisitor2.visitVarInsn(25, context2.var("list_item_desc"));
                    methodVisitor2.visitTypeInsn(192, str8);
                    methodVisitor2.visitVarInsn(25, 1);
                    methodVisitor2.visitVarInsn(25, context2.var("list_item"));
                    if (context.nonContext) {
                        methodVisitor2.visitInsn(1);
                    } else {
                        methodVisitor2.visitVarInsn(21, context2.var(ProtocolVersions.PROTOCOL_KEY_IDENTIFIER));
                        methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    }
                    methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) cls2)));
                    methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                    methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, str4, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    methodVisitor2.visitJumpInsn(Opcodes.GOTO, label24);
                    methodVisitor2.visitLabel(label23);
                } else {
                    label2 = label19;
                    label7 = label21;
                    label8 = label22;
                    str3 = "write";
                }
                methodVisitor2.visitVarInsn(25, context2.var("list_item_desc"));
                methodVisitor2.visitVarInsn(25, 1);
                methodVisitor2.visitVarInsn(25, context2.var("list_item"));
                if (context.nonContext) {
                    methodVisitor2.visitInsn(1);
                } else {
                    methodVisitor2.visitVarInsn(21, context2.var(ProtocolVersions.PROTOCOL_KEY_IDENTIFIER));
                    methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                }
                methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) cls2)));
                methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                str2 = str3;
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEINTERFACE, ObjectSerializer, str2, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodVisitor2.visitLabel(label24);
                label5 = label7;
                methodVisitor2.visitJumpInsn(Opcodes.GOTO, label5);
                label6 = label8;
            }
            methodVisitor2.visitLabel(label6);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context2.var("list_item"));
            if (context.nonContext) {
                methodVisitor2.visitInsn(1);
            } else {
                methodVisitor2.visitVarInsn(21, context2.var(ProtocolVersions.PROTOCOL_KEY_IDENTIFIER));
                methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            }
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) (Class) type)));
                methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
            methodVisitor2.visitLabel(label5);
            methodVisitor2.visitLabel(label2);
            i3 = 1;
            methodVisitor2.visitIincInsn(context2.var(ProtocolVersions.PROTOCOL_KEY_IDENTIFIER), 1);
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label3);
            methodVisitor2.visitLabel(label4);
            i2 = 25;
            methodVisitor2.visitVarInsn(25, context2.var(str));
            methodVisitor2.visitVarInsn(16, 93);
            i = Opcodes.INVOKEVIRTUAL;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str6, str2, str7);
        } else {
            methodVisitor2.visitVarInsn(25, context2.var("out"));
            methodVisitor2.visitVarInsn(25, context2.var("list"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "write", "(Ljava/util/List;)V");
            i2 = 25;
            i = 182;
            i3 = 1;
        }
        methodVisitor2.visitVarInsn(i2, i3);
        methodVisitor2.visitMethodInsn(i, JSONSerializer, "popContext", "()V");
        methodVisitor2.visitLabel(label);
        _seperator(methodVisitor2, context2);
        methodVisitor2.visitLabel(label15);
        methodVisitor2.visitLabel(label12);
    }

    private void _long(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(55, context.var("long", 2));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(22, context.var("long", 2));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;J)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _nameApply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (!context.writeDirect) {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(25, Context.fieldName);
            String str = JavaBeanSerializer;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "applyName", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            _labelApply(methodVisitor, fieldInfo, context, label);
        }
        if (fieldInfo.field == null) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.IgnoreNonFieldGetter.mask));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label);
        }
    }

    private void _notWriteDefault(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (!context.writeDirect) {
            Label label2 = new Label();
            methodVisitor.visitVarInsn(21, context.var("notWriteDefaultValue"));
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label2);
            Class<?> cls = fieldInfo.fieldClass;
            if (cls == Boolean.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("boolean"));
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            } else if (cls == Byte.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("byte"));
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            } else if (cls == Short.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("short"));
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            } else if (cls == Integer.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("int"));
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            } else if (cls == Long.TYPE) {
                methodVisitor.visitVarInsn(22, context.var("long"));
                methodVisitor.visitInsn(9);
                methodVisitor.visitInsn(Opcodes.LCMP);
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            } else if (cls == Float.TYPE) {
                methodVisitor.visitVarInsn(23, context.var("float"));
                methodVisitor.visitInsn(11);
                methodVisitor.visitInsn(Opcodes.FCMPL);
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            } else if (cls == Double.TYPE) {
                methodVisitor.visitVarInsn(24, context.var("double"));
                methodVisitor.visitInsn(14);
                methodVisitor.visitInsn(Opcodes.DCMPL);
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            }
            methodVisitor.visitLabel(label2);
        }
    }

    private void _object(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("object"));
        _filters(methodVisitor, fieldInfo, context, label);
        _writeObject(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitLabel(label);
    }

    private void _processKey(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        methodVisitor.visitVarInsn(21, context.var("hasNameFilters"));
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        Class<?> cls = fieldInfo.fieldClass;
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var("string"));
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var("list"));
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
        }
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "processKey", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        methodVisitor.visitVarInsn(58, Context.fieldName);
        methodVisitor.visitLabel(label);
    }

    private void _processValue(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        MethodVisitor methodVisitor2 = methodVisitor;
        FieldInfo fieldInfo2 = fieldInfo;
        Context context2 = context;
        Label label2 = new Label();
        Class<?> cls = fieldInfo2.fieldClass;
        if (cls.isPrimitive()) {
            Label label3 = new Label();
            methodVisitor2.visitVarInsn(21, context2.var("checkValue"));
            methodVisitor2.visitJumpInsn(Opcodes.IFNE, label3);
            methodVisitor2.visitInsn(1);
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(58, Context.processValue);
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label2);
            methodVisitor2.visitLabel(label3);
        }
        methodVisitor2.visitVarInsn(25, 0);
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitVarInsn(25, 0);
        methodVisitor2.visitLdcInsn(Integer.valueOf(context2.getFieldOrinal(fieldInfo2.name)));
        String str = JavaBeanSerializer;
        StringBuilder sb = new StringBuilder();
        sb.append("(I)");
        Class<BeanContext> cls2 = BeanContext.class;
        sb.append(ASMUtils.desc((Class<?>) cls2));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getBeanContext", sb.toString());
        methodVisitor2.visitVarInsn(25, 2);
        methodVisitor2.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor2.visitVarInsn(21, context2.var("byte"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Short.TYPE) {
            methodVisitor2.visitVarInsn(21, context2.var("short"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Integer.TYPE) {
            methodVisitor2.visitVarInsn(21, context2.var("int"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Character.TYPE) {
            methodVisitor2.visitVarInsn(21, context2.var("char"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Long.TYPE) {
            methodVisitor2.visitVarInsn(22, context2.var("long", 2));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Float.TYPE) {
            methodVisitor2.visitVarInsn(23, context2.var("float"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Double.TYPE) {
            methodVisitor2.visitVarInsn(24, context2.var("double", 2));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Boolean.TYPE) {
            methodVisitor2.visitVarInsn(21, context2.var("boolean"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == BigDecimal.class) {
            methodVisitor2.visitVarInsn(25, context2.var("decimal"));
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(25, Context.original);
        } else if (cls == String.class) {
            methodVisitor2.visitVarInsn(25, context2.var("string"));
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(25, Context.original);
        } else if (cls.isEnum()) {
            methodVisitor2.visitVarInsn(25, context2.var("enum"));
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(25, Context.original);
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor2.visitVarInsn(25, context2.var("list"));
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(25, Context.original);
        } else {
            methodVisitor2.visitVarInsn(25, context2.var("object"));
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(25, Context.original);
        }
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "processValue", "(L" + JSONSerializer + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD + ASMUtils.desc((Class<?>) cls2) + "Ljava/lang/Object;Ljava/lang/String;" + "Ljava/lang/Object;" + ")Ljava/lang/Object;");
        methodVisitor2.visitVarInsn(58, Context.processValue);
        methodVisitor2.visitVarInsn(25, Context.original);
        methodVisitor2.visitVarInsn(25, Context.processValue);
        methodVisitor2.visitJumpInsn(Opcodes.IF_ACMPEQ, label2);
        _writeObject(methodVisitor, fieldInfo, context, label);
        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label);
        methodVisitor2.visitLabel(label2);
    }

    private void _seperator(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(16, 44);
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _string(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        if (fieldInfo.name.equals(context.beanInfo.typeKey)) {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 4);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label);
        }
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("string"));
        _filters(methodVisitor, fieldInfo, context, label);
        Label label2 = new Label();
        Label label3 = new Label();
        methodVisitor.visitVarInsn(25, context.var("string"));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label2);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label3);
        methodVisitor.visitLabel(label2);
        if ("trim".equals(fieldInfo.format)) {
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "trim", "()Ljava/lang/String;");
            methodVisitor.visitVarInsn(58, context.var("string"));
        }
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        }
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitLabel(label);
    }

    private void _writeFieldName(MethodVisitor methodVisitor, Context context) {
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldNameDirect", "(Ljava/lang/String;)V");
            return;
        }
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitInsn(3);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldName", "(Ljava/lang/String;Z)V");
    }

    private void _writeObject(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        String str;
        Label label2;
        Label label3;
        MethodVisitor methodVisitor2 = methodVisitor;
        FieldInfo fieldInfo2 = fieldInfo;
        Context context2 = context;
        String format = fieldInfo.getFormat();
        Class<?> cls = fieldInfo2.fieldClass;
        Label label4 = new Label();
        if (context.writeDirect) {
            methodVisitor2.visitVarInsn(25, context2.var("object"));
        } else {
            methodVisitor2.visitVarInsn(25, Context.processValue);
        }
        methodVisitor2.visitInsn(89);
        methodVisitor2.visitVarInsn(58, context2.var("object"));
        methodVisitor2.visitJumpInsn(Opcodes.IFNONNULL, label4);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor2.visitJumpInsn(Opcodes.GOTO, label);
        methodVisitor2.visitLabel(label4);
        methodVisitor2.visitVarInsn(25, context2.var("out"));
        methodVisitor2.visitVarInsn(21, context2.var("seperator"));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "write", "(I)V");
        _writeFieldName(methodVisitor2, context2);
        Label label5 = new Label();
        Label label6 = new Label();
        if (!Modifier.isPublic(cls.getModifiers()) || ParserConfig.isPrimitive2(cls)) {
            str = format;
            label2 = label5;
            label3 = label6;
        } else {
            methodVisitor2.visitVarInsn(25, context2.var("object"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
            methodVisitor2.visitJumpInsn(Opcodes.IF_ACMPNE, label6);
            _getFieldSer(context2, methodVisitor2, fieldInfo2);
            methodVisitor2.visitVarInsn(58, context2.var("fied_ser"));
            Label label7 = new Label();
            Label label8 = new Label();
            methodVisitor2.visitVarInsn(25, context2.var("fied_ser"));
            String str2 = JavaBeanSerializer;
            methodVisitor2.visitTypeInsn(Opcodes.INSTANCEOF, str2);
            methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label7);
            int i = fieldInfo2.serialzeFeatures;
            str = format;
            boolean z = (SerializerFeature.DisableCircularReferenceDetect.mask & i) != 0;
            boolean z2 = (SerializerFeature.BeanToArray.mask & i) != 0;
            String str3 = (z || (context.nonContext && context.writeDirect)) ? z2 ? "writeAsArrayNonContext" : "writeDirectNonContext" : z2 ? "writeAsArray" : "write";
            methodVisitor2.visitVarInsn(25, context2.var("fied_ser"));
            methodVisitor2.visitTypeInsn(192, str2);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context2.var("object"));
            methodVisitor2.visitVarInsn(25, Context.fieldName);
            methodVisitor2.visitVarInsn(25, 0);
            String access$300 = context.className;
            methodVisitor2.visitFieldInsn(180, access$300, fieldInfo2.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
            StringBuilder sb = new StringBuilder();
            sb.append("(L");
            String str4 = JSONSerializer;
            sb.append(str4);
            sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, str3, sb.toString());
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label8);
            methodVisitor2.visitLabel(label7);
            methodVisitor2.visitVarInsn(25, context2.var("fied_ser"));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context2.var("object"));
            methodVisitor2.visitVarInsn(25, Context.fieldName);
            methodVisitor2.visitVarInsn(25, 0);
            String access$3002 = context.className;
            methodVisitor2.visitFieldInsn(180, access$3002, fieldInfo2.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
            String str5 = ObjectSerializer;
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEINTERFACE, str5, "write", "(L" + str4 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitLabel(label8);
            label2 = label5;
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label2);
            label3 = label6;
        }
        methodVisitor2.visitLabel(label3);
        methodVisitor2.visitVarInsn(25, 1);
        if (context.writeDirect) {
            methodVisitor2.visitVarInsn(25, context2.var("object"));
        } else {
            methodVisitor2.visitVarInsn(25, Context.processValue);
        }
        if (str != null) {
            methodVisitor2.visitLdcInsn(str);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
            methodVisitor2.visitVarInsn(25, Context.fieldName);
            java.lang.reflect.Type type = fieldInfo2.fieldType;
            if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
                Class<String> cls2 = String.class;
                if (fieldInfo2.fieldClass == cls2) {
                    methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) cls2)));
                } else {
                    methodVisitor2.visitVarInsn(25, 0);
                    String access$3003 = context.className;
                    methodVisitor2.visitFieldInsn(180, access$3003, fieldInfo2.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                }
                methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            } else {
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            }
        }
        methodVisitor2.visitLabel(label2);
        _seperator(methodVisitor2, context2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v58, resolved type: java.lang.Class<java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v59, resolved type: java.lang.Class<java.lang.Object>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void generateWriteAsArray(java.lang.Class<?> r35, com.alibaba.fastjson.asm.MethodVisitor r36, com.alibaba.fastjson.util.FieldInfo[] r37, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context r38) throws java.lang.Exception {
        /*
            r34 = this;
            r0 = r34
            r1 = r36
            r2 = r37
            r3 = r38
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            r5 = 25
            r6 = 1
            r1.visitVarInsn(r5, r6)
            r7 = 0
            r1.visitVarInsn(r5, r7)
            java.lang.String r8 = JSONSerializer
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "("
            r9.append(r10)
            java.lang.String r10 = SerializeFilterable_desc
            r9.append(r10)
            java.lang.String r10 = ")Z"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r10 = 182(0xb6, float:2.55E-43)
            java.lang.String r11 = "hasPropertyFilters"
            r1.visitMethodInsn(r10, r8, r11, r9)
            r9 = 154(0x9a, float:2.16E-43)
            r1.visitJumpInsn(r9, r4)
            r1.visitVarInsn(r5, r7)
            r1.visitVarInsn(r5, r6)
            r9 = 2
            r1.visitVarInsn(r5, r9)
            r9 = 3
            r1.visitVarInsn(r5, r9)
            r9 = 4
            r1.visitVarInsn(r5, r9)
            r9 = 5
            r11 = 21
            r1.visitVarInsn(r11, r9)
            java.lang.String r9 = JavaBeanSerializer
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "(L"
            r12.append(r13)
            r12.append(r8)
            java.lang.String r8 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            r12.append(r8)
            java.lang.String r12 = r12.toString()
            r14 = 183(0xb7, float:2.56E-43)
            java.lang.String r15 = "writeNoneASM"
            r1.visitMethodInsn(r14, r9, r15, r12)
            r9 = 177(0xb1, float:2.48E-43)
            r1.visitInsn(r9)
            r1.visitLabel(r4)
            java.lang.String r4 = "out"
            int r9 = r3.var(r4)
            r1.visitVarInsn(r5, r9)
            r9 = 91
            r12 = 16
            r1.visitVarInsn(r12, r9)
            java.lang.String r9 = SerializeWriter
            java.lang.String r14 = "write"
            java.lang.String r15 = "(I)V"
            r1.visitMethodInsn(r10, r9, r14, r15)
            int r6 = r2.length
            if (r6 != 0) goto L_0x00a8
            int r0 = r3.var(r4)
            r1.visitVarInsn(r5, r0)
            r0 = 93
            r1.visitVarInsn(r12, r0)
            r1.visitMethodInsn(r10, r9, r14, r15)
            return
        L_0x00a8:
            r9 = r7
        L_0x00a9:
            if (r9 >= r6) goto L_0x08b4
            int r11 = r6 + -1
            if (r9 != r11) goto L_0x00b2
            r11 = 93
            goto L_0x00b4
        L_0x00b2:
            r11 = 44
        L_0x00b4:
            r7 = r2[r9]
            java.lang.Class<?> r12 = r7.fieldClass
            java.lang.String r10 = r7.name
            r1.visitLdcInsn(r10)
            int r10 = com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName
            r5 = 58
            r1.visitVarInsn(r5, r10)
            java.lang.Class r10 = java.lang.Byte.TYPE
            r5 = 89
            if (r12 == r10) goto L_0x00d2
            java.lang.Class r10 = java.lang.Short.TYPE
            if (r12 == r10) goto L_0x00d2
            java.lang.Class r10 = java.lang.Integer.TYPE
            if (r12 != r10) goto L_0x00e1
        L_0x00d2:
            r0 = r4
            r20 = r6
            r21 = r9
            r5 = r13
            r2 = r15
            r4 = 25
            r6 = 0
            r9 = 1
            r10 = 182(0xb6, float:2.55E-43)
            goto L_0x087f
        L_0x00e1:
            java.lang.Class r10 = java.lang.Long.TYPE
            if (r12 != r10) goto L_0x0118
            int r10 = r3.var(r4)
            r12 = 25
            r1.visitVarInsn(r12, r10)
            r1.visitInsn(r5)
            r0._get(r1, r3, r7)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeLong"
            java.lang.String r10 = "(J)V"
            r12 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r12, r5, r7, r10)
            r7 = 16
            r1.visitVarInsn(r7, r11)
            r1.visitMethodInsn(r12, r5, r14, r15)
        L_0x0107:
            r20 = r6
            r21 = r9
            r10 = r12
            r5 = r13
            r2 = r15
            r6 = 0
            r9 = 1
            r13 = 16
        L_0x0112:
            r12 = r0
            r0 = r4
            r4 = 25
            goto L_0x089f
        L_0x0118:
            java.lang.Class r10 = java.lang.Float.TYPE
            if (r12 != r10) goto L_0x0143
            int r10 = r3.var(r4)
            r12 = 25
            r1.visitVarInsn(r12, r10)
            r1.visitInsn(r5)
            r0._get(r1, r3, r7)
            r5 = 4
            r1.visitInsn(r5)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeFloat"
            java.lang.String r10 = "(FZ)V"
            r12 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r12, r5, r7, r10)
            r7 = 16
            r1.visitVarInsn(r7, r11)
            r1.visitMethodInsn(r12, r5, r14, r15)
            goto L_0x0107
        L_0x0143:
            java.lang.Class r10 = java.lang.Double.TYPE
            if (r12 != r10) goto L_0x016e
            int r10 = r3.var(r4)
            r12 = 25
            r1.visitVarInsn(r12, r10)
            r1.visitInsn(r5)
            r0._get(r1, r3, r7)
            r5 = 4
            r1.visitInsn(r5)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeDouble"
            java.lang.String r10 = "(DZ)V"
            r12 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r12, r5, r7, r10)
            r7 = 16
            r1.visitVarInsn(r7, r11)
            r1.visitMethodInsn(r12, r5, r14, r15)
            goto L_0x0107
        L_0x016e:
            java.lang.Class r10 = java.lang.Boolean.TYPE
            if (r12 != r10) goto L_0x01a2
            int r10 = r3.var(r4)
            r12 = 25
            r1.visitVarInsn(r12, r10)
            r1.visitInsn(r5)
            r0._get(r1, r3, r7)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "(Z)V"
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r5, r14, r7)
            r7 = 16
            r1.visitVarInsn(r7, r11)
            r1.visitMethodInsn(r10, r5, r14, r15)
        L_0x0192:
            r12 = r0
            r0 = r4
            r20 = r6
            r21 = r9
            r5 = r13
            r2 = r15
        L_0x019a:
            r4 = 25
            r6 = 0
            r9 = 1
        L_0x019e:
            r13 = 16
            goto L_0x089f
        L_0x01a2:
            java.lang.Class r10 = java.lang.Character.TYPE
            r5 = 184(0xb8, float:2.58E-43)
            if (r12 != r10) goto L_0x01d9
            int r10 = r3.var(r4)
            r12 = 25
            r1.visitVarInsn(r12, r10)
            r0._get(r1, r3, r7)
            java.lang.String r7 = "toString"
            java.lang.String r10 = "(C)Ljava/lang/String;"
            java.lang.String r12 = "java/lang/Character"
            r1.visitMethodInsn(r5, r12, r7, r10)
            r10 = 16
            r1.visitVarInsn(r10, r11)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeString"
            java.lang.String r11 = "(Ljava/lang/String;C)V"
            r12 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r12, r5, r7, r11)
            r20 = r6
            r21 = r9
            r5 = r13
            r2 = r15
            r6 = 0
            r9 = 1
            r13 = r10
            r10 = r12
            goto L_0x0112
        L_0x01d9:
            r10 = 16
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            if (r12 != r5) goto L_0x020c
            int r5 = r3.var(r4)
            r12 = 25
            r1.visitVarInsn(r12, r5)
            r0._get(r1, r3, r7)
            r1.visitVarInsn(r10, r11)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeString"
            java.lang.String r10 = "(Ljava/lang/String;C)V"
            r11 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r11, r5, r7, r10)
            r20 = r6
            r21 = r9
            r10 = r11
            r5 = r13
            r2 = r15
            r6 = 0
            r9 = 1
            r13 = 16
            r33 = r12
            r12 = r0
            r0 = r4
            r4 = r33
            goto L_0x089f
        L_0x020c:
            r5 = 25
            r10 = 182(0xb6, float:2.55E-43)
            boolean r16 = r12.isEnum()
            if (r16 == 0) goto L_0x0238
            int r12 = r3.var(r4)
            r1.visitVarInsn(r5, r12)
            r5 = 89
            r1.visitInsn(r5)
            r0._get(r1, r3, r7)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeEnum"
            java.lang.String r12 = "(Ljava/lang/Enum;)V"
            r1.visitMethodInsn(r10, r5, r7, r12)
            r7 = 16
            r1.visitVarInsn(r7, r11)
            r1.visitMethodInsn(r10, r5, r14, r15)
            goto L_0x0192
        L_0x0238:
            java.lang.Class<java.util.List> r5 = java.util.List.class
            boolean r5 = r5.isAssignableFrom(r12)
            java.lang.String r10 = "writeWithFieldName"
            if (r5 == 0) goto L_0x060a
            java.lang.reflect.Type r5 = r7.fieldType
            boolean r12 = r5 instanceof java.lang.Class
            if (r12 == 0) goto L_0x024b
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            goto L_0x0254
        L_0x024b:
            java.lang.reflect.ParameterizedType r5 = (java.lang.reflect.ParameterizedType) r5
            java.lang.reflect.Type[] r5 = r5.getActualTypeArguments()
            r12 = 0
            r5 = r5[r12]
        L_0x0254:
            boolean r12 = r5 instanceof java.lang.Class
            if (r12 == 0) goto L_0x025f
            r12 = r5
            java.lang.Class r12 = (java.lang.Class) r12
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            if (r12 != r2) goto L_0x0260
        L_0x025f:
            r12 = 0
        L_0x0260:
            r0._get(r1, r3, r7)
            r2 = 192(0xc0, float:2.69E-43)
            r20 = r6
            java.lang.String r6 = "java/util/List"
            r1.visitTypeInsn(r2, r6)
            java.lang.String r2 = "list"
            int r6 = r3.var(r2)
            r21 = r9
            r9 = 58
            r1.visitVarInsn(r9, r6)
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            if (r12 != r6) goto L_0x02aa
            boolean r6 = r38.writeDirect
            if (r6 == 0) goto L_0x02aa
            int r5 = r3.var(r4)
            r6 = 25
            r1.visitVarInsn(r6, r5)
            int r2 = r3.var(r2)
            r1.visitVarInsn(r6, r2)
            java.lang.String r2 = SerializeWriter
            java.lang.String r5 = "(Ljava/util/List;)V"
            r6 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r6, r2, r14, r5)
            r0 = r4
            r4 = r6
            r22 = r11
            r5 = r13
            r9 = r15
            r2 = 21
            r6 = 25
            r7 = 16
            goto L_0x05f3
        L_0x02aa:
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            com.alibaba.fastjson.asm.Label r9 = new com.alibaba.fastjson.asm.Label
            r9.<init>()
            r22 = r11
            int r11 = r3.var(r2)
            r23 = r10
            r10 = 25
            r1.visitVarInsn(r10, r11)
            r11 = 199(0xc7, float:2.79E-43)
            r1.visitJumpInsn(r11, r9)
            int r11 = r3.var(r4)
            r1.visitVarInsn(r10, r11)
            java.lang.String r11 = SerializeWriter
            java.lang.String r10 = "writeNull"
            r18 = r5
            java.lang.String r5 = "()V"
            r24 = r8
            r8 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r8, r11, r10, r5)
            r5 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r5, r6)
            r1.visitLabel(r9)
            int r5 = r3.var(r2)
            r8 = 25
            r1.visitVarInsn(r8, r5)
            java.lang.String r5 = "size"
            java.lang.String r9 = "()I"
            java.lang.String r10 = "java/util/List"
            r8 = 185(0xb9, float:2.59E-43)
            r1.visitMethodInsn(r8, r10, r5, r9)
            java.lang.String r5 = "size"
            int r5 = r3.var(r5)
            r8 = 54
            r1.visitVarInsn(r8, r5)
            int r5 = r3.var(r4)
            r8 = 25
            r1.visitVarInsn(r8, r5)
            r5 = 91
            r8 = 16
            r1.visitVarInsn(r8, r5)
            r5 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r5, r11, r14, r15)
            com.alibaba.fastjson.asm.Label r5 = new com.alibaba.fastjson.asm.Label
            r5.<init>()
            com.alibaba.fastjson.asm.Label r8 = new com.alibaba.fastjson.asm.Label
            r8.<init>()
            com.alibaba.fastjson.asm.Label r9 = new com.alibaba.fastjson.asm.Label
            r9.<init>()
            r10 = 3
            r1.visitInsn(r10)
            r10 = 54
            r25 = r6
            java.lang.String r6 = "i"
            r26 = r13
            int r13 = r3.var(r6)
            r1.visitVarInsn(r10, r13)
            r1.visitLabel(r5)
            int r10 = r3.var(r6)
            r13 = 21
            r1.visitVarInsn(r13, r10)
            java.lang.String r10 = "size"
            int r10 = r3.var(r10)
            r1.visitVarInsn(r13, r10)
            r10 = 162(0xa2, float:2.27E-43)
            r1.visitJumpInsn(r10, r9)
            int r10 = r3.var(r6)
            r1.visitVarInsn(r13, r10)
            r10 = 153(0x99, float:2.14E-43)
            r1.visitJumpInsn(r10, r8)
            int r10 = r3.var(r4)
            r13 = 25
            r1.visitVarInsn(r13, r10)
            r10 = 44
            r13 = 16
            r1.visitVarInsn(r13, r10)
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r11, r14, r15)
            r1.visitLabel(r8)
            int r2 = r3.var(r2)
            r8 = 25
            r1.visitVarInsn(r8, r2)
            int r2 = r3.var(r6)
            r8 = 21
            r1.visitVarInsn(r8, r2)
            java.lang.String r2 = "get"
            java.lang.String r8 = "(I)Ljava/lang/Object;"
            java.lang.String r10 = "java/util/List"
            r13 = 185(0xb9, float:2.59E-43)
            r1.visitMethodInsn(r13, r10, r2, r8)
            java.lang.String r2 = "list_item"
            int r8 = r3.var(r2)
            r10 = 58
            r1.visitVarInsn(r10, r8)
            com.alibaba.fastjson.asm.Label r8 = new com.alibaba.fastjson.asm.Label
            r8.<init>()
            com.alibaba.fastjson.asm.Label r10 = new com.alibaba.fastjson.asm.Label
            r10.<init>()
            int r13 = r3.var(r2)
            r27 = r15
            r15 = 25
            r1.visitVarInsn(r15, r13)
            r13 = 199(0xc7, float:2.79E-43)
            r1.visitJumpInsn(r13, r10)
            int r13 = r3.var(r4)
            r1.visitVarInsn(r15, r13)
            java.lang.String r13 = "writeNull"
            java.lang.String r15 = "()V"
            r28 = r4
            r4 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r4, r11, r13, r15)
            r4 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r4, r8)
            r1.visitLabel(r10)
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            com.alibaba.fastjson.asm.Label r10 = new com.alibaba.fastjson.asm.Label
            r10.<init>()
            if (r12 == 0) goto L_0x053f
            int r13 = r12.getModifiers()
            boolean r13 = java.lang.reflect.Modifier.isPublic(r13)
            if (r13 == 0) goto L_0x053f
            int r13 = r3.var(r2)
            r15 = 25
            r1.visitVarInsn(r15, r13)
            java.lang.String r13 = "getClass"
            java.lang.String r15 = "()Ljava/lang/Class;"
            r29 = r11
            java.lang.String r11 = "java/lang/Object"
            r30 = r9
            r9 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r9, r11, r13, r15)
            java.lang.String r9 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r12)
            com.alibaba.fastjson.asm.Type r9 = com.alibaba.fastjson.asm.Type.getType(r9)
            r1.visitLdcInsn(r9)
            r9 = 166(0xa6, float:2.33E-43)
            r1.visitJumpInsn(r9, r10)
            r0._getListFieldItemSer(r3, r1, r7, r12)
            java.lang.String r9 = "list_item_desc"
            int r11 = r3.var(r9)
            r13 = 58
            r1.visitVarInsn(r13, r11)
            com.alibaba.fastjson.asm.Label r11 = new com.alibaba.fastjson.asm.Label
            r11.<init>()
            com.alibaba.fastjson.asm.Label r13 = new com.alibaba.fastjson.asm.Label
            r13.<init>()
            boolean r15 = r38.writeDirect
            if (r15 == 0) goto L_0x04c5
            int r15 = r3.var(r9)
            r0 = 25
            r1.visitVarInsn(r0, r15)
            java.lang.String r15 = JavaBeanSerializer
            r0 = 193(0xc1, float:2.7E-43)
            r1.visitTypeInsn(r0, r15)
            r0 = 153(0x99, float:2.14E-43)
            r1.visitJumpInsn(r0, r11)
            int r0 = r3.var(r9)
            r17 = r5
            r5 = 25
            r1.visitVarInsn(r5, r0)
            r0 = 192(0xc0, float:2.69E-43)
            r1.visitTypeInsn(r0, r15)
            r0 = 1
            r1.visitVarInsn(r5, r0)
            int r0 = r3.var(r2)
            r1.visitVarInsn(r5, r0)
            boolean r0 = r38.nonContext
            if (r0 == 0) goto L_0x046f
            r0 = 1
            r1.visitInsn(r0)
            r31 = r8
            r32 = r10
            goto L_0x0487
        L_0x046f:
            int r0 = r3.var(r6)
            r5 = 21
            r1.visitVarInsn(r5, r0)
            java.lang.String r0 = "valueOf"
            java.lang.String r5 = "(I)Ljava/lang/Integer;"
            r31 = r8
            java.lang.String r8 = "java/lang/Integer"
            r32 = r10
            r10 = 184(0xb8, float:2.58E-43)
            r1.visitMethodInsn(r10, r8, r0, r5)
        L_0x0487:
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r12)
            com.alibaba.fastjson.asm.Type r0 = com.alibaba.fastjson.asm.Type.getType(r0)
            r1.visitLdcInsn(r0)
            int r0 = r7.serialzeFeatures
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.visitLdcInsn(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r5 = r26
            r0.append(r5)
            java.lang.String r8 = JSONSerializer
            r0.append(r8)
            r8 = r24
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.lang.String r10 = "writeAsArrayNonContext"
            r24 = r4
            r4 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r4, r15, r10, r0)
            r0 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r0, r13)
            r1.visitLabel(r11)
            goto L_0x04d1
        L_0x04c5:
            r17 = r5
            r31 = r8
            r32 = r10
            r8 = r24
            r5 = r26
            r24 = r4
        L_0x04d1:
            int r0 = r3.var(r9)
            r4 = 25
            r1.visitVarInsn(r4, r0)
            r0 = 1
            r1.visitVarInsn(r4, r0)
            int r9 = r3.var(r2)
            r1.visitVarInsn(r4, r9)
            boolean r4 = r38.nonContext
            if (r4 == 0) goto L_0x04ef
            r1.visitInsn(r0)
            goto L_0x0503
        L_0x04ef:
            int r0 = r3.var(r6)
            r4 = 21
            r1.visitVarInsn(r4, r0)
            java.lang.String r0 = "valueOf"
            java.lang.String r4 = "(I)Ljava/lang/Integer;"
            java.lang.String r9 = "java/lang/Integer"
            r10 = 184(0xb8, float:2.58E-43)
            r1.visitMethodInsn(r10, r9, r0, r4)
        L_0x0503:
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r12)
            com.alibaba.fastjson.asm.Type r0 = com.alibaba.fastjson.asm.Type.getType(r0)
            r1.visitLdcInsn(r0)
            int r0 = r7.serialzeFeatures
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.visitLdcInsn(r0)
            java.lang.String r0 = ObjectSerializer
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r5)
            java.lang.String r9 = JSONSerializer
            r4.append(r9)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            r9 = 185(0xb9, float:2.59E-43)
            r1.visitMethodInsn(r9, r0, r14, r4)
            r1.visitLabel(r13)
            r4 = r24
            r0 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r0, r4)
            r0 = r32
            goto L_0x054c
        L_0x053f:
            r17 = r5
            r31 = r8
            r30 = r9
            r29 = r11
            r8 = r24
            r5 = r26
            r0 = r10
        L_0x054c:
            r1.visitLabel(r0)
            r0 = 25
            r9 = 1
            r1.visitVarInsn(r0, r9)
            int r2 = r3.var(r2)
            r1.visitVarInsn(r0, r2)
            boolean r0 = r38.nonContext
            if (r0 == 0) goto L_0x0568
            r1.visitInsn(r9)
            r2 = 21
            goto L_0x057c
        L_0x0568:
            int r0 = r3.var(r6)
            r2 = 21
            r1.visitVarInsn(r2, r0)
            java.lang.String r0 = "valueOf"
            java.lang.String r9 = "(I)Ljava/lang/Integer;"
            java.lang.String r10 = "java/lang/Integer"
            r11 = 184(0xb8, float:2.58E-43)
            r1.visitMethodInsn(r11, r10, r0, r9)
        L_0x057c:
            if (r12 == 0) goto L_0x05ac
            int r0 = r12.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isPublic(r0)
            if (r0 == 0) goto L_0x05ac
            r0 = r18
            java.lang.Class r0 = (java.lang.Class) r0
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r0)
            com.alibaba.fastjson.asm.Type r0 = com.alibaba.fastjson.asm.Type.getType(r0)
            r1.visitLdcInsn(r0)
            int r0 = r7.serialzeFeatures
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.visitLdcInsn(r0)
            java.lang.String r0 = JSONSerializer
            java.lang.String r7 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            r10 = r23
            r9 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r9, r0, r10, r7)
            goto L_0x05b7
        L_0x05ac:
            r10 = r23
            r9 = 182(0xb6, float:2.55E-43)
            java.lang.String r0 = JSONSerializer
            java.lang.String r7 = "(Ljava/lang/Object;Ljava/lang/Object;)V"
            r1.visitMethodInsn(r9, r0, r10, r7)
        L_0x05b7:
            r1.visitLabel(r4)
            r0 = r31
            r1.visitLabel(r0)
            int r0 = r3.var(r6)
            r4 = 1
            r1.visitIincInsn(r0, r4)
            r4 = r17
            r0 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r0, r4)
            r0 = r30
            r1.visitLabel(r0)
            r0 = r28
            int r4 = r3.var(r0)
            r6 = 25
            r1.visitVarInsn(r6, r4)
            r4 = 93
            r7 = 16
            r1.visitVarInsn(r7, r4)
            r9 = r27
            r10 = r29
            r4 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r4, r10, r14, r9)
            r10 = r25
            r1.visitLabel(r10)
        L_0x05f3:
            int r10 = r3.var(r0)
            r1.visitVarInsn(r6, r10)
            r11 = r22
            r1.visitVarInsn(r7, r11)
            java.lang.String r6 = SerializeWriter
            r1.visitMethodInsn(r4, r6, r14, r9)
            r12 = r34
            r10 = r4
            r2 = r9
            goto L_0x019a
        L_0x060a:
            r0 = r4
            r20 = r6
            r21 = r9
            r5 = r13
            r9 = r15
            r2 = 21
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            r13 = r34
            r13._get(r1, r3, r7)
            r15 = 89
            r1.visitInsn(r15)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r2 = "field_"
            r15.append(r2)
            r27 = r9
            java.lang.Class<?> r9 = r7.fieldClass
            java.lang.String r9 = r9.getName()
            r15.append(r9)
            java.lang.String r9 = r15.toString()
            int r9 = r3.var(r9)
            r15 = 58
            r1.visitVarInsn(r15, r9)
            r9 = 199(0xc7, float:2.79E-43)
            r1.visitJumpInsn(r9, r6)
            int r9 = r3.var(r0)
            r15 = 25
            r1.visitVarInsn(r15, r9)
            java.lang.String r9 = SerializeWriter
            java.lang.String r15 = "writeNull"
            r22 = r11
            java.lang.String r11 = "()V"
            r28 = r0
            r0 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r0, r9, r15, r11)
            r0 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r0, r4)
            r1.visitLabel(r6)
            com.alibaba.fastjson.asm.Label r0 = new com.alibaba.fastjson.asm.Label
            r0.<init>()
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r2)
            java.lang.Class<?> r15 = r7.fieldClass
            java.lang.String r15 = r15.getName()
            r11.append(r15)
            java.lang.String r11 = r11.toString()
            int r11 = r3.var(r11)
            r15 = 25
            r1.visitVarInsn(r15, r11)
            java.lang.String r11 = "getClass"
            java.lang.String r15 = "()Ljava/lang/Class;"
            r18 = r9
            java.lang.String r9 = "java/lang/Object"
            r19 = r4
            r4 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r4, r9, r11, r15)
            java.lang.String r4 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r12)
            com.alibaba.fastjson.asm.Type r4 = com.alibaba.fastjson.asm.Type.getType(r4)
            r1.visitLdcInsn(r4)
            r4 = 166(0xa6, float:2.33E-43)
            r1.visitJumpInsn(r4, r6)
            r13._getFieldSer(r3, r1, r7)
            java.lang.String r4 = "fied_ser"
            int r4 = r3.var(r4)
            r9 = 58
            r1.visitVarInsn(r9, r4)
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            com.alibaba.fastjson.asm.Label r9 = new com.alibaba.fastjson.asm.Label
            r9.<init>()
            boolean r11 = r38.writeDirect
            if (r11 == 0) goto L_0x0765
            int r11 = r12.getModifiers()
            boolean r11 = java.lang.reflect.Modifier.isPublic(r11)
            if (r11 == 0) goto L_0x0765
            java.lang.String r11 = "fied_ser"
            int r11 = r3.var(r11)
            r15 = 25
            r1.visitVarInsn(r15, r11)
            java.lang.String r11 = JavaBeanSerializer
            r15 = 193(0xc1, float:2.7E-43)
            r1.visitTypeInsn(r15, r11)
            r15 = 153(0x99, float:2.14E-43)
            r1.visitJumpInsn(r15, r4)
            java.lang.String r15 = "fied_ser"
            int r15 = r3.var(r15)
            r13 = 25
            r1.visitVarInsn(r13, r15)
            r15 = 192(0xc0, float:2.69E-43)
            r1.visitTypeInsn(r15, r11)
            r15 = 1
            r1.visitVarInsn(r13, r15)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r2)
            java.lang.Class<?> r13 = r7.fieldClass
            java.lang.String r13 = r13.getName()
            r15.append(r13)
            java.lang.String r13 = r15.toString()
            int r13 = r3.var(r13)
            r15 = 25
            r1.visitVarInsn(r15, r13)
            int r13 = com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName
            r1.visitVarInsn(r15, r13)
            java.lang.String r13 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r12)
            com.alibaba.fastjson.asm.Type r13 = com.alibaba.fastjson.asm.Type.getType(r13)
            r1.visitLdcInsn(r13)
            int r13 = r7.serialzeFeatures
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r1.visitLdcInsn(r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r5)
            java.lang.String r15 = JSONSerializer
            r13.append(r15)
            r13.append(r8)
            java.lang.String r13 = r13.toString()
            java.lang.String r15 = "writeAsArrayNonContext"
            r23 = r10
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r11, r15, r13)
            r10 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r10, r9)
            r1.visitLabel(r4)
            goto L_0x0767
        L_0x0765:
            r23 = r10
        L_0x0767:
            java.lang.String r4 = "fied_ser"
            int r4 = r3.var(r4)
            r10 = 25
            r1.visitVarInsn(r10, r4)
            r4 = 1
            r1.visitVarInsn(r10, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.Class<?> r11 = r7.fieldClass
            java.lang.String r11 = r11.getName()
            r4.append(r11)
            java.lang.String r4 = r4.toString()
            int r4 = r3.var(r4)
            r1.visitVarInsn(r10, r4)
            int r4 = com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName
            r1.visitVarInsn(r10, r4)
            java.lang.String r4 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r12)
            com.alibaba.fastjson.asm.Type r4 = com.alibaba.fastjson.asm.Type.getType(r4)
            r1.visitLdcInsn(r4)
            int r4 = r7.serialzeFeatures
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.visitLdcInsn(r4)
            java.lang.String r4 = ObjectSerializer
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r5)
            java.lang.String r11 = JSONSerializer
            r10.append(r11)
            r10.append(r8)
            java.lang.String r10 = r10.toString()
            r12 = 185(0xb9, float:2.59E-43)
            r1.visitMethodInsn(r12, r4, r14, r10)
            r1.visitLabel(r9)
            r4 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r4, r0)
            r1.visitLabel(r6)
            java.lang.String r4 = r7.getFormat()
            r6 = 25
            r9 = 1
            r1.visitVarInsn(r6, r9)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r2)
            java.lang.Class<?> r2 = r7.fieldClass
            java.lang.String r2 = r2.getName()
            r10.append(r2)
            java.lang.String r2 = r10.toString()
            int r2 = r3.var(r2)
            r1.visitVarInsn(r6, r2)
            if (r4 == 0) goto L_0x0807
            r1.visitLdcInsn(r4)
            java.lang.String r2 = "writeWithFormat"
            java.lang.String r4 = "(Ljava/lang/Object;Ljava/lang/String;)V"
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r11, r2, r4)
        L_0x0805:
            r6 = 0
            goto L_0x085a
        L_0x0807:
            r10 = 182(0xb6, float:2.55E-43)
            int r2 = com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName
            r1.visitVarInsn(r6, r2)
            java.lang.reflect.Type r2 = r7.fieldType
            boolean r4 = r2 instanceof java.lang.Class
            if (r4 == 0) goto L_0x0824
            java.lang.Class r2 = (java.lang.Class) r2
            boolean r2 = r2.isPrimitive()
            if (r2 == 0) goto L_0x0824
            java.lang.String r2 = "(Ljava/lang/Object;Ljava/lang/Object;)V"
            r4 = r23
            r1.visitMethodInsn(r10, r11, r4, r2)
            goto L_0x0805
        L_0x0824:
            r4 = r23
            r2 = 25
            r6 = 0
            r1.visitVarInsn(r2, r6)
            java.lang.String r2 = r38.className
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = r7.name
            r10.append(r12)
            java.lang.String r12 = "_asm_fieldType"
            r10.append(r12)
            java.lang.String r10 = r10.toString()
            java.lang.String r12 = "Ljava/lang/reflect/Type;"
            r13 = 180(0xb4, float:2.52E-43)
            r1.visitFieldInsn(r13, r2, r10, r12)
            int r2 = r7.serialzeFeatures
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.visitLdcInsn(r2)
            java.lang.String r2 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r11, r4, r2)
        L_0x085a:
            r1.visitLabel(r0)
            r0 = r19
            r1.visitLabel(r0)
            r0 = r28
            int r2 = r3.var(r0)
            r4 = 25
            r1.visitVarInsn(r4, r2)
            r11 = r22
            r2 = 16
            r1.visitVarInsn(r2, r11)
            r7 = r18
            r2 = r27
            r1.visitMethodInsn(r10, r7, r14, r2)
            r12 = r34
            goto L_0x019e
        L_0x087f:
            int r12 = r3.var(r0)
            r1.visitVarInsn(r4, r12)
            r12 = 89
            r1.visitInsn(r12)
            r12 = r34
            r12._get(r1, r3, r7)
            java.lang.String r7 = SerializeWriter
            java.lang.String r13 = "writeInt"
            r1.visitMethodInsn(r10, r7, r13, r2)
            r13 = 16
            r1.visitVarInsn(r13, r11)
            r1.visitMethodInsn(r10, r7, r14, r2)
        L_0x089f:
            int r7 = r21 + 1
            r15 = r2
            r9 = r7
            r11 = 21
            r2 = r37
            r7 = r6
            r6 = r20
            r33 = r4
            r4 = r0
            r0 = r12
            r12 = r13
            r13 = r5
            r5 = r33
            goto L_0x00a9
        L_0x08b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ASMSerializerFactory.generateWriteAsArray(java.lang.Class, com.alibaba.fastjson.asm.MethodVisitor, com.alibaba.fastjson.util.FieldInfo[], com.alibaba.fastjson.serializer.ASMSerializerFactory$Context):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x03d2  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x04a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void generateWriteMethod(java.lang.Class<?> r24, com.alibaba.fastjson.asm.MethodVisitor r25, com.alibaba.fastjson.util.FieldInfo[] r26, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context r27) throws java.lang.Exception {
        /*
            r23 = this;
            r7 = r23
            r8 = r24
            r9 = r25
            r10 = r26
            r11 = r27
            com.alibaba.fastjson.asm.Label r12 = new com.alibaba.fastjson.asm.Label
            r12.<init>()
            int r13 = r10.length
            boolean r0 = r27.writeDirect
            java.lang.String r1 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            java.lang.String r2 = "(I)Z"
            java.lang.String r3 = "isEnabled"
            java.lang.String r14 = "write"
            java.lang.String r4 = "(L"
            java.lang.String r5 = "out"
            r15 = 25
            if (r0 != 0) goto L_0x00ce
            com.alibaba.fastjson.asm.Label r0 = new com.alibaba.fastjson.asm.Label
            r0.<init>()
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            r19 = r12
            int r12 = r11.var(r5)
            r9.visitVarInsn(r15, r12)
            com.alibaba.fastjson.serializer.SerializerFeature r12 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat
            int r12 = r12.mask
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r9.visitLdcInsn(r12)
            java.lang.String r12 = SerializeWriter
            r15 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r15, r12, r3, r2)
            r12 = 154(0x9a, float:2.16E-43)
            r9.visitJumpInsn(r12, r6)
            int r12 = r10.length
            r15 = 0
            r20 = 0
        L_0x0052:
            if (r15 >= r12) goto L_0x0063
            r21 = r12
            r12 = r10[r15]
            java.lang.reflect.Method r12 = r12.method
            if (r12 == 0) goto L_0x005e
            r20 = 1
        L_0x005e:
            int r15 = r15 + 1
            r12 = r21
            goto L_0x0052
        L_0x0063:
            if (r20 == 0) goto L_0x0086
            int r12 = r11.var(r5)
            r15 = 25
            r9.visitVarInsn(r15, r12)
            com.alibaba.fastjson.serializer.SerializerFeature r12 = com.alibaba.fastjson.serializer.SerializerFeature.IgnoreErrorGetter
            int r12 = r12.mask
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r9.visitLdcInsn(r12)
            java.lang.String r12 = SerializeWriter
            r15 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r15, r12, r3, r2)
            r12 = 153(0x99, float:2.14E-43)
            r9.visitJumpInsn(r12, r0)
            goto L_0x008b
        L_0x0086:
            r12 = 167(0xa7, float:2.34E-43)
            r9.visitJumpInsn(r12, r0)
        L_0x008b:
            r9.visitLabel(r6)
            r6 = 0
            r12 = 25
            r9.visitVarInsn(r12, r6)
            r6 = 1
            r9.visitVarInsn(r12, r6)
            r6 = 2
            r9.visitVarInsn(r12, r6)
            r6 = 3
            r9.visitVarInsn(r12, r6)
            r6 = 4
            r9.visitVarInsn(r12, r6)
            r6 = 5
            r12 = 21
            r9.visitVarInsn(r12, r6)
            java.lang.String r6 = JavaBeanSerializer
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r4)
            java.lang.String r15 = JSONSerializer
            r12.append(r15)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            r15 = 183(0xb7, float:2.56E-43)
            r9.visitMethodInsn(r15, r6, r14, r12)
            r6 = 177(0xb1, float:2.48E-43)
            r9.visitInsn(r6)
            r9.visitLabel(r0)
            goto L_0x00d0
        L_0x00ce:
            r19 = r12
        L_0x00d0:
            boolean r0 = r27.nonContext
            if (r0 != 0) goto L_0x011b
            com.alibaba.fastjson.asm.Label r0 = new com.alibaba.fastjson.asm.Label
            r0.<init>()
            r6 = 0
            r12 = 25
            r9.visitVarInsn(r12, r6)
            r6 = 1
            r9.visitVarInsn(r12, r6)
            r6 = 2
            r9.visitVarInsn(r12, r6)
            r6 = 5
            r12 = 21
            r9.visitVarInsn(r12, r6)
            java.lang.String r6 = JavaBeanSerializer
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r4)
            java.lang.String r15 = JSONSerializer
            r12.append(r15)
            java.lang.String r15 = ";Ljava/lang/Object;I)Z"
            r12.append(r15)
            java.lang.String r12 = r12.toString()
            java.lang.String r15 = "writeReference"
            r8 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r8, r6, r15, r12)
            r6 = 153(0x99, float:2.14E-43)
            r9.visitJumpInsn(r6, r0)
            r6 = 177(0xb1, float:2.48E-43)
            r9.visitInsn(r6)
            r9.visitLabel(r0)
        L_0x011b:
            boolean r0 = r27.writeDirect
            if (r0 == 0) goto L_0x012d
            boolean r0 = r27.nonContext
            if (r0 == 0) goto L_0x012a
            java.lang.String r0 = "writeAsArrayNonContext"
            goto L_0x012f
        L_0x012a:
            java.lang.String r0 = "writeAsArray"
            goto L_0x012f
        L_0x012d:
            java.lang.String r0 = "writeAsArrayNormal"
        L_0x012f:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r6 = r27.beanInfo
            int r6 = r6.features
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.BeanToArray
            int r12 = r8.mask
            r6 = r6 & r12
            if (r6 != 0) goto L_0x01a1
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            int r12 = r11.var(r5)
            r15 = 25
            r9.visitVarInsn(r15, r12)
            int r8 = r8.mask
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9.visitLdcInsn(r8)
            java.lang.String r8 = SerializeWriter
            r12 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r12, r8, r3, r2)
            r2 = 153(0x99, float:2.14E-43)
            r9.visitJumpInsn(r2, r6)
            r2 = 0
            r9.visitVarInsn(r15, r2)
            r2 = 1
            r9.visitVarInsn(r15, r2)
            r2 = 2
            r9.visitVarInsn(r15, r2)
            r2 = 3
            r9.visitVarInsn(r15, r2)
            r2 = 4
            r9.visitVarInsn(r15, r2)
            r2 = 5
            r3 = 21
            r9.visitVarInsn(r3, r2)
            java.lang.String r2 = r27.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            java.lang.String r8 = JSONSerializer
            r3.append(r8)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r3 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r3, r2, r0, r1)
            r0 = 177(0xb1, float:2.48E-43)
            r9.visitInsn(r0)
            r9.visitLabel(r6)
            r6 = 21
            goto L_0x01df
        L_0x01a1:
            r2 = 0
            r3 = 25
            r9.visitVarInsn(r3, r2)
            r2 = 1
            r9.visitVarInsn(r3, r2)
            r2 = 2
            r9.visitVarInsn(r3, r2)
            r2 = 3
            r9.visitVarInsn(r3, r2)
            r2 = 4
            r9.visitVarInsn(r3, r2)
            r2 = 5
            r6 = 21
            r9.visitVarInsn(r6, r2)
            java.lang.String r2 = r27.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            java.lang.String r8 = JSONSerializer
            r3.append(r8)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r3 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r3, r2, r0, r1)
            r0 = 177(0xb1, float:2.48E-43)
            r9.visitInsn(r0)
        L_0x01df:
            boolean r0 = r27.nonContext
            java.lang.String r8 = "parent"
            java.lang.String r12 = "("
            if (r0 != 0) goto L_0x0251
            r0 = 1
            r1 = 25
            r9.visitVarInsn(r1, r0)
            java.lang.String r0 = JSONSerializer
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "()"
            r1.append(r2)
            java.lang.String r2 = SerialContext_desc
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "getContext"
            r15 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r15, r0, r3, r1)
            int r1 = r11.var(r8)
            r3 = 58
            r9.visitVarInsn(r3, r1)
            r1 = 1
            r3 = 25
            r9.visitVarInsn(r3, r1)
            int r1 = r11.var(r8)
            r9.visitVarInsn(r3, r1)
            r1 = 2
            r9.visitVarInsn(r3, r1)
            r1 = 3
            r9.visitVarInsn(r3, r1)
            com.alibaba.fastjson.serializer.SerializeBeanInfo r1 = r27.beanInfo
            int r1 = r1.features
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r9.visitLdcInsn(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r12)
            r1.append(r2)
            java.lang.String r2 = "Ljava/lang/Object;Ljava/lang/Object;I)V"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "setContext"
            r3 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r3, r0, r2, r1)
        L_0x0251:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r0 = r27.beanInfo
            int r0 = r0.features
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName
            int r1 = r1.mask
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0260
            r0 = 1
            goto L_0x0261
        L_0x0260:
            r0 = 0
        L_0x0261:
            r15 = 123(0x7b, float:1.72E-43)
            r3 = 16
            if (r0 != 0) goto L_0x0275
            boolean r1 = r27.writeDirect
            if (r1 != 0) goto L_0x026e
            goto L_0x0275
        L_0x026e:
            r9.visitVarInsn(r3, r15)
            r18 = r8
            goto L_0x0336
        L_0x0275:
            com.alibaba.fastjson.asm.Label r1 = new com.alibaba.fastjson.asm.Label
            r1.<init>()
            com.alibaba.fastjson.asm.Label r2 = new com.alibaba.fastjson.asm.Label
            r2.<init>()
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            if (r0 != 0) goto L_0x02aa
            r0 = 1
            r3 = 25
            r9.visitVarInsn(r3, r0)
            r0 = 4
            r9.visitVarInsn(r3, r0)
            r15 = 2
            r9.visitVarInsn(r3, r15)
            java.lang.String r15 = JSONSerializer
            java.lang.String r0 = "isWriteClassName"
            java.lang.String r3 = "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z"
            r18 = r8
            r8 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r8, r15, r0, r3)
            r0 = 153(0x99, float:2.14E-43)
            r9.visitJumpInsn(r0, r2)
        L_0x02a6:
            r0 = 4
            r3 = 25
            goto L_0x02af
        L_0x02aa:
            r18 = r8
            r8 = 182(0xb6, float:2.55E-43)
            goto L_0x02a6
        L_0x02af:
            r9.visitVarInsn(r3, r0)
            r0 = 2
            r9.visitVarInsn(r3, r0)
            java.lang.String r0 = "getClass"
            java.lang.String r15 = "()Ljava/lang/Class;"
            java.lang.String r3 = "java/lang/Object"
            r9.visitMethodInsn(r8, r3, r0, r15)
            r0 = 165(0xa5, float:2.31E-43)
            r9.visitJumpInsn(r0, r2)
            r9.visitLabel(r6)
            int r0 = r11.var(r5)
            r3 = 25
            r9.visitVarInsn(r3, r0)
            r0 = 123(0x7b, float:1.72E-43)
            r6 = 16
            r9.visitVarInsn(r6, r0)
            java.lang.String r0 = SerializeWriter
            java.lang.String r6 = "(I)V"
            r9.visitMethodInsn(r8, r0, r14, r6)
            r0 = 0
            r9.visitVarInsn(r3, r0)
            r0 = 1
            r9.visitVarInsn(r3, r0)
            com.alibaba.fastjson.serializer.SerializeBeanInfo r6 = r27.beanInfo
            java.lang.String r6 = r6.typeKey
            if (r6 == 0) goto L_0x02f9
            com.alibaba.fastjson.serializer.SerializeBeanInfo r6 = r27.beanInfo
            java.lang.String r6 = r6.typeKey
            r9.visitLdcInsn(r6)
        L_0x02f7:
            r0 = 2
            goto L_0x02fd
        L_0x02f9:
            r9.visitInsn(r0)
            goto L_0x02f7
        L_0x02fd:
            r9.visitVarInsn(r3, r0)
            java.lang.String r0 = JavaBeanSerializer
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            java.lang.String r4 = JSONSerializer
            r3.append(r4)
            java.lang.String r4 = ";Ljava/lang/String;Ljava/lang/Object;)V"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "writeClassName"
            r6 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r6, r0, r4, r3)
            r0 = 44
            r3 = 16
            r9.visitVarInsn(r3, r0)
            r0 = 167(0xa7, float:2.34E-43)
            r9.visitJumpInsn(r0, r1)
            r9.visitLabel(r2)
            r0 = 123(0x7b, float:1.72E-43)
            r9.visitVarInsn(r3, r0)
            r9.visitLabel(r1)
        L_0x0336:
            java.lang.String r0 = "seperator"
            int r0 = r11.var(r0)
            r1 = 54
            r9.visitVarInsn(r1, r0)
            boolean r0 = r27.writeDirect
            if (r0 != 0) goto L_0x034a
            r7._before(r9, r11)
        L_0x034a:
            boolean r0 = r27.writeDirect
            if (r0 != 0) goto L_0x03cc
            int r0 = r11.var(r5)
            r2 = 25
            r9.visitVarInsn(r2, r0)
            java.lang.String r0 = SerializeWriter
            java.lang.String r4 = "isNotWriteDefaultValue"
            java.lang.String r6 = "()Z"
            r8 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r8, r0, r4, r6)
            java.lang.String r0 = "notWriteDefaultValue"
            int r0 = r11.var(r0)
            r9.visitVarInsn(r1, r0)
            r0 = 1
            r9.visitVarInsn(r2, r0)
            r0 = 0
            r9.visitVarInsn(r2, r0)
            java.lang.String r0 = JSONSerializer
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            java.lang.String r4 = SerializeFilterable_desc
            r2.append(r4)
            java.lang.String r6 = ")Z"
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            java.lang.String r6 = "checkValue"
            r8 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r8, r0, r6, r2)
            java.lang.String r2 = "checkValue"
            int r2 = r11.var(r2)
            r9.visitVarInsn(r1, r2)
            r2 = 25
            r6 = 1
            r9.visitVarInsn(r2, r6)
            r8 = 0
            r9.visitVarInsn(r2, r8)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r4)
            java.lang.String r4 = ")Z"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "hasNameFilters"
            r15 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r15, r0, r4, r2)
            java.lang.String r0 = "hasNameFilters"
            int r0 = r11.var(r0)
            r9.visitVarInsn(r1, r0)
            goto L_0x03d0
        L_0x03cc:
            r6 = 1
            r8 = 0
            goto L_0x04a2
        L_0x03d0:
            if (r8 >= r13) goto L_0x04a6
            r4 = r10[r8]
            java.lang.Class<?> r0 = r4.fieldClass
            java.lang.String r1 = r4.name
            r9.visitLdcInsn(r1)
            r1 = 58
            int r2 = com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName
            r9.visitVarInsn(r1, r2)
            java.lang.Class r1 = java.lang.Byte.TYPE
            if (r0 == r1) goto L_0x03ee
            java.lang.Class r1 = java.lang.Short.TYPE
            if (r0 == r1) goto L_0x03ee
            java.lang.Class r1 = java.lang.Integer.TYPE
            if (r0 != r1) goto L_0x03f6
        L_0x03ee:
            r15 = r24
            r22 = r5
            r10 = 21
            goto L_0x0483
        L_0x03f6:
            java.lang.Class r1 = java.lang.Long.TYPE
            if (r0 != r1) goto L_0x0406
            r2 = r24
            r7._long(r2, r9, r4, r11)
        L_0x03ff:
            r15 = r2
            r22 = r5
            r10 = 21
            goto L_0x0499
        L_0x0406:
            r2 = r24
            java.lang.Class r1 = java.lang.Float.TYPE
            if (r0 != r1) goto L_0x0410
            r7._float(r2, r9, r4, r11)
            goto L_0x03ff
        L_0x0410:
            java.lang.Class r1 = java.lang.Double.TYPE
            if (r0 != r1) goto L_0x0418
            r7._double(r2, r9, r4, r11)
            goto L_0x03ff
        L_0x0418:
            java.lang.Class r1 = java.lang.Boolean.TYPE
            if (r0 != r1) goto L_0x043b
            java.lang.String r0 = "boolean"
            int r16 = r11.var(r0)
            r17 = 90
            r0 = r23
            r1 = r24
            r15 = r2
            r2 = r25
            r3 = r4
            r4 = r27
            r22 = r5
            r10 = 21
            r5 = r16
            r6 = r17
            r0._int(r1, r2, r3, r4, r5, r6)
            goto L_0x0499
        L_0x043b:
            r15 = r2
            r22 = r5
            r10 = 21
            java.lang.Class r1 = java.lang.Character.TYPE
            if (r0 != r1) goto L_0x0459
            java.lang.String r0 = "char"
            int r5 = r11.var(r0)
            r6 = 67
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r4
            r4 = r27
            r0._int(r1, r2, r3, r4, r5, r6)
            goto L_0x0499
        L_0x0459:
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            if (r0 != r1) goto L_0x0461
            r7._string(r15, r9, r4, r11)
            goto L_0x0499
        L_0x0461:
            java.lang.Class<java.math.BigDecimal> r1 = java.math.BigDecimal.class
            if (r0 != r1) goto L_0x0469
            r7._decimal(r15, r9, r4, r11)
            goto L_0x0499
        L_0x0469:
            java.lang.Class<java.util.List> r1 = java.util.List.class
            boolean r1 = r1.isAssignableFrom(r0)
            if (r1 == 0) goto L_0x0475
            r7._list(r15, r9, r4, r11)
            goto L_0x0499
        L_0x0475:
            boolean r0 = r0.isEnum()
            if (r0 == 0) goto L_0x047f
            r7._enum(r15, r9, r4, r11)
            goto L_0x0499
        L_0x047f:
            r7._object(r15, r9, r4, r11)
            goto L_0x0499
        L_0x0483:
            java.lang.String r0 = r0.getName()
            int r5 = r11.var(r0)
            r6 = 73
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r4
            r4 = r27
            r0._int(r1, r2, r3, r4, r5, r6)
        L_0x0499:
            int r8 = r8 + 1
            r10 = r26
            r5 = r22
            r3 = 16
            r6 = 1
        L_0x04a2:
            r15 = 182(0xb6, float:2.55E-43)
            goto L_0x03d0
        L_0x04a6:
            r22 = r5
            r10 = 21
            boolean r0 = r27.writeDirect
            if (r0 != 0) goto L_0x04b3
            r7._after(r9, r11)
        L_0x04b3:
            com.alibaba.fastjson.asm.Label r0 = new com.alibaba.fastjson.asm.Label
            r0.<init>()
            com.alibaba.fastjson.asm.Label r1 = new com.alibaba.fastjson.asm.Label
            r1.<init>()
            java.lang.String r2 = "seperator"
            int r2 = r11.var(r2)
            r9.visitVarInsn(r10, r2)
            r2 = 123(0x7b, float:1.72E-43)
            r3 = 16
            r9.visitIntInsn(r3, r2)
            r4 = 160(0xa0, float:2.24E-43)
            r9.visitJumpInsn(r4, r0)
            r4 = r22
            int r5 = r11.var(r4)
            r6 = 25
            r9.visitVarInsn(r6, r5)
            r9.visitVarInsn(r3, r2)
            java.lang.String r2 = SerializeWriter
            java.lang.String r5 = "(I)V"
            r7 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r7, r2, r14, r5)
            r9.visitLabel(r0)
            int r0 = r11.var(r4)
            r9.visitVarInsn(r6, r0)
            r0 = 125(0x7d, float:1.75E-43)
            r9.visitVarInsn(r3, r0)
            java.lang.String r0 = "(I)V"
            r9.visitMethodInsn(r7, r2, r14, r0)
            r9.visitLabel(r1)
            r0 = r19
            r9.visitLabel(r0)
            boolean r0 = r27.nonContext
            if (r0 != 0) goto L_0x0535
            r0 = 1
            r9.visitVarInsn(r6, r0)
            r0 = r18
            int r0 = r11.var(r0)
            r9.visitVarInsn(r6, r0)
            java.lang.String r0 = JSONSerializer
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r12)
            java.lang.String r2 = SerialContext_desc
            r1.append(r2)
            java.lang.String r2 = ")V"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "setContext"
            r9.visitMethodInsn(r7, r0, r2, r1)
        L_0x0535:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ASMSerializerFactory.generateWriteMethod(java.lang.Class, com.alibaba.fastjson.asm.MethodVisitor, com.alibaba.fastjson.util.FieldInfo[], com.alibaba.fastjson.serializer.ASMSerializerFactory$Context):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:125:0x04b9 A[EDGE_INSN: B:125:0x04b9->B:93:0x04b9 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x04c8  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x053b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0540  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.fastjson.serializer.JavaBeanSerializer createJavaBeanSerializer(com.alibaba.fastjson.serializer.SerializeBeanInfo r35) throws java.lang.Exception {
        /*
            r34 = this;
            r0 = r34
            r7 = r35
            java.lang.Class<?> r8 = r7.beanType
            boolean r1 = r8.isPrimitive()
            if (r1 != 0) goto L_0x05f8
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r1 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r1 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r8, r1)
            r9 = r1
            com.alibaba.fastjson.annotation.JSONType r9 = (com.alibaba.fastjson.annotation.JSONType) r9
            com.alibaba.fastjson.util.FieldInfo[] r10 = r7.fields
            int r1 = r10.length
            r2 = 0
        L_0x0019:
            if (r2 >= r1) goto L_0x0038
            r3 = r10[r2]
            java.lang.reflect.Field r4 = r3.field
            if (r4 != 0) goto L_0x0035
            java.lang.reflect.Method r3 = r3.method
            if (r3 == 0) goto L_0x0035
            java.lang.Class r3 = r3.getDeclaringClass()
            boolean r3 = r3.isInterface()
            if (r3 == 0) goto L_0x0035
            com.alibaba.fastjson.serializer.JavaBeanSerializer r0 = new com.alibaba.fastjson.serializer.JavaBeanSerializer
            r0.<init>((com.alibaba.fastjson.serializer.SerializeBeanInfo) r7)
            return r0
        L_0x0035:
            int r2 = r2 + 1
            goto L_0x0019
        L_0x0038:
            com.alibaba.fastjson.util.FieldInfo[] r12 = r7.sortedFields
            com.alibaba.fastjson.util.FieldInfo[] r1 = r7.fields
            if (r12 != r1) goto L_0x0040
            r14 = 1
            goto L_0x0041
        L_0x0040:
            r14 = 0
        L_0x0041:
            int r1 = r12.length
            r2 = 256(0x100, float:3.59E-43)
            if (r1 <= r2) goto L_0x004c
            com.alibaba.fastjson.serializer.JavaBeanSerializer r0 = new com.alibaba.fastjson.serializer.JavaBeanSerializer
            r0.<init>((com.alibaba.fastjson.serializer.SerializeBeanInfo) r7)
            return r0
        L_0x004c:
            int r1 = r12.length
            r2 = 0
        L_0x004e:
            if (r2 >= r1) goto L_0x0069
            r3 = r12[r2]
            java.lang.reflect.Member r3 = r3.getMember()
            java.lang.String r3 = r3.getName()
            boolean r3 = com.alibaba.fastjson.util.ASMUtils.checkName(r3)
            if (r3 != 0) goto L_0x0066
            com.alibaba.fastjson.serializer.JavaBeanSerializer r0 = new com.alibaba.fastjson.serializer.JavaBeanSerializer
            r0.<init>((com.alibaba.fastjson.serializer.SerializeBeanInfo) r7)
            return r0
        L_0x0066:
            int r2 = r2 + 1
            goto L_0x004e
        L_0x0069:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ASMSerializer_"
            r1.append(r2)
            java.util.concurrent.atomic.AtomicLong r2 = r0.seed
            long r2 = r2.incrementAndGet()
            r1.append(r2)
            java.lang.String r2 = "_"
            r1.append(r2)
            java.lang.String r2 = r8.getSimpleName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.Class<com.alibaba.fastjson.serializer.ASMSerializerFactory> r2 = com.alibaba.fastjson.serializer.ASMSerializerFactory.class
            java.lang.Package r3 = r2.getPackage()
            if (r3 == 0) goto L_0x00cb
            java.lang.String r3 = r3.getName()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = 46
            r6 = 47
            java.lang.String r5 = r3.replace(r5, r6)
            r4.append(r5)
            java.lang.String r5 = "/"
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            java.lang.String r3 = "."
            r5.append(r3)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r5 = r1
            r6 = r4
            goto L_0x00cd
        L_0x00cb:
            r5 = r1
            r6 = r5
        L_0x00cd:
            java.lang.Package r1 = r2.getPackage()
            r1.getName()
            com.alibaba.fastjson.asm.ClassWriter r4 = new com.alibaba.fastjson.asm.ClassWriter
            r4.<init>()
            java.lang.String r19 = JavaBeanSerializer
            java.lang.String r1 = ObjectSerializer
            java.lang.String[] r20 = new java.lang.String[]{r1}
            r16 = 49
            r17 = 33
            r15 = r4
            r18 = r6
            r15.visit(r16, r17, r18, r19, r20)
            int r1 = r12.length
            r2 = 0
        L_0x00ed:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r2 >= r1) goto L_0x016d
            r15 = r12[r2]
            java.lang.Class<?> r11 = r15.fieldClass
            boolean r11 = r11.isPrimitive()
            if (r11 != 0) goto L_0x00ff
            java.lang.Class<?> r11 = r15.fieldClass
            if (r11 != r3) goto L_0x0102
        L_0x00ff:
            r16 = r1
            goto L_0x0168
        L_0x0102:
            com.alibaba.fastjson.asm.FieldWriter r3 = new com.alibaba.fastjson.asm.FieldWriter
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r13 = r15.name
            r11.append(r13)
            java.lang.String r13 = "_asm_fieldType"
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            java.lang.String r13 = "Ljava/lang/reflect/Type;"
            r16 = r1
            r1 = 1
            r3.<init>(r4, r1, r11, r13)
            r3.visitEnd()
            java.lang.Class<java.util.List> r1 = java.util.List.class
            java.lang.Class<?> r3 = r15.fieldClass
            boolean r1 = r1.isAssignableFrom(r3)
            if (r1 == 0) goto L_0x014a
            com.alibaba.fastjson.asm.FieldWriter r1 = new com.alibaba.fastjson.asm.FieldWriter
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r11 = r15.name
            r3.append(r11)
            java.lang.String r11 = "_asm_list_item_ser_"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            java.lang.String r11 = ObjectSerializer_desc
            r13 = 1
            r1.<init>(r4, r13, r3, r11)
            r1.visitEnd()
        L_0x014a:
            com.alibaba.fastjson.asm.FieldWriter r1 = new com.alibaba.fastjson.asm.FieldWriter
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r11 = r15.name
            r3.append(r11)
            java.lang.String r11 = "_asm_ser_"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            java.lang.String r11 = ObjectSerializer_desc
            r13 = 1
            r1.<init>(r4, r13, r3, r11)
            r1.visitEnd()
        L_0x0168:
            int r2 = r2 + 1
            r1 = r16
            goto L_0x00ed
        L_0x016d:
            com.alibaba.fastjson.asm.MethodWriter r1 = new com.alibaba.fastjson.asm.MethodWriter
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r11 = "("
            r2.append(r11)
            java.lang.Class<com.alibaba.fastjson.serializer.SerializeBeanInfo> r11 = com.alibaba.fastjson.serializer.SerializeBeanInfo.class
            java.lang.String r13 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r11)
            r2.append(r13)
            java.lang.String r13 = ")V"
            r2.append(r13)
            java.lang.String r19 = r2.toString()
            r20 = 0
            r21 = 0
            r17 = 1
            java.lang.String r18 = "<init>"
            r15 = r1
            r16 = r4
            r15.<init>(r16, r17, r18, r19, r20, r21)
            r13 = 25
            r2 = 0
            r1.visitVarInsn(r13, r2)
            r2 = 1
            r1.visitVarInsn(r13, r2)
            java.lang.String r2 = JavaBeanSerializer
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r13 = "("
            r15.append(r13)
            java.lang.String r13 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r11)
            r15.append(r13)
            java.lang.String r13 = ")V"
            r15.append(r13)
            java.lang.String r13 = r15.toString()
            r15 = 183(0xb7, float:2.56E-43)
            java.lang.String r4 = "<init>"
            r1.visitMethodInsn(r15, r2, r4, r13)
            r2 = 0
        L_0x01c7:
            int r4 = r12.length
            if (r2 >= r4) goto L_0x024f
            r4 = r12[r2]
            java.lang.Class<?> r13 = r4.fieldClass
            boolean r13 = r13.isPrimitive()
            if (r13 != 0) goto L_0x01d8
            java.lang.Class<?> r13 = r4.fieldClass
            if (r13 != r3) goto L_0x01dd
        L_0x01d8:
            r17 = r3
            r18 = r5
            goto L_0x0247
        L_0x01dd:
            r13 = 0
            r15 = 25
            r1.visitVarInsn(r15, r13)
            java.lang.reflect.Method r13 = r4.method
            if (r13 == 0) goto L_0x0211
            java.lang.Class<?> r13 = r4.declaringClass
            java.lang.String r13 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r13)
            com.alibaba.fastjson.asm.Type r13 = com.alibaba.fastjson.asm.Type.getType(r13)
            r1.visitLdcInsn(r13)
            java.lang.reflect.Method r13 = r4.method
            java.lang.String r13 = r13.getName()
            r1.visitLdcInsn(r13)
            java.lang.Class<com.alibaba.fastjson.util.ASMUtils> r13 = com.alibaba.fastjson.util.ASMUtils.class
            java.lang.String r13 = com.alibaba.fastjson.util.ASMUtils.type(r13)
            java.lang.String r15 = "getMethodType"
            r17 = r3
            java.lang.String r3 = "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;"
            r18 = r5
            r5 = 184(0xb8, float:2.58E-43)
            r1.visitMethodInsn(r5, r13, r15, r3)
            goto L_0x022d
        L_0x0211:
            r17 = r3
            r18 = r5
            r3 = 0
            r5 = 25
            r1.visitVarInsn(r5, r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r1.visitLdcInsn(r3)
            java.lang.String r3 = JavaBeanSerializer
            java.lang.String r5 = "getFieldType"
            java.lang.String r13 = "(I)Ljava/lang/reflect/Type;"
            r15 = 183(0xb7, float:2.56E-43)
            r1.visitMethodInsn(r15, r3, r5, r13)
        L_0x022d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r4.name
            r3.append(r4)
            java.lang.String r4 = "_asm_fieldType"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "Ljava/lang/reflect/Type;"
            r5 = 181(0xb5, float:2.54E-43)
            r1.visitFieldInsn(r5, r6, r3, r4)
        L_0x0247:
            int r2 = r2 + 1
            r3 = r17
            r5 = r18
            goto L_0x01c7
        L_0x024f:
            r18 = r5
            r13 = 177(0xb1, float:2.48E-43)
            r1.visitInsn(r13)
            r15 = 4
            r1.visitMaxs(r15, r15)
            r1.visitEnd()
            if (r9 == 0) goto L_0x0273
            com.alibaba.fastjson.serializer.SerializerFeature[] r1 = r9.serialzeFeatures()
            int r2 = r1.length
            r3 = 0
        L_0x0265:
            if (r3 >= r2) goto L_0x0273
            r4 = r1[r3]
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect
            if (r4 != r5) goto L_0x0270
            r22 = 1
            goto L_0x0275
        L_0x0270:
            int r3 = r3 + 1
            goto L_0x0265
        L_0x0273:
            r22 = 0
        L_0x0275:
            r5 = 0
        L_0x0276:
            r4 = 7
            java.lang.String r3 = "entity"
            r2 = 192(0xc0, float:2.69E-43)
            java.lang.String r23 = "java/io/IOException"
            java.lang.String r13 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            java.lang.String r7 = "(L"
            r25 = r11
            java.lang.String r11 = "out"
            r26 = r10
            r10 = 2
            r1 = 3
            if (r5 >= r1) goto L_0x04b9
            if (r5 != 0) goto L_0x0296
            java.lang.String r1 = "write"
            r20 = r1
            r27 = r22
            r19 = 1
            goto L_0x02aa
        L_0x0296:
            r1 = 1
            if (r5 != r1) goto L_0x02a2
            java.lang.String r1 = "writeNormal"
            r20 = r1
            r27 = r22
            r19 = 0
            goto L_0x02aa
        L_0x02a2:
            java.lang.String r1 = "writeDirectNonContext"
            r20 = r1
            r19 = 1
            r27 = 1
        L_0x02aa:
            com.alibaba.fastjson.serializer.ASMSerializerFactory$Context r1 = new com.alibaba.fastjson.serializer.ASMSerializerFactory$Context
            r28 = r1
            r2 = r12
            r29 = r3
            r3 = r35
            r30 = r16
            r4 = r6
            r32 = r5
            r31 = r18
            r5 = r19
            r33 = r6
            r6 = r27
            r1.<init>(r2, r3, r4, r5, r6)
            com.alibaba.fastjson.asm.MethodWriter r1 = new com.alibaba.fastjson.asm.MethodWriter
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            java.lang.String r3 = JSONSerializer
            r2.append(r3)
            r2.append(r13)
            java.lang.String r19 = r2.toString()
            r2 = 0
            java.lang.String[] r21 = new java.lang.String[]{r23}
            r17 = 1
            r4 = r15
            r15 = r1
            r18 = r20
            r20 = r2
            r15.<init>(r16, r17, r18, r19, r20, r21)
            com.alibaba.fastjson.asm.Label r2 = new com.alibaba.fastjson.asm.Label
            r2.<init>()
            r5 = 25
            r1.visitVarInsn(r5, r10)
            r6 = 199(0xc7, float:2.79E-43)
            r1.visitJumpInsn(r6, r2)
            r6 = 1
            r1.visitVarInsn(r5, r6)
            java.lang.String r15 = "writeNull"
            java.lang.String r4 = "()V"
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r3, r15, r4)
            r4 = 177(0xb1, float:2.48E-43)
            r1.visitInsn(r4)
            r1.visitLabel(r2)
            r1.visitVarInsn(r5, r6)
            java.lang.String r2 = SerializeWriter_desc
            r15 = 180(0xb4, float:2.52E-43)
            r1.visitFieldInsn(r15, r3, r11, r2)
            r2 = r28
            int r4 = r2.var(r11)
            r5 = 58
            r1.visitVarInsn(r5, r4)
            if (r14 != 0) goto L_0x0333
            boolean r6 = r2.writeDirect
            if (r6 != 0) goto L_0x0333
            if (r9 == 0) goto L_0x0336
            boolean r6 = r9.alphabetic()
            if (r6 == 0) goto L_0x0333
            goto L_0x0336
        L_0x0333:
            r15 = r33
            goto L_0x038f
        L_0x0336:
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            int r15 = r2.var(r11)
            r4 = 25
            r1.visitVarInsn(r4, r15)
            java.lang.String r15 = SerializeWriter
            java.lang.String r5 = "isSortField"
            java.lang.String r4 = "()Z"
            r1.visitMethodInsn(r10, r15, r5, r4)
            r4 = 154(0x9a, float:2.16E-43)
            r1.visitJumpInsn(r4, r6)
            r4 = 0
            r5 = 25
            r1.visitVarInsn(r5, r4)
            r4 = 1
            r1.visitVarInsn(r5, r4)
            r4 = 2
            r1.visitVarInsn(r5, r4)
            r4 = 3
            r1.visitVarInsn(r5, r4)
            r4 = 4
            r1.visitVarInsn(r5, r4)
            r4 = 5
            r5 = 21
            r1.visitVarInsn(r5, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r7)
            r4.append(r3)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "writeUnsorted"
            r15 = r33
            r1.visitMethodInsn(r10, r15, r5, r4)
            r4 = 177(0xb1, float:2.48E-43)
            r1.visitInsn(r4)
            r1.visitLabel(r6)
        L_0x038f:
            boolean r4 = r2.writeDirect
            if (r4 == 0) goto L_0x0471
            if (r27 != 0) goto L_0x0471
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            com.alibaba.fastjson.asm.Label r5 = new com.alibaba.fastjson.asm.Label
            r5.<init>()
            r6 = 0
            r10 = 25
            r1.visitVarInsn(r10, r6)
            r6 = 1
            r1.visitVarInsn(r10, r6)
            java.lang.String r6 = JavaBeanSerializer
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r7)
            r10.append(r3)
            r20 = r9
            java.lang.String r9 = ";)Z"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            java.lang.String r10 = "writeDirect"
            r21 = r14
            r14 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r14, r6, r10, r9)
            r6 = 154(0x9a, float:2.16E-43)
            r1.visitJumpInsn(r6, r5)
            r6 = 0
            r9 = 25
            r1.visitVarInsn(r9, r6)
            r6 = 1
            r1.visitVarInsn(r9, r6)
            r6 = 2
            r1.visitVarInsn(r9, r6)
            r6 = 3
            r1.visitVarInsn(r9, r6)
            r6 = 4
            r1.visitVarInsn(r9, r6)
            r6 = 5
            r9 = 21
            r1.visitVarInsn(r9, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r7)
            r6.append(r3)
            r6.append(r13)
            java.lang.String r6 = r6.toString()
            java.lang.String r9 = "writeNormal"
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r15, r9, r6)
            r6 = 177(0xb1, float:2.48E-43)
            r1.visitInsn(r6)
            r1.visitLabel(r5)
            int r5 = r2.var(r11)
            r6 = 25
            r1.visitVarInsn(r6, r5)
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect
            int r5 = r5.mask
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1.visitLdcInsn(r5)
            java.lang.String r5 = SerializeWriter
            java.lang.String r9 = "isEnabled"
            java.lang.String r10 = "(I)Z"
            r11 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r11, r5, r9, r10)
            r5 = 153(0x99, float:2.14E-43)
            r1.visitJumpInsn(r5, r4)
            r5 = 0
            r1.visitVarInsn(r6, r5)
            r5 = 1
            r1.visitVarInsn(r6, r5)
            r5 = 2
            r1.visitVarInsn(r6, r5)
            r5 = 3
            r1.visitVarInsn(r6, r5)
            r5 = 4
            r1.visitVarInsn(r6, r5)
            r6 = 5
            r9 = 21
            r1.visitVarInsn(r9, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r7)
            r6.append(r3)
            r6.append(r13)
            java.lang.String r3 = r6.toString()
            java.lang.String r6 = "writeDirectNonContext"
            r7 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r7, r15, r6, r3)
            r3 = 177(0xb1, float:2.48E-43)
            r1.visitInsn(r3)
            r1.visitLabel(r4)
        L_0x046d:
            r4 = 25
            r6 = 2
            goto L_0x0479
        L_0x0471:
            r20 = r9
            r21 = r14
            r3 = 177(0xb1, float:2.48E-43)
            r5 = 4
            goto L_0x046d
        L_0x0479:
            r1.visitVarInsn(r4, r6)
            java.lang.String r4 = com.alibaba.fastjson.util.ASMUtils.type(r8)
            r9 = 192(0xc0, float:2.69E-43)
            r1.visitTypeInsn(r9, r4)
            r10 = r29
            int r4 = r2.var(r10)
            r7 = 58
            r1.visitVarInsn(r7, r4)
            r0.generateWriteMethod(r8, r1, r12, r2)
            r1.visitInsn(r3)
            int r2 = r2.variantIndex
            int r2 = r2 + r6
            r14 = 7
            r1.visitMaxs(r14, r2)
            r1.visitEnd()
            int r1 = r32 + 1
            r7 = r35
            r6 = r15
            r9 = r20
            r14 = r21
            r11 = r25
            r10 = r26
            r16 = r30
            r18 = r31
            r13 = 177(0xb1, float:2.48E-43)
            r15 = r5
            r5 = r1
            goto L_0x0276
        L_0x04b9:
            r9 = r2
            r10 = r3
            r27 = r6
            r21 = r14
            r30 = r16
            r31 = r18
            r15 = 180(0xb4, float:2.52E-43)
            r14 = r4
            if (r21 != 0) goto L_0x053b
            com.alibaba.fastjson.serializer.ASMSerializerFactory$Context r6 = new com.alibaba.fastjson.serializer.ASMSerializerFactory$Context
            r5 = 0
            r1 = r6
            r2 = r12
            r3 = r35
            r4 = r27
            r14 = r6
            r6 = r22
            r1.<init>(r2, r3, r4, r5, r6)
            com.alibaba.fastjson.asm.MethodWriter r1 = new com.alibaba.fastjson.asm.MethodWriter
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            java.lang.String r3 = JSONSerializer
            r2.append(r3)
            r2.append(r13)
            java.lang.String r19 = r2.toString()
            r20 = 0
            java.lang.String[] r21 = new java.lang.String[]{r23}
            r17 = 1
            java.lang.String r18 = "writeUnsorted"
            r6 = r15
            r15 = r1
            r16 = r30
            r15.<init>(r16, r17, r18, r19, r20, r21)
            r2 = 1
            r4 = 25
            r1.visitVarInsn(r4, r2)
            java.lang.String r2 = SerializeWriter_desc
            r1.visitFieldInsn(r6, r3, r11, r2)
            int r2 = r14.var(r11)
            r3 = 58
            r1.visitVarInsn(r3, r2)
            r2 = 2
            r1.visitVarInsn(r4, r2)
            java.lang.String r4 = com.alibaba.fastjson.util.ASMUtils.type(r8)
            r1.visitTypeInsn(r9, r4)
            int r4 = r14.var(r10)
            r1.visitVarInsn(r3, r4)
            r3 = r26
            r0.generateWriteMethod(r8, r1, r3, r14)
            r3 = 177(0xb1, float:2.48E-43)
            r1.visitInsn(r3)
            int r3 = r14.variantIndex
            int r3 = r3 + r2
            r2 = 7
            r1.visitMaxs(r2, r3)
            r1.visitEnd()
            goto L_0x053c
        L_0x053b:
            r6 = r15
        L_0x053c:
            r14 = 0
            r15 = 3
        L_0x053e:
            if (r14 >= r15) goto L_0x05d7
            if (r14 != 0) goto L_0x054a
            java.lang.String r1 = "writeAsArray"
            r18 = r1
            r16 = r22
            r5 = 1
            goto L_0x055c
        L_0x054a:
            r1 = 1
            if (r14 != r1) goto L_0x0555
            java.lang.String r1 = "writeAsArrayNormal"
            r18 = r1
            r16 = r22
            r5 = 0
            goto L_0x055c
        L_0x0555:
            java.lang.String r1 = "writeAsArrayNonContext"
            r18 = r1
            r5 = 1
            r16 = 1
        L_0x055c:
            com.alibaba.fastjson.serializer.ASMSerializerFactory$Context r4 = new com.alibaba.fastjson.serializer.ASMSerializerFactory$Context
            r1 = r4
            r2 = r12
            r3 = r35
            r9 = r4
            r4 = r27
            r24 = r14
            r14 = r6
            r6 = r16
            r1.<init>(r2, r3, r4, r5, r6)
            com.alibaba.fastjson.asm.MethodWriter r1 = new com.alibaba.fastjson.asm.MethodWriter
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            java.lang.String r3 = JSONSerializer
            r2.append(r3)
            r2.append(r13)
            java.lang.String r19 = r2.toString()
            r20 = 0
            java.lang.String[] r21 = new java.lang.String[]{r23}
            r17 = 1
            r2 = r15
            r15 = r1
            r16 = r30
            r15.<init>(r16, r17, r18, r19, r20, r21)
            r4 = 1
            r5 = 25
            r1.visitVarInsn(r5, r4)
            java.lang.String r6 = SerializeWriter_desc
            r1.visitFieldInsn(r14, r3, r11, r6)
            int r3 = r9.var(r11)
            r6 = 58
            r1.visitVarInsn(r6, r3)
            r3 = 2
            r1.visitVarInsn(r5, r3)
            java.lang.String r15 = com.alibaba.fastjson.util.ASMUtils.type(r8)
            r2 = 192(0xc0, float:2.69E-43)
            r1.visitTypeInsn(r2, r15)
            int r15 = r9.var(r10)
            r1.visitVarInsn(r6, r15)
            r0.generateWriteAsArray(r8, r1, r12, r9)
            r15 = 177(0xb1, float:2.48E-43)
            r1.visitInsn(r15)
            int r9 = r9.variantIndex
            int r9 = r9 + r3
            r2 = 7
            r1.visitMaxs(r2, r9)
            r1.visitEnd()
            int r1 = r24 + 1
            r6 = r14
            r9 = 192(0xc0, float:2.69E-43)
            r15 = 3
            r14 = r1
            goto L_0x053e
        L_0x05d7:
            byte[] r1 = r30.toByteArray()
            com.alibaba.fastjson.util.ASMClassLoader r0 = r0.classLoader
            int r2 = r1.length
            r4 = r31
            r3 = 0
            java.lang.Class r0 = r0.defineClassPublic(r4, r1, r3, r2)
            java.lang.Class[] r1 = new java.lang.Class[]{r25}
            java.lang.reflect.Constructor r0 = r0.getConstructor(r1)
            java.lang.Object[] r1 = new java.lang.Object[]{r35}
            java.lang.Object r0 = r0.newInstance(r1)
            com.alibaba.fastjson.serializer.JavaBeanSerializer r0 = (com.alibaba.fastjson.serializer.JavaBeanSerializer) r0
            return r0
        L_0x05f8:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "unsupportd class "
            r1.append(r2)
            java.lang.String r2 = r8.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ASMSerializerFactory.createJavaBeanSerializer(com.alibaba.fastjson.serializer.SerializeBeanInfo):com.alibaba.fastjson.serializer.JavaBeanSerializer");
    }

    public static class Context {
        static final int features = 5;
        static int fieldName = 6;
        static final int obj = 2;
        static int original = 7;
        static final int paramFieldName = 3;
        static final int paramFieldType = 4;
        static int processValue = 8;
        static final int serializer = 1;
        /* access modifiers changed from: private */
        public final SerializeBeanInfo beanInfo;
        /* access modifiers changed from: private */
        public final String className;
        private final FieldInfo[] getters;
        /* access modifiers changed from: private */
        public final boolean nonContext;
        /* access modifiers changed from: private */
        public int variantIndex = 9;
        private Map<String, Integer> variants = new HashMap();
        /* access modifiers changed from: private */
        public final boolean writeDirect;

        public Context(FieldInfo[] fieldInfoArr, SerializeBeanInfo serializeBeanInfo, String str, boolean z, boolean z2) {
            this.getters = fieldInfoArr;
            this.className = str;
            this.beanInfo = serializeBeanInfo;
            this.writeDirect = z;
            this.nonContext = z2 || serializeBeanInfo.beanType.isEnum();
        }

        public int getFieldOrinal(String str) {
            int length = this.getters.length;
            for (int i = 0; i < length; i++) {
                if (this.getters[i].name.equals(str)) {
                    return i;
                }
            }
            return -1;
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

        public int var(String str, int i) {
            if (this.variants.get(str) == null) {
                this.variants.put(str, Integer.valueOf(this.variantIndex));
                this.variantIndex += i;
            }
            return this.variants.get(str).intValue();
        }
    }
}

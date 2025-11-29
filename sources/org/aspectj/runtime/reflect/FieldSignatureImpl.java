package org.aspectj.runtime.reflect;

import java.lang.reflect.Field;
import org.aspectj.lang.reflect.FieldSignature;

public class FieldSignatureImpl extends MemberSignatureImpl implements FieldSignature {
    private Field field;
    Class<?> fieldType;

    public FieldSignatureImpl(int i, String str, Class<?> cls, Class<?> cls2) {
        super(i, str, cls);
        this.fieldType = cls2;
    }

    public String createToString(StringMaker stringMaker) {
        StringBuilder sb = new StringBuilder();
        sb.append(stringMaker.makeModifiersString(getModifiers()));
        if (stringMaker.includeArgs) {
            sb.append(stringMaker.makeTypeName(getFieldType()));
        }
        if (stringMaker.includeArgs) {
            sb.append(" ");
        }
        sb.append(stringMaker.makePrimaryTypeName(getDeclaringType(), getDeclaringTypeName()));
        sb.append(".");
        sb.append(getName());
        return sb.toString();
    }

    public /* bridge */ /* synthetic */ Class getDeclaringType() {
        return super.getDeclaringType();
    }

    public /* bridge */ /* synthetic */ String getDeclaringTypeName() {
        return super.getDeclaringTypeName();
    }

    public Field getField() {
        if (this.field == null) {
            try {
                this.field = getDeclaringType().getDeclaredField(getName());
            } catch (Exception unused) {
            }
        }
        return this.field;
    }

    public Class getFieldType() {
        if (this.fieldType == null) {
            this.fieldType = extractType(3);
        }
        return this.fieldType;
    }

    public /* bridge */ /* synthetic */ int getModifiers() {
        return super.getModifiers();
    }

    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    public /* bridge */ /* synthetic */ void setLookupClassLoader(ClassLoader classLoader) {
        super.setLookupClassLoader(classLoader);
    }

    public FieldSignatureImpl(String str) {
        super(str);
    }
}

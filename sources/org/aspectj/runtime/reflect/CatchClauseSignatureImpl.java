package org.aspectj.runtime.reflect;

import org.aspectj.lang.reflect.CatchClauseSignature;

class CatchClauseSignatureImpl extends SignatureImpl implements CatchClauseSignature {
    String parameterName;
    Class<?> parameterType;

    public CatchClauseSignatureImpl(Class<?> cls, Class<?> cls2, String str) {
        super(0, "catch", cls);
        this.parameterType = cls2;
        this.parameterName = str;
    }

    public String createToString(StringMaker stringMaker) {
        return "catch(" + stringMaker.makeTypeName(getParameterType()) + ")";
    }

    public String getParameterName() {
        if (this.parameterName == null) {
            this.parameterName = extractString(4);
        }
        return this.parameterName;
    }

    public Class getParameterType() {
        if (this.parameterType == null) {
            this.parameterType = extractType(3);
        }
        return this.parameterType;
    }

    public CatchClauseSignatureImpl(String str) {
        super(str);
    }
}

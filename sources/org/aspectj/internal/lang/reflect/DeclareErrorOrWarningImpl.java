package org.aspectj.internal.lang.reflect;

import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.DeclareErrorOrWarning;
import org.aspectj.lang.reflect.PointcutExpression;

public class DeclareErrorOrWarningImpl implements DeclareErrorOrWarning {
    private AjType<?> declaringType;
    private boolean isError;
    private String msg;
    private PointcutExpression pc;

    public DeclareErrorOrWarningImpl(String str, String str2, boolean z, AjType ajType) {
        this.pc = new PointcutExpressionImpl(str);
        this.msg = str2;
        this.isError = z;
        this.declaringType = ajType;
    }

    public AjType getDeclaringType() {
        return this.declaringType;
    }

    public String getMessage() {
        return this.msg;
    }

    public PointcutExpression getPointcutExpression() {
        return this.pc;
    }

    public boolean isError() {
        return this.isError;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("declare ");
        sb.append(isError() ? "error : " : "warning : ");
        sb.append(getPointcutExpression().asString());
        sb.append(" : ");
        sb.append("\"");
        sb.append(getMessage());
        sb.append("\"");
        return sb.toString();
    }
}

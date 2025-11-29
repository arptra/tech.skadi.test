package org.aspectj.internal.lang.reflect;

import com.meizu.common.widget.MzContactsContract;
import java.lang.reflect.Method;
import java.util.StringTokenizer;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.Pointcut;
import org.aspectj.lang.reflect.PointcutExpression;

public class PointcutImpl implements Pointcut {
    private final Method baseMethod;
    private final AjType<?> declaringType;
    private final String name;
    private String[] parameterNames = new String[0];
    private final PointcutExpression pc;

    public PointcutImpl(String str, String str2, Method method, AjType ajType, String str3) {
        this.name = str;
        this.pc = new PointcutExpressionImpl(str2);
        this.baseMethod = method;
        this.declaringType = ajType;
        this.parameterNames = splitOnComma(str3);
    }

    private String[] splitOnComma(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
        int countTokens = stringTokenizer.countTokens();
        String[] strArr = new String[countTokens];
        for (int i = 0; i < countTokens; i++) {
            strArr[i] = stringTokenizer.nextToken().trim();
        }
        return strArr;
    }

    public AjType getDeclaringType() {
        return this.declaringType;
    }

    public int getModifiers() {
        return this.baseMethod.getModifiers();
    }

    public String getName() {
        return this.name;
    }

    public String[] getParameterNames() {
        return this.parameterNames;
    }

    public AjType<?>[] getParameterTypes() {
        Class[] parameterTypes = this.baseMethod.getParameterTypes();
        int length = parameterTypes.length;
        AjType<?>[] ajTypeArr = new AjType[length];
        for (int i = 0; i < length; i++) {
            ajTypeArr[i] = AjTypeSystem.getAjType(parameterTypes[i]);
        }
        return ajTypeArr;
    }

    public PointcutExpression getPointcutExpression() {
        return this.pc;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append("(");
        AjType[] parameterTypes = getParameterTypes();
        int i = 0;
        while (i < parameterTypes.length) {
            sb.append(parameterTypes[i].getName());
            String[] strArr = this.parameterNames;
            if (!(strArr == null || strArr[i] == null)) {
                sb.append(" ");
                sb.append(this.parameterNames[i]);
            }
            i++;
            if (i < parameterTypes.length) {
                sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
            }
        }
        sb.append(") : ");
        sb.append(getPointcutExpression().asString());
        return sb.toString();
    }
}

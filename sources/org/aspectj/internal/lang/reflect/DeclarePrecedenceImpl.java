package org.aspectj.internal.lang.reflect;

import com.meizu.common.widget.MzContactsContract;
import java.util.StringTokenizer;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.DeclarePrecedence;
import org.aspectj.lang.reflect.TypePattern;

public class DeclarePrecedenceImpl implements DeclarePrecedence {
    private AjType<?> declaringType;
    private TypePattern[] precedenceList;
    private String precedenceString;

    public DeclarePrecedenceImpl(String str, AjType ajType) {
        this.declaringType = ajType;
        this.precedenceString = str;
        StringTokenizer stringTokenizer = new StringTokenizer(str.startsWith("(") ? str.substring(1, str.length() - 1) : str, MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
        this.precedenceList = new TypePattern[stringTokenizer.countTokens()];
        int i = 0;
        while (true) {
            TypePattern[] typePatternArr = this.precedenceList;
            if (i < typePatternArr.length) {
                typePatternArr[i] = new TypePatternImpl(stringTokenizer.nextToken().trim());
                i++;
            } else {
                return;
            }
        }
    }

    public AjType getDeclaringType() {
        return this.declaringType;
    }

    public TypePattern[] getPrecedenceOrder() {
        return this.precedenceList;
    }

    public String toString() {
        return "declare precedence : " + this.precedenceString;
    }
}

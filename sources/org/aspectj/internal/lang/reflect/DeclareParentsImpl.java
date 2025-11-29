package org.aspectj.internal.lang.reflect;

import java.lang.reflect.Type;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.DeclareParents;
import org.aspectj.lang.reflect.TypePattern;

public class DeclareParentsImpl implements DeclareParents {
    private AjType<?> declaringType;
    private String firstMissingTypeName;
    private boolean isExtends;
    private Type[] parents;
    private boolean parentsError = false;
    private String parentsString;
    private TypePattern targetTypesPattern;

    public DeclareParentsImpl(String str, String str2, boolean z, AjType<?> ajType) {
        this.targetTypesPattern = new TypePatternImpl(str);
        this.isExtends = z;
        this.declaringType = ajType;
        this.parentsString = str2;
        try {
            this.parents = StringToType.commaSeparatedListToTypeArray(str2, ajType.getJavaClass());
        } catch (ClassNotFoundException e) {
            this.parentsError = true;
            this.firstMissingTypeName = e.getMessage();
        }
    }

    public AjType getDeclaringType() {
        return this.declaringType;
    }

    public Type[] getParentTypes() throws ClassNotFoundException {
        if (!this.parentsError) {
            return this.parents;
        }
        throw new ClassNotFoundException(this.firstMissingTypeName);
    }

    public TypePattern getTargetTypesPattern() {
        return this.targetTypesPattern;
    }

    public boolean isExtends() {
        return this.isExtends;
    }

    public boolean isImplements() {
        return !this.isExtends;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("declare parents : ");
        sb.append(getTargetTypesPattern().asString());
        sb.append(isExtends() ? " extends " : " implements ");
        sb.append(this.parentsString);
        return sb.toString();
    }
}

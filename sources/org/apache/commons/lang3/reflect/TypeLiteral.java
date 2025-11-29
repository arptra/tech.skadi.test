package org.apache.commons.lang3.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;
import org.apache.commons.lang3.Validate;

public abstract class TypeLiteral<T> implements Typed<T> {
    private static final TypeVariable<Class<TypeLiteral>> T = TypeLiteral.class.getTypeParameters()[0];
    private final String toString;
    public final Type value;

    public TypeLiteral() {
        Class<TypeLiteral> cls = TypeLiteral.class;
        Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(getClass(), cls);
        TypeVariable<Class<TypeLiteral>> typeVariable = T;
        Type type = (Type) Validate.notNull(typeArguments.get(typeVariable), "%s does not assign type parameter %s", getClass(), TypeUtils.toLongString(typeVariable));
        this.value = type;
        this.toString = String.format("%s<%s>", new Object[]{cls.getSimpleName(), TypeUtils.toString(type)});
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TypeLiteral)) {
            return false;
        }
        return TypeUtils.equals(this.value, ((TypeLiteral) obj).value);
    }

    public Type getType() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() | 592;
    }

    public String toString() {
        return this.toString;
    }
}

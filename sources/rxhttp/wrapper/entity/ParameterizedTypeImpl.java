package rxhttp.wrapper.entity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ParameterizedTypeImpl implements ParameterizedType {

    /* renamed from: a  reason: collision with root package name */
    public final Type f3556a;
    public final Type b;
    public final Type[] c;

    public final Type[] getActualTypeArguments() {
        return this.c;
    }

    public final Type getOwnerType() {
        return this.b;
    }

    public final Type getRawType() {
        return this.f3556a;
    }
}

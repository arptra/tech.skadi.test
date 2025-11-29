package io.netty.channel;

import io.netty.channel.Channel;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Constructor;

public class ReflectiveChannelFactory<T extends Channel> implements ChannelFactory<T> {
    private final Constructor<? extends T> constructor;

    public ReflectiveChannelFactory(Class<? extends T> cls) {
        ObjectUtil.checkNotNull(cls, "clazz");
        try {
            this.constructor = cls.getConstructor((Class[]) null);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + StringUtil.simpleClassName((Class<?>) cls) + " does not have a public non-arg constructor", e);
        }
    }

    public T newChannel() {
        try {
            return (Channel) this.constructor.newInstance((Object[]) null);
        } catch (Throwable th) {
            throw new ChannelException("Unable to create Channel from class " + this.constructor.getDeclaringClass(), th);
        }
    }

    public String toString() {
        return StringUtil.simpleClassName((Class<?>) ReflectiveChannelFactory.class) + '(' + StringUtil.simpleClassName((Class<?>) this.constructor.getDeclaringClass()) + ".class)";
    }
}

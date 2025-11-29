package io.netty.util;

public final class AttributeKey<T> extends AbstractConstant<AttributeKey<T>> {
    private static final ConstantPool<AttributeKey<Object>> pool = new ConstantPool<AttributeKey<Object>>() {
        public AttributeKey<Object> newConstant(int i, String str) {
            return new AttributeKey<>(i, str);
        }
    };

    public static boolean exists(String str) {
        return pool.exists(str);
    }

    public static <T> AttributeKey<T> newInstance(String str) {
        return pool.newInstance(str);
    }

    public static <T> AttributeKey<T> valueOf(String str) {
        return pool.valueOf(str);
    }

    private AttributeKey(int i, String str) {
        super(i, str);
    }

    public static <T> AttributeKey<T> valueOf(Class<?> cls, String str) {
        return pool.valueOf(cls, str);
    }
}

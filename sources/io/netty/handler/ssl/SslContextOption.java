package io.netty.handler.ssl;

import com.honey.account.constant.AccountConstantKt;
import io.netty.util.AbstractConstant;
import io.netty.util.ConstantPool;
import io.netty.util.internal.ObjectUtil;

public class SslContextOption<T> extends AbstractConstant<SslContextOption<T>> {
    private static final ConstantPool<SslContextOption<Object>> pool = new ConstantPool<SslContextOption<Object>>() {
        public SslContextOption<Object> newConstant(int i, String str) {
            return new SslContextOption<>(i, str);
        }
    };

    public static boolean exists(String str) {
        return pool.exists(str);
    }

    public static <T> SslContextOption<T> valueOf(String str) {
        return pool.valueOf(str);
    }

    public void validate(T t) {
        ObjectUtil.checkNotNull(t, AccountConstantKt.RESPONSE_VALUE);
    }

    private SslContextOption(int i, String str) {
        super(i, str);
    }

    public static <T> SslContextOption<T> valueOf(Class<?> cls, String str) {
        return pool.valueOf(cls, str);
    }

    public SslContextOption(String str) {
        this(pool.nextId(), str);
    }
}

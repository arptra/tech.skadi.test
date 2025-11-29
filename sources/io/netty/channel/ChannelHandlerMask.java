package io.netty.channel;

import com.upuphone.runasone.uupcast.CastErrorCode;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.SocketAddress;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Map;
import java.util.WeakHashMap;

final class ChannelHandlerMask {
    private static final FastThreadLocal<Map<Class<? extends ChannelHandler>, Integer>> MASKS = new FastThreadLocal<Map<Class<? extends ChannelHandler>, Integer>>() {
        public Map<Class<? extends ChannelHandler>, Integer> initialValue() {
            return new WeakHashMap(32);
        }
    };
    private static final int MASK_ALL_INBOUND = 511;
    private static final int MASK_ALL_OUTBOUND = 130561;
    static final int MASK_BIND = 512;
    static final int MASK_CHANNEL_ACTIVE = 8;
    static final int MASK_CHANNEL_INACTIVE = 16;
    static final int MASK_CHANNEL_READ = 32;
    static final int MASK_CHANNEL_READ_COMPLETE = 64;
    static final int MASK_CHANNEL_REGISTERED = 2;
    static final int MASK_CHANNEL_UNREGISTERED = 4;
    static final int MASK_CHANNEL_WRITABILITY_CHANGED = 256;
    static final int MASK_CLOSE = 4096;
    static final int MASK_CONNECT = 1024;
    static final int MASK_DEREGISTER = 8192;
    static final int MASK_DISCONNECT = 2048;
    static final int MASK_EXCEPTION_CAUGHT = 1;
    static final int MASK_FLUSH = 65536;
    static final int MASK_ONLY_INBOUND = 510;
    static final int MASK_ONLY_OUTBOUND = 130560;
    static final int MASK_READ = 16384;
    static final int MASK_USER_EVENT_TRIGGERED = 128;
    static final int MASK_WRITE = 32768;
    /* access modifiers changed from: private */
    public static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ChannelHandlerMask.class);

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Skip {
    }

    private ChannelHandlerMask() {
    }

    private static boolean isSkippable(final Class<?> cls, final String str, final Class<?>... clsArr) throws Exception {
        return ((Boolean) AccessController.doPrivileged(new PrivilegedExceptionAction<Boolean>() {
            public Boolean run() throws Exception {
                try {
                    return Boolean.valueOf(cls.getMethod(str, clsArr).isAnnotationPresent(Skip.class));
                } catch (NoSuchMethodException e) {
                    if (ChannelHandlerMask.logger.isDebugEnabled()) {
                        ChannelHandlerMask.logger.debug("Class {} missing method {}, assume we can not skip execution", cls, str, e);
                    }
                    return Boolean.FALSE;
                }
            }
        })).booleanValue();
    }

    public static int mask(Class<? extends ChannelHandler> cls) {
        Map map = MASKS.get();
        Integer num = (Integer) map.get(cls);
        if (num == null) {
            num = Integer.valueOf(mask0(cls));
            map.put(cls, num);
        }
        return num.intValue();
    }

    private static int mask0(Class<? extends ChannelHandler> cls) {
        int i;
        Class<SocketAddress> cls2 = SocketAddress.class;
        Class<ChannelPromise> cls3 = ChannelPromise.class;
        int i2 = 1;
        try {
            Class<Object> cls4 = Object.class;
            Class<ChannelHandlerContext> cls5 = ChannelHandlerContext.class;
            if (ChannelInboundHandler.class.isAssignableFrom(cls)) {
                i2 = MASK_ALL_INBOUND;
                if (isSkippable(cls, "channelRegistered", cls5)) {
                    i2 = 509;
                }
                if (isSkippable(cls, "channelUnregistered", cls5)) {
                    i2 &= -5;
                }
                if (isSkippable(cls, "channelActive", cls5)) {
                    i2 &= -9;
                }
                if (isSkippable(cls, "channelInactive", cls5)) {
                    i2 &= -17;
                }
                if (isSkippable(cls, "channelRead", cls5, cls4)) {
                    i2 &= -33;
                }
                if (isSkippable(cls, "channelReadComplete", cls5)) {
                    i2 &= -65;
                }
                if (isSkippable(cls, "channelWritabilityChanged", cls5)) {
                    i2 &= -257;
                }
                if (isSkippable(cls, "userEventTriggered", cls5, cls4)) {
                    i2 &= -129;
                }
            }
            if (ChannelOutboundHandler.class.isAssignableFrom(cls)) {
                i |= MASK_ALL_OUTBOUND;
                if (isSkippable(cls, "bind", cls5, cls2, cls3)) {
                    i &= CastErrorCode.SINK_SURFACE_NOT_SET;
                }
                if (isSkippable(cls, "connect", cls5, cls2, cls2, cls3)) {
                    i &= -1025;
                }
                if (isSkippable(cls, "disconnect", cls5, cls3)) {
                    i &= -2049;
                }
                if (isSkippable(cls, "close", cls5, cls3)) {
                    i &= -4097;
                }
                if (isSkippable(cls, "deregister", cls5, cls3)) {
                    i &= -8193;
                }
                if (isSkippable(cls, "read", cls5)) {
                    i &= -16385;
                }
                if (isSkippable(cls, "write", cls5, cls4, cls3)) {
                    i = -32769 & i;
                }
                if (isSkippable(cls, "flush", cls5)) {
                    i = -65537 & i;
                }
            }
            return isSkippable(cls, "exceptionCaught", cls5, Throwable.class) ? i & -2 : i;
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return i2;
        }
    }
}

package io.netty.handler.codec.socksx;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.socksx.v4.Socks4ServerDecoder;
import io.netty.handler.codec.socksx.v4.Socks4ServerEncoder;
import io.netty.handler.codec.socksx.v5.Socks5InitialRequestDecoder;
import io.netty.handler.codec.socksx.v5.Socks5ServerEncoder;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.List;

public class SocksPortUnificationServerHandler extends ByteToMessageDecoder {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SocksPortUnificationServerHandler.class);
    private final Socks5ServerEncoder socks5encoder;

    /* renamed from: io.netty.handler.codec.socksx.SocksPortUnificationServerHandler$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socksx$SocksVersion;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.netty.handler.codec.socksx.SocksVersion[] r0 = io.netty.handler.codec.socksx.SocksVersion.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$socksx$SocksVersion = r0
                io.netty.handler.codec.socksx.SocksVersion r1 = io.netty.handler.codec.socksx.SocksVersion.SOCKS4a     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$socksx$SocksVersion     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.socksx.SocksVersion r1 = io.netty.handler.codec.socksx.SocksVersion.SOCKS5     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socksx.SocksPortUnificationServerHandler.AnonymousClass1.<clinit>():void");
        }
    }

    public SocksPortUnificationServerHandler() {
        this(Socks5ServerEncoder.DEFAULT);
    }

    private static void logKnownVersion(ChannelHandlerContext channelHandlerContext, SocksVersion socksVersion) {
        logger.debug("{} Protocol version: {}({})", channelHandlerContext.channel(), socksVersion);
    }

    private static void logUnknownVersion(ChannelHandlerContext channelHandlerContext, byte b) {
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} Unknown protocol version: {}", channelHandlerContext.channel(), Integer.valueOf(b & 255));
        }
    }

    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readerIndex = byteBuf.readerIndex();
        if (byteBuf.writerIndex() != readerIndex) {
            ChannelPipeline pipeline = channelHandlerContext.pipeline();
            byte b = byteBuf.getByte(readerIndex);
            SocksVersion valueOf = SocksVersion.valueOf(b);
            int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socksx$SocksVersion[valueOf.ordinal()];
            if (i == 1) {
                logKnownVersion(channelHandlerContext, valueOf);
                pipeline.addAfter(channelHandlerContext.name(), (String) null, Socks4ServerEncoder.INSTANCE);
                pipeline.addAfter(channelHandlerContext.name(), (String) null, new Socks4ServerDecoder());
            } else if (i != 2) {
                logUnknownVersion(channelHandlerContext, b);
                byteBuf.skipBytes(byteBuf.readableBytes());
                channelHandlerContext.close();
                return;
            } else {
                logKnownVersion(channelHandlerContext, valueOf);
                pipeline.addAfter(channelHandlerContext.name(), (String) null, this.socks5encoder);
                pipeline.addAfter(channelHandlerContext.name(), (String) null, new Socks5InitialRequestDecoder());
            }
            pipeline.remove((ChannelHandler) this);
        }
    }

    public SocksPortUnificationServerHandler(Socks5ServerEncoder socks5ServerEncoder) {
        this.socks5encoder = (Socks5ServerEncoder) ObjectUtil.checkNotNull(socks5ServerEncoder, "socks5encoder");
    }
}

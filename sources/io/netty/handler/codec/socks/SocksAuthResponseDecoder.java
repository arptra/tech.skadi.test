package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

public class SocksAuthResponseDecoder extends ReplayingDecoder<State> {

    /* renamed from: io.netty.handler.codec.socks.SocksAuthResponseDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAuthResponseDecoder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.netty.handler.codec.socks.SocksAuthResponseDecoder$State[] r0 = io.netty.handler.codec.socks.SocksAuthResponseDecoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$socks$SocksAuthResponseDecoder$State = r0
                io.netty.handler.codec.socks.SocksAuthResponseDecoder$State r1 = io.netty.handler.codec.socks.SocksAuthResponseDecoder.State.CHECK_PROTOCOL_VERSION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$socks$SocksAuthResponseDecoder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.socks.SocksAuthResponseDecoder$State r1 = io.netty.handler.codec.socks.SocksAuthResponseDecoder.State.READ_AUTH_RESPONSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socks.SocksAuthResponseDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        CHECK_PROTOCOL_VERSION,
        READ_AUTH_RESPONSE
    }

    public SocksAuthResponseDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAuthResponseDecoder$State[((State) state()).ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new Error();
            }
        } else if (byteBuf.readByte() != SocksSubnegotiationVersion.AUTH_PASSWORD.byteValue()) {
            list.add(SocksCommonUtils.UNKNOWN_SOCKS_RESPONSE);
            channelHandlerContext.pipeline().remove((ChannelHandler) this);
        } else {
            checkpoint(State.READ_AUTH_RESPONSE);
        }
        list.add(new SocksAuthResponse(SocksAuthStatus.valueOf(byteBuf.readByte())));
        channelHandlerContext.pipeline().remove((ChannelHandler) this);
    }
}

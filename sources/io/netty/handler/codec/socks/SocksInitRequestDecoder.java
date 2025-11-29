package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SocksInitRequestDecoder extends ReplayingDecoder<State> {

    /* renamed from: io.netty.handler.codec.socks.SocksInitRequestDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.netty.handler.codec.socks.SocksInitRequestDecoder$State[] r0 = io.netty.handler.codec.socks.SocksInitRequestDecoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State = r0
                io.netty.handler.codec.socks.SocksInitRequestDecoder$State r1 = io.netty.handler.codec.socks.SocksInitRequestDecoder.State.CHECK_PROTOCOL_VERSION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.socks.SocksInitRequestDecoder$State r1 = io.netty.handler.codec.socks.SocksInitRequestDecoder.State.READ_AUTH_SCHEMES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socks.SocksInitRequestDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        CHECK_PROTOCOL_VERSION,
        READ_AUTH_SCHEMES
    }

    public SocksInitRequestDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        List list2;
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State[((State) state()).ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new Error();
            }
        } else if (byteBuf.readByte() != SocksProtocolVersion.SOCKS5.byteValue()) {
            list.add(SocksCommonUtils.UNKNOWN_SOCKS_REQUEST);
            channelHandlerContext.pipeline().remove((ChannelHandler) this);
        } else {
            checkpoint(State.READ_AUTH_SCHEMES);
        }
        byte readByte = byteBuf.readByte();
        if (readByte > 0) {
            list2 = new ArrayList(readByte);
            for (int i2 = 0; i2 < readByte; i2++) {
                list2.add(SocksAuthScheme.valueOf(byteBuf.readByte()));
            }
        } else {
            list2 = Collections.emptyList();
        }
        list.add(new SocksInitRequest(list2));
        channelHandlerContext.pipeline().remove((ChannelHandler) this);
    }
}

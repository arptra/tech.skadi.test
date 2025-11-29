package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.socksx.SocksVersion;
import io.netty.util.internal.ObjectUtil;
import java.util.List;
import org.eclipse.jetty.util.StringUtil;

public class Socks5CommandRequestDecoder extends ReplayingDecoder<State> {
    private final Socks5AddressDecoder addressDecoder;

    /* renamed from: io.netty.handler.codec.socksx.v5.Socks5CommandRequestDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5CommandRequestDecoder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.netty.handler.codec.socksx.v5.Socks5CommandRequestDecoder$State[] r0 = io.netty.handler.codec.socksx.v5.Socks5CommandRequestDecoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5CommandRequestDecoder$State = r0
                io.netty.handler.codec.socksx.v5.Socks5CommandRequestDecoder$State r1 = io.netty.handler.codec.socksx.v5.Socks5CommandRequestDecoder.State.INIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5CommandRequestDecoder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.socksx.v5.Socks5CommandRequestDecoder$State r1 = io.netty.handler.codec.socksx.v5.Socks5CommandRequestDecoder.State.SUCCESS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5CommandRequestDecoder$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.socksx.v5.Socks5CommandRequestDecoder$State r1 = io.netty.handler.codec.socksx.v5.Socks5CommandRequestDecoder.State.FAILURE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socksx.v5.Socks5CommandRequestDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        INIT,
        SUCCESS,
        FAILURE
    }

    public Socks5CommandRequestDecoder() {
        this(Socks5AddressDecoder.DEFAULT);
    }

    private void fail(List<Object> list, Exception exc) {
        if (!(exc instanceof DecoderException)) {
            exc = new DecoderException((Throwable) exc);
        }
        checkpoint(State.FAILURE);
        DefaultSocks5CommandRequest defaultSocks5CommandRequest = new DefaultSocks5CommandRequest(Socks5CommandType.CONNECT, Socks5AddressType.IPv4, StringUtil.ALL_INTERFACES, 1);
        defaultSocks5CommandRequest.setDecoderResult(DecoderResult.failure(exc));
        list.add(defaultSocks5CommandRequest);
    }

    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        try {
            int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socksx$v5$Socks5CommandRequestDecoder$State[((State) state()).ordinal()];
            if (i == 1) {
                byte readByte = byteBuf.readByte();
                SocksVersion socksVersion = SocksVersion.SOCKS5;
                if (readByte == socksVersion.byteValue()) {
                    Socks5CommandType valueOf = Socks5CommandType.valueOf(byteBuf.readByte());
                    byteBuf.skipBytes(1);
                    Socks5AddressType valueOf2 = Socks5AddressType.valueOf(byteBuf.readByte());
                    list.add(new DefaultSocks5CommandRequest(valueOf, valueOf2, this.addressDecoder.decodeAddress(valueOf2, byteBuf), byteBuf.readUnsignedShort()));
                    checkpoint(State.SUCCESS);
                } else {
                    throw new DecoderException("unsupported version: " + readByte + " (expected: " + socksVersion.byteValue() + ')');
                }
            } else if (i != 2) {
                if (i == 3) {
                    byteBuf.skipBytes(actualReadableBytes());
                    return;
                }
                return;
            }
            int actualReadableBytes = actualReadableBytes();
            if (actualReadableBytes > 0) {
                list.add(byteBuf.readRetainedSlice(actualReadableBytes));
            }
        } catch (Exception e) {
            fail(list, e);
        }
    }

    public Socks5CommandRequestDecoder(Socks5AddressDecoder socks5AddressDecoder) {
        super(State.INIT);
        this.addressDecoder = (Socks5AddressDecoder) ObjectUtil.checkNotNull(socks5AddressDecoder, "addressDecoder");
    }
}

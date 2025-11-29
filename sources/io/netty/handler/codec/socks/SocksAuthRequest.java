package io.netty.handler.codec.socks;

import com.honey.account.constant.AccountConstantKt;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public final class SocksAuthRequest extends SocksRequest {
    private static final SocksSubnegotiationVersion SUBNEGOTIATION_VERSION = SocksSubnegotiationVersion.AUTH_PASSWORD;
    private final String password;
    private final String username;

    public SocksAuthRequest(String str, String str2) {
        super(SocksRequestType.AUTH);
        ObjectUtil.checkNotNull(str, "username");
        ObjectUtil.checkNotNull(str2, AccountConstantKt.INTENT_PARAM_PASSWORD);
        CharsetEncoder encoder = CharsetUtil.encoder(CharsetUtil.US_ASCII);
        if (!encoder.canEncode(str) || !encoder.canEncode(str2)) {
            throw new IllegalArgumentException("username: " + str + " or password: **** values should be in pure ascii");
        } else if (str.length() > 255) {
            throw new IllegalArgumentException("username: " + str + " exceeds 255 char limit");
        } else if (str2.length() <= 255) {
            this.username = str;
            this.password = str2;
        } else {
            throw new IllegalArgumentException("password: **** exceeds 255 char limit");
        }
    }

    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(SUBNEGOTIATION_VERSION.byteValue());
        byteBuf.writeByte(this.username.length());
        String str = this.username;
        Charset charset = CharsetUtil.US_ASCII;
        byteBuf.writeCharSequence(str, charset);
        byteBuf.writeByte(this.password.length());
        byteBuf.writeCharSequence(this.password, charset);
    }

    public String password() {
        return this.password;
    }

    public String username() {
        return this.username;
    }
}

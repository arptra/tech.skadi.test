package io.netty.handler.codec.socksx.v5;

import com.honey.account.constant.AccountConstantKt;
import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultSocks5PasswordAuthRequest extends AbstractSocks5Message implements Socks5PasswordAuthRequest {
    private final String password;
    private final String username;

    public DefaultSocks5PasswordAuthRequest(String str, String str2) {
        ObjectUtil.checkNotNull(str, "username");
        ObjectUtil.checkNotNull(str2, AccountConstantKt.INTENT_PARAM_PASSWORD);
        if (str.length() > 255) {
            throw new IllegalArgumentException("username: **** (expected: less than 256 chars)");
        } else if (str2.length() <= 255) {
            this.username = str;
            this.password = str2;
        } else {
            throw new IllegalArgumentException("password: **** (expected: less than 256 chars)");
        }
    }

    public String password() {
        return this.password;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName((Object) this));
        DecoderResult decoderResult = decoderResult();
        if (!decoderResult.isSuccess()) {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", username: ");
        } else {
            sb.append("(username: ");
        }
        sb.append(username());
        sb.append(", password: ****)");
        return sb.toString();
    }

    public String username() {
        return this.username;
    }
}

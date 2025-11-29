package io.netty.handler.codec.http2;

import com.honey.account.constant.AccountConstantKt;
import io.netty.util.internal.ObjectUtil;

class HpackHeaderField {
    static final int HEADER_ENTRY_OVERHEAD = 32;
    final CharSequence name;
    final CharSequence value;

    public HpackHeaderField(CharSequence charSequence, CharSequence charSequence2) {
        this.name = (CharSequence) ObjectUtil.checkNotNull(charSequence, "name");
        this.value = (CharSequence) ObjectUtil.checkNotNull(charSequence2, AccountConstantKt.RESPONSE_VALUE);
    }

    public static long sizeOf(CharSequence charSequence, CharSequence charSequence2) {
        return (long) (charSequence.length() + charSequence2.length() + 32);
    }

    public final boolean equalsForTest(HpackHeaderField hpackHeaderField) {
        return HpackUtil.equalsVariableTime(this.name, hpackHeaderField.name) && HpackUtil.equalsVariableTime(this.value, hpackHeaderField.value);
    }

    public final int size() {
        return this.name.length() + this.value.length() + 32;
    }

    public String toString() {
        return this.name + ": " + this.value;
    }
}

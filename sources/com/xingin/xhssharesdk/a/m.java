package com.xingin.xhssharesdk.a;

import java.io.IOException;

public final class m extends IOException {
    public m(String str) {
        super(str);
    }

    public static m a() {
        return new m("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static m b() {
        return new m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}

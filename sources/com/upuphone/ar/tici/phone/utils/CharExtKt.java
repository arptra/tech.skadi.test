package com.upuphone.ar.tici.phone.utils;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"", "", "a", "(C)Z", "isEmoji", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class CharExtKt {
    public static final boolean a(char c) {
        int type = Character.getType(c);
        return type == 19 || type == 28;
    }
}

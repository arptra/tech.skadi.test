package com.xingin.xhssharesdk.a;

import com.xingin.xhssharesdk.a.r;

public abstract class b<MessageType extends r> implements u<MessageType> {
    static {
        int i = i.f8132a;
        Class cls = h.f8131a;
        if (cls != null) {
            try {
                i iVar = (i) cls.getMethod("getEmptyRegistry", (Class[]) null).invoke((Object) null, (Object[]) null);
            } catch (Exception unused) {
            }
        }
    }
}

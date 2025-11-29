package com.ucar.protocol;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class UCarMessagePool {
    public static final UCarMessagePool c = new UCarMessagePool();

    /* renamed from: a  reason: collision with root package name */
    public final Stack f9640a = new Stack();
    public final Set b = new HashSet();

    public UCarMessagePool() {
        for (int i = 0; i < 20; i++) {
            UCarMessage r = UCarMessage.r(true);
            this.f9640a.add(r);
            this.b.add(Integer.valueOf(r.j()));
        }
    }

    public static UCarMessagePool a() {
        return c;
    }

    public synchronized UCarMessage b() {
        if (this.f9640a.isEmpty()) {
            ProtocolConfig.b().w("UCarMessagePool", "UCarMessage pool is empty, please check whether release message correctly or not");
            return UCarMessage.r(false);
        }
        UCarMessage uCarMessage = (UCarMessage) this.f9640a.pop();
        this.b.remove(Integer.valueOf(uCarMessage.j()));
        return uCarMessage;
    }

    public synchronized void c(UCarMessage uCarMessage) {
        if (uCarMessage.n() && !this.b.contains(Integer.valueOf(uCarMessage.j()))) {
            this.f9640a.push(uCarMessage);
            this.b.add(Integer.valueOf(uCarMessage.j()));
        }
    }
}

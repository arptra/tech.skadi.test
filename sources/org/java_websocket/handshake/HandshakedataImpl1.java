package org.java_websocket.handshake;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class HandshakedataImpl1 implements HandshakeBuilder {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f3401a;
    public TreeMap b = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    public void a(String str, String str2) {
        this.b.put(str, str2);
    }

    public String e(String str) {
        String str2 = (String) this.b.get(str);
        return str2 == null ? "" : str2;
    }

    public boolean g(String str) {
        return this.b.containsKey(str);
    }

    public byte[] getContent() {
        return this.f3401a;
    }

    public Iterator i() {
        return Collections.unmodifiableSet(this.b.keySet()).iterator();
    }
}

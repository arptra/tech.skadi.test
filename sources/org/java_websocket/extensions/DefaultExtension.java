package org.java_websocket.extensions;

import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;

public class DefaultExtension implements IExtension {
    public IExtension a() {
        return new DefaultExtension();
    }

    public boolean b(String str) {
        return true;
    }

    public void c(Framedata framedata) {
    }

    public String d() {
        return "";
    }

    public boolean e(String str) {
        return true;
    }

    public boolean equals(Object obj) {
        return this == obj || (obj != null && getClass() == obj.getClass());
    }

    public void f(Framedata framedata) {
    }

    public String g() {
        return "";
    }

    public void h(Framedata framedata) {
        if (framedata.b() || framedata.c() || framedata.e()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.b() + " RSV2: " + framedata.c() + " RSV3: " + framedata.e());
        }
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    public void reset() {
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}

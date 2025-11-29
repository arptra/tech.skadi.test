package org.java_websocket.extensions;

import org.java_websocket.framing.Framedata;

public interface IExtension {
    IExtension a();

    boolean b(String str);

    void c(Framedata framedata);

    String d();

    boolean e(String str);

    void f(Framedata framedata);

    String g();

    void h(Framedata framedata);

    void reset();

    String toString();
}

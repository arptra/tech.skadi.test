package com.geetest.sdk;

import java.util.Observable;
import java.util.Observer;

public abstract class ab implements Observer {
    public abstract void a();

    public abstract void b(String str, String str2);

    public abstract void c(boolean z, String str);

    public abstract void d();

    public void update(Observable observable, Object obj) {
    }
}

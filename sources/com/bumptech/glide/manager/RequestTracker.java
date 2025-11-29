package com.bumptech.glide.manager;

import android.util.Log;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker {

    /* renamed from: a  reason: collision with root package name */
    public final Set f2683a = Collections.newSetFromMap(new WeakHashMap());
    public final Set b = new HashSet();
    public boolean c;

    public boolean a(Request request) {
        boolean z = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.f2683a.remove(request);
        if (!this.b.remove(request) && !remove) {
            z = false;
        }
        if (z) {
            request.clear();
        }
        return z;
    }

    public void b() {
        for (Request a2 : Util.k(this.f2683a)) {
            a(a2);
        }
        this.b.clear();
    }

    public void c() {
        this.c = true;
        for (Request request : Util.k(this.f2683a)) {
            if (request.isRunning() || request.f()) {
                request.clear();
                this.b.add(request);
            }
        }
    }

    public void d() {
        this.c = true;
        for (Request request : Util.k(this.f2683a)) {
            if (request.isRunning()) {
                request.pause();
                this.b.add(request);
            }
        }
    }

    public void e() {
        for (Request request : Util.k(this.f2683a)) {
            if (!request.f() && !request.e()) {
                request.clear();
                if (!this.c) {
                    request.i();
                } else {
                    this.b.add(request);
                }
            }
        }
    }

    public void f() {
        this.c = false;
        for (Request request : Util.k(this.f2683a)) {
            if (!request.f() && !request.isRunning()) {
                request.i();
            }
        }
        this.b.clear();
    }

    public void g(Request request) {
        this.f2683a.add(request);
        if (!this.c) {
            request.i();
            return;
        }
        request.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.b.add(request);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f2683a.size() + ", isPaused=" + this.c + "}";
    }
}

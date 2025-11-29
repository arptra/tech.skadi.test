package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

public final class ErrorRequestCoordinator implements RequestCoordinator, Request {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2708a;
    public final RequestCoordinator b;
    public volatile Request c;
    public volatile Request d;
    public RequestCoordinator.RequestState e;
    public RequestCoordinator.RequestState f;

    public ErrorRequestCoordinator(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.e = requestState;
        this.f = requestState;
        this.f2708a = obj;
        this.b = requestCoordinator;
    }

    public boolean a() {
        boolean z;
        synchronized (this.f2708a) {
            try {
                if (!this.c.a()) {
                    if (!this.d.a()) {
                        z = false;
                    }
                }
                z = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public void b(Request request) {
        synchronized (this.f2708a) {
            try {
                if (request.equals(this.c)) {
                    this.e = RequestCoordinator.RequestState.SUCCESS;
                } else if (request.equals(this.d)) {
                    this.f = RequestCoordinator.RequestState.SUCCESS;
                }
                RequestCoordinator requestCoordinator = this.b;
                if (requestCoordinator != null) {
                    requestCoordinator.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean c(Request request) {
        boolean z;
        synchronized (this.f2708a) {
            try {
                z = m() && k(request);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public void clear() {
        synchronized (this.f2708a) {
            try {
                RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
                this.e = requestState;
                this.c.clear();
                if (this.f != requestState) {
                    this.f = requestState;
                    this.d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean d(Request request) {
        boolean n;
        synchronized (this.f2708a) {
            n = n();
        }
        return n;
    }

    public boolean e() {
        boolean z;
        synchronized (this.f2708a) {
            try {
                RequestCoordinator.RequestState requestState = this.e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
                z = requestState == requestState2 && this.f == requestState2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public boolean f() {
        boolean z;
        synchronized (this.f2708a) {
            try {
                RequestCoordinator.RequestState requestState = this.e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
                if (requestState != requestState2) {
                    if (this.f != requestState2) {
                        z = false;
                    }
                }
                z = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public boolean g(Request request) {
        if (!(request instanceof ErrorRequestCoordinator)) {
            return false;
        }
        ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
        return this.c.g(errorRequestCoordinator.c) && this.d.g(errorRequestCoordinator.d);
    }

    public RequestCoordinator getRoot() {
        synchronized (this.f2708a) {
            try {
                RequestCoordinator requestCoordinator = this.b;
                this = this;
                if (requestCoordinator != null) {
                    this = requestCoordinator.getRoot();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f2708a
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.d     // Catch:{ all -> 0x001d }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x001d }
            if (r3 != 0) goto L_0x0021
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x001d }
            r2.e = r3     // Catch:{ all -> 0x001d }
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.f     // Catch:{ all -> 0x001d }
            com.bumptech.glide.request.RequestCoordinator$RequestState r1 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING     // Catch:{ all -> 0x001d }
            if (r3 == r1) goto L_0x001f
            r2.f = r1     // Catch:{ all -> 0x001d }
            com.bumptech.glide.request.Request r2 = r2.d     // Catch:{ all -> 0x001d }
            r2.i()     // Catch:{ all -> 0x001d }
            goto L_0x001f
        L_0x001d:
            r2 = move-exception
            goto L_0x002e
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            return
        L_0x0021:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x001d }
            r2.f = r3     // Catch:{ all -> 0x001d }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.b     // Catch:{ all -> 0x001d }
            if (r3 == 0) goto L_0x002c
            r3.h(r2)     // Catch:{ all -> 0x001d }
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            return
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ErrorRequestCoordinator.h(com.bumptech.glide.request.Request):void");
    }

    public void i() {
        synchronized (this.f2708a) {
            try {
                RequestCoordinator.RequestState requestState = this.e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.e = requestState2;
                    this.c.i();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.f2708a) {
            try {
                RequestCoordinator.RequestState requestState = this.e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    if (this.f != requestState2) {
                        z = false;
                    }
                }
                z = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public boolean j(Request request) {
        boolean z;
        synchronized (this.f2708a) {
            try {
                z = l() && request.equals(this.c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        r2 = r2.f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            com.bumptech.glide.request.RequestCoordinator$RequestState r0 = r2.e
            com.bumptech.glide.request.RequestCoordinator$RequestState r1 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED
            if (r0 == r1) goto L_0x000d
            com.bumptech.glide.request.Request r2 = r2.c
            boolean r2 = r3.equals(r2)
            return r2
        L_0x000d:
            com.bumptech.glide.request.Request r0 = r2.d
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x001f
            com.bumptech.glide.request.RequestCoordinator$RequestState r2 = r2.f
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS
            if (r2 == r3) goto L_0x001d
            if (r2 != r1) goto L_0x001f
        L_0x001d:
            r2 = 1
            goto L_0x0020
        L_0x001f:
            r2 = 0
        L_0x0020:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ErrorRequestCoordinator.k(com.bumptech.glide.request.Request):boolean");
    }

    public final boolean l() {
        RequestCoordinator requestCoordinator = this.b;
        return requestCoordinator == null || requestCoordinator.j(this);
    }

    public final boolean m() {
        RequestCoordinator requestCoordinator = this.b;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    public final boolean n() {
        RequestCoordinator requestCoordinator = this.b;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    public void o(Request request, Request request2) {
        this.c = request;
        this.d = request2;
    }

    public void pause() {
        synchronized (this.f2708a) {
            try {
                RequestCoordinator.RequestState requestState = this.e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState == requestState2) {
                    this.e = RequestCoordinator.RequestState.PAUSED;
                    this.c.pause();
                }
                if (this.f == requestState2) {
                    this.f = RequestCoordinator.RequestState.PAUSED;
                    this.d.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

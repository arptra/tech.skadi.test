package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {

    /* renamed from: a  reason: collision with root package name */
    public final RequestCoordinator f2711a;
    public final Object b;
    public volatile Request c;
    public volatile Request d;
    public RequestCoordinator.RequestState e;
    public RequestCoordinator.RequestState f;
    public boolean g;

    public ThumbnailRequestCoordinator(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.e = requestState;
        this.f = requestState;
        this.b = obj;
        this.f2711a = requestCoordinator;
    }

    private boolean k() {
        RequestCoordinator requestCoordinator = this.f2711a;
        return requestCoordinator == null || requestCoordinator.j(this);
    }

    private boolean l() {
        RequestCoordinator requestCoordinator = this.f2711a;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.f2711a;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    public boolean a() {
        boolean z;
        synchronized (this.b) {
            try {
                if (!this.d.a()) {
                    if (!this.c.a()) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.b
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.d     // Catch:{ all -> 0x0011 }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x0011 }
            if (r3 == 0) goto L_0x0013
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x0011 }
            r2.f = r3     // Catch:{ all -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0011:
            r2 = move-exception
            goto L_0x002d
        L_0x0013:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x0011 }
            r2.e = r3     // Catch:{ all -> 0x0011 }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f2711a     // Catch:{ all -> 0x0011 }
            if (r3 == 0) goto L_0x001e
            r3.b(r2)     // Catch:{ all -> 0x0011 }
        L_0x001e:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.f     // Catch:{ all -> 0x0011 }
            boolean r3 = r3.isComplete()     // Catch:{ all -> 0x0011 }
            if (r3 != 0) goto L_0x002b
            com.bumptech.glide.request.Request r2 = r2.d     // Catch:{ all -> 0x0011 }
            r2.clear()     // Catch:{ all -> 0x0011 }
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.b(com.bumptech.glide.request.Request):void");
    }

    public boolean c(Request request) {
        boolean z;
        synchronized (this.b) {
            try {
                z = l() && request.equals(this.c) && !a();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public void clear() {
        synchronized (this.b) {
            this.g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.e = requestState;
            this.f = requestState;
            this.d.clear();
            this.c.clear();
        }
    }

    public boolean d(Request request) {
        boolean z;
        synchronized (this.b) {
            try {
                if (m()) {
                    if (!request.equals(this.c)) {
                        if (this.e != RequestCoordinator.RequestState.SUCCESS) {
                        }
                    }
                    z = true;
                }
                z = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public boolean e() {
        boolean z;
        synchronized (this.b) {
            z = this.e == RequestCoordinator.RequestState.CLEARED;
        }
        return z;
    }

    public boolean f() {
        boolean z;
        synchronized (this.b) {
            z = this.e == RequestCoordinator.RequestState.SUCCESS;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g(com.bumptech.glide.request.Request r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.bumptech.glide.request.ThumbnailRequestCoordinator
            r1 = 0
            if (r0 == 0) goto L_0x002e
            com.bumptech.glide.request.ThumbnailRequestCoordinator r4 = (com.bumptech.glide.request.ThumbnailRequestCoordinator) r4
            com.bumptech.glide.request.Request r0 = r3.c
            if (r0 != 0) goto L_0x0010
            com.bumptech.glide.request.Request r0 = r4.c
            if (r0 != 0) goto L_0x002e
            goto L_0x001a
        L_0x0010:
            com.bumptech.glide.request.Request r0 = r3.c
            com.bumptech.glide.request.Request r2 = r4.c
            boolean r0 = r0.g(r2)
            if (r0 == 0) goto L_0x002e
        L_0x001a:
            com.bumptech.glide.request.Request r0 = r3.d
            if (r0 != 0) goto L_0x0023
            com.bumptech.glide.request.Request r3 = r4.d
            if (r3 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0023:
            com.bumptech.glide.request.Request r3 = r3.d
            com.bumptech.glide.request.Request r4 = r4.d
            boolean r3 = r3.g(r4)
            if (r3 == 0) goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.g(com.bumptech.glide.request.Request):boolean");
    }

    public RequestCoordinator getRoot() {
        synchronized (this.b) {
            try {
                RequestCoordinator requestCoordinator = this.f2711a;
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

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.b
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.c     // Catch:{ all -> 0x0011 }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x0011 }
            if (r3 != 0) goto L_0x0013
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x0011 }
            r2.f = r3     // Catch:{ all -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0011:
            r2 = move-exception
            goto L_0x0020
        L_0x0013:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x0011 }
            r2.e = r3     // Catch:{ all -> 0x0011 }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f2711a     // Catch:{ all -> 0x0011 }
            if (r3 == 0) goto L_0x001e
            r3.h(r2)     // Catch:{ all -> 0x0011 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.h(com.bumptech.glide.request.Request):void");
    }

    public void i() {
        RequestCoordinator.RequestState requestState;
        RequestCoordinator.RequestState requestState2;
        synchronized (this.b) {
            try {
                this.g = true;
                if (!(this.e == RequestCoordinator.RequestState.SUCCESS || this.f == (requestState2 = RequestCoordinator.RequestState.RUNNING))) {
                    this.f = requestState2;
                    this.d.i();
                }
                if (this.g && this.e != (requestState = RequestCoordinator.RequestState.RUNNING)) {
                    this.e = requestState;
                    this.c.i();
                }
                this.g = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.b) {
            z = this.e == RequestCoordinator.RequestState.RUNNING;
        }
        return z;
    }

    public boolean j(Request request) {
        boolean z;
        synchronized (this.b) {
            try {
                z = k() && request.equals(this.c) && this.e != RequestCoordinator.RequestState.PAUSED;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public void n(Request request, Request request2) {
        this.c = request;
        this.d = request2;
    }

    public void pause() {
        synchronized (this.b) {
            try {
                if (!this.f.isComplete()) {
                    this.f = RequestCoordinator.RequestState.PAUSED;
                    this.d.pause();
                }
                if (!this.e.isComplete()) {
                    this.e = RequestCoordinator.RequestState.PAUSED;
                    this.c.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

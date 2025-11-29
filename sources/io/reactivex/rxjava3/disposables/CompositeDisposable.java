package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.OpenHashSet;
import java.util.ArrayList;
import java.util.Objects;

public final class CompositeDisposable implements Disposable, DisposableContainer {
    volatile boolean disposed;
    OpenHashSet<Disposable> resources;

    public CompositeDisposable() {
    }

    public boolean add(@NonNull Disposable disposable) {
        Objects.requireNonNull(disposable, "disposable is null");
        if (!this.disposed) {
            synchronized (this) {
                try {
                    if (!this.disposed) {
                        OpenHashSet<Disposable> openHashSet = this.resources;
                        if (openHashSet == null) {
                            openHashSet = new OpenHashSet<>();
                            this.resources = openHashSet;
                        }
                        openHashSet.add(disposable);
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    public boolean addAll(@NonNull Disposable... disposableArr) {
        Objects.requireNonNull(disposableArr, "disposables is null");
        if (!this.disposed) {
            synchronized (this) {
                try {
                    if (!this.disposed) {
                        OpenHashSet<Disposable> openHashSet = this.resources;
                        if (openHashSet == null) {
                            openHashSet = new OpenHashSet<>(disposableArr.length + 1);
                            this.resources = openHashSet;
                        }
                        for (Disposable disposable : disposableArr) {
                            Objects.requireNonNull(disposable, "A Disposable in the disposables array is null");
                            openHashSet.add(disposable);
                        }
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        for (Disposable dispose : disposableArr) {
            dispose.dispose();
        }
        return false;
    }

    public void clear() {
        if (!this.disposed) {
            synchronized (this) {
                try {
                    if (!this.disposed) {
                        OpenHashSet<Disposable> openHashSet = this.resources;
                        this.resources = null;
                        dispose(openHashSet);
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean delete(@io.reactivex.rxjava3.annotations.NonNull io.reactivex.rxjava3.disposables.Disposable r3) {
        /*
            r2 = this;
            java.lang.String r0 = "disposable is null"
            java.util.Objects.requireNonNull(r3, r0)
            boolean r0 = r2.disposed
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.disposed     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0014
            monitor-exit(r2)     // Catch:{ all -> 0x0012 }
            return r1
        L_0x0012:
            r3 = move-exception
            goto L_0x0024
        L_0x0014:
            io.reactivex.rxjava3.internal.util.OpenHashSet<io.reactivex.rxjava3.disposables.Disposable> r0 = r2.resources     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0022
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0012 }
            if (r3 != 0) goto L_0x001f
            goto L_0x0022
        L_0x001f:
            monitor-exit(r2)     // Catch:{ all -> 0x0012 }
            r2 = 1
            return r2
        L_0x0022:
            monitor-exit(r2)     // Catch:{ all -> 0x0012 }
            return r1
        L_0x0024:
            monitor-exit(r2)     // Catch:{ all -> 0x0012 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.disposables.CompositeDisposable.delete(io.reactivex.rxjava3.disposables.Disposable):boolean");
    }

    public void dispose() {
        if (!this.disposed) {
            synchronized (this) {
                try {
                    if (!this.disposed) {
                        this.disposed = true;
                        OpenHashSet<Disposable> openHashSet = this.resources;
                        this.resources = null;
                        dispose(openHashSet);
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public boolean remove(@NonNull Disposable disposable) {
        if (!delete(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0018, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int size() {
        /*
            r2 = this;
            boolean r0 = r2.disposed
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            monitor-enter(r2)
            boolean r0 = r2.disposed     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x000f
            monitor-exit(r2)     // Catch:{ all -> 0x000d }
            return r1
        L_0x000d:
            r0 = move-exception
            goto L_0x0019
        L_0x000f:
            io.reactivex.rxjava3.internal.util.OpenHashSet<io.reactivex.rxjava3.disposables.Disposable> r0 = r2.resources     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x0017
            int r1 = r0.size()     // Catch:{ all -> 0x000d }
        L_0x0017:
            monitor-exit(r2)     // Catch:{ all -> 0x000d }
            return r1
        L_0x0019:
            monitor-exit(r2)     // Catch:{ all -> 0x000d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.disposables.CompositeDisposable.size():int");
    }

    public CompositeDisposable(@NonNull Disposable... disposableArr) {
        Objects.requireNonNull(disposableArr, "disposables is null");
        this.resources = new OpenHashSet<>(disposableArr.length + 1);
        for (Disposable disposable : disposableArr) {
            Objects.requireNonNull(disposable, "A Disposable in the disposables array is null");
            this.resources.add(disposable);
        }
    }

    public CompositeDisposable(@NonNull Iterable<? extends Disposable> iterable) {
        Objects.requireNonNull(iterable, "disposables is null");
        this.resources = new OpenHashSet<>();
        for (Disposable disposable : iterable) {
            Objects.requireNonNull(disposable, "A Disposable item in the disposables sequence is null");
            this.resources.add(disposable);
        }
    }

    public void dispose(@Nullable OpenHashSet<Disposable> openHashSet) {
        if (openHashSet != null) {
            ArrayList arrayList = null;
            for (Object obj : openHashSet.keys()) {
                if (obj instanceof Disposable) {
                    try {
                        ((Disposable) obj).dispose();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th);
                    }
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw ExceptionHelper.wrapOrThrow((Throwable) arrayList.get(0));
            }
            throw new CompositeException((Iterable<? extends Throwable>) arrayList);
        }
    }
}

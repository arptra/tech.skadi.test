package io.reactivex.rxjava3.internal.disposables;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class ListCompositeDisposable implements Disposable, DisposableContainer {
    volatile boolean disposed;
    List<Disposable> resources;

    public ListCompositeDisposable() {
    }

    public boolean add(Disposable disposable) {
        Objects.requireNonNull(disposable, "d is null");
        if (!this.disposed) {
            synchronized (this) {
                try {
                    if (!this.disposed) {
                        List list = this.resources;
                        if (list == null) {
                            list = new LinkedList();
                            this.resources = list;
                        }
                        list.add(disposable);
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

    public boolean addAll(Disposable... disposableArr) {
        Objects.requireNonNull(disposableArr, "ds is null");
        if (!this.disposed) {
            synchronized (this) {
                try {
                    if (!this.disposed) {
                        List list = this.resources;
                        if (list == null) {
                            list = new LinkedList();
                            this.resources = list;
                        }
                        for (Disposable disposable : disposableArr) {
                            Objects.requireNonNull(disposable, "d is null");
                            list.add(disposable);
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
                        List<Disposable> list = this.resources;
                        this.resources = null;
                        dispose(list);
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
    public boolean delete(io.reactivex.rxjava3.disposables.Disposable r3) {
        /*
            r2 = this;
            java.lang.String r0 = "Disposable item is null"
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
            java.util.List<io.reactivex.rxjava3.disposables.Disposable> r0 = r2.resources     // Catch:{ all -> 0x0012 }
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
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable.delete(io.reactivex.rxjava3.disposables.Disposable):boolean");
    }

    public void dispose() {
        if (!this.disposed) {
            synchronized (this) {
                try {
                    if (!this.disposed) {
                        this.disposed = true;
                        List<Disposable> list = this.resources;
                        this.resources = null;
                        dispose(list);
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

    public boolean remove(Disposable disposable) {
        if (!delete(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }

    public ListCompositeDisposable(Disposable... disposableArr) {
        Objects.requireNonNull(disposableArr, "resources is null");
        this.resources = new LinkedList();
        for (Disposable disposable : disposableArr) {
            Objects.requireNonNull(disposable, "Disposable item is null");
            this.resources.add(disposable);
        }
    }

    public ListCompositeDisposable(Iterable<? extends Disposable> iterable) {
        Objects.requireNonNull(iterable, "resources is null");
        this.resources = new LinkedList();
        for (Disposable disposable : iterable) {
            Objects.requireNonNull(disposable, "Disposable item is null");
            this.resources.add(disposable);
        }
    }

    public void dispose(List<Disposable> list) {
        if (list != null) {
            ArrayList arrayList = null;
            for (Disposable dispose : list) {
                try {
                    dispose.dispose();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
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

package io.reactivex.rxjava3.internal.operators.observable;

import com.honey.account.x.c;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {
    final AtomicReference<PublishConnection<T>> current = new AtomicReference<>();
    final ObservableSource<T> source;

    public static final class InnerDisposable<T> extends AtomicReference<PublishConnection<T>> implements Disposable {
        private static final long serialVersionUID = 7463222674719692880L;
        final Observer<? super T> downstream;

        public InnerDisposable(Observer<? super T> observer, PublishConnection<T> publishConnection) {
            this.downstream = observer;
            lazySet(publishConnection);
        }

        public void dispose() {
            PublishConnection publishConnection = (PublishConnection) getAndSet((Object) null);
            if (publishConnection != null) {
                publishConnection.remove(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }

    public static final class PublishConnection<T> extends AtomicReference<InnerDisposable<T>[]> implements Observer<T>, Disposable {
        static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        private static final long serialVersionUID = -3251430252873581268L;
        final AtomicBoolean connect = new AtomicBoolean();
        final AtomicReference<PublishConnection<T>> current;
        Throwable error;
        final AtomicReference<Disposable> upstream;

        public PublishConnection(AtomicReference<PublishConnection<T>> atomicReference) {
            this.current = atomicReference;
            this.upstream = new AtomicReference<>();
            lazySet(EMPTY);
        }

        public boolean add(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) get();
                if (innerDisposableArr == TERMINATED) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        public void dispose() {
            getAndSet(TERMINATED);
            c.a(this.current, this, (Object) null);
            DisposableHelper.dispose(this.upstream);
        }

        public boolean isDisposed() {
            return get() == TERMINATED;
        }

        public void onComplete() {
            this.upstream.lazySet(DisposableHelper.DISPOSED);
            for (InnerDisposable innerDisposable : (InnerDisposable[]) getAndSet(TERMINATED)) {
                innerDisposable.downstream.onComplete();
            }
        }

        public void onError(Throwable th) {
            Disposable disposable = this.upstream.get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.error = th;
                this.upstream.lazySet(disposableHelper);
                for (InnerDisposable innerDisposable : (InnerDisposable[]) getAndSet(TERMINATED)) {
                    innerDisposable.downstream.onError(th);
                }
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onNext(T t) {
            for (InnerDisposable innerDisposable : (InnerDisposable[]) get()) {
                innerDisposable.downstream.onNext(t);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        public void remove(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            i = -1;
                            break;
                        } else if (innerDisposableArr[i] == innerDisposable) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i >= 0) {
                        innerDisposableArr2 = EMPTY;
                        if (length != 1) {
                            innerDisposableArr2 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, i);
                            System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr2, i, (length - i) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
        }
    }

    public ObservablePublish(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(io.reactivex.rxjava3.functions.Consumer<? super io.reactivex.rxjava3.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r0 = r4.current
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection r0 = (io.reactivex.rxjava3.internal.operators.observable.ObservablePublish.PublishConnection) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0021
        L_0x0010:
            io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection r1 = new io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r2 = r4.current
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r2 = r4.current
            boolean r0 = com.honey.account.x.c.a(r2, r0, r1)
            if (r0 != 0) goto L_0x0020
            goto L_0x0000
        L_0x0020:
            r0 = r1
        L_0x0021:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.connect
            boolean r1 = r1.get()
            r2 = 0
            if (r1 != 0) goto L_0x0034
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.connect
            r3 = 1
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x0034
            r2 = r3
        L_0x0034:
            r5.accept(r0)     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x003e
            io.reactivex.rxjava3.core.ObservableSource<T> r4 = r4.source
            r4.subscribe(r0)
        L_0x003e:
            return
        L_0x003f:
            r4 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
            java.lang.RuntimeException r4 = io.reactivex.rxjava3.internal.util.ExceptionHelper.wrapOrThrow(r4)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservablePublish.connect(io.reactivex.rxjava3.functions.Consumer):void");
    }

    public void reset() {
        PublishConnection publishConnection = this.current.get();
        if (publishConnection != null && publishConnection.isDisposed()) {
            c.a(this.current, publishConnection, (Object) null);
        }
    }

    public ObservableSource<T> source() {
        return this.source;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void subscribeActual(io.reactivex.rxjava3.core.Observer<? super T> r4) {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r0 = r3.current
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection r0 = (io.reactivex.rxjava3.internal.operators.observable.ObservablePublish.PublishConnection) r0
            if (r0 != 0) goto L_0x001b
            io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection r1 = new io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r2 = r3.current
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r2 = r3.current
            boolean r0 = com.honey.account.x.c.a(r2, r0, r1)
            if (r0 != 0) goto L_0x001a
            goto L_0x0000
        L_0x001a:
            r0 = r1
        L_0x001b:
            io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$InnerDisposable r3 = new io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$InnerDisposable
            r3.<init>(r4, r0)
            r4.onSubscribe(r3)
            boolean r1 = r0.add(r3)
            if (r1 == 0) goto L_0x0033
            boolean r4 = r3.isDisposed()
            if (r4 == 0) goto L_0x0032
            r0.remove(r3)
        L_0x0032:
            return
        L_0x0033:
            java.lang.Throwable r3 = r0.error
            if (r3 == 0) goto L_0x003b
            r4.onError(r3)
            goto L_0x003e
        L_0x003b:
            r4.onComplete()
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservablePublish.subscribeActual(io.reactivex.rxjava3.core.Observer):void");
    }
}

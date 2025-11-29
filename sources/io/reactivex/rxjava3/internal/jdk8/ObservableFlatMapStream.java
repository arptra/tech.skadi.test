package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public final class ObservableFlatMapStream<T, R> extends Observable<R> {
    final Function<? super T, ? extends Stream<? extends R>> mapper;
    final Observable<T> source;

    public static final class FlatMapStreamObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5127032662980523968L;
        volatile boolean disposed;
        boolean done;
        final Observer<? super R> downstream;
        final Function<? super T, ? extends Stream<? extends R>> mapper;
        Disposable upstream;

        public FlatMapStreamObserver(Observer<? super R> observer, Function<? super T, ? extends Stream<? extends R>> function) {
            this.downstream = observer;
            this.mapper = function;
        }

        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }

        public void onError(@NonNull Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public void onNext(@NonNull T t) {
            if (!this.done) {
                try {
                    Object apply = this.mapper.apply(t);
                    Objects.requireNonNull(apply, "The mapper returned a null Stream");
                    Stream stream = (Stream) apply;
                    try {
                        Iterator it = stream.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (!this.disposed) {
                                    Object next = it.next();
                                    Objects.requireNonNull(next, "The Stream's Iterator.next returned a null value");
                                    if (!this.disposed) {
                                        this.downstream.onNext(next);
                                        if (this.disposed) {
                                            this.done = true;
                                            break;
                                        }
                                    } else {
                                        this.done = true;
                                        break;
                                    }
                                } else {
                                    this.done = true;
                                    break;
                                }
                            }
                        }
                        stream.close();
                    } catch (Throwable th) {
                        stream.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.upstream.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(@NonNull Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapStream(Observable<T> observable, Function<? super T, ? extends Stream<? extends R>> function) {
        this.source = observable;
        this.mapper = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        Stream stream;
        Observable<T> observable = this.source;
        if (observable instanceof Supplier) {
            try {
                Object obj = ((Supplier) observable).get();
                if (obj != null) {
                    Object apply = this.mapper.apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null Stream");
                    stream = (Stream) apply;
                } else {
                    stream = null;
                }
                if (stream != null) {
                    ObservableFromStream.subscribeStream(observer, stream);
                } else {
                    EmptyDisposable.complete((Observer<?>) observer);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, (Observer<?>) observer);
            }
        } else {
            observable.subscribe((Observer<? super T>) new FlatMapStreamObserver(observer, this.mapper));
        }
    }
}

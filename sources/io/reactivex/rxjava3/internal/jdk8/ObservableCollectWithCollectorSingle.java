package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;

public final class ObservableCollectWithCollectorSingle<T, A, R> extends Single<R> implements FuseToObservable<R> {
    final Collector<T, A, R> collector;
    final Observable<T> source;

    public static final class CollectorSingleObserver<T, A, R> implements Observer<T>, Disposable {
        final BiConsumer<A, T> accumulator;
        A container;
        boolean done;
        final SingleObserver<? super R> downstream;
        final Function<A, R> finisher;
        Disposable upstream;

        public CollectorSingleObserver(SingleObserver<? super R> singleObserver, A a2, BiConsumer<A, T> biConsumer, Function<A, R> function) {
            this.downstream = singleObserver;
            this.container = a2;
            this.accumulator = biConsumer;
            this.finisher = function;
        }

        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.upstream == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.upstream = DisposableHelper.DISPOSED;
                A a2 = this.container;
                this.container = null;
                try {
                    R apply = this.finisher.apply(a2);
                    Objects.requireNonNull(apply, "The finisher returned a null value");
                    this.downstream.onSuccess(apply);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.downstream.onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.upstream = DisposableHelper.DISPOSED;
            this.container = null;
            this.downstream.onError(th);
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.accumulator.accept(this.container, t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.dispose();
                    onError(th);
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

    public ObservableCollectWithCollectorSingle(Observable<T> observable, Collector<T, A, R> collector2) {
        this.source = observable;
        this.collector = collector2;
    }

    public Observable<R> fuseToObservable() {
        return new ObservableCollectWithCollector(this.source, this.collector);
    }

    public void subscribeActual(@NonNull SingleObserver<? super R> singleObserver) {
        try {
            this.source.subscribe(new CollectorSingleObserver(singleObserver, this.collector.supplier().get(), this.collector.accumulator(), this.collector.finisher()));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }
}

package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapNotification<T, R> extends Single<R> {
    final Function<? super Throwable, ? extends SingleSource<? extends R>> onErrorMapper;
    final Function<? super T, ? extends SingleSource<? extends R>> onSuccessMapper;
    final SingleSource<T> source;

    public static final class FlatMapSingleObserver<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = 4375739915521278546L;
        final SingleObserver<? super R> downstream;
        final Function<? super Throwable, ? extends SingleSource<? extends R>> onErrorMapper;
        final Function<? super T, ? extends SingleSource<? extends R>> onSuccessMapper;
        Disposable upstream;

        public final class InnerObserver implements SingleObserver<R> {
            public InnerObserver() {
            }

            public void onError(Throwable th) {
                FlatMapSingleObserver.this.downstream.onError(th);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(FlatMapSingleObserver.this, disposable);
            }

            public void onSuccess(R r) {
                FlatMapSingleObserver.this.downstream.onSuccess(r);
            }
        }

        public FlatMapSingleObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function, Function<? super Throwable, ? extends SingleSource<? extends R>> function2) {
            this.downstream = singleObserver;
            this.onSuccessMapper = function;
            this.onErrorMapper = function2;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th) {
            try {
                Object apply = this.onErrorMapper.apply(th);
                Objects.requireNonNull(apply, "The onErrorMapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                if (!isDisposed()) {
                    singleSource.subscribe(new InnerObserver());
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            try {
                Object apply = this.onSuccessMapper.apply(t);
                Objects.requireNonNull(apply, "The onSuccessMapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                if (!isDisposed()) {
                    singleSource.subscribe(new InnerObserver());
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }
    }

    public SingleFlatMapNotification(SingleSource<T> singleSource, Function<? super T, ? extends SingleSource<? extends R>> function, Function<? super Throwable, ? extends SingleSource<? extends R>> function2) {
        this.source = singleSource;
        this.onSuccessMapper = function;
        this.onErrorMapper = function2;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.source.subscribe(new FlatMapSingleObserver(singleObserver, this.onSuccessMapper, this.onErrorMapper));
    }
}

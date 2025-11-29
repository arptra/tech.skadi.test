package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.Optional;

public final class SingleMapOptional<T, R> extends Maybe<R> {
    final Function<? super T, Optional<? extends R>> mapper;
    final Single<T> source;

    public static final class MapOptionalSingleObserver<T, R> implements SingleObserver<T>, Disposable {
        final MaybeObserver<? super R> downstream;
        final Function<? super T, Optional<? extends R>> mapper;
        Disposable upstream;

        public MapOptionalSingleObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, Optional<? extends R>> function) {
            this.downstream = maybeObserver;
            this.mapper = function;
        }

        public void dispose() {
            Disposable disposable = this.upstream;
            this.upstream = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            try {
                Optional<? extends R> apply = this.mapper.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null item");
                Optional optional = apply;
                if (optional.isPresent()) {
                    this.downstream.onSuccess(optional.get());
                } else {
                    this.downstream.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }
    }

    public SingleMapOptional(Single<T> single, Function<? super T, Optional<? extends R>> function) {
        this.source = single;
        this.mapper = function;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe(new MapOptionalSingleObserver(maybeObserver, this.mapper));
    }
}

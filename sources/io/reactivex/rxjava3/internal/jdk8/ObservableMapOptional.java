package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;
import java.util.Objects;
import java.util.Optional;

public final class ObservableMapOptional<T, R> extends Observable<R> {
    final Function<? super T, Optional<? extends R>> mapper;
    final Observable<T> source;

    public static final class MapOptionalObserver<T, R> extends BasicFuseableObserver<T, R> {
        final Function<? super T, Optional<? extends R>> mapper;

        public MapOptionalObserver(Observer<? super R> observer, Function<? super T, Optional<? extends R>> function) {
            super(observer);
            this.mapper = function;
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.downstream.onNext(null);
                    return;
                }
                try {
                    Optional<? extends R> apply = this.mapper.apply(t);
                    Objects.requireNonNull(apply, "The mapper returned a null Optional");
                    Optional optional = apply;
                    if (optional.isPresent()) {
                        this.downstream.onNext(optional.get());
                    }
                } catch (Throwable th) {
                    fail(th);
                }
            }
        }

        public R poll() throws Throwable {
            Optional optional;
            do {
                T poll = this.qd.poll();
                if (poll == null) {
                    return null;
                }
                Optional<? extends R> apply = this.mapper.apply(poll);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                optional = apply;
            } while (!optional.isPresent());
            return optional.get();
        }

        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public ObservableMapOptional(Observable<T> observable, Function<? super T, Optional<? extends R>> function) {
        this.source = observable;
        this.mapper = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new MapOptionalObserver(observer, this.mapper));
    }
}

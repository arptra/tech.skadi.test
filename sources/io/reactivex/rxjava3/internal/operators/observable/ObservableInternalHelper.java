package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class ObservableInternalHelper {

    public static final class BufferedReplaySupplier<T> implements Supplier<ConnectableObservable<T>> {
        final int bufferSize;
        final boolean eagerTruncate;
        final Observable<T> parent;

        public BufferedReplaySupplier(Observable<T> observable, int i, boolean z) {
            this.parent = observable;
            this.bufferSize = i;
            this.eagerTruncate = z;
        }

        public ConnectableObservable<T> get() {
            return this.parent.replay(this.bufferSize, this.eagerTruncate);
        }
    }

    public static final class BufferedTimedReplaySupplier<T> implements Supplier<ConnectableObservable<T>> {
        final int bufferSize;
        final boolean eagerTruncate;
        final Observable<T> parent;
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;

        public BufferedTimedReplaySupplier(Observable<T> observable, int i, long j, TimeUnit timeUnit, Scheduler scheduler2, boolean z) {
            this.parent = observable;
            this.bufferSize = i;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.eagerTruncate = z;
        }

        public ConnectableObservable<T> get() {
            return this.parent.replay(this.bufferSize, this.time, this.unit, this.scheduler, this.eagerTruncate);
        }
    }

    public static final class FlatMapIntoIterable<T, U> implements Function<T, ObservableSource<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> mapper;

        public FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.mapper = function;
        }

        public ObservableSource<U> apply(T t) throws Throwable {
            Object apply = this.mapper.apply(t);
            Objects.requireNonNull(apply, "The mapper returned a null Iterable");
            return new ObservableFromIterable((Iterable) apply);
        }
    }

    public static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final T t;

        public FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t2) {
            this.combiner = biFunction;
            this.t = t2;
        }

        public R apply(U u) throws Throwable {
            return this.combiner.apply(this.t, u);
        }
    }

    public static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, ObservableSource<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final Function<? super T, ? extends ObservableSource<? extends U>> mapper;

        public FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
            this.combiner = biFunction;
            this.mapper = function;
        }

        public ObservableSource<R> apply(T t) throws Throwable {
            Object apply = this.mapper.apply(t);
            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
            return new ObservableMap((ObservableSource) apply, new FlatMapWithCombinerInner(this.combiner, t));
        }
    }

    public static final class ItemDelayFunction<T, U> implements Function<T, ObservableSource<T>> {
        final Function<? super T, ? extends ObservableSource<U>> itemDelay;

        public ItemDelayFunction(Function<? super T, ? extends ObservableSource<U>> function) {
            this.itemDelay = function;
        }

        public ObservableSource<T> apply(T t) throws Throwable {
            Object apply = this.itemDelay.apply(t);
            Objects.requireNonNull(apply, "The itemDelay returned a null ObservableSource");
            return new ObservableTake((ObservableSource) apply, 1).map(Functions.justFunction(t)).defaultIfEmpty(t);
        }
    }

    public enum MapToInt implements Function<Object, Object> {
        INSTANCE;

        public Object apply(Object obj) {
            return 0;
        }
    }

    public static final class ObserverOnComplete<T> implements Action {
        final Observer<T> observer;

        public ObserverOnComplete(Observer<T> observer2) {
            this.observer = observer2;
        }

        public void run() {
            this.observer.onComplete();
        }
    }

    public static final class ObserverOnError<T> implements Consumer<Throwable> {
        final Observer<T> observer;

        public ObserverOnError(Observer<T> observer2) {
            this.observer = observer2;
        }

        public void accept(Throwable th) {
            this.observer.onError(th);
        }
    }

    public static final class ObserverOnNext<T> implements Consumer<T> {
        final Observer<T> observer;

        public ObserverOnNext(Observer<T> observer2) {
            this.observer = observer2;
        }

        public void accept(T t) {
            this.observer.onNext(t);
        }
    }

    public static final class ReplaySupplier<T> implements Supplier<ConnectableObservable<T>> {
        private final Observable<T> parent;

        public ReplaySupplier(Observable<T> observable) {
            this.parent = observable;
        }

        public ConnectableObservable<T> get() {
            return this.parent.replay();
        }
    }

    public static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final BiConsumer<S, Emitter<T>> consumer;

        public SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            this.consumer = biConsumer;
        }

        public S apply(S s, Emitter<T> emitter) throws Throwable {
            this.consumer.accept(s, emitter);
            return s;
        }
    }

    public static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final Consumer<Emitter<T>> consumer;

        public SimpleGenerator(Consumer<Emitter<T>> consumer2) {
            this.consumer = consumer2;
        }

        public S apply(S s, Emitter<T> emitter) throws Throwable {
            this.consumer.accept(emitter);
            return s;
        }
    }

    public static final class TimedReplayCallable<T> implements Supplier<ConnectableObservable<T>> {
        final boolean eagerTruncate;
        final Observable<T> parent;
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;

        public TimedReplayCallable(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler2, boolean z) {
            this.parent = observable;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.eagerTruncate = z;
        }

        public ConnectableObservable<T> get() {
            return this.parent.replay(this.time, this.unit, this.scheduler, this.eagerTruncate);
        }
    }

    private ObservableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Function<T, ObservableSource<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T, U, R> Function<T, ObservableSource<R>> flatMapWithCombiner(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, ObservableSource<T>> itemDelay(Function<? super T, ? extends ObservableSource<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Action observerOnComplete(Observer<T> observer) {
        return new ObserverOnComplete(observer);
    }

    public static <T> Consumer<Throwable> observerOnError(Observer<T> observer) {
        return new ObserverOnError(observer);
    }

    public static <T> Consumer<T> observerOnNext(Observer<T> observer) {
        return new ObserverOnNext(observer);
    }

    public static <T> Supplier<ConnectableObservable<T>> replaySupplier(Observable<T> observable) {
        return new ReplaySupplier(observable);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T> Supplier<ConnectableObservable<T>> replaySupplier(Observable<T> observable, int i, boolean z) {
        return new BufferedReplaySupplier(observable, i, z);
    }

    public static <T> Supplier<ConnectableObservable<T>> replaySupplier(Observable<T> observable, int i, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return new BufferedTimedReplaySupplier(observable, i, j, timeUnit, scheduler, z);
    }

    public static <T> Supplier<ConnectableObservable<T>> replaySupplier(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return new TimedReplayCallable(observable, j, timeUnit, scheduler, z);
    }
}

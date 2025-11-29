package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.fuseable.FuseToMaybe;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.internal.jdk8.CompletableFromCompletionStage;
import io.reactivex.rxjava3.internal.jdk8.CompletionStageConsumer;
import io.reactivex.rxjava3.internal.observers.BlockingDisposableMultiObserver;
import io.reactivex.rxjava3.internal.observers.BlockingMultiObserver;
import io.reactivex.rxjava3.internal.observers.CallbackCompletableObserver;
import io.reactivex.rxjava3.internal.observers.EmptyCompletableObserver;
import io.reactivex.rxjava3.internal.observers.FutureMultiObserver;
import io.reactivex.rxjava3.internal.observers.SafeCompletableObserver;
import io.reactivex.rxjava3.internal.operators.completable.CompletableAmb;
import io.reactivex.rxjava3.internal.operators.completable.CompletableAndThenCompletable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableCache;
import io.reactivex.rxjava3.internal.operators.completable.CompletableConcat;
import io.reactivex.rxjava3.internal.operators.completable.CompletableConcatArray;
import io.reactivex.rxjava3.internal.operators.completable.CompletableConcatIterable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableCreate;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDefer;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDelay;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDetach;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDisposeOn;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDoFinally;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDoOnEvent;
import io.reactivex.rxjava3.internal.operators.completable.CompletableEmpty;
import io.reactivex.rxjava3.internal.operators.completable.CompletableError;
import io.reactivex.rxjava3.internal.operators.completable.CompletableErrorSupplier;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromAction;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromCallable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromObservable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromPublisher;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromRunnable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromSingle;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromSupplier;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromUnsafeSource;
import io.reactivex.rxjava3.internal.operators.completable.CompletableHide;
import io.reactivex.rxjava3.internal.operators.completable.CompletableLift;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMaterialize;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMerge;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMergeArray;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMergeArrayDelayError;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMergeDelayErrorIterable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMergeIterable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableNever;
import io.reactivex.rxjava3.internal.operators.completable.CompletableObserveOn;
import io.reactivex.rxjava3.internal.operators.completable.CompletableOnErrorComplete;
import io.reactivex.rxjava3.internal.operators.completable.CompletableOnErrorReturn;
import io.reactivex.rxjava3.internal.operators.completable.CompletablePeek;
import io.reactivex.rxjava3.internal.operators.completable.CompletableResumeNext;
import io.reactivex.rxjava3.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.rxjava3.internal.operators.completable.CompletableTakeUntilCompletable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableTimeout;
import io.reactivex.rxjava3.internal.operators.completable.CompletableTimer;
import io.reactivex.rxjava3.internal.operators.completable.CompletableToFlowable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableToObservable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableToSingle;
import io.reactivex.rxjava3.internal.operators.completable.CompletableUsing;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDelayWithCompletable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromCompletable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeIgnoreElementCompletable;
import io.reactivex.rxjava3.internal.operators.mixed.CompletableAndThenObservable;
import io.reactivex.rxjava3.internal.operators.mixed.CompletableAndThenPublisher;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapCompletablePublisher;
import io.reactivex.rxjava3.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;

public abstract class Completable implements CompletableSource {
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable amb(@NonNull Iterable<? extends CompletableSource> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableAmb((CompletableSource[]) null, iterable));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static Completable ambArray(@NonNull CompletableSource... completableSourceArr) {
        Objects.requireNonNull(completableSourceArr, "sources is null");
        return completableSourceArr.length == 0 ? complete() : completableSourceArr.length == 1 ? wrap(completableSourceArr[0]) : RxJavaPlugins.onAssembly((Completable) new CompletableAmb(completableSourceArr, (Iterable<? extends CompletableSource>) null));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable complete() {
        return RxJavaPlugins.onAssembly(CompletableEmpty.INSTANCE);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable concat(@NonNull Iterable<? extends CompletableSource> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableConcatIterable(iterable));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static Completable concatArray(@NonNull CompletableSource... completableSourceArr) {
        Objects.requireNonNull(completableSourceArr, "sources is null");
        return completableSourceArr.length == 0 ? complete() : completableSourceArr.length == 1 ? wrap(completableSourceArr[0]) : RxJavaPlugins.onAssembly((Completable) new CompletableConcatArray(completableSourceArr));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static Completable concatArrayDelayError(@NonNull CompletableSource... completableSourceArr) {
        return Flowable.fromArray(completableSourceArr).concatMapCompletableDelayError(Functions.identity(), true, 2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable concatDelayError(@NonNull Iterable<? extends CompletableSource> iterable) {
        return Flowable.fromIterable(iterable).concatMapCompletableDelayError(Functions.identity());
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable create(@NonNull CompletableOnSubscribe completableOnSubscribe) {
        Objects.requireNonNull(completableOnSubscribe, "source is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableCreate(completableOnSubscribe));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable defer(@NonNull Supplier<? extends CompletableSource> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableDefer(supplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable error(@NonNull Supplier<? extends Throwable> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableErrorSupplier(supplier));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable fromAction(@NonNull Action action) {
        Objects.requireNonNull(action, "action is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromAction(action));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable fromCallable(@NonNull Callable<?> callable) {
        Objects.requireNonNull(callable, "callable is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromCallable(callable));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable fromCompletionStage(@NonNull CompletionStage<?> completionStage) {
        Objects.requireNonNull(completionStage, "stage is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromCompletionStage(completionStage));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable fromFuture(@NonNull Future<?> future) {
        Objects.requireNonNull(future, "future is null");
        return fromAction(Functions.futureAction(future));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Completable fromMaybe(@NonNull MaybeSource<T> maybeSource) {
        Objects.requireNonNull(maybeSource, "maybe is null");
        return RxJavaPlugins.onAssembly((Completable) new MaybeIgnoreElementCompletable(maybeSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Completable fromObservable(@NonNull ObservableSource<T> observableSource) {
        Objects.requireNonNull(observableSource, "observable is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromObservable(observableSource));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Completable fromPublisher(@NonNull Publisher<T> publisher) {
        Objects.requireNonNull(publisher, "publisher is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromPublisher(publisher));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable fromRunnable(@NonNull Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromRunnable(runnable));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Completable fromSingle(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "single is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromSingle(singleSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable fromSupplier(@NonNull Supplier<?> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromSupplier(supplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable merge(@NonNull Iterable<? extends CompletableSource> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableMergeIterable(iterable));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    private static Completable merge0(@NonNull Publisher<? extends CompletableSource> publisher, int i, boolean z) {
        Objects.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        return RxJavaPlugins.onAssembly((Completable) new CompletableMerge(publisher, i, z));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static Completable mergeArray(@NonNull CompletableSource... completableSourceArr) {
        Objects.requireNonNull(completableSourceArr, "sources is null");
        return completableSourceArr.length == 0 ? complete() : completableSourceArr.length == 1 ? wrap(completableSourceArr[0]) : RxJavaPlugins.onAssembly((Completable) new CompletableMergeArray(completableSourceArr));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static Completable mergeArrayDelayError(@NonNull CompletableSource... completableSourceArr) {
        Objects.requireNonNull(completableSourceArr, "sources is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableMergeArrayDelayError(completableSourceArr));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable mergeDelayError(@NonNull Iterable<? extends CompletableSource> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableMergeDelayErrorIterable(iterable));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable never() {
        return RxJavaPlugins.onAssembly(CompletableNever.INSTANCE);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Single<Boolean> sequenceEqual(@NonNull CompletableSource completableSource, @NonNull CompletableSource completableSource2) {
        Objects.requireNonNull(completableSource, "source1 is null");
        Objects.requireNonNull(completableSource2, "source2 is null");
        return mergeArrayDelayError(completableSource, completableSource2).andThen(Single.just(Boolean.TRUE));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable switchOnNext(@NonNull Publisher<? extends CompletableSource> publisher) {
        Objects.requireNonNull(publisher, "sources is null");
        return RxJavaPlugins.onAssembly((Completable) new FlowableSwitchMapCompletablePublisher(publisher, Functions.identity(), false));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable switchOnNextDelayError(@NonNull Publisher<? extends CompletableSource> publisher) {
        Objects.requireNonNull(publisher, "sources is null");
        return RxJavaPlugins.onAssembly((Completable) new FlowableSwitchMapCompletablePublisher(publisher, Functions.identity(), true));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("custom")
    private Completable timeout0(long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableTimeout(this, j, timeUnit, scheduler, completableSource));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public static Completable timer(long j, @NonNull TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.computation());
    }

    private static NullPointerException toNpe(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable unsafeCreate(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "onSubscribe is null");
        if (!(completableSource instanceof Completable)) {
            return RxJavaPlugins.onAssembly((Completable) new CompletableFromUnsafeSource(completableSource));
        }
        throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <R> Completable using(@NonNull Supplier<R> supplier, @NonNull Function<? super R, ? extends CompletableSource> function, @NonNull Consumer<? super R> consumer) {
        return using(supplier, function, consumer, true);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable wrap(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "source is null");
        return completableSource instanceof Completable ? RxJavaPlugins.onAssembly((Completable) completableSource) : RxJavaPlugins.onAssembly((Completable) new CompletableFromUnsafeSource(completableSource));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable ambWith(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return ambArray(this, completableSource);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Observable<T> andThen(@NonNull ObservableSource<T> observableSource) {
        Objects.requireNonNull(observableSource, "next is null");
        return RxJavaPlugins.onAssembly(new CompletableAndThenObservable(this, observableSource));
    }

    @SchedulerSupport("none")
    public final void blockingAwait() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe((CompletableObserver) blockingMultiObserver);
        blockingMultiObserver.blockingGet();
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe() {
        blockingSubscribe(Functions.EMPTY_ACTION, Functions.ERROR_CONSUMER);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable cache() {
        return RxJavaPlugins.onAssembly((Completable) new CompletableCache(this));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable compose(@NonNull CompletableTransformer completableTransformer) {
        Objects.requireNonNull(completableTransformer, "transformer is null");
        return wrap(completableTransformer.apply(this));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable concatWith(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableAndThenCompletable(this, completableSource));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Completable delay(long j, @NonNull TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.computation(), false);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Completable delaySubscription(long j, @NonNull TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, Schedulers.computation());
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable doAfterTerminate(@NonNull Action action) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return doOnLifecycle(emptyConsumer, emptyConsumer2, action2, action2, action, action2);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable doFinally(@NonNull Action action) {
        Objects.requireNonNull(action, "onFinally is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableDoFinally(this, action));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable doOnComplete(@NonNull Action action) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return doOnLifecycle(emptyConsumer, emptyConsumer2, action, action2, action2, action2);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable doOnDispose(@NonNull Action action) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return doOnLifecycle(emptyConsumer, emptyConsumer2, action2, action2, action2, action);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable doOnError(@NonNull Consumer<? super Throwable> consumer) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return doOnLifecycle(emptyConsumer, consumer, action, action, action, action);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable doOnEvent(@NonNull Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(consumer, "onEvent is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableDoOnEvent(this, consumer));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable doOnLifecycle(@NonNull Consumer<? super Disposable> consumer, @NonNull Action action) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return doOnLifecycle(consumer, emptyConsumer, action2, action2, action2, action);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable doOnSubscribe(@NonNull Consumer<? super Disposable> consumer) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return doOnLifecycle(consumer, emptyConsumer, action, action, action, action);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable doOnTerminate(@NonNull Action action) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return doOnLifecycle(emptyConsumer, emptyConsumer2, action2, action, action2, action2);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable hide() {
        return RxJavaPlugins.onAssembly((Completable) new CompletableHide(this));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable lift(@NonNull CompletableOperator completableOperator) {
        Objects.requireNonNull(completableOperator, "onLift is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableLift(this, completableOperator));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Single<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly(new CompletableMaterialize(this));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable mergeWith(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return mergeArray(this, completableSource);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Completable observeOn(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableObserveOn(this, scheduler));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable onErrorComplete() {
        return onErrorComplete(Functions.alwaysTrue());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable onErrorResumeNext(@NonNull Function<? super Throwable, ? extends CompletableSource> function) {
        Objects.requireNonNull(function, "fallbackSupplier is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableResumeNext(this, function));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable onErrorResumeWith(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "fallback is null");
        return onErrorResumeNext(Functions.justFunction(completableSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Maybe<T> onErrorReturn(@NonNull Function<? super Throwable, ? extends T> function) {
        Objects.requireNonNull(function, "itemSupplier is null");
        return RxJavaPlugins.onAssembly(new CompletableOnErrorReturn(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Maybe<T> onErrorReturnItem(@NonNull T t) {
        Objects.requireNonNull(t, "item is null");
        return onErrorReturn(Functions.justFunction(t));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable onTerminateDetach() {
        return RxJavaPlugins.onAssembly((Completable) new CompletableDetach(this));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable repeat() {
        return fromPublisher(toFlowable().repeat());
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable repeatUntil(@NonNull BooleanSupplier booleanSupplier) {
        return fromPublisher(toFlowable().repeatUntil(booleanSupplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable repeatWhen(@NonNull Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        return fromPublisher(toFlowable().repeatWhen(function));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable retry() {
        return fromPublisher(toFlowable().retry());
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable retryUntil(@NonNull BooleanSupplier booleanSupplier) {
        Objects.requireNonNull(booleanSupplier, "stop is null");
        return retry(LongCompanionObject.MAX_VALUE, Functions.predicateReverseFor(booleanSupplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable retryWhen(@NonNull Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        return fromPublisher(toFlowable().retryWhen(function));
    }

    @SchedulerSupport("none")
    public final void safeSubscribe(@NonNull CompletableObserver completableObserver) {
        Objects.requireNonNull(completableObserver, "observer is null");
        subscribe((CompletableObserver) new SafeCompletableObserver(completableObserver));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable startWith(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return concatArray(completableSource, this);
    }

    @NonNull
    @SchedulerSupport("none")
    public final Disposable subscribe() {
        EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        subscribe((CompletableObserver) emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    public abstract void subscribeActual(@NonNull CompletableObserver completableObserver);

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Completable subscribeOn(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableSubscribeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <E extends CompletableObserver> E subscribeWith(E e) {
        subscribe((CompletableObserver) e);
        return e;
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable takeUntil(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableTakeUntilCompletable(this, completableSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final TestObserver<Void> test() {
        TestObserver<Void> testObserver = new TestObserver<>();
        subscribe((CompletableObserver) testObserver);
        return testObserver;
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Completable timeout(long j, @NonNull TimeUnit timeUnit) {
        return timeout0(j, timeUnit, Schedulers.computation(), (CompletableSource) null);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> R to(@NonNull CompletableConverter<? extends R> completableConverter) {
        Objects.requireNonNull(completableConverter, "converter is null");
        return completableConverter.apply(this);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> CompletionStage<T> toCompletionStage(@Nullable T t) {
        return (CompletionStage) subscribeWith(new CompletionStageConsumer(true, t));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Flowable<T> toFlowable() {
        return this instanceof FuseToFlowable ? ((FuseToFlowable) this).fuseToFlowable() : RxJavaPlugins.onAssembly(new CompletableToFlowable(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Future<Void> toFuture() {
        return (Future) subscribeWith(new FutureMultiObserver());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Maybe<T> toMaybe() {
        return this instanceof FuseToMaybe ? ((FuseToMaybe) this).fuseToMaybe() : RxJavaPlugins.onAssembly(new MaybeFromCompletable(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Observable<T> toObservable() {
        return this instanceof FuseToObservable ? ((FuseToObservable) this).fuseToObservable() : RxJavaPlugins.onAssembly(new CompletableToObservable(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Single<T> toSingle(@NonNull Supplier<? extends T> supplier) {
        Objects.requireNonNull(supplier, "completionValueSupplier is null");
        return RxJavaPlugins.onAssembly(new CompletableToSingle(this, supplier, null));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Single<T> toSingleDefault(T t) {
        Objects.requireNonNull(t, "completionValue is null");
        return RxJavaPlugins.onAssembly(new CompletableToSingle(this, (Supplier) null, t));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Completable unsubscribeOn(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableDisposeOn(this, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable concatDelayError(@NonNull Publisher<? extends CompletableSource> publisher) {
        return concatDelayError(publisher, 2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    private Completable doOnLifecycle(Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        Objects.requireNonNull(consumer, "onSubscribe is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        Objects.requireNonNull(action2, "onTerminate is null");
        Objects.requireNonNull(action3, "onAfterTerminate is null");
        Objects.requireNonNull(action4, "onDispose is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletablePeek(this, consumer, consumer2, action, action2, action3, action4));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("custom")
    public static Completable timer(long j, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableTimer(j, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <R> Completable using(@NonNull Supplier<R> supplier, @NonNull Function<? super R, ? extends CompletableSource> function, @NonNull Consumer<? super R> consumer, boolean z) {
        Objects.requireNonNull(supplier, "resourceSupplier is null");
        Objects.requireNonNull(function, "sourceSupplier is null");
        Objects.requireNonNull(consumer, "resourceCleanup is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableUsing(supplier, function, consumer, z));
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(@NonNull Action action) {
        blockingSubscribe(action, Functions.ERROR_CONSUMER);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Completable delay(long j, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Completable delaySubscription(long j, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return timer(j, timeUnit, scheduler).andThen((CompletableSource) this);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable onErrorComplete(@NonNull Predicate<? super Throwable> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableOnErrorComplete(this, predicate));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable repeat(long j) {
        return fromPublisher(toFlowable().repeat(j));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable retry(@NonNull BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return fromPublisher(toFlowable().retry(biPredicate));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Completable timeout(long j, @NonNull TimeUnit timeUnit, @NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "fallback is null");
        return timeout0(j, timeUnit, Schedulers.computation(), completableSource);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable concat(@NonNull Publisher<? extends CompletableSource> publisher) {
        return concat(publisher, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable concatDelayError(@NonNull Publisher<? extends CompletableSource> publisher, int i) {
        return Flowable.fromPublisher(publisher).concatMapCompletableDelayError(Functions.identity(), true, i);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable error(@NonNull Throwable th) {
        Objects.requireNonNull(th, "throwable is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableError(th));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable merge(@NonNull Publisher<? extends CompletableSource> publisher) {
        return merge0(publisher, Integer.MAX_VALUE, false);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable mergeDelayError(@NonNull Publisher<? extends CompletableSource> publisher) {
        return merge0(publisher, Integer.MAX_VALUE, true);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Flowable<T> andThen(@NonNull Publisher<T> publisher) {
        Objects.requireNonNull(publisher, "next is null");
        return RxJavaPlugins.onAssembly(new CompletableAndThenPublisher(this, publisher));
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(@NonNull Action action, @NonNull Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(action, "onComplete is null");
        Objects.requireNonNull(consumer, "onError is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe((CompletableObserver) blockingMultiObserver);
        blockingMultiObserver.blockingConsume(Functions.emptyConsumer(), consumer, action);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Completable delay(long j, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableDelay(this, j, timeUnit, scheduler, z));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable retry(long j) {
        return fromPublisher(toFlowable().retry(j));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Flowable<T> startWith(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "other is null");
        return Flowable.concat(Single.wrap(singleSource).toFlowable(), (Flowable<T>) toFlowable());
    }

    @SchedulerSupport("none")
    public final void subscribe(@NonNull CompletableObserver completableObserver) {
        Objects.requireNonNull(completableObserver, "observer is null");
        try {
            CompletableObserver onSubscribe = RxJavaPlugins.onSubscribe(this, completableObserver);
            Objects.requireNonNull(onSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(onSubscribe);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            throw toNpe(th);
        }
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final TestObserver<Void> test(boolean z) {
        TestObserver<Void> testObserver = new TestObserver<>();
        if (z) {
            testObserver.dispose();
        }
        subscribe((CompletableObserver) testObserver);
        return testObserver;
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable concat(@NonNull Publisher<? extends CompletableSource> publisher, int i) {
        Objects.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return RxJavaPlugins.onAssembly((Completable) new CompletableConcat(publisher, i));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable merge(@NonNull Publisher<? extends CompletableSource> publisher, int i) {
        return merge0(publisher, i, false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable mergeDelayError(@NonNull Publisher<? extends CompletableSource> publisher, int i) {
        return merge0(publisher, i, true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final boolean blockingAwait(long j, @NonNull TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit, "unit is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe((CompletableObserver) blockingMultiObserver);
        return blockingMultiObserver.blockingAwait(j, timeUnit);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable retry(long j, @NonNull Predicate<? super Throwable> predicate) {
        return fromPublisher(toFlowable().retry(j, predicate));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Completable timeout(long j, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return timeout0(j, timeUnit, scheduler, (CompletableSource) null);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Single<T> andThen(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "next is null");
        return RxJavaPlugins.onAssembly(new SingleDelayWithCompletable(singleSource, this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable retry(@NonNull Predicate<? super Throwable> predicate) {
        return fromPublisher(toFlowable().retry(predicate));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Flowable<T> startWith(@NonNull MaybeSource<T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return Flowable.concat(Maybe.wrap(maybeSource).toFlowable(), (Flowable<T>) toFlowable());
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Completable timeout(long j, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, @NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "fallback is null");
        return timeout0(j, timeUnit, scheduler, completableSource);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Maybe<T> andThen(@NonNull MaybeSource<T> maybeSource) {
        Objects.requireNonNull(maybeSource, "next is null");
        return RxJavaPlugins.onAssembly(new MaybeDelayWithCompletable(maybeSource, this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Observable<T> startWith(@NonNull ObservableSource<T> observableSource) {
        Objects.requireNonNull(observableSource, "other is null");
        return Observable.wrap(observableSource).concatWith(toObservable());
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(@NonNull CompletableObserver completableObserver) {
        Objects.requireNonNull(completableObserver, "observer is null");
        BlockingDisposableMultiObserver blockingDisposableMultiObserver = new BlockingDisposableMultiObserver();
        completableObserver.onSubscribe(blockingDisposableMultiObserver);
        subscribe((CompletableObserver) blockingDisposableMultiObserver);
        blockingDisposableMultiObserver.blockingConsume(completableObserver);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable andThen(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "next is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableAndThenCompletable(this, completableSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Flowable<T> startWith(@NonNull Publisher<T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return toFlowable().startWith(publisher);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable subscribe(@NonNull Action action, @NonNull Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(consumer, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(consumer, action);
        subscribe((CompletableObserver) callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable subscribe(@NonNull Action action) {
        Objects.requireNonNull(action, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(action);
        subscribe((CompletableObserver) callbackCompletableObserver);
        return callbackCompletableObserver;
    }
}

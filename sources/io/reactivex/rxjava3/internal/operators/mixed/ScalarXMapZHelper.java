package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeToObservable;
import io.reactivex.rxjava3.internal.operators.single.SingleToObservable;
import java.util.Objects;

final class ScalarXMapZHelper {
    private ScalarXMapZHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> boolean tryAsCompletable(Object obj, Function<? super T, ? extends CompletableSource> function, CompletableObserver completableObserver) {
        CompletableSource completableSource;
        if (!(obj instanceof Supplier)) {
            return false;
        }
        try {
            Object obj2 = ((Supplier) obj).get();
            if (obj2 != null) {
                Object apply = function.apply(obj2);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                completableSource = (CompletableSource) apply;
            } else {
                completableSource = null;
            }
            if (completableSource == null) {
                EmptyDisposable.complete(completableObserver);
            } else {
                completableSource.subscribe(completableObserver);
            }
            return true;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, completableObserver);
            return true;
        }
    }

    public static <T, R> boolean tryAsMaybe(Object obj, Function<? super T, ? extends MaybeSource<? extends R>> function, Observer<? super R> observer) {
        MaybeSource maybeSource;
        if (!(obj instanceof Supplier)) {
            return false;
        }
        try {
            Object obj2 = ((Supplier) obj).get();
            if (obj2 != null) {
                Object apply = function.apply(obj2);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                maybeSource = (MaybeSource) apply;
            } else {
                maybeSource = null;
            }
            if (maybeSource == null) {
                EmptyDisposable.complete((Observer<?>) observer);
            } else {
                maybeSource.subscribe(MaybeToObservable.create(observer));
            }
            return true;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (Observer<?>) observer);
            return true;
        }
    }

    public static <T, R> boolean tryAsSingle(Object obj, Function<? super T, ? extends SingleSource<? extends R>> function, Observer<? super R> observer) {
        SingleSource singleSource;
        if (!(obj instanceof Supplier)) {
            return false;
        }
        try {
            Object obj2 = ((Supplier) obj).get();
            if (obj2 != null) {
                Object apply = function.apply(obj2);
                Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                singleSource = (SingleSource) apply;
            } else {
                singleSource = null;
            }
            if (singleSource == null) {
                EmptyDisposable.complete((Observer<?>) observer);
            } else {
                singleSource.subscribe(SingleToObservable.create(observer));
            }
            return true;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (Observer<?>) observer);
            return true;
        }
    }
}

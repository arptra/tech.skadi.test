package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;

public final class CompletableFromSingle<T> extends Completable {
    final SingleSource<T> single;

    public static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {
        final CompletableObserver co;

        public CompletableFromSingleObserver(CompletableObserver completableObserver) {
            this.co = completableObserver;
        }

        public void onError(Throwable th) {
            this.co.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            this.co.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            this.co.onComplete();
        }
    }

    public CompletableFromSingle(SingleSource<T> singleSource) {
        this.single = singleSource;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.single.subscribe(new CompletableFromSingleObserver(completableObserver));
    }
}

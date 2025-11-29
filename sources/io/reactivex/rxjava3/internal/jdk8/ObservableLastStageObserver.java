package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;

public final class ObservableLastStageObserver<T> extends ObservableStageObserver<T> {
    final T defaultItem;
    final boolean hasDefault;

    public ObservableLastStageObserver(boolean z, T t) {
        this.hasDefault = z;
        this.defaultItem = t;
    }

    public void onComplete() {
        if (!isDone()) {
            T t = this.value;
            clear();
            if (t != null) {
                complete(t);
            } else if (this.hasDefault) {
                complete(this.defaultItem);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    public void onNext(T t) {
        this.value = t;
    }
}

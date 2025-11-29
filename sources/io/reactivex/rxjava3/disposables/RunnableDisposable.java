package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.NonNull;

final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    public RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }

    public void onDisposed(@NonNull Runnable runnable) {
        runnable.run();
    }
}

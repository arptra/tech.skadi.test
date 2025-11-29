package io.reactivex.rxjava3.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;

public interface SchedulerRunnableIntrospection {
    @NonNull
    Runnable getWrappedRunnable();
}

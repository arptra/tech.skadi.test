package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapCompletable;
import org.reactivestreams.Publisher;

public final class FlowableSwitchMapCompletablePublisher<T> extends Completable {
    final boolean delayErrors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final Publisher<T> source;

    public FlowableSwitchMapCompletablePublisher(Publisher<T> publisher, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.source = publisher;
        this.mapper = function;
        this.delayErrors = z;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new FlowableSwitchMapCompletable.SwitchMapCompletableObserver(completableObserver, this.mapper, this.delayErrors));
    }
}

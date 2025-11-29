package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import java.util.Objects;
import org.reactivestreams.Publisher;

abstract class AbstractFlowableWithUpstream<T, R> extends Flowable<R> implements HasUpstreamPublisher<T> {
    protected final Flowable<T> source;

    public AbstractFlowableWithUpstream(Flowable<T> flowable) {
        Objects.requireNonNull(flowable, "source is null");
        this.source = flowable;
    }

    public final Publisher<T> source() {
        return this.source;
    }
}

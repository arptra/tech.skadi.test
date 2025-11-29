package org.reactivestreams;

import j$.util.concurrent.Flow$Processor;
import j$.util.concurrent.Flow$Publisher;
import j$.util.concurrent.Flow$Subscriber;
import j$.util.concurrent.Flow$Subscription;

public final class FlowAdapters {

    public static final class FlowPublisherFromReactive<T> implements Flow$Publisher<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Publisher f3443a;

        public void subscribe(Flow$Subscriber flow$Subscriber) {
            this.f3443a.subscribe(flow$Subscriber == null ? null : new ReactiveToFlowSubscriber(flow$Subscriber));
        }
    }

    public static final class FlowToReactiveProcessor<T, U> implements Flow$Processor<T, U> {

        /* renamed from: a  reason: collision with root package name */
        public final Processor f3444a;

        public void onComplete() {
            this.f3444a.onComplete();
        }

        public void onError(Throwable th) {
            this.f3444a.onError(th);
        }

        public void onNext(Object obj) {
            this.f3444a.onNext(obj);
        }

        public void onSubscribe(Flow$Subscription flow$Subscription) {
            this.f3444a.onSubscribe(flow$Subscription == null ? null : new ReactiveToFlowSubscription(flow$Subscription));
        }

        public void subscribe(Flow$Subscriber flow$Subscriber) {
            this.f3444a.subscribe(flow$Subscriber == null ? null : new ReactiveToFlowSubscriber(flow$Subscriber));
        }
    }

    public static final class FlowToReactiveSubscriber<T> implements Flow$Subscriber<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Subscriber f3445a;

        public FlowToReactiveSubscriber(Subscriber subscriber) {
            this.f3445a = subscriber;
        }

        public void onComplete() {
            this.f3445a.onComplete();
        }

        public void onError(Throwable th) {
            this.f3445a.onError(th);
        }

        public void onNext(Object obj) {
            this.f3445a.onNext(obj);
        }

        public void onSubscribe(Flow$Subscription flow$Subscription) {
            this.f3445a.onSubscribe(flow$Subscription == null ? null : new ReactiveToFlowSubscription(flow$Subscription));
        }
    }

    public static final class FlowToReactiveSubscription implements Flow$Subscription {

        /* renamed from: a  reason: collision with root package name */
        public final Subscription f3446a;

        public FlowToReactiveSubscription(Subscription subscription) {
            this.f3446a = subscription;
        }

        public void cancel() {
            this.f3446a.cancel();
        }

        public void request(long j) {
            this.f3446a.request(j);
        }
    }

    public static final class ReactivePublisherFromFlow<T> implements Publisher<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Flow$Publisher f3447a;

        public void subscribe(Subscriber subscriber) {
            this.f3447a.subscribe(subscriber == null ? null : new FlowToReactiveSubscriber(subscriber));
        }
    }

    public static final class ReactiveToFlowProcessor<T, U> implements Processor<T, U> {

        /* renamed from: a  reason: collision with root package name */
        public final Flow$Processor f3448a;

        public void onComplete() {
            this.f3448a.onComplete();
        }

        public void onError(Throwable th) {
            this.f3448a.onError(th);
        }

        public void onNext(Object obj) {
            this.f3448a.onNext(obj);
        }

        public void onSubscribe(Subscription subscription) {
            this.f3448a.onSubscribe(subscription == null ? null : new FlowToReactiveSubscription(subscription));
        }

        public void subscribe(Subscriber subscriber) {
            this.f3448a.subscribe(subscriber == null ? null : new FlowToReactiveSubscriber(subscriber));
        }
    }

    public static final class ReactiveToFlowSubscriber<T> implements Subscriber<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Flow$Subscriber f3449a;

        public ReactiveToFlowSubscriber(Flow$Subscriber flow$Subscriber) {
            this.f3449a = flow$Subscriber;
        }

        public void onComplete() {
            this.f3449a.onComplete();
        }

        public void onError(Throwable th) {
            this.f3449a.onError(th);
        }

        public void onNext(Object obj) {
            this.f3449a.onNext(obj);
        }

        public void onSubscribe(Subscription subscription) {
            this.f3449a.onSubscribe(subscription == null ? null : new FlowToReactiveSubscription(subscription));
        }
    }

    public static final class ReactiveToFlowSubscription implements Subscription {

        /* renamed from: a  reason: collision with root package name */
        public final Flow$Subscription f3450a;

        public ReactiveToFlowSubscription(Flow$Subscription flow$Subscription) {
            this.f3450a = flow$Subscription;
        }

        public void cancel() {
            this.f3450a.cancel();
        }

        public void request(long j) {
            this.f3450a.request(j);
        }
    }
}

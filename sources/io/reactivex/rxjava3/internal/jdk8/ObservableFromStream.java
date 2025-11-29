package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

public final class ObservableFromStream<T> extends Observable<T> {
    final Stream<T> stream;

    public static final class StreamDisposable<T> implements QueueDisposable<T> {
        AutoCloseable closeable;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        Iterator<T> iterator;
        boolean once;
        boolean outputFused;

        public StreamDisposable(Observer<? super T> observer, Iterator<T> it, AutoCloseable autoCloseable) {
            this.downstream = observer;
            this.iterator = it;
            this.closeable = autoCloseable;
        }

        public void clear() {
            this.iterator = null;
            AutoCloseable autoCloseable = this.closeable;
            this.closeable = null;
            if (autoCloseable != null) {
                ObservableFromStream.closeSafely(autoCloseable);
            }
        }

        public void dispose() {
            this.disposed = true;
            run();
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public boolean isEmpty() {
            Iterator<T> it = this.iterator;
            if (it == null) {
                return true;
            }
            if (!this.once || it.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        public boolean offer(@NonNull T t) {
            throw new UnsupportedOperationException();
        }

        @Nullable
        public T poll() {
            Iterator<T> it = this.iterator;
            if (it == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!it.hasNext()) {
                clear();
                return null;
            }
            T next = this.iterator.next();
            Objects.requireNonNull(next, "The Stream's Iterator.next() returned a null value");
            return next;
        }

        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 1;
        }

        public void run() {
            if (!this.outputFused) {
                Iterator<T> it = this.iterator;
                Observer<? super T> observer = this.downstream;
                while (!this.disposed) {
                    try {
                        T next = it.next();
                        Objects.requireNonNull(next, "The Stream's Iterator.next returned a null value");
                        if (!this.disposed) {
                            observer.onNext(next);
                            if (!this.disposed) {
                                try {
                                    if (!it.hasNext()) {
                                        observer.onComplete();
                                        this.disposed = true;
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    observer.onError(th);
                                    this.disposed = true;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        observer.onError(th2);
                        this.disposed = true;
                    }
                }
                clear();
            }
        }

        public boolean offer(@NonNull T t, @NonNull T t2) {
            throw new UnsupportedOperationException();
        }
    }

    public ObservableFromStream(Stream<T> stream2) {
        this.stream = stream2;
    }

    public static void closeSafely(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }

    public static <T> void subscribeStream(Observer<? super T> observer, Stream<T> stream2) {
        try {
            Iterator<T> it = stream2.iterator();
            if (!it.hasNext()) {
                EmptyDisposable.complete((Observer<?>) observer);
                closeSafely(stream2);
                return;
            }
            StreamDisposable streamDisposable = new StreamDisposable(observer, it, stream2);
            observer.onSubscribe(streamDisposable);
            streamDisposable.run();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (Observer<?>) observer);
            closeSafely(stream2);
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        subscribeStream(observer, this.stream);
    }
}

package com.honey.account.utils.coroutine;

import com.honey.account.utils.thread.DefaultExecutor;
import com.honey.account.utils.thread.IOExecutor;
import com.honey.account.utils.thread.MainExecutor;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/honey/account/utils/coroutine/DispatcherHelper;", "", "()V", "Companion", "DispatchContext", "ExecutorContext", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DispatcherHelper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Executor Default = DefaultExecutor.INSTANCE;
    /* access modifiers changed from: private */
    @NotNull
    public static final Executor IO = IOExecutor.INSTANCE;
    /* access modifiers changed from: private */
    @NotNull
    public static final Executor Main = MainExecutor.INSTANCE;
    /* access modifiers changed from: private */
    @Nullable
    public static final Executor Unconfined = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/honey/account/utils/coroutine/DispatcherHelper$Companion;", "", "()V", "Default", "Ljava/util/concurrent/Executor;", "getDefault", "()Ljava/util/concurrent/Executor;", "IO", "getIO", "Main", "getMain", "Unconfined", "getUnconfined", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Executor getDefault() {
            return DispatcherHelper.Default;
        }

        @NotNull
        public final Executor getIO() {
            return DispatcherHelper.IO;
        }

        @NotNull
        public final Executor getMain() {
            return DispatcherHelper.Main;
        }

        @Nullable
        public final Executor getUnconfined() {
            return DispatcherHelper.Unconfined;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/honey/account/utils/coroutine/DispatcherHelper$DispatchContext;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DispatchContext extends AbstractCoroutineContextElement implements ContinuationInterceptor {
        public DispatchContext() {
            super(ContinuationInterceptor.Key);
        }

        @Nullable
        public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
            return ContinuationInterceptor.DefaultImpls.get(this, key);
        }

        @NotNull
        public <T> Continuation<T> interceptContinuation(@NotNull Continuation<? super T> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            return new DispatcherHelper$DispatchContext$interceptContinuation$1(continuation);
        }

        @NotNull
        public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
            return ContinuationInterceptor.DefaultImpls.minusKey(this, key);
        }

        public void releaseInterceptedContinuation(@NotNull Continuation<?> continuation) {
            ContinuationInterceptor.DefaultImpls.releaseInterceptedContinuation(this, continuation);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/honey/account/utils/coroutine/DispatcherHelper$ExecutorContext;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "threadType", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "getThreadType", "()Ljava/util/concurrent/Executor;", "Key", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ExecutorContext extends AbstractCoroutineContextElement {
        @NotNull
        public static final Key Key = new Key((DefaultConstructorMarker) null);
        @Nullable
        private final Executor threadType;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/honey/account/utils/coroutine/DispatcherHelper$ExecutorContext$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lcom/honey/account/utils/coroutine/DispatcherHelper$ExecutorContext;", "()V", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Key implements CoroutineContext.Key<ExecutorContext> {
            public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Key() {
            }
        }

        public ExecutorContext(@Nullable Executor executor) {
            super(Key);
            this.threadType = executor;
        }

        @Nullable
        public final Executor getThreadType() {
            return this.threadType;
        }
    }
}

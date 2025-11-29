package com.upuphone.star.httplib;

import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.star.httplib.HttpInstance$post$1", f = "HttpInstance.kt", i = {}, l = {160, 161}, m = "invokeSuspend", n = {}, s = {})
final class HttpInstance$post$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $headers;
    final /* synthetic */ ResultListener<Object> $listener;
    final /* synthetic */ Map<String, String> $params;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ HttpInstance this$0;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.star.httplib.HttpInstance$post$1$1", f = "HttpInstance.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.star.httplib.HttpInstance$post$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(resultListener, httpResult, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    resultListener.onResult(HttpResultKt.b(httpResult));
                } catch (HttpResultException e) {
                    resultListener.onError(e.getCode(), e.getMsg(), e.getRawContent());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpInstance$post$1(ResultListener<Object> resultListener, HttpInstance httpInstance, String str, Map<String, String> map, Map<String, String> map2, Continuation<? super HttpInstance$post$1> continuation) {
        super(2, continuation);
        this.$listener = resultListener;
        this.this$0 = httpInstance;
        this.$url = str;
        this.$params = map;
        this.$headers = map2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HttpInstance$post$1(this.$listener, this.this$0, this.$url, this.$params, this.$headers, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Type a2 = UtilExtKt.a(this.$listener);
            HttpInstance httpInstance = this.this$0;
            String str = this.$url;
            Map<String, String> map = this.$params;
            Map<String, String> map2 = this.$headers;
            this.label = 1;
            obj = httpInstance.f(str, map, map2, a2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final HttpResult httpResult = (HttpResult) obj;
        MainCoroutineDispatcher c = Dispatchers.c();
        final ResultListener<Object> resultListener = this.$listener;
        AnonymousClass1 r3 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
        this.label = 2;
        if (BuildersKt.g(c, r3, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HttpInstance$post$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

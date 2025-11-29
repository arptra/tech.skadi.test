package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", "Lio/ktor/client/statement/HttpResponse;", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement$execute$4", f = "HttpStatement.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
final class HttpStatement$execute$4 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super HttpResponse>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public HttpStatement$execute$4(Continuation<? super HttpStatement$execute$4> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        HttpStatement$execute$4 httpStatement$execute$4 = new HttpStatement$execute$4(continuation);
        httpStatement$execute$4.L$0 = obj;
        return httpStatement$execute$4;
    }

    @Nullable
    public final Object invoke(@NotNull HttpResponse httpResponse, @Nullable Continuation<? super HttpResponse> continuation) {
        return ((HttpStatement$execute$4) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HttpClientCall p0 = ((HttpResponse) this.L$0).p0();
            this.label = 1;
            obj = SavedCallKt.a(p0, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return ((HttpClientCall) obj).g();
    }
}

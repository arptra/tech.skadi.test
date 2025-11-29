package com.upuphone.star.httplib;

import java.io.IOException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "Lcom/upuphone/star/httplib/HttpResult;", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.star.httplib.HttpInstance$request$4", f = "HttpInstance.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
public final class HttpInstance$request$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResult<Object>>, Object> {
    final /* synthetic */ Request $request;
    final /* synthetic */ Type $type;
    Object L$0;
    int label;
    final /* synthetic */ HttpInstance this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpInstance$request$4(HttpInstance httpInstance, Request request, Type type, Continuation<? super HttpInstance$request$4> continuation) {
        super(2, continuation);
        this.this$0 = httpInstance;
        this.$request = request;
        this.$type = type;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HttpInstance$request$4(this.this$0, this.$request, this.$type, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ResponseParser responseParser;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ResponseParser b = this.this$0.b;
            HttpInstance httpInstance = this.this$0;
            Request request = this.$request;
            this.L$0 = b;
            this.label = 1;
            Object c = httpInstance.c(request, this);
            if (c == coroutine_suspended) {
                return coroutine_suspended;
            }
            responseParser = b;
            obj = c;
        } else if (i == 1) {
            responseParser = (ResponseParser) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (IOException e) {
                if (this.this$0.c) {
                    e.printStackTrace();
                }
                return new HttpResult(-1, "network error", (Object) null, (String) null, 12, (DefaultConstructorMarker) null);
            } catch (Throwable th) {
                if (this.this$0.c) {
                    th.printStackTrace();
                }
                return new HttpResult(-10, "bad response", (Object) null, (String) null, 12, (DefaultConstructorMarker) null);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return responseParser.a((Response) obj, this.$type);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super HttpResult<Object>> continuation) {
        return ((HttpInstance$request$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

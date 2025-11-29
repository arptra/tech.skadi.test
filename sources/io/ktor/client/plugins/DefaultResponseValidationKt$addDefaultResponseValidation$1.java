package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.HttpCallValidator;
import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/HttpCallValidator$Config;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class DefaultResponseValidationKt$addDefaultResponseValidation$1 extends Lambda implements Function1<HttpCallValidator.Config, Unit> {
    final /* synthetic */ HttpClientConfig<?> $this_addDefaultResponseValidation;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "response", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1", f = "DefaultResponseValidation.kt", i = {0, 0, 1, 1, 1}, l = {42, 48}, m = "invokeSuspend", n = {"response", "statusCode", "response", "exceptionResponse", "statusCode"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
    /* renamed from: io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
        int I$0;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(continuation);
            r0.L$0 = obj;
            return r0;
        }

        @Nullable
        public final Object invoke(@NotNull HttpResponse httpResponse, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x00d9 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00e6 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00f5  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00fb  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.label
                r2 = 300(0x12c, float:4.2E-43)
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0034
                if (r1 == r4) goto L_0x0027
                if (r1 != r3) goto L_0x001f
                int r0 = r10.I$0
                java.lang.Object r1 = r10.L$1
                io.ktor.client.statement.HttpResponse r1 = (io.ktor.client.statement.HttpResponse) r1
                java.lang.Object r10 = r10.L$0
                io.ktor.client.statement.HttpResponse r10 = (io.ktor.client.statement.HttpResponse) r10
                kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ MalformedInputException -> 0x00d3 }
                goto L_0x00cd
            L_0x001f:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L_0x0027:
                int r1 = r10.I$0
                java.lang.Object r5 = r10.L$0
                io.ktor.client.statement.HttpResponse r5 = (io.ktor.client.statement.HttpResponse) r5
                kotlin.ResultKt.throwOnFailure(r11)
                r9 = r5
                r5 = r11
                r11 = r9
                goto L_0x00a5
            L_0x0034:
                kotlin.ResultKt.throwOnFailure(r11)
                java.lang.Object r11 = r10.L$0
                io.ktor.client.statement.HttpResponse r11 = (io.ktor.client.statement.HttpResponse) r11
                io.ktor.client.call.HttpClientCall r1 = r11.p0()
                io.ktor.util.Attributes r1 = r1.J()
                io.ktor.util.AttributeKey r5 = io.ktor.client.plugins.HttpCallValidatorKt.d()
                java.lang.Object r1 = r1.f(r5)
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r1 = r1.booleanValue()
                if (r1 != 0) goto L_0x007a
                org.slf4j.Logger r10 = io.ktor.client.plugins.DefaultResponseValidationKt.b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Skipping default response validation for "
                r0.append(r1)
                io.ktor.client.call.HttpClientCall r11 = r11.p0()
                io.ktor.client.request.HttpRequest r11 = r11.f()
                io.ktor.http.Url r11 = r11.T()
                r0.append(r11)
                java.lang.String r11 = r0.toString()
                r10.trace(r11)
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            L_0x007a:
                io.ktor.http.HttpStatusCode r1 = r11.f()
                int r1 = r1.h0()
                io.ktor.client.call.HttpClientCall r5 = r11.p0()
                if (r1 < r2) goto L_0x012d
                io.ktor.util.Attributes r6 = r5.J()
                io.ktor.util.AttributeKey r7 = io.ktor.client.plugins.DefaultResponseValidationKt.f8836a
                boolean r6 = r6.d(r7)
                if (r6 == 0) goto L_0x0098
                goto L_0x012d
            L_0x0098:
                r10.L$0 = r11
                r10.I$0 = r1
                r10.label = r4
                java.lang.Object r5 = io.ktor.client.call.SavedCallKt.a(r5, r10)
                if (r5 != r0) goto L_0x00a5
                return r0
            L_0x00a5:
                io.ktor.client.call.HttpClientCall r5 = (io.ktor.client.call.HttpClientCall) r5
                io.ktor.util.Attributes r6 = r5.J()
                io.ktor.util.AttributeKey r7 = io.ktor.client.plugins.DefaultResponseValidationKt.f8836a
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                r6.a(r7, r8)
                io.ktor.client.statement.HttpResponse r5 = r5.g()
                r10.L$0 = r11     // Catch:{ MalformedInputException -> 0x00d0 }
                r10.L$1 = r5     // Catch:{ MalformedInputException -> 0x00d0 }
                r10.I$0 = r1     // Catch:{ MalformedInputException -> 0x00d0 }
                r10.label = r3     // Catch:{ MalformedInputException -> 0x00d0 }
                r3 = 0
                java.lang.Object r10 = io.ktor.client.statement.HttpResponseKt.c(r5, r3, r10, r4, r3)     // Catch:{ MalformedInputException -> 0x00d0 }
                if (r10 != r0) goto L_0x00c8
                return r0
            L_0x00c8:
                r0 = r1
                r1 = r5
                r9 = r11
                r11 = r10
                r10 = r9
            L_0x00cd:
                java.lang.String r11 = (java.lang.String) r11     // Catch:{ MalformedInputException -> 0x00d3 }
                goto L_0x00d5
            L_0x00d0:
                r10 = r11
                r0 = r1
                r1 = r5
            L_0x00d3:
                java.lang.String r11 = "<body failed decoding>"
            L_0x00d5:
                r3 = 400(0x190, float:5.6E-43)
                if (r2 > r0) goto L_0x00e2
                if (r0 < r3) goto L_0x00dc
                goto L_0x00e2
            L_0x00dc:
                io.ktor.client.plugins.RedirectResponseException r0 = new io.ktor.client.plugins.RedirectResponseException
                r0.<init>(r1, r11)
                goto L_0x0100
            L_0x00e2:
                r2 = 500(0x1f4, float:7.0E-43)
                if (r3 > r0) goto L_0x00ef
                if (r0 < r2) goto L_0x00e9
                goto L_0x00ef
            L_0x00e9:
                io.ktor.client.plugins.ClientRequestException r0 = new io.ktor.client.plugins.ClientRequestException
                r0.<init>(r1, r11)
                goto L_0x0100
            L_0x00ef:
                if (r2 > r0) goto L_0x00fb
                r2 = 600(0x258, float:8.41E-43)
                if (r0 >= r2) goto L_0x00fb
                io.ktor.client.plugins.ServerResponseException r0 = new io.ktor.client.plugins.ServerResponseException
                r0.<init>(r1, r11)
                goto L_0x0100
            L_0x00fb:
                io.ktor.client.plugins.ResponseException r0 = new io.ktor.client.plugins.ResponseException
                r0.<init>(r1, r11)
            L_0x0100:
                org.slf4j.Logger r11 = io.ktor.client.plugins.DefaultResponseValidationKt.b
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Default response validation for "
                r1.append(r2)
                io.ktor.client.call.HttpClientCall r10 = r10.p0()
                io.ktor.client.request.HttpRequest r10 = r10.f()
                io.ktor.http.Url r10 = r10.T()
                r1.append(r10)
                java.lang.String r10 = " failed with "
                r1.append(r10)
                r1.append(r0)
                java.lang.String r10 = r1.toString()
                r11.trace(r10)
                throw r0
            L_0x012d:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultResponseValidationKt$addDefaultResponseValidation$1(HttpClientConfig<?> httpClientConfig) {
        super(1);
        this.$this_addDefaultResponseValidation = httpClientConfig;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HttpCallValidator.Config) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull HttpCallValidator.Config config) {
        Intrinsics.checkNotNullParameter(config, "$this$HttpResponseValidator");
        config.d(this.$this_addDefaultResponseValidation.b());
        config.e(new AnonymousClass1((Continuation<? super AnonymousClass1>) null));
    }
}

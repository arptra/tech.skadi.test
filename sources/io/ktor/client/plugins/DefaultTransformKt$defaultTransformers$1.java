package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "body"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1", f = "DefaultTransform.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultTransformKt$defaultTransformers$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public DefaultTransformKt$defaultTransformers$1(Continuation<? super DefaultTransformKt$defaultTransformers$1> continuation) {
        super(3, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull PipelineContext<Object, HttpRequestBuilder> pipelineContext, @NotNull Object obj, @Nullable Continuation<? super Unit> continuation) {
        DefaultTransformKt$defaultTransformers$1 defaultTransformKt$defaultTransformers$1 = new DefaultTransformKt$defaultTransformers$1(continuation);
        defaultTransformKt$defaultTransformers$1.L$0 = pipelineContext;
        defaultTransformKt$defaultTransformers$1.L$1 = obj;
        return defaultTransformKt$defaultTransformers$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: io.ktor.http.content.OutgoingContent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: io.ktor.http.content.OutgoingContent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: io.ktor.http.content.TextContent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: io.ktor.http.content.TextContent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: io.ktor.http.content.TextContent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: io.ktor.http.content.TextContent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: io.ktor.http.content.TextContent} */
    /* JADX WARNING: type inference failed for: r5v2, types: [java.lang.Object, io.ktor.http.content.OutgoingContent] */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 1
            if (r1 == 0) goto L_0x0018
            if (r1 != r2) goto L_0x0010
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00ed
        L_0x0010:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0018:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            io.ktor.util.pipeline.PipelineContext r13 = (io.ktor.util.pipeline.PipelineContext) r13
            java.lang.Object r1 = r12.L$1
            java.lang.Object r3 = r13.d()
            io.ktor.client.request.HttpRequestBuilder r3 = (io.ktor.client.request.HttpRequestBuilder) r3
            io.ktor.http.HeadersBuilder r3 = r3.a()
            io.ktor.http.HttpHeaders r4 = io.ktor.http.HttpHeaders.f8966a
            java.lang.String r5 = r4.c()
            java.lang.String r3 = r3.h(r5)
            if (r3 != 0) goto L_0x004a
            java.lang.Object r3 = r13.d()
            io.ktor.client.request.HttpRequestBuilder r3 = (io.ktor.client.request.HttpRequestBuilder) r3
            io.ktor.http.HeadersBuilder r3 = r3.a()
            java.lang.String r5 = r4.c()
            java.lang.String r6 = "*/*"
            r3.e(r5, r6)
        L_0x004a:
            java.lang.Object r3 = r13.d()
            io.ktor.http.HttpMessageBuilder r3 = (io.ktor.http.HttpMessageBuilder) r3
            io.ktor.http.ContentType r3 = io.ktor.http.HttpMessagePropertiesKt.e(r3)
            boolean r5 = r1 instanceof java.lang.String
            if (r5 == 0) goto L_0x006e
            io.ktor.http.content.TextContent r5 = new io.ktor.http.content.TextContent
            r7 = r1
            java.lang.String r7 = (java.lang.String) r7
            if (r3 != 0) goto L_0x0065
            io.ktor.http.ContentType$Text r3 = io.ktor.http.ContentType.Text.f8951a
            io.ktor.http.ContentType r3 = r3.a()
        L_0x0065:
            r8 = r3
            r10 = 4
            r11 = 0
            r9 = 0
            r6 = r5
            r6.<init>(r7, r8, r9, r10, r11)
            goto L_0x0094
        L_0x006e:
            boolean r5 = r1 instanceof byte[]
            if (r5 == 0) goto L_0x0078
            io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$1 r5 = new io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$1
            r5.<init>(r3, r1)
            goto L_0x0094
        L_0x0078:
            boolean r5 = r1 instanceof io.ktor.utils.io.ByteReadChannel
            if (r5 == 0) goto L_0x0082
            io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$2 r5 = new io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$2
            r5.<init>(r13, r3, r1)
            goto L_0x0094
        L_0x0082:
            boolean r5 = r1 instanceof io.ktor.http.content.OutgoingContent
            if (r5 == 0) goto L_0x008a
            r5 = r1
            io.ktor.http.content.OutgoingContent r5 = (io.ktor.http.content.OutgoingContent) r5
            goto L_0x0094
        L_0x008a:
            java.lang.Object r5 = r13.d()
            io.ktor.client.request.HttpRequestBuilder r5 = (io.ktor.client.request.HttpRequestBuilder) r5
            io.ktor.http.content.OutgoingContent r5 = io.ktor.client.plugins.DefaultTransformersJvmKt.a(r3, r5, r1)
        L_0x0094:
            r3 = 0
            if (r5 == 0) goto L_0x009c
            io.ktor.http.ContentType r6 = r5.b()
            goto L_0x009d
        L_0x009c:
            r6 = r3
        L_0x009d:
            if (r6 == 0) goto L_0x00ed
            java.lang.Object r6 = r13.d()
            io.ktor.client.request.HttpRequestBuilder r6 = (io.ktor.client.request.HttpRequestBuilder) r6
            io.ktor.http.HeadersBuilder r6 = r6.a()
            java.lang.String r4 = r4.k()
            r6.j(r4)
            org.slf4j.Logger r4 = io.ktor.client.plugins.DefaultTransformKt.f8837a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Transformed with default transformers request body for "
            r6.append(r7)
            java.lang.Object r7 = r13.d()
            io.ktor.client.request.HttpRequestBuilder r7 = (io.ktor.client.request.HttpRequestBuilder) r7
            io.ktor.http.URLBuilder r7 = r7.i()
            r6.append(r7)
            java.lang.String r7 = " from "
            r6.append(r7)
            java.lang.Class r1 = r1.getClass()
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            r4.trace(r1)
            r12.L$0 = r3
            r12.label = r2
            java.lang.Object r12 = r13.g(r5, r12)
            if (r12 != r0) goto L_0x00ed
            return r0
        L_0x00ed:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

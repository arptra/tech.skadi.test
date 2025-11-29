package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nHttpSend.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpSend.kt\nio/ktor/client/plugins/HttpSend$Plugin$install$1\n+ 2 RequestBody.kt\nio/ktor/client/request/RequestBodyKt\n+ 3 TypeInfoJvm.kt\nio/ktor/util/reflect/TypeInfoJvmKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,158:1\n16#2,4:159\n21#2,10:166\n17#3,3:163\n1855#4,2:176\n*S KotlinDebug\n*F\n+ 1 HttpSend.kt\nio/ktor/client/plugins/HttpSend$Plugin$install$1\n*L\n96#1:159,4\n96#1:166,10\n96#1:163,3\n100#1:176,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "content"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpSend$Plugin$install$1", f = "HttpSend.kt", i = {0}, l = {104, 105}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
public final class HttpSend$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpSend $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpSend$Plugin$install$1(HttpSend httpSend, HttpClient httpClient, Continuation<? super HttpSend$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = httpSend;
        this.$scope = httpClient;
    }

    @Nullable
    public final Object invoke(@NotNull PipelineContext<Object, HttpRequestBuilder> pipelineContext, @NotNull Object obj, @Nullable Continuation<? super Unit> continuation) {
        HttpSend$Plugin$install$1 httpSend$Plugin$install$1 = new HttpSend$Plugin$install$1(this.$plugin, this.$scope, continuation);
        httpSend$Plugin$install$1.L$0 = pipelineContext;
        httpSend$Plugin$install$1.L$1 = obj;
        return httpSend$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: io.ktor.util.pipeline.PipelineContext} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0025
            if (r1 == r3) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00e5
        L_0x0014:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x001c:
            java.lang.Object r1 = r10.L$0
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00d8
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            r1 = r11
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            java.lang.Object r11 = r10.L$1
            boolean r5 = r11 instanceof io.ktor.http.content.OutgoingContent
            if (r5 == 0) goto L_0x00e8
            java.lang.Object r5 = r1.d()
            io.ktor.client.request.HttpRequestBuilder r5 = (io.ktor.client.request.HttpRequestBuilder) r5
            java.lang.Class<io.ktor.http.content.OutgoingContent> r6 = io.ktor.http.content.OutgoingContent.class
            if (r11 != 0) goto L_0x0056
            io.ktor.http.content.NullBody r11 = io.ktor.http.content.NullBody.f8994a
            r5.j(r11)
            kotlin.reflect.KType r11 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r6)
            java.lang.reflect.Type r7 = kotlin.reflect.TypesJVMKt.getJavaType((kotlin.reflect.KType) r11)
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            io.ktor.util.reflect.TypeInfo r11 = io.ktor.util.reflect.TypeInfoJvmKt.b(r7, r6, r11)
            r5.k(r11)
            goto L_0x0077
        L_0x0056:
            boolean r7 = r11 instanceof io.ktor.http.content.OutgoingContent
            if (r7 == 0) goto L_0x0061
            r5.j(r11)
            r5.k(r4)
            goto L_0x0077
        L_0x0061:
            r5.j(r11)
            kotlin.reflect.KType r11 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r6)
            java.lang.reflect.Type r7 = kotlin.reflect.TypesJVMKt.getJavaType((kotlin.reflect.KType) r11)
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            io.ktor.util.reflect.TypeInfo r11 = io.ktor.util.reflect.TypeInfoJvmKt.b(r7, r6, r11)
            r5.k(r11)
        L_0x0077:
            io.ktor.client.plugins.HttpSend$DefaultSender r11 = new io.ktor.client.plugins.HttpSend$DefaultSender
            io.ktor.client.plugins.HttpSend r5 = r10.$plugin
            int r5 = r5.f8863a
            io.ktor.client.HttpClient r6 = r10.$scope
            r11.<init>(r5, r6)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            r5.element = r11
            io.ktor.client.plugins.HttpSend r11 = r10.$plugin
            java.util.List r11 = r11.b
            int r11 = kotlin.collections.CollectionsKt.getLastIndex(r11)
            r6 = 0
            kotlin.ranges.IntProgression r11 = kotlin.ranges.RangesKt.downTo((int) r11, (int) r6)
            io.ktor.client.plugins.HttpSend r6 = r10.$plugin
            java.util.Iterator r11 = r11.iterator()
        L_0x00a0:
            boolean r7 = r11.hasNext()
            if (r7 == 0) goto L_0x00c3
            r7 = r11
            kotlin.collections.IntIterator r7 = (kotlin.collections.IntIterator) r7
            int r7 = r7.nextInt()
            java.util.List r8 = r6.b
            java.lang.Object r7 = r8.get(r7)
            kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
            io.ktor.client.plugins.HttpSend$InterceptedSender r8 = new io.ktor.client.plugins.HttpSend$InterceptedSender
            T r9 = r5.element
            io.ktor.client.plugins.Sender r9 = (io.ktor.client.plugins.Sender) r9
            r8.<init>(r7, r9)
            r5.element = r8
            goto L_0x00a0
        L_0x00c3:
            T r11 = r5.element
            io.ktor.client.plugins.Sender r11 = (io.ktor.client.plugins.Sender) r11
            java.lang.Object r5 = r1.d()
            io.ktor.client.request.HttpRequestBuilder r5 = (io.ktor.client.request.HttpRequestBuilder) r5
            r10.L$0 = r1
            r10.label = r3
            java.lang.Object r11 = r11.a(r5, r10)
            if (r11 != r0) goto L_0x00d8
            return r0
        L_0x00d8:
            io.ktor.client.call.HttpClientCall r11 = (io.ktor.client.call.HttpClientCall) r11
            r10.L$0 = r4
            r10.label = r2
            java.lang.Object r10 = r1.g(r11, r10)
            if (r10 != r0) goto L_0x00e5
            return r0
        L_0x00e5:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00e8:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "\n|Fail to prepare request body for sending. \n|The body type is: "
            r10.append(r0)
            java.lang.Class r11 = r11.getClass()
            kotlin.reflect.KClass r11 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r11)
            r10.append(r11)
            java.lang.String r11 = ", with Content-Type: "
            r10.append(r11)
            java.lang.Object r11 = r1.d()
            io.ktor.http.HttpMessageBuilder r11 = (io.ktor.http.HttpMessageBuilder) r11
            io.ktor.http.ContentType r11 = io.ktor.http.HttpMessagePropertiesKt.e(r11)
            r10.append(r11)
            java.lang.String r11 = ".\n|\n|If you expect serialized body, please check that you have installed the corresponding plugin(like `ContentNegotiation`) and set `Content-Type` header."
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.lang.String r10 = kotlin.text.StringsKt.trimMargin$default(r10, r4, r3, r4)
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r10 = r10.toString()
            r11.<init>(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpSend$Plugin$install$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

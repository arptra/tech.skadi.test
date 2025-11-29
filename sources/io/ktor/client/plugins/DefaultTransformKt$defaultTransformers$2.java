package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
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

@SourceDebugExtension({"SMAP\nDefaultTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultTransform.kt\nio/ktor/client/plugins/DefaultTransformKt$defaultTransformers$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,144:1\n1#2:145\n*E\n"})
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<name for destructuring parameter 0>"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2", f = "DefaultTransform.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 7, 7, 8, 8}, l = {68, 72, 72, 78, 78, 82, 90, 116, 121}, m = "invokeSuspend", n = {"$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "response", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class DefaultTransformKt$defaultTransformers$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public DefaultTransformKt$defaultTransformers$2(Continuation<? super DefaultTransformKt$defaultTransformers$2> continuation) {
        super(3, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, @NotNull HttpResponseContainer httpResponseContainer, @Nullable Continuation<? super Unit> continuation) {
        DefaultTransformKt$defaultTransformers$2 defaultTransformKt$defaultTransformers$2 = new DefaultTransformKt$defaultTransformers$2(continuation);
        defaultTransformKt$defaultTransformers$2.L$0 = pipelineContext;
        defaultTransformKt$defaultTransformers$2.L$1 = httpResponseContainer;
        return defaultTransformKt$defaultTransformers$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v7, resolved type: io.ktor.util.pipeline.PipelineContext} */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x010c, code lost:
        r9 = (io.ktor.client.statement.HttpResponseContainer) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x010f, code lost:
        r15 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x013a, code lost:
        r4 = new io.ktor.client.statement.HttpResponseContainer(r14, kotlin.coroutines.jvm.internal.Boxing.boxInt(java.lang.Integer.parseInt(io.ktor.utils.io.core.Input.L0((io.ktor.utils.io.core.Input) r0, 0, 0, 3, (java.lang.Object) null))));
        r6.L$0 = r15;
        r6.L$1 = r2;
        r6.L$2 = null;
        r6.L$3 = null;
        r6.label = 3;
        r0 = r1.g(r4, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x015c, code lost:
        if (r0 != r7) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x015e, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x015f, code lost:
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0160, code lost:
        r9 = (io.ktor.client.statement.HttpResponseContainer) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0163, code lost:
        r15 = r1;
        r14 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x019d, code lost:
        r3 = new io.ktor.client.statement.HttpResponseContainer(r14, r0);
        r6.L$0 = r15;
        r6.L$1 = r2;
        r6.L$2 = null;
        r6.L$3 = null;
        r6.label = 5;
        r0 = r1.g(r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01b1, code lost:
        if (r0 != r7) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01b3, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01b4, code lost:
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01b5, code lost:
        r9 = (io.ktor.client.statement.HttpResponseContainer) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01d7, code lost:
        r0 = (byte[]) r0;
        r3 = io.ktor.http.HttpMessagePropertiesKt.c(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01e3, code lost:
        if (io.ktor.util.PlatformUtils.f9037a.a() != false) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01f3, code lost:
        if (r2.a().get(io.ktor.http.HttpHeaders.f8966a.i()) != null) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01f5, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01f7, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01f8, code lost:
        r4 = !kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) ((io.ktor.client.call.HttpClientCall) r15.d()).f().getMethod(), (java.lang.Object) io.ktor.http.HttpMethod.b.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0211, code lost:
        if (r2 == false) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0213, code lost:
        if (r4 == false) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0215, code lost:
        if (r3 == null) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x021f, code lost:
        if (r3.longValue() <= 0) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0227, code lost:
        if (r0.length != ((int) r3.longValue())) goto L_0x022a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0229, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x022a, code lost:
        if (r8 == false) goto L_0x022d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0250, code lost:
        throw new java.lang.IllegalStateException(("Expected " + r3 + ", actual " + r0.length).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0251, code lost:
        r1 = new io.ktor.client.statement.HttpResponseContainer(r14, r0);
        r6.L$0 = r15;
        r6.L$1 = r14;
        r6.L$2 = null;
        r6.label = 7;
        r0 = r15.g(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0263, code lost:
        if (r0 != r7) goto L_0x0266;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0265, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0266, code lost:
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0267, code lost:
        r9 = (io.ktor.client.statement.HttpResponseContainer) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02be, code lost:
        r9 = (io.ktor.client.statement.HttpResponseContainer) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02c1, code lost:
        r15 = r1;
        r14 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02f0, code lost:
        r9 = (io.ktor.client.statement.HttpResponseContainer) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02f6, code lost:
        if (r9 == null) goto L_0x032a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02f8, code lost:
        io.ktor.client.plugins.DefaultTransformKt.f8837a.trace("Transformed with default transformers response body for " + ((io.ktor.client.call.HttpClientCall) r15.d()).f().T() + " to " + r14.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x032c, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
        /*
            r16 = this;
            r6 = r16
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r6.label
            r8 = 0
            r1 = 1
            r9 = 0
            switch(r0) {
                case 0: goto L_0x00bd;
                case 1: goto L_0x00ae;
                case 2: goto L_0x0095;
                case 3: goto L_0x0085;
                case 4: goto L_0x006c;
                case 5: goto L_0x005c;
                case 6: goto L_0x0046;
                case 7: goto L_0x0036;
                case 8: goto L_0x0026;
                case 9: goto L_0x0016;
                default: goto L_0x000e;
            }
        L_0x000e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0016:
            java.lang.Object r0 = r6.L$1
            io.ktor.util.reflect.TypeInfo r0 = (io.ktor.util.reflect.TypeInfo) r0
            java.lang.Object r1 = r6.L$0
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            kotlin.ResultKt.throwOnFailure(r17)
            r4 = r0
            r0 = r17
            goto L_0x02f0
        L_0x0026:
            java.lang.Object r0 = r6.L$1
            io.ktor.util.reflect.TypeInfo r0 = (io.ktor.util.reflect.TypeInfo) r0
            java.lang.Object r1 = r6.L$0
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            kotlin.ResultKt.throwOnFailure(r17)
            r4 = r0
            r0 = r17
            goto L_0x02be
        L_0x0036:
            java.lang.Object r0 = r6.L$1
            io.ktor.util.reflect.TypeInfo r0 = (io.ktor.util.reflect.TypeInfo) r0
            java.lang.Object r1 = r6.L$0
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            kotlin.ResultKt.throwOnFailure(r17)
            r14 = r0
            r0 = r17
            goto L_0x0267
        L_0x0046:
            java.lang.Object r0 = r6.L$2
            io.ktor.client.statement.HttpResponse r0 = (io.ktor.client.statement.HttpResponse) r0
            java.lang.Object r2 = r6.L$1
            io.ktor.util.reflect.TypeInfo r2 = (io.ktor.util.reflect.TypeInfo) r2
            java.lang.Object r3 = r6.L$0
            io.ktor.util.pipeline.PipelineContext r3 = (io.ktor.util.pipeline.PipelineContext) r3
            kotlin.ResultKt.throwOnFailure(r17)
            r14 = r2
            r15 = r3
            r2 = r0
            r0 = r17
            goto L_0x01d7
        L_0x005c:
            java.lang.Object r0 = r6.L$1
            io.ktor.util.reflect.TypeInfo r0 = (io.ktor.util.reflect.TypeInfo) r0
            java.lang.Object r1 = r6.L$0
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            kotlin.ResultKt.throwOnFailure(r17)
            r2 = r0
            r0 = r17
            goto L_0x01b5
        L_0x006c:
            java.lang.Object r0 = r6.L$3
            io.ktor.util.reflect.TypeInfo r0 = (io.ktor.util.reflect.TypeInfo) r0
            java.lang.Object r1 = r6.L$2
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            java.lang.Object r2 = r6.L$1
            io.ktor.util.reflect.TypeInfo r2 = (io.ktor.util.reflect.TypeInfo) r2
            java.lang.Object r3 = r6.L$0
            io.ktor.util.pipeline.PipelineContext r3 = (io.ktor.util.pipeline.PipelineContext) r3
            kotlin.ResultKt.throwOnFailure(r17)
            r14 = r0
            r15 = r3
            r0 = r17
            goto L_0x019d
        L_0x0085:
            java.lang.Object r0 = r6.L$1
            io.ktor.util.reflect.TypeInfo r0 = (io.ktor.util.reflect.TypeInfo) r0
            java.lang.Object r1 = r6.L$0
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            kotlin.ResultKt.throwOnFailure(r17)
            r2 = r0
            r0 = r17
            goto L_0x0160
        L_0x0095:
            java.lang.Object r0 = r6.L$3
            io.ktor.util.reflect.TypeInfo r0 = (io.ktor.util.reflect.TypeInfo) r0
            java.lang.Object r1 = r6.L$2
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            java.lang.Object r2 = r6.L$1
            io.ktor.util.reflect.TypeInfo r2 = (io.ktor.util.reflect.TypeInfo) r2
            java.lang.Object r3 = r6.L$0
            io.ktor.util.pipeline.PipelineContext r3 = (io.ktor.util.pipeline.PipelineContext) r3
            kotlin.ResultKt.throwOnFailure(r17)
            r14 = r0
            r15 = r3
            r0 = r17
            goto L_0x013a
        L_0x00ae:
            java.lang.Object r0 = r6.L$1
            io.ktor.util.reflect.TypeInfo r0 = (io.ktor.util.reflect.TypeInfo) r0
            java.lang.Object r1 = r6.L$0
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            kotlin.ResultKt.throwOnFailure(r17)
            r14 = r0
            r0 = r17
            goto L_0x010c
        L_0x00bd:
            kotlin.ResultKt.throwOnFailure(r17)
            java.lang.Object r0 = r6.L$0
            r15 = r0
            io.ktor.util.pipeline.PipelineContext r15 = (io.ktor.util.pipeline.PipelineContext) r15
            java.lang.Object r0 = r6.L$1
            io.ktor.client.statement.HttpResponseContainer r0 = (io.ktor.client.statement.HttpResponseContainer) r0
            io.ktor.util.reflect.TypeInfo r14 = r0.a()
            java.lang.Object r0 = r0.b()
            boolean r2 = r0 instanceof io.ktor.utils.io.ByteReadChannel
            if (r2 != 0) goto L_0x00d8
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00d8:
            java.lang.Object r2 = r15.d()
            io.ktor.client.call.HttpClientCall r2 = (io.ktor.client.call.HttpClientCall) r2
            io.ktor.client.statement.HttpResponse r2 = r2.g()
            kotlin.reflect.KClass r3 = r14.b()
            java.lang.Class<kotlin.Unit> r4 = kotlin.Unit.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0112
            io.ktor.utils.io.ByteReadChannel r0 = (io.ktor.utils.io.ByteReadChannel) r0
            io.ktor.utils.io.ByteReadChannelKt.a(r0)
            io.ktor.client.statement.HttpResponseContainer r0 = new io.ktor.client.statement.HttpResponseContainer
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r0.<init>(r14, r2)
            r6.L$0 = r15
            r6.L$1 = r14
            r6.label = r1
            java.lang.Object r0 = r15.g(r0, r6)
            if (r0 != r7) goto L_0x010b
            return r7
        L_0x010b:
            r1 = r15
        L_0x010c:
            r9 = r0
            io.ktor.client.statement.HttpResponseContainer r9 = (io.ktor.client.statement.HttpResponseContainer) r9
        L_0x010f:
            r15 = r1
            goto L_0x02f6
        L_0x0112:
            java.lang.Class r4 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0167
            io.ktor.utils.io.ByteReadChannel r0 = (io.ktor.utils.io.ByteReadChannel) r0
            r6.L$0 = r15
            r6.L$1 = r14
            r6.L$2 = r15
            r6.L$3 = r14
            r1 = 2
            r6.label = r1
            r1 = 0
            r4 = 1
            r5 = 0
            r3 = r16
            java.lang.Object r0 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.a(r0, r1, r3, r4, r5)
            if (r0 != r7) goto L_0x0138
            return r7
        L_0x0138:
            r2 = r14
            r1 = r15
        L_0x013a:
            io.ktor.utils.io.core.Input r0 = (io.ktor.utils.io.core.Input) r0
            r3 = 3
            java.lang.String r0 = io.ktor.utils.io.core.Input.L0(r0, r8, r8, r3, r9)
            int r0 = java.lang.Integer.parseInt(r0)
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            io.ktor.client.statement.HttpResponseContainer r4 = new io.ktor.client.statement.HttpResponseContainer
            r4.<init>(r14, r0)
            r6.L$0 = r15
            r6.L$1 = r2
            r6.L$2 = r9
            r6.L$3 = r9
            r6.label = r3
            java.lang.Object r0 = r1.g(r4, r6)
            if (r0 != r7) goto L_0x015f
            return r7
        L_0x015f:
            r1 = r15
        L_0x0160:
            r9 = r0
            io.ktor.client.statement.HttpResponseContainer r9 = (io.ktor.client.statement.HttpResponseContainer) r9
        L_0x0163:
            r15 = r1
            r14 = r2
            goto L_0x02f6
        L_0x0167:
            java.lang.Class<io.ktor.utils.io.core.ByteReadPacket> r4 = io.ktor.utils.io.core.ByteReadPacket.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0175
            r4 = r1
            goto L_0x017f
        L_0x0175:
            java.lang.Class<io.ktor.utils.io.core.Input> r4 = io.ktor.utils.io.core.Input.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
        L_0x017f:
            if (r4 == 0) goto L_0x01b9
            io.ktor.utils.io.ByteReadChannel r0 = (io.ktor.utils.io.ByteReadChannel) r0
            r6.L$0 = r15
            r6.L$1 = r14
            r6.L$2 = r15
            r6.L$3 = r14
            r1 = 4
            r6.label = r1
            r1 = 0
            r4 = 1
            r5 = 0
            r3 = r16
            java.lang.Object r0 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.a(r0, r1, r3, r4, r5)
            if (r0 != r7) goto L_0x019b
            return r7
        L_0x019b:
            r2 = r14
            r1 = r15
        L_0x019d:
            io.ktor.client.statement.HttpResponseContainer r3 = new io.ktor.client.statement.HttpResponseContainer
            r3.<init>(r14, r0)
            r6.L$0 = r15
            r6.L$1 = r2
            r6.L$2 = r9
            r6.L$3 = r9
            r0 = 5
            r6.label = r0
            java.lang.Object r0 = r1.g(r3, r6)
            if (r0 != r7) goto L_0x01b4
            return r7
        L_0x01b4:
            r1 = r15
        L_0x01b5:
            r9 = r0
            io.ktor.client.statement.HttpResponseContainer r9 = (io.ktor.client.statement.HttpResponseContainer) r9
            goto L_0x0163
        L_0x01b9:
            java.lang.Class<byte[]> r4 = byte[].class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x026c
            io.ktor.utils.io.ByteReadChannel r0 = (io.ktor.utils.io.ByteReadChannel) r0
            r6.L$0 = r15
            r6.L$1 = r14
            r6.L$2 = r2
            r3 = 6
            r6.label = r3
            java.lang.Object r0 = io.ktor.util.ByteChannelsKt.b(r0, r6)
            if (r0 != r7) goto L_0x01d7
            return r7
        L_0x01d7:
            byte[] r0 = (byte[]) r0
            java.lang.Long r3 = io.ktor.http.HttpMessagePropertiesKt.c(r2)
            io.ktor.util.PlatformUtils r4 = io.ktor.util.PlatformUtils.f9037a
            boolean r4 = r4.a()
            if (r4 != 0) goto L_0x01f7
            io.ktor.http.Headers r2 = r2.a()
            io.ktor.http.HttpHeaders r4 = io.ktor.http.HttpHeaders.f8966a
            java.lang.String r4 = r4.i()
            java.lang.String r2 = r2.get(r4)
            if (r2 != 0) goto L_0x01f7
            r2 = r1
            goto L_0x01f8
        L_0x01f7:
            r2 = r8
        L_0x01f8:
            java.lang.Object r4 = r15.d()
            io.ktor.client.call.HttpClientCall r4 = (io.ktor.client.call.HttpClientCall) r4
            io.ktor.client.request.HttpRequest r4 = r4.f()
            io.ktor.http.HttpMethod r4 = r4.getMethod()
            io.ktor.http.HttpMethod$Companion r5 = io.ktor.http.HttpMethod.b
            io.ktor.http.HttpMethod r5 = r5.b()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            r4 = r4 ^ r1
            if (r2 == 0) goto L_0x0251
            if (r4 == 0) goto L_0x0251
            if (r3 == 0) goto L_0x0251
            long r4 = r3.longValue()
            r10 = 0
            int r2 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r2 <= 0) goto L_0x0251
            int r2 = r0.length
            long r4 = r3.longValue()
            int r4 = (int) r4
            if (r2 != r4) goto L_0x022a
            r8 = r1
        L_0x022a:
            if (r8 == 0) goto L_0x022d
            goto L_0x0251
        L_0x022d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = ", actual "
            r1.append(r2)
            int r0 = r0.length
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0251:
            io.ktor.client.statement.HttpResponseContainer r1 = new io.ktor.client.statement.HttpResponseContainer
            r1.<init>(r14, r0)
            r6.L$0 = r15
            r6.L$1 = r14
            r6.L$2 = r9
            r0 = 7
            r6.label = r0
            java.lang.Object r0 = r15.g(r1, r6)
            if (r0 != r7) goto L_0x0266
            return r7
        L_0x0266:
            r1 = r15
        L_0x0267:
            r9 = r0
            io.ktor.client.statement.HttpResponseContainer r9 = (io.ktor.client.statement.HttpResponseContainer) r9
            goto L_0x010f
        L_0x026c:
            java.lang.Class<io.ktor.utils.io.ByteReadChannel> r1 = io.ktor.utils.io.ByteReadChannel.class
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x02c4
            kotlin.coroutines.CoroutineContext r1 = r2.getCoroutineContext()
            kotlinx.coroutines.Job$Key r3 = kotlinx.coroutines.Job.b0
            kotlin.coroutines.CoroutineContext$Element r1 = r1.get(r3)
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
            kotlinx.coroutines.CompletableJob r1 = kotlinx.coroutines.JobKt.a(r1)
            kotlin.coroutines.CoroutineContext r11 = r2.getCoroutineContext()
            io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$result$channel$1 r13 = new io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$result$channel$1
            r13.<init>(r0, r2, r9)
            r0 = 2
            r2 = 0
            r12 = 0
            r10 = r15
            r4 = r14
            r14 = r0
            r5 = r15
            r15 = r2
            io.ktor.utils.io.WriterJob r0 = io.ktor.utils.io.CoroutinesKt.c(r10, r11, r12, r13, r14, r15)
            io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$result$channel$2$1 r2 = new io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$result$channel$2$1
            r2.<init>(r1)
            r0.r(r2)
            io.ktor.utils.io.ByteReadChannel r0 = r0.b()
            io.ktor.client.statement.HttpResponseContainer r1 = new io.ktor.client.statement.HttpResponseContainer
            r1.<init>(r4, r0)
            r6.L$0 = r5
            r6.L$1 = r4
            r0 = 8
            r6.label = r0
            java.lang.Object r0 = r5.g(r1, r6)
            if (r0 != r7) goto L_0x02bd
            return r7
        L_0x02bd:
            r1 = r5
        L_0x02be:
            r9 = r0
            io.ktor.client.statement.HttpResponseContainer r9 = (io.ktor.client.statement.HttpResponseContainer) r9
        L_0x02c1:
            r15 = r1
            r14 = r4
            goto L_0x02f6
        L_0x02c4:
            r4 = r14
            r5 = r15
            java.lang.Class<io.ktor.http.HttpStatusCode> r1 = io.ktor.http.HttpStatusCode.class
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x02f4
            io.ktor.utils.io.ByteReadChannel r0 = (io.ktor.utils.io.ByteReadChannel) r0
            io.ktor.utils.io.ByteReadChannelKt.a(r0)
            io.ktor.client.statement.HttpResponseContainer r0 = new io.ktor.client.statement.HttpResponseContainer
            io.ktor.http.HttpStatusCode r1 = r2.f()
            r0.<init>(r4, r1)
            r6.L$0 = r5
            r6.L$1 = r4
            r1 = 9
            r6.label = r1
            java.lang.Object r0 = r5.g(r0, r6)
            if (r0 != r7) goto L_0x02ef
            return r7
        L_0x02ef:
            r1 = r5
        L_0x02f0:
            r9 = r0
            io.ktor.client.statement.HttpResponseContainer r9 = (io.ktor.client.statement.HttpResponseContainer) r9
            goto L_0x02c1
        L_0x02f4:
            r14 = r4
            r15 = r5
        L_0x02f6:
            if (r9 == 0) goto L_0x032a
            org.slf4j.Logger r0 = io.ktor.client.plugins.DefaultTransformKt.f8837a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Transformed with default transformers response body for "
            r1.append(r2)
            java.lang.Object r2 = r15.d()
            io.ktor.client.call.HttpClientCall r2 = (io.ktor.client.call.HttpClientCall) r2
            io.ktor.client.request.HttpRequest r2 = r2.f()
            io.ktor.http.Url r2 = r2.T()
            r1.append(r2)
            java.lang.String r2 = " to "
            r1.append(r2)
            kotlin.reflect.KClass r2 = r14.b()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.trace(r1)
        L_0x032a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

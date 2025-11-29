package com.upuphone.ai.ttsengine.flavor.service;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ai.ttsengine.flavor.service.LicenceSender$sendFile$2", f = "LicenceSender.kt", i = {0, 0, 1, 1, 1, 1}, l = {102, 111}, m = "invokeSuspend", n = {"$this$withContext", "$this$invokeSuspend_u24lambda_u244_u24lambda_u243", "$this$withContext", "$this$invokeSuspend_u24lambda_u244_u24lambda_u243", "buffer", "baIs"}, s = {"L$0", "L$4", "L$0", "L$4", "L$5", "L$6"})
public final class LicenceSender$sendFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ long $version;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ LicenceSender this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LicenceSender$sendFile$2(Context context, LicenceSender licenceSender, long j, Continuation<? super LicenceSender$sendFile$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.this$0 = licenceSender;
        this.$version = j;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        LicenceSender$sendFile$2 licenceSender$sendFile$2 = new LicenceSender$sendFile$2(this.$context, this.this$0, this.$version, continuation);
        licenceSender$sendFile$2.L$0 = obj;
        return licenceSender$sendFile$2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: kotlinx.coroutines.CoroutineScope} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: java.io.InputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ec A[SYNTHETIC, Splitter:B:26:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0134 A[Catch:{ all -> 0x0174 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0177  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 50
            java.lang.String r5 = "getBytes(...)"
            r6 = 2
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x005c
            if (r2 == r7) goto L_0x0043
            if (r2 != r6) goto L_0x003b
            java.lang.Object r2 = r0.L$6
            java.io.ByteArrayInputStream r2 = (java.io.ByteArrayInputStream) r2
            java.lang.Object r9 = r0.L$5
            byte[] r9 = (byte[]) r9
            java.lang.Object r10 = r0.L$4
            byte[] r10 = (byte[]) r10
            java.lang.Object r11 = r0.L$3
            byte[] r11 = (byte[]) r11
            java.lang.Object r12 = r0.L$2
            com.upuphone.ai.ttsengine.flavor.service.LicenceSender r12 = (com.upuphone.ai.ttsengine.flavor.service.LicenceSender) r12
            java.lang.Object r13 = r0.L$1
            java.io.Closeable r13 = (java.io.Closeable) r13
            java.lang.Object r14 = r0.L$0
            kotlinx.coroutines.CoroutineScope r14 = (kotlinx.coroutines.CoroutineScope) r14
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ all -> 0x0037 }
            r15 = r13
            goto L_0x0124
        L_0x0037:
            r0 = move-exception
            r1 = r0
            goto L_0x0184
        L_0x003b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0043:
            java.lang.Object r2 = r0.L$4
            byte[] r2 = (byte[]) r2
            java.lang.Object r9 = r0.L$3
            byte[] r9 = (byte[]) r9
            java.lang.Object r10 = r0.L$2
            com.upuphone.ai.ttsengine.flavor.service.LicenceSender r10 = (com.upuphone.ai.ttsengine.flavor.service.LicenceSender) r10
            java.lang.Object r11 = r0.L$1
            r13 = r11
            java.io.Closeable r13 = (java.io.Closeable) r13
            java.lang.Object r11 = r0.L$0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ all -> 0x0037 }
            goto L_0x00d0
        L_0x005c:
            kotlin.ResultKt.throwOnFailure(r22)
            java.lang.Object r2 = r0.L$0
            r11 = r2
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            android.content.Context r2 = r0.$context
            android.content.res.AssetManager r2 = r2.getAssets()
            java.lang.String r9 = "glass/licence/speech_license.licbag"
            java.io.InputStream r13 = r2.open(r9)
            com.upuphone.ai.ttsengine.flavor.service.LicenceSender r10 = r0.this$0
            long r14 = r0.$version
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)     // Catch:{ all -> 0x0037 }
            byte[] r2 = kotlin.io.ByteStreamsKt.readBytes(r13)     // Catch:{ all -> 0x0037 }
            com.upuphone.ai.ttsengine.protocol.bean.LicenceBean r9 = new com.upuphone.ai.ttsengine.protocol.bean.LicenceBean     // Catch:{ all -> 0x0037 }
            r9.<init>()     // Catch:{ all -> 0x0037 }
            r9.setVersion(r14)     // Catch:{ all -> 0x0037 }
            int r12 = r2.length     // Catch:{ all -> 0x0037 }
            r9.setLength(r12)     // Catch:{ all -> 0x0037 }
            com.upuphone.ai.ttsengine.base.utils.AILOG r12 = r10.c     // Catch:{ all -> 0x0037 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0037 }
            r14.<init>()     // Catch:{ all -> 0x0037 }
            java.lang.String r15 = "trans begin info: "
            r14.append(r15)     // Catch:{ all -> 0x0037 }
            r14.append(r9)     // Catch:{ all -> 0x0037 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x0037 }
            java.lang.Object[] r15 = new java.lang.Object[r8]     // Catch:{ all -> 0x0037 }
            r12.c(r14, r15)     // Catch:{ all -> 0x0037 }
            java.lang.String r9 = com.upuphone.ai.ttsengine.base.utils.GsonUtils.b(r9)     // Catch:{ all -> 0x0037 }
            java.nio.charset.Charset r12 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x0037 }
            byte[] r9 = r9.getBytes(r12)     // Catch:{ all -> 0x0037 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r5)     // Catch:{ all -> 0x0037 }
            r18 = 4
            r19 = 0
            r15 = 0
            r17 = 0
            r14 = r10
            r16 = r9
            com.upuphone.ai.ttsengine.flavor.service.LicenceSender.j(r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x0037 }
            r0.L$0 = r11     // Catch:{ all -> 0x0037 }
            r0.L$1 = r13     // Catch:{ all -> 0x0037 }
            r0.L$2 = r10     // Catch:{ all -> 0x0037 }
            r0.L$3 = r2     // Catch:{ all -> 0x0037 }
            r0.L$4 = r2     // Catch:{ all -> 0x0037 }
            r0.label = r7     // Catch:{ all -> 0x0037 }
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r3, r0)     // Catch:{ all -> 0x0037 }
            if (r9 != r1) goto L_0x00cf
            return r1
        L_0x00cf:
            r9 = r2
        L_0x00d0:
            r12 = 250(0xfa, float:3.5E-43)
            byte[] r12 = new byte[r12]     // Catch:{ all -> 0x0037 }
            java.io.ByteArrayInputStream r14 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0037 }
            r14.<init>(r2)     // Catch:{ all -> 0x0037 }
            r15 = r13
            r20 = r10
            r10 = r2
            r2 = r14
            r14 = r11
            r11 = r9
            r9 = r12
            r12 = r20
        L_0x00e3:
            kotlinx.coroutines.CoroutineScopeKt.g(r14)     // Catch:{ all -> 0x0174 }
            int r13 = r2.read(r9)     // Catch:{ all -> 0x0174 }
            if (r13 <= 0) goto L_0x012a
            com.upuphone.ai.ttsengine.base.utils.AILOG r3 = r12.c     // Catch:{ all -> 0x0126 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r4.<init>()     // Catch:{ all -> 0x0126 }
            java.lang.String r6 = "trans data len: "
            r4.append(r6)     // Catch:{ all -> 0x0126 }
            r4.append(r13)     // Catch:{ all -> 0x0126 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0126 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x0126 }
            r3.c(r4, r6)     // Catch:{ all -> 0x0126 }
            r12.i(r7, r9, r13)     // Catch:{ all -> 0x0126 }
            r0.L$0 = r14     // Catch:{ all -> 0x0126 }
            r0.L$1 = r15     // Catch:{ all -> 0x0126 }
            r0.L$2 = r12     // Catch:{ all -> 0x0126 }
            r0.L$3 = r11     // Catch:{ all -> 0x0126 }
            r0.L$4 = r10     // Catch:{ all -> 0x0126 }
            r0.L$5 = r9     // Catch:{ all -> 0x0126 }
            r0.L$6 = r2     // Catch:{ all -> 0x0126 }
            r3 = 2
            r0.label = r3     // Catch:{ all -> 0x0126 }
            r3 = 50
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.b(r3, r0)     // Catch:{ all -> 0x0126 }
            if (r6 != r1) goto L_0x0124
            return r1
        L_0x0124:
            r6 = 2
            goto L_0x00e3
        L_0x0126:
            r0 = move-exception
            r1 = r0
            r13 = r15
            goto L_0x0184
        L_0x012a:
            java.lang.String r1 = kotlin.text.StringsKt.decodeToString(r10)     // Catch:{ all -> 0x0174 }
            java.lang.String r1 = com.upuphone.ai.ttsengine.base.utils.StringUtilsKt.b(r1)     // Catch:{ all -> 0x0174 }
            if (r1 == 0) goto L_0x0177
            com.upuphone.ai.ttsengine.protocol.bean.LicenceBean r2 = new com.upuphone.ai.ttsengine.protocol.bean.LicenceBean     // Catch:{ all -> 0x0174 }
            r2.<init>()     // Catch:{ all -> 0x0174 }
            r2.setMd5(r1)     // Catch:{ all -> 0x0174 }
            com.upuphone.ai.ttsengine.base.utils.AILOG r1 = r12.c     // Catch:{ all -> 0x0174 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0174 }
            r3.<init>()     // Catch:{ all -> 0x0174 }
            java.lang.String r4 = "trans end info: "
            r3.append(r4)     // Catch:{ all -> 0x0174 }
            r3.append(r2)     // Catch:{ all -> 0x0174 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0174 }
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ all -> 0x0174 }
            r1.c(r3, r4)     // Catch:{ all -> 0x0174 }
            java.lang.String r1 = com.upuphone.ai.ttsengine.base.utils.GsonUtils.b(r2)     // Catch:{ all -> 0x0174 }
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x0174 }
            byte[] r14 = r1.getBytes(r2)     // Catch:{ all -> 0x0174 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r5)     // Catch:{ all -> 0x0174 }
            r16 = 4
            r17 = 0
            r13 = 2
            r1 = 0
            r2 = r15
            r15 = r1
            com.upuphone.ai.ttsengine.flavor.service.LicenceSender.j(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0170 }
            goto L_0x0178
        L_0x0170:
            r0 = move-exception
        L_0x0171:
            r1 = r0
            r13 = r2
            goto L_0x0184
        L_0x0174:
            r0 = move-exception
            r2 = r15
            goto L_0x0171
        L_0x0177:
            r2 = r15
        L_0x0178:
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r1)
            com.upuphone.ai.ttsengine.flavor.service.LicenceSender r0 = r0.this$0
            r0.f = r8
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0184:
            throw r1     // Catch:{ all -> 0x0185 }
        L_0x0185:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r13, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.flavor.service.LicenceSender$sendFile$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LicenceSender$sendFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

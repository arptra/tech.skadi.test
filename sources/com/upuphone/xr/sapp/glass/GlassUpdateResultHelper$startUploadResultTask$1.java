package com.upuphone.xr.sapp.glass;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nGlassUpdateResultHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassUpdateResultHelper.kt\ncom/upuphone/xr/sapp/glass/GlassUpdateResultHelper$startUploadResultTask$1\n+ 2 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n*L\n1#1,464:1\n29#2,5:465\n*S KotlinDebug\n*F\n+ 1 GlassUpdateResultHelper.kt\ncom/upuphone/xr/sapp/glass/GlassUpdateResultHelper$startUploadResultTask$1\n*L\n240#1:465,5\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateResultHelper$startUploadResultTask$1", f = "GlassUpdateResultHelper.kt", i = {0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6}, l = {222, 226, 231, 233, 243, 251, 256}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "handledIds", "lastId", "$this$launch", "handledIds", "$this$launch", "handledIds", "$this$launch", "handledIds", "lastId", "$this$launch", "handledIds", "lastId", "entity", "$this$launch", "handledIds", "lastId"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
public final class GlassUpdateResultHelper$startUploadResultTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayTime;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateResultHelper$startUploadResultTask$1(long j, Continuation<? super GlassUpdateResultHelper$startUploadResultTask$1> continuation) {
        super(2, continuation);
        this.$delayTime = j;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GlassUpdateResultHelper$startUploadResultTask$1 glassUpdateResultHelper$startUploadResultTask$1 = new GlassUpdateResultHelper$startUploadResultTask$1(this.$delayTime, continuation);
        glassUpdateResultHelper$startUploadResultTask$1.L$0 = obj;
        return glassUpdateResultHelper$startUploadResultTask$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v36, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: kotlinx.coroutines.CoroutineScope} */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0087, code lost:
        r13 = new java.util.LinkedHashSet();
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0091, code lost:
        if (kotlinx.coroutines.CoroutineScopeKt.h(r1) == false) goto L_0x0202;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0093, code lost:
        r4 = com.upuphone.xr.sapp.utils.NetworkUtils.f7898a;
        r12.L$0 = r1;
        r12.L$1 = r13;
        r12.L$2 = r3;
        r12.L$3 = null;
        r12.label = 2;
        r4 = r4.h(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a4, code lost:
        if (r4 != r0) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a6, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a7, code lost:
        r10 = r3;
        r3 = r13;
        r13 = r4;
        r4 = r1;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b2, code lost:
        if (((java.lang.Boolean) r13).booleanValue() != false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b4, code lost:
        com.upuphone.xr.sapp.glass.GlassUpdateResultHelper.b.x("uploadUpdateResult, no network");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00be, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00bf, code lost:
        if (r1 == null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c1, code lost:
        r13 = com.upuphone.xr.sapp.glass.db.GlassUpdateDB.f7073a.a().e();
        r5 = r1.longValue();
        r12.L$0 = r4;
        r12.L$1 = r3;
        r12.L$2 = null;
        r12.label = 3;
        r13 = r13.d(r5, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00dc, code lost:
        if (r13 != r0) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00de, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00df, code lost:
        r1 = r3;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e1, code lost:
        r13 = (com.upuphone.xr.sapp.glass.db.GlassUpdateResultEntity) r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e3, code lost:
        r4 = r3;
        r3 = r1;
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00e7, code lost:
        r13 = com.upuphone.xr.sapp.glass.db.GlassUpdateDB.f7073a.a().e();
        r12.L$0 = r4;
        r12.L$1 = r3;
        r12.L$2 = null;
        r12.label = 4;
        r13 = r13.b(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00fe, code lost:
        if (r13 != r0) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0100, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0101, code lost:
        r1 = r3;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0103, code lost:
        r13 = (com.upuphone.xr.sapp.glass.db.GlassUpdateResultEntity) r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0106, code lost:
        if (r1 != null) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0108, code lost:
        com.upuphone.xr.sapp.glass.GlassUpdateResultHelper.b.x("uploadUpdateResult, no data");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0112, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0113, code lost:
        r13 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r1.getId());
        r5 = com.upuphone.xr.sapp.utils.JsonUtils.f7893a;
        r6 = r1.getContent();
        r7 = new com.upuphone.xr.sapp.glass.GlassUpdateResultHelper$startUploadResultTask$1$invokeSuspend$$inlined$fromJson$1().getType();
        r8 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0134, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8.getClass()) != false) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x013c, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) java.lang.Void.class) == false) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x013f, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r7);
        r5 = r5.a(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0147, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r7);
        r5 = r5.a("{}", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0151, code lost:
        r5 = (com.upuphone.star.fota.phone.GlassUpdateResultParam) r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0153, code lost:
        if (r5 != null) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0155, code lost:
        com.upuphone.xr.sapp.glass.GlassUpdateResultHelper.b.x("uploadUpdateResult, wrong data");
        r5 = com.upuphone.xr.sapp.glass.db.GlassUpdateDB.f7073a.a().e();
        r12.L$0 = r4;
        r12.L$1 = r3;
        r12.L$2 = r13;
        r12.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0174, code lost:
        if (r5.c(r1, r12) != r0) goto L_0x0177;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0176, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0177, code lost:
        r1 = r4;
        r10 = r3;
        r3 = r13;
        r13 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0189, code lost:
        if (r3.add(kotlin.coroutines.jvm.internal.Boxing.boxLong(r1.getId())) != false) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x018b, code lost:
        com.upuphone.xr.sapp.glass.GlassUpdateResultHelper.b.x("uploadUpdateResult, finish one loop");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0193, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0194, code lost:
        r6 = com.upuphone.xr.sapp.glass.GlassUpdateResultHelper.b;
        r12.L$0 = r4;
        r12.L$1 = r3;
        r12.L$2 = r13;
        r12.L$3 = r1;
        r12.label = 6;
        r5 = r6.I(r5, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01a5, code lost:
        if (r5 != r0) goto L_0x01a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01a7, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01a8, code lost:
        r10 = r5;
        r5 = r13;
        r13 = r10;
        r11 = r4;
        r4 = r1;
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01ae, code lost:
        r13 = ((java.lang.Boolean) r13).booleanValue();
        r6 = com.upuphone.xr.sapp.glass.GlassUpdateResultHelper.b;
        r6.x("uploadUpdateResult, result: " + r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01cb, code lost:
        if (r13 == false) goto L_0x01fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01cd, code lost:
        r6.x("uploadUpdateResult, delete entity: " + r4);
        r13 = com.upuphone.xr.sapp.glass.db.GlassUpdateDB.f7073a.a().e();
        r12.L$0 = r1;
        r12.L$1 = r3;
        r12.L$2 = r5;
        r12.L$3 = null;
        r12.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01fb, code lost:
        if (r13.c(r4, r12) != r0) goto L_0x01fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01fd, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01fe, code lost:
        r13 = r3;
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0204, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 0
            switch(r1) {
                case 0: goto L_0x0071;
                case 1: goto L_0x0069;
                case 2: goto L_0x0059;
                case 3: goto L_0x004c;
                case 4: goto L_0x003f;
                case 5: goto L_0x002c;
                case 6: goto L_0x0012;
                case 7: goto L_0x002c;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0012:
            java.lang.Object r1 = r12.L$3
            com.upuphone.xr.sapp.glass.db.GlassUpdateResultEntity r1 = (com.upuphone.xr.sapp.glass.db.GlassUpdateResultEntity) r1
            java.lang.Object r3 = r12.L$2
            java.lang.Long r3 = (java.lang.Long) r3
            java.lang.Object r4 = r12.L$1
            java.util.Set r4 = (java.util.Set) r4
            java.lang.Object r5 = r12.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            kotlin.ResultKt.throwOnFailure(r13)
            r10 = r4
            r4 = r1
            r1 = r5
            r5 = r3
            r3 = r10
            goto L_0x01ae
        L_0x002c:
            java.lang.Object r1 = r12.L$2
            java.lang.Long r1 = (java.lang.Long) r1
            java.lang.Object r3 = r12.L$1
            java.util.Set r3 = (java.util.Set) r3
            java.lang.Object r4 = r12.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r3
            r3 = r1
            r1 = r4
            goto L_0x008d
        L_0x003f:
            java.lang.Object r1 = r12.L$1
            java.util.Set r1 = (java.util.Set) r1
            java.lang.Object r3 = r12.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0103
        L_0x004c:
            java.lang.Object r1 = r12.L$1
            java.util.Set r1 = (java.util.Set) r1
            java.lang.Object r3 = r12.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00e1
        L_0x0059:
            java.lang.Object r1 = r12.L$2
            java.lang.Long r1 = (java.lang.Long) r1
            java.lang.Object r3 = r12.L$1
            java.util.Set r3 = (java.util.Set) r3
            java.lang.Object r4 = r12.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00ac
        L_0x0069:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0087
        L_0x0071:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            r1 = r13
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            long r3 = r12.$delayTime
            r12.L$0 = r1
            r13 = 1
            r12.label = r13
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.b(r3, r12)
            if (r13 != r0) goto L_0x0087
            return r0
        L_0x0087:
            java.util.LinkedHashSet r13 = new java.util.LinkedHashSet
            r13.<init>()
            r3 = r2
        L_0x008d:
            boolean r4 = kotlinx.coroutines.CoroutineScopeKt.h(r1)
            if (r4 == 0) goto L_0x0202
            com.upuphone.xr.sapp.utils.NetworkUtils r4 = com.upuphone.xr.sapp.utils.NetworkUtils.f7898a
            r12.L$0 = r1
            r12.L$1 = r13
            r12.L$2 = r3
            r12.L$3 = r2
            r5 = 2
            r12.label = r5
            java.lang.Object r4 = r4.h(r12)
            if (r4 != r0) goto L_0x00a7
            return r0
        L_0x00a7:
            r10 = r3
            r3 = r13
            r13 = r4
            r4 = r1
            r1 = r10
        L_0x00ac:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x00bf
            com.upuphone.xr.sapp.glass.GlassUpdateResultHelper r12 = com.upuphone.xr.sapp.glass.GlassUpdateResultHelper.b
            java.lang.String r13 = "uploadUpdateResult, no network"
            r12.x(r13)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00bf:
            if (r1 == 0) goto L_0x00e7
            com.upuphone.xr.sapp.glass.db.GlassUpdateDB$Companion r13 = com.upuphone.xr.sapp.glass.db.GlassUpdateDB.f7073a
            com.upuphone.xr.sapp.glass.db.GlassUpdateDB r13 = r13.a()
            com.upuphone.xr.sapp.glass.db.GlassUpdateResultDao r13 = r13.e()
            long r5 = r1.longValue()
            r12.L$0 = r4
            r12.L$1 = r3
            r12.L$2 = r2
            r1 = 3
            r12.label = r1
            java.lang.Object r13 = r13.d(r5, r12)
            if (r13 != r0) goto L_0x00df
            return r0
        L_0x00df:
            r1 = r3
            r3 = r4
        L_0x00e1:
            com.upuphone.xr.sapp.glass.db.GlassUpdateResultEntity r13 = (com.upuphone.xr.sapp.glass.db.GlassUpdateResultEntity) r13
        L_0x00e3:
            r4 = r3
            r3 = r1
            r1 = r13
            goto L_0x0106
        L_0x00e7:
            com.upuphone.xr.sapp.glass.db.GlassUpdateDB$Companion r13 = com.upuphone.xr.sapp.glass.db.GlassUpdateDB.f7073a
            com.upuphone.xr.sapp.glass.db.GlassUpdateDB r13 = r13.a()
            com.upuphone.xr.sapp.glass.db.GlassUpdateResultDao r13 = r13.e()
            r12.L$0 = r4
            r12.L$1 = r3
            r12.L$2 = r2
            r1 = 4
            r12.label = r1
            java.lang.Object r13 = r13.b(r12)
            if (r13 != r0) goto L_0x0101
            return r0
        L_0x0101:
            r1 = r3
            r3 = r4
        L_0x0103:
            com.upuphone.xr.sapp.glass.db.GlassUpdateResultEntity r13 = (com.upuphone.xr.sapp.glass.db.GlassUpdateResultEntity) r13
            goto L_0x00e3
        L_0x0106:
            if (r1 != 0) goto L_0x0113
            com.upuphone.xr.sapp.glass.GlassUpdateResultHelper r12 = com.upuphone.xr.sapp.glass.GlassUpdateResultHelper.b
            java.lang.String r13 = "uploadUpdateResult, no data"
            r12.x(r13)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0113:
            long r5 = r1.getId()
            java.lang.Long r13 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
            com.upuphone.xr.sapp.utils.JsonUtils r5 = com.upuphone.xr.sapp.utils.JsonUtils.f7893a
            java.lang.String r6 = r1.getContent()
            com.upuphone.xr.sapp.glass.GlassUpdateResultHelper$startUploadResultTask$1$invokeSuspend$$inlined$fromJson$1 r7 = new com.upuphone.xr.sapp.glass.GlassUpdateResultHelper$startUploadResultTask$1$invokeSuspend$$inlined$fromJson$1
            r7.<init>()
            java.lang.reflect.Type r7 = r7.getType()
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            java.lang.Class r9 = r8.getClass()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r9)
            if (r9 != 0) goto L_0x0147
            java.lang.Class<java.lang.Void> r9 = java.lang.Void.class
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r9)
            if (r9 == 0) goto L_0x013f
            goto L_0x0147
        L_0x013f:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.Object r5 = r5.a(r6, r7)
            goto L_0x0151
        L_0x0147:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.String r6 = "{}"
            java.lang.Object r5 = r5.a(r6, r7)
        L_0x0151:
            com.upuphone.star.fota.phone.GlassUpdateResultParam r5 = (com.upuphone.star.fota.phone.GlassUpdateResultParam) r5
            if (r5 != 0) goto L_0x017d
            com.upuphone.xr.sapp.glass.GlassUpdateResultHelper r5 = com.upuphone.xr.sapp.glass.GlassUpdateResultHelper.b
            java.lang.String r6 = "uploadUpdateResult, wrong data"
            r5.x(r6)
            com.upuphone.xr.sapp.glass.db.GlassUpdateDB$Companion r5 = com.upuphone.xr.sapp.glass.db.GlassUpdateDB.f7073a
            com.upuphone.xr.sapp.glass.db.GlassUpdateDB r5 = r5.a()
            com.upuphone.xr.sapp.glass.db.GlassUpdateResultDao r5 = r5.e()
            r12.L$0 = r4
            r12.L$1 = r3
            r12.L$2 = r13
            r6 = 5
            r12.label = r6
            java.lang.Object r1 = r5.c(r1, r12)
            if (r1 != r0) goto L_0x0177
            return r0
        L_0x0177:
            r1 = r4
            r10 = r3
            r3 = r13
            r13 = r10
            goto L_0x008d
        L_0x017d:
            long r6 = r1.getId()
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            boolean r6 = r3.add(r6)
            if (r6 != 0) goto L_0x0194
            com.upuphone.xr.sapp.glass.GlassUpdateResultHelper r12 = com.upuphone.xr.sapp.glass.GlassUpdateResultHelper.b
            java.lang.String r13 = "uploadUpdateResult, finish one loop"
            r12.x(r13)
            return r8
        L_0x0194:
            com.upuphone.xr.sapp.glass.GlassUpdateResultHelper r6 = com.upuphone.xr.sapp.glass.GlassUpdateResultHelper.b
            r12.L$0 = r4
            r12.L$1 = r3
            r12.L$2 = r13
            r12.L$3 = r1
            r7 = 6
            r12.label = r7
            java.lang.Object r5 = r6.I(r5, r12)
            if (r5 != r0) goto L_0x01a8
            return r0
        L_0x01a8:
            r10 = r5
            r5 = r13
            r13 = r10
            r11 = r4
            r4 = r1
            r1 = r11
        L_0x01ae:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            com.upuphone.xr.sapp.glass.GlassUpdateResultHelper r6 = com.upuphone.xr.sapp.glass.GlassUpdateResultHelper.b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "uploadUpdateResult, result: "
            r7.append(r8)
            r7.append(r13)
            java.lang.String r7 = r7.toString()
            r6.x(r7)
            if (r13 == 0) goto L_0x01fe
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r7 = "uploadUpdateResult, delete entity: "
            r13.append(r7)
            r13.append(r4)
            java.lang.String r13 = r13.toString()
            r6.x(r13)
            com.upuphone.xr.sapp.glass.db.GlassUpdateDB$Companion r13 = com.upuphone.xr.sapp.glass.db.GlassUpdateDB.f7073a
            com.upuphone.xr.sapp.glass.db.GlassUpdateDB r13 = r13.a()
            com.upuphone.xr.sapp.glass.db.GlassUpdateResultDao r13 = r13.e()
            r12.L$0 = r1
            r12.L$1 = r3
            r12.L$2 = r5
            r12.L$3 = r2
            r6 = 7
            r12.label = r6
            java.lang.Object r13 = r13.c(r4, r12)
            if (r13 != r0) goto L_0x01fe
            return r0
        L_0x01fe:
            r13 = r3
            r3 = r5
            goto L_0x008d
        L_0x0202:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.GlassUpdateResultHelper$startUploadResultTask$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassUpdateResultHelper$startUploadResultTask$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

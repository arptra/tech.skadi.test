package com.upuphone.xr.sapp.unicron;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import java.io.File;
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

@SourceDebugExtension({"SMAP\nUnicronUpdateHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnicronUpdateHelper.kt\ncom/upuphone/xr/sapp/unicron/UnicronUpdateHelper$downloadCompleted$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,760:1\n766#2:761\n857#2,2:762\n*S KotlinDebug\n*F\n+ 1 UnicronUpdateHelper.kt\ncom/upuphone/xr/sapp/unicron/UnicronUpdateHelper$downloadCompleted$1\n*L\n622#1:761\n622#1:762,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$downloadCompleted$1", f = "UnicronUpdateHelper.kt", i = {0, 2}, l = {604, 611, 622}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
public final class UnicronUpdateHelper$downloadCompleted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $file;
    final /* synthetic */ GlassUpdateInfo $glassUpdateInfo;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnicronUpdateHelper$downloadCompleted$1(File file, GlassUpdateInfo glassUpdateInfo, Continuation<? super UnicronUpdateHelper$downloadCompleted$1> continuation) {
        super(2, continuation);
        this.$file = file;
        this.$glassUpdateInfo = glassUpdateInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        UnicronUpdateHelper$downloadCompleted$1 unicronUpdateHelper$downloadCompleted$1 = new UnicronUpdateHelper$downloadCompleted$1(this.$file, this.$glassUpdateInfo, continuation);
        unicronUpdateHelper$downloadCompleted$1.L$0 = obj;
        return unicronUpdateHelper$downloadCompleted$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0124  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 3000(0xbb8, double:1.482E-320)
            r4 = 3
            r5 = 2
            r6 = 0
            r7 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 == r7) goto L_0x002a
            if (r1 == r5) goto L_0x0025
            if (r1 != r4) goto L_0x001d
            java.lang.Object r0 = r10.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00dd
        L_0x001d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00ae
        L_0x002a:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x006c
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            r1 = r11
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper r11 = com.upuphone.xr.sapp.unicron.UnicronUpdateHelper.b
            java.lang.String r8 = "downloadCompleted, verifying"
            r11.L(r8)
            java.io.File r8 = r10.$file
            boolean r8 = r8.exists()
            if (r8 != 0) goto L_0x0056
            java.lang.String r0 = "downloadCompleted, file not exist"
            r11.M(r0)
            com.upuphone.star.fota.phone.GlassUpdateInfo r10 = r10.$glassUpdateInfo
            r11.V(r10, r2)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0056:
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$downloadCompleted$1$md5$1 r8 = new com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$downloadCompleted$1$md5$1
            java.io.File r9 = r10.$file
            r8.<init>(r9, r6)
            r10.L$0 = r1
            r10.label = r7
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.g(r11, r8, r10)
            if (r11 != r0) goto L_0x006c
            return r0
        L_0x006c:
            java.lang.String r11 = (java.lang.String) r11
            com.upuphone.star.fota.phone.GlassUpdateInfo r8 = r10.$glassUpdateInfo
            java.lang.String r8 = r8.getDigest()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r11)
            if (r9 != 0) goto L_0x00b8
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper r1 = com.upuphone.xr.sapp.unicron.UnicronUpdateHelper.b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = "downloadCompleted, verify fail: "
            r4.append(r7)
            r4.append(r8)
            java.lang.String r7 = " <=> "
            r4.append(r7)
            r4.append(r11)
            java.lang.String r11 = r4.toString()
            r1.L(r11)
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$downloadCompleted$1$1 r1 = new com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$downloadCompleted$1$1
            java.io.File r4 = r10.$file
            r1.<init>(r4, r6)
            r10.L$0 = r6
            r10.label = r5
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.g(r11, r1, r10)
            if (r11 != r0) goto L_0x00ae
            return r0
        L_0x00ae:
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper r11 = com.upuphone.xr.sapp.unicron.UnicronUpdateHelper.b
            com.upuphone.star.fota.phone.GlassUpdateInfo r10 = r10.$glassUpdateInfo
            r11.V(r10, r2)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00b8:
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper r11 = com.upuphone.xr.sapp.unicron.UnicronUpdateHelper.b
            java.lang.String r2 = "downloadCompleted, verify success"
            r11.L(r2)
            java.io.File r2 = r10.$file
            java.io.File r2 = r2.getParentFile()
            if (r2 == 0) goto L_0x00d0
            java.lang.String r2 = r2.getAbsolutePath()
            if (r2 == 0) goto L_0x00d0
            r11.v(r2)
        L_0x00d0:
            java.io.File r2 = r10.$file
            r10.L$0 = r1
            r10.label = r4
            java.lang.Object r11 = r11.R(r2, r10)
            if (r11 != r0) goto L_0x00dd
            return r0
        L_0x00dd:
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r11 = r11.iterator()
        L_0x00e8:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x0100
            java.lang.Object r1 = r11.next()
            r2 = r1
            java.io.File r2 = (java.io.File) r2
            boolean r2 = r2.isDirectory()
            r2 = r2 ^ r7
            if (r2 == 0) goto L_0x00e8
            r0.add(r1)
            goto L_0x00e8
        L_0x0100:
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper r11 = com.upuphone.xr.sapp.unicron.UnicronUpdateHelper.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "downloadCompleted, processUpdateFile fileList: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r11.L(r1)
            int r1 = r0.size()
            if (r1 == r7) goto L_0x0124
            java.lang.String r10 = "downloadCompleted, processUpdateFile wrong fileList"
            r11.M(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0124:
            com.upuphone.xr.sapp.entity.UnicronInfo r1 = com.upuphone.xr.sapp.unicron.UnicronUpdateHelper.o
            if (r1 != 0) goto L_0x0132
            java.lang.String r10 = "downloadCompleted, currentUnicronInfo is null"
            r11.M(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0132:
            com.upuphone.star.fota.phone.GlassUpdateInfo r2 = r10.$glassUpdateInfo
            r11.a0(r2)
            com.upuphone.xr.sapp.unicron.UnicronUpdateAdapter r11 = com.upuphone.xr.sapp.unicron.UnicronUpdateAdapter.f7835a
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r0)
            java.io.File r0 = (java.io.File) r0
            com.upuphone.star.fota.phone.GlassUpdateInfo r10 = r10.$glassUpdateInfo
            r11.a(r0, r10, r1)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$downloadCompleted$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UnicronUpdateHelper$downloadCompleted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

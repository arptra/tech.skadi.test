package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordMainViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordMainViewModel$checkAndMergeFastRecordVideoFile$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,565:1\n1855#2:566\n1856#2:568\n1#3:567\n*S KotlinDebug\n*F\n+ 1 FastRecordMainViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordMainViewModel$checkAndMergeFastRecordVideoFile$1\n*L\n118#1:566\n118#1:568\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$checkAndMergeFastRecordVideoFile$1", f = "FastRecordMainViewModel.kt", i = {0}, l = {120, 123, 124}, m = "invokeSuspend", n = {"recordIdListNew"}, s = {"L$0"})
public final class FastRecordMainViewModel$checkAndMergeFastRecordVideoFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callBack;
    final /* synthetic */ ArrayList<RecordEntity> $list;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FastRecordMainViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainViewModel$checkAndMergeFastRecordVideoFile$1(ArrayList<RecordEntity> arrayList, FastRecordMainViewModel fastRecordMainViewModel, Function0<Unit> function0, Continuation<? super FastRecordMainViewModel$checkAndMergeFastRecordVideoFile$1> continuation) {
        super(2, continuation);
        this.$list = arrayList;
        this.this$0 = fastRecordMainViewModel;
        this.$callBack = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordMainViewModel$checkAndMergeFastRecordVideoFile$1(this.$list, this.this$0, this.$callBack, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009d A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r16) {
        /*
            r15 = this;
            r7 = r15
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r7.label
            r9 = 3
            r10 = 2
            r11 = 1
            r12 = 0
            if (r0 == 0) goto L_0x0035
            if (r0 == r11) goto L_0x0025
            if (r0 == r10) goto L_0x0020
            if (r0 != r9) goto L_0x0018
            kotlin.ResultKt.throwOnFailure(r16)
            goto L_0x009e
        L_0x0018:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r16)
            goto L_0x008a
        L_0x0025:
            java.lang.Object r0 = r7.L$1
            java.util.Iterator r0 = (java.util.Iterator) r0
            java.lang.Object r1 = r7.L$0
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            kotlin.ResultKt.throwOnFailure(r16)
            r13 = r0
            r14 = r1
            r0 = r16
            goto L_0x0073
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r16)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList<com.upuphone.ar.fastrecord.phone.db.RecordEntity> r1 = r7.$list
            java.util.Iterator r1 = r1.iterator()
            r14 = r0
            r13 = r1
        L_0x0045:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x007b
            java.lang.Object r0 = r13.next()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r0 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r0
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r1 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r1 = r1.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r1 = r1.fastRecordDao()
            long r2 = r0.getRecordId()
            r7.L$0 = r14
            r7.L$1 = r13
            r7.label = r11
            r4 = 0
            r5 = 2
            r6 = 0
            r0 = r1
            r1 = r2
            r3 = r4
            r4 = r15
            java.lang.Object r0 = com.upuphone.ar.fastrecord.phone.db.FastRecordDao.DefaultImpls.findRecordEntityById$default(r0, r1, r3, r4, r5, r6)
            if (r0 != r8) goto L_0x0073
            return r8
        L_0x0073:
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r0 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r0
            if (r0 == 0) goto L_0x0045
            r14.add(r0)
            goto L_0x0045
        L_0x007b:
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel r0 = r7.this$0
            r7.L$0 = r12
            r7.L$1 = r12
            r7.label = r10
            java.lang.Object r0 = r0.checkFastRecordVideoState(r14, r15)
            if (r0 != r8) goto L_0x008a
            return r8
        L_0x008a:
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$checkAndMergeFastRecordVideoFile$1$2 r1 = new com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$checkAndMergeFastRecordVideoFile$1$2
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r7.$callBack
            r1.<init>(r2, r12)
            r7.label = r9
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.g(r0, r1, r15)
            if (r0 != r8) goto L_0x009e
            return r8
        L_0x009e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$checkAndMergeFastRecordVideoFile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordMainViewModel$checkAndMergeFastRecordVideoFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

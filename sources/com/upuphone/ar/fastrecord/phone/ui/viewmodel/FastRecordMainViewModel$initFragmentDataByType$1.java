package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

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

@SourceDebugExtension({"SMAP\nFastRecordMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordMainViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordMainViewModel$initFragmentDataByType$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,565:1\n1855#2,2:566\n1855#2,2:568\n1#3:570\n*S KotlinDebug\n*F\n+ 1 FastRecordMainViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordMainViewModel$initFragmentDataByType$1\n*L\n391#1:566,2\n396#1:568,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$initFragmentDataByType$1", f = "FastRecordMainViewModel.kt", i = {1}, l = {389, 411}, m = "invokeSuspend", n = {"allRecordList"}, s = {"L$1"})
public final class FastRecordMainViewModel$initFragmentDataByType$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $type;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FastRecordMainViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainViewModel$initFragmentDataByType$1(int i, FastRecordMainViewModel fastRecordMainViewModel, Continuation<? super FastRecordMainViewModel$initFragmentDataByType$1> continuation) {
        super(2, continuation);
        this.$type = i;
        this.this$0 = fastRecordMainViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordMainViewModel$initFragmentDataByType$1(this.$type, this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e4  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            java.lang.String r2 = "FastRecordMainViewModel"
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x002b
            if (r1 == r4) goto L_0x0027
            if (r1 != r3) goto L_0x001f
            int r0 = r12.I$0
            java.lang.Object r1 = r12.L$1
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.lang.Object r12 = r12.L$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel r12 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00d7
        L_0x001f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x004c
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.String r13 = "initFragmentDataByType start "
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logI(r13, r2)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r13 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r13 = r13.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r5 = r13.fastRecordDao()
            int r6 = r12.$type
            r12.label = r4
            r7 = 0
            r9 = 2
            r10 = 0
            r8 = r12
            java.lang.Object r13 = com.upuphone.ar.fastrecord.phone.db.FastRecordDao.DefaultImpls.getRecordEntityForTypeCreate$default(r5, r6, r7, r8, r9, r10)
            if (r13 != r0) goto L_0x004c
            return r0
        L_0x004c:
            java.util.List r13 = (java.util.List) r13
            if (r13 == 0) goto L_0x00eb
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel r1 = r12.this$0
            int r5 = r12.$type
            java.util.Iterator r6 = r13.iterator()
        L_0x0058:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x007e
            java.lang.Object r7 = r6.next()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r7 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r7
            java.lang.String r7 = r7.getShortHandTitle()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "title = "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logI(r7, r2)
            goto L_0x0058
        L_0x007e:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r6 = r13.iterator()
        L_0x0087:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00b6
            java.lang.Object r7 = r6.next()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r7 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r7
            boolean r8 = r7.isDownloading()
            if (r8 == 0) goto L_0x009d
            r2.add(r7)
            goto L_0x0087
        L_0x009d:
            long r8 = r7.getTotalTime()
            r10 = 1000(0x3e8, double:4.94E-321)
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 >= 0) goto L_0x00aa
            r7.setTotalTime(r10)
        L_0x00aa:
            long r8 = r7.getRecordId()
            java.util.ArrayList r8 = r1.getTagInfo(r8)
            r7.setTagBeanList(r8)
            goto L_0x0087
        L_0x00b6:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r6.addAll(r13)
            java.util.Set r13 = kotlin.collections.CollectionsKt.toSet(r2)
            r6.removeAll(r13)
            r12.L$0 = r1
            r12.L$1 = r6
            r12.I$0 = r5
            r12.label = r3
            java.lang.Object r12 = r1.resetRecordStatus(r6, r12)
            if (r12 != r0) goto L_0x00d4
            return r0
        L_0x00d4:
            r12 = r1
            r0 = r5
            r1 = r6
        L_0x00d7:
            if (r0 == 0) goto L_0x00e4
            if (r0 == r4) goto L_0x00dc
            goto L_0x00eb
        L_0x00dc:
            androidx.lifecycle.MutableLiveData r12 = r12._mSceneFastRecordLiveData
            r12.postValue(r1)
            goto L_0x00eb
        L_0x00e4:
            androidx.lifecycle.MutableLiveData r12 = r12._mPhoneFastRecordLiveData
            r12.postValue(r1)
        L_0x00eb:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$initFragmentDataByType$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordMainViewModel$initFragmentDataByType$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

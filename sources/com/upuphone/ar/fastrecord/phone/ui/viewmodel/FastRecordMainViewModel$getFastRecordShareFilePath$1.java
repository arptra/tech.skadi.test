package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import android.content.Context;
import android.net.Uri;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordMainViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordMainViewModel$getFastRecordShareFilePath$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,565:1\n1855#2:566\n1856#2:568\n1#3:567\n*S KotlinDebug\n*F\n+ 1 FastRecordMainViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordMainViewModel$getFastRecordShareFilePath$1\n*L\n142#1:566\n142#1:568\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$getFastRecordShareFilePath$1", f = "FastRecordMainViewModel.kt", i = {0}, l = {144}, m = "invokeSuspend", n = {"recordIdListNew"}, s = {"L$0"})
public final class FastRecordMainViewModel$getFastRecordShareFilePath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ArrayList<Uri>, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ ArrayList<RecordEntity> $list;
    final /* synthetic */ String $type;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainViewModel$getFastRecordShareFilePath$1(ArrayList<RecordEntity> arrayList, String str, Context context, Function1<? super ArrayList<Uri>, Unit> function1, Continuation<? super FastRecordMainViewModel$getFastRecordShareFilePath$1> continuation) {
        super(2, continuation);
        this.$list = arrayList;
        this.$type = str;
        this.$context = context;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordMainViewModel$getFastRecordShareFilePath$1(this.$list, this.$type, this.$context, this.$callback, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0034  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            java.lang.Object r1 = r12.L$1
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r3 = r12.L$0
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0059
        L_0x0017:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r13)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.ArrayList<com.upuphone.ar.fastrecord.phone.db.RecordEntity> r1 = r12.$list
            java.util.Iterator r1 = r1.iterator()
            r3 = r13
        L_0x002e:
            boolean r13 = r1.hasNext()
            if (r13 == 0) goto L_0x0061
            java.lang.Object r13 = r1.next()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r13 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r13
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r4 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r4 = r4.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r5 = r4.fastRecordDao()
            long r6 = r13.getRecordId()
            r12.L$0 = r3
            r12.L$1 = r1
            r12.label = r2
            r8 = 0
            r10 = 2
            r11 = 0
            r9 = r12
            java.lang.Object r13 = com.upuphone.ar.fastrecord.phone.db.FastRecordDao.DefaultImpls.findRecordEntityById$default(r5, r6, r8, r9, r10, r11)
            if (r13 != r0) goto L_0x0059
            return r0
        L_0x0059:
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r13 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r13
            if (r13 == 0) goto L_0x002e
            r3.add(r13)
            goto L_0x002e
        L_0x0061:
            java.lang.String r13 = r12.$type
            int r0 = r13.hashCode()
            r1 = -1970031442(0xffffffff8a93b4ae, float:-1.4223549E-32)
            if (r0 == r1) goto L_0x009d
            r1 = -1787870358(0xffffffff956f436a, float:-4.8318846E-26)
            if (r0 == r1) goto L_0x008a
            r1 = 409478171(0x1868241b, float:3.0003526E-24)
            if (r0 == r1) goto L_0x0077
            goto L_0x00ae
        L_0x0077:
            java.lang.String r0 = "share_video"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x0080
            goto L_0x00ae
        L_0x0080:
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils r13 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils.INSTANCE
            android.content.Context r0 = r12.$context
            kotlin.jvm.functions.Function1<java.util.ArrayList<android.net.Uri>, kotlin.Unit> r12 = r12.$callback
            r13.getVideoUirForSelectRecord(r0, r3, r12)
            goto L_0x00ae
        L_0x008a:
            java.lang.String r0 = "share_word"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x0093
            goto L_0x00ae
        L_0x0093:
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils r13 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils.INSTANCE
            android.content.Context r0 = r12.$context
            kotlin.jvm.functions.Function1<java.util.ArrayList<android.net.Uri>, kotlin.Unit> r12 = r12.$callback
            r13.getRecordListWordUirList(r0, r3, r12)
            goto L_0x00ae
        L_0x009d:
            java.lang.String r0 = "share_video_word"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x00ae
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils r13 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils.INSTANCE
            android.content.Context r0 = r12.$context
            kotlin.jvm.functions.Function1<java.util.ArrayList<android.net.Uri>, kotlin.Unit> r12 = r12.$callback
            r13.getWordAndVideoUirForSelectRecord(r0, r3, r12)
        L_0x00ae:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$getFastRecordShareFilePath$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordMainViewModel$getFastRecordShareFilePath$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordMainViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordMainViewModel$delRecord$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,565:1\n1855#2,2:566\n*S KotlinDebug\n*F\n+ 1 FastRecordMainViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordMainViewModel$delRecord$1\n*L\n485#1:566,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$delRecord$1", f = "FastRecordMainViewModel.kt", i = {0}, l = {483}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
public final class FastRecordMainViewModel$delRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callBack;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FastRecordMainViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainViewModel$delRecord$1(FastRecordMainViewModel fastRecordMainViewModel, Function0<Unit> function0, Continuation<? super FastRecordMainViewModel$delRecord$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordMainViewModel;
        this.$callBack = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordMainViewModel$delRecord$1(this.this$0, this.$callBack, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FastRecordMainViewModel fastRecordMainViewModel;
        ArrayList<RecordEntity> arrayList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList2 = (ArrayList) this.this$0._mChooseRecordEntityList.getValue();
            if (arrayList2 != null) {
                fastRecordMainViewModel = this.this$0;
                int size = arrayList2.size();
                LogExt.logI("getShortHandByCreateTime start  deleteList size = " + size, "FastRecordMainViewModel");
                FastRecordDao fastRecordDao = FastRecordManager.Companion.getInstance().fastRecordDao();
                this.L$0 = fastRecordMainViewModel;
                this.L$1 = arrayList2;
                this.label = 1;
                if (fastRecordDao.deleteList(arrayList2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                arrayList = arrayList2;
            }
            this.this$0.setClearSelectStatus();
            this.$callBack.invoke();
            return Unit.INSTANCE;
        } else if (i == 1) {
            arrayList = (ArrayList) this.L$1;
            fastRecordMainViewModel = (FastRecordMainViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Intrinsics.checkNotNull(arrayList);
        for (RecordEntity recordEntity : arrayList) {
            FastRecordManager.Companion.getInstance().fastRecordVoice().deleteByRecordId(recordEntity.getRecordId());
            fastRecordMainViewModel.deleteFileData(recordEntity);
        }
        this.this$0.setClearSelectStatus();
        this.$callBack.invoke();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordMainViewModel$delRecord$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

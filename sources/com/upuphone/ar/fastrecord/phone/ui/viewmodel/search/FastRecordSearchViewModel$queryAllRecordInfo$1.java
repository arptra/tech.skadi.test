package com.upuphone.ar.fastrecord.phone.ui.viewmodel.search;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordSearchViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordSearchViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/search/FastRecordSearchViewModel$queryAllRecordInfo$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,255:1\n1855#2,2:256\n1#3:258\n*S KotlinDebug\n*F\n+ 1 FastRecordSearchViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/search/FastRecordSearchViewModel$queryAllRecordInfo$1\n*L\n37#1:256,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.search.FastRecordSearchViewModel$queryAllRecordInfo$1", f = "FastRecordSearchViewModel.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordSearchViewModel$queryAllRecordInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    int label;
    final /* synthetic */ FastRecordSearchViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordSearchViewModel$queryAllRecordInfo$1(FastRecordSearchViewModel fastRecordSearchViewModel, Function0<Unit> function0, Continuation<? super FastRecordSearchViewModel$queryAllRecordInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordSearchViewModel;
        this.$callback = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordSearchViewModel$queryAllRecordInfo$1(this.this$0, this.$callback, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.allRecordList.clear();
            FastRecordDao fastRecordDao = FastRecordManager.Companion.getInstance().fastRecordDao();
            this.label = 1;
            obj = FastRecordDao.DefaultImpls.getRecordEntityFinisRecordByCreateTime$default(fastRecordDao, (String) null, this, 1, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List<RecordEntity> list = (List) obj;
        LogExt.logE("getRecordData info from db", "FastRecordSearchViewModel");
        if (list != null) {
            FastRecordSearchViewModel fastRecordSearchViewModel = this.this$0;
            for (RecordEntity recordEntity : list) {
                LogExt.logE("record data = " + recordEntity, "FastRecordSearchViewModel");
                recordEntity.setTagBeanList(fastRecordSearchViewModel.getTagInfo(recordEntity.getRecordId()));
                recordEntity.setPersonBeanList(fastRecordSearchViewModel.getPersonInfo(recordEntity.getRecordId()));
            }
        }
        if (list != null) {
            Boxing.boxBoolean(this.this$0.allRecordList.addAll(list));
        }
        Function0<Unit> function0 = this.$callback;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordSearchViewModel$queryAllRecordInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

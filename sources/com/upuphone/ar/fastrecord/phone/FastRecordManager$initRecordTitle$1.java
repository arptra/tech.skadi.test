package com.upuphone.ar.fastrecord.phone;

import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.FastRecordManager$initRecordTitle$1", f = "FastRecordManager.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordManager$initRecordTitle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FastRecordManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordManager$initRecordTitle$1(FastRecordManager fastRecordManager, Continuation<? super FastRecordManager$initRecordTitle$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordManager;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordManager$initRecordTitle$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LogExt.logI("initRecordTitle start ", "FastRecordManager");
            FastRecordDao fastRecordDao = this.this$0.fastRecordDao();
            this.label = 1;
            obj = FastRecordDao.DefaultImpls.getRecordEntityByCreateTime$default(fastRecordDao, (String) null, this, 1, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list = (List) obj;
        if (list != null) {
            int size = list.size();
            LogExt.logI("initRecordTitle start recordData size = " + size + ",data = " + list, "FastRecordManager");
            new ArrayList().addAll(CollectionsKt.toSet(list));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordManager$initRecordTitle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

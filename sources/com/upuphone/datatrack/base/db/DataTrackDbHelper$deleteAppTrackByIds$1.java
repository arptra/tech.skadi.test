package com.upuphone.datatrack.base.db;

import com.upuphone.datatrack.base.utils.LogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.upuphone.datatrack.base.db.DataTrackDbHelper$deleteAppTrackByIds$1", f = "DataTrackDbHelper.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
public final class DataTrackDbHelper$deleteAppTrackByIds$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Long> $idList;
    int label;
    final /* synthetic */ DataTrackDbHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataTrackDbHelper$deleteAppTrackByIds$1(List<Long> list, DataTrackDbHelper dataTrackDbHelper, Continuation<? super DataTrackDbHelper$deleteAppTrackByIds$1> continuation) {
        super(2, continuation);
        this.$idList = list;
        this.this$0 = dataTrackDbHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DataTrackDbHelper$deleteAppTrackByIds$1(this.$idList, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LogUtil.e("DataTrackDbHelper", "deleteAppTrackByIds, idList: " + this.$idList);
            AppTrackDao a2 = this.this$0.f();
            List<Long> list = this.$idList;
            this.label = 1;
            if (a2.f(list, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DataTrackDbHelper$deleteAppTrackByIds$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.upuphone.datatrack.base.db;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.upuphone.datatrack.base.db.DataTrackDbHelper$getAppTrackMaxId$1", f = "DataTrackDbHelper.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
final class DataTrackDbHelper$getAppTrackMaxId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    int label;
    final /* synthetic */ DataTrackDbHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataTrackDbHelper$getAppTrackMaxId$1(DataTrackDbHelper dataTrackDbHelper, Continuation<? super DataTrackDbHelper$getAppTrackMaxId$1> continuation) {
        super(2, continuation);
        this.this$0 = dataTrackDbHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DataTrackDbHelper$getAppTrackMaxId$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AppTrackDao a2 = this.this$0.f();
            this.label = 1;
            obj = a2.d(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AppTrack appTrack = (AppTrack) obj;
        return Boxing.boxLong(appTrack != null ? appTrack.getId() : 0);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Long> continuation) {
        return ((DataTrackDbHelper$getAppTrackMaxId$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

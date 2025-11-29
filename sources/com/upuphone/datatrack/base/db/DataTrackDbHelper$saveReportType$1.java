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
@DebugMetadata(c = "com.upuphone.datatrack.base.db.DataTrackDbHelper$saveReportType$1", f = "DataTrackDbHelper.kt", i = {}, l = {33, 35}, m = "invokeSuspend", n = {}, s = {})
public final class DataTrackDbHelper$saveReportType$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ReportType> $reportTypes;
    int label;
    final /* synthetic */ DataTrackDbHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataTrackDbHelper$saveReportType$1(List<ReportType> list, DataTrackDbHelper dataTrackDbHelper, Continuation<? super DataTrackDbHelper$saveReportType$1> continuation) {
        super(2, continuation);
        this.$reportTypes = list;
        this.this$0 = dataTrackDbHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DataTrackDbHelper$saveReportType$1(this.$reportTypes, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LogUtil.a("DataTrackDbHelper", "saveReportType, reportTypes: " + this.$reportTypes);
            ReportTypeDao c = this.this$0.h();
            this.label = 1;
            if (c.a(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List<ReportType> list = this.$reportTypes;
        if (list != null && !list.isEmpty()) {
            ReportTypeDao c2 = this.this$0.h();
            List<ReportType> list2 = this.$reportTypes;
            this.label = 2;
            if (c2.b(list2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DataTrackDbHelper$saveReportType$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

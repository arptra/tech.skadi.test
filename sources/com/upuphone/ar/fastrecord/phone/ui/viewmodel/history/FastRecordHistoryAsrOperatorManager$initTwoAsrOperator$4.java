package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J!\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¨\u0006\b"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordHistoryAsrOperatorManager$initTwoAsrOperator$4", "Lkotlin/Function3;", "", "", "invoke", "recordId", "totalTime", "curTime", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryAsrOperatorManager$initTwoAsrOperator$4 implements Function3<Long, Long, Long, Unit> {
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Number) obj).longValue(), ((Number) obj2).longValue(), ((Number) obj3).longValue());
        return Unit.INSTANCE;
    }

    public void invoke(long j, long j2, long j3) {
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        FastRecordHistoryAsrOperatorManager.INSTANCE.setEventProgress(j4, j5, j6);
        LogExt.logW("initTwoAsrOperator setEmptyCallBack record id = " + j + ",totalTime = " + j2 + ",curTime =" + j3, "FastRecordHistoryAsrOperatorManager");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordHistoryAsrOperatorManager$initTwoAsrOperator$4$invoke$1(j4, j5, j6, (Continuation<? super FastRecordHistoryAsrOperatorManager$initTwoAsrOperator$4$invoke$1>) null), 3, (Object) null);
    }
}

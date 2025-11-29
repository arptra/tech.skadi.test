package com.upuphone.ar.translation.phone.vm;

import androidx.lifecycle.ViewModelKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "eventId", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class IntelExtnTodoViewModel$registerCalendarContentObserver$2$1 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ IntelExtnTodoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnTodoViewModel$registerCalendarContentObserver$2$1(IntelExtnTodoViewModel intelExtnTodoViewModel) {
        super(1);
        this.this$0 = intelExtnTodoViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) {
        List<IntelExtnTodo> list = (List) this.this$0.d.getValue();
        if (list != null) {
            IntelExtnTodoViewModel intelExtnTodoViewModel = this.this$0;
            int i = 0;
            for (IntelExtnTodo calendarEventId : list) {
                int i2 = i + 1;
                if (j == calendarEventId.getCalendarEventId()) {
                    LogExt.j("CalendarContentObserver index=" + i + ", eventId=" + j, "IntelExtnTodoViewModel");
                    Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(intelExtnTodoViewModel), Dispatchers.c(), (CoroutineStart) null, new IntelExtnTodoViewModel$registerCalendarContentObserver$2$1$1$1(intelExtnTodoViewModel, (Continuation<? super IntelExtnTodoViewModel$registerCalendarContentObserver$2$1$1$1>) null), 2, (Object) null);
                    return;
                }
                i = i2;
            }
        }
    }
}

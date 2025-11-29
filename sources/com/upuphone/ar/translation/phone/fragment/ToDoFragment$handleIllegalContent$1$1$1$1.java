package com.upuphone.ar.translation.phone.fragment;

import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.adapter.IntelExtnTodoAdapter;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse;
import com.upuphone.xr.audio.record.ai.feedback.ReportCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/ar/translation/phone/fragment/ToDoFragment$handleIllegalContent$1$1$1$1", "Lcom/upuphone/xr/audio/record/ai/feedback/ReportCallback;", "onFail", "", "result", "Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackResponse;", "onSuccess", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ToDoFragment$handleIllegalContent$1$1$1$1 implements ReportCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ToDoFragment f6288a;
    public final /* synthetic */ NoteBean b;
    public final /* synthetic */ IntelExtnTodoAdapter c;

    public ToDoFragment$handleIllegalContent$1$1$1$1(ToDoFragment toDoFragment, NoteBean noteBean, IntelExtnTodoAdapter intelExtnTodoAdapter) {
        this.f6288a = toDoFragment;
        this.b = noteBean;
        this.c = intelExtnTodoAdapter;
    }

    public void onFail(AiFeedBackResponse aiFeedBackResponse) {
        Intrinsics.checkNotNullParameter(aiFeedBackResponse, "result");
        LogExt.j("handleIllegalContent 待办事项举报失败", "ToDoFragment");
    }

    public void onSuccess(AiFeedBackResponse aiFeedBackResponse) {
        Intrinsics.checkNotNullParameter(aiFeedBackResponse, "result");
        LogExt.j("handleIllegalContent 待办事项举报成功", "ToDoFragment");
        this.f6288a.D0().Y(this.b, true);
        int i = 0;
        for (IntelExtnTodo intelExtnTodo : this.c.getData()) {
            List data = this.c.getData();
            intelExtnTodo.setReported(true);
            Unit unit = Unit.INSTANCE;
            data.set(i, intelExtnTodo);
            i++;
        }
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this.f6288a), Dispatchers.c(), (CoroutineStart) null, new ToDoFragment$handleIllegalContent$1$1$1$1$onSuccess$2(this.f6288a, (Continuation<? super ToDoFragment$handleIllegalContent$1$1$1$1$onSuccess$2>) null), 2, (Object) null);
    }
}

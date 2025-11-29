package com.upuphone.ar.transcribe.phone.vm;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 12\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\nJ\u001b\u0010\u0014\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060*8\u0006¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010-R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060*8\u0006¢\u0006\f\n\u0004\b'\u0010+\u001a\u0004\b/\u0010-¨\u00063"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/AiShareViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "", "recordId", "", "l", "(Ljava/lang/String;)V", "", "isFinish", "m", "(Z)V", "summary", "n", "", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;", "todoList", "p", "(Ljava/util/List;)V", "b", "Landroid/app/Application;", "g", "()Landroid/app/Application;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "c", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_pageFinish", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "_shareSummary", "e", "_shareTodos", "Lkotlinx/coroutines/flow/Flow;", "f", "Lkotlinx/coroutines/flow/Flow;", "h", "()Lkotlinx/coroutines/flow/Flow;", "pageFinish", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LiveData;", "j", "()Landroidx/lifecycle/LiveData;", "shareSummary", "k", "shareTodos", "i", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AiShareViewModel extends AndroidViewModel {
    public static final Companion i = new Companion((DefaultConstructorMarker) null);
    public final Application b;
    public MutableSharedFlow c = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
    public MutableLiveData d = new MutableLiveData();
    public MutableLiveData e = new MutableLiveData();
    public final Flow f;
    public final LiveData g;
    public final LiveData h;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/AiShareViewModel$Companion;", "", "()V", "TAG", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiShareViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, DDAuthConstant.AUTH_LOGIN_TYPE_APP);
        this.b = application;
        MutableSharedFlow mutableSharedFlow = this.c;
        Intrinsics.checkNotNull(mutableSharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<kotlin.Boolean>");
        this.f = mutableSharedFlow;
        MutableLiveData mutableLiveData = this.d;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.String>");
        this.g = mutableLiveData;
        MutableLiveData mutableLiveData2 = this.e;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.String>");
        this.h = mutableLiveData2;
    }

    public final Application g() {
        return this.b;
    }

    public final Flow h() {
        return this.f;
    }

    public final LiveData j() {
        return this.g;
    }

    public final LiveData k() {
        return this.h;
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "recordId");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.b(), (CoroutineStart) null, new AiShareViewModel$load$1(this, str, (Continuation<? super AiShareViewModel$load$1>) null), 2, (Object) null);
    }

    public final void m(boolean z) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new AiShareViewModel$notifyIntelExtnPageFinish$1(this, z, (Continuation<? super AiShareViewModel$notifyIntelExtnPageFinish$1>) null), 2, (Object) null);
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "summary");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new AiShareViewModel$notifyShareSummary$1(this, str, (Continuation<? super AiShareViewModel$notifyShareSummary$1>) null), 2, (Object) null);
    }

    public final void p(List list) {
        Intrinsics.checkNotNullParameter(list, "todoList");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new AiShareViewModel$notifyShareTodos$1(list, this, (Continuation<? super AiShareViewModel$notifyShareTodos$1>) null), 2, (Object) null);
    }
}

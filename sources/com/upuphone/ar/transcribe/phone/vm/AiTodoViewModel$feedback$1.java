package com.upuphone.ar.transcribe.phone.vm;

import android.app.Activity;
import androidx.lifecycle.ViewModelKt;
import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
import com.upuphone.ar.transcribe.phone.repo.TranscribeAiRepo;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.audio.record.ai.bean.AiFeedBackRequest;
import com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse;
import com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager;
import com.upuphone.xr.audio.record.ai.feedback.ReportCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel$feedback$1", f = "AiTodoViewModel.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
public final class AiTodoViewModel$feedback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $recordId;
    int label;
    final /* synthetic */ AiTodoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiTodoViewModel$feedback$1(AiTodoViewModel aiTodoViewModel, String str, Activity activity, Continuation<? super AiTodoViewModel$feedback$1> continuation) {
        super(2, continuation);
        this.this$0 = aiTodoViewModel;
        this.$recordId = str;
        this.$activity = activity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AiTodoViewModel$feedback$1(this.this$0, this.$recordId, this.$activity, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TranscribeAiRepo g = this.this$0.d;
            String str = this.$recordId;
            this.label = 1;
            obj = g.s(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list = (List) obj;
        if (list.isEmpty()) {
            ULog.f6446a.c("AiTodoViewModel", "no todo to feedback");
            return Unit.INSTANCE;
        }
        AiFeedBackManager aiFeedBackManager = AiFeedBackManager.f6560a;
        Activity activity = this.$activity;
        String str2 = this.$recordId;
        String k = this.this$0.x(list);
        String requestId = ((AiTodoEntity) list.get(0)).getRequestId();
        if (requestId == null) {
            requestId = "";
        }
        AiFeedBackRequest aiFeedBackRequest = new AiFeedBackRequest(2, str2, k, requestId);
        final AiTodoViewModel aiTodoViewModel = this.this$0;
        final String str3 = this.$recordId;
        aiFeedBackManager.k(activity, aiFeedBackRequest, new ReportCallback() {
            public void onFail(AiFeedBackResponse aiFeedBackResponse) {
                Intrinsics.checkNotNullParameter(aiFeedBackResponse, "result");
                ULog.Delegate delegate = ULog.f6446a;
                delegate.c("AiTodoViewModel", "onFail result = " + aiFeedBackResponse);
                Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(aiTodoViewModel), (CoroutineContext) null, (CoroutineStart) null, new AiTodoViewModel$feedback$1$1$onFail$1(aiTodoViewModel, (Continuation<? super AiTodoViewModel$feedback$1$1$onFail$1>) null), 3, (Object) null);
            }

            public void onSuccess(AiFeedBackResponse aiFeedBackResponse) {
                Intrinsics.checkNotNullParameter(aiFeedBackResponse, "result");
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("AiTodoViewModel", "onSuccess result = " + aiFeedBackResponse);
                Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(aiTodoViewModel), (CoroutineContext) null, (CoroutineStart) null, new AiTodoViewModel$feedback$1$1$onSuccess$1(aiTodoViewModel, str3, (Continuation<? super AiTodoViewModel$feedback$1$1$onSuccess$1>) null), 3, (Object) null);
            }
        });
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AiTodoViewModel$feedback$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.helper.TranslatorDbHelper;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$getTodosByDb$1$todoList$1", f = "IntelExtnTodoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class IntelExtnTodoViewModel$getTodosByDb$1$todoList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends IntelExtnTodo>>, Object> {
    final /* synthetic */ boolean $isClearDeleteStatus;
    final /* synthetic */ NoteBean $noteBean;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnTodoViewModel$getTodosByDb$1$todoList$1(boolean z, NoteBean noteBean, Continuation<? super IntelExtnTodoViewModel$getTodosByDb$1$todoList$1> continuation) {
        super(2, continuation);
        this.$isClearDeleteStatus = z;
        this.$noteBean = noteBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IntelExtnTodoViewModel$getTodosByDb$1$todoList$1(this.$isClearDeleteStatus, this.$noteBean, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$isClearDeleteStatus) {
                TranslatorDbHelper translatorDbHelper = TranslatorDbHelper.f6307a;
                translatorDbHelper.b().b(this.$noteBean.getAccountId(), this.$noteBean.getRecognizeId(), 0);
                translatorDbHelper.b().h(this.$noteBean.getAccountId(), this.$noteBean.getRecognizeId(), false);
            }
            return TranslatorDbHelper.f6307a.b().g(this.$noteBean.getAccountId(), this.$noteBean.getRecognizeId(), 0);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<IntelExtnTodo>> continuation) {
        return ((IntelExtnTodoViewModel$getTodosByDb$1$todoList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

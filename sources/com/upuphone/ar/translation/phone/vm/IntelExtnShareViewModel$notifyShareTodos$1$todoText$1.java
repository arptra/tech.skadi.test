package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import com.upuphone.ar.translation.utils.DateUtils;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnShareViewModel$notifyShareTodos$1$todoText$1", f = "IntelExtnShareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class IntelExtnShareViewModel$notifyShareTodos$1$todoText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ List<IntelExtnTodo> $todoList;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnShareViewModel$notifyShareTodos$1$todoText$1(List<IntelExtnTodo> list, Continuation<? super IntelExtnShareViewModel$notifyShareTodos$1$todoText$1> continuation) {
        super(2, continuation);
        this.$todoList = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IntelExtnShareViewModel$notifyShareTodos$1$todoText$1(this.$todoList, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (IntelExtnTodo next : this.$todoList) {
                int i2 = i + 1;
                String startTime = next.getStartTime();
                String endTime = next.getEndTime();
                if (!StringsKt.isBlank(startTime)) {
                    DateUtils.b(startTime);
                    if (!StringsKt.isBlank(endTime)) {
                        DateUtils.b(endTime);
                    } else if (DateUtils.h(startTime)) {
                        DateUtils.a(startTime);
                    }
                } else {
                    DateUtils.f(1);
                }
                sb.append(next.getTitle());
                sb.append(StringUtils.LF);
                sb.append(next.getContent());
                if (i != CollectionsKt.getLastIndex(this.$todoList)) {
                    sb.append("\n\n");
                }
                i = i2;
            }
            return sb.toString();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((IntelExtnShareViewModel$notifyShareTodos$1$todoText$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

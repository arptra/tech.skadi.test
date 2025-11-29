package com.upuphone.ar.transcribe.phone.vm;

import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
import com.upuphone.ar.transcribe.utils.DateUtils;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nAiShareViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiShareViewModel.kt\ncom/upuphone/ar/transcribe/phone/vm/AiShareViewModel$notifyShareTodos$1$todoText$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,105:1\n1864#2,3:106\n*S KotlinDebug\n*F\n+ 1 AiShareViewModel.kt\ncom/upuphone/ar/transcribe/phone/vm/AiShareViewModel$notifyShareTodos$1$todoText$1\n*L\n71#1:106,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.vm.AiShareViewModel$notifyShareTodos$1$todoText$1", f = "AiShareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AiShareViewModel$notifyShareTodos$1$todoText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ List<AiTodoEntity> $todoList;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiShareViewModel$notifyShareTodos$1$todoText$1(List<AiTodoEntity> list, Continuation<? super AiShareViewModel$notifyShareTodos$1$todoText$1> continuation) {
        super(2, continuation);
        this.$todoList = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AiShareViewModel$notifyShareTodos$1$todoText$1(this.$todoList, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            StringBuilder sb = new StringBuilder();
            List<AiTodoEntity> list = this.$todoList;
            int i = 0;
            for (T next : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                AiTodoEntity aiTodoEntity = (AiTodoEntity) next;
                String startTime = aiTodoEntity.getStartTime();
                String endTime = aiTodoEntity.getEndTime();
                if (!StringsKt.isBlank(startTime)) {
                    if (DateUtils.b(startTime) > (StringsKt.isBlank(endTime) ^ true ? DateUtils.b(endTime) : DateUtils.a(startTime))) {
                        DateUtils.a(startTime);
                    }
                } else {
                    DateUtils.f();
                    DateUtils.e();
                }
                sb.append(aiTodoEntity.getTitle());
                sb.append(StringUtils.LF);
                sb.append(aiTodoEntity.getContent());
                if (i != list.size() - 1) {
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
        return ((AiShareViewModel$notifyShareTodos$1$todoText$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

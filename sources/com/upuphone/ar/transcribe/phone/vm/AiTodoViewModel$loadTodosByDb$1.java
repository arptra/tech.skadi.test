package com.upuphone.ar.transcribe.phone.vm;

import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.repo.TranscribeAiRepo;
import com.upuphone.ar.transcribe.phone.vm.TodoData;
import com.upuphone.xr.sapp.context.SdkContext;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nAiTodoViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiTodoViewModel.kt\ncom/upuphone/ar/transcribe/phone/vm/AiTodoViewModel$loadTodosByDb$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,510:1\n1855#2,2:511\n*S KotlinDebug\n*F\n+ 1 AiTodoViewModel.kt\ncom/upuphone/ar/transcribe/phone/vm/AiTodoViewModel$loadTodosByDb$1\n*L\n144#1:511,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel$loadTodosByDb$1", f = "AiTodoViewModel.kt", i = {}, l = {129, 136, 142, 152}, m = "invokeSuspend", n = {}, s = {})
public final class AiTodoViewModel$loadTodosByDb$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TranscribeBean $noteBean;
    Object L$0;
    int label;
    final /* synthetic */ AiTodoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiTodoViewModel$loadTodosByDb$1(AiTodoViewModel aiTodoViewModel, TranscribeBean transcribeBean, Continuation<? super AiTodoViewModel$loadTodosByDb$1> continuation) {
        super(2, continuation);
        this.this$0 = aiTodoViewModel;
        this.$noteBean = transcribeBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AiTodoViewModel$loadTodosByDb$1(this.this$0, this.$noteBean, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TranscribeAiRepo g = this.this$0.d;
            String recognizeId = this.$noteBean.getRecognizeId();
            Intrinsics.checkNotNull(recognizeId);
            this.label = 1;
            obj2 = g.s(recognizeId, this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    List list = (List) this.L$0;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        List<AiTodoEntity> list2 = (List) obj2;
        if (list2.isEmpty()) {
            LogExt.d("no db data", "AiTodoViewModel");
            TranscribeAiRepo g2 = this.this$0.d;
            String recognizeId2 = this.$noteBean.getRecognizeId();
            Intrinsics.checkNotNull(recognizeId2);
            if (g2.u(recognizeId2)) {
                TranscribeAiRepo g3 = this.this$0.d;
                String recognizeId3 = this.$noteBean.getRecognizeId();
                Intrinsics.checkNotNull(recognizeId3);
                g3.z(recognizeId3, this.this$0.f);
                MutableSharedFlow l = this.this$0.e;
                TodoData.Loading loading = TodoData.Loading.f6152a;
                this.label = 2;
                if (l.emit(loading, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (SdkContext.f6675a.f().a(this.this$0.c)) {
            AiTodoViewModel aiTodoViewModel = this.this$0;
            this.label = 3;
            if (aiTodoViewModel.q(list2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            for (AiTodoEntity aiTodoEntity : list2) {
                aiTodoEntity.setAddedSchedule(aiTodoEntity.getCalendarEventId() != 0);
            }
            List mutableList = CollectionsKt.toMutableList(list2);
            AiTodoViewModel aiTodoViewModel2 = this.this$0;
            AiTodoEntity aiTodoEntity2 = r7;
            AiTodoEntity aiTodoEntity3 = new AiTodoEntity(0, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (Integer) null, false, (String) null, (Integer) null, false, 65535, (DefaultConstructorMarker) null);
            aiTodoEntity2.setReported(((AiTodoEntity) CollectionsKt.first(list2)).getReported());
            aiTodoEntity2.setItemType(1);
            mutableList.add(aiTodoEntity2);
            MutableSharedFlow l2 = aiTodoViewModel2.e;
            TodoData.DbData dbData = new TodoData.DbData(mutableList);
            this.L$0 = mutableList;
            this.label = 4;
            if (l2.emit(dbData, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AiTodoViewModel$loadTodosByDb$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

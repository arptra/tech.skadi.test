package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao;
import com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordTodoViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTodoViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel$updateTodoList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,698:1\n1855#2,2:699\n*S KotlinDebug\n*F\n+ 1 FastRecordTodoViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel$updateTodoList$1\n*L\n257#1:699,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$updateTodoList$1", f = "FastRecordTodoViewModel.kt", i = {}, l = {258}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordTodoViewModel$updateTodoList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<RecordTodoItemEntity> $todoList;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTodoViewModel$updateTodoList$1(List<RecordTodoItemEntity> list, Continuation<? super FastRecordTodoViewModel$updateTodoList$1> continuation) {
        super(2, continuation);
        this.$todoList = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordTodoViewModel$updateTodoList$1(this.$todoList, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Iterator<T> it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            it = this.$todoList.iterator();
        } else if (i == 1) {
            it = (Iterator) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            FastRecordTodoItemDao fastRecordTodoItemDao = FastRecordManager.Companion.getInstance().fastRecordTodoItemDao();
            this.L$0 = it;
            this.label = 1;
            if (fastRecordTodoItemDao.update((RecordTodoItemEntity) it.next(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordTodoViewModel$updateTodoList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

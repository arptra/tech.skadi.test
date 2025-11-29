package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$updateRecordName$1", f = "FastRecordMainViewModel.kt", i = {}, l = {367, 368}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordMainViewModel$updateRecordName$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callBack;
    final /* synthetic */ long $recordId;
    final /* synthetic */ String $title;
    int label;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$updateRecordName$1$1", f = "FastRecordMainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$updateRecordName$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(function0, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                function0.invoke();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainViewModel$updateRecordName$1(long j, String str, Function0<Unit> function0, Continuation<? super FastRecordMainViewModel$updateRecordName$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.$title = str;
        this.$callBack = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordMainViewModel$updateRecordName$1(this.$recordId, this.$title, this.$callBack, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j = this.$recordId;
            String str = this.$title;
            LogExt.logI("updateRecordName recordId = " + j + ", title = " + str, "FastRecordMainViewModel");
            FastRecordDao fastRecordDao = FastRecordManager.Companion.getInstance().fastRecordDao();
            long j2 = this.$recordId;
            String str2 = this.$title;
            this.label = 1;
            if (fastRecordDao.updateRecordTitleItemState(j2, str2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        MainCoroutineDispatcher c = Dispatchers.c();
        final Function0<Unit> function0 = this.$callBack;
        AnonymousClass1 r1 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
        this.label = 2;
        if (BuildersKt.g(c, r1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordMainViewModel$updateRecordName$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.upuphone.ar.transcribe.phone.activity;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
import com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "position", "", "todo", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AiToDoFragment$initViews$2 extends Lambda implements Function2<Integer, AiTodoEntity, Unit> {
    final /* synthetic */ AiToDoFragment this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.AiToDoFragment$initViews$2$1", f = "AiToDoFragment.kt", i = {0}, l = {129}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    /* renamed from: com.upuphone.ar.transcribe.phone.activity.AiToDoFragment$initViews$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(aiToDoFragment, aiTodoEntity, i, continuation);
            r0.L$0 = obj;
            return r0;
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                AiTodoViewModel access$getTodoViewModel = aiToDoFragment.getTodoViewModel();
                AiTodoEntity aiTodoEntity = aiTodoEntity;
                this.L$0 = coroutineScope2;
                this.label = 1;
                if (access$getTodoViewModel.s(aiTodoEntity, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            MainCoroutineDispatcher c = Dispatchers.c();
            final AiToDoFragment aiToDoFragment = aiToDoFragment;
            final int i2 = i;
            Job unused = BuildersKt__Builders_commonKt.d(coroutineScope, c, (CoroutineStart) null, new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                int label;

                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return 

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public AiToDoFragment$initViews$2(AiToDoFragment aiToDoFragment) {
                        super(2);
                        this.this$0 = aiToDoFragment;
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke(((Number) obj).intValue(), (AiTodoEntity) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final int i, @NotNull final AiTodoEntity aiTodoEntity) {
                        Intrinsics.checkNotNullParameter(aiTodoEntity, VuiModelType.TODO);
                        LifecycleCoroutineScope a2 = LifecycleOwnerKt.a(this.this$0);
                        CoroutineDispatcher b = Dispatchers.b();
                        final AiToDoFragment aiToDoFragment = this.this$0;
                        Job unused = BuildersKt__Builders_commonKt.d(a2, b, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 2, (Object) null);
                    }
                }

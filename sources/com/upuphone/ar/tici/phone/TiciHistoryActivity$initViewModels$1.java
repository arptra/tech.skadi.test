package com.upuphone.ar.tici.phone;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.upuphone.ar.tici.phone.data.TiciHistory;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciHistoryActivity$initViewModels$1", f = "TiciHistoryActivity.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
public final class TiciHistoryActivity$initViewModels$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TiciHistoryActivity this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciHistoryActivity$initViewModels$1$1", f = "TiciHistoryActivity.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.tici.phone.TiciHistoryActivity$initViewModels$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(ticiHistoryActivity, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow j = ticiHistoryActivity.a1().j();
                final TiciHistoryActivity ticiHistoryActivity = ticiHistoryActivity;
                AnonymousClass1 r1 = new Function2<Map<String, ? extends List<? extends TiciHistory>>, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    /* synthetic */ Object L$0;
                    int label;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        AnonymousClass1 r0 = 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public TiciHistoryActivity$initViewModels$1(TiciHistoryActivity ticiHistoryActivity, Continuation<? super TiciHistoryActivity$initViewModels$1> continuation) {
                            super(2, continuation);
                            this.this$0 = ticiHistoryActivity;
                        }

                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            return new TiciHistoryActivity$initViewModels$1(this.this$0, continuation);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                final TiciHistoryActivity ticiHistoryActivity = this.this$0;
                                Lifecycle.State state = Lifecycle.State.CREATED;
                                AnonymousClass1 r3 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
                                this.label = 1;
                                if (RepeatOnLifecycleKt.b(ticiHistoryActivity, state, r3, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }

                        @Nullable
                        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                            return ((TiciHistoryActivity$initViewModels$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }

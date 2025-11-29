package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.data.ImportFileState;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.EventBus;
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
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTiciImportFileActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciImportFileActivity.kt\ncom/upuphone/ar/tici/phone/TiciImportFileActivity$initViewModels$3\n+ 2 EventBus.kt\ncom/upuphone/ar/tici/phone/utils/EventBus\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 5 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,197:1\n64#2:198\n36#3:199\n21#3:200\n23#3:204\n50#4:201\n55#4:203\n106#5:202\n*S KotlinDebug\n*F\n+ 1 TiciImportFileActivity.kt\ncom/upuphone/ar/tici/phone/TiciImportFileActivity$initViewModels$3\n*L\n156#1:198\n156#1:199\n156#1:200\n156#1:204\n156#1:201\n156#1:203\n156#1:202\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciImportFileActivity$initViewModels$3", f = "TiciImportFileActivity.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
public final class TiciImportFileActivity$initViewModels$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TiciImportFileActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciImportFileActivity$initViewModels$3(TiciImportFileActivity ticiImportFileActivity, Continuation<? super TiciImportFileActivity$initViewModels$3> continuation) {
        super(2, continuation);
        this.this$0 = ticiImportFileActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciImportFileActivity$initViewModels$3(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TiciImportFileActivity$initViewModels$3$invokeSuspend$$inlined$register$1 ticiImportFileActivity$initViewModels$3$invokeSuspend$$inlined$register$1 = new TiciImportFileActivity$initViewModels$3$invokeSuspend$$inlined$register$1(EventBus.e);
            final TiciImportFileActivity ticiImportFileActivity = this.this$0;
            AnonymousClass1 r5 = new FlowCollector() {
                /* renamed from: d */
                public final Object emit(ImportFileState importFileState, Continuation continuation) {
                    CommonExtKt.b("receive ImportFileState: " + importFileState, "TiciImportFileActivity");
                    ticiImportFileActivity.finish();
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (ticiImportFileActivity$initViewModels$3$invokeSuspend$$inlined$register$1.collect(r5, this) == coroutine_suspended) {
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
        return ((TiciImportFileActivity$initViewModels$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

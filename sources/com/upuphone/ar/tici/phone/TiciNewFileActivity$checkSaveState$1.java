package com.upuphone.ar.tici.phone;

import android.text.Editable;
import com.upuphone.ar.tici.R;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciNewFileActivity$checkSaveState$1", f = "TiciNewFileActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TiciNewFileActivity$checkSaveState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TiciNewFileActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciNewFileActivity$checkSaveState$1(TiciNewFileActivity ticiNewFileActivity, Continuation<? super TiciNewFileActivity$checkSaveState$1> continuation) {
        super(2, continuation);
        this.this$0 = ticiNewFileActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciNewFileActivity$checkSaveState$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Editable text;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Editable text2 = this.this$0.F0().c.getText();
            if (text2 == null || text2.length() == 0 || (text = this.this$0.F0().b.getText()) == null || text.length() == 0) {
                this.this$0.F0().e.getTvSave().setTextColor(this.this$0.getColor(R.color.tici_blue_trans_30));
            } else {
                this.this$0.F0().e.getTvSave().setTextColor(this.this$0.getColor(R.color.tici_blue));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciNewFileActivity$checkSaveState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

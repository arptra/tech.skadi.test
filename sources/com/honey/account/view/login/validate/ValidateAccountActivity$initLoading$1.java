package com.honey.account.view.login.validate;

import android.widget.TextView;
import com.honey.account.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "second", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.view.login.validate.ValidateAccountActivity$initLoading$1", f = "ValidateAccountActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ValidateAccountActivity$initLoading$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ ValidateAccountActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValidateAccountActivity$initLoading$1(ValidateAccountActivity validateAccountActivity, Continuation<? super ValidateAccountActivity$initLoading$1> continuation) {
        super(2, continuation);
        this.this$0 = validateAccountActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ValidateAccountActivity$initLoading$1 validateAccountActivity$initLoading$1 = new ValidateAccountActivity$initLoading$1(this.this$0, continuation);
        validateAccountActivity$initLoading$1.I$0 = ((Number) obj).intValue();
        return validateAccountActivity$initLoading$1;
    }

    @Nullable
    public final Object invoke(int i, @Nullable Continuation<? super Unit> continuation) {
        return ((ValidateAccountActivity$initLoading$1) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int i = this.I$0;
            if (i == 100) {
                return Unit.INSTANCE;
            }
            TextView access$getMTvSendLoginCode = this.this$0.getMTvSendLoginCode();
            if (i <= 0) {
                this.this$0.getMTvSendLoginCode().setEnabled(true);
                str = this.this$0.getResources().getString(R.string.get_vcode);
            } else {
                this.this$0.getMTvSendLoginCode().setEnabled(false);
                String string = this.this$0.getResources().getString(R.string.reget_vcode);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                str = String.format(string, Arrays.copyOf(new Object[]{Boxing.boxInt(i)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            }
            access$getMTvSendLoginCode.setText(str);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (Continuation<? super Unit>) (Continuation) obj2);
    }
}

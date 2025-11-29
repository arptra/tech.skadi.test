package com.upuphone.ar.translation.phone.vm;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import androidx.core.content.ContextCompat;
import com.upuphone.ar.translation.ext.DialogExtKt;
import com.upuphone.ar.translation.phone.R;
import flyme.support.v7.app.ShowAtBottomAlertDialog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorMainViewModel$showRecordDeleteDialog$1", f = "TranslatorMainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorMainViewModel$showRecordDeleteDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ int $deleteCount;
    int label;
    final /* synthetic */ TranslatorMainViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorMainViewModel$showRecordDeleteDialog$1(TranslatorMainViewModel translatorMainViewModel, int i, Activity activity, Continuation<? super TranslatorMainViewModel$showRecordDeleteDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = translatorMainViewModel;
        this.$deleteCount = i;
        this.$activity = activity;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(TranslatorMainViewModel translatorMainViewModel, DialogInterface dialogInterface, int i) {
        translatorMainViewModel.e.setValue(Boolean.TRUE);
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$2$lambda$1(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorMainViewModel$showRecordDeleteDialog$1(this.this$0, this.$deleteCount, this.$activity, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this.this$0.l().getString(R.string.tl_deleted_options);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(this.$deleteCount)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            ShowAtBottomAlertDialog create = new ShowAtBottomAlertDialog.Builder(this.$activity).setItems((CharSequence[]) new String[]{format}, (DialogInterface.OnClickListener) new a(this.this$0), true, new ColorStateList[]{ContextCompat.getColorStateList(this.this$0.l(), R.color.color_choice_multi_delete_dialog_item)}).create();
            TranslatorMainViewModel translatorMainViewModel = this.this$0;
            Intrinsics.checkNotNull(create);
            DialogExtKt.a(create);
            create.setButton(-2, (CharSequence) translatorMainViewModel.l().getString(R.string.tl_dialog_cancel), (DialogInterface.OnClickListener) new b());
            create.show();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorMainViewModel$showRecordDeleteDialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

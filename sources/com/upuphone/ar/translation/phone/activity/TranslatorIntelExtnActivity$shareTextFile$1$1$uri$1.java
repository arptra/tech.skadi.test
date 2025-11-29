package com.upuphone.ar.translation.phone.activity;

import android.net.Uri;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.ext.StringExtKt;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.utils.DateUtils;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.activity.TranslatorIntelExtnActivity$shareTextFile$1$1$uri$1", f = "TranslatorIntelExtnActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorIntelExtnActivity$shareTextFile$1$1$uri$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    final /* synthetic */ NoteBean $noteBean;
    final /* synthetic */ String $shareText;
    int label;
    final /* synthetic */ TranslatorIntelExtnActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorIntelExtnActivity$shareTextFile$1$1$uri$1(NoteBean noteBean, TranslatorIntelExtnActivity translatorIntelExtnActivity, String str, Continuation<? super TranslatorIntelExtnActivity$shareTextFile$1$1$uri$1> continuation) {
        super(2, continuation);
        this.$noteBean = noteBean;
        this.this$0 = translatorIntelExtnActivity;
        this.$shareText = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorIntelExtnActivity$shareTextFile$1$1$uri$1(this.$noteBean, this.this$0, this.$shareText, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String d = StringExtKt.d(StringExtKt.c(this.$noteBean.getTitle()));
            String c = DateUtils.c(this.$noteBean.getRecordTime(), 7);
            return ContextExtKt.I(this.this$0, this.$shareText, d + AccountConstantKt.DEFAULT_SEGMENT + c + ".txt");
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Uri> continuation) {
        return ((TranslatorIntelExtnActivity$shareTextFile$1$1$uri$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.upuphone.ar.tici.phone.utils;

import com.upuphone.ar.tici.phone.starrynet.msg.ParagraphItem;
import java.util.ArrayList;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/upuphone/ar/tici/phone/starrynet/msg/ParagraphItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.ParagraphHelper$Companion$computeParagraph$2", f = "ParagraphHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ParagraphHelper$Companion$computeParagraph$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<ParagraphItem>>, Object> {
    final /* synthetic */ String $sourceText;
    final /* synthetic */ int $wordCountOfParagraph;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ParagraphHelper$Companion$computeParagraph$2(String str, int i, Continuation<? super ParagraphHelper$Companion$computeParagraph$2> continuation) {
        super(2, continuation);
        this.$sourceText = str;
        this.$wordCountOfParagraph = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ParagraphHelper$Companion$computeParagraph$2(this.$sourceText, this.$wordCountOfParagraph, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CommonExtKt.e("computeParagraph, sourceText.length: " + this.$sourceText.length(), "ParagraphHelper");
            int ceil = (int) ((float) Math.ceil((double) (((float) this.$sourceText.length()) / ((float) this.$wordCountOfParagraph))));
            CommonExtKt.e("computeParagraph, totalPart: " + ceil, "ParagraphHelper");
            ArrayList arrayList = new ArrayList();
            int i = this.$wordCountOfParagraph;
            String str = this.$sourceText;
            int i2 = 0;
            int i3 = 0;
            while (i2 < ceil) {
                int min = Math.min(i, str.length() - i3) + i3;
                arrayList.add(new ParagraphItem(i3, min));
                i2++;
                i3 = min;
            }
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<ParagraphItem>> continuation) {
        return ((ParagraphHelper$Companion$computeParagraph$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

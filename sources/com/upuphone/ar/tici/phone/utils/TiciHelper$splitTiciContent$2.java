package com.upuphone.ar.tici.phone.utils;

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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.TiciHelper$splitTiciContent$2", f = "TiciHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TiciHelper$splitTiciContent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<String>>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ int $wordCount;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciHelper$splitTiciContent$2(String str, int i, Continuation<? super TiciHelper$splitTiciContent$2> continuation) {
        super(2, continuation);
        this.$content = str;
        this.$wordCount = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciHelper$splitTiciContent$2(this.$content, this.$wordCount, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CommonExtKt.e("splitTiciContent, sourceText.length: " + this.$content.length(), "TiciHelper");
            int ceil = (int) ((float) Math.ceil((double) (((float) this.$content.length()) / ((float) this.$wordCount))));
            CommonExtKt.e("splitTiciContent, totalPart: " + ceil, "TiciHelper");
            int ceil2 = (int) ((float) Math.ceil((double) (((float) this.$content.length()) / ((float) ceil))));
            CommonExtKt.e("splitTiciContent, partWordCount: " + ceil2, "TiciHelper");
            ArrayList arrayList = new ArrayList();
            String str = this.$content;
            int i = 0;
            int i2 = 0;
            while (i < ceil) {
                int min = Math.min(ceil2, str.length() - i2) + i2;
                String substring = str.substring(i2, min);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                arrayList.add(substring);
                i++;
                i2 = min;
            }
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<String>> continuation) {
        return ((TiciHelper$splitTiciContent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

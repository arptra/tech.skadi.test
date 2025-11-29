package com.upuphone.ar.tici.phone.utils;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.ContextExtKt$readAssetsToString$2", f = "ContextExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ContextExtKt$readAssetsToString$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $path;
    final /* synthetic */ Context $this_readAssetsToString;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextExtKt$readAssetsToString$2(Context context, String str, Continuation<? super ContextExtKt$readAssetsToString$2> continuation) {
        super(2, continuation);
        this.$this_readAssetsToString = context;
        this.$path = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ContextExtKt$readAssetsToString$2(this.$this_readAssetsToString, this.$path, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                InputStream open = this.$this_readAssetsToString.getAssets().open(this.$path);
                Intrinsics.checkNotNullExpressionValue(open, "open(...)");
                InputStreamReader inputStreamReader = new InputStreamReader(open, Charsets.UTF_8);
                return TextStreamsKt.readText(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
            } catch (Exception e) {
                CommonExtKt.d("readAssetsToString, error: " + e, "TiciApp", (Throwable) null, 2, (Object) null);
                return "";
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((ContextExtKt$readAssetsToString$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

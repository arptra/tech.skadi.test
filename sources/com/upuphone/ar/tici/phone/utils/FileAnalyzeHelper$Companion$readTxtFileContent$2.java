package com.upuphone.ar.tici.phone.utils;

import java.io.File;
import java.nio.charset.Charset;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion$readTxtFileContent$2", f = "FileAnalyzeHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FileAnalyzeHelper$Companion$readTxtFileContent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Charset $charset;
    final /* synthetic */ File $file;
    final /* synthetic */ int $maxLength;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileAnalyzeHelper$Companion$readTxtFileContent$2(File file, Charset charset, int i, Continuation<? super FileAnalyzeHelper$Companion$readTxtFileContent$2> continuation) {
        super(2, continuation);
        this.$file = file;
        this.$charset = charset;
        this.$maxLength = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileAnalyzeHelper$Companion$readTxtFileContent$2(this.$file, this.$charset, this.$maxLength, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return FileExtKt.d(this.$file, this.$charset, this.$maxLength);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((FileAnalyzeHelper$Companion$readTxtFileContent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

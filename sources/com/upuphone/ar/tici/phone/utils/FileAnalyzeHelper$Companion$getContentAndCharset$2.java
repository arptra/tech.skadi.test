package com.upuphone.ar.tici.phone.utils;

import com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper;
import java.io.File;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Ljava/nio/charset/Charset;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion$getContentAndCharset$2", f = "FileAnalyzeHelper.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
final class FileAnalyzeHelper$Companion$getContentAndCharset$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends Charset>>, Object> {
    final /* synthetic */ File $file;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileAnalyzeHelper$Companion$getContentAndCharset$2(File file, Continuation<? super FileAnalyzeHelper$Companion$getContentAndCharset$2> continuation) {
        super(2, continuation);
        this.$file = file;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileAnalyzeHelper$Companion$getContentAndCharset$2(this.$file, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FileAnalyzeHelper.Companion companion = FileAnalyzeHelper.f5989a;
            File file = this.$file;
            this.label = 1;
            obj = companion.a(file, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Charset charset = (Charset) obj;
        String absolutePath = this.$file.getAbsolutePath();
        CommonExtKt.e("getAllContent-> file: " + absolutePath + ", charset: " + charset, "FileAnalyzeHelper");
        if (charset == null) {
            CommonExtKt.e("getAllContent-> 不支持的文件格式，降级为utf-8", "FileAnalyzeHelper");
        }
        return TuplesKt.to(StringExtKt.e(FilesKt.readText(this.$file, charset == null ? Charsets.UTF_8 : charset)), charset);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Pair<String, ? extends Charset>> continuation) {
        return ((FileAnalyzeHelper$Companion$getContentAndCharset$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

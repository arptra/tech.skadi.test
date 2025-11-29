package com.upuphone.ar.tici.phone.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
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
import org.apache.tika.detect.DefaultEncodingDetector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Ljava/nio/charset/Charset;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion$detectEncodingCharset$2", f = "FileAnalyzeHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FileAnalyzeHelper$Companion$detectEncodingCharset$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Charset>, Object> {
    final /* synthetic */ File $file;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileAnalyzeHelper$Companion$detectEncodingCharset$2(File file, Continuation<? super FileAnalyzeHelper$Companion$detectEncodingCharset$2> continuation) {
        super(2, continuation);
        this.$file = file;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileAnalyzeHelper$Companion$detectEncodingCharset$2(this.$file, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                DefaultEncodingDetector defaultEncodingDetector = new DefaultEncodingDetector();
                FileInputStream fileInputStream = new FileInputStream(this.$file);
                return defaultEncodingDetector.detect(fileInputStream instanceof BufferedInputStream ? (BufferedInputStream) fileInputStream : new BufferedInputStream(fileInputStream, 8192), new org.apache.tika.metadata.Metadata());
            } catch (Throwable th) {
                CommonExtKt.d("detectEncodingCharset, error: " + th, "FileAnalyzeHelper", (Throwable) null, 2, (Object) null);
                return null;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Charset> continuation) {
        return ((FileAnalyzeHelper$Companion$detectEncodingCharset$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

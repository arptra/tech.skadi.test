package com.upuphone.ar.tici.phone.utils;

import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.apache.tika.Tika;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion$detectMime$2", f = "FileAnalyzeHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FileAnalyzeHelper$Companion$detectMime$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ File $file;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileAnalyzeHelper$Companion$detectMime$2(File file, Continuation<? super FileAnalyzeHelper$Companion$detectMime$2> continuation) {
        super(2, continuation);
        this.$file = file;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileAnalyzeHelper$Companion$detectMime$2(this.$file, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                return new Tika().a(this.$file);
            } catch (Throwable th) {
                CommonExtKt.d("detectMime, error: " + th, "FileAnalyzeHelper", (Throwable) null, 2, (Object) null);
                return null;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((FileAnalyzeHelper$Companion$detectMime$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.upuphone.ar.tici.phone.utils;

import java.io.File;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.FileScanner$scanTxtFiles$2", f = "FileScanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FileScanner$scanTxtFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<File>>, Object> {
    final /* synthetic */ String $directoryPath;
    final /* synthetic */ List<String> $suffixList;
    int label;
    final /* synthetic */ FileScanner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileScanner$scanTxtFiles$2(FileScanner fileScanner, String str, List<String> list, Continuation<? super FileScanner$scanTxtFiles$2> continuation) {
        super(2, continuation);
        this.this$0 = fileScanner;
        this.$directoryPath = str;
        this.$suffixList = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileScanner$scanTxtFiles$2(this.this$0, this.$directoryPath, this.$suffixList, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.c(this.$directoryPath, this.$suffixList);
            return this.this$0.f5990a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<File>> continuation) {
        return ((FileScanner$scanTxtFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

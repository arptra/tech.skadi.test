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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFileScanner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileScanner.kt\ncom/upuphone/ar/tici/phone/utils/FileScanner$scanTxtFiles$4\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,50:1\n1855#2,2:51\n*S KotlinDebug\n*F\n+ 1 FileScanner.kt\ncom/upuphone/ar/tici/phone/utils/FileScanner$scanTxtFiles$4\n*L\n22#1:51,2\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.FileScanner$scanTxtFiles$4", f = "FileScanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FileScanner$scanTxtFiles$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<File>>, Object> {
    final /* synthetic */ List<String> $pathList;
    final /* synthetic */ List<String> $suffixList;
    int label;
    final /* synthetic */ FileScanner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileScanner$scanTxtFiles$4(List<String> list, FileScanner fileScanner, List<String> list2, Continuation<? super FileScanner$scanTxtFiles$4> continuation) {
        super(2, continuation);
        this.$pathList = list;
        this.this$0 = fileScanner;
        this.$suffixList = list2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileScanner$scanTxtFiles$4(this.$pathList, this.this$0, this.$suffixList, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<String> list = this.$pathList;
            FileScanner fileScanner = this.this$0;
            List<String> list2 = this.$suffixList;
            for (String str : list) {
                try {
                    CommonExtKt.e("scanTxtFiles, path: " + str, "FileScanner");
                    fileScanner.c(str, list2);
                } catch (Exception e) {
                    CommonExtKt.d("scanTxtFiles, path: " + str + ", error: " + e, "FileScanner", (Throwable) null, 2, (Object) null);
                }
            }
            return this.this$0.f5990a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<File>> continuation) {
        return ((FileScanner$scanTxtFiles$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

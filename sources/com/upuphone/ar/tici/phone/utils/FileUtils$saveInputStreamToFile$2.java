package com.upuphone.ar.tici.phone.utils;

import java.io.File;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.FileUtils$saveInputStreamToFile$2", f = "FileUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FileUtils$saveInputStreamToFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ String $directoryPath;
    final /* synthetic */ String $fileName;
    final /* synthetic */ InputStream $inputStream;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileUtils$saveInputStreamToFile$2(String str, String str2, InputStream inputStream, Continuation<? super FileUtils$saveInputStreamToFile$2> continuation) {
        super(2, continuation);
        this.$directoryPath = str;
        this.$fileName = str2;
        this.$inputStream = inputStream;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileUtils$saveInputStreamToFile$2(this.$directoryPath, this.$fileName, this.$inputStream, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        throw r0;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r4.label
            if (r0 != 0) goto L_0x003e
            kotlin.ResultKt.throwOnFailure(r5)
            java.io.File r5 = new java.io.File
            java.lang.String r0 = r4.$directoryPath
            r5.<init>(r0)
            boolean r0 = r5.exists()
            if (r0 != 0) goto L_0x001a
            r5.mkdirs()
        L_0x001a:
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r4.$fileName
            r0.<init>(r5, r1)
            java.io.FileOutputStream r5 = new java.io.FileOutputStream
            r5.<init>(r0)
            java.io.InputStream r4 = r4.$inputStream
            r1 = 0
            r2 = 2
            r3 = 0
            kotlin.io.ByteStreamsKt.copyTo$default(r4, r5, r1, r2, r3)     // Catch:{ all -> 0x0037 }
            r5.flush()     // Catch:{ all -> 0x0037 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0037 }
            kotlin.io.CloseableKt.closeFinally(r5, r3)
            return r0
        L_0x0037:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r4)
            throw r0
        L_0x003e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.utils.FileUtils$saveInputStreamToFile$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super File> continuation) {
        return ((FileUtils$saveInputStreamToFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

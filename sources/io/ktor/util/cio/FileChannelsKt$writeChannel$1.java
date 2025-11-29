package io.ktor.util.cio;

import io.ktor.utils.io.ReaderScope;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFileChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileChannels.kt\nio/ktor/util/cio/FileChannelsKt$writeChannel$1\n+ 2 Closeable.kt\nio/ktor/utils/io/core/CloseableKt\n*L\n1#1,100:1\n8#2,4:101\n22#2,4:105\n12#2,9:109\n*S KotlinDebug\n*F\n+ 1 FileChannels.kt\nio/ktor/util/cio/FileChannelsKt$writeChannel$1\n*L\n95#1:101,4\n95#1:105,4\n95#1:109,9\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ReaderScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$writeChannel$1", f = "FileChannels.kt", i = {0, 0, 0}, l = {96}, m = "invokeSuspend", n = {"$this$use$iv", "file", "closed$iv"}, s = {"L$0", "L$1", "I$0"})
final class FileChannelsKt$writeChannel$1 extends SuspendLambda implements Function2<ReaderScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $this_writeChannel;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileChannelsKt$writeChannel$1(File file, Continuation<? super FileChannelsKt$writeChannel$1> continuation) {
        super(2, continuation);
        this.$this_writeChannel = file;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FileChannelsKt$writeChannel$1 fileChannelsKt$writeChannel$1 = new FileChannelsKt$writeChannel$1(this.$this_writeChannel, continuation);
        fileChannelsKt$writeChannel$1.L$0 = obj;
        return fileChannelsKt$writeChannel$1;
    }

    @Nullable
    public final Object invoke(@NotNull ReaderScope readerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FileChannelsKt$writeChannel$1) create(readerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.io.RandomAccessFile} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 1
            if (r1 == 0) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            java.lang.Object r0 = r12.L$1
            java.io.RandomAccessFile r0 = (java.io.RandomAccessFile) r0
            java.lang.Object r12 = r12.L$0
            java.io.Closeable r12 = (java.io.Closeable) r12
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x0017 }
            goto L_0x0055
        L_0x0017:
            r13 = move-exception
            goto L_0x0068
        L_0x0019:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            io.ktor.utils.io.ReaderScope r13 = (io.ktor.utils.io.ReaderScope) r13
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.io.File r3 = r12.$this_writeChannel
            java.lang.String r4 = "rw"
            r1.<init>(r3, r4)
            io.ktor.utils.io.ByteReadChannel r5 = r13.b()     // Catch:{ all -> 0x0066 }
            java.nio.channels.FileChannel r6 = r1.getChannel()     // Catch:{ all -> 0x0066 }
            java.lang.String r13 = "file.channel"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r13)     // Catch:{ all -> 0x0066 }
            r12.L$0 = r1     // Catch:{ all -> 0x0066 }
            r12.L$1 = r1     // Catch:{ all -> 0x0066 }
            r13 = 0
            r12.I$0 = r13     // Catch:{ all -> 0x0066 }
            r12.label = r2     // Catch:{ all -> 0x0066 }
            r7 = 0
            r10 = 2
            r11 = 0
            r9 = r12
            java.lang.Object r13 = io.ktor.utils.io.jvm.nio.WritingKt.b(r5, r6, r7, r9, r10, r11)     // Catch:{ all -> 0x0066 }
            if (r13 != r0) goto L_0x0053
            return r0
        L_0x0053:
            r12 = r1
            r0 = r12
        L_0x0055:
            java.lang.Number r13 = (java.lang.Number) r13     // Catch:{ all -> 0x0017 }
            long r1 = r13.longValue()     // Catch:{ all -> 0x0017 }
            r0.setLength(r1)     // Catch:{ all -> 0x0017 }
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0017 }
            r12.close()
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0066:
            r13 = move-exception
            r12 = r1
        L_0x0068:
            r12.close()     // Catch:{ all -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r12 = move-exception
            io.ktor.utils.io.core.CloseableJVMKt.a(r13, r12)
        L_0x0070:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.cio.FileChannelsKt$writeChannel$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

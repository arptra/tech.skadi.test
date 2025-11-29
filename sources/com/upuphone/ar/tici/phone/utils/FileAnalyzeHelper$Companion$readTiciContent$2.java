package com.upuphone.ar.tici.phone.utils;

import com.upuphone.ar.tici.phone.data.TiciContentInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/upuphone/ar/tici/phone/data/TiciContentInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion$readTiciContent$2", f = "FileAnalyzeHelper.kt", i = {1}, l = {63, 64}, m = "invokeSuspend", n = {"mime"}, s = {"L$0"})
final class FileAnalyzeHelper$Companion$readTiciContent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TiciContentInfo>, Object> {
    final /* synthetic */ File $file;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileAnalyzeHelper$Companion$readTiciContent$2(File file, Continuation<? super FileAnalyzeHelper$Companion$readTiciContent$2> continuation) {
        super(2, continuation);
        this.$file = file;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileAnalyzeHelper$Companion$readTiciContent$2(this.$file, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0083  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L_0x0022
            if (r1 == r2) goto L_0x001e
            if (r1 != r3) goto L_0x0016
            java.lang.Object r0 = r5.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0045
        L_0x0016:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0032
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r6)
            com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion r6 = com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper.f5989a
            java.io.File r1 = r5.$file
            r5.label = r2
            java.lang.Object r6 = r6.c(r1, r5)
            if (r6 != r0) goto L_0x0032
            return r0
        L_0x0032:
            java.lang.String r6 = (java.lang.String) r6
            com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion r1 = com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper.f5989a
            java.io.File r2 = r5.$file
            r5.L$0 = r6
            r5.label = r3
            java.lang.Object r1 = r1.b(r2, r5)
            if (r1 != r0) goto L_0x0043
            return r0
        L_0x0043:
            r0 = r6
            r6 = r1
        L_0x0045:
            java.nio.charset.Charset r6 = (java.nio.charset.Charset) r6
            java.io.File r1 = r5.$file
            java.lang.String r1 = r1.getAbsolutePath()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "readTiciContent, file: "
            r2.append(r4)
            r2.append(r1)
            java.lang.String r1 = ", mime: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r1 = ", charset: "
            r2.append(r1)
            r2.append(r6)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "FileAnalyzeHelper"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r1, r2)
            if (r6 != 0) goto L_0x0083
            java.lang.String r5 = "readTiciContent, 不支持的文件格式，降级为utf-8"
            r6 = 0
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r5, r2, r6, r3, r6)
            com.upuphone.ar.tici.phone.data.TiciContentInfo r5 = new com.upuphone.ar.tici.phone.data.TiciContentInfo
            java.lang.String r1 = ""
            r5.<init>(r0, r6, r1)
            return r5
        L_0x0083:
            java.io.File r5 = r5.$file
            java.lang.String r5 = kotlin.io.FilesKt.readText(r5, r6)
            java.lang.String r5 = com.upuphone.ar.tici.phone.utils.StringExtKt.e(r5)
            com.upuphone.ar.tici.phone.data.TiciContentInfo r1 = new com.upuphone.ar.tici.phone.data.TiciContentInfo
            java.lang.String r6 = r6.name()
            r1.<init>(r0, r6, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion$readTiciContent$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super TiciContentInfo> continuation) {
        return ((FileAnalyzeHelper$Companion$readTiciContent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

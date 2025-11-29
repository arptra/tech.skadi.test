package com.upuphone.ar.tici.phone.utils;

import com.upuphone.ar.tici.phone.data.ImportFileState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/upuphone/ar/tici/phone/data/ImportFileState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.TiciHelper$importSmallTiciFile$2", f = "TiciHelper.kt", i = {0, 0, 1, 1, 1}, l = {74, 121}, m = "invokeSuspend", n = {"file", "maxLength", "rawContent", "content", "ticiEntity"}, s = {"L$0", "I$0", "L$0", "L$1", "L$2"})
public final class TiciHelper$importSmallTiciFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImportFileState>, Object> {
    final /* synthetic */ String $filePath;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciHelper$importSmallTiciFile$2(String str, Continuation<? super TiciHelper$importSmallTiciFile$2> continuation) {
        super(2, continuation);
        this.$filePath = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciHelper$importSmallTiciFile$2(this.$filePath, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0178, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0179, code lost:
        r4 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01a1, code lost:
        com.upuphone.ar.tici.phone.utils.CommonExtKt.d("importSmallTiciFile, readFile error: " + r0, "TiciHelper", (java.lang.Throwable) null, 2, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01b7, code lost:
        return r0.getFail();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x0034, B:14:0x0061] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e A[ExcHandler: ImportFailException (r0v9 'e' com.upuphone.ar.tici.phone.utils.ImportFailException A[CUSTOM_DECLARE]), Splitter:B:8:0x0034] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "importSmallTiciFile, readFile error: "
            r4 = 1
            r5 = 2
            java.lang.String r6 = "TiciHelper"
            r7 = 0
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x002e
            if (r2 != r5) goto L_0x0026
            java.lang.Object r1 = r0.L$2
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r1 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r1
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r0.L$0
            java.lang.String r3 = (java.lang.String) r3
            kotlin.ResultKt.throwOnFailure(r18)
            goto L_0x014d
        L_0x0026:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002e:
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$0
            java.io.File r4 = (java.io.File) r4
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ ImportFailException -> 0x003e, Exception -> 0x003b }
            r8 = r4
            r4 = r18
            goto L_0x007a
        L_0x003b:
            r0 = move-exception
            goto L_0x017a
        L_0x003e:
            r0 = move-exception
            goto L_0x01a1
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.String r2 = r0.$filePath
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "importSmallTiciFile, filePath: "
            r8.append(r9)
            r8.append(r2)
            java.lang.String r2 = r8.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r2, r6)
            java.io.File r2 = new java.io.File
            java.lang.String r8 = r0.$filePath
            r2.<init>(r8)
            com.upuphone.ar.tici.phone.utils.TiciHelper r8 = com.upuphone.ar.tici.phone.utils.TiciHelper.f6002a     // Catch:{ ImportFailException -> 0x003e, Exception -> 0x0178 }
            java.lang.String r9 = r0.$filePath     // Catch:{ ImportFailException -> 0x003e, Exception -> 0x0178 }
            r0.L$0 = r2     // Catch:{ ImportFailException -> 0x003e, Exception -> 0x0178 }
            r10 = 60000(0xea60, float:8.4078E-41)
            r0.I$0 = r10     // Catch:{ ImportFailException -> 0x003e, Exception -> 0x0178 }
            r0.label = r4     // Catch:{ ImportFailException -> 0x003e, Exception -> 0x0178 }
            r4 = 60100(0xeac4, float:8.4218E-41)
            java.lang.Object r4 = r8.k(r9, r4, r0)     // Catch:{ ImportFailException -> 0x003e, Exception -> 0x0178 }
            if (r4 != r1) goto L_0x0078
            return r1
        L_0x0078:
            r8 = r2
            r2 = r10
        L_0x007a:
            kotlin.Pair r4 = (kotlin.Pair) r4     // Catch:{ ImportFailException -> 0x003e, Exception -> 0x0175 }
            java.lang.Object r3 = r4.component1()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r4.component2()
            java.nio.charset.Charset r4 = (java.nio.charset.Charset) r4
            java.lang.String r9 = com.upuphone.ar.tici.phone.utils.StringExtKt.e(r3)
            java.lang.String r2 = com.upuphone.ar.tici.phone.utils.StringExtKt.j(r9, r2)
            int r9 = r3.length()
            int r10 = r2.length()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "importSmallTiciFile, rawTextLength: "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r9 = ", formatedTextLength: "
            r11.append(r9)
            r11.append(r10)
            java.lang.String r9 = r11.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r9, r6)
            int r9 = r2.length()
            if (r9 != 0) goto L_0x00bb
            goto L_0x00c1
        L_0x00bb:
            boolean r9 = kotlin.text.StringsKt.isBlank(r2)
            if (r9 == 0) goto L_0x00e3
        L_0x00c1:
            com.upuphone.ar.tici.phone.data.ImportFileInfo r0 = new com.upuphone.ar.tici.phone.data.ImportFileInfo
            long r11 = r8.length()
            if (r4 == 0) goto L_0x00cf
            java.lang.String r1 = r4.name()
            r15 = r1
            goto L_0x00d0
        L_0x00cf:
            r15 = r7
        L_0x00d0:
            r13 = 0
            r10 = r0
            r10.<init>(r11, r13, r15)
            java.lang.String r1 = "importSmallTiciFile, content is empty"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r1, r6, r7, r5, r7)
            com.upuphone.ar.tici.phone.data.ImportFileState$Fail r1 = new com.upuphone.ar.tici.phone.data.ImportFileState$Fail
            com.upuphone.ar.tici.phone.data.ImportFailReason r2 = com.upuphone.ar.tici.phone.data.ImportFailReason.EmptyContent
            r1.<init>(r2, r0)
            return r1
        L_0x00e3:
            int r9 = com.upuphone.ar.tici.phone.utils.StringExtKt.a(r2)
            r10 = 204800(0x32000, float:2.86986E-40)
            if (r9 <= r10) goto L_0x0123
            com.upuphone.ar.tici.phone.data.ImportFileInfo r0 = new com.upuphone.ar.tici.phone.data.ImportFileInfo
            long r12 = r8.length()
            long r14 = (long) r9
            if (r4 == 0) goto L_0x00fc
            java.lang.String r1 = r4.name()
            r16 = r1
            goto L_0x00fe
        L_0x00fc:
            r16 = r7
        L_0x00fe:
            r11 = r0
            r11.<init>(r12, r14, r16)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "importSmallTiciFile, content oversize("
            r1.append(r2)
            r1.append(r9)
            java.lang.String r2 = ")"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r1, r6, r7, r5, r7)
            com.upuphone.ar.tici.phone.data.ImportFileState$Fail r1 = new com.upuphone.ar.tici.phone.data.ImportFileState$Fail
            com.upuphone.ar.tici.phone.data.ImportFailReason r2 = com.upuphone.ar.tici.phone.data.ImportFailReason.TextByteOverSize
            r1.<init>(r2, r0)
            return r1
        L_0x0123:
            java.lang.String r4 = r8.getName()
            java.lang.String r8 = "getName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)
            java.lang.String r4 = com.upuphone.ar.tici.phone.utils.StringExtKt.g(r4)
            com.upuphone.ar.tici.phone.TiciApp r8 = com.upuphone.ar.tici.phone.TiciApp.b
            java.lang.String r8 = r8.g()
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r4 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.e(r4, r2, r7, r8)
            com.upuphone.ar.tici.phone.db.TiciDBHelper r7 = com.upuphone.ar.tici.phone.db.TiciDBHelper.f5925a
            r0.L$0 = r3
            r0.L$1 = r2
            r0.L$2 = r4
            r0.label = r5
            r5 = 0
            java.lang.Object r5 = r7.e(r4, r2, r5, r0)
            if (r5 != r1) goto L_0x014c
            return r1
        L_0x014c:
            r1 = r4
        L_0x014d:
            java.lang.String r4 = r1.toSimpleString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "importSmallTiciFile, insert ticiEntity: "
            r5.append(r7)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r4, r6)
            com.upuphone.ar.tici.phone.data.ImportFileState$Success r4 = new com.upuphone.ar.tici.phone.data.ImportFileState$Success
            java.lang.String r0 = r0.$filePath
            int r2 = r2.length()
            int r3 = r3.length()
            r4.<init>(r1, r0, r2, r3)
            return r4
        L_0x0175:
            r0 = move-exception
            r4 = r8
            goto L_0x017a
        L_0x0178:
            r0 = move-exception
            r4 = r2
        L_0x017a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r0, r6, r7, r5, r7)
            com.upuphone.ar.tici.phone.data.ImportFileInfo r0 = new com.upuphone.ar.tici.phone.data.ImportFileInfo
            long r9 = r4.length()
            r11 = 0
            r13 = 0
            r8 = r0
            r8.<init>(r9, r11, r13)
            com.upuphone.ar.tici.phone.data.ImportFileState$Fail r1 = new com.upuphone.ar.tici.phone.data.ImportFileState$Fail
            com.upuphone.ar.tici.phone.data.ImportFailReason r2 = com.upuphone.ar.tici.phone.data.ImportFailReason.ReadFileError
            r1.<init>(r2, r0)
            return r1
        L_0x01a1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r1, r6, r7, r5, r7)
            com.upuphone.ar.tici.phone.data.ImportFileState$Fail r0 = r0.getFail()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.utils.TiciHelper$importSmallTiciFile$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ImportFileState> continuation) {
        return ((TiciHelper$importSmallTiciFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

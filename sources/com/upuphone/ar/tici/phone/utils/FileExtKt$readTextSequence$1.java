package com.upuphone.ar.tici.phone.utils;

import java.io.Reader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.FileExtKt$readTextSequence$1", f = "FileExt.kt", i = {0, 0, 1, 1, 1, 1}, l = {81, 89, 94}, m = "invokeSuspend", n = {"$this$sequence", "stringBuffer", "$this$sequence", "stringBuffer", "buffer", "charsCopied"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "J$0"})
public final class FileExtKt$readTextSequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $maxLength;
    final /* synthetic */ int $pageLimit;
    final /* synthetic */ Reader $this_readTextSequence;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileExtKt$readTextSequence$1(int i, Reader reader, int i2, Continuation<? super FileExtKt$readTextSequence$1> continuation) {
        super(2, continuation);
        this.$pageLimit = i;
        this.$this_readTextSequence = reader;
        this.$maxLength = i2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FileExtKt$readTextSequence$1 fileExtKt$readTextSequence$1 = new FileExtKt$readTextSequence$1(this.$pageLimit, this.$this_readTextSequence, this.$maxLength, continuation);
        fileExtKt$readTextSequence$1.L$0 = obj;
        return fileExtKt$readTextSequence$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c6  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            java.lang.String r2 = "toString(...)"
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r1 == 0) goto L_0x0041
            if (r1 == r5) goto L_0x0035
            if (r1 == r4) goto L_0x0022
            if (r1 != r3) goto L_0x001a
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00dc
        L_0x001a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0022:
            long r7 = r14.J$0
            java.lang.Object r1 = r14.L$2
            char[] r1 = (char[]) r1
            java.lang.Object r9 = r14.L$1
            java.lang.StringBuffer r9 = (java.lang.StringBuffer) r9
            java.lang.Object r10 = r14.L$0
            kotlin.sequences.SequenceScope r10 = (kotlin.sequences.SequenceScope) r10
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00b7
        L_0x0035:
            java.lang.Object r1 = r14.L$1
            java.lang.StringBuffer r1 = (java.lang.StringBuffer) r1
            java.lang.Object r4 = r14.L$0
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0086
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            kotlin.sequences.SequenceScope r15 = (kotlin.sequences.SequenceScope) r15
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            int r7 = r14.$pageLimit
            char[] r7 = new char[r7]
            java.io.Reader r8 = r14.$this_readTextSequence
            int r8 = r8.read(r7)
            r9 = 0
            r10 = r9
            r9 = r1
            r1 = r7
        L_0x005c:
            if (r8 < 0) goto L_0x00c0
            r7 = 0
            r9.append(r1, r7, r8)
            long r12 = (long) r8
            long r10 = r10 + r12
            int r8 = r14.$maxLength
            long r12 = (long) r8
            int r8 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r8 < 0) goto L_0x0089
            java.lang.String r1 = r9.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r9.setLength(r7)
            r14.L$0 = r15
            r14.L$1 = r9
            r14.L$2 = r6
            r14.label = r5
            java.lang.Object r1 = r15.yield(r1, r14)
            if (r1 != r0) goto L_0x0084
            return r0
        L_0x0084:
            r4 = r15
            r1 = r9
        L_0x0086:
            r9 = r1
            r15 = r4
            goto L_0x00c0
        L_0x0089:
            int r8 = r9.length()
            int r12 = r14.$pageLimit
            if (r8 < r12) goto L_0x00b9
            java.lang.String r8 = r9.substring(r7, r12)
            int r12 = r14.$pageLimit
            java.lang.String r12 = r9.substring(r12)
            r9.setLength(r7)
            r9.append(r12)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r14.L$0 = r15
            r14.L$1 = r9
            r14.L$2 = r1
            r14.J$0 = r10
            r14.label = r4
            java.lang.Object r7 = r15.yield(r8, r14)
            if (r7 != r0) goto L_0x00b5
            return r0
        L_0x00b5:
            r7 = r10
            r10 = r15
        L_0x00b7:
            r15 = r10
            r10 = r7
        L_0x00b9:
            java.io.Reader r7 = r14.$this_readTextSequence
            int r8 = r7.read(r1)
            goto L_0x005c
        L_0x00c0:
            int r1 = r9.length()
            if (r1 <= 0) goto L_0x00dc
            java.lang.String r1 = r9.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r14.L$0 = r6
            r14.L$1 = r6
            r14.L$2 = r6
            r14.label = r3
            java.lang.Object r14 = r15.yield(r1, r14)
            if (r14 != r0) goto L_0x00dc
            return r0
        L_0x00dc:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.utils.FileExtKt$readTextSequence$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super String> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FileExtKt$readTextSequence$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

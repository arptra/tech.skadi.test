package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/LookAheadSuspendSession;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$copied$1", f = "Delimited.kt", i = {0, 0, 1, 1}, l = {85, 95}, m = "invokeSuspend", n = {"$this$lookAheadSuspend", "copied", "$this$lookAheadSuspend", "copied"}, s = {"L$0", "I$0", "L$0", "I$0"})
public final class DelimitedKt$readUntilDelimiterSuspend$copied$1 extends SuspendLambda implements Function2<LookAheadSuspendSession, Continuation<? super Integer>, Object> {
    final /* synthetic */ int $copied0;
    final /* synthetic */ ByteBuffer $delimiter;
    final /* synthetic */ ByteBuffer $dst;
    final /* synthetic */ Ref.BooleanRef $endFound;
    final /* synthetic */ ByteReadChannel $this_readUntilDelimiterSuspend;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DelimitedKt$readUntilDelimiterSuspend$copied$1(int i, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, Ref.BooleanRef booleanRef, ByteReadChannel byteReadChannel, Continuation<? super DelimitedKt$readUntilDelimiterSuspend$copied$1> continuation) {
        super(2, continuation);
        this.$copied0 = i;
        this.$delimiter = byteBuffer;
        this.$dst = byteBuffer2;
        this.$endFound = booleanRef;
        this.$this_readUntilDelimiterSuspend = byteReadChannel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DelimitedKt$readUntilDelimiterSuspend$copied$1 delimitedKt$readUntilDelimiterSuspend$copied$1 = new DelimitedKt$readUntilDelimiterSuspend$copied$1(this.$copied0, this.$delimiter, this.$dst, this.$endFound, this.$this_readUntilDelimiterSuspend, continuation);
        delimitedKt$readUntilDelimiterSuspend$copied$1.L$0 = obj;
        return delimitedKt$readUntilDelimiterSuspend$copied$1;
    }

    @Nullable
    public final Object invoke(@NotNull LookAheadSuspendSession lookAheadSuspendSession, @Nullable Continuation<? super Integer> continuation) {
        return ((DelimitedKt$readUntilDelimiterSuspend$copied$1) create(lookAheadSuspendSession, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r6.$endFound.element == false) goto L_0x0033;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008d  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002a
            if (r1 == r3) goto L_0x0020
            if (r1 != r2) goto L_0x0018
            int r1 = r6.I$0
            java.lang.Object r4 = r6.L$0
            io.ktor.utils.io.LookAheadSuspendSession r4 = (io.ktor.utils.io.LookAheadSuspendSession) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x007a
        L_0x0018:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0020:
            int r1 = r6.I$0
            java.lang.Object r4 = r6.L$0
            io.ktor.utils.io.LookAheadSuspendSession r4 = (io.ktor.utils.io.LookAheadSuspendSession) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0041
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            io.ktor.utils.io.LookAheadSuspendSession r7 = (io.ktor.utils.io.LookAheadSuspendSession) r7
            int r1 = r6.$copied0
        L_0x0033:
            r6.L$0 = r7
            r6.I$0 = r1
            r6.label = r3
            java.lang.Object r4 = r7.b(r3, r6)
            if (r4 != r0) goto L_0x0040
            return r0
        L_0x0040:
            r4 = r7
        L_0x0041:
            java.nio.ByteBuffer r7 = r6.$delimiter
            java.nio.ByteBuffer r5 = r6.$dst
            int r7 = io.ktor.utils.io.DelimitedKt.g(r4, r7, r5)
            if (r7 != 0) goto L_0x007c
            java.nio.ByteBuffer r7 = r6.$delimiter
            int r7 = io.ktor.utils.io.DelimitedKt.f(r4, r7)
            java.nio.ByteBuffer r5 = r6.$delimiter
            int r5 = r5.remaining()
            if (r7 != r5) goto L_0x005e
            kotlin.jvm.internal.Ref$BooleanRef r6 = r6.$endFound
            r6.element = r3
            goto L_0x0093
        L_0x005e:
            io.ktor.utils.io.ByteReadChannel r7 = r6.$this_readUntilDelimiterSuspend
            boolean r7 = r7.g()
            if (r7 == 0) goto L_0x0067
            goto L_0x0093
        L_0x0067:
            java.nio.ByteBuffer r7 = r6.$delimiter
            int r7 = r7.remaining()
            r6.L$0 = r4
            r6.I$0 = r1
            r6.label = r2
            java.lang.Object r7 = r4.b(r7, r6)
            if (r7 != r0) goto L_0x007a
            return r0
        L_0x007a:
            r7 = r4
            goto L_0x0085
        L_0x007c:
            if (r7 > 0) goto L_0x0083
            kotlin.jvm.internal.Ref$BooleanRef r5 = r6.$endFound
            r5.element = r3
            int r7 = -r7
        L_0x0083:
            int r1 = r1 + r7
            goto L_0x007a
        L_0x0085:
            java.nio.ByteBuffer r4 = r6.$dst
            boolean r4 = r4.hasRemaining()
            if (r4 == 0) goto L_0x0093
            kotlin.jvm.internal.Ref$BooleanRef r4 = r6.$endFound
            boolean r4 = r4.element
            if (r4 == 0) goto L_0x0033
        L_0x0093:
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$copied$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

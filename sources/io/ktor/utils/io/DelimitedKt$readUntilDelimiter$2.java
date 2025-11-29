package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/LookAheadSession;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class DelimitedKt$readUntilDelimiter$2 extends Lambda implements Function1<LookAheadSession, Unit> {
    final /* synthetic */ Ref.IntRef $copied;
    final /* synthetic */ ByteBuffer $delimiter;
    final /* synthetic */ ByteBuffer $dst;
    final /* synthetic */ Ref.BooleanRef $endFound;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DelimitedKt$readUntilDelimiter$2(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, Ref.BooleanRef booleanRef, Ref.IntRef intRef) {
        super(1);
        this.$delimiter = byteBuffer;
        this.$dst = byteBuffer2;
        this.$endFound = booleanRef;
        this.$copied = intRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LookAheadSession) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x000f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull io.ktor.utils.io.LookAheadSession r4) {
        /*
            r3 = this;
            java.lang.String r0 = "$this$lookAhead"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
        L_0x0005:
            java.nio.ByteBuffer r0 = r3.$delimiter
            java.nio.ByteBuffer r1 = r3.$dst
            int r0 = io.ktor.utils.io.DelimitedKt.g(r4, r0, r1)
            if (r0 == 0) goto L_0x002c
            if (r0 >= 0) goto L_0x0017
            kotlin.jvm.internal.Ref$BooleanRef r1 = r3.$endFound
            r2 = 1
            r1.element = r2
            int r0 = -r0
        L_0x0017:
            kotlin.jvm.internal.Ref$IntRef r1 = r3.$copied
            int r2 = r1.element
            int r2 = r2 + r0
            r1.element = r2
            java.nio.ByteBuffer r0 = r3.$dst
            boolean r0 = r0.hasRemaining()
            if (r0 == 0) goto L_0x002c
            kotlin.jvm.internal.Ref$BooleanRef r0 = r3.$endFound
            boolean r0 = r0.element
            if (r0 == 0) goto L_0x0005
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.DelimitedKt$readUntilDelimiter$2.invoke(io.ktor.utils.io.LookAheadSession):void");
    }
}

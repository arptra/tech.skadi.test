package com.upuphone.ar.tici.phone.starrynet.msg;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "", "invoke", "([Ljava/lang/Integer;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class OpenTiciMsgReplyV2$toString$1 extends Lambda implements Function1<Integer[], CharSequence> {
    public static final OpenTiciMsgReplyV2$toString$1 INSTANCE = new OpenTiciMsgReplyV2$toString$1();

    public OpenTiciMsgReplyV2$toString$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "it");
        String arrays = Arrays.toString(numArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
        return arrays;
    }
}

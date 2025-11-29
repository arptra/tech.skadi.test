package com.upuphone.xr.interconnect.util.log;

import com.google.protobuf.ByteString;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PayloadLoggingKt$appendSize$2 extends Lambda implements Function1<String, String> {
    final /* synthetic */ ByteString $this_appendSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PayloadLoggingKt$appendSize$2(ByteString byteString) {
        super(1);
        this.$this_appendSize = byteString;
    }

    @NotNull
    public final String invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$null");
        return PayloadLoggingKt.appendSize(str, this.$this_appendSize.size());
    }
}

package com.example.flutter_pag_plugin;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "byteArray", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class DataLoadHelper$loadPag$3$1 extends Lambda implements Function2<byte[], String, Unit> {
    final /* synthetic */ Function1<byte[], Unit> $addPag;
    final /* synthetic */ int $from;
    final /* synthetic */ String $src;
    final /* synthetic */ long $time;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataLoadHelper$loadPag$3$1(Function1<? super byte[], Unit> function1, String str, long j, int i) {
        super(2);
        this.$addPag = function1;
        this.$src = str;
        this.$time = j;
        this.$from = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((byte[]) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable byte[] bArr, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "errorMsg");
        this.$addPag.invoke(bArr);
        List<ILoadListener> b = DataLoadHelper.d;
        String str2 = this.$src;
        long j = this.$time;
        int i = this.$from;
        for (ILoadListener a2 : b) {
            a2.a(str2, bArr, System.currentTimeMillis() - j, str, i);
        }
    }
}

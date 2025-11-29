package com.upuphone.xr.sapp.monitor.starry;

import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nStarryMessageHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StarryMessageHelper.kt\ncom/upuphone/xr/sapp/monitor/starry/StarryMessageHelper$1$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,267:1\n1855#2,2:268\n*S KotlinDebug\n*F\n+ 1 StarryMessageHelper.kt\ncom/upuphone/xr/sapp/monitor/starry/StarryMessageHelper$1$3\n*L\n48#1:268,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "version", "", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class StarryMessageHelper$1$3 extends Lambda implements Function1<Integer, Unit> {
    public static final StarryMessageHelper$1$3 INSTANCE = new StarryMessageHelper$1$3();

    public StarryMessageHelper$1$3() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Integer num) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("StarryMessageHelper", "operatorManager peerVersion: " + num);
        for (Function1 invoke : StarryMessageHelper.e) {
            invoke.invoke(num);
        }
    }
}

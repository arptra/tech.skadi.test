package com.xjmz.myvu.dialog.starrynet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "clickValue", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class StarryNetConnectDialog$setDeviceConnectUI$buildAgreementClickSpan$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ String $anchor;
    final /* synthetic */ int $windowType;
    final /* synthetic */ StarryNetConnectDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarryNetConnectDialog$setDeviceConnectUI$buildAgreementClickSpan$1(String str, StarryNetConnectDialog starryNetConnectDialog, int i) {
        super(1);
        this.$anchor = str;
        this.this$0 = starryNetConnectDialog;
        this.$windowType = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "clickValue");
        if (Intrinsics.areEqual((Object) this.$anchor, (Object) str)) {
            ConnectDeviceInterFace k = this.this$0.b;
            if (k != null) {
                k.c(this.$windowType, "TYPE_ONE");
                return;
            }
            return;
        }
        ConnectDeviceInterFace k2 = this.this$0.b;
        if (k2 != null) {
            k2.c(this.$windowType, "TYPE_TWO");
        }
    }
}

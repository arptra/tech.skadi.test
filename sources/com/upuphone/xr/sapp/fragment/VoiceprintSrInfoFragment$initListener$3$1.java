package com.upuphone.xr.sapp.fragment;

import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VoiceprintSrInfoFragment$initListener$3$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ VoiceprintSrInfoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceprintSrInfoFragment$initListener$3$1(VoiceprintSrInfoFragment voiceprintSrInfoFragment) {
        super(1);
        this.this$0 = voiceprintSrInfoFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("VoiceprintSrInfoFragment", "requestPermission record result=" + z);
        if (z) {
            this.this$0.W0();
        }
    }
}

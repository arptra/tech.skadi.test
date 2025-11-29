package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.vm.RoleVprintViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "audioData", "Lcom/upuphone/xr/sapp/vm/RoleVprintViewModel$AudioData;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VoiceprintSrRecordFragment$initViewModels$3 extends Lambda implements Function1<RoleVprintViewModel.AudioData, Unit> {
    final /* synthetic */ VoiceprintSrRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceprintSrRecordFragment$initViewModels$3(VoiceprintSrRecordFragment voiceprintSrRecordFragment) {
        super(1);
        this.this$0 = voiceprintSrRecordFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RoleVprintViewModel.AudioData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(RoleVprintViewModel.AudioData audioData) {
        int b = audioData.b();
        if (b == 1) {
            byte[] a2 = audioData.a();
            if (a2 != null) {
                VoiceprintSrRecordFragment voiceprintSrRecordFragment = this.this$0;
                voiceprintSrRecordFragment.m = ArraysKt.plus(voiceprintSrRecordFragment.m, a2);
                voiceprintSrRecordFragment.e1().Z(a2);
            }
        } else if (b == 2) {
            VoiceprintSrRecordFragment.s1(this.this$0, false, 1, (Object) null);
        }
    }
}

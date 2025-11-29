package com.upuphone.xr.sapp.fragment;

import androidx.fragment.app.FragmentActivity;
import com.upuphone.xr.sapp.RoleVprintActivity;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VoiceprintSrInfoFragment$initListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VoiceprintSrInfoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceprintSrInfoFragment$initListener$1(VoiceprintSrInfoFragment voiceprintSrInfoFragment) {
        super(0);
        this.this$0 = voiceprintSrInfoFragment;
    }

    public final void invoke() {
        Unit unit;
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            VoiceprintSrInfoFragment voiceprintSrInfoFragment = this.this$0;
            if (activity instanceof RoleVprintActivity) {
                activity.finish();
            } else {
                StaticMethodUtilsKt.q(voiceprintSrInfoFragment);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            StaticMethodUtilsKt.q(this.this$0);
        }
    }
}

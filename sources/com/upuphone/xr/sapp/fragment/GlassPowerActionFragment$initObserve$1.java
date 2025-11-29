package com.upuphone.xr.sapp.fragment;

import com.meizu.common.app.LoadingDialog;
import com.upuphone.xr.sapp.databinding.FragmentGlassPowerActionBinding;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassPowerActionFragment$initObserve$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ GlassPowerActionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassPowerActionFragment$initObserve$1(GlassPowerActionFragment glassPowerActionFragment) {
        super(1);
        this.this$0 = glassPowerActionFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        FragmentGlassPowerActionBinding F0 = this.this$0.j;
        FragmentGlassPowerActionBinding fragmentGlassPowerActionBinding = null;
        if (F0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            F0 = null;
        }
        F0.c.setChecked(false);
        FragmentGlassPowerActionBinding F02 = this.this$0.j;
        if (F02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            F02 = null;
        }
        F02.e.setChecked(false);
        FragmentGlassPowerActionBinding F03 = this.this$0.j;
        if (F03 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            F03 = null;
        }
        F03.f.setChecked(false);
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -312782418) {
                if (hashCode != 465806113) {
                    if (hashCode == 1640777725 && str.equals(AssistantConstants.PKG_NAME_TRANSLATION)) {
                        FragmentGlassPowerActionBinding F04 = this.this$0.j;
                        if (F04 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            fragmentGlassPowerActionBinding = F04;
                        }
                        fragmentGlassPowerActionBinding.e.setChecked(true);
                    }
                } else if (str.equals("com.upuphone.ar.transcribe.glasses")) {
                    FragmentGlassPowerActionBinding F05 = this.this$0.j;
                    if (F05 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentGlassPowerActionBinding = F05;
                    }
                    fragmentGlassPowerActionBinding.f.setChecked(true);
                }
            } else if (str.equals("com.upuphone.ar.recorder")) {
                FragmentGlassPowerActionBinding F06 = this.this$0.j;
                if (F06 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentGlassPowerActionBinding = F06;
                }
                fragmentGlassPowerActionBinding.c.setChecked(true);
            }
        }
        LoadingDialog G0 = this.this$0.m;
        if (G0 != null) {
            G0.dismiss();
        }
    }
}

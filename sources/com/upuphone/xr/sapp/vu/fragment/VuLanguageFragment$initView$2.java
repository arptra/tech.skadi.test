package com.upuphone.xr.sapp.vu.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuLanguageFragment$initView$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ VuLanguageFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuLanguageFragment$initView$2(VuLanguageFragment vuLanguageFragment) {
        super(1);
        this.this$0 = vuLanguageFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        VuLanguageFragment vuLanguageFragment = this.this$0;
        Intrinsics.checkNotNull(str);
        vuLanguageFragment.O0(str);
    }
}

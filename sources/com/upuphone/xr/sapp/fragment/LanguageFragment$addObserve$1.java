package com.upuphone.xr.sapp.fragment;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.adapter.LanguageAdapter;
import com.upuphone.xr.sapp.entity.LanguageMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nLanguageFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LanguageFragment.kt\ncom/upuphone/xr/sapp/fragment/LanguageFragment$addObserve$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,265:1\n1855#2,2:266\n*S KotlinDebug\n*F\n+ 1 LanguageFragment.kt\ncom/upuphone/xr/sapp/fragment/LanguageFragment$addObserve$1\n*L\n94#1:266,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class LanguageFragment$addObserve$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ LanguageFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LanguageFragment$addObserve$1(LanguageFragment languageFragment) {
        super(1);
        this.this$0 = languageFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("LanguageFragment", "viewModel.glassLanguage " + str);
        this.this$0.P0();
        List<LanguageMode> L0 = this.this$0.q;
        if (L0 != null) {
            for (LanguageMode languageMode : L0) {
                languageMode.setSelectState(Intrinsics.areEqual((Object) languageMode.getLanguage(), (Object) str));
            }
        }
        LanguageAdapter K0 = this.this$0.r;
        if (K0 != null) {
            K0.notifyDataSetChanged();
        }
    }
}

package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.databinding.FragmentGlassManagerBinding;
import com.upuphone.xr.sapp.entity.LanguageMode;
import com.upuphone.xr.sapp.utils.LanguageHelper;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nGlassManagerFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassManagerFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassManagerFragment$addObserve$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,770:1\n288#2,2:771\n*S KotlinDebug\n*F\n+ 1 GlassManagerFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassManagerFragment$addObserve$3\n*L\n135#1:771,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassManagerFragment$addObserve$3 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ GlassManagerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassManagerFragment$addObserve$3(GlassManagerFragment glassManagerFragment) {
        super(1);
        this.this$0 = glassManagerFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        FragmentGlassManagerBinding fragmentGlassManagerBinding;
        Object obj;
        Iterator it = LanguageHelper.f7894a.a().iterator();
        while (true) {
            fragmentGlassManagerBinding = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((LanguageMode) obj).getLanguage(), (Object) str)) {
                break;
            }
        }
        LanguageMode languageMode = (LanguageMode) obj;
        if (languageMode != null) {
            FragmentGlassManagerBinding W0 = this.this$0.j;
            if (W0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentGlassManagerBinding = W0;
            }
            fragmentGlassManagerBinding.k.setCardSubTitle(this.this$0.getString(languageMode.getLanguageStrId()));
        }
    }
}

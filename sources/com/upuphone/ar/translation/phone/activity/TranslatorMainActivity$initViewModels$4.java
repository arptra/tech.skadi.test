package com.upuphone.ar.translation.phone.activity;

import android.view.View;
import androidx.constraintlayout.widget.Group;
import com.upuphone.ar.translation.phone.view.TransTitleBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTranslatorMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslatorMainActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorMainActivity$initViewModels$4\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,606:1\n262#2,2:607\n262#2,2:609\n262#2,2:611\n*S KotlinDebug\n*F\n+ 1 TranslatorMainActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorMainActivity$initViewModels$4\n*L\n246#1:607,2\n247#1:609,2\n249#1:611,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslatorMainActivity$initViewModels$4 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ TranslatorMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorMainActivity$initViewModels$4(TranslatorMainActivity translatorMainActivity) {
        super(1);
        this.this$0 = translatorMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean bool) {
        Group group = this.this$0.getMBinding().h;
        Intrinsics.checkNotNullExpressionValue(group, "gpMulti");
        Intrinsics.checkNotNull(bool);
        int i = 8;
        group.setVisibility(bool.booleanValue() ? 0 : 8);
        TransTitleBar transTitleBar = this.this$0.getMBinding().p;
        Intrinsics.checkNotNullExpressionValue(transTitleBar, "titleBar");
        transTitleBar.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
        View view = this.this$0.getMBinding().v;
        Intrinsics.checkNotNullExpressionValue(view, "vTabDisable");
        if (bool.booleanValue()) {
            i = 0;
        }
        view.setVisibility(i);
        this.this$0.getMBinding().x.setUserInputEnabled(!bool.booleanValue());
        this.this$0.getMBinding().n.setFuncEnabled(!bool.booleanValue());
        this.this$0.getMBinding().m.setFuncEnabled(!bool.booleanValue());
    }
}

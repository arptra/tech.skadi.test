package com.upuphone.xr.sapp.contract;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/contract/AppUserGuideDialogController$buildKoreanSpanStringMoreDetail$clickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppUserGuideDialogController$buildKoreanSpanStringMoreDetail$clickableSpan$1 extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f6678a;
    public final /* synthetic */ AppUserGuideDialogController b;

    public AppUserGuideDialogController$buildKoreanSpanStringMoreDetail$clickableSpan$1(boolean z, AppUserGuideDialogController appUserGuideDialogController) {
        this.f6678a = z;
        this.b = appUserGuideDialogController;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        if (this.f6678a) {
            ContractEntry.t(ContractEntry.f6691a, this.b.f6676a, ProtocolType.CATEGORY_PP, (String) null, true, 4, (Object) null);
        } else {
            ContractEntry.t(ContractEntry.f6691a, this.b.f6676a, ProtocolType.CATEGORY_PP, (String) null, false, 4, (Object) null);
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setColor(MainApplication.k.f().getColor(R.color.secondary_text_color));
    }
}

package com.upuphone.xr.sapp.contract;

import com.upuphone.xr.sapp.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AppUserGuideDialogController$privacyPolicy$2 extends Lambda implements Function0<String> {
    final /* synthetic */ AppUserGuideDialogController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppUserGuideDialogController$privacyPolicy$2(AppUserGuideDialogController appUserGuideDialogController) {
        super(0);
        this.this$0 = appUserGuideDialogController;
    }

    @NotNull
    public final String invoke() {
        return this.this$0.f6676a.getString(R.string.superapp_privacy_policy);
    }
}

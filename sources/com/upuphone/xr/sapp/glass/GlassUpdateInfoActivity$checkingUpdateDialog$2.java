package com.upuphone.xr.sapp.glass;

import com.meizu.common.app.LoadingDialog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.LoadingDialogUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/meizu/common/app/LoadingDialog;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassUpdateInfoActivity$checkingUpdateDialog$2 extends Lambda implements Function0<LoadingDialog> {
    final /* synthetic */ GlassUpdateInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateInfoActivity$checkingUpdateDialog$2(GlassUpdateInfoActivity glassUpdateInfoActivity) {
        super(0);
        this.this$0 = glassUpdateInfoActivity;
    }

    @NotNull
    public final LoadingDialog invoke() {
        return LoadingDialogUtils.b(LoadingDialogUtils.f7895a, this.this$0, R.string.checking_update, 0, 0, false, 28, (Object) null);
    }
}

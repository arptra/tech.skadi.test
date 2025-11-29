package com.upuphone.xr.sapp.utils;

import android.content.Context;
import androidx.appcompat.content.res.AppCompatResources;
import com.meizu.common.app.LoadingDialog;
import com.upuphone.xr.sapp.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/utils/LoadingDialogUtils;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "msgRes", "msgTextColorRes", "backgroundRes", "", "isCancelable", "Lcom/meizu/common/app/LoadingDialog;", "a", "(Landroid/content/Context;IIIZ)Lcom/meizu/common/app/LoadingDialog;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LoadingDialogUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final LoadingDialogUtils f7895a = new LoadingDialogUtils();

    public static /* synthetic */ LoadingDialog b(LoadingDialogUtils loadingDialogUtils, Context context, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = R.color.text_loading_dialog;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = R.drawable.shape_loading_dialog_bg;
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            z = false;
        }
        return loadingDialogUtils.a(context, i, i5, i6, z);
    }

    public final LoadingDialog a(Context context, int i, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        LoadingDialog loadingDialog = new LoadingDialog(context, R.style.LoadingDialog);
        loadingDialog.setMessage(i);
        loadingDialog.setMessageTextColorResource(i2);
        loadingDialog.setBackgroundDrawable(AppCompatResources.b(context, i3));
        loadingDialog.setDimAmount(0.6f);
        loadingDialog.setCancelable(z);
        return loadingDialog;
    }
}

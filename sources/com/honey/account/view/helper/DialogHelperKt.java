package com.honey.account.view.helper;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.honey.account.R;
import com.honey.account.utils.system.SystemUtilsKt;
import com.honey.account.view.AccountAlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aF\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"DIALOG_DISTANCE_DP", "", "showAccountDialog", "Lcom/honey/account/view/AccountAlertDialog;", "activity", "Landroid/app/Activity;", "title", "", "contentView", "Landroid/view/View;", "cancel", "ok", "cancelListener", "Landroid/view/View$OnClickListener;", "okListener", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DialogHelperKt {
    private static final float DIALOG_DISTANCE_DP = 18.0f;

    @NotNull
    public static final AccountAlertDialog showAccountDialog(@NotNull Activity activity, @NotNull String str, @Nullable View view, @Nullable String str2, @NotNull String str3, @Nullable View.OnClickListener onClickListener, @Nullable View.OnClickListener onClickListener2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str3, "ok");
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_utils, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        View findViewById2 = inflate.findViewById(R.id.fl_content);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        FrameLayout frameLayout = (FrameLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.bt_dialog_cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        Button button = (Button) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.bt_dialog_ok);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        Button button2 = (Button) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.bt_success_ok);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        Button button3 = (Button) findViewById5;
        ((TextView) findViewById).setText(str);
        if (view == null) {
            frameLayout.setVisibility(8);
        } else {
            frameLayout.setVisibility(0);
            frameLayout.addView(view);
        }
        if (str2 == null) {
            button3.setVisibility(0);
            button3.setText(str3);
            button.setVisibility(8);
            button2.setVisibility(8);
            button3.setOnClickListener(onClickListener2);
        } else {
            button3.setVisibility(8);
            button.setVisibility(0);
            button2.setVisibility(0);
            button.setText(str2);
            button.setOnClickListener(onClickListener);
            button2.setOnClickListener(onClickListener2);
            button2.setText(str3);
        }
        AccountAlertDialog accountAlertDialog = new AccountAlertDialog(activity, R.style.SimpleDialog);
        accountAlertDialog.setView(inflate);
        accountAlertDialog.show();
        Window window = accountAlertDialog.getWindow();
        if (window == null) {
            return accountAlertDialog;
        }
        window.setBackgroundDrawableResource(R.drawable.ha_dialog_round);
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        int dp2px = SystemUtilsKt.dp2px(applicationContext, DIALOG_DISTANCE_DP);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            attributes.gravity = 80;
        }
        if (attributes != null) {
            attributes.y = dp2px;
        }
        if (attributes != null) {
            attributes.width = activity.getWindowManager().getDefaultDisplay().getWidth() - (dp2px * 2);
        }
        window.setAttributes(attributes);
        return accountAlertDialog;
    }
}

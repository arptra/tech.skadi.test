package com.meizu.common.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.meizu.common.R;

public class LoadingAlertDialog extends AlertDialog {
    private ViewGroup mApplyContentLayout;
    private LoadingAnimationView mLoadingAnimationView;
    private TextView mTitle;

    public LoadingAlertDialog(Context context) {
        super(context);
        create();
    }

    public void cancelDialog() {
        this.mApplyContentLayout.setVisibility(4);
        cancel();
    }

    public void hideDialog() {
        this.mApplyContentLayout.setVisibility(4);
        hide();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.7f;
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.mc_loading_alert));
        setContentView(R.layout.loading_alert_dialog);
        this.mApplyContentLayout = (ViewGroup) findViewById(R.id.rootLayout);
        this.mLoadingAnimationView = (LoadingAnimationView) findViewById(R.id.applyAnimView);
        this.mTitle = (TextView) findViewById(R.id.applyAnimTitle);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    public void setMessage(CharSequence charSequence) {
        TextView textView = this.mTitle;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void showDialog() {
        show();
        this.mApplyContentLayout.setVisibility(0);
    }

    public LoadingAlertDialog(Context context, int i) {
        super(context, i);
    }
}

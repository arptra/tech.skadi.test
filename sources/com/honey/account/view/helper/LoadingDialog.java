package com.honey.account.view.helper;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.honey.account.R;
import com.honey.account.utils.reflect.ReflectUtils;

public class LoadingDialog extends Dialog {
    private boolean isCancelable;
    private int mAnimationViewVisibility;
    private Drawable mBackground;
    private LinearLayout mContainerLayout;
    private Context mContext;
    private float mDimAmount;
    private SwimmingAnimationView mLoadingAnimationView;
    private CharSequence mMessage;
    private TextView mMessageView;
    private int mTextColor;
    private Window mWindow;

    public LoadingDialog(Context context) {
        this(context, R.style.HaLoadingDialogTheme);
    }

    private void initView() {
        this.mContainerLayout = (LinearLayout) findViewById(R.id.rootLayout);
        this.mLoadingAnimationView = (SwimmingAnimationView) findViewById(R.id.applyAnimView);
        this.mMessageView = (TextView) findViewById(R.id.applyAnimTitle);
        updateMessageView();
        updateAnimationView();
    }

    public static LoadingDialog show(Context context, CharSequence charSequence, CharSequence charSequence2) {
        return show(context, charSequence, charSequence2, false);
    }

    private void updateAnimationView() {
        SwimmingAnimationView swimmingAnimationView = this.mLoadingAnimationView;
        if (swimmingAnimationView != null) {
            swimmingAnimationView.setVisibility(this.mAnimationViewVisibility);
        }
    }

    private void updateMessageView() {
        if (this.mMessageView == null) {
            return;
        }
        if (TextUtils.isEmpty(this.mMessage)) {
            this.mMessageView.setVisibility(8);
            return;
        }
        this.mMessageView.setVisibility(0);
        this.mMessageView.setText(this.mMessage);
        this.mMessageView.setTextColor(this.mTextColor);
    }

    public boolean isCancelable() {
        return this.isCancelable;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        this.mWindow = window;
        if (window != null) {
            window.requestFeature(1);
            this.mWindow.setDimAmount(this.mDimAmount);
            this.mWindow.setBackgroundDrawable(this.mBackground);
            this.mWindow.getDecorView().setSystemUiVisibility(8192);
            try {
                WindowManager.LayoutParams attributes = this.mWindow.getAttributes();
                ReflectUtils.from((Object) attributes).field("statusBarColor").set(attributes, -16777216);
                this.mWindow.setAttributes(attributes);
            } catch (Exception e) {
                Log.w("LoadingDialog", "statusBarColor set failed, " + e.getMessage());
            }
        }
        setContentView(R.layout.dialog_loading);
        initView();
    }

    public void onStart() {
        super.onStart();
        Log.d("LoadingDialog", "onStart");
        this.mLoadingAnimationView.startAnimator();
    }

    public void onStop() {
        super.onStop();
        Log.d("LoadingDialog", "onStop");
        this.mLoadingAnimationView.stopAnimator();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mBackground = drawable;
        Window window = this.mWindow;
        if (window != null) {
            window.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundDrawableResource(int i) {
        setBackgroundDrawable(this.mContext.getResources().getDrawable(i));
    }

    @Deprecated
    public void setBarBackground(int i) {
    }

    @Deprecated
    public void setBarForeground(int i) {
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.isCancelable = z;
    }

    public void setDimAmount(float f) {
        this.mDimAmount = f;
        Window window = this.mWindow;
        if (window != null) {
            window.setDimAmount(f);
        }
    }

    public void setLoadingAnimationViewVisibility(int i) {
        this.mAnimationViewVisibility = i;
        updateAnimationView();
    }

    public void setMessage(int i) {
        setMessage((CharSequence) this.mContext.getResources().getString(i));
    }

    public void setMessageTextColor(int i) {
        this.mTextColor = i;
        updateMessageView();
    }

    public void setMessageTextColorResource(int i) {
        setMessageTextColor(this.mContext.getResources().getColor(i));
    }

    public LoadingDialog(Context context, int i) {
        super(context, i);
        this.isCancelable = true;
        this.mTextColor = -16777216;
        this.mDimAmount = 0.2f;
        this.mAnimationViewVisibility = 0;
        Context context2 = getContext();
        this.mContext = context2;
        this.mBackground = context2.getResources().getDrawable(R.drawable.ha_loading_alert);
    }

    public static LoadingDialog show(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return show(context, charSequence, charSequence2, z, (DialogInterface.OnCancelListener) null);
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence;
        updateMessageView();
    }

    public static LoadingDialog show(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        LoadingDialog loadingDialog = new LoadingDialog(context);
        loadingDialog.setTitle(charSequence);
        loadingDialog.setMessage(charSequence2);
        loadingDialog.setCancelable(z);
        loadingDialog.setOnCancelListener(onCancelListener);
        loadingDialog.show();
        return loadingDialog;
    }
}

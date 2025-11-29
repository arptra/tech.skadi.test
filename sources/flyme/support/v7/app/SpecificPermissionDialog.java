package flyme.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import flyme.support.v7.app.AlertDialog;
import flyme.support.v7.appcompat.R;

public class SpecificPermissionDialog {
    /* access modifiers changed from: private */
    public Builder builder;
    private boolean mCancelable = false;
    /* access modifiers changed from: private */
    public AlertDialog mDialog;
    private DialogInterface.OnDismissListener mDismissListener;

    public static class Builder {
        /* access modifiers changed from: private */
        public String checkBoxText;
        /* access modifiers changed from: private */
        public Boolean forceChecked = Boolean.TRUE;
        /* access modifiers changed from: private */
        public Boolean hideCheckBox = Boolean.FALSE;
        /* access modifiers changed from: private */
        public String negativeButtonText;
        /* access modifiers changed from: private */
        public String permission;
        /* access modifiers changed from: private */
        public String positiveButtonText;
        /* access modifiers changed from: private */
        public String summary;
        /* access modifiers changed from: private */
        public String title;

        public SpecificPermissionDialog build() {
            return new SpecificPermissionDialog(this);
        }

        public Builder hideCheckBox(boolean z) {
            this.hideCheckBox = Boolean.valueOf(z);
            return this;
        }

        public Builder setCheckBoxText(String str) {
            this.checkBoxText = str;
            return this;
        }

        public Builder setForceChecked(boolean z) {
            this.forceChecked = Boolean.valueOf(z);
            return this;
        }

        public Builder setNegativeButtonText(String str) {
            this.negativeButtonText = str;
            return this;
        }

        public Builder setPermission(String str) {
            this.permission = str;
            return this;
        }

        public Builder setPositiveButtonText(String str) {
            this.positiveButtonText = str;
            return this;
        }

        public Builder setSummary(String str) {
            this.summary = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }
    }

    public interface PermissionDialogCallBack {
        void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z2, String str);
    }

    public SpecificPermissionDialog(Builder builder2) {
        this.builder = builder2;
    }

    private void contentViewAdapterGravity(final LinearLayout linearLayout, final TextView textView) {
        if (textView != null && textView.getVisibility() == 0 && !TextUtils.isEmpty(textView.getText())) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    AlertController alertController = SpecificPermissionDialog.this.mDialog.getAlertController();
                    TextView titleView = alertController instanceof FlymeAlertController ? ((FlymeAlertController) alertController).getTitleView() : null;
                    int i = 8388611;
                    if (titleView == null || titleView.getLineCount() <= 1) {
                        int lineCount = textView.getLineCount();
                        LinearLayout linearLayout = linearLayout;
                        if (lineCount <= 1) {
                            i = 17;
                        }
                        linearLayout.setGravity(i);
                        return;
                    }
                    linearLayout.setGravity(8388611);
                }
            });
        }
    }

    public void dismiss() {
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    public boolean isShowing() {
        AlertDialog alertDialog = this.mDialog;
        return alertDialog != null && alertDialog.isShowing();
    }

    public void setCancelable(boolean z) {
        this.mCancelable = z;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mDismissListener = onDismissListener;
    }

    public void show(Context context, final PermissionDialogCallBack permissionDialogCallBack) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.mz_specific_permission_dialog, (ViewGroup) null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.mz_specific_permission_dialog_summary);
        final CheckBox checkBox = (CheckBox) linearLayout.findViewById(R.id.mz_specific_permission_dialog_checkbox);
        textView.setText(this.builder.summary);
        contentViewAdapterGravity(linearLayout, textView);
        this.mDialog = new AlertDialog.Builder(context).setTitle((CharSequence) this.builder.title).setView((View) linearLayout).setCancelable(this.mCancelable).setPositiveButton((CharSequence) TextUtils.isEmpty(this.builder.positiveButtonText) ? context.getResources().getString(R.string.mz_specific_permission_allow) : this.builder.positiveButtonText, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                PermissionDialogCallBack permissionDialogCallBack = permissionDialogCallBack;
                if (permissionDialogCallBack != null) {
                    permissionDialogCallBack.onPermissionClick(dialogInterface, checkBox.isChecked(), true, SpecificPermissionDialog.this.builder.permission);
                }
            }
        }).setNegativeButton((CharSequence) TextUtils.isEmpty(this.builder.negativeButtonText) ? context.getResources().getString(R.string.mz_specific_permission_deny) : this.builder.negativeButtonText, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                PermissionDialogCallBack permissionDialogCallBack = permissionDialogCallBack;
                if (permissionDialogCallBack != null) {
                    permissionDialogCallBack.onPermissionClick(dialogInterface, checkBox.isChecked(), false, SpecificPermissionDialog.this.builder.permission);
                }
            }
        }).setHighLightButton(-1, 0).setOnDismissListener(this.mDismissListener).create();
        if (this.builder.hideCheckBox.booleanValue()) {
            checkBox.setVisibility(8);
            this.mDialog.show();
            return;
        }
        if (!TextUtils.isEmpty(this.builder.checkBoxText)) {
            checkBox.setText(this.builder.checkBoxText);
        }
        if (this.builder.forceChecked.booleanValue()) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    SpecificPermissionDialog.this.mDialog.getButton(-1).setEnabled(!z);
                }
            });
        }
        this.mDialog.show();
    }
}

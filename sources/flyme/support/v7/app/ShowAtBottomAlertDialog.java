package flyme.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import flyme.support.v7.app.AlertDialog;
import flyme.support.v7.appcompat.R;

public class ShowAtBottomAlertDialog extends AlertDialog {

    public static class Builder extends AlertDialog.Builder {

        public static class OnNegativeListener implements DialogInterface.OnClickListener {
            private OnNegativeListener() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null) {
                    try {
                        dialogInterface.dismiss();
                    } catch (Exception unused) {
                    }
                }
            }
        }

        public Builder(Context context) {
            super(context, R.style.Theme_Flyme_AppCompat_Light_Dialog_Alert_ShowAtBottom);
        }

        @Deprecated
        public Builder setNavigationBarColor(@ColorInt int i) {
            return this;
        }

        @Deprecated
        public Builder setNightModeColor(int i) {
            return this;
        }

        public Builder(@NonNull Context context, int i) {
            super(context, i);
        }

        public ShowAtBottomAlertDialog create() {
            setNegativeButton(com.meizu.common.R.string.mc_cancel, (DialogInterface.OnClickListener) new OnNegativeListener());
            return (ShowAtBottomAlertDialog) create(new AlertDialog.Builder.DialogFactory<ShowAtBottomAlertDialog>() {
                public ShowAtBottomAlertDialog newDialog(@NonNull Context context, int i) {
                    return new ShowAtBottomAlertDialog(context, i);
                }
            });
        }

        public Builder setTitle(int i) {
            super.setTitle(i);
            return this;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            super.setTitle(charSequence);
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener, boolean z, ColorStateList[] colorStateListArr) {
            super.setItems(i, onClickListener, z, colorStateListArr);
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener, boolean z, ColorStateList colorStateList) {
            super.setItems(i, onClickListener, z, colorStateList);
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener, boolean z) {
            super.setItems(charSequenceArr, onClickListener, z);
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener, boolean z) {
            super.setItems(i, onClickListener, z);
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener, boolean z, ColorStateList colorStateList) {
            super.setItems(charSequenceArr, onClickListener, z, colorStateList);
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener, boolean z, ColorStateList[] colorStateListArr) {
            super.setItems(charSequenceArr, onClickListener, z, colorStateListArr);
            return this;
        }
    }

    public ShowAtBottomAlertDialog(Context context) {
        super(context);
    }

    @Deprecated
    public void setContinueShowBottomDialog(boolean z) {
    }

    @Deprecated
    public void setNavigationBarColor(@ColorInt int i) {
    }

    public ShowAtBottomAlertDialog(Context context, int i) {
        super(context, i);
    }

    public ShowAtBottomAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }
}

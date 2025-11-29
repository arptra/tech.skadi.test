package flyme.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import flyme.support.v7.app.PermissionDialogBuilder;
import flyme.support.v7.permission.PermissionGroup;
import java.util.List;
import java.util.Map;

public class PermissionDialogView extends RelativeLayout {
    private final PermissionViewHandler mViewHandler;

    public static class Builder {
        Activity activity;
        List<Pair<String, String>> additionalGroups;
        String appName;
        CharSequence csReminder;
        boolean isDark;
        boolean isIntl;
        boolean mShowTitle = true;
        String message;
        String[] permissionReasons;
        String[] permissions;
        String reminder;
        boolean showAlmostDenyBtn;

        public void build(PermissionDialogView permissionDialogView) {
            permissionDialogView.setPermissionDialogBuild(this);
        }

        public Builder isIntl(boolean z) {
            this.isIntl = z;
            return this;
        }

        public Builder setActivity(Activity activity2) {
            this.activity = activity2;
            return this;
        }

        public Builder setAdditionalGroups(List<Pair<String, String>> list) {
            this.additionalGroups = list;
            return this;
        }

        public Builder setAppName(@NonNull String str) {
            this.appName = str;
            return this;
        }

        public Builder setCsReminder(@NonNull CharSequence charSequence) {
            this.csReminder = charSequence;
            return this;
        }

        public Builder setDark(boolean z) {
            this.isDark = z;
            return this;
        }

        public Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        public Builder setPermission(@NonNull String[] strArr, @NonNull String[] strArr2) {
            this.permissions = strArr;
            this.permissionReasons = strArr2;
            return this;
        }

        public Builder setReminder(@NonNull String str) {
            this.reminder = str;
            return this;
        }

        public Builder setShowAlmostDenyBtn(boolean z) {
            this.showAlmostDenyBtn = z;
            return this;
        }

        public Builder setShowTitle(boolean z) {
            this.mShowTitle = z;
            return this;
        }

        @Deprecated
        public Builder setTheme(int i) {
            return this;
        }
    }

    public PermissionDialogView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CheckBox getCheckBox() {
        return this.mViewHandler.getCheckBox();
    }

    public Map<String, Boolean> getItemCheckedMap() {
        PermissionViewHandler permissionViewHandler = this.mViewHandler;
        if (permissionViewHandler instanceof PermissionViewHandlerImpl23) {
            return ((PermissionViewHandlerImpl23) permissionViewHandler).getItemCheckedMap();
        }
        return null;
    }

    public List<PermissionGroup> getPermissions() {
        return this.mViewHandler.getPermissions();
    }

    public TextView getTermsView() {
        return this.mViewHandler.getTermsView();
    }

    public void setPermissionDialogBuild(Builder builder) {
        this.mViewHandler.bindData(builder);
    }

    public PermissionDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PermissionDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (PermissionDialogBuilder.sOldPermissionDialog) {
            this.mViewHandler = new PermissionViewHandlerImpl(context);
        } else {
            this.mViewHandler = new PermissionViewHandlerImpl23(context);
        }
        addView(this.mViewHandler.createView(this));
    }
}

package flyme.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import flyme.support.v7.app.AlertDialog;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.permission.Permission;
import flyme.support.v7.permission.PermissionGroup;
import flyme.support.v7.permission.PermissionManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SecondaryConfirmationPermissionDialog {
    private Builder builder;

    public static class Builder {
        /* access modifiers changed from: private */
        public String[] permission;
        /* access modifiers changed from: private */
        public String title;

        public SecondaryConfirmationPermissionDialog build() {
            return new SecondaryConfirmationPermissionDialog(this);
        }

        public Builder setPermission(String[] strArr) {
            this.permission = strArr;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }
    }

    public interface PermissionDialogCallBack {
        void onPermissionClick(DialogInterface dialogInterface, boolean z);
    }

    public SecondaryConfirmationPermissionDialog(Builder builder2) {
        this.builder = builder2;
    }

    private String buildSummary(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getString(R.string.mz_permission_inform_secondary_confirmation_summary));
        ArrayList arrayList = new ArrayList();
        for (String add : this.builder.permission) {
            arrayList.add(add);
        }
        List<PermissionGroup> requestPermission = PermissionManager.getInstance(context).getRequestPermission(this.builder.permission, false);
        for (PermissionGroup next : requestPermission) {
            if (next.getSubPermission().size() > 0 && arrayList.contains(next.getIdentifier())) {
                next.getSubPermission().clear();
            }
        }
        for (PermissionGroup next2 : requestPermission) {
            if (next2.getSubPermission().size() > 0) {
                for (Permission displayName : next2.getSubPermission()) {
                    sb.append(displayName.getDisplayName(context));
                    sb.append(getSeparator());
                }
            } else {
                sb.append(next2.getDisplayName(context));
                sb.append(getSeparator());
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String getSeparator() {
        return isZh() ? "，" : ", ";
    }

    private static boolean isZh() {
        return "zh".equals(Locale.getDefault().getLanguage());
    }

    public AlertDialog show(Context context, final PermissionDialogCallBack permissionDialogCallBack) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mz_secondary_confirmation_permission_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.mz_secondary_confirmation_dialog_summary)).setText(buildSummary(context));
        AlertDialog create = new AlertDialog.Builder(context).setTitle((CharSequence) this.builder.title == null ? context.getResources().getString(R.string.mz_permission_secondary_confirmation_title) : this.builder.title).setView(inflate).setCancelable(false).setPositiveButton(R.string.mz_permission_continue_allow, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                PermissionDialogCallBack permissionDialogCallBack = permissionDialogCallBack;
                if (permissionDialogCallBack != null) {
                    permissionDialogCallBack.onPermissionClick(dialogInterface, true);
                }
            }
        }).setNegativeButton(R.string.mz_reject, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                PermissionDialogCallBack permissionDialogCallBack = permissionDialogCallBack;
                if (permissionDialogCallBack != null) {
                    permissionDialogCallBack.onPermissionClick(dialogInterface, false);
                }
            }
        }).setHighLightButton(-1, 0).create();
        create.show();
        return create;
    }
}

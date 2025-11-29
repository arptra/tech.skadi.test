package flyme.support.v7.view;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.meizu.common.R;
import flyme.support.v7.permission.PermissionGroup;
import flyme.support.v7.permission.PermissionManager;
import flyme.support.v7.view.PermissionDialogView;
import java.util.Collections;
import java.util.List;

public class PermissionViewHandlerImpl implements PermissionViewHandler {
    private TextView mCenterIfNeedTextView;
    private final Context mContext;
    private PermissionManager mPermissionManager;
    private TextView mTermsView;

    public PermissionViewHandlerImpl(Context context) {
        this.mContext = context;
        this.mPermissionManager = PermissionManager.getInstance(context);
    }

    private int getTextWidth(TextView textView, String str) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, textView).toString();
        }
        return (int) textView.getPaint().measureText(str);
    }

    private boolean isTextViewOneLine(TextView textView) {
        ViewGroup viewGroup = (ViewGroup) textView.getParent().getParent();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        return (getTextWidth(textView, textView.getText().toString()) + (((textView.getPaddingLeft() + textView.getPaddingRight()) + viewGroup.getPaddingLeft()) + viewGroup.getPaddingRight())) + (((marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) <= this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_width);
    }

    public void bindData(PermissionDialogView.Builder builder) {
        String str;
        if (TextUtils.isEmpty(builder.message)) {
            String[] strArr = builder.permissions;
            if (strArr != null && strArr.length > 0) {
                try {
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    while (true) {
                        String[] strArr2 = builder.permissions;
                        if (i >= strArr2.length) {
                            break;
                        }
                        String permissionName = this.mPermissionManager.getPermissionName(this.mContext, strArr2[i]);
                        if (!TextUtils.isEmpty(permissionName)) {
                            sb.append(permissionName);
                            sb.append("、");
                        }
                        i++;
                    }
                    if (sb.length() > 0) {
                        sb.setLength(sb.length() - 1);
                    }
                    str = String.format(this.mContext.getResources().getString(flyme.support.v7.appcompat.R.string.mz_permission_message_supplement), new Object[]{builder.appName, sb.toString(), Integer.valueOf(builder.permissions.length)});
                } catch (Exception unused) {
                }
            }
            str = null;
        } else {
            str = builder.message;
        }
        if (TextUtils.isEmpty(str)) {
            this.mCenterIfNeedTextView.setVisibility(8);
        } else {
            this.mCenterIfNeedTextView.setText(str);
        }
        if (isTextViewOneLine(this.mCenterIfNeedTextView)) {
            this.mCenterIfNeedTextView.setGravity(17);
        }
    }

    public View createView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(flyme.support.v7.appcompat.R.layout.mz_permission_dialog_simple, viewGroup, false);
        this.mCenterIfNeedTextView = (TextView) inflate.findViewById(flyme.support.v7.appcompat.R.id.mz_permission_dialog_message);
        this.mTermsView = (TextView) inflate.findViewById(flyme.support.v7.appcompat.R.id.mz_permission_dialog_terms);
        return inflate;
    }

    public CheckBox getCheckBox() {
        return new CheckBox(this.mContext);
    }

    public List<PermissionGroup> getPermissions() {
        return Collections.emptyList();
    }

    public TextView getTermsView() {
        return this.mTermsView;
    }
}

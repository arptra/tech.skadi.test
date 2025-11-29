package flyme.support.v7.view;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.TransformationMethod;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.va.a;
import com.honey.account.va.b;
import com.meizu.common.scrollbarview.MzScrollBarView;
import com.meizu.common.scrollbarview.MzScrollBarViewHelper;
import com.meizu.common.scrollview.MzNestedScrollView;
import com.meizu.common.widget.Switch;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.permission.Permission;
import flyme.support.v7.permission.PermissionGroup;
import flyme.support.v7.permission.PermissionManager;
import flyme.support.v7.util.DensityUtils;
import flyme.support.v7.view.PermissionDialogView;
import flyme.support.v7.widget.PermissionScrollView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermissionViewHandlerImpl23 implements PermissionViewHandler {
    private CheckBox almostDenyCheckBox;
    private LinearLayout contentLayout;
    private boolean isIntl;
    private final Context mContext;
    /* access modifiers changed from: private */
    public View mDownIndicator;
    private Map<String, Boolean> mItemCheckedMap = new HashMap();
    private final int mItemSummaryColor;
    private final int mItemTitleColor;
    private final LayoutInflater mLayoutInflater;
    private LinearLayout mPermissionContainer;
    private final PermissionManager mPermissionManager;
    private RelativeLayout mPermissionRelativeLayout;
    /* access modifiers changed from: private */
    public PermissionScrollView mScrollView;
    private final int mTitleColor;
    /* access modifiers changed from: private */
    public View mUpIndicator;
    private MzNestedScrollView mzNestedScrollView;
    private MzScrollBarView mzScrollBarView;
    private List<PermissionGroup> permissions;
    private TextView reminderTextView;
    private TextView termsView;
    private TextView titleTextView;

    public PermissionViewHandlerImpl23(Context context) {
        this.mContext = context;
        this.mTitleColor = context.getResources().getColor(R.color.mz_alert_dialog_title_color_dark);
        this.mItemTitleColor = context.getResources().getColor(R.color.mz_permission_dialog_item_title_dark);
        this.mItemSummaryColor = context.getResources().getColor(R.color.mz_permission_dialog_item_summary_dark);
        this.mPermissionManager = PermissionManager.getInstance(context);
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    private void addGroupItem(ViewGroup viewGroup, String str, String str2, boolean z) {
        if (this.isIntl) {
            addGroupItemIntl(viewGroup, str, str2, z);
            return;
        }
        if (viewGroup.getChildCount() != 0) {
            viewGroup.addView(new Space(this.mContext), new LinearLayout.LayoutParams(-1, DensityUtils.dip2px(this.mContext, 22.0d)));
        }
        View inflate = this.mLayoutInflater.inflate(R.layout.mz_permission_dialog_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.mz_permission_dialog_item_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.mz_permission_dialog_item_summary);
        textView.setText(str);
        if (TextUtils.isEmpty(str2)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str2);
        }
        if (z) {
            textView.setTextColor(this.mItemTitleColor);
            textView2.setTextColor(this.mItemSummaryColor);
        }
        viewGroup.addView(inflate);
    }

    private void addGroupItemIntl(ViewGroup viewGroup, String str, String str2, boolean z) {
        View inflate = this.mLayoutInflater.inflate(R.layout.mz_permission_dialog_item_intl, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.switch_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.switch_info);
        Switch switchR = (Switch) inflate.findViewById(R.id.switch1);
        inflate.setOnClickListener(new a(switchR));
        switchR.setOnCheckedChangeListener(new b(this, str));
        textView.setText(str);
        if (TextUtils.isEmpty(str2)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str2);
        }
        if (z) {
            textView.setTextColor(this.mItemTitleColor);
            textView2.setTextColor(this.mItemSummaryColor);
        }
        this.mItemCheckedMap.put(str, Boolean.valueOf(switchR.isChecked()));
        viewGroup.addView(inflate);
    }

    private int getTextWidth(TextView textView, String str) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, textView).toString();
        }
        return (int) textView.getPaint().measureText(str);
    }

    private boolean isTextViewOneLine(TextView textView) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        return (getTextWidth(textView, textView.getText().toString()) + (textView.getPaddingLeft() + textView.getPaddingRight())) + (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin) <= this.mContext.getResources().getDimensionPixelOffset(com.meizu.common.R.dimen.mz_alert_dialog_width);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addGroupItemIntl$1(String str, CompoundButton compoundButton, boolean z) {
        this.mItemCheckedMap.put(str, Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public void manageScrollIndicators(View view, View view2, View view3) {
        int i = 4;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (view.canScrollVertically(1)) {
                i = 0;
            }
            view3.setVisibility(i);
        }
    }

    public void bindData(PermissionDialogView.Builder builder) {
        String[] strArr;
        if (builder.mShowTitle) {
            this.titleTextView.setText(builder.appName);
            if (isTextViewOneLine(this.titleTextView)) {
                this.titleTextView.setGravity(17);
            }
        } else {
            this.titleTextView.setVisibility(8);
        }
        if (builder.isDark) {
            this.titleTextView.setTextColor(this.mTitleColor);
            this.termsView.setTextColor(this.mItemSummaryColor);
        }
        this.isIntl = builder.isIntl;
        String[] strArr2 = builder.permissions;
        boolean z = true;
        boolean z2 = strArr2 != null && strArr2.length > 0;
        List<Pair<String, String>> list = builder.additionalGroups;
        if (list == null || list.size() <= 0) {
            z = false;
        }
        if (z2 || z) {
            if (z2) {
                HashMap hashMap = new HashMap();
                int i = 0;
                while (true) {
                    strArr = builder.permissions;
                    if (i >= strArr.length) {
                        break;
                    }
                    hashMap.put(strArr[i], builder.permissionReasons[i]);
                    i++;
                }
                List<PermissionGroup> requestPermission = this.mPermissionManager.getRequestPermission(strArr, false);
                this.permissions = requestPermission;
                for (PermissionGroup next : requestPermission) {
                    if (next.getSubPermission().size() > 0 && hashMap.containsKey(next.getIdentifier())) {
                        next.getSubPermission().clear();
                    }
                }
                for (PermissionGroup next2 : this.permissions) {
                    if (next2.getSubPermission().size() > 0) {
                        for (Permission next3 : next2.getSubPermission()) {
                            addGroupItem(this.contentLayout, next3.getDisplayName(this.mContext), (String) hashMap.get(next3.getIdentifier()), builder.isDark);
                        }
                    } else {
                        addGroupItem(this.contentLayout, next2.getDisplayName(this.mContext), (String) hashMap.get(next2.getIdentifier()), builder.isDark);
                    }
                }
            }
            if (z) {
                for (Pair next4 : builder.additionalGroups) {
                    addGroupItem(this.contentLayout, (String) next4.first, (String) next4.second, builder.isDark);
                }
            }
            this.mScrollView.setOnScrollChangeListener(new PermissionScrollView.OnScrollChangeListener() {
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    PermissionViewHandlerImpl23 permissionViewHandlerImpl23 = PermissionViewHandlerImpl23.this;
                    permissionViewHandlerImpl23.manageScrollIndicators(view, permissionViewHandlerImpl23.mUpIndicator, PermissionViewHandlerImpl23.this.mDownIndicator);
                }
            });
            this.mScrollView.post(new Runnable() {
                public void run() {
                    PermissionViewHandlerImpl23 permissionViewHandlerImpl23 = PermissionViewHandlerImpl23.this;
                    permissionViewHandlerImpl23.manageScrollIndicators(permissionViewHandlerImpl23.mScrollView, PermissionViewHandlerImpl23.this.mUpIndicator, PermissionViewHandlerImpl23.this.mDownIndicator);
                }
            });
        } else {
            this.mPermissionContainer.setVisibility(8);
        }
        if (builder.showAlmostDenyBtn) {
            this.almostDenyCheckBox.setVisibility(0);
        } else {
            this.almostDenyCheckBox.setVisibility(8);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.mPermissionRelativeLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            this.mPermissionRelativeLayout.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mzNestedScrollView.getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.mzNestedScrollView.setLayoutParams(layoutParams2);
        }
        if (!TextUtils.isEmpty(builder.reminder)) {
            this.reminderTextView.setText(builder.reminder);
            this.reminderTextView.setVisibility(0);
        } else if (!TextUtils.isEmpty(builder.csReminder)) {
            this.reminderTextView.setText(builder.csReminder);
            this.reminderTextView.setVisibility(0);
            this.reminderTextView.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            this.reminderTextView.setVisibility(8);
        }
    }

    public View createView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.mz_permission_dialog, viewGroup, false);
        this.mPermissionRelativeLayout = (RelativeLayout) inflate.findViewById(R.id.permission_relative_layout);
        this.titleTextView = (TextView) inflate.findViewById(R.id.mz_permission_dialog_title);
        this.mPermissionContainer = (LinearLayout) inflate.findViewById(R.id.mz_permission_dialog_container);
        this.mUpIndicator = inflate.findViewById(R.id.mz_permission_dialog_scroll_indicator_up);
        this.mScrollView = (PermissionScrollView) inflate.findViewById(R.id.mz_permission_dialog_scroll_view);
        this.mzScrollBarView = (MzScrollBarView) inflate.findViewById(R.id.mz_permission_dialog_scrollbarview_vertical);
        this.mzNestedScrollView = (MzNestedScrollView) inflate.findViewById(R.id.mz_permission_dialog_scrollview);
        this.reminderTextView = (TextView) inflate.findViewById(R.id.mz_permission_dialog_reminder);
        this.mDownIndicator = inflate.findViewById(R.id.mz_permission_dialog_scroll_indicator_down);
        this.contentLayout = (LinearLayout) inflate.findViewById(R.id.mz_permission_dialog_content_layout);
        this.almostDenyCheckBox = (CheckBox) inflate.findViewById(R.id.mz_permission_dialog_checkbox);
        this.termsView = (TextView) inflate.findViewById(R.id.mz_permission_dialog_terms);
        MzScrollBarViewHelper.bindNestedScrollView(this.mzNestedScrollView, this.mzScrollBarView);
        return inflate;
    }

    public CheckBox getCheckBox() {
        return this.almostDenyCheckBox;
    }

    public Map<String, Boolean> getItemCheckedMap() {
        return this.mItemCheckedMap;
    }

    public List<PermissionGroup> getPermissions() {
        return this.permissions;
    }

    public TextView getTermsView() {
        return this.termsView;
    }
}

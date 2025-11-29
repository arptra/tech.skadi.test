package flyme.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.common.animator.MzPressAnimationHelper;
import com.meizu.common.util.InternalResUtils;
import com.meizu.common.util.ResourceUtils;
import com.meizu.common.util.ScreenUtil;
import com.meizu.common.util.TextViewUtils;
import flyme.support.v7.app.AlertController;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.widget.FlymeAlertDialogLayout;
import flyme.support.v7.widget.MzMultiLinesCheckLayout;
import flyme.support.v7.widget.MzRecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

class FlymeAlertController extends AlertController {
    private static final int BIT_BUTTON_NEGATIVE = 2;
    private static final int BIT_BUTTON_NEUTRAL = 4;
    private static final int BIT_BUTTON_POSITIVE = 1;
    private static final int CUSTOM_TITLE_PADDING_BOTTOM = 20;
    private static final int CUSTOM_TITLE_PADDING_TOP = 38;
    private static final float DIALOG_MEDIUM = 0.65f;
    private static final float DIALOG_SMALL = 0.33f;
    private static final int HAS_BUTTON_PANEL = 4;
    private static final int HAS_CONTENT_PANEL = 2;
    private static final int HAS_TOP_PANEL = 1;
    private static final String TAG = "FlymeAlertController";
    private static List<PaddingRule> sActionListPaddingRules = new ArrayList();
    private static List<PaddingRule> sCustomViewRules = new ArrayList();
    private static List<PaddingRule> sListPaddingRules = new ArrayList();
    private static List<PaddingRule> sPaddingRules = new ArrayList();
    private static List<PaddingRule> sSingleActionPaddingRules = new ArrayList();
    private static List<PaddingRule> sSingleMessagePaddingRules = new ArrayList();
    private boolean hasCustomView;
    private boolean isScaleOnPress = true;
    private boolean mActionDialog;
    ListAdapter mAdapter;
    private int mAlertDialogLayout;
    private int mAlertDialogWidth;
    MzPressAnimationHelper mAnimationHelper;
    private boolean mAutoShowSoftInput = true;
    private final View.OnClickListener mButtonHandler = new View.OnClickListener() {
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
            r3 = r0.mButtonNeutralMessage;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r3) {
            /*
                r2 = this;
                flyme.support.v7.app.FlymeAlertController r0 = flyme.support.v7.app.FlymeAlertController.this
                android.widget.Button r1 = r0.mButtonPositive
                if (r3 != r1) goto L_0x000f
                android.os.Message r1 = r0.mButtonPositiveMessage
                if (r1 == 0) goto L_0x000f
                android.os.Message r3 = android.os.Message.obtain(r1)
                goto L_0x002a
            L_0x000f:
                android.widget.Button r1 = r0.mButtonNegative
                if (r3 != r1) goto L_0x001c
                android.os.Message r1 = r0.mButtonNegativeMessage
                if (r1 == 0) goto L_0x001c
                android.os.Message r3 = android.os.Message.obtain(r1)
                goto L_0x002a
            L_0x001c:
                android.widget.Button r1 = r0.mButtonNeutral
                if (r3 != r1) goto L_0x0029
                android.os.Message r3 = r0.mButtonNeutralMessage
                if (r3 == 0) goto L_0x0029
                android.os.Message r3 = android.os.Message.obtain(r3)
                goto L_0x002a
            L_0x0029:
                r3 = 0
            L_0x002a:
                if (r3 == 0) goto L_0x002f
                r3.sendToTarget()
            L_0x002f:
                flyme.support.v7.app.FlymeAlertController r2 = flyme.support.v7.app.FlymeAlertController.this
                android.os.Handler r3 = r2.mHandler
                r0 = 1
                flyme.support.v7.app.AppCompatDialog r2 = r2.mDialog
                android.os.Message r2 = r3.obtainMessage(r0, r2)
                r2.sendToTarget()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.app.FlymeAlertController.AnonymousClass1.onClick(android.view.View):void");
        }
    };
    private final int mButtonIconDimen;
    Button mButtonNegative;
    private Drawable mButtonNegativeIcon;
    Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    Button mButtonNeutral;
    private Drawable mButtonNeutralIcon;
    Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private int mButtonPanelLayoutHint = 0;
    private int mButtonPanelSideLayout;
    Button mButtonPositive;
    private Drawable mButtonPositiveIcon;
    Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    /* access modifiers changed from: private */
    public int mCenterListItemLayout;
    int mCheckedItem = -1;
    private final Context mContext;
    private boolean mCustomPaddingRule;
    private View mCustomTitleView;
    private float mDensityRatio;
    final AppCompatDialog mDialog;
    private int mDividerHeight;
    private int mGravity;
    Handler mHandler;
    private int mHighLightButton;
    private int mHighLightColor = 1;
    private Drawable mIcon;
    private int mIconId = 0;
    private ImageView mIconView;
    /* access modifiers changed from: private */
    public boolean mIsSingleMultiLines;
    int mListItemLayout;
    int mListLayout;
    ListView mListView;
    private int mMaxHeight;
    private CharSequence mMessage;
    private MovementMethod mMessageMovementMethod;
    private TextView mMessageView;
    int mMultiChoiceItemLayout;
    int mMultiLinesChoiceItemLayout;
    private int mMultiLinesStyleItemSize;
    private int mPaddingSpace1;
    private int mPaddingSpace2;
    private int mPaddingSpace3;
    private int mPaddingSpace4;
    int mRecyclerViewItemMultiLayout;
    int mRecyclerViewItemSingleLayout;
    NestedScrollView mScrollView;
    private boolean mShowTitle;
    int mSingleChoiceItemLayout;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private boolean mViewSpacingSpecified = false;
    private int mViewSpacingTop;
    private final Window mWindow;

    public static final class ButtonHandler extends Handler {
        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference<DialogInterface> mDialog;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.mDialog = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.mDialog.get(), message.what);
            } else if (i == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public static class PaddingRule {
        /* access modifiers changed from: private */
        public int mask;
        private int space1;
        private int space2;
        private int space3;
        private int space4;

        public PaddingRule(int i, int i2, int i3, int i4, int i5) {
            this.mask = i;
            this.space1 = i2;
            this.space2 = i3;
            this.space3 = i4;
            this.space4 = i5;
        }

        /* access modifiers changed from: private */
        public void applyRule(Context context, View view, View view2, View view3, View view4, boolean z) {
            if (view != null) {
                view.getLayoutParams().height = FlymeAlertController.dp2px(context, (float) this.space1);
            }
            if (view2 != null) {
                view2.getLayoutParams().height = FlymeAlertController.dp2px(context, (float) this.space2);
            }
            if (view3 != null) {
                view3.getLayoutParams().height = FlymeAlertController.dp2px(context, (float) this.space3);
            }
            if (view4 != null) {
                view4.getLayoutParams().height = FlymeAlertController.dp2px(context, (float) this.space4);
            }
            if (z) {
                if (view != null) {
                    view.getLayoutParams().height = FlymeAlertController.dp2px(context, 20.0f);
                }
                if (view2 != null) {
                    view2.getLayoutParams().height = FlymeAlertController.dp2px(context, 16.0f);
                }
                if (view3 != null) {
                    view3.getLayoutParams().height = FlymeAlertController.dp2px(context, 18.0f);
                }
            }
        }
    }

    @Keep
    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context context) {
            this(context, (AttributeSet) null);
        }

        public void setHasDecor(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.mPaddingTopNoTitle, getPaddingRight(), z2 ? getPaddingBottom() : this.mPaddingBottomNoButtons);
            }
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mPaddingTopNoTitle = 0;
            this.mPaddingBottomNoButtons = 0;
        }
    }

    public static class ViewHolder {
        public TextView item;

        private ViewHolder() {
        }
    }

    static {
        sPaddingRules.add(new PaddingRule(7, 38, 24, 38, 24));
        sPaddingRules.add(new PaddingRule(3, 38, 22, 0, 24));
        sPaddingRules.add(new PaddingRule(5, 38, 0, 38, 24));
        sPaddingRules.add(new PaddingRule(1, 38, 0, 0, 24));
        sPaddingRules.add(new PaddingRule(6, 0, 26, 38, 24));
        sPaddingRules.add(new PaddingRule(2, 0, 0, 0, 0));
        sPaddingRules.add(new PaddingRule(4, 0, 0, 10, 24));
        sPaddingRules.add(new PaddingRule(0, 10, 0, 0, 24));
        sSingleMessagePaddingRules.add(new PaddingRule(7, 38, 22, 38, 24));
        sSingleMessagePaddingRules.add(new PaddingRule(3, 38, 6, 0, 24));
        sSingleMessagePaddingRules.add(new PaddingRule(5, 38, 0, 38, 24));
        sSingleMessagePaddingRules.add(new PaddingRule(1, 38, 0, 0, 24));
        sSingleMessagePaddingRules.add(new PaddingRule(6, 0, 26, 38, 24));
        sSingleMessagePaddingRules.add(new PaddingRule(2, 0, 0, 0, 0));
        sSingleMessagePaddingRules.add(new PaddingRule(4, 0, 0, 10, 24));
        sSingleMessagePaddingRules.add(new PaddingRule(0, 10, 0, 0, 24));
        sCustomViewRules.add(new PaddingRule(7, 38, 38, 38, 24));
        sCustomViewRules.add(new PaddingRule(3, 38, 22, 0, 24));
        sCustomViewRules.add(new PaddingRule(5, 38, 0, 38, 24));
        sCustomViewRules.add(new PaddingRule(1, 38, 0, 0, 24));
        sCustomViewRules.add(new PaddingRule(6, 0, 0, 38, 24));
        sCustomViewRules.add(new PaddingRule(2, 0, 0, 0, 0));
        sCustomViewRules.add(new PaddingRule(4, 0, 0, 10, 24));
        sCustomViewRules.add(new PaddingRule(0, 10, 0, 0, 24));
        sListPaddingRules.add(new PaddingRule(7, 38, 22, 12, 0));
        sListPaddingRules.add(new PaddingRule(3, 38, 26, 0, 0));
        sListPaddingRules.add(new PaddingRule(5, 38, 0, 12, 0));
        sListPaddingRules.add(new PaddingRule(1, 38, 24, 0, 0));
        sListPaddingRules.add(new PaddingRule(6, 0, 26, 12, 0));
        sListPaddingRules.add(new PaddingRule(2, 0, 0, 0, 0));
        sListPaddingRules.add(new PaddingRule(4, 0, 0, 0, 0));
        sListPaddingRules.add(new PaddingRule(0, 10, 0, 0, 24));
        sActionListPaddingRules.add(new PaddingRule(7, 24, 12, 12, 0));
        sActionListPaddingRules.add(new PaddingRule(3, 38, 26, 0, 0));
        sActionListPaddingRules.add(new PaddingRule(5, 38, 0, 12, 0));
        sActionListPaddingRules.add(new PaddingRule(1, 38, 24, 0, 0));
        sActionListPaddingRules.add(new PaddingRule(6, 0, 26, 12, 0));
        sActionListPaddingRules.add(new PaddingRule(2, 0, 0, 0, 0));
        sActionListPaddingRules.add(new PaddingRule(4, 0, 0, 0, 0));
        sActionListPaddingRules.add(new PaddingRule(0, 10, 0, 0, 24));
        sSingleActionPaddingRules.add(new PaddingRule(7, 24, 12, 0, 0));
        sSingleActionPaddingRules.add(new PaddingRule(3, 24, 12, 0, 0));
        sSingleActionPaddingRules.add(new PaddingRule(5, 24, 0, 0, 0));
        sSingleActionPaddingRules.add(new PaddingRule(1, 24, 0, 0, 24));
        sSingleActionPaddingRules.add(new PaddingRule(6, 0, 0, 0, 0));
        sSingleActionPaddingRules.add(new PaddingRule(2, 0, 0, 0, 0));
        sSingleActionPaddingRules.add(new PaddingRule(4, 0, 0, 0, 0));
        sSingleActionPaddingRules.add(new PaddingRule(0, 10, 0, 0, 24));
    }

    public FlymeAlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        super(context, appCompatDialog, window);
        this.mContext = context;
        this.mDialog = appCompatDialog;
        this.mWindow = window;
        this.mHandler = new ButtonHandler(appCompatDialog);
        this.mAnimationHelper = new MzPressAnimationHelper();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.AlertDialog, androidx.appcompat.R.attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_android_layout, 0);
        this.mButtonPanelSideLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.mListLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_listLayout, 0);
        this.mMultiChoiceItemLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.mSingleChoiceItemLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.mListItemLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_listItemLayout, 0);
        this.mMultiLinesChoiceItemLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiLinesChoiceItemLayout, 0);
        this.mRecyclerViewItemMultiLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_recyclerViewMultiLinesLayout, 0);
        this.mRecyclerViewItemSingleLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_recyclerViewMultiLinesSingleLayout, 0);
        this.mShowTitle = true;
        this.mButtonIconDimen = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_mzButtonIconDimen, dp2px(context, 48.0f));
        this.mCenterListItemLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_centerListItemLayout, 0);
        this.mActionDialog = obtainStyledAttributes.getBoolean(R.styleable.AlertDialog_mzActionDialog, false);
        this.mCustomPaddingRule = obtainStyledAttributes.getBoolean(R.styleable.AlertDialog_mzDialogCustomPadding, false);
        this.mPaddingSpace1 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_mzDialogSpace1, 0);
        this.mPaddingSpace2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_mzDialogSpace2, 0);
        this.mPaddingSpace3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_mzDialogSpace3, 0);
        this.mPaddingSpace4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_mzDialogSpace4, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
        this.mAlertDialogWidth = Math.min(getScreenWidth(), getScreenHeight()) - (context.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_margin_bottom_to_screen) * 2);
        this.mDensityRatio = 1.0f;
        this.mDividerHeight = context.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_divider_height);
    }

    private void addTargetView(View view, boolean z) {
        MzPressAnimationHelper mzPressAnimationHelper = this.mAnimationHelper;
        if (mzPressAnimationHelper != null && !this.mActionDialog && this.mListView == null && this.isScaleOnPress) {
            mzPressAnimationHelper.addTargetView(view, z);
        }
    }

    private int[] analyzeDialogButtons() {
        int i = -1;
        Button button = getButton(-1);
        Button button2 = getButton(-2);
        Button button3 = getButton(-3);
        int i2 = 0;
        if (button != null && !TextUtils.isEmpty(button.getText())) {
            i = 0;
        }
        if (button2 != null && !TextUtils.isEmpty(button2.getText())) {
            i++;
        }
        if (button3 != null && !TextUtils.isEmpty(button3.getText())) {
            i++;
        }
        if (i > 0) {
            if (button == null || TextUtils.isEmpty(button.getText())) {
                button = (button2 == null || TextUtils.isEmpty(button2.getText())) ? button3 : button2;
            }
            ViewGroup viewGroup = (ViewGroup) button.getParent();
            if ((viewGroup instanceof LinearLayout) && ((LinearLayout) viewGroup).getOrientation() == 1) {
                i2 = 1;
            }
        }
        return new int[]{i, i2};
    }

    private void applyHorizontalButtonStyle(Button button, int i, int i2, boolean z) {
        if (button != null && button.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.width = calcButtonWidth(i2);
            layoutParams.height = this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_horizontal_button_height);
            button.setGravity(17);
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_button_padding);
            button.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
            if (i == 4) {
                if ((i2 & 2) != 0) {
                    layoutParams.setMarginStart(this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_button_margin_start));
                }
            } else if (i == 1 && !((i2 & 2) == 0 && (i2 & 4) == 0)) {
                layoutParams.setMarginStart(this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_button_margin_start));
            }
            if (z) {
                int i3 = this.mHighLightColor;
                if (i3 == 2) {
                    button.setTextColor(this.mContext.getResources().getColor(R.color.mz_alert_dialog_delete_button_color));
                    button.setBackgroundResource(R.drawable.mz_alert_dialog_button_bg_radius_red);
                } else if (i3 == 1) {
                    button.setBackgroundResource(R.drawable.mz_alert_dialog_button_bg_radius_blue);
                } else if (i3 == 3) {
                    button.setBackgroundResource(R.drawable.mz_alert_dialog_button_bg_radius_polestar);
                } else {
                    button.setBackgroundResource(R.drawable.mz_alert_dialog_button_bg_radius);
                }
            } else {
                button.setBackgroundResource(R.drawable.mz_alert_dialog_button_bg_radius);
            }
        }
    }

    private void applyMessageTextAppearance(TextView textView) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes((AttributeSet) null, new int[]{16842804}, com.meizu.common.R.attr.mzDialogMessageStyle, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, com.meizu.common.R.style.DialogWindowContent_Flyme_Light);
        obtainStyledAttributes.recycle();
        textView.setTextAppearance(this.mContext, resourceId);
    }

    private void applyTitleTextAppearance(TextView textView) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes((AttributeSet) null, new int[]{16842804}, 16842843, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, com.meizu.common.R.style.DialogWindowTitle_Flyme_Light);
        obtainStyledAttributes.recycle();
        textView.setTextAppearance(this.mContext, resourceId);
    }

    private void applyVerticalButtonStyle(Button button, int i, int i2, boolean z) {
        if (button != null && button.getVisibility() == 0) {
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_button_padding);
            button.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
            if (this.mActionDialog || this.mListView != null || this.mIsSingleMultiLines) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_vertical_action_button_height);
                button.setBackgroundResource(this.mIsSingleMultiLines ? R.drawable.mz_alert_dialog_button_bg_rectange : R.drawable.mz_alert_dialog_button_bg_rectangle_none_corner);
                return;
            }
            int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_normal_margin_start);
            int dimensionPixelOffset3 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_button_margin_start);
            int i3 = this.mAlertDialogWidth - (dimensionPixelOffset2 * 2);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams2.width = i3;
            layoutParams2.height = this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_vertical_button_height);
            if (i == 4) {
                if ((i2 & 1) != 0) {
                    layoutParams2.topMargin = dimensionPixelOffset3;
                }
            } else if (i == 2 && !((i2 & 4) == 0 && (i2 & 1) == 0)) {
                layoutParams2.topMargin = dimensionPixelOffset3;
            }
            if (z) {
                int i4 = this.mHighLightColor;
                if (i4 == 2) {
                    button.setTextColor(this.mContext.getResources().getColor(R.color.mz_alert_dialog_delete_button_color));
                    button.setBackgroundResource(R.drawable.mz_alert_dialog_button_bg_radius_red);
                } else if (i4 == 1) {
                    button.setBackgroundResource(R.drawable.mz_alert_dialog_button_bg_radius_blue);
                } else if (i4 == 3) {
                    button.setBackgroundResource(R.drawable.mz_alert_dialog_button_bg_radius_polestar);
                } else {
                    button.setBackgroundResource(R.drawable.mz_alert_dialog_button_bg_radius);
                }
            } else {
                button.setBackgroundResource(R.drawable.mz_alert_dialog_button_bg_radius);
            }
        }
    }

    private int calcButtonCount(int i) {
        int i2 = (i & 4) != 0 ? 1 : 0;
        if ((i & 2) != 0) {
            i2++;
        }
        return (i & 1) != 0 ? i2 + 1 : i2;
    }

    private int calcButtonHighLight(int i) {
        int i2 = this.mHighLightButton;
        if (i2 == -1 && (i & 1) != 0) {
            return 1;
        }
        if (i2 != -2 || (i & 2) == 0) {
            if (i2 != -3 || (i & 4) == 0) {
                if ((i & 1) != 0) {
                    return 1;
                }
                if ((i & 4) == 0) {
                    if ((i & 2) == 0) {
                        return 0;
                    }
                }
            }
            return 4;
        }
        return 2;
    }

    private int calcButtonLayoutPadding() {
        int i;
        int i2;
        Button button = this.mButtonPositive;
        int i3 = 1;
        int i4 = 0;
        if (button == null || button.getVisibility() != 0) {
            i2 = 0;
            i = 0;
        } else {
            i2 = getTextWidth(this.mButtonPositive, this.mButtonPositiveText);
            i = 1;
        }
        Button button2 = this.mButtonNegative;
        if (button2 != null && button2.getVisibility() == 0) {
            i2 += getTextWidth(this.mButtonNegative, this.mButtonNegativeText);
            i++;
        }
        Button button3 = this.mButtonNeutral;
        if (button3 != null && button3.getVisibility() == 0) {
            i2 += getTextWidth(this.mButtonNeutral, this.mButtonNeutralText);
            i++;
        }
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_normal_margin_start);
        int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_button_margin_start);
        int i5 = (this.mAlertDialogWidth - i2) - (dimensionPixelOffset * 2);
        if (i > 0) {
            i4 = i - 1;
        }
        int i6 = i5 - (dimensionPixelOffset2 * i4);
        if (i > 0) {
            i3 = i;
        }
        return (i6 / i3) / 2;
    }

    private int calcButtonWidth(int i) {
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_normal_margin_start);
        int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_button_margin_start);
        int calcButtonCount = calcButtonCount(i);
        if (calcButtonCount == 0) {
            return this.mAlertDialogWidth - (dimensionPixelOffset * 2);
        }
        return ((this.mAlertDialogWidth - (dimensionPixelOffset * 2)) - (dimensionPixelOffset2 * (calcButtonCount > 0 ? calcButtonCount - 1 : 0))) / calcButtonCount;
    }

    public static boolean canTextInput(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (canTextInput(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void cancelFallbackLineSpacing(TextView textView) {
        try {
            TextView.class.getDeclaredMethod("setFallbackLineSpacing", new Class[]{Boolean.TYPE}).invoke(textView, new Object[]{Boolean.FALSE});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void centerButton(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0081, code lost:
        r11 = r11[0];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private double computeDialogHeightRatio() {
        /*
            r11 = this;
            java.lang.CharSequence r0 = r11.mTitle
            r1 = 4592302525631185289(0x3fbb22d0e5604189, double:0.106)
            if (r0 == 0) goto L_0x001e
            int r0 = r0.length()
            double r3 = (double) r0
            r5 = 4624633867356078080(0x402e000000000000, double:15.0)
            double r3 = r3 / r5
            double r3 = java.lang.Math.ceil(r3)
            int r0 = (int) r3
            double r3 = (double) r0
            r5 = 4584304132692975288(0x3f9eb851eb851eb8, double:0.03)
            double r3 = r3 * r5
            double r1 = r1 + r3
        L_0x001e:
            java.lang.CharSequence r0 = r11.mMessage
            if (r0 == 0) goto L_0x0037
            int r0 = r0.length()
            double r3 = (double) r0
            r5 = 4626041242239631360(0x4033000000000000, double:19.0)
            double r3 = r3 / r5
            double r3 = java.lang.Math.ceil(r3)
            int r0 = (int) r3
            double r3 = (double) r0
            r5 = 4582286520059913306(0x3f978d4fdf3b645a, double:0.023)
            double r3 = r3 * r5
            double r1 = r1 + r3
        L_0x0037:
            boolean r0 = r11.hasCustomView
            r3 = 4599075939470750515(0x3fd3333333333333, double:0.3)
            if (r0 == 0) goto L_0x0041
            double r1 = r1 + r3
        L_0x0041:
            android.view.View r0 = r11.mCustomTitleView
            if (r0 == 0) goto L_0x004b
            r5 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            double r1 = r1 + r5
        L_0x004b:
            android.widget.ListView r0 = r11.getListView()
            r5 = 4589204049087554388(0x3fb020c49ba5e354, double:0.063)
            if (r0 == 0) goto L_0x0063
            android.widget.ListAdapter r0 = r0.getAdapter()
            if (r0 == 0) goto L_0x0063
            int r0 = r0.getCount()
            double r7 = (double) r0
            double r7 = r7 * r5
            double r1 = r1 + r7
        L_0x0063:
            int r0 = r11.mMultiLinesStyleItemSize
            if (r0 <= 0) goto L_0x0070
            double r7 = (double) r0
            r9 = 4592590756007337001(0x3fbc28f5c28f5c29, double:0.11)
            double r7 = r7 * r9
            double r1 = r1 + r7
            double r1 = r1 - r3
        L_0x0070:
            int[] r11 = r11.analyzeDialogButtons()
            r0 = 1
            r3 = r11[r0]
            r4 = 0
            if (r3 != 0) goto L_0x007f
            r7 = r11[r4]
            if (r7 <= 0) goto L_0x007f
            goto L_0x0088
        L_0x007f:
            if (r3 != r0) goto L_0x0088
            r11 = r11[r4]
            if (r11 <= 0) goto L_0x0088
            double r3 = (double) r11
            double r3 = r3 * r5
            double r1 = r1 + r3
        L_0x0088:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.app.FlymeAlertController.computeDialogHeightRatio():double");
    }

    private ColorStateList createColorList(int i) {
        return new ColorStateList(new int[][]{new int[]{16842910}, new int[0]}, new int[]{this.mContext.getResources().getColor(i), Color.argb(77, 0, 0, 0)});
    }

    /* access modifiers changed from: private */
    public static int dp2px(Context context, float f) {
        return ScreenUtil.dip2px(context, (double) f);
    }

    private View findEditText(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof EditText) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View findEditText = findEditText(viewGroup.getChildAt(i));
                if (findEditText != null) {
                    return findEditText;
                }
            }
        }
        return null;
    }

    private int getCustomPanelChildCount(ViewGroup viewGroup) {
        View childAt = viewGroup.getChildAt(0);
        if (childAt instanceof ViewGroup) {
            return ((ViewGroup) childAt).getChildCount();
        }
        return 0;
    }

    private static float getRawDimension(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return TypedValue.complexToFloat(typedValue.data);
    }

    private int getScreenHeight() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager == null) {
            return this.mContext.getResources().getDisplayMetrics().heightPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private int getScreenWidth() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager == null) {
            return this.mContext.getResources().getDisplayMetrics().widthPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private int getTextWidth(TextView textView, CharSequence charSequence) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, textView);
        }
        int i = 0;
        for (String measureText : charSequence.toString().split(StringUtils.LF)) {
            i = Math.max(i, (int) textView.getPaint().measureText(measureText));
        }
        return i;
    }

    private int getTitleWidth() {
        int i;
        int i2;
        ImageView imageView;
        int i3 = 0;
        if (!TextUtils.isEmpty(this.mTitle)) {
            View findViewById = this.mWindow.findViewById(R.id.title_template);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            int i4 = layoutParams.leftMargin + layoutParams.rightMargin;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTitleView.getLayoutParams();
            i = i4 + layoutParams2.leftMargin + layoutParams2.rightMargin;
            int paddingLeft = this.mTitleView.getPaddingLeft() + this.mTitleView.getPaddingRight() + findViewById.getPaddingLeft() + findViewById.getPaddingRight();
            if (!((this.mIconId == 0 && this.mIcon == null) || (imageView = this.mIconView) == null || imageView.getVisibility() != 0)) {
                int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.mz_alert_dialog_title_icon_width) + this.mIconView.getPaddingLeft() + this.mIconView.getPaddingRight();
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mIconView.getLayoutParams();
                i3 = dimensionPixelSize + layoutParams3.leftMargin + layoutParams3.rightMargin;
            }
            i2 = i3;
            i3 = paddingLeft;
        } else {
            i2 = 0;
            i = 0;
        }
        return this.mAlertDialogWidth - ((i3 + i) + i2);
    }

    private boolean hasEditText() {
        View view = this.mView;
        if (view instanceof EditText) {
            return true;
        }
        if (view instanceof ViewGroup) {
            return isEditInViewGroup((ViewGroup) view);
        }
        return false;
    }

    private boolean isButtonLayoutVertical(int i) {
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_button_padding);
        if (calcButtonCount(i) < 1) {
            return false;
        }
        int calcButtonWidth = calcButtonWidth(i) - (dimensionPixelOffset * 2);
        Button button = this.mButtonPositive;
        if (button != null && button.getVisibility() == 0 && getTextWidth(this.mButtonPositive, this.mButtonPositiveText) > calcButtonWidth) {
            return true;
        }
        Button button2 = this.mButtonNegative;
        if (button2 != null && button2.getVisibility() == 0 && getTextWidth(this.mButtonNegative, this.mButtonNegativeText) > calcButtonWidth) {
            return true;
        }
        Button button3 = this.mButtonNeutral;
        return (button3 != null && button3.getVisibility() == 0 && getTextWidth(this.mButtonNeutral, this.mButtonNeutralText) > calcButtonWidth) || this.mActionDialog || this.mListView != null || this.mIsSingleMultiLines;
    }

    private boolean isCustomViewSpacingSpecified(@NonNull View view) {
        if (!(view instanceof EditText) && view.getPaddingLeft() != 0) {
            return true;
        }
        if (view.getLayoutParams() != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin != 0) {
            return true;
        }
        if (view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup.getId() != R.id.customPanel) {
            return isCustomViewSpacingSpecified(viewGroup);
        }
        return false;
    }

    private boolean isEditInViewGroup(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EditText) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && isEditInViewGroup((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMessageViewOneLine() {
        if (this.mMessageView == null || TextUtils.isEmpty(this.mMessage)) {
            return true;
        }
        if (this.mMessage.toString().split(StringUtils.LF).length > 1) {
            return false;
        }
        return (getTextWidth(this.mMessageView, this.mMessage) + this.mMessageView.getPaddingLeft()) + this.mMessageView.getPaddingRight() <= this.mAlertDialogWidth;
    }

    private boolean isTitleViewOneLine() {
        int i;
        if (TextUtils.isEmpty(this.mTitle)) {
            i = 0;
        } else if (this.mTitle.toString().split(StringUtils.LF).length > 1) {
            return false;
        } else {
            i = getTextWidth(this.mTitleView, this.mTitle);
        }
        return i <= getTitleWidth();
    }

    public static void manageScrollIndicators(View view, View view2, View view3) {
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

    @Nullable
    private ViewGroup resolvePanel(@Nullable View view, @Nullable View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int selectContentView() {
        int i = this.mButtonPanelSideLayout;
        return i == 0 ? this.mAlertDialogLayout : this.mButtonPanelLayoutHint == 1 ? i : this.mAlertDialogLayout;
    }

    /* access modifiers changed from: private */
    public void setMultiLinesStyleItemSize(int i) {
        this.mMultiLinesStyleItemSize = i;
    }

    private void setScrollIndicators(ViewGroup viewGroup, View view, int i, int i2) {
        final View findViewById = this.mWindow.findViewById(R.id.scrollIndicatorUp);
        final View findViewById2 = this.mWindow.findViewById(R.id.scrollIndicatorDown);
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById != null || findViewById2 != null) {
            if (this.mMessage != null) {
                this.mScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                    public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        FlymeAlertController.manageScrollIndicators(nestedScrollView, findViewById, findViewById2);
                    }
                });
                this.mScrollView.postDelayed(new Runnable() {
                    public void run() {
                        FlymeAlertController.manageScrollIndicators(FlymeAlertController.this.mScrollView, findViewById, findViewById2);
                    }
                }, 100);
                return;
            }
            ListView listView = this.mListView;
            if (listView != null) {
                listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        FlymeAlertController.manageScrollIndicators(absListView, findViewById, findViewById2);
                    }

                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }
                });
                this.mListView.postDelayed(new Runnable() {
                    public void run() {
                        FlymeAlertController.manageScrollIndicators(FlymeAlertController.this.mListView, findViewById, findViewById2);
                    }
                }, 100);
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
            }
        }
    }

    private void setupButtons(ViewGroup viewGroup) {
        int i;
        Button button = (Button) viewGroup.findViewById(16908313);
        this.mButtonPositive = button;
        button.setOnClickListener(this.mButtonHandler);
        boolean z = false;
        addTargetView(this.mButtonPositive, false);
        if (!TextUtils.isEmpty(this.mButtonPositiveText) || this.mButtonPositiveIcon != null) {
            this.mButtonPositive.setText(this.mButtonPositiveText);
            Drawable drawable = this.mButtonPositiveIcon;
            if (drawable != null) {
                int i2 = this.mButtonIconDimen;
                drawable.setBounds(0, 0, i2, i2);
                this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.mButtonPositive.setVisibility(0);
            i = 1;
        } else {
            this.mButtonPositive.setVisibility(8);
            i = 0;
        }
        Button button2 = (Button) viewGroup.findViewById(16908314);
        this.mButtonNegative = button2;
        button2.setOnClickListener(this.mButtonHandler);
        addTargetView(this.mButtonNegative, false);
        if (!TextUtils.isEmpty(this.mButtonNegativeText) || this.mButtonNegativeIcon != null) {
            this.mButtonNegative.setText(this.mButtonNegativeText);
            Drawable drawable2 = this.mButtonNegativeIcon;
            if (drawable2 != null) {
                int i3 = this.mButtonIconDimen;
                drawable2.setBounds(0, 0, i3, i3);
                this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.mButtonNegative.setVisibility(0);
            i |= 2;
        } else {
            this.mButtonNegative.setVisibility(8);
        }
        Button button3 = (Button) viewGroup.findViewById(16908315);
        this.mButtonNeutral = button3;
        button3.setOnClickListener(this.mButtonHandler);
        addTargetView(this.mButtonNeutral, false);
        if (!TextUtils.isEmpty(this.mButtonNeutralText) || this.mButtonNeutralIcon != null) {
            this.mButtonNeutral.setText(this.mButtonNeutralText);
            Drawable drawable3 = this.mButtonPositiveIcon;
            if (drawable3 != null) {
                int i4 = this.mButtonIconDimen;
                drawable3.setBounds(0, 0, i4, i4);
                this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.mButtonNeutral.setVisibility(0);
            i |= 4;
        } else {
            this.mButtonNeutral.setVisibility(8);
        }
        if (i == 0) {
            viewGroup.setVisibility(8);
        } else if (this.mButtonNeutral.getParent() instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) this.mButtonNeutral.getParent();
            if (isButtonLayoutVertical(i)) {
                linearLayout.setOrientation(1);
                linearLayout.setGravity(1);
                linearLayout.removeAllViews();
                if (this.mActionDialog || this.mListView != null || this.mIsSingleMultiLines) {
                    View view = new View(this.mContext);
                    view.setBackgroundColor(this.mContext.getResources().getColor(R.color.fd_sys_color_outline_variant_default));
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, this.mDividerHeight);
                    int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_normal_margin_start);
                    marginLayoutParams.setMargins(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                    linearLayout.addView(view, marginLayoutParams);
                }
                linearLayout.addView(this.mButtonPositive);
                linearLayout.addView(this.mButtonNeutral);
                linearLayout.addView(this.mButtonNegative);
                int calcButtonHighLight = calcButtonHighLight(i);
                applyVerticalButtonStyle(this.mButtonPositive, 1, i, 1 == calcButtonHighLight);
                applyVerticalButtonStyle(this.mButtonNegative, 2, i, 2 == calcButtonHighLight);
                Button button4 = this.mButtonNeutral;
                if (4 == calcButtonHighLight) {
                    z = true;
                }
                applyVerticalButtonStyle(button4, 4, i, z);
                return;
            }
            linearLayout.setOrientation(0);
            linearLayout.setGravity(1);
            int calcButtonHighLight2 = calcButtonHighLight(i);
            applyHorizontalButtonStyle(this.mButtonPositive, 1, i, 1 == calcButtonHighLight2);
            applyHorizontalButtonStyle(this.mButtonNegative, 2, i, 2 == calcButtonHighLight2);
            Button button5 = this.mButtonNeutral;
            if (4 == calcButtonHighLight2) {
                z = true;
            }
            applyHorizontalButtonStyle(button5, 4, i, z);
        }
    }

    private void setupContent(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.mWindow.findViewById(R.id.scrollView);
        this.mScrollView = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.mMessageView = textView;
        if (textView != null) {
            cancelFallbackLineSpacing(textView);
            CharSequence charSequence = this.mMessage;
            if (charSequence != null) {
                this.mMessageView.setText(charSequence);
                this.mMessageView.setVisibility(0);
                MovementMethod movementMethod = this.mMessageMovementMethod;
                if (movementMethod != null) {
                    this.mMessageView.setMovementMethod(movementMethod);
                    return;
                }
                return;
            }
            this.mMessageView.setVisibility(8);
            this.mScrollView.removeView(this.mMessageView);
            if (this.mListView != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.mScrollView.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.mScrollView);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.mListView, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void setupCustomContent(ViewGroup viewGroup) {
        View view = this.mView;
        boolean z = false;
        if (view == null) {
            view = this.mViewLayoutResId != 0 ? LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, viewGroup, false) : null;
        }
        if (view != null) {
            z = true;
        }
        this.hasCustomView = z;
        if (!z || !canTextInput(view)) {
            this.mWindow.setFlags(131072, 131072);
        }
        if (this.hasCustomView) {
            FrameLayout frameLayout = (FrameLayout) this.mWindow.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.mViewSpacingSpecified) {
                frameLayout.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            }
            if (this.mListView != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setupSpaceView(android.view.View r21, android.view.View r22, android.view.View r23, android.view.View r24) {
        /*
            r20 = this;
            r0 = r20
            r1 = 1
            r2 = 0
            if (r21 == 0) goto L_0x000e
            int r3 = r21.getVisibility()
            if (r3 != 0) goto L_0x000e
            r3 = r1
            goto L_0x000f
        L_0x000e:
            r3 = r2
        L_0x000f:
            if (r22 == 0) goto L_0x0019
            int r4 = r22.getVisibility()
            if (r4 != 0) goto L_0x0019
            r4 = r1
            goto L_0x001a
        L_0x0019:
            r4 = r2
        L_0x001a:
            if (r23 == 0) goto L_0x0024
            int r5 = r23.getVisibility()
            if (r5 != 0) goto L_0x0024
            r5 = r1
            goto L_0x0025
        L_0x0024:
            r5 = r2
        L_0x0025:
            if (r24 == 0) goto L_0x002f
            int r6 = r24.getVisibility()
            if (r6 != 0) goto L_0x002f
            r6 = r1
            goto L_0x0030
        L_0x002f:
            r6 = r2
        L_0x0030:
            android.view.Window r7 = r0.mWindow
            int r8 = flyme.support.v7.appcompat.R.id.dialogSpace1
            android.view.View r7 = r7.findViewById(r8)
            r10 = r7
            android.widget.Space r10 = (android.widget.Space) r10
            android.view.Window r7 = r0.mWindow
            int r8 = flyme.support.v7.appcompat.R.id.dialogSpace2
            android.view.View r7 = r7.findViewById(r8)
            r11 = r7
            android.widget.Space r11 = (android.widget.Space) r11
            android.view.Window r7 = r0.mWindow
            int r8 = flyme.support.v7.appcompat.R.id.dialogSpace3
            android.view.View r7 = r7.findViewById(r8)
            r12 = r7
            android.widget.Space r12 = (android.widget.Space) r12
            android.view.Window r7 = r0.mWindow
            int r8 = flyme.support.v7.appcompat.R.id.dialogSpace4
            android.view.View r7 = r7.findViewById(r8)
            r13 = r7
            android.widget.Space r13 = (android.widget.Space) r13
            if (r4 != 0) goto L_0x0063
            if (r5 == 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r4 = r2
            goto L_0x0064
        L_0x0063:
            r4 = 2
        L_0x0064:
            r3 = r3 | r4
            if (r6 == 0) goto L_0x0069
            r4 = 4
            goto L_0x006a
        L_0x0069:
            r4 = r2
        L_0x006a:
            r3 = r3 | r4
            boolean r4 = r0.mCustomPaddingRule
            if (r4 == 0) goto L_0x008d
            boolean r4 = r0.mIsSingleMultiLines
            if (r4 != 0) goto L_0x008d
            flyme.support.v7.app.FlymeAlertController$PaddingRule r3 = new flyme.support.v7.app.FlymeAlertController$PaddingRule
            int r4 = r0.mPaddingSpace1
            int r6 = r0.mPaddingSpace2
            int r7 = r0.mPaddingSpace3
            int r8 = r0.mPaddingSpace4
            r15 = 0
            r14 = r3
            r16 = r4
            r17 = r6
            r18 = r7
            r19 = r8
            r14.<init>(r15, r16, r17, r18, r19)
        L_0x008a:
            r8 = r3
            goto L_0x00f4
        L_0x008d:
            android.widget.ListView r4 = r0.mListView
            if (r4 == 0) goto L_0x00b0
            boolean r6 = r0.mActionDialog
            if (r6 == 0) goto L_0x00ad
            android.widget.ListAdapter r4 = r4.getAdapter()
            if (r4 == 0) goto L_0x00aa
            android.widget.ListView r4 = r0.mListView
            android.widget.ListAdapter r4 = r4.getAdapter()
            int r4 = r4.getCount()
            if (r4 != r1) goto L_0x00aa
            java.util.List<flyme.support.v7.app.FlymeAlertController$PaddingRule> r4 = sSingleActionPaddingRules
            goto L_0x00d0
        L_0x00aa:
            java.util.List<flyme.support.v7.app.FlymeAlertController$PaddingRule> r4 = sActionListPaddingRules
            goto L_0x00d0
        L_0x00ad:
            java.util.List<flyme.support.v7.app.FlymeAlertController$PaddingRule> r4 = sListPaddingRules
            goto L_0x00d0
        L_0x00b0:
            boolean r4 = r0.mIsSingleMultiLines
            if (r4 == 0) goto L_0x00b7
            java.util.List<flyme.support.v7.app.FlymeAlertController$PaddingRule> r4 = sListPaddingRules
            goto L_0x00d0
        L_0x00b7:
            if (r5 == 0) goto L_0x00c5
            boolean r4 = r20.hasEditText()
            if (r4 == 0) goto L_0x00c2
            java.util.List<flyme.support.v7.app.FlymeAlertController$PaddingRule> r4 = sCustomViewRules
            goto L_0x00d0
        L_0x00c2:
            java.util.List<flyme.support.v7.app.FlymeAlertController$PaddingRule> r4 = sPaddingRules
            goto L_0x00d0
        L_0x00c5:
            boolean r4 = r20.isMessageViewOneLine()
            if (r4 == 0) goto L_0x00ce
            java.util.List<flyme.support.v7.app.FlymeAlertController$PaddingRule> r4 = sSingleMessagePaddingRules
            goto L_0x00d0
        L_0x00ce:
            java.util.List<flyme.support.v7.app.FlymeAlertController$PaddingRule> r4 = sPaddingRules
        L_0x00d0:
            java.util.Iterator r4 = r4.iterator()
        L_0x00d4:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x00e7
            java.lang.Object r6 = r4.next()
            flyme.support.v7.app.FlymeAlertController$PaddingRule r6 = (flyme.support.v7.app.FlymeAlertController.PaddingRule) r6
            int r7 = r6.mask
            if (r3 != r7) goto L_0x00d4
            goto L_0x00e8
        L_0x00e7:
            r6 = 0
        L_0x00e8:
            if (r6 != 0) goto L_0x00f3
            java.util.List<flyme.support.v7.app.FlymeAlertController$PaddingRule> r3 = sPaddingRules
            java.lang.Object r3 = r3.get(r2)
            flyme.support.v7.app.FlymeAlertController$PaddingRule r3 = (flyme.support.v7.app.FlymeAlertController.PaddingRule) r3
            goto L_0x008a
        L_0x00f3:
            r8 = r6
        L_0x00f4:
            android.view.Window r3 = r0.mWindow
            int r4 = flyme.support.v7.appcompat.R.id.custom
            android.view.View r3 = r3.findViewById(r4)
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            if (r5 == 0) goto L_0x010e
            boolean r4 = r20.hasEditText()
            if (r4 == 0) goto L_0x010e
            int r3 = r0.getCustomPanelChildCount(r3)
            if (r3 <= r1) goto L_0x010e
            r14 = r1
            goto L_0x010f
        L_0x010e:
            r14 = r2
        L_0x010f:
            android.content.Context r9 = r0.mContext
            r8.applyRule(r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.app.FlymeAlertController.setupSpaceView(android.view.View, android.view.View, android.view.View, android.view.View):void");
    }

    private void setupTitle(ViewGroup viewGroup) {
        if (this.mCustomTitleView != null) {
            viewGroup.addView(this.mCustomTitleView, 0, new ViewGroup.LayoutParams(-1, -2));
            this.mWindow.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.mIconView = (ImageView) this.mWindow.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.mTitle)) || !this.mShowTitle) {
            this.mWindow.findViewById(R.id.title_template).setVisibility(8);
            this.mIconView.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.mWindow.findViewById(R.id.alertTitle);
        this.mTitleView = textView;
        textView.setText(this.mTitle);
        cancelFallbackLineSpacing(this.mTitleView);
        int i = this.mIconId;
        if (i != 0) {
            this.mIconView.setImageResource(i);
            return;
        }
        Drawable drawable = this.mIcon;
        if (drawable != null) {
            this.mIconView.setImageDrawable(drawable);
            return;
        }
        this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
        this.mIconView.setVisibility(8);
    }

    private void setupView() {
        ListAdapter listAdapter;
        View view;
        View findViewById;
        View findViewById2;
        View findViewById3 = this.mWindow.findViewById(R.id.parentPanel);
        View findViewById4 = findViewById3.findViewById(R.id.topPanel);
        View findViewById5 = findViewById3.findViewById(R.id.contentPanel);
        View findViewById6 = findViewById3.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R.id.customPanel);
        setupCustomContent(viewGroup);
        View findViewById7 = viewGroup.findViewById(R.id.topPanel);
        View findViewById8 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById9 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup resolvePanel = resolvePanel(findViewById7, findViewById4);
        ViewGroup resolvePanel2 = resolvePanel(findViewById8, findViewById5);
        ViewGroup resolvePanel3 = resolvePanel(findViewById9, findViewById6);
        setupContent(resolvePanel2);
        setupButtons(resolvePanel3);
        setupTitle(resolvePanel);
        char c = 0;
        boolean z = viewGroup.getVisibility() != 8;
        boolean z2 = (resolvePanel == null || resolvePanel.getVisibility() == 8) ? false : true;
        boolean z3 = (resolvePanel3 == null || resolvePanel3.getVisibility() == 8) ? false : true;
        if (!(z3 || resolvePanel2 == null || (findViewById2 = resolvePanel2.findViewById(androidx.appcompat.R.id.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z2) {
            NestedScrollView nestedScrollView = this.mScrollView;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View findViewById10 = (this.mMessage == null && this.mListView == null) ? null : resolvePanel.findViewById(R.id.titleDividerNoCustom);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        } else if (!(resolvePanel2 == null || (findViewById = resolvePanel2.findViewById(R.id.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.mListView;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z2, z3);
        }
        if (!z && !this.mActionDialog && (view = this.mListView) == null) {
            if (view == null) {
                view = this.mScrollView;
            }
            if (view != null) {
                if (z3) {
                    c = 2;
                }
                setScrollIndicators(resolvePanel2, view, z2 | c ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.mListView;
        if (!(listView2 == null || (listAdapter = this.mAdapter) == null)) {
            listView2.setAdapter(listAdapter);
            int i = this.mCheckedItem;
            if (i > -1) {
                listView2.setItemChecked(i, true);
                listView2.setSelection(i);
            }
        }
        setupSpaceView(resolvePanel, resolvePanel2, viewGroup, resolvePanel3);
    }

    private static boolean shouldCenterSingleButton(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    private void textViewAdapterGravity(final TextView textView) {
        if (textView != null && textView.getVisibility() == 0 && !TextUtils.isEmpty(textView.getText())) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    textView.setGravity(textView.getLineCount() > 1 ? 8388611 : 17);
                }
            });
        }
    }

    public void applyMeizuStyle() {
        View findEditText;
        TextView textView = this.mTitleView;
        boolean z = false;
        boolean z2 = textView != null && textView.getVisibility() == 0;
        ImageView imageView = this.mIconView;
        boolean z3 = imageView != null && imageView.getVisibility() == 0;
        if (this.mListView != null && this.mActionDialog && z2) {
            applyMessageTextAppearance(this.mTitleView);
        }
        if (z2 && !z3 && isTitleViewOneLine()) {
            this.mTitleView.setGravity(17);
        }
        TextView textView2 = this.mTitleView;
        if (textView2 != null) {
            TextViewUtils.adaptiveTextSizeIfNeed(textView2, getTitleWidth());
        }
        TextView textView3 = this.mMessageView;
        if (textView3 != null && textView3.getVisibility() == 0) {
            z = true;
        }
        textViewAdapterGravity(this.mMessageView);
        if (!z2 && z) {
            applyTitleTextAppearance(this.mMessageView);
        }
        ListView listView = this.mListView;
        if (listView != null && this.mActionDialog) {
            listView.setDivider((Drawable) null);
        }
        ViewGroup viewGroup = (ViewGroup) this.mWindow.findViewById(R.id.customPanel);
        if (!(viewGroup == null || viewGroup.getVisibility() == 8 || this.mViewSpacingSpecified || (findEditText = findEditText(viewGroup)) == null)) {
            if (this.mContext.getApplicationInfo().targetSdkVersion >= 28) {
                findEditText.requestFocus();
            }
            if (!isCustomViewSpacingSpecified(findEditText)) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ((FrameLayout) this.mWindow.findViewById(R.id.custom)).getLayoutParams();
                layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelOffset(com.meizu.common.R.dimen.mz_alert_dialog_edittext_padding_left);
                layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelOffset(com.meizu.common.R.dimen.mz_alert_dialog_edittext_padding_right);
            }
        }
        WindowManager.LayoutParams attributes = this.mWindow.getAttributes();
        attributes.width = this.mAlertDialogWidth;
        if (this.mMaxHeight == 0) {
            this.mMaxHeight = (getScreenHeight() - ResourceUtils.getStatusBarHeight(this.mContext)) - this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_margin_bottom_to_screen);
        }
        FlymeAlertDialogLayout flymeAlertDialogLayout = (FlymeAlertDialogLayout) this.mWindow.findViewById(R.id.parentPanel);
        if (flymeAlertDialogLayout != null) {
            flymeAlertDialogLayout.setMaxHeight(this.mMaxHeight);
        }
        int i = this.mGravity;
        if (i != 0) {
            attributes.gravity = i;
        } else {
            attributes.gravity = 80;
        }
        int i2 = attributes.gravity;
        if (i2 == 80) {
            attributes.y = this.mContext.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_margin_bottom_to_screen);
        } else if (i2 == 17 && this.mContext.getResources().getConfiguration().orientation == 2) {
            attributes.y = (-this.mContext.getResources().getDimensionPixelSize(InternalResUtils.getInternalResId(1, "status_bar_height"))) / 2;
        }
        if (this.mAutoShowSoftInput) {
            this.mWindow.setSoftInputMode(37);
        }
        this.mWindow.setElevation(0.0f);
    }

    public Button getButton(int i) {
        if (i == -3) {
            return this.mButtonNeutral;
        }
        if (i == -2) {
            return this.mButtonNegative;
        }
        if (i != -1) {
            return null;
        }
        return this.mButtonPositive;
    }

    public int getIconAttributeResId(int i) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public void installContent() {
        this.mDialog.setContentView(selectContentView());
        setupView();
        applyMeizuStyle();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mScrollView;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mScrollView;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public void setAutoShowSoftInput(boolean z) {
        this.mAutoShowSoftInput = z;
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.mHandler.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.mButtonNeutralText = charSequence;
            this.mButtonNeutralMessage = message;
            this.mButtonNeutralIcon = drawable;
        } else if (i == -2) {
            this.mButtonNegativeText = charSequence;
            this.mButtonNegativeMessage = message;
            this.mButtonNegativeIcon = drawable;
        } else if (i == -1) {
            this.mButtonPositiveText = charSequence;
            this.mButtonPositiveMessage = message;
            this.mButtonPositiveIcon = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void setButtonPanelLayoutHint(int i) {
        this.mButtonPanelLayoutHint = i;
    }

    public void setButtonTextColor(int i, int i2) {
        Button button;
        AppCompatDialog appCompatDialog = this.mDialog;
        if ((appCompatDialog instanceof AlertDialog) && (button = ((AlertDialog) appCompatDialog).getButton(i)) != null) {
            button.setTextColor(createColorList(i2));
        }
    }

    public void setCustomPaddingRule(int i, int i2, int i3, int i4) {
        this.mCustomPaddingRule = true;
        this.mPaddingSpace1 = i;
        this.mPaddingSpace2 = i2;
        this.mPaddingSpace3 = i3;
        this.mPaddingSpace4 = i4;
    }

    public void setCustomTitle(View view) {
        this.mCustomTitleView = view;
    }

    public void setGravity(int i) {
        this.mGravity = i;
    }

    public void setHighLightButton(int i, int i2) {
        this.mHighLightButton = i;
        this.mHighLightColor = i2;
    }

    public void setIcon(int i) {
        this.mIcon = null;
        this.mIconId = i;
        ImageView imageView = this.mIconView;
        if (imageView == null) {
            return;
        }
        if (i != 0) {
            imageView.setVisibility(0);
            this.mIconView.setImageResource(this.mIconId);
            return;
        }
        imageView.setVisibility(8);
    }

    public void setMaxHeight(int i) {
        this.mMaxHeight = (int) (((float) i) * this.mDensityRatio);
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence;
        TextView textView = this.mMessageView;
        if (textView != null) {
            textView.setText(charSequence);
            this.mMessageView.setVisibility(0);
        }
    }

    public void setMessageMovementMethod(MovementMethod movementMethod) {
        this.mMessageMovementMethod = movementMethod;
        TextView textView = this.mMessageView;
        if (textView != null) {
            textView.setMovementMethod(movementMethod);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setUpAnimation() {
        Window window = this.mDialog.getWindow();
        double computeDialogHeightRatio = computeDialogHeightRatio();
        boolean hasEditText = hasEditText();
        StringBuilder sb = new StringBuilder();
        sb.append("setUpAnimation, hasEditText:");
        sb.append(hasEditText);
        sb.append(",dialog type:");
        int i = (computeDialogHeightRatio > 0.33000001311302185d ? 1 : (computeDialogHeightRatio == 0.33000001311302185d ? 0 : -1));
        sb.append(i < 0 ? "small" : computeDialogHeightRatio < 0.6499999761581421d ? "medium" : "large");
        sb.append(" heightRatio ");
        sb.append(computeDialogHeightRatio);
        sb.append(" hasEditText ");
        sb.append(hasEditText);
        Log.i(TAG, sb.toString());
        int i2 = i < 0 ? hasEditText ? com.meizu.common.R.style.Animation_Flyme_Dialog_Alert_Input_Short : com.meizu.common.R.style.Animation_Flyme_Dialog_Alert_Short : computeDialogHeightRatio < 0.6499999761581421d ? hasEditText ? com.meizu.common.R.style.Animation_Flyme_Dialog_Alert_Input_Medium : com.meizu.common.R.style.Animation_Flyme_Dialog_Alert_Medium : com.meizu.common.R.style.Animation_Flyme_Dialog_Alert_Tall;
        if (window != null) {
            window.setWindowAnimations(i2);
        }
    }

    public void setView(int i) {
        this.mView = null;
        this.mViewLayoutResId = i;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public static class ListItemCenterAdapter extends ArrayAdapter {
        Context context;
        private int resourceId;
        CharSequence[] strings;
        ColorStateList textColor;
        ColorStateList[] textColors;
        private int textViewResourceId;

        public ListItemCenterAdapter(Context context2, int i, int i2, CharSequence[] charSequenceArr, ColorStateList colorStateList) {
            super(context2, i, i2, charSequenceArr);
            this.context = context2;
            this.resourceId = i;
            this.textViewResourceId = i2;
            this.strings = charSequenceArr;
            this.textColor = colorStateList;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(this.resourceId, (ViewGroup) null);
                viewHolder = new ViewHolder();
                viewHolder.item = (TextView) view.findViewById(this.textViewResourceId);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.item.setText(this.strings[i]);
            ColorStateList[] colorStateListArr = this.textColors;
            if (colorStateListArr != null) {
                viewHolder.item.setTextColor(colorStateListArr[i]);
            } else {
                ColorStateList colorStateList = this.textColor;
                if (colorStateList != null) {
                    viewHolder.item.setTextColor(colorStateList);
                }
            }
            return view;
        }

        public boolean hasStableIds() {
            return true;
        }

        public ListItemCenterAdapter(Context context2, int i, int i2, CharSequence[] charSequenceArr, ColorStateList[] colorStateListArr) {
            super(context2, i, i2, charSequenceArr);
            this.context = context2;
            this.resourceId = i;
            this.textViewResourceId = i2;
            this.strings = charSequenceArr;
            this.textColors = colorStateListArr;
        }

        public ListItemCenterAdapter(Context context2, int i, int i2, CharSequence[] charSequenceArr) {
            super(context2, i, i2, charSequenceArr);
            this.context = context2;
            this.resourceId = i;
            this.textViewResourceId = i2;
            this.strings = charSequenceArr;
        }
    }

    public static class AlertParamsWrapper {
        /* access modifiers changed from: private */
        public AlertController.AlertParams mAlertParams;

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

        public AlertParamsWrapper(AlertController.AlertParams alertParams) {
            this.mAlertParams = alertParams;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: flyme.support.v7.app.FlymeAlertController$CheckedItemAdapter} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: android.widget.SimpleCursorAdapter} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: flyme.support.v7.app.FlymeAlertController$CheckedItemAdapter} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: flyme.support.v7.app.FlymeAlertController$CheckedItemAdapter} */
        /* JADX WARNING: type inference failed for: r12v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r12v14 */
        /* JADX WARNING: type inference failed for: r12v15 */
        /* JADX WARNING: type inference failed for: r13v4, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r12v17 */
        /* JADX WARNING: type inference failed for: r12v18 */
        /* JADX WARNING: type inference failed for: r12v19 */
        /* JADX WARNING: type inference failed for: r0v38, types: [flyme.support.v7.app.FlymeAlertController$AlertParamsWrapper$3] */
        /* JADX WARNING: type inference failed for: r0v39, types: [flyme.support.v7.app.FlymeAlertController$AlertParamsWrapper$2] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void createListView(flyme.support.v7.app.FlymeAlertController r20) {
            /*
                r19 = this;
                r7 = r19
                r8 = r20
                flyme.support.v7.app.AlertController$AlertParams r0 = r7.mAlertParams
                android.view.LayoutInflater r0 = r0.mInflater
                int r1 = r8.mListLayout
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                r9 = r0
                flyme.support.v7.app.FlymeAlertController$RecycleListView r9 = (flyme.support.v7.app.FlymeAlertController.RecycleListView) r9
                flyme.support.v7.app.AlertController$AlertParams r0 = r7.mAlertParams
                boolean r1 = r0.mIsMultiChoice
                r10 = 0
                if (r1 == 0) goto L_0x0049
                int r11 = r8.mMultiChoiceItemLayout
                android.database.Cursor r0 = r0.mCursor
                if (r0 != 0) goto L_0x0035
                flyme.support.v7.app.FlymeAlertController$AlertParamsWrapper$2 r12 = new flyme.support.v7.app.FlymeAlertController$AlertParamsWrapper$2
                flyme.support.v7.app.AlertController$AlertParams r0 = r7.mAlertParams
                android.content.Context r2 = r0.mContext
                int r3 = r8.mMultiChoiceItemLayout
                r4 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r5 = r0.mItems
                r0 = r12
                r1 = r19
                r6 = r9
                r0.<init>(r2, r3, r4, r5, r6)
                goto L_0x010d
            L_0x0035:
                flyme.support.v7.app.FlymeAlertController$AlertParamsWrapper$3 r12 = new flyme.support.v7.app.FlymeAlertController$AlertParamsWrapper$3
                flyme.support.v7.app.AlertController$AlertParams r0 = r7.mAlertParams
                android.content.Context r2 = r0.mContext
                android.database.Cursor r3 = r0.mCursor
                r4 = 0
                r0 = r12
                r1 = r19
                r5 = r9
                r6 = r20
                r0.<init>(r2, r3, r4, r5, r6)
                goto L_0x010d
            L_0x0049:
                boolean r1 = r0.mIsListItemCenter
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L_0x00d4
                int r11 = r20.mCenterListItemLayout
                flyme.support.v7.app.AlertController$AlertParams r0 = r7.mAlertParams
                android.database.Cursor r1 = r0.mCursor
                if (r1 != 0) goto L_0x00b5
                android.widget.ListAdapter r12 = r0.mAdapter
                if (r12 == 0) goto L_0x0061
            L_0x005e:
                r11 = r10
                goto L_0x010d
            L_0x0061:
                android.content.res.ColorStateList[] r1 = r0.mListItemColors
                if (r1 == 0) goto L_0x0082
                flyme.support.v7.app.FlymeAlertController$ListItemCenterAdapter r0 = new flyme.support.v7.app.FlymeAlertController$ListItemCenterAdapter
                flyme.support.v7.app.AlertController$AlertParams r1 = r7.mAlertParams
                android.content.Context r13 = r1.mContext
                int r14 = r20.mCenterListItemLayout
                flyme.support.v7.app.AlertController$AlertParams r1 = r7.mAlertParams
                java.lang.CharSequence[] r2 = r1.mItems
                android.content.res.ColorStateList[] r1 = r1.mListItemColors
                r15 = 16908308(0x1020014, float:2.3877285E-38)
                r12 = r0
                r16 = r2
                r17 = r1
                r12.<init>((android.content.Context) r13, (int) r14, (int) r15, (java.lang.CharSequence[]) r16, (android.content.res.ColorStateList[]) r17)
                goto L_0x010d
            L_0x0082:
                android.content.res.ColorStateList r0 = r0.mListItemColor
                if (r0 == 0) goto L_0x00a3
                flyme.support.v7.app.FlymeAlertController$ListItemCenterAdapter r0 = new flyme.support.v7.app.FlymeAlertController$ListItemCenterAdapter
                flyme.support.v7.app.AlertController$AlertParams r1 = r7.mAlertParams
                android.content.Context r13 = r1.mContext
                int r14 = r20.mCenterListItemLayout
                flyme.support.v7.app.AlertController$AlertParams r1 = r7.mAlertParams
                java.lang.CharSequence[] r2 = r1.mItems
                android.content.res.ColorStateList r1 = r1.mListItemColor
                r15 = 16908308(0x1020014, float:2.3877285E-38)
                r12 = r0
                r16 = r2
                r17 = r1
                r12.<init>((android.content.Context) r13, (int) r14, (int) r15, (java.lang.CharSequence[]) r16, (android.content.res.ColorStateList) r17)
                goto L_0x010d
            L_0x00a3:
                flyme.support.v7.app.FlymeAlertController$ListItemCenterAdapter r12 = new flyme.support.v7.app.FlymeAlertController$ListItemCenterAdapter
                flyme.support.v7.app.AlertController$AlertParams r0 = r7.mAlertParams
                android.content.Context r0 = r0.mContext
                int r1 = r20.mCenterListItemLayout
                flyme.support.v7.app.AlertController$AlertParams r3 = r7.mAlertParams
                java.lang.CharSequence[] r3 = r3.mItems
                r12.<init>(r0, r1, r2, r3)
                goto L_0x010d
            L_0x00b5:
                android.widget.SimpleCursorAdapter r12 = new android.widget.SimpleCursorAdapter
                flyme.support.v7.app.AlertController$AlertParams r0 = r7.mAlertParams
                android.content.Context r14 = r0.mContext
                int r15 = r20.mCenterListItemLayout
                flyme.support.v7.app.AlertController$AlertParams r0 = r7.mAlertParams
                android.database.Cursor r1 = r0.mCursor
                java.lang.String r0 = r0.mLabelColumn
                java.lang.String[] r17 = new java.lang.String[]{r0}
                int[] r18 = new int[]{r2}
                r13 = r12
                r16 = r1
                r13.<init>(r14, r15, r16, r17, r18)
                goto L_0x010d
            L_0x00d4:
                boolean r1 = r0.mIsSingleChoice
                if (r1 == 0) goto L_0x00db
                int r1 = r8.mSingleChoiceItemLayout
                goto L_0x00dd
            L_0x00db:
                int r1 = r8.mListItemLayout
            L_0x00dd:
                android.database.Cursor r3 = r0.mCursor
                if (r3 == 0) goto L_0x00fb
                android.widget.SimpleCursorAdapter r0 = new android.widget.SimpleCursorAdapter
                flyme.support.v7.app.AlertController$AlertParams r3 = r7.mAlertParams
                android.content.Context r12 = r3.mContext
                android.database.Cursor r14 = r3.mCursor
                java.lang.String r3 = r3.mLabelColumn
                java.lang.String[] r15 = new java.lang.String[]{r3}
                int[] r16 = new int[]{r2}
                r11 = r0
                r13 = r1
                r11.<init>(r12, r13, r14, r15, r16)
                r12 = r0
            L_0x00f9:
                r11 = r1
                goto L_0x010d
            L_0x00fb:
                android.widget.ListAdapter r12 = r0.mAdapter
                if (r12 == 0) goto L_0x0101
                goto L_0x005e
            L_0x0101:
                flyme.support.v7.app.FlymeAlertController$CheckedItemAdapter r12 = new flyme.support.v7.app.FlymeAlertController$CheckedItemAdapter
                flyme.support.v7.app.AlertController$AlertParams r0 = r7.mAlertParams
                android.content.Context r3 = r0.mContext
                java.lang.CharSequence[] r0 = r0.mItems
                r12.<init>(r3, r1, r2, r0)
                goto L_0x00f9
            L_0x010d:
                flyme.support.v7.app.AlertController$AlertParams r0 = r7.mAlertParams
                flyme.support.v7.app.AlertController$AlertParams$OnPrepareListViewListener r0 = r0.mOnPrepareListViewListener
                if (r0 == 0) goto L_0x0116
                r0.onPrepareListView(r9)
            L_0x0116:
                r8.mAdapter = r12
                flyme.support.v7.app.AlertController$AlertParams r0 = r7.mAlertParams
                int r1 = r0.mCheckedItem
                r8.mCheckedItem = r1
                android.content.DialogInterface$OnClickListener r1 = r0.mOnClickListener
                if (r1 == 0) goto L_0x012b
                flyme.support.v7.app.FlymeAlertController$AlertParamsWrapper$4 r0 = new flyme.support.v7.app.FlymeAlertController$AlertParamsWrapper$4
                r0.<init>(r8)
                r9.setOnItemClickListener(r0)
                goto L_0x0137
            L_0x012b:
                android.content.DialogInterface$OnMultiChoiceClickListener r0 = r0.mOnCheckboxClickListener
                if (r0 == 0) goto L_0x0137
                flyme.support.v7.app.FlymeAlertController$AlertParamsWrapper$5 r0 = new flyme.support.v7.app.FlymeAlertController$AlertParamsWrapper$5
                r0.<init>(r9, r8)
                r9.setOnItemClickListener(r0)
            L_0x0137:
                flyme.support.v7.app.AlertController$AlertParams r0 = r7.mAlertParams
                android.widget.AdapterView$OnItemSelectedListener r0 = r0.mOnItemSelectedListener
                if (r0 == 0) goto L_0x0140
                r9.setOnItemSelectedListener(r0)
            L_0x0140:
                flyme.support.v7.app.AlertController$AlertParams r0 = r7.mAlertParams
                android.content.Context r0 = r0.mContext
                android.content.res.Resources r0 = r0.getResources()
                int r1 = flyme.support.v7.appcompat.R.dimen.mz_alert_dialog_listview_choice_padding
                int r0 = r0.getDimensionPixelOffset(r1)
                if (r11 <= 0) goto L_0x0161
                int r1 = com.meizu.common.R.layout.mz_select_dialog_singlechoice
                if (r11 == r1) goto L_0x0158
                int r1 = com.meizu.common.R.layout.mz_select_dialog_multichoice
                if (r11 != r1) goto L_0x0161
            L_0x0158:
                r9.setPadding(r0, r10, r0, r10)
                r0 = 17170445(0x106000d, float:2.461195E-38)
                r9.setSelector(r0)
            L_0x0161:
                flyme.support.v7.app.AlertController$AlertParams r0 = r7.mAlertParams
                boolean r1 = r0.mIsSingleChoice
                if (r1 == 0) goto L_0x016c
                r0 = 1
                r9.setChoiceMode(r0)
                goto L_0x0174
            L_0x016c:
                boolean r0 = r0.mIsMultiChoice
                if (r0 == 0) goto L_0x0174
                r0 = 2
                r9.setChoiceMode(r0)
            L_0x0174:
                r8.mListView = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.app.FlymeAlertController.AlertParamsWrapper.createListView(flyme.support.v7.app.FlymeAlertController):void");
        }

        private void createLocalRecyclerView(FlymeAlertController flymeAlertController) {
            final MzRecyclerView mzRecyclerView;
            View view;
            AlertController.AlertParams alertParams = this.mAlertParams;
            if (alertParams.mCheckedItems == null) {
                view = LayoutInflater.from(alertParams.mContext).inflate(flymeAlertController.mMultiLinesChoiceItemLayout, (ViewGroup) null);
                mzRecyclerView = (MzRecyclerView) view.findViewById(R.id.select_dialog_recycler_view);
                AlertController.AlertParams alertParams2 = this.mAlertParams;
                if (alertParams2.mCheckedItem <= alertParams2.mItemData.size()) {
                    AppCompatDialog appCompatDialog = flymeAlertController.mDialog;
                    AlertController.AlertParams alertParams3 = this.mAlertParams;
                    mzRecyclerView.setAdapter(new MultiLineItemAdapter((DialogInterface) appCompatDialog, alertParams3.mContext, flymeAlertController.mRecyclerViewItemSingleLayout, alertParams3.mItemData, alertParams3.mCheckedItem));
                } else {
                    return;
                }
            } else {
                view = LayoutInflater.from(alertParams.mContext).inflate(flymeAlertController.mMultiLinesChoiceItemLayout, (ViewGroup) null);
                mzRecyclerView = (MzRecyclerView) view.findViewById(R.id.select_dialog_recycler_view);
                AppCompatDialog appCompatDialog2 = flymeAlertController.mDialog;
                AlertController.AlertParams alertParams4 = this.mAlertParams;
                mzRecyclerView.setAdapter(new MultiLineItemAdapter((DialogInterface) appCompatDialog2, alertParams4.mContext, flymeAlertController.mRecyclerViewItemMultiLayout, alertParams4.mItemData, alertParams4.mCheckedItems));
            }
            mzRecyclerView.addItemDecoration(new MzRecyclerView.ItemDecoration() {
                public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
                    if (recyclerView.getChildAdapterPosition(view) != 0) {
                        rect.top = (int) ResourceUtils.dp2px(4.0f, mzRecyclerView.getContext());
                    }
                }
            });
            mzRecyclerView.setLayoutManager(new LinearLayoutManager(this.mAlertParams.mContext));
            mzRecyclerView.setOverScrollEnable(false);
            this.mAlertParams.mView = view;
        }

        public void apply(FlymeAlertController flymeAlertController) {
            AlertController.AlertParams alertParams = this.mAlertParams;
            View view = alertParams.mCustomTitleView;
            if (view != null) {
                flymeAlertController.setCustomTitle(view);
            } else {
                CharSequence charSequence = alertParams.mTitle;
                if (charSequence != null) {
                    flymeAlertController.setTitle(charSequence);
                }
                Drawable drawable = this.mAlertParams.mIcon;
                if (drawable != null) {
                    flymeAlertController.setIcon(drawable);
                }
                int i = this.mAlertParams.mIconId;
                if (i != 0) {
                    flymeAlertController.setIcon(i);
                }
                int i2 = this.mAlertParams.mIconAttrId;
                if (i2 != 0) {
                    flymeAlertController.setIcon(flymeAlertController.getIconAttributeResId(i2));
                }
            }
            CharSequence charSequence2 = this.mAlertParams.mMessage;
            if (charSequence2 != null) {
                flymeAlertController.setMessage(charSequence2);
            }
            AlertController.AlertParams alertParams2 = this.mAlertParams;
            CharSequence charSequence3 = alertParams2.mPositiveButtonText;
            if (!(charSequence3 == null && alertParams2.mPositiveButtonIcon == null)) {
                flymeAlertController.setButton(-1, charSequence3, alertParams2.mPositiveButtonListener, (Message) null, alertParams2.mPositiveButtonIcon);
            }
            AlertController.AlertParams alertParams3 = this.mAlertParams;
            CharSequence charSequence4 = alertParams3.mNegativeButtonText;
            if (!(charSequence4 == null && alertParams3.mNegativeButtonIcon == null)) {
                flymeAlertController.setButton(-2, charSequence4, alertParams3.mNegativeButtonListener, (Message) null, alertParams3.mNegativeButtonIcon);
            }
            AlertController.AlertParams alertParams4 = this.mAlertParams;
            CharSequence charSequence5 = alertParams4.mNeutralButtonText;
            if (!(charSequence5 == null && alertParams4.mNeutralButtonIcon == null)) {
                flymeAlertController.setButton(-3, charSequence5, alertParams4.mNeutralButtonListener, (Message) null, alertParams4.mNeutralButtonIcon);
            }
            AlertController.AlertParams alertParams5 = this.mAlertParams;
            if (!(alertParams5.mItems == null && alertParams5.mCursor == null && alertParams5.mAdapter == null)) {
                createListView(flymeAlertController);
                AlertController.AlertParams alertParams6 = this.mAlertParams;
                if (alertParams6.mNegativeButtonText == null && alertParams6.mNegativeButtonIcon == null && alertParams6.mPositiveButtonText == null && alertParams6.mPositiveButtonIcon == null && alertParams6.mNeutralButtonText == null && alertParams6.mNeutralButtonIcon == null) {
                    flymeAlertController.setButton(-2, alertParams6.mContext.getText(com.meizu.common.R.string.mc_cancel), new OnNegativeListener(), (Message) null, this.mAlertParams.mNegativeButtonIcon);
                }
            }
            if (this.mAlertParams.mIsSingleMultiLines) {
                boolean unused = flymeAlertController.mIsSingleMultiLines = true;
                createLocalRecyclerView(flymeAlertController);
                flymeAlertController.setMultiLinesStyleItemSize(this.mAlertParams.mItemData.size());
                flymeAlertController.setButton(-2, this.mAlertParams.mContext.getText(com.meizu.common.R.string.mc_cancel), new OnNegativeListener(), (Message) null, this.mAlertParams.mNegativeButtonIcon);
            }
            AlertController.AlertParams alertParams7 = this.mAlertParams;
            View view2 = alertParams7.mView;
            if (view2 == null) {
                int i3 = alertParams7.mViewLayoutResId;
                if (i3 != 0) {
                    flymeAlertController.setView(i3);
                }
            } else if (alertParams7.mViewSpacingSpecified) {
                flymeAlertController.setView(view2, alertParams7.mViewSpacingLeft, alertParams7.mViewSpacingTop, alertParams7.mViewSpacingRight, alertParams7.mViewSpacingBottom);
            } else {
                flymeAlertController.setView(view2);
            }
            flymeAlertController.setGravity(this.mAlertParams.mGravity);
            flymeAlertController.setMaxHeight(this.mAlertParams.mMaxHeight);
            AlertController.AlertParams alertParams8 = this.mAlertParams;
            flymeAlertController.setHighLightButton(alertParams8.mHighLightButton, alertParams8.mHighLightColor);
        }

        public class MultiLineItemAdapter extends RecyclerView.Adapter {
            /* access modifiers changed from: private */
            public DialogInterface mDialogInterface;
            private final LayoutInflater mInflater;
            private boolean mIsMultiSelect;
            private final ArrayList<Pair<String, String>> mItemData;
            private final int mLayoutResourceId;
            /* access modifiers changed from: private */
            public int mSelectPosition = -1;
            private boolean[] mSelectPositions;

            public class MultiLineViewHolder extends RecyclerView.ViewHolder {
                CheckBox mCheckBox;
                TextView mDetailTextView;
                TextView mTitleTextView;
                MzMultiLinesCheckLayout mzMultiLinesCheckLayout;

                public MultiLineViewHolder(MzMultiLinesCheckLayout mzMultiLinesCheckLayout2) {
                    super(mzMultiLinesCheckLayout2);
                    this.mzMultiLinesCheckLayout = mzMultiLinesCheckLayout2;
                    this.mTitleTextView = (TextView) mzMultiLinesCheckLayout2.findViewById(R.id.alert_title_multi_line_text_view);
                    this.mDetailTextView = (TextView) mzMultiLinesCheckLayout2.findViewById(R.id.alert_detail_multi_line_text_view);
                    this.mCheckBox = (CheckBox) mzMultiLinesCheckLayout2.findViewById(R.id.alert_title_multi_line_check_box);
                }
            }

            public class SingleLineViewHolder extends RecyclerView.ViewHolder {
                TextView mDetailTextView;
                ImageView mImageView;
                MzMultiLinesCheckLayout mMzCheckBoxMultiText;
                TextView mTitleTextView;

                public SingleLineViewHolder(MzMultiLinesCheckLayout mzMultiLinesCheckLayout) {
                    super(mzMultiLinesCheckLayout);
                    this.mMzCheckBoxMultiText = mzMultiLinesCheckLayout;
                    this.mTitleTextView = (TextView) mzMultiLinesCheckLayout.findViewById(R.id.alert_title_multi_line_text_view);
                    this.mDetailTextView = (TextView) mzMultiLinesCheckLayout.findViewById(R.id.alert_detail_multi_line_text_view);
                    this.mImageView = (ImageView) mzMultiLinesCheckLayout.findViewById(R.id.alert_title_multi_line_check_box_single);
                }
            }

            public MultiLineItemAdapter(DialogInterface dialogInterface, Context context, int i, ArrayList<Pair<String, String>> arrayList, int i2) {
                this.mDialogInterface = dialogInterface;
                this.mInflater = LayoutInflater.from(context);
                this.mLayoutResourceId = i;
                this.mItemData = arrayList;
                this.mSelectPosition = i2;
                this.mIsMultiSelect = false;
            }

            /* access modifiers changed from: private */
            public void updateItemBackgroundColor(TextView textView, TextView textView2, boolean z) {
                if (z) {
                    int identifierByAttrId = ResourceUtils.getIdentifierByAttrId(R.attr.colorBrand, AlertParamsWrapper.this.mAlertParams.mContext);
                    textView.setTextColor(AlertParamsWrapper.this.mAlertParams.mContext.getResources().getColor(identifierByAttrId));
                    textView2.setTextColor(AlertParamsWrapper.this.mAlertParams.mContext.getResources().getColor(identifierByAttrId));
                    return;
                }
                textView.setTextColor(AlertParamsWrapper.this.mAlertParams.mContext.getResources().getColor(ResourceUtils.getIdentifierByAttrId(R.attr.colorOnSurface, AlertParamsWrapper.this.mAlertParams.mContext)));
                textView2.setTextColor(AlertParamsWrapper.this.mAlertParams.mContext.getResources().getColor(ResourceUtils.getIdentifierByAttrId(R.attr.colorOnSurfaceVariant, AlertParamsWrapper.this.mAlertParams.mContext)));
            }

            public int getItemCount() {
                return this.mItemData.size();
            }

            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) int i) {
                Pair pair = this.mItemData.get(i);
                if (this.mIsMultiSelect) {
                    final MultiLineViewHolder multiLineViewHolder = (MultiLineViewHolder) viewHolder;
                    multiLineViewHolder.itemView.setTag(Integer.valueOf(i));
                    multiLineViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            CheckBox checkBox = multiLineViewHolder.mCheckBox;
                            checkBox.setChecked(!checkBox.isChecked());
                            MultiLineViewHolder multiLineViewHolder = multiLineViewHolder;
                            multiLineViewHolder.mzMultiLinesCheckLayout.setChecked(multiLineViewHolder.mCheckBox.isChecked());
                            MultiLineItemAdapter multiLineItemAdapter = MultiLineItemAdapter.this;
                            MultiLineViewHolder multiLineViewHolder2 = multiLineViewHolder;
                            multiLineItemAdapter.updateItemBackgroundColor(multiLineViewHolder2.mTitleTextView, multiLineViewHolder2.mDetailTextView, multiLineViewHolder2.mCheckBox.isChecked());
                            if (AlertParamsWrapper.this.mAlertParams.mOnCheckboxClickListener != null) {
                                AlertParamsWrapper.this.mAlertParams.mOnCheckboxClickListener.onClick(MultiLineItemAdapter.this.mDialogInterface, multiLineViewHolder.getLayoutPosition(), multiLineViewHolder.mCheckBox.isChecked());
                            }
                        }
                    });
                    if (this.mSelectPositions[i]) {
                        multiLineViewHolder.mzMultiLinesCheckLayout.setChecked(true);
                        CheckBox checkBox = multiLineViewHolder.mCheckBox;
                        checkBox.setChecked(!checkBox.isChecked());
                    }
                    updateItemBackgroundColor(multiLineViewHolder.mTitleTextView, multiLineViewHolder.mDetailTextView, multiLineViewHolder.mCheckBox.isChecked());
                    multiLineViewHolder.mTitleTextView.setText((CharSequence) pair.first);
                    multiLineViewHolder.mDetailTextView.setText((CharSequence) pair.second);
                    return;
                }
                final SingleLineViewHolder singleLineViewHolder = (SingleLineViewHolder) viewHolder;
                singleLineViewHolder.itemView.setTag(Integer.valueOf(i));
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint({"NotifyDataSetChanged"})
                    public void onClick(View view) {
                        int unused = MultiLineItemAdapter.this.mSelectPosition = singleLineViewHolder.getLayoutPosition();
                        singleLineViewHolder.mMzCheckBoxMultiText.setChecked(true);
                        if (AlertParamsWrapper.this.mAlertParams.mOnClickListener != null) {
                            AlertParamsWrapper.this.mAlertParams.mOnClickListener.onClick(MultiLineItemAdapter.this.mDialogInterface, singleLineViewHolder.getLayoutPosition());
                        }
                        MultiLineItemAdapter.this.notifyDataSetChanged();
                    }
                });
                if (i == this.mSelectPosition) {
                    singleLineViewHolder.mImageView.setVisibility(0);
                    singleLineViewHolder.mMzCheckBoxMultiText.setChecked(true);
                } else {
                    singleLineViewHolder.mImageView.setVisibility(4);
                    singleLineViewHolder.mMzCheckBoxMultiText.setChecked(false);
                }
                updateItemBackgroundColor(singleLineViewHolder.mTitleTextView, singleLineViewHolder.mDetailTextView, singleLineViewHolder.mMzCheckBoxMultiText.isChecked());
                singleLineViewHolder.mTitleTextView.setText((CharSequence) pair.first);
                singleLineViewHolder.mDetailTextView.setText((CharSequence) pair.second);
            }

            @NonNull
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                MzMultiLinesCheckLayout mzMultiLinesCheckLayout = (MzMultiLinesCheckLayout) this.mInflater.inflate(this.mLayoutResourceId, viewGroup, false);
                return this.mIsMultiSelect ? new MultiLineViewHolder(mzMultiLinesCheckLayout) : new SingleLineViewHolder(mzMultiLinesCheckLayout);
            }

            public MultiLineItemAdapter(DialogInterface dialogInterface, Context context, int i, ArrayList<Pair<String, String>> arrayList, boolean[] zArr) {
                this.mDialogInterface = dialogInterface;
                this.mInflater = LayoutInflater.from(context);
                this.mLayoutResourceId = i;
                this.mItemData = arrayList;
                this.mSelectPositions = zArr;
                this.mIsMultiSelect = true;
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        this.mIconId = 0;
        ImageView imageView = this.mIconView;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.mIconView.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = i;
        this.mViewSpacingTop = i2;
        this.mViewSpacingRight = i3;
        this.mViewSpacingBottom = i4;
    }
}

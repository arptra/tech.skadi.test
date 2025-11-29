package flyme.support.v7.view.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.view.ViewCompat;
import com.meizu.common.animator.MzPressAnimationDrawable;
import com.meizu.common.animator.MzPressAnimationHelper;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.view.menu.MenuBuilder;
import flyme.support.v7.view.menu.MenuView;
import flyme.support.v7.widget.ActionMenuView;

@SuppressLint({"RestrictedApi"})
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, View.OnClickListener, View.OnLongClickListener, ActionMenuView.ActionMenuChildView {
    private static final int MAX_ICON_SIZE = 24;
    private static final int NO_ALPHA = 255;
    private static final int[] PRESSED_STATE_SET = {16842919};
    private static final String TAG = "ActionMenuItemView";
    private boolean mAllowTextWithIcon;
    private Drawable mBackgroundOnlyText;
    private float mDisabledAlpha;
    private int mDrawablePadding;
    private boolean mExpandedFormat;
    private ForwardingListener mForwardingListener;
    private final MzPressAnimationHelper mHelper;
    private Drawable mIcon;
    private int mIconNormalAlpha;
    private boolean mIsInSplit;
    private boolean mIsInitialize;
    private boolean mIsOverflowActor;
    /* access modifiers changed from: private */
    public MenuItemImpl mItemData;
    /* access modifiers changed from: private */
    public MenuBuilder.ItemInvoker mItemInvoker;
    private int mMaxIconSize;
    private int mMinWidth;
    private final Paint mPaint;
    /* access modifiers changed from: private */
    public PopupCallback mPopupCallback;
    private float mPressedAlpha;
    private int mSavedPaddingLeft;
    private Drawable mSplitBackground;
    private final int mSpotColor;
    private final float mSpotRadius;
    private CharSequence mTitle;

    public class ActionMenuItemForwardingListener extends ForwardingListener {
        public ActionMenuItemForwardingListener() {
            super(ActionMenuItemView.this);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x001b, code lost:
            r3 = getPopup();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onForwardingStarted() {
            /*
                r3 = this;
                flyme.support.v7.view.menu.ActionMenuItemView r0 = flyme.support.v7.view.menu.ActionMenuItemView.this
                flyme.support.v7.view.menu.MenuBuilder$ItemInvoker r0 = r0.mItemInvoker
                r1 = 0
                if (r0 == 0) goto L_0x0028
                flyme.support.v7.view.menu.ActionMenuItemView r0 = flyme.support.v7.view.menu.ActionMenuItemView.this
                flyme.support.v7.view.menu.MenuBuilder$ItemInvoker r0 = r0.mItemInvoker
                flyme.support.v7.view.menu.ActionMenuItemView r2 = flyme.support.v7.view.menu.ActionMenuItemView.this
                flyme.support.v7.view.menu.MenuItemImpl r2 = r2.mItemData
                boolean r0 = r0.invokeItem(r2)
                if (r0 == 0) goto L_0x0028
                androidx.appcompat.widget.ListPopupWindow r3 = r3.getPopup()
                if (r3 == 0) goto L_0x0028
                boolean r3 = r3.isShowing()
                if (r3 == 0) goto L_0x0028
                r1 = 1
            L_0x0028:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.view.menu.ActionMenuItemView.ActionMenuItemForwardingListener.onForwardingStarted():boolean");
        }

        public ListPopupWindow getPopup() {
            if (ActionMenuItemView.this.mPopupCallback != null) {
                return ActionMenuItemView.this.mPopupCallback.getPopup();
            }
            return null;
        }
    }

    public static abstract class PopupCallback {
        public abstract ListPopupWindow getPopup();
    }

    public ActionMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    private int measureTextWidth() {
        return (int) getPaint().measureText(getText().toString());
    }

    private void setCompoundDrawables(boolean z) {
        setCompoundDrawables(z ? null : this.mIcon, z ? this.mIcon : null, (Drawable) null, (Drawable) null);
    }

    private void updateTextAppearance(boolean z) {
        int[] iArr;
        setBackground(getBackground());
        if (this.mIcon != null && z) {
            iArr = this.mIsInSplit ? new int[]{R.attr.mzActionMenuTextAppearanceWithIconSplit} : new int[]{R.attr.mzActionMenuTextAppearanceWithIcon};
        } else if (this.mIsInSplit) {
            iArr = new int[]{R.attr.mzActionMenuTextAppearanceSplit};
            setBackground(this.mSplitBackground);
        } else {
            iArr = new int[]{androidx.appcompat.R.attr.actionMenuTextAppearance};
        }
        int resourceId = getContext().getTheme().obtainStyledAttributes(iArr).getResourceId(0, -1);
        if (resourceId > 0) {
            setTextAppearance(getContext(), resourceId);
        }
    }

    private void updateTextButtonVisibility() {
        if (!this.mIsInitialize) {
            boolean z = true;
            boolean z2 = !TextUtils.isEmpty(this.mTitle);
            if (this.mIcon != null && (!this.mItemData.showsTextAsAction() || (!this.mAllowTextWithIcon && !this.mExpandedFormat))) {
                z = false;
            }
            boolean z3 = z2 & z;
            setText(z3 ? this.mTitle : null);
            updateTextAppearance(z3);
            setCompoundDrawables(z3);
            if (z3 && this.mIcon != null && this.mIsInSplit) {
                setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
            } else if (this.mIcon != null) {
                setPadding(getPaddingLeft(), getPaddingLeft(), getPaddingRight(), getPaddingRight());
            } else {
                setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
            setGravity(17);
            if (z3 && this.mIcon == null) {
                setBackground(AppCompatResources.b(getContext(), R.drawable.press_anim_background_4dp));
            }
            Drawable drawable = this.mIcon;
            if (drawable != null && this.mIsInSplit) {
                this.mHelper.addTargetDrawable(drawable);
                final Drawable b = AppCompatResources.b(getContext(), R.drawable.action_menu_split_background_8dp);
                if (!TextUtils.isEmpty(getText()) && (b instanceof MzPressAnimationDrawable)) {
                    final int measureTextWidth = measureTextWidth();
                    final int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.mz_action_menu_bottom_drawable_padding_vertical) * 2;
                    final int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(R.dimen.mz_action_menu_bottom_drawable_padding_horizontal) * 2;
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        public void onGlobalLayout() {
                            ActionMenuItemView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            int height = ActionMenuItemView.this.getHeight() - dimensionPixelOffset;
                            ((MzPressAnimationDrawable) b).setStickyBounds(Math.max(measureTextWidth > (ActionMenuItemView.this.getWidth() - ActionMenuItemView.this.getPaddingStart()) - ActionMenuItemView.this.getPaddingEnd() ? (ActionMenuItemView.this.getWidth() - ActionMenuItemView.this.getPaddingStart()) - ActionMenuItemView.this.getPaddingEnd() : measureTextWidth + dimensionPixelOffset2, height), height);
                            ActionMenuItemView.this.setBackground(b);
                        }
                    });
                }
            }
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        MenuItemImpl menuItemImpl = this.mItemData;
        if (menuItemImpl != null && this.mIcon != null && this.mIsInSplit) {
            if (!menuItemImpl.isEnabled() && !isPressed()) {
                isFocused();
            }
            this.mIcon.mutate();
            if (isPressed()) {
                boolean z = this.mIcon instanceof DrawableContainer;
            }
        }
    }

    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.mItemData = menuItemImpl;
        boolean z = true;
        this.mIsInitialize = true;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitleForItemView(this));
        setId(menuItemImpl.getItemId());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
        setEllipsize(TextUtils.TruncateAt.MIDDLE);
        setSelected(menuItemImpl.isSelected());
        if (menuItemImpl.hasSubMenu() && this.mForwardingListener == null) {
            this.mForwardingListener = new ActionMenuItemForwardingListener();
        }
        setIsOverflowActor(menuItemImpl.isOverflowActor());
        if (this.mIcon != null) {
            if (this.mItemData.isEnabled() || (!isPressed() && isFocused())) {
                z = false;
            }
            this.mIcon.mutate();
            this.mIcon.setAlpha(z ? (int) (this.mDisabledAlpha * ((float) this.mIconNormalAlpha)) : this.mIconNormalAlpha);
        }
        this.mIsInitialize = false;
        updateTextButtonVisibility();
        if (menuItemImpl.getTitleColor() != null) {
            setTextColor(menuItemImpl.getTitleColor());
        }
    }

    public boolean isOverflowActor() {
        return this.mIsOverflowActor;
    }

    public boolean needsDividerAfter() {
        return hasText();
    }

    public boolean needsDividerBefore() {
        return hasText() && this.mItemData.getIcon() == null;
    }

    public void onClick(View view) {
        MenuBuilder.ItemInvoker itemInvoker = this.mItemInvoker;
        if (itemInvoker != null) {
            itemInvoker.invokeItem(this.mItemData);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mAllowTextWithIcon = getContext().getResources().getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
        updateTextButtonVisibility();
    }

    public void onDraw(Canvas canvas) {
        if (getRight() - getLeft() != 0 || getMeasuredWidth() <= 0) {
            if (!TextUtils.isEmpty(getText()) && this.mIcon == null && this.mItemData.isLittleSpotVisible()) {
                Layout layout = getLayout();
                float measuredWidth = (float) ((getMeasuredWidth() / 2) + (layout.getWidth() / 2));
                float f = this.mSpotRadius;
                canvas.drawCircle(measuredWidth + f, (float) ((getMeasuredHeight() / 2) - (layout.getHeight() / 2)), f, this.mPaint);
            }
            super.onDraw(canvas);
            return;
        }
        getParent().requestLayout();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean onLongClick(View view) {
        if (hasText()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        int i2 = iArr[0] + (width / 2);
        if (ViewCompat.z(view) == 0) {
            i2 = context.getResources().getDisplayMetrics().widthPixels - i2;
        }
        Toast makeText = Toast.makeText(context, this.mItemData.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, i2, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        boolean hasText = hasText();
        if (hasText && (i3 = this.mSavedPaddingLeft) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.mMinWidth) : this.mMinWidth;
        if (mode != 1073741824 && this.mMinWidth > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (!hasText && this.mIcon != null) {
            super.setPadding((getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        if (this.mItemData.isLittleSpotVisible()) {
            Drawable drawable = this.mIcon;
            if (drawable instanceof ActionMenuItemIconDrawable) {
                ((ActionMenuItemIconDrawable) drawable).measureSpot();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener;
        Drawable drawable;
        int action = motionEvent.getAction();
        if (action == 0) {
            Drawable drawable2 = this.mIcon;
            if (drawable2 != null && this.mIsInSplit) {
                this.mHelper.changeDrawableState(drawable2, true);
            }
        } else if ((action == 1 || action == 3) && (drawable = this.mIcon) != null && this.mIsInSplit) {
            this.mHelper.changeDrawableState(drawable, false);
        }
        if (!this.mItemData.hasSubMenu() || (forwardingListener = this.mForwardingListener) == null || !forwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.mExpandedFormat != z) {
            this.mExpandedFormat = z;
            MenuItemImpl menuItemImpl = this.mItemData;
            if (menuItemImpl != null) {
                menuItemImpl.actionFormatChanged();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        if (drawable != null) {
            ActionMenuItemIconDrawable actionMenuItemIconDrawable = new ActionMenuItemIconDrawable(getContext(), drawable);
            actionMenuItemIconDrawable.setSpotVisible(this.mItemData.isLittleSpotVisible());
            actionMenuItemIconDrawable.setSpotCount(this.mItemData.getLittleSpotCount());
            this.mIcon = actionMenuItemIconDrawable;
            int intrinsicWidth = actionMenuItemIconDrawable.getIntrinsicWidth();
            int intrinsicHeight = actionMenuItemIconDrawable.getIntrinsicHeight();
            int i = this.mMaxIconSize;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i) / ((float) intrinsicWidth)));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i) / ((float) intrinsicHeight)));
            } else {
                i = intrinsicHeight;
            }
            if (this.mIsInSplit) {
                actionMenuItemIconDrawable.setBounds(0, getContext().getResources().getDimensionPixelSize(R.dimen.mz_split_action_bar_default_margin), intrinsicWidth, i + getContext().getResources().getDimensionPixelSize(R.dimen.mz_split_action_bar_default_margin));
            } else {
                actionMenuItemIconDrawable.setBounds(0, 0, intrinsicWidth, i);
            }
        }
        updateTextButtonVisibility();
    }

    public void setIsInSplit(boolean z) {
        this.mIsInSplit = z;
    }

    public void setIsOverflowActor(boolean z) {
        this.mIsOverflowActor = z;
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.mItemInvoker = itemInvoker;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mSavedPaddingLeft = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.mPopupCallback = popupCallback;
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        setContentDescription(charSequence);
        updateTextButtonVisibility();
    }

    public void setTitleMaxLines(int i) {
        setMaxLines(i);
    }

    public boolean showsIcon() {
        return true;
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIconNormalAlpha = 255;
        this.mSpotColor = -65536;
        this.mHelper = new MzPressAnimationHelper();
        Resources resources = context.getResources();
        this.mAllowTextWithIcon = resources.getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i, 0);
        this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionMenuItemView_android_minWidth, 0);
        this.mPressedAlpha = obtainStyledAttributes.getFloat(R.styleable.ActionMenuItemView_mzItemIconPressedAlpha, 1.0f);
        this.mSplitBackground = obtainStyledAttributes.getDrawable(R.styleable.ActionMenuItemView_mzItemBackgroundSplit);
        this.mBackgroundOnlyText = obtainStyledAttributes.getDrawable(R.styleable.ActionMenuItemView_mzItemBackgroundOnlyText);
        this.mDrawablePadding = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionMenuItemView_mzItemDrawablePadding, 0);
        obtainStyledAttributes.recycle();
        this.mMaxIconSize = (int) ((resources.getDisplayMetrics().density * 24.0f) + 0.5f);
        setOnClickListener(this);
        this.mSavedPaddingLeft = -1;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.MenuView, i, 0);
        this.mDisabledAlpha = obtainStyledAttributes2.getFloat(androidx.appcompat.R.styleable.MenuView_android_itemIconDisabledAlpha, 1.0f);
        obtainStyledAttributes2.recycle();
        this.mSpotRadius = context.getResources().getDimension(com.meizu.common.R.dimen.mc_new_message_view_radius);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setColor(-65536);
        paint.setStyle(Paint.Style.FILL);
        setIncludeFontPadding(false);
    }
}

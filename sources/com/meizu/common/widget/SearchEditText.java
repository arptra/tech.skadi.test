package com.meizu.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.ContentObserver;
import android.net.Uri;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.honey.account.u2.e;
import com.meizu.common.R;

public class SearchEditText extends EditText {
    private static final String DARK_MODE_CHANGE = "flymelab_flyme_night_mode";
    private static final String SOFT_DARK_MODE_VALUE = "flyme_dark_mode_preference_color";
    private static final String TAG = "SearchEditText";
    private final Uri darkModeChanged;
    private boolean isNightMode;
    private final int mNormalBackground;
    private final int mSoftNightBackground;
    private final ContentObserver nightModeObserver;
    private final Uri softDarkModeChanged;

    public SearchEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @RequiresApi
    /* renamed from: applyPaddingValue */
    public void lambda$new$0(Context context) {
        Pair<Integer, Integer> behindImageFontCompatView = behindImageFontCompatView();
        float f = context.getResources().getConfiguration().fontScale;
        if (behindImageFontCompatView != null && f > 1.0f) {
            setPadding(context.getResources().getDimensionPixelSize(R.dimen.mc_search_edit_margin_start) + ((Integer) behindImageFontCompatView.second).intValue() + ((Integer) behindImageFontCompatView.first).intValue(), getPaddingTop(), getPaddingEnd(), getPaddingBottom());
        }
    }

    @RequiresApi
    private Pair<Integer, Integer> behindImageFontCompatView() {
        if (!(getParent() instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int[] iArr = new int[2];
        getLocationInSurface(iArr);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ImageFontCompatView) {
                int[] iArr2 = new int[2];
                childAt.getLocationInSurface(iArr2);
                if (iArr2[0] < iArr[0] + (getWidth() / 2)) {
                    return new Pair<>(Integer.valueOf(Math.abs(iArr2[0] - iArr[0])), Integer.valueOf(childAt.getWidth()));
                }
            }
        }
        return null;
    }

    private void hideSoftInput() {
        if (getContext() != null && getWindowToken() != null) {
            ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 2);
        }
    }

    private boolean isNightMode(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }

    private void showSoftInput() {
        if (getContext() != null) {
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
        }
    }

    /* access modifiers changed from: private */
    public void updateResBetweenNightMode() {
        updateResBetweenNightMode(false);
    }

    public boolean isInputComplete() {
        return BaseInputConnection.getComposingSpanStart(getEditableText()) == -1;
    }

    public boolean isSoftNightMode() {
        if (!this.isNightMode) {
            return false;
        }
        return "#262626".equals(Settings.Global.getString(getContext().getContentResolver(), SOFT_DARK_MODE_VALUE));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isNightMode = isNightMode(getContext().getResources().getConfiguration());
        getContext().getContentResolver().registerContentObserver(this.softDarkModeChanged, false, this.nightModeObserver);
        getContext().getContentResolver().registerContentObserver(this.darkModeChanged, false, this.nightModeObserver);
        updateResBetweenNightMode();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean isNightMode2 = isNightMode(configuration);
        if (isNightMode2 != this.isNightMode) {
            this.isNightMode = isNightMode2;
            updateResBetweenNightMode(true);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().getContentResolver().unregisterContentObserver(this.nightModeObserver);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SearchEditText.class.getName());
    }

    public void showIme(boolean z) {
        if (z) {
            requestFocus();
            showSoftInput();
            return;
        }
        clearFocus();
        hideSoftInput();
    }

    public SearchEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void updateResBetweenNightMode(boolean z) {
        int i;
        if (isSoftNightMode()) {
            i = this.mSoftNightBackground;
        } else {
            i = this.mNormalBackground;
        }
        if (z) {
            setBackground(ContextCompat.getDrawable(getContext(), i));
        } else {
            setBackgroundResource(i);
        }
    }

    public SearchEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.softDarkModeChanged = Settings.Global.getUriFor(SOFT_DARK_MODE_VALUE);
        this.darkModeChanged = Settings.Global.getUriFor(DARK_MODE_CHANGE);
        this.nightModeObserver = new ContentObserver(getHandler()) {
            public void onChange(boolean z) {
                SearchEditText.this.updateResBetweenNightMode();
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SearchEditText);
        this.mNormalBackground = obtainStyledAttributes.getResourceId(R.styleable.SearchEditText_searchEditNormalBackground, R.drawable.mz_titlebar_search_view_edittext_bg);
        this.mSoftNightBackground = obtainStyledAttributes.getResourceId(R.styleable.SearchEditText_searchEditSoftNightBackground, R.drawable.mz_titlebar_search_view_edittext_soft_night_mode_bg);
        obtainStyledAttributes.recycle();
        float f = context.getResources().getConfiguration().fontScale;
        Log.i(TAG, "fontScale:" + f);
        if (f > 1.0f) {
            post(new e(this, context));
        }
    }
}

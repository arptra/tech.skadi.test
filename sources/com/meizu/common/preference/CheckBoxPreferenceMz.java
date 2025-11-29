package com.meizu.common.preference;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Checkable;
import com.meizu.common.R;
import com.meizu.common.widget.MzContactsContract;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CheckBoxPreferenceMz extends CheckBoxPreference {
    private static Method sPerformClick;
    private static Field sRecycle;
    private View mTextLayout;
    private View.OnClickListener mTextLayoutClickListener;
    private boolean mTextLayoutEnabled;
    private View.OnLongClickListener mTextLayoutLongClickListener;
    private View mWidgetFrame;
    private boolean mWidgetFrameEnabled;

    public CheckBoxPreferenceMz(Context context) {
        this(context, (AttributeSet) null);
    }

    private void mzShouldRecycle() {
        try {
            if (sRecycle == null) {
                Field declaredField = Preference.class.getDeclaredField("mCanRecycleLayout");
                sRecycle = declaredField;
                declaredField.setAccessible(true);
            }
            sRecycle.set(this, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void performClick() {
        try {
            if (sPerformClick == null) {
                Method method = CheckBoxPreference.class.getMethod("performClick", new Class[]{PreferenceScreen.class});
                sPerformClick = method;
                method.setAccessible(true);
            }
            sPerformClick.invoke(this, new Object[]{null});
        } catch (Exception unused) {
        }
    }

    private void setEnabledStateOnViews(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                setEnabledStateOnViews(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public boolean isTextLayoutEnabled() {
        return this.mTextLayoutEnabled;
    }

    public boolean isWidgetFrameEnabled() {
        return this.mWidgetFrameEnabled;
    }

    public void onBindView(View view) {
        boolean z;
        boolean z2;
        super.onBindView(view);
        if (isEnabled() && !(z2 = this.mTextLayoutEnabled)) {
            setEnabledStateOnViews(this.mTextLayout, z2);
        }
        if (isEnabled() && !(z = this.mWidgetFrameEnabled)) {
            setEnabledStateOnViews(this.mWidgetFrame, z);
        }
        View findViewById = view.findViewById(16908289);
        if (findViewById != null && (findViewById instanceof Checkable)) {
            if (findViewById instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) findViewById;
                String string = isChecked() ? getContext().getResources().getString(R.string.mc_value_checked) : getContext().getResources().getString(R.string.mc_value_not_checked);
                String str = new String();
                if (getTitle() != null) {
                    str = str + getTitle() + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA;
                }
                if (getSummary() != null) {
                    str = str + getSummary() + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA;
                }
                View view2 = this.mTextLayout;
                if (view2 != null) {
                    view2.setContentDescription(str + string);
                }
                checkBox.setContentDescription(str);
            }
            ((Checkable) findViewById).setChecked(isChecked());
        }
    }

    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        View findViewById = onCreateView.findViewById(R.id.mz_preference_text_layout);
        this.mTextLayout = findViewById;
        View.OnClickListener onClickListener = this.mTextLayoutClickListener;
        if (onClickListener != null) {
            findViewById.setOnClickListener(onClickListener);
        }
        View.OnLongClickListener onLongClickListener = this.mTextLayoutLongClickListener;
        if (onLongClickListener != null) {
            this.mTextLayout.setOnLongClickListener(onLongClickListener);
        }
        View findViewById2 = onCreateView.findViewById(16908312);
        this.mWidgetFrame = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CheckBoxPreferenceMz.this.performClick();
            }
        });
        return onCreateView;
    }

    public void setTextLayoutClickListener(View.OnClickListener onClickListener) {
        this.mTextLayoutClickListener = onClickListener;
        View view = this.mTextLayout;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setTextLayoutEnabled(boolean z) {
        if (this.mTextLayoutEnabled != z) {
            this.mTextLayoutEnabled = z;
            View view = this.mTextLayout;
            if (view != null) {
                setEnabledStateOnViews(view, z);
            }
        }
    }

    public void setTextLayoutLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mTextLayoutLongClickListener = onLongClickListener;
        View view = this.mTextLayout;
        if (view != null) {
            view.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setWidgetFrameEnabled(boolean z) {
        if (this.mWidgetFrameEnabled != z) {
            this.mWidgetFrameEnabled = z;
            View view = this.mWidgetFrame;
            if (view != null) {
                setEnabledStateOnViews(view, z);
            }
        }
    }

    public CheckBoxPreferenceMz(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTextLayoutEnabled = true;
        this.mWidgetFrameEnabled = true;
        setLayoutResource(R.layout.mz_preference_checkbox);
        mzShouldRecycle();
    }

    public CheckBoxPreferenceMz(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextLayoutEnabled = true;
        this.mWidgetFrameEnabled = true;
        setLayoutResource(R.layout.mz_preference_checkbox);
        mzShouldRecycle();
    }
}

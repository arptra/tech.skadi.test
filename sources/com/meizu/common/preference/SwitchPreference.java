package com.meizu.common.preference;

import android.annotation.SuppressLint;
import android.content.Context;
import android.preference.Preference;
import android.preference.TwoStatePreference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.util.ResourceUtils;
import com.meizu.common.widget.MzContactsContract;
import com.meizu.common.widget.Switch;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SwitchPreference extends TwoStatePreference {
    private static Method sOnPreferenceChanged;
    private static Field sRecycle;
    private boolean isUserDarkStyle;
    /* access modifiers changed from: private */
    public View mDivider;
    private final Listener mListener;
    boolean mNeedHapticFeedback;
    /* access modifiers changed from: private */
    public boolean mShowDivider;
    private CharSequence mSwitchOff;
    private CharSequence mSwitchOn;
    private boolean mTitleSingle;
    private TextView mTitleTextView;
    boolean mUseAnim;

    public class Listener implements CompoundButton.OnCheckedChangeListener {
        private Listener() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!SwitchPreference.this.callChangeListener(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
                return;
            }
            SwitchPreference.this.setChecked(z);
            SwitchPreference.this.performPreferenceChanged();
        }
    }

    @SuppressLint({"NewApi"})
    public SwitchPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mListener = new Listener();
        this.mUseAnim = true;
        this.mNeedHapticFeedback = false;
        this.mTitleSingle = true;
    }

    /* access modifiers changed from: private */
    public synchronized void performPreferenceChanged() {
        try {
            if (sOnPreferenceChanged == null) {
                Method method = SwitchPreference.class.getMethod("onPreferenceChange", (Class[]) null);
                sOnPreferenceChanged = method;
                method.setAccessible(true);
            }
            sOnPreferenceChanged.invoke(this, (Object[]) null);
        } catch (Exception unused) {
        } catch (Throwable th) {
            throw th;
        }
    }

    private void setUpDivider(View view) {
        View findViewById = view.findViewById(R.id.divider);
        this.mDivider = findViewById;
        if (findViewById != null) {
            findViewById.post(new Runnable() {
                public void run() {
                    boolean access$300 = SwitchPreference.this.mShowDivider;
                    ViewGroup.LayoutParams layoutParams = SwitchPreference.this.mDivider.getLayoutParams();
                    layoutParams.width = (int) ResourceUtils.dp2px(access$300 ? 1.0f : 0.0f, SwitchPreference.this.getContext());
                    SwitchPreference.this.mDivider.setLayoutParams(layoutParams);
                }
            });
        }
    }

    public CharSequence getSwitchTextOff() {
        return this.mSwitchOff;
    }

    public CharSequence getSwitchTextOn() {
        return this.mSwitchOn;
    }

    public boolean isUserDarkStyle() {
        return this.isUserDarkStyle;
    }

    public void onBindView(View view) {
        super.onBindView(view);
        View findViewById = view.findViewById(R.id.switchWidget);
        if (findViewById != null && (findViewById instanceof Checkable)) {
            boolean z = findViewById instanceof Switch;
            if (z) {
                Switch switchR = (Switch) findViewById;
                switchR.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                View findViewById2 = view.findViewById(16908312);
                if (findViewById2 != null) {
                    findViewById2.setContentDescription(isChecked() ? switchR.switchOn : switchR.switchOff);
                }
                String str = new String();
                if (getTitle() != null) {
                    str = str + getTitle() + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA;
                }
                if (getSummary() != null) {
                    str = str + getSummary() + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA;
                }
                switchR.setContentDescription(str);
            }
            if (z) {
                Switch switchR2 = (Switch) findViewById;
                if (!this.mUseAnim || !this.mNeedHapticFeedback) {
                    switchR2.setChecked(isChecked(), this.mUseAnim);
                } else {
                    switchR2.setCheckedWithHapticFeedback(isChecked());
                }
                this.mUseAnim = true;
                this.mNeedHapticFeedback = false;
                switchR2.setOnCheckedChangeListener(this.mListener);
            } else {
                ((Checkable) findViewById).setChecked(isChecked());
            }
        }
        this.mTitleTextView = (TextView) view.findViewById(16908310);
        setUpDivider(view);
        syncSummaryView(view);
    }

    public void onClick() {
        this.mNeedHapticFeedback = true;
        super.onClick();
    }

    public void setChecked(boolean z) {
        setChecked(z, true);
    }

    public void setSwitchTextOff(CharSequence charSequence) {
        this.mSwitchOff = charSequence;
        notifyChanged();
    }

    public void setSwitchTextOn(CharSequence charSequence) {
        this.mSwitchOn = charSequence;
        notifyChanged();
    }

    public void setTitleSingleLine(boolean z) {
        this.mTitleSingle = z;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setSingleLine(z);
        }
    }

    public void setUserDarkStyle(boolean z) {
        this.isUserDarkStyle = z;
    }

    public void showDivider(boolean z) {
        this.mShowDivider = z;
    }

    public void syncSummaryView(View view) {
        boolean z;
        TextView textView = (TextView) view.findViewById(16908304);
        if (textView != null) {
            CharSequence summary = getSummary();
            int i = 0;
            if (!TextUtils.isEmpty(summary)) {
                textView.setText(summary);
                z = false;
            } else {
                z = true;
            }
            if (z) {
                i = 8;
            }
            if (i != textView.getVisibility()) {
                textView.setVisibility(i);
            }
        }
    }

    public void setChecked(boolean z, boolean z2) {
        super.setChecked(z);
        this.mUseAnim = z2;
    }

    public void setSwitchTextOff(int i) {
        setSwitchTextOff((CharSequence) getContext().getString(i));
    }

    public void setSwitchTextOn(int i) {
        setSwitchTextOn((CharSequence) getContext().getString(i));
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mListener = new Listener();
        this.mUseAnim = true;
        this.mNeedHapticFeedback = false;
        this.mTitleSingle = true;
        try {
            if (sRecycle == null) {
                Field declaredField = Preference.class.getDeclaredField("mRecycleEnabled");
                sRecycle = declaredField;
                declaredField.setAccessible(true);
            }
            sRecycle.set(this, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        context.obtainStyledAttributes(attributeSet, R.styleable.SwitchPreference, i, 0).recycle();
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_SwitchPreferenceStyle);
    }

    public SwitchPreference(Context context) {
        this(context, (AttributeSet) null);
    }
}

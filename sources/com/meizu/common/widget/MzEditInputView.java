package com.meizu.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import com.meizu.common.R;
import com.meizu.textinputlayout.TextInputLayout;
import java.lang.reflect.InvocationTargetException;

public class MzEditInputView extends FrameLayout {
    private static final String DARK_MODE_CHANGE = "flymelab_flyme_night_mode";
    private static final String SOFT_DARK_MODE_VALUE = "flyme_dark_mode_preference_color";
    private final ContentObserver darkModeChangedObserver;
    private View mCleanView;
    private View.OnClickListener mClickedListener;
    private final int mContentPaddingEnd;
    private final int mContentPaddingStart;
    private View mDivide0;
    private final int mEditPaddingEnd;
    private final int mEditPaddingStart;
    private EditText mEditText;
    private final int mEditTextAppearance;
    private final int mErrorBackground;
    private ViewGroup mGroup;
    private final String mHint;
    private int mInputType;
    private boolean mIsRTL;
    private final int mNormalBackground;
    private final boolean mPasswordSwitch;
    /* access modifiers changed from: private */
    public View mPasswordSwitchView;
    private final boolean mShowCleanIcon;
    private int mSoftNightModeBackground;
    private int mSoftNightModeErrorBackground;
    private final int mTextColorHint;
    private TextInputLayout mTextInputLayout;
    private final String mTitle;
    private final Drawable mTitleIcon;
    private final int mTitleTextAppearance;
    private TextView mTitleView;

    public MzEditInputView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void ignoreDarkMode(View view) {
        try {
            View.class.getDeclaredMethod("actInMzNightMode", new Class[]{Integer.TYPE}).invoke(view, new Object[]{2});
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void adjustEditTextMargin() {
        EditText editText = this.mEditText;
        if (editText != null && this.mGroup != null) {
            ViewGroup.LayoutParams layoutParams = editText.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mGroup.getLayoutParams();
                layoutParams3.topMargin = layoutParams2.topMargin;
                layoutParams3.bottomMargin = layoutParams2.bottomMargin;
                layoutParams3.leftMargin = layoutParams2.leftMargin;
                layoutParams3.rightMargin = layoutParams2.rightMargin;
                this.mGroup.setLayoutParams(layoutParams3);
            }
        }
    }

    public void adjustSoftDarkMode() {
        TextInputLayout textInputLayout = this.mTextInputLayout;
        boolean z = textInputLayout != null && textInputLayout.isErrorShow();
        if (isSoftDarkMode()) {
            EditText editText = this.mEditText;
            if (!(editText == null || z || this.mSoftNightModeBackground == 0)) {
                editText.setBackground(ContextCompat.getDrawable(getContext(), this.mSoftNightModeBackground));
            }
            TextInputLayout textInputLayout2 = this.mTextInputLayout;
            if (textInputLayout2 != null) {
                textInputLayout2.setErrorBackgroundResource(this.mSoftNightModeErrorBackground);
                this.mTextInputLayout.setOriginBackgroundResource(this.mSoftNightModeBackground);
                return;
            }
            return;
        }
        EditText editText2 = this.mEditText;
        if (!(editText2 == null || z || this.mNormalBackground == 0)) {
            editText2.setBackground(ContextCompat.getDrawable(getContext(), this.mNormalBackground));
        }
        TextInputLayout textInputLayout3 = this.mTextInputLayout;
        if (textInputLayout3 != null) {
            textInputLayout3.setErrorBackgroundResource(this.mErrorBackground);
            this.mTextInputLayout.setOriginBackgroundResource(this.mNormalBackground);
        }
    }

    public void callViewClickedListener(View view) {
        View.OnClickListener onClickListener = this.mClickedListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void checkCleanViewVisible() {
        View view = this.mCleanView;
        if (view == null) {
            checkDivide0State();
            return;
        }
        int i = 8;
        if (!this.mShowCleanIcon) {
            view.setVisibility(8);
        } else {
            if (this.mEditText.length() > 0) {
                i = 0;
            }
            view.setVisibility(i);
        }
        checkDivide0State();
    }

    public void checkDivide0State() {
        View view;
        if (this.mDivide0 != null) {
            View view2 = this.mCleanView;
            if (view2 == null || view2.getVisibility() != 0 || (view = this.mPasswordSwitchView) == null || view.getVisibility() != 0) {
                this.mDivide0.setVisibility(8);
            } else {
                this.mDivide0.setVisibility(0);
            }
        }
    }

    public void cleanContent() {
        EditText editText = this.mEditText;
        if (editText != null) {
            editText.setText("");
        }
    }

    public View getCleanView() {
        return this.mCleanView;
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    public int getInputViewContentPaddingEnd() {
        return this.mContentPaddingEnd;
    }

    public int getInputViewContentPaddingStart() {
        return this.mContentPaddingStart;
    }

    public View getPasswordSwitchView() {
        return this.mPasswordSwitchView;
    }

    public TextInputLayout getTextInputLayout() {
        return this.mTextInputLayout;
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public <T extends View> T getView(@IdRes int i) {
        return findViewById(i);
    }

    public void init(Context context, int i) {
        int i2 = 0;
        this.mIsRTL = context.getResources().getConfiguration().getLayoutDirection() == 1;
        LayoutInflater.from(context).inflate(i, this, true);
        this.mTitleView = (TextView) findViewById(R.id.mz_edit_title);
        this.mEditText = (EditText) findViewById(R.id.mz_edit_content);
        this.mTextInputLayout = (TextInputLayout) findViewById(R.id.mz_edit_text_input_layout);
        this.mCleanView = findViewById(R.id.mz_edit_clean);
        this.mPasswordSwitchView = findViewById(R.id.mz_edit_password);
        this.mDivide0 = findViewById(R.id.edit_divide0);
        this.mGroup = (ViewGroup) findViewById(R.id.mz_edit_item_group);
        ignoreDarkMode(this);
        if (this.mTextInputLayout != null) {
            initTextInputLayout();
        }
        if (this.mEditText != null) {
            initEditText();
        }
        if (this.mGroup != null) {
            initGroup();
        }
        View view = this.mCleanView;
        if (view != null) {
            view.setVisibility(this.mShowCleanIcon ? 0 : 8);
            initClean();
        }
        View view2 = this.mPasswordSwitchView;
        if (view2 != null) {
            if (!this.mPasswordSwitch) {
                i2 = 8;
            }
            view2.setVisibility(i2);
            initPasswordSwitch();
        }
        if (this.mTitleView != null) {
            initTitle();
        }
        adjustSoftDarkMode();
        checkDivide0State();
        if (this.mIsRTL) {
            this.mEditText.setTextDirection(4);
        }
    }

    public void initClean() {
        checkCleanViewVisible();
        this.mCleanView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MzEditInputView.this.cleanContent();
                MzEditInputView.this.callViewClickedListener(view);
            }
        });
    }

    public void initEditText() {
        TextInputLayout textInputLayout = this.mTextInputLayout;
        if (textInputLayout == null || !textInputLayout.getLabelEnable()) {
            this.mEditText.setHint(this.mHint);
        }
        if (this.mEditTextAppearance != -1) {
            this.mEditText.setTextAppearance(getContext(), this.mEditTextAppearance);
        }
        int i = this.mTextColorHint;
        if (i != -1) {
            this.mEditText.setHintTextColor(i);
        }
        Typeface typeface = this.mEditText.getTypeface();
        EditText editText = this.mEditText;
        editText.setPaddingRelative(this.mEditPaddingStart, editText.getPaddingTop(), this.mEditPaddingEnd, this.mEditText.getPaddingBottom());
        this.mEditText.setInputType(this.mInputType);
        this.mEditText.setTypeface(typeface);
        this.mEditText.setBackgroundResource(this.mNormalBackground);
        this.mEditText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                MzEditInputView.this.checkCleanViewVisible();
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void initGroup() {
        ViewGroup viewGroup = this.mGroup;
        viewGroup.setPaddingRelative(this.mContentPaddingStart, viewGroup.getPaddingTop(), this.mContentPaddingEnd, this.mGroup.getPaddingBottom());
    }

    public void initPasswordSwitch() {
        this.mPasswordSwitchView.setSelected(false);
        this.mPasswordSwitchView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MzEditInputView.this.mPasswordSwitchView.setSelected(!MzEditInputView.this.mPasswordSwitchView.isSelected());
                MzEditInputView mzEditInputView = MzEditInputView.this;
                mzEditInputView.setEditTextPasswordState(mzEditInputView.mPasswordSwitchView.isSelected());
                MzEditInputView.this.callViewClickedListener(view);
            }
        });
    }

    public void initTextInputLayout() {
        this.mTextInputLayout.setErrorBackgroundResource(this.mErrorBackground);
        this.mTextInputLayout.setHint(this.mHint);
        this.mTextInputLayout.setLabelPaddingHorizontal(this.mContentPaddingStart);
        this.mTextInputLayout.setErrorPaddingHorizontal(this.mContentPaddingStart);
        this.mTextInputLayout.setLabelEnable(false);
    }

    public void initTitle() {
        Drawable drawable = this.mTitleIcon;
        if (drawable != null) {
            if (this.mIsRTL) {
                this.mTitleView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            } else {
                this.mTitleView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        this.mTitleView.setTextAppearance(getContext(), this.mTitleTextAppearance);
        this.mTitleView.setText(this.mTitle);
        this.mTitleView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MzEditInputView.this.callViewClickedListener(view);
            }
        });
    }

    public boolean isSoftDarkMode() {
        if ((getContext().getResources().getConfiguration().uiMode & 48) == 32) {
            return "#262626".equals(Settings.Global.getString(getContext().getContentResolver(), SOFT_DARK_MODE_VALUE));
        }
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerDarkModeChangedListener();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        adjustSoftDarkMode();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unregisterDarkModeChangedListener();
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        adjustEditTextMargin();
    }

    public void registerDarkModeChangedListener() {
        Uri uriFor = Settings.Global.getUriFor(SOFT_DARK_MODE_VALUE);
        Uri uriFor2 = Settings.Global.getUriFor(DARK_MODE_CHANGE);
        getContext().getContentResolver().registerContentObserver(uriFor, false, this.darkModeChangedObserver);
        getContext().getContentResolver().registerContentObserver(uriFor2, false, this.darkModeChangedObserver);
    }

    public void setEditTextPasswordState(boolean z) {
        EditText editText = this.mEditText;
        if (editText != null) {
            Typeface typeface = editText.getTypeface();
            if (z) {
                this.mInputType = 145;
            } else {
                this.mInputType = 129;
            }
            this.mEditText.setInputType(this.mInputType);
            this.mEditText.setTypeface(typeface);
            EditText editText2 = this.mEditText;
            editText2.setSelection(editText2.getText().length());
        }
    }

    public void setOnViewClickedListener(View.OnClickListener onClickListener) {
        this.mClickedListener = onClickListener;
    }

    public void unregisterDarkModeChangedListener() {
        getContext().getContentResolver().unregisterContentObserver(this.darkModeChangedObserver);
    }

    public MzEditInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnViewClickedListener(@IdRes int i, View.OnClickListener onClickListener) {
        View view = getView(i);
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public MzEditInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.darkModeChangedObserver = new ContentObserver(getHandler()) {
            public void onChange(boolean z) {
                super.onChange(z);
                MzEditInputView.this.adjustSoftDarkMode();
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MzEditInputView);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MzEditInputView_contentLayout, R.layout.mz_layout_edit_input);
        this.mHint = obtainStyledAttributes.getString(R.styleable.MzEditInputView_android_hint);
        this.mTitle = obtainStyledAttributes.getString(R.styleable.MzEditInputView_title);
        this.mTitleIcon = obtainStyledAttributes.getDrawable(R.styleable.MzEditInputView_titleIcon);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.MzEditInputView_errorBackground, 0);
        this.mErrorBackground = resourceId2;
        int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.MzEditInputView_normalBackground, 0);
        this.mNormalBackground = resourceId3;
        this.mSoftNightModeBackground = obtainStyledAttributes.getResourceId(R.styleable.MzEditInputView_softNightModeBackground, resourceId3);
        this.mSoftNightModeErrorBackground = obtainStyledAttributes.getResourceId(R.styleable.MzEditInputView_softNightModeErrorBackground, resourceId2);
        this.mPasswordSwitch = obtainStyledAttributes.getBoolean(R.styleable.MzEditInputView_passwordSwitch, false);
        this.mShowCleanIcon = obtainStyledAttributes.getBoolean(R.styleable.MzEditInputView_showCleanIcon, false);
        this.mInputType = obtainStyledAttributes.getInt(R.styleable.MzEditInputView_android_inputType, 131073);
        this.mContentPaddingStart = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzEditInputView_inputContentPaddingStart, 0);
        this.mContentPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzEditInputView_inputContentPaddingEnd, 0);
        this.mEditPaddingStart = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzEditInputView_editPaddingStart, 0);
        this.mEditPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzEditInputView_editPaddingEnd, 0);
        this.mTitleTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.MzEditInputView_titleTextAppearance, -1);
        this.mEditTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.MzEditInputView_editTextAppearance, -1);
        this.mTextColorHint = obtainStyledAttributes.getColor(R.styleable.MzEditInputView_android_textColorHint, -1);
        obtainStyledAttributes.recycle();
        init(context, resourceId);
    }
}

package com.honey.account.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import com.honey.account.R;

public class PasswordEditLayout extends FrameLayout implements View.OnClickListener {
    /* access modifiers changed from: private */
    public AppCompatEditText mEditInputPassword;
    private final TextWatcher mEditInputPasswordTextChangeListener;
    /* access modifiers changed from: private */
    public TextView mErrorTv;
    private View.OnFocusChangeListener mFocusChangeListener;
    private TextView mForgetTv;
    /* access modifiers changed from: private */
    public View mInputVerticalLine;
    /* access modifiers changed from: private */
    public ImageView mIvInputClear;
    private boolean mIvInputPwdShow;
    private ImageView mIvInputShowPwd;
    /* access modifiers changed from: private */
    public TextWatcher mTextChangeListener;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        /* access modifiers changed from: private */
        public final boolean ivInputPwdShow;

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ivInputPwdShow ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, boolean z) {
            super(parcelable);
            this.ivInputPwdShow = z;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ivInputPwdShow = parcel.readInt() != 1 ? false : true;
        }
    }

    public PasswordEditLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void bindListener() {
        this.mEditInputPassword.addTextChangedListener(this.mEditInputPasswordTextChangeListener);
        this.mIvInputShowPwd.setOnClickListener(this);
        this.mIvInputClear.setOnClickListener(this);
    }

    private void changeInputEye() {
        boolean z = !this.mIvInputPwdShow;
        this.mIvInputPwdShow = z;
        updateEditStatus(z);
        this.mEditInputPassword.setSelection(getText().length());
    }

    private void initView(View view, String str) {
        AppCompatEditText appCompatEditText = (AppCompatEditText) view.findViewById(R.id.mz_input_password);
        this.mEditInputPassword = appCompatEditText;
        appCompatEditText.setHint(str);
        this.mIvInputClear = (ImageView) view.findViewById(R.id.iv_input_clear);
        this.mIvInputShowPwd = (ImageView) view.findViewById(R.id.iv_input_show_pwd);
        this.mInputVerticalLine = view.findViewById(R.id.v_input_vertival);
        this.mErrorTv = (TextView) view.findViewById(R.id.tv_login_code_error_msg);
        this.mForgetTv = (TextView) view.findViewById(R.id.tv_forget_login_code);
        updateEditStatus(this.mIvInputPwdShow);
    }

    private void updateEditStatus(boolean z) {
        this.mIvInputShowPwd.setSelected(z);
        if (z) {
            this.mEditInputPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            this.mEditInputPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public void addOnPasswordFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.mEditInputPassword.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void addPasswordEditTextWatcher(TextWatcher textWatcher) {
        this.mTextChangeListener = textWatcher;
    }

    public EditText getEdit() {
        return this.mEditInputPassword;
    }

    public String getText() {
        return this.mEditInputPassword.getText().toString();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_input_show_pwd) {
            changeInputEye();
        } else if (id == R.id.iv_input_clear) {
            this.mEditInputPassword.setText("");
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        boolean access$500 = savedState.ivInputPwdShow;
        this.mIvInputPwdShow = access$500;
        updateEditStatus(access$500);
    }

    @Nullable
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mIvInputPwdShow);
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        this.mEditInputPassword.setOnEditorActionListener(onEditorActionListener);
    }

    public void setOnForgetClickListener(View.OnClickListener onClickListener) {
        this.mForgetTv.setOnClickListener(onClickListener);
    }

    public void showError(String str) {
        this.mEditInputPassword.requestFocus();
        if (TextUtils.isEmpty(str)) {
            this.mErrorTv.setVisibility(4);
            this.mEditInputPassword.setBackgroundResource(R.drawable.ha_et_bg_grey);
            return;
        }
        this.mErrorTv.setText(str);
        this.mErrorTv.setVisibility(0);
        this.mEditInputPassword.setBackgroundResource(R.drawable.ha_et_bg_err);
    }

    public PasswordEditLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PasswordEditLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEditInputPasswordTextChangeListener = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                PasswordEditLayout.this.showError((String) null);
                if (PasswordEditLayout.this.mTextChangeListener != null) {
                    PasswordEditLayout.this.mTextChangeListener.afterTextChanged(editable);
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (PasswordEditLayout.this.mTextChangeListener != null) {
                    PasswordEditLayout.this.mTextChangeListener.beforeTextChanged(charSequence, i, i2, i3);
                }
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!charSequence.toString().isEmpty()) {
                    PasswordEditLayout.this.mInputVerticalLine.setVisibility(0);
                    PasswordEditLayout.this.mIvInputClear.setVisibility(0);
                } else {
                    PasswordEditLayout.this.mInputVerticalLine.setVisibility(8);
                    PasswordEditLayout.this.mIvInputClear.setVisibility(8);
                }
                if (PasswordEditLayout.this.mTextChangeListener != null) {
                    PasswordEditLayout.this.mTextChangeListener.onTextChanged(charSequence, i, i2, i3);
                }
            }
        };
        this.mFocusChangeListener = new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                PasswordEditLayout.this.mEditInputPassword.setBackgroundResource(z ? PasswordEditLayout.this.mErrorTv.getVisibility() == 4 ? R.drawable.ha_et_bg_blue : R.drawable.ha_et_bg_err : R.drawable.ha_et_bg_grey);
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.password_edit_layout);
        String string = obtainStyledAttributes.getString(R.styleable.password_edit_layout_android_hint);
        obtainStyledAttributes.recycle();
        initView(LayoutInflater.from(context).inflate(R.layout.password_edit_layout, this), string);
        bindListener();
        this.mEditInputPassword.setOnFocusChangeListener(this.mFocusChangeListener);
    }
}

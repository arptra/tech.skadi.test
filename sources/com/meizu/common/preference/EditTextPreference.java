package com.meizu.common.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.meizu.common.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class EditTextPreference extends Preference implements View.OnFocusChangeListener, TextWatcher {
    private static String TAG = "EditTextPreference";
    private static Method mInputSoftMethod;
    private static Field sRecycle;
    private boolean isSetPadding;
    /* access modifiers changed from: private */
    public EditText mEditText;
    private boolean mEditTextSingleLine;
    private float mEditTextTextSize;
    private InputFilter[] mFilters;
    private String mHint;
    private int mInputType;
    private String mText;
    private TextWatcher mTextWatcher;
    private int paddingBottom;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;

    public EditTextPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    private void initEditText(EditText editText) {
        TextWatcher textWatcher = (TextWatcher) editText.getTag();
        if (textWatcher != null) {
            editText.removeTextChangedListener(textWatcher);
        }
        editText.clearFocus();
        editText.removeTextChangedListener(this);
        editText.setTextSize(this.mEditTextTextSize);
        if (this.isSetPadding) {
            editText.setPadding(this.paddingLeft, this.paddingTop, this.paddingRight, this.paddingBottom);
        }
        if (!isPasswordInputType(this.mInputType)) {
            editText.setSingleLine(this.mEditTextSingleLine);
        }
        if (!this.mHint.trim().equals("")) {
            editText.setHint(this.mHint);
        } else if (editText.getHint() != null && !editText.getHint().toString().trim().equals("")) {
            editText.setHint("");
        }
        editText.setFilters(this.mFilters);
        int i = this.mInputType;
        if (i != 0) {
            editText.setInputType(i);
        }
        editText.setOnFocusChangeListener(this);
        editText.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1 || EditTextPreference.this.isSoftInputShown() || EditTextPreference.this.mEditText.hasSelection()) {
                    return false;
                }
                EditTextPreference.this.mEditText.clearFocus();
                return false;
            }
        });
    }

    private static boolean isPasswordInputType(int i) {
        int i2 = i & 4095;
        return i2 == 129 || i2 == 225 || i2 == 18;
    }

    /* access modifiers changed from: private */
    public boolean isSoftInputShown() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.mEditText.getContext().getSystemService("input_method");
            if (mInputSoftMethod == null) {
                mInputSoftMethod = Class.forName("android.view.inputmethod.InputMethodManager").getMethod("isSoftInputShown", (Class[]) null);
            }
            return ((Boolean) mInputSoftMethod.invoke(inputMethodManager, (Object[]) null)).booleanValue();
        } catch (Exception unused) {
            Log.e(TAG, "isSoftInputShown fail to be invoked");
            return false;
        }
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }

    public void afterTextChanged(Editable editable) {
        setText(editable.toString());
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    public String getText() {
        return this.mText;
    }

    public void mzSetRecycle(boolean z) {
        try {
            setRecycleEnabled(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBindView(View view) {
        super.onBindView(view);
        EditText editText = (EditText) view.findViewById(16908291);
        this.mEditText = editText;
        initEditText(editText);
        setText(this.mText);
    }

    public View onCreateView(ViewGroup viewGroup) {
        return super.onCreateView(viewGroup);
    }

    public void onDependencyChanged(Preference preference, boolean z) {
        InputMethodManager inputMethodManager;
        super.onDependencyChanged(preference, z);
        EditText editText = this.mEditText;
        if (editText != null) {
            editText.setFocusableInTouchMode(!z);
            if (z && (inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method")) != null) {
                inputMethodManager.hideSoftInputFromWindow(this.mEditText.getWindowToken(), 0);
            }
        }
    }

    public void onFocusChange(View view, boolean z) {
        EditText editText = this.mEditText;
        if (editText == null) {
            return;
        }
        if (z) {
            editText.addTextChangedListener(this);
            TextWatcher textWatcher = this.mTextWatcher;
            if (textWatcher != null) {
                this.mEditText.addTextChangedListener(textWatcher);
            }
            this.mEditText.setTag(this);
            return;
        }
        editText.setTag((Object) null);
        this.mEditText.removeTextChangedListener(this);
        TextWatcher textWatcher2 = this.mTextWatcher;
        if (textWatcher2 != null) {
            this.mEditText.removeTextChangedListener(textWatcher2);
        }
        String obj = this.mEditText.getText().toString();
        if (callChangeListener(obj)) {
            setText(obj);
        }
    }

    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    public void onSetInitialValue(boolean z, Object obj) {
        setText(z ? getPersistedString(this.mText) : (String) obj);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        EditText editText = this.mEditText;
        if (editText != null) {
            editText.removeTextChangedListener(textWatcher);
        }
    }

    public void setAutoShowSoftInput(boolean z) {
        if (z) {
            this.mEditText.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.mEditText.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }

    public void setDialogTitle(int i) {
        setDialogTitle((CharSequence) getContext().getString(i));
    }

    public void setEditTextTextSize(float f) {
        this.mEditTextTextSize = f;
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        this.mFilters = inputFilterArr;
    }

    public void setHint(String str) {
        this.mHint = str;
    }

    public void setInputType(int i) {
        this.mInputType = i;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.isSetPadding = true;
        this.paddingLeft = i;
        this.paddingRight = i3;
        this.paddingTop = i2;
        this.paddingBottom = i4;
    }

    public void setSingleLine(boolean z) {
        this.mEditTextSingleLine = z;
    }

    public void setSummary(int i) {
        setSummary((CharSequence) getContext().getString(i));
    }

    public void setText(String str) {
        boolean shouldDisableDependents = shouldDisableDependents();
        this.mText = str;
        persistString(str);
        EditText editText = this.mEditText;
        if (!(editText == null || str == null || str.equals(editText.getText().toString()))) {
            this.mEditText.setText(str);
            if (this.mEditText.getText().length() > 0) {
                EditText editText2 = this.mEditText;
                editText2.setSelection(editText2.getText().length());
            }
        }
        boolean shouldDisableDependents2 = shouldDisableDependents();
        if (shouldDisableDependents2 != shouldDisableDependents) {
            notifyDependencyChange(shouldDisableDependents2);
        }
    }

    public boolean shouldDisableDependents() {
        return TextUtils.isEmpty(this.mText) || super.shouldDisableDependents();
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setDialogTitle(CharSequence charSequence) {
        super.setTitle((String) charSequence);
    }

    public void setSummary(CharSequence charSequence) {
        setText((String) charSequence);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mText = "";
        this.mEditTextTextSize = 16.0f;
        this.mInputType = 0;
        this.mFilters = new InputFilter[0];
        this.isSetPadding = false;
        this.mEditTextSingleLine = true;
        this.mHint = "";
        setLayoutResource(R.layout.mz_preference_edittext);
        mzSetRecycle(true);
        setPersistent(false);
    }
}

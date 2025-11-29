package com.meizu.common.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.meizu.common.R;
import java.util.Locale;

public class PasswordInputView extends RelativeLayout {
    private ImageView mClearImage;
    /* access modifiers changed from: private */
    public LinearLayout mClearLayout;
    /* access modifiers changed from: private */
    public EditText mInputText;
    private CompoundButton mPasswordBtn;

    public PasswordInputView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init() {
        View.inflate(getContext(), getInflateLayoutResource(), this);
    }

    public EditText getEditText() {
        return this.mInputText;
    }

    public int getInflateLayoutResource() {
        return R.layout.mc_layout_password_input;
    }

    public void handleCheckChange(CompoundButton compoundButton, boolean z) {
        EditText editText = this.mInputText;
        if (editText != null) {
            if (z) {
                editText.setInputType(145);
                this.mInputText.setTypeface(Typeface.DEFAULT);
                EditText editText2 = this.mInputText;
                editText2.setSelection(editText2.getText().length());
                return;
            }
            editText.setInputType(129);
            this.mInputText.setTypeface(Typeface.DEFAULT);
            EditText editText3 = this.mInputText;
            editText3.setSelection(editText3.getText().length());
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof EditText) {
                    this.mInputText = (EditText) childAt;
                } else if (childAt instanceof LinearLayout) {
                    this.mPasswordBtn = (CompoundButton) childAt.findViewById(R.id.mz_password_btn);
                    this.mClearLayout = (LinearLayout) childAt.findViewById(R.id.mz_input_clear_layout);
                    this.mClearImage = (ImageView) childAt.findViewById(R.id.mz_icon_input_clear);
                }
            }
        }
        CompoundButton compoundButton = this.mPasswordBtn;
        if (compoundButton != null) {
            compoundButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    PasswordInputView.this.handleCheckChange(compoundButton, z);
                }
            });
        }
        EditText editText = this.mInputText;
        if (editText != null) {
            editText.setInputType(129);
            this.mInputText.setTypeface(Typeface.DEFAULT);
            EditText editText2 = this.mInputText;
            editText2.setSelection(editText2.getText().length());
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                this.mInputText.setGravity(5);
            }
            this.mInputText.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    if (PasswordInputView.this.mInputText.length() > 0) {
                        PasswordInputView.this.mClearLayout.setVisibility(0);
                    } else {
                        PasswordInputView.this.mClearLayout.setVisibility(8);
                    }
                }

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            this.mClearImage.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PasswordInputView.this.mInputText.setText("");
                }
            });
        }
    }

    public PasswordInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PasswordInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}

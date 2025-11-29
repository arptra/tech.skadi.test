package com.meizu.textinputlayout;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import com.meizu.common.R;

public class EditTextWithClearIcon extends EditText {
    boolean isRTL;
    Drawable mClearIcon;

    public EditTextWithClearIcon(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mClearIcon = ContextCompat.getDrawable(context, R.drawable.mz_text_input_layout_ic_clear);
        boolean z = true;
        if (context.getResources().getConfiguration().getLayoutDirection() != 1) {
            z = false;
        }
        this.isRTL = z;
        addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                EditTextWithClearIcon.this.setRightDrawable();
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        setRightDrawable();
    }

    /* access modifiers changed from: private */
    public void setRightDrawable() {
        if (length() <= 0) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (this.isRTL) {
            setCompoundDrawablesWithIntrinsicBounds(this.mClearIcon, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mClearIcon, (Drawable) null);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable = this.isRTL ? getCompoundDrawables()[0] : getCompoundDrawables()[2];
        if (motionEvent.getAction() == 1 && drawable != null) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int i = iArr[0];
            rect.set(i, iArr[1], getWidth() + i, iArr[1] + getHeight());
            int intrinsicHeight = ((rect.bottom - rect.top) - drawable.getIntrinsicHeight()) / 2;
            if (this.isRTL) {
                int paddingLeft = rect.left + getPaddingLeft() + getCompoundDrawablePadding();
                rect.left = paddingLeft;
                rect.right = paddingLeft + drawable.getIntrinsicWidth();
            } else {
                int paddingRight = (rect.right - getPaddingRight()) - getCompoundDrawablePadding();
                rect.right = paddingRight;
                rect.left = paddingRight - drawable.getIntrinsicWidth();
            }
            rect.top += intrinsicHeight;
            rect.bottom -= intrinsicHeight;
            if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                setText("");
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public EditTextWithClearIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public EditTextWithClearIcon(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}

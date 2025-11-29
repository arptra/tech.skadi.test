package com.meizu.common.notice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.android.internal.graphics.drawable.BackgroundBlurDrawable;
import com.meizu.common.R;
import com.meizu.common.util.BlurDrawableUtil;
import com.meizu.common.util.SmoothCornerPathGenerator;

public class NoticeView extends CardView {
    private static final int OPAQUE = 255;
    private static final String TAG = "NoticeView";
    int blurRadius;
    float cornerRadius;
    private OnDragCallback mCallback;
    private final Context mContext;
    TextView mDescView;
    private ImageView mIcon;
    private int mLastTouchY;
    private final int mMaxFlingVelocity;
    TextView mTipView;
    private int mTouchDownY;
    private VelocityTracker mVelocityTracker;
    int overlayColor;

    public interface OnDragCallback {
        void onDrag(int i, int i2);

        void onSettling(float f);
    }

    public NoticeView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void dispatchDrag(int i, int i2) {
        OnDragCallback onDragCallback = this.mCallback;
        if (onDragCallback != null) {
            onDragCallback.onDrag(i, i2);
        }
    }

    private void dispatchSettling(float f) {
        OnDragCallback onDragCallback = this.mCallback;
        if (onDragCallback != null) {
            onDragCallback.onSettling(f);
        }
    }

    private void setupBackgroundBlur(View view, float f, int i, int i2) {
        if (!(view.getBackground() instanceof BackgroundBlurDrawable)) {
            if (view.isAttachedToWindow()) {
                BackgroundBlurDrawable createDrawable = BlurDrawableUtil.createDrawable(view, f, i, i2, 255);
                if (createDrawable == null) {
                    view.setBackground(AppCompatResources.b(view.getContext(), R.drawable.notice_background));
                } else {
                    view.setBackground(createDrawable);
                }
            } else {
                final View view2 = view;
                final float f2 = f;
                final int i3 = i;
                final int i4 = i2;
                view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                    public void onViewAttachedToWindow(@NonNull View view) {
                        BackgroundBlurDrawable createDrawable = BlurDrawableUtil.createDrawable(view2, f2, i3, i4, 255);
                        if (createDrawable == null) {
                            View view2 = view2;
                            view2.setBackground(AppCompatResources.b(view2.getContext(), R.drawable.notice_background));
                            return;
                        }
                        view2.setBackground(createDrawable);
                    }

                    public void onViewDetachedFromWindow(@NonNull View view) {
                    }
                });
            }
        }
    }

    private void setupShadow() {
        setCardElevation(50.0f);
        setCardBackgroundColor(0);
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
    }

    public void inflate() {
        View.inflate(this.mContext, R.layout.mz_strong_notification_container, this);
        this.mDescView = (TextView) findViewById(R.id.description);
        this.mTipView = (TextView) findViewById(R.id.tips);
        this.mIcon = (ImageView) findViewById(R.id.icon);
        setupBackgroundBlur((ViewGroup) findViewById(R.id.notice_sec_container), this.cornerRadius, this.blurRadius, this.overlayColor);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.mTouchDownY = (int) (motionEvent.getRawY() + 0.5f);
            this.mLastTouchY = (int) (motionEvent.getRawY() + 0.5f);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaxFlingVelocity);
            float yVelocity = this.mVelocityTracker.getYVelocity();
            this.mVelocityTracker.clear();
            dispatchSettling(yVelocity);
        } else if (actionMasked == 2) {
            int rawY = (int) (motionEvent.getRawY() + 0.5f);
            this.mLastTouchY = rawY;
            dispatchDrag(rawY - this.mLastTouchY, rawY - this.mTouchDownY);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setContainer(ViewGroup viewGroup) {
        addView(viewGroup);
        if (viewGroup != null) {
            setupBackgroundBlur(viewGroup, this.cornerRadius, this.blurRadius, this.overlayColor);
        }
    }

    public NoticeView setDesc(@NonNull String str) {
        TextView textView = this.mDescView;
        if (textView != null) {
            textView.setText(str);
        }
        return this;
    }

    public NoticeView setIcon(@NonNull Drawable drawable) {
        ImageView imageView = this.mIcon;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
        return this;
    }

    public NoticeView setNoticeTextColor(@ColorInt int i) {
        TextView textView = this.mDescView;
        if (textView != null) {
            textView.setTextColor(i);
        }
        return this;
    }

    public NoticeView setNoticeTextSize(int i) {
        TextView textView = this.mDescView;
        if (textView != null) {
            textView.setTextSize((float) i);
        }
        return this;
    }

    public void setOnDragListener(OnDragCallback onDragCallback) {
        this.mCallback = onDragCallback;
    }

    public NoticeView setTipTextColor(@ColorInt int i) {
        TextView textView = this.mTipView;
        if (textView != null) {
            textView.setTextColor(i);
        }
        return this;
    }

    public NoticeView setTipTextSize(int i) {
        TextView textView = this.mTipView;
        if (textView != null) {
            textView.setTextSize((float) i);
        }
        return this;
    }

    public NoticeView setTips(@Nullable String str) {
        if (this.mTipView != null) {
            if (!TextUtils.isEmpty(str)) {
                this.mTipView.setText(str);
            } else {
                this.mTipView.setVisibility(8);
            }
        }
        return this;
    }

    public NoticeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzNoticeViewStyle);
    }

    public NoticeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public NoticeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NoticeView, i, 0);
        saveAttributeDataForStyleable(context, R.styleable.NoticeView, attributeSet, obtainStyledAttributes, i, 0);
        this.overlayColor = obtainStyledAttributes.getColor(R.styleable.NoticeView_colorOverlay, 1728053247);
        this.cornerRadius = obtainStyledAttributes.getDimension(R.styleable.NoticeView_cornerRadius, 0.0f);
        this.blurRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NoticeView_blurRadius, 0);
        obtainStyledAttributes.recycle();
        this.mMaxFlingVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        setupShadow();
        SmoothCornerPathGenerator.addSmoothCornerAsOutline(this, 0.2f, this.cornerRadius);
    }
}

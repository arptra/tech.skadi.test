package com.meizu.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.honey.account.u2.a;
import com.honey.account.u2.b;
import com.meizu.common.R;
import com.meizu.common.interpolator.PathInterpolatorCompat;
import com.meizu.common.util.PAGReporterPrevent;
import java.util.ArrayList;
import java.util.List;
import org.libpag.PAGView;

public class MzPAGEmptyLayout extends FrameLayout {
    private ValueAnimator animator;
    private final List<View> extraViews;
    private int mButtonAppearance;
    private int mButtonBackgroundId;
    private String mButtonText;
    private TextView mButtonView;
    private String mHintText;
    private TextView mHintView;
    private String mInitPath;
    private int mInitRepeatCount;
    private int mLayoutId;
    private String mMessageText;
    private TextView mMessageTextView;
    private PAGView mPagView;
    private boolean mShowButton;
    private final Runnable mStartRunnable;
    private int mTextAppearance;

    public MzPAGEmptyLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void initAlphaAnimator() {
        PAGView pAGView = this.mPagView;
        if (pAGView != null) {
            pAGView.setVisibility(4);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.animator = ofFloat;
        ofFloat.setDuration(500);
        this.animator.setInterpolator(new PathInterpolatorCompat(0.33f, 0.0f, 0.67f, 1.0f));
        this.animator.addUpdateListener(new b(this));
    }

    private void initAttribute(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MzPAGEmptyLayout);
        this.mInitPath = obtainStyledAttributes.getString(R.styleable.MzPAGEmptyLayout_path);
        this.mInitRepeatCount = obtainStyledAttributes.getInt(R.styleable.MzPAGEmptyLayout_android_repeatCount, 1);
        this.mTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.MzPAGEmptyLayout_hintAppearance, -1);
        this.mButtonAppearance = obtainStyledAttributes.getResourceId(R.styleable.MzPAGEmptyLayout_buttonAppearance, -1);
        this.mButtonBackgroundId = obtainStyledAttributes.getResourceId(R.styleable.MzPAGEmptyLayout_buttonBackground, 0);
        this.mHintText = obtainStyledAttributes.getString(R.styleable.MzPAGEmptyLayout_hintText);
        this.mMessageText = obtainStyledAttributes.getString(R.styleable.MzPAGEmptyLayout_messageText);
        this.mButtonText = obtainStyledAttributes.getString(R.styleable.MzPAGEmptyLayout_buttonText);
        this.mShowButton = obtainStyledAttributes.getBoolean(R.styleable.MzPAGEmptyLayout_showButton, false);
        this.mLayoutId = obtainStyledAttributes.getResourceId(R.styleable.MzPAGEmptyLayout_contentLayout, R.layout.mz_pag_empty_layout);
        obtainStyledAttributes.recycle();
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(this.mLayoutId, this, true);
        try {
            this.mPagView = (PAGView) findViewById(R.id.pag_view);
        } catch (Exception unused) {
        }
        this.mHintView = (TextView) findViewById(R.id.pag_hint);
        this.mButtonView = (TextView) findViewById(R.id.pag_button);
        TextView textView = (TextView) findViewById(R.id.pag_text);
        this.mMessageTextView = textView;
        if (textView != null) {
            if (TextUtils.isEmpty(this.mMessageText)) {
                this.mMessageTextView.setVisibility(8);
            } else {
                this.mMessageTextView.setVisibility(0);
                this.mMessageTextView.setText(this.mMessageText);
            }
        }
        if (this.mPagView != null) {
            setPagViewStyle();
        }
        if (this.mHintView != null) {
            setTextViewStyle();
        }
        if (this.mButtonView != null) {
            setButtonViewStyle();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initAlphaAnimator$1(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        TextView textView = this.mHintView;
        if (textView != null) {
            textView.setAlpha(floatValue);
        }
        TextView textView2 = this.mMessageTextView;
        if (textView2 != null) {
            textView2.setAlpha(floatValue);
        }
        TextView textView3 = this.mButtonView;
        if (textView3 != null) {
            textView3.setAlpha(floatValue);
        }
        for (View alpha : this.extraViews) {
            alpha.setAlpha(floatValue);
        }
    }

    private void setButtonBackground() {
        TextView textView = this.mButtonView;
        if (textView != null && this.mButtonBackgroundId != 0) {
            textView.setBackground(ContextCompat.getDrawable(getContext(), this.mButtonBackgroundId));
        }
    }

    private void setButtonViewStyle() {
        setTextViewAppearance(this.mButtonView, this.mButtonAppearance);
        this.mButtonView.setText(this.mButtonText);
        this.mButtonView.setVisibility(this.mShowButton ? 0 : 8);
    }

    private void setPagViewStyle() {
        this.mPagView.setPath(this.mInitPath);
        this.mPagView.setRepeatCount(this.mInitRepeatCount);
    }

    private void setTextViewAppearance(TextView textView, int i) {
        if (i != -1) {
            TextViewCompat.n(textView, i);
        }
    }

    private void setTextViewStyle() {
        setTextViewAppearance(this.mHintView, this.mTextAppearance);
        this.mHintView.setText(this.mHintText);
    }

    public ValueAnimator getAnimator() {
        return this.animator;
    }

    public TextView getButtonView() {
        return this.mButtonView;
    }

    public TextView getHintView() {
        return this.mHintView;
    }

    public TextView getMessageTextView() {
        return this.mMessageTextView;
    }

    public PAGView getPAGView() {
        return this.mPagView;
    }

    public <T extends View> T getView(@IdRes int i) {
        return findViewById(i);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setButtonBackground();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setButtonBackground();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mStartRunnable);
        this.extraViews.clear();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.animator.cancel();
        }
        PAGView pAGView = this.mPagView;
        if (pAGView != null) {
            pAGView.stop();
        }
    }

    public void registerAnimationView(View view) {
        this.extraViews.add(view);
    }

    public void setAnimatorDuration(int i) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.setDuration((long) i);
        }
    }

    public void setButtonViewClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.mButtonView;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setOnViewClickedListener(@IdRes int i, View.OnClickListener onClickListener) {
        View view = getView(i);
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    /* renamed from: start */
    public void lambda$new$0() {
        PAGView pAGView = this.mPagView;
        if (pAGView != null) {
            if (pAGView.isPlaying()) {
                this.mPagView.stop();
            }
            this.mPagView.setProgress(0.0d);
            this.mPagView.setVisibility(0);
            this.mPagView.play();
        }
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.animator.cancel();
            }
            this.animator.start();
        }
    }

    public void startDelay(long j) {
        removeCallbacks(this.mStartRunnable);
        postDelayed(this.mStartRunnable, j);
    }

    public void stop() {
        stop(true);
    }

    public MzPAGEmptyLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void registerAnimationView(int i) {
        View findViewById = findViewById(i);
        if (findViewById != null) {
            this.extraViews.add(findViewById);
        }
    }

    public void stop(boolean z) {
        removeCallbacks(this.mStartRunnable);
        PAGView pAGView = this.mPagView;
        if (pAGView != null && pAGView.isPlaying()) {
            this.mPagView.stop();
            if (z) {
                this.mPagView.setProgress(0.0d);
            }
        }
        if (this.animator.isRunning()) {
            this.animator.cancel();
        }
    }

    public MzPAGEmptyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInitRepeatCount = 1;
        this.extraViews = new ArrayList();
        this.mStartRunnable = new a(this);
        PAGReporterPrevent.init(context.getApplicationContext());
        initAttribute(context, attributeSet);
        initView(context);
        initAlphaAnimator();
        if (isInEditMode()) {
            TextView textView = this.mHintView;
            if (textView != null) {
                textView.setAlpha(1.0f);
            }
            TextView textView2 = this.mMessageTextView;
            if (textView2 != null) {
                textView2.setAlpha(1.0f);
            }
            TextView textView3 = this.mButtonView;
            if (textView3 != null) {
                textView3.setAlpha(1.0f);
            }
        }
    }
}

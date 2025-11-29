package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.geetest.sdk.x;
import com.meizu.common.R;
import com.meizu.common.app.SlideNotice;
import com.meizu.common.datetimepicker.date.MonthView;

public class StretchSearchView extends RelativeLayout {
    private static final int SIZE_DEFAULT = 0;
    public static final int STATE_ERROR = -1;
    public static final int STATE_READY = 0;
    public static final int STATE_SHORTENED = 4;
    public static final int STATE_SHORTENING = 3;
    public static final int STATE_STRETCHED = 2;
    public static final int STATE_STRETCHING = 1;
    public static final String TAG = "StretchSearchView";
    public static final int TYPE_CUSTOM = 0;
    public static final int TYPE_MIDDLE_TO_LEFT = 3;
    public static final int TYPE_MIDDLE_TO_LEFT_TEXTVIEW = 4;
    public static final int TYPE_RIGHT_TO_LEFT = 1;
    public static final int TYPE_RIGHT_TO_LEFT_TEXTVIEW = 2;
    private boolean mAlignRightWhenAnim;
    /* access modifiers changed from: private */
    public int mAnimationState;
    private TextView mButton;
    private int mButtonColor;
    private Context mContext;
    private float mCustomAnimValueFrom;
    private float mCustomAnimValueTo;
    private boolean mHasBtn;
    /* access modifiers changed from: private */
    public boolean mHasVoiceIcon;
    private ImageView mImgSearch;
    /* access modifiers changed from: private */
    public ImageView mImgSearchClear;
    private float mInputClearAlphaFrom;
    private float mInputClearAlphaTo;
    /* access modifiers changed from: private */
    public SearchEditText mInputText;
    private float mInputTextAlphaFrom;
    private float mInputTextAlphaTo;
    private int mLayoutMarginLeftAdjust;
    private int mLayoutMarginRightAdjust;
    private int mLayoutPaddingLeft;
    private int mLayoutPaddingRight;
    /* access modifiers changed from: private */
    public RelativeLayout mMainLayout;
    private boolean mPlayInputTextAlhpaAnim;
    private boolean mPlayMoveXAnim;
    private boolean mPlaySearchImgScaleAnim;
    private boolean mPlaySearchclearAlphaAnim;
    /* access modifiers changed from: private */
    public boolean mPlayStretchOnPreDraw;
    private boolean mPlayStretchWidthAnim;
    private float mScaleFrom;
    private float mScaleTo;
    /* access modifiers changed from: private */
    public RelativeLayout mSearchLayout;
    private float mSearchLayoutInitAlpha;
    private String mSearchTextHint;
    /* access modifiers changed from: private */
    public View mSearchView;
    /* access modifiers changed from: private */
    public ShortenAnimationListener mShortenAnimationListener;
    private int mShortenDuration;
    /* access modifiers changed from: private */
    public StretchAnimationListener mStretchAnimationListener;
    private int mStretchDuration;
    private int mStretchTpye;
    private int mStretchWidthFrom;
    private int mStretchWidthTo;
    private int mStretchXfrom;
    private int mStretchXto;
    private String mTextViewContent;
    private boolean mUseSysInterpolater;
    /* access modifiers changed from: private */
    public ImageView mVoiceIcon;

    public interface ShortenAnimationListener {
        void onShortenAnimationEnd(View view);

        void onShortenAnimationStart(View view);

        void onShortenAnimationUpdate(View view, float f);
    }

    public interface StretchAnimationListener {
        void onStetchAnimationEnd(View view);

        void onStetchAnimationStart(View view);

        void onStetchAnimationUpdate(View view, float f);
    }

    public StretchSearchView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void addGlobalPreDrawListener() {
        final ViewTreeObserver viewTreeObserver = this.mMainLayout.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
                StretchSearchView.this.onInitLayout();
            }
        });
    }

    private void addPreDrawListener() {
        this.mMainLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                StretchSearchView.this.mMainLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                StretchSearchView.this.onInitLayout();
                if (!StretchSearchView.this.mPlayStretchOnPreDraw) {
                    return true;
                }
                StretchSearchView.this.startStretch();
                return true;
            }
        });
    }

    private Interpolator getMovingInterpolater() {
        new DecelerateInterpolator();
        return new PathInterpolator(0.3333f, 0.0f, 0.1f, 1.0f);
    }

    private Interpolator getScaleInterpolater() {
        new DecelerateInterpolator();
        return new PathInterpolator(0.3333f, 0.0f, 0.0f, 1.0f);
    }

    public static int getScreenWidth(Context context) {
        new DisplayMetrics();
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private Interpolator getStretchInterpolater() {
        new DecelerateInterpolator();
        return new PathInterpolator(0.33f, 0.0f, 0.1f, 1.0f);
    }

    private void initMeasure() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mMainLayout.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mSearchLayout.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mImgSearch.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mInputText.measure(makeMeasureSpec, makeMeasureSpec2);
    }

    private void shortenAmin() {
        if (this.mAnimationState == 2) {
            this.mAnimationState = 3;
            beforeShortenViewState();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration((long) this.mShortenDuration);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mSearchLayout, x.f, new float[]{(float) this.mStretchXto, (float) this.mStretchXfrom});
            ofFloat.setDuration((long) this.mShortenDuration);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mSearchLayout, MonthView.VIEW_PARAMS_WIDTH, new float[]{(float) this.mStretchWidthTo, (float) this.mStretchWidthFrom});
            ofFloat2.setDuration((long) this.mShortenDuration);
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    StretchSearchView.this.mSearchLayout.setLayoutParams(new RelativeLayout.LayoutParams((int) ((Float) valueAnimator.getAnimatedValue()).floatValue(), StretchSearchView.this.mSearchLayout.getHeight()));
                }
            });
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mSearchLayout, "StretchSearchViewAnimValue", new float[]{this.mCustomAnimValueTo, this.mCustomAnimValueFrom});
            ofFloat3.setDuration((long) this.mShortenDuration);
            ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (StretchSearchView.this.mShortenAnimationListener != null) {
                        StretchSearchView.this.mShortenAnimationListener.onShortenAnimationUpdate(StretchSearchView.this.mSearchView, floatValue);
                    }
                }
            });
            animatorSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    StretchSearchView.this.afterShortenViewState();
                    int unused = StretchSearchView.this.mAnimationState = 4;
                    if (StretchSearchView.this.mShortenAnimationListener != null) {
                        StretchSearchView.this.mShortenAnimationListener.onShortenAnimationEnd(StretchSearchView.this.mSearchView);
                    }
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    if (StretchSearchView.this.mShortenAnimationListener != null) {
                        StretchSearchView.this.mShortenAnimationListener.onShortenAnimationStart(StretchSearchView.this.mSearchView);
                    }
                }
            });
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mInputText, "alpha", new float[]{this.mInputTextAlphaTo, this.mInputTextAlphaFrom});
            ofFloat4.setDuration((long) ((this.mShortenDuration * 4) / 5));
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mImgSearchClear, "alpha", new float[]{this.mInputClearAlphaTo, this.mInputClearAlphaFrom});
            ofFloat5.setDuration((long) ((this.mShortenDuration * 4) / 5));
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mImgSearch, "scaleX", new float[]{this.mScaleTo, this.mScaleFrom});
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.mImgSearch, "scaleY", new float[]{this.mScaleTo, this.mScaleFrom});
            if (this.mUseSysInterpolater) {
                ofFloat.setInterpolator(getMovingInterpolater());
                ofFloat2.setInterpolator(getStretchInterpolater());
                ofFloat6.setInterpolator(getScaleInterpolater());
                ofFloat7.setInterpolator(getScaleInterpolater());
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration((long) ((this.mShortenDuration * 4) / 5));
            if (this.mPlaySearchclearAlphaAnim) {
                animatorSet2.play(ofFloat5);
            }
            if (this.mPlayInputTextAlhpaAnim) {
                animatorSet2.play(ofFloat4);
            }
            animatorSet2.start();
            animatorSet.play(ofFloat3);
            if (this.mPlayMoveXAnim) {
                animatorSet.play(ofFloat3).with(ofFloat);
            }
            if (this.mPlayStretchWidthAnim) {
                animatorSet.play(ofFloat3).with(ofFloat2);
            }
            if (this.mPlaySearchImgScaleAnim) {
                animatorSet.play(ofFloat3).with(ofFloat6).with(ofFloat7);
            }
            if (this.mHasBtn) {
                ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.mButton, "alpha", new float[]{1.0f, 0.0f});
                ofFloat8.setDuration((long) ((this.mShortenDuration * 2) / 3));
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.setDuration((long) ((this.mShortenDuration * 2) / 3));
                animatorSet3.play(ofFloat8);
                animatorSet3.start();
            }
            animatorSet.start();
        }
    }

    private void stretchAmin() {
        int i = this.mAnimationState;
        if (i == 0 || i == 4) {
            this.mAnimationState = 1;
            beforeStretchViewState();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration((long) this.mStretchDuration);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mSearchLayout, x.f, new float[]{(float) this.mStretchXto});
            ofFloat.setDuration((long) this.mStretchDuration);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mSearchLayout, MonthView.VIEW_PARAMS_WIDTH, new float[]{(float) this.mStretchWidthTo});
            ofFloat2.setDuration((long) this.mStretchDuration);
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    StretchSearchView.this.mSearchLayout.setLayoutParams(new RelativeLayout.LayoutParams((int) ((Float) valueAnimator.getAnimatedValue()).floatValue(), StretchSearchView.this.mSearchLayout.getHeight()));
                }
            });
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mSearchLayout, "StretchSearchViewAnimValue", new float[]{this.mCustomAnimValueFrom, this.mCustomAnimValueTo});
            ofFloat3.setDuration((long) this.mStretchDuration);
            ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (StretchSearchView.this.mStretchAnimationListener != null) {
                        StretchSearchView.this.mStretchAnimationListener.onStetchAnimationUpdate(StretchSearchView.this.mSearchView, floatValue);
                    }
                }
            });
            animatorSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    StretchSearchView.this.afterStretchViewState();
                    int unused = StretchSearchView.this.mAnimationState = 2;
                    if (StretchSearchView.this.mStretchAnimationListener != null) {
                        StretchSearchView.this.mStretchAnimationListener.onStetchAnimationEnd(StretchSearchView.this.mSearchView);
                    }
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    if (StretchSearchView.this.mStretchAnimationListener != null) {
                        StretchSearchView.this.mStretchAnimationListener.onStetchAnimationStart(StretchSearchView.this.mSearchView);
                    }
                }
            });
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mImgSearchClear, "alpha", new float[]{this.mInputClearAlphaFrom, this.mInputClearAlphaTo});
            ofFloat4.setDuration((long) this.mStretchDuration);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mInputText, "alpha", new float[]{this.mInputTextAlphaFrom, this.mInputTextAlphaTo});
            ofFloat5.setDuration((long) this.mStretchDuration);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mImgSearch, "scaleX", new float[]{this.mScaleFrom, this.mScaleTo});
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.mImgSearch, "scaleY", new float[]{this.mScaleFrom, this.mScaleTo});
            ofFloat6.setDuration((long) this.mStretchDuration);
            ofFloat7.setDuration((long) this.mStretchDuration);
            if (this.mUseSysInterpolater) {
                ofFloat.setInterpolator(getMovingInterpolater());
                ofFloat2.setInterpolator(getStretchInterpolater());
                ofFloat6.setInterpolator(getScaleInterpolater());
                ofFloat7.setInterpolator(getScaleInterpolater());
            }
            animatorSet.play(ofFloat3);
            if (this.mPlayMoveXAnim) {
                animatorSet.play(ofFloat3).with(ofFloat);
            }
            if (this.mPlaySearchclearAlphaAnim) {
                animatorSet.play(ofFloat3).with(ofFloat4);
            }
            if (this.mPlayInputTextAlhpaAnim) {
                animatorSet.play(ofFloat3).with(ofFloat5);
            }
            if (this.mPlayStretchWidthAnim) {
                animatorSet.play(ofFloat3).with(ofFloat2);
            }
            if (this.mPlaySearchImgScaleAnim) {
                animatorSet.play(ofFloat3).with(ofFloat6).with(ofFloat7);
            }
            if (this.mHasBtn) {
                ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.mButton, "alpha", new float[]{0.0f, 1.0f});
                ofFloat8.setDuration((long) ((this.mStretchDuration * 2) / 3));
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.setDuration((long) ((this.mStretchDuration * 2) / 3));
                animatorSet2.play(ofFloat8).after((long) (this.mStretchDuration / 3));
                animatorSet2.start();
            }
            animatorSet.start();
        }
    }

    public void addEditTextChangedListener(TextWatcher textWatcher) {
        this.mInputText.addTextChangedListener(textWatcher);
    }

    public void afterShortenViewState() {
        this.mSearchView.requestLayout();
        this.mInputText.setVisibility(8);
        this.mSearchView.setVisibility(0);
        if (this.mHasBtn) {
            this.mButton.setVisibility(4);
        }
    }

    public void afterStretchViewState() {
        this.mSearchView.requestLayout();
        this.mInputText.showIme(true);
        if (this.mHasVoiceIcon) {
            this.mVoiceIcon.setVisibility(0);
        }
    }

    public void beforeShortenViewState() {
        this.mSearchView.requestLayout();
        this.mInputText.showIme(false);
        if (this.mHasVoiceIcon) {
            this.mVoiceIcon.setVisibility(8);
        }
    }

    public void beforeStretchViewState() {
        this.mSearchView.requestLayout();
        this.mSearchView.setVisibility(0);
        this.mInputText.setVisibility(0);
        this.mInputText.setText("");
        if (this.mHasBtn) {
            this.mButton.setVisibility(0);
            this.mButton.setAlpha(0.0f);
        }
    }

    public void calcWidth() {
        this.mStretchWidthFrom = this.mSearchLayout.getMeasuredWidth();
        this.mStretchWidthTo = getMaxStretchWidth();
    }

    public void calcX() {
        this.mStretchXfrom = (int) this.mSearchLayout.getX();
        this.mStretchXto = getMinMoveX();
    }

    public int getAnimationState() {
        return this.mAnimationState;
    }

    public String getBtnText() {
        if (!this.mHasBtn) {
            return null;
        }
        return this.mButton.getText().toString();
    }

    public float getCustomAnimValueFrom() {
        return this.mCustomAnimValueFrom;
    }

    public float getCustomAnimValueTo() {
        return this.mInputClearAlphaTo;
    }

    public float getInputClearAlphaFrom() {
        return this.mInputTextAlphaFrom;
    }

    public int getInputClearAlphaTo() {
        return this.mStretchWidthTo;
    }

    public float getInputTextAlphaFrom() {
        return this.mInputTextAlphaFrom;
    }

    public float getInputTextAlphaTo() {
        return this.mInputClearAlphaTo;
    }

    public boolean getIsAlignRight() {
        return this.mAlignRightWhenAnim;
    }

    public int getLayoutMarginLeftAdjust() {
        return this.mLayoutMarginLeftAdjust;
    }

    public int getLayoutMarginRightAdjust() {
        return this.mLayoutMarginRightAdjust;
    }

    public int getMaxStretchWidth() {
        int measuredWidth = this.mMainLayout.getMeasuredWidth();
        int paddingLeft = this.mMainLayout.getPaddingLeft();
        return this.mHasBtn ? (measuredWidth - this.mButton.getLayoutParams().width) - paddingLeft : (measuredWidth - paddingLeft) - this.mMainLayout.getPaddingRight();
    }

    public int getMinMoveX() {
        return ((int) this.mMainLayout.getX()) + this.mMainLayout.getPaddingLeft() + this.mLayoutMarginLeftAdjust;
    }

    public float getScaleFrom() {
        return this.mScaleFrom;
    }

    public float getScaleTo() {
        return this.mScaleTo;
    }

    public String getSearchText() {
        return this.mInputText.getText().toString();
    }

    public int getShortenAnimDuration() {
        return this.mShortenDuration;
    }

    public int getStretchAnimDuration() {
        return this.mStretchDuration;
    }

    public int getStretchWidthFrom() {
        return this.mStretchWidthFrom;
    }

    public int getStretchWidthTo() {
        return this.mStretchWidthTo;
    }

    public int getStretchXfrom() {
        return this.mStretchXfrom;
    }

    public int getStretchXto() {
        return this.mStretchXto;
    }

    public boolean getUseInterpolater() {
        return this.mUseSysInterpolater;
    }

    public void initAll() {
        initStretchType();
        initView(this.mContext);
        initViewState();
        initListener();
    }

    public void initListener() {
        this.mImgSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StretchSearchView.this.startStretch();
            }
        });
        this.mImgSearchClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StretchSearchView.this.mInputText.setText("");
            }
        });
        this.mInputText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                String obj = StretchSearchView.this.mInputText.getText().toString();
                if (obj == null || obj.isEmpty()) {
                    StretchSearchView.this.mImgSearchClear.setVisibility(8);
                    if (StretchSearchView.this.mAnimationState == 2 && StretchSearchView.this.mHasVoiceIcon) {
                        StretchSearchView.this.mVoiceIcon.setVisibility(0);
                    }
                    StretchSearchView.this.showIme(true);
                    return;
                }
                if (StretchSearchView.this.mHasVoiceIcon) {
                    StretchSearchView.this.mVoiceIcon.setVisibility(8);
                }
                StretchSearchView.this.mImgSearchClear.setVisibility(0);
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        int i = this.mStretchTpye;
        if (4 == i || 3 == i) {
            this.mInputText.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StretchSearchView.this.startStretch();
                }
            });
        }
        addPreDrawListener();
    }

    public void initStretchType() {
        int i = this.mStretchTpye;
        boolean z = false;
        this.mHasBtn = 2 == i || 4 == i || i == 0;
        if (true != this.mAlignRightWhenAnim) {
            z = true;
        }
        this.mPlayMoveXAnim = z;
    }

    public void initView(Context context) {
        this.mSearchView = null;
        int i = this.mStretchTpye;
        String str = "R.layout.mc_move_search_layout";
        if (i == 0) {
            this.mSearchView = View.inflate(context, R.layout.mc_stretch_search_layout_ext, this);
        } else if (3 == i) {
            this.mSearchView = View.inflate(context, R.layout.mc_move_search_layout, this);
        } else if (2 == i) {
            this.mSearchView = View.inflate(context, R.layout.mc_stretch_search_layout_ext, this);
            str = "R.layout.mc_stretch_search_layout_ext";
        } else {
            this.mSearchView = View.inflate(context, R.layout.mc_stretch_search_layout, this);
            str = "R.layout.mc_stretch_search_layout";
        }
        View view = this.mSearchView;
        if (view != null) {
            this.mMainLayout = (RelativeLayout) view.findViewById(R.id.mc_stretch_search_layout);
            this.mSearchLayout = (RelativeLayout) this.mSearchView.findViewById(R.id.mc_search_layout);
            this.mVoiceIcon = (ImageView) this.mSearchView.findViewById(R.id.mc_voice_icon);
            this.mImgSearch = (ImageView) this.mSearchView.findViewById(R.id.mc_search_icon);
            this.mImgSearchClear = (ImageView) this.mSearchView.findViewById(R.id.mc_search_icon_input_clear);
            SearchEditText searchEditText = (SearchEditText) this.mSearchView.findViewById(R.id.mc_search_edit);
            this.mInputText = searchEditText;
            searchEditText.setAlpha(this.mSearchLayoutInitAlpha);
            this.mInputText.setHint(this.mSearchTextHint);
            if (this.mHasBtn) {
                TextView textView = (TextView) this.mSearchView.findViewById(R.id.mc_search_textView);
                this.mButton = textView;
                textView.setTextColor(this.mButtonColor);
                this.mButton.setText(this.mTextViewContent);
                this.mButton.setAlpha(0.0f);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.rightMargin = this.mLayoutMarginRightAdjust;
            this.mSearchLayout.setLayoutParams(layoutParams);
            RelativeLayout relativeLayout = this.mMainLayout;
            relativeLayout.setPadding(this.mLayoutPaddingLeft, relativeLayout.getTop(), this.mLayoutPaddingRight, this.mMainLayout.getBottom());
            this.mMainLayout.requestLayout();
            return;
        }
        throw new IllegalArgumentException("StretchSearchView cannot inflate " + str + "!");
    }

    public void initViewState() {
        int i = this.mStretchTpye;
        if (3 == i || 4 == i) {
            this.mSearchView.setVisibility(0);
            this.mInputText.setVisibility(0);
            this.mInputText.setBackground((Drawable) null);
            this.mInputTextAlphaFrom = 0.8f;
        } else {
            this.mSearchView.setVisibility(0);
            this.mInputText.setVisibility(8);
        }
        this.mAnimationState = 0;
    }

    public boolean isAutoPlayStretchOnPreDraw() {
        return this.mPlayStretchOnPreDraw;
    }

    public boolean isHaveVoiceIcon() {
        return this.mHasVoiceIcon;
    }

    public boolean isPlayInputTextAlhpaAnim() {
        return this.mPlayInputTextAlhpaAnim;
    }

    public boolean isPlayMoveXAnim() {
        return this.mPlayMoveXAnim;
    }

    public boolean isPlaySearchImgScaleAnim() {
        return this.mPlaySearchImgScaleAnim;
    }

    public boolean isPlaySearchclearAlphaAnim() {
        return this.mPlaySearchclearAlphaAnim;
    }

    public boolean isPlayStretchWidthAnim() {
        return this.mPlayStretchWidthAnim;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void onInitLayout() {
        if (this.mStretchTpye != 0) {
            calcX();
            calcWidth();
        }
        int i = this.mStretchTpye;
        if (3 == i || 4 == i) {
            recalcFromMiddle();
        }
        Log.i(TAG, "Stretch width from " + this.mStretchWidthFrom + " to " + this.mStretchWidthTo + ", move X from " + this.mStretchXfrom + " to " + this.mStretchXto + " !");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(StretchSearchView.class.getName());
    }

    public void recalcFromMiddle() {
        int measureText = (((int) this.mInputText.getPaint().measureText(this.mInputText.getHint().toString())) / 2) + this.mImgSearch.getMeasuredWidth();
        this.mStretchWidthFrom = (getMaxStretchWidth() / 2) + measureText;
        this.mStretchXfrom = (this.mMainLayout.getMeasuredWidth() / 2) - measureText;
        this.mStretchXto = getMinMoveX();
        this.mSearchLayout.setX((float) this.mStretchXfrom);
        Log.i(TAG, "Reset stretch layout, search icon location X to layout right:  " + this.mStretchWidthFrom + ",search icon location X: " + this.mStretchXfrom + " !");
        ImageView imageView = (ImageView) this.mMainLayout.findViewById(R.id.mc_stretch_search_layout_1);
        if (imageView != null) {
            imageView.setX((float) (this.mStretchXto - this.mImgSearch.getPaddingLeft()));
        }
    }

    public void setAutoPlayStretchOnPreDraw(boolean z) {
        this.mPlayStretchOnPreDraw = z;
    }

    public void setBtnListener(View.OnClickListener onClickListener) {
        TextView textView = this.mButton;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setBtnText(String str) {
        if (this.mHasBtn) {
            this.mButton.setText(str);
        }
    }

    public void setCustomAnimValueFrom(float f) {
        this.mCustomAnimValueFrom = f;
    }

    public void setCustomAnimValueTo(float f) {
        this.mCustomAnimValueTo = f;
    }

    public void setEditTextListener(View.OnClickListener onClickListener) {
        this.mInputText.setOnClickListener(onClickListener);
    }

    public void setHaveVoiceIcon(boolean z) {
        this.mHasVoiceIcon = z;
    }

    public void setInputClearAlphaFrom(float f) {
        this.mInputTextAlphaFrom = f;
    }

    public void setInputClearAlphaTo(float f) {
        this.mInputTextAlphaTo = f;
    }

    public void setInputTextAlphaFrom(float f) {
        this.mInputTextAlphaFrom = f;
    }

    public void setInputTextAlphaTo(float f) {
        this.mInputTextAlphaTo = f;
    }

    public void setIsAlignRigh(boolean z) {
        this.mAlignRightWhenAnim = z;
    }

    public void setLayoutMarginLeftAdjust(int i) {
        this.mLayoutMarginLeftAdjust = i;
    }

    public void setLayoutMarginRightAdjust(int i) {
        this.mLayoutMarginRightAdjust = i;
    }

    public void setOnShortenAnimationListener(ShortenAnimationListener shortenAnimationListener) {
        this.mShortenAnimationListener = shortenAnimationListener;
    }

    public void setOnStretchAnimationListener(StretchAnimationListener stretchAnimationListener) {
        this.mStretchAnimationListener = stretchAnimationListener;
    }

    public void setPlayInputTextAlhpaAnim(boolean z) {
        this.mPlayInputTextAlhpaAnim = z;
    }

    public void setPlayMoveXAnim(boolean z) {
        this.mPlayMoveXAnim = z;
    }

    public void setPlaySearchImgScaleAnim(boolean z) {
        this.mPlaySearchImgScaleAnim = z;
    }

    public void setPlaySearchclearAlphaAnim(boolean z) {
        this.mPlaySearchclearAlphaAnim = z;
    }

    public void setPlayStretchWidthAnim(boolean z) {
        this.mPlayStretchWidthAnim = z;
    }

    public void setScaleFrom(float f) {
        this.mScaleFrom = f;
    }

    public void setScaleTo(float f) {
        this.mScaleTo = f;
    }

    public void setSearchText(String str) {
        this.mInputText.setText(str);
    }

    public void setShortenAnimDuration(int i) {
        this.mShortenDuration = i;
    }

    public void setStretchAnimDuration(int i) {
        this.mStretchDuration = i;
    }

    public void setStretchWidthFrom(int i) {
        this.mStretchWidthFrom = i;
    }

    public void setStretchWidthTo(int i) {
        this.mStretchWidthTo = i;
    }

    public void setStretchXfrom(int i) {
        this.mStretchXfrom = i;
    }

    public void setStretchXto(int i) {
        this.mStretchXto = i;
    }

    public void setUseInterpolater(boolean z) {
        this.mUseSysInterpolater = z;
    }

    public void setVoiceIconListener(View.OnClickListener onClickListener) {
        if (this.mHasVoiceIcon) {
            this.mVoiceIcon.setOnClickListener(onClickListener);
        }
    }

    public void showIme(boolean z) {
        this.mInputText.showIme(z);
    }

    public void startShorten() {
        shortenAmin();
    }

    public void startStretch() {
        stretchAmin();
    }

    public void startStretchOnPreDraw() {
        stretchAmin();
    }

    public StretchSearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_StretchSearchViewStyle);
    }

    public StretchSearchView(Context context, int i) {
        this(context);
        this.mStretchTpye = i;
    }

    public StretchSearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStretchXfrom = 0;
        this.mStretchXto = 0;
        this.mStretchWidthFrom = 0;
        this.mStretchWidthTo = 0;
        this.mLayoutMarginLeftAdjust = 0;
        this.mLayoutPaddingLeft = 0;
        this.mLayoutPaddingRight = 0;
        this.mLayoutMarginRightAdjust = 0;
        this.mPlayStretchOnPreDraw = false;
        this.mHasBtn = false;
        this.mHasVoiceIcon = false;
        this.mPlayStretchWidthAnim = true;
        this.mPlayMoveXAnim = true;
        this.mPlaySearchImgScaleAnim = true;
        this.mPlaySearchclearAlphaAnim = true;
        this.mPlayInputTextAlhpaAnim = true;
        this.mStretchTpye = 1;
        this.mUseSysInterpolater = false;
        this.mAlignRightWhenAnim = false;
        this.mStretchDuration = SlideNotice.SHOW_ANIMATION_DURATION;
        this.mShortenDuration = SlideNotice.SHOW_ANIMATION_DURATION;
        this.mInputClearAlphaFrom = 0.0f;
        this.mInputClearAlphaTo = 1.0f;
        this.mInputTextAlphaFrom = 0.0f;
        this.mInputTextAlphaTo = 1.0f;
        this.mCustomAnimValueFrom = 0.0f;
        this.mCustomAnimValueTo = 1.0f;
        this.mScaleFrom = 1.0f;
        this.mScaleTo = 0.9f;
        this.mSearchLayoutInitAlpha = 0.0f;
        this.mButtonColor = -1;
        this.mSearchTextHint = "搜索";
        this.mStretchAnimationListener = null;
        this.mShortenAnimationListener = null;
        this.mAnimationState = -1;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StretchSearchView, i, 0);
        this.mStretchTpye = obtainStyledAttributes.getInteger(R.styleable.StretchSearchView_mcStretchTpye, this.mStretchTpye);
        this.mHasVoiceIcon = obtainStyledAttributes.getBoolean(R.styleable.StretchSearchView_mcHasVoiceIcon, this.mHasVoiceIcon);
        this.mPlayStretchOnPreDraw = obtainStyledAttributes.getBoolean(R.styleable.StretchSearchView_mcPlayStretchOnPreDraw, this.mPlayStretchOnPreDraw);
        this.mAlignRightWhenAnim = obtainStyledAttributes.getBoolean(R.styleable.StretchSearchView_mcAlignRightWhenAnim, this.mAlignRightWhenAnim);
        this.mUseSysInterpolater = obtainStyledAttributes.getBoolean(R.styleable.StretchSearchView_mcUseSysInterpolater, this.mUseSysInterpolater);
        this.mStretchDuration = obtainStyledAttributes.getInteger(R.styleable.StretchSearchView_mcStretchDuration, this.mStretchDuration);
        this.mShortenDuration = obtainStyledAttributes.getInteger(R.styleable.StretchSearchView_mcShortenDuration, this.mShortenDuration);
        this.mSearchTextHint = obtainStyledAttributes.getString(R.styleable.StretchSearchView_mcSearchTextHint);
        this.mTextViewContent = obtainStyledAttributes.getString(R.styleable.StretchSearchView_mcTextViewContent);
        this.mSearchLayoutInitAlpha = obtainStyledAttributes.getFloat(R.styleable.StretchSearchView_mcSearchLayoutInitAlpha, this.mSearchLayoutInitAlpha);
        this.mButtonColor = obtainStyledAttributes.getColor(R.styleable.StretchSearchView_mcTextViewColor, -1);
        this.mLayoutMarginLeftAdjust = (int) obtainStyledAttributes.getDimension(R.styleable.StretchSearchView_mcLayoutMarginLeftAdjust, (float) this.mLayoutMarginLeftAdjust);
        this.mLayoutMarginRightAdjust = (int) obtainStyledAttributes.getDimension(R.styleable.StretchSearchView_mcLayoutMarginRightAdjust, (float) this.mLayoutMarginRightAdjust);
        this.mLayoutPaddingLeft = (int) obtainStyledAttributes.getDimension(R.styleable.StretchSearchView_mcLayoutPaddingLeft, (float) this.mLayoutPaddingLeft);
        this.mLayoutPaddingRight = (int) obtainStyledAttributes.getDimension(R.styleable.StretchSearchView_mcLayoutPaddingRight, (float) this.mLayoutPaddingRight);
        this.mStretchWidthFrom = (int) obtainStyledAttributes.getDimension(R.styleable.StretchSearchView_mcStretchWidthFrom, 0.0f);
        this.mStretchWidthTo = (int) obtainStyledAttributes.getDimension(R.styleable.StretchSearchView_mcStretchWidthTo, 0.0f);
        this.mStretchXfrom = (int) obtainStyledAttributes.getDimension(R.styleable.StretchSearchView_mcStretchXfrom, 0.0f);
        this.mStretchXto = (int) obtainStyledAttributes.getDimension(R.styleable.StretchSearchView_mcStretchXto, 0.0f);
        obtainStyledAttributes.recycle();
        initAll();
    }
}

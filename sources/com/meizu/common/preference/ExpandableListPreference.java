package com.meizu.common.preference;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.meizu.common.R;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.lang.reflect.Field;

@SuppressLint({"NewApi"})
public class ExpandableListPreference extends Preference {
    private int ANIMATION_DURATION;
    /* access modifiers changed from: private */
    public PreferenceAdapter mAdapter;
    private AnimHelper mAnimHelper;
    /* access modifiers changed from: private */
    public CharSequence[] mEntries;
    /* access modifiers changed from: private */
    public CharSequence[] mEntryValues;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private ImageView mImageView;
    public boolean mIsExtand;
    /* access modifiers changed from: private */
    public boolean mIsWaitingToChange;
    private LinearLayout mLinearLayout;
    private ListView mListView;
    /* access modifiers changed from: private */
    public TextView mSummary;
    private String mValue;
    private boolean mValueSet;
    /* access modifiers changed from: private */
    public Runnable performClick;

    @SuppressLint({"NewApi"})
    public class AnimHelper {
        public static final int COLLAPSE = 1;
        public static final int EXPAND = 0;
        private float mEndAlpha;
        /* access modifiers changed from: private */
        public int mEndBottomMargin;
        private int mEndHeight;
        /* access modifiers changed from: private */
        public boolean mIsAnimating = false;
        /* access modifiers changed from: private */
        public LinearLayout.LayoutParams mLayoutParams;
        private int mMarginTop = 0;
        private long mMillisTime;
        /* access modifiers changed from: private */
        public View mRonateView;
        private float mStartAlpha;
        /* access modifiers changed from: private */
        public int mStartBottomMargin;
        /* access modifiers changed from: private */
        public View mSummaryView;
        /* access modifiers changed from: private */
        public View mTarget;
        /* access modifiers changed from: private */
        public int mType;

        public class AnimInterpolator implements Interpolator {
            private AnimInterpolator() {
            }

            public float getInterpolation(float f) {
                return (float) (1.0d - Math.pow((double) (1.0f - f), 3.0d));
            }
        }

        public AnimHelper() {
        }

        private Interpolator getInterpolator() {
            return new PathInterpolator(0.33f, 0.0f, 0.1f, 1.0f);
        }

        public void animateHeightPrt() {
            int i = this.mType;
            if (i == 0) {
                this.mStartBottomMargin = (-this.mEndHeight) + this.mMarginTop;
                this.mEndBottomMargin = 0;
                this.mStartAlpha = 0.0f;
                this.mEndAlpha = 1.0f;
            } else if (i == 1) {
                this.mStartBottomMargin = 0;
                this.mEndBottomMargin = (-this.mEndHeight) + this.mMarginTop;
                this.mStartAlpha = 1.0f;
                this.mEndAlpha = 0.0f;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.mEndAlpha, this.mStartAlpha});
            ofFloat.setDuration((long) ((int) (((double) this.mMillisTime) * 0.4d)));
            if (this.mType == 1) {
                ofFloat.setStartDelay((long) ((int) (((double) this.mMillisTime) * 0.6d)));
            }
            ofFloat.setInterpolator(getInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AnimHelper.this.mSummaryView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (AnimHelper.this.mType == 1) {
                        AnimHelper.this.mSummaryView.setVisibility(0);
                    } else {
                        AnimHelper.this.mSummaryView.setVisibility(4);
                    }
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }
            });
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{this.mStartAlpha, this.mEndAlpha});
            ofFloat2.setDuration((long) ((int) (((double) this.mMillisTime) * 0.5d)));
            if (this.mType == 0) {
                ofFloat2.setStartDelay((long) ((int) (((double) this.mMillisTime) * 0.4d)));
            }
            ofFloat2.setInterpolator(getInterpolator());
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AnimHelper.this.mTarget.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            final ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.mStartBottomMargin, this.mEndBottomMargin});
            ofInt.setInterpolator(getInterpolator());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float abs = ((float) Math.abs(((Integer) valueAnimator.getAnimatedValue()).intValue() - AnimHelper.this.mStartBottomMargin)) / ((float) Math.abs(AnimHelper.this.mStartBottomMargin - AnimHelper.this.mEndBottomMargin));
                    if (AnimHelper.this.mType == 0) {
                        AnimHelper.this.mRonateView.setRotation(abs * 180.0f);
                    } else {
                        AnimHelper.this.mRonateView.setRotation((1.0f - abs) * 180.0f);
                    }
                    AnimHelper.this.mLayoutParams.bottomMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (!AnimHelper.this.mTarget.isInLayout()) {
                        AnimHelper.this.mTarget.requestLayout();
                    }
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    animator.removeAllListeners();
                    ofInt.removeAllUpdateListeners();
                    ofInt.removeAllListeners();
                    if (AnimHelper.this.mType == 1) {
                        AnimHelper.this.mTarget.setVisibility(4);
                    }
                    boolean unused = AnimHelper.this.mIsAnimating = false;
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    AnimHelper.this.mTarget.setVisibility(0);
                    boolean unused = AnimHelper.this.mIsAnimating = true;
                }
            });
            ofInt.setDuration(this.mMillisTime);
            animatorSet.playTogether(new Animator[]{ofInt, ofFloat2, ofFloat});
            animatorSet.start();
        }

        public boolean iSAnimating() {
            return this.mIsAnimating;
        }

        public void init(View view, View view2, View view3, int i, long j) {
            this.mTarget = view;
            this.mSummaryView = view3;
            this.mRonateView = view2;
            this.mType = i;
            this.mMillisTime = j;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            this.mLayoutParams = layoutParams;
            int i2 = layoutParams.height;
            this.mEndHeight = i2;
            if (this.mType == 0) {
                layoutParams.bottomMargin = -i2;
            } else {
                layoutParams.bottomMargin = 0;
            }
            this.mTarget.setVisibility(0);
            float f = 1.0f;
            this.mTarget.setAlpha(this.mType == 0 ? 0.0f : 1.0f);
            this.mSummaryView.setVisibility(0);
            View view4 = this.mSummaryView;
            if (this.mType != 0) {
                f = 0.0f;
            }
            view4.setAlpha(f);
        }

        public void setMarginTop(int i) {
            this.mMarginTop = i;
        }
    }

    public class PreferenceAdapter extends BaseAdapter {
        private Context mContext;
        private CharSequence[] mData;
        private ListView mList;
        private int mSelectedPosition = -1;

        public class Holder {
            public CheckedTextView checkedTextView;

            private Holder() {
            }
        }

        public PreferenceAdapter(Context context, CharSequence[] charSequenceArr) {
            this.mContext = context;
            this.mData = charSequenceArr;
        }

        public int getCount() {
            return this.mData.length;
        }

        public Object getItem(int i) {
            return this.mData[i];
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            Holder holder;
            if (view == null) {
                holder = new Holder();
                view2 = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.mc_expandable_preference_list_item, (ViewGroup) null);
                holder.checkedTextView = (CheckedTextView) view2;
                view2.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContext.getResources().getDimensionPixelOffset(R.dimen.mc_expandable_preference_list_item_height)));
                view2.setTag(holder);
            } else {
                view2 = view;
                holder = (Holder) view.getTag();
            }
            holder.checkedTextView.setText(this.mData[i]);
            if (i == this.mSelectedPosition) {
                this.mList.setItemChecked(i, true);
            }
            return view2;
        }

        public void setSelectedPosition(int i) {
            this.mSelectedPosition = i;
        }

        public void setTargetList(ListView listView) {
            this.mList = listView;
        }
    }

    public ExpandableListPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    private int getValueIndex() {
        return findIndexOfValue(this.mValue);
    }

    /* access modifiers changed from: private */
    public void setListSummary(CharSequence charSequence) {
        try {
            Field declaredField = Preference.class.getDeclaredField("mSummary");
            declaredField.setAccessible(true);
            declaredField.set(this, charSequence);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        }
    }

    public int findIndexOfValue(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.mEntryValues) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.mEntryValues[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] getEntries() {
        return this.mEntries;
    }

    public CharSequence getEntry() {
        CharSequence[] charSequenceArr;
        int valueIndex = getValueIndex();
        if (valueIndex < 0 || (charSequenceArr = this.mEntries) == null) {
            return null;
        }
        return charSequenceArr[valueIndex];
    }

    public CharSequence[] getEntryValues() {
        return this.mEntryValues;
    }

    public String getValue() {
        return this.mValue;
    }

    public boolean iSAnimating() {
        AnimHelper animHelper = this.mAnimHelper;
        if (animHelper != null) {
            return animHelper.iSAnimating();
        }
        return false;
    }

    public void onBindView(View view) {
        super.onBindView(view);
        this.mListView = (ListView) view.findViewById(R.id.expand_listview);
        this.mAdapter = new PreferenceAdapter(getContext(), this.mEntries);
        this.mSummary = (TextView) view.findViewById(16908304);
        this.mImageView = (ImageView) view.findViewById(R.id.pull_icon);
        CharSequence[] charSequenceArr = this.mEntries;
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            int valueIndex = getValueIndex() != -1 ? getValueIndex() : 0;
            setSummary(this.mEntries[valueIndex]);
            this.mSummary.setText(this.mEntries[valueIndex]);
            this.mAdapter.setSelectedPosition(valueIndex);
            this.mAdapter.notifyDataSetChanged();
            if (this.mIsExtand) {
                this.mSummary.setVisibility(4);
            } else {
                this.mSummary.setVisibility(0);
            }
            this.mListView.setAdapter(this.mAdapter);
            this.mAdapter.setTargetList(this.mListView);
            this.mListView.setChoiceMode(1);
            this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (!ExpandableListPreference.this.iSAnimating() && !ExpandableListPreference.this.mIsWaitingToChange) {
                        ExpandableListPreference.this.mAdapter.setSelectedPosition(i);
                        ExpandableListPreference.this.mAdapter.notifyDataSetChanged();
                        if (ExpandableListPreference.this.mEntryValues != null) {
                            String charSequence = ExpandableListPreference.this.mEntryValues[i].toString();
                            ExpandableListPreference.this.mSummary.setText(ExpandableListPreference.this.mEntries[i]);
                            ExpandableListPreference expandableListPreference = ExpandableListPreference.this;
                            expandableListPreference.setListSummary(expandableListPreference.mEntries[i]);
                            if (ExpandableListPreference.this.callChangeListener(charSequence)) {
                                ExpandableListPreference.this.setValue(charSequence);
                            }
                        }
                        ExpandableListPreference.this.mHandler.postDelayed(ExpandableListPreference.this.performClick, 200);
                    }
                }
            });
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.container);
        this.mLinearLayout = linearLayout;
        linearLayout.measure(0, 0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mLinearLayout.getLayoutParams();
        CharSequence[] charSequenceArr2 = this.mEntries;
        if (charSequenceArr2 != null && charSequenceArr2.length > 0) {
            layoutParams.height = this.mLinearLayout.getMeasuredHeight() * this.mEntries.length;
        }
        if (this.mIsExtand) {
            this.mLinearLayout.setVisibility(0);
            this.mLinearLayout.setFocusable(false);
            return;
        }
        this.mLinearLayout.setVisibility(8);
    }

    public void onClick() {
        if (!iSAnimating() && !this.mIsWaitingToChange) {
            if (this.mIsExtand) {
                this.mAnimHelper.init(this.mLinearLayout, this.mImageView, this.mSummary, 1, (long) this.ANIMATION_DURATION);
                this.mAnimHelper.animateHeightPrt();
                this.mIsExtand = false;
                return;
            }
            this.mAnimHelper.init(this.mLinearLayout, this.mImageView, this.mSummary, 0, (long) this.ANIMATION_DURATION);
            this.mAnimHelper.animateHeightPrt();
            this.mIsExtand = true;
        }
    }

    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    public void onSetInitialValue(boolean z, Object obj) {
        setValue(z ? getPersistedString(this.mValue) : (String) obj);
    }

    public void performCollapseAnim() {
        if (this.mIsExtand) {
            this.mAnimHelper.init(this.mLinearLayout, this.mImageView, this.mSummary, 1, (long) this.ANIMATION_DURATION);
            this.mAnimHelper.animateHeightPrt();
            this.mIsExtand = false;
        }
    }

    public void setEntries(CharSequence[] charSequenceArr) {
        this.mEntries = charSequenceArr;
    }

    public void setEntryValues(CharSequence[] charSequenceArr) {
        this.mEntryValues = charSequenceArr;
    }

    public void setValue(String str) {
        boolean z = !TextUtils.equals(this.mValue, str);
        if (z || !this.mValueSet) {
            this.mValue = str;
            this.mValueSet = true;
            persistString(str);
            if (z) {
                notifyChanged();
            }
        }
    }

    public ExpandableListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandableListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsExtand = false;
        this.ANIMATION_DURATION = CmdCode.CODE_WAKEUP_RECORDING;
        this.mHandler = new Handler();
        this.mIsWaitingToChange = false;
        this.performClick = new Runnable() {
            public void run() {
                ExpandableListPreference.this.performCollapseAnim();
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableListPreference, 0, 0);
        this.mEntries = obtainStyledAttributes.getTextArray(R.styleable.ExpandableListPreference_mcEntries);
        this.mEntryValues = obtainStyledAttributes.getTextArray(R.styleable.ExpandableListPreference_mcEntryValues);
        obtainStyledAttributes.recycle();
        setLayoutResource(R.layout.mc_expandable_preference_layout);
        AnimHelper animHelper = new AnimHelper();
        this.mAnimHelper = animHelper;
        animHelper.setMarginTop(-context.getResources().getDimensionPixelSize(R.dimen.mc_expandable_preference_inner_list_margin));
    }
}

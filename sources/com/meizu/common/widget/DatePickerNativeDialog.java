package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.meizu.common.R;
import com.meizu.common.datetimepicker.date.CalendarDay;
import com.meizu.common.datetimepicker.date.MonthView;
import com.meizu.common.datetimepicker.date.SimpleMonthView;
import com.meizu.common.interpolator.PathInterpolatorCompat;
import com.meizu.common.util.InternalResUtils;
import com.meizu.common.util.LunarCalendar;
import com.meizu.common.util.ResourceUtils;
import com.meizu.common.util.ScreenUtil;
import com.meizu.common.widget.DatePicker;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import org.apache.commons.lang3.time.DateUtils;

public class DatePickerNativeDialog extends AlertDialog implements DialogInterface.OnClickListener, DatePicker.OnDateChangedListener {
    private static final String DAY = "day";
    private static final String MONTH = "month";
    private static final int STATUS_DOWN = 1;
    private static final int STATUS_UP = 0;
    private static final int STATUS_UP_MIN = 2;
    private static final String TAG = "DatePickerNativeDialog";
    private static final String YEAR = "year";
    private static Method setWidthMethod;
    /* access modifiers changed from: private */
    public int BUTTON_TRANSLATE_DURATION;
    /* access modifiers changed from: private */
    public int FIVE_ROWHEIGHT;
    /* access modifiers changed from: private */
    public int FOUR_ROWHEIGHT;
    private int LUNAR_HIDE_SHOW_DURATION;
    /* access modifiers changed from: private */
    public int ROWHEIGHT;
    /* access modifiers changed from: private */
    public int SELECT_DAY_DELAY;
    /* access modifiers changed from: private */
    public int SIX_ROWHEIGHT;
    private ObjectAnimator anim;
    /* access modifiers changed from: private */
    public boolean isShowLunar;
    private boolean isZH;
    private String leap;
    private View mButtonPanel;
    private final OnDateSetListener mCallBack;
    /* access modifiers changed from: private */
    public int mCurrentPosition;
    /* access modifiers changed from: private */
    public float mCurrentTranslateYPosition;
    private TextView mDayStatusTv;
    private String mDayText;
    private int mDialogWidth;
    private ArrayList<Calendar> mEventRemindList;
    /* access modifiers changed from: private */
    public int[] mHeightRecord;
    private String mHideLunarText;
    private float mInitTranslationY;
    /* access modifiers changed from: private */
    public boolean mIsFlyme8;
    private String mLunarText;
    private String[] mLunardays;
    private int mMaxYear;
    private int mMinYear;
    /* access modifiers changed from: private */
    public MonthAdapter mMonthAdapter;
    private TextView mMonthDayTv;
    private String mMonthText;
    /* access modifiers changed from: private */
    public ViewPager mMouthPager;
    private OnDateChangedListener mOnDateChangedListener;
    private String mOneDayAfterText;
    private String mOneDayBeforeText;
    HeightRecordCallBack mRecord;
    private RectClipView mRectClipView;
    /* access modifiers changed from: private */
    public int mSelectDay;
    /* access modifiers changed from: private */
    public int mSelectMonth;
    /* access modifiers changed from: private */
    public int mSelectYear;
    private String mShowLunarText;
    private TextView mShowLunarTv;
    private String mTodayText;
    private String[] mouths;

    public interface HeightRecord {
        void recordHeight(int i, int i2);
    }

    public class HeightRecordCallBack implements HeightRecord {
        public HeightRecordCallBack() {
        }

        public void recordHeight(int i, int i2) {
            if (DatePickerNativeDialog.this.mHeightRecord == null) {
                DatePickerNativeDialog datePickerNativeDialog = DatePickerNativeDialog.this;
                int[] unused = datePickerNativeDialog.mHeightRecord = new int[datePickerNativeDialog.mMonthAdapter.getCount()];
            }
            DatePickerNativeDialog.this.mHeightRecord[i] = i2;
        }
    }

    public class MonthAdapter extends PagerAdapter {
        private boolean isMonthShowLunar;
        private int mMaxYear;
        private int mMinYear;
        private float mPaintAlpha = 1.0f;
        private int mParentHeight;

        public MonthAdapter(int i, int i2) {
            this.mMinYear = i;
            this.mMaxYear = i2;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return ((this.mMaxYear - this.mMinYear) + 1) * 12;
        }

        public int getItemPosition(Object obj) {
            return -2;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public void setMonthShowLunar(boolean z) {
            this.isMonthShowLunar = z;
        }

        public void setPaintAlpha(float f) {
            this.mPaintAlpha = f;
        }

        public void setParentHeight(int i) {
            this.mParentHeight = i;
        }

        public View instantiateItem(ViewGroup viewGroup, int i) {
            Context context = viewGroup.getContext();
            int i2 = (i / 12) + this.mMinYear;
            SimpleMonthView simpleMonthView = new SimpleMonthView(context);
            HashMap hashMap = new HashMap();
            hashMap.put("year", Integer.valueOf(i2));
            int i3 = i % 12;
            hashMap.put("month", Integer.valueOf(i3));
            hashMap.put(MonthView.VIEW_PARAMS_WEEK_START, 2);
            hashMap.put(MonthView.VIEW_PARAMS_PAINT_ALPHA, Float.valueOf(this.mPaintAlpha));
            if (i2 == DatePickerNativeDialog.this.mSelectYear && i3 == DatePickerNativeDialog.this.mSelectMonth) {
                hashMap.put(MonthView.VIEW_PARAMS_SELECTED_DAY, Integer.valueOf(DatePickerNativeDialog.this.mSelectDay));
            }
            DatePickerNativeDialog.this.setDrawingParamsRemind(hashMap, i2, i3);
            simpleMonthView.setHeightRecordCallBack(i, DatePickerNativeDialog.this.mRecord);
            simpleMonthView.setMonthParams(hashMap);
            simpleMonthView.setShowLunar(this.isMonthShowLunar);
            simpleMonthView.setOnDayClickListener(new MonthView.OnDayClickListener() {
                public void onDayClick(MonthView monthView, CalendarDay calendarDay) {
                    int unused = DatePickerNativeDialog.this.mSelectYear = calendarDay.getYear();
                    int unused2 = DatePickerNativeDialog.this.mSelectMonth = calendarDay.getMonth();
                    int unused3 = DatePickerNativeDialog.this.mSelectDay = calendarDay.getDay();
                    DatePickerNativeDialog datePickerNativeDialog = DatePickerNativeDialog.this;
                    datePickerNativeDialog.updateDateShowInfo(datePickerNativeDialog.mSelectYear, DatePickerNativeDialog.this.mSelectMonth, DatePickerNativeDialog.this.mSelectDay);
                    DatePickerNativeDialog.this.mMonthAdapter.notifyDataSetChanged();
                    DatePickerNativeDialog.this.notifyDateChangedListener();
                }
            });
            viewGroup.addView(simpleMonthView);
            return simpleMonthView;
        }
    }

    public interface OnDateChangedListener {
        void onDateChanged(DatePickerNativeDialog datePickerNativeDialog, int i, int i2, int i3);
    }

    public interface OnDateSetListener {
        void onDateSet(int i, int i2, int i3);
    }

    public DatePickerNativeDialog(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3) {
        this(context, 0, onDateSetListener, i, i2, i3);
    }

    private void buttonInitTranslate(int i) {
        float f;
        float f2;
        int i2;
        float f3;
        int i3;
        ObjectAnimator objectAnimator = this.anim;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.anim.cancel();
        }
        float translationY = getTranslateView().getTranslationY();
        if (this.mIsFlyme8) {
            if (i == 0) {
                f3 = this.mInitTranslationY;
                i3 = this.ROWHEIGHT;
            } else if (i == 1) {
                f = this.mInitTranslationY;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getTranslateView(), "translationY", new float[]{translationY, f});
                this.anim = ofFloat;
                ofFloat.setDuration((long) this.BUTTON_TRANSLATE_DURATION);
                this.anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float unused = DatePickerNativeDialog.this.mCurrentTranslateYPosition = ((Float) valueAnimator.getAnimatedValue("translationY")).floatValue();
                        DatePickerNativeDialog.this.clipCustomView();
                    }
                });
                this.anim.start();
            } else if (i == 2) {
                f3 = this.mInitTranslationY;
                i3 = this.ROWHEIGHT * 2;
            }
            f = f3 + ((float) i3);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(getTranslateView(), "translationY", new float[]{translationY, f});
            this.anim = ofFloat2;
            ofFloat2.setDuration((long) this.BUTTON_TRANSLATE_DURATION);
            this.anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = DatePickerNativeDialog.this.mCurrentTranslateYPosition = ((Float) valueAnimator.getAnimatedValue("translationY")).floatValue();
                    DatePickerNativeDialog.this.clipCustomView();
                }
            });
            this.anim.start();
        }
        if (i == 0) {
            f2 = this.mInitTranslationY;
            i2 = this.ROWHEIGHT;
        } else if (i == 1) {
            f = this.mInitTranslationY;
            ObjectAnimator ofFloat22 = ObjectAnimator.ofFloat(getTranslateView(), "translationY", new float[]{translationY, f});
            this.anim = ofFloat22;
            ofFloat22.setDuration((long) this.BUTTON_TRANSLATE_DURATION);
            this.anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = DatePickerNativeDialog.this.mCurrentTranslateYPosition = ((Float) valueAnimator.getAnimatedValue("translationY")).floatValue();
                    DatePickerNativeDialog.this.clipCustomView();
                }
            });
            this.anim.start();
        } else if (i == 2) {
            f2 = this.mInitTranslationY;
            i2 = this.ROWHEIGHT * 2;
        }
        f = f2 - ((float) i2);
        ObjectAnimator ofFloat222 = ObjectAnimator.ofFloat(getTranslateView(), "translationY", new float[]{translationY, f});
        this.anim = ofFloat222;
        ofFloat222.setDuration((long) this.BUTTON_TRANSLATE_DURATION);
        this.anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = DatePickerNativeDialog.this.mCurrentTranslateYPosition = ((Float) valueAnimator.getAnimatedValue("translationY")).floatValue();
                DatePickerNativeDialog.this.clipCustomView();
            }
        });
        this.anim.start();
        f = 0.0f;
        ObjectAnimator ofFloat2222 = ObjectAnimator.ofFloat(getTranslateView(), "translationY", new float[]{translationY, f});
        this.anim = ofFloat2222;
        ofFloat2222.setDuration((long) this.BUTTON_TRANSLATE_DURATION);
        this.anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = DatePickerNativeDialog.this.mCurrentTranslateYPosition = ((Float) valueAnimator.getAnimatedValue("translationY")).floatValue();
                DatePickerNativeDialog.this.clipCustomView();
            }
        });
        this.anim.start();
    }

    /* access modifiers changed from: private */
    public void buttonTranslate(View view, float f, long j, boolean z) {
        this.mCurrentTranslateYPosition = f;
        view.setTranslationY(f);
        clipCustomView();
    }

    /* access modifiers changed from: private */
    public void clipCustomView() {
        RectClipView rectClipView = this.mRectClipView;
        rectClipView.setClipRect(0, 0, rectClipView.getWidth(), (int) (((float) this.mRectClipView.getHeight()) + this.mCurrentTranslateYPosition + 50.0f));
    }

    private void doAlphaAnim(boolean z) {
        ValueAnimator ofFloat = z ? ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}) : ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.setInterpolator(new PathInterpolatorCompat(0.3f, 0.0f, 0.7f, 1.0f));
        ofFloat.setDuration((long) this.LUNAR_HIDE_SHOW_DURATION);
        ofFloat.start();
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DatePickerNativeDialog.this.mMonthAdapter.setPaintAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                DatePickerNativeDialog.this.mMonthAdapter.notifyDataSetChanged();
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                if (!DatePickerNativeDialog.this.isShowLunar) {
                    DatePickerNativeDialog.this.mMonthAdapter.setMonthShowLunar(DatePickerNativeDialog.this.isShowLunar);
                    DatePickerNativeDialog.this.mMonthAdapter.notifyDataSetChanged();
                }
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }
        });
    }

    private void getButtonPanel() {
        if (this.mButtonPanel == null) {
            View findViewById = findViewById(InternalResUtils.getInternalResId(0, "buttonPanel"));
            this.mButtonPanel = findViewById;
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.mz_dialog_background_material_bottom));
            getWindow().setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.mz_dialog_background_transparent));
            this.mInitTranslationY = getTranslateView().getTranslationY();
            initButtonLocationY();
        }
    }

    private int getDaySpaceWithToday(int i, int i2, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance();
        instance.set(1, i);
        instance.set(2, i2);
        instance.set(5, i3);
        return (int) ((instance.getTimeInMillis() - currentTimeMillis) / DateUtils.MILLIS_PER_DAY);
    }

    private int getGregorianMonthDays(int i, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.set(5, 1);
        instance.set(1, i);
        instance.set(2, i2);
        return instance.getActualMaximum(5);
    }

    private String getLunarDateText(int i, int i2, int i3) {
        String str;
        int i4 = i2 + 1;
        int leapMonth = LunarCalendar.leapMonth(i);
        int[] solarToLunar = LunarCalendar.solarToLunar(i, i4, i3);
        int i5 = solarToLunar[1];
        if (i5 == leapMonth && solarToLunar[3] == 1) {
            str = this.leap + this.mouths[solarToLunar[1] - 1];
        } else {
            str = this.mouths[i5 - 1];
        }
        if (this.isZH) {
            return str + this.mMonthText + getLunarDays(solarToLunar[2] - 1);
        } else if (i4 <= 0 || i4 > this.mouths.length) {
            return "";
        } else {
            return this.mLunarText + str + " " + getLunarDays(solarToLunar[2] - 1);
        }
    }

    private String getLunarDays(int i) {
        String[] strArr = this.mLunardays;
        if (i > strArr.length - 1) {
            return null;
        }
        return strArr[i];
    }

    /* access modifiers changed from: private */
    public View getTranslateView() {
        return this.mIsFlyme8 ? this.mRectClipView : this.mButtonPanel;
    }

    /* access modifiers changed from: private */
    public void initButtonLocationY() {
        if (getTranslateView() == null) {
            Log.d(TAG, "mButtonPanel == null, initButtonLocationY failed");
            return;
        }
        int i = this.mHeightRecord[this.mCurrentPosition];
        if (i == this.FIVE_ROWHEIGHT) {
            buttonInitTranslate(0);
        } else if (i == this.SIX_ROWHEIGHT) {
            buttonInitTranslate(1);
        } else if (i == this.FOUR_ROWHEIGHT) {
            buttonInitTranslate(2);
        }
    }

    private void initView(Context context, View view) {
        this.mRectClipView = (RectClipView) view.findViewById(R.id.native_picker_root);
        this.mMonthDayTv = (TextView) view.findViewById(R.id.month_day_view);
        this.mDayStatusTv = (TextView) view.findViewById(R.id.day_status);
        TextView textView = (TextView) view.findViewById(R.id.showlunar);
        this.mShowLunarTv = textView;
        if (!this.isZH) {
            textView.setVisibility(8);
        }
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.month_viewpager);
        this.mMouthPager = viewPager;
        viewPager.getLayoutParams().height = this.SIX_ROWHEIGHT;
        MonthAdapter monthAdapter = new MonthAdapter(this.mMinYear, this.mMaxYear);
        this.mMonthAdapter = monthAdapter;
        monthAdapter.setMonthShowLunar(this.isShowLunar);
        this.mMouthPager.setAdapter(this.mMonthAdapter);
        int i = ((this.mSelectYear - this.mMinYear) * 12) + this.mSelectMonth;
        this.mCurrentPosition = i;
        this.mMouthPager.setCurrentItem(i);
        this.mMouthPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
                int i3;
                if (i != 0 && i != DatePickerNativeDialog.this.mMonthAdapter.getCount() - 1) {
                    int i4 = i + 1;
                    if (DatePickerNativeDialog.this.mHeightRecord[i] != DatePickerNativeDialog.this.mHeightRecord[i4] && (i3 = ((int) ((((float) DatePickerNativeDialog.this.mHeightRecord[i]) * (1.0f - f)) + (((float) DatePickerNativeDialog.this.mHeightRecord[i4]) * f))) - DatePickerNativeDialog.this.mHeightRecord[DatePickerNativeDialog.this.mCurrentPosition]) != 0) {
                        int access$400 = DatePickerNativeDialog.this.ROWHEIGHT;
                        if (DatePickerNativeDialog.this.mHeightRecord[DatePickerNativeDialog.this.mCurrentPosition] == DatePickerNativeDialog.this.FOUR_ROWHEIGHT) {
                            access$400 = DatePickerNativeDialog.this.ROWHEIGHT * 2;
                        } else if (DatePickerNativeDialog.this.mHeightRecord[DatePickerNativeDialog.this.mCurrentPosition] == DatePickerNativeDialog.this.FIVE_ROWHEIGHT) {
                            access$400 = DatePickerNativeDialog.this.ROWHEIGHT;
                        } else if (DatePickerNativeDialog.this.mHeightRecord[DatePickerNativeDialog.this.mCurrentPosition] == DatePickerNativeDialog.this.SIX_ROWHEIGHT) {
                            access$400 = 0;
                        }
                        int i5 = i3 - access$400;
                        if (DatePickerNativeDialog.this.mIsFlyme8) {
                            i5 = -i5;
                        }
                        if (DatePickerNativeDialog.this.getTranslateView() != null) {
                            DatePickerNativeDialog datePickerNativeDialog = DatePickerNativeDialog.this;
                            datePickerNativeDialog.buttonTranslate(datePickerNativeDialog.getTranslateView(), (float) i5, (long) DatePickerNativeDialog.this.BUTTON_TRANSLATE_DURATION, false);
                        }
                    }
                }
            }

            public void onPageSelected(int i) {
                int unused = DatePickerNativeDialog.this.mCurrentPosition = i;
                DatePickerNativeDialog.this.mMouthPager.postDelayed(new Runnable() {
                    public void run() {
                        DatePickerNativeDialog.this.initButtonLocationY();
                        DatePickerNativeDialog.this.updateSelect2FirstDayOfMonth();
                    }
                }, (long) DatePickerNativeDialog.this.SELECT_DAY_DELAY);
            }
        });
        this.mShowLunarTv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DatePickerNativeDialog datePickerNativeDialog = DatePickerNativeDialog.this;
                datePickerNativeDialog.showLunar(!datePickerNativeDialog.isShowLunar());
            }
        });
        updateDateShowInfo(this.mSelectYear, this.mSelectMonth, this.mSelectDay);
        updateShowLunar();
    }

    private boolean isZh(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    /* access modifiers changed from: private */
    public void notifyDateChangedListener() {
        OnDateChangedListener onDateChangedListener = this.mOnDateChangedListener;
        if (onDateChangedListener != null) {
            onDateChangedListener.onDateChanged(this, this.mSelectYear, this.mSelectMonth, this.mSelectDay);
        }
    }

    private void setDaysAfterInfo(int i) {
        String str;
        if (i == -1) {
            str = this.mOneDayBeforeText;
        } else if (i == 0) {
            str = this.mTodayText;
        } else if (i != 1) {
            str = getContext().getResources().getString(i > 0 ? R.string.mc_custom_date_time_days_after : R.string.mc_custom_date_time_days_before, new Object[]{Integer.valueOf(Math.abs(i))});
        } else {
            str = this.mOneDayAfterText;
        }
        this.mDayStatusTv.setText(str);
    }

    private void setDialogWidth(int i) {
        setWidth(this, i);
    }

    /* access modifiers changed from: private */
    public void setDrawingParamsRemind(HashMap<String, Object> hashMap, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            ArrayList<Calendar> arrayList2 = this.mEventRemindList;
            if (arrayList2 != null && i3 < arrayList2.size()) {
                Calendar calendar = this.mEventRemindList.get(i3);
                if (i == calendar.get(1) && i2 == calendar.get(2)) {
                    arrayList.add(Integer.valueOf(calendar.get(5)));
                }
                i3++;
            }
        }
        if (arrayList.size() > 0) {
            hashMap.put(MonthView.VIEW_PARAMS_EVENT_REMIND, arrayList);
        }
    }

    private boolean setWidth(AlertDialog alertDialog, int i) {
        try {
            Method method = setWidthMethod;
            if (method == null) {
                Method declaredMethod = AlertDialog.class.getDeclaredMethod("setWidth", new Class[]{Integer.TYPE});
                setWidthMethod = declaredMethod;
                declaredMethod.setAccessible(true);
                setWidthMethod.invoke(alertDialog, new Object[]{Integer.valueOf(i)});
                return true;
            }
            method.setAccessible(true);
            setWidthMethod.invoke(alertDialog, new Object[]{Integer.valueOf(i)});
            return true;
        } catch (Exception e) {
            Log.e(TAG, "setWidth fail to be invoked.Caused by:" + e.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void updateDateShowInfo(int i, int i2, int i3) {
        String str;
        int i4 = i2 + 1;
        if (this.isZH) {
            str = this.isShowLunar ? String.format(Locale.getDefault(), "%d %s%s", new Object[]{Integer.valueOf(i), getContext().getResources().getString(R.string.mc_date_time_year), getLunarDateText(i, i2, i3)}) : String.format(Locale.getDefault(), "%d %s %d %s %d %s", new Object[]{Integer.valueOf(i), getContext().getResources().getString(R.string.mc_date_time_year), Integer.valueOf(i4), getContext().getResources().getString(R.string.mc_date_time_month), Integer.valueOf(i3), getContext().getResources().getString(R.string.mc_date_time_day)});
        } else {
            Calendar instance = Calendar.getInstance();
            instance.set(i, i2, i3);
            str = DateFormat.getDateInstance().format(instance.getTime());
        }
        this.mMonthDayTv.setText(str);
        setDaysAfterInfo(getDaySpaceWithToday(i, i2, i3));
    }

    /* access modifiers changed from: private */
    public void updateSelect2FirstDayOfMonth() {
        int i = this.mCurrentPosition;
        this.mSelectYear = (i / 12) + this.mMinYear;
        this.mSelectMonth = i % 12;
        this.mSelectDay = 1;
        this.mMonthAdapter.notifyDataSetChanged();
        updateDateShowInfo(this.mSelectYear, this.mSelectMonth, this.mSelectDay);
        notifyDateChangedListener();
    }

    private void updateShowLunar() {
        if (this.isShowLunar) {
            this.mShowLunarTv.setText(this.mHideLunarText);
        } else {
            this.mShowLunarTv.setText(this.mShowLunarText);
        }
    }

    public boolean isShowLunar() {
        return this.isShowLunar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        OnDateSetListener onDateSetListener = this.mCallBack;
        if (onDateSetListener != null) {
            onDateSetListener.onDateSet(this.mSelectYear, this.mSelectMonth, this.mSelectDay);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = findViewById(ResourceUtils.getIdentifier(getContext().getResources(), "dialogSpace1", "id", "android")) != null;
        this.mIsFlyme8 = z;
        if (z) {
            findViewById(ResourceUtils.getIdentifier(getContext().getResources(), "dialogSpace2", "id", "android")).getLayoutParams().height = 0;
            findViewById(ResourceUtils.getIdentifier(getContext().getResources(), "dialogSpace3", "id", "android")).getLayoutParams().height = 0;
            findViewById(ResourceUtils.getIdentifier(getContext().getResources(), "dialogSpace4", "id", "android")).getLayoutParams().height = 0;
            View findViewById = findViewById(InternalResUtils.getInternalResId(0, "buttonPanel"));
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), ScreenUtil.dip2px(getContext(), 24.0d));
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mRectClipView.measure(makeMeasureSpec, makeMeasureSpec);
        RectClipView rectClipView = this.mRectClipView;
        rectClipView.setClipRect(0, 0, rectClipView.getWidth(), this.mRectClipView.getHeight());
    }

    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mSelectYear = bundle.getInt("year");
        this.mSelectMonth = bundle.getInt("month");
        int i = bundle.getInt(DAY);
        this.mSelectDay = i;
        updateDateShowInfo(this.mSelectYear, this.mSelectMonth, i);
        ViewPager viewPager = this.mMouthPager;
        if (viewPager != null) {
            int i2 = ((this.mSelectYear - this.mMinYear) * 12) + this.mSelectMonth;
            this.mCurrentPosition = i2;
            viewPager.setCurrentItem(i2);
        }
        notifyDateChangedListener();
    }

    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putInt("year", this.mSelectYear);
        onSaveInstanceState.putInt("month", this.mSelectMonth);
        onSaveInstanceState.putInt(DAY, this.mSelectDay);
        return onSaveInstanceState;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            getButtonPanel();
        }
    }

    public void setEventRemind(ArrayList<Calendar> arrayList) {
        this.mEventRemindList = arrayList;
    }

    public void setMaxYear(int i) {
    }

    public void setMinYear(int i) {
    }

    public void setOnDateChangedListener(OnDateChangedListener onDateChangedListener) {
        this.mOnDateChangedListener = onDateChangedListener;
    }

    public void showLunar(boolean z) {
        if (this.isZH) {
            this.isShowLunar = z;
            updateDateShowInfo(this.mSelectYear, this.mSelectMonth, this.mSelectDay);
            updateShowLunar();
            boolean z2 = this.isShowLunar;
            if (z2) {
                this.mMonthAdapter.setMonthShowLunar(z2);
            }
            this.mMonthAdapter.notifyDataSetChanged();
            doAlphaAnim(z);
        }
    }

    public DatePickerNativeDialog(Context context, int i, OnDateSetListener onDateSetListener, int i2, int i3, int i4) {
        this(context, i, onDateSetListener, i2, i3, i4, false);
    }

    public DatePickerNativeDialog(Context context, int i, OnDateSetListener onDateSetListener, int i2, int i3, int i4, boolean z) {
        super(context, i);
        this.isShowLunar = false;
        this.mMaxYear = LunarCalendar.MAX_YEAR;
        this.mMinYear = 1900;
        this.LUNAR_HIDE_SHOW_DURATION = 256;
        this.BUTTON_TRANSLATE_DURATION = 1;
        this.SELECT_DAY_DELAY = 300;
        this.mIsFlyme8 = false;
        this.mRecord = new HeightRecordCallBack();
        this.mCallBack = onDateSetListener;
        setButton(-1, context.getText(R.string.mc_yes), this);
        setButton(-2, context.getText(17039360), (DialogInterface.OnClickListener) null);
        boolean isZh = isZh(context);
        this.isZH = isZh;
        if (isZh) {
            this.isShowLunar = z;
        }
        this.mShowLunarText = context.getResources().getString(R.string.mc_custom_date_time_show_lunar);
        this.mHideLunarText = context.getResources().getString(R.string.mc_custom_date_time_hide_lunar);
        this.mLunarText = context.getResources().getString(R.string.mc_custom_date_time_lunar);
        this.mMonthText = context.getResources().getString(R.string.mc_date_time_month);
        this.mDayText = context.getResources().getString(R.string.mc_date_time_day);
        this.leap = context.getResources().getString(R.string.mc_time_picker_leap);
        this.mTodayText = context.getResources().getString(R.string.mc_custom_date_time_today);
        this.mOneDayBeforeText = context.getResources().getString(R.string.mc_custom_date_time_one_day_before);
        this.mOneDayAfterText = context.getResources().getString(R.string.mc_custom_date_time_one_day_after);
        this.mouths = context.getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
        this.mLunardays = context.getResources().getStringArray(R.array.mc_custom_time_picker_lunar_day);
        this.mDialogWidth = context.getResources().getDimensionPixelSize(R.dimen.mc_native_date_picker_date_dialog_width);
        int rowHeight = MonthView.getRowHeight(context);
        this.ROWHEIGHT = rowHeight;
        this.SIX_ROWHEIGHT = rowHeight * 6;
        this.FIVE_ROWHEIGHT = rowHeight * 5;
        this.FOUR_ROWHEIGHT = rowHeight * 4;
        final View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.mc_date_picker_native_dialog, (ViewGroup) null);
        setView(inflate);
        inflate.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                inflate.removeOnLayoutChangeListener(this);
                LinearLayout linearLayout = (LinearLayout) DatePickerNativeDialog.this.findViewById(16908316);
                if (linearLayout != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams.setMargins(0, 0, 0, 0);
                    linearLayout.setLayoutParams(layoutParams);
                }
            }
        });
        int i5 = this.mMaxYear;
        i2 = i2 > i5 ? i5 : i2;
        this.mSelectYear = i2;
        i3 = i3 > 11 ? 11 : i3;
        this.mSelectMonth = i3;
        int gregorianMonthDays = getGregorianMonthDays(i2, i3);
        this.mSelectDay = i4 > gregorianMonthDays ? gregorianMonthDays : i4;
        initView(context, inflate);
        setDialogWidth(this.mDialogWidth);
    }
}

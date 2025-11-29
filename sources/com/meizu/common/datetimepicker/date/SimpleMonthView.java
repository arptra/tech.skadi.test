package com.meizu.common.datetimepicker.date;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.meizu.common.R;
import com.meizu.common.util.LunarCalendar;
import com.meizu.common.util.ScreenUtil;
import java.util.HashMap;
import java.util.Locale;

public class SimpleMonthView extends MonthView {
    private boolean isShowLunar = false;
    private String leap;
    private HashMap<Integer, int[]> mLunarValue = new HashMap<>();
    private String[] mLunardays = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_day);
    private String mMonthText;
    private float mRadius;
    private String[] mouths;

    public SimpleMonthView(Context context) {
        super(context);
        this.leap = context.getResources().getString(R.string.mc_time_picker_leap);
        this.mouths = context.getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
        this.mMonthText = context.getResources().getString(R.string.mc_date_time_month);
        this.mRadius = (float) ScreenUtil.dip2px(context, 4.0d);
    }

    private String getLunarDays(int i) {
        String[] strArr = this.mLunardays;
        if (i > strArr.length - 1) {
            return null;
        }
        return strArr[i];
    }

    public void drawMonthDay(Canvas canvas, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8;
        float f9;
        int[] iArr;
        String str;
        if (isOutOfRange(i, i2, i3)) {
            this.mMonthNumPaint.setColor(this.mDisabledDayTextColor);
            this.mMonthDayLabelPaint.setColor(this.mDisabledDayTextColor);
            this.mEventRemindPaint.setColor(this.mDisabledDayTextColor);
        } else if (this.mSelectedDay == i3) {
            this.mMonthNumPaint.setColor(this.mSelectDayColor);
            this.mMonthDayLabelPaint.setColor(this.mSelectDayColor);
            this.mMonthDayLabelPaint.setAlpha(this.mSelectPaintAlpha);
            this.mEventRemindPaint.setColor(this.mSelectDayColor);
        } else if (!this.mHasToday || this.mToday != i3) {
            this.mMonthNumPaint.setColor(this.mDayTextColor);
            this.mMonthDayLabelPaint.setColor(this.mLunarColor);
            this.mMonthDayLabelPaint.setAlpha(this.mLunarPaintAlpha);
            this.mEventRemindPaint.setColor(this.mEventRemindColor);
        } else {
            this.mMonthNumPaint.setColor(this.mTodayNumberColor);
            this.mMonthDayLabelPaint.setColor(this.mTodayNumberColor);
            this.mMonthDayLabelPaint.setAlpha(this.mSelectPaintAlpha);
            this.mEventRemindPaint.setColor(this.mEventRemindColor);
        }
        boolean isEventRemindDay = isEventRemindDay(i3);
        float f10 = f2 + ((float) this.mGregorianMarginTop);
        if (this.isShowLunar) {
            float f11 = ((float) this.mMonthNumFontMetrics.descent) + f10 + ((float) this.mPaddingOffset);
            Paint.FontMetricsInt fontMetricsInt = this.mMonthLunarLabelFontMetrics;
            int i4 = fontMetricsInt.descent;
            f8 = (f11 - ((float) fontMetricsInt.top)) - ((float) i4);
            if (isEventRemindDay) {
                int i5 = this.mEventDotMarginTop;
                float f12 = this.mEventRemindRadios;
                f9 = ((float) i5) + f8 + f12 + ((float) i4);
                f7 = ((float) i4) + f8 + ((float) i5) + f12;
            } else {
                f9 = f8 + ((float) i4);
                f7 = ((float) i4) + f8;
            }
        } else {
            f9 = isEventRemindDay ? ((float) this.mMonthNumFontMetrics.descent) + f10 + ((float) this.mEventDotMarginTop) + this.mEventRemindRadios : f10;
            f8 = f10;
            f7 = f9;
        }
        if (this.mSelectedDay == i3) {
            RectF rectF = new RectF();
            rectF.top = f5;
            float f13 = f7 + ((float) this.mBgMarginTop);
            rectF.bottom = f13;
            if (isEventRemindDay) {
                rectF.bottom = f13 + this.mEventRemindRadios;
            }
            int i6 = this.mBgPaddingLeftRight;
            rectF.left = f - ((float) i6);
            rectF.right = ((float) i6) + f;
            float f14 = this.mRadius;
            canvas.drawRoundRect(rectF, f14, f14, this.mSelectedCirclePaint);
        }
        canvas.drawText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i3)}), f, f10, this.mMonthNumPaint);
        if (this.isShowLunar) {
            int[] iArr2 = {i, i2 + 1, i3, 0};
            if (this.mLunarValue.containsKey(Integer.valueOf(i3))) {
                iArr = this.mLunarValue.get(Integer.valueOf(i3));
            } else {
                iArr = LunarCalendar.solarToLunar(iArr2[0], iArr2[1], iArr2[2]);
                this.mLunarValue.put(Integer.valueOf(i3), iArr);
            }
            int i7 = iArr[2];
            if (i7 == 1) {
                if (iArr[1] == LunarCalendar.leapMonth(i) && iArr[3] == 1) {
                    str = this.leap + this.mouths[iArr[1] - 1] + this.mMonthText;
                } else {
                    str = this.mouths[iArr[1] - 1] + this.mMonthText;
                }
            } else {
                str = getLunarDays(i7 - 1);
            }
            canvas.drawText(String.format(Locale.getDefault(), "%s", new Object[]{str}), f, f8, this.mMonthDayLabelPaint);
        }
        if (isEventRemindDay) {
            RectF rectF2 = new RectF();
            float f15 = this.mEventRemindRadios;
            rectF2.top = f9 - (f15 / 2.0f);
            rectF2.bottom = f9 + (f15 / 2.0f);
            float f16 = this.mEventRemindWidth;
            rectF2.left = f - (f16 / 2.0f);
            rectF2.right = f + (f16 / 2.0f);
            canvas.drawRoundRect(rectF2, f15, f15, this.mEventRemindPaint);
        }
    }

    public void drawMonthNums(Canvas canvas) {
        int monthHeaderSize = getMonthHeaderSize();
        int findDayOffset = findDayOffset();
        for (int i = 1; i <= this.mNumCells; i++) {
            if (this.isRTL) {
                RectF rectF = this.mTempRect;
                int i2 = this.mCellWidth;
                float f = (float) ((((this.mNumDays - findDayOffset) - 1) * i2) + this.mEdgePadding + this.mOffsetX);
                rectF.left = f;
                rectF.right = f + ((float) i2);
            } else {
                RectF rectF2 = this.mTempRect;
                int i3 = this.mCellWidth;
                float f2 = (float) ((findDayOffset * i3) + this.mEdgePadding + this.mOffsetX);
                rectF2.left = f2;
                rectF2.right = f2 + ((float) i3);
            }
            RectF rectF3 = this.mTempRect;
            float f3 = (float) monthHeaderSize;
            rectF3.top = f3;
            rectF3.bottom = (float) (this.mRowHeight + monthHeaderSize);
            Paint.FontMetricsInt fontMetricsInt = this.mMonthNumFontMetrics;
            float f4 = (f3 - ((float) fontMetricsInt.top)) - ((float) fontMetricsInt.descent);
            int i4 = this.mYear;
            int i5 = this.mMonth;
            float centerX = rectF3.centerX();
            RectF rectF4 = this.mTempRect;
            drawMonthDay(canvas, i4, i5, i, centerX, f4, rectF4.left, rectF4.right, rectF4.top, rectF4.bottom);
            findDayOffset++;
            if (findDayOffset == this.mNumDays) {
                monthHeaderSize += this.mRowHeight;
                findDayOffset = 0;
            }
        }
    }

    public void setShowLunar(boolean z) {
        this.isShowLunar = z;
    }
}

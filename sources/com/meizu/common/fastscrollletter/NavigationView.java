package com.meizu.common.fastscrollletter;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.meizu.common.R;
import com.meizu.common.interpolator.PathInterpolatorCompat;
import com.meizu.common.util.CommonUtils;
import com.meizu.common.util.ScreenUtil;
import com.meizu.common.widget.MzContactsContract;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NavigationView extends View {
    public static String[] DEFAULT_LETTERS = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
    public static String[] DEFAULT_LETTERS_AR = {"ا", "ﺏ", "ﺕ", "ﺙ", " ﺝ", "ﺡ", "ﺥ", "ﺩ", "ﺫ", "ﺭ", "ﺯ", "ﺱ", "ﺵ", "ﺹ", "ﺽ", "ﻁ", "ﻅ", "ﻉ", "ﻍ", "ف", "ﻕ", "ﻙ", "ﻝ", "ﻡ", "ن", "ﻩ", "ﻭ", "ﻱ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
    public static String[] DEFAULT_LETTERS_TH = {"ก", "ข", "ฃ", "ค", "ฅ", "ฆ", "ง", "จ", "ฉ", "ช", "ซ", "ฌ", "ญ", "ฎ", "ฏ", "ฐ", "ฑ", "ฒ", "ณ", "ด", "ต", "ถ", "ท", "ธ", "น", "บ", "ป", "ผ", "ฝ", "พ", "ฟ", "ภ", "ม", "ย", "ร", "ล", "ว", "ศ", "ษ", "ส", "ห", "อ", "ฮ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
    final int ENTRY_HIGHLIGHT_DURATION = 150;
    final int EXIT_HIGHLIGHT_DURATION = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    private Map<String, Bitmap> activeHideNavigationLetters;
    private int bottomPassHide;
    private NavigationViewCallBack callBack;
    private Context context;
    private int currentLetterIndex;
    private Map<String, Bitmap> customActiveHideNavigationLetters;
    private Map<String, Bitmap> customNormalHideNavigationLetters;
    private boolean initialized;
    private int intervalHide;
    private boolean isActive = true;
    private boolean isAuto;
    private boolean isOnTouching;
    private ArrayList<RectF> letterRect;
    /* access modifiers changed from: private */
    public int mCurrentColor;
    final Interpolator mInterpolator = new PathInterpolatorCompat(0.33f, 0.0f, 0.67f, 1.0f);
    private int navigationLetterActiveBackgroundColor;
    private int navigationLetterActiveTextColor;
    private Paint navigationLetterBackgroundPaint;
    private int navigationLetterLeftPadding;
    private int navigationLetterNormalBackgroundColor;
    private int navigationLetterNormalTextColor;
    private int navigationLetterRightMargin;
    private int navigationLetterRightPadding;
    private int navigationLetterSelectedBackgroundColor;
    private int navigationLetterSelectedBackgroundRadius;
    private int navigationLetterSelectedTextColor;
    private Paint navigationLetterTextPaint;
    private int navigationLetterTextSize;
    private int navigationLetterVerticalSpace;
    private int navigationLetterWidth;
    private ArrayList<String> navigationLetters;
    private boolean needDisposeData;
    private Map<String, Bitmap> normalHideNavigationLetters;
    private ArrayList<String> originalNavigationLetters;
    private int topPassHide;
    private ArrayList<String> virtualFocusLetters;

    public interface NavigationViewCallBack {
        int getListViewFirstVisiblePosition();

        int getListViewHeightNow();

        int getListViewItemCount();

        int getListViewLastVisiblePosition();

        void hideOverlay();

        void location(String str, int i);

        void showOverlay();

        void stopListViewScroll();

        void touchY(float f);
    }

    public NavigationView(Context context2) {
        super(context2);
        this.context = context2;
        initializeDefault();
    }

    private String analyseLocationLetter(float f) {
        int i = (int) (f / ((float) (this.navigationLetterTextSize + this.navigationLetterVerticalSpace)));
        ArrayList<String> arrayList = this.virtualFocusLetters;
        if (arrayList == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (i >= arrayList.size()) {
            i = this.virtualFocusLetters.size() - 1;
        }
        if (i < 0) {
            return null;
        }
        if (this.virtualFocusLetters.get(i) != null && this.virtualFocusLetters.get(i).contains(">>")) {
            if (this.navigationLetters == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.navigationLetters.size(); i2++) {
                if (this.navigationLetters.get(i2) != null && this.navigationLetters.get(i2).equals(this.virtualFocusLetters.get(i - 1))) {
                    return this.navigationLetters.get(i2 + 1);
                }
            }
        }
        return this.virtualFocusLetters.get(i);
    }

    private int analyzeLocationIndexByFullLetters(String str) {
        if (!(this.navigationLetters == null || str == null)) {
            for (int i = 0; i < this.navigationLetters.size(); i++) {
                if (this.navigationLetters.get(i) != null && this.navigationLetters.get(i).equals(str)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int analyzeLocationIndexByVirtualLetters(String str) {
        if (!(this.virtualFocusLetters == null || str == null)) {
            for (int i = 0; i < this.virtualFocusLetters.size(); i++) {
                if (this.virtualFocusLetters.get(i) != null && this.virtualFocusLetters.get(i).contains(str)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void disposeLayoutParams() {
        int i = 0;
        int i2 = 0;
        while (i < this.navigationLetters.size()) {
            if (needHide(this.navigationLetters.get(i))) {
                int i3 = i + 1;
                while (i3 < this.navigationLetters.size() && needHide(this.navigationLetters.get(i3))) {
                    i++;
                    i3++;
                }
            }
            i2++;
            i++;
        }
        fillVirtualFocusLetters();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.height = i2 * (this.navigationLetterTextSize + this.navigationLetterVerticalSpace);
        layoutParams.width = this.navigationLetterWidth;
        layoutParams.rightMargin = this.navigationLetterRightMargin;
        setLayoutParams(layoutParams);
        invalidate();
    }

    private void drawSelectedLetterBackground(Canvas canvas, RectF rectF, String str) {
        this.navigationLetterBackgroundPaint.setColor(this.navigationLetterSelectedBackgroundColor);
        this.navigationLetterBackgroundPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle((float) ((this.navigationLetterWidth - this.navigationLetterRightPadding) - this.navigationLetterSelectedBackgroundRadius), rectF.top + (rectF.height() / 2.0f), (float) this.navigationLetterSelectedBackgroundRadius, this.navigationLetterBackgroundPaint);
    }

    private void drawText(Canvas canvas, RectF rectF, String str, int i) {
        float f = (float) ((this.navigationLetterWidth - this.navigationLetterRightPadding) - this.navigationLetterSelectedBackgroundRadius);
        this.navigationLetterTextPaint.setColor(Color.argb(0, 0, 0, 0));
        canvas.drawRect(rectF, this.navigationLetterTextPaint);
        if (i == this.currentLetterIndex) {
            this.navigationLetterTextPaint.setColor(this.navigationLetterSelectedTextColor);
        } else {
            this.navigationLetterTextPaint.setColor(this.mCurrentColor);
        }
        if (needHide(str)) {
            Bitmap bitmap = (this.isActive ? this.activeHideNavigationLetters : this.normalHideNavigationLetters).get(str);
            if (bitmap == null) {
                canvas.drawCircle(f, rectF.centerY(), (float) (this.navigationLetterTextSize / 5), this.navigationLetterTextPaint);
            } else {
                canvas.drawBitmap(bitmap, f - ((float) (bitmap.getWidth() / 2)), rectF.centerY() - ((float) (bitmap.getHeight() / 2)), this.navigationLetterTextPaint);
            }
        } else {
            Paint.FontMetricsInt fontMetricsInt = this.navigationLetterTextPaint.getFontMetricsInt();
            canvas.drawText(str, f, (float) ((int) ((((rectF.bottom + rectF.top) - ((float) fontMetricsInt.bottom)) - ((float) fontMetricsInt.top)) / 2.0f)), this.navigationLetterTextPaint);
        }
    }

    private void fillVirtualFocusLetters() {
        this.virtualFocusLetters.clear();
        int i = 0;
        while (i < this.navigationLetters.size()) {
            if (needHide(this.navigationLetters.get(i))) {
                String str = this.navigationLetters.get(i) + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA;
                int i2 = i + 1;
                int i3 = 1;
                while (i2 < this.navigationLetters.size() && needHide(this.navigationLetters.get(i2))) {
                    i3++;
                    i++;
                    str = str + this.navigationLetters.get(i2) + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA;
                    i2++;
                }
                this.virtualFocusLetters.add(">>," + i3 + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + str);
            } else {
                this.virtualFocusLetters.add(this.navigationLetters.get(i));
            }
            i++;
        }
    }

    private int getColor(int i) {
        return this.context.getResources().getColor(i);
    }

    private int getPxSize(int i) {
        return this.context.getResources().getDimensionPixelSize(i);
    }

    private void initializeDefault() {
        this.originalNavigationLetters = new ArrayList<>();
        this.navigationLetters = new ArrayList<>();
        this.virtualFocusLetters = new ArrayList<>();
        this.activeHideNavigationLetters = new HashMap();
        this.customActiveHideNavigationLetters = new HashMap();
        this.normalHideNavigationLetters = new HashMap();
        this.customNormalHideNavigationLetters = new HashMap();
        this.letterRect = new ArrayList<>();
        String language = getResources().getConfiguration().locale.getLanguage();
        Log.d("NavigationView", "Current Language is:" + language);
        String[] strArr = "th".equalsIgnoreCase(language) ? DEFAULT_LETTERS_TH : "ar".equalsIgnoreCase(language) ? DEFAULT_LETTERS_AR : DEFAULT_LETTERS;
        for (int i = 0; i < strArr.length; i++) {
            this.originalNavigationLetters.add(strArr[i]);
            this.navigationLetters.add(strArr[i]);
        }
        this.bottomPassHide = 1;
        this.topPassHide = 1;
        this.intervalHide = 0;
        this.isAuto = true;
        this.needDisposeData = true;
        this.navigationLetterNormalBackgroundColor = getColor(R.color.mc_fastscroll_navigation_letter_normal_background_color);
        this.navigationLetterActiveBackgroundColor = getColor(R.color.mc_fastscroll_navigation_letter_active_background_color);
        this.navigationLetterNormalTextColor = getColor(R.color.fd_sys_color_surface_container_highest_default);
        this.navigationLetterActiveTextColor = getColor(R.color.fd_sys_color_on_surface_default);
        this.navigationLetterSelectedTextColor = -1;
        this.navigationLetterSelectedBackgroundColor = getColor(R.color.fd_sys_color_surface_container_highest_default);
        this.navigationLetterTextSize = ScreenUtil.sp2px(this.context, getPxSize(R.dimen.mc_fastscroll_letter_text_size));
        this.navigationLetterVerticalSpace = getPxSize(R.dimen.mc_fastscroll_navigation_letter_vertical_space);
        this.navigationLetterSelectedBackgroundRadius = getPxSize(R.dimen.mc_fastscroll_navigation_letter_selected_background_radius);
        this.navigationLetterLeftPadding = getPxSize(R.dimen.mc_fastscroll_letter_layout_padding_left);
        this.navigationLetterRightPadding = getPxSize(CommonUtils.isCurvedScreen() ? R.dimen.mc_fastscroll_letter_layout_padding_right_curved : R.dimen.mc_fastscroll_letter_layout_padding_right);
        this.navigationLetterRightMargin = getPxSize(R.dimen.mc_fastscroll_letter_layout_margin_right);
        this.navigationLetterWidth = getPxSize(R.dimen.mc_fastscroll_letter_layout_wdith);
        this.navigationLetterTextPaint = new Paint(1);
        this.navigationLetterBackgroundPaint = new Paint(1);
        this.navigationLetterTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mCurrentColor = this.navigationLetterNormalTextColor;
    }

    private boolean needHide(String str) {
        Map<String, Bitmap> map = this.activeHideNavigationLetters;
        if (map == null) {
            return false;
        }
        for (String equals : map.keySet()) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void disposeIntervalHide() {
        if (this.isAuto) {
            this.activeHideNavigationLetters.clear();
            this.normalHideNavigationLetters.clear();
            int listViewHeightNow = this.callBack.getListViewHeightNow() - ScreenUtil.dip2px(this.context, 44.0d);
            int i = 0;
            this.intervalHide = 0;
            while (i < this.navigationLetters.size()) {
                if ((this.navigationLetterTextSize + this.navigationLetterVerticalSpace) * (this.navigationLetters.size() - i) > listViewHeightNow) {
                    i++;
                } else if (i > 0) {
                    this.intervalHide = ((int) ((((float) this.navigationLetters.size()) / ((float) i)) * 10.0f)) + 1;
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public void initializeFromAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.context.obtainStyledAttributes(attributeSet, R.styleable.FastScrollLetter, R.attr.MeizuCommon_FastScrollLetter, 0);
        this.navigationLetterNormalBackgroundColor = obtainStyledAttributes.getColor(R.styleable.FastScrollLetter_mcNavigationLetterNormalBackgroundColor, this.navigationLetterNormalBackgroundColor);
        this.navigationLetterActiveBackgroundColor = obtainStyledAttributes.getColor(R.styleable.FastScrollLetter_mcNavigationLetterActiveBackgroundColor, this.navigationLetterActiveBackgroundColor);
        this.navigationLetterNormalTextColor = obtainStyledAttributes.getColor(R.styleable.FastScrollLetter_mcNavigationLetterNormalTextColor, this.navigationLetterNormalTextColor);
        this.navigationLetterActiveTextColor = obtainStyledAttributes.getColor(R.styleable.FastScrollLetter_mcNavigationLetterActiveTextColor, this.navigationLetterActiveTextColor);
        this.navigationLetterSelectedTextColor = obtainStyledAttributes.getColor(R.styleable.FastScrollLetter_mcNavigationLetterSelectedTextColor, this.navigationLetterSelectedTextColor);
        this.navigationLetterSelectedBackgroundColor = obtainStyledAttributes.getColor(R.styleable.FastScrollLetter_mcNavigationLetterSelectedBackgroundColor, this.navigationLetterSelectedBackgroundColor);
        this.navigationLetterTextSize = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcNavigationLetterTextSize, (float) this.navigationLetterTextSize);
        this.navigationLetterVerticalSpace = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcNavigationLetterVerticalSpace, (float) this.navigationLetterVerticalSpace);
        this.navigationLetterSelectedBackgroundRadius = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcNavigationLetterSelectedBackgroundRadius, (float) this.navigationLetterSelectedBackgroundRadius);
        this.navigationLetterLeftPadding = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcNavigationLetterLeftPadding, (float) this.navigationLetterLeftPadding);
        this.navigationLetterRightPadding = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcNavigationLetterRightPadding, (float) this.navigationLetterRightPadding);
        this.navigationLetterRightMargin = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcNavigationLetterRightMargin, (float) this.navigationLetterRightMargin);
        this.navigationLetterWidth = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcNavigationLetterWidth, (float) this.navigationLetterWidth);
        obtainStyledAttributes.recycle();
        this.mCurrentColor = this.navigationLetterNormalTextColor;
        disposeLayoutParams();
        setBackgroundColor(this.navigationLetterNormalBackgroundColor);
        invalidate();
    }

    public void initialized() {
        this.initialized = true;
        setVisibility(0);
        requestLayout();
    }

    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.initialized) {
            int i2 = 0;
            if (this.needDisposeData) {
                this.needDisposeData = false;
                disposeIntervalHide();
                int i3 = this.topPassHide;
                while (i3 < this.navigationLetters.size()) {
                    int i4 = 1;
                    while (true) {
                        i = this.intervalHide;
                        if (i4 >= i + 1) {
                            break;
                        }
                        if ((this.navigationLetters.size() - i3) - i4 > this.bottomPassHide) {
                            int i5 = i3 + i4;
                            this.activeHideNavigationLetters.put(this.navigationLetters.get(i5), (Object) null);
                            this.normalHideNavigationLetters.put(this.navigationLetters.get(i5), (Object) null);
                        }
                        i4++;
                    }
                    i3 += i + 1;
                }
                int size = (this.navigationLetters.size() - this.bottomPassHide) - 1;
                if (this.intervalHide > 0 && size >= 0) {
                    this.activeHideNavigationLetters.put(this.navigationLetters.get(size), (Object) null);
                    this.normalHideNavigationLetters.put(this.navigationLetters.get(size), (Object) null);
                }
                for (String next : this.customActiveHideNavigationLetters.keySet()) {
                    this.activeHideNavigationLetters.remove(next);
                    this.activeHideNavigationLetters.put(next, this.customActiveHideNavigationLetters.get(next));
                    this.normalHideNavigationLetters.remove(next);
                    this.normalHideNavigationLetters.put(next, this.customNormalHideNavigationLetters.get(next));
                }
                disposeLayoutParams();
            } else if (this.navigationLetters != null) {
                this.navigationLetterTextPaint.setTextSize((float) this.navigationLetterTextSize);
                this.virtualFocusLetters.clear();
                int i6 = 0;
                while (i2 < this.navigationLetters.size()) {
                    if (needHide(this.navigationLetters.get(i2))) {
                        String str = this.navigationLetters.get(i2) + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA;
                        int i7 = i2 + 1;
                        int i8 = 1;
                        while (i7 < this.navigationLetters.size() && needHide(this.navigationLetters.get(i7))) {
                            i8++;
                            i2++;
                            str = str + this.navigationLetters.get(i7) + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA;
                            i7++;
                        }
                        this.virtualFocusLetters.add(">>," + i8 + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + str);
                    } else {
                        this.virtualFocusLetters.add(this.navigationLetters.get(i2));
                    }
                    if (this.letterRect.size() <= i6) {
                        this.letterRect.add(new RectF());
                    }
                    int i9 = this.navigationLetterTextSize;
                    int i10 = this.navigationLetterVerticalSpace;
                    int i11 = i6 + 1;
                    this.letterRect.get(i6).set(0.0f, (float) ((i9 + i10) * i6), (float) this.navigationLetterWidth, (float) ((i9 + i10) * i11));
                    if (i6 == this.currentLetterIndex) {
                        drawSelectedLetterBackground(canvas, this.letterRect.get(i6), this.navigationLetters.get(i2));
                    }
                    drawText(canvas, this.letterRect.get(i6), this.navigationLetters.get(i2), i6);
                    i2++;
                    i6 = i11;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r0 != 3) goto L_0x00b2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            r1 = 150(0x96, float:2.1E-43)
            r2 = 1
            if (r0 == 0) goto L_0x0077
            r3 = 0
            if (r0 == r2) goto L_0x0056
            r4 = 2
            if (r0 == r4) goto L_0x0014
            r6 = 3
            if (r0 == r6) goto L_0x0058
            goto L_0x00b2
        L_0x0014:
            r5.isOnTouching = r2
            float r6 = r6.getY()
            r0 = 0
            int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r3 >= 0) goto L_0x0020
            r6 = r0
        L_0x0020:
            int r0 = r5.getHeight()
            float r0 = (float) r0
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x002e
            int r6 = r5.getHeight()
            float r6 = (float) r6
        L_0x002e:
            java.lang.String r0 = r5.analyseLocationLetter(r6)
            com.meizu.common.fastscrollletter.NavigationView$NavigationViewCallBack r3 = r5.callBack
            int r4 = r5.analyzeLocationIndexByFullLetters(r0)
            r3.location(r0, r4)
            com.meizu.common.fastscrollletter.NavigationView$NavigationViewCallBack r0 = r5.callBack
            r0.touchY(r6)
            boolean r6 = r5.isActive
            if (r6 != 0) goto L_0x004d
            r5.isActive = r2
            int r6 = r5.navigationLetterNormalTextColor
            int r0 = r5.navigationLetterActiveTextColor
            r5.startAnimation(r6, r0, r1)
        L_0x004d:
            r5.invalidate()
            int r6 = r5.navigationLetterActiveBackgroundColor
            r5.setBackgroundColor(r6)
            goto L_0x00b2
        L_0x0056:
            r5.isOnTouching = r3
        L_0x0058:
            r5.isOnTouching = r3
            com.meizu.common.fastscrollletter.NavigationView$NavigationViewCallBack r6 = r5.callBack
            r6.hideOverlay()
            boolean r6 = r5.isActive
            if (r6 == 0) goto L_0x0071
            r5.isActive = r3
            int r6 = r5.navigationLetterActiveTextColor
            int r0 = r5.navigationLetterNormalTextColor
            r1 = 250(0xfa, float:3.5E-43)
            r5.startAnimation(r6, r0, r1)
            r5.invalidate()
        L_0x0071:
            int r6 = r5.navigationLetterNormalBackgroundColor
            r5.setBackgroundColor(r6)
            goto L_0x00b2
        L_0x0077:
            r5.isOnTouching = r2
            com.meizu.common.fastscrollletter.NavigationView$NavigationViewCallBack r0 = r5.callBack
            r0.showOverlay()
            com.meizu.common.fastscrollletter.NavigationView$NavigationViewCallBack r0 = r5.callBack
            r0.stopListViewScroll()
            float r0 = r6.getY()
            java.lang.String r0 = r5.analyseLocationLetter(r0)
            com.meizu.common.fastscrollletter.NavigationView$NavigationViewCallBack r3 = r5.callBack
            int r4 = r5.analyzeLocationIndexByFullLetters(r0)
            r3.location(r0, r4)
            com.meizu.common.fastscrollletter.NavigationView$NavigationViewCallBack r0 = r5.callBack
            float r6 = r6.getY()
            r0.touchY(r6)
            boolean r6 = r5.isActive
            if (r6 != 0) goto L_0x00ad
            r5.isActive = r2
            int r6 = r5.navigationLetterNormalTextColor
            int r0 = r5.navigationLetterActiveTextColor
            r5.startAnimation(r6, r0, r1)
            r5.invalidate()
        L_0x00ad:
            int r6 = r5.navigationLetterActiveBackgroundColor
            r5.setBackgroundColor(r6)
        L_0x00b2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.fastscrollletter.NavigationView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAutoHideLetter(boolean z) {
        this.isAuto = z;
        this.intervalHide = 0;
        setNavigationLetters(this.originalNavigationLetters);
    }

    public void setCallBack(NavigationViewCallBack navigationViewCallBack) {
        this.callBack = navigationViewCallBack;
    }

    public void setCurrentLetter(String str) {
        fillVirtualFocusLetters();
        int analyzeLocationIndexByVirtualLetters = analyzeLocationIndexByVirtualLetters(str);
        if (analyzeLocationIndexByVirtualLetters != this.currentLetterIndex) {
            this.currentLetterIndex = analyzeLocationIndexByVirtualLetters;
            invalidate();
        }
    }

    public void setCurrentLetterFormScrolling(int i, String str) {
        int analyzeLocationIndexByVirtualLetters = analyzeLocationIndexByVirtualLetters(str);
        if (analyzeLocationIndexByVirtualLetters != this.currentLetterIndex && !this.isOnTouching) {
            this.currentLetterIndex = analyzeLocationIndexByVirtualLetters;
            invalidate();
        }
    }

    public void setHideBottomPassCount(int i) {
        this.bottomPassHide = i;
    }

    public void setHideNavigationLetter(String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            this.activeHideNavigationLetters.put(strArr[i], (Object) null);
            this.normalHideNavigationLetters.put(strArr[i], (Object) null);
        }
    }

    public void setHideTopPassCount(int i) {
        this.topPassHide = i;
    }

    public void setIntervalHide(int i) {
        this.intervalHide = i;
        this.isAuto = false;
    }

    public void setNavigationLetterActiveBackgroundColor(int i) {
        this.navigationLetterActiveBackgroundColor = i;
    }

    public void setNavigationLetterActiveTextColor(int i) {
        this.navigationLetterActiveTextColor = i;
        this.needDisposeData = true;
        invalidate();
    }

    public void setNavigationLetterNormalBackgroundColor(int i) {
        this.navigationLetterNormalBackgroundColor = i;
        setBackgroundColor(i);
    }

    public void setNavigationLetterNormalTextColor(int i) {
        this.navigationLetterNormalTextColor = i;
        this.mCurrentColor = i;
        this.needDisposeData = true;
        invalidate();
    }

    public void setNavigationLetterRightMargin(int i) {
        if (this.navigationLetterRightMargin != i) {
            this.navigationLetterRightMargin = i;
            this.needDisposeData = true;
            disposeLayoutParams();
        }
    }

    public void setNavigationLetterRightPadding(int i) {
        if (this.navigationLetterRightPadding != i) {
            this.navigationLetterRightPadding = i;
            this.needDisposeData = true;
            disposeLayoutParams();
        }
    }

    public void setNavigationLetterSelectedBackgroundColor(int i) {
        this.navigationLetterSelectedBackgroundColor = i;
        this.needDisposeData = true;
        disposeLayoutParams();
        invalidate();
    }

    public void setNavigationLetterSelectedBackgroundRadius(int i) {
        this.navigationLetterSelectedBackgroundRadius = i;
        this.needDisposeData = true;
        disposeLayoutParams();
        invalidate();
    }

    public void setNavigationLetterSelectedTextColor(int i) {
        this.navigationLetterSelectedTextColor = i;
        this.needDisposeData = true;
        disposeLayoutParams();
        invalidate();
    }

    public void setNavigationLetterTextSize(int i) {
        this.navigationLetterTextSize = i;
        this.needDisposeData = true;
        disposeLayoutParams();
        invalidate();
    }

    public void setNavigationLetterVerticalSpace(int i) {
        this.navigationLetterVerticalSpace = i;
        this.needDisposeData = true;
        disposeLayoutParams();
        invalidate();
    }

    public void setNavigationLetterWidth(int i) {
        if (this.navigationLetterWidth != i) {
            this.navigationLetterWidth = i;
            this.needDisposeData = true;
            disposeLayoutParams();
        }
    }

    public void setNavigationLetters(ArrayList<String> arrayList) {
        if (arrayList != null) {
            this.originalNavigationLetters = arrayList;
            this.navigationLetters = (ArrayList) arrayList.clone();
            this.needDisposeData = true;
            invalidate();
        }
    }

    public void startAnimation(int i, int i2, int i3) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = NavigationView.this.mCurrentColor = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                NavigationView.this.invalidate();
            }
        });
        ofObject.setInterpolator(this.mInterpolator);
        ofObject.setDuration((long) i3);
        ofObject.start();
    }

    public void setHideNavigationLetter(String str, Bitmap bitmap, Bitmap bitmap2) {
        this.customActiveHideNavigationLetters.put(str, bitmap);
        this.customNormalHideNavigationLetters.put(str, bitmap2);
    }
}

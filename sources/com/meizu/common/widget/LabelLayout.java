package com.meizu.common.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.meizu.common.R;
import java.util.ArrayList;
import java.util.List;

@TargetApi(14)
public class LabelLayout extends ViewGroup {
    public static final int DEFAULT_MAX_LINES = 100;
    private List<List<View>> mAllRows;
    private final Context mContext;
    private int mGravity;
    private LayoutParams mHotWordsLayoutParams;
    private int mHotWordsPaddingHorizontal;
    private int mHotWordsPaddingVertical;
    private float mHotWordsTextSize;
    private int mIconMarginBottom;
    private int mIconMarginLeft;
    private int mIconMaxHeight;
    private int mIconMaxWidth;
    private int mItemMargin;
    private LayoutParams mLabelLayoutParams;
    private int mLabelPaddingHorizontal;
    private int mLabelPaddingVertical;
    private int mLabelRadiusCorner;
    private float mLabelTextSize;
    private final List<Integer> mLineHeights;
    private int mLineMargin;
    private final List<Integer> mLineMargins;
    private final List<List<View>> mLines;
    private int mMaxLine;
    private final Typeface mMediumTypeface;
    private LayoutParams mMiniLabelLayoutParams;
    private int mMiniLabelPaddingHorizontal;
    private int mMiniLabelPaddingVertical;
    private int mMiniLabelRadiusCorner;
    private float mMiniLabelTextSize;

    public static class DrawableImagePlayer implements ImagePlayer {
        private Drawable mDrawable;

        public DrawableImagePlayer(Drawable drawable) {
            this.mDrawable = drawable;
        }

        public void displayImage(Context context, ImageView imageView) {
            imageView.setImageDrawable(this.mDrawable);
        }
    }

    public interface ImagePlayer {
        void displayImage(Context context, ImageView imageView);
    }

    public enum LabelColor {
        NONE,
        RED,
        ORANGE,
        YELLOW,
        CYAN,
        GREEN,
        BLUE,
        PURPLE,
        POLESTAR;
        
        /* access modifiers changed from: private */
        @ColorInt
        public int mBgNormalColor;
        /* access modifiers changed from: private */
        @ColorInt
        public int mBgPressColor;
        /* access modifiers changed from: private */
        @ColorInt
        public int mTextColor;

        public int getBgNormalColor() {
            return this.mBgNormalColor;
        }

        public int getBgPressColor() {
            return this.mBgPressColor;
        }

        public int getTextColor() {
            return this.mTextColor;
        }
    }

    public enum MiniLabelColor {
        NONE,
        RED,
        ORANGE,
        YELLOW,
        CYAN,
        GREEN,
        BLUE,
        PURPLE,
        POLESTAR;
        
        /* access modifiers changed from: private */
        @ColorInt
        public int mBgNormalColor;
        /* access modifiers changed from: private */
        @ColorInt
        public int mBgPressColor;
        /* access modifiers changed from: private */
        @ColorInt
        public int mTextColor;

        public int getBgNormalColor() {
            return this.mBgNormalColor;
        }

        public int getBgPressColor() {
            return this.mBgPressColor;
        }

        public int getTextColor() {
            return this.mTextColor;
        }
    }

    public LabelLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private LayoutParams createLayoutParams(int i, int i2) {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, i);
        layoutParams.setMarginEnd(i2);
        layoutParams.gravity = 80;
        return layoutParams;
    }

    private int getResId(String str) {
        int identifier = getResources().getIdentifier(str, "color", getContext().getPackageName());
        return identifier == 0 ? str.contains("container") ? R.color.fd_sys_color_primary_container_blue : R.color.fd_sys_color_primary_blue : identifier;
    }

    private static boolean isIcs() {
        return true;
    }

    private void labelInit() {
        LabelColor labelColor = LabelColor.NONE;
        int unused = labelColor.mTextColor = this.mContext.getResources().getColor(R.color.fd_sys_color_on_surface_default);
        int unused2 = labelColor.mBgNormalColor = this.mContext.getResources().getColor(R.color.fd_sys_color_surface_container_lowest_default);
        int unused3 = labelColor.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        LabelColor labelColor2 = LabelColor.BLUE;
        int unused4 = labelColor2.mTextColor = this.mContext.getResources().getColor(R.color.fd_sys_color_primary_blue);
        int unused5 = labelColor2.mBgNormalColor = this.mContext.getResources().getColor(R.color.fd_sys_color_primary_container_blue);
        int unused6 = labelColor2.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        LabelColor labelColor3 = LabelColor.RED;
        int unused7 = labelColor3.mTextColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_red"));
        int unused8 = labelColor3.mBgNormalColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_container_red"));
        int unused9 = labelColor3.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        LabelColor labelColor4 = LabelColor.ORANGE;
        int unused10 = labelColor4.mTextColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_orange"));
        int unused11 = labelColor4.mBgNormalColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_container_orange"));
        int unused12 = labelColor4.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        LabelColor labelColor5 = LabelColor.YELLOW;
        int unused13 = labelColor5.mTextColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_yellow"));
        int unused14 = labelColor5.mBgNormalColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_container_yellow"));
        int unused15 = labelColor5.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        LabelColor labelColor6 = LabelColor.GREEN;
        int unused16 = labelColor6.mTextColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_green"));
        int unused17 = labelColor6.mBgNormalColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_container_green"));
        int unused18 = labelColor6.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        LabelColor labelColor7 = LabelColor.CYAN;
        int unused19 = labelColor7.mTextColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_cyan"));
        int unused20 = labelColor7.mBgNormalColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_container_cyan"));
        int unused21 = labelColor7.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        LabelColor labelColor8 = LabelColor.PURPLE;
        int unused22 = labelColor8.mTextColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_purple"));
        int unused23 = labelColor8.mBgNormalColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_container_purple"));
        int unused24 = labelColor8.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        LabelColor labelColor9 = LabelColor.POLESTAR;
        int unused25 = labelColor9.mTextColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_polestar"));
        int unused26 = labelColor9.mBgNormalColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_container_polestar"));
        int unused27 = labelColor9.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        MiniLabelColor miniLabelColor = MiniLabelColor.NONE;
        int unused28 = miniLabelColor.mTextColor = this.mContext.getResources().getColor(R.color.fd_sys_color_primary_default);
        int unused29 = miniLabelColor.mBgNormalColor = this.mContext.getResources().getColor(R.color.fd_sys_color_primary_container_default);
        int unused30 = miniLabelColor.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        MiniLabelColor miniLabelColor2 = MiniLabelColor.BLUE;
        int unused31 = miniLabelColor2.mTextColor = this.mContext.getResources().getColor(R.color.fd_sys_color_primary_blue);
        int unused32 = miniLabelColor2.mBgNormalColor = this.mContext.getResources().getColor(R.color.fd_sys_color_primary_container_blue);
        int unused33 = miniLabelColor2.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        MiniLabelColor miniLabelColor3 = MiniLabelColor.RED;
        int unused34 = miniLabelColor3.mTextColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_red"));
        int unused35 = miniLabelColor3.mBgNormalColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_container_red"));
        int unused36 = miniLabelColor3.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        MiniLabelColor miniLabelColor4 = MiniLabelColor.ORANGE;
        int unused37 = miniLabelColor4.mTextColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_orange"));
        int unused38 = miniLabelColor4.mBgNormalColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_container_orange"));
        int unused39 = miniLabelColor4.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        MiniLabelColor miniLabelColor5 = MiniLabelColor.YELLOW;
        int unused40 = miniLabelColor5.mTextColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_yellow"));
        int unused41 = miniLabelColor5.mBgNormalColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_container_yellow"));
        int unused42 = miniLabelColor5.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        MiniLabelColor miniLabelColor6 = MiniLabelColor.GREEN;
        int unused43 = miniLabelColor6.mTextColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_green"));
        int unused44 = miniLabelColor6.mBgNormalColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_container_green"));
        int unused45 = miniLabelColor6.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        MiniLabelColor miniLabelColor7 = MiniLabelColor.CYAN;
        int unused46 = miniLabelColor7.mTextColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_cyan"));
        int unused47 = miniLabelColor7.mBgNormalColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_container_cyan"));
        int unused48 = miniLabelColor7.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        MiniLabelColor miniLabelColor8 = MiniLabelColor.PURPLE;
        int unused49 = miniLabelColor8.mTextColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_purple"));
        int unused50 = miniLabelColor8.mBgNormalColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_container_purple"));
        int unused51 = miniLabelColor8.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
        MiniLabelColor miniLabelColor9 = MiniLabelColor.POLESTAR;
        int unused52 = miniLabelColor9.mTextColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_polestar"));
        int unused53 = miniLabelColor9.mBgNormalColor = this.mContext.getResources().getColor(getResId("fd_sys_color_primary_container_polestar"));
        int unused54 = miniLabelColor9.mBgPressColor = this.mContext.getResources().getColor(R.color.fd_sys_color_state_pressed_default);
    }

    public TextView addHotWords(String str) {
        return addHotWords(str, LabelColor.NONE, (Drawable) null);
    }

    public TextView addLabel(String str) {
        return addLabel(str, LabelColor.NONE);
    }

    public TextView addMiniLabel(String str) {
        return addMiniLabel(str, MiniLabelColor.NONE);
    }

    public int getGravity() {
        return this.mGravity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            r22 = this;
            r0 = r22
            java.util.List<java.util.List<android.view.View>> r1 = r0.mLines
            r1.clear()
            java.util.List<java.lang.Integer> r1 = r0.mLineHeights
            r1.clear()
            java.util.List<java.lang.Integer> r1 = r0.mLineMargins
            r1.clear()
            int r1 = r22.getWidth()
            int r2 = r22.getPaddingLeft()
            int r1 = r1 - r2
            int r2 = r22.getPaddingRight()
            int r1 = r1 - r2
            int r2 = r22.getHeight()
            int r3 = r22.getPaddingTop()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            int r5 = r0.mGravity
            r5 = r5 & 7
            r6 = 1
            if (r5 == r6) goto L_0x003b
            r7 = 5
            if (r5 == r7) goto L_0x0038
            r5 = 0
            goto L_0x003d
        L_0x0038:
            r5 = 1065353216(0x3f800000, float:1.0)
            goto L_0x003d
        L_0x003b:
            r5 = 1056964608(0x3f000000, float:0.5)
        L_0x003d:
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x0040:
            int r11 = r22.getChildCount()
            r12 = 8
            if (r8 >= r11) goto L_0x00a5
            android.view.View r11 = r0.getChildAt(r8)
            int r13 = r11.getVisibility()
            if (r13 != r12) goto L_0x0053
            goto L_0x00a2
        L_0x0053:
            android.view.ViewGroup$LayoutParams r12 = r11.getLayoutParams()
            com.meizu.common.widget.LabelLayout$LayoutParams r12 = (com.meizu.common.widget.LabelLayout.LayoutParams) r12
            int r13 = r11.getMeasuredWidth()
            int r14 = r12.leftMargin
            int r13 = r13 + r14
            int r14 = r12.rightMargin
            int r13 = r13 + r14
            int r14 = r11.getMeasuredHeight()
            int r15 = r12.bottomMargin
            int r14 = r14 + r15
            int r12 = r12.topMargin
            int r14 = r14 + r12
            int r12 = r10 + r13
            if (r12 <= r1) goto L_0x009a
            java.util.List<java.lang.Integer> r12 = r0.mLineHeights
            java.lang.Integer r15 = java.lang.Integer.valueOf(r9)
            r12.add(r15)
            java.util.List<java.util.List<android.view.View>> r12 = r0.mLines
            r12.add(r4)
            java.util.List<java.lang.Integer> r4 = r0.mLineMargins
            int r10 = r1 - r10
            float r10 = (float) r10
            float r10 = r10 * r5
            int r10 = (int) r10
            int r12 = r22.getPaddingLeft()
            int r10 = r10 + r12
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r4.add(r10)
            int r3 = r3 + r9
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r9 = 0
            r10 = 0
        L_0x009a:
            int r10 = r10 + r13
            int r9 = java.lang.Math.max(r9, r14)
            r4.add(r11)
        L_0x00a2:
            int r8 = r8 + 1
            goto L_0x0040
        L_0x00a5:
            java.util.List<java.lang.Integer> r8 = r0.mLineHeights
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)
            r8.add(r11)
            java.util.List<java.util.List<android.view.View>> r8 = r0.mLines
            r8.add(r4)
            java.util.List<java.lang.Integer> r4 = r0.mLineMargins
            int r1 = r1 - r10
            float r1 = (float) r1
            float r1 = r1 * r5
            int r1 = (int) r1
            int r5 = r22.getPaddingLeft()
            int r1 = r1 + r5
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4.add(r1)
            int r3 = r3 + r9
            int r1 = r0.mGravity
            r1 = r1 & 112(0x70, float:1.57E-43)
            r4 = 80
            r5 = 16
            if (r1 == r5) goto L_0x00d6
            if (r1 == r4) goto L_0x00d4
            r2 = 0
            goto L_0x00d9
        L_0x00d4:
            int r2 = r2 - r3
            goto L_0x00d9
        L_0x00d6:
            int r2 = r2 - r3
            int r2 = r2 / 2
        L_0x00d9:
            java.util.List<java.util.List<android.view.View>> r1 = r0.mLines
            int r1 = r1.size()
            int r3 = r22.getPaddingTop()
            int r8 = androidx.core.view.ViewCompat.z(r22)
            if (r8 != r6) goto L_0x00ea
            goto L_0x00eb
        L_0x00ea:
            r6 = 0
        L_0x00eb:
            r8 = 0
        L_0x00ec:
            if (r8 >= r1) goto L_0x0229
            java.util.List<java.lang.Integer> r9 = r0.mLineHeights
            java.lang.Object r9 = r9.get(r8)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            java.util.List<java.util.List<android.view.View>> r11 = r0.mLines
            java.lang.Object r11 = r11.get(r8)
            java.util.List r11 = (java.util.List) r11
            java.util.List<java.lang.Integer> r13 = r0.mLineMargins
            java.lang.Object r13 = r13.get(r8)
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            if (r6 == 0) goto L_0x0115
            int r14 = r22.getWidth()
            goto L_0x0116
        L_0x0115:
            r14 = 0
        L_0x0116:
            int r15 = r11.size()
            r7 = 0
        L_0x011b:
            if (r7 >= r15) goto L_0x020b
            java.lang.Object r16 = r11.get(r7)
            r4 = r16
            android.view.View r4 = (android.view.View) r4
            int r5 = r0.mMaxLine
            if (r8 < r5) goto L_0x012d
            r0.removeView(r4)
            goto L_0x0133
        L_0x012d:
            int r5 = r4.getVisibility()
            if (r5 != r12) goto L_0x0141
        L_0x0133:
            r27 = r1
            r18 = r6
            r21 = r9
            r16 = r10
            r17 = r11
            r19 = r15
            goto L_0x01f5
        L_0x0141:
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            com.meizu.common.widget.LabelLayout$LayoutParams r5 = (com.meizu.common.widget.LabelLayout.LayoutParams) r5
            int r12 = r5.height
            r27 = r1
            r1 = -1
            if (r12 != r1) goto L_0x0176
            int r12 = r5.width
            r16 = r10
            r10 = 1073741824(0x40000000, float:2.0)
            if (r12 != r1) goto L_0x015a
            r1 = r10
        L_0x0157:
            r12 = r16
            goto L_0x0161
        L_0x015a:
            if (r12 < 0) goto L_0x015e
            r1 = r10
            goto L_0x0161
        L_0x015e:
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0157
        L_0x0161:
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r1)
            int r12 = r5.topMargin
            int r12 = r9 - r12
            r17 = r11
            int r11 = r5.bottomMargin
            int r12 = r12 - r11
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r10)
            r4.measure(r1, r10)
            goto L_0x017a
        L_0x0176:
            r16 = r10
            r17 = r11
        L_0x017a:
            int r1 = r4.getMeasuredWidth()
            int r10 = r4.getMeasuredHeight()
            int r11 = r5.gravity
            boolean r11 = android.view.Gravity.isVertical(r11)
            if (r11 == 0) goto L_0x01ad
            int r11 = r5.gravity
            r12 = 16
            if (r11 == r12) goto L_0x01a2
            r12 = 17
            if (r11 == r12) goto L_0x01a2
            r12 = 80
            if (r11 == r12) goto L_0x0199
            goto L_0x01ad
        L_0x0199:
            int r11 = r9 - r10
            int r12 = r5.topMargin
            int r11 = r11 - r12
            int r12 = r5.bottomMargin
            int r11 = r11 - r12
            goto L_0x01ae
        L_0x01a2:
            int r11 = r9 - r10
            int r12 = r5.topMargin
            int r11 = r11 - r12
            int r12 = r5.bottomMargin
            int r11 = r11 - r12
            int r11 = r11 / 2
            goto L_0x01ae
        L_0x01ad:
            r11 = 0
        L_0x01ae:
            if (r6 != 0) goto L_0x01d5
            int r12 = r5.leftMargin
            r18 = r6
            int r6 = r13 + r12
            r19 = r15
            int r15 = r5.topMargin
            int r20 = r3 + r15
            int r20 = r20 + r11
            r21 = r9
            int r9 = r20 + r2
            int r20 = r13 + r1
            int r12 = r20 + r12
            int r10 = r10 + r3
            int r10 = r10 + r15
            int r10 = r10 + r11
            int r10 = r10 + r2
            r4.layout(r6, r9, r12, r10)
            int r4 = r5.leftMargin
            int r1 = r1 + r4
            int r4 = r5.rightMargin
            int r1 = r1 + r4
            int r13 = r13 + r1
            goto L_0x01f5
        L_0x01d5:
            r18 = r6
            r21 = r9
            r19 = r15
            int r6 = r14 - r1
            int r9 = r5.topMargin
            int r12 = r3 + r9
            int r12 = r12 + r11
            int r12 = r12 + r2
            int r10 = r10 + r3
            int r10 = r10 + r9
            int r10 = r10 + r11
            int r10 = r10 + r2
            r4.layout(r6, r12, r14, r10)
            int r4 = r5.getMarginEnd()
            int r1 = r1 + r4
            int r4 = r5.getMarginStart()
            int r1 = r1 + r4
            int r14 = r14 - r1
        L_0x01f5:
            int r7 = r7 + 1
            r1 = r27
            r10 = r16
            r11 = r17
            r6 = r18
            r15 = r19
            r9 = r21
            r4 = 80
            r5 = 16
            r12 = 8
            goto L_0x011b
        L_0x020b:
            r27 = r1
            r18 = r6
            r21 = r9
            r16 = r10
            int r1 = r0.mMaxLine
            if (r8 >= r1) goto L_0x0219
            int r3 = r3 + r21
        L_0x0219:
            int r8 = r8 + 1
            r1 = r27
            r10 = r16
            r6 = r18
            r4 = 80
            r5 = 16
            r12 = 8
            goto L_0x00ec
        L_0x0229:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.LabelLayout.onLayout(boolean, int, int, int, int):void");
    }

    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.mAllRows.clear();
        ArrayList arrayList = new ArrayList();
        this.mAllRows.add(arrayList);
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = 1073741824;
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i7 = layoutParams.width;
                if (i7 >= 0) {
                    i3 = 1073741824;
                } else {
                    i7 = (((size - getPaddingLeft()) - getPaddingRight()) - layoutParams.leftMargin) - layoutParams.rightMargin;
                    i3 = Integer.MIN_VALUE;
                }
                int i8 = layoutParams.height;
                if (i8 < 0) {
                    i6 = 0;
                    i8 = 0;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i7, i3), View.MeasureSpec.makeMeasureSpec(i8, i6));
                int measuredWidth = childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                if (arrayList.size() == 0) {
                    arrayList.add(childAt);
                } else {
                    i5 += measuredWidth;
                    if (i5 >= (size - getPaddingLeft()) - getPaddingRight()) {
                        arrayList = new ArrayList();
                        arrayList.add(childAt);
                        this.mAllRows.add(arrayList);
                    } else {
                        arrayList.add(childAt);
                    }
                }
                i5 = measuredWidth;
            }
            i4++;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i9 = 0;
        int i10 = 0;
        for (List<View> next : this.mAllRows) {
            i9++;
            if (i9 > this.mMaxLine) {
                break;
            }
            int i11 = 0;
            int i12 = 0;
            for (View view : next) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                i11 += view.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin;
                i12 = Math.max(i12, view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
            }
            i10 = Math.max(i10, i11);
            paddingTop += i12;
        }
        int paddingLeft = i10 + getPaddingLeft() + getPaddingRight();
        if (mode != 1073741824) {
            size = paddingLeft;
        }
        if (mode2 != 1073741824) {
            size2 = paddingTop;
        }
        setMeasuredDimension(size, size2);
    }

    @TargetApi(14)
    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= isIcs() ? 8388611 : 3;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHotWordsPaddingHorizontal(int i) {
        this.mHotWordsPaddingHorizontal = i;
    }

    public void setHotWordsPaddingVertical(int i) {
        this.mHotWordsPaddingVertical = i;
    }

    public void setLabelPaddingHorizontal(int i) {
        this.mLabelPaddingHorizontal = i;
    }

    public void setLabelPaddingVertical(int i) {
        this.mLabelPaddingVertical = i;
    }

    public void setMaxLine(int i) {
        this.mMaxLine = i;
    }

    public void setMiniLabelPaddingHorizontal(int i) {
        this.mMiniLabelPaddingHorizontal = i;
    }

    public void setMiniLabelPaddingVertical(int i) {
        this.mMiniLabelPaddingVertical = i;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity = -1;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public LabelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextView addHotWords(String str, LabelColor labelColor) {
        return addHotWords(str, labelColor, (ImagePlayer) null);
    }

    public TextView addLabel(String str, LabelColor labelColor) {
        Typeface typeface = Typeface.DEFAULT;
        if (labelColor != LabelColor.NONE) {
            typeface = this.mMediumTypeface;
        }
        Context context = this.mContext;
        Context context2 = context;
        String str2 = str;
        LabelItem labelItem = new LabelItem(context2, str2, this.mLabelTextSize, typeface, this.mLabelPaddingHorizontal, this.mLabelPaddingVertical, labelColor.mTextColor, labelColor.mBgNormalColor, labelColor.mBgPressColor, this.mLabelRadiusCorner, (ImagePlayer) null, 0, 0, 0, 0);
        addView(labelItem, this.mLabelLayoutParams);
        return labelItem.getTextView();
    }

    public TextView addMiniLabel(String str, MiniLabelColor miniLabelColor) {
        LabelItem labelItem = r1;
        LabelItem labelItem2 = new LabelItem(this.mContext, str, this.mMiniLabelTextSize, this.mMediumTypeface, this.mMiniLabelPaddingHorizontal, this.mMiniLabelPaddingVertical, miniLabelColor.mTextColor, miniLabelColor.mBgNormalColor, miniLabelColor.mBgPressColor, this.mMiniLabelRadiusCorner, (ImagePlayer) null, 0, 0, 0, 0, true);
        LabelItem labelItem3 = labelItem;
        addView(labelItem3, this.mMiniLabelLayoutParams);
        return labelItem3.getTextView();
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public LabelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGravity = (isIcs() ? 8388611 : 3) | 48;
        this.mLines = new ArrayList();
        this.mLineHeights = new ArrayList();
        this.mLineMargins = new ArrayList();
        this.mMaxLine = 100;
        this.mAllRows = new ArrayList();
        this.mContext = context;
        labelInit();
        this.mMediumTypeface = Typeface.create("sans-serif-medium", 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LabelLayout, i, 0);
        this.mLineMargin = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelLayout_lineMargin, getResources().getDimensionPixelOffset(R.dimen.label_layout_line_margin_default));
        this.mItemMargin = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelLayout_itemMargin, getResources().getDimensionPixelOffset(R.dimen.label_layout_item_margin_default));
        this.mLabelRadiusCorner = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelLayout_labelRadiusCorner, getResources().getDimensionPixelOffset(R.dimen.label_layout_label_radius_corner_default));
        obtainStyledAttributes.recycle();
        this.mMiniLabelRadiusCorner = getResources().getDimensionPixelOffset(R.dimen.label_layout_mini_label_radius_corner_default);
        this.mMiniLabelPaddingVertical = getResources().getDimensionPixelOffset(R.dimen.label_layout_mini_label_padding_vertical);
        this.mLabelPaddingVertical = getResources().getDimensionPixelOffset(R.dimen.label_layout_label_padding_vertical);
        this.mHotWordsPaddingVertical = getResources().getDimensionPixelOffset(R.dimen.label_layout_hot_words_padding_vertical);
        this.mMiniLabelPaddingHorizontal = getResources().getDimensionPixelSize(R.dimen.label_layout_mini_label_padding_horizontal);
        this.mLabelPaddingHorizontal = getResources().getDimensionPixelSize(R.dimen.label_layout_label_padding_horizontal);
        this.mHotWordsPaddingHorizontal = getResources().getDimensionPixelSize(R.dimen.label_layout_hot_words_padding_horizontal);
        this.mMiniLabelTextSize = (float) getResources().getDimensionPixelSize(R.dimen.label_layout_mini_label_text_size_default);
        this.mLabelTextSize = (float) getResources().getDimensionPixelSize(R.dimen.label_layout_label_text_size_default);
        this.mHotWordsTextSize = (float) getResources().getDimensionPixelSize(R.dimen.label_layout_hot_words_text_size_default);
        this.mIconMarginLeft = getResources().getDimensionPixelSize(R.dimen.label_layout_icon_margin_left_right);
        this.mIconMarginBottom = getResources().getDimensionPixelSize(R.dimen.label_layout_icon_margin_bottom);
        this.mIconMaxWidth = getResources().getDimensionPixelSize(R.dimen.label_layout_icon_max_width);
        this.mIconMaxHeight = getResources().getDimensionPixelSize(R.dimen.label_layout_icon_max_height);
        this.mMiniLabelLayoutParams = createLayoutParams(getResources().getDimensionPixelOffset(R.dimen.label_layout_mini_line_margin_default), getResources().getDimensionPixelOffset(R.dimen.label_layout_mini_item_margin_default));
        this.mLabelLayoutParams = createLayoutParams(this.mLineMargin, this.mItemMargin);
        this.mHotWordsLayoutParams = createLayoutParams(this.mLineMargin, this.mItemMargin);
    }

    public TextView addHotWords(String str, LabelColor labelColor, @DrawableRes int i) {
        return addHotWords(str, labelColor, this.mContext.getResources().getDrawable(i));
    }

    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public TextView addHotWords(String str, LabelColor labelColor, Drawable drawable) {
        return addHotWords(str, labelColor, (ImagePlayer) new DrawableImagePlayer(drawable));
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public TextView addHotWords(String str, LabelColor labelColor, ImagePlayer imagePlayer) {
        Typeface typeface = Typeface.DEFAULT;
        Typeface typeface2 = this.mMediumTypeface;
        Context context = this.mContext;
        float f = this.mHotWordsTextSize;
        int i = this.mHotWordsPaddingHorizontal;
        int i2 = this.mHotWordsPaddingVertical;
        int access$300 = labelColor.mTextColor;
        int access$400 = labelColor.mBgNormalColor;
        int access$500 = labelColor.mBgPressColor;
        int i3 = this.mLabelRadiusCorner;
        int i4 = this.mIconMaxWidth;
        int i5 = this.mIconMaxHeight;
        int i6 = this.mIconMarginLeft;
        int i7 = i6;
        LabelItem labelItem = new LabelItem(context, str, f, typeface2, i, i2, access$300, access$400, access$500, i3, imagePlayer, i4, i5, i7, this.mIconMarginBottom);
        addView(labelItem, this.mHotWordsLayoutParams);
        return labelItem.getTextView();
    }
}

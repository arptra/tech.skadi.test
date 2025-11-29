package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import com.meizu.common.R;

public class RoundCornerRecordView extends ImageView {
    static final int ID_COLUMN_INDEX = 0;
    static final int LOOKUPKEY_COLUMN_INDEX = 1;
    static final int PHONE_COLUMN_INDEX = 2;
    public static final String TAG = "RoundCornerRecordView";
    private static final BorderType[] sBorderTypeArray = {BorderType.BORDER_NULL, BorderType.BORDER_LIST_CONTACT, BorderType.BORDER_EDIT_CONTACT, BorderType.BORDER_VIEW_CONTACT, BorderType.BORDER_SMS_CONTACT, BorderType.BORDER_SMALL_CONTACT};
    private static final IconType[] sIconTypeArray = {IconType.IC_NULL, IconType.IC_CALL_LOG_CALLOUT, IconType.IC_CALL_LOG_CALLIN, IconType.IC_CALL_LOG_MISSED, IconType.IC_CALL_LOG_REFUSED, IconType.IC_CALL_LOG_RINGONCE, IconType.IC_CALL_LOG_RECORD, IconType.IC_CALL_LOG_RECORD_FAIL, IconType.IC_CALL_LOG_VOICEMAIL, IconType.IC_SMS_HAS_UNREAD, IconType.IC_SMS_HAS_NOTDELIVERED};
    private static boolean sStartActivity = false;
    private static final Object sSyncKeyLock = new Object();
    private String mBadgeText;
    private Drawable mBadgeTextDrawable;
    private Paint mBadgeTextPaint;
    private int mBadgeTextShadowColor;
    private int mBadgeTextShadowRadius;
    private int mBadgeTextSize;
    private int mBgColor;
    private Drawable mBorder;
    private BorderType mBorderType;
    private Drawable mCallIcon;
    private long mContactId;
    private String mContactPhone;
    private Drawable mCoverDrawable;
    private int mDefaultColor;
    private Drawable mDefaultDrawable;
    private Bitmap mDstContactBmp;
    private Bundle mExtras;
    private boolean mHasShadow;
    private CharSequence mIconText;
    private IconType mIconType;
    private boolean mIsClickToCall;
    private boolean mIsUseStyle;
    private Drawable mListCallIcon;
    private boolean mLongClick;
    private int mOffsetBottom;
    private int mOffsetRight;
    private long mOldContactId;
    private Bundle mOldExtras;
    private String mOldPhone;
    private Paint mPaint;
    private int mPictureHeight;
    private int mPictureWidth;
    private Rect mRectView;
    private boolean mRecycle;
    private boolean mRecycleOnDetached;
    private Drawable mShadowDrawable;
    private Drawable mSmallIcon;
    private CharSequence mSubtitle;
    private CharSequence mTitle;
    private boolean mUseCallIcon;
    private int mViewHeight;
    private int mViewWidth;

    /* renamed from: com.meizu.common.widget.RoundCornerRecordView$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$meizu$common$widget$RoundCornerRecordView$BorderType;
        static final /* synthetic */ int[] $SwitchMap$com$meizu$common$widget$RoundCornerRecordView$IconType;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0085 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x008f */
        static {
            /*
                com.meizu.common.widget.RoundCornerRecordView$IconType[] r0 = com.meizu.common.widget.RoundCornerRecordView.IconType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$meizu$common$widget$RoundCornerRecordView$IconType = r0
                r1 = 1
                com.meizu.common.widget.RoundCornerRecordView$IconType r2 = com.meizu.common.widget.RoundCornerRecordView.IconType.IC_CALL_LOG_CALLOUT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$meizu$common$widget$RoundCornerRecordView$IconType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.meizu.common.widget.RoundCornerRecordView$IconType r3 = com.meizu.common.widget.RoundCornerRecordView.IconType.IC_CALL_LOG_CALLIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$meizu$common$widget$RoundCornerRecordView$IconType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.meizu.common.widget.RoundCornerRecordView$IconType r4 = com.meizu.common.widget.RoundCornerRecordView.IconType.IC_CALL_LOG_MISSED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$meizu$common$widget$RoundCornerRecordView$IconType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.meizu.common.widget.RoundCornerRecordView$IconType r5 = com.meizu.common.widget.RoundCornerRecordView.IconType.IC_CALL_LOG_REFUSED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$com$meizu$common$widget$RoundCornerRecordView$IconType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.meizu.common.widget.RoundCornerRecordView$IconType r6 = com.meizu.common.widget.RoundCornerRecordView.IconType.IC_CALL_LOG_RINGONCE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r5 = $SwitchMap$com$meizu$common$widget$RoundCornerRecordView$IconType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.meizu.common.widget.RoundCornerRecordView$IconType r6 = com.meizu.common.widget.RoundCornerRecordView.IconType.IC_CALL_LOG_RECORD     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r7 = 6
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r5 = $SwitchMap$com$meizu$common$widget$RoundCornerRecordView$IconType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.meizu.common.widget.RoundCornerRecordView$IconType r6 = com.meizu.common.widget.RoundCornerRecordView.IconType.IC_CALL_LOG_RECORD_FAIL     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7 = 7
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r5 = $SwitchMap$com$meizu$common$widget$RoundCornerRecordView$IconType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.meizu.common.widget.RoundCornerRecordView$IconType r6 = com.meizu.common.widget.RoundCornerRecordView.IconType.IC_CALL_LOG_VOICEMAIL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r7 = 8
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                com.meizu.common.widget.RoundCornerRecordView$BorderType[] r5 = com.meizu.common.widget.RoundCornerRecordView.BorderType.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                $SwitchMap$com$meizu$common$widget$RoundCornerRecordView$BorderType = r5
                com.meizu.common.widget.RoundCornerRecordView$BorderType r6 = com.meizu.common.widget.RoundCornerRecordView.BorderType.BORDER_SMALL_CONTACT     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r1 = $SwitchMap$com$meizu$common$widget$RoundCornerRecordView$BorderType     // Catch:{ NoSuchFieldError -> 0x007b }
                com.meizu.common.widget.RoundCornerRecordView$BorderType r5 = com.meizu.common.widget.RoundCornerRecordView.BorderType.BORDER_LIST_CONTACT     // Catch:{ NoSuchFieldError -> 0x007b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = $SwitchMap$com$meizu$common$widget$RoundCornerRecordView$BorderType     // Catch:{ NoSuchFieldError -> 0x0085 }
                com.meizu.common.widget.RoundCornerRecordView$BorderType r1 = com.meizu.common.widget.RoundCornerRecordView.BorderType.BORDER_SMS_CONTACT     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                int[] r0 = $SwitchMap$com$meizu$common$widget$RoundCornerRecordView$BorderType     // Catch:{ NoSuchFieldError -> 0x008f }
                com.meizu.common.widget.RoundCornerRecordView$BorderType r1 = com.meizu.common.widget.RoundCornerRecordView.BorderType.BORDER_EDIT_CONTACT     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = $SwitchMap$com$meizu$common$widget$RoundCornerRecordView$BorderType     // Catch:{ NoSuchFieldError -> 0x0099 }
                com.meizu.common.widget.RoundCornerRecordView$BorderType r1 = com.meizu.common.widget.RoundCornerRecordView.BorderType.BORDER_VIEW_CONTACT     // Catch:{ NoSuchFieldError -> 0x0099 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0099 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0099 }
            L_0x0099:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.RoundCornerRecordView.AnonymousClass1.<clinit>():void");
        }
    }

    public enum BorderType {
        BORDER_NULL(0),
        BORDER_LIST_CONTACT(1),
        BORDER_EDIT_CONTACT(2),
        BORDER_VIEW_CONTACT(3),
        BORDER_SMS_CONTACT(4),
        BORDER_SMALL_CONTACT(5);
        
        final int borderTypeInt;

        private BorderType(int i) {
            this.borderTypeInt = i;
        }
    }

    public enum IconType {
        IC_NULL(0),
        IC_CALL_LOG_CALLOUT(1),
        IC_CALL_LOG_CALLIN(2),
        IC_CALL_LOG_MISSED(3),
        IC_CALL_LOG_REFUSED(4),
        IC_CALL_LOG_RINGONCE(5),
        IC_CALL_LOG_RECORD(6),
        IC_CALL_LOG_RECORD_FAIL(7),
        IC_CALL_LOG_VOICEMAIL(8),
        IC_SMS_HAS_UNREAD(9),
        IC_SMS_HAS_NOTDELIVERED(10);
        
        final int iconTypeInt;

        private IconType(int i) {
            this.iconTypeInt = i;
        }
    }

    public RoundCornerRecordView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void drawBadgeText(Canvas canvas, Rect rect) {
        if (this.mBadgeTextDrawable == null) {
            this.mBadgeTextDrawable = getResources().getDrawable(R.drawable.mc_contact_list_picture_default);
        }
        this.mBadgeTextDrawable.setBounds(rect);
        this.mBadgeTextDrawable.draw(canvas);
        if (this.mBadgeTextPaint == null) {
            Paint paint = new Paint();
            this.mBadgeTextPaint = paint;
            paint.setAntiAlias(true);
            this.mBadgeTextPaint.setTextAlign(Paint.Align.CENTER);
            this.mBadgeTextPaint.setColor(-1);
            this.mBadgeTextPaint.setShadowLayer((float) this.mBadgeTextShadowRadius, 0.0f, 0.0f, this.mBadgeTextShadowColor);
        }
        this.mBadgeTextPaint.setTextSize((float) this.mBadgeTextSize);
        float f = (float) ((rect.top + rect.bottom) / 2);
        Paint.FontMetrics fontMetrics = this.mBadgeTextPaint.getFontMetrics();
        float f2 = fontMetrics.bottom;
        canvas.drawText(this.mBadgeText, (float) ((rect.left + rect.right) / 2), (f + (((f2 - fontMetrics.top) / 2.0f) - f2)) - 2.0f, this.mBadgeTextPaint);
    }

    private void drawContactDrawable() {
        int i;
        int i2;
        int i3;
        int i4;
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if ((drawable instanceof BitmapDrawable) && !isDefaultDrawable(drawable)) {
            int width = this.mRectView.width();
            int height = this.mRectView.height();
            if (this.mIsUseStyle) {
                width = this.mPictureWidth;
                height = this.mPictureHeight;
            }
            Bitmap bitmap2 = ((BitmapDrawable) drawable).getBitmap();
            int width2 = bitmap2.getWidth();
            int height2 = bitmap2.getHeight();
            if (width2 == height2) {
                i2 = width2;
                i = height2;
                i4 = 0;
                i3 = 0;
            } else if (height2 > width2) {
                i2 = width2;
                i = i2;
                i3 = (height2 - width2) / 2;
                i4 = 0;
            } else {
                i2 = height2;
                i = i2;
                i3 = 0;
                i4 = (width2 - height2) / 2;
            }
            float f = ((float) width) / ((float) i2);
            float f2 = ((float) height) / ((float) i);
            if (f == 1.0f && f2 == 1.0f && i4 == 0 && i3 == 0) {
                bitmap = bitmap2;
            } else {
                Matrix matrix = new Matrix();
                matrix.postScale(f, f2);
                bitmap = Bitmap.createBitmap(bitmap2, i4, i3, i2, i, matrix, true);
            }
            this.mDstContactBmp = getRoundCornerBitmap(bitmap);
            super.setImageDrawable(new BitmapDrawable(getResources(), this.mDstContactBmp));
            if (bitmap != bitmap2) {
                bitmap.recycle();
            }
            if (this.mRecycle) {
                bitmap2.recycle();
                this.mRecycle = false;
            }
        }
    }

    private void drawSmallIcon(Canvas canvas) {
        if (this.mBorderType == BorderType.BORDER_LIST_CONTACT && this.mSmallIcon != null) {
            int i = this.mOffsetRight - this.mOffsetBottom;
            Rect rect = this.mRectView;
            this.mSmallIcon.setBounds(new Rect(this.mRectView.right - this.mSmallIcon.getIntrinsicWidth(), (this.mRectView.bottom - this.mSmallIcon.getIntrinsicHeight()) - i, rect.right, rect.bottom - i));
            this.mSmallIcon.draw(canvas);
            if (!TextUtils.isEmpty(this.mIconText)) {
                IconType iconType = this.mIconType;
                if (iconType == IconType.IC_SMS_HAS_NOTDELIVERED || iconType == IconType.IC_SMS_HAS_UNREAD) {
                    TextPaint textPaint = new TextPaint(1);
                    textPaint.density = getResources().getDisplayMetrics().density;
                    textPaint.setTextSize(20.0f);
                    textPaint.setColor(getResources().getColor(R.color.white));
                    StaticLayout staticLayout = new StaticLayout(this.mIconText, textPaint, this.mSmallIcon.getIntrinsicWidth(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
                    canvas.save();
                    canvas.translate((float) (this.mRectView.right - this.mSmallIcon.getIntrinsicWidth()), (float) ((this.mRectView.bottom - this.mSmallIcon.getIntrinsicHeight()) - i));
                    canvas.clipRect(0, 0, this.mSmallIcon.getIntrinsicWidth(), this.mSmallIcon.getIntrinsicHeight());
                    staticLayout.draw(canvas);
                    canvas.restore();
                }
            }
        }
    }

    private Drawable getDefaultDrawable() {
        return AnonymousClass1.$SwitchMap$com$meizu$common$widget$RoundCornerRecordView$BorderType[this.mBorderType.ordinal()] != 1 ? getResources().getDrawable(R.drawable.mc_contact_list_picture) : getResources().getDrawable(R.drawable.mc_contact_small_picture);
    }

    private Bitmap getRoundCornerBitmap(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        new RectF(rect);
        if (this.mCoverDrawable == null) {
            Drawable drawable = getResources().getDrawable(R.drawable.mc_contact_list_picture_cover);
            this.mCoverDrawable = drawable;
            if (drawable instanceof NinePatchDrawable) {
                ((NinePatchDrawable) drawable).getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            }
        }
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setXfermode((Xfermode) null);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.mPaint);
        this.mCoverDrawable.setBounds(rect);
        this.mCoverDrawable.draw(canvas);
        return createBitmap;
    }

    private void init() {
        super.setScaleType(ImageView.ScaleType.FIT_CENTER);
        setDuplicateParentStateEnabled(false);
        this.mRectView = new Rect();
        this.mShadowDrawable = getResources().getDrawable(R.drawable.mc_contact_list_picture_shadow);
    }

    private boolean isDefaultDrawable(Drawable drawable) {
        return ((BitmapDrawable) drawable).getBitmap().equals(((BitmapDrawable) this.mDefaultDrawable).getBitmap());
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mBorder;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(drawableState);
            invalidate();
        }
    }

    public BorderType getBorderType() {
        return this.mBorderType;
    }

    public IconType getIconType() {
        return this.mIconType;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mRecycleOnDetached) {
            setImageDrawable((Drawable) null);
        } else {
            this.mRecycleOnDetached = true;
        }
    }

    public void onDraw(Canvas canvas) {
        Drawable drawable;
        Drawable drawable2;
        if (!(getDrawable() instanceof BitmapDrawable) || this.mDstContactBmp != ((BitmapDrawable) getDrawable()).getBitmap()) {
            Bitmap bitmap = this.mDstContactBmp;
            this.mDstContactBmp = null;
            drawContactDrawable();
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        Paint paint = new Paint();
        paint.setColor(this.mBgColor);
        Rect rect = new Rect();
        if (this.mBorderType == BorderType.BORDER_LIST_CONTACT) {
            Rect rect2 = this.mRectView;
            int i = rect2.left;
            int i2 = this.mOffsetRight;
            rect.set(i + i2, rect2.top + i2, rect2.right - i2, rect2.bottom - i2);
        } else {
            rect.set(this.mRectView);
        }
        canvas.drawRect(rect, paint);
        int save = canvas.save();
        if (!this.mUseCallIcon || (drawable2 = this.mCallIcon) == null) {
            if (this.mDstContactBmp != null || TextUtils.isEmpty(this.mBadgeText)) {
                Drawable drawable3 = getDrawable();
                drawable3.setBounds(rect);
                drawable3.draw(canvas);
            } else {
                drawBadgeText(canvas, rect);
            }
            if (this.mHasShadow) {
                this.mShadowDrawable.setBounds(rect);
                this.mShadowDrawable.draw(canvas);
            }
            if (this.mIsClickToCall && (drawable = this.mListCallIcon) != null) {
                drawable.setBounds(rect.left, rect.bottom - drawable.getIntrinsicHeight(), rect.right, rect.bottom);
                this.mListCallIcon.draw(canvas);
            }
            Drawable drawable4 = this.mBorder;
            if (drawable4 != null) {
                drawable4.setBounds(rect);
                this.mBorder.draw(canvas);
            }
        } else {
            drawable2.setBounds(rect);
            this.mCallIcon.draw(canvas);
        }
        canvas.restoreToCount(save);
        this.mUseCallIcon = false;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(RoundCornerRecordView.class.getName());
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mRectView.set(0, 0, super.getMeasuredWidth(), super.getMeasuredHeight());
    }

    public void onMeasure(int i, int i2) {
        if (this.mIsUseStyle) {
            int i3 = this.mViewWidth;
            int i4 = this.mViewHeight;
            i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mIsClickToCall) {
            return super.onTouchEvent(motionEvent);
        }
        if (!hasWindowFocus() || sStartActivity) {
            return true;
        }
        this.mOldPhone = this.mContactPhone;
        this.mOldContactId = this.mContactId;
        this.mOldExtras = this.mExtras;
        return super.onTouchEvent(motionEvent);
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            synchronized (sSyncKeyLock) {
                sStartActivity = false;
            }
        }
        super.onWindowFocusChanged(z);
    }

    public void recycleOnDetached(boolean z) {
        this.mRecycleOnDetached = z;
    }

    public void setBackgroundColorId(String str) {
        TypedArray obtainTypedArray = getResources().obtainTypedArray(R.array.mc_colorful_round);
        int abs = Math.abs(str.hashCode()) % obtainTypedArray.length();
        if (abs < obtainTypedArray.length()) {
            this.mBgColor = obtainTypedArray.getColor(abs, this.mDefaultColor);
        }
        obtainTypedArray.recycle();
    }

    public void setBorderType(BorderType borderType) {
        borderType.getClass();
        if (this.mBorderType != borderType) {
            this.mIsUseStyle = true;
            this.mBorderType = borderType;
            Drawable drawable = this.mDefaultDrawable;
            this.mDefaultDrawable = getDefaultDrawable();
            if (getDrawable() == drawable) {
                setImageDrawable(this.mDefaultDrawable);
            }
            this.mBorder = getResources().getDrawable(R.drawable.mc_contact_list_picture_box);
            this.mBadgeTextShadowRadius = getResources().getDimensionPixelSize(R.dimen.mc_badge_text_shadow_radius);
            this.mBadgeTextShadowColor = getResources().getColor(R.color.mc_badge_text_shadow_color);
            int i = AnonymousClass1.$SwitchMap$com$meizu$common$widget$RoundCornerRecordView$BorderType[this.mBorderType.ordinal()];
            if (i == 1) {
                this.mViewWidth = getResources().getDimensionPixelSize(R.dimen.mc_badge_border_small_width);
                this.mViewHeight = getResources().getDimensionPixelSize(R.dimen.mc_badge_border_small_height);
                this.mPictureWidth = getResources().getDimensionPixelSize(R.dimen.mc_badge_contact_small_picture_width);
                this.mPictureHeight = getResources().getDimensionPixelSize(R.dimen.mc_badge_contact_small_picture_height);
                this.mListCallIcon = getResources().getDrawable(R.drawable.mc_contact_list_call);
                this.mCallIcon = getResources().getDrawable(R.drawable.mc_contact_list_picture_call_pressed);
                this.mBadgeTextSize = getResources().getDimensionPixelSize(R.dimen.mc_badge_small_textsize);
            } else if (i == 2) {
                this.mViewWidth = getResources().getDimensionPixelSize(R.dimen.mc_badge_border_list_width);
                this.mViewHeight = getResources().getDimensionPixelSize(R.dimen.mc_badge_border_list_height);
                this.mPictureWidth = getResources().getDimensionPixelSize(R.dimen.mc_badge_contact_list_picture_width);
                this.mPictureHeight = getResources().getDimensionPixelSize(R.dimen.mc_badge_contact_list_picture_height);
                this.mListCallIcon = getResources().getDrawable(R.drawable.mc_contact_list_call);
                this.mCallIcon = getResources().getDrawable(R.drawable.mc_contact_list_picture_call_pressed);
                this.mBadgeTextSize = getResources().getDimensionPixelSize(R.dimen.mc_badge_list_textsize);
            } else if (i == 3) {
                this.mViewWidth = getResources().getDimensionPixelSize(R.dimen.mc_badge_border_sms_width);
                this.mViewHeight = getResources().getDimensionPixelSize(R.dimen.mc_badge_border_sms_height);
                this.mPictureWidth = getResources().getDimensionPixelSize(R.dimen.mc_badge_contact_list_picture_width);
                this.mPictureHeight = getResources().getDimensionPixelSize(R.dimen.mc_badge_contact_list_picture_height);
                this.mListCallIcon = getResources().getDrawable(R.drawable.mc_contact_list_call);
                this.mCallIcon = getResources().getDrawable(R.drawable.mc_contact_list_picture_call_pressed);
                this.mBadgeTextSize = getResources().getDimensionPixelSize(R.dimen.mc_badge_list_textsize);
            } else if (i == 4 || i == 5) {
                this.mViewWidth = getResources().getDimensionPixelSize(R.dimen.mc_badge_border_contact_width);
                this.mViewHeight = getResources().getDimensionPixelSize(R.dimen.mc_badge_border_contact_height);
                this.mPictureWidth = getResources().getDimensionPixelSize(R.dimen.mc_badge_contact_picture_width);
                this.mPictureHeight = getResources().getDimensionPixelSize(R.dimen.mc_badge_contact_picture_height);
                this.mListCallIcon = null;
                this.mCallIcon = null;
                this.mBadgeTextSize = getResources().getDimensionPixelSize(R.dimen.mc_badge_list_textsize);
            } else {
                this.mListCallIcon = null;
                this.mCallIcon = null;
                this.mIsUseStyle = false;
                this.mBadgeTextSize = getResources().getDimensionPixelSize(R.dimen.mc_badge_small_textsize);
            }
        }
    }

    public void setClickToCall(boolean z) {
        if (this.mIsClickToCall != z) {
            this.mIsClickToCall = z;
            invalidate();
        }
    }

    public void setContactBadgeText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mBadgeText = "";
        } else {
            String trim = str.trim();
            if (TextUtils.isEmpty(trim)) {
                this.mBadgeText = "";
            } else {
                String substring = trim.substring(0, 1);
                char charAt = substring.charAt(0);
                if ('a' <= charAt && charAt <= 'z') {
                    substring = substring.toUpperCase();
                }
                this.mBadgeText = substring;
            }
        }
        invalidate();
    }

    public void setHasShadow(boolean z) {
        if (this.mHasShadow != z) {
            this.mHasShadow = z;
            invalidate();
        }
    }

    public void setIconText(CharSequence charSequence) {
        if (!TextUtils.equals(this.mIconText, charSequence)) {
            this.mIconText = charSequence;
            invalidate();
        }
    }

    public void setIconType(IconType iconType) {
        iconType.getClass();
        if (this.mIconType != iconType) {
            this.mIconType = iconType;
            switch (AnonymousClass1.$SwitchMap$com$meizu$common$widget$RoundCornerRecordView$IconType[iconType.ordinal()]) {
                case 1:
                    this.mSmallIcon = getResources().getDrawable(R.drawable.mc_sym_call_list_outgoing);
                    break;
                case 2:
                    this.mSmallIcon = getResources().getDrawable(R.drawable.mc_sym_call_list_incoming);
                    break;
                case 3:
                    this.mSmallIcon = getResources().getDrawable(R.drawable.mc_sym_call_list_missed);
                    break;
                case 4:
                    this.mSmallIcon = getResources().getDrawable(R.drawable.mc_sym_call_list_reject);
                    break;
                case 5:
                    this.mSmallIcon = getResources().getDrawable(R.drawable.mc_sym_call_list_ringing);
                    break;
                case 6:
                    this.mSmallIcon = getResources().getDrawable(R.drawable.mc_sym_call_list_record);
                    break;
                case 7:
                    this.mSmallIcon = getResources().getDrawable(R.drawable.mc_sym_call_list_record_fail);
                    break;
                case 8:
                    this.mSmallIcon = getResources().getDrawable(R.drawable.mc_sym_call_list_voicemail);
                    break;
                default:
                    this.mSmallIcon = null;
                    break;
            }
            invalidate();
        }
    }

    public void setImageBitmap(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            setImageDrawable((Drawable) null);
            return;
        }
        super.setImageBitmap(bitmap);
        this.mRecycle = z;
    }

    public void setImageDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        if (drawable == null) {
            drawable = this.mDefaultDrawable;
        }
        super.setImageDrawable(drawable);
        Bitmap bitmap = drawable instanceof BitmapDrawable ? ((BitmapDrawable) drawable).getBitmap() : null;
        Bitmap bitmap2 = this.mDstContactBmp;
        if (!(bitmap2 == null || bitmap2 == bitmap)) {
            bitmap2.recycle();
            this.mDstContactBmp = null;
        }
        if (this.mRecycle && (drawable2 instanceof BitmapDrawable)) {
            ((BitmapDrawable) drawable2).getBitmap().recycle();
        }
        this.mRecycle = false;
    }

    public void setImageResource(int i) {
        if (i == 0) {
            setImageDrawable((Drawable) null);
            return;
        }
        Drawable drawable = getDrawable();
        super.setImageResource(i);
        Drawable drawable2 = getDrawable();
        Bitmap bitmap = (drawable2 == null || !(drawable2 instanceof BitmapDrawable)) ? null : ((BitmapDrawable) drawable2).getBitmap();
        Bitmap bitmap2 = this.mDstContactBmp;
        if (!(bitmap2 == null || bitmap2 == bitmap)) {
            bitmap2.recycle();
            this.mDstContactBmp = null;
        }
        if (this.mRecycle && (drawable instanceof BitmapDrawable)) {
            ((BitmapDrawable) drawable).getBitmap().recycle();
        }
        this.mRecycle = false;
    }

    public void setImageURI(Uri uri) {
        if (uri == null) {
            setImageDrawable((Drawable) null);
            return;
        }
        Drawable drawable = getDrawable();
        super.setImageURI(uri);
        Drawable drawable2 = getDrawable();
        Bitmap bitmap = (drawable2 == null || !(drawable2 instanceof BitmapDrawable)) ? null : ((BitmapDrawable) drawable2).getBitmap();
        Bitmap bitmap2 = this.mDstContactBmp;
        if (!(bitmap2 == null || bitmap2 == bitmap)) {
            bitmap2.recycle();
            this.mDstContactBmp = null;
        }
        if (this.mRecycle && (drawable instanceof BitmapDrawable)) {
            ((BitmapDrawable) drawable).getBitmap().recycle();
        }
        this.mRecycle = false;
    }

    public void setPressed(boolean z) {
        if (!(getParent() instanceof View) || !((View) getParent()).isPressed()) {
            super.setPressed(z);
        }
    }

    public void setRecordClickListener(View.OnClickListener onClickListener) {
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
    }

    public void setTilte(CharSequence charSequence) {
        this.mTitle = charSequence;
    }

    public RoundCornerRecordView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerRecordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBorderType = null;
        this.mIconType = null;
        this.mDstContactBmp = null;
        this.mSmallIcon = null;
        this.mBorder = null;
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mPictureWidth = 0;
        this.mPictureHeight = 0;
        this.mIsUseStyle = false;
        this.mIsClickToCall = false;
        this.mUseCallIcon = false;
        this.mLongClick = false;
        this.mBgColor = -1;
        this.mHasShadow = true;
        this.mRecycleOnDetached = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundCornerContactBadge, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.RoundCornerContactBadge_mcBorderType, BorderType.BORDER_NULL.borderTypeInt);
        int i3 = obtainStyledAttributes.getInt(R.styleable.RoundCornerContactBadge_mcIconType, IconType.IC_CALL_LOG_RECORD.iconTypeInt);
        this.mDefaultColor = getResources().getColor(R.color.mc_round_colorfulbg_color);
        obtainStyledAttributes.recycle();
        setBorderType(sBorderTypeArray[i2]);
        setIconType(sIconTypeArray[i3]);
        init();
    }

    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            setImageDrawable((Drawable) null);
        } else {
            super.setImageBitmap(bitmap);
        }
    }
}

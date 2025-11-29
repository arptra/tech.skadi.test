package com.meizu.common.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.meizu.common.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
@TargetApi(18)
@Deprecated
public class FastScrollLetter extends View {
    private static final String CLASS_NAME_FLYME_FEATURE = "flyme.config.FlymeFeature";
    private static final String FIELD_SUPPORT_MOTOR = "SHELL_HAPTICFEEDBACK_MOTOR";
    private static final String FIELD_USE_QCOM_VIBRATE = "USE_QCOM_VIBRATE";
    private static final int SCROLLER_SCROLL = 20120;
    public static final int SECTION_COMPARE_TYPE1 = 1;
    public static final int SECTION_COMPARE_TYPE2 = 2;
    private static final int STATE_DRAGGING = 1;
    private static final int STATE_NONE = 0;
    private static final String TAG = "FastScrollLetter";
    private static final String[] mDefaultLetters = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
    private static Field mShellHapticFeedBackMotor;
    private static Field mUseQCOMVibrate;
    private AbsListView mAbsListView;
    private Map<String, String> mBackgroundColorSet;
    private CircleColorType mCircleColorType;
    private String mCurrentLetter;
    private int mCurrentShowPos;
    private int[] mDefaultCircleColor;
    private int[] mDefaultColor;
    private int mDefaultSectionType;
    private int mEventDownY;
    private int mEventMoveY;
    private Method mFlymeSplitModeManagerInstance;
    private int mHeaderCount;
    private int mHeaderHeight;
    private SparseArray<Integer> mHideLetteSparseArray;
    private int mHideNum;
    private String mHideStr;
    private boolean mIsAlwayShowLetter;
    private boolean mIsEnable;
    private Method mIsSplitMode;
    private int mLetterActiveTextColor;
    private int mLetterMarginBottom;
    private int mLetterMarginRight;
    private int mLetterMarginTop;
    private int mLetterTextColor;
    private int mLetterTextSize;
    private int mLetterWidth;
    private String[] mLetters;
    private ViewGroupOverlay mOverlay;
    private int mOverlayOneTextSize;
    private TextView mOverlayText;
    private int mOverlayTextHeight;
    private String[] mOverlayTextLetters;
    private int mOverlayTextMarginRight;
    private int mOverlayTextTop;
    private int mOverlayTextWidth;
    private int mOverlayThreeTextSize;
    private int mOverlayTwoTextSize;
    private int mPaddingLeft;
    Paint mPaint;
    private Bitmap mPointBitmap;
    private SectionCompare mSectionCompare;
    private SectionIndexer mSectionIndexer;
    private String[] mShowLetters;
    private int mSingleLetterHeight;
    private int mState;
    private String mTopLetter;

    public enum CircleColorType {
        GRAY_SINGLE,
        COLORFUL,
        CUSTOM
    }

    public interface SectionCompare {
        int getSection(int i);
    }

    public FastScrollLetter(Context context, AbsListView absListView) {
        this(context, absListView, (TextView) LayoutInflater.from(context).inflate(R.layout.mc_letter_overlay, (ViewGroup) null));
    }

    private void OnTouchingLetterChange(MotionEvent motionEvent, int i) {
        this.mOverlayText.setTranslationY((float) (((int) ((((float) this.mOverlayTextTop) + motionEvent.getY()) - ((float) this.mEventDownY))) + (this.mOverlayTextHeight / 2)));
        setSelection(i, motionEvent.getY());
    }

    private void alphaAnim(final boolean z, final View view) {
        if (view.getAnimation() == null) {
            if (z && view.getVisibility() == 0) {
                return;
            }
            if (!z && view.getVisibility() == 4) {
                return;
            }
        }
        float f = 1.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (!z) {
            f = 0.0f;
        }
        view.clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(z ? 0 : 4);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        alphaAnimation.setDuration(180);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        view.setAnimation(alphaAnimation);
        alphaAnimation.startNow();
    }

    private void cancelFling() {
        MotionEvent obtain = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0);
        this.mAbsListView.onTouchEvent(obtain);
        obtain.recycle();
    }

    private int getChoosePos(float f) {
        int i;
        int i2;
        int height = getHeight() / this.mShowLetters.length;
        this.mSingleLetterHeight = height;
        int ceil = (int) (Math.ceil((double) (f / ((float) height))) - 1.0d);
        if (ceil < 0 || ceil >= this.mShowLetters.length) {
            return -1;
        }
        int i3 = 0;
        if (this.mHideLetteSparseArray == null) {
            i2 = 0;
            while (i3 < ceil) {
                i2 = this.mShowLetters[i3].equals(this.mHideStr) ? i2 + this.mHideNum : i2 + 1;
                i3++;
            }
            float f2 = f - ((float) (this.mSingleLetterHeight * ceil));
            if (this.mHideNum == 0) {
                this.mHideNum = 1;
            }
            if (!this.mShowLetters[ceil].equals(this.mHideStr)) {
                return i2;
            }
            i = (int) (f2 / ((float) (this.mSingleLetterHeight / this.mHideNum)));
        } else {
            int i4 = 0;
            while (i3 < ceil) {
                i4 = this.mShowLetters[i3].equals(this.mHideStr) ? i2 + this.mHideLetteSparseArray.get(i3).intValue() : i2 + 1;
                i3++;
            }
            float f3 = f - ((float) (this.mSingleLetterHeight * ceil));
            if (!this.mShowLetters[ceil].equals(this.mHideStr)) {
                return i2;
            }
            i = (int) Math.floor((double) ((f3 / ((float) this.mSingleLetterHeight)) * ((float) this.mHideLetteSparseArray.get(ceil).intValue())));
        }
        return i2 + i;
    }

    private int getCurrentPos(int i) {
        this.mCurrentShowPos = -1;
        int i2 = -1;
        while (i2 == -1) {
            int i3 = i - 1;
            if (i >= this.mOverlayTextLetters.length || i < 0) {
                break;
            }
            int section = getSection(i);
            if (!(section == -1 || (i2 = this.mSectionIndexer.getPositionForSection(section)) == -1)) {
                this.mCurrentShowPos = Math.max(i, 0);
            }
            i = i3;
        }
        return i2;
    }

    private int getNextPos(int i) {
        int i2 = -1;
        while (i2 == -1) {
            i++;
            if (i >= this.mOverlayTextLetters.length || i < 0) {
                break;
            }
            int section = getSection(i);
            if (section != -1) {
                i2 = this.mSectionIndexer.getPositionForSection(section);
            }
        }
        if (this.mCurrentShowPos < 0 && i < this.mOverlayTextLetters.length) {
            this.mCurrentShowPos = i;
        }
        return i2 == -1 ? this.mAbsListView.getCount() : i2;
    }

    private int getPxSize(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    private int getSection(int i) {
        SectionCompare sectionCompare = this.mSectionCompare;
        if (sectionCompare != null) {
            return sectionCompare.getSection(i);
        }
        String str = this.mOverlayTextLetters[i];
        Object[] sections = this.mSectionIndexer.getSections();
        if (sections == null) {
            return -1;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= sections.length) {
                i3 = -1;
                break;
            } else if (sections[i3].toString().equals(str)) {
                break;
            } else {
                i3++;
            }
        }
        int i4 = this.mDefaultSectionType;
        if (i4 == 2 && i3 >= 0) {
            return i3;
        }
        if (i4 != 1 || i3 == -1) {
            return -1;
        }
        int positionForSection = this.mSectionIndexer.getPositionForSection(i3);
        AbsListView absListView = this.mAbsListView;
        if (absListView instanceof ListView) {
            i2 = ((ListView) absListView).getFooterViewsCount();
        }
        if (positionForSection >= this.mAbsListView.getCount() - i2 || this.mSectionIndexer.getSectionForPosition(positionForSection) != i3) {
            return -1;
        }
        return i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean hasFlymeFeature() {
        /*
            r2 = this;
            r2 = 0
            java.lang.reflect.Field r0 = mShellHapticFeedBackMotor     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r0 == 0) goto L_0x000c
            java.lang.reflect.Field r0 = mUseQCOMVibrate     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r0 != 0) goto L_0x002a
            goto L_0x000c
        L_0x000a:
            r0 = move-exception
            goto L_0x003d
        L_0x000c:
            java.lang.String r0 = "flyme.config.FlymeFeature"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            java.lang.reflect.Field r1 = mShellHapticFeedBackMotor     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r1 != 0) goto L_0x001e
            java.lang.String r1 = "SHELL_HAPTICFEEDBACK_MOTOR"
            java.lang.reflect.Field r1 = r0.getDeclaredField(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            mShellHapticFeedBackMotor = r1     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
        L_0x001e:
            java.lang.reflect.Field r1 = mUseQCOMVibrate     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r1 != 0) goto L_0x002a
            java.lang.String r1 = "USE_QCOM_VIBRATE"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            mUseQCOMVibrate = r0     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
        L_0x002a:
            java.lang.reflect.Field r0 = mShellHapticFeedBackMotor     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            r1 = 0
            boolean r0 = r0.getBoolean(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r0 != 0) goto L_0x003b
            java.lang.reflect.Field r0 = mUseQCOMVibrate     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            boolean r0 = r0.getBoolean(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r0 == 0) goto L_0x0040
        L_0x003b:
            r2 = 1
            goto L_0x0040
        L_0x003d:
            r0.printStackTrace()
        L_0x0040:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.FastScrollLetter.hasFlymeFeature():boolean");
    }

    private boolean isContain(float f, float f2) {
        return ((float) getLeft()) < f && f < ((float) getRight()) && ((float) getTop()) < f2 && ((float) getBottom()) > f2;
    }

    private boolean isContainWithTop(float f, float f2) {
        return ((float) getLeft()) < f && f < ((float) getRight()) && ((float) getTop()) > f2 && ((float) getBottom()) > f2;
    }

    private boolean isFlymeSplitmode(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            if (this.mIsSplitMode == null) {
                Class<?> cls = Class.forName("meizu.splitmode.FlymeSplitModeManager");
                this.mFlymeSplitModeManagerInstance = cls.getMethod("getInstance", new Class[]{Context.class});
                this.mIsSplitMode = cls.getMethod("isSplitMode", (Class[]) null);
            }
            return ((Boolean) this.mIsSplitMode.invoke(this.mFlymeSplitModeManagerInstance.invoke((Object) null, new Object[]{activity}), (Object[]) null)).booleanValue();
        } catch (ClassNotFoundException unused) {
            Log.e(TAG, "isFlymeSplitemode ClassNotFoundException");
            return false;
        } catch (NoSuchMethodException unused2) {
            Log.e(TAG, "isFlymeSplitemode NoSuchMethodException");
            return false;
        } catch (InvocationTargetException unused3) {
            Log.e(TAG, "isFlymeSplitemode InvocationTargetException");
            return false;
        } catch (IllegalAccessException unused4) {
            Log.e(TAG, "isFlymeSplitemode IllegalAccessException");
            return false;
        }
    }

    private boolean isSplitMode(Activity activity) {
        return activity.isInMultiWindowMode();
    }

    private void isVibratorNeed() {
        if (hasFlymeFeature()) {
            performHapticFeedback(SCROLLER_SCROLL);
        }
    }

    private void onTouchingLetterTop() {
        setOverLayText(this.mTopLetter);
        AbsListView absListView = this.mAbsListView;
        if (absListView instanceof ListView) {
            absListView.setSelectionFromTop(0, -this.mHeaderHeight);
        } else {
            absListView.setSelection(this.mHeaderCount);
        }
    }

    private void setLetterState(boolean z, View view) {
        alphaAnim(z, this.mOverlayText);
        if (!this.mIsAlwayShowLetter) {
            alphaAnim(z, view);
        }
    }

    private void setOverLayText(int i) {
        setOverLayText(this.mOverlayTextLetters[i]);
    }

    @TargetApi(17)
    private void setOverlayTextLayout(float f) {
        this.mEventDownY = (int) f;
        int width = this.mAbsListView.getWidth() - (this.mOverlayTextMarginRight + this.mOverlayTextWidth);
        int i = (int) (((float) this.mOverlayTextTop) + f);
        int width2 = this.mAbsListView.getWidth() - this.mOverlayTextMarginRight;
        int i2 = this.mOverlayTextHeight + i;
        this.mOverlayText.setTranslationY(0.0f);
        if (this.mAbsListView.getLayoutDirection() == 0) {
            this.mOverlayText.layout(width, i, width2, i2);
            return;
        }
        TextView textView = this.mOverlayText;
        int i3 = this.mOverlayTextMarginRight;
        textView.layout(i3, i, this.mOverlayTextWidth + i3, i2);
    }

    private void setSelection(int i, float f) {
        ListAdapter listAdapter = (ListAdapter) this.mAbsListView.getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) listAdapter;
            this.mHeaderCount = headerViewListAdapter.getHeadersCount();
            listAdapter = headerViewListAdapter.getWrappedAdapter();
        }
        if (listAdapter instanceof SectionIndexer) {
            this.mSectionIndexer = (SectionIndexer) listAdapter;
            int i2 = this.mCurrentShowPos;
            int currentPos = getCurrentPos(i);
            if (this.mCurrentShowPos == -1) {
                currentPos = getNextPos(i);
            }
            int i3 = this.mCurrentShowPos;
            if (i3 < 0 || i3 >= this.mOverlayTextLetters.length) {
                String str = this.mTopLetter;
                if (str != null && !str.equals("")) {
                    setOverLayText(this.mTopLetter);
                }
            } else if (i2 != i3) {
                setOverLayText(i3);
                AbsListView absListView = this.mAbsListView;
                if (absListView instanceof ListView) {
                    absListView.setSelectionFromTop(this.mHeaderCount + currentPos, -this.mHeaderHeight);
                } else {
                    absListView.setSelection(currentPos + this.mHeaderCount);
                }
            }
        } else {
            Log.w(TAG, "mSectionIndexer is null, adapter is not implements");
        }
    }

    public int getHeaderHeight() {
        return this.mHeaderHeight;
    }

    public int getHideNum() {
        return this.mHideNum;
    }

    public String getHideStr() {
        return this.mHideStr;
    }

    public int getLetterMarginBottom() {
        return this.mLetterMarginBottom;
    }

    public int getLetterMarginRight() {
        return this.mLetterMarginRight;
    }

    public int getLetterMarginTop() {
        return this.mLetterMarginTop;
    }

    public int getLetterTextColor() {
        return this.mLetterTextColor;
    }

    public int getLetterTextSize() {
        return this.mLetterTextSize;
    }

    public int getLetterWidth() {
        return this.mLetterWidth;
    }

    public String[] getLetters() {
        return this.mLetters;
    }

    public Map<String, String> getOverlayTextBackgroundColor() {
        return this.mBackgroundColorSet;
    }

    public String[] getOverlayTextLetters() {
        return this.mOverlayTextLetters;
    }

    public int getOverlayTextMarginRight() {
        return this.mOverlayTextMarginRight;
    }

    public int getOverlayTextWidth() {
        return this.mOverlayTextWidth;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.mPaddingLeft;
        if (this.mAbsListView.getLayoutDirection() == 1) {
            i = this.mPaddingLeft * -1;
        }
        String[] strArr = this.mShowLetters;
        if (strArr != null && strArr.length != 0) {
            int height = getHeight();
            int width = getWidth();
            this.mSingleLetterHeight = height / strArr.length;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                int i3 = width / 2;
                float measureText = (((float) i3) - (this.mPaint.measureText(strArr[i2]) / 2.0f)) + ((float) i);
                int i4 = this.mSingleLetterHeight;
                float f = (float) ((i4 * i2) + i4);
                if (this.mPointBitmap == null || !strArr[i2].equals(this.mHideStr)) {
                    canvas.drawText(strArr[i2], measureText, f, this.mPaint);
                } else {
                    int i5 = this.mSingleLetterHeight;
                    Bitmap bitmap = this.mPointBitmap;
                    canvas.drawBitmap(bitmap, (float) ((i3 - (this.mPointBitmap.getWidth() / 2)) + i), (float) ((i5 * i2) + (i5 / 2)), this.mPaint);
                }
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(FastScrollLetter.class.getName());
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @TargetApi(17)
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        float f;
        super.onSizeChanged(i, i2, i3, i4);
        int width = this.mAbsListView.getWidth() - (this.mLetterMarginRight + this.mLetterWidth);
        int width2 = this.mAbsListView.getWidth() - this.mLetterMarginRight;
        int i6 = this.mLetterMarginTop;
        if (i6 == -1 || this.mLetterMarginBottom == -1) {
            i6 = (this.mAbsListView.getHeight() - (this.mLetters.length * this.mLetterTextSize)) / 2;
            this.mLetterMarginTop = i6;
            this.mLetterMarginBottom = i6;
            i5 = this.mAbsListView.getHeight() - i6;
        } else {
            i5 = this.mAbsListView.getHeight() - this.mLetterMarginBottom;
        }
        boolean isSplitMode = isSplitMode((Activity) getContext());
        if (isSplitMode) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            ((Activity) getContext()).getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            f = ((float) displayMetrics.heightPixels) / ((float) Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels));
            this.mPaint.setTextSize(((float) this.mLetterTextSize) * f);
        } else {
            this.mPaint.setTextSize((float) this.mLetterTextSize);
            f = 1.0f;
        }
        if (this.mAbsListView.getLayoutDirection() == 0) {
            if (isSplitMode) {
                i6 = (int) (((float) i6) * f);
            }
            if (isSplitMode) {
                i5 = this.mAbsListView.getHeight() - ((int) (f * ((float) this.mLetterMarginBottom)));
            }
            layout(width, i6, width2, i5);
        } else {
            int i7 = this.mLetterMarginRight;
            if (isSplitMode) {
                i6 = (int) (((float) i6) * f);
            }
            int i8 = this.mLetterWidth + i7;
            if (isSplitMode) {
                i5 = this.mAbsListView.getHeight() - ((int) (f * ((float) this.mLetterMarginBottom)));
            }
            layout(i7, i6, i8, i5);
        }
        TextView textView = this.mOverlayText;
        int i9 = this.mOverlayTextWidth;
        textView.measure(i9, i9);
        setOverlayTextLayout(0.0f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004c, code lost:
        if (r0 != 4) goto L_0x011a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.mIsEnable
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            android.widget.AbsListView r0 = r7.mAbsListView
            int r0 = r0.getScrollY()
            if (r0 == 0) goto L_0x000f
            return r1
        L_0x000f:
            int r0 = r8.getAction()
            float r2 = r8.getY()
            r3 = 0
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x001d
            r2 = r3
        L_0x001d:
            java.lang.String[] r3 = r7.mShowLetters
            if (r3 == 0) goto L_0x011f
            int r3 = r3.length
            if (r3 == 0) goto L_0x011f
            android.widget.AbsListView r3 = r7.mAbsListView
            if (r3 == 0) goto L_0x011f
            android.widget.TextView r3 = r7.mOverlayText
            if (r3 == 0) goto L_0x011f
            java.lang.String[] r3 = r7.mOverlayTextLetters
            if (r3 == 0) goto L_0x011f
            int r3 = r3.length
            if (r3 != 0) goto L_0x0035
            goto L_0x011f
        L_0x0035:
            int r3 = r7.mLetterMarginTop
            float r3 = (float) r3
            float r2 = r2 - r3
            int r2 = r7.getChoosePos(r2)
            java.lang.String r3 = ""
            r4 = -1
            r5 = 1
            if (r0 == 0) goto L_0x0071
            if (r0 == r5) goto L_0x0050
            r6 = 2
            if (r0 == r6) goto L_0x00de
            r8 = 3
            if (r0 == r8) goto L_0x0050
            r8 = 4
            if (r0 == r8) goto L_0x0050
            goto L_0x011a
        L_0x0050:
            android.widget.AbsListView r8 = r7.mAbsListView
            r8.requestDisallowInterceptTouchEvent(r1)
            int r8 = r7.mState
            if (r8 != r5) goto L_0x011a
            r7.mCurrentShowPos = r4
            android.graphics.Paint r8 = r7.mPaint
            int r0 = r7.mLetterTextColor
            r8.setColor(r0)
            r7.invalidate()
            int r8 = r7.mEventMoveY
            float r8 = (float) r8
            r7.setOverlayTextLayout(r8)
            r7.setLetterState(r1, r7)
            r7.mState = r1
            return r5
        L_0x0071:
            if (r2 >= 0) goto L_0x0074
            return r1
        L_0x0074:
            float r0 = r8.getY()
            int r0 = (int) r0
            r7.mEventMoveY = r0
            float r0 = r8.getX()
            float r6 = r8.getY()
            boolean r0 = r7.isContain(r0, r6)
            if (r0 == 0) goto L_0x00ab
            android.graphics.Paint r0 = r7.mPaint
            int r1 = r7.mLetterActiveTextColor
            r0.setColor(r1)
            r7.invalidate()
            android.widget.AbsListView r0 = r7.mAbsListView
            r0.requestDisallowInterceptTouchEvent(r5)
            r7.cancelFling()
            float r0 = r8.getY()
            r7.setOverlayTextLayout(r0)
            r7.setLetterState(r5, r7)
            r7.OnTouchingLetterChange(r8, r2)
            r7.mState = r5
            return r5
        L_0x00ab:
            java.lang.String r0 = r7.mTopLetter
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x00de
            float r0 = r8.getX()
            float r6 = r8.getY()
            boolean r0 = r7.isContainWithTop(r0, r6)
            if (r0 == 0) goto L_0x00de
            r7.mCurrentShowPos = r4
            android.graphics.Paint r8 = r7.mPaint
            int r0 = r7.mLetterActiveTextColor
            r8.setColor(r0)
            r7.invalidate()
            r7.mState = r5
            int r8 = r7.getTop()
            float r8 = (float) r8
            r7.setOverlayTextLayout(r8)
            r7.setLetterState(r5, r7)
            r7.onTouchingLetterTop()
            return r5
        L_0x00de:
            int r0 = r7.mState
            if (r0 != r5) goto L_0x011a
            if (r2 < 0) goto L_0x00ff
            java.lang.String[] r0 = r7.mOverlayTextLetters
            int r0 = r0.length
            if (r2 >= r0) goto L_0x00ff
            float r0 = r8.getY()
            int r0 = (int) r0
            r7.mEventMoveY = r0
            int r0 = r7.mCurrentShowPos
            if (r0 != r4) goto L_0x00fb
            float r0 = r8.getY()
            r7.setOverlayTextLayout(r0)
        L_0x00fb:
            r7.OnTouchingLetterChange(r8, r2)
            goto L_0x011a
        L_0x00ff:
            java.lang.String r0 = r7.mTopLetter
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x011a
            float r0 = r8.getX()
            float r8 = r8.getY()
            boolean r8 = r7.isContainWithTop(r0, r8)
            if (r8 == 0) goto L_0x011a
            r7.mCurrentShowPos = r4
            r7.onTouchingLetterTop()
        L_0x011a:
            int r7 = r7.mState
            if (r7 != r5) goto L_0x011f
            r1 = r5
        L_0x011f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.FastScrollLetter.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCircleColorResIds(@NonNull int... iArr) {
        if (this.mCircleColorType == CircleColorType.CUSTOM) {
            this.mDefaultColor = iArr;
        }
    }

    public void setCircleColorType(@NonNull CircleColorType circleColorType) {
        this.mCircleColorType = circleColorType;
        if (circleColorType != CircleColorType.CUSTOM) {
            if (circleColorType == CircleColorType.COLORFUL) {
                this.mDefaultColor = this.mDefaultCircleColor;
            } else if (circleColorType == CircleColorType.GRAY_SINGLE) {
                this.mDefaultColor = new int[]{R.color.mc_fast_scroll_letter_color_gray};
            }
        }
    }

    public void setFastScrollAlwaysVisible(boolean z) {
        this.mIsAlwayShowLetter = z;
        if (z) {
            setVisibility(0);
        }
    }

    public void setFastScrollEnabled(boolean z) {
        this.mIsEnable = z;
        setVisibility(z ? 0 : 8);
    }

    public void setHeaderHeight(int i) {
        this.mHeaderHeight = i;
    }

    public void setHideLetter(SparseArray<Integer> sparseArray, String[] strArr) {
        this.mHideLetteSparseArray = sparseArray;
        this.mShowLetters = strArr;
    }

    public void setHideLetterNum(String str, int i) {
        this.mHideStr = str;
        this.mHideNum = i;
        int length = ((this.mShowLetters.length - 1) / (i + 1)) * 2;
        String[] strArr = new String[(length + 2)];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr2 = this.mShowLetters;
            if (i2 < strArr2.length) {
                int i4 = i3 + 1;
                strArr[i3] = strArr2[i2];
                i3 += 2;
                strArr[i4] = this.mHideStr;
                i2 += this.mHideNum + 1;
            } else {
                strArr[length + 1] = strArr2[strArr2.length - 1];
                this.mShowLetters = strArr;
                return;
            }
        }
    }

    public void setHideLetterStr(String str, Bitmap bitmap) {
        if (bitmap != null) {
            this.mPointBitmap = bitmap;
        }
        this.mHideStr = str;
    }

    public void setLayoutPaddingLeft(int i) {
        this.mPaddingLeft = i;
    }

    public void setLetterActiveColor(int i, int i2) {
        this.mLetterActiveTextColor = i2;
        this.mLetterTextColor = i;
        this.mPaint.setColor(i);
        invalidate();
    }

    @TargetApi(16)
    public void setLetterBackground(Drawable drawable) {
        setBackground(drawable);
    }

    public void setLetterParam(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != -1) {
            this.mLetterTextSize = i;
            this.mPaint.setTextSize((float) i);
        }
        if (i2 != -1) {
            this.mLetterTextColor = i2;
            this.mLetterActiveTextColor = i2;
            this.mPaint.setColor(i2);
            invalidate();
        }
        this.mLetterMarginTop = i3;
        this.mLetterMarginBottom = i4;
        if (i5 != -1) {
            this.mLetterMarginRight = i5;
        }
        if (i6 != -1) {
            this.mLetterWidth = i6;
        }
    }

    public void setLetters(String[] strArr) {
        this.mShowLetters = strArr;
        this.mLetters = strArr;
        setOverlayTextLetters(strArr);
    }

    @TargetApi(16)
    public void setOverlayBackground(Drawable drawable) {
        this.mOverlayText.setBackground(drawable);
    }

    public void setOverlayParam(int i, int i2) {
        if (i != -1) {
            this.mOverlayTextHeight = i;
            this.mOverlayTextWidth = i;
        }
        if (i2 != -1) {
            this.mOverlayTextMarginRight = i2;
        }
    }

    public void setOverlayTextBackgroundColor(Map<String, String> map) {
        this.mBackgroundColorSet = map;
    }

    public void setOverlayTextLetters(String[] strArr) {
        this.mOverlayTextLetters = strArr;
        if (strArr == null || strArr.length == 0) {
            setOverLayText(this.mTopLetter);
        }
    }

    public void setSectionCompare(SectionCompare sectionCompare) {
        this.mSectionCompare = sectionCompare;
    }

    public void setTopLetter(String str) {
        this.mTopLetter = str;
        String[] strArr = this.mOverlayTextLetters;
        if (strArr == null || strArr.length == 0) {
            setOverLayText(str);
        }
    }

    private void setOverLayText(String str) {
        int i = this.mOverlayThreeTextSize;
        if (str != this.mCurrentLetter) {
            this.mCurrentLetter = str;
            int length = str.length();
            if (length == 1) {
                i = this.mOverlayOneTextSize;
            } else if (length == 2 || length == 3 || length == 4) {
                i = this.mOverlayTwoTextSize;
            }
            int i2 = 0;
            this.mOverlayText.setTextSize(0, (float) i);
            this.mOverlayText.setText(this.mCurrentLetter);
            isVibratorNeed();
            Map<String, String> map = this.mBackgroundColorSet;
            if (map != null) {
                String str2 = map.get(this.mCurrentLetter);
                if (str2 != null) {
                    ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
                    shapeDrawable.getPaint().setColor(Color.parseColor(str2));
                    this.mOverlayText.setBackground(shapeDrawable);
                    return;
                }
                return;
            }
            Object[] sections = this.mSectionIndexer.getSections();
            if (sections != null) {
                while (true) {
                    if (i2 >= sections.length) {
                        i2 = -1;
                        break;
                    } else if (sections[i2].toString().equals(str)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 != -1) {
                    ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShape());
                    Paint paint = shapeDrawable2.getPaint();
                    Resources resources = getResources();
                    int[] iArr = this.mDefaultColor;
                    paint.setColor(resources.getColor(iArr[i2 % iArr.length]));
                    this.mOverlayText.setBackground(shapeDrawable2);
                }
            }
        }
    }

    public FastScrollLetter(Context context, AbsListView absListView, int i) {
        this(context, absListView, (TextView) LayoutInflater.from(context).inflate(R.layout.mc_letter_overlay, (ViewGroup) null));
        this.mDefaultSectionType = i;
    }

    public FastScrollLetter(Context context, AbsListView absListView, TextView textView, int i) {
        this(context, absListView, textView);
        this.mDefaultSectionType = i;
    }

    public FastScrollLetter(Context context, AbsListView absListView, TextView textView) {
        super(context, (AttributeSet) null, R.attr.MeizuCommon_FastScrollLetter);
        this.mIsAlwayShowLetter = false;
        this.mIsEnable = true;
        this.mPaint = new Paint();
        this.mCurrentShowPos = -1;
        this.mSingleLetterHeight = 0;
        this.mTopLetter = "";
        this.mOverlayOneTextSize = 0;
        this.mOverlayTwoTextSize = 0;
        this.mOverlayThreeTextSize = 0;
        this.mOverlayTextWidth = 0;
        this.mOverlayTextHeight = 0;
        this.mOverlayTextMarginRight = 220;
        this.mOverlayTextTop = 0;
        this.mLetterTextSize = 20;
        this.mLetterMarginTop = 0;
        this.mLetterMarginBottom = 0;
        this.mLetterMarginRight = 0;
        this.mLetterWidth = 24;
        this.mPaddingLeft = 0;
        this.mPointBitmap = null;
        this.mHideStr = "";
        this.mHideNum = 0;
        this.mEventDownY = 0;
        this.mEventMoveY = 0;
        this.mHeaderCount = 0;
        this.mHeaderHeight = 53;
        this.mDefaultSectionType = 2;
        int[] iArr = {R.color.mc_fast_scroll_letter_color_one, R.color.mc_fast_scroll_letter_color_two, R.color.mc_fast_scroll_letter_color_three, R.color.mc_fast_scroll_letter_color_four, R.color.mc_fast_scroll_letter_color_five, R.color.mc_fast_scroll_letter_color_six, R.color.mc_fast_scroll_letter_color_seven};
        this.mDefaultCircleColor = iArr;
        this.mDefaultColor = iArr;
        this.mCircleColorType = CircleColorType.COLORFUL;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.FastScrollLetter, R.attr.MeizuCommon_FastScrollLetter, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.FastScrollLetter_mcFastScrollLetter);
        if (drawable != null) {
            textView.setBackground(drawable);
        }
        if (absListView != null) {
            this.mAbsListView = absListView;
            ViewGroupOverlay overlay = absListView.getOverlay();
            this.mOverlay = overlay;
            overlay.add(this);
            this.mOverlayOneTextSize = getPxSize(context, R.dimen.mc_fastscroll_letter_overlay_text_size);
            this.mOverlayTwoTextSize = getPxSize(context, R.dimen.mc_fastscroll_letter_overlay_two_text_size);
            this.mOverlayThreeTextSize = getPxSize(context, R.dimen.mc_fastscroll_letter_overlay_three_text_size);
            int pxSize = getPxSize(context, R.dimen.mc_fastscroll_letter_overlay_layout_width);
            this.mOverlayTextHeight = pxSize;
            this.mOverlayTextWidth = pxSize;
            this.mOverlayTextMarginRight = getPxSize(context, R.dimen.mc_fastscroll_letter_overlay_layout_margin_right);
            this.mOverlayTextTop = (-this.mOverlayTextHeight) / 2;
            this.mLetterTextSize = getPxSize(context, R.dimen.mc_fastscroll_letter_text_size);
            this.mLetterTextColor = context.getResources().getColor(R.color.mc_fastscroll_letter_text_color);
            this.mLetterMarginTop = getPxSize(context, R.dimen.mc_fastscroll_letter_layout_margin_top);
            this.mLetterMarginRight = getPxSize(context, R.dimen.mc_fastscroll_letter_layout_margin_right);
            this.mLetterMarginBottom = getPxSize(context, R.dimen.mc_fastscroll_letter_layout_margin_bottom);
            this.mLetterWidth = getPxSize(context, R.dimen.mc_fastscroll_letter_layout_wdith);
            this.mOverlayText = textView;
            this.mLetterTextColor = obtainStyledAttributes.getColor(R.styleable.FastScrollLetter_mcLetterTextColor, this.mLetterTextColor);
            this.mLetterActiveTextColor = obtainStyledAttributes.getColor(R.styleable.FastScrollLetter_mcLetterActiveTextColor, this.mLetterActiveTextColor);
            this.mLetterTextSize = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcLetterTextSize, (float) this.mLetterTextSize);
            this.mLetterWidth = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcLetterWidth, (float) this.mLetterWidth);
            this.mLetterMarginTop = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcLetterMarginTop, (float) this.mLetterMarginTop);
            this.mLetterMarginBottom = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcLetterMarginBottom, (float) this.mLetterMarginBottom);
            this.mLetterMarginRight = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcLetterMarginRight, (float) this.mLetterMarginRight);
            this.mOverlay.add(this.mOverlayText);
            this.mOverlayText.setVisibility(4);
            this.mOverlayText.setLayoutDirection(this.mAbsListView.getLayoutDirection());
            int i = this.mLetterTextColor;
            this.mLetterActiveTextColor = i;
            this.mPaint.setColor(i);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setTextSize((float) this.mLetterTextSize);
            this.mPointBitmap = ((BitmapDrawable) context.getResources().getDrawable(R.drawable.mc_ic_letter_search_point)).getBitmap();
            setBackgroundResource(R.drawable.mc_ic_letter_search_bg);
            String[] strArr = mDefaultLetters;
            this.mShowLetters = strArr;
            this.mOverlayTextLetters = strArr;
            this.mLetters = strArr;
            setVisibility(4);
        }
        obtainStyledAttributes.recycle();
    }
}

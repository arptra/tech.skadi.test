package flyme.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import com.meizu.common.util.ReflectUtils;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.util.ResourceUtils;
import flyme.support.v7.view.menu.MenuBuilder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class OptionPopupWindow extends PopupWindow implements PopupWindow.OnDismissListener {
    private static final boolean DEBUG = false;
    private static final int STATE_EMPTY = 0;
    private static final int STATE_MAX = 2;
    private static final int STATE_PRESSED = 1;
    /* access modifiers changed from: private */
    public static final int[][] STATE_SETS;
    private static final String SUSPENSION_POINTS = "‥";
    private static final String TAG = "OptionPopupWindow";
    static Class clazz = null;
    private static Method method = null;
    static Object obj = null;
    private static Bitmap[] sTmpBitmaps;
    private static Method uperWindowLayoutTypeMethod = null;
    /* access modifiers changed from: private */
    public OptionActionMode mActionMode;
    /* access modifiers changed from: private */
    public boolean mAlwaysDrawDivider;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public int mCurPageNum = 0;
    private boolean mDisableAlignBottom;
    private int mGravity = 0;
    private HandleView mHandleView;
    private int[] mLocationInWindow = new int[2];
    /* access modifiers changed from: private */
    public ArrayList<ArrayList<OptionMenu>> mOptionPageList = new ArrayList<>();
    private PopupWindow.OnDismissListener mOptionPopupDismissListener;
    private View mParent;
    private RectF mRectF;
    private Rect mWindowRect;
    private Rect mWndRect;

    public class HandleView extends View {
        private final int ITEM_PADDING;
        private final int ITEM_WIDTH_MAX;
        private final int ITEM_WIDTH_MIN;
        private final int NAVI_NEXT_CONTENT_OFFSET;
        private final int NAVI_PREV_CONTENT_OFFSET;
        private final int TEXT_SIZE;
        int USER_ITEM_WIDTH_MAX = 0;
        int USER_ITEM_WIDTH_MIN = 0;
        private final int kHeight;
        private final int kMinWidth;
        /* access modifiers changed from: private */
        public int mActionIndex = -1;
        private int mActiveIndex = -1;
        private int mArrowOffsetX;
        private Rect mBGPadding = new Rect();
        private Paint mBitmapPaint;
        private final Runnable mClickAction = new Runnable() {
            public void run() {
                OptionActionMode access$000 = OptionPopupWindow.this.mActionMode;
                if (access$000 != null && HandleView.this.mActionIndex >= 0 && OptionPopupWindow.this.mCurPageNum < OptionPopupWindow.this.mOptionPageList.size()) {
                    ArrayList arrayList = (ArrayList) OptionPopupWindow.this.mOptionPageList.get(OptionPopupWindow.this.mCurPageNum);
                    if (HandleView.this.mActionIndex < arrayList.size()) {
                        OptionMenu optionMenu = (OptionMenu) arrayList.get(HandleView.this.mActionIndex);
                        if (optionMenu.isNext && OptionPopupWindow.this.mCurPageNum < OptionPopupWindow.this.mOptionPageList.size() - 1) {
                            OptionPopupWindow.access$208(OptionPopupWindow.this);
                            HandleView.this.invalidate();
                            OptionPopupWindow.this.updateWindow();
                        } else if (optionMenu.isPrev && OptionPopupWindow.this.mCurPageNum > 0) {
                            OptionPopupWindow.access$210(OptionPopupWindow.this);
                            HandleView.this.invalidate();
                            OptionPopupWindow.this.updateWindow();
                        } else if (access$000.onMenuItemSelected(access$000.mMenu, optionMenu.menuItem)) {
                            access$000.finish();
                        }
                        int unused = HandleView.this.mActionIndex = -1;
                    }
                }
            }
        };
        boolean mClickable = true;
        private int mContentWidth;
        private Paint.FontMetricsInt mFmi;
        private int mIconWidth = 24;
        private boolean mIsArrowUp = false;
        private Drawable mLeftDrawable;
        private Drawable mMiddleDrawable;
        private int mNavigationMenuWidth = 0;
        private Drawable mNextDrawable;
        private TextPaint mPaintLabel;
        private int[] mPixels;
        private Drawable mPrevDrawable;
        private Drawable mRightDrawable;
        private Drawable mSepDrawable;
        private float mSuspensionPointsWidth;
        private final int mTouchSlop;
        private int offsetX;

        public HandleView(Context context) {
            super(context);
            Resources resources = context.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.option_popup_text_size);
            this.TEXT_SIZE = dimensionPixelSize;
            this.ITEM_PADDING = resources.getDimensionPixelSize(R.dimen.option_popup_item_padding);
            this.ITEM_WIDTH_MIN = resources.getDimensionPixelSize(R.dimen.option_popup_item_width_min);
            this.ITEM_WIDTH_MAX = resources.getDimensionPixelSize(R.dimen.option_popup_item_width_max);
            this.NAVI_NEXT_CONTENT_OFFSET = resources.getDimensionPixelSize(R.dimen.option_popup_navigation_next_offset);
            this.NAVI_PREV_CONTENT_OFFSET = resources.getDimensionPixelSize(R.dimen.option_popup_navigation_prev_offset);
            this.kHeight = resources.getDimensionPixelSize(R.dimen.option_popup_height);
            this.mLeftDrawable = resources.getDrawable(com.meizu.common.R.drawable.mz_btn_copy_left);
            this.mMiddleDrawable = resources.getDrawable(com.meizu.common.R.drawable.mz_btn_copy_middle);
            this.mRightDrawable = resources.getDrawable(com.meizu.common.R.drawable.mz_btn_copy_right);
            this.mSepDrawable = resources.getDrawable(com.meizu.common.R.drawable.mz_btn_copy_divider);
            this.mSepDrawable.setColorFilter(new PorterDuffColorFilter(OptionPopupWindow.this.mContext.getColor(R.color.fd_sys_color_on_surface_default), PorterDuff.Mode.SCREEN));
            this.mPrevDrawable = resources.getDrawable(com.meizu.common.R.drawable.mz_btn_copy_prev_page);
            this.mNextDrawable = resources.getDrawable(com.meizu.common.R.drawable.mz_btn_copy_next_page);
            if (ResourceUtils.isUiModeNight(getResources().getConfiguration())) {
                int color = getContext().getColor(R.color.fd_sys_color_outline_default);
                this.mLeftDrawable.setTint(color);
                this.mMiddleDrawable.setTint(color);
                this.mRightDrawable.setTint(color);
                int color2 = getContext().getColor(R.color.fd_sys_color_on_surface_default);
                this.mPrevDrawable.setTint(color2);
                this.mNextDrawable.setTint(color2);
            }
            this.mNavigationMenuWidth = this.mNextDrawable.getIntrinsicWidth() + (resources.getDimensionPixelSize(R.dimen.option_popup_navigation_menu_padding) * 2);
            this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
            Rect rect = new Rect();
            this.mLeftDrawable.getPadding(rect);
            Rect rect2 = this.mBGPadding;
            rect2.left = Math.max(rect.left, rect2.left);
            Rect rect3 = this.mBGPadding;
            rect3.top = Math.max(rect.top, rect3.top);
            Rect rect4 = this.mBGPadding;
            rect4.bottom = Math.max(rect.bottom, rect4.bottom);
            this.mMiddleDrawable.getPadding(rect);
            Rect rect5 = this.mBGPadding;
            rect5.top = Math.max(rect.top, rect5.top);
            Rect rect6 = this.mBGPadding;
            rect6.bottom = Math.max(rect.bottom, rect6.bottom);
            this.mRightDrawable.getPadding(rect);
            Rect rect7 = this.mBGPadding;
            rect7.right = Math.max(rect.right, rect7.right);
            Rect rect8 = this.mBGPadding;
            rect8.top = Math.max(rect.top, rect8.top);
            Rect rect9 = this.mBGPadding;
            rect9.bottom = Math.max(rect.bottom, rect9.bottom);
            this.kMinWidth = this.mLeftDrawable.getIntrinsicWidth() + this.mMiddleDrawable.getIntrinsicWidth() + this.mRightDrawable.getIntrinsicWidth();
            TextPaint textPaint = new TextPaint();
            this.mPaintLabel = textPaint;
            textPaint.setAntiAlias(true);
            this.mPaintLabel.setTextSize((float) dimensionPixelSize);
            this.mPaintLabel.setColor(getContext().getColor(R.color.fd_sys_color_on_surface_default));
            this.mPaintLabel.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.mSuspensionPointsWidth = this.mPaintLabel.measureText(OptionPopupWindow.SUSPENSION_POINTS);
            this.mFmi = this.mPaintLabel.getFontMetricsInt();
            Paint paint = new Paint();
            this.mBitmapPaint = paint;
            paint.setAntiAlias(true);
            this.mBitmapPaint.setColor(-3355444);
            this.mIconWidth = (int) (((float) this.mIconWidth) * resources.getDisplayMetrics().density);
        }

        private int calcActiveIndex(float f, float f2) {
            int i = this.mActiveIndex;
            if (OptionPopupWindow.this.mCurPageNum > OptionPopupWindow.this.mOptionPageList.size() - 1) {
                return -1;
            }
            ArrayList arrayList = (ArrayList) OptionPopupWindow.this.mOptionPageList.get(OptionPopupWindow.this.mCurPageNum);
            int size = arrayList.size();
            if (i >= 0 && i < size) {
                Rect rect = ((OptionMenu) arrayList.get(i)).clip;
                int i2 = rect.left;
                int i3 = this.mTouchSlop;
                if (f >= ((float) (i2 - i3)) && f < ((float) (rect.right + i3))) {
                    Rect rect2 = this.mBGPadding;
                    if (f2 >= ((float) ((rect.top - i3) + rect2.top)) && f2 < ((float) ((rect.bottom + i3) - rect2.bottom))) {
                        return i;
                    }
                }
            }
            int i4 = 0;
            while (i4 < size) {
                Rect rect3 = ((OptionMenu) arrayList.get(i4)).clip;
                int i5 = rect3.left;
                if (i4 == 0) {
                    i5 += this.mBGPadding.left;
                }
                int i6 = size + -1 == i4 ? rect3.right - this.mBGPadding.right : rect3.right;
                if (f >= ((float) i5) && f < ((float) i6)) {
                    int i7 = rect3.top;
                    Rect rect4 = this.mBGPadding;
                    if (f2 >= ((float) (i7 + rect4.top)) && f2 < ((float) (rect3.bottom - rect4.bottom))) {
                        return i4;
                    }
                }
                i4++;
            }
            return -1;
        }

        private void calcOptionPage(ArrayList<OptionMenu> arrayList) {
            int i;
            int i2;
            ArrayList<OptionMenu> arrayList2 = arrayList;
            if (arrayList2 != null) {
                int maxWidth = getMaxWidth();
                int i3 = this.mNavigationMenuWidth;
                Rect rect = this.mBGPadding;
                int i4 = i3 + rect.left + rect.right;
                ArrayList arrayList3 = new ArrayList();
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                boolean z = false;
                while (i6 < arrayList.size()) {
                    OptionMenu optionMenu = arrayList2.get(i6);
                    if (z) {
                        i4 += this.mNavigationMenuWidth;
                    }
                    int i8 = optionMenu.width;
                    if (i4 + i8 <= maxWidth || ((i4 - this.mNavigationMenuWidth) + i8 < maxWidth && i6 == arrayList.size() - 1)) {
                        i4 += optionMenu.width;
                        i7++;
                        z = false;
                    } else {
                        i6--;
                        int i9 = this.mNavigationMenuWidth;
                        Rect rect2 = this.mBGPadding;
                        i4 = i9 + rect2.left + rect2.right;
                        arrayList3.add(new PageInfo(i7));
                        i7 = 0;
                        z = true;
                    }
                    i6++;
                }
                arrayList3.add(new PageInfo(i7));
                int i10 = ((PageInfo) arrayList3.get(0)).mMenuCount;
                int i11 = this.mBGPadding.left;
                ArrayList arrayList4 = new ArrayList();
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                while (i12 < arrayList.size()) {
                    OptionMenu optionMenu2 = arrayList2.get(i12);
                    if (i13 != 0) {
                        if (i14 == 0) {
                            OptionMenu optionMenu3 = new OptionMenu(new Rect(i11, i5, this.mNavigationMenuWidth + i11, this.kHeight), (MenuItem) null, this.mNavigationMenuWidth);
                            optionMenu3.isPrev = true;
                            optionMenu3.contentOffset = this.NAVI_PREV_CONTENT_OFFSET;
                            arrayList4.add(optionMenu3);
                            i11 += this.mNavigationMenuWidth;
                        }
                        Rect rect3 = optionMenu2.clip;
                        rect3.left = i11;
                        i11 += optionMenu2.width;
                        rect3.right = i11;
                        arrayList4.add(optionMenu2);
                    } else {
                        arrayList4.add(optionMenu2);
                        i11 += optionMenu2.width;
                    }
                    i14++;
                    if (i14 != i10 || arrayList3.size() <= 1 || (i2 = i13 + 1) >= arrayList3.size()) {
                        i = 0;
                    } else {
                        i = 0;
                        OptionMenu optionMenu4 = new OptionMenu(new Rect(i11, 0, this.mNavigationMenuWidth + i11, this.kHeight), (MenuItem) null, this.mNavigationMenuWidth);
                        optionMenu4.isNext = true;
                        optionMenu4.contentOffset = this.NAVI_NEXT_CONTENT_OFFSET;
                        arrayList4.add(optionMenu4);
                        OptionPopupWindow.this.mOptionPageList.add(arrayList4);
                        ArrayList arrayList5 = new ArrayList();
                        i11 = this.mBGPadding.left;
                        i13 = i2;
                        i14 = 0;
                        arrayList4 = arrayList5;
                        i10 = ((PageInfo) arrayList3.get(i2)).mMenuCount;
                    }
                    i12++;
                    i5 = i;
                }
                OptionPopupWindow.this.mOptionPageList.add(arrayList4);
            }
        }

        private boolean canDrawDivider(ArrayList<OptionMenu> arrayList, int i) {
            if (OptionPopupWindow.this.mAlwaysDrawDivider) {
                return i > 0;
            }
            if (i <= 0 || i >= arrayList.size()) {
                return false;
            }
            OptionMenu optionMenu = arrayList.get(i - 1);
            OptionMenu optionMenu2 = arrayList.get(i);
            if (optionMenu.isPrev || optionMenu2.isNext) {
                return true;
            }
            return optionMenu.menuItem.getGroupId() != optionMenu2.menuItem.getGroupId();
        }

        private void drawOptionItem(Canvas canvas, OptionMenu optionMenu, int i, int i2, int i3, int i4) {
            boolean z = optionMenu.isNext;
            if (z || optionMenu.isPrev) {
                Drawable drawable = z ? this.mNextDrawable : this.mPrevDrawable;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                int dimensionPixelSize = i + OptionPopupWindow.this.mContext.getResources().getDimensionPixelSize(R.dimen.option_popup_navigation_menu_padding);
                int i5 = ((i2 + i4) - intrinsicHeight) / 2;
                drawable.setBounds(dimensionPixelSize, i5, intrinsicWidth + dimensionPixelSize, intrinsicHeight + i5);
                drawable.draw(canvas);
                return;
            }
            MenuItem menuItem = optionMenu.menuItem;
            CharSequence title = menuItem.getTitle();
            if (TextUtils.isEmpty(title)) {
                Drawable icon = menuItem.getIcon();
                if (icon != null) {
                    int i6 = this.mIconWidth;
                    int i7 = ((i + i3) - i6) / 2;
                    int i8 = ((i2 + i4) - i6) / 2;
                    icon.setBounds(i7, i8, i7 + i6, i6 + i8);
                    icon.draw(canvas);
                    return;
                }
                return;
            }
            String charSequence = title.toString();
            float f = (float) ((i3 - i) - (this.ITEM_PADDING * 2));
            float measureText = this.mPaintLabel.measureText(charSequence);
            if (measureText > f) {
                charSequence = getLimitedLabelForDrawing(charSequence, f);
                measureText = this.mPaintLabel.measureText(charSequence);
            }
            Paint.FontMetricsInt fontMetricsInt = this.mFmi;
            int i9 = fontMetricsInt.bottom;
            int i10 = fontMetricsInt.top;
            canvas.drawText(charSequence, (((float) (i + i3)) - measureText) / 2.0f, (((float) ((i4 + i2) - (i9 - i10))) / 2.0f) - ((float) i10), this.mPaintLabel);
        }

        private Bitmap[] getBackgrounds() {
            Canvas canvas = new Canvas();
            try {
                ReflectUtils.from((Object) canvas).method("setNightModeUseOf", Integer.TYPE).invoke(canvas, 2);
            } catch (Exception unused) {
            }
            int measuredHeight = getMeasuredHeight();
            int i = this.mArrowOffsetX;
            int intrinsicWidth = this.mMiddleDrawable.getIntrinsicWidth() + i;
            Bitmap[] access$600 = OptionPopupWindow.getBitmaps(2, this.mContentWidth, this.kHeight);
            for (int i2 = 0; i2 < 2; i2++) {
                int[] iArr = OptionPopupWindow.STATE_SETS[i2];
                Bitmap bitmap = access$600[i2];
                bitmap.eraseColor(0);
                canvas.setBitmap(bitmap);
                this.mLeftDrawable.setState(iArr);
                this.mLeftDrawable.setBounds(0, 0, i, measuredHeight);
                this.mLeftDrawable.draw(canvas);
                this.mMiddleDrawable.setState(iArr);
                this.mMiddleDrawable.setBounds(i, 0, intrinsicWidth, measuredHeight);
                this.mMiddleDrawable.draw(canvas);
                this.mRightDrawable.setState(iArr);
                this.mRightDrawable.setBounds(intrinsicWidth, 0, this.mContentWidth, measuredHeight);
                this.mRightDrawable.draw(canvas);
                if (this.mIsArrowUp) {
                    int[] iArr2 = this.mPixels;
                    if (iArr2 == null || iArr2.length < this.mContentWidth * 2) {
                        this.mPixels = new int[(this.mContentWidth * 2)];
                    }
                    int i3 = measuredHeight >> 1;
                    int i4 = 0;
                    while (i4 < i3) {
                        int i5 = (measuredHeight - i4) - 1;
                        int[] iArr3 = this.mPixels;
                        int i6 = this.mContentWidth;
                        int i7 = i4;
                        Bitmap bitmap2 = bitmap;
                        bitmap.getPixels(iArr3, 0, i6, 0, i7, i6, 1);
                        int[] iArr4 = this.mPixels;
                        int i8 = this.mContentWidth;
                        Bitmap bitmap3 = bitmap2;
                        bitmap3.getPixels(iArr4, i8, i8, 0, i5, i8, 1);
                        int[] iArr5 = this.mPixels;
                        int i9 = this.mContentWidth;
                        bitmap3.setPixels(iArr5, i9, i9, 0, i7, i9, 1);
                        int[] iArr6 = this.mPixels;
                        int i10 = this.mContentWidth;
                        bitmap3.setPixels(iArr6, 0, i10, 0, i5, i10, 1);
                        i4 = i7 + 1;
                        bitmap = bitmap2;
                    }
                }
            }
            return access$600;
        }

        private String getLimitedLabelForDrawing(String str, float f) {
            int length = str.length();
            if (length <= 1) {
                return str;
            }
            do {
                length--;
                if (this.mPaintLabel.measureText(str, 0, length) + this.mSuspensionPointsWidth <= f) {
                    break;
                }
            } while (1 < length);
            return str.substring(0, length) + OptionPopupWindow.SUSPENSION_POINTS;
        }

        private int getMaxWidth() {
            Resources resources = getResources();
            if (resources == null) {
                return 0;
            }
            return resources.getDisplayMetrics().widthPixels;
        }

        private int measureMenuItem(MenuItem menuItem) {
            if (TextUtils.isEmpty(menuItem.getTitle())) {
                Drawable icon = menuItem.getIcon();
                if (icon != null) {
                    return icon.getIntrinsicWidth();
                }
                return 0;
            }
            CharSequence title = menuItem.getTitle();
            return (int) this.mPaintLabel.measureText(title, 0, title.length());
        }

        public int getContentWidth() {
            return this.mContentWidth;
        }

        public void onDraw(Canvas canvas) {
            MenuItem menuItem;
            Canvas canvas2 = canvas;
            if (OptionPopupWindow.this.mActionMode != null) {
                int i = 0;
                int i2 = -1;
                try {
                    ReflectUtils.IReflectClass from = ReflectUtils.from((Object) canvas);
                    i2 = ((Integer) from.method("getNightModeUseOf", new Class[0]).invoke(canvas2, new Object[0])).intValue();
                    from.method("setNightModeUseOf", Integer.TYPE).invoke(canvas2, 3);
                } catch (Exception unused) {
                }
                int i3 = i2;
                OptionPopupWindow.this.mActionMode.getMenu();
                Bitmap[] backgrounds = getBackgrounds();
                if (OptionPopupWindow.this.mCurPageNum >= OptionPopupWindow.this.mOptionPageList.size()) {
                    try {
                        ReflectUtils.from((Object) canvas).method("setNightModeUseOf", Integer.TYPE).invoke(canvas2, Integer.valueOf(i3));
                    } catch (Exception unused2) {
                    }
                } else {
                    ArrayList arrayList = (ArrayList) OptionPopupWindow.this.mOptionPageList.get(OptionPopupWindow.this.mCurPageNum);
                    int size = arrayList.size();
                    new Rect();
                    int i4 = this.offsetX;
                    if (i4 != 0) {
                        canvas2.translate((float) i4, 0.0f);
                    }
                    int i5 = 0;
                    while (i5 < size) {
                        OptionMenu optionMenu = (OptionMenu) arrayList.get(i5);
                        Rect rect = optionMenu.clip;
                        if (i5 == 0) {
                            rect.left = i;
                        }
                        int i6 = size - 1;
                        if (i5 == i6) {
                            rect.right = this.mContentWidth;
                        }
                        int i7 = (this.mActiveIndex == i5 && this.mActionIndex == i5) ? 1 : i;
                        canvas2.drawBitmap(backgrounds[i7], rect, rect, this.mBitmapPaint);
                        if (!(i7 == 0 || (menuItem = optionMenu.menuItem) == null)) {
                            announceForAccessibility(menuItem.getTitle());
                        }
                        if (canDrawDivider(arrayList, i5)) {
                            int intrinsicWidth = this.mSepDrawable.getIntrinsicWidth();
                            int intrinsicHeight = this.mSepDrawable.getIntrinsicHeight();
                            int i8 = rect.left - (intrinsicWidth / 2);
                            int height = rect.height();
                            Rect rect2 = this.mBGPadding;
                            int i9 = rect2.top;
                            int i10 = rect2.bottom;
                            int i11 = (((height - i9) - i10) - intrinsicHeight) / 2;
                            int i12 = i10;
                            if (this.mIsArrowUp) {
                                i9 = i12;
                            }
                            int i13 = i11 + i9;
                            this.mSepDrawable.setBounds(i8, i13, intrinsicWidth + i8, intrinsicHeight + i13);
                            this.mSepDrawable.draw(canvas2);
                        }
                        int i14 = this.mIsArrowUp ? this.mBGPadding.bottom : this.mBGPadding.top;
                        int height2 = getHeight() - (this.mIsArrowUp ? this.mBGPadding.top : this.mBGPadding.bottom);
                        int i15 = rect.left;
                        if (i5 == 0) {
                            i15 += this.mBGPadding.left;
                        }
                        int i16 = rect.right;
                        if (i5 == i6) {
                            i16 -= this.mBGPadding.right;
                        }
                        drawOptionItem(canvas, optionMenu, i15, i14, i16, height2);
                        i5++;
                        i = 0;
                    }
                    int i17 = this.offsetX;
                    if (i17 != 0) {
                        canvas2.translate((float) (-i17), 0.0f);
                    }
                    try {
                        ReflectUtils.from((Object) canvas).method("setNightModeUseOf", Integer.TYPE).invoke(canvas2, Integer.valueOf(i3));
                    } catch (Exception unused3) {
                    }
                }
            }
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
                int action = motionEvent.getAction();
                if (action == 7) {
                    motionEvent.setAction(2);
                } else if (action == 9) {
                    motionEvent.setAction(0);
                } else if (action == 10) {
                    motionEvent.setAction(1);
                }
                onTouchEvent(motionEvent);
                motionEvent.setAction(action);
            }
            return super.onHoverEvent(motionEvent);
        }

        public void onMeasure(int i, int i2) {
            if (OptionPopupWindow.this.mActionMode == null) {
                setMeasuredDimension(0, 0);
                return;
            }
            Rect rect = this.mBGPadding;
            int i3 = rect.left;
            int i4 = rect.right + i3;
            Menu menu = OptionPopupWindow.this.mActionMode.getMenu();
            int size = menu.size();
            int i5 = 1;
            boolean z = getContext().getResources().getConfiguration().getLayoutDirection() == 1;
            if (OptionPopupWindow.this.mOptionPageList.size() == 0) {
                ArrayList arrayList = new ArrayList();
                int i6 = 0;
                while (i6 < size) {
                    int i7 = z ? (size - i6) - i5 : i6;
                    int measureMenuItem = measureMenuItem(menu.getItem(i7)) + (this.ITEM_PADDING * 2);
                    int i8 = this.USER_ITEM_WIDTH_MAX;
                    if (i8 == 0) {
                        i8 = this.ITEM_WIDTH_MAX;
                    }
                    int i9 = this.USER_ITEM_WIDTH_MIN;
                    if (i9 == 0) {
                        i9 = this.ITEM_WIDTH_MIN;
                    }
                    if (measureMenuItem < i9) {
                        measureMenuItem = i9;
                    }
                    if (measureMenuItem <= i8) {
                        i8 = measureMenuItem;
                    }
                    int i10 = i3 + i8;
                    arrayList.add(new OptionMenu(new Rect(i3, 0, i10, this.kHeight), menu.getItem(i7), i8));
                    i6++;
                    i3 = i10;
                    i5 = 1;
                }
                if (arrayList.size() > 0) {
                    calcOptionPage(arrayList);
                }
            }
            if (OptionPopupWindow.this.mOptionPageList.size() > 0 && OptionPopupWindow.this.mCurPageNum < OptionPopupWindow.this.mOptionPageList.size()) {
                Iterator it = ((ArrayList) OptionPopupWindow.this.mOptionPageList.get(OptionPopupWindow.this.mCurPageNum)).iterator();
                while (it.hasNext()) {
                    i4 += ((OptionMenu) it.next()).width;
                }
            }
            int max = Math.max(i4, this.kMinWidth);
            this.mContentWidth = max;
            setMeasuredDimension(max, this.kHeight);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!this.mClickable) {
                return true;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                int calcActiveIndex = calcActiveIndex(motionEvent.getX(), motionEvent.getY());
                this.mActiveIndex = calcActiveIndex;
                this.mActionIndex = calcActiveIndex;
                if (calcActiveIndex >= 0) {
                    invalidate();
                }
            } else if (actionMasked == 1) {
                if (this.mActiveIndex >= 0) {
                    post(this.mClickAction);
                    invalidate();
                }
                this.mActiveIndex = -1;
            } else if (actionMasked == 2) {
                int calcActiveIndex2 = calcActiveIndex(motionEvent.getX(), motionEvent.getY());
                int i = this.mActiveIndex;
                if (i != calcActiveIndex2) {
                    if (i >= 0 || calcActiveIndex2 >= 0) {
                        invalidate();
                    }
                    this.mActiveIndex = calcActiveIndex2;
                    this.mActionIndex = calcActiveIndex2;
                }
            } else if (actionMasked == 3) {
                this.mActiveIndex = -1;
            }
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0055  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int setArrowOffsetX(int r7, int r8) {
            /*
                r6 = this;
                android.graphics.drawable.Drawable r0 = r6.mMiddleDrawable
                int r0 = r0.getIntrinsicWidth()
                int r0 = r0 / 2
                flyme.support.v7.widget.OptionPopupWindow r1 = flyme.support.v7.widget.OptionPopupWindow.this
                int r1 = r1.mCurPageNum
                flyme.support.v7.widget.OptionPopupWindow r2 = flyme.support.v7.widget.OptionPopupWindow.this
                java.util.ArrayList r2 = r2.mOptionPageList
                int r2 = r2.size()
                r3 = 0
                if (r1 >= r2) goto L_0x004a
                flyme.support.v7.widget.OptionPopupWindow r1 = flyme.support.v7.widget.OptionPopupWindow.this
                java.util.ArrayList r1 = r1.mOptionPageList
                flyme.support.v7.widget.OptionPopupWindow r2 = flyme.support.v7.widget.OptionPopupWindow.this
                int r2 = r2.mCurPageNum
                java.lang.Object r1 = r1.get(r2)
                java.util.ArrayList r1 = (java.util.ArrayList) r1
                int r2 = r1.size()
                if (r2 <= 0) goto L_0x004a
                java.lang.Object r2 = r1.get(r3)
                flyme.support.v7.widget.OptionPopupWindow$OptionMenu r2 = (flyme.support.v7.widget.OptionPopupWindow.OptionMenu) r2
                int r3 = r2.width
                int r2 = r1.size()
                int r2 = r2 + -1
                java.lang.Object r1 = r1.get(r2)
                flyme.support.v7.widget.OptionPopupWindow$OptionMenu r1 = (flyme.support.v7.widget.OptionPopupWindow.OptionMenu) r1
                int r1 = r1.width
                goto L_0x004b
            L_0x004a:
                r1 = r3
            L_0x004b:
                int r3 = r3 / 2
                android.graphics.Rect r2 = r6.mBGPadding
                int r4 = r2.left
                int r5 = r3 + r4
                if (r7 >= r5) goto L_0x0057
                int r7 = r3 + r4
            L_0x0057:
                int r1 = r1 / 2
                int r8 = r8 - r1
                int r1 = r2.right
                int r2 = r8 - r1
                if (r7 <= r2) goto L_0x0062
                int r7 = r8 - r1
            L_0x0062:
                int r8 = r7 - r0
                r6.mArrowOffsetX = r8
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.OptionPopupWindow.HandleView.setArrowOffsetX(int, int):int");
        }

        public void setArrowUp(boolean z) {
            if (this.mIsArrowUp != z) {
                this.mIsArrowUp = z;
                if (OptionPopupWindow.this.isShowing()) {
                    postInvalidate();
                }
            }
        }

        public void setOffsetX(int i) {
            if (this.offsetX != i) {
                this.offsetX = i;
                onMeasure(0, 0);
            }
        }
    }

    public class OptionActionMode extends ActionMode implements MenuBuilder.Callback {
        private ActionMode.Callback mCallback;
        /* access modifiers changed from: private */
        public MenuBuilder mMenu;

        public OptionActionMode(ActionMode.Callback callback) {
            MenuBuilder menuBuilder = new MenuBuilder(OptionPopupWindow.this.mContext);
            this.mMenu = menuBuilder;
            menuBuilder.setCallback(this);
            this.mCallback = callback;
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                return this.mCallback.onCreateActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public void finish() {
            if (OptionPopupWindow.this.mActionMode == this) {
                OptionPopupWindow.this.dismiss();
                this.mCallback.onDestroyActionMode(this);
                this.mCallback = null;
                OptionActionMode unused = OptionPopupWindow.this.mActionMode = null;
            }
        }

        public View getCustomView() {
            return null;
        }

        public Menu getMenu() {
            return this.mMenu;
        }

        public MenuInflater getMenuInflater() {
            return new MenuInflater(OptionPopupWindow.this.mContext);
        }

        public CharSequence getSubtitle() {
            return null;
        }

        public CharSequence getTitle() {
            return null;
        }

        public void invalidate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                this.mCallback.onPrepareActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            ActionMode.Callback callback = this.mCallback;
            if (callback != null) {
                return callback.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }

        public void setCustomView(View view) {
        }

        public void setSubtitle(int i) {
        }

        public void setTitle(int i) {
        }

        public void setSubtitle(CharSequence charSequence) {
        }

        public void setTitle(CharSequence charSequence) {
        }
    }

    public class OptionMenu {
        public Rect clip;
        @Deprecated
        public int contentOffset;
        public boolean isNext = false;
        public boolean isPrev = false;
        public int mPageNum = 0;
        public MenuItem menuItem;
        public int width;

        public OptionMenu(Rect rect, MenuItem menuItem2, int i) {
            this.clip = rect;
            this.menuItem = menuItem2;
            this.width = i;
        }
    }

    public class PageInfo {
        int mMenuCount;

        public PageInfo(int i) {
            this.mMenuCount = i;
        }
    }

    static {
        int[][] iArr = new int[2][];
        STATE_SETS = iArr;
        iArr[0] = new int[]{16842921};
        iArr[1] = new int[]{16842919};
    }

    public OptionPopupWindow(Context context) {
        super(context);
        this.mContext = context;
        setTouchable(true);
        setOutsideTouchable(true);
        setClippingEnabled(false);
        setWindowLayoutMode(-2, -2);
        setInputMethodMode(2);
        setUperWindowLayoutType(1002);
        setBackgroundDrawable(new ColorDrawable(0));
        HandleView handleView = new HandleView(this.mContext);
        this.mHandleView = handleView;
        setContentView(handleView);
        super.setOnDismissListener(this);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mWindowRect = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        setAlwaysDrawDivider(true);
    }

    public static /* synthetic */ int access$208(OptionPopupWindow optionPopupWindow) {
        int i = optionPopupWindow.mCurPageNum;
        optionPopupWindow.mCurPageNum = i + 1;
        return i;
    }

    public static /* synthetic */ int access$210(OptionPopupWindow optionPopupWindow) {
        int i = optionPopupWindow.mCurPageNum;
        optionPopupWindow.mCurPageNum = i - 1;
        return i;
    }

    private void clearBitmap() {
        if (sTmpBitmaps != null) {
            int i = 0;
            while (true) {
                Bitmap[] bitmapArr = sTmpBitmaps;
                if (i < bitmapArr.length) {
                    Bitmap bitmap = bitmapArr[i];
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    sTmpBitmaps[i] = null;
                    i++;
                } else {
                    sTmpBitmaps = null;
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static Bitmap[] getBitmaps(int i, int i2, int i3) {
        Bitmap[] bitmapArr = sTmpBitmaps;
        if (bitmapArr == null) {
            sTmpBitmaps = new Bitmap[i];
        } else if (bitmapArr.length < i) {
            sTmpBitmaps = (Bitmap[]) Arrays.copyOf(bitmapArr, i);
        }
        for (int i4 = 0; i4 < i; i4++) {
            Bitmap bitmap = sTmpBitmaps[i4];
            if (bitmap == null || bitmap.getWidth() < i2 || bitmap.getHeight() < i3) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
                bitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            }
            sTmpBitmaps[i4] = bitmap;
        }
        return sTmpBitmaps;
    }

    private boolean isSplitMode() {
        try {
            Object obj2 = obj;
            if (obj2 == null) {
                Class<?> cls = Class.forName("meizu.splitmode.FlymeSplitModeManager");
                Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[]{Context.class});
                declaredMethod.setAccessible(true);
                obj = declaredMethod.invoke(this.mContext, (Object[]) null);
                Method declaredMethod2 = cls.getDeclaredMethod("isSplitMode", (Class[]) null);
                method = declaredMethod2;
                declaredMethod2.setAccessible(true);
                return ((Boolean) method.invoke(obj, (Object[]) null)).booleanValue();
            }
            Method method2 = method;
            if (method2 != null) {
                return ((Boolean) method2.invoke(obj2, (Object[]) null)).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void disableAlignBottom(boolean z) {
        this.mDisableAlignBottom = z;
    }

    public void onDismiss() {
        this.mCurPageNum = 0;
        clearBitmap();
        PopupWindow.OnDismissListener onDismissListener = this.mOptionPopupDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void setAlwaysDrawDivider(boolean z) {
        this.mAlwaysDrawDivider = z;
    }

    public void setClickable(boolean z) {
        this.mHandleView.mClickable = z;
    }

    public void setGravity(int i) {
        this.mGravity = i;
    }

    public void setItemMaxWidth(int i) {
        this.mHandleView.USER_ITEM_WIDTH_MAX = i;
    }

    public void setItemMinWidth(int i) {
        this.mHandleView.USER_ITEM_WIDTH_MIN = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOptionPopupDismissListener = onDismissListener;
    }

    public void setUperWindowLayoutType(int i) {
        try {
            if (clazz == null) {
                Class<PopupWindow> cls = PopupWindow.class;
                clazz = cls;
                Method declaredMethod = cls.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                uperWindowLayoutTypeMethod = declaredMethod;
                declaredMethod.setAccessible(true);
                uperWindowLayoutTypeMethod.invoke(this, new Object[]{Integer.valueOf(i)});
            } else if (method != null) {
                uperWindowLayoutTypeMethod.invoke(this, new Object[]{Integer.valueOf(i)});
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0192  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean showOptions(android.view.View r14, android.graphics.RectF r15) {
        /*
            r13 = this;
            android.view.View r0 = r13.mParent
            r1 = 0
            if (r14 != r0) goto L_0x019d
            flyme.support.v7.widget.OptionPopupWindow$OptionActionMode r14 = r13.mActionMode
            if (r14 != 0) goto L_0x000b
            goto L_0x019d
        L_0x000b:
            android.graphics.Rect r14 = r13.mWndRect
            if (r14 != 0) goto L_0x0016
            android.graphics.Rect r14 = new android.graphics.Rect
            r14.<init>()
            r13.mWndRect = r14
        L_0x0016:
            android.graphics.Rect r14 = r13.mWndRect
            android.view.View r0 = r13.mParent
            r0.getWindowVisibleDisplayFrame(r14)
            int r0 = r14.left
            android.graphics.Rect r2 = r13.mWindowRect
            int r3 = r2.left
            if (r0 < r3) goto L_0x0037
            int r0 = r14.top
            int r3 = r2.top
            if (r0 < r3) goto L_0x0037
            int r0 = r14.right
            int r3 = r2.right
            if (r0 > r3) goto L_0x0037
            int r0 = r14.bottom
            int r3 = r2.bottom
            if (r0 <= r3) goto L_0x0038
        L_0x0037:
            r14 = r2
        L_0x0038:
            android.content.Context r0 = r13.mContext
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.heightPixels
            int r2 = r14.top
            if (r2 >= 0) goto L_0x004a
            r14.top = r1
        L_0x004a:
            int r2 = r14.bottom
            if (r2 <= r0) goto L_0x0050
            r14.bottom = r0
        L_0x0050:
            r0 = 2
            int[] r2 = new int[r0]
            android.view.View r3 = r13.mParent
            r3.getLocationOnScreen(r2)
            android.graphics.RectF r3 = new android.graphics.RectF
            r3.<init>(r15)
            r13.mRectF = r3
            r3 = r2[r1]
            float r3 = (float) r3
            r4 = 1
            r5 = r2[r4]
            float r5 = (float) r5
            r15.offset(r3, r5)
            boolean r3 = r13.isSplitMode()
            if (r3 != 0) goto L_0x007b
            float r3 = r15.top
            int r5 = r14.top
            float r6 = (float) r5
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x007b
            float r3 = (float) r5
            r15.top = r3
        L_0x007b:
            float r3 = r15.bottom
            int r5 = r14.bottom
            float r6 = (float) r5
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x0087
            float r3 = (float) r5
            r15.bottom = r3
        L_0x0087:
            flyme.support.v7.widget.OptionPopupWindow$HandleView r3 = r13.mHandleView
            r3.onMeasure(r1, r1)
            flyme.support.v7.widget.OptionPopupWindow$HandleView r3 = r13.mHandleView
            int r3 = r3.getContentWidth()
            flyme.support.v7.widget.OptionPopupWindow$HandleView r5 = r13.mHandleView
            int r5 = r5.getMeasuredHeight()
            int r6 = r14.top
            int r6 = r6 + r5
            float r6 = (float) r6
            float r7 = r15.top
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            r7 = 48
            if (r6 > 0) goto L_0x00b6
            int r6 = r14.centerY()
            float r6 = (float) r6
            float r8 = r15.top
            int r9 = r5 >> 1
            float r9 = (float) r9
            float r8 = r8 - r9
            float r6 = r6 - r8
            float r6 = java.lang.Math.abs(r6)
            r8 = r7
            goto L_0x00ba
        L_0x00b6:
            r6 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r8 = r1
        L_0x00ba:
            boolean r9 = r13.mDisableAlignBottom
            r10 = 80
            if (r9 != 0) goto L_0x00df
            int r9 = r14.bottom
            int r9 = r9 - r5
            float r9 = (float) r9
            float r11 = r15.bottom
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 <= 0) goto L_0x00df
            int r9 = r14.centerY()
            float r9 = (float) r9
            float r11 = r15.bottom
            int r12 = r5 >> 1
            float r12 = (float) r12
            float r11 = r11 + r12
            float r9 = r9 - r11
            float r9 = java.lang.Math.abs(r9)
            int r6 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x00df
            r8 = r10
        L_0x00df:
            if (r8 != 0) goto L_0x00f8
            float r6 = r15.top
            int r9 = r14.top
            float r9 = (float) r9
            float r6 = r6 - r9
            int r9 = r14.bottom
            float r9 = (float) r9
            float r11 = r15.bottom
            float r9 = r9 - r11
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x00f3
            r8 = r7
            goto L_0x00f8
        L_0x00f3:
            boolean r6 = r13.mDisableAlignBottom
            if (r6 != 0) goto L_0x00f8
            r8 = r10
        L_0x00f8:
            int r6 = r13.mGravity
            if (r6 == 0) goto L_0x00fd
            r8 = r6
        L_0x00fd:
            if (r8 != r7) goto L_0x0109
            flyme.support.v7.widget.OptionPopupWindow$HandleView r6 = r13.mHandleView
            r6.setArrowUp(r1)
            float r6 = r15.top
        L_0x0106:
            float r7 = (float) r5
            float r6 = r6 - r7
            goto L_0x011b
        L_0x0109:
            if (r8 != r10) goto L_0x0113
            flyme.support.v7.widget.OptionPopupWindow$HandleView r6 = r13.mHandleView
            r6.setArrowUp(r4)
            float r6 = r15.bottom
            goto L_0x011b
        L_0x0113:
            flyme.support.v7.widget.OptionPopupWindow$HandleView r6 = r13.mHandleView
            r6.setArrowUp(r1)
            float r6 = r15.top
            goto L_0x0106
        L_0x011b:
            boolean r7 = r13.isSplitMode()
            if (r7 != 0) goto L_0x0129
            int r7 = r14.top
            float r8 = (float) r7
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x0129
            float r6 = (float) r7
        L_0x0129:
            float r15 = r15.centerX()
            int r15 = (int) r15
            int r7 = r14.width()
            int r7 = r7 / r0
            if (r15 > r7) goto L_0x013b
            int r7 = r3 / 2
            if (r15 >= r7) goto L_0x014e
            r7 = r15
            goto L_0x014e
        L_0x013b:
            int r7 = r14.width()
            int r7 = r7 - r15
            int r8 = r3 / 2
            if (r7 >= r8) goto L_0x014d
            int r8 = r8 + r8
            int r7 = r14.width()
            int r7 = r7 - r15
            int r7 = r8 - r7
            goto L_0x014e
        L_0x014d:
            r7 = r8
        L_0x014e:
            flyme.support.v7.widget.OptionPopupWindow$HandleView r8 = r13.mHandleView
            int r7 = r8.setArrowOffsetX(r7, r3)
            int r15 = r15 - r7
            if (r15 >= 0) goto L_0x0158
            r15 = r1
        L_0x0158:
            int r7 = r14.width()
            int r7 = r7 - r3
            if (r15 <= r7) goto L_0x0164
            int r15 = r14.width()
            int r15 = r15 - r3
        L_0x0164:
            float r7 = (float) r5
            float r7 = r7 + r6
            int r8 = r14.bottom
            float r8 = (float) r8
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 <= 0) goto L_0x0170
            int r14 = r14.top
            float r6 = (float) r14
        L_0x0170:
            int[] r14 = new int[r0]
            android.view.View r0 = r13.mParent
            r0.getLocationInWindow(r14)
            r0 = r2[r4]
            r7 = r14[r4]
            int r0 = r0 - r7
            float r0 = (float) r0
            float r6 = r6 - r0
            r0 = r2[r1]
            r14 = r14[r1]
            int r0 = r0 - r14
            int r15 = r15 - r0
            boolean r14 = r13.isShowing()
            if (r14 == 0) goto L_0x0192
            r13.setWindowLayoutMode(r1, r1)
            int r14 = (int) r6
            r13.update(r15, r14, r3, r5)
            goto L_0x019c
        L_0x0192:
            r14 = -2
            r13.setWindowLayoutMode(r14, r14)
            android.view.View r14 = r13.mParent
            int r0 = (int) r6
            r13.showAtLocation(r14, r1, r15, r0)
        L_0x019c:
            return r4
        L_0x019d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.OptionPopupWindow.showOptions(android.view.View, android.graphics.RectF):boolean");
    }

    public ActionMode startPopupActionMode(View view, ActionMode.Callback callback) {
        this.mParent = view;
        OptionActionMode optionActionMode = this.mActionMode;
        if (optionActionMode != null) {
            optionActionMode.finish();
        }
        OptionActionMode optionActionMode2 = new OptionActionMode(callback);
        if (!optionActionMode2.dispatchOnCreate()) {
            return null;
        }
        optionActionMode2.invalidate();
        this.mActionMode = optionActionMode2;
        this.mOptionPageList.clear();
        this.mCurPageNum = 0;
        return optionActionMode2;
    }

    public void updateWindow() {
        RectF rectF;
        View view = this.mParent;
        if (view != null && (rectF = this.mRectF) != null) {
            showOptions(view, rectF);
        }
    }
}

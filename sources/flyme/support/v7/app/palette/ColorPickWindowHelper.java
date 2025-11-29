package flyme.support.v7.app.palette;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import com.honey.account.ua.a;
import com.meizu.common.util.ResourceUtils;
import flyme.support.v7.app.palette.FlymePalettePopupActivity;
import flyme.support.v7.appcompat.R;
import java.lang.reflect.Array;

public final class ColorPickWindowHelper {
    @SuppressLint({"StaticFieldLeak"})
    private static ColorPickWindowHelper mInstance;
    /* access modifiers changed from: private */
    public float initialTouchX;
    /* access modifiers changed from: private */
    public float initialTouchY;
    /* access modifiers changed from: private */
    public float initialX;
    /* access modifiers changed from: private */
    public float initialY;
    /* access modifiers changed from: private */
    public View mBkgView;
    private ColorGridView mColorGridView;
    /* access modifiers changed from: private */
    public View mFloatingView;
    /* access modifiers changed from: private */
    public int mHeight;
    private int mPickColor;
    private ShapeDrawable mPickColorDrawable;
    /* access modifiers changed from: private */
    public Bitmap mScreenShot;
    /* access modifiers changed from: private */
    public int mWidth;
    /* access modifiers changed from: private */
    public WindowManager mWindowManager;

    private ColorPickWindowHelper() {
    }

    private int[][] getGridColorsInBmp(int i, int i2) {
        int i3 = i - 3;
        int i4 = i + 3;
        int i5 = i2 - 3;
        int i6 = i2 + 3;
        int[] iArr = new int[2];
        iArr[1] = 7;
        iArr[0] = 7;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        for (int i7 = i5; i7 <= i6; i7++) {
            for (int i8 = i3; i8 <= i4; i8++) {
                iArr2[i7 - i5][i8 - i3] = this.mScreenShot.getPixel(i8, i7);
            }
        }
        return iArr2;
    }

    public static ColorPickWindowHelper getInstance() {
        if (mInstance == null) {
            mInstance = new ColorPickWindowHelper();
        }
        return mInstance;
    }

    /* access modifiers changed from: private */
    public boolean isTouchInsideView(float f, float f2, View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        rect.left = i;
        rect.top = iArr[1];
        rect.right = i + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        return rect.contains((int) f, (int) f2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showColorPickWindow$0(int[] iArr) {
        this.mBkgView.getLocationOnScreen(iArr);
        updatePickView(iArr);
    }

    /* access modifiers changed from: private */
    public void updatePickView(int[] iArr) {
        int[][] gridColorsInBmp = getGridColorsInBmp(iArr[0] + (this.mWidth / 2), iArr[1] + (this.mHeight / 2));
        this.mColorGridView.setColors(gridColorsInBmp);
        int i = gridColorsInBmp[3][3];
        this.mPickColor = i;
        this.mPickColorDrawable.setTint(i);
    }

    public int getPickColor() {
        return this.mPickColor;
    }

    public void release() {
        if (this.mFloatingView.isAttachedToWindow()) {
            this.mWindowManager.removeView(this.mFloatingView);
            this.mScreenShot.recycle();
        }
    }

    public void setScreenShotBmp(Bitmap bitmap) {
        this.mScreenShot = bitmap;
    }

    @RequiresApi
    @SuppressLint({"InflateParams"})
    public void showColorPickWindow(Context context, FlymePalettePopupActivity.OnColorPickListener onColorPickListener) {
        final Context applicationContext = context.getApplicationContext();
        this.mWindowManager = (WindowManager) applicationContext.getSystemService("window");
        int dp2px = (int) ResourceUtils.dp2px(130.0f, applicationContext);
        this.mHeight = dp2px;
        this.mWidth = dp2px;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2038, 8, -3);
        View inflate = LayoutInflater.from(applicationContext).inflate(R.layout.layout_my_window, (ViewGroup) null);
        this.mFloatingView = inflate;
        this.mColorGridView = (ColorGridView) inflate.findViewById(R.id.scale_magnifier);
        this.mBkgView = this.mFloatingView.findViewById(R.id.out_bkg);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        this.mPickColorDrawable = shapeDrawable;
        shapeDrawable.setIntrinsicWidth(this.mWidth);
        this.mPickColorDrawable.setIntrinsicHeight(this.mHeight);
        this.mBkgView.setBackground(this.mPickColorDrawable);
        this.mWindowManager.addView(this.mFloatingView, layoutParams);
        final int[] iArr = new int[2];
        this.mBkgView.post(new a(this, iArr));
        final Context context2 = context;
        final FlymePalettePopupActivity.OnColorPickListener onColorPickListener2 = onColorPickListener;
        this.mFloatingView.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        ColorPickWindowHelper.this.mWindowManager.removeView(ColorPickWindowHelper.this.mFloatingView);
                        FlymePalettePopupActivity.startWithPickColor(applicationContext, ColorPickWindowHelper.this.getPickColor());
                        onColorPickListener2.onColorPickSelected(ColorPickWindowHelper.this.getPickColor());
                    } else if (action == 2) {
                        float access$000 = ColorPickWindowHelper.this.initialX + (motionEvent.getRawX() - ColorPickWindowHelper.this.initialTouchX);
                        float access$200 = ColorPickWindowHelper.this.initialY + (motionEvent.getRawY() - ColorPickWindowHelper.this.initialTouchY);
                        ColorPickWindowHelper.this.mBkgView.getLocationOnScreen(iArr);
                        ColorPickWindowHelper.this.mBkgView.setX(access$000);
                        ColorPickWindowHelper.this.mBkgView.setY(access$200);
                        int access$600 = iArr[0] + (ColorPickWindowHelper.this.mWidth / 2);
                        int access$700 = iArr[1] + (ColorPickWindowHelper.this.mHeight / 2);
                        if (access$600 > 4 && access$600 < ColorPickWindowHelper.this.mScreenShot.getWidth() - 4 && access$700 > 4 && access$700 < ColorPickWindowHelper.this.mScreenShot.getHeight() - 4) {
                            ColorPickWindowHelper.this.updatePickView(iArr);
                            onColorPickListener2.onColorPickDragged(ColorPickWindowHelper.this.getPickColor());
                        }
                    }
                    return true;
                }
                ColorPickWindowHelper colorPickWindowHelper = ColorPickWindowHelper.this;
                float unused = colorPickWindowHelper.initialX = colorPickWindowHelper.mBkgView.getX();
                ColorPickWindowHelper colorPickWindowHelper2 = ColorPickWindowHelper.this;
                float unused2 = colorPickWindowHelper2.initialY = colorPickWindowHelper2.mBkgView.getY();
                float unused3 = ColorPickWindowHelper.this.initialTouchX = motionEvent.getRawX();
                float unused4 = ColorPickWindowHelper.this.initialTouchY = motionEvent.getRawY();
                ColorPickWindowHelper colorPickWindowHelper3 = ColorPickWindowHelper.this;
                if (colorPickWindowHelper3.isTouchInsideView(colorPickWindowHelper3.initialTouchX, ColorPickWindowHelper.this.initialTouchY, ColorPickWindowHelper.this.mBkgView)) {
                    return true;
                }
                float access$300 = ColorPickWindowHelper.this.initialTouchX - (ColorPickWindowHelper.this.initialX + ((float) (ColorPickWindowHelper.this.mBkgView.getWidth() / 2)));
                float access$400 = ColorPickWindowHelper.this.initialTouchY - (((ColorPickWindowHelper.this.initialY + ((float) (ColorPickWindowHelper.this.mBkgView.getHeight() / 2))) + ((float) ResourceUtils.getStatusBarHeight(context2))) + ResourceUtils.dp2px(48.0f, context2));
                ColorPickWindowHelper.this.mBkgView.setX(ColorPickWindowHelper.this.initialX + access$300);
                ColorPickWindowHelper.this.mBkgView.setY(ColorPickWindowHelper.this.initialY + access$400);
                ColorPickWindowHelper colorPickWindowHelper4 = ColorPickWindowHelper.this;
                float unused5 = colorPickWindowHelper4.initialX = colorPickWindowHelper4.mBkgView.getX();
                ColorPickWindowHelper colorPickWindowHelper5 = ColorPickWindowHelper.this;
                float unused6 = colorPickWindowHelper5.initialY = colorPickWindowHelper5.mBkgView.getY();
                return true;
            }
        });
    }
}

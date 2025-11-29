package com.meizu.common.drawble;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.meizu.common.R;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactHeaderDrawable extends Drawable {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int COLOR_DRAWABLE_DIMENSION = 2;
    private static final int DEFAULT_BG_COLOR = -11227562;
    private static final int DEFAULT_BORDER_COLOR = -1;
    private static final int MAX_COUNT = 3;
    private static final int[] colorArray = {-148165, -435152, -1169103, -10464278, -14315542, -14565170, -12402834};
    private static final String mEnglishFirstLetters = "\\b[a-zA-Z]";
    private static final String mRegExChinese = "[一-龥]";
    private static final String mRegExChineseText = "([一-龥]+)";
    private static final String mRegExEnglish = "[a-zA-Z]";
    private static final String mRegExNumber = "\\d";
    private static final String mSpace = " ";
    private static Method sMethodSetNightModeUseOf;
    private final Paint mBitmapPaint = new Paint();
    private final Rect mBounds = new Rect();
    private final Header[] mHeaders = new Header[3];
    private int mIntrinsicHeight;
    private int mIntrinsicWidth;
    private final Paint mTextPaint = new Paint();

    public static class Header {
        private final Path bitmapClip = new Path();
        private final RectF bitmapRect = new RectF();
        public int mBackgroundColor;
        public Bitmap mBitmap;
        public int mBorderColor;
        public int mBorderWidth;
        public Drawable mDefaultIcon;
        private final RectF mHeaderRect = new RectF();
        private final Matrix mMatrix = new Matrix();
        public float mOffsetX;
        private final Resources mResources;
        public float mSizeScale;
        public String mText;
        public int mTextColor = -1;
        private float mTextScale = 1.0f;

        public Header(Resources resources) {
            this.mResources = resources;
        }

        private void dealHeaderRect(Rect rect) {
            float min = (float) Math.min(rect.width(), rect.height());
            float f = this.mSizeScale * min;
            float f2 = this.mResources.getDisplayMetrics().density;
            this.mHeaderRect.set(0.0f, 0.0f, f, f);
            this.mHeaderRect.offset(0.0f, (((float) rect.height()) - f) / 2.0f);
            this.mHeaderRect.offset(this.mOffsetX * min, 0.0f);
            if (Float.compare(this.mSizeScale, 1.0f) == 0) {
                this.mBorderWidth = 0;
                this.mBorderColor = 0;
            }
            this.mTextScale = this.mHeaderRect.width() / (f2 * 40.0f);
            this.mHeaderRect.inset(getScaleBorderWidth() / 2.0f, getScaleBorderWidth() / 2.0f);
        }

        private void drawBackground(Canvas canvas, Paint paint) {
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            int color = paint.getColor();
            paint.setColor(this.mBackgroundColor);
            canvas.drawOval(this.mHeaderRect, paint);
            paint.setColor(color);
        }

        private void drawBitmap(Canvas canvas, Paint paint) {
            this.bitmapClip.reset();
            this.mMatrix.reset();
            this.bitmapRect.set(0.0f, 0.0f, (float) this.mBitmap.getWidth(), (float) this.mBitmap.getHeight());
            this.mMatrix.setRectToRect(this.bitmapRect, this.mHeaderRect, Matrix.ScaleToFit.FILL);
            canvas.save();
            this.bitmapClip.addCircle(this.mHeaderRect.centerX(), this.mHeaderRect.centerY(), (this.mHeaderRect.width() - getScaleBorderWidth()) / 2.0f, Path.Direction.CCW);
            canvas.clipPath(this.bitmapClip);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, paint);
            canvas.restore();
        }

        private void drawBorder(Canvas canvas, Paint paint) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            int color = paint.getColor();
            float strokeWidth = paint.getStrokeWidth();
            paint.setColor(this.mBorderColor);
            paint.setStrokeWidth(getScaleBorderWidth());
            paint.setShader((Shader) null);
            canvas.drawOval(this.mHeaderRect, paint);
            paint.setColor(color);
            paint.setStrokeWidth(strokeWidth);
        }

        private float getScaleBorderWidth() {
            return ((float) this.mBorderWidth) * Math.max(1.0f, this.mTextScale);
        }

        public void draw(Canvas canvas, Rect rect, Paint paint, Paint paint2) {
            dealHeaderRect(rect);
            drawBackground(canvas, paint);
            drawBorder(canvas, paint);
            if (!TextUtils.isEmpty(this.mText)) {
                int dimensionPixelSize = this.mText.length() == 1 ? this.mResources.getDimensionPixelSize(R.dimen.avatar_name_char_one) : this.mResources.getDimensionPixelSize(R.dimen.avatar_name_char_two);
                paint2.setColor(this.mTextColor);
                paint2.setTextSize(((float) dimensionPixelSize) * this.mTextScale);
                canvas.drawText(this.mText, this.mHeaderRect.centerX() - (paint2.measureText(this.mText) / 2.0f), this.mHeaderRect.centerY() - ((paint2.descent() + paint2.ascent()) / 2.0f), paint2);
            } else if (this.mBitmap != null) {
                drawBitmap(canvas, paint);
            } else {
                Drawable drawable = this.mDefaultIcon;
                if (drawable != null) {
                    RectF rectF = this.mHeaderRect;
                    drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    this.mDefaultIcon.draw(canvas);
                }
            }
        }
    }

    public ContactHeaderDrawable(Resources resources) {
        initPaint();
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private Header createDefaultHeader(Resources resources, int i, Object obj, int i2) {
        Header header = new Header(resources);
        header.mBorderColor = i2;
        header.mBorderWidth = i;
        header.mDefaultIcon = resources.getDrawable(R.drawable.mz_contact_list_picture);
        header.mSizeScale = 1.0f;
        header.mBackgroundColor = parseBackgroundColor(obj);
        return header;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private Header createHeader(Resources resources, int i, float f, Object obj, Object obj2, int i2) {
        Header header = new Header(resources);
        header.mBorderColor = i2;
        header.mBorderWidth = i;
        header.mSizeScale = f;
        if (obj instanceof String) {
            String headerText = getHeaderText((String) obj);
            header.mText = headerText;
            if (TextUtils.isEmpty(headerText)) {
                header.mDefaultIcon = resources.getDrawable(R.drawable.mz_contact_list_picture);
            }
        } else if (obj instanceof Bitmap) {
            header.mBitmap = (Bitmap) obj;
        } else if (obj instanceof Drawable) {
            header.mBitmap = getBitmapFromDrawable((Drawable) obj);
        } else {
            header.mDefaultIcon = resources.getDrawable(R.drawable.mz_contact_list_picture);
        }
        if (obj2 != null) {
            header.mBackgroundColor = parseBackgroundColor(obj2);
        } else if (TextUtils.isEmpty(header.mText)) {
            header.mBackgroundColor = getColorByText(header.mText);
        } else {
            header.mBackgroundColor = DEFAULT_BG_COLOR;
        }
        return header;
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            return drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, BITMAP_CONFIG) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
        } catch (OutOfMemoryError unused) {
            Log.e("ContactHeaderUtils ", "getBitmapFromDrawable  OutOfMemoryError !");
            return null;
        }
    }

    private int getChineseCount(String str) {
        Matcher matcher = Pattern.compile(mRegExChinese).matcher(str);
        int i = 0;
        while (matcher.find()) {
            i++;
        }
        return i;
    }

    private String getChineseStr(String str) {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = Pattern.compile(mRegExChineseText).matcher(str);
        while (matcher.find()) {
            sb.append(matcher.group());
        }
        return sb.toString();
    }

    private int getColorByText(String str) {
        return colorArray[!TextUtils.isEmpty(str) ? Math.abs(str.hashCode()) % colorArray.length : 5];
    }

    public static int getEnglishCount(String str) {
        int i = 0;
        while (Pattern.compile(mRegExEnglish).matcher(str).find()) {
            i++;
        }
        return i;
    }

    private String getEnglishFirstLetters(String str) {
        String replaceAll = Pattern.compile(mRegExNumber).matcher(str).replaceAll(" ");
        StringBuilder sb = new StringBuilder();
        Matcher matcher = Pattern.compile(mEnglishFirstLetters).matcher(replaceAll);
        while (matcher.find()) {
            sb.append(matcher.group());
        }
        return sb.toString().toUpperCase();
    }

    private String getHeaderText(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String chineseStr = getChineseStr(str);
        if (isChinese(chineseStr)) {
            int chineseCount = getChineseCount(chineseStr);
            return chineseCount < 2 ? chineseStr : chineseCount == 2 ? (str.length() != chineseStr.length() && !str.contains(chineseStr)) ? chineseStr.substring(chineseStr.length() - 2) : chineseStr : chineseStr.substring(chineseStr.length() - 2);
        } else if (!isEnglish(str.substring(0, 1))) {
            return "";
        } else {
            String englishFirstLetters = getEnglishFirstLetters(str);
            if (getEnglishCount(englishFirstLetters) <= 2) {
                return englishFirstLetters;
            }
            return englishFirstLetters.charAt(0) + englishFirstLetters.substring(englishFirstLetters.length() - 1);
        }
    }

    private void initPaint() {
        this.mBitmapPaint.setFlags(2);
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setFilterBitmap(true);
        this.mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setColor(DEFAULT_BG_COLOR);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTypeface(Typeface.create(Typeface.create("sans-serif-medium", 0), 500, false));
    }

    public static boolean isChinese(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (c >= 19968 && c <= 40869) {
                return true;
            }
        }
        return false;
    }

    private boolean isEnglish(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                return true;
            }
            if (c >= 'A' && c <= 'Z') {
                return true;
            }
        }
        return false;
    }

    private int parseBackgroundColor(Object obj) {
        return obj instanceof String ? getColorByText((String) obj) : DEFAULT_BG_COLOR;
    }

    private void parseContent(Resources resources, Object[] objArr, Object[] objArr2, int i) {
        Resources resources2 = resources;
        Object[] objArr3 = objArr;
        Object[] objArr4 = objArr2;
        int i2 = i;
        int min = Math.min(objArr3 != null ? objArr3.length : 1, 3);
        int i3 = ((int) resources.getDisplayMetrics().density) + 1;
        int i4 = min - 1;
        float f = 1.0f - (((float) i4) / 6.0f);
        if (objArr3 == null || objArr3.length == 0) {
            Header createDefaultHeader = (objArr4 == null || objArr4.length == 0) ? createDefaultHeader(resources2, i3, Integer.valueOf(colorArray[5]), i2) : createDefaultHeader(resources2, i3, objArr4[0], i2);
            createDefaultHeader.mSizeScale = 1.0f;
            createDefaultHeader.mOffsetX = 0.0f;
            this.mHeaders[0] = createDefaultHeader;
            return;
        }
        int i5 = i4;
        while (i5 >= 0) {
            int i6 = i5;
            Header createHeader = createHeader(resources, i3, f, objArr3[i5], objArr4.length > i5 ? objArr4[i5] : null, i);
            createHeader.mSizeScale = f;
            createHeader.mOffsetX = (((float) i6) * 1.0f) / 6.0f;
            this.mHeaders[i6] = createHeader;
            i5 = i6 - 1;
        }
    }

    private void setNightModeUse(Canvas canvas) {
        try {
            if (sMethodSetNightModeUseOf == null) {
                sMethodSetNightModeUseOf = Canvas.class.getDeclaredMethod("setNightModeUseOf", new Class[]{Integer.TYPE});
            }
            sMethodSetNightModeUseOf.invoke(canvas, new Object[]{2});
        } catch (Exception unused) {
        }
    }

    public void draw(@NonNull Canvas canvas) {
        setNightModeUse(canvas);
        for (int length = this.mHeaders.length - 1; length >= 0; length--) {
            Header header = this.mHeaders[length];
            if (header != null) {
                header.draw(canvas, this.mBounds, this.mBitmapPaint, this.mTextPaint);
            }
        }
    }

    public int getIntrinsicHeight() {
        return this.mIntrinsicHeight;
    }

    public int getIntrinsicWidth() {
        return this.mIntrinsicWidth;
    }

    public int getOpacity() {
        return this.mTextPaint.getAlpha();
    }

    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.mBounds.set(rect);
    }

    public void setAlpha(int i) {
        this.mBitmapPaint.setAlpha(i);
        this.mTextPaint.setAlpha(i);
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mBitmapPaint.setColorFilter(colorFilter);
        this.mTextPaint.setColorFilter(colorFilter);
    }

    public void setContent(Resources resources, int i, int i2, Object[] objArr, Object[] objArr2, int i3) {
        float f = resources.getDisplayMetrics().density;
        this.mIntrinsicHeight = (int) (((float) i) * f);
        this.mIntrinsicWidth = (int) (((float) i2) * f);
        parseContent(resources, objArr, objArr2, i3);
    }

    public ContactHeaderDrawable(Resources resources, int i, int i2, Object[] objArr, Object[] objArr2, int i3) {
        initPaint();
        setContent(resources, i, i2, objArr, objArr2, i3);
    }
}

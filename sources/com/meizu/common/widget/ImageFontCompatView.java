package com.meizu.common.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.meizu.common.R;
import com.meizu.common.util.FontLoader;
import com.meizu.common.util.ResourceUtils;
import com.meizu.common.util.ThemeUtil;
import com.xjsd.ai.assistant.protocol.CmdCode;

public class ImageFontCompatView extends FrameLayout {
    private static final String ASSET_PATH_DEFAULT = "ImageFont.ttf";
    private static final boolean DEBUG = false;
    private static final int DEFAULT_TEXT_COLOR_IF_FONT = -16777216;
    private static final int DEFAULT_TEXT_SIZE_IF_FONT = 25;
    public static final int ICON_FONT_TYPE = 1;
    public static final int IMAGE_TYPE = 2;
    public static final int NONE_TYPE = -1;
    private static final int SYSTEM_DEFAULT_WEIGHT = 400;
    private static final String TAG = "IconFontCompatView";
    private static final String TYPE_JPEG = "image/jpeg";
    private static final String TYPE_PNG = "image/png";
    private String mAssetPath;
    private ImageView mImage;
    private String mImageResName;
    private int mResType;
    private ColorStateList mTextColor;
    private String mTextResName;
    private float mTextSize;
    private int mTextSizeUnit;
    private TextView mTextView;

    public ImageFontCompatView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void addImage(Context context) {
        this.mImage = new ImageView(context);
        addView(this.mImage, new FrameLayout.LayoutParams(-2, -2));
    }

    private Typeface createByWeightAdjustment(Context context, String str, int i) {
        int i2 = i + 400;
        int fallArea = FontLoader.fallArea(i2);
        if (!TextUtils.equals(getContext().getString(R.string.icon_font_more_search), this.mTextResName)) {
            Log.d(TAG, "mTextResName " + this.mTextResName + " weight " + fallArea);
        }
        if (fallArea == 100) {
            str = "FlymeIcon-Thin.otf";
        } else if (fallArea == 200) {
            str = "FlymeIcon-ExtraLight.otf";
        } else if (fallArea == 300) {
            if (TextUtils.equals(getContext().getString(R.string.icon_font_more_search), this.mTextResName) || TextUtils.equals(getContext().getString(R.string.icon_font_more_voice), this.mTextResName)) {
                i2 = i + CmdCode.CODE_WAKEUP_AUDIO_STATE;
            } else {
                str = "FlymeIcon-Light.otf";
            }
        }
        return FontLoader.createTypefaceByCache(context, str, i2);
    }

    private boolean executeDrawable(Context context) {
        int identifier = context.getResources().getIdentifier(this.mImageResName, "drawable", context.getPackageName());
        if (identifier <= 0) {
            return executeThemeOverlayDrawable(context);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), identifier, options);
        String str = options.outMimeType;
        if (getChildCount() > 1) {
            removeAllViews();
        }
        if (getChildCount() <= 0) {
            executeDrawableInner(context, str, identifier);
        } else if (getChildAt(0) instanceof ImageView) {
            setImageResByType(context, str, identifier);
        } else {
            removeAllViews();
            executeDrawableInner(context, str, identifier);
        }
        this.mResType = 2;
        return true;
    }

    private void executeDrawableInner(Context context, String str, int i) {
        addImage(context);
        setImageResByType(context, str, i);
    }

    private void executeIconFont(Context context) {
        if (this.mAssetPath == null) {
            this.mResType = -1;
            return;
        }
        if (getChildCount() > 1) {
            removeAllViews();
        }
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setText(this.mTextResName);
                this.mTextView.setTextSize(this.mTextSizeUnit, this.mTextSize);
                this.mTextView.setTextColor(this.mTextColor);
            } else {
                removeAllViews();
                executeIconFontInner(context);
            }
        } else {
            executeIconFontInner(context);
        }
        this.mResType = 1;
    }

    private void executeIconFontInner(Context context) {
        this.mTextView = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration != null) {
            this.mTextView.setTypeface(createByWeightAdjustment(context, this.mAssetPath, Build.VERSION.SDK_INT >= 31 ? configuration.fontWeightAdjustment : 0));
        }
        addView(this.mTextView, layoutParams);
        this.mTextView.setText(this.mTextResName);
        this.mTextView.setTextSize(this.mTextSizeUnit, this.mTextSize);
        this.mTextView.setTextColor(this.mTextColor);
        this.mTextView.setMovementMethod((MovementMethod) null);
        this.mTextView.setVerticalScrollBarEnabled(false);
        this.mTextView.setHorizontalScrollBarEnabled(false);
    }

    private boolean executeThemeOverlayDrawable(Context context) {
        Drawable drawable;
        try {
            drawable = ThemeUtil.getCustomRes(context, this.mImageResName);
        } catch (Exception | NoSuchMethodError unused) {
            Log.w(TAG, "has no such method 'getCustomRes' in fwk.");
            drawable = null;
        }
        if (drawable != null) {
            Log.i(TAG, "drawable from theme app.");
            if (getChildCount() > 1) {
                removeAllViews();
            }
            if (getChildCount() <= 0) {
                addImage(context);
                this.mImage.setImageDrawable(drawable);
            } else if (getChildAt(0) instanceof ImageView) {
                this.mImage.setImageDrawable(drawable);
            } else {
                removeAllViews();
                addImage(context);
                this.mImage.setImageDrawable(drawable);
            }
        } else {
            Log.i(TAG, "the resource:" + this.mImageResName + " has no drawable from theme app.");
        }
        return drawable != null;
    }

    private void handleDisplay() {
        if (this.mImageResName == null || !executeDrawable(getContext())) {
            executeIconFont(getContext());
        }
    }

    private void setImageResByType(Context context, String str, int i) {
        if (TYPE_PNG.equals(str) || TYPE_JPEG.equals(str)) {
            this.mImage.setImageResource(i);
            return;
        }
        this.mImage.setImageDrawable(VectorDrawableCompat.b(context.getResources(), i, context.getTheme()));
    }

    public int getResType() {
        return this.mResType;
    }

    public String getTextResName() {
        return this.mTextResName;
    }

    public void setEnabled(boolean z) {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setEnabled(z);
        }
        ImageView imageView = this.mImage;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
    }

    public void setImageResName(String str) {
        this.mImageResName = str;
        handleDisplay();
    }

    public void setImageSize(int i, int i2) {
        if (this.mImage != null) {
            this.mImage.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
        }
    }

    public void setTextColor(@ColorInt int i) {
        ColorStateList valueOf = ColorStateList.valueOf(i);
        this.mTextColor = valueOf;
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setTextColor(valueOf);
        }
    }

    public void setTextResName(@Nullable String str) {
        this.mTextResName = str;
        handleDisplay();
    }

    public void setTextSize(float f) {
        this.mTextSize = f;
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setTextSize(f);
            this.mTextSizeUnit = 2;
        }
    }

    public ImageFontCompatView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzIconFontCompatViewStyle);
    }

    public ImageFontCompatView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedValue peekValue;
        this.mAssetPath = ASSET_PATH_DEFAULT;
        this.mTextSize = 25.0f;
        this.mResType = -1;
        this.mTextSizeUnit = 2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageFontCompatView, i, 0);
        this.mTextResName = obtainStyledAttributes.getString(R.styleable.ImageFontCompatView_textResName);
        this.mImageResName = obtainStyledAttributes.getString(R.styleable.ImageFontCompatView_imageResName);
        if (obtainStyledAttributes.hasValue(R.styleable.ImageFontCompatView_fontTextSize) && (peekValue = obtainStyledAttributes.peekValue(R.styleable.ImageFontCompatView_fontTextSize)) != null) {
            this.mTextSizeUnit = peekValue.getComplexUnit();
            float dimension = peekValue.getDimension(getResources().getDisplayMetrics());
            this.mTextSize = dimension;
            int i2 = this.mTextSizeUnit;
            if (i2 == 2) {
                this.mTextSize = (float) ResourceUtils.px2sp(getContext(), dimension);
            } else if (i2 == 1) {
                this.mTextSize = ResourceUtils.px2dip(getContext(), dimension);
            }
        }
        this.mTextColor = obtainStyledAttributes.getColorStateList(R.styleable.ImageFontCompatView_fontTextColor);
        obtainStyledAttributes.recycle();
        handleDisplay();
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.mTextColor = colorStateList;
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTextSize(int i, float f) {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setTextSize(i, f);
            this.mTextSizeUnit = i;
            this.mTextSize = this.mTextView.getTextSize();
        }
    }
}

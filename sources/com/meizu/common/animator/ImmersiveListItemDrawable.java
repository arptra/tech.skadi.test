package com.meizu.common.animator;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.meizu.common.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ImmersiveListItemDrawable extends MzPressAnimationDrawable {
    private static int DEFAULT_IMMERSIVE_PADDING = 16;
    private int mImmersiveItemPadding;
    private int mImmersiveType = 3;
    private MaterialShapeDrawable mSolid;
    private int mSolidColor = -1;

    public void draw(@NonNull Canvas canvas) {
        this.mSolid.draw(canvas);
        super.draw(canvas);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.ImmersiveListItemDrawable);
        if (obtainAttributes.hasValue(R.styleable.ImmersiveListItemDrawable_immersiveType)) {
            this.mImmersiveType = obtainAttributes.getInt(R.styleable.ImmersiveListItemDrawable_immersiveType, 3);
        }
        if (obtainAttributes.hasValue(R.styleable.ImmersiveListItemDrawable_immersiveItemPadding)) {
            this.mImmersiveItemPadding = obtainAttributes.getDimensionPixelSize(R.styleable.ImmersiveListItemDrawable_immersiveItemPadding, DEFAULT_IMMERSIVE_PADDING);
        }
        TypedValue typedValue = new TypedValue();
        if (obtainAttributes.hasValue(R.styleable.ImmersiveListItemDrawable_immersiveSolidColor) && obtainAttributes.getValue(R.styleable.ImmersiveListItemDrawable_immersiveSolidColor, typedValue)) {
            int i = typedValue.type;
            if (i == 2) {
                if (theme != null) {
                    theme.resolveAttribute(typedValue.data, typedValue, true);
                    this.mSolidColor = typedValue.data;
                }
            } else if (i >= 28 && i <= 31) {
                this.mSolidColor = typedValue.data;
            }
        }
        obtainAttributes.recycle();
        ShapeAppearanceModel.Builder allCorners = ShapeAppearanceModel.builder().setAllCorners(new RoundedCornerTreatment());
        int i2 = this.mImmersiveType;
        if (i2 == 3) {
            allCorners.setAllCornerSizes((float) getRadius());
        } else if (i2 == 0) {
            allCorners.setTopLeftCornerSize((float) getRadius()).setTopRightCornerSize((float) getRadius());
        } else if (i2 == 1) {
            allCorners.setAllCornerSizes(0.0f);
        } else if (i2 == 2) {
            allCorners.setBottomLeftCornerSize((float) getRadius()).setBottomRightCornerSize((float) getRadius());
        }
        ShapeAppearanceModel build = allCorners.build();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(build);
        this.mSolid = materialShapeDrawable;
        materialShapeDrawable.setTint(this.mSolidColor);
        getPressDrawable().setShapeAppearanceModel(build);
    }

    public boolean isImmersiveStyle() {
        return true;
    }

    public boolean isProjected() {
        return false;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mSolid.setBounds(new Rect(getBounds().left + this.mImmersiveItemPadding, getBounds().top, getBounds().right - this.mImmersiveItemPadding, getBounds().bottom));
        this.mShapeDrawableWidth -= this.mImmersiveItemPadding * 2;
    }
}

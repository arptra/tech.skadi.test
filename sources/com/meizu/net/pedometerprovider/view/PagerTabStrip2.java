package com.meizu.net.pedometerprovider.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.PagerTitleStrip;
import com.meizu.net.pedometerprovider.util.DensityUtil;
import java.lang.reflect.Field;

public class PagerTabStrip2 extends PagerTabStrip {
    private static final String TAG = "PagerTabStrip2";
    String CURRTEXT_FIELD = "mCurrText";
    String FIELD = "mTabAlpha";
    String NEXTTEXT_FIELD = "mNextText";
    String PREVTEXT_FIELD = "mPrevText";
    Field mField;
    Field mNextTextField;
    Field mPrevTextField;

    public PagerTabStrip2(Context context) {
        super(context);
        initField();
    }

    private void initField() {
        Class<PagerTabStrip> cls = PagerTabStrip.class;
        Class<PagerTitleStrip> cls2 = PagerTitleStrip.class;
        try {
            Field declaredField = cls.getDeclaredField(this.FIELD);
            this.mField = declaredField;
            declaredField.setAccessible(true);
            int dip2px = DensityUtil.dip2px(getContext(), 0.0f);
            Field declaredField2 = cls2.getDeclaredField(this.PREVTEXT_FIELD);
            declaredField2.setAccessible(true);
            TextView textView = (TextView) declaredField2.get(this);
            textView.setGravity(5);
            textView.setPadding(0, 0, 0, 0);
            Field declaredField3 = cls2.getDeclaredField(this.NEXTTEXT_FIELD);
            declaredField3.setAccessible(true);
            TextView textView2 = (TextView) declaredField3.get(this);
            textView2.setGravity(3);
            textView2.setPadding(0, 0, 0, 0);
            Field declaredField4 = cls2.getDeclaredField(this.CURRTEXT_FIELD);
            declaredField4.setAccessible(true);
            TextView textView3 = (TextView) declaredField4.get(this);
            textView3.setGravity(17);
            textView3.setPadding(dip2px, 0, dip2px, 0);
            Field declaredField5 = cls.getDeclaredField("mMinTextSpacing");
            declaredField5.setAccessible(true);
            declaredField5.setInt(this, Integer.MIN_VALUE);
        } catch (NoSuchFieldException e) {
            String str = TAG;
            Log.e(str, "NoSuchFieldException " + e.getMessage());
        } catch (IllegalAccessException e2) {
            String str2 = TAG;
            Log.e(str2, "IllegalAccessException " + e2.getMessage());
        }
    }

    public void onDraw(Canvas canvas) {
        try {
            this.mField.setInt(this, 0);
        } catch (IllegalAccessException e) {
            String str = TAG;
            Log.e(str, "IllegalAccessException " + e.getMessage());
        }
        super.onDraw(canvas);
    }

    public PagerTabStrip2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initField();
    }
}

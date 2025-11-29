package flyme.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ScrollView;

public class LimitingHeightScrollView extends ScrollView {
    private Context mContext;

    public LimitingHeightScrollView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
    }

    public void onMeasure(int i, int i2) {
        try {
            Display defaultDisplay = ((Activity) this.mContext).getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            i2 = View.MeasureSpec.makeMeasureSpec((int) (((double) displayMetrics.heightPixels) * 0.33d), Integer.MIN_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onMeasure(i, i2);
    }

    public LimitingHeightScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LimitingHeightScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}

package flyme.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class PermissionScrollView extends ScrollView {
    private OnScrollChangeListener mOnScrollChangeListener;

    public interface OnScrollChangeListener {
        void onScrollChange(View view, int i, int i2, int i3, int i4);
    }

    public PermissionScrollView(Context context) {
        super(context);
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollChangeListener onScrollChangeListener = this.mOnScrollChangeListener;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChange(this, i, i2, i3, i4);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListener = onScrollChangeListener;
    }

    public PermissionScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PermissionScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOnScrollChangeListener(new OnScrollChangeListener() {
            public void onScrollChange(View view, int i, int i2, int i3, int i4) {
            }
        });
    }
}

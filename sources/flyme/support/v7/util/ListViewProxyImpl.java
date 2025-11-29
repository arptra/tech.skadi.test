package flyme.support.v7.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import flyme.support.v7.appcompat.R;

public class ListViewProxyImpl extends ListViewProxy {
    private Context mContext;
    private int mDividerPaddingEnd;
    private int mDividerPaddingStart;

    public ListViewProxyImpl(AbsListView absListView, Context context) {
        this(absListView, context, 0);
    }

    public int[] getDividerPadding(int i) {
        int[] iArr = new int[2];
        if (ViewCompat.z(this.mAbsList) == 1) {
            iArr[0] = this.mDividerPaddingEnd;
            iArr[1] = this.mDividerPaddingStart;
        } else {
            iArr[1] = this.mDividerPaddingEnd;
            iArr[0] = this.mDividerPaddingStart;
        }
        return iArr;
    }

    public ListViewProxyImpl(AbsListView absListView, Context context, int i) {
        this(absListView, context, i, 0);
    }

    public ListViewProxyImpl(AbsListView absListView, Context context, int i, int i2) {
        super(absListView);
        this.mContext = context;
        TintTypedArray v = TintTypedArray.v(context, (AttributeSet) null, R.styleable.MzListViewProxy, i, i2);
        this.mDividerPaddingStart = v.f(R.styleable.MzListViewProxy_mzDividerPaddingStart, 0);
        this.mDividerPaddingEnd = v.f(R.styleable.MzListViewProxy_mzDividerPaddingEnd, 0);
    }
}

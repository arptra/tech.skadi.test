package flyme.support.v7.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.util.ListViewProxy;

public class MenuListViewProxyImpl extends ListViewProxy {
    private Context mContext;
    private int mDividerPaddingEnd;
    private int mDividerPaddingStart;
    private int mDividerPaddingStratWithIcon;

    public MenuListViewProxyImpl(AbsListView absListView, Context context) {
        this(absListView, context, 0);
    }

    public int[] getDividerPadding(int i) {
        boolean z = ViewCompat.z(this.mAbsList) == 1;
        int[] iArr = new int[2];
        View findViewById = this.mAbsList.getChildAt(i).findViewById(R.id.icon);
        if (findViewById == null || findViewById.getVisibility() != 0) {
            if (z) {
                iArr[0] = this.mDividerPaddingEnd;
                iArr[1] = this.mDividerPaddingStart;
            } else {
                iArr[1] = this.mDividerPaddingEnd;
                iArr[0] = this.mDividerPaddingStart;
            }
        } else if (z) {
            iArr[0] = this.mDividerPaddingEnd;
            iArr[1] = this.mDividerPaddingStratWithIcon;
        } else {
            iArr[1] = this.mDividerPaddingEnd;
            iArr[0] = this.mDividerPaddingStratWithIcon;
        }
        return iArr;
    }

    public MenuListViewProxyImpl(AbsListView absListView, Context context, int i) {
        this(absListView, context, i, 0);
    }

    public MenuListViewProxyImpl(AbsListView absListView, Context context, int i, int i2) {
        super(absListView);
        this.mContext = context;
        TintTypedArray v = TintTypedArray.v(context, (AttributeSet) null, R.styleable.MzListViewProxy, i, i2);
        this.mDividerPaddingStart = v.f(R.styleable.MzListViewProxy_mzDividerPaddingStart, 0);
        this.mDividerPaddingEnd = v.f(R.styleable.MzListViewProxy_mzDividerPaddingEnd, 0);
        this.mDividerPaddingStratWithIcon = v.f(R.styleable.MzListViewProxy_mzDividerPaddingStartWithIcon, 0);
    }
}

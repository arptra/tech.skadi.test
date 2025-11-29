package com.meizu.common.widget.listeners;

import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;

public abstract class MzListViewDefaultScrollListener implements AbsListView.OnScrollListener {
    private int mCurrentfirstVisibleItem;
    private SparseArray mRecordSp = new SparseArray(0);

    public class ItemRecod {
        int height;

        /* renamed from: top  reason: collision with root package name */
        int f9497top;

        private ItemRecod() {
            this.height = 0;
            this.f9497top = 0;
        }
    }

    private int getScrollY() {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.mCurrentfirstVisibleItem;
            if (i2 >= i) {
                break;
            }
            ItemRecod itemRecod = (ItemRecod) this.mRecordSp.get(i2);
            if (itemRecod != null) {
                i3 += itemRecod.height;
            }
            i2++;
        }
        ItemRecod itemRecod2 = (ItemRecod) this.mRecordSp.get(i);
        if (itemRecod2 == null) {
            itemRecod2 = new ItemRecod();
        }
        return i3 - itemRecod2.f9497top;
    }

    public abstract void onHideBackTopButton();

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.mCurrentfirstVisibleItem = i;
        View childAt = absListView.getChildAt(0);
        if (childAt != null) {
            ItemRecod itemRecod = (ItemRecod) this.mRecordSp.get(i);
            if (itemRecod == null) {
                itemRecod = new ItemRecod();
            }
            itemRecod.height = childAt.getHeight();
            itemRecod.f9497top = childAt.getTop();
            this.mRecordSp.append(i, itemRecod);
            if (getScrollY() >= absListView.getHeight() * 2) {
                onShowBackTopButton();
            } else {
                onHideBackTopButton();
            }
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public abstract void onShowBackTopButton();
}

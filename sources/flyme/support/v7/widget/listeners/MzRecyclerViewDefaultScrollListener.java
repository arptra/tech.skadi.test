package flyme.support.v7.widget.listeners;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import flyme.support.v7.widget.MzRecyclerView;

public abstract class MzRecyclerViewDefaultScrollListener extends RecyclerView.OnScrollListener {
    private static final String TAG = "RecyclerViewDtListener";
    private int mScrollDistance = 0;

    private int getFirstPosition(RecyclerView recyclerView) {
        View childAt = recyclerView.getChildAt(0);
        if (childAt == null) {
            return -1;
        }
        return recyclerView.getChildLayoutPosition(childAt);
    }

    public abstract void onHideBackTopButton();

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (i != 0) {
            return;
        }
        if (recyclerView instanceof MzRecyclerView) {
            if (((MzRecyclerView) recyclerView).getFirstPosition() == 0) {
                this.mScrollDistance = 0;
            }
        } else if (getFirstPosition(recyclerView) == 0) {
            this.mScrollDistance = 0;
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        int i3 = this.mScrollDistance + i2;
        this.mScrollDistance = i3;
        if (i3 > recyclerView.getHeight() * 2) {
            onShowBackTopButton();
        } else {
            onHideBackTopButton();
        }
    }

    public abstract void onShowBackTopButton();
}

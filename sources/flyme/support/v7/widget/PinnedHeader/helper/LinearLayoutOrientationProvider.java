package flyme.support.v7.widget.PinnedHeader.helper;

import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import flyme.support.v7.widget.MzRecyclerView;

public class LinearLayoutOrientationProvider implements OrientationProvider {
    private void throwIfNotLinearLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof LinearLayoutManager)) {
            Log.e("lijinqian", "LinearLayoutOrientationProvider exception : " + "MzRecyclerView PinnedHeader decoration can only be used with a LinearLayoutManager.");
            throw new IllegalStateException("MzRecyclerView PinnedHeader decoration can only be used with a LinearLayoutManager.");
        }
    }

    public int getOrientation(MzRecyclerView mzRecyclerView) {
        RecyclerView.LayoutManager layoutManager = mzRecyclerView.getLayoutManager();
        throwIfNotLinearLayoutManager(layoutManager);
        return ((LinearLayoutManager) layoutManager).getOrientation();
    }

    public boolean isReverseLayout(MzRecyclerView mzRecyclerView) {
        RecyclerView.LayoutManager layoutManager = mzRecyclerView.getLayoutManager();
        throwIfNotLinearLayoutManager(layoutManager);
        return ((LinearLayoutManager) layoutManager).getReverseLayout();
    }
}

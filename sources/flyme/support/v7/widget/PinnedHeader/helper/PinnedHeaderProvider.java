package flyme.support.v7.widget.PinnedHeader.helper;

import android.view.View;
import flyme.support.v7.widget.MzRecyclerView;

public interface PinnedHeaderProvider {
    View getHeader(MzRecyclerView mzRecyclerView, int i);

    void invalidate();
}

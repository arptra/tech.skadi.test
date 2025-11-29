package flyme.support.v7.widget.PinnedHeader.helper;

import flyme.support.v7.widget.MzRecyclerView;

public interface OrientationProvider {
    int getOrientation(MzRecyclerView mzRecyclerView);

    boolean isReverseLayout(MzRecyclerView mzRecyclerView);
}

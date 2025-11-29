package flyme.support.v7.widget.PinnedHeader;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public interface RecyclerPinnedHeaderAdapter<VH extends RecyclerView.ViewHolder> {
    long getHeaderId(int i);

    int getItemCount();

    void onBindHeaderViewHolder(VH vh, int i);

    VH onCreateHeaderViewHolder(ViewGroup viewGroup);
}

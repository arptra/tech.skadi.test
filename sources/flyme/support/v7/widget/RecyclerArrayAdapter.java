package flyme.support.v7.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import flyme.support.v7.widget.MzRecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public abstract class RecyclerArrayAdapter<VH extends RecyclerView.ViewHolder> extends MzRecyclerView.Adapter<VH> {
    private ArrayList<String> mList = new ArrayList<>();

    public RecyclerArrayAdapter() {
        setHasStableIds(true);
        updateLocalData();
    }

    public void add(String str) {
        this.mList.add(str);
        updateLocalData();
        notifyDataSetChanged();
    }

    public void addAll(Collection<? extends String> collection) {
        if (collection != null) {
            this.mList.addAll(collection);
            updateLocalData();
            notifyDataSetChanged();
        }
    }

    public void clear() {
        this.mList.clear();
        updateLocalData();
        notifyDataSetChanged();
    }

    public String getItem(int i) {
        return this.mList.get(i);
    }

    public int getItemCount() {
        return this.mList.size();
    }

    public long getItemId(int i) {
        return (long) getItem(i).hashCode();
    }

    public void remove(String str) {
        this.mList.remove(str);
        updateLocalData();
        notifyDataSetChanged();
    }

    public void updateLocalData() {
    }

    public void add(int i, String str) {
        this.mList.add(i, str);
        updateLocalData();
        notifyDataSetChanged();
    }

    public void addAll(String... strArr) {
        addAll((Collection<? extends String>) Arrays.asList(strArr));
    }
}

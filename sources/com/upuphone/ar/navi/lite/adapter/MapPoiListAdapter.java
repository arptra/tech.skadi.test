package com.upuphone.ar.navi.lite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.e4.e;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.util.CLog;
import java.util.ArrayList;
import java.util.List;

public class MapPoiListAdapter extends RecyclerView.Adapter<MapPoiViewHolder> {
    public static final String g = ("NAVI-" + MapPoiListAdapter.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public Context f5647a;
    public ItemClickListener b;
    public LayoutInflater c;
    public RecyclerView d;
    public List e = new ArrayList();
    public int f = 0;

    public interface ItemClickListener {
        void d(RecyclerView recyclerView, View view, int i, SearchModel searchModel);
    }

    public MapPoiListAdapter(Context context, List list) {
        this.f5647a = context;
        this.c = LayoutInflater.from(context);
        this.e.clear();
        this.e.addAll(list);
    }

    private void h(View view) {
        view.setOnClickListener(new e(this, view));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(View view, View view2) {
        int childLayoutPosition = this.d.getChildLayoutPosition(view);
        String str = g;
        CLog.b(str, "onItemClick  initItemClick position=" + childLayoutPosition);
        if (this.b != null && this.e.size() > 0 && childLayoutPosition >= 0 && childLayoutPosition < this.e.size()) {
            this.b.d(this.d, view2, childLayoutPosition, (SearchModel) this.e.get(childLayoutPosition));
        }
    }

    public int getItemCount() {
        return this.e.size();
    }

    public int getItemViewType(int i) {
        return ((SearchModel) this.e.get(i)).getType();
    }

    /* renamed from: j */
    public void onBindViewHolder(MapPoiViewHolder mapPoiViewHolder, int i) {
        int itemViewType = getItemViewType(i);
        boolean z = false;
        if (itemViewType == 0) {
            SearchModel searchModel = (SearchModel) this.e.get(i);
            if (i == getItemCount() - 1) {
                z = true;
            }
            mapPoiViewHolder.a(searchModel, z);
        } else if (itemViewType == 1) {
            mapPoiViewHolder.c((SearchModel) this.e.get(i), i, this.f);
        } else if (itemViewType == 2) {
            mapPoiViewHolder.b(0);
        } else if (itemViewType == 3) {
            mapPoiViewHolder.b(1);
        }
    }

    /* renamed from: k */
    public MapPoiViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        if (i == 0) {
            view = this.c.inflate(R.layout.map_location_item, viewGroup, false);
            h(view);
        } else if (i == 1) {
            view = this.c.inflate(R.layout.poi_mark_list_item, viewGroup, false);
            h(view);
        } else if (i == 2 || i == 3) {
            view = this.c.inflate(R.layout.item_more_layout, viewGroup, false);
            h(view);
        } else {
            view = null;
        }
        return new MapPoiViewHolder(this.f5647a, view);
    }

    public void l(List list) {
        this.e.clear();
        this.e.addAll(list);
    }

    public void m(ItemClickListener itemClickListener) {
        this.b = itemClickListener;
    }

    public void n(int i) {
        this.f = i;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.d = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.d = null;
    }
}

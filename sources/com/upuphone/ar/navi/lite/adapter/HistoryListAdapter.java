package com.upuphone.ar.navi.lite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.e4.a;
import com.honey.account.e4.b;
import com.honey.account.e4.c;
import com.honey.account.e4.d;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.view.DrawableCenterTextView;
import java.util.ArrayList;
import java.util.List;

public class HistoryListAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public LayoutInflater f5646a;
    public List b;
    public RecyclerView c;
    public ItemClickListener d;
    public Context e;
    public int f = 0;
    public int g = 0;
    public String h = "";

    public interface ItemClickListener {
        void d(RecyclerView recyclerView, View view, int i, SearchModel searchModel);

        void e(RecyclerView recyclerView, View view, int i, SearchModel searchModel);
    }

    public HistoryListAdapter(Context context, List list) {
        this.e = context;
        this.f5646a = LayoutInflater.from(context);
        this.b = new ArrayList(list);
        this.f = 0;
    }

    public int getItemCount() {
        return this.b.size();
    }

    public int getItemViewType(int i) {
        return ((SearchModel) this.b.get(i)).getType();
    }

    public List k() {
        return this.b;
    }

    public final void l(View view) {
        view.setOnClickListener(new b(this, view));
        ImageView imageView = (ImageView) view.findViewById(R.id.route);
        TextView textView = (TextView) view.findViewById(R.id.distance);
        View findViewById = view.findViewById(R.id.route_info);
        int i = this.f;
        if (i == 0) {
            imageView.setVisibility(8);
        } else if (i == 1) {
            textView.setText(this.h);
            imageView.setImageResource(this.g);
            findViewById.setOnClickListener(new c(this, view));
        }
    }

    public final void m(View view) {
        ((DrawableCenterTextView) view.findViewById(R.id.menu_location)).setOnClickListener(new d(this, view));
    }

    public final void n(View view) {
        view.setOnClickListener(new a(this, view));
    }

    public final /* synthetic */ void o(View view, View view2) {
        int childAdapterPosition = this.c.getChildAdapterPosition(view);
        if (this.d != null && this.b.size() > 0 && childAdapterPosition >= 0 && childAdapterPosition < this.b.size()) {
            this.d.d(this.c, view2, childAdapterPosition, (SearchModel) this.b.get(childAdapterPosition));
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.c = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.c = null;
    }

    public final /* synthetic */ void p(View view, View view2) {
        int childAdapterPosition = this.c.getChildAdapterPosition(view);
        if (this.d != null && this.b.size() > 0 && childAdapterPosition >= 0 && childAdapterPosition < this.b.size()) {
            this.d.e(this.c, view2, childAdapterPosition, (SearchModel) this.b.get(childAdapterPosition));
        }
    }

    public final /* synthetic */ void q(View view, View view2) {
        int childAdapterPosition = this.c.getChildAdapterPosition(view);
        if (this.d != null && this.b.size() > 0 && childAdapterPosition >= 0 && childAdapterPosition < this.b.size()) {
            this.d.d(this.c, view2, childAdapterPosition, (SearchModel) this.b.get(childAdapterPosition));
        }
    }

    public final /* synthetic */ void r(View view, View view2) {
        int childAdapterPosition = this.c.getChildAdapterPosition(view);
        if (this.d != null && this.b.size() > 0 && childAdapterPosition >= 0 && childAdapterPosition < this.b.size()) {
            this.d.d(this.c, view2, childAdapterPosition, (SearchModel) this.b.get(childAdapterPosition));
        }
    }

    /* renamed from: s */
    public void onBindViewHolder(SearchViewHolder searchViewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            searchViewHolder.c((SearchModel) this.b.get(i));
            searchViewHolder.b((SearchModel) this.b.get(i));
        } else if (itemViewType == 1) {
            searchViewHolder.c((SearchModel) this.b.get(i));
            searchViewHolder.f((SearchModel) this.b.get(i));
        } else if (itemViewType == 2 || itemViewType == 3 || itemViewType == 4) {
            searchViewHolder.g((SearchModel) this.b.get(i));
        } else if (itemViewType == 5) {
            searchViewHolder.h((SearchModel) this.b.get(i));
        }
    }

    /* renamed from: t */
    public SearchViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        if (i == 0 || i == 1) {
            view = this.f5646a.inflate(R.layout.search_list_item, viewGroup, false);
            l(view);
        } else if (i == 2 || i == 3) {
            view = this.f5646a.inflate(R.layout.search_menu_item, viewGroup, false);
            n(view);
        } else if (i == 4) {
            view = this.f5646a.inflate(R.layout.search_menu_item, viewGroup, false);
        } else if (i != 5) {
            view = null;
        } else {
            view = this.f5646a.inflate(R.layout.search_location_item, viewGroup, false);
            m(view);
        }
        return new SearchViewHolder(this.e, view);
    }

    public void u(List list) {
        this.b.clear();
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    public void v(ItemClickListener itemClickListener) {
        this.d = itemClickListener;
    }
}

package com.upuphone.ar.navi.lite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.e4.f;
import com.honey.account.e4.g;
import com.honey.account.e4.h;
import com.honey.account.e4.i;
import com.honey.account.e4.j;
import com.honey.account.e4.k;
import com.honey.account.e4.l;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.util.CLog;
import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {
    public static final String g = ("NAVI-" + SearchAdapter.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public LayoutInflater f5649a;
    public List b;
    public RecyclerView c;
    public ItemClickListener d;
    public Context e;
    public boolean f;

    public interface ItemClickListener {
        void B(RecyclerView recyclerView, View view, int i, SearchModel searchModel);

        void F(RecyclerView recyclerView, View view, int i, SearchModel searchModel);

        void d(RecyclerView recyclerView, View view, int i, SearchModel searchModel);

        void e(RecyclerView recyclerView, View view, int i, SearchModel searchModel);
    }

    public SearchAdapter(Context context, List list, boolean z) {
        this.e = context;
        this.f5649a = LayoutInflater.from(context);
        this.b = new ArrayList(list);
        this.f = z;
    }

    private void p(View view) {
        view.setOnClickListener(new f(this, view));
        view.findViewById(R.id.route_info).setOnClickListener(new g(this, view));
    }

    private void q(View view) {
        view.setOnClickListener(new l(this, view));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(View view, View view2) {
        int childAdapterPosition = this.c.getChildAdapterPosition(view);
        if (this.d != null && this.b.size() > 0 && childAdapterPosition >= 0 && childAdapterPosition < this.b.size()) {
            this.d.d(this.c, view2, childAdapterPosition, (SearchModel) this.b.get(childAdapterPosition));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(View view, View view2) {
        int childAdapterPosition = this.c.getChildAdapterPosition(view);
        if (this.d != null && this.b.size() > 0 && childAdapterPosition >= 0 && childAdapterPosition < this.b.size()) {
            this.d.e(this.c, view2, childAdapterPosition, (SearchModel) this.b.get(childAdapterPosition));
        }
    }

    public void A(List list) {
        this.b.clear();
        this.b.addAll(list);
    }

    public void B(ItemClickListener itemClickListener) {
        this.d = itemClickListener;
    }

    public final void C(SearchViewHolder searchViewHolder, int i) {
        boolean z = true;
        if (i == this.b.size() - 1 || this.f) {
            z = false;
        }
        searchViewHolder.l(z);
    }

    public int getItemCount() {
        return this.b.size();
    }

    public int getItemViewType(int i) {
        return ((SearchModel) this.b.get(i)).getType();
    }

    public List n() {
        return this.b;
    }

    public final void o(View view) {
        view.setOnClickListener(new h(this, view));
        view.findViewById(R.id.route_info).setOnClickListener(new i(this, view));
        ((TextView) view.findViewById(R.id.editAddrerss)).setOnClickListener(new j(this, view));
        ((TextView) view.findViewById(R.id.delete)).setOnClickListener(new k(this, view));
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.c = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.c = null;
    }

    public final /* synthetic */ void r(View view, View view2) {
        int childAdapterPosition = this.c.getChildAdapterPosition(view);
        if (this.d != null && this.b.size() > 0 && childAdapterPosition >= 0 && childAdapterPosition < this.b.size()) {
            this.d.d(this.c, view2, childAdapterPosition, (SearchModel) this.b.get(childAdapterPosition));
        }
    }

    public final /* synthetic */ void s(View view, View view2) {
        int childAdapterPosition = this.c.getChildAdapterPosition(view);
        if (this.d != null && this.b.size() > 0 && childAdapterPosition >= 0 && childAdapterPosition < this.b.size()) {
            this.d.e(this.c, view2, childAdapterPosition, (SearchModel) this.b.get(childAdapterPosition));
        }
    }

    public final /* synthetic */ void t(View view, View view2) {
        int childAdapterPosition = this.c.getChildAdapterPosition(view);
        if (this.d != null && this.b.size() > 0 && childAdapterPosition >= 0 && childAdapterPosition < this.b.size()) {
            this.d.B(this.c, view2, childAdapterPosition, (SearchModel) this.b.get(childAdapterPosition));
        }
    }

    public final /* synthetic */ void u(View view, View view2) {
        int childAdapterPosition = this.c.getChildAdapterPosition(view);
        if (this.d != null && this.b.size() > 0 && childAdapterPosition >= 0 && childAdapterPosition < this.b.size()) {
            this.d.F(this.c, view2, childAdapterPosition, (SearchModel) this.b.get(childAdapterPosition));
        }
    }

    public final /* synthetic */ void x(View view, View view2) {
        int childAdapterPosition = this.c.getChildAdapterPosition(view);
        if (this.d != null && this.b.size() > 0 && childAdapterPosition >= 0 && childAdapterPosition < this.b.size()) {
            this.d.d(this.c, view2, childAdapterPosition, (SearchModel) this.b.get(childAdapterPosition));
        }
    }

    /* renamed from: y */
    public void onBindViewHolder(SearchViewHolder searchViewHolder, int i) {
        if (this.b.size() > 0) {
            C(searchViewHolder, i);
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    searchViewHolder.d((SearchModel) this.b.get(i));
                    searchViewHolder.e((SearchModel) this.b.get(i));
                } else if (itemViewType == 2 || itemViewType == 3 || itemViewType == 4) {
                    searchViewHolder.g((SearchModel) this.b.get(i));
                } else {
                    CLog.b(g, "onBindViewHolder() default");
                }
            } else if (this.f) {
                searchViewHolder.i((SearchModel) this.b.get(i));
            } else {
                searchViewHolder.c((SearchModel) this.b.get(i));
            }
        }
    }

    /* renamed from: z */
    public SearchViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        if (i == 0) {
            view = this.f ? this.f5649a.inflate(R.layout.search_scroll_list_item, viewGroup, false) : this.f5649a.inflate(R.layout.search_list_item, viewGroup, false);
            p(view);
        } else if (i == 1) {
            view = this.f5649a.inflate(R.layout.search_history_list_item, viewGroup, false);
            o(view);
        } else if (i == 2 || i == 3) {
            view = this.f5649a.inflate(R.layout.search_menu_item, viewGroup, false);
            q(view);
        } else if (i != 4) {
            CLog.b(g, "onCreateViewHolder() default");
            view = null;
        } else {
            view = this.f5649a.inflate(R.layout.search_menu_item, viewGroup, false);
        }
        return new SearchViewHolder(this.e, view);
    }
}

package com.upuphone.ar.navi.lite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.e4.m;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.CommonAddress;
import java.util.List;

public class SearchCommonAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List f5650a;
    public Context b;
    public ItemClickListener c;

    public interface ItemClickListener {
        void a(CommonAddress commonAddress, int i);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f5651a;
        public ImageView b;
        public TextView c;

        public ViewHolder(View view) {
            super(view);
            this.f5651a = view;
            this.b = (ImageView) view.findViewById(R.id.common_address_list_icon);
            this.c = (TextView) view.findViewById(R.id.common_address_list_name);
        }
    }

    public SearchCommonAdapter(Context context, List list) {
        this.f5650a = list;
        this.b = context;
    }

    public int getItemCount() {
        return this.f5650a.size();
    }

    public final /* synthetic */ void h(int i, View view) {
        ItemClickListener itemClickListener = this.c;
        if (itemClickListener != null) {
            itemClickListener.a((CommonAddress) this.f5650a.get(i), i);
        }
    }

    /* renamed from: i */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (this.f5650a.size() > 0) {
            if (((CommonAddress) this.f5650a.get(i)).j().length() > 7) {
                String substring = ((CommonAddress) this.f5650a.get(i)).j().substring(0, 7);
                viewHolder.c.setText(substring + "...");
            } else {
                viewHolder.c.setText(((CommonAddress) this.f5650a.get(i)).j());
            }
            viewHolder.f5651a.setOnClickListener(new m(this, i));
        }
    }

    /* renamed from: j */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(((LayoutInflater) this.b.getSystemService("layout_inflater")).inflate(R.layout.search_common_address_item, viewGroup, false));
    }

    public void k(ItemClickListener itemClickListener) {
        this.c = itemClickListener;
    }
}

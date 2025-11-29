package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.o4.v;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.adapter.SearchCommonAdapter;
import com.upuphone.ar.navi.lite.base.CommonAddress;
import com.upuphone.ar.navi.lite.manger.NaviOperatorManager;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.JsonUtil;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import java.util.ArrayList;
import java.util.List;

public class SearchCommonView extends RelativeLayout {
    public static final String f = ("NAVI-" + SearchCommonView.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f5849a;
    public TextView b;
    public RelativeLayout c;
    public SearchCommonAdapter d;
    public List e = new ArrayList();

    public SearchCommonView(Context context) {
        super(context);
        c(context);
        b(context);
    }

    public void b(Context context) {
        this.f5849a.setLayoutManager(new GridLayoutManager(context, 2));
        setListData(getAliasCustomInfo());
    }

    public void c(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.search_common_address_view, this);
        this.f5849a = (RecyclerView) findViewById(R.id.search_common_list);
        TextView textView = (TextView) findViewById(R.id.more_address);
        this.b = textView;
        textView.setOnClickListener(new v(this));
        this.c = (RelativeLayout) findViewById(R.id.common_address_layout);
    }

    public final /* synthetic */ void d(View view) {
        e();
    }

    public final void e() {
        this.e.clear();
        this.e.addAll(getAliasCustomInfo());
        this.d.notifyDataSetChanged();
        this.b.setVisibility(8);
    }

    public final void f(List list) {
        if (list.size() > 6) {
            for (int i = 0; i < 6; i++) {
                this.e.add((CommonAddress) list.get(i));
            }
            return;
        }
        this.e.addAll(list);
    }

    public SearchCommonAdapter getAdapter() {
        return this.d;
    }

    public List<CommonAddress> getAliasCustomInfo() {
        List<CommonAddress> i = NaviOperatorManager.getInstance(getContext().getApplicationContext()).getNaviDatabase().d().i(NaviUtil.t());
        String str = f;
        CLog.a(str, "getAliasCustomInfo list.size(): " + i.size());
        for (CommonAddress next : i) {
            String str2 = f;
            CLog.a(str2, "getAliasCustomInfo: " + JsonUtil.a(next) + " addr.getAlias()=" + next.d());
        }
        return i;
    }

    public List<CommonAddress> getCommonAddressList() {
        return this.e;
    }

    public void setCommonAddressList(List<CommonAddress> list) {
        this.e.clear();
        this.e.addAll(list);
    }

    public void setListData(List<CommonAddress> list) {
        CLog.b(f, "setListData() ######## list.size()" + list.size());
        this.e.clear();
        int i = 8;
        this.c.setVisibility(list.size() > 0 ? 0 : 8);
        TextView textView = this.b;
        if (list.size() > 6) {
            i = 0;
        }
        textView.setVisibility(i);
        f(list);
        if (this.d == null) {
            this.d = new SearchCommonAdapter(getContext().getApplicationContext(), this.e);
        }
        this.f5849a.setAdapter(this.d);
        this.d.notifyDataSetChanged();
    }

    public SearchCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
        b(context);
    }

    public SearchCommonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
        b(context);
    }
}

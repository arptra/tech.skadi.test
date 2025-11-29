package com.upuphone.ar.navi.lite.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.e4.n;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.CommonAddress;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.search.PoiSearchManager;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.view.DrawableCenterTextView;
import java.util.List;

public class SearchViewHolder extends RecyclerView.ViewHolder {
    public static final String n = ("NAVI-" + SearchViewHolder.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public Context f5652a;
    public ImageView b;
    public TextView c;
    public TextView d;
    public LinearLayout e;
    public ImageView f;
    public TextView g;
    public View h;
    public TextView i;
    public DrawableCenterTextView j;
    public LinearLayout k;
    public TextView l;
    public TextView m;

    public SearchViewHolder(Context context, View view) {
        super(view);
        this.f5652a = context;
        this.b = (ImageView) view.findViewById(R.id.icon);
        this.c = (TextView) view.findViewById(R.id.name);
        this.d = (TextView) view.findViewById(R.id.address);
        this.e = (LinearLayout) view.findViewById(R.id.route_info);
        this.f = (ImageView) view.findViewById(R.id.route);
        this.g = (TextView) view.findViewById(R.id.distance);
        this.h = view.findViewById(R.id.line);
        this.i = (TextView) view.findViewById(R.id.menue);
        this.j = (DrawableCenterTextView) view.findViewById(R.id.menu_location);
        this.k = (LinearLayout) view.findViewById(R.id.itemMenu);
        this.l = (TextView) view.findViewById(R.id.editAddrerss);
        this.m = (TextView) view.findViewById(R.id.frequent_address);
    }

    public static /* synthetic */ void k(boolean z, TextView textView, SearchModel searchModel, List list) {
        if (list != null && list.size() > 0) {
            PlaceBean placeBean = (PlaceBean) list.get(0);
            String str = n;
            CLog.b(str, "setItemAddressInfo isCity=" + z + " getCity()=" + placeBean.getCity() + " getProvince=" + placeBean.getProvince() + " getDistrict=" + placeBean.getDistrict() + " getAddress=" + placeBean.getAddress());
            textView.setText(z ? placeBean.getCity() : placeBean.getAddress());
            searchModel.setCity(placeBean.getCity());
            searchModel.setDistrict(placeBean.getDistrict());
        }
    }

    public void b(SearchModel searchModel) {
        if (searchModel == null) {
            CLog.b(n, "bindHCommonRoute searchModel is null!");
            return;
        }
        this.e.setVisibility(searchModel.getDistance() == -2 ? 8 : 0);
        this.g.setVisibility(0);
        this.f.setVisibility(8);
    }

    public void c(SearchModel searchModel) {
        String name = searchModel.getName();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
        if (!TextUtils.isEmpty(searchModel.getKeywords())) {
            int length = searchModel.getKeywords().length();
            int indexOf = name.indexOf(searchModel.getKeywords());
            if (indexOf != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f5652a.getApplicationContext().getResources().getColor(R.color.search_highlight_color, (Resources.Theme) null)), indexOf, length + indexOf, 33);
            }
        }
        this.c.setText(spannableStringBuilder);
        if (TextUtils.isEmpty(searchModel.getDistrict())) {
            o(searchModel, this.d, false);
        } else {
            this.d.setText(searchModel.getAddress());
        }
        this.g.setText(NaviUtil.r(this.f5652a.getApplicationContext(), searchModel.getDistance()));
        if (searchModel.getDistance() == -2) {
            this.b.setImageResource(R.drawable.search_h_icon);
            this.d.setText(searchModel.getCity());
            return;
        }
        this.b.setImageResource(R.drawable.default_generalsearch_sugg_tqueryicon_normal);
    }

    public void d(SearchModel searchModel) {
        if (searchModel == null) {
            CLog.b(n, "bindEditAddress searchModel is null!");
            return;
        }
        n(searchModel);
        CommonAddress M = NaviUtil.M(this.f5652a.getApplicationContext(), searchModel);
        if (M != null) {
            String str = n;
            CLog.b(str, "existAddress =" + M.toString());
        }
        if (M == null || !NaviUtil.n0(M.d())) {
            this.l.setText(this.f5652a.getString(R.string.add_common_addr));
            this.l.setBackgroundColor(this.f5652a.getApplicationContext().getResources().getColor(R.color.add_nor_address_color, (Resources.Theme) null));
            return;
        }
        this.l.setText(this.f5652a.getString(R.string.del_common_addr));
        this.l.setBackgroundColor(this.f5652a.getApplicationContext().getResources().getColor(R.color.del_nor_address_color, (Resources.Theme) null));
    }

    public void e(SearchModel searchModel) {
        if (searchModel == null) {
            CLog.b(n, "bindHistoryData searchModel is null!");
            return;
        }
        this.c.setMaxWidth(j(searchModel));
        this.c.setText(searchModel.getName());
        m(searchModel);
        if (TextUtils.isEmpty(searchModel.getCity())) {
            o(searchModel, this.d, true);
        } else {
            this.d.setText(searchModel.getCity());
        }
        this.g.setText(R.string.route);
        if (searchModel.getDistance() == -2) {
            this.b.setImageResource(R.drawable.search_h_icon);
            this.e.setVisibility(8);
        } else {
            this.b.setImageResource(R.drawable.default_generalsearch_sugg_tqueryicon_normal);
            this.e.setVisibility(0);
        }
        if (NaviUtil.w0(this.f5652a, searchModel)) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }

    public void f(SearchModel searchModel) {
        if (searchModel == null) {
            CLog.b(n, "bindHistoryRoute searchModel is null!");
            return;
        }
        this.e.setVisibility(searchModel.getDistance() == -2 ? 8 : 0);
        this.g.setVisibility(8);
        this.f.setVisibility(0);
        this.f.setImageResource(R.drawable.open_address);
    }

    public void g(SearchModel searchModel) {
        this.i.setText(searchModel.getName());
    }

    public void h(SearchModel searchModel) {
        this.j.setText(searchModel.getName());
    }

    public void i(SearchModel searchModel) {
        String name = searchModel.getName();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
        if (!TextUtils.isEmpty(searchModel.getKeywords())) {
            int length = searchModel.getKeywords().length();
            int indexOf = name.indexOf(searchModel.getKeywords());
            if (indexOf != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f5652a.getApplicationContext().getResources().getColor(R.color.search_highlight_color, (Resources.Theme) null)), indexOf, length + indexOf, 33);
            }
        }
        this.c.setText(spannableStringBuilder);
        if (TextUtils.isEmpty(searchModel.getDistrict())) {
            o(searchModel, this.d, false);
        } else {
            this.d.setText(searchModel.getAddress());
        }
        this.g.setText(NaviUtil.r(this.f5652a.getApplicationContext(), searchModel.getDistance()));
    }

    public final int j(SearchModel searchModel) {
        float f2;
        float f3;
        float f4;
        int i2;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f5652a.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels;
        float f5 = this.f5652a.getResources().getDisplayMetrics().density;
        float applyDimension = TypedValue.applyDimension(0, (float) i3, this.f5652a.getResources().getDisplayMetrics()) / f5;
        if (applyDimension > 390.0f) {
            float f6 = applyDimension - 390.0f;
            f3 = 250.0f + f6;
            f2 = 180.0f + f6;
            f4 = f6 + 210.0f;
        } else {
            float f7 = 390.0f - applyDimension;
            f3 = 250.0f - f7;
            f2 = 180.0f - f7;
            f4 = 210.0f - f7;
        }
        if (searchModel.getDistance() == -2) {
            i2 = (int) (f3 * f5);
        } else if (!NaviUtil.w0(this.f5652a, searchModel)) {
            i2 = (int) (f4 * f5);
        } else {
            if (NaviUtil.s0()) {
                f2 -= 35.0f;
            }
            i2 = (int) (f2 * f5);
        }
        String str = n;
        CLog.b(str, "calculateMaxWitch screenWidthDp=" + applyDimension);
        return i2;
    }

    public void l(boolean z) {
        this.h.setVisibility(z ? 0 : 8);
    }

    public final void m(SearchModel searchModel) {
        if (NaviUtil.s0()) {
            if (NaviUtil.w0(this.f5652a, searchModel)) {
                this.d.setMaxWidth(this.f5652a.getResources().getDimensionPixelOffset(R.dimen.size_dp_60));
            } else {
                this.d.setMaxWidth(this.f5652a.getResources().getDimensionPixelOffset(R.dimen.size_dp_200));
            }
        }
    }

    public final void n(SearchModel searchModel) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
        int i2 = 0;
        boolean z = searchModel.getDistance() != -2;
        TextView textView = this.l;
        if (!z) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        layoutParams.width = z ? this.f5652a.getApplicationContext().getResources().getDimensionPixelOffset(R.dimen.size_dp_190) : this.f5652a.getApplicationContext().getResources().getDimensionPixelOffset(R.dimen.size_dp_70);
        this.k.setLayoutParams(layoutParams);
    }

    public final void o(SearchModel searchModel, TextView textView, boolean z) {
        PoiSearchManager.f().c(this.f5652a.getApplicationContext(), new ULatLng(searchModel.getLatitude(), searchModel.getLongitude()), new n(z, textView, searchModel));
    }
}

package com.upuphone.ar.navi.lite.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.util.NaviUtil;

public class MapPoiViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public Context f5648a;
    public AnimationSet b;
    public View c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public ImageView i;
    public TextView j;
    public View k;

    public MapPoiViewHolder(Context context, View view) {
        super(view);
        this.c = view;
        this.f5648a = context;
        this.d = (ImageView) view.findViewById(R.id.icon);
        this.e = (TextView) view.findViewById(R.id.poi_index);
        this.f = (TextView) view.findViewById(R.id.name);
        this.g = (TextView) view.findViewById(R.id.distance);
        this.h = (TextView) view.findViewById(R.id.address);
        this.k = view.findViewById(R.id.line);
        this.i = (ImageView) view.findViewById(R.id.icon_progress);
        this.j = (TextView) view.findViewById(R.id.more_menu_desp);
        d();
    }

    public void a(SearchModel searchModel, boolean z) {
        String name = searchModel.getName();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
        if (!TextUtils.isEmpty(searchModel.getKeywords())) {
            int length = searchModel.getKeywords().length();
            int indexOf = name.indexOf(searchModel.getKeywords());
            if (indexOf != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f5648a.getResources().getColor(R.color.search_highlight_color, (Resources.Theme) null)), indexOf, length + indexOf, 33);
            }
        }
        this.f.setText(spannableStringBuilder);
        this.g.setText(NaviUtil.r(this.f5648a, searchModel.getDistance()));
        this.h.setText(searchModel.getAddress());
        this.k.setVisibility(z ? 8 : 0);
    }

    public void b(int i2) {
        if (i2 == 0) {
            this.i.setVisibility(8);
            this.j.setText(this.f5648a.getString(R.string.more_search_results));
            return;
        }
        this.i.setVisibility(8);
        this.j.setText(this.f5648a.getString(R.string.loading_no_date));
        AnimationSet animationSet = this.b;
        if (animationSet != null) {
            animationSet.cancel();
            this.b.getAnimations().clear();
        }
    }

    public void c(SearchModel searchModel, int i2, int i3) {
        TextView textView = this.e;
        textView.setText((i2 + 1) + "");
        String name = searchModel.getName();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
        if (!TextUtils.isEmpty(searchModel.getKeywords())) {
            int length = searchModel.getKeywords().length();
            int indexOf = name.indexOf(searchModel.getKeywords());
            if (indexOf != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f5648a.getResources().getColor(R.color.search_highlight_color, (Resources.Theme) null)), indexOf, length + indexOf, 33);
            }
        }
        this.f.setText(spannableStringBuilder);
        this.g.setText(NaviUtil.r(this.f5648a, searchModel.getDistance()));
        this.h.setText(searchModel.getAddress());
        if (i2 == i3) {
            this.c.setBackgroundResource(i2 == 0 ? R.drawable.poi_mark_item_select_top : R.drawable.poi_mark_item_select_nor);
        } else {
            this.c.setBackgroundColor(this.f5648a.getResources().getColor(R.color.transparent, (Resources.Theme) null));
        }
    }

    public void d() {
        this.b = new AnimationSet(true);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setStartOffset(0);
        rotateAnimation.setDuration(500);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.addAnimation(rotateAnimation);
    }
}

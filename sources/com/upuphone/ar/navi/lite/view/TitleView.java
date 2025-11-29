package com.upuphone.ar.navi.lite.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.honey.account.o4.w;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.SettingActivity;
import com.upuphone.ar.navi.lite.util.CLog;

public class TitleView extends RelativeLayout implements View.OnClickListener {
    public static final String j = ("NAVI-" + TitleView.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public Context f5853a;
    public ImageView b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public boolean f;
    public boolean g;
    public Activity h;
    public OnMenueClickListener i;

    public interface OnMenueClickListener {
        void a(View view);
    }

    public TitleView(Context context) {
        super(context);
        this.f5853a = context;
        c(context);
    }

    public final void b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TitleView);
            this.b.setImageResource(obtainStyledAttributes.getResourceId(R.styleable.TitleView_title_icon, R.drawable.ic_arrow_back));
            this.c.setText(obtainStyledAttributes.getString(R.styleable.TitleView_title_summary));
            this.d.setText(obtainStyledAttributes.getResourceId(R.styleable.TitleView_title_icon, R.string.navi_app_name));
            int i2 = 0;
            this.f = obtainStyledAttributes.getBoolean(R.styleable.TitleView_title_task_back, false);
            boolean z = obtainStyledAttributes.getBoolean(R.styleable.TitleView_title_show_setting, false);
            this.g = z;
            ImageView imageView = this.e;
            if (!z) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
            obtainStyledAttributes.recycle();
        }
    }

    public final void c(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.title_panel_layout, this);
        ImageView imageView = (ImageView) findViewById(R.id.title_icon);
        this.b = imageView;
        imageView.setOnClickListener(this);
        this.c = (TextView) findViewById(R.id.title_summary);
        this.d = (TextView) findViewById(R.id.title_name);
        ImageView imageView2 = (ImageView) findViewById(R.id.right_icon);
        this.e = imageView2;
        imageView2.setOnClickListener(new w(this));
    }

    public final /* synthetic */ void d(View view) {
        e();
    }

    public final void e() {
        this.h.startActivityForResult(new Intent(this.h, SettingActivity.class), 0);
    }

    public Activity getActivity() {
        return this.h;
    }

    public OnMenueClickListener getOnMenueClickListener() {
        return this.i;
    }

    public ImageView getTitleIcon() {
        return this.b;
    }

    public TextView getTitleName() {
        return this.d;
    }

    public TextView getTitleSummary() {
        return this.c;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_icon) {
            OnMenueClickListener onMenueClickListener = this.i;
            if (onMenueClickListener != null) {
                onMenueClickListener.a(view);
                return;
            }
            Context context = this.f5853a;
            if (!(context instanceof Activity)) {
                CLog.a(j, "mContext instanceof Activity failed.");
            } else if (this.f) {
                ((Activity) context).moveTaskToBack(true);
            } else {
                ((Activity) context).finish();
            }
        }
    }

    public void setActivity(Activity activity) {
        this.h = activity;
    }

    public void setOnMenueClickListener(OnMenueClickListener onMenueClickListener) {
        this.i = onMenueClickListener;
    }

    public void setTitleIcon(int i2) {
        this.b.setImageResource(i2);
    }

    public void setTitleName(int i2) {
        this.d.setText(i2);
    }

    public void setTitleSummary(int i2) {
        this.c.setText(i2);
    }

    public void setTitleName(String str) {
        this.d.setText(str);
    }

    public void setTitleSummary(String str) {
        this.c.setText(str);
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5853a = context;
        c(context);
        b(context, attributeSet);
    }
}

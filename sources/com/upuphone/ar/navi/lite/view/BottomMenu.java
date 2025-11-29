package com.upuphone.ar.navi.lite.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.SearchModel;

public class BottomMenu implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f5817a;
    public View b;
    public Activity c;
    public OnClickListener d;
    public String e;
    public TextView f;
    public TextView g = ((TextView) this.b.findViewById(R.id.menu_edit));
    public TextView h = ((TextView) this.b.findViewById(R.id.menu_delete));
    public TextView i = ((TextView) this.b.findViewById(R.id.menu_cancel));
    public SearchModel j;

    public interface OnClickListener {
        void B(boolean z);

        void r(View view, String str, SearchModel searchModel);
    }

    public BottomMenu(Context context, String str, SearchModel searchModel, int i2, OnClickListener onClickListener) {
        LayoutInflater from = LayoutInflater.from(context);
        this.d = onClickListener;
        this.e = str;
        this.j = searchModel;
        this.c = (Activity) context;
        View inflate = from.inflate(R.layout.layout_pop_window, (ViewGroup) null);
        this.b = inflate;
        this.f = (TextView) inflate.findViewById(R.id.menu_add);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        b(i2);
        this.f5817a = new PopupWindow(this.b, -1, -2, true);
        this.f5817a.setBackgroundDrawable(new ColorDrawable(0));
        this.b.setOnTouchListener(this);
    }

    public void a() {
        this.f5817a.showAtLocation(((ViewGroup) this.c.findViewById(16908290)).getChildAt(0), 81, 0, 0);
        this.d.B(true);
    }

    public final void b(int i2) {
        int i3 = 0;
        this.g.setVisibility((i2 == 0 || i2 == 1) ? 0 : 8);
        this.h.setVisibility(i2 == 1 ? 0 : 8);
        TextView textView = this.f;
        if (i2 != 3) {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    public void onClick(View view) {
        this.d.B(false);
        this.f5817a.dismiss();
        if (view.getId() != R.id.menu_cancel) {
            this.d.r(view, this.e, this.j);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int top2 = this.b.findViewById(R.id.pop_layout).getTop();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 1 && y < top2) {
            this.f5817a.dismiss();
        }
        return true;
    }
}

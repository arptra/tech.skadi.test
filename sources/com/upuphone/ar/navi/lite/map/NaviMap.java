package com.upuphone.ar.navi.lite.map;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;

public class NaviMap {
    public static final String h = ("NAVI-" + NaviMap.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public Context f5777a;
    public List b = new ArrayList();
    public RelativeLayout c;
    public Point d = new Point();
    public View e;
    public View f;
    public boolean g = true;

    public NaviMap(Context context, RelativeLayout relativeLayout) {
        this.f5777a = context;
        this.c = relativeLayout;
    }

    public void a() {
        this.c.removeView(this.f);
        this.b.remove(this.f);
    }

    public void b() {
        this.c.removeView(this.e);
        this.b.remove(this.e);
    }

    public void c(boolean z) {
        this.g = z;
    }
}

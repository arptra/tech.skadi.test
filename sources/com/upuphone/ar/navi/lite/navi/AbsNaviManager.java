package com.upuphone.ar.navi.lite.navi;

import android.content.Context;
import com.upuphone.ar.navi.lite.base.UNaviPoi;
import com.upuphone.ar.navi.lite.model.INaviEvent;
import com.upuphone.ar.navi.lite.naviview.NaviView;
import com.upuphone.ar.navi.lite.protocol.NaviInfoBean;

public abstract class AbsNaviManager {

    /* renamed from: a  reason: collision with root package name */
    public Context f5786a;
    public NaviView b;
    public int c = 0;
    public int d = 0;
    public INaviEvent e;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 1;
    public boolean j = true;
    public boolean k = true;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;

    public abstract boolean A(int i2, int i3);

    public abstract void B(int i2);

    public abstract void C(boolean z, int i2, boolean z2);

    public abstract void D();

    public abstract void E(NaviView naviView);

    public abstract void F();

    public abstract void G(INaviEvent iNaviEvent);

    public abstract void H(int i2);

    public abstract void I(int i2);

    public abstract void J(NaviView naviView);

    public abstract void K();

    public abstract void L(int i2);

    public abstract void M();

    public abstract void N();

    public abstract void O();

    public abstract void a(UNaviPoi uNaviPoi, UNaviPoi uNaviPoi2, int i2);

    public abstract void b(UNaviPoi uNaviPoi, UNaviPoi uNaviPoi2);

    public abstract void c(UNaviPoi uNaviPoi, UNaviPoi uNaviPoi2);

    public abstract void d(NaviView naviView);

    public abstract void e();

    public abstract void f(NaviView naviView, int i2);

    public abstract int g(int i2);

    public abstract int h(int i2);

    public abstract NaviView i();

    public abstract String j(String str);

    public abstract String k(int i2);

    public abstract int l();

    public abstract NaviInfoBean m();

    public abstract String n(boolean z, int i2);

    public abstract int[] o();

    public abstract int p();

    public abstract String q();

    public abstract int r(int i2);

    public abstract int s(int i2);

    public abstract void t(Context context);

    public abstract void u(NaviView naviView);

    public abstract void v(int i2, boolean z);

    public abstract void w(Context context);

    public abstract boolean x();

    public abstract boolean y();

    public abstract boolean z(int i2);
}

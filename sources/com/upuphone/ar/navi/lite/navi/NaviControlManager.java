package com.upuphone.ar.navi.lite.navi;

import android.content.Context;
import com.upuphone.ar.navi.lite.base.UNaviPoi;
import com.upuphone.ar.navi.lite.manger.ManagerUtils;
import com.upuphone.ar.navi.lite.model.INaviEvent;
import com.upuphone.ar.navi.lite.naviview.NaviView;
import com.upuphone.ar.navi.lite.protocol.NaviInfoBean;

public class NaviControlManager implements INaviInterface {

    public static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final NaviControlManager f5790a = new NaviControlManager();
    }

    public static NaviControlManager k() {
        return InstanceHolder.f5790a;
    }

    public boolean A() {
        return m().y();
    }

    public boolean B(int i) {
        return m().z(i);
    }

    public boolean C(int i, int i2) {
        return m().A(i, i2);
    }

    public void D(int i) {
        m().B(i);
    }

    public void E(boolean z, int i, boolean z2) {
        m().C(z, i, z2);
    }

    public void F() {
        m().D();
    }

    public void G(NaviView naviView) {
        m().E(naviView);
    }

    public void H() {
        m().F();
    }

    public void I(INaviEvent iNaviEvent) {
        m().G(iNaviEvent);
    }

    public void J(int i) {
        m().H(i);
    }

    public void K(int i) {
        m().I(i);
    }

    public void L(NaviView naviView) {
        m().J(naviView);
    }

    public void M() {
        m().K();
    }

    public void N(int i) {
        m().L(i);
    }

    public void O() {
        m().M();
    }

    public void P() {
        m().N();
    }

    public void Q() {
        m().O();
    }

    public void a(UNaviPoi uNaviPoi, UNaviPoi uNaviPoi2, int i) {
        m().a(uNaviPoi, uNaviPoi2, i);
    }

    public void b(UNaviPoi uNaviPoi, UNaviPoi uNaviPoi2) {
        m().b(uNaviPoi, uNaviPoi2);
    }

    public void c(UNaviPoi uNaviPoi, UNaviPoi uNaviPoi2) {
        m().c(uNaviPoi, uNaviPoi2);
    }

    public void d(NaviView naviView) {
        m().d(naviView);
    }

    public void e() {
        m().e();
    }

    public void f(NaviView naviView, int i) {
        m().f(naviView, i);
    }

    public int g(int i) {
        return m().g(i);
    }

    public int h(int i) {
        return m().h(i);
    }

    public NaviView i() {
        return m().i();
    }

    public String j(String str) {
        return m().j(str);
    }

    public String l(int i) {
        return m().k(i);
    }

    public AbsNaviManager m() {
        return ManagerUtils.getNaviControlManager();
    }

    public int n() {
        return m().l();
    }

    public NaviInfoBean o() {
        return m().m();
    }

    public String p(boolean z, int i) {
        return m().n(z, i);
    }

    public int[] q() {
        return m().o();
    }

    public int r() {
        return m().p();
    }

    public String s() {
        return m().q();
    }

    public int t(int i) {
        return m().r(i);
    }

    public int u(int i) {
        return m().s(i);
    }

    public void v(Context context) {
        m().t(context);
    }

    public void w(NaviView naviView) {
        m().u(naviView);
    }

    public void x(int i, boolean z) {
        m().v(i, z);
    }

    public void y(Context context) {
        m().w(context);
    }

    public boolean z() {
        return m().x();
    }
}

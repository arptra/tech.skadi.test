package com.upuphone.ar.tici.phone.utils;

import android.content.Context;
import com.upuphone.ar.tici.phone.TiciApp;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u000f\u0010\u0003\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u000f\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u000f\u0010\u0015\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u000f\u0010\u0017\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0017\u0010\u0016\u001a\u000f\u0010\u0018\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0018\u0010\u0006\u001a\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\n\u001a\u000f\u0010\u001b\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u001b\u0010\r\u001a\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u001d\u0010\u0010\u001a\u000f\u0010\u001e\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0017\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0011H\u0000¢\u0006\u0004\b!\u0010\u0014\u001a\u000f\u0010\"\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\"\u0010\u0016\u001a\u0017\u0010#\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0011H\u0000¢\u0006\u0004\b#\u0010\u0014\u001a\u000f\u0010$\u001a\u00020\u0011H\u0000¢\u0006\u0004\b$\u0010\u0016\u001a\u0017\u0010%\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0004H\u0000¢\u0006\u0004\b%\u0010\n\u001a\u000f\u0010&\u001a\u00020\u0004H\u0000¢\u0006\u0004\b&\u0010\u0006\"\u0014\u0010*\u001a\u00020'8@X\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/SpUtil;", "l", "()Lcom/upuphone/ar/tici/phone/utils/SpUtil;", "d", "", "j", "()I", "mode", "", "t", "(I)V", "", "k", "()J", "speed", "u", "(J)V", "", "value", "q", "(Z)V", "g", "()Z", "b", "h", "location", "r", "f", "ticiId", "o", "a", "()V", "result", "p", "m", "s", "i", "n", "e", "Landroid/content/Context;", "c", "()Landroid/content/Context;", "context", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class SpUtilKt {
    public static final void a() {
        l().c();
    }

    public static final boolean b() {
        return !g();
    }

    public static final Context c() {
        return TiciApp.b.a();
    }

    public static final SpUtil d() {
        return SpUtil.b.a();
    }

    public static final int e() {
        return l().f();
    }

    public static final long f() {
        return l().h();
    }

    public static final boolean g() {
        return l().j();
    }

    public static final int h() {
        return l().k();
    }

    public static final boolean i() {
        return l().l();
    }

    public static final int j() {
        return l().n();
    }

    public static final long k() {
        return l().o();
    }

    public static final SpUtil l() {
        return SpUtil.b.c(TiciApp.b.g());
    }

    public static final boolean m() {
        return d().p();
    }

    public static final void n(int i) {
        l().u(i);
    }

    public static final void o(long j) {
        l().v(j);
    }

    public static final void p(boolean z) {
        d().w(z);
    }

    public static final void q(boolean z) {
        l().x(z);
    }

    public static final void r(int i) {
        l().y(i);
    }

    public static final void s(boolean z) {
        l().z(z);
    }

    public static final void t(int i) {
        l().A(i);
    }

    public static final void u(long j) {
        l().B(j);
    }
}

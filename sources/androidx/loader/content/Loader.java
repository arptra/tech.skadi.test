package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import androidx.core.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D> {

    /* renamed from: a  reason: collision with root package name */
    public int f1410a;
    public OnLoadCompleteListener b;
    public OnLoadCanceledListener c;
    public Context d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;

    public final class ForceLoadContentObserver extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Loader f1411a;

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            this.f1411a.o();
        }
    }

    public interface OnLoadCanceledListener<D> {
        void a(Loader loader);
    }

    public interface OnLoadCompleteListener<D> {
        void a(Loader loader, Object obj);
    }

    public void a() {
        this.f = true;
        m();
    }

    public boolean b() {
        return n();
    }

    public void c() {
        this.i = false;
    }

    public String d(Object obj) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.a(obj, sb);
        sb.append("}");
        return sb.toString();
    }

    public void e() {
        OnLoadCanceledListener onLoadCanceledListener = this.c;
        if (onLoadCanceledListener != null) {
            onLoadCanceledListener.a(this);
        }
    }

    public void f(Object obj) {
        OnLoadCompleteListener onLoadCompleteListener = this.b;
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.a(this, obj);
        }
    }

    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f1410a);
        printWriter.print(" mListener=");
        printWriter.println(this.b);
        if (this.e || this.h || this.i) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.e);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.h);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.i);
        }
        if (this.f || this.g) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f);
            printWriter.print(" mReset=");
            printWriter.println(this.g);
        }
    }

    public void h() {
        p();
    }

    public Context i() {
        return this.d;
    }

    public boolean j() {
        return this.f;
    }

    public boolean k() {
        return this.g;
    }

    public boolean l() {
        return this.e;
    }

    public void m() {
    }

    public boolean n() {
        return false;
    }

    public void o() {
        if (this.e) {
            h();
        } else {
            this.h = true;
        }
    }

    public void p() {
    }

    public void q() {
    }

    public void r() {
    }

    public void s() {
    }

    public void t() {
        q();
        this.g = true;
        this.e = false;
        this.f = false;
        this.h = false;
        this.i = false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.a(this, sb);
        sb.append(" id=");
        sb.append(this.f1410a);
        sb.append("}");
        return sb.toString();
    }

    public void u() {
        if (this.i) {
            o();
        }
    }

    public final void v() {
        this.e = true;
        this.g = false;
        this.f = false;
        r();
    }

    public void w() {
        this.e = false;
        s();
    }

    public boolean x() {
        boolean z = this.h;
        this.h = false;
        this.i |= z;
        return z;
    }

    public void y(OnLoadCompleteListener onLoadCompleteListener) {
        OnLoadCompleteListener onLoadCompleteListener2 = this.b;
        if (onLoadCompleteListener2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (onLoadCompleteListener2 == onLoadCompleteListener) {
            this.b = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }
}

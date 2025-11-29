package com.xingin.xhssharesdk.a;

import com.xingin.xhssharesdk.a.a;
import com.xingin.xhssharesdk.a.c0;
import com.xingin.xhssharesdk.a.j;
import com.xingin.xhssharesdk.a.k;
import com.xingin.xhssharesdk.a.k.a;
import com.xingin.xhssharesdk.a.r;
import com.xingin.xhssharesdk.a.w;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Map;

public abstract class k<MessageType extends k<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a<MessageType, BuilderType> {
    public z b = z.d;
    public int c = -1;

    public static abstract class a<MessageType extends k<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a.C0026a<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        public final k f8134a;
        public k b;
        public boolean c = false;

        public a(k kVar) {
            this.f8134a = kVar;
            this.b = (k) kVar.c(h.e);
        }

        public final a c(k kVar) {
            f();
            this.b.g(g.f8138a, kVar);
            return this;
        }

        public final Object clone() {
            a aVar = (a) this.f8134a.c(h.f);
            if (!this.c) {
                this.b.i();
                this.c = true;
            }
            aVar.c(this.b);
            return aVar;
        }

        public final k e() {
            if (!this.c) {
                this.b.i();
                this.c = true;
            }
            k kVar = this.b;
            if (kVar.h()) {
                return kVar;
            }
            throw new y();
        }

        public final void f() {
            if (this.c) {
                k kVar = (k) this.b.c(h.e);
                kVar.g(g.f8138a, this.b);
                this.b = kVar;
                this.c = false;
            }
        }

        public final k c() {
            return this.f8134a;
        }
    }

    public static class b<T extends k<T, ?>> extends b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final k f8135a;

        public b(k kVar) {
            this.f8135a = kVar;
        }

        public final k a(f fVar, i iVar) {
            k kVar = (k) this.f8135a.c(h.e);
            try {
                kVar.e(h.c, fVar, iVar);
                kVar.i();
                return kVar;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof m) {
                    throw ((m) e.getCause());
                }
                throw e;
            }
        }
    }

    public static class c implements i {

        /* renamed from: a  reason: collision with root package name */
        public static final c f8136a = new c();
        public static final a b = new a();

        public static final class a extends RuntimeException {
        }

        public final j a(j jVar, j jVar2) {
            if (jVar.equals(jVar2)) {
                return jVar;
            }
            throw b;
        }

        public final z b(z zVar, z zVar2) {
            if (zVar.equals(zVar2)) {
                return zVar;
            }
            throw b;
        }

        public final r c(k kVar, k kVar2) {
            if (kVar == null && kVar2 == null) {
                return null;
            }
            if (kVar == null || kVar2 == null) {
                throw b;
            }
            if (kVar != kVar2 && ((k) kVar.c(h.g)).getClass().isInstance(kVar2)) {
                kVar.g(this, kVar2);
            }
            return kVar;
        }

        public final String d(boolean z, String str, boolean z2, String str2) {
            if (z == z2 && str.equals(str2)) {
                return str;
            }
            throw b;
        }

        public final q e(q qVar, q qVar2) {
            if (qVar.equals(qVar2)) {
                return qVar;
            }
            throw b;
        }

        public final long f(boolean z, long j, boolean z2, long j2) {
            if (z == z2 && j == j2) {
                return j;
            }
            throw b;
        }

        public final int g(boolean z, int i, boolean z2, int i2) {
            if (z == z2 && i == i2) {
                return i;
            }
            throw b;
        }
    }

    public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType> extends k<MessageType, BuilderType> implements s {
        public j d;

        public final k c() {
            return (k) c(h.g);
        }

        public final /* bridge */ /* synthetic */ a d() {
            return d();
        }

        public final void g(i iVar, k kVar) {
            d dVar = (d) kVar;
            k.super.g(iVar, dVar);
            this.d = iVar.a(this.d, dVar.d);
        }

        public final void i() {
            k.super.i();
            this.d.h();
        }
    }

    public static final class e implements j.a<e> {
        public final void a() {
        }

        public final void b() {
        }

        public final c0.b c() {
            throw null;
        }

        public final int compareTo(Object obj) {
            ((e) obj).getClass();
            return 0;
        }

        public final a e(r.a aVar, r rVar) {
            return ((a) aVar).c((k) rVar);
        }
    }

    public static class f implements i {

        /* renamed from: a  reason: collision with root package name */
        public int f8137a = 0;

        public final j a(j jVar, j jVar2) {
            this.f8137a = jVar.f8133a.hashCode() + (this.f8137a * 53);
            return jVar;
        }

        public final z b(z zVar, z zVar2) {
            this.f8137a = zVar.hashCode() + (this.f8137a * 53);
            return zVar;
        }

        public final r c(k kVar, k kVar2) {
            int i;
            if (kVar != null) {
                if (kVar.f8121a == 0) {
                    int i2 = this.f8137a;
                    this.f8137a = 0;
                    kVar.g(this, kVar);
                    kVar.f8121a = this.f8137a;
                    this.f8137a = i2;
                }
                i = kVar.f8121a;
            } else {
                i = 37;
            }
            this.f8137a = (this.f8137a * 53) + i;
            return kVar;
        }

        public final String d(boolean z, String str, boolean z2, String str2) {
            this.f8137a = str.hashCode() + (this.f8137a * 53);
            return str;
        }

        public final q e(q qVar, q qVar2) {
            this.f8137a = qVar.hashCode() + (this.f8137a * 53);
            return qVar;
        }

        public final long f(boolean z, long j, boolean z2, long j2) {
            Charset charset = l.f8140a;
            this.f8137a = (this.f8137a * 53) + ((int) ((j >>> 32) ^ j));
            return j;
        }

        public final int g(boolean z, int i, boolean z2, int i2) {
            this.f8137a = (this.f8137a * 53) + i;
            return i;
        }
    }

    public static class g implements i {

        /* renamed from: a  reason: collision with root package name */
        public static final g f8138a = new g();

        public final j a(j jVar, j jVar2) {
            if (jVar.b) {
                jVar = jVar.clone();
            }
            for (int i = 0; i < jVar2.f8133a.b.size(); i++) {
                jVar.g((Map.Entry) jVar2.f8133a.b.get(i));
            }
            v vVar = jVar2.f8133a;
            for (Map.Entry g : vVar.c.isEmpty() ? w.a.b : vVar.c.entrySet()) {
                jVar.g(g);
            }
            return jVar;
        }

        public final z b(z zVar, z zVar2) {
            return zVar2 == z.d ? zVar : z.a(zVar, zVar2);
        }

        public final r c(k kVar, k kVar2) {
            if (kVar == null || kVar2 == null) {
                return kVar != null ? kVar : kVar2;
            }
            a d = kVar.d();
            d.getClass();
            if (d.f8134a.getClass().isInstance(kVar2)) {
                return d.c(kVar2).e();
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        public final String d(boolean z, String str, boolean z2, String str2) {
            return z2 ? str2 : str;
        }

        public final q e(q qVar, q qVar2) {
            if (!qVar2.isEmpty()) {
                if (!qVar.f8146a) {
                    qVar = qVar.isEmpty() ? new q() : new q(qVar);
                }
                qVar.a(qVar2);
            }
            return qVar;
        }

        public final long f(boolean z, long j, boolean z2, long j2) {
            return z2 ? j2 : j;
        }

        public final int g(boolean z, int i, boolean z2, int i2) {
            return z2 ? i2 : i;
        }
    }

    public enum h {
        f8139a,
        b,
        c,
        d,
        e,
        f,
        g,
        h;

        /* access modifiers changed from: public */
        h() {
        }
    }

    public interface i {
        j a(j jVar, j jVar2);

        z b(z zVar, z zVar2);

        r c(k kVar, k kVar2);

        String d(boolean z, String str, boolean z2, String str2);

        q e(q qVar, q qVar2);

        long f(boolean z, long j, boolean z2, long j2);

        int g(boolean z, int i, boolean z2, int i2);
    }

    public static Object f(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public final Object c(h hVar) {
        return e(hVar, (Object) null, (Object) null);
    }

    public abstract Object e(h hVar, Object obj, Object obj2);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((k) c(h.g)).getClass().isInstance(obj)) {
            return false;
        }
        try {
            g(c.f8136a, (k) obj);
            return true;
        } catch (c.a unused) {
            return false;
        }
    }

    public void g(i iVar, k kVar) {
        e(h.b, iVar, kVar);
        this.b = iVar.b(this.b, kVar.b);
    }

    public final boolean h() {
        return e(h.f8139a, Boolean.TRUE, (Object) null) != null;
    }

    public final int hashCode() {
        if (this.f8121a == 0) {
            f fVar = new f();
            g(fVar, this);
            this.f8121a = fVar.f8137a;
        }
        return this.f8121a;
    }

    public void i() {
        c(h.d);
        this.b.getClass();
    }

    /* renamed from: j */
    public final a d() {
        a aVar = (a) c(h.f);
        aVar.c(this);
        return aVar;
    }

    public final String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        t.a(this, sb, 0);
        return sb.toString();
    }

    public k c() {
        return (k) c(h.g);
    }
}

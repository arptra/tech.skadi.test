package org.zeromq;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.zeromq.ZMQ;
import org.zeromq.ZPoller;
import org.zeromq.ZStar;

public class ZActor extends ZStar {

    public interface Actor {
        boolean a(ZContext zContext, ZMQ.Socket socket, ZPoller zPoller);

        long b(ZMQ.Socket socket, ZPoller zPoller);

        boolean c(ZMQ.Socket socket, ZPoller zPoller);

        boolean d(ZMQ.Socket socket, ZMQ.Socket socket2, ZPoller zPoller, int i);

        boolean e(ZMQ.Socket socket, ZPoller zPoller, int i);

        String f(ZMQ.Socket socket);

        List g(ZContext zContext, Object... objArr);

        void h(ZMQ.Socket socket);

        boolean i(ZMQ.Socket socket);

        void j(ZMQ.Socket socket, List list, ZPoller zPoller);
    }

    public static final class ActorFortune implements ZStar.Fortune {

        /* renamed from: a  reason: collision with root package name */
        public final Actor f3473a;

        public ZStar.Star a(ZContext zContext, ZMQ.Socket socket, int i, ZStar.Star star, Object... objArr) {
            return new Double(zContext, socket, this.f3473a, objArr);
        }

        public String b(ZMQ.Socket socket, Object... objArr) {
            return this.f3473a.f(socket);
        }

        public boolean c(ZMQ.Socket socket) {
            return this.f3473a.i(socket);
        }

        public void e(ZContext zContext) {
        }
    }

    public static final class Double implements ZPoller.EventsHandler, ZStar.Star {

        /* renamed from: a  reason: collision with root package name */
        public final ZPoller f3474a;
        public final ZMQ.Socket b;
        public final List c;
        public final Actor d;
        public final ZContext e;

        public Double(ZContext zContext, ZMQ.Socket socket, Actor actor, Object... objArr) {
            this.e = zContext;
            this.b = socket;
            this.d = actor;
            this.c = new ArrayList(actor.g(zContext, objArr));
            ZPoller zPoller = new ZPoller(zContext);
            this.f3474a = zPoller;
            zPoller.s(this);
        }

        public boolean a(int i) {
            return i >= 0;
        }

        public boolean b() {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ZMQ.Socket socket = (ZMQ.Socket) it.next();
                it.remove();
                if (socket != null) {
                    this.f3474a.u(socket);
                    socket.close();
                    this.d.h(socket);
                }
            }
            return this.d.a(this.e, this.b, this.f3474a);
        }

        public boolean c() {
            return this.d.c(this.b, this.f3474a);
        }

        public boolean d(SelectableChannel selectableChannel, int i) {
            return true;
        }

        public boolean e(ZMQ.Socket socket, int i) {
            ZMQ.Socket socket2 = this.b;
            return socket != socket2 ? this.d.d(socket, socket2, this.f3474a, i) : this.d.e(socket2, this.f3474a, i);
        }

        public int f() {
            return this.f3474a.i(this.d.b(this.b, this.f3474a));
        }

        public void prepare() {
            this.f3474a.o(this.b, 1);
            this.d.j(this.b, Collections.unmodifiableList(this.c), this.f3474a);
        }
    }

    public static class Duo implements Actor {

        /* renamed from: a  reason: collision with root package name */
        public final Actor f3475a;
        public final Actor b;

        public boolean a(ZContext zContext, ZMQ.Socket socket, ZPoller zPoller) {
            this.b.a(zContext, socket, zPoller);
            return this.f3475a.a(zContext, socket, zPoller);
        }

        public long b(ZMQ.Socket socket, ZPoller zPoller) {
            this.b.b(socket, zPoller);
            return this.f3475a.b(socket, zPoller);
        }

        public boolean c(ZMQ.Socket socket, ZPoller zPoller) {
            this.b.c(socket, zPoller);
            return this.f3475a.c(socket, zPoller);
        }

        public boolean d(ZMQ.Socket socket, ZMQ.Socket socket2, ZPoller zPoller, int i) {
            this.b.d(socket, socket2, zPoller, i);
            return this.f3475a.d(socket, socket2, zPoller, i);
        }

        public boolean e(ZMQ.Socket socket, ZPoller zPoller, int i) {
            this.b.e(socket, zPoller, i);
            return this.f3475a.e(socket, zPoller, i);
        }

        public String f(ZMQ.Socket socket) {
            this.b.f(socket);
            return this.f3475a.f(socket);
        }

        public List g(ZContext zContext, Object... objArr) {
            this.b.g(zContext, objArr);
            return this.f3475a.g(zContext, objArr);
        }

        public void h(ZMQ.Socket socket) {
            this.b.h(socket);
            this.f3475a.h(socket);
        }

        public boolean i(ZMQ.Socket socket) {
            this.b.i(socket);
            return this.f3475a.i(socket);
        }

        public void j(ZMQ.Socket socket, List list, ZPoller zPoller) {
            this.b.j(socket, list, zPoller);
            this.f3475a.j(socket, list, zPoller);
        }
    }

    public static class SimpleActor implements Actor {
        public boolean a(ZContext zContext, ZMQ.Socket socket, ZPoller zPoller) {
            return false;
        }

        public long b(ZMQ.Socket socket, ZPoller zPoller) {
            return -1;
        }

        public boolean c(ZMQ.Socket socket, ZPoller zPoller) {
            return true;
        }

        public boolean d(ZMQ.Socket socket, ZMQ.Socket socket2, ZPoller zPoller, int i) {
            return false;
        }

        public boolean e(ZMQ.Socket socket, ZPoller zPoller, int i) {
            return false;
        }

        public String f(ZMQ.Socket socket) {
            return null;
        }

        public List g(ZContext zContext, Object... objArr) {
            return Collections.emptyList();
        }

        public void h(ZMQ.Socket socket) {
        }

        public boolean i(ZMQ.Socket socket) {
            return true;
        }

        public void j(ZMQ.Socket socket, List list, ZPoller zPoller) {
        }
    }
}

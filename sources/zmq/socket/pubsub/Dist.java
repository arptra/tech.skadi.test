package zmq.socket.pubsub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import zmq.Msg;
import zmq.pipe.Pipe;

public class Dist {

    /* renamed from: a  reason: collision with root package name */
    public final List f3661a = new ArrayList();
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public boolean e = false;

    public void a(Pipe pipe) {
        if (this.d < this.f3661a.size()) {
            List list = this.f3661a;
            Collections.swap(list, list.indexOf(pipe), this.d);
            this.d++;
        }
        if (!this.e && this.c < this.f3661a.size()) {
            Collections.swap(this.f3661a, this.d - 1, this.c);
            this.c++;
        }
    }

    public void b(Pipe pipe) {
        if (this.e) {
            this.f3661a.add(pipe);
            List list = this.f3661a;
            Collections.swap(list, this.d, list.size() - 1);
            this.d++;
            return;
        }
        this.f3661a.add(pipe);
        List list2 = this.f3661a;
        Collections.swap(list2, this.c, list2.size() - 1);
        this.c++;
        this.d++;
    }

    public boolean c() {
        for (int i = 0; i < this.b; i++) {
            if (!((Pipe) this.f3661a.get(i)).f1()) {
                return false;
            }
        }
        return true;
    }

    public final void d(Msg msg) {
        if (this.b != 0) {
            int i = 0;
            while (i < this.b) {
                if (!k((Pipe) this.f3661a.get(i), msg)) {
                    i--;
                }
                i++;
            }
        }
    }

    public boolean e() {
        return true;
    }

    public void f(Pipe pipe) {
        int indexOf = this.f3661a.indexOf(pipe);
        int i = this.b;
        if (indexOf >= i && indexOf < this.d) {
            Collections.swap(this.f3661a, indexOf, i);
            this.b++;
        }
    }

    public boolean g(Msg msg) {
        this.b = this.c;
        return h(msg);
    }

    public boolean h(Msg msg) {
        boolean n = msg.n();
        d(msg);
        if (!n) {
            this.c = this.d;
        }
        this.e = n;
        return true;
    }

    public void i(Pipe pipe) {
        if (this.f3661a.indexOf(pipe) < this.b) {
            List list = this.f3661a;
            Collections.swap(list, list.indexOf(pipe), this.b - 1);
            this.b--;
        }
        if (this.f3661a.indexOf(pipe) < this.c) {
            List list2 = this.f3661a;
            Collections.swap(list2, list2.indexOf(pipe), this.c - 1);
            this.c--;
        }
        if (this.f3661a.indexOf(pipe) < this.d) {
            List list3 = this.f3661a;
            Collections.swap(list3, list3.indexOf(pipe), this.d - 1);
            this.d--;
        }
        this.f3661a.remove(pipe);
    }

    public void j() {
        this.b = 0;
    }

    public final boolean k(Pipe pipe, Msg msg) {
        if (!pipe.C1(msg)) {
            List list = this.f3661a;
            Collections.swap(list, list.indexOf(pipe), this.b - 1);
            this.b--;
            List list2 = this.f3661a;
            Collections.swap(list2, list2.indexOf(pipe), this.c - 1);
            int i = this.c - 1;
            this.c = i;
            Collections.swap(this.f3661a, i, this.d - 1);
            this.d--;
            return false;
        }
        if (!msg.n()) {
            pipe.flush();
        }
        return true;
    }
}

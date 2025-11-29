package zmq.socket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import zmq.Msg;
import zmq.pipe.Pipe;
import zmq.util.Blob;
import zmq.util.Errno;
import zmq.util.ValueReference;

public class FQ {

    /* renamed from: a  reason: collision with root package name */
    public final List f3657a = new ArrayList();
    public int b = 0;
    public Pipe c;
    public int d = 0;
    public boolean e = false;
    public Blob f;

    public void a(Pipe pipe) {
        List list = this.f3657a;
        Collections.swap(list, list.indexOf(pipe), this.b);
        this.b++;
    }

    public void b(Pipe pipe) {
        this.f3657a.add(pipe);
        List list = this.f3657a;
        Collections.swap(list, this.b, list.size() - 1);
        this.b++;
    }

    public boolean c() {
        if (this.e) {
            return true;
        }
        while (this.b > 0) {
            if (((Pipe) this.f3657a.get(this.d)).g1()) {
                return true;
            }
            int i = this.b - 1;
            this.b = i;
            Collections.swap(this.f3657a, this.d, i);
            if (this.d == this.b) {
                this.d = 0;
            }
        }
        return false;
    }

    public Msg d(Errno errno) {
        return e(errno, (ValueReference) null);
    }

    public Msg e(Errno errno, ValueReference valueReference) {
        while (this.b > 0) {
            Pipe pipe = (Pipe) this.f3657a.get(this.d);
            Msg q1 = pipe.q1();
            if (q1 != null) {
                if (valueReference != null) {
                    valueReference.b(pipe);
                }
                boolean n = q1.n();
                this.e = n;
                if (!n) {
                    this.c = pipe;
                    this.d = (this.d + 1) % this.b;
                }
                return q1;
            }
            int i = this.b - 1;
            this.b = i;
            Collections.swap(this.f3657a, this.d, i);
            if (this.d == this.b) {
                this.d = 0;
            }
        }
        errno.c(35);
        return null;
    }

    public void f(Pipe pipe) {
        int indexOf = this.f3657a.indexOf(pipe);
        int i = this.b;
        if (indexOf < i) {
            int i2 = i - 1;
            this.b = i2;
            Collections.swap(this.f3657a, indexOf, i2);
            if (this.d == this.b) {
                this.d = 0;
            }
        }
        this.f3657a.remove(pipe);
        Pipe pipe2 = this.c;
        if (pipe2 == pipe) {
            this.f = pipe2.j1();
            this.c = null;
        }
    }
}

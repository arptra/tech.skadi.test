package zmq.socket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import zmq.Msg;
import zmq.pipe.Pipe;
import zmq.util.Errno;
import zmq.util.ValueReference;

public class LB {

    /* renamed from: a  reason: collision with root package name */
    public final List f3658a = new ArrayList();
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;

    public void a(Pipe pipe) {
        List list = this.f3658a;
        Collections.swap(list, list.indexOf(pipe), this.b);
        this.b++;
    }

    public void b(Pipe pipe) {
        this.f3658a.add(pipe);
        a(pipe);
    }

    public boolean c() {
        if (this.d) {
            return true;
        }
        while (this.b > 0) {
            if (((Pipe) this.f3658a.get(this.c)).h1()) {
                return true;
            }
            int i = this.b - 1;
            this.b = i;
            Collections.swap(this.f3658a, this.c, i);
            if (this.c == this.b) {
                this.c = 0;
            }
        }
        return false;
    }

    public boolean d(Msg msg, Errno errno, ValueReference valueReference) {
        if (this.e) {
            boolean n = msg.n();
            this.d = n;
            this.e = n;
            return true;
        }
        while (true) {
            if (this.b <= 0) {
                break;
            } else if (!((Pipe) this.f3658a.get(this.c)).C1(msg)) {
                int i = this.b - 1;
                this.b = i;
                int i2 = this.c;
                if (i2 < i) {
                    Collections.swap(this.f3658a, i2, i);
                } else {
                    this.c = 0;
                }
            } else if (valueReference != null) {
                valueReference.b((Pipe) this.f3658a.get(this.c));
            }
        }
        if (this.b == 0) {
            errno.c(35);
            return false;
        }
        boolean n2 = msg.n();
        this.d = n2;
        if (!n2) {
            ((Pipe) this.f3658a.get(this.c)).flush();
            int i3 = this.c + 1;
            this.c = i3;
            if (i3 >= this.b) {
                this.c = 0;
            }
        }
        return true;
    }

    public void e(Pipe pipe) {
        int indexOf = this.f3658a.indexOf(pipe);
        if (indexOf == this.c && this.d) {
            this.e = true;
        }
        int i = this.b;
        if (indexOf < i) {
            int i2 = i - 1;
            this.b = i2;
            Collections.swap(this.f3658a, indexOf, i2);
            if (this.c == this.b) {
                this.c = 0;
            }
        }
        this.f3658a.remove(pipe);
    }
}

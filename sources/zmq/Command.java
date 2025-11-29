package zmq;

public class Command {

    /* renamed from: a  reason: collision with root package name */
    public final ZObject f3593a;
    public final Type b;
    public final Object c;

    public enum Type {
        STOP,
        PLUG,
        OWN,
        ATTACH,
        BIND,
        ACTIVATE_READ,
        ACTIVATE_WRITE,
        HICCUP,
        PIPE_TERM,
        PIPE_TERM_ACK,
        TERM_REQ,
        TERM,
        TERM_ACK,
        REAP,
        REAP_ACK,
        REAPED,
        INPROC_CONNECTED,
        DONE,
        CANCEL
    }

    public Command(ZObject zObject, Type type) {
        this(zObject, type, (Object) null);
    }

    public final void a() {
        this.f3593a.d0(this);
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("Cmd[");
        sb.append(this.f3593a);
        sb.append(", ");
        if (this.f3593a == null) {
            str = "Reaper";
        } else {
            str = this.f3593a.z() + ", ";
        }
        sb.append(str);
        sb.append(this.b);
        if (this.c == null) {
            str2 = "";
        } else {
            str2 = ", " + this.c;
        }
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }

    public Command(ZObject zObject, Type type, Object obj) {
        this.f3593a = zObject;
        this.b = type;
        this.c = obj;
    }
}

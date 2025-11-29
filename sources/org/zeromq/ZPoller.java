package org.zeromq;

import java.io.Closeable;
import java.nio.channels.SelectableChannel;
import java.nio.channels.Selector;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.zeromq.ZMQ;
import zmq.poll.PollItem;
import zmq.util.Objects;
import zmq.util.function.BiFunction;

public class ZPoller implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final Selector f3504a;
    public final ItemCreator b;
    public final Map c;
    public final Set d;
    public EventsHandler e;

    public static class ComposeEventsHandler implements EventsHandler {

        /* renamed from: a  reason: collision with root package name */
        public final BiFunction f3505a;
        public final BiFunction b;

        public boolean d(SelectableChannel selectableChannel, int i) {
            return ((Boolean) this.b.apply(selectableChannel, Integer.valueOf(i))).booleanValue();
        }

        public boolean e(ZMQ.Socket socket, int i) {
            return ((Boolean) this.f3505a.apply(socket, Integer.valueOf(i))).booleanValue();
        }
    }

    public static class CompositePollItem implements ItemHolder, EventsHandler {

        /* renamed from: a  reason: collision with root package name */
        public final Collection f3506a = new HashSet();
        public final ZMQ.Socket b;
        public final SelectableChannel c;
        public PollItem d;
        public EventsHandler e;

        public CompositePollItem(Object obj) {
            SelectableChannel selectableChannel = null;
            this.b = obj instanceof ZMQ.Socket ? (ZMQ.Socket) obj : null;
            this.c = obj instanceof SelectableChannel ? (SelectableChannel) obj : selectableChannel;
        }

        public PollItem a() {
            if (this.d == null) {
                this.d = f();
            }
            return this.d;
        }

        public boolean d(SelectableChannel selectableChannel, int i) {
            boolean z = true;
            boolean z2 = false;
            for (ItemHolder itemHolder : this.f3506a) {
                if (itemHolder.a().c(i)) {
                    EventsHandler handler = itemHolder.handler() == null ? this.e : itemHolder.handler();
                    if (handler != null) {
                        boolean d2 = handler.d(selectableChannel, i);
                        if (z) {
                            z = false;
                            z2 = d2;
                        } else {
                            z2 &= d2;
                        }
                    }
                }
            }
            return z2;
        }

        public boolean e(ZMQ.Socket socket, int i) {
            boolean z = false;
            boolean z2 = true;
            for (ItemHolder itemHolder : this.f3506a) {
                if (itemHolder.a().c(i)) {
                    if (z2) {
                        z2 = false;
                        z = true;
                    }
                    EventsHandler handler = itemHolder.handler() == null ? this.e : itemHolder.handler();
                    if (handler != null) {
                        z &= handler.e(socket, i);
                    }
                }
            }
            return z;
        }

        public final PollItem f() {
            ZMQ.Socket socket = this.b;
            return socket == null ? new PollItem(this.c, h()) : new PollItem(socket.b(), h());
        }

        public final ItemHolder g(EventsHandler eventsHandler) {
            this.e = eventsHandler;
            return this;
        }

        public final int h() {
            int i = 0;
            for (ItemHolder a2 : this.f3506a) {
                i |= a2.a().j();
            }
            return i;
        }

        public EventsHandler handler() {
            return this;
        }

        public ZMQ.Socket socket() {
            return this.b;
        }
    }

    public interface EventsHandler {
        boolean d(SelectableChannel selectableChannel, int i);

        boolean e(ZMQ.Socket socket, int i);
    }

    public interface ItemCreator {
        ItemHolder a(ZMQ.Socket socket, EventsHandler eventsHandler, int i);
    }

    public interface ItemHolder {
        PollItem a();

        EventsHandler handler();

        ZMQ.Socket socket();
    }

    public static class SimpleCreator implements ItemCreator {
        public ItemHolder a(ZMQ.Socket socket, EventsHandler eventsHandler, int i) {
            return new ZPollItem(socket, eventsHandler, i);
        }
    }

    public static class ZPollItem extends ZMQ.PollItem implements ItemHolder {
        public final EventsHandler c;

        public ZPollItem(ZMQ.Socket socket, EventsHandler eventsHandler, int i) {
            super(socket, i);
            this.c = eventsHandler;
        }

        public PollItem a() {
            return b();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof ItemHolder)) {
                return false;
            }
            ItemHolder itemHolder = (ItemHolder) obj;
            if (itemHolder.a() == null) {
                return false;
            }
            if (a().b() == null) {
                if (itemHolder.a().b() != null) {
                    return false;
                }
            } else if (!a().b().equals(itemHolder.a().b())) {
                return false;
            }
            if (socket() == null) {
                if (itemHolder.socket() != null) {
                    return false;
                }
            } else if (!socket().equals(itemHolder.socket())) {
                return false;
            }
            if (handler() == null) {
                if (itemHolder.handler() != null) {
                    return false;
                }
            } else if (!handler().equals(itemHolder.handler())) {
                return false;
            }
            return true;
        }

        public EventsHandler handler() {
            return this.c;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((a() == null ? 0 : a().hashCode()) + 31) * 31) + (c() == null ? 0 : c().hashCode())) * 31) + (socket() == null ? 0 : socket().hashCode())) * 31;
            if (handler() != null) {
                i = handler().hashCode();
            }
            return hashCode + i;
        }

        public ZMQ.Socket socket() {
            return d();
        }
    }

    public ZPoller(ZContext zContext) {
        this(new SimpleCreator(), zContext);
    }

    public boolean a(Object obj, ItemHolder itemHolder) {
        if (obj == null) {
            ZMQ.Socket socket = itemHolder.socket();
            SelectableChannel b2 = itemHolder.a().b();
            if (b2 == null) {
                obj = socket;
            } else if (socket == null) {
                obj = b2;
            }
        }
        CompositePollItem compositePollItem = (CompositePollItem) this.c.get(obj);
        if (compositePollItem == null) {
            compositePollItem = new CompositePollItem(obj);
            this.c.put(obj, compositePollItem);
        }
        boolean add = compositePollItem.f3506a.add(itemHolder);
        if (add) {
            this.d.add(compositePollItem);
        }
        return add;
    }

    public ItemHolder b(ZMQ.Socket socket, EventsHandler eventsHandler, int i) {
        Objects.a(socket, "Socket has to be non-null");
        return this.b.a(socket, eventsHandler, i);
    }

    public void c() {
    }

    public void close() {
        c();
    }

    public boolean d(Collection collection, int i) {
        int h;
        for (ItemHolder itemHolder : (ItemHolder[]) collection.toArray(new ItemHolder[collection.size()])) {
            EventsHandler handler = itemHolder.handler();
            if (handler == null) {
                handler = this.e;
            }
            if (handler != null && (h = itemHolder.a().h()) > 0) {
                ZMQ.Socket socket = itemHolder.socket();
                SelectableChannel b2 = itemHolder.a().b();
                if (socket != null && !handler.e(socket, h)) {
                    return false;
                }
                if (b2 != null && !handler.d(b2, h)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean g(Set set, int i) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ItemHolder unused = ((CompositePollItem) it.next()).g(this.e);
        }
        return d(set, i);
    }

    public int i(long j) {
        return j(j, true);
    }

    public int j(long j, boolean z) {
        HashSet hashSet = new HashSet();
        for (CompositePollItem a2 : this.d) {
            hashSet.add(a2.a());
        }
        int n = n(this.f3504a, j, hashSet);
        if (z && !g(this.d, hashSet.size())) {
            return -1;
        }
        return n;
    }

    public int n(Selector selector, long j, Collection collection) {
        int size = collection.size();
        return zmq.ZMQ.d(selector, (PollItem[]) collection.toArray(new PollItem[size]), size, j);
    }

    public final boolean o(ZMQ.Socket socket, int i) {
        return r(socket, this.e, i);
    }

    public final boolean r(ZMQ.Socket socket, EventsHandler eventsHandler, int i) {
        if (socket == null) {
            return false;
        }
        return a(socket, b(socket, eventsHandler, i));
    }

    public void s(EventsHandler eventsHandler) {
        this.e = eventsHandler;
    }

    public final boolean u(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        CompositePollItem compositePollItem = (CompositePollItem) this.c.remove(obj);
        if (compositePollItem != null) {
            z = true;
        }
        if (z) {
            this.d.remove(compositePollItem);
        }
        return z;
    }

    public ZPoller(ItemCreator itemCreator, ZContext zContext) {
        this(itemCreator, zContext, zContext.i());
    }

    public ZPoller(ItemCreator itemCreator, ZContext zContext, Selector selector) {
        Objects.a(itemCreator, "Item creator is mandatory for ZPoller");
        Objects.a(selector, "Selector is mandatory for ZPoller");
        this.b = itemCreator;
        this.f3504a = selector;
        this.c = new HashMap();
        this.d = new HashSet();
    }
}

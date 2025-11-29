package zmq.socket;

import java.util.Arrays;
import java.util.List;
import zmq.Ctx;
import zmq.Options;
import zmq.SocketBase;
import zmq.io.HelloMsgSession;
import zmq.io.IOThread;
import zmq.io.SessionBase;
import zmq.io.net.Address;
import zmq.socket.clientserver.Client;
import zmq.socket.clientserver.Server;
import zmq.socket.pipeline.Pull;
import zmq.socket.pipeline.Push;
import zmq.socket.pubsub.Pub;
import zmq.socket.pubsub.Sub;
import zmq.socket.pubsub.XPub;
import zmq.socket.pubsub.XSub;
import zmq.socket.radiodish.Dish;
import zmq.socket.radiodish.Radio;
import zmq.socket.reqrep.Dealer;
import zmq.socket.reqrep.Rep;
import zmq.socket.reqrep.Req;
import zmq.socket.reqrep.Router;
import zmq.socket.scattergather.Gather;
import zmq.socket.scattergather.Scatter;

public enum Sockets {
    PAIR("PAIR") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Pair(ctx, i, i2);
        }
    },
    PUB("SUB", "XSUB") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Pub(ctx, i, i2);
        }
    },
    SUB("PUB", "XPUB") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Sub(ctx, i, i2);
        }
    },
    REQ("REP", "ROUTER") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Req(ctx, i, i2);
        }

        public SessionBase create(IOThread iOThread, boolean z, SocketBase socketBase, Options options, Address address) {
            return new Req.ReqSession(iOThread, z, socketBase, options, address);
        }
    },
    REP("REQ", "DEALER") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Rep(ctx, i, i2);
        }
    },
    DEALER("REP", "DEALER", "ROUTER") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Dealer(ctx, i, i2);
        }
    },
    ROUTER("REQ", "DEALER", "ROUTER") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Router(ctx, i, i2);
        }
    },
    PULL("PUSH") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Pull(ctx, i, i2);
        }
    },
    PUSH("PULL") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Push(ctx, i, i2);
        }
    },
    XPUB("SUB", "XSUB") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new XPub(ctx, i, i2);
        }
    },
    XSUB("PUB", "XPUB") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new XSub(ctx, i, i2);
        }
    },
    STREAM(new String[0]) {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Stream(ctx, i, i2);
        }
    },
    SERVER("CLIENT") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Server(ctx, i, i2);
        }
    },
    CLIENT("SERVER") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Client(ctx, i, i2);
        }
    },
    RADIO("DISH") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Radio(ctx, i, i2);
        }

        public SessionBase create(IOThread iOThread, boolean z, SocketBase socketBase, Options options, Address address) {
            return new Radio.RadioSession(iOThread, z, socketBase, options, address);
        }
    },
    DISH("RADIO") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Dish(ctx, i, i2);
        }

        public SessionBase create(IOThread iOThread, boolean z, SocketBase socketBase, Options options, Address address) {
            return new Dish.DishSession(iOThread, z, socketBase, options, address);
        }
    },
    CHANNEL("CHANNEL") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Channel(ctx, i, i2);
        }
    },
    PEER("PEER") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Peer(ctx, i, i2);
        }
    },
    RAW(new String[0]) {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Raw(ctx, i, i2);
        }
    },
    SCATTER("GATHER") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Scatter(ctx, i, i2);
        }
    },
    GATHER("SCATTER") {
        public SocketBase create(Ctx ctx, int i, int i2) {
            return new Gather(ctx, i, i2);
        }
    };
    
    private final List<String> compatible;

    public static boolean compatible(int i, String str) {
        return values()[i].compatible.contains(str);
    }

    public static SessionBase createSession(IOThread iOThread, boolean z, SocketBase socketBase, Options options, Address address) {
        return values()[options.m].create(iOThread, z, socketBase, options, address);
    }

    public static Sockets fromType(int i) {
        return values()[i];
    }

    public static String name(int i) {
        return values()[i].name();
    }

    public abstract SocketBase create(Ctx ctx, int i, int i2);

    public SessionBase create(IOThread iOThread, boolean z, SocketBase socketBase, Options options, Address address) {
        if (!options.d0 || options.c0 == null) {
            return new SessionBase(iOThread, z, socketBase, options, address);
        }
        return new HelloMsgSession(iOThread, z, socketBase, options, address);
    }

    private Sockets(String... strArr) {
        this.compatible = Arrays.asList(strArr);
    }

    public static SocketBase create(int i, Ctx ctx, int i2, int i3) {
        return values()[i].create(ctx, i2, i3);
    }
}

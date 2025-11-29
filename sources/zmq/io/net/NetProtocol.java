package zmq.io.net;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import zmq.Options;
import zmq.SocketBase;
import zmq.io.IOThread;
import zmq.io.net.Address;
import zmq.io.net.ipc.IpcAddress;
import zmq.io.net.ipc.IpcListener;
import zmq.io.net.tcp.TcpAddress;
import zmq.io.net.tcp.TcpListener;
import zmq.io.net.tipc.TipcListener;
import zmq.socket.Sockets;

public enum NetProtocol {
    inproc(true, false, false, new Sockets[0]),
    ipc(true, false, false, new Sockets[0]) {
        public Listener getListener(IOThread iOThread, SocketBase socketBase, Options options) {
            return new IpcListener(iOThread, socketBase, options);
        }

        public void resolve(Address address, boolean z) {
            address.e(z);
        }

        public Address.IZAddress zresolve(String str, boolean z) {
            return new IpcAddress(str);
        }
    },
    tcp(true, false, false, new Sockets[0]) {
        public Listener getListener(IOThread iOThread, SocketBase socketBase, Options options) {
            return new TcpListener(iOThread, socketBase, options);
        }

        public void resolve(Address address, boolean z) {
            address.e(z);
        }

        public Address.IZAddress zresolve(String str, boolean z) {
            return new TcpAddress(str, z);
        }
    },
    pgm(false, true, true, r1, r2, r3, r3),
    epgm(false, true, true, r1, r2, r3, r3),
    tipc(false, false, false, new Sockets[0]) {
        public Listener getListener(IOThread iOThread, SocketBase socketBase, Options options) {
            return new TipcListener(iOThread, socketBase, options);
        }

        public void resolve(Address address, boolean z) {
            address.e(z);
        }
    },
    norm(false, true, true, new Sockets[0]);
    
    private Set<Integer> compatibles;
    public final boolean isMulticast;
    public final boolean subscribe2all;
    public final boolean valid;

    public static NetProtocol getProtocol(String str) {
        try {
            return valueOf(str.toLowerCase(Locale.ENGLISH));
        } catch (IllegalArgumentException | NullPointerException unused) {
            throw new IllegalArgumentException("Unknown protocol: \"" + str + "\"");
        }
    }

    public final boolean compatible(int i) {
        return this.compatibles.isEmpty() || this.compatibles.contains(Integer.valueOf(i));
    }

    public Listener getListener(IOThread iOThread, SocketBase socketBase, Options options) {
        return null;
    }

    public void resolve(Address address, boolean z) {
    }

    public Address.IZAddress zresolve(String str, boolean z) {
        return null;
    }

    private NetProtocol(boolean z, boolean z2, boolean z3, Sockets... socketsArr) {
        this.valid = z;
        this.compatibles = new HashSet(socketsArr.length);
        for (Sockets ordinal : socketsArr) {
            this.compatibles.add(Integer.valueOf(ordinal.ordinal()));
        }
        this.subscribe2all = z2;
        this.isMulticast = z3;
    }
}

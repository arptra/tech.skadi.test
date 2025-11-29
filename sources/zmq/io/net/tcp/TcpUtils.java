package zmq.io.net.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Channel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import zmq.ZError;

public class TcpUtils {

    public interface OptionSetter<S> {
        void a(Object obj);
    }

    public static void A(SocketChannel socketChannel) {
        u(socketChannel, new d());
    }

    public static void B(SelectableChannel... selectableChannelArr) {
        for (SelectableChannel configureBlocking : selectableChannelArr) {
            configureBlocking.configureBlocking(false);
        }
    }

    public static void j(SelectableChannel selectableChannel) {
    }

    public static /* synthetic */ void l(ServerSocket serverSocket) {
    }

    public static /* synthetic */ void r(int i, Socket socket) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        socket.setKeepAlive(z);
    }

    public static boolean t(Channel channel, int i) {
        u(channel, new h(i));
        return true;
    }

    public static void u(Channel channel, OptionSetter optionSetter) {
        v(channel, optionSetter, new i());
    }

    public static void v(Channel channel, OptionSetter optionSetter, OptionSetter optionSetter2) {
        try {
            if (channel instanceof ServerSocketChannel) {
                optionSetter2.a(((ServerSocketChannel) channel).socket());
            } else if (channel instanceof SocketChannel) {
                optionSetter.a(((SocketChannel) channel).socket());
            }
        } catch (IOException e) {
            throw new ZError.IOException(e);
        }
    }

    public static boolean w(Channel channel, boolean z) {
        v(channel, new f(z), new g(z));
        return true;
    }

    public static boolean x(Channel channel, int i) {
        v(channel, new b(i), new c(i));
        return true;
    }

    public static boolean y(Channel channel, int i) {
        u(channel, new a(i));
        return true;
    }

    public static void z(SocketChannel socketChannel, int i, int i2, int i3, int i4) {
        u(socketChannel, new e(i));
    }
}

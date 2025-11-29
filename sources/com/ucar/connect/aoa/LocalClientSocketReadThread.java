package com.ucar.connect.aoa;

import com.easy.logger.EasyLog;
import com.ucar.protocol.channel.socket.SocketChannel;
import java.io.IOException;
import java.net.Socket;

public class LocalClientSocketReadThread extends SocketReadThread {
    public LocalClientSocketReadThread(int i, String str, int i2, int i3) {
        super(i, str, i2);
        r(2);
        if (d() == -1) {
            EasyLog.c("AOALocalClientSocketReadThread", "invalid channel id");
        }
        q(i3);
    }

    public void b() {
        EasyLog.a("AOALocalClientSocketReadThread", "Cancel " + i() + " read thread.");
        super.b();
    }

    public Socket u() {
        int i = 20;
        while (true) {
            int i2 = i - 1;
            if (i <= 0 || !j()) {
                EasyLog.c("AOALocalClientSocketReadThread", "Connect socket error: " + f());
            } else {
                try {
                    Socket socket = new Socket();
                    socket.connect(SocketChannel.G0("127.0.0.1", g()), 100);
                    socket.setTcpNoDelay(true);
                    socket.setSendBufferSize(327680);
                    socket.setReceiveBufferSize(327680);
                    return socket;
                } catch (IOException e) {
                    EasyLog.b("AOALocalClientSocketReadThread", "start Connect socket fail " + f(), e);
                    try {
                        if (j()) {
                            Thread.sleep(100);
                        }
                    } catch (InterruptedException e2) {
                        EasyLog.b("AOALocalClientSocketReadThread", "sleep exception: " + f(), e2);
                    }
                    i = i2;
                }
            }
        }
        EasyLog.c("AOALocalClientSocketReadThread", "Connect socket error: " + f());
        return null;
    }
}

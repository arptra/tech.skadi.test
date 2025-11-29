package com.ucar.connect.aoa;

import com.easy.logger.EasyLog;
import com.ucar.protocol.channel.socket.SocketChannel;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LocalServerSocketReadThread extends SocketReadThread {
    public ServerSocket n = null;

    public LocalServerSocketReadThread(int i, String str, int i2) {
        super(i, str, -1);
        try {
            ServerSocket serverSocket = new ServerSocket();
            this.n = serverSocket;
            serverSocket.setReuseAddress(true);
            this.n.bind(SocketChannel.G0("127.0.0.1", i));
        } catch (Exception e) {
            EasyLog.d("AOALocalServerSocketReadThread", "Create " + str + " fail.", e);
        }
        r(1);
        q(i2);
    }

    public void b() {
        EasyLog.a("AOALocalServerSocketReadThread", "Cancel " + i() + " read thread.");
        super.b();
        ServerSocket serverSocket = this.n;
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                EasyLog.d("AOALocalServerSocketReadThread", "Close " + i() + " server socket fail", e);
            }
        }
    }

    public void n() {
        w();
    }

    public Socket u() {
        try {
            if (this.n == null || !j()) {
                return null;
            }
            Socket accept = this.n.accept();
            if (accept == null) {
                EasyLog.a("AOALocalServerSocketReadThread", "One client connected fail: " + i());
            }
            EasyLog.a("AOALocalServerSocketReadThread", "One client connected in " + i());
            accept.setTcpNoDelay(true);
            accept.setSendBufferSize(327680);
            accept.setReceiveBufferSize(327680);
            return accept;
        } catch (Exception e) {
            EasyLog.d("AOALocalServerSocketReadThread", "Get Exception in accept:" + i(), e);
            return null;
        }
    }

    public final void w() {
        int a2 = a(g());
        p(a2);
        AOAConnectManager.h().p(g(), a2, 2, e());
    }
}

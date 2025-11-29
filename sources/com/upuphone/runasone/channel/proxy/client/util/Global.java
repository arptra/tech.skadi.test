package com.upuphone.runasone.channel.proxy.client.util;

import com.upuphone.runasone.channel.proxy.client.channel.IDataHandler;
import com.upuphone.runasone.channel.proxy.client.channel.IPackHandler;
import com.upuphone.runasone.channel.proxy.client.channel.SimpleAdapter;
import com.upuphone.runasone.channel.proxy.client.service.LocalVpnService;
import java.net.InetSocketAddress;

public class Global {
    public static Global HOLDER = new Global();
    private volatile int UdpServerPort;
    private Class<? extends SimpleAdapter> adapterClass;
    private volatile InetSocketAddress inetSocketAddress;
    private volatile IDataHandler mDataHandler;
    private volatile IPackHandler mPackHandler;
    private volatile LocalVpnService mVpnService;

    private Global() {
    }

    public Class<? extends SimpleAdapter> getAdapterClass() {
        return this.adapterClass;
    }

    public IDataHandler getDataHandler() {
        return this.mDataHandler;
    }

    public InetSocketAddress getInetSocketAddress() {
        return this.inetSocketAddress;
    }

    public IPackHandler getPackHandler() {
        return this.mPackHandler;
    }

    public int getUdpServerPort() {
        return this.UdpServerPort;
    }

    public LocalVpnService getVpnService() {
        return this.mVpnService;
    }

    public void setAdapterClass(Class<? extends SimpleAdapter> cls) {
        this.adapterClass = cls;
    }

    public void setDataHandler(IDataHandler iDataHandler) {
        this.mDataHandler = iDataHandler;
    }

    public void setInetSocketAddress(InetSocketAddress inetSocketAddress2) {
        this.inetSocketAddress = inetSocketAddress2;
    }

    public void setPackHandler(IPackHandler iPackHandler) {
        this.mPackHandler = iPackHandler;
    }

    public void setUdpServerPort(int i) {
        this.UdpServerPort = i;
    }

    public void setVpnService(LocalVpnService localVpnService) {
        this.mVpnService = localVpnService;
    }
}

package com.upuphone.runasone.channel.proxy.client.nat;

import android.text.TextUtils;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.channel.proxy.client.channel.SimpleAdapter;
import com.upuphone.runasone.channel.proxy.client.tcpip.CommonMethods;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import kotlin.UShort;

public class NatSession implements Serializable {
    public static final int SESSION_TYPE_HTTP = 1;
    public static final int SESSION_TYPE_HTTPS = 2;
    public static final int SESSION_TYPE_TCP = 3;
    public static final String TAG = "NatSession";
    public int bytesSent;
    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public boolean isDirectConnect = false;
    public short key;
    public Long lastActivityTime;
    public long lastNanoTime;
    public SimpleAdapter mAdapter;
    public int packetSent;
    public String remoteHost;
    public int remoteIP;
    public short remotePort;

    public String getHost() {
        if (TextUtils.isEmpty(this.remoteHost)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(CommonMethods.ipIntToString(this.remoteIP));
            stringBuffer.append(AccountConstantKt.CODE_SEPARTOR);
            stringBuffer.append(this.remotePort & UShort.MAX_VALUE);
            return stringBuffer.toString();
        } else if (this.remoteHost.contains(AccountConstantKt.CODE_SEPARTOR)) {
            return this.remoteHost;
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(this.remoteHost);
            stringBuffer2.append(AccountConstantKt.CODE_SEPARTOR);
            stringBuffer2.append(this.remotePort & UShort.MAX_VALUE);
            return stringBuffer2.toString();
        }
    }

    public String toString() {
        return String.format("%s: key = %d, remote=%s/%s:%d, packet: %d, lastActivityTime = %s", new Object[]{TAG, Integer.valueOf(this.key & UShort.MAX_VALUE), this.remoteHost, CommonMethods.ipIntToString(this.remoteIP), Integer.valueOf(this.remotePort & UShort.MAX_VALUE), Integer.valueOf(this.packetSent), this.dateformat.format(this.lastActivityTime)});
    }
}

package com.ucar.protocol.channel.socket;

import com.meizu.common.util.LunarCalendar;
import com.ucar.protocol.channel.ChannelType;
import com.ucar.protocol.channel.UCarChannel;

public abstract class NetChannel implements UCarChannel {

    /* renamed from: a  reason: collision with root package name */
    public final ChannelType f9645a;
    public final boolean b;
    public int c = 0;
    public String d = "127.0.0.1";
    public String e;

    public NetChannel(ChannelType channelType, boolean z) {
        this.f9645a = channelType;
        this.b = z;
        this.e = channelType.name();
    }

    public String a() {
        return this.d;
    }

    public int b() {
        return this.c;
    }

    public String c(String str) {
        int b2;
        StringBuilder sb = new StringBuilder();
        String g = g();
        if (g().equals(ChannelType.CUSTOM.name()) && (b2 = b()) != 0) {
            g = Integer.toString(b2);
        }
        sb.append(this.b ? "S-" : "C-");
        sb.append(str);
        sb.append(LunarCalendar.DATE_SEPARATOR);
        sb.append(g);
        sb.append(LunarCalendar.DATE_SEPARATOR);
        sb.append(Thread.currentThread().getId());
        return sb.toString();
    }

    public boolean d() {
        return this.b;
    }

    public String g() {
        return this.e;
    }

    public void i(String str) {
        if (str != null) {
            this.d = str;
        }
    }

    public void j(int i) {
        if (this.f9645a != ChannelType.CUSTOM) {
            throw new IllegalArgumentException("Can not set " + g() + " channel port to " + this.d);
        } else if (i != 0 || d()) {
            this.c = i;
        } else {
            throw new IllegalArgumentException("Can not set " + g() + " channel port to 0.");
        }
    }

    public ChannelType n() {
        return this.f9645a;
    }
}

package io.netty.channel.unix;

import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.net.SocketAddress;

public class DomainSocketAddress extends SocketAddress {
    private static final long serialVersionUID = -6934618000832236893L;
    private final String socketPath;

    public DomainSocketAddress(String str) {
        this.socketPath = (String) ObjectUtil.checkNotNull(str, "socketPath");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DomainSocketAddress)) {
            return false;
        }
        return ((DomainSocketAddress) obj).socketPath.equals(this.socketPath);
    }

    public int hashCode() {
        return this.socketPath.hashCode();
    }

    public String path() {
        return this.socketPath;
    }

    public String toString() {
        return path();
    }

    public DomainSocketAddress(File file) {
        this(file.getPath());
    }
}

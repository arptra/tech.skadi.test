package io.netty.resolver.dns;

import io.netty.channel.EventLoop;

public final class NoopDnsCnameCache implements DnsCnameCache {
    public static final NoopDnsCnameCache INSTANCE = new NoopDnsCnameCache();

    private NoopDnsCnameCache() {
    }

    public void cache(String str, String str2, long j, EventLoop eventLoop) {
    }

    public void clear() {
    }

    public String get(String str) {
        return null;
    }

    public boolean clear(String str) {
        return false;
    }
}

package io.netty.resolver.dns;

import io.netty.channel.EventLoop;

public interface DnsCnameCache {
    void cache(String str, String str2, long j, EventLoop eventLoop);

    void clear();

    boolean clear(String str);

    String get(String str);
}

package org.java_websocket.client;

import java.net.InetAddress;
import java.net.URI;

public interface DnsResolver {
    InetAddress a(URI uri);
}

package io.netty.resolver;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class HostsFileParser {
    private HostsFileParser() {
    }

    private static HostsFileEntries hostsFileEntries(HostsFileEntriesProvider hostsFileEntriesProvider) {
        return hostsFileEntriesProvider == HostsFileEntriesProvider.EMPTY ? HostsFileEntries.EMPTY : new HostsFileEntries(toMapWithSingleValue(hostsFileEntriesProvider.ipv4Entries()), toMapWithSingleValue(hostsFileEntriesProvider.ipv6Entries()));
    }

    public static HostsFileEntries parse() throws IOException {
        return hostsFileEntries(HostsFileEntriesProvider.parser().parse());
    }

    public static HostsFileEntries parseSilently() {
        return hostsFileEntries(HostsFileEntriesProvider.parser().parseSilently());
    }

    private static Map<String, ?> toMapWithSingleValue(Map<String, List<InetAddress>> map) {
        HashMap hashMap = new HashMap(map.size());
        for (Map.Entry next : map.entrySet()) {
            List list = (List) next.getValue();
            if (!list.isEmpty()) {
                hashMap.put(next.getKey(), list.get(0));
            }
        }
        return hashMap;
    }

    public static HostsFileEntries parse(File file) throws IOException {
        return hostsFileEntries(HostsFileEntriesProvider.parser().parse(file, new Charset[0]));
    }

    public static HostsFileEntries parseSilently(Charset... charsetArr) {
        return hostsFileEntries(HostsFileEntriesProvider.parser().parseSilently(charsetArr));
    }

    public static HostsFileEntries parse(File file, Charset... charsetArr) throws IOException {
        return hostsFileEntries(HostsFileEntriesProvider.parser().parse(file, charsetArr));
    }

    public static HostsFileEntries parse(Reader reader) throws IOException {
        return hostsFileEntries(HostsFileEntriesProvider.parser().parse(reader));
    }
}

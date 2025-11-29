package io.netty.resolver;

import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public final class HostsFileEntriesProvider {
    static final HostsFileEntriesProvider EMPTY = new HostsFileEntriesProvider(Collections.emptyMap(), Collections.emptyMap());
    private final Map<String, List<InetAddress>> ipv4Entries;
    private final Map<String, List<InetAddress>> ipv6Entries;

    public interface Parser {
        HostsFileEntriesProvider parse() throws IOException;

        HostsFileEntriesProvider parse(File file, Charset... charsetArr) throws IOException;

        HostsFileEntriesProvider parse(Reader reader) throws IOException;

        HostsFileEntriesProvider parse(Charset... charsetArr) throws IOException;

        HostsFileEntriesProvider parseSilently();

        HostsFileEntriesProvider parseSilently(File file, Charset... charsetArr);

        HostsFileEntriesProvider parseSilently(Charset... charsetArr);
    }

    public static final class ParserImpl implements Parser {
        static final ParserImpl INSTANCE = new ParserImpl();
        private static final Pattern WHITESPACES = Pattern.compile("[ \t]+");
        private static final String WINDOWS_DEFAULT_SYSTEM_ROOT = "C:\\Windows";
        private static final String WINDOWS_HOSTS_FILE_RELATIVE_PATH = "\\system32\\drivers\\etc\\hosts";
        private static final String X_PLATFORMS_HOSTS_FILE_PATH = "/etc/hosts";
        private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Parser.class);

        private ParserImpl() {
        }

        private static File locateHostsFile() {
            if (!PlatformDependent.isWindows()) {
                return new File(X_PLATFORMS_HOSTS_FILE_PATH);
            }
            File file = new File(System.getenv("SystemRoot") + WINDOWS_HOSTS_FILE_RELATIVE_PATH);
            return !file.exists() ? new File("C:\\Windows\\system32\\drivers\\etc\\hosts") : file;
        }

        public HostsFileEntriesProvider parse() throws IOException {
            return parse(locateHostsFile(), Charset.defaultCharset());
        }

        public HostsFileEntriesProvider parseSilently() {
            return parseSilently(locateHostsFile(), Charset.defaultCharset());
        }

        public HostsFileEntriesProvider parse(Charset... charsetArr) throws IOException {
            return parse(locateHostsFile(), charsetArr);
        }

        public HostsFileEntriesProvider parseSilently(Charset... charsetArr) {
            return parseSilently(locateHostsFile(), charsetArr);
        }

        /* JADX INFO: finally extract failed */
        public HostsFileEntriesProvider parse(File file, Charset... charsetArr) throws IOException {
            ObjectUtil.checkNotNull(file, "file");
            ObjectUtil.checkNotNull(charsetArr, "charsets");
            int i = 0;
            if (charsetArr.length == 0) {
                charsetArr = new Charset[]{Charset.defaultCharset()};
            }
            if (file.exists() && file.isFile()) {
                int length = charsetArr.length;
                while (i < length) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charsetArr[i]));
                    try {
                        HostsFileEntriesProvider parse = parse((Reader) bufferedReader);
                        if (parse != HostsFileEntriesProvider.EMPTY) {
                            bufferedReader.close();
                            return parse;
                        }
                        bufferedReader.close();
                        i++;
                    } catch (Throwable th) {
                        bufferedReader.close();
                        throw th;
                    }
                }
            }
            return HostsFileEntriesProvider.EMPTY;
        }

        public HostsFileEntriesProvider parseSilently(File file, Charset... charsetArr) {
            try {
                return parse(file, charsetArr);
            } catch (IOException e) {
                if (logger.isWarnEnabled()) {
                    InternalLogger internalLogger = logger;
                    internalLogger.warn("Failed to load and parse hosts file at " + file.getPath(), (Throwable) e);
                }
                return HostsFileEntriesProvider.EMPTY;
            }
        }

        public HostsFileEntriesProvider parse(Reader reader) throws IOException {
            List list;
            ObjectUtil.checkNotNull(reader, "reader");
            BufferedReader bufferedReader = new BufferedReader(reader);
            try {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    int indexOf = readLine.indexOf(35);
                    if (indexOf != -1) {
                        readLine = readLine.substring(0, indexOf);
                    }
                    String trim = readLine.trim();
                    if (!trim.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        for (String str : WHITESPACES.split(trim)) {
                            if (!str.isEmpty()) {
                                arrayList.add(str);
                            }
                        }
                        if (arrayList.size() >= 2) {
                            byte[] createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString((String) arrayList.get(0));
                            if (createByteArrayFromIpAddressString != null) {
                                for (int i = 1; i < arrayList.size(); i++) {
                                    String str2 = (String) arrayList.get(i);
                                    String lowerCase = str2.toLowerCase(Locale.ENGLISH);
                                    InetAddress byAddress = InetAddress.getByAddress(str2, createByteArrayFromIpAddressString);
                                    if (byAddress instanceof Inet4Address) {
                                        list = (List) hashMap.get(lowerCase);
                                        if (list == null) {
                                            list = new ArrayList();
                                            hashMap.put(lowerCase, list);
                                        }
                                    } else {
                                        list = (List) hashMap2.get(lowerCase);
                                        if (list == null) {
                                            list = new ArrayList();
                                            hashMap2.put(lowerCase, list);
                                        }
                                    }
                                    list.add(byAddress);
                                }
                            }
                        }
                    }
                }
                HostsFileEntriesProvider hostsFileEntriesProvider = (!hashMap.isEmpty() || !hashMap2.isEmpty()) ? new HostsFileEntriesProvider(hashMap, hashMap2) : HostsFileEntriesProvider.EMPTY;
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    logger.warn("Failed to close a reader", (Throwable) e);
                }
                return hostsFileEntriesProvider;
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    logger.warn("Failed to close a reader", (Throwable) e2);
                }
            }
        }
    }

    public HostsFileEntriesProvider(Map<String, List<InetAddress>> map, Map<String, List<InetAddress>> map2) {
        this.ipv4Entries = Collections.unmodifiableMap(new HashMap(map));
        this.ipv6Entries = Collections.unmodifiableMap(new HashMap(map2));
    }

    public static Parser parser() {
        return ParserImpl.INSTANCE;
    }

    public Map<String, List<InetAddress>> ipv4Entries() {
        return this.ipv4Entries;
    }

    public Map<String, List<InetAddress>> ipv6Entries() {
        return this.ipv6Entries;
    }
}

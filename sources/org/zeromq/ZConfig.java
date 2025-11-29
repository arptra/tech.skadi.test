package org.zeromq;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZConfig {
    public static final Pattern e = Pattern.compile("^( *)([0-9a-zA-Z\\$\\-_@\\.&\\+\\/]+)( *#.*)?$");
    public static final Pattern f = Pattern.compile("^( *)([0-9a-zA-Z\\$\\-_@\\.&\\+\\/]+) = ((\"|')(.*)(\\4)|(.*?))(#.*)?$");

    /* renamed from: a  reason: collision with root package name */
    public final String f3490a;
    public final Map b = new HashMap();
    public final List c = new LinkedList();
    public String d;

    /* renamed from: org.zeromq.ZConfig$1  reason: invalid class name */
    class AnonymousClass1 implements IVisitor {
    }

    public interface IVisitor {
    }

    public static class ReadException extends RuntimeException {
        private static final long serialVersionUID = 1;
        public final String currentLine;
        public final int currentLineNumber;

        public ReadException(String str, String str2, AtomicInteger atomicInteger) {
            super(String.format("%s %s: %s", new Object[]{str, atomicInteger, str2}));
            this.currentLine = str2;
            this.currentLineNumber = atomicInteger.get();
        }
    }

    public ZConfig(String str, ZConfig zConfig) {
        this.f3490a = str;
        if (zConfig != null) {
            zConfig.b.put(str, this);
        }
    }

    public static ZConfig a(ZConfig zConfig, Matcher matcher, int i, String str, AtomicInteger atomicInteger) {
        int length = matcher.group(1).length() / 4;
        if (length > i) {
            throw new ReadException("Level mismatch in line", str, atomicInteger);
        } else if (length < i) {
            return null;
        } else {
            atomicInteger.incrementAndGet();
            return new ZConfig(matcher.group(2), zConfig);
        }
    }

    public static ZConfig g(String str) {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        try {
            ArrayList arrayList = new ArrayList();
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                if (!readLine.matches("^ *#.*|^ *[0-9]+.*")) {
                    if (!readLine.trim().isEmpty()) {
                        arrayList.add(readLine);
                    }
                }
            }
            ZConfig h = h(new ZConfig("root", (ZConfig) null), arrayList, 0, new AtomicInteger());
            bufferedReader.close();
            return h;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static ZConfig h(ZConfig zConfig, List list, int i, AtomicInteger atomicInteger) {
        while (atomicInteger.get() < list.size()) {
            String str = (String) list.get(atomicInteger.get());
            Matcher matcher = e.matcher(str);
            if (matcher.find()) {
                ZConfig a2 = a(zConfig, matcher, i, str, atomicInteger);
                if (a2 == null) {
                    break;
                }
                h(a2, list, i + 1, atomicInteger);
            } else {
                Matcher matcher2 = f.matcher(str);
                if (matcher2.find()) {
                    ZConfig a3 = a(zConfig, matcher2, i, str, atomicInteger);
                    if (a3 == null) {
                        break;
                    }
                    String group = matcher2.group(5);
                    if (group == null) {
                        group = matcher2.group(7);
                    }
                    if (group != null) {
                        group = group.trim();
                    }
                    a3.d = group;
                } else {
                    throw new ReadException("Couldn't process line", str, atomicInteger);
                }
            }
        }
        return zConfig;
    }

    public final void b(String str, Map map) {
        for (Map.Entry entry : this.b.entrySet()) {
            String str2 = (String) entry.getKey();
            ZConfig zConfig = (ZConfig) entry.getValue();
            if (zConfig.d != null) {
                map.put(str + str2, zConfig.d);
            }
            zConfig.b(str + str2 + '/', map);
        }
    }

    public ZConfig c(String str) {
        return (ZConfig) this.b.get(str);
    }

    public String d(String str) {
        return e(str, (String) null);
    }

    public String e(String str, String str2) {
        for (String str3 : str.split("/")) {
            if (!str3.isEmpty() && (this = (ZConfig) this.b.get(str3)) == null) {
                return str2;
            }
        }
        return this.d;
    }

    public Map f() {
        HashMap hashMap = new HashMap();
        b("", hashMap);
        return hashMap;
    }
}

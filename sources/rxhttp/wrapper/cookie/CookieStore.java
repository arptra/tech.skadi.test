package rxhttp.wrapper.cookie;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Cookie;
import okhttp3.HttpUrl;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.io.FileSystem;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import rxhttp.wrapper.OkHttpCompat;

public class CookieStore implements ICookieJar {

    /* renamed from: a  reason: collision with root package name */
    public final File f3544a;
    public final long b;
    public DiskLruCache c;
    public Map d;

    public static String g(String str) {
        return ByteString.encodeUtf8(str).md5().hex();
    }

    public List a(HttpUrl httpUrl) {
        Map map;
        String host = httpUrl.host();
        Map map2 = this.d;
        if (map2 != null && (map = (Map) map2.get(host)) != null) {
            return f(httpUrl, map);
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        DiskLruCache d2 = d();
        if (d2 != null) {
            DiskLruCache.Snapshot snapshot = null;
            try {
                snapshot = d2.get(g(host));
                if (snapshot == null) {
                    return Collections.emptyList();
                }
                for (Cookie cookie : h(httpUrl, snapshot.getSource(0))) {
                    concurrentHashMap.put(e(cookie), cookie);
                }
                OkHttpCompat.b(snapshot);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                OkHttpCompat.b(snapshot);
            }
        }
        if (this.d != null && !concurrentHashMap.isEmpty()) {
            this.d.put(host, concurrentHashMap);
        }
        return f(httpUrl, concurrentHashMap);
    }

    public void b(HttpUrl httpUrl, List list) {
        ConcurrentHashMap concurrentHashMap;
        String host = httpUrl.host();
        Map map = this.d;
        if (map != null) {
            concurrentHashMap = (ConcurrentHashMap) map.get(host);
            if (concurrentHashMap == null) {
                Map map2 = this.d;
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                map2.put(host, concurrentHashMap2);
                concurrentHashMap = concurrentHashMap2;
            }
        } else {
            concurrentHashMap = new ConcurrentHashMap();
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Cookie cookie = (Cookie) it.next();
            concurrentHashMap.put(e(cookie), cookie);
        }
        DiskLruCache d2 = d();
        if (d2 != null) {
            DiskLruCache.Editor editor = null;
            try {
                editor = d2.edit(g(host));
                if (editor == null) {
                    c(editor);
                    return;
                }
                i(editor, concurrentHashMap);
                editor.commit();
                c(editor);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                c(editor);
                throw th;
            }
        }
    }

    public final void c(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (Exception unused) {
            }
        }
    }

    public final DiskLruCache d() {
        File file = this.f3544a;
        if (file != null && this.c == null) {
            this.c = OkHttpCompat.i(FileSystem.SYSTEM, file, 1, 1, this.b);
        }
        return this.c;
    }

    public final String e(Cookie cookie) {
        return cookie.name() + "; " + cookie.domain() + "; " + cookie.path() + "; " + cookie.secure();
    }

    public final List f(HttpUrl httpUrl, Map map) {
        ArrayList arrayList = new ArrayList();
        for (Cookie cookie : map.values()) {
            if (cookie.matches(httpUrl) && cookie.expiresAt() > System.currentTimeMillis()) {
                arrayList.add(cookie);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final List h(HttpUrl httpUrl, Source source) {
        ArrayList arrayList = new ArrayList();
        try {
            BufferedSource buffer = Okio.buffer(source);
            int readInt = buffer.readInt();
            for (int i = 0; i < readInt; i++) {
                arrayList.add(Cookie.parse(httpUrl, buffer.readUtf8LineStrict()));
            }
            return arrayList;
        } finally {
            source.close();
        }
    }

    public final void i(DiskLruCache.Editor editor, Map map) {
        BufferedSink buffer = Okio.buffer(editor.newSink(0));
        buffer.writeInt(map.size());
        for (Cookie cookie : map.values()) {
            buffer.writeUtf8(cookie.toString()).writeByte(10);
        }
        buffer.close();
    }
}

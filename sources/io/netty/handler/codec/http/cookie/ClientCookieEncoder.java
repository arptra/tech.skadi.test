package io.netty.handler.codec.http.cookie;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public final class ClientCookieEncoder extends CookieEncoder {
    static final Comparator<Cookie> COOKIE_COMPARATOR = new Comparator<Cookie>() {
        public int compare(Cookie cookie, Cookie cookie2) {
            int i;
            String path = cookie.path();
            String path2 = cookie2.path();
            int i2 = Integer.MAX_VALUE;
            if (path == null) {
                i = Integer.MAX_VALUE;
            } else {
                i = path.length();
            }
            if (path2 != null) {
                i2 = path2.length();
            }
            return i2 - i;
        }
    };
    public static final ClientCookieEncoder LAX = new ClientCookieEncoder(false);
    public static final ClientCookieEncoder STRICT = new ClientCookieEncoder(true);

    private ClientCookieEncoder(boolean z) {
        super(z);
    }

    public String encode(String str, String str2) {
        return encode((Cookie) new DefaultCookie(str, str2));
    }

    public String encode(Cookie cookie) {
        StringBuilder stringBuilder = CookieUtil.stringBuilder();
        encode(stringBuilder, (Cookie) ObjectUtil.checkNotNull(cookie, "cookie"));
        return CookieUtil.stripTrailingSeparator(stringBuilder);
    }

    public String encode(Cookie... cookieArr) {
        if (((Cookie[]) ObjectUtil.checkNotNull(cookieArr, "cookies")).length == 0) {
            return null;
        }
        StringBuilder stringBuilder = CookieUtil.stringBuilder();
        int i = 0;
        if (!this.strict) {
            int length = cookieArr.length;
            while (i < length) {
                encode(stringBuilder, cookieArr[i]);
                i++;
            }
        } else if (cookieArr.length == 1) {
            encode(stringBuilder, cookieArr[0]);
        } else {
            Cookie[] cookieArr2 = (Cookie[]) Arrays.copyOf(cookieArr, cookieArr.length);
            Arrays.sort(cookieArr2, COOKIE_COMPARATOR);
            int length2 = cookieArr2.length;
            while (i < length2) {
                encode(stringBuilder, cookieArr2[i]);
                i++;
            }
        }
        return CookieUtil.stripTrailingSeparatorOrNull(stringBuilder);
    }

    public String encode(Collection<? extends Cookie> collection) {
        if (((Collection) ObjectUtil.checkNotNull(collection, "cookies")).isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = CookieUtil.stringBuilder();
        if (!this.strict) {
            for (Cookie encode : collection) {
                encode(stringBuilder, encode);
            }
        } else if (collection.size() == 1) {
            encode(stringBuilder, (Cookie) collection.iterator().next());
        } else {
            Cookie[] cookieArr = (Cookie[]) collection.toArray(new Cookie[0]);
            Arrays.sort(cookieArr, COOKIE_COMPARATOR);
            for (Cookie encode2 : cookieArr) {
                encode(stringBuilder, encode2);
            }
        }
        return CookieUtil.stripTrailingSeparatorOrNull(stringBuilder);
    }

    public String encode(Iterable<? extends Cookie> iterable) {
        Iterator it = ((Iterable) ObjectUtil.checkNotNull(iterable, "cookies")).iterator();
        if (!it.hasNext()) {
            return null;
        }
        StringBuilder stringBuilder = CookieUtil.stringBuilder();
        if (this.strict) {
            Cookie cookie = (Cookie) it.next();
            if (!it.hasNext()) {
                encode(stringBuilder, cookie);
            } else {
                ArrayList arrayList = InternalThreadLocalMap.get().arrayList();
                arrayList.add(cookie);
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                Cookie[] cookieArr = (Cookie[]) arrayList.toArray(new Cookie[0]);
                Arrays.sort(cookieArr, COOKIE_COMPARATOR);
                for (Cookie encode : cookieArr) {
                    encode(stringBuilder, encode);
                }
            }
        } else {
            while (it.hasNext()) {
                encode(stringBuilder, (Cookie) it.next());
            }
        }
        return CookieUtil.stripTrailingSeparatorOrNull(stringBuilder);
    }

    private void encode(StringBuilder sb, Cookie cookie) {
        String name = cookie.name();
        String value = cookie.value() != null ? cookie.value() : "";
        validateCookie(name, value);
        if (cookie.wrap()) {
            CookieUtil.addQuoted(sb, name, value);
        } else {
            CookieUtil.add(sb, name, value);
        }
    }
}

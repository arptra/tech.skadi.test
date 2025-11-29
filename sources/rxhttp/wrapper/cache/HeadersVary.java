package rxhttp.wrapper.cache;

import com.meizu.common.widget.MzContactsContract;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Headers;
import okhttp3.Response;

class HeadersVary {
    public static Set a(Headers headers) {
        Set emptySet = Collections.emptySet();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            if ("Vary".equalsIgnoreCase(headers.name(i))) {
                String value = headers.value(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : value.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA)) {
                    emptySet.add(trim.trim());
                }
            }
        }
        return emptySet;
    }

    public static Headers b(Headers headers, Headers headers2) {
        Set a2 = a(headers2);
        if (a2.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            if (a2.contains(name)) {
                builder.add(name, headers.value(i));
            }
        }
        return builder.build();
    }

    public static Headers c(Response response) {
        return b(response.networkResponse().request().headers(), response.headers());
    }
}

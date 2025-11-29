package rxhttp.wrapper.utils;

import com.honey.account.constant.AccountConstantKt;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONStringer {

    /* renamed from: a  reason: collision with root package name */
    public final StringBuilder f3572a = new StringBuilder();
    public final List b = new ArrayList();
    public final String c;
    public SerializeCallback d;

    public enum Scope {
        EMPTY_ARRAY,
        NONEMPTY_ARRAY,
        EMPTY_OBJECT,
        DANGLING_KEY,
        NONEMPTY_OBJECT,
        NULL
    }

    public interface SerializeCallback {
        String serialize(Object obj);
    }

    public JSONStringer(int i) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, ' ');
        this.c = new String(cArr);
    }

    public JSONStringer a() {
        return j(Scope.EMPTY_ARRAY, "[");
    }

    public final void b() {
        Scope k = k();
        if (k == Scope.NONEMPTY_OBJECT) {
            this.f3572a.append(StringUtil.COMMA);
        } else if (k != Scope.EMPTY_OBJECT) {
            throw new JSONException("Nesting problem");
        }
        h();
        l(Scope.DANGLING_KEY);
    }

    public final void c() {
        if (!this.b.isEmpty()) {
            Scope k = k();
            if (k == Scope.EMPTY_ARRAY) {
                l(Scope.NONEMPTY_ARRAY);
                h();
            } else if (k == Scope.NONEMPTY_ARRAY) {
                this.f3572a.append(StringUtil.COMMA);
                h();
            } else if (k == Scope.DANGLING_KEY) {
                this.f3572a.append(this.c == null ? AccountConstantKt.CODE_SEPARTOR : ": ");
                l(Scope.NONEMPTY_OBJECT);
            } else if (k != Scope.NULL) {
                throw new JSONException("Nesting problem");
            }
        }
    }

    public JSONStringer d(Scope scope, Scope scope2, String str) {
        Scope k = k();
        if (k == scope2 || k == scope) {
            List list = this.b;
            list.remove(list.size() - 1);
            if (k == scope2) {
                h();
            }
            this.f3572a.append(str);
            return this;
        }
        throw new JSONException("Nesting problem");
    }

    public JSONStringer e() {
        return d(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
    }

    public JSONStringer f() {
        return d(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
    }

    public JSONStringer g(String str) {
        if (str != null) {
            b();
            m(str);
            return this;
        }
        throw new JSONException("Names must be non-null");
    }

    public final void h() {
        if (this.c != null) {
            this.f3572a.append(StringUtils.LF);
            for (int i = 0; i < this.b.size(); i++) {
                this.f3572a.append(this.c);
            }
        }
    }

    public JSONStringer i() {
        return j(Scope.EMPTY_OBJECT, "{");
    }

    public JSONStringer j(Scope scope, String str) {
        if (!this.b.isEmpty() || this.f3572a.length() <= 0) {
            c();
            this.b.add(scope);
            this.f3572a.append(str);
            return this;
        }
        throw new JSONException("Nesting problem: multiple top-level roots");
    }

    public final Scope k() {
        if (!this.b.isEmpty()) {
            List list = this.b;
            return (Scope) list.get(list.size() - 1);
        }
        throw new JSONException("Nesting problem");
    }

    public final void l(Scope scope) {
        List list = this.b;
        list.set(list.size() - 1, scope);
    }

    public final void m(String str) {
        this.f3572a.append("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 12) {
                this.f3572a.append("\\f");
            } else if (charAt != 13) {
                if (charAt != '\"' && charAt != '\\') {
                    switch (charAt) {
                        case 8:
                            this.f3572a.append("\\b");
                            break;
                        case 9:
                            this.f3572a.append("\\t");
                            break;
                        case 10:
                            this.f3572a.append("\\n");
                            break;
                        default:
                            if (charAt > 31) {
                                this.f3572a.append(charAt);
                                break;
                            } else {
                                this.f3572a.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                                break;
                            }
                    }
                } else {
                    StringBuilder sb = this.f3572a;
                    sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                    sb.append(charAt);
                }
            } else {
                this.f3572a.append("\\r");
            }
        }
        this.f3572a.append("\"");
    }

    public JSONStringer n(Object obj) {
        if (this.b.isEmpty()) {
            throw new JSONException("Nesting problem");
        } else if (obj instanceof JSONArray) {
            q((JSONArray) obj);
            return this;
        } else if (obj instanceof JSONObject) {
            r((JSONObject) obj);
            return this;
        } else if (obj instanceof Collection) {
            o((Collection) obj);
            return this;
        } else if (obj instanceof Map) {
            p((Map) obj);
            return this;
        } else {
            c();
            if (obj == null || (obj instanceof Boolean) || obj == JSONObject.NULL) {
                this.f3572a.append(obj);
            } else if (obj instanceof Number) {
                this.f3572a.append(JSONObject.numberToString((Number) obj));
            } else {
                SerializeCallback serializeCallback = this.d;
                if (serializeCallback == null) {
                    m(obj.toString());
                } else if (obj instanceof String) {
                    m(obj.toString());
                } else {
                    this.f3572a.append(serializeCallback.serialize(obj));
                }
            }
            return this;
        }
    }

    public JSONStringer o(Collection collection) {
        a();
        for (Object n : collection) {
            n(n);
        }
        e();
        return this;
    }

    public JSONStringer p(Map map) {
        i();
        for (Map.Entry entry : map.entrySet()) {
            g(entry.getKey().toString()).n(entry.getValue());
        }
        f();
        return this;
    }

    public JSONStringer q(JSONArray jSONArray) {
        a();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            n(jSONArray.opt(i));
        }
        e();
        return this;
    }

    public JSONStringer r(JSONObject jSONObject) {
        i();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            g(obj).n(jSONObject.opt(obj));
        }
        f();
        return this;
    }

    public String toString() {
        if (this.f3572a.length() == 0) {
            return null;
        }
        return this.f3572a.toString();
    }
}

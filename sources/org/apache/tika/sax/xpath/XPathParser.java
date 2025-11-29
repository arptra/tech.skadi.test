package org.apache.tika.sax.xpath;

import java.util.HashMap;
import java.util.Map;

public class XPathParser {

    /* renamed from: a  reason: collision with root package name */
    public final Map f3335a = new HashMap();

    public XPathParser(String str, String str2) {
        a(str, str2);
    }

    public void a(String str, String str2) {
        this.f3335a.put(str, str2);
    }

    public Matcher b(String str) {
        if (str.equals("/text()")) {
            return TextMatcher.b;
        }
        if (str.equals("/node()")) {
            return NodeMatcher.b;
        }
        if (str.equals("/descendant::node()") || str.equals("/descendant:node()")) {
            return new CompositeMatcher(TextMatcher.b, new ChildMatcher(new SubtreeMatcher(NodeMatcher.b)));
        }
        if (str.equals("/@*")) {
            return AttributeMatcher.b;
        }
        if (str.length() == 0) {
            return ElementMatcher.b;
        }
        String str2 = null;
        if (str.startsWith("/@")) {
            String substring = str.substring(2);
            int indexOf = substring.indexOf(58);
            if (indexOf != -1) {
                str2 = substring.substring(0, indexOf);
                substring = substring.substring(indexOf + 1);
            }
            return this.f3335a.containsKey(str2) ? new NamedAttributeMatcher((String) this.f3335a.get(str2), substring) : Matcher.f3334a;
        } else if (str.startsWith("/*")) {
            return new ChildMatcher(b(str.substring(2)));
        } else {
            if (str.startsWith("///")) {
                return Matcher.f3334a;
            }
            if (str.startsWith("//")) {
                return new SubtreeMatcher(b(str.substring(1)));
            }
            if (!str.startsWith("/")) {
                return Matcher.f3334a;
            }
            int indexOf2 = str.indexOf(47, 1);
            if (indexOf2 == -1) {
                indexOf2 = str.length();
            }
            String substring2 = str.substring(1, indexOf2);
            int indexOf3 = substring2.indexOf(58);
            if (indexOf3 != -1) {
                str2 = substring2.substring(0, indexOf3);
                substring2 = substring2.substring(indexOf3 + 1);
            }
            return this.f3335a.containsKey(str2) ? new NamedElementMatcher((String) this.f3335a.get(str2), substring2, b(str.substring(indexOf2))) : Matcher.f3334a;
        }
    }
}

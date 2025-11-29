package org.apache.tika.sax.xpath;

import java.util.Objects;

public class NamedElementMatcher extends ChildMatcher {
    public final String c;
    public final String d;

    public NamedElementMatcher(String str, String str2, Matcher matcher) {
        super(matcher);
        this.c = str;
        this.d = str2;
    }

    public Matcher a(String str, String str2) {
        return (!Objects.equals(str, this.c) || !str2.equals(this.d)) ? Matcher.f3334a : super.a(str, str2);
    }
}

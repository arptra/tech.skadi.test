package org.apache.tika.sax.xpath;

public class ChildMatcher extends Matcher {
    public final Matcher b;

    public ChildMatcher(Matcher matcher) {
        this.b = matcher;
    }

    public Matcher a(String str, String str2) {
        return this.b;
    }
}

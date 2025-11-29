package org.apache.tika.sax.xpath;

import java.util.Objects;

public class NamedAttributeMatcher extends Matcher {
    public final String b;
    public final String c;

    public NamedAttributeMatcher(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    public boolean b(String str, String str2) {
        return Objects.equals(str, this.b) && str2.equals(this.c);
    }
}

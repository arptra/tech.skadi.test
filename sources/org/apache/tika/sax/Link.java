package org.apache.tika.sax;

public class Link {

    /* renamed from: a  reason: collision with root package name */
    public final String f3322a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public Link(String str, String str2, String str3, String str4, String str5) {
        this.f3322a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public boolean a() {
        return "img".equals(this.f3322a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (a()) {
            sb.append("<img src=\"");
            sb.append(this.b);
            String str = this.c;
            if (str != null && str.length() > 0) {
                sb.append("\" title=\"");
                sb.append(this.c);
            }
            String str2 = this.d;
            if (str2 != null && str2.length() > 0) {
                sb.append("\" alt=\"");
                sb.append(this.d);
            }
            sb.append("\"/>");
        } else {
            sb.append("<");
            sb.append(this.f3322a);
            sb.append(" href=\"");
            sb.append(this.b);
            String str3 = this.c;
            if (str3 != null && str3.length() > 0) {
                sb.append("\" title=\"");
                sb.append(this.c);
            }
            String str4 = this.e;
            if (str4 != null && str4.length() > 0) {
                sb.append("\" rel=\"");
                sb.append(this.e);
            }
            sb.append("\">");
            sb.append(this.d);
            sb.append("</");
            sb.append(this.f3322a);
            sb.append(">");
        }
        return sb.toString();
    }
}

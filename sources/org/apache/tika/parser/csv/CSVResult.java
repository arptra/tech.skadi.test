package org.apache.tika.parser.csv;

import java.util.Objects;
import org.apache.tika.mime.MediaType;

public class CSVResult implements Comparable<CSVResult> {
    public static CSVResult d = new CSVResult(1.0d, MediaType.TEXT_PLAIN, (Character) null);

    /* renamed from: a  reason: collision with root package name */
    public final double f3253a;
    public final MediaType b;
    public final Character c;

    public CSVResult(double d2, MediaType mediaType, Character ch) {
        this.f3253a = d2;
        this.b = mediaType;
        this.c = ch;
    }

    /* renamed from: a */
    public int compareTo(CSVResult cSVResult) {
        return Double.compare(cSVResult.f3253a, this.f3253a);
    }

    public double d() {
        return this.f3253a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CSVResult cSVResult = (CSVResult) obj;
        return Double.compare(cSVResult.f3253a, this.f3253a) == 0 && this.b.equals(cSVResult.b) && Objects.equals(this.c, cSVResult.c);
    }

    public Character f() {
        return this.c;
    }

    public MediaType g() {
        return this.b;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Double.valueOf(this.f3253a), this.b, this.c});
    }

    public String toString() {
        return "CSVResult{confidence=" + this.f3253a + ", mediaType=" + this.b + ", delimiter=" + this.c + '}';
    }
}

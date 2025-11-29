package org.apache.tika.parser.csv;

import java.nio.charset.Charset;
import org.apache.tika.mime.MediaType;

public class CSVParams {

    /* renamed from: a  reason: collision with root package name */
    public MediaType f3252a;
    public Character b;
    public Charset c;

    public CSVParams() {
        this.f3252a = null;
        this.b = null;
        this.c = null;
    }

    public Charset a() {
        return this.c;
    }

    public Character b() {
        return this.b;
    }

    public MediaType c() {
        return this.f3252a;
    }

    public boolean d() {
        return (this.f3252a == null || this.b == null || this.c == null) ? false : true;
    }

    public void e(Charset charset) {
        this.c = charset;
    }

    public void f(Character ch) {
        this.b = ch;
    }

    public void g(MediaType mediaType) {
        this.f3252a = mediaType;
    }

    public CSVParams(MediaType mediaType, Charset charset) {
        this.b = null;
        this.f3252a = mediaType;
        this.c = charset;
    }

    public CSVParams(MediaType mediaType, Charset charset, Character ch) {
        this.f3252a = mediaType;
        this.c = charset;
        this.b = ch;
    }
}

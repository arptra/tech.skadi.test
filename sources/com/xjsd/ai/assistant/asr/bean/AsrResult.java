package com.xjsd.ai.assistant.asr.bean;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AsrResult {

    /* renamed from: a  reason: collision with root package name */
    public String f8384a;
    public String b;
    public int c;

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    @Keep
    @Retention(RetentionPolicy.CLASS)
    public @interface Type {
        public static final int PARTIAL = 0;
        public static final int RESULT = 1;
    }

    public String a() {
        return this.f8384a;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public boolean d() {
        return this.c == 1;
    }

    public void e(String str) {
        this.f8384a = str;
    }

    public void f(String str) {
        this.b = str;
    }

    public void g(int i) {
        this.c = i;
    }

    public String toString() {
        return "AsrResult{id='" + this.f8384a + '\'' + ", text='" + this.b + '\'' + ", type=" + this.c + '}';
    }
}

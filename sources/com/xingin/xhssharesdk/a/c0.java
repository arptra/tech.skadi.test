package com.xingin.xhssharesdk.a;

import java.io.Serializable;

public final class c0 {

    public enum a {
        ;
        

        /* renamed from: a  reason: collision with root package name */
        public final b f8124a;
        public final int b;

        /* 'enum' modifier removed */
        /* renamed from: com.xingin.xhssharesdk.a.c0$a$a  reason: collision with other inner class name */
        public static class C0027a extends a {
            public C0027a() {
                super("STRING", 8, b.STRING, 2, 0);
            }
        }

        /* 'enum' modifier removed */
        public static class b extends a {
            public b(b bVar) {
                super("GROUP", 9, bVar, 3, 0);
            }
        }

        /* 'enum' modifier removed */
        public static class c extends a {
            public c(b bVar) {
                super("MESSAGE", 10, bVar, 2, 0);
            }
        }

        /* 'enum' modifier removed */
        public static class d extends a {
            public d(b bVar) {
                super("BYTES", 11, bVar, 2, 0);
            }
        }

        /* access modifiers changed from: public */
        a(b bVar, int i) {
            this.f8124a = bVar;
            this.b = i;
        }
    }

    public enum b {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(e.b),
        ENUM((String) null),
        MESSAGE((String) null);
        

        /* renamed from: a  reason: collision with root package name */
        public final Object f8125a;

        /* access modifiers changed from: public */
        b(Serializable serializable) {
            this.f8125a = serializable;
        }
    }

    public enum c {
        ;

        /* 'enum' modifier removed */
        public static class a extends c {
            public a() {
                super("LOOSE", 0);
            }
        }

        /* 'enum' modifier removed */
        public static class b extends c {
            public b() {
                super("STRICT", 1);
            }

            public final Object a(f fVar) {
                return fVar.i();
            }
        }

        /* 'enum' modifier removed */
        /* renamed from: com.xingin.xhssharesdk.a.c0$c$c  reason: collision with other inner class name */
        public static class C0028c extends c {
            public C0028c() {
                super("LAZY", 2);
            }
        }

        /* access modifiers changed from: public */
        c() {
        }
    }

    public static int a(int i, int i2) {
        return (i << 3) | i2;
    }
}

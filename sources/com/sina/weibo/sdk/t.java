package com.sina.weibo.sdk;

import android.os.Bundle;
import com.upuphone.runasone.share.lib.TransferHandler;
import java.util.HashMap;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public String f9994a;
    public Bundle b = new Bundle();
    public Bundle c = new Bundle();
    public HashMap d = new HashMap();
    public HashMap e = new HashMap();
    public int f;
    public int g;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f9995a;
        public Bundle b = new Bundle();
        public Bundle c = new Bundle();
        public HashMap d = new HashMap();
        public HashMap e = new HashMap();
        public int f = TransferHandler.TIMEOUT;
        public int g = 60000;

        public final a a(String str, String str2) {
            Bundle bundle = this.c;
            if (str2 != null) {
                bundle.putString(str, str2);
            }
            return this;
        }
    }

    public t(a aVar) {
        this.f9994a = aVar.f9995a;
        this.b.putAll(aVar.b);
        this.c.putAll(aVar.c);
        this.d.putAll(aVar.d);
        this.e.putAll(aVar.e);
        this.f = aVar.f;
        this.g = aVar.g;
    }
}

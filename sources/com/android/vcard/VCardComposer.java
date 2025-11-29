package com.android.vcard;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class VCardComposer {
    public static final Map b;
    public static final String[] c = {"_id"};

    /* renamed from: a  reason: collision with root package name */
    public boolean f2368a;

    public static class RawContactEntitlesInfo {
    }

    public interface RawContactEntitlesInfoCallback {
    }

    static {
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put(0, "X-AIM");
        hashMap.put(1, "X-MSN");
        hashMap.put(2, "X-YAHOO");
        hashMap.put(6, "X-ICQ");
        hashMap.put(7, "X-JABBER");
        hashMap.put(3, "X-SKYPE-USERNAME");
    }

    public void finalize() {
        try {
            if (!this.f2368a) {
                Log.e("VCardComposer", "finalized() is called before terminate() being called");
            }
        } finally {
            super.finalize();
        }
    }
}

package com.android.vcard;

import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;

public class VCardEntryCommitter implements VCardEntryHandler {
    public static String f = "vCard";

    /* renamed from: a  reason: collision with root package name */
    public final ContentResolver f2388a;
    public long b;
    public int c;
    public ArrayList d;
    public final ArrayList e;

    public void a(VCardEntry vCardEntry) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList o = vCardEntry.o(this.f2388a, this.d);
        this.d = o;
        this.c++;
        if (o != null && o.size() >= 450) {
            this.e.add(c(this.d));
            this.c = 0;
            this.d = null;
        }
        this.b += System.currentTimeMillis() - currentTimeMillis;
    }

    public void b() {
        ArrayList arrayList = this.d;
        if (arrayList != null) {
            this.e.add(c(arrayList));
        }
        if (VCardConfig.g()) {
            Log.d(f, String.format("time to commit entries: %d ms", new Object[]{Long.valueOf(this.b)}));
        }
    }

    public final Uri c(ArrayList arrayList) {
        try {
            ContentProviderResult[] applyBatch = this.f2388a.applyBatch("com.android.contacts", arrayList);
            if (applyBatch == null || applyBatch.length == 0) {
                return null;
            }
            ContentProviderResult contentProviderResult = applyBatch[0];
            if (contentProviderResult == null) {
                return null;
            }
            return contentProviderResult.uri;
        } catch (RemoteException e2) {
            Log.e(f, String.format("%s: %s", new Object[]{e2.toString(), e2.getMessage()}));
            return null;
        } catch (OperationApplicationException e3) {
            Log.e(f, String.format("%s: %s", new Object[]{e3.toString(), e3.getMessage()}));
            return null;
        }
    }

    public void onStart() {
    }
}

package com.android.vcard;

import android.accounts.Account;
import java.util.ArrayList;
import java.util.List;

public class VCardEntryConstructor implements VCardInterpreter {

    /* renamed from: a  reason: collision with root package name */
    public final List f2389a;
    public VCardEntry b;
    public final int c;
    public final Account d;
    public final List e;

    public VCardEntryConstructor() {
        this(-1073741824, (Account) null, (String) null);
    }

    public void a(VCardProperty vCardProperty) {
        this.b.j(vCardProperty);
    }

    public void b() {
        this.b.m();
        for (VCardEntryHandler a2 : this.e) {
            a2.a(this.b);
        }
        int size = this.f2389a.size();
        if (size > 1) {
            VCardEntry vCardEntry = (VCardEntry) this.f2389a.get(size - 2);
            vCardEntry.a(this.b);
            this.b = vCardEntry;
        } else {
            this.b = null;
        }
        this.f2389a.remove(size - 1);
    }

    public void c() {
        for (VCardEntryHandler onStart : this.e) {
            onStart.onStart();
        }
    }

    public void d() {
        for (VCardEntryHandler b2 : this.e) {
            b2.b();
        }
    }

    public void e() {
        VCardEntry vCardEntry = new VCardEntry(this.c, this.d);
        this.b = vCardEntry;
        this.f2389a.add(vCardEntry);
    }

    public void f(VCardEntryHandler vCardEntryHandler) {
        this.e.add(vCardEntryHandler);
    }

    public VCardEntryConstructor(int i, Account account, String str) {
        this.f2389a = new ArrayList();
        this.e = new ArrayList();
        this.c = i;
        this.d = account;
    }
}

package org.mozilla.universalchardet.prober.statemachine;

public class CodingStateMachine {

    /* renamed from: a  reason: collision with root package name */
    public SMModel f3440a;
    public int b = 0;
    public int c;
    public int d;

    public CodingStateMachine(SMModel sMModel) {
        this.f3440a = sMModel;
    }

    public String a() {
        return this.f3440a.c();
    }

    public int b() {
        return this.c;
    }

    public int c(byte b2) {
        int b3 = this.f3440a.b(b2);
        if (this.b == 0) {
            this.d = 0;
            this.c = this.f3440a.a(b3);
        }
        int d2 = this.f3440a.d(b3, this.b);
        this.b = d2;
        this.d++;
        return d2;
    }

    public void d() {
        this.b = 0;
    }
}

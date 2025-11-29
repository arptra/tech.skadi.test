package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.SMModel;
import org.mozilla.universalchardet.prober.statemachine.UTF8SMModel;

public class UTF8Prober extends CharsetProber {
    public static final SMModel e = new UTF8SMModel();
    public CodingStateMachine b = new CodingStateMachine(e);
    public CharsetProber.ProbingState c;
    public int d = 0;

    public UTF8Prober() {
        j();
    }

    public String c() {
        return Constants.u;
    }

    public float d() {
        float f = 0.99f;
        if (this.d >= 6) {
            return 0.99f;
        }
        for (int i = 0; i < this.d; i++) {
            f *= 0.5f;
        }
        return 1.0f - f;
    }

    public CharsetProber.ProbingState e() {
        return this.c;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (true) {
            if (i >= i3) {
                break;
            }
            int c2 = this.b.c(bArr[i]);
            if (c2 == 1) {
                this.c = CharsetProber.ProbingState.NOT_ME;
                break;
            } else if (c2 == 2) {
                this.c = CharsetProber.ProbingState.FOUND_IT;
                break;
            } else {
                if (c2 == 0 && this.b.b() >= 2) {
                    this.d++;
                }
                i++;
            }
        }
        if (this.c == CharsetProber.ProbingState.DETECTING && d() > 0.95f) {
            this.c = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.c;
    }

    public final void j() {
        this.b.d();
        this.d = 0;
        this.c = CharsetProber.ProbingState.DETECTING;
    }
}

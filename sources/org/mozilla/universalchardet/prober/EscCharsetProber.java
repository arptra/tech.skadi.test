package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.HZSMModel;
import org.mozilla.universalchardet.prober.statemachine.ISO2022CNSMModel;
import org.mozilla.universalchardet.prober.statemachine.ISO2022JPSMModel;
import org.mozilla.universalchardet.prober.statemachine.ISO2022KRSMModel;

public class EscCharsetProber extends CharsetProber {
    public static final HZSMModel f = new HZSMModel();
    public static final ISO2022CNSMModel g = new ISO2022CNSMModel();
    public static final ISO2022JPSMModel h = new ISO2022JPSMModel();
    public static final ISO2022KRSMModel i = new ISO2022KRSMModel();
    public CodingStateMachine[] b;
    public int c;
    public CharsetProber.ProbingState d;
    public String e;

    public EscCharsetProber() {
        CodingStateMachine[] codingStateMachineArr = new CodingStateMachine[4];
        this.b = codingStateMachineArr;
        codingStateMachineArr[0] = new CodingStateMachine(f);
        this.b[1] = new CodingStateMachine(g);
        this.b[2] = new CodingStateMachine(h);
        this.b[3] = new CodingStateMachine(i);
        j();
    }

    public String c() {
        return this.e;
    }

    public float d() {
        return 0.99f;
    }

    public CharsetProber.ProbingState e() {
        return this.d;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        while (i2 < i4 && this.d == CharsetProber.ProbingState.DETECTING) {
            for (int i5 = this.c - 1; i5 >= 0; i5--) {
                int c2 = this.b[i5].c(bArr[i2]);
                if (c2 == 1) {
                    int i6 = this.c - 1;
                    this.c = i6;
                    if (i6 <= 0) {
                        CharsetProber.ProbingState probingState = CharsetProber.ProbingState.NOT_ME;
                        this.d = probingState;
                        return probingState;
                    } else if (i5 != i6) {
                        CodingStateMachine[] codingStateMachineArr = this.b;
                        CodingStateMachine codingStateMachine = codingStateMachineArr[i6];
                        codingStateMachineArr[i6] = codingStateMachineArr[i5];
                        codingStateMachineArr[i5] = codingStateMachine;
                    }
                } else if (c2 == 2) {
                    this.d = CharsetProber.ProbingState.FOUND_IT;
                    this.e = this.b[i5].a();
                    return this.d;
                }
            }
            i2++;
        }
        return this.d;
    }

    public final void j() {
        this.d = CharsetProber.ProbingState.DETECTING;
        int i2 = 0;
        while (true) {
            CodingStateMachine[] codingStateMachineArr = this.b;
            if (i2 < codingStateMachineArr.length) {
                codingStateMachineArr[i2].d();
                i2++;
            } else {
                this.c = codingStateMachineArr.length;
                this.e = null;
                return;
            }
        }
    }
}

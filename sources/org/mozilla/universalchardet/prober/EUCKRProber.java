package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.distributionanalysis.EUCKRDistributionAnalysis;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.EUCKRSMModel;
import org.mozilla.universalchardet.prober.statemachine.SMModel;

public class EUCKRProber extends CharsetProber {
    public static final SMModel f = new EUCKRSMModel();
    public CodingStateMachine b = new CodingStateMachine(f);
    public CharsetProber.ProbingState c;
    public EUCKRDistributionAnalysis d = new EUCKRDistributionAnalysis();
    public byte[] e = new byte[2];

    public EUCKRProber() {
        j();
    }

    public String c() {
        return Constants.j;
    }

    public float d() {
        return this.d.a();
    }

    public CharsetProber.ProbingState e() {
        return this.c;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        int i4 = i;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            int c2 = this.b.c(bArr[i4]);
            if (c2 == 1) {
                this.c = CharsetProber.ProbingState.NOT_ME;
                break;
            } else if (c2 == 2) {
                this.c = CharsetProber.ProbingState.FOUND_IT;
                break;
            } else {
                if (c2 == 0) {
                    int b2 = this.b.b();
                    if (i4 == i) {
                        byte[] bArr2 = this.e;
                        bArr2[1] = bArr[i];
                        this.d.d(bArr2, 0, b2);
                    } else {
                        this.d.d(bArr, i4 - 1, b2);
                    }
                }
                i4++;
            }
        }
        this.e[0] = bArr[i3 - 1];
        if (this.c == CharsetProber.ProbingState.DETECTING && this.d.c() && d() > 0.95f) {
            this.c = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.c;
    }

    public final void j() {
        this.b.d();
        this.c = CharsetProber.ProbingState.DETECTING;
        this.d.e();
        Arrays.fill(this.e, (byte) 0);
    }
}

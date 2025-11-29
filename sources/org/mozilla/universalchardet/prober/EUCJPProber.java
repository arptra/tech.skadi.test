package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.contextanalysis.EUCJPContextAnalysis;
import org.mozilla.universalchardet.prober.distributionanalysis.EUCJPDistributionAnalysis;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.EUCJPSMModel;
import org.mozilla.universalchardet.prober.statemachine.SMModel;

public class EUCJPProber extends CharsetProber {
    public static final SMModel g = new EUCJPSMModel();
    public CodingStateMachine b = new CodingStateMachine(g);
    public CharsetProber.ProbingState c;
    public EUCJPContextAnalysis d = new EUCJPContextAnalysis();
    public EUCJPDistributionAnalysis e = new EUCJPDistributionAnalysis();
    public byte[] f = new byte[2];

    public EUCJPProber() {
        j();
    }

    public String c() {
        return Constants.i;
    }

    public float d() {
        return Math.max(this.d.a(), this.e.a());
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
                        byte[] bArr2 = this.f;
                        bArr2[1] = bArr[i];
                        this.d.d(bArr2, 0, b2);
                        this.e.d(this.f, 0, b2);
                    } else {
                        int i5 = i4 - 1;
                        this.d.d(bArr, i5, b2);
                        this.e.d(bArr, i5, b2);
                    }
                }
                i4++;
            }
        }
        this.f[0] = bArr[i3 - 1];
        if (this.c == CharsetProber.ProbingState.DETECTING && this.d.c() && d() > 0.95f) {
            this.c = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.c;
    }

    public final void j() {
        this.b.d();
        this.c = CharsetProber.ProbingState.DETECTING;
        this.d.e();
        this.e.e();
        Arrays.fill(this.f, (byte) 0);
    }
}

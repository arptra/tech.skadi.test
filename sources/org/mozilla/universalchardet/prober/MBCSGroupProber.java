package org.mozilla.universalchardet.prober;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mozilla.universalchardet.prober.CharsetProber;

public class MBCSGroupProber extends CharsetProber {
    public CharsetProber.ProbingState b;
    public List c;
    public CharsetProber d;
    public int e;

    public MBCSGroupProber() {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        arrayList.add(new UTF8Prober());
        this.c.add(new SJISProber());
        this.c.add(new EUCJPProber());
        this.c.add(new GB18030Prober());
        this.c.add(new EUCKRProber());
        this.c.add(new Big5Prober());
        this.c.add(new EUCTWProber());
        j();
    }

    public String c() {
        if (this.d == null) {
            d();
            if (this.d == null) {
                this.d = (CharsetProber) this.c.get(0);
            }
        }
        return this.d.c();
    }

    public float d() {
        CharsetProber.ProbingState probingState = this.b;
        if (probingState == CharsetProber.ProbingState.FOUND_IT) {
            return 0.99f;
        }
        if (probingState == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        float f = 0.0f;
        for (CharsetProber charsetProber : this.c) {
            if (charsetProber.g()) {
                float d2 = charsetProber.d();
                if (f < d2) {
                    this.d = charsetProber;
                    f = d2;
                }
            }
        }
        return f;
    }

    public CharsetProber.ProbingState e() {
        return this.b;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        int i3 = i2 + i;
        boolean z = true;
        int i4 = 0;
        while (i < i3) {
            byte b2 = bArr[i];
            if ((b2 & 128) != 0) {
                bArr2[i4] = b2;
                i4++;
                z = true;
            } else if (z) {
                bArr2[i4] = b2;
                i4++;
                z = false;
            }
            i++;
        }
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CharsetProber charsetProber = (CharsetProber) it.next();
            if (charsetProber.g()) {
                CharsetProber.ProbingState f = charsetProber.f(bArr2, 0, i4);
                CharsetProber.ProbingState probingState = CharsetProber.ProbingState.FOUND_IT;
                if (f == probingState) {
                    this.d = charsetProber;
                    this.b = probingState;
                    break;
                }
                CharsetProber.ProbingState probingState2 = CharsetProber.ProbingState.NOT_ME;
                if (f == probingState2) {
                    charsetProber.k(false);
                    int i5 = this.e - 1;
                    this.e = i5;
                    if (i5 <= 0) {
                        this.b = probingState2;
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return this.b;
    }

    public final void j() {
        this.e = 0;
        for (CharsetProber charsetProber : this.c) {
            charsetProber.j();
            charsetProber.k(true);
            this.e++;
        }
        this.d = null;
        this.b = CharsetProber.ProbingState.DETECTING;
    }
}

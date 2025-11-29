package org.mozilla.universalchardet.prober;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.sequence.HebrewModel;
import org.mozilla.universalchardet.prober.sequence.Ibm855Model;
import org.mozilla.universalchardet.prober.sequence.Ibm866Model;
import org.mozilla.universalchardet.prober.sequence.Koi8rModel;
import org.mozilla.universalchardet.prober.sequence.Latin5BulgarianModel;
import org.mozilla.universalchardet.prober.sequence.Latin5Model;
import org.mozilla.universalchardet.prober.sequence.Latin7Model;
import org.mozilla.universalchardet.prober.sequence.MacCyrillicModel;
import org.mozilla.universalchardet.prober.sequence.ThaiModel;
import org.mozilla.universalchardet.prober.sequence.Win1251BulgarianModel;
import org.mozilla.universalchardet.prober.sequence.Win1251Model;
import org.mozilla.universalchardet.prober.sequence.Win1253Model;

public class SBCSGroupProber extends CharsetProber {
    public CharsetProber.ProbingState b;
    public List c;
    public CharsetProber d;
    public int e;

    public SBCSGroupProber() {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        arrayList.add(new SingleByteCharsetProber(new Win1251Model()));
        this.c.add(new SingleByteCharsetProber(new Koi8rModel()));
        this.c.add(new SingleByteCharsetProber(new Latin5Model()));
        this.c.add(new SingleByteCharsetProber(new MacCyrillicModel()));
        this.c.add(new SingleByteCharsetProber(new Ibm866Model()));
        this.c.add(new SingleByteCharsetProber(new Ibm855Model()));
        this.c.add(new SingleByteCharsetProber(new Latin7Model()));
        this.c.add(new SingleByteCharsetProber(new Win1253Model()));
        this.c.add(new SingleByteCharsetProber(new Latin5BulgarianModel()));
        this.c.add(new SingleByteCharsetProber(new Win1251BulgarianModel()));
        this.c.add(new SingleByteCharsetProber(new ThaiModel()));
        HebrewModel hebrewModel = new HebrewModel();
        HebrewProber hebrewProber = new HebrewProber();
        SingleByteCharsetProber singleByteCharsetProber = new SingleByteCharsetProber(hebrewModel, false, hebrewProber);
        SingleByteCharsetProber singleByteCharsetProber2 = new SingleByteCharsetProber(hebrewModel, true, hebrewProber);
        hebrewProber.n(singleByteCharsetProber, singleByteCharsetProber2);
        this.c.add(hebrewProber);
        this.c.add(singleByteCharsetProber);
        this.c.add(singleByteCharsetProber2);
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
        ByteBuffer b2 = b(bArr, i, i2);
        if (b2.position() != 0) {
            Iterator it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CharsetProber charsetProber = (CharsetProber) it.next();
                if (charsetProber.g()) {
                    CharsetProber.ProbingState f = charsetProber.f(b2.array(), 0, b2.position());
                    CharsetProber.ProbingState probingState = CharsetProber.ProbingState.FOUND_IT;
                    if (f == probingState) {
                        this.d = charsetProber;
                        this.b = probingState;
                        break;
                    }
                    CharsetProber.ProbingState probingState2 = CharsetProber.ProbingState.NOT_ME;
                    if (f == probingState2) {
                        charsetProber.k(false);
                        int i3 = this.e - 1;
                        this.e = i3;
                        if (i3 <= 0) {
                            this.b = probingState2;
                            break;
                        }
                    } else {
                        continue;
                    }
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

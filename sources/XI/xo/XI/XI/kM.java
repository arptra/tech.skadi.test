package XI.xo.XI.XI;

import org.apache.commons.lang3.time.DateUtils;

public class kM {
    public int K0;

    /* renamed from: XI  reason: collision with root package name */
    public String f62XI = null;
    public long kM;

    public kM(String str, int i) {
        this.K0 = i;
        this.kM = System.currentTimeMillis() + DateUtils.MILLIS_PER_DAY;
    }

    public String toString() {
        return "ValueData{value='" + this.f62XI + '\'' + ", code=" + this.K0 + ", expired=" + this.kM + '}';
    }
}

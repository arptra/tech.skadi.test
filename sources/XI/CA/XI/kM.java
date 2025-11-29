package XI.CA.XI;

import android.database.ContentObserver;
import android.os.Handler;

public class kM extends ContentObserver {
    public int K0;

    /* renamed from: XI  reason: collision with root package name */
    public String f45XI;
    public K0 kM;

    public kM(K0 k0, int i, String str) {
        super((Handler) null);
        this.kM = k0;
        this.K0 = i;
        this.f45XI = str;
    }

    public void onChange(boolean z) {
        K0 k0 = this.kM;
        if (k0 != null) {
            k0.K0(this.K0, this.f45XI);
        }
    }
}

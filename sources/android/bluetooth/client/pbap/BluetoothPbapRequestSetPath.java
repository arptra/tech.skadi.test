package android.bluetooth.client.pbap;

import android.util.Log;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants;
import java.io.IOException;
import javax.obex.ClientSession;
import javax.obex.HeaderSet;

final class BluetoothPbapRequestSetPath extends BluetoothPbapRequest {
    public SetPathDir e;

    /* renamed from: android.bluetooth.client.pbap.BluetoothPbapRequestSetPath$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f74a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                android.bluetooth.client.pbap.BluetoothPbapRequestSetPath$SetPathDir[] r0 = android.bluetooth.client.pbap.BluetoothPbapRequestSetPath.SetPathDir.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f74a = r0
                android.bluetooth.client.pbap.BluetoothPbapRequestSetPath$SetPathDir r1 = android.bluetooth.client.pbap.BluetoothPbapRequestSetPath.SetPathDir.ROOT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f74a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.bluetooth.client.pbap.BluetoothPbapRequestSetPath$SetPathDir r1 = android.bluetooth.client.pbap.BluetoothPbapRequestSetPath.SetPathDir.DOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f74a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.bluetooth.client.pbap.BluetoothPbapRequestSetPath$SetPathDir r1 = android.bluetooth.client.pbap.BluetoothPbapRequestSetPath.SetPathDir.UP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.bluetooth.client.pbap.BluetoothPbapRequestSetPath.AnonymousClass1.<clinit>():void");
        }
    }

    public enum SetPathDir {
        ROOT,
        UP,
        DOWN
    }

    public void c(ClientSession clientSession) {
        Log.v("BluetoothPbapRequestSetPath", "execute");
        try {
            int i = AnonymousClass1.f74a[this.e.ordinal()];
            HeaderSet j = (i == 1 || i == 2) ? clientSession.j(this.f73a, false, false) : i != 3 ? null : clientSession.j(this.f73a, true, false);
            this.b = j != null ? j.w : 208;
        } catch (IOException unused) {
            this.b = AdvPackConstants.ADV_MODE_REQUEST_CONNECT;
        }
    }
}

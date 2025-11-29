package android.bluetooth.client.pbap;

import android.util.Log;
import com.android.vcard.VCardEntry;
import java.io.IOException;
import java.io.InputStream;

final class BluetoothPbapRequestPullVcardEntry extends BluetoothPbapRequest {
    public BluetoothPbapVcardList e;
    public final byte f;

    public void b(int i) {
        Log.v("BluetoothPbapRequestPullVcardEntry", "checkResponseCode");
        if (this.e.b() != 0) {
            return;
        }
        if (i == 196) {
            Log.v("BluetoothPbapRequestPullVcardEntry", "Vcard Entry not found");
            return;
        }
        throw new IOException("Invalid response received");
    }

    public void e(InputStream inputStream) {
        Log.v("BluetoothPbapRequestPullVcardEntry", "readResponse");
        this.e = new BluetoothPbapVcardList(inputStream, this.f);
    }

    public VCardEntry g() {
        return this.e.c();
    }
}

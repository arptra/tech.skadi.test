package android.bluetooth.client.pbap;

import android.annotation.SuppressLint;
import android.bluetooth.client.pbap.utils.ObexAppParameters;
import android.util.Log;
import java.io.InputStream;
import java.util.ArrayList;
import javax.obex.HeaderSet;

@SuppressLint({"LongLogTag"})
final class BluetoothPbapRequestPullVcardListing extends BluetoothPbapRequest {
    public BluetoothPbapVcardListing e;
    public int f;

    public void e(InputStream inputStream) {
        Log.v("BluetoothPbapRequestPullVcardListing", "readResponse");
        this.e = new BluetoothPbapVcardListing(inputStream);
    }

    public void f(HeaderSet headerSet) {
        Log.v("BluetoothPbapRequestPullVcardListing", "readResponseHeaders");
        ObexAppParameters g = ObexAppParameters.g(headerSet);
        if (g.f((byte) 9)) {
            this.f = g.h((byte) 9);
        }
    }

    public ArrayList g() {
        return this.e.a();
    }

    public int h() {
        return this.f;
    }
}

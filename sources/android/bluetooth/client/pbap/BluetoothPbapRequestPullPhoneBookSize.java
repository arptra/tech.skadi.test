package android.bluetooth.client.pbap;

import android.bluetooth.client.pbap.utils.ObexAppParameters;
import android.util.Log;
import javax.obex.HeaderSet;

class BluetoothPbapRequestPullPhoneBookSize extends BluetoothPbapRequest {
    public int e;

    public void f(HeaderSet headerSet) {
        Log.v("BluetoothPbapRequestPullPhoneBookSize", "readResponseHeaders");
        this.e = ObexAppParameters.g(headerSet).j((byte) 8);
    }

    public int g() {
        return this.e;
    }
}

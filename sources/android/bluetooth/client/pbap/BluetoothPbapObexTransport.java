package android.bluetooth.client.pbap;

import android.bluetooth.BluetoothSocket;
import java.io.InputStream;
import java.io.OutputStream;
import javax.obex.ObexTransport;

class BluetoothPbapObexTransport implements ObexTransport {

    /* renamed from: a  reason: collision with root package name */
    public BluetoothSocket f72a;

    public BluetoothPbapObexTransport(BluetoothSocket bluetoothSocket) {
        this.f72a = bluetoothSocket;
    }

    public InputStream a() {
        return this.f72a.getInputStream();
    }

    public OutputStream b() {
        return this.f72a.getOutputStream();
    }

    public void close() {
        this.f72a.close();
    }
}

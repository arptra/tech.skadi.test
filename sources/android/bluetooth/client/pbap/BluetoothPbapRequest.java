package android.bluetooth.client.pbap;

import android.util.Log;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants;
import java.io.IOException;
import java.io.InputStream;
import javax.obex.ClientOperation;
import javax.obex.ClientSession;
import javax.obex.HeaderSet;

abstract class BluetoothPbapRequest {

    /* renamed from: a  reason: collision with root package name */
    public HeaderSet f73a = new HeaderSet();
    public int b;
    public boolean c = false;
    public ClientOperation d = null;

    public void a() {
        this.c = true;
        ClientOperation clientOperation = this.d;
        if (clientOperation != null) {
            try {
                clientOperation.e();
            } catch (IOException e) {
                Log.e("BluetoothPbapRequest", "Exception occured when trying to abort", e);
            }
        }
    }

    public void b(int i) {
        Log.v("BluetoothPbapRequest", "checkResponseCode");
    }

    public void c(ClientSession clientSession) {
        Log.v("BluetoothPbapRequest", "execute");
        if (this.c) {
            this.b = AdvPackConstants.ADV_MODE_REQUEST_CONNECT;
            return;
        }
        try {
            ClientOperation clientOperation = (ClientOperation) clientSession.g(this.f73a);
            this.d = clientOperation;
            clientOperation.k(true);
            this.d.b(true, false);
            f(this.d.g());
            InputStream i = this.d.i();
            e(i);
            i.close();
            this.d.f();
            this.b = this.d.h();
            Log.d("BluetoothPbapRequest", "mResponseCode=" + this.b);
            b(this.b);
        } catch (IOException e) {
            Log.e("BluetoothPbapRequest", "IOException occured when processing request", e);
            this.b = AdvPackConstants.ADV_MODE_REQUEST_CONNECT;
            throw e;
        }
    }

    public final boolean d() {
        return this.b == 160;
    }

    public void e(InputStream inputStream) {
        Log.v("BluetoothPbapRequest", "readResponse");
    }

    public void f(HeaderSet headerSet) {
        Log.v("BluetoothPbapRequest", "readResponseHeaders");
    }
}

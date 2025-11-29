package android.bluetooth.client.pbap;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Message;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.HandlerThreadUtil;
import java.io.IOException;
import java.util.UUID;

class BluetoothPbapSession implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final BluetoothAdapter f75a;
    public final BluetoothDevice b;
    public final Handler c;
    public final Handler d;
    public RfcommConnectThread e;
    public BluetoothPbapObexTransport f;
    public BluetoothPbapObexSession g;
    public BluetoothPbapRequest h = null;

    public class RfcommConnectThread extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public BluetoothSocket f76a;

        public RfcommConnectThread() {
            super("RfcommConnectThread");
        }

        public final void b() {
            try {
                BluetoothSocket bluetoothSocket = this.f76a;
                if (bluetoothSocket != null) {
                    bluetoothSocket.close();
                }
            } catch (IOException e) {
                StLog.e("RfcommConnectThread", "Error when closing socket", (Throwable) e);
            }
        }

        public void run() {
            if (BluetoothPbapSession.this.f75a.isDiscovering()) {
                BluetoothPbapSession.this.f75a.cancelDiscovery();
            }
            try {
                BluetoothSocket createRfcommSocketToServiceRecord = BluetoothPbapSession.this.b.createRfcommSocketToServiceRecord(UUID.fromString("0000112f-0000-1000-8000-00805f9b34fb"));
                this.f76a = createRfcommSocketToServiceRecord;
                createRfcommSocketToServiceRecord.connect();
                BluetoothPbapSession.this.d.obtainMessage(1, new BluetoothPbapObexTransport(this.f76a)).sendToTarget();
            } catch (IOException unused) {
                b();
                BluetoothPbapSession.this.d.obtainMessage(2).sendToTarget();
            }
        }
    }

    public BluetoothPbapSession(BluetoothDevice bluetoothDevice, Handler handler) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.f75a = defaultAdapter;
        if (defaultAdapter != null) {
            this.b = bluetoothDevice;
            this.c = handler;
            this.e = null;
            this.f = null;
            this.g = null;
            this.d = new Handler(HandlerThreadUtil.getInstance().getLooper("pbap_session_" + bluetoothDevice.getAddress(), 10), this);
            return;
        }
        throw new NullPointerException("No Bluetooth adapter in the system");
    }

    public boolean d(BluetoothPbapRequest bluetoothPbapRequest) {
        StLog.v("BluetoothPbapSession", "makeRequest: " + bluetoothPbapRequest.getClass().getSimpleName());
        if (this.h != null) {
            StLog.w("BluetoothPbapSession", "makeRequest: request already queued, exiting");
            return false;
        }
        BluetoothPbapObexSession bluetoothPbapObexSession = this.g;
        if (bluetoothPbapObexSession != null) {
            return bluetoothPbapObexSession.f(bluetoothPbapRequest);
        }
        this.h = bluetoothPbapRequest;
        h();
        return true;
    }

    public boolean e(String str) {
        StLog.d("BluetoothPbapSession", "setAuthResponse key=" + str);
        this.d.removeMessages(106);
        BluetoothPbapObexSession bluetoothPbapObexSession = this.g;
        if (bluetoothPbapObexSession == null) {
            return false;
        }
        return bluetoothPbapObexSession.g(str);
    }

    public void f() {
        StLog.d("BluetoothPbapSession", MzContactsContract.START_PARAM_KEY);
        h();
    }

    public final void g() {
        StLog.d("BluetoothPbapSession", "startObexSession");
        BluetoothPbapObexSession bluetoothPbapObexSession = new BluetoothPbapObexSession(this.f);
        this.g = bluetoothPbapObexSession;
        bluetoothPbapObexSession.h(this.d);
    }

    public final void h() {
        StLog.d("BluetoothPbapSession", "startRfcomm ");
        RfcommConnectThread rfcommConnectThread = this.e;
        if (rfcommConnectThread == null || (rfcommConnectThread.f76a != null && !this.e.f76a.isConnected())) {
            this.c.obtainMessage(5).sendToTarget();
            RfcommConnectThread rfcommConnectThread2 = new RfcommConnectThread();
            this.e = rfcommConnectThread2;
            rfcommConnectThread2.start();
        }
    }

    public boolean handleMessage(Message message) {
        StLog.d("BluetoothPbapSession", "msg: " + message.what);
        int i = message.what;
        if (i == 1) {
            this.e = null;
            this.f = (BluetoothPbapObexTransport) message.obj;
            g();
        } else if (i != 2) {
            switch (i) {
                case 100:
                    this.c.obtainMessage(6).sendToTarget();
                    BluetoothPbapRequest bluetoothPbapRequest = this.h;
                    if (bluetoothPbapRequest != null) {
                        this.g.f(bluetoothPbapRequest);
                        this.h = null;
                        break;
                    }
                    break;
                case 101:
                    j();
                    BluetoothPbapRequest bluetoothPbapRequest2 = this.h;
                    if (bluetoothPbapRequest2 != null) {
                        this.c.obtainMessage(4, bluetoothPbapRequest2).sendToTarget();
                        this.h = null;
                    }
                    this.c.obtainMessage(7).sendToTarget();
                    break;
                case 102:
                    this.c.obtainMessage(7).sendToTarget();
                    k();
                    break;
                case 103:
                    this.c.obtainMessage(3, message.obj).sendToTarget();
                    break;
                case 104:
                    this.c.obtainMessage(4, message.obj).sendToTarget();
                    break;
                case 105:
                    this.c.obtainMessage(8).sendToTarget();
                    Handler handler = this.d;
                    handler.sendMessageDelayed(handler.obtainMessage(106), 30000);
                    break;
                case 106:
                    e((String) null);
                    this.c.obtainMessage(9).sendToTarget();
                    break;
                default:
                    return false;
            }
        } else {
            this.e = null;
            this.c.obtainMessage(7).sendToTarget();
            BluetoothPbapRequest bluetoothPbapRequest3 = this.h;
            if (bluetoothPbapRequest3 != null) {
                this.c.obtainMessage(4, bluetoothPbapRequest3).sendToTarget();
                this.h = null;
            }
        }
        return true;
    }

    public void i() {
        StLog.d("BluetoothPbapSession", "Stop");
        j();
        k();
    }

    public final void j() {
        StLog.d("BluetoothPbapSession", "stopObexSession");
        BluetoothPbapObexSession bluetoothPbapObexSession = this.g;
        if (bluetoothPbapObexSession != null) {
            bluetoothPbapObexSession.i();
            this.g = null;
        }
    }

    public final void k() {
        StLog.d("BluetoothPbapSession", "stopRfcomm");
        RfcommConnectThread rfcommConnectThread = this.e;
        if (rfcommConnectThread != null) {
            try {
                rfcommConnectThread.join();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            this.e = null;
        }
        BluetoothPbapObexTransport bluetoothPbapObexTransport = this.f;
        if (bluetoothPbapObexTransport != null) {
            try {
                bluetoothPbapObexTransport.close();
            } catch (IOException unused2) {
            }
            this.f = null;
        }
    }
}

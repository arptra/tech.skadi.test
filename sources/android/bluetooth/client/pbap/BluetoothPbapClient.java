package android.bluetooth.client.pbap;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.HandlerThreadUtil;
import com.upuphone.starrynet.core.bredr.listener.IBTPbapClientEventCallback;

public class BluetoothPbapClient {

    /* renamed from: a  reason: collision with root package name */
    public final IBTPbapClientEventCallback f66a;
    public final BluetoothPbapSession b;
    public ConnectionState c = ConnectionState.DISCONNECTED;

    public enum ConnectionState {
        DISCONNECTED,
        CONNECTING,
        CONNECTED,
        DISCONNECTING
    }

    public static class SessionHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public BluetoothPbapClient f67a;

        public SessionHandler(BluetoothPbapClient bluetoothPbapClient, Looper looper) {
            super(looper);
            this.f67a = bluetoothPbapClient;
        }

        public void handleMessage(Message message) {
            StLog.d("BluetoothPbapClient", "msg: " + message.what);
            BluetoothPbapClient bluetoothPbapClient = this.f67a;
            if (bluetoothPbapClient != null) {
                switch (message.what) {
                    case 3:
                        BluetoothPbapRequest bluetoothPbapRequest = (BluetoothPbapRequest) message.obj;
                        if (bluetoothPbapRequest instanceof BluetoothPbapRequestPullPhoneBookSize) {
                            bluetoothPbapClient.k(5, ((BluetoothPbapRequestPullPhoneBookSize) bluetoothPbapRequest).g());
                            return;
                        } else if (bluetoothPbapRequest instanceof BluetoothPbapRequestPullVcardListingSize) {
                            bluetoothPbapClient.k(6, ((BluetoothPbapRequestPullVcardListingSize) bluetoothPbapRequest).g());
                            return;
                        } else if (bluetoothPbapRequest instanceof BluetoothPbapRequestPullPhoneBook) {
                            BluetoothPbapRequestPullPhoneBook bluetoothPbapRequestPullPhoneBook = (BluetoothPbapRequestPullPhoneBook) bluetoothPbapRequest;
                            bluetoothPbapClient.l(2, bluetoothPbapRequestPullPhoneBook.h(), bluetoothPbapRequestPullPhoneBook.g());
                            return;
                        } else if (bluetoothPbapRequest instanceof BluetoothPbapRequestPullVcardListing) {
                            BluetoothPbapRequestPullVcardListing bluetoothPbapRequestPullVcardListing = (BluetoothPbapRequestPullVcardListing) bluetoothPbapRequest;
                            bluetoothPbapClient.l(3, bluetoothPbapRequestPullVcardListing.h(), bluetoothPbapRequestPullVcardListing.g());
                            return;
                        } else if (bluetoothPbapRequest instanceof BluetoothPbapRequestPullVcardEntry) {
                            bluetoothPbapClient.m(4, ((BluetoothPbapRequestPullVcardEntry) bluetoothPbapRequest).g());
                            return;
                        } else if (bluetoothPbapRequest instanceof BluetoothPbapRequestSetPath) {
                            bluetoothPbapClient.j(1);
                            return;
                        } else {
                            return;
                        }
                    case 4:
                        BluetoothPbapRequest bluetoothPbapRequest2 = (BluetoothPbapRequest) message.obj;
                        if (bluetoothPbapRequest2 instanceof BluetoothPbapRequestPullPhoneBookSize) {
                            bluetoothPbapClient.j(105);
                            return;
                        } else if (bluetoothPbapRequest2 instanceof BluetoothPbapRequestPullVcardListingSize) {
                            bluetoothPbapClient.j(106);
                            return;
                        } else if (bluetoothPbapRequest2 instanceof BluetoothPbapRequestPullPhoneBook) {
                            bluetoothPbapClient.j(102);
                            return;
                        } else if (bluetoothPbapRequest2 instanceof BluetoothPbapRequestPullVcardListing) {
                            bluetoothPbapClient.j(103);
                            return;
                        } else if (bluetoothPbapRequest2 instanceof BluetoothPbapRequestPullVcardEntry) {
                            bluetoothPbapClient.j(104);
                            return;
                        } else if (bluetoothPbapRequest2 instanceof BluetoothPbapRequestSetPath) {
                            bluetoothPbapClient.j(101);
                            return;
                        } else {
                            return;
                        }
                    case 5:
                        ConnectionState unused = bluetoothPbapClient.c = ConnectionState.CONNECTING;
                        return;
                    case 6:
                        ConnectionState unused2 = bluetoothPbapClient.c = ConnectionState.CONNECTED;
                        bluetoothPbapClient.j(201);
                        return;
                    case 7:
                        ConnectionState unused3 = bluetoothPbapClient.c = ConnectionState.DISCONNECTED;
                        bluetoothPbapClient.j(202);
                        return;
                    case 8:
                        bluetoothPbapClient.j(203);
                        return;
                    case 9:
                        bluetoothPbapClient.j(204);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public BluetoothPbapClient(BluetoothDevice bluetoothDevice, IBTPbapClientEventCallback iBTPbapClientEventCallback) {
        if (bluetoothDevice != null) {
            this.f66a = iBTPbapClientEventCallback;
            this.b = new BluetoothPbapSession(bluetoothDevice, new SessionHandler(this, HandlerThreadUtil.getInstance().getLooper("pbap_client_" + bluetoothDevice.getAddress())));
            return;
        }
        throw new NullPointerException("BluetoothDevice is null");
    }

    public void f() {
        this.b.f();
    }

    public void finalize() {
        BluetoothPbapSession bluetoothPbapSession = this.b;
        if (bluetoothPbapSession != null) {
            bluetoothPbapSession.i();
        }
    }

    public void g() {
        this.b.i();
    }

    public boolean h(String str) {
        return i(str, 0, (byte) 0, 0, 0);
    }

    public boolean i(String str, long j, byte b2, int i, int i2) {
        return this.b.d(new BluetoothPbapRequestPullPhoneBook(str, j, b2, i, i2));
    }

    public final void j(int i) {
        l(i, 0, (Object) null);
    }

    public final void k(int i, int i2) {
        l(i, i2, (Object) null);
    }

    public final void l(int i, int i2, Object obj) {
        this.f66a.onEvent(i, i2, 0, obj);
    }

    public final void m(int i, Object obj) {
        l(i, 0, obj);
    }
}

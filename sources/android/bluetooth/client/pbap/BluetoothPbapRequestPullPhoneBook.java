package android.bluetooth.client.pbap;

import android.bluetooth.client.pbap.utils.ObexAppParameters;
import android.util.Log;
import java.io.InputStream;
import java.util.ArrayList;
import javax.obex.HeaderSet;

final class BluetoothPbapRequestPullPhoneBook extends BluetoothPbapRequest {
    public BluetoothPbapVcardList e;
    public int f = -1;
    public final byte g;

    public BluetoothPbapRequestPullPhoneBook(String str, long j, byte b, int i, int i2) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("maxListCount should be [0..65535]");
        } else if (i2 < 0 || i2 > 65535) {
            throw new IllegalArgumentException("listStartOffset should be [0..65535]");
        } else {
            this.f73a.e(1, str);
            this.f73a.e(66, "x-bt/phonebook");
            ObexAppParameters obexAppParameters = new ObexAppParameters();
            if (!(b == 0 || b == 1)) {
                b = 0;
            }
            if (j != 0) {
                obexAppParameters.b((byte) 6, j);
            }
            obexAppParameters.a((byte) 7, b);
            if (i > 0) {
                obexAppParameters.c((byte) 4, (short) i);
            } else {
                obexAppParameters.c((byte) 4, -1);
            }
            if (i2 > 0) {
                obexAppParameters.c((byte) 5, (short) i2);
            }
            obexAppParameters.e(this.f73a);
            this.g = b;
        }
    }

    public void e(InputStream inputStream) {
        Log.v("BluetoothPbapRequestPullPhoneBook", "readResponse");
        this.e = new BluetoothPbapVcardList(inputStream, this.g);
    }

    public void f(HeaderSet headerSet) {
        Log.v("BluetoothPbapRequestPullPhoneBook", "readResponse");
        ObexAppParameters g2 = ObexAppParameters.g(headerSet);
        if (g2.f((byte) 9)) {
            this.f = g2.h((byte) 9);
        }
    }

    public ArrayList g() {
        return this.e.d();
    }

    public int h() {
        return this.f;
    }
}

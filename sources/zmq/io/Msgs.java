package zmq.io;

import zmq.Msg;

public class Msgs {
    public static boolean a(Msg msg, String str, boolean z) {
        int length = str.length();
        if (msg.O() < length + (z ? 1 : 0)) {
            return false;
        }
        boolean z2 = !z || length == (msg.e(0) & 255);
        if (z2) {
            for (int i = z; i < length; i++) {
                z2 = msg.e(i) == str.charAt(i - z);
                if (!z2) {
                    break;
                }
            }
        }
        return z2;
    }
}

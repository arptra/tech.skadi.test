package android.bluetooth.client.pbap;

import com.android.vcard.VCardEntry;
import com.android.vcard.VCardEntryConstructor;
import com.android.vcard.VCardEntryCounter;
import com.android.vcard.VCardEntryHandler;
import com.android.vcard.VCardParser;
import com.android.vcard.VCardParser_V21;
import com.android.vcard.VCardParser_V30;
import com.android.vcard.exception.VCardException;
import java.io.InputStream;
import java.util.ArrayList;

class BluetoothPbapVcardList {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f77a = new ArrayList();

    public class CardEntryHandler implements VCardEntryHandler {
        public CardEntryHandler() {
        }

        public void a(VCardEntry vCardEntry) {
            BluetoothPbapVcardList.this.f77a.add(vCardEntry);
        }

        public void b() {
        }

        public void onStart() {
        }
    }

    public BluetoothPbapVcardList(InputStream inputStream, byte b) {
        e(inputStream, b);
    }

    public int b() {
        return this.f77a.size();
    }

    public VCardEntry c() {
        return (VCardEntry) this.f77a.get(0);
    }

    public ArrayList d() {
        return this.f77a;
    }

    public final void e(InputStream inputStream, byte b) {
        VCardParser vCardParser_V30 = b == 1 ? new VCardParser_V30() : new VCardParser_V21();
        VCardEntryConstructor vCardEntryConstructor = new VCardEntryConstructor();
        VCardEntryCounter vCardEntryCounter = new VCardEntryCounter();
        vCardEntryConstructor.f(new CardEntryHandler());
        vCardParser_V30.a(vCardEntryConstructor);
        vCardParser_V30.a(vCardEntryCounter);
        try {
            vCardParser_V30.b(inputStream);
        } catch (VCardException e) {
            e.printStackTrace();
        }
    }
}

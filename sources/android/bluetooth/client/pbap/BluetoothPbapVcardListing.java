package android.bluetooth.client.pbap;

import android.util.Log;
import android.util.Xml;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class BluetoothPbapVcardListing {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f79a = new ArrayList();

    public BluetoothPbapVcardListing(InputStream inputStream) {
        b(inputStream);
    }

    public ArrayList a() {
        return this.f79a;
    }

    public final void b(InputStream inputStream) {
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(inputStream, "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2 && newPullParser.getName().equals("card")) {
                    this.f79a.add(new BluetoothPbapCard(newPullParser.getAttributeValue((String) null, "handle"), newPullParser.getAttributeValue((String) null, "name")));
                }
            }
        } catch (XmlPullParserException e) {
            Log.e("BluetoothPbapVcardListing", "XML parser error when parsing XML", e);
        }
    }
}

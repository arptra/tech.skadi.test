package android.bluetooth.client.pbap;

import com.meizu.common.widget.MzContactsContract;
import org.json.JSONException;
import org.json.JSONObject;

public class BluetoothPbapCard {

    /* renamed from: a  reason: collision with root package name */
    public final String f65a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public BluetoothPbapCard(String str, String str2) {
        this.f65a = str;
        this.b = str2;
        String[] split = str2.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD, 5);
        String str3 = null;
        this.c = split.length < 1 ? null : split[0];
        this.d = split.length < 2 ? null : split[1];
        this.e = split.length < 3 ? null : split[2];
        this.f = split.length < 4 ? null : split[3];
        this.g = split.length >= 5 ? split[4] : str3;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("handle", this.f65a);
            jSONObject.put("N", this.b);
            jSONObject.put("lastName", this.c);
            jSONObject.put("firstName", this.d);
            jSONObject.put("middleName", this.e);
            jSONObject.put("prefix", this.f);
            jSONObject.put("suffix", this.g);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}

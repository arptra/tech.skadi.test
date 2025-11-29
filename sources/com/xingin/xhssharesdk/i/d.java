package com.xingin.xhssharesdk.i;

import android.text.TextUtils;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.xingin.xhssharesdk.XhsShareConstants$XhsShareNoteErrorCode;
import com.xingin.xhssharesdk.m.a;
import com.xingin.xhssharesdk.o.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements b.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.xingin.xhssharesdk.h.b f8187a;

    public d(b bVar) {
        this.f8187a = bVar;
    }

    public final void a(Exception exc) {
        b bVar = (b) this.f8187a;
        c cVar = bVar.b;
        a aVar = bVar.f8181a;
        cVar.d = new a(aVar.f8192a, aVar.b, aVar.c, aVar.d, false, XhsShareConstants$XhsShareNoteErrorCode.UNKNOWN, exc.getMessage());
        c.d(bVar.b);
    }

    public final void onSuccess(String str) {
        com.xingin.xhssharesdk.n.a aVar;
        b bVar = (b) this.f8187a;
        bVar.getClass();
        try {
            aVar = new com.xingin.xhssharesdk.n.a();
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                aVar.f8194a = jSONObject.getInt("code");
                aVar.b = jSONObject.getBoolean("success");
                aVar.c = jSONObject.optString(PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
            }
        } catch (JSONException e) {
            bVar.b.n.w("XhsShare_Sdk", "CheckTokenResponse convert from json Error!", e);
            aVar = new com.xingin.xhssharesdk.n.a();
        }
        if (aVar.b) {
            b bVar2 = (b) this.f8187a;
            bVar2.getClass();
            c cVar = bVar2.b;
            cVar.d = bVar2.f8181a;
            c.d(cVar);
            return;
        }
        com.xingin.xhssharesdk.h.b bVar3 = this.f8187a;
        int i = aVar.f8194a;
        Exception exc = new Exception(aVar.c);
        b bVar4 = (b) bVar3;
        c cVar2 = bVar4.b;
        a aVar2 = bVar4.f8181a;
        cVar2.d = new a(aVar2.f8192a, aVar2.b, aVar2.c, aVar2.d, false, i, exc.getMessage());
        c.d(bVar4.b);
    }
}

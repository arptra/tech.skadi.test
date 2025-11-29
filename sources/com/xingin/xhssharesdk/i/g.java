package com.xingin.xhssharesdk.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.common.widget.MzContactsContract;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import com.xingin.xhssharesdk.h.c;
import com.xingin.xhssharesdk.m.b;

public final class g extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final c f8188a;

    public g(c cVar) {
        this.f8188a = cVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null && TextUtils.equals(intent.getAction(), "com.xingin.xhs.action.VOLLEY_SHARE_RESULT")) {
            b bVar = new b(intent.getBooleanExtra("success", false), intent.getIntExtra(MzContactsContract.MzNetContacts.ERROR_CODE_KEY, 1), intent.getStringExtra("error_message"), intent.getStringExtra("session_id"));
            XhsShareSdk.b("XhsShare_XhsShareResultReceiver", "Receive the share result, the result is " + bVar);
            c cVar = this.f8188a;
            if (cVar != null) {
                cVar.a(bVar);
            }
        }
    }
}

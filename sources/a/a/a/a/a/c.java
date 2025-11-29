package a.a.a.a.a;

import android.content.Context;
import android.util.Log;
import com.android.dingtalk.openauth.utils.DDAuthUtil;

public class c {
    public static void a(String str) {
        if (DDAuthUtil.isDebug((Context) null)) {
            Log.i("DDOpenAuth", str);
        }
    }
}

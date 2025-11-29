package com.honey.account.data;

import android.content.Context;
import com.honey.account.R;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.utils.log.LogUtils;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"TAG", "", "analysisBasic", "Lkotlin/Triple;", "", "", "context", "Landroid/content/Context;", "jsonBodyObject", "Lorg/json/JSONObject;", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ResponseBasicDataKt {
    @NotNull
    private static final String TAG = "ResponseBasicData";

    @NotNull
    public static final Triple<Integer, String, Object> analysisBasic(@NotNull Context context, @NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jSONObject, "jsonBodyObject");
        try {
            if (jSONObject.has("code")) {
                if (jSONObject.has(AccountConstantKt.RESPONSE_VALUE)) {
                    int i = jSONObject.getInt("code");
                    String string = jSONObject.getString("message");
                    if (i != 200) {
                        if (string != null) {
                            if (string.length() == 0) {
                            }
                        }
                        string = context.getString(R.string.server_response_error);
                    }
                    Object obj = jSONObject.get(AccountConstantKt.RESPONSE_VALUE);
                    if ((obj instanceof String) && ((CharSequence) obj).length() == 0) {
                        obj = null;
                    }
                    return new Triple<>(Integer.valueOf(i), string, obj);
                }
            }
            LogUtils.INSTANCE.e(TAG, "analysisBasic() error, result: " + jSONObject);
            return new Triple<>(AccountConstantKt.getRESULT_RESPONSE_ERROR().getFirst(), AccountConstantKt.getRESULT_RESPONSE_ERROR().getSecond() + jSONObject, null);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.INSTANCE.e(TAG, "ResponseBasicData analysis error, " + e.getMessage());
            Integer first = AccountConstantKt.getRESULT_PROGRAM_EXCEPTION().getFirst();
            StringBuilder sb = new StringBuilder();
            sb.append(AccountConstantKt.getRESULT_PROGRAM_EXCEPTION().getSecond());
            String message = e.getMessage();
            Intrinsics.checkNotNull(message);
            sb.append(message);
            return new Triple<>(first, sb.toString(), null);
        }
    }
}

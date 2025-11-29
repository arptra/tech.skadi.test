package com.honey.account.data;

import android.content.Context;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.utils.log.LogUtils;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"TAG", "", "analysisUpdateNickName", "Lcom/honey/account/data/UpdateNickNameData;", "context", "Landroid/content/Context;", "responseBody", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UpdateNickNameDataKt {
    @NotNull
    private static final String TAG = "UpdateNickNameData";

    @NotNull
    public static final UpdateNickNameData analysisUpdateNickName(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "responseBody");
        try {
            Triple<Integer, String, Object> analysisBasic = ResponseBasicDataKt.analysisBasic(context, new JSONObject(str));
            Object third = analysisBasic.getThird();
            if (third == null) {
                return new UpdateNickNameData(analysisBasic.getFirst().intValue(), analysisBasic.getSecond(), false, 4, (DefaultConstructorMarker) null);
            }
            return new UpdateNickNameData(analysisBasic.getFirst().intValue(), analysisBasic.getSecond(), ((Boolean) third).booleanValue());
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils logUtils = LogUtils.INSTANCE;
            logUtils.e(TAG, "analysisUpdateNickNameData analysis error, " + e.getMessage());
            int intValue = AccountConstantKt.getRESULT_PROGRAM_EXCEPTION().getFirst().intValue();
            StringBuilder sb = new StringBuilder();
            sb.append(AccountConstantKt.getRESULT_PROGRAM_EXCEPTION().getSecond());
            String message = e.getMessage();
            Intrinsics.checkNotNull(message);
            sb.append(message);
            return new UpdateNickNameData(intValue, sb.toString(), false, 4, (DefaultConstructorMarker) null);
        }
    }
}

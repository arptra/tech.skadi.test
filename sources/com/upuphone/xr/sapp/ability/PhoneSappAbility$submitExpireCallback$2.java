package com.upuphone.xr.sapp.ability;

import com.upuphone.star.core.log.ULog;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/upuphone/xr/sapp/ability/PhoneSappAbility$submitExpireCallback$2$1", "invoke", "()Lcom/upuphone/xr/sapp/ability/PhoneSappAbility$submitExpireCallback$2$1;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PhoneSappAbility$submitExpireCallback$2 extends Lambda implements Function0<AnonymousClass1> {
    public static final PhoneSappAbility$submitExpireCallback$2 INSTANCE = new PhoneSappAbility$submitExpireCallback$2();

    public PhoneSappAbility$submitExpireCallback$2() {
        super(0);
    }

    @NotNull
    public final AnonymousClass1 invoke() {
        return new Callback() {
            public void onFailure(Call call, IOException iOException) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(iOException, "e");
                ULog.Delegate delegate = ULog.f6446a;
                delegate.c("PhoneSappAbility", "submitExpireCallback failed, e: " + iOException);
            }

            public void onResponse(Call call, Response response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.code() == 200) {
                    ResponseBody body = response.body();
                    Intrinsics.checkNotNull(body);
                    String string = body.string();
                    ULog.Delegate delegate = ULog.f6446a;
                    delegate.a("PhoneSappAbility", "submitExpireCallback res body: " + string);
                    boolean areEqual = Intrinsics.areEqual(new JSONObject(string).get("code"), (Object) 0);
                    delegate.a("PhoneSappAbility", "submitExpireCallback state: " + areEqual);
                }
            }
        };
    }
}

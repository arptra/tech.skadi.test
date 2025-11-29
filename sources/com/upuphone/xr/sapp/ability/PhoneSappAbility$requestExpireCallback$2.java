package com.upuphone.xr.sapp.ability;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
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

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/upuphone/xr/sapp/ability/PhoneSappAbility$requestExpireCallback$2$1", "invoke", "()Lcom/upuphone/xr/sapp/ability/PhoneSappAbility$requestExpireCallback$2$1;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PhoneSappAbility$requestExpireCallback$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ PhoneSappAbility this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneSappAbility$requestExpireCallback$2(PhoneSappAbility phoneSappAbility) {
        super(0);
        this.this$0 = phoneSappAbility;
    }

    @NotNull
    public final AnonymousClass1 invoke() {
        final PhoneSappAbility phoneSappAbility = this.this$0;
        return new Callback() {
            public void onFailure(Call call, IOException iOException) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(iOException, "e");
                ULog.Delegate delegate = ULog.f6446a;
                delegate.c("PhoneSappAbility", "requestExpireCallback failed, e: " + iOException);
            }

            public void onResponse(Call call, Response response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.code() == 200) {
                    try {
                        ResponseBody body = response.body();
                        Intrinsics.checkNotNull(body);
                        String string = body.string();
                        ULog.Delegate delegate = ULog.f6446a;
                        delegate.a("PhoneSappAbility", "requestExpireCallback res body: " + string);
                        JSONObject jSONObject = new JSONObject(string);
                        if (Intrinsics.areEqual(jSONObject.get("code"), (Object) 0)) {
                            JSONObject jSONObject2 = new JSONObject(jSONObject.get("data").toString());
                            String string2 = jSONObject2.getString("policyId");
                            boolean z = jSONObject2.getBoolean("isExpired");
                            Object obj = jSONObject2.get("agreeTime");
                            delegate.a("PhoneSappAbility", "requestExpireCallback policyId: " + string2 + " and isExpired is: " + z + " and agreeTime is: " + obj);
                            if (!obj.equals((Object) null)) {
                                if (!Intrinsics.areEqual(obj, (Object) 0)) {
                                    if ((obj instanceof Long) && ((Number) obj).longValue() > 0) {
                                        if (z) {
                                            PhoneSappAbility phoneSappAbility = phoneSappAbility;
                                            Intrinsics.checkNotNull(string2);
                                            phoneSappAbility.p(string2, 0);
                                            SuperMessageManger.m.a().Y(string2);
                                            return;
                                        } else if (Intrinsics.areEqual((Object) string2, (Object) "myvu_pp")) {
                                            PhoneSappAbility.l(phoneSappAbility, "glass_pp", (String) null, 2, (Object) null);
                                            return;
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                            String str = (String) DataStoreUtils.i(DataStoreUtils.e.a(), "current_active_location", "", (Context) null, 4, (Object) null);
                            delegate.a("PhoneSappAbility", "requestExpireCallback countryCode " + str);
                            if (Intrinsics.areEqual((Object) str, (Object) "MYS")) {
                                delegate.a("PhoneSappAbility", "requestExpireCallback submit " + string2);
                                PhoneSappAbility phoneSappAbility2 = phoneSappAbility;
                                Intrinsics.checkNotNull(string2);
                                phoneSappAbility2.p(string2, System.currentTimeMillis());
                            }
                        }
                    } catch (Exception e) {
                        ULog.Delegate delegate2 = ULog.f6446a;
                        String message = e.getMessage();
                        delegate2.c("PhoneSappAbility", "requestExpireCallback::e is: " + message);
                    }
                }
            }
        };
    }
}

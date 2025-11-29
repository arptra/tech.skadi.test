package com.xjsd.ai.assistant.env;

import com.upuphone.xr.sapp.config.NetConfigEntity;
import com.upuphone.xr.sapp.context.SdkContext;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/xjsd/ai/assistant/env/UnifiedEnvAbility;", "Lcom/xjsd/ai/assistant/env/EnvAbility;", "()V", "environment", "Lcom/xjsd/ai/assistant/env/Environment;", "changeEnv", "", "env", "", "getCurrentEnv", "getEnv", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UnifiedEnvAbility implements EnvAbility {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "UnifiedEnvAbility";
    @Nullable
    private Environment environment;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/env/UnifiedEnvAbility$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void changeEnv(int i) {
        ILog.a(TAG, "changeEnv: 环境参数由主应用统一控制，修改环境无效");
    }

    @NotNull
    public Environment getCurrentEnv() {
        NetConfigEntity a2 = SdkContext.f6675a.c().a();
        String kmUrl = a2.getKmUrl();
        Environment environment2 = this.environment;
        if (Intrinsics.areEqual((Object) kmUrl, (Object) environment2 != null ? environment2.getNluUrl() : null)) {
            Environment environment3 = this.environment;
            Intrinsics.checkNotNull(environment3);
            return environment3;
        }
        String e = GsonUtils.e(a2);
        ILog.a(TAG, "getCurrentEnv: " + e);
        String asrUrl = a2.getAsrUrl();
        String str = asrUrl == null ? "" : asrUrl;
        String kmUrl2 = a2.getKmUrl();
        String str2 = kmUrl2 == null ? "" : kmUrl2;
        String aiRecordUrl = a2.getAiRecordUrl();
        String str3 = aiRecordUrl == null ? "" : aiRecordUrl;
        String appId = a2.getAppId();
        String str4 = appId == null ? "" : appId;
        String userKey = a2.getUserKey();
        String str5 = userKey == null ? "" : userKey;
        String userSecret = a2.getUserSecret();
        Environment environment4 = new Environment(str, str2, str3, str4, str5, userSecret == null ? "" : userSecret);
        this.environment = environment4;
        Intrinsics.checkNotNull(environment4);
        return environment4;
    }

    public int getEnv() {
        ILog.a(TAG, "changeEnv: 环境参数由主应用统一控制，此处直接返回生成");
        return 3;
    }

    public /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    public /* bridge */ /* synthetic */ void register() {
        super.register();
    }
}

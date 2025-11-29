package com.xjsd.ai.assistant.chatgpt.util;

import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import com.upuphone.xr.interconnect.entity.AccountInfo;
import com.upuphone.xr.sapp.context.SdkContext;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper;
import com.xjsd.ai.assistant.phone.vui.todo.TodoRepository;
import com.xjsd.ai.assistant.skill.navigation.optimize.NavOptimizer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/xjsd/ai/assistant/chatgpt/util/AccountUtil;", "", "<init>", "()V", "Lcom/upuphone/xr/interconnect/entity/AccountInfo;", "accountInfo", "", "a", "(Lcom/upuphone/xr/interconnect/entity/AccountInfo;)V", "c", "()Lcom/upuphone/xr/interconnect/entity/AccountInfo;", "Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;", "b", "Lkotlin/Lazy;", "()Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;", "cacheAbility", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AccountUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final AccountUtil f8401a = new AccountUtil();
    public static final Lazy b = LazyKt.lazy(AccountUtil$cacheAbility$2.INSTANCE);

    public static final void a(AccountInfo accountInfo) {
        Intrinsics.checkNotNullParameter(accountInfo, "accountInfo");
        ILog.a("AccountUtil", "cacheUserInfo: " + accountInfo);
        String str = accountInfo.mzUid;
        AccountUtil accountUtil = f8401a;
        CacheAbility b2 = accountUtil.b();
        if (b2 != null) {
            b2.cache("xrUid", accountInfo.id);
        }
        CacheAbility b3 = accountUtil.b();
        if (b3 != null) {
            b3.cache("mzUid", str);
        }
        Intrinsics.checkNotNull(str);
        AssistantSettingsHelper.l(str);
        TodoRepository.f8656a.m(str);
        NavOptimizer.f8690a.g(str);
    }

    public final CacheAbility b() {
        return (CacheAbility) b.getValue();
    }

    public final AccountInfo c() {
        try {
            String a2 = SdkContext.f6675a.b().a();
            ILog.a("AccountUtil", "getUserInfo: SdkContext.getAppContext().getAccountInfo()->" + a2);
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            AccountInfo accountInfo = (AccountInfo) GsonUtils.a(a2, AccountInfo.class);
            a(accountInfo);
            return accountInfo;
        } catch (JsonSyntaxException e) {
            ILog.h("AccountUtil", "syncAccountInfo: error", e);
            return null;
        }
    }
}

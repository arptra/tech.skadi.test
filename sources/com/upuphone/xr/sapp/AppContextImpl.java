package com.upuphone.xr.sapp;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.lifecycle.LiveData;
import com.upuphone.star.core.log.ULog;
import com.upuphone.star.httplib.HttpInstance;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.config.NetConfigEntity;
import com.upuphone.xr.sapp.context.AppContext;
import com.upuphone.xr.sapp.utils.AudioMultiHelper;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.PhoneCallStatusHelper;
import com.xjsd.ai.assistant.phone.helper.VrStateHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00132\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0013H\u0016¢\u0006\u0004\b \u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/upuphone/xr/sapp/AppContextImpl;", "Lcom/upuphone/xr/sapp/context/AppContext;", "<init>", "()V", "", "e", "()Z", "f", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/upuphone/star/httplib/HttpInstance;", "j", "()Lcom/upuphone/star/httplib/HttpInstance;", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "g", "()Landroidx/datastore/core/DataStore;", "d", "", "i", "()Ljava/lang/String;", "Lcom/upuphone/xr/sapp/config/NetConfigEntity;", "a", "()Lcom/upuphone/xr/sapp/config/NetConfigEntity;", "callbackKey", "Lkotlin/Function1;", "Lcom/upuphone/xr/sapp/context/IAudioMulti;", "", "callback", "b", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "c", "(Ljava/lang/String;)V", "Landroidx/lifecycle/LiveData;", "Lcom/upuphone/xr/sapp/context/IPhoneCallStatus;", "h", "()Landroidx/lifecycle/LiveData;", "phoneCallStatus", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AppContextImpl implements AppContext {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6572a = new Companion((DefaultConstructorMarker) null);
    public static final Lazy b = LazyKt.lazy(AppContextImpl$Companion$appHttpInstance$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/AppContextImpl$Companion;", "", "<init>", "()V", "Lcom/upuphone/star/httplib/HttpInstance;", "appHttpInstance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/upuphone/star/httplib/HttpInstance;", "appHttpInstance", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HttpInstance a() {
            return (HttpInstance) AppContextImpl.b.getValue();
        }

        public Companion() {
        }
    }

    public NetConfigEntity a() {
        return NetConfig.f6666a.r();
    }

    public void b(String str, Function1 function1) {
        Intrinsics.checkNotNullParameter(str, "callbackKey");
        Intrinsics.checkNotNullParameter(function1, "callback");
        AudioMultiHelper.f7846a.a(str, function1);
    }

    public void c(String str) {
        Intrinsics.checkNotNullParameter(str, "callbackKey");
        AudioMultiHelper.f7846a.d(str);
    }

    public boolean d() {
        return VrStateHelper.f8567a.a();
    }

    public boolean e() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        return bool.booleanValue();
    }

    public boolean f() {
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        return bool.booleanValue();
    }

    public DataStore g() {
        return DataStoreUtils.e.a().l();
    }

    public Context getContext() {
        return MainApplication.k.d();
    }

    public LiveData h() {
        return PhoneCallStatusHelper.f7909a.a();
    }

    public String i() {
        return NetConfig.f6666a.q();
    }

    public HttpInstance j() {
        ULog.f6446a.o("AppContextImpl", "getHttpUtil start");
        return f6572a.a();
    }
}

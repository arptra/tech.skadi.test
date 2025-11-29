package com.upuphone.xr.sapp.context;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.lifecycle.LiveData;
import com.upuphone.star.httplib.HttpInstance;
import com.upuphone.xr.sapp.config.NetConfigEntity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u000e2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u000eH&¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/upuphone/xr/sapp/context/AppContext;", "", "", "e", "()Z", "f", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "g", "()Landroidx/datastore/core/DataStore;", "d", "", "i", "()Ljava/lang/String;", "Lcom/upuphone/xr/sapp/config/NetConfigEntity;", "a", "()Lcom/upuphone/xr/sapp/config/NetConfigEntity;", "Lcom/upuphone/star/httplib/HttpInstance;", "j", "()Lcom/upuphone/star/httplib/HttpInstance;", "callbackKey", "Lkotlin/Function1;", "Lcom/upuphone/xr/sapp/context/IAudioMulti;", "", "callback", "b", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "c", "(Ljava/lang/String;)V", "Landroidx/lifecycle/LiveData;", "Lcom/upuphone/xr/sapp/context/IPhoneCallStatus;", "h", "()Landroidx/lifecycle/LiveData;", "phoneCallStatus", "lib_context_release"}, k = 1, mv = {1, 9, 0})
public interface AppContext {
    NetConfigEntity a();

    void b(String str, Function1 function1);

    void c(String str);

    boolean d();

    boolean e();

    boolean f();

    DataStore g();

    Context getContext();

    LiveData h();

    String i();

    HttpInstance j();
}

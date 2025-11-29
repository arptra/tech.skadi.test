package com.upuphone.xr.sapp.context;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/context/AccountContext;", "", "", "a", "()Ljava/lang/String;", "Landroidx/lifecycle/LiveData;", "Lcom/upuphone/xr/sapp/context/IAccountInfo;", "c", "()Landroidx/lifecycle/LiveData;", "accountInfoData", "b", "()Lcom/upuphone/xr/sapp/context/IAccountInfo;", "accountInfoOrCache", "lib_context_release"}, k = 1, mv = {1, 9, 0})
public interface AccountContext {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    String a();

    IAccountInfo b();

    LiveData c();
}

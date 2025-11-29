package com.upuphone.xr.sapp.common;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.upuphone.xr.sapp.context.AccountContext;
import com.upuphone.xr.sapp.context.IAccountInfo;
import com.upuphone.xr.sapp.entity.AccountInfo;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/common/AccountContextImpl;", "Lcom/upuphone/xr/sapp/context/AccountContext;", "<init>", "()V", "", "a", "()Ljava/lang/String;", "Lcom/upuphone/xr/sapp/entity/AccountInfo;", "Lcom/upuphone/xr/sapp/common/AccountInfoImpl;", "f", "(Lcom/upuphone/xr/sapp/entity/AccountInfo;)Lcom/upuphone/xr/sapp/common/AccountInfoImpl;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/upuphone/xr/sapp/context/IAccountInfo;", "b", "Landroidx/lifecycle/MutableLiveData;", "_accountInfoData", "Landroidx/lifecycle/LiveData;", "c", "()Landroidx/lifecycle/LiveData;", "accountInfoData", "()Lcom/upuphone/xr/sapp/context/IAccountInfo;", "accountInfoOrCache", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AccountContextImpl implements AccountContext {

    /* renamed from: a  reason: collision with root package name */
    public static final AccountContextImpl f6652a = new AccountContextImpl();
    public static final MutableLiveData b = new MutableLiveData();

    static {
        MzAccountManager.c.b().d().observeForever(new AccountContextImpl$sam$androidx_lifecycle_Observer$0(AnonymousClass1.INSTANCE));
    }

    public String a() {
        return MzAccountManager.c.a() != null ? (String) DataStoreUtils.i(DataStoreUtils.e.a(), "mz_account", "", (Context) null, 4, (Object) null) : "";
    }

    public IAccountInfo b() {
        IAccountInfo iAccountInfo = (IAccountInfo) c().getValue();
        if (iAccountInfo != null) {
            return iAccountInfo;
        }
        AccountInfo a2 = MzAccountManager.c.a();
        return a2 != null ? f(a2) : null;
    }

    public LiveData c() {
        return b;
    }

    public final AccountInfoImpl f(AccountInfo accountInfo) {
        String id = accountInfo.getId();
        String mzUid = accountInfo.getMzUid();
        if (id == null || id.length() == 0 || mzUid == null || mzUid.length() == 0) {
            return null;
        }
        return new AccountInfoImpl(id, mzUid);
    }
}

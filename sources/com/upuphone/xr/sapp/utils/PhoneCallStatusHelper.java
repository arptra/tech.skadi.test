package com.upuphone.xr.sapp.utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.context.IPhoneCallStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/utils/PhoneCallStatusHelper;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/context/IPhoneCallStatus;", "callStatus", "", "b", "(Lcom/upuphone/xr/sapp/context/IPhoneCallStatus;)V", "Landroidx/lifecycle/LiveData;", "a", "()Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "_callStatus", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PhoneCallStatusHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final PhoneCallStatusHelper f7909a = new PhoneCallStatusHelper();
    public static final MutableLiveData b = new MutableLiveData();

    public final LiveData a() {
        return b;
    }

    public final void b(IPhoneCallStatus iPhoneCallStatus) {
        Intrinsics.checkNotNullParameter(iPhoneCallStatus, "callStatus");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("PhoneCallStatusHelper", "updateCallStatus callStatus=" + iPhoneCallStatus);
        b.postValue(iPhoneCallStatus);
    }
}

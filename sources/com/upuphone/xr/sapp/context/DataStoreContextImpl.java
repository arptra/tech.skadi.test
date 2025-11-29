package com.upuphone.xr.sapp.context;

import android.content.Context;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0010\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0012\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/context/DataStoreContextImpl;", "Lcom/upuphone/xr/sapp/context/DataStoreContext;", "<init>", "()V", "T", "", "key", "defaultValue", "d", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "", "associateUser", "b", "(Ljava/lang/String;Ljava/lang/Object;Z)Ljava/lang/Object;", "value", "", "c", "(Ljava/lang/String;Ljava/lang/Object;)V", "a", "(Ljava/lang/String;Ljava/lang/Object;Z)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DataStoreContextImpl implements DataStoreContext {
    public void a(String str, Object obj, boolean z) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        DataStoreUtils.e.a().p(str, obj, z);
    }

    public Object b(String str, Object obj, boolean z) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        return DataStoreUtils.j(DataStoreUtils.e.a(), str, obj, z, (Context) null, 8, (Object) null);
    }

    public void c(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        DataStoreUtils.e.a().o(str, obj);
    }

    public Object d(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        return DataStoreUtils.i(DataStoreUtils.e.a(), str, obj, (Context) null, 4, (Object) null);
    }
}

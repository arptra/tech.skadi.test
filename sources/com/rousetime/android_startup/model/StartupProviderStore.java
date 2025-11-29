package com.rousetime.android_startup.model;

import com.rousetime.android_startup.provider.StartupProviderConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B#\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R!\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0013\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/rousetime/android_startup/model/StartupProviderStore;", "", "", "Lcom/rousetime/android_startup/AndroidStartup;", "result", "Lcom/rousetime/android_startup/provider/StartupProviderConfig;", "config", "<init>", "(Ljava/util/List;Lcom/rousetime/android_startup/provider/StartupProviderConfig;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/rousetime/android_startup/provider/StartupProviderConfig;", "()Lcom/rousetime/android_startup/provider/StartupProviderConfig;", "android-startup_release"}, k = 1, mv = {1, 4, 0})
public final class StartupProviderStore {

    /* renamed from: a  reason: collision with root package name */
    public final List f9831a;
    public final StartupProviderConfig b;

    public StartupProviderStore(List list, StartupProviderConfig startupProviderConfig) {
        this.f9831a = list;
        this.b = startupProviderConfig;
    }

    public final StartupProviderConfig a() {
        return this.b;
    }

    public final List b() {
        return this.f9831a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StartupProviderStore)) {
            return false;
        }
        StartupProviderStore startupProviderStore = (StartupProviderStore) obj;
        return Intrinsics.areEqual((Object) this.f9831a, (Object) startupProviderStore.f9831a) && Intrinsics.areEqual((Object) this.b, (Object) startupProviderStore.b);
    }

    public int hashCode() {
        List list = this.f9831a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        StartupProviderConfig startupProviderConfig = this.b;
        if (startupProviderConfig != null) {
            i = startupProviderConfig.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "StartupProviderStore(result=" + this.f9831a + ", config=" + this.b + ")";
    }
}

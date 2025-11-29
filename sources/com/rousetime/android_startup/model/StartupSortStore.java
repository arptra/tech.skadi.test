package com.rousetime.android_startup.model;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001BK\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0005\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R!\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R'\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00058\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR)\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u0017\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/rousetime/android_startup/model/StartupSortStore;", "", "", "Lcom/rousetime/android_startup/Startup;", "result", "", "", "startupMap", "startupChildrenMap", "<init>", "(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/util/List;", "()Ljava/util/List;", "b", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "android-startup_release"}, k = 1, mv = {1, 4, 0})
public final class StartupSortStore {

    /* renamed from: a  reason: collision with root package name */
    public final List f9832a;
    public final Map b;
    public final Map c;

    public StartupSortStore(List list, Map map, Map map2) {
        this.f9832a = list;
        this.b = map;
        this.c = map2;
    }

    public final List a() {
        return this.f9832a;
    }

    public final Map b() {
        return this.c;
    }

    public final Map c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StartupSortStore)) {
            return false;
        }
        StartupSortStore startupSortStore = (StartupSortStore) obj;
        return Intrinsics.areEqual((Object) this.f9832a, (Object) startupSortStore.f9832a) && Intrinsics.areEqual((Object) this.b, (Object) startupSortStore.b) && Intrinsics.areEqual((Object) this.c, (Object) startupSortStore.c);
    }

    public int hashCode() {
        List list = this.f9832a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Map map = this.b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Map map2 = this.c;
        if (map2 != null) {
            i = map2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "StartupSortStore(result=" + this.f9832a + ", startupMap=" + this.b + ", startupChildrenMap=" + this.c + ")";
    }
}

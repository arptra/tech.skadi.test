package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import com.upuphone.runasone.relay.api.IntentKey;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0000¢\u0006\u0004\b\r\u0010\fJ$\u0010\u0010\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J&\u0010\u0012\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u0018\u001a\u00020\n\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0017\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u00020\n2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\u0019J)\u0010\u001e\u001a\u00020\n2\u001a\u0010\u001d\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001c0\u001b\"\u0006\u0012\u0002\b\u00030\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010 \u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b \u0010\u0013J\r\u0010!\u001a\u00020\n¢\u0006\u0004\b!\u0010\fJ\u001a\u0010#\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*R*\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010\u0016R\u0014\u0010/\u001a\u00020-8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010.¨\u00060"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "Landroidx/datastore/preferences/core/Preferences;", "", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "preferencesMap", "", "startFrozen", "<init>", "(Ljava/util/Map;Z)V", "", "f", "()V", "h", "T", "key", "b", "(Landroidx/datastore/preferences/core/Preferences$Key;)Z", "c", "(Landroidx/datastore/preferences/core/Preferences$Key;)Ljava/lang/Object;", "", "a", "()Ljava/util/Map;", "value", "k", "(Landroidx/datastore/preferences/core/Preferences$Key;Ljava/lang/Object;)V", "l", "", "Landroidx/datastore/preferences/core/Preferences$Pair;", "pairs", "i", "([Landroidx/datastore/preferences/core/Preferences$Pair;)V", "j", "g", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/Map;", "getPreferencesMap$datastore_preferences_core", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "frozen", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
public final class MutablePreferences extends Preferences {

    /* renamed from: a  reason: collision with root package name */
    public final Map f1037a;
    public final AtomicBoolean b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutablePreferences(Map map, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LinkedHashMap() : map, (i & 2) != 0 ? true : z);
    }

    public Map a() {
        Map unmodifiableMap = Collections.unmodifiableMap(this.f1037a);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(preferencesMap)");
        return unmodifiableMap;
    }

    public boolean b(Preferences.Key key) {
        Intrinsics.checkNotNullParameter(key, IntentKey.ACTIVITY.ACTION_KEY);
        return this.f1037a.containsKey(key);
    }

    public Object c(Preferences.Key key) {
        Intrinsics.checkNotNullParameter(key, IntentKey.ACTIVITY.ACTION_KEY);
        return this.f1037a.get(key);
    }

    public boolean equals(Object obj) {
        if (obj instanceof MutablePreferences) {
            return Intrinsics.areEqual((Object) this.f1037a, (Object) ((MutablePreferences) obj).f1037a);
        }
        return false;
    }

    public final void f() {
        if (!(!this.b.get())) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.".toString());
        }
    }

    public final void g() {
        f();
        this.f1037a.clear();
    }

    public final void h() {
        this.b.set(true);
    }

    public int hashCode() {
        return this.f1037a.hashCode();
    }

    public final void i(Preferences.Pair... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        f();
        for (Preferences.Pair pair : pairArr) {
            l(pair.a(), pair.b());
        }
    }

    public final Object j(Preferences.Key key) {
        Intrinsics.checkNotNullParameter(key, IntentKey.ACTIVITY.ACTION_KEY);
        f();
        return this.f1037a.remove(key);
    }

    public final void k(Preferences.Key key, Object obj) {
        Intrinsics.checkNotNullParameter(key, IntentKey.ACTIVITY.ACTION_KEY);
        l(key, obj);
    }

    public final void l(Preferences.Key key, Object obj) {
        Intrinsics.checkNotNullParameter(key, IntentKey.ACTIVITY.ACTION_KEY);
        f();
        if (obj == null) {
            j(key);
        } else if (obj instanceof Set) {
            Map map = this.f1037a;
            Set unmodifiableSet = Collections.unmodifiableSet(CollectionsKt.toSet((Iterable) obj));
            Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(value.toSet())");
            map.put(key, unmodifiableSet);
        } else {
            this.f1037a.put(key, obj);
        }
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.f1037a.entrySet(), ",\n", "{\n", "\n}", 0, (CharSequence) null, MutablePreferences$toString$1.INSTANCE, 24, (Object) null);
    }

    public MutablePreferences(Map map, boolean z) {
        Intrinsics.checkNotNullParameter(map, "preferencesMap");
        this.f1037a = map;
        this.b = new AtomicBoolean(z);
    }
}

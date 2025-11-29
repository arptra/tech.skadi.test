package androidx.datastore.preferences.core;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H¦\u0002¢\u0006\u0004\b\b\u0010\tJ&\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H¦\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00010\fH&¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Landroidx/datastore/preferences/core/Preferences;", "", "<init>", "()V", "T", "Landroidx/datastore/preferences/core/Preferences$Key;", "key", "", "b", "(Landroidx/datastore/preferences/core/Preferences$Key;)Z", "c", "(Landroidx/datastore/preferences/core/Preferences$Key;)Ljava/lang/Object;", "", "a", "()Ljava/util/Map;", "Landroidx/datastore/preferences/core/MutablePreferences;", "d", "()Landroidx/datastore/preferences/core/MutablePreferences;", "e", "()Landroidx/datastore/preferences/core/Preferences;", "Key", "Pair", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
public abstract class Preferences {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/datastore/preferences/core/Preferences$Key;", "T", "", "", "name", "<init>", "(Ljava/lang/String;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "a", "Ljava/lang/String;", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
    public static final class Key<T> {

        /* renamed from: a  reason: collision with root package name */
        public final String f1040a;

        public Key(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.f1040a = str;
        }

        public final String a() {
            return this.f1040a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                return Intrinsics.areEqual((Object) this.f1040a, (Object) ((Key) obj).f1040a);
            }
            return false;
        }

        public int hashCode() {
            return this.f1040a.hashCode();
        }

        public String toString() {
            return this.f1040a;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0000X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u001a\u0010\u000b\u001a\u00028\u00008\u0000X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n¨\u0006\f"}, d2 = {"Landroidx/datastore/preferences/core/Preferences$Pair;", "T", "", "Landroidx/datastore/preferences/core/Preferences$Key;", "a", "Landroidx/datastore/preferences/core/Preferences$Key;", "()Landroidx/datastore/preferences/core/Preferences$Key;", "key", "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "value", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
    public static final class Pair<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Key f1041a;
        public final Object b;

        public final Key a() {
            return this.f1041a;
        }

        public final Object b() {
            return this.b;
        }
    }

    public abstract Map a();

    public abstract boolean b(Key key);

    public abstract Object c(Key key);

    public final MutablePreferences d() {
        return new MutablePreferences(MapsKt.toMutableMap(a()), false);
    }

    public final Preferences e() {
        return new MutablePreferences(MapsKt.toMutableMap(a()), true);
    }
}

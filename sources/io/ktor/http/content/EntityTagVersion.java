package io.ktor.http.content;

import io.ktor.http.HeaderValueWithParametersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012¨\u0006\u001c"}, d2 = {"Lio/ktor/http/content/EntityTagVersion;", "Lio/ktor/http/content/Version;", "", "etag", "", "weak", "<init>", "(Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getEtag", "b", "Z", "getWeak", "()Z", "c", "normalized", "d", "Companion", "ktor-http"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nVersions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Versions.kt\nio/ktor/http/content/EntityTagVersion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,261:1\n1#2:262\n1747#3,3:263\n*S KotlinDebug\n*F\n+ 1 Versions.kt\nio/ktor/http/content/EntityTagVersion\n*L\n189#1:263,3\n*E\n"})
public final class EntityTagVersion implements Version {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);
    public static final EntityTagVersion e = new EntityTagVersion("*", false);

    /* renamed from: a  reason: collision with root package name */
    public final String f8991a;
    public final boolean b;
    public final String c;

    @SourceDebugExtension({"SMAP\nVersions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Versions.kt\nio/ktor/http/content/EntityTagVersion$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,261:1\n1549#2:262\n1620#2,2:263\n1622#2:266\n1#3:265\n*S KotlinDebug\n*F\n+ 1 Versions.kt\nio/ktor/http/content/EntityTagVersion$Companion\n*L\n227#1:262\n227#1:263,2\n227#1:266\n*E\n"})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/http/content/EntityTagVersion$Companion;", "", "<init>", "()V", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public EntityTagVersion(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "etag");
        this.f8991a = str;
        this.b = z;
        int i = 0;
        this.c = (!Intrinsics.areEqual((Object) str, (Object) "*") && !StringsKt.startsWith$default(str, "\"", false, 2, (Object) null)) ? HeaderValueWithParametersKt.e(str) : str;
        int length = str.length();
        while (i < length) {
            char charAt = this.f8991a.charAt(i);
            if ((Intrinsics.compare((int) charAt, 32) > 0 && charAt != '\"') || i == 0 || i == StringsKt.getLastIndex(this.f8991a)) {
                i++;
            } else {
                throw new IllegalArgumentException(("Character '" + charAt + "' is not allowed in entity-tag.").toString());
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EntityTagVersion)) {
            return false;
        }
        EntityTagVersion entityTagVersion = (EntityTagVersion) obj;
        return Intrinsics.areEqual((Object) this.f8991a, (Object) entityTagVersion.f8991a) && this.b == entityTagVersion.b;
    }

    public int hashCode() {
        int hashCode = this.f8991a.hashCode() * 31;
        boolean z = this.b;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "EntityTagVersion(etag=" + this.f8991a + ", weak=" + this.b + ')';
    }
}

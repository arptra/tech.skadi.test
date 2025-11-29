package kotlinx.serialization.internal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0003H\u0016¢\u0006\u0004\b$\u0010%J\u001b\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070&H\u0002¢\u0006\u0004\b'\u0010(R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010%R\u001a\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001c\u0010.\u001a\u0004\b/\u0010#R\u0016\u00100\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010.R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u0003018\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00102R\"\u00106\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u000104018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u00105R\u001e\u00108\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010:R\"\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010<R%\u0010C\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030>018BX\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR!\u0010F\u001a\b\u0012\u0004\u0012\u00020\u0001018@X\u0002¢\u0006\f\n\u0004\b\u000f\u0010@\u001a\u0004\bD\u0010ER\u001b\u0010I\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\bG\u0010@\u001a\u0004\bH\u0010#R\u0014\u0010M\u001a\u00020J8VX\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168VX\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00030Q8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010R¨\u0006T"}, d2 = {"Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "", "serialName", "Lkotlinx/serialization/internal/GeneratedSerializer;", "generatedSerializer", "", "elementsCount", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "name", "", "isOptional", "", "k", "(Ljava/lang/String;Z)V", "index", "d", "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "i", "(I)Z", "", "", "g", "(I)Ljava/util/List;", "f", "(I)Ljava/lang/String;", "c", "(Ljava/lang/String;)I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "", "m", "()Ljava/util/Map;", "a", "Ljava/lang/String;", "h", "b", "Lkotlinx/serialization/internal/GeneratedSerializer;", "I", "e", "added", "", "[Ljava/lang/String;", "names", "", "[Ljava/util/List;", "propertiesAnnotations", "Ljava/util/List;", "classAnnotations", "", "[Z", "elementsOptionality", "Ljava/util/Map;", "indices", "Lkotlinx/serialization/KSerializer;", "j", "Lkotlin/Lazy;", "n", "()[Lkotlinx/serialization/KSerializer;", "childSerializers", "o", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParameterDescriptors", "l", "p", "_hashCode", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "getAnnotations", "()Ljava/util/List;", "annotations", "", "()Ljava/util/Set;", "serialNames", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPluginGeneratedSerialDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginGeneratedSerialDescriptor.kt\nkotlinx/serialization/internal/PluginGeneratedSerialDescriptor\n+ 2 Platform.kt\nkotlinx/serialization/internal/PlatformKt\n+ 3 PluginGeneratedSerialDescriptor.kt\nkotlinx/serialization/internal/PluginGeneratedSerialDescriptorKt\n*L\n1#1,134:1\n13#2:135\n18#2:136\n13#2:137\n13#2:138\n111#3,10:139\n*S KotlinDebug\n*F\n+ 1 PluginGeneratedSerialDescriptor.kt\nkotlinx/serialization/internal/PluginGeneratedSerialDescriptor\n*L\n76#1:135\n79#1:136\n81#1:137\n82#1:138\n93#1:139,10\n*E\n"})
@PublishedApi
public class PluginGeneratedSerialDescriptor implements SerialDescriptor, CachedNames {

    /* renamed from: a  reason: collision with root package name */
    public final String f4053a;
    public final GeneratedSerializer b;
    public final int c;
    public int d;
    public final String[] e;
    public final List[] f;
    public List g;
    public final boolean[] h;
    public Map i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;

    public PluginGeneratedSerialDescriptor(String str, GeneratedSerializer generatedSerializer, int i2) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        this.f4053a = str;
        this.b = generatedSerializer;
        this.c = i2;
        this.d = -1;
        String[] strArr = new String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            strArr[i3] = "[UNINITIALIZED]";
        }
        this.e = strArr;
        int i4 = this.c;
        this.f = new List[i4];
        this.h = new boolean[i4];
        this.i = MapsKt.emptyMap();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.j = LazyKt.lazy(lazyThreadSafetyMode, new PluginGeneratedSerialDescriptor$childSerializers$2(this));
        this.k = LazyKt.lazy(lazyThreadSafetyMode, new PluginGeneratedSerialDescriptor$typeParameterDescriptors$2(this));
        this.l = LazyKt.lazy(lazyThreadSafetyMode, new PluginGeneratedSerialDescriptor$_hashCode$2(this));
    }

    public static /* synthetic */ void l(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, String str, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            pluginGeneratedSerialDescriptor.k(str, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
    }

    private final int p() {
        return ((Number) this.l.getValue()).intValue();
    }

    public Set a() {
        return this.i.keySet();
    }

    public boolean b() {
        return SerialDescriptor.DefaultImpls.c(this);
    }

    public int c(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        Integer num = (Integer) this.i.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public SerialDescriptor d(int i2) {
        return n()[i2].getDescriptor();
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PluginGeneratedSerialDescriptor) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.areEqual((Object) h(), (Object) serialDescriptor.h()) && Arrays.equals(o(), ((PluginGeneratedSerialDescriptor) obj).o()) && e() == serialDescriptor.e()) {
                int e2 = e();
                int i2 = 0;
                while (i2 < e2) {
                    if (Intrinsics.areEqual((Object) d(i2).h(), (Object) serialDescriptor.d(i2).h()) && Intrinsics.areEqual((Object) d(i2).getKind(), (Object) serialDescriptor.d(i2).getKind())) {
                        i2++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public String f(int i2) {
        return this.e[i2];
    }

    public List g(int i2) {
        List list = this.f[i2];
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public List getAnnotations() {
        List list = this.g;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public SerialKind getKind() {
        return StructureKind.CLASS.f4008a;
    }

    public String h() {
        return this.f4053a;
    }

    public int hashCode() {
        return p();
    }

    public boolean i(int i2) {
        return this.h[i2];
    }

    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.b(this);
    }

    public final void k(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        String[] strArr = this.e;
        int i2 = this.d + 1;
        this.d = i2;
        strArr[i2] = str;
        this.h[i2] = z;
        this.f[i2] = null;
        if (i2 == this.c - 1) {
            this.i = m();
        }
    }

    public final Map m() {
        HashMap hashMap = new HashMap();
        int length = this.e.length;
        for (int i2 = 0; i2 < length; i2++) {
            hashMap.put(this.e[i2], Integer.valueOf(i2));
        }
        return hashMap;
    }

    public final KSerializer[] n() {
        return (KSerializer[]) this.j.getValue();
    }

    public final SerialDescriptor[] o() {
        return (SerialDescriptor[]) this.k.getValue();
    }

    public String toString() {
        IntRange until = RangesKt.until(0, this.c);
        return CollectionsKt.joinToString$default(until, ", ", h() + '(', ")", 0, (CharSequence) null, new PluginGeneratedSerialDescriptor$toString$1(this), 24, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PluginGeneratedSerialDescriptor(String str, GeneratedSerializer generatedSerializer, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : generatedSerializer, i2);
    }
}

package kotlinx.serialization.internal;

import com.google.common.net.HttpHeaders;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lkotlinx/serialization/internal/KTypeWrapper;", "Lkotlin/reflect/KType;", "origin", "<init>", "(Lkotlin/reflect/KType;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "Lkotlin/reflect/KType;", "", "", "getAnnotations", "()Ljava/util/List;", "annotations", "Lkotlin/reflect/KTypeProjection;", "getArguments", "arguments", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier", "isMarkedNullable", "()Z", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
final class KTypeWrapper implements KType {

    /* renamed from: a  reason: collision with root package name */
    public final KType f4038a;

    public KTypeWrapper(KType kType) {
        Intrinsics.checkNotNullParameter(kType, HttpHeaders.ReferrerPolicyValues.ORIGIN);
        this.f4038a = kType;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        KType kType = this.f4038a;
        KClassifier kClassifier = null;
        KTypeWrapper kTypeWrapper = obj instanceof KTypeWrapper ? (KTypeWrapper) obj : null;
        if (!Intrinsics.areEqual((Object) kType, (Object) kTypeWrapper != null ? kTypeWrapper.f4038a : null)) {
            return false;
        }
        KClassifier classifier = getClassifier();
        if (classifier instanceof KClass) {
            KType kType2 = obj instanceof KType ? (KType) obj : null;
            if (kType2 != null) {
                kClassifier = kType2.getClassifier();
            }
            if (kClassifier != null && (kClassifier instanceof KClass)) {
                return Intrinsics.areEqual((Object) JvmClassMappingKt.getJavaClass((KClass) classifier), (Object) JvmClassMappingKt.getJavaClass((KClass) kClassifier));
            }
        }
        return false;
    }

    public List getAnnotations() {
        return this.f4038a.getAnnotations();
    }

    public List getArguments() {
        return this.f4038a.getArguments();
    }

    public KClassifier getClassifier() {
        return this.f4038a.getClassifier();
    }

    public int hashCode() {
        return this.f4038a.hashCode();
    }

    public boolean isMarkedNullable() {
        return this.f4038a.isMarkedNullable();
    }

    public String toString() {
        return "KTypeWrapper: " + this.f4038a;
    }
}

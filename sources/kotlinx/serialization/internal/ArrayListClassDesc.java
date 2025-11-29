package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lkotlinx/serialization/internal/ArrayListClassDesc;", "Lkotlinx/serialization/internal/ListLikeDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementDesc", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "h", "()Ljava/lang/String;", "serialName", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
public final class ArrayListClassDesc extends ListLikeDescriptor {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArrayListClassDesc(SerialDescriptor serialDescriptor) {
        super(serialDescriptor, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(serialDescriptor, "elementDesc");
    }

    public String h() {
        return "kotlin.collections.ArrayList";
    }
}

package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLoadingKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import org.jetbrains.annotations.NotNull;

public final class ClassDeclaredMemberIndex$methodFilter$1 extends Lambda implements Function1<JavaMethod, Boolean> {
    final /* synthetic */ ClassDeclaredMemberIndex this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClassDeclaredMemberIndex$methodFilter$1(ClassDeclaredMemberIndex classDeclaredMemberIndex) {
        super(1);
        this.this$0 = classDeclaredMemberIndex;
    }

    @NotNull
    public final Boolean invoke(@NotNull JavaMethod javaMethod) {
        Intrinsics.checkNotNullParameter(javaMethod, ProtocolVersions.PROTOCOL_KEY_MAX_MTU_SIZE);
        return Boolean.valueOf(((Boolean) this.this$0.memberFilter.invoke(javaMethod)).booleanValue() && !JavaLoadingKt.isObjectMethodInInterface(javaMethod));
    }
}

package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class KDeclarationContainerImpl$Data$moduleData$2 extends Lambda implements Function0<RuntimeModuleData> {
    final /* synthetic */ KDeclarationContainerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KDeclarationContainerImpl$Data$moduleData$2(KDeclarationContainerImpl kDeclarationContainerImpl) {
        super(0);
        this.this$0 = kDeclarationContainerImpl;
    }

    public final RuntimeModuleData invoke() {
        return ModuleByClassLoaderKt.getOrCreateModule(this.this$0.getJClass());
    }
}

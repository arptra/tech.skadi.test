package com.upuphone.xr.interconnect;

import android.util.Log;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.inner.OperatorManagerCreator;
import com.upuphone.xr.interconnect.util.AlienCallExtKt;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nInnerSuperAppServiceManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InnerSuperAppServiceManager.kt\ncom/upuphone/xr/interconnect/InnerSuperAppServiceManager$inject$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,46:1\n1855#2,2:47\n*S KotlinDebug\n*F\n+ 1 InnerSuperAppServiceManager.kt\ncom/upuphone/xr/interconnect/InnerSuperAppServiceManager$inject$1\n*L\n22#1:47,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class InnerSuperAppServiceManager$inject$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ OperatorManagerCreator $creator;
    final /* synthetic */ InnerSuperAppServiceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InnerSuperAppServiceManager$inject$1(InnerSuperAppServiceManager innerSuperAppServiceManager, OperatorManagerCreator operatorManagerCreator) {
        super(0);
        this.this$0 = innerSuperAppServiceManager;
        this.$creator = operatorManagerCreator;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$1(OperatorManagerCreator operatorManagerCreator, InnerSuperAppServiceManager innerSuperAppServiceManager, String str, Set set) {
        Intrinsics.checkNotNullParameter(operatorManagerCreator, "$creator");
        Intrinsics.checkNotNullParameter(innerSuperAppServiceManager, "this$0");
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(set, "callbacks");
        OperatorManager create = operatorManagerCreator.create(str);
        String access$getTag = innerSuperAppServiceManager.getTag();
        Log.d(access$getTag, "Created instance " + create + '.');
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AlienCallExtKt.threadSafeAlienCall((OperatorManagerCreateCallback) it.next(), innerSuperAppServiceManager.getTag(), new InnerSuperAppServiceManager$inject$1$1$1$1(create));
        }
        ConcurrentHashMap<String, OperatorManager> instances = innerSuperAppServiceManager.getInstances();
        Intrinsics.checkNotNullExpressionValue(create, "instance");
        instances.put(str, create);
    }

    public final void invoke() {
        Log.d(this.this$0.getTag(), "Creator is injected.");
        this.this$0.operatorManagerCreator = this.$creator;
        this.this$0.requests.forEach(new a(this.$creator, this.this$0));
    }
}

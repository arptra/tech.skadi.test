package com.upuphone.xr.interconnect;

import android.util.Log;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.inner.OperatorManagerCreator;
import com.upuphone.xr.interconnect.util.AlienCallExtKt;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class InnerSuperAppServiceManager$request$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $appId;
    final /* synthetic */ OperatorManagerCreateCallback $callback;
    final /* synthetic */ InnerSuperAppServiceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InnerSuperAppServiceManager$request$1(InnerSuperAppServiceManager innerSuperAppServiceManager, String str, OperatorManagerCreateCallback operatorManagerCreateCallback) {
        super(0);
        this.this$0 = innerSuperAppServiceManager;
        this.$appId = str;
        this.$callback = operatorManagerCreateCallback;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        Log.d(access$getTag, "Adding callback for " + this.$appId + ": " + this.$callback + '.');
        OperatorManager operatorManager = this.this$0.getInstances().get(this.$appId);
        if (operatorManager != null) {
            InnerSuperAppServiceManager innerSuperAppServiceManager = this.this$0;
            OperatorManagerCreateCallback operatorManagerCreateCallback = this.$callback;
            String access$getTag2 = innerSuperAppServiceManager.getTag();
            Log.d(access$getTag2, "Got cached instance " + operatorManager + '.');
            AlienCallExtKt.threadSafeAlienCall(operatorManagerCreateCallback, innerSuperAppServiceManager.getTag(), new InnerSuperAppServiceManager$request$1$1$1(operatorManager));
            return;
        }
        OperatorManagerCreator operatorManagerCreator = this.this$0.getOperatorManagerCreator();
        if (operatorManagerCreator != null) {
            String str = this.$appId;
            InnerSuperAppServiceManager innerSuperAppServiceManager2 = this.this$0;
            OperatorManagerCreateCallback operatorManagerCreateCallback2 = this.$callback;
            OperatorManager create = operatorManagerCreator.create(str);
            String access$getTag3 = innerSuperAppServiceManager2.getTag();
            Log.d(access$getTag3, "Created instance " + create + '.');
            AlienCallExtKt.threadSafeAlienCall(operatorManagerCreateCallback2, innerSuperAppServiceManager2.getTag(), new InnerSuperAppServiceManager$request$1$2$1(create));
            ConcurrentHashMap<String, OperatorManager> instances = innerSuperAppServiceManager2.getInstances();
            Intrinsics.checkNotNullExpressionValue(create, "instance");
            instances.put(str, create);
            return;
        }
        this.this$0.requests.set(this.$appId, this.$callback);
    }
}

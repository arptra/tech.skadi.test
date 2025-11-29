package com.honey.account.z9;

import com.xjsd.ai.assistant.cloud.CloudAbilityImpl;
import com.xjsd.ai.assistant.cloud.InitCloudParams;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloudAbilityImpl f7726a;
    public final /* synthetic */ InitCloudParams b;

    public /* synthetic */ b(CloudAbilityImpl cloudAbilityImpl, InitCloudParams initCloudParams) {
        this.f7726a = cloudAbilityImpl;
        this.b = initCloudParams;
    }

    public final Object call() {
        return CloudAbilityImpl.launch$lambda$0(this.f7726a, this.b);
    }
}

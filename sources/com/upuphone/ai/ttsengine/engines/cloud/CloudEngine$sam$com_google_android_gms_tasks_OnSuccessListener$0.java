package com.upuphone.ai.ttsengine.engines.cloud;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public final class CloudEngine$sam$com_google_android_gms_tasks_OnSuccessListener$0 implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f5551a;

    public CloudEngine$sam$com_google_android_gms_tasks_OnSuccessListener$0(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "function");
        this.f5551a = function1;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.f5551a.invoke(obj);
    }
}

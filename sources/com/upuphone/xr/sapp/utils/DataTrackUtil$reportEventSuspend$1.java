package com.upuphone.xr.sapp.utils;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.DataTrackUtil", f = "DataTrackUtil.kt", i = {0, 0, 0, 0, 0, 0}, l = {452}, m = "reportEventSuspend", n = {"eventName", "attributes", "iotDeviceId", "iotDeviceModel", "iotDeviceRom", "isSync"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"})
public final class DataTrackUtil$reportEventSuspend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataTrackUtil this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataTrackUtil$reportEventSuspend$1(DataTrackUtil dataTrackUtil, Continuation<? super DataTrackUtil$reportEventSuspend$1> continuation) {
        super(continuation);
        this.this$0 = dataTrackUtil;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.p((String) null, (Map) null, (String) null, (String) null, (String) null, false, this);
    }
}

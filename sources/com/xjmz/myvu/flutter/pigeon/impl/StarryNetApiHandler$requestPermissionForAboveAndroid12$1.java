package com.xjmz.myvu.flutter.pigeon.impl;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler", f = "StarryNetApiHandler.kt", i = {0}, l = {568}, m = "requestPermissionForAboveAndroid12", n = {"fragment"}, s = {"L$0"})
public final class StarryNetApiHandler$requestPermissionForAboveAndroid12$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StarryNetApiHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarryNetApiHandler$requestPermissionForAboveAndroid12$1(StarryNetApiHandler starryNetApiHandler, Continuation<? super StarryNetApiHandler$requestPermissionForAboveAndroid12$1> continuation) {
        super(continuation);
        this.this$0 = starryNetApiHandler;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i0((Fragment) null, this);
    }
}

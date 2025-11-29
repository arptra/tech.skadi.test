package com.upuphone.xr.sapp.permission;

import androidx.fragment.app.FragmentActivity;
import com.upuphone.xr.sapp.entity.PermissionNote;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.permission.PermissionExtKt", f = "PermissionExt.kt", i = {}, l = {65}, m = "requestPermissionWithTips", n = {}, s = {})
public final class PermissionExtKt$requestPermissionWithTips$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public PermissionExtKt$requestPermissionWithTips$1(Continuation<? super PermissionExtKt$requestPermissionWithTips$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PermissionExtKt.a((FragmentActivity) null, (String[]) null, (PermissionNote) null, false, this);
    }
}

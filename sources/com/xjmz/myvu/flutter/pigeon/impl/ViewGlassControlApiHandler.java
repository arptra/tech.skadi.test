package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.vu.ArSpaceService;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil;
import com.xjmz.myvu.flutter.pigeon.AndroidViewGlassControlApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/ViewGlassControlApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidViewGlassControlApi$ViewGlassControlApi;", "<init>", "()V", "", "current", "", "isEnd", "", "f", "(JZ)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ViewGlassControlApiHandler implements AndroidViewGlassControlApi.ViewGlassControlApi {

    /* renamed from: a  reason: collision with root package name */
    public static final ViewGlassControlApiHandler f8360a = new ViewGlassControlApiHandler();

    public /* bridge */ /* synthetic */ void a(Long l, Boolean bool) {
        f(l.longValue(), bool.booleanValue());
    }

    public void f(long j, boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ViewGlassControlApiHandler", "updateGlassBrightness: " + j + ", isEnd: " + z);
        ArSpaceService.Companion companion = ArSpaceService.j;
        if (companion.a() != null) {
            ArSpaceService a2 = companion.a();
            if (a2 != null) {
                a2.y((int) j);
                return;
            }
            return;
        }
        VuGlassesHidUtil vuGlassesHidUtil = VuGlassesHidUtil.f8104a;
        if (vuGlassesHidUtil.e() == 1) {
            vuGlassesHidUtil.y((int) j);
        } else {
            Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, Dispatchers.b(), (CoroutineStart) null, new ViewGlassControlApiHandler$updateGlassBrightness$1((Continuation<? super ViewGlassControlApiHandler$updateGlassBrightness$1>) null), 2, (Object) null);
        }
    }
}

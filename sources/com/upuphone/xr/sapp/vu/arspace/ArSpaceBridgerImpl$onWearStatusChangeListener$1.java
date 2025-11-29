package com.upuphone.xr.sapp.vu.arspace;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.vu.utils.VuGlassesEventDispatcher;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nArSpaceBridgerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArSpaceBridgerImpl.kt\ncom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$onWearStatusChangeListener$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,665:1\n1855#2,2:666\n*S KotlinDebug\n*F\n+ 1 ArSpaceBridgerImpl.kt\ncom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$onWearStatusChangeListener$1\n*L\n165#1:666,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$onWearStatusChangeListener$1", "Lcom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$OnWearStateChangeListener;", "", "isWear", "", "a", "(Z)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ArSpaceBridgerImpl$onWearStatusChangeListener$1 implements VuGlassesEventDispatcher.OnWearStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArSpaceBridgerImpl f8045a;

    public ArSpaceBridgerImpl$onWearStatusChangeListener$1(ArSpaceBridgerImpl arSpaceBridgerImpl) {
        this.f8045a = arSpaceBridgerImpl;
    }

    public void a(boolean z) {
        for (IOnGlassesWearStateChangeListener iOnGlassesWearStateChangeListener : this.f8045a.onGlassesWearStateChangeListeners) {
            try {
                Result.Companion companion = Result.Companion;
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("ArSpaceBridgerImpl", "onWearStateChanged: " + z);
                iOnGlassesWearStateChangeListener.onGlassesWearStateChange(z);
                Result.m20constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m20constructorimpl(ResultKt.createFailure(th));
            }
        }
    }
}

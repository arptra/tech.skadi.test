package com.upuphone.xr.sapp.vu.arspace;

import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nArSpaceBridgerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArSpaceBridgerImpl.kt\ncom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$onGlassesKeyListener$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,665:1\n1855#2,2:666\n*S KotlinDebug\n*F\n+ 1 ArSpaceBridgerImpl.kt\ncom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$onGlassesKeyListener$1\n*L\n142#1:666,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$onGlassesKeyListener$1", "Lcom/upuphone/xr/sapp/vu/arspace/OnKeyListener;", "onKeyEvent", "", "keyCode", "", "action", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ArSpaceBridgerImpl$onGlassesKeyListener$1 implements OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArSpaceBridgerImpl f8043a;

    public ArSpaceBridgerImpl$onGlassesKeyListener$1(ArSpaceBridgerImpl arSpaceBridgerImpl) {
        this.f8043a = arSpaceBridgerImpl;
    }

    public void onKeyEvent(int i, int i2) {
        for (IOnKeyListener iOnKeyListener : this.f8043a.onKeyListeners) {
            try {
                Result.Companion companion = Result.Companion;
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("ArSpaceBridgerImpl", "onKeyEvent: " + i + ", " + i2);
                iOnKeyListener.onKeyEvent(0, i, i2);
                Result.m20constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m20constructorimpl(ResultKt.createFailure(th));
            }
        }
    }
}

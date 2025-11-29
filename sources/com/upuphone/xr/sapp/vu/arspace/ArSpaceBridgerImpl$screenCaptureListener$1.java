package com.upuphone.xr.sapp.vu.arspace;

import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nArSpaceBridgerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArSpaceBridgerImpl.kt\ncom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$screenCaptureListener$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,665:1\n1855#2,2:666\n1855#2,2:668\n1855#2,2:670\n*S KotlinDebug\n*F\n+ 1 ArSpaceBridgerImpl.kt\ncom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$screenCaptureListener$1\n*L\n84#1:666,2\n93#1:668,2\n102#1:670,2\n*E\n"})
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$screenCaptureListener$1", "Lcom/upuphone/xr/sapp/vu/arspace/OnCaptureScreenListener;", "onCaptureScreenEnd", "", "file", "", "onCaptureScreenStart", "onPrepare", "countDown", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ArSpaceBridgerImpl$screenCaptureListener$1 implements OnCaptureScreenListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArSpaceBridgerImpl f8046a;

    public ArSpaceBridgerImpl$screenCaptureListener$1(ArSpaceBridgerImpl arSpaceBridgerImpl) {
        this.f8046a = arSpaceBridgerImpl;
    }

    public void onCaptureScreenEnd(String str) {
        for (IOnCaptureScreenListener iOnCaptureScreenListener : this.f8046a.onCaptureScreenListeners) {
            try {
                Result.Companion companion = Result.Companion;
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("ArSpaceBridgerImpl", "onCaptureScreenEnd: " + str);
                iOnCaptureScreenListener.onCaptureScreenEnd(str);
                Result.m20constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m20constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    public void onCaptureScreenStart() {
        for (IOnCaptureScreenListener iOnCaptureScreenListener : this.f8046a.onCaptureScreenListeners) {
            try {
                Result.Companion companion = Result.Companion;
                ULog.f6446a.a("ArSpaceBridgerImpl", "onCaptureScreenStart");
                iOnCaptureScreenListener.onCaptureScreenStart();
                Result.m20constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m20constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    public void onPrepare(int i) {
        for (IOnCaptureScreenListener iOnCaptureScreenListener : this.f8046a.onCaptureScreenListeners) {
            try {
                Result.Companion companion = Result.Companion;
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("ArSpaceBridgerImpl", "screenCapture onPrepare: " + i);
                iOnCaptureScreenListener.onPrepare(i);
                Result.m20constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m20constructorimpl(ResultKt.createFailure(th));
            }
        }
    }
}

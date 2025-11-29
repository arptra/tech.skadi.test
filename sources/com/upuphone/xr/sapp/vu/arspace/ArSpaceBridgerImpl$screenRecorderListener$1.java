package com.upuphone.xr.sapp.vu.arspace;

import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nArSpaceBridgerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArSpaceBridgerImpl.kt\ncom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$screenRecorderListener$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,665:1\n1855#2,2:666\n1855#2,2:668\n1855#2,2:670\n*S KotlinDebug\n*F\n+ 1 ArSpaceBridgerImpl.kt\ncom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$screenRecorderListener$1\n*L\n113#1:666,2\n122#1:668,2\n131#1:670,2\n*E\n"})
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"com/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$screenRecorderListener$1", "Lcom/upuphone/xr/sapp/vu/arspace/OnRecordScreenListener;", "onPrepare", "", "countDown", "", "onRecordScreenEnd", "file", "", "onRecordScreenStart", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ArSpaceBridgerImpl$screenRecorderListener$1 implements OnRecordScreenListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArSpaceBridgerImpl f8047a;

    public ArSpaceBridgerImpl$screenRecorderListener$1(ArSpaceBridgerImpl arSpaceBridgerImpl) {
        this.f8047a = arSpaceBridgerImpl;
    }

    public void onPrepare(int i) {
        for (IOnRecordScreenListener iOnRecordScreenListener : this.f8047a.onRecordScreenListeners) {
            try {
                Result.Companion companion = Result.Companion;
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("ArSpaceBridgerImpl", "screenRecorder onPrepare: " + i);
                iOnRecordScreenListener.onPrepare(i);
                Result.m20constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m20constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    public void onRecordScreenEnd(String str) {
        for (IOnRecordScreenListener iOnRecordScreenListener : this.f8047a.onRecordScreenListeners) {
            try {
                Result.Companion companion = Result.Companion;
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("ArSpaceBridgerImpl", "onRecordScreenEnd: " + str);
                iOnRecordScreenListener.onRecordScreenEnd(str);
                Result.m20constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m20constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    public void onRecordScreenStart() {
        for (IOnRecordScreenListener iOnRecordScreenListener : this.f8047a.onRecordScreenListeners) {
            try {
                Result.Companion companion = Result.Companion;
                ULog.f6446a.a("ArSpaceBridgerImpl", "onRecordScreenStart");
                iOnRecordScreenListener.onRecordScreenStart();
                Result.m20constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m20constructorimpl(ResultKt.createFailure(th));
            }
        }
    }
}

package com.upuphone.xr.sapp.monitor.notification.business;

import android.service.notification.StatusBarNotification;
import com.upuphone.sdk.ArSmartReminderModel;
import com.upuphone.sdk.ICallback;
import com.upuphone.sdk.ResultType;
import com.upuphone.xr.sapp.monitor.notification.mode.AiSdkResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/upuphone/sdk/ArSmartReminderModel;", "kotlin.jvm.PlatformType", "model", "Lcom/upuphone/sdk/ResultType;", "type", "", "a", "(Lcom/upuphone/sdk/ArSmartReminderModel;Lcom/upuphone/sdk/ResultType;)V"}, k = 3, mv = {1, 9, 0})
public final class ReminderBusinessHandle$handleData$2$1 implements ICallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StatusBarNotification f7757a;
    public final /* synthetic */ CancellableContinuation b;

    public ReminderBusinessHandle$handleData$2$1(StatusBarNotification statusBarNotification, CancellableContinuation cancellableContinuation) {
        this.f7757a = statusBarNotification;
        this.b = cancellableContinuation;
    }

    public final void a(ArSmartReminderModel arSmartReminderModel, ResultType resultType) {
        this.b.resumeWith(Result.m20constructorimpl(new AiSdkResult(resultType, arSmartReminderModel, this.f7757a, false, 8, (DefaultConstructorMarker) null)));
    }
}

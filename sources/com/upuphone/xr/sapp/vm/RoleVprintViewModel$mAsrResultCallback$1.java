package com.upuphone.xr.sapp.vm;

import com.upuphone.xr.sapp.vm.RoleVprintViewModel;
import com.xjsd.xr.sapp.asr.callback.AsrResultCallback;
import com.xjsd.xr.sapp.asr.dao.AsrMessageState;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.Src;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;

@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0015"}, d2 = {"com/upuphone/xr/sapp/vm/RoleVprintViewModel$mAsrResultCallback$1", "Lcom/xjsd/xr/sapp/asr/callback/AsrResultCallback;", "onAsrRunningState", "", "state", "Lcom/xjsd/xr/sapp/asr/dao/AsrMessageState;", "onClosed", "code", "", "reason", "", "onClosing", "onFailure", "throwable", "", "response", "Lokhttp3/Response;", "onOpen", "onRemoteAsrResult", "asrResult", "Lcom/xjsd/xr/sapp/asr/dao/AsrResult;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RoleVprintViewModel$mAsrResultCallback$1 extends AsrResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RoleVprintViewModel f8011a;

    public RoleVprintViewModel$mAsrResultCallback$1(RoleVprintViewModel roleVprintViewModel) {
        this.f8011a = roleVprintViewModel;
    }

    public void onAsrRunningState(AsrMessageState asrMessageState) {
        Intrinsics.checkNotNullParameter(asrMessageState, "state");
        super.onAsrRunningState(asrMessageState);
        RoleVprintViewModel roleVprintViewModel = this.f8011a;
        roleVprintViewModel.S("onAsrRunningState state=" + asrMessageState);
        if (!Intrinsics.areEqual((Object) asrMessageState.getCode(), (Object) "0")) {
            this.f8011a.W(2);
        }
    }

    public void onClosed(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        super.onClosed(i, str);
        RoleVprintViewModel roleVprintViewModel = this.f8011a;
        roleVprintViewModel.S("onClosed code=" + i + ", reason=" + str);
    }

    public void onClosing(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        super.onClosing(i, str);
        RoleVprintViewModel roleVprintViewModel = this.f8011a;
        roleVprintViewModel.S("onClosing code=" + i + ", reason=" + str);
    }

    public void onFailure(Throwable th, Response response) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        super.onFailure(th, response);
        RoleVprintViewModel roleVprintViewModel = this.f8011a;
        String stackTraceToString = ExceptionsKt.stackTraceToString(th);
        roleVprintViewModel.S("onFailure response=" + response + ", throwable=" + stackTraceToString);
        this.f8011a.W(2);
    }

    public void onOpen(Response response) {
        super.onOpen(response);
        RoleVprintViewModel roleVprintViewModel = this.f8011a;
        roleVprintViewModel.S("onOpen response=" + response);
        this.f8011a.W(1);
    }

    public void onRemoteAsrResult(AsrResult asrResult) {
        Unit unit;
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(asrResult, "asrResult");
        super.onRemoteAsrResult(asrResult);
        this.f8011a.S("onAsrResult asrResult=" + asrResult);
        Src src = asrResult.getSrc();
        if (src != null) {
            RoleVprintViewModel roleVprintViewModel = this.f8011a;
            RoleVprintViewModel.RoleAsrResult j = roleVprintViewModel.h;
            String str4 = "";
            if (j != null) {
                if (src.getType() == 0) {
                    str3 = j.a() + src.getContent();
                    str2 = str4;
                } else {
                    str3 = j.a();
                    str2 = src.getContent();
                }
                roleVprintViewModel.h = new RoleVprintViewModel.RoleAsrResult(str3, str2);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                if (src.getType() == 0) {
                    String str5 = str4;
                    str4 = src.getContent();
                    str = str5;
                } else {
                    str = src.getContent();
                }
                roleVprintViewModel.h = new RoleVprintViewModel.RoleAsrResult(str4, str);
            }
            roleVprintViewModel.U(src);
        }
    }
}

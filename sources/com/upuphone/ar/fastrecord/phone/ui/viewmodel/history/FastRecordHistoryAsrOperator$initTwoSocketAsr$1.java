package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.xjsd.xr.sapp.asr.callback.AsrResultCallback;
import com.xjsd.xr.sapp.asr.dao.AsrMessageState;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.Dst;
import com.xjsd.xr.sapp.asr.dao.ResultExt;
import com.xjsd.xr.sapp.asr.dao.Src;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0016"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordHistoryAsrOperator$initTwoSocketAsr$1", "Lcom/xjsd/xr/sapp/asr/callback/AsrResultCallback;", "onAsrRunningState", "", "state", "Lcom/xjsd/xr/sapp/asr/dao/AsrMessageState;", "onClosed", "code", "", "reason", "", "onClosing", "onFailure", "throwable", "", "response", "Lokhttp3/Response;", "onOpen", "onProximalAsrResult", "asrResult", "Lcom/xjsd/xr/sapp/asr/dao/AsrResult;", "onRemoteAsrResult", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryAsrOperator$initTwoSocketAsr$1 extends AsrResultCallback {
    final /* synthetic */ FastRecordHistoryAsrOperator this$0;

    public FastRecordHistoryAsrOperator$initTwoSocketAsr$1(FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator) {
        this.this$0 = fastRecordHistoryAsrOperator;
    }

    public void onAsrRunningState(@NotNull AsrMessageState asrMessageState) {
        Intrinsics.checkNotNullParameter(asrMessageState, "state");
        super.onAsrRunningState(asrMessageState);
        String code = asrMessageState.getCode();
        String desc = asrMessageState.getDesc();
        boolean access$isAsrFailCode = this.this$0.isAsrFailCode(asrMessageState.getCode());
        LogExt.logW("TwoAsr onAsrRunningState code = " + code + ",reason = " + desc + ",isAsrFailCode = " + access$isAsrFailCode, FastRecordHistoryAsrOperator.TAG);
        if (Intrinsics.areEqual((Object) asrMessageState.getCode(), (Object) "0") || this.this$0.isAsrFailCode(asrMessageState.getCode())) {
            this.this$0.isFinishPrePareAsrSocket = true;
        } else {
            FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator = this.this$0;
            fastRecordHistoryAsrOperator.createOrPostHandlerCommand(new FastRecordHistoryAsrOperator$initTwoSocketAsr$1$onAsrRunningState$1(fastRecordHistoryAsrOperator, asrMessageState));
        }
        this.this$0.showComplianceFail(asrMessageState.getCode(), asrMessageState.getDesc(), asrMessageState.getAction(), new FastRecordHistoryAsrOperator$initTwoSocketAsr$1$onAsrRunningState$2(this.this$0, asrMessageState));
    }

    public void onClosed(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        super.onClosed(i, str);
        LogExt.logW("TwoAsr onClosed code = " + i + ",reason = " + str, FastRecordHistoryAsrOperator.TAG);
    }

    public void onClosing(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        super.onClosing(i, str);
        LogExt.logW("TwoAsr onClosing", FastRecordHistoryAsrOperator.TAG);
        FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator = this.this$0;
        fastRecordHistoryAsrOperator.createOrPostHandlerCommand(new FastRecordHistoryAsrOperator$initTwoSocketAsr$1$onClosing$1(fastRecordHistoryAsrOperator, i));
    }

    public void onFailure(@NotNull Throwable th, @Nullable Response response) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        super.onFailure(th, response);
        String message = th.getMessage();
        Integer num = null;
        String message2 = response != null ? response.message() : null;
        if (response != null) {
            num = Integer.valueOf(response.code());
        }
        LogExt.logW("TwoAsr onProximalAsrResult onFailure response throwable = " + message + ",= " + message2 + " ,code = " + num, FastRecordHistoryAsrOperator.TAG);
        FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator = this.this$0;
        fastRecordHistoryAsrOperator.createOrPostHandlerCommand(new FastRecordHistoryAsrOperator$initTwoSocketAsr$1$onFailure$1(fastRecordHistoryAsrOperator, response));
    }

    public void onOpen(@Nullable Response response) {
        super.onOpen(response);
        LogExt.logW("TwoAsr onOpen", FastRecordHistoryAsrOperator.TAG);
    }

    public void onProximalAsrResult(@NotNull AsrResult asrResult) {
        String str;
        Intrinsics.checkNotNullParameter(asrResult, "asrResult");
        super.onProximalAsrResult(asrResult);
        Src src = asrResult.getSrc();
        Dst dst = asrResult.getDst();
        ResultExt ext = asrResult.getExt();
        LogExt.logW("TwoAsr onProximalAsrResult src = " + src + ",dst = " + dst + ",ext = " + ext, FastRecordHistoryAsrOperator.TAG);
        FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator = this.this$0;
        ResultExt ext2 = asrResult.getExt();
        if (ext2 == null || (str = ext2.getRecognizeId()) == null) {
            str = "";
        }
        fastRecordHistoryAsrOperator.recognizeId = str;
        Src src2 = asrResult.getSrc();
        if (src2 != null && src2.getType() == 0) {
            this.this$0.savePhoneProximalProgressData(asrResult.getSrc());
            FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator2 = this.this$0;
            fastRecordHistoryAsrOperator2.createOrPostHandlerCommand(new FastRecordHistoryAsrOperator$initTwoSocketAsr$1$onProximalAsrResult$1(fastRecordHistoryAsrOperator2, asrResult));
        }
        Src src3 = asrResult.getSrc();
        if (src3 != null && src3.getEnd() == 0) {
            LogExt.logW("TwoAsr onProximalAsrResult asrResult.src?.end = 0 endRequest proximalIsEnd", FastRecordHistoryAsrOperator.TAG);
            this.this$0.endProximalState = true;
            this.this$0.checkTwoEndState();
        }
    }

    public void onRemoteAsrResult(@NotNull AsrResult asrResult) {
        String str;
        Intrinsics.checkNotNullParameter(asrResult, "asrResult");
        super.onRemoteAsrResult(asrResult);
        Src src = asrResult.getSrc();
        Dst dst = asrResult.getDst();
        ResultExt ext = asrResult.getExt();
        LogExt.logW("TwoAsr phoneOther onRemoteAsrResult src = " + src + ",dst = " + dst + ",ext = " + ext, FastRecordHistoryAsrOperator.TAG);
        FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator = this.this$0;
        ResultExt ext2 = asrResult.getExt();
        if (ext2 == null || (str = ext2.getRecognizeId()) == null) {
            str = "";
        }
        fastRecordHistoryAsrOperator.recognizeId = str;
        Src src2 = asrResult.getSrc();
        if (src2 != null && src2.getType() == 0) {
            this.this$0.savePhoneRemoteProgressData(asrResult.getSrc());
            FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator2 = this.this$0;
            fastRecordHistoryAsrOperator2.createOrPostHandlerCommand(new FastRecordHistoryAsrOperator$initTwoSocketAsr$1$onRemoteAsrResult$1(fastRecordHistoryAsrOperator2, asrResult));
        }
        Src src3 = asrResult.getSrc();
        if (src3 != null && src3.getEnd() == 0) {
            LogExt.logW("TwoAsr phoneOther onRemoteAsrResult asrResult.src?.end = 0 endRequest", FastRecordHistoryAsrOperator.TAG);
            this.this$0.endRemoteState = true;
            this.this$0.checkTwoEndState();
        }
    }
}

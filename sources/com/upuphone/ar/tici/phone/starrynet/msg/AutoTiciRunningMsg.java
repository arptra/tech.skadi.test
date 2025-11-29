package com.upuphone.ar.tici.phone.starrynet.msg;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.upuphone.ar.tici.phone.starrynet.BaseJsonMsg;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/AutoTiciRunningMsg;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "isRunning", "", "isFinish", "(ZZ)V", "()Z", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AutoTiciRunningMsg extends BaseJsonMsg {
    @SerializedName("isFinish")
    private final boolean isFinish;
    @SerializedName("isRunning")
    private final boolean isRunning;

    public AutoTiciRunningMsg(boolean z, boolean z2) {
        this.isRunning = z;
        this.isFinish = z2;
    }

    public final boolean isFinish() {
        return this.isFinish;
    }

    public final boolean isRunning() {
        return this.isRunning;
    }
}

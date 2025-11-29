package com.upuphone.ar.tici.phone.starrynet.msg;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.upuphone.ar.tici.phone.starrynet.BaseJsonMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/ChangeTiciModeMsg;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "ticiMode", "", "ticiSpeed", "", "blockNotification", "", "screenLocation", "(IJLjava/lang/Boolean;Ljava/lang/Integer;)V", "getBlockNotification", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getScreenLocation", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTiciMode", "()I", "getTiciSpeed", "()J", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ChangeTiciModeMsg extends BaseJsonMsg {
    @SerializedName("blockNotification")
    @Nullable
    private final Boolean blockNotification;
    @SerializedName("screenLocation")
    @Nullable
    private final Integer screenLocation;
    @SerializedName("ticiMode")
    private final int ticiMode;
    @SerializedName("ticiSpeed")
    private final long ticiSpeed;

    public ChangeTiciModeMsg(int i, long j, @Nullable Boolean bool, @Nullable Integer num) {
        this.ticiMode = i;
        this.ticiSpeed = j;
        this.blockNotification = bool;
        this.screenLocation = num;
    }

    @Nullable
    public final Boolean getBlockNotification() {
        return this.blockNotification;
    }

    @Nullable
    public final Integer getScreenLocation() {
        return this.screenLocation;
    }

    public final int getTiciMode() {
        return this.ticiMode;
    }

    public final long getTiciSpeed() {
        return this.ticiSpeed;
    }
}

package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.honey.account.view.web.WebJs;
import com.upuphone.xr.sapp.context.IAudioMulti;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/entity/AudioMulti;", "Lcom/upuphone/xr/sapp/context/IAudioMulti;", "action", "", "data", "Lcom/upuphone/xr/sapp/context/IAudioMulti$Data;", "audioBytes", "", "(Ljava/lang/String;Lcom/upuphone/xr/sapp/context/IAudioMulti$Data;[B)V", "getAction", "()Ljava/lang/String;", "getAudioBytes", "()[B", "getData", "()Lcom/upuphone/xr/sapp/context/IAudioMulti$Data;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AudioMulti implements IAudioMulti {
    @NotNull
    private final String action;
    @NotNull
    private final transient byte[] audioBytes;
    @NotNull
    private final IAudioMulti.Data data;

    public AudioMulti(@NotNull String str, @NotNull IAudioMulti.Data data2, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(data2, "data");
        Intrinsics.checkNotNullParameter(bArr, "audioBytes");
        this.action = str;
        this.data = data2;
        this.audioBytes = bArr;
    }

    public static /* synthetic */ AudioMulti copy$default(AudioMulti audioMulti, String str, IAudioMulti.Data data2, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = audioMulti.action;
        }
        if ((i & 2) != 0) {
            data2 = audioMulti.data;
        }
        if ((i & 4) != 0) {
            bArr = audioMulti.audioBytes;
        }
        return audioMulti.copy(str, data2, bArr);
    }

    @NotNull
    public final String component1() {
        return this.action;
    }

    @NotNull
    public final IAudioMulti.Data component2() {
        return this.data;
    }

    @NotNull
    public final byte[] component3() {
        return this.audioBytes;
    }

    @NotNull
    public final AudioMulti copy(@NotNull String str, @NotNull IAudioMulti.Data data2, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(data2, "data");
        Intrinsics.checkNotNullParameter(bArr, "audioBytes");
        return new AudioMulti(str, data2, bArr);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) AudioMulti.class, (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.xr.sapp.entity.AudioMulti");
        AudioMulti audioMulti = (AudioMulti) obj;
        return Intrinsics.areEqual((Object) getData(), (Object) audioMulti.getData()) && Arrays.equals(getAudioBytes(), audioMulti.getAudioBytes());
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    @NotNull
    public byte[] getAudioBytes() {
        return this.audioBytes;
    }

    @NotNull
    public IAudioMulti.Data getData() {
        return this.data;
    }

    public int hashCode() {
        return (getData().hashCode() * 31) + Arrays.hashCode(getAudioBytes());
    }

    @NotNull
    public String toString() {
        String str = this.action;
        IAudioMulti.Data data2 = this.data;
        String arrays = Arrays.toString(this.audioBytes);
        return "AudioMulti(action=" + str + ", data=" + data2 + ", audioBytes=" + arrays + ")";
    }
}

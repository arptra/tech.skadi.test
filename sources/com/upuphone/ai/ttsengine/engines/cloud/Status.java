package com.upuphone.ai.ttsengine.engines.cloud;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cloud/Status;", "", "()V", "AudioData", "Error", "Lcom/upuphone/ai/ttsengine/engines/cloud/Status$AudioData;", "Lcom/upuphone/ai/ttsengine/engines/cloud/Status$Error;", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class Status {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cloud/Status$Error;", "Lcom/upuphone/ai/ttsengine/engines/cloud/Status;", "", "code", "", "message", "<init>", "(ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "b", "Ljava/lang/String;", "getMessage", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Error extends Status {

        /* renamed from: a  reason: collision with root package name */
        public final int f5554a;
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(int i, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.f5554a = i;
            this.b = str;
        }

        public final int a() {
            return this.f5554a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return this.f5554a == error.f5554a && Intrinsics.areEqual((Object) this.b, (Object) error.b);
        }

        public int hashCode() {
            return (Integer.hashCode(this.f5554a) * 31) + this.b.hashCode();
        }

        public String toString() {
            int i = this.f5554a;
            String str = this.b;
            return "Error(code=" + i + ", message=" + str + ")";
        }
    }

    public /* synthetic */ Status(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public Status() {
    }

    @Keep
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J3\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0010\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cloud/Status$AudioData;", "Lcom/upuphone/ai/ttsengine/engines/cloud/Status;", "sequence", "", "encoding", "", "data", "requestId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "audioBytes", "", "getAudioBytes", "()[B", "setAudioBytes", "([B)V", "getData", "()Ljava/lang/String;", "getEncoding", "setEncoding", "(Ljava/lang/String;)V", "getRequestId", "setRequestId", "getSequence", "()I", "setSequence", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AudioData extends Status {
        @Nullable
        private byte[] audioBytes;
        @NotNull
        private final String data;
        @Nullable
        private String encoding;
        @NotNull
        private String requestId;
        private int sequence;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AudioData(int i, String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? "mp3" : str, str2, (i2 & 8) != 0 ? "" : str3);
        }

        public static /* synthetic */ AudioData copy$default(AudioData audioData, int i, String str, String str2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = audioData.sequence;
            }
            if ((i2 & 2) != 0) {
                str = audioData.encoding;
            }
            if ((i2 & 4) != 0) {
                str2 = audioData.data;
            }
            if ((i2 & 8) != 0) {
                str3 = audioData.requestId;
            }
            return audioData.copy(i, str, str2, str3);
        }

        public final int component1() {
            return this.sequence;
        }

        @Nullable
        public final String component2() {
            return this.encoding;
        }

        @NotNull
        public final String component3() {
            return this.data;
        }

        @NotNull
        public final String component4() {
            return this.requestId;
        }

        @NotNull
        public final AudioData copy(int i, @Nullable String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str2, "data");
            Intrinsics.checkNotNullParameter(str3, "requestId");
            return new AudioData(i, str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioData)) {
                return false;
            }
            AudioData audioData = (AudioData) obj;
            return this.sequence == audioData.sequence && Intrinsics.areEqual((Object) this.encoding, (Object) audioData.encoding) && Intrinsics.areEqual((Object) this.data, (Object) audioData.data) && Intrinsics.areEqual((Object) this.requestId, (Object) audioData.requestId);
        }

        @Nullable
        public final byte[] getAudioBytes() {
            return this.audioBytes;
        }

        @NotNull
        public final String getData() {
            return this.data;
        }

        @Nullable
        public final String getEncoding() {
            return this.encoding;
        }

        @NotNull
        public final String getRequestId() {
            return this.requestId;
        }

        public final int getSequence() {
            return this.sequence;
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.sequence) * 31;
            String str = this.encoding;
            return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.data.hashCode()) * 31) + this.requestId.hashCode();
        }

        public final void setAudioBytes(@Nullable byte[] bArr) {
            this.audioBytes = bArr;
        }

        public final void setEncoding(@Nullable String str) {
            this.encoding = str;
        }

        public final void setRequestId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.requestId = str;
        }

        public final void setSequence(int i) {
            this.sequence = i;
        }

        @NotNull
        public String toString() {
            int i = this.sequence;
            String str = this.encoding;
            String str2 = this.data;
            String str3 = this.requestId;
            return "AudioData(sequence=" + i + ", encoding=" + str + ", data=" + str2 + ", requestId=" + str3 + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AudioData(int i, @Nullable String str, @NotNull String str2, @NotNull String str3) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str2, "data");
            Intrinsics.checkNotNullParameter(str3, "requestId");
            this.sequence = i;
            this.encoding = str;
            this.data = str2;
            this.requestId = str3;
        }
    }
}

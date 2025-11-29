package com.upuphone.xr.sapp.context;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/context/IAudioMulti;", "", "audioBytes", "", "getAudioBytes", "()[B", "data", "Lcom/upuphone/xr/sapp/context/IAudioMulti$Data;", "getData", "()Lcom/upuphone/xr/sapp/context/IAudioMulti$Data;", "Data", "lib_context_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IAudioMulti {

    @Keep
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/context/IAudioMulti$Data;", "", "type", "", "tag", "id", "(III)V", "getId", "()I", "getTag", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "lib_context_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Data {
        private final int id;
        private final int tag;
        private final int type;

        public Data(int i, int i2, int i3) {
            this.type = i;
            this.tag = i2;
            this.id = i3;
        }

        public static /* synthetic */ Data copy$default(Data data, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = data.type;
            }
            if ((i4 & 2) != 0) {
                i2 = data.tag;
            }
            if ((i4 & 4) != 0) {
                i3 = data.id;
            }
            return data.copy(i, i2, i3);
        }

        public final int component1() {
            return this.type;
        }

        public final int component2() {
            return this.tag;
        }

        public final int component3() {
            return this.id;
        }

        @NotNull
        public final Data copy(int i, int i2, int i3) {
            return new Data(i, i2, i3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return this.type == data.type && this.tag == data.tag && this.id == data.id;
        }

        public final int getId() {
            return this.id;
        }

        public final int getTag() {
            return this.tag;
        }

        public final int getType() {
            return this.type;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.type) * 31) + Integer.hashCode(this.tag)) * 31) + Integer.hashCode(this.id);
        }

        @NotNull
        public String toString() {
            int i = this.type;
            int i2 = this.tag;
            int i3 = this.id;
            return "Data(type=" + i + ", tag=" + i2 + ", id=" + i3 + ")";
        }
    }

    byte[] getAudioBytes();

    Data getData();
}

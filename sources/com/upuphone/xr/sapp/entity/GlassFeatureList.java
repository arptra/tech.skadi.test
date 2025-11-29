package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.honey.account.view.web.WebJs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassFeatureList;", "", "action", "", "data", "Lcom/upuphone/xr/sapp/entity/GlassFeatureList$Data;", "(Ljava/lang/String;Lcom/upuphone/xr/sapp/entity/GlassFeatureList$Data;)V", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "getData", "()Lcom/upuphone/xr/sapp/entity/GlassFeatureList$Data;", "setData", "(Lcom/upuphone/xr/sapp/entity/GlassFeatureList$Data;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Data", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GlassFeatureList {
    @NotNull
    private String action;
    @NotNull
    private Data data;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassFeatureList$Data;", "", "version", "", "features", "", "(Ljava/lang/String;Ljava/util/List;)V", "getFeatures", "()Ljava/util/List;", "setFeatures", "(Ljava/util/List;)V", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Data {
        @NotNull
        private List<String> features;
        @NotNull
        private String version;

        public Data(@NotNull String str, @NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(str, "version");
            Intrinsics.checkNotNullParameter(list, "features");
            this.version = str;
            this.features = list;
        }

        public static /* synthetic */ Data copy$default(Data data, String str, List<String> list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = data.version;
            }
            if ((i & 2) != 0) {
                list = data.features;
            }
            return data.copy(str, list);
        }

        @NotNull
        public final String component1() {
            return this.version;
        }

        @NotNull
        public final List<String> component2() {
            return this.features;
        }

        @NotNull
        public final Data copy(@NotNull String str, @NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(str, "version");
            Intrinsics.checkNotNullParameter(list, "features");
            return new Data(str, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return Intrinsics.areEqual((Object) this.version, (Object) data.version) && Intrinsics.areEqual((Object) this.features, (Object) data.features);
        }

        @NotNull
        public final List<String> getFeatures() {
            return this.features;
        }

        @NotNull
        public final String getVersion() {
            return this.version;
        }

        public int hashCode() {
            return (this.version.hashCode() * 31) + this.features.hashCode();
        }

        public final void setFeatures(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.features = list;
        }

        public final void setVersion(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.version = str;
        }

        @NotNull
        public String toString() {
            String str = this.version;
            List<String> list = this.features;
            return "Data(version=" + str + ", features=" + list + ")";
        }
    }

    public GlassFeatureList(@NotNull String str, @NotNull Data data2) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(data2, "data");
        this.action = str;
        this.data = data2;
    }

    public static /* synthetic */ GlassFeatureList copy$default(GlassFeatureList glassFeatureList, String str, Data data2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = glassFeatureList.action;
        }
        if ((i & 2) != 0) {
            data2 = glassFeatureList.data;
        }
        return glassFeatureList.copy(str, data2);
    }

    @NotNull
    public final String component1() {
        return this.action;
    }

    @NotNull
    public final Data component2() {
        return this.data;
    }

    @NotNull
    public final GlassFeatureList copy(@NotNull String str, @NotNull Data data2) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(data2, "data");
        return new GlassFeatureList(str, data2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassFeatureList)) {
            return false;
        }
        GlassFeatureList glassFeatureList = (GlassFeatureList) obj;
        return Intrinsics.areEqual((Object) this.action, (Object) glassFeatureList.action) && Intrinsics.areEqual((Object) this.data, (Object) glassFeatureList.data);
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    @NotNull
    public final Data getData() {
        return this.data;
    }

    public int hashCode() {
        return (this.action.hashCode() * 31) + this.data.hashCode();
    }

    public final void setAction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.action = str;
    }

    public final void setData(@NotNull Data data2) {
        Intrinsics.checkNotNullParameter(data2, "<set-?>");
        this.data = data2;
    }

    @NotNull
    public String toString() {
        String str = this.action;
        Data data2 = this.data;
        return "GlassFeatureList(action=" + str + ", data=" + data2 + ")";
    }
}

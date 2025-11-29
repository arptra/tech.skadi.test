package com.upuphone.ar.translation.interconnect.entity;

import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.google.gson.annotations.SerializedName;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/translation/interconnect/entity/OpenScene;", "", "action", "", "data", "Lcom/upuphone/ar/translation/interconnect/entity/OpenScene$Data;", "(Ljava/lang/String;Lcom/upuphone/ar/translation/interconnect/entity/OpenScene$Data;)V", "getAction", "()Ljava/lang/String;", "getData", "()Lcom/upuphone/ar/translation/interconnect/entity/OpenScene$Data;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Data", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OpenScene {
    @SerializedName("action")
    @NotNull
    private final String action;
    @SerializedName("data")
    @NotNull
    private final Data data;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001 BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/upuphone/ar/translation/interconnect/entity/OpenScene$Data;", "", "action", "", "launchMode", "pkg", "appName", "ext", "size", "Lcom/upuphone/ar/translation/interconnect/entity/OpenScene$Data$Size;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/upuphone/ar/translation/interconnect/entity/OpenScene$Data$Size;)V", "getAction", "()Ljava/lang/String;", "getAppName", "getExt", "getLaunchMode", "getPkg", "getSize", "()Lcom/upuphone/ar/translation/interconnect/entity/OpenScene$Data$Size;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Size", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Data {
        @SerializedName("action")
        @NotNull
        private final String action;
        @SerializedName("app_name")
        @NotNull
        private final String appName;
        @SerializedName("ext")
        @Nullable
        private final String ext;
        @SerializedName("launchMode")
        @NotNull
        private final String launchMode;
        @SerializedName("pkg")
        @NotNull
        private final String pkg;
        @SerializedName("size")
        @Nullable
        private final Size size;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/upuphone/ar/translation/interconnect/entity/OpenScene$Data$Size;", "", "height", "", "width", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Size {
            @SerializedName("height")
            private final int height;
            @SerializedName("width")
            private final int width;

            public Size() {
                this(0, 0, 3, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Size copy$default(Size size, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = size.height;
                }
                if ((i3 & 2) != 0) {
                    i2 = size.width;
                }
                return size.copy(i, i2);
            }

            public final int component1() {
                return this.height;
            }

            public final int component2() {
                return this.width;
            }

            @NotNull
            public final Size copy(int i, int i2) {
                return new Size(i, i2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Size)) {
                    return false;
                }
                Size size = (Size) obj;
                return this.height == size.height && this.width == size.width;
            }

            public final int getHeight() {
                return this.height;
            }

            public final int getWidth() {
                return this.width;
            }

            public int hashCode() {
                return (Integer.hashCode(this.height) * 31) + Integer.hashCode(this.width);
            }

            @NotNull
            public String toString() {
                int i = this.height;
                int i2 = this.width;
                return "Size(height=" + i + ", width=" + i2 + ")";
            }

            public Size(int i, int i2) {
                this.height = i;
                this.width = i2;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Size(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
            }
        }

        public Data() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, (Size) null, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Data copy$default(Data data, String str, String str2, String str3, String str4, String str5, Size size2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = data.action;
            }
            if ((i & 2) != 0) {
                str2 = data.launchMode;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = data.pkg;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = data.appName;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = data.ext;
            }
            String str9 = str5;
            if ((i & 32) != 0) {
                size2 = data.size;
            }
            return data.copy(str, str6, str7, str8, str9, size2);
        }

        @NotNull
        public final String component1() {
            return this.action;
        }

        @NotNull
        public final String component2() {
            return this.launchMode;
        }

        @NotNull
        public final String component3() {
            return this.pkg;
        }

        @NotNull
        public final String component4() {
            return this.appName;
        }

        @Nullable
        public final String component5() {
            return this.ext;
        }

        @Nullable
        public final Size component6() {
            return this.size;
        }

        @NotNull
        public final Data copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @Nullable Size size2) {
            Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
            Intrinsics.checkNotNullParameter(str2, "launchMode");
            Intrinsics.checkNotNullParameter(str3, AccountConstantKt.REQUEST_HEADER_PKG);
            Intrinsics.checkNotNullParameter(str4, "appName");
            return new Data(str, str2, str3, str4, str5, size2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return Intrinsics.areEqual((Object) this.action, (Object) data.action) && Intrinsics.areEqual((Object) this.launchMode, (Object) data.launchMode) && Intrinsics.areEqual((Object) this.pkg, (Object) data.pkg) && Intrinsics.areEqual((Object) this.appName, (Object) data.appName) && Intrinsics.areEqual((Object) this.ext, (Object) data.ext) && Intrinsics.areEqual((Object) this.size, (Object) data.size);
        }

        @NotNull
        public final String getAction() {
            return this.action;
        }

        @NotNull
        public final String getAppName() {
            return this.appName;
        }

        @Nullable
        public final String getExt() {
            return this.ext;
        }

        @NotNull
        public final String getLaunchMode() {
            return this.launchMode;
        }

        @NotNull
        public final String getPkg() {
            return this.pkg;
        }

        @Nullable
        public final Size getSize() {
            return this.size;
        }

        public int hashCode() {
            int hashCode = ((((((this.action.hashCode() * 31) + this.launchMode.hashCode()) * 31) + this.pkg.hashCode()) * 31) + this.appName.hashCode()) * 31;
            String str = this.ext;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Size size2 = this.size;
            if (size2 != null) {
                i = size2.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            String str = this.action;
            String str2 = this.launchMode;
            String str3 = this.pkg;
            String str4 = this.appName;
            String str5 = this.ext;
            Size size2 = this.size;
            return "Data(action=" + str + ", launchMode=" + str2 + ", pkg=" + str3 + ", appName=" + str4 + ", ext=" + str5 + ", size=" + size2 + ")";
        }

        public Data(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @Nullable Size size2) {
            Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
            Intrinsics.checkNotNullParameter(str2, "launchMode");
            Intrinsics.checkNotNullParameter(str3, AccountConstantKt.REQUEST_HEADER_PKG);
            Intrinsics.checkNotNullParameter(str4, "appName");
            this.action = str;
            this.launchMode = str2;
            this.pkg = str3;
            this.appName = str4;
            this.ext = str5;
            this.size = size2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Data(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, com.upuphone.ar.translation.interconnect.entity.OpenScene.Data.Size r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
            /*
                r4 = this;
                r12 = r11 & 1
                if (r12 == 0) goto L_0x0006
                java.lang.String r5 = "open_app"
            L_0x0006:
                r12 = r11 & 2
                if (r12 == 0) goto L_0x000c
                java.lang.String r6 = "scene"
            L_0x000c:
                r12 = r6
                r6 = r11 & 4
                if (r6 == 0) goto L_0x0013
                java.lang.String r7 = "com.upuphone.ar.translation.glasses"
            L_0x0013:
                r0 = r7
                r6 = r11 & 8
                if (r6 == 0) goto L_0x001a
                java.lang.String r8 = ""
            L_0x001a:
                r1 = r8
                r6 = r11 & 16
                r7 = 0
                if (r6 == 0) goto L_0x0022
                r2 = r7
                goto L_0x0023
            L_0x0022:
                r2 = r9
            L_0x0023:
                r6 = r11 & 32
                if (r6 == 0) goto L_0x0029
                r3 = r7
                goto L_0x002a
            L_0x0029:
                r3 = r10
            L_0x002a:
                r6 = r4
                r7 = r5
                r8 = r12
                r9 = r0
                r10 = r1
                r11 = r2
                r12 = r3
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.interconnect.entity.OpenScene.Data.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.upuphone.ar.translation.interconnect.entity.OpenScene$Data$Size, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    public OpenScene(@NotNull String str, @NotNull Data data2) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(data2, "data");
        this.action = str;
        this.data = data2;
    }

    public static /* synthetic */ OpenScene copy$default(OpenScene openScene, String str, Data data2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = openScene.action;
        }
        if ((i & 2) != 0) {
            data2 = openScene.data;
        }
        return openScene.copy(str, data2);
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
    public final OpenScene copy(@NotNull String str, @NotNull Data data2) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(data2, "data");
        return new OpenScene(str, data2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenScene)) {
            return false;
        }
        OpenScene openScene = (OpenScene) obj;
        return Intrinsics.areEqual((Object) this.action, (Object) openScene.action) && Intrinsics.areEqual((Object) this.data, (Object) openScene.data);
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

    @NotNull
    public String toString() {
        String str = this.action;
        Data data2 = this.data;
        return "OpenScene(action=" + str + ", data=" + data2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OpenScene(String str, Data data2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DDAuthConstant.AUTH_LOGIN_TYPE_APP : str, data2);
    }
}

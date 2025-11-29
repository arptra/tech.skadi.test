package kotlin.text;

import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lkotlin/text/HexFormat;", "", "upperCase", "", "bytes", "Lkotlin/text/HexFormat$BytesHexFormat;", "number", "Lkotlin/text/HexFormat$NumberHexFormat;", "(ZLkotlin/text/HexFormat$BytesHexFormat;Lkotlin/text/HexFormat$NumberHexFormat;)V", "getBytes", "()Lkotlin/text/HexFormat$BytesHexFormat;", "getNumber", "()Lkotlin/text/HexFormat$NumberHexFormat;", "getUpperCase", "()Z", "toString", "", "Builder", "BytesHexFormat", "Companion", "NumberHexFormat", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@ExperimentalStdlibApi
public final class HexFormat {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final HexFormat Default;
    /* access modifiers changed from: private */
    @NotNull
    public static final HexFormat UpperCase;
    @NotNull
    private final BytesHexFormat bytes;
    @NotNull
    private final NumberHexFormat number;
    private final boolean upperCase;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0001¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0001J%\u0010\u0007\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0017¢\u0006\u0002\b\u0018H\bø\u0001\u0000J%\u0010\n\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u0017¢\u0006\u0002\b\u0018H\bø\u0001\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0019"}, d2 = {"Lkotlin/text/HexFormat$Builder;", "", "()V", "_bytes", "Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "_number", "Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "bytes", "getBytes", "()Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "number", "getNumber", "()Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "upperCase", "", "getUpperCase", "()Z", "setUpperCase", "(Z)V", "build", "Lkotlin/text/HexFormat;", "", "builderAction", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder {
        @Nullable
        private BytesHexFormat.Builder _bytes;
        @Nullable
        private NumberHexFormat.Builder _number;
        private boolean upperCase = HexFormat.Companion.getDefault().getUpperCase();

        @InlineOnly
        private final void bytes(Function1<? super BytesHexFormat.Builder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "builderAction");
            function1.invoke(getBytes());
        }

        @InlineOnly
        private final void number(Function1<? super NumberHexFormat.Builder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "builderAction");
            function1.invoke(getNumber());
        }

        @NotNull
        @PublishedApi
        public final HexFormat build() {
            BytesHexFormat bytesHexFormat;
            NumberHexFormat numberHexFormat;
            boolean z = this.upperCase;
            BytesHexFormat.Builder builder = this._bytes;
            if (builder == null || (bytesHexFormat = builder.build$kotlin_stdlib()) == null) {
                bytesHexFormat = BytesHexFormat.Companion.getDefault$kotlin_stdlib();
            }
            NumberHexFormat.Builder builder2 = this._number;
            if (builder2 == null || (numberHexFormat = builder2.build$kotlin_stdlib()) == null) {
                numberHexFormat = NumberHexFormat.Companion.getDefault$kotlin_stdlib();
            }
            return new HexFormat(z, bytesHexFormat, numberHexFormat);
        }

        @NotNull
        public final BytesHexFormat.Builder getBytes() {
            if (this._bytes == null) {
                this._bytes = new BytesHexFormat.Builder();
            }
            BytesHexFormat.Builder builder = this._bytes;
            Intrinsics.checkNotNull(builder);
            return builder;
        }

        @NotNull
        public final NumberHexFormat.Builder getNumber() {
            if (this._number == null) {
                this._number = new NumberHexFormat.Builder();
            }
            NumberHexFormat.Builder builder = this._number;
            Intrinsics.checkNotNull(builder);
            return builder;
        }

        public final boolean getUpperCase() {
            return this.upperCase;
        }

        public final void setUpperCase(boolean z) {
            this.upperCase = z;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ%\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\n\u0010\u0016\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0017\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0018J\b\u0010\u0019\u001a\u00020\u0006H\u0016R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001c"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat;", "", "bytesPerLine", "", "bytesPerGroup", "groupSeparator", "", "byteSeparator", "bytePrefix", "byteSuffix", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBytePrefix", "()Ljava/lang/String;", "getByteSeparator", "getByteSuffix", "getBytesPerGroup", "()I", "getBytesPerLine", "getGroupSeparator", "appendOptionsTo", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "indent", "appendOptionsTo$kotlin_stdlib", "toString", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BytesHexFormat {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        @NotNull
        public static final BytesHexFormat Default = new BytesHexFormat(Integer.MAX_VALUE, Integer.MAX_VALUE, FastRecordHistoryDetailActivity.TAG_SPLIT, "", "", "");
        @NotNull
        private final String bytePrefix;
        @NotNull
        private final String byteSeparator;
        @NotNull
        private final String byteSuffix;
        private final int bytesPerGroup;
        private final int bytesPerLine;
        @NotNull
        private final String groupSeparator;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\r\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001eR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001f"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "", "()V", "value", "", "bytePrefix", "getBytePrefix", "()Ljava/lang/String;", "setBytePrefix", "(Ljava/lang/String;)V", "byteSeparator", "getByteSeparator", "setByteSeparator", "byteSuffix", "getByteSuffix", "setByteSuffix", "", "bytesPerGroup", "getBytesPerGroup", "()I", "setBytesPerGroup", "(I)V", "bytesPerLine", "getBytesPerLine", "setBytesPerLine", "groupSeparator", "getGroupSeparator", "setGroupSeparator", "build", "Lkotlin/text/HexFormat$BytesHexFormat;", "build$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Builder {
            @NotNull
            private String bytePrefix;
            @NotNull
            private String byteSeparator;
            @NotNull
            private String byteSuffix;
            private int bytesPerGroup;
            private int bytesPerLine;
            @NotNull
            private String groupSeparator;

            public Builder() {
                Companion companion = BytesHexFormat.Companion;
                this.bytesPerLine = companion.getDefault$kotlin_stdlib().getBytesPerLine();
                this.bytesPerGroup = companion.getDefault$kotlin_stdlib().getBytesPerGroup();
                this.groupSeparator = companion.getDefault$kotlin_stdlib().getGroupSeparator();
                this.byteSeparator = companion.getDefault$kotlin_stdlib().getByteSeparator();
                this.bytePrefix = companion.getDefault$kotlin_stdlib().getBytePrefix();
                this.byteSuffix = companion.getDefault$kotlin_stdlib().getByteSuffix();
            }

            @NotNull
            public final BytesHexFormat build$kotlin_stdlib() {
                return new BytesHexFormat(this.bytesPerLine, this.bytesPerGroup, this.groupSeparator, this.byteSeparator, this.bytePrefix, this.byteSuffix);
            }

            @NotNull
            public final String getBytePrefix() {
                return this.bytePrefix;
            }

            @NotNull
            public final String getByteSeparator() {
                return this.byteSeparator;
            }

            @NotNull
            public final String getByteSuffix() {
                return this.byteSuffix;
            }

            public final int getBytesPerGroup() {
                return this.bytesPerGroup;
            }

            public final int getBytesPerLine() {
                return this.bytesPerLine;
            }

            @NotNull
            public final String getGroupSeparator() {
                return this.groupSeparator;
            }

            public final void setBytePrefix(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
                if (StringsKt.contains$default((CharSequence) str, 10, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, 13, false, 2, (Object) null)) {
                    throw new IllegalArgumentException("LF and CR characters are prohibited in bytePrefix, but was " + str);
                }
                this.bytePrefix = str;
            }

            public final void setByteSeparator(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
                if (StringsKt.contains$default((CharSequence) str, 10, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, 13, false, 2, (Object) null)) {
                    throw new IllegalArgumentException("LF and CR characters are prohibited in byteSeparator, but was " + str);
                }
                this.byteSeparator = str;
            }

            public final void setByteSuffix(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
                if (StringsKt.contains$default((CharSequence) str, 10, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, 13, false, 2, (Object) null)) {
                    throw new IllegalArgumentException("LF and CR characters are prohibited in byteSuffix, but was " + str);
                }
                this.byteSuffix = str;
            }

            public final void setBytesPerGroup(int i) {
                if (i > 0) {
                    this.bytesPerGroup = i;
                    return;
                }
                throw new IllegalArgumentException("Non-positive values are prohibited for bytesPerGroup, but was " + i);
            }

            public final void setBytesPerLine(int i) {
                if (i > 0) {
                    this.bytesPerLine = i;
                    return;
                }
                throw new IllegalArgumentException("Non-positive values are prohibited for bytesPerLine, but was " + i);
            }

            public final void setGroupSeparator(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.groupSeparator = str;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat$Companion;", "", "()V", "Default", "Lkotlin/text/HexFormat$BytesHexFormat;", "getDefault$kotlin_stdlib", "()Lkotlin/text/HexFormat$BytesHexFormat;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final BytesHexFormat getDefault$kotlin_stdlib() {
                return BytesHexFormat.Default;
            }

            private Companion() {
            }
        }

        public BytesHexFormat(int i, int i2, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "groupSeparator");
            Intrinsics.checkNotNullParameter(str2, "byteSeparator");
            Intrinsics.checkNotNullParameter(str3, "bytePrefix");
            Intrinsics.checkNotNullParameter(str4, "byteSuffix");
            this.bytesPerLine = i;
            this.bytesPerGroup = i2;
            this.groupSeparator = str;
            this.byteSeparator = str2;
            this.bytePrefix = str3;
            this.byteSuffix = str4;
        }

        @NotNull
        public final StringBuilder appendOptionsTo$kotlin_stdlib(@NotNull StringBuilder sb, @NotNull String str) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            Intrinsics.checkNotNullParameter(str, "indent");
            sb.append(str);
            sb.append("bytesPerLine = ");
            sb.append(this.bytesPerLine);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(10);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(str);
            sb.append("bytesPerGroup = ");
            sb.append(this.bytesPerGroup);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(10);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(str);
            sb.append("groupSeparator = \"");
            sb.append(this.groupSeparator);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append("\",");
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(10);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(str);
            sb.append("byteSeparator = \"");
            sb.append(this.byteSeparator);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append("\",");
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(10);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(str);
            sb.append("bytePrefix = \"");
            sb.append(this.bytePrefix);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append("\",");
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(10);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(str);
            sb.append("byteSuffix = \"");
            sb.append(this.byteSuffix);
            sb.append("\"");
            return sb;
        }

        @NotNull
        public final String getBytePrefix() {
            return this.bytePrefix;
        }

        @NotNull
        public final String getByteSeparator() {
            return this.byteSeparator;
        }

        @NotNull
        public final String getByteSuffix() {
            return this.byteSuffix;
        }

        public final int getBytesPerGroup() {
            return this.bytesPerGroup;
        }

        public final int getBytesPerLine() {
            return this.bytesPerLine;
        }

        @NotNull
        public final String getGroupSeparator() {
            return this.groupSeparator;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BytesHexFormat(");
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(10);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            StringBuilder appendOptionsTo$kotlin_stdlib = appendOptionsTo$kotlin_stdlib(sb, "    ");
            appendOptionsTo$kotlin_stdlib.append(10);
            Intrinsics.checkNotNullExpressionValue(appendOptionsTo$kotlin_stdlib, "append(...)");
            sb.append(")");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/text/HexFormat$Companion;", "", "()V", "Default", "Lkotlin/text/HexFormat;", "getDefault", "()Lkotlin/text/HexFormat;", "UpperCase", "getUpperCase", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HexFormat getDefault() {
            return HexFormat.Default;
        }

        @NotNull
        public final HexFormat getUpperCase() {
            return HexFormat.UpperCase;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0012J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat;", "", "prefix", "", "suffix", "removeLeadingZeros", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getPrefix", "()Ljava/lang/String;", "getRemoveLeadingZeros", "()Z", "getSuffix", "appendOptionsTo", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "indent", "appendOptionsTo$kotlin_stdlib", "toString", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NumberHexFormat {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        @NotNull
        public static final NumberHexFormat Default = new NumberHexFormat("", "", false);
        @NotNull
        private final String prefix;
        private final boolean removeLeadingZeros;
        @NotNull
        private final String suffix;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0016"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "", "()V", "value", "", "prefix", "getPrefix", "()Ljava/lang/String;", "setPrefix", "(Ljava/lang/String;)V", "removeLeadingZeros", "", "getRemoveLeadingZeros", "()Z", "setRemoveLeadingZeros", "(Z)V", "suffix", "getSuffix", "setSuffix", "build", "Lkotlin/text/HexFormat$NumberHexFormat;", "build$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Builder {
            @NotNull
            private String prefix;
            private boolean removeLeadingZeros;
            @NotNull
            private String suffix;

            public Builder() {
                Companion companion = NumberHexFormat.Companion;
                this.prefix = companion.getDefault$kotlin_stdlib().getPrefix();
                this.suffix = companion.getDefault$kotlin_stdlib().getSuffix();
                this.removeLeadingZeros = companion.getDefault$kotlin_stdlib().getRemoveLeadingZeros();
            }

            @NotNull
            public final NumberHexFormat build$kotlin_stdlib() {
                return new NumberHexFormat(this.prefix, this.suffix, this.removeLeadingZeros);
            }

            @NotNull
            public final String getPrefix() {
                return this.prefix;
            }

            public final boolean getRemoveLeadingZeros() {
                return this.removeLeadingZeros;
            }

            @NotNull
            public final String getSuffix() {
                return this.suffix;
            }

            public final void setPrefix(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
                if (StringsKt.contains$default((CharSequence) str, 10, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, 13, false, 2, (Object) null)) {
                    throw new IllegalArgumentException("LF and CR characters are prohibited in prefix, but was " + str);
                }
                this.prefix = str;
            }

            public final void setRemoveLeadingZeros(boolean z) {
                this.removeLeadingZeros = z;
            }

            public final void setSuffix(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
                if (StringsKt.contains$default((CharSequence) str, 10, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, 13, false, 2, (Object) null)) {
                    throw new IllegalArgumentException("LF and CR characters are prohibited in suffix, but was " + str);
                }
                this.suffix = str;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat$Companion;", "", "()V", "Default", "Lkotlin/text/HexFormat$NumberHexFormat;", "getDefault$kotlin_stdlib", "()Lkotlin/text/HexFormat$NumberHexFormat;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final NumberHexFormat getDefault$kotlin_stdlib() {
                return NumberHexFormat.Default;
            }

            private Companion() {
            }
        }

        public NumberHexFormat(@NotNull String str, @NotNull String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "prefix");
            Intrinsics.checkNotNullParameter(str2, "suffix");
            this.prefix = str;
            this.suffix = str2;
            this.removeLeadingZeros = z;
        }

        @NotNull
        public final StringBuilder appendOptionsTo$kotlin_stdlib(@NotNull StringBuilder sb, @NotNull String str) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            Intrinsics.checkNotNullParameter(str, "indent");
            sb.append(str);
            sb.append("prefix = \"");
            sb.append(this.prefix);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append("\",");
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(10);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(str);
            sb.append("suffix = \"");
            sb.append(this.suffix);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append("\",");
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(10);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(str);
            sb.append("removeLeadingZeros = ");
            sb.append(this.removeLeadingZeros);
            return sb;
        }

        @NotNull
        public final String getPrefix() {
            return this.prefix;
        }

        public final boolean getRemoveLeadingZeros() {
            return this.removeLeadingZeros;
        }

        @NotNull
        public final String getSuffix() {
            return this.suffix;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NumberHexFormat(");
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(10);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            StringBuilder appendOptionsTo$kotlin_stdlib = appendOptionsTo$kotlin_stdlib(sb, "    ");
            appendOptionsTo$kotlin_stdlib.append(10);
            Intrinsics.checkNotNullExpressionValue(appendOptionsTo$kotlin_stdlib, "append(...)");
            sb.append(")");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
    }

    static {
        BytesHexFormat.Companion companion = BytesHexFormat.Companion;
        BytesHexFormat default$kotlin_stdlib = companion.getDefault$kotlin_stdlib();
        NumberHexFormat.Companion companion2 = NumberHexFormat.Companion;
        Default = new HexFormat(false, default$kotlin_stdlib, companion2.getDefault$kotlin_stdlib());
        UpperCase = new HexFormat(true, companion.getDefault$kotlin_stdlib(), companion2.getDefault$kotlin_stdlib());
    }

    public HexFormat(boolean z, @NotNull BytesHexFormat bytesHexFormat, @NotNull NumberHexFormat numberHexFormat) {
        Intrinsics.checkNotNullParameter(bytesHexFormat, "bytes");
        Intrinsics.checkNotNullParameter(numberHexFormat, "number");
        this.upperCase = z;
        this.bytes = bytesHexFormat;
        this.number = numberHexFormat;
    }

    @NotNull
    public final BytesHexFormat getBytes() {
        return this.bytes;
    }

    @NotNull
    public final NumberHexFormat getNumber() {
        return this.number;
    }

    public final boolean getUpperCase() {
        return this.upperCase;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HexFormat(");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append("    upperCase = ");
        sb.append(this.upperCase);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append("    bytes = BytesHexFormat(");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        StringBuilder appendOptionsTo$kotlin_stdlib = this.bytes.appendOptionsTo$kotlin_stdlib(sb, "        ");
        appendOptionsTo$kotlin_stdlib.append(10);
        Intrinsics.checkNotNullExpressionValue(appendOptionsTo$kotlin_stdlib, "append(...)");
        sb.append("    ),");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append("    number = NumberHexFormat(");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        StringBuilder appendOptionsTo$kotlin_stdlib2 = this.number.appendOptionsTo$kotlin_stdlib(sb, "        ");
        appendOptionsTo$kotlin_stdlib2.append(10);
        Intrinsics.checkNotNullExpressionValue(appendOptionsTo$kotlin_stdlib2, "append(...)");
        sb.append("    )");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}

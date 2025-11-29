package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public enum RenderingFormat {
    ;

    public static final class HTML extends RenderingFormat {
        public HTML(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        @NotNull
        public String escape(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "string");
            return StringsKt.replace$default(StringsKt.replace$default(str, "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null);
        }
    }

    public static final class PLAIN extends RenderingFormat {
        public PLAIN(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        @NotNull
        public String escape(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "string");
            return str;
        }
    }

    @NotNull
    public abstract String escape(@NotNull String str);
}

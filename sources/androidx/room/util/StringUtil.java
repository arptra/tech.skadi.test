package androidx.room.util;

import androidx.annotation.RestrictTo;
import com.meizu.common.widget.MzContactsContract;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nStringUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringUtil.kt\nandroidx/room/util/StringUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n1603#2,9:87\n1855#2:96\n1856#2:98\n1612#2:99\n1#3:97\n*S KotlinDebug\n*F\n+ 1 StringUtil.kt\nandroidx/room/util/StringUtil\n*L\n66#1:87,9\n66#1:96\n66#1:98\n66#1:99\n66#1:97\n*E\n"})
@RestrictTo
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\"\"\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0006X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u000b\u0012\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Ljava/lang/StringBuilder;", "b", "()Ljava/lang/StringBuilder;", "builder", "", "count", "", "a", "(Ljava/lang/StringBuilder;I)V", "", "", "[Ljava/lang/String;", "getEMPTY_STRING_ARRAY$annotations", "()V", "EMPTY_STRING_ARRAY", "room-runtime_release"}, k = 2, mv = {1, 8, 0})
@JvmName(name = "StringUtil")
public final class StringUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f1768a = new String[0];

    public static final void a(StringBuilder sb, int i) {
        Intrinsics.checkNotNullParameter(sb, "builder");
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("?");
            if (i2 < i - 1) {
                sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
            }
        }
    }

    public static final StringBuilder b() {
        return new StringBuilder();
    }
}

package androidx.navigation;

import android.os.Bundle;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.relay.api.IntentKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ \u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"androidx/navigation/NavType$Companion$IntType$1", "Landroidx/navigation/NavType;", "", "Landroid/os/Bundle;", "bundle", "", "key", "value", "", "i", "(Landroid/os/Bundle;Ljava/lang/String;I)V", "g", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Integer;", "h", "(Ljava/lang/String;)Ljava/lang/Integer;", "b", "()Ljava/lang/String;", "name", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
public final class NavType$Companion$IntType$1 extends NavType<Integer> {
    public NavType$Companion$IntType$1() {
        super(false);
    }

    public String b() {
        return "integer";
    }

    public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Object obj) {
        i(bundle, str, ((Number) obj).intValue());
    }

    /* renamed from: g */
    public Integer a(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Object obj = bundle.get(str);
        if (obj != null) {
            return (Integer) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* renamed from: h */
    public Integer e(String str) {
        int i;
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        if (StringsKt.startsWith$default(str, "0x", false, 2, (Object) null)) {
            String substring = str.substring(2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            i = Integer.parseInt(substring, CharsKt.checkRadix(16));
        } else {
            i = Integer.parseInt(str);
        }
        return Integer.valueOf(i);
    }

    public void i(Bundle bundle, String str, int i) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        bundle.putInt(str, i);
    }
}

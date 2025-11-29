package androidx.navigation;

import android.os.Bundle;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.relay.api.IntentKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.BooleanUtils;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"androidx/navigation/NavType$Companion$BoolType$1", "Landroidx/navigation/NavType;", "", "Landroid/os/Bundle;", "bundle", "", "key", "value", "", "i", "(Landroid/os/Bundle;Ljava/lang/String;Z)V", "g", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Boolean;", "h", "(Ljava/lang/String;)Ljava/lang/Boolean;", "b", "()Ljava/lang/String;", "name", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
public final class NavType$Companion$BoolType$1 extends NavType<Boolean> {
    public NavType$Companion$BoolType$1() {
        super(false);
    }

    public String b() {
        return "boolean";
    }

    public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Object obj) {
        i(bundle, str, ((Boolean) obj).booleanValue());
    }

    /* renamed from: g */
    public Boolean a(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        return (Boolean) bundle.get(str);
    }

    /* renamed from: h */
    public Boolean e(String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        if (Intrinsics.areEqual((Object) str, (Object) BooleanUtils.TRUE)) {
            z = true;
        } else if (Intrinsics.areEqual((Object) str, (Object) BooleanUtils.FALSE)) {
            z = false;
        } else {
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }
        return Boolean.valueOf(z);
    }

    public void i(Bundle bundle, String str, boolean z) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        bundle.putBoolean(str, z);
    }
}

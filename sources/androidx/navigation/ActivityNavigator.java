package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import com.upuphone.runasone.uupcast.CaptureType;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001f !B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Landroidx/navigation/ActivityNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/ActivityNavigator$Destination;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "l", "()Landroidx/navigation/ActivityNavigator$Destination;", "", "k", "()Z", "destination", "Landroid/os/Bundle;", "args", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "Landroidx/navigation/NavDestination;", "m", "(Landroidx/navigation/ActivityNavigator$Destination;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Landroidx/navigation/NavDestination;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", "hostActivity", "e", "Companion", "Destination", "Extras", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
@Navigator.Name("activity")
public class ActivityNavigator extends Navigator<Destination> {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public final Context c;
    public final Activity d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Landroidx/navigation/ActivityNavigator$Companion;", "", "<init>", "()V", "", "EXTRA_NAV_CURRENT", "Ljava/lang/String;", "EXTRA_NAV_SOURCE", "EXTRA_POP_ENTER_ANIM", "EXTRA_POP_EXIT_ANIM", "LOG_TAG", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0012\u0010\tJ\u0017\u0010\u0015\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0018\u0010\tJ\u0017\u0010\u001b\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R(\u0010/\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8\u0006@BX\u000e¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010\u00068\u0006@BX\u000e¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010!R(\u00103\u001a\u0004\u0018\u00010\u00132\b\u0010*\u001a\u0004\u0018\u00010\u00138F@BX\u000e¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R(\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010\u00068F@BX\u000e¢\u0006\f\n\u0004\b\u0017\u00101\u001a\u0004\b7\u0010!¨\u00068"}, d2 = {"Landroidx/navigation/ActivityNavigator$Destination;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/Navigator;", "activityNavigator", "<init>", "(Landroidx/navigation/Navigator;)V", "", "dataPattern", "E", "(Ljava/lang/String;)Landroidx/navigation/ActivityNavigator$Destination;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "q", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "packageName", "F", "Landroid/content/ComponentName;", "name", "C", "(Landroid/content/ComponentName;)Landroidx/navigation/ActivityNavigator$Destination;", "action", "B", "Landroid/net/Uri;", "data", "D", "(Landroid/net/Uri;)Landroidx/navigation/ActivityNavigator$Destination;", "", "w", "()Z", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroid/content/Intent;", "<set-?>", "l", "Landroid/content/Intent;", "A", "()Landroid/content/Intent;", "intent", "m", "Ljava/lang/String;", "z", "component", "Landroid/content/ComponentName;", "y", "()Landroid/content/ComponentName;", "x", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
    @NavDestination.ClassType
    public static class Destination extends NavDestination {
        public Intent l;
        public String m;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Destination(Navigator navigator) {
            super(navigator);
            Intrinsics.checkNotNullParameter(navigator, "activityNavigator");
        }

        public final Intent A() {
            return this.l;
        }

        public final Destination B(String str) {
            if (this.l == null) {
                this.l = new Intent();
            }
            Intent intent = this.l;
            Intrinsics.checkNotNull(intent);
            intent.setAction(str);
            return this;
        }

        public final Destination C(ComponentName componentName) {
            if (this.l == null) {
                this.l = new Intent();
            }
            Intent intent = this.l;
            Intrinsics.checkNotNull(intent);
            intent.setComponent(componentName);
            return this;
        }

        public final Destination D(Uri uri) {
            if (this.l == null) {
                this.l = new Intent();
            }
            Intent intent = this.l;
            Intrinsics.checkNotNull(intent);
            intent.setData(uri);
            return this;
        }

        public final Destination E(String str) {
            this.m = str;
            return this;
        }

        public final Destination F(String str) {
            if (this.l == null) {
                this.l = new Intent();
            }
            Intent intent = this.l;
            Intrinsics.checkNotNull(intent);
            intent.setPackage(str);
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Destination) || !super.equals(obj)) {
                return false;
            }
            Intent intent = this.l;
            Boolean valueOf = intent == null ? null : Boolean.valueOf(intent.filterEquals(((Destination) obj).l));
            return (valueOf == null ? ((Destination) obj).l == null : valueOf.booleanValue()) && Intrinsics.areEqual((Object) this.m, (Object) ((Destination) obj).m);
        }

        public int hashCode() {
            int hashCode = super.hashCode() * 31;
            Intent intent = this.l;
            int i = 0;
            int filterHashCode = (hashCode + (intent == null ? 0 : intent.filterHashCode())) * 31;
            String str = this.m;
            if (str != null) {
                i = str.hashCode();
            }
            return filterHashCode + i;
        }

        public void q(Context context, AttributeSet attributeSet) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            super.q(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.ActivityNavigator);
            Intrinsics.checkNotNullExpressionValue(obtainAttributes, "context.resources.obtain…tyNavigator\n            )");
            String string = obtainAttributes.getString(R.styleable.ActivityNavigator_targetPackage);
            if (string != null) {
                String packageName = context.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
                string = StringsKt.replace$default(string, "${applicationId}", packageName, false, 4, (Object) null);
            }
            F(string);
            String string2 = obtainAttributes.getString(R.styleable.ActivityNavigator_android_name);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = Intrinsics.stringPlus(context.getPackageName(), string2);
                }
                C(new ComponentName(context, string2));
            }
            B(obtainAttributes.getString(R.styleable.ActivityNavigator_action));
            String string3 = obtainAttributes.getString(R.styleable.ActivityNavigator_data);
            if (string3 != null) {
                D(Uri.parse(string3));
            }
            E(obtainAttributes.getString(R.styleable.ActivityNavigator_dataPattern));
            obtainAttributes.recycle();
        }

        public String toString() {
            ComponentName y = y();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (y != null) {
                sb.append(" class=");
                sb.append(y.getClassName());
            } else {
                String x = x();
                if (x != null) {
                    sb.append(" action=");
                    sb.append(x);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            return sb2;
        }

        public boolean w() {
            return false;
        }

        public final String x() {
            Intent intent = this.l;
            if (intent == null) {
                return null;
            }
            return intent.getAction();
        }

        public final ComponentName y() {
            Intent intent = this.l;
            if (intent == null) {
                return null;
            }
            return intent.getComponent();
        }

        public final String z() {
            return this.m;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n¨\u0006\r"}, d2 = {"Landroidx/navigation/ActivityNavigator$Extras;", "Landroidx/navigation/Navigator$Extras;", "", "a", "I", "b", "()I", "flags", "Landroidx/core/app/ActivityOptionsCompat;", "Landroidx/core/app/ActivityOptionsCompat;", "()Landroidx/core/app/ActivityOptionsCompat;", "activityOptions", "Builder", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
    public static final class Extras implements Navigator.Extras {

        /* renamed from: a  reason: collision with root package name */
        public final int f1465a;
        public final ActivityOptionsCompat b;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/navigation/ActivityNavigator$Extras$Builder;", "", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
        public static final class Builder {
        }

        public final ActivityOptionsCompat a() {
            return this.b;
        }

        public final int b() {
            return this.f1465a;
        }
    }

    public ActivityNavigator(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = context;
        Iterator it = SequencesKt.generateSequence(context, ActivityNavigator$hostActivity$1.INSTANCE).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Context) obj) instanceof Activity) {
                break;
            }
        }
        this.d = (Activity) obj;
    }

    public boolean k() {
        Activity activity = this.d;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    /* renamed from: l */
    public Destination a() {
        return new Destination(this);
    }

    /* renamed from: m */
    public NavDestination d(Destination destination, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        Intent intent;
        int intExtra;
        Intrinsics.checkNotNullParameter(destination, RtspHeaders.Values.DESTINATION);
        if (destination.A() != null) {
            Intent intent2 = new Intent(destination.A());
            if (bundle != null) {
                intent2.putExtras(bundle);
                String z = destination.z();
                if (!(z == null || z.length() == 0)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(z);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            stringBuffer.append(Uri.encode(String.valueOf(bundle.get(group))));
                        } else {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + z);
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            boolean z2 = extras instanceof Extras;
            if (z2) {
                intent2.addFlags(((Extras) extras).b());
            }
            if (this.d == null) {
                intent2.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            }
            if (navOptions != null && navOptions.g()) {
                intent2.addFlags(536870912);
            }
            Activity activity = this.d;
            if (!(activity == null || (intent = activity.getIntent()) == null || (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) == 0)) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
            }
            intent2.putExtra("android-support-navigation:ActivityNavigator:current", destination.k());
            Resources resources = this.c.getResources();
            if (navOptions != null) {
                int c2 = navOptions.c();
                int d2 = navOptions.d();
                if ((c2 <= 0 || !Intrinsics.areEqual((Object) resources.getResourceTypeName(c2), (Object) "animator")) && (d2 <= 0 || !Intrinsics.areEqual((Object) resources.getResourceTypeName(d2), (Object) "animator"))) {
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", c2);
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", d2);
                } else {
                    Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(c2) + " and popExit resource " + resources.getResourceName(d2) + " when launching " + destination);
                }
            }
            if (z2) {
                ActivityOptionsCompat a2 = ((Extras) extras).a();
                if (a2 != null) {
                    ContextCompat.startActivity(this.c, intent2, a2.b());
                } else {
                    this.c.startActivity(intent2);
                }
            } else {
                this.c.startActivity(intent2);
            }
            if (navOptions == null || this.d == null) {
                return null;
            }
            int a3 = navOptions.a();
            int b = navOptions.b();
            if ((a3 > 0 && Intrinsics.areEqual((Object) resources.getResourceTypeName(a3), (Object) "animator")) || (b > 0 && Intrinsics.areEqual((Object) resources.getResourceTypeName(b), (Object) "animator"))) {
                Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(a3) + " and exit resource " + resources.getResourceName(b) + "when launching " + destination);
                return null;
            } else if (a3 < 0 && b < 0) {
                return null;
            } else {
                this.d.overridePendingTransition(RangesKt.coerceAtLeast(a3, 0), RangesKt.coerceAtLeast(b, 0));
                return null;
            }
        } else {
            throw new IllegalStateException(("Destination " + destination.k() + " does not have an Intent set.").toString());
        }
    }
}

package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavOptions;
import androidx.navigation.common.R;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 $2\u00020\u0001:\u0001(B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010 \u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b \u0010!J'\u0010\"\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010#J7\u0010$\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010&R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010'¨\u0006)"}, d2 = {"Landroidx/navigation/NavInflater;", "", "Landroid/content/Context;", "context", "Landroidx/navigation/NavigatorProvider;", "navigatorProvider", "<init>", "(Landroid/content/Context;Landroidx/navigation/NavigatorProvider;)V", "", "graphResId", "Landroidx/navigation/NavGraph;", "b", "(I)Landroidx/navigation/NavGraph;", "Landroid/content/res/Resources;", "res", "Landroid/content/res/XmlResourceParser;", "parser", "Landroid/util/AttributeSet;", "attrs", "Landroidx/navigation/NavDestination;", "a", "(Landroid/content/res/Resources;Landroid/content/res/XmlResourceParser;Landroid/util/AttributeSet;I)Landroidx/navigation/NavDestination;", "dest", "", "f", "(Landroid/content/res/Resources;Landroidx/navigation/NavDestination;Landroid/util/AttributeSet;I)V", "Landroid/os/Bundle;", "bundle", "e", "(Landroid/content/res/Resources;Landroid/os/Bundle;Landroid/util/AttributeSet;I)V", "Landroid/content/res/TypedArray;", "Landroidx/navigation/NavArgument;", "d", "(Landroid/content/res/TypedArray;Landroid/content/res/Resources;I)Landroidx/navigation/NavArgument;", "g", "(Landroid/content/res/Resources;Landroidx/navigation/NavDestination;Landroid/util/AttributeSet;)V", "c", "(Landroid/content/res/Resources;Landroidx/navigation/NavDestination;Landroid/util/AttributeSet;Landroid/content/res/XmlResourceParser;I)V", "Landroid/content/Context;", "Landroidx/navigation/NavigatorProvider;", "Companion", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
public final class NavInflater {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);
    public static final ThreadLocal d = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    public final Context f1488a;
    public final NavigatorProvider b;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\tH\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\t8\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/navigation/NavInflater$Companion;", "", "<init>", "()V", "Landroid/util/TypedValue;", "value", "Landroidx/navigation/NavType;", "navType", "expectedNavType", "", "argType", "foundType", "a", "(Landroid/util/TypedValue;Landroidx/navigation/NavType;Landroidx/navigation/NavType;Ljava/lang/String;Ljava/lang/String;)Landroidx/navigation/NavType;", "APPLICATION_ID_PLACEHOLDER", "Ljava/lang/String;", "TAG_ACTION", "TAG_ARGUMENT", "TAG_DEEP_LINK", "TAG_INCLUDE", "Ljava/lang/ThreadLocal;", "sTmpValue", "Ljava/lang/ThreadLocal;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavType a(TypedValue typedValue, NavType navType, NavType navType2, String str, String str2) {
            Intrinsics.checkNotNullParameter(typedValue, AccountConstantKt.RESPONSE_VALUE);
            Intrinsics.checkNotNullParameter(navType2, "expectedNavType");
            Intrinsics.checkNotNullParameter(str2, "foundType");
            if (navType == null || navType == navType2) {
                return navType == null ? navType2 : navType;
            }
            throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
        }

        public Companion() {
        }
    }

    public NavInflater(Context context, NavigatorProvider navigatorProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        this.f1488a = context;
        this.b = navigatorProvider;
    }

    public final NavDestination a(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i) {
        int depth;
        NavigatorProvider navigatorProvider = this.b;
        String name = xmlResourceParser.getName();
        Intrinsics.checkNotNullExpressionValue(name, "parser.name");
        NavDestination a2 = navigatorProvider.d(name).a();
        a2.q(this.f1488a, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                return a2;
            }
            if (next == 2 && depth <= depth2) {
                String name2 = xmlResourceParser.getName();
                if (Intrinsics.areEqual((Object) "argument", (Object) name2)) {
                    f(resources, a2, attributeSet, i);
                } else if (Intrinsics.areEqual((Object) "deepLink", (Object) name2)) {
                    g(resources, a2, attributeSet);
                } else if (Intrinsics.areEqual((Object) WebJs.ACTION, (Object) name2)) {
                    c(resources, a2, attributeSet, xmlResourceParser, i);
                } else if (Intrinsics.areEqual((Object) "include", (Object) name2) && (a2 instanceof NavGraph)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavInclude);
                    Intrinsics.checkNotNullExpressionValue(obtainAttributes, "res.obtainAttributes(att…n.R.styleable.NavInclude)");
                    ((NavGraph) a2).x(b(obtainAttributes.getResourceId(R.styleable.NavInclude_graph, 0)));
                    Unit unit = Unit.INSTANCE;
                    obtainAttributes.recycle();
                } else if (a2 instanceof NavGraph) {
                    ((NavGraph) a2).x(a(resources, xmlResourceParser, attributeSet, i));
                }
            }
        }
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0060 A[Catch:{ Exception -> 0x003e, all -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0020 A[Catch:{ Exception -> 0x003e, all -> 0x003c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.navigation.NavGraph b(int r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f1488a
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.XmlResourceParser r1 = r0.getXml(r7)
            java.lang.String r2 = "res.getXml(graphResId)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r1)
        L_0x0013:
            int r3 = r1.next()     // Catch:{ Exception -> 0x003e }
            r4 = 2
            if (r3 == r4) goto L_0x001e
            r5 = 1
            if (r3 == r5) goto L_0x001e
            goto L_0x0013
        L_0x001e:
            if (r3 != r4) goto L_0x0060
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x003e }
            java.lang.String r4 = "res"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ Exception -> 0x003e }
            java.lang.String r4 = "attrs"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ Exception -> 0x003e }
            androidx.navigation.NavDestination r6 = r6.a(r0, r1, r2, r7)     // Catch:{ Exception -> 0x003e }
            boolean r2 = r6 instanceof androidx.navigation.NavGraph     // Catch:{ Exception -> 0x003e }
            if (r2 == 0) goto L_0x0040
            androidx.navigation.NavGraph r6 = (androidx.navigation.NavGraph) r6     // Catch:{ Exception -> 0x003e }
            r1.close()
            return r6
        L_0x003c:
            r6 = move-exception
            goto L_0x008f
        L_0x003e:
            r6 = move-exception
            goto L_0x0068
        L_0x0040:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003e }
            r6.<init>()     // Catch:{ Exception -> 0x003e }
            java.lang.String r2 = "Root element <"
            r6.append(r2)     // Catch:{ Exception -> 0x003e }
            r6.append(r3)     // Catch:{ Exception -> 0x003e }
            java.lang.String r2 = "> did not inflate into a NavGraph"
            r6.append(r2)     // Catch:{ Exception -> 0x003e }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x003e }
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x003e }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x003e }
            r2.<init>(r6)     // Catch:{ Exception -> 0x003e }
            throw r2     // Catch:{ Exception -> 0x003e }
        L_0x0060:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x003e }
            java.lang.String r2 = "No start tag found"
            r6.<init>(r2)     // Catch:{ Exception -> 0x003e }
            throw r6     // Catch:{ Exception -> 0x003e }
        L_0x0068:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x003c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003c }
            r3.<init>()     // Catch:{ all -> 0x003c }
            java.lang.String r4 = "Exception inflating "
            r3.append(r4)     // Catch:{ all -> 0x003c }
            java.lang.String r7 = r0.getResourceName(r7)     // Catch:{ all -> 0x003c }
            r3.append(r7)     // Catch:{ all -> 0x003c }
            java.lang.String r7 = " line "
            r3.append(r7)     // Catch:{ all -> 0x003c }
            int r7 = r1.getLineNumber()     // Catch:{ all -> 0x003c }
            r3.append(r7)     // Catch:{ all -> 0x003c }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x003c }
            r2.<init>(r7, r6)     // Catch:{ all -> 0x003c }
            throw r2     // Catch:{ all -> 0x003c }
        L_0x008f:
            r1.close()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavInflater.b(int):androidx.navigation.NavGraph");
    }

    public final void c(Resources resources, NavDestination navDestination, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i) {
        int depth;
        Context context = this.f1488a;
        int[] iArr = R.styleable.NavAction;
        Intrinsics.checkNotNullExpressionValue(iArr, "NavAction");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.NavAction_android_id, 0);
        NavAction navAction = new NavAction(obtainStyledAttributes.getResourceId(R.styleable.NavAction_destination, 0), (NavOptions) null, (Bundle) null, 6, (DefaultConstructorMarker) null);
        NavOptions.Builder builder = new NavOptions.Builder();
        builder.d(obtainStyledAttributes.getBoolean(R.styleable.NavAction_launchSingleTop, false));
        builder.j(obtainStyledAttributes.getBoolean(R.styleable.NavAction_restoreState, false));
        builder.g(obtainStyledAttributes.getResourceId(R.styleable.NavAction_popUpTo, -1), obtainStyledAttributes.getBoolean(R.styleable.NavAction_popUpToInclusive, false), obtainStyledAttributes.getBoolean(R.styleable.NavAction_popUpToSaveState, false));
        builder.b(obtainStyledAttributes.getResourceId(R.styleable.NavAction_enterAnim, -1));
        builder.c(obtainStyledAttributes.getResourceId(R.styleable.NavAction_exitAnim, -1));
        builder.e(obtainStyledAttributes.getResourceId(R.styleable.NavAction_popEnterAnim, -1));
        builder.f(obtainStyledAttributes.getResourceId(R.styleable.NavAction_popExitAnim, -1));
        navAction.e(builder.a());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next != 1 && ((depth = xmlResourceParser.getDepth()) >= depth2 || next != 3)) {
                if (next == 2 && depth <= depth2 && Intrinsics.areEqual((Object) "argument", (Object) xmlResourceParser.getName())) {
                    e(resources, bundle, attributeSet, i);
                }
            }
        }
        if (!bundle.isEmpty()) {
            navAction.d(bundle);
        }
        navDestination.r(resourceId, navAction);
        obtainStyledAttributes.recycle();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.navigation.NavArgument d(android.content.res.TypedArray r10, android.content.res.Resources r11, int r12) {
        /*
            r9 = this;
            androidx.navigation.NavArgument$Builder r9 = new androidx.navigation.NavArgument$Builder
            r9.<init>()
            int r0 = androidx.navigation.common.R.styleable.NavArgument_nullable
            r1 = 0
            boolean r0 = r10.getBoolean(r0, r1)
            r9.c(r0)
            java.lang.ThreadLocal r0 = d
            java.lang.Object r2 = r0.get()
            android.util.TypedValue r2 = (android.util.TypedValue) r2
            if (r2 != 0) goto L_0x0021
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            r0.set(r2)
        L_0x0021:
            int r0 = androidx.navigation.common.R.styleable.NavArgument_argType
            java.lang.String r7 = r10.getString(r0)
            r0 = 0
            if (r7 == 0) goto L_0x0036
            androidx.navigation.NavType$Companion r3 = androidx.navigation.NavType.c
            java.lang.String r12 = r11.getResourcePackageName(r12)
            androidx.navigation.NavType r12 = com.honey.account.y.b.a(r3, r7, r12)
            r5 = r12
            goto L_0x0037
        L_0x0036:
            r5 = r0
        L_0x0037:
            int r12 = androidx.navigation.common.R.styleable.NavArgument_android_defaultValue
            boolean r12 = r10.getValue(r12, r2)
            if (r12 == 0) goto L_0x0171
            androidx.navigation.NavType r12 = androidx.navigation.NavType.e
            java.lang.String r0 = "' for "
            java.lang.String r3 = "unsupported value '"
            r4 = 16
            if (r5 != r12) goto L_0x0083
            int r10 = r2.resourceId
            if (r10 == 0) goto L_0x004f
            r1 = r10
            goto L_0x0057
        L_0x004f:
            int r10 = r2.type
            if (r10 != r4) goto L_0x005d
            int r10 = r2.data
            if (r10 != 0) goto L_0x005d
        L_0x0057:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            goto L_0x0171
        L_0x005d:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r3)
            java.lang.CharSequence r11 = r2.string
            r10.append(r11)
            r10.append(r0)
            java.lang.String r11 = r5.b()
            r10.append(r11)
            java.lang.String r11 = ". Must be a reference to a resource."
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0083:
            int r6 = r2.resourceId
            if (r6 == 0) goto L_0x00c2
            if (r5 != 0) goto L_0x0090
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            r5 = r12
            goto L_0x0171
        L_0x0090:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r3)
            java.lang.CharSequence r11 = r2.string
            r10.append(r11)
            r10.append(r0)
            java.lang.String r11 = r5.b()
            r10.append(r11)
            java.lang.String r11 = ". You must use a \""
            r10.append(r11)
            java.lang.String r11 = r12.b()
            r10.append(r11)
            java.lang.String r11 = "\" type to reference other resources."
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x00c2:
            androidx.navigation.NavType r12 = androidx.navigation.NavType.m
            if (r5 != r12) goto L_0x00ce
            int r11 = androidx.navigation.common.R.styleable.NavArgument_android_defaultValue
            java.lang.String r0 = r10.getString(r11)
            goto L_0x0171
        L_0x00ce:
            int r10 = r2.type
            r12 = 3
            if (r10 == r12) goto L_0x015f
            r12 = 4
            if (r10 == r12) goto L_0x014b
            r12 = 5
            if (r10 == r12) goto L_0x0132
            r11 = 18
            if (r10 == r11) goto L_0x011d
            if (r10 < r4) goto L_0x010b
            r11 = 31
            if (r10 > r11) goto L_0x010b
            androidx.navigation.NavType r6 = androidx.navigation.NavType.i
            if (r5 != r6) goto L_0x00f9
            androidx.navigation.NavInflater$Companion r3 = c
            java.lang.String r8 = "float"
            r4 = r2
            androidx.navigation.NavType r5 = r3.a(r4, r5, r6, r7, r8)
            int r10 = r2.data
            float r10 = (float) r10
            java.lang.Float r0 = java.lang.Float.valueOf(r10)
            goto L_0x0171
        L_0x00f9:
            androidx.navigation.NavInflater$Companion r3 = c
            androidx.navigation.NavType r6 = androidx.navigation.NavType.d
            java.lang.String r8 = "integer"
            r4 = r2
            androidx.navigation.NavType r5 = r3.a(r4, r5, r6, r7, r8)
            int r10 = r2.data
            java.lang.Integer r0 = java.lang.Integer.valueOf(r10)
            goto L_0x0171
        L_0x010b:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            int r10 = r2.type
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r11 = "unsupported argument type "
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r10)
            r9.<init>(r10)
            throw r9
        L_0x011d:
            androidx.navigation.NavInflater$Companion r3 = c
            androidx.navigation.NavType r6 = androidx.navigation.NavType.k
            java.lang.String r8 = "boolean"
            r4 = r2
            androidx.navigation.NavType r5 = r3.a(r4, r5, r6, r7, r8)
            int r10 = r2.data
            if (r10 == 0) goto L_0x012d
            r1 = 1
        L_0x012d:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            goto L_0x0171
        L_0x0132:
            androidx.navigation.NavInflater$Companion r3 = c
            androidx.navigation.NavType r6 = androidx.navigation.NavType.d
            java.lang.String r8 = "dimension"
            r4 = r2
            androidx.navigation.NavType r5 = r3.a(r4, r5, r6, r7, r8)
            android.util.DisplayMetrics r10 = r11.getDisplayMetrics()
            float r10 = r2.getDimension(r10)
            int r10 = (int) r10
            java.lang.Integer r0 = java.lang.Integer.valueOf(r10)
            goto L_0x0171
        L_0x014b:
            androidx.navigation.NavInflater$Companion r3 = c
            androidx.navigation.NavType r6 = androidx.navigation.NavType.i
            java.lang.String r8 = "float"
            r4 = r2
            androidx.navigation.NavType r5 = r3.a(r4, r5, r6, r7, r8)
            float r10 = r2.getFloat()
            java.lang.Float r0 = java.lang.Float.valueOf(r10)
            goto L_0x0171
        L_0x015f:
            java.lang.CharSequence r10 = r2.string
            java.lang.String r10 = r10.toString()
            if (r5 != 0) goto L_0x016d
            androidx.navigation.NavType$Companion r11 = androidx.navigation.NavType.c
            androidx.navigation.NavType r5 = r11.b(r10)
        L_0x016d:
            java.lang.Object r0 = r5.e(r10)
        L_0x0171:
            if (r0 == 0) goto L_0x0176
            r9.b(r0)
        L_0x0176:
            if (r5 == 0) goto L_0x017b
            r9.d(r5)
        L_0x017b:
            androidx.navigation.NavArgument r9 = r9.a()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavInflater.d(android.content.res.TypedArray, android.content.res.Resources, int):androidx.navigation.NavArgument");
    }

    public final void e(Resources resources, Bundle bundle, AttributeSet attributeSet, int i) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavArgument);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "res.obtainAttributes(att… R.styleable.NavArgument)");
        String string = obtainAttributes.getString(R.styleable.NavArgument_android_name);
        if (string != null) {
            NavArgument d2 = d(obtainAttributes, resources, i);
            if (d2.b()) {
                d2.d(string, bundle);
            }
            Unit unit = Unit.INSTANCE;
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    public final void f(Resources resources, NavDestination navDestination, AttributeSet attributeSet, int i) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavArgument);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "res.obtainAttributes(att… R.styleable.NavArgument)");
        String string = obtainAttributes.getString(R.styleable.NavArgument_android_name);
        if (string != null) {
            navDestination.a(string, d(obtainAttributes, resources, i));
            Unit unit = Unit.INSTANCE;
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    public final void g(Resources resources, NavDestination navDestination, AttributeSet attributeSet) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavDeepLink);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "res.obtainAttributes(att… R.styleable.NavDeepLink)");
        String string = obtainAttributes.getString(R.styleable.NavDeepLink_uri);
        String string2 = obtainAttributes.getString(R.styleable.NavDeepLink_action);
        String string3 = obtainAttributes.getString(R.styleable.NavDeepLink_mimeType);
        if ((string == null || string.length() == 0) && ((string2 == null || string2.length() == 0) && (string3 == null || string3.length() == 0))) {
            throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
        }
        NavDeepLink.Builder builder = new NavDeepLink.Builder();
        if (string != null) {
            String packageName = this.f1488a.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
            builder.d(StringsKt.replace$default(string, "${applicationId}", packageName, false, 4, (Object) null));
        }
        if (!(string2 == null || string2.length() == 0)) {
            String packageName2 = this.f1488a.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName2, "context.packageName");
            builder.b(StringsKt.replace$default(string2, "${applicationId}", packageName2, false, 4, (Object) null));
        }
        if (string3 != null) {
            String packageName3 = this.f1488a.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName3, "context.packageName");
            builder.c(StringsKt.replace$default(string3, "${applicationId}", packageName3, false, 4, (Object) null));
        }
        navDestination.b(builder.a());
        Unit unit = Unit.INSTANCE;
        obtainAttributes.recycle();
    }
}

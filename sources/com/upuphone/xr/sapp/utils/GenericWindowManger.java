package com.upuphone.xr.sapp.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.view.SuperGenericWindowView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 >2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJm\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00012\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00152\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u001aJw\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00012\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00152\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0004¢\u0006\u0004\b#\u0010\u0003J\u001d\u0010%\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0001¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0011¢\u0006\u0004\b(\u0010\"J\u0001\u0010/\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)2\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122&\u0010,\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00152\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100JU\u00103\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)2\u0006\u00101\u001a\u00020\u00112\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b3\u00104Jq\u00105\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00012\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00152\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b5\u00106R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0006078\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lcom/upuphone/xr/sapp/utils/GenericWindowManger;", "", "<init>", "()V", "", "h", "Lcom/upuphone/xr/sapp/view/SuperGenericWindowView;", "view", "l", "(Lcom/upuphone/xr/sapp/view/SuperGenericWindowView;)V", "", "s", "()Z", "Landroid/content/Context;", "context", "window", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "windowType", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mExtras", "touchOutsideDismiss", "backKeyDismiss", "f", "(Landroid/content/Context;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/HashMap;ZZ)V", "Landroid/os/Bundle;", "bundle", "g", "(Landroid/content/Context;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/HashMap;ZZLandroid/os/Bundle;)V", "k", "(I)Z", "j", "(I)V", "i", "data", "r", "(ILjava/lang/Object;)Z", "height", "m", "Landroid/app/Activity;", "activity", "notices", "extras", "Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;", "callback", "o", "(Landroid/app/Activity;Ljava/util/ArrayList;Ljava/util/HashMap;ZZLandroid/os/Bundle;Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;)V", "type", "extra", "n", "(Landroid/app/Activity;ILjava/lang/Object;ZZLandroid/os/Bundle;Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;)V", "p", "(Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/HashMap;ZZLandroid/os/Bundle;)V", "", "a", "Ljava/util/List;", "mGenericWindowList", "b", "I", "mDismissRetryTime", "c", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGenericWindowManger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GenericWindowManger.kt\ncom/upuphone/xr/sapp/utils/GenericWindowManger\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,662:1\n1855#2,2:663\n1855#2,2:665\n1855#2,2:667\n1855#2,2:669\n1855#2,2:671\n*S KotlinDebug\n*F\n+ 1 GenericWindowManger.kt\ncom/upuphone/xr/sapp/utils/GenericWindowManger\n*L\n389#1:663,2\n447#1:665,2\n492#1:667,2\n504#1:669,2\n582#1:671,2\n*E\n"})
public final class GenericWindowManger {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);
    public static final Lazy d = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, GenericWindowManger$Companion$instance$2.INSTANCE);
    public static final Handler e = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public final List f7886a = new CopyOnWriteArrayList();
    public int b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\br\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR \u0010\u000b\u001a\u00020\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00148\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0012R\u0014\u0010\u001c\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0012R\u0014\u0010\u001d\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u0012R\u0014\u0010\u001e\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u0012R\u0014\u0010\u001f\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u0012R\u0014\u0010 \u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b \u0010\u0012R\u0014\u0010!\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\u0012R\u0014\u0010\"\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\"\u0010\u0012R\u0014\u0010#\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b#\u0010\u0012R\u0014\u0010$\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b$\u0010\u0012R\u0014\u0010%\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b%\u0010\u0012R\u0014\u0010&\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b&\u0010\u0012R\u0014\u0010'\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b'\u0010\u0012R\u0014\u0010(\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b(\u0010\u0012R\u0014\u0010)\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b)\u0010\u0012R\u0014\u0010*\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b*\u0010\u0012R\u0014\u0010+\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b+\u0010\u0012R\u0014\u0010,\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b,\u0010\u0012R\u0014\u0010-\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b-\u0010\u0012R\u0014\u0010.\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b.\u0010\u0012R\u0014\u0010/\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b/\u0010\u0012R\u0014\u00100\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b0\u0010\u0012R\u0014\u00101\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b1\u0010\u0012R\u0014\u00102\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b2\u0010\u0012R\u0014\u00103\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b3\u0010\u0012R\u0014\u00104\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b4\u0010\u0012R\u0014\u00105\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b5\u0010\u0012R\u0014\u00106\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b6\u0010\u0012R\u0014\u00107\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b7\u0010\u0012R\u0014\u00108\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b8\u0010\u0012R\u0014\u00109\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b9\u0010\u0012R\u0014\u0010:\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b:\u0010\u0012R\u0014\u0010;\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b;\u0010\u0012R\u0014\u0010<\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b<\u0010\u0012R\u0014\u0010=\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b=\u0010\u0012R\u0014\u0010>\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b>\u0010\u0012R\u0014\u0010?\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b?\u0010\u0012R\u0014\u0010@\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b@\u0010\u0012R\u0014\u0010A\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bA\u0010\u0012R\u0014\u0010B\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bB\u0010\u0012R\u0014\u0010C\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bC\u0010\u0012R\u0014\u0010D\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bD\u0010\u0012R\u0014\u0010E\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bE\u0010\u0012R\u0014\u0010F\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bF\u0010\u0012R\u0014\u0010G\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bG\u0010\u0012R\u0014\u0010H\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bH\u0010\u0012R\u0014\u0010I\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bI\u0010\u0012R\u0014\u0010J\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bJ\u0010\u0012R\u0014\u0010K\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bK\u0010\u0012R\u0014\u0010L\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bL\u0010\u0012R\u0014\u0010M\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bM\u0010\u0012R\u0014\u0010N\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bN\u0010\u0012R\u0014\u0010O\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bO\u0010\u0012R\u0014\u0010P\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bP\u0010\u0012R\u0014\u0010Q\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bQ\u0010\u0012R\u0014\u0010R\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bR\u0010\u0012R\u0014\u0010S\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bS\u0010\u0012R\u0014\u0010T\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bT\u0010\u0012R\u0014\u0010U\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bU\u0010\u0012R\u0014\u0010V\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bV\u0010\u0012R\u0014\u0010W\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bW\u0010\u0012R\u0014\u0010X\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bX\u0010\u0012R\u0014\u0010Y\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bY\u0010\u0012R\u0014\u0010Z\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bZ\u0010\u0012R\u0014\u0010[\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b[\u0010\u0012R\u0014\u0010\\\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\\\u0010\u0012R\u0014\u0010]\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b]\u0010\u0012R\u0014\u0010^\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b^\u0010\u0012R\u0014\u0010_\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b_\u0010\u0012R\u0014\u0010`\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b`\u0010\u0012R\u0014\u0010a\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\ba\u0010\u0012R\u0014\u0010b\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bb\u0010\u0012R\u0014\u0010c\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bc\u0010\u0012R\u0014\u0010d\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bd\u0010\u0012R\u0014\u0010e\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\be\u0010\u0012R\u0014\u0010f\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bf\u0010\u0012R\u0014\u0010g\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bg\u0010\u0012R\u0014\u0010h\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bh\u0010\u0012R\u0014\u0010i\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bi\u0010\u0012R\u0014\u0010j\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bj\u0010\u0012R\u0014\u0010k\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bk\u0010\u0012R\u0014\u0010l\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bl\u0010\u0012R\u0014\u0010m\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bm\u0010\u0012R\u0014\u0010n\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bn\u0010\u0012R\u0014\u0010o\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bo\u0010\u0012R\u0014\u0010p\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bp\u0010\u0012R\u0014\u0010q\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bq\u0010\u0012R\u0014\u0010r\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\br\u0010\u0012R\u0014\u0010s\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bs\u0010\u0012R\u0014\u0010t\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bt\u0010\u0012R\u0014\u0010u\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bu\u0010\u0012R\u0014\u0010v\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bv\u0010\u0012R\u0014\u0010w\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bw\u0010\u0012R\u0014\u0010x\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bx\u0010\u0012R\u0014\u0010y\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\by\u0010\u0012R\u0014\u0010z\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\bz\u0010\u0012R\u0014\u0010{\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b{\u0010\u0012R\u0014\u0010|\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b|\u0010\u0012R\u0014\u0010}\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b}\u0010\u0012R\u0014\u0010~\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b~\u0010\u0012R\u0014\u0010\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0012R\u0016\u0010\u0001\u001a\u00020\u00108\u0006XT¢\u0006\u0007\n\u0005\b\u0001\u0010\u0012R\u0016\u0010\u0001\u001a\u00020\u00108\u0006XT¢\u0006\u0007\n\u0005\b\u0001\u0010\u0012R\u0016\u0010\u0001\u001a\u00020\u00108\u0006XT¢\u0006\u0007\n\u0005\b\u0001\u0010\u0012R\u0016\u0010\u0001\u001a\u00020\u00108\u0006XT¢\u0006\u0007\n\u0005\b\u0001\u0010\u0012R\u0016\u0010\u0001\u001a\u00020\u00108\u0006XT¢\u0006\u0007\n\u0005\b\u0001\u0010\u0012R\u0016\u0010\u0001\u001a\u00020\u00108\u0006XT¢\u0006\u0007\n\u0005\b\u0001\u0010\u0012¨\u0006\u0001"}, d2 = {"Lcom/upuphone/xr/sapp/utils/GenericWindowManger$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/utils/GenericWindowManger;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/upuphone/xr/sapp/utils/GenericWindowManger;", "instance", "Landroid/os/Handler;", "mDelayHandler", "Landroid/os/Handler;", "b", "()Landroid/os/Handler;", "getMDelayHandler$annotations", "", "ACTION_CANCEL", "I", "ACTION_CONFIRM", "", "TAG", "Ljava/lang/String;", "WINDOW_TYPE_ABANDON_ADJUST_MINI_DESKTOP", "WINDOW_TYPE_ABANDON_ADJUST_SHORTCUT", "WINDOW_TYPE_AIR_MODE_OPEN", "WINDOW_TYPE_APP_LOCATION_FOR_USER", "WINDOW_TYPE_APP_UPDATE", "WINDOW_TYPE_BT", "WINDOW_TYPE_BT_REJECT_TWICE", "WINDOW_TYPE_CALL_CONFIRM", "WINDOW_TYPE_CANCEL_AGREE", "WINDOW_TYPE_CANCEL_AI_ASST_AGREE", "WINDOW_TYPE_CANCEL_AR_NAVI_AGREE", "WINDOW_TYPE_CANCEL_AR_TICI_AGREE", "WINDOW_TYPE_CANCEL_AR_TRAN_AGREE", "WINDOW_TYPE_CHECK_GLASS_UPDATE", "WINDOW_TYPE_CLEAR_DATA", "WINDOW_TYPE_CLEAR_ROLE_VP", "WINDOW_TYPE_CLOSE_HOTSPOT", "WINDOW_TYPE_CLOSE_HUAWEI_HEALTH_SERVICE", "WINDOW_TYPE_CLOSE_SUPER_SERVICE", "WINDOW_TYPE_CLOSE_WIFI_IGNORE_DLNA", "WINDOW_TYPE_COMPRESS_DATA", "WINDOW_TYPE_CONNECT_GLASSES_HELPER", "WINDOW_TYPE_CONNECT_VIEW", "WINDOW_TYPE_CONNECT_WIFI_IGNORE_P2P", "WINDOW_TYPE_DEVICE_CONNECT", "WINDOW_TYPE_DEVICE_CONNECT_OUTER", "WINDOW_TYPE_DEVICE_CONNECT_TYPE_ERROR_FOR_CHINA_APP_GLASS_INTL", "WINDOW_TYPE_DEVICE_CONNECT_TYPE_ERROR_FOR_INTL_APP_GLASS_CHINA", "WINDOW_TYPE_DEVICE_FOUND", "WINDOW_TYPE_DEVICE_MANAGER_UNBIND_AIR_TIP", "WINDOW_TYPE_DEVICE_MANAGER_UNBIND_VIEW_TIP", "WINDOW_TYPE_DEVICE_UNBOUND", "WINDOW_TYPE_DOWNLOADING_APP_UPDATE", "WINDOW_TYPE_ENHANCED_SERVICE_OPEN", "WINDOW_TYPE_FACTORY_RESET", "WINDOW_TYPE_FEEDBACK_SUBMIT_LOADING", "WINDOW_TYPE_FLOAT_PERMISSION", "WINDOW_TYPE_FLYME_PERMISSION_REJECT", "WINDOW_TYPE_GLASS_ERROR_UPDATE_ROM", "WINDOW_TYPE_GLASS_SPACE_NOT_OK", "WINDOW_TYPE_GLASS_STORAGE_NOT_ENOUGH", "WINDOW_TYPE_GLASS_UPDATE_FAIL", "WINDOW_TYPE_GLASS_UPDATE_VERIFY_FAIL", "WINDOW_TYPE_GLASS_UPDATING", "WINDOW_TYPE_GO_PERMISSION_SETTING", "WINDOW_TYPE_IN_NAV_STATE", "WINDOW_TYPE_IN_NAV_STATE_OPEN_TRANSLATION", "WINDOW_TYPE_LISTENER_NOTIFICATION", "WINDOW_TYPE_LOCATION", "WINDOW_TYPE_LOCATION_REJECT_TWICE", "WINDOW_TYPE_MOBILE_NETWORK", "WINDOW_TYPE_MODIFY_GLASS_LAN", "WINDOW_TYPE_MODIFY_GLASS_LAN_LOADING", "WINDOW_TYPE_MODIFY_RING_NAME", "WINDOW_TYPE_MODIFY_VIEW_GLASS_NAME", "WINDOW_TYPE_NETWORK_ERROR", "WINDOW_TYPE_NOTIFICATION", "WINDOW_TYPE_NOTIFY_CONNECT_STATE", "WINDOW_TYPE_NOT_CONNECT_WHEN_UNBIND", "WINDOW_TYPE_NO_INSTALL_QUICK_WORKER", "WINDOW_TYPE_NO_INSTALL_TIKTOK", "WINDOW_TYPE_NO_NETWORK", "WINDOW_TYPE_OPEN_GPS", "WINDOW_TYPE_OPEN_WIFI", "WINDOW_TYPE_PERMISSION_BLUETOOTH", "WINDOW_TYPE_PERMISSION_CALL_READ_PHONE_STATE", "WINDOW_TYPE_PERMISSION_CAMERA", "WINDOW_TYPE_PERMISSION_CONTACT", "WINDOW_TYPE_PERMISSION_DIAL", "WINDOW_TYPE_PERMISSION_FINE_LOCATION", "WINDOW_TYPE_PERMISSION_LOCATION", "WINDOW_TYPE_PERMISSION_NEARBY_WIFI_DEVICES", "WINDOW_TYPE_PERMISSION_NOTIFICATION", "WINDOW_TYPE_PERMISSION_READ_CALENDAR", "WINDOW_TYPE_PERMISSION_READ_CALL", "WINDOW_TYPE_PERMISSION_RECORD_AUDIO", "WINDOW_TYPE_PERMISSION_STORE", "WINDOW_TYPE_PERMISSION_WRITE_READ", "WINDOW_TYPE_PHONE_SPACE_NOT_OK", "WINDOW_TYPE_PHONE_STORAGE_NOT_ENOUGH", "WINDOW_TYPE_PHONE_VERSION_INCOMPATIBLE", "WINDOW_TYPE_PRIVACY_AI_ASST_AGREE", "WINDOW_TYPE_PRIVACY_AR_NAVI_AGREE", "WINDOW_TYPE_PRIVACY_AR_TICI_AGREE", "WINDOW_TYPE_PRIVACY_AR_TRAN_AGREE", "WINDOW_TYPE_QUERY_APP_LOADING", "WINDOW_TYPE_RECORD_MORE_ROLE_VP", "WINDOW_TYPE_REJECT_RECORD_AUDIO", "WINDOW_TYPE_REJECT_TWICE_PERMISSION", "WINDOW_TYPE_REMOVE_DEVICE", "WINDOW_TYPE_REQUEST_IGNORE_BATTERY", "WINDOW_TYPE_REQUEST_UNBOUND_DEVICE", "WINDOW_TYPE_THIRD_PERMISSION_NOTE", "WINDOW_TYPE_THIRD_REMOVE_DEVICE", "WINDOW_TYPE_UNICRON_HOTSPOT_TIPS", "WINDOW_TYPE_UNICRON_NEARBY_DEVICES_TIPS", "WINDOW_TYPE_UNICRON_PERMISSION_TIPS", "WINDOW_TYPE_UNICRON_TRANSFER_TIPS", "WINDOW_TYPE_UNICRON_WIFI_TIPS", "WINDOW_TYPE_UNKNOWN", "WINDOW_TYPE_UPGRADE_PRIVACY_AGREE", "WINDOW_TYPE_USER_AGREEMENT", "WINDOW_TYPE_VIEW_ALWAYS_ALLOW_ACCESS_GLASSES", "WINDOW_TYPE_VIEW_CHECK_GLASS_UPDATE", "WINDOW_TYPE_VIEW_FLOAT_WINDOW_PERMISSION", "WINDOW_TYPE_VIEW_GLASS_UPDATE_FAIL", "WINDOW_TYPE_VIEW_UNABLE_CONNECT", "WINDOW_TYPE_WAKEUP_RECORD_CLEAR", "WINDOW_TYPE_WAKEUP_RECORD_CONFLICT", "WINDOW_TYPE_WIFI_PASSWORD", "WINDOW_TYPE_XR_VERSION_INCOMPATIBLE", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GenericWindowManger a() {
            return (GenericWindowManger) GenericWindowManger.d.getValue();
        }

        public final Handler b() {
            return GenericWindowManger.e;
        }

        public Companion() {
        }
    }

    public static /* synthetic */ void q(GenericWindowManger genericWindowManger, Activity activity, int i, Object obj, boolean z, boolean z2, Bundle bundle, SuperGenericWindowView.IActionCallback iActionCallback, int i2, Object obj2) {
        genericWindowManger.n(activity, i, (i2 & 4) != 0 ? null : obj, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? null : bundle, (i2 & 64) != 0 ? null : iActionCallback);
    }

    public final void f(Context context, Object obj, ArrayList arrayList, HashMap hashMap, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(obj, "window");
        Intrinsics.checkNotNullParameter(arrayList, "windowType");
        g(context, obj, arrayList, hashMap, z, z2, (Bundle) null);
    }

    public final void g(Context context, Object obj, ArrayList arrayList, HashMap hashMap, boolean z, boolean z2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(obj, "window");
        Intrinsics.checkNotNullParameter(arrayList, "windowType");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            if (intValue != 101) {
                if (intValue != 102) {
                    if (intValue != 106) {
                        if (intValue != 107) {
                            if (intValue != 124) {
                                if (intValue == 126 && PermissionAndStateCheckUtils.f7907a.C(context)) {
                                    arrayList2.add(126);
                                }
                            } else if (PermissionAndStateCheckUtils.f7907a.c(context)) {
                                arrayList2.add(124);
                            }
                        } else if (PermissionAndStateCheckUtils.f7907a.g(context)) {
                            arrayList2.add(107);
                        }
                    } else if (PermissionAndStateCheckUtils.j(PermissionAndStateCheckUtils.f7907a, (Context) null, 1, (Object) null)) {
                        arrayList2.add(106);
                    }
                } else if (PermissionAndStateCheckUtils.f7907a.f(context)) {
                    arrayList2.add(102);
                }
            } else if (PermissionAndStateCheckUtils.f7907a.k(context)) {
                arrayList2.add(101);
            }
        }
        arrayList.removeAll(CollectionsKt.toSet(arrayList2));
        if (!arrayList.isEmpty()) {
            CollectionsKt.sort(arrayList);
            p(obj, arrayList, hashMap, z, z2, bundle);
        }
    }

    public final void h() {
        List list = this.f7886a;
        if (list != null) {
            list.clear();
        }
    }

    public final void i() {
        List<SuperGenericWindowView> list = this.f7886a;
        if (list != null) {
            for (SuperGenericWindowView r : list) {
                r.r();
            }
        }
    }

    public final void j(int i) {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new GenericWindowManger$dismissGenericWindow$1(i, this, (Continuation<? super GenericWindowManger$dismissGenericWindow$1>) null), 3, (Object) null);
    }

    public final boolean k(int i) {
        List<SuperGenericWindowView> list = this.f7886a;
        if (list == null) {
            return false;
        }
        for (SuperGenericWindowView l : list) {
            if (l.l(i)) {
                return true;
            }
        }
        return false;
    }

    public final void l(SuperGenericWindowView superGenericWindowView) {
        Intrinsics.checkNotNullParameter(superGenericWindowView, "view");
        try {
            List list = this.f7886a;
            if (list != null) {
                list.remove(superGenericWindowView);
            }
        } catch (Exception unused) {
        }
    }

    public final void m(int i) {
        List<SuperGenericWindowView> list = this.f7886a;
        if (list != null) {
            for (SuperGenericWindowView softKeyHeight : list) {
                softKeyHeight.setSoftKeyHeight(i);
            }
        }
    }

    public final void n(Activity activity, int i, Object obj, boolean z, boolean z2, Bundle bundle, SuperGenericWindowView.IActionCallback iActionCallback) {
        Object obj2 = obj;
        Activity activity2 = activity;
        Intrinsics.checkNotNullParameter(activity, "activity");
        o(activity, CollectionsKt.arrayListOf(Integer.valueOf(i)), obj2 != null ? MapsKt.hashMapOf(TuplesKt.to(Integer.valueOf(i), obj)) : null, z, z2, bundle, iActionCallback);
    }

    public final void o(Activity activity, ArrayList arrayList, HashMap hashMap, boolean z, boolean z2, Bundle bundle, SuperGenericWindowView.IActionCallback iActionCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(arrayList, "notices");
        CoroutineScope a2 = CoroutineScopeKt.a(Dispatchers.c());
        Job unused = BuildersKt__Builders_commonKt.d(a2, (CoroutineContext) null, (CoroutineStart) null, new GenericWindowManger$showGenericWindow$3(arrayList, activity, iActionCallback, z, z2, bundle, hashMap, this, (Continuation<? super GenericWindowManger$showGenericWindow$3>) null), 3, (Object) null);
    }

    public final void p(Object obj, ArrayList arrayList, HashMap hashMap, boolean z, boolean z2, Bundle bundle) {
        Activity activity;
        Object obj2 = obj;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Activity activity2 = null;
        if (obj2 instanceof Activity) {
            activity = (Activity) obj2;
            objectRef.element = StaticMethodUtilsKt.f(activity);
        } else if (obj2 instanceof Fragment) {
            Fragment fragment = (Fragment) obj2;
            FragmentActivity requireActivity = fragment.requireActivity();
            objectRef.element = StaticMethodUtilsKt.g(fragment);
            activity = requireActivity;
        } else {
            activity = null;
        }
        if (activity != null) {
            if ((!activity.isFinishing()) && (!activity.isDestroyed())) {
                activity2 = activity;
            }
            if (activity2 != null) {
                Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new GenericWindowManger$showGenericWindow$2$1(arrayList, activity2, objectRef, z, z2, bundle, hashMap, this, (Continuation<? super GenericWindowManger$showGenericWindow$2$1>) null), 3, (Object) null);
            }
        }
    }

    public final boolean r(int i, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("GenericWindowManger", "updateWindowView windowType = " + i + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + obj);
        List<SuperGenericWindowView> list = this.f7886a;
        if (list == null) {
            return false;
        }
        for (SuperGenericWindowView superGenericWindowView : list) {
            if (superGenericWindowView.l(i)) {
                superGenericWindowView.v(i, obj);
                return true;
            }
        }
        return false;
    }

    public final boolean s() {
        List list = this.f7886a;
        if (list == null) {
            return false;
        }
        Intrinsics.checkNotNull(list);
        return list.size() > 0;
    }
}

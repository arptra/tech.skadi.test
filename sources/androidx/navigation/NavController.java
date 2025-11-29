package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.y.a;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000Ä\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0016\u0018\u0000 í\u00012\u00020\u0001:\u0006\u0002\u0002\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJb\u0010\u0019\u001a\u00020\t*\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122#\b\u0002\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\t0\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJP\u0010\u001e\u001a\u00020\t*\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2#\b\u0002\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\t0\u0014H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010#\u001a\u00020\u001c2\b\b\u0001\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0003¢\u0006\u0004\b#\u0010$J1\u0010(\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\u001c2\b\b\u0001\u0010!\u001a\u00020 H\u0003¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u001cH\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u001cH\u0002¢\u0006\u0004\b.\u0010-J\u000f\u0010/\u001a\u00020\u001cH\u0002¢\u0006\u0004\b/\u0010-J\u0019\u00102\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u000100H\u0003¢\u0006\u0004\b2\u00103J\u0019\u00107\u001a\u0004\u0018\u0001062\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b7\u00108J\u001f\u00109\u001a\u0004\u0018\u00010\r*\u00020\r2\b\b\u0001\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b9\u0010:J5\u0010=\u001a\u00020\t2\u0006\u0010;\u001a\u00020\r2\b\u0010<\u001a\u0004\u0018\u0001002\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0003¢\u0006\u0004\b=\u0010>J5\u0010@\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020 2\b\u0010<\u001a\u0004\u0018\u0001002\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b@\u0010AJ%\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0002¢\u0006\u0004\bC\u0010DJ9\u0010G\u001a\u00020\t2\u0006\u0010;\u001a\u00020\r2\b\u0010E\u001a\u0004\u0018\u0001002\u0006\u0010\u0017\u001a\u00020\u00062\u000e\b\u0002\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\tH\u0002¢\u0006\u0004\bI\u0010JJ\u0019\u0010K\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\bK\u0010LJ\u0017\u0010O\u001a\u00020\t2\u0006\u0010N\u001a\u00020MH\u0016¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001a\u00020\t2\u0006\u0010N\u001a\u00020MH\u0016¢\u0006\u0004\bQ\u0010PJ\u000f\u0010R\u001a\u00020\u001cH\u0017¢\u0006\u0004\bR\u0010-J!\u0010S\u001a\u00020\u001c2\b\b\u0001\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001cH\u0017¢\u0006\u0004\bS\u0010TJ)\u0010U\u001a\u00020\u001c2\b\b\u0001\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0017¢\u0006\u0004\bU\u0010$J%\u0010X\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00062\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\t0VH\u0000¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020\u001cH\u0017¢\u0006\u0004\bZ\u0010-J\u000f\u0010[\u001a\u00020\tH\u0000¢\u0006\u0004\b[\u0010JJ\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0000¢\u0006\u0004\b\\\u0010]J\u0019\u0010_\u001a\u00020\t2\b\b\u0001\u0010^\u001a\u00020 H\u0017¢\u0006\u0004\b_\u0010`J#\u0010a\u001a\u00020\t2\b\b\u0001\u0010^\u001a\u00020 2\b\u00101\u001a\u0004\u0018\u000100H\u0017¢\u0006\u0004\ba\u0010bJ!\u0010e\u001a\u00020\t2\u0006\u0010d\u001a\u00020c2\b\u00101\u001a\u0004\u0018\u000100H\u0017¢\u0006\u0004\be\u0010fJ\u0019\u0010i\u001a\u00020\u001c2\b\u0010h\u001a\u0004\u0018\u00010gH\u0017¢\u0006\u0004\bi\u0010jJ\u001b\u0010k\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\bk\u0010lJ\u0019\u0010n\u001a\u00020\t2\b\b\u0001\u0010m\u001a\u00020 H\u0017¢\u0006\u0004\bn\u0010`J#\u0010o\u001a\u00020\t2\b\b\u0001\u0010m\u001a\u00020 2\b\u0010<\u001a\u0004\u0018\u000100H\u0017¢\u0006\u0004\bo\u0010bJ-\u0010p\u001a\u00020\t2\b\b\u0001\u0010m\u001a\u00020 2\b\u0010<\u001a\u0004\u0018\u0001002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0017¢\u0006\u0004\bp\u0010qJ7\u0010r\u001a\u00020\t2\b\b\u0001\u0010m\u001a\u00020 2\b\u0010<\u001a\u0004\u0018\u0001002\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0017¢\u0006\u0004\br\u0010sJ\u000f\u0010u\u001a\u00020tH\u0016¢\u0006\u0004\bu\u0010vJ\u0011\u0010w\u001a\u0004\u0018\u000100H\u0017¢\u0006\u0004\bw\u0010xJ\u0019\u0010z\u001a\u00020\t2\b\u0010y\u001a\u0004\u0018\u000100H\u0017¢\u0006\u0004\bz\u00103J\u0017\u0010}\u001a\u00020\t2\u0006\u0010|\u001a\u00020{H\u0017¢\u0006\u0004\b}\u0010~J\u001b\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020H\u0017¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\u001cH\u0017¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\t2\b\u0010\u0001\u001a\u00030\u0001H\u0017¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020 H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u000206¢\u0006\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010 \u0001\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R#\u0010¥\u0001\u001a\f\u0012\u0005\u0012\u00030¢\u0001\u0018\u00010¡\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u0018\u0010§\u0001\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b¦\u0001\u0010\u001eR%\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060%8WX\u0004¢\u0006\u0010\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001R$\u0010°\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e0­\u00018\u0002X\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R3\u0010·\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e0±\u00018\u0006X\u0004¢\u0006\u0017\n\u0006\b²\u0001\u0010³\u0001\u0012\u0005\b¶\u0001\u0010J\u001a\u0006\b´\u0001\u0010µ\u0001R$\u0010»\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060¸\u00018\u0002X\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R%\u0010¾\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0005\u0012\u00030¼\u00010¸\u00018\u0002X\u0004¢\u0006\b\n\u0006\b½\u0001\u0010º\u0001R&\u0010À\u0001\u001a\u0011\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u0001060¸\u00018\u0002X\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010º\u0001R)\u0010Á\u0001\u001a\u0015\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0¸\u00018\u0002X\u0004¢\u0006\u0007\n\u0005\bG\u0010º\u0001R\u001b\u0010Ä\u0001\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001a\u0010Æ\u0001\u001a\u0004\u0018\u000108\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bO\u0010Å\u0001R\u001b\u0010É\u0001\u001a\u0005\u0018\u00010Ç\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b*\u0010È\u0001R\u001d\u0010Ì\u0001\u001a\t\u0012\u0004\u0012\u00020M0Ê\u00018\u0002X\u0004¢\u0006\u0007\n\u0005\bu\u0010Ë\u0001R)\u0010Ó\u0001\u001a\u00030Í\u00018@@\u0000X\u000e¢\u0006\u0017\n\u0005\b/\u0010Î\u0001\u001a\u0006\bÏ\u0001\u0010Ð\u0001\"\u0006\bÑ\u0001\u0010Ò\u0001R\u0018\u0010Ö\u0001\u001a\u00030Ô\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010Õ\u0001R\u0017\u0010Ù\u0001\u001a\u00030×\u00018\u0002X\u0004¢\u0006\u0007\n\u0005\bk\u0010Ø\u0001R\u0017\u0010Ú\u0001\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010\u001eR\u0019\u0010Ý\u0001\u001a\u00030Û\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b7\u0010Ü\u0001R1\u0010ß\u0001\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\u0012\t\u0012\u00070Þ\u0001R\u00020\u00000¸\u00018\u0002X\u0004¢\u0006\b\n\u0006\bª\u0001\u0010º\u0001R6\u0010á\u0001\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010à\u0001R6\u0010â\u0001\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010à\u0001R$\u0010ã\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001c0¸\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010º\u0001R\u0019\u0010æ\u0001\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bä\u0001\u0010å\u0001R\u001e\u0010ê\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060ç\u00018\u0002X\u0004¢\u0006\b\n\u0006\bè\u0001\u0010é\u0001R!\u0010ï\u0001\u001a\u00030\u00018VX\u0002¢\u0006\u0010\n\u0006\bë\u0001\u0010ì\u0001\u001a\u0006\bí\u0001\u0010î\u0001R\u001e\u0010ó\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060ð\u00018\u0002X\u0004¢\u0006\b\n\u0006\bñ\u0001\u0010ò\u0001R#\u0010ø\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060ô\u00018\u0006¢\u0006\u0010\n\u0006\bÏ\u0001\u0010õ\u0001\u001a\u0006\bö\u0001\u0010÷\u0001R\u0017\u0010ú\u0001\u001a\u00020 8BX\u0004¢\u0006\b\u001a\u0006\bë\u0001\u0010ù\u0001R(\u0010d\u001a\u00020c2\u0006\u0010d\u001a\u00020c8W@WX\u000e¢\u0006\u0010\u001a\u0006\bñ\u0001\u0010û\u0001\"\u0006\bü\u0001\u0010ý\u0001R,\u0010þ\u0001\u001a\u00030Û\u00012\b\u0010þ\u0001\u001a\u00030Û\u00018V@WX\u000e¢\u0006\u0010\u001a\u0006\bÿ\u0001\u0010\u0002\"\u0006\b\u0002\u0010\u0002R\u0019\u0010\u0002\u001a\u0004\u0018\u00010\r8VX\u0004¢\u0006\b\u001a\u0006\bè\u0001\u0010\u0002R\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\b\u001a\u0006\bä\u0001\u0010\u0002R\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\b\u001a\u0006\bå\u0001\u0010\u0002¨\u0006\u0002"}, d2 = {"Landroidx/navigation/NavController;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroidx/navigation/NavBackStackEntry;", "child", "parent", "", "M", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavBackStackEntry;)V", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "", "entries", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "backStackEntry", "handler", "S", "(Landroidx/navigation/Navigator;Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;Lkotlin/jvm/functions/Function1;)V", "popUpTo", "", "saveState", "Z", "(Landroidx/navigation/Navigator;Landroidx/navigation/NavBackStackEntry;ZLkotlin/jvm/functions/Function1;)V", "", "destinationId", "inclusive", "a0", "(IZZ)Z", "Lkotlin/collections/ArrayDeque;", "Landroidx/navigation/NavBackStackEntryState;", "savedState", "c0", "(Landroidx/navigation/NavBackStackEntry;ZLkotlin/collections/ArrayDeque;)V", "q", "(I)Z", "p0", "()Z", "q0", "s", "Landroid/os/Bundle;", "startDestinationArgs", "U", "(Landroid/os/Bundle;)V", "", "deepLink", "", "w", "([I)Ljava/lang/String;", "v", "(Landroidx/navigation/NavDestination;I)Landroidx/navigation/NavDestination;", "node", "args", "R", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "id", "h0", "(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Z", "backStackState", "K", "(Lkotlin/collections/ArrayDeque;)Ljava/util/List;", "finalArgs", "restoredEntries", "n", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavBackStackEntry;Ljava/util/List;)V", "t0", "()V", "r0", "(Landroidx/navigation/NavBackStackEntry;)Landroidx/navigation/NavBackStackEntry;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "listener", "p", "(Landroidx/navigation/NavController$OnDestinationChangedListener;)V", "f0", "V", "W", "(IZ)Z", "X", "Lkotlin/Function0;", "onComplete", "Y", "(Landroidx/navigation/NavBackStackEntry;Lkotlin/jvm/functions/Function0;)V", "T", "s0", "e0", "()Ljava/util/List;", "graphResId", "j0", "(I)V", "k0", "(ILandroid/os/Bundle;)V", "Landroidx/navigation/NavGraph;", "graph", "l0", "(Landroidx/navigation/NavGraph;Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "J", "(Landroid/content/Intent;)Z", "u", "(I)Landroidx/navigation/NavDestination;", "resId", "N", "O", "P", "(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;)V", "Q", "(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavDeepLinkBuilder;", "r", "()Landroidx/navigation/NavDeepLinkBuilder;", "i0", "()Landroid/os/Bundle;", "navState", "g0", "Landroidx/lifecycle/LifecycleOwner;", "owner", "m0", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/activity/OnBackPressedDispatcher;", "dispatcher", "n0", "(Landroidx/activity/OnBackPressedDispatcher;)V", "enabled", "t", "(Z)V", "Landroidx/lifecycle/ViewModelStore;", "viewModelStore", "o0", "(Landroidx/lifecycle/ViewModelStore;)V", "y", "(I)Landroidx/navigation/NavBackStackEntry;", "route", "z", "(Ljava/lang/String;)Landroidx/navigation/NavBackStackEntry;", "a", "Landroid/content/Context;", "A", "()Landroid/content/Context;", "Landroid/app/Activity;", "b", "Landroid/app/Activity;", "activity", "Landroidx/navigation/NavInflater;", "c", "Landroidx/navigation/NavInflater;", "inflater", "d", "Landroidx/navigation/NavGraph;", "_graph", "e", "Landroid/os/Bundle;", "navigatorStateToRestore", "", "Landroid/os/Parcelable;", "f", "[Landroid/os/Parcelable;", "backStackToRestore", "g", "deepLinkHandled", "h", "Lkotlin/collections/ArrayDeque;", "x", "()Lkotlin/collections/ArrayDeque;", "backQueue", "Lkotlinx/coroutines/flow/MutableStateFlow;", "i", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_visibleEntries", "Lkotlinx/coroutines/flow/StateFlow;", "j", "Lkotlinx/coroutines/flow/StateFlow;", "getVisibleEntries", "()Lkotlinx/coroutines/flow/StateFlow;", "getVisibleEntries$annotations", "visibleEntries", "", "k", "Ljava/util/Map;", "childToParentEntries", "Ljava/util/concurrent/atomic/AtomicInteger;", "l", "parentToChildCount", "m", "backStackMap", "backStackStates", "o", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/activity/OnBackPressedDispatcher;", "onBackPressedDispatcher", "Landroidx/navigation/NavControllerViewModel;", "Landroidx/navigation/NavControllerViewModel;", "viewModel", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onDestinationChangedListeners", "Landroidx/lifecycle/Lifecycle$State;", "Landroidx/lifecycle/Lifecycle$State;", "F", "()Landroidx/lifecycle/Lifecycle$State;", "setHostLifecycleState$navigation_runtime_release", "(Landroidx/lifecycle/Lifecycle$State;)V", "hostLifecycleState", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "lifecycleObserver", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", "enableOnBackPressedCallback", "Landroidx/navigation/NavigatorProvider;", "Landroidx/navigation/NavigatorProvider;", "_navigatorProvider", "Landroidx/navigation/NavController$NavControllerNavigatorState;", "navigatorState", "Lkotlin/jvm/functions/Function1;", "addToBackStackHandler", "popFromBackStackHandler", "entrySavedState", "B", "I", "dispatchReentrantCount", "", "C", "Ljava/util/List;", "backStackEntriesToDispatch", "D", "Lkotlin/Lazy;", "G", "()Landroidx/navigation/NavInflater;", "navInflater", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "E", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/Flow;", "getCurrentBackStackEntryFlow", "()Lkotlinx/coroutines/flow/Flow;", "currentBackStackEntryFlow", "()I", "destinationCountOnBackStack", "()Landroidx/navigation/NavGraph;", "setGraph", "(Landroidx/navigation/NavGraph;)V", "navigatorProvider", "H", "()Landroidx/navigation/NavigatorProvider;", "setNavigatorProvider", "(Landroidx/navigation/NavigatorProvider;)V", "()Landroidx/navigation/NavDestination;", "currentDestination", "()Landroidx/navigation/NavBackStackEntry;", "currentBackStackEntry", "previousBackStackEntry", "Companion", "NavControllerNavigatorState", "OnDestinationChangedListener", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
public class NavController {
    public static final Companion G = new Companion((DefaultConstructorMarker) null);
    public static boolean H = true;
    public final Map A;
    public int B;
    public final List C;
    public final Lazy D;
    public final MutableSharedFlow E;
    public final Flow F;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1474a;
    public Activity b;
    public NavInflater c;
    public NavGraph d;
    public Bundle e;
    public Parcelable[] f;
    public boolean g;
    public final ArrayDeque h;
    public final MutableStateFlow i;
    public final StateFlow j;
    public final Map k;
    public final Map l;
    public final Map m;
    public final Map n;
    public LifecycleOwner o;
    public OnBackPressedDispatcher p;
    public NavControllerViewModel q;
    public final CopyOnWriteArrayList r;
    public Lifecycle.State s;
    public final LifecycleObserver t;
    public final OnBackPressedCallback u;
    public boolean v;
    public NavigatorProvider w;
    public final Map x;
    public Function1 y;
    public Function1 z;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0006R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/navigation/NavController$Companion;", "", "<init>", "()V", "", "KEY_BACK_STACK", "Ljava/lang/String;", "KEY_BACK_STACK_DEST_IDS", "KEY_BACK_STACK_IDS", "KEY_BACK_STACK_STATES_IDS", "KEY_BACK_STACK_STATES_PREFIX", "KEY_DEEP_LINK_ARGS", "KEY_DEEP_LINK_HANDLED", "KEY_DEEP_LINK_IDS", "KEY_DEEP_LINK_INTENT", "KEY_NAVIGATOR_STATE", "KEY_NAVIGATOR_STATE_NAMES", "TAG", "", "deepLinkSaveState", "Z", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u000bR\u001f\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/navigation/NavController$NavControllerNavigatorState;", "Landroidx/navigation/NavigatorState;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "navigator", "<init>", "(Landroidx/navigation/NavController;Landroidx/navigation/Navigator;)V", "Landroidx/navigation/NavBackStackEntry;", "backStackEntry", "", "h", "(Landroidx/navigation/NavBackStackEntry;)V", "k", "destination", "Landroid/os/Bundle;", "arguments", "a", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;)Landroidx/navigation/NavBackStackEntry;", "popUpTo", "", "saveState", "g", "(Landroidx/navigation/NavBackStackEntry;Z)V", "entry", "e", "Landroidx/navigation/Navigator;", "getNavigator", "()Landroidx/navigation/Navigator;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
    public final class NavControllerNavigatorState extends NavigatorState {
        public final Navigator g;
        public final /* synthetic */ NavController h;

        public NavControllerNavigatorState(NavController navController, Navigator navigator) {
            Intrinsics.checkNotNullParameter(navController, "this$0");
            Intrinsics.checkNotNullParameter(navigator, "navigator");
            this.h = navController;
            this.g = navigator;
        }

        public NavBackStackEntry a(NavDestination navDestination, Bundle bundle) {
            Intrinsics.checkNotNullParameter(navDestination, RtspHeaders.Values.DESTINATION);
            return NavBackStackEntry.Companion.b(NavBackStackEntry.n, this.h.A(), navDestination, bundle, this.h.F(), this.h.q, (String) null, (Bundle) null, 96, (Object) null);
        }

        public void e(NavBackStackEntry navBackStackEntry) {
            NavControllerViewModel j;
            Intrinsics.checkNotNullParameter(navBackStackEntry, "entry");
            boolean areEqual = Intrinsics.areEqual(this.h.A.get(navBackStackEntry), (Object) Boolean.TRUE);
            super.e(navBackStackEntry);
            this.h.A.remove(navBackStackEntry);
            if (!this.h.x().contains(navBackStackEntry)) {
                this.h.r0(navBackStackEntry);
                if (navBackStackEntry.getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
                    navBackStackEntry.m(Lifecycle.State.DESTROYED);
                }
                ArrayDeque x = this.h.x();
                if (!(x instanceof Collection) || !x.isEmpty()) {
                    Iterator it = x.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Intrinsics.areEqual((Object) ((NavBackStackEntry) it.next()).g(), (Object) navBackStackEntry.g())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.h.s0();
                    this.h.i.b(this.h.e0());
                }
                if (!areEqual && (j = this.h.q) != null) {
                    j.d(navBackStackEntry.g());
                }
                this.h.s0();
                this.h.i.b(this.h.e0());
            } else if (!d()) {
                this.h.s0();
                this.h.i.b(this.h.e0());
            }
        }

        public void g(NavBackStackEntry navBackStackEntry, boolean z) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
            Navigator d = this.h.w.d(navBackStackEntry.f().m());
            if (Intrinsics.areEqual((Object) d, (Object) this.g)) {
                Function1 i = this.h.z;
                if (i != null) {
                    i.invoke(navBackStackEntry);
                    super.g(navBackStackEntry, z);
                    return;
                }
                this.h.Y(navBackStackEntry, new NavController$NavControllerNavigatorState$pop$1(this, navBackStackEntry, z));
                return;
            }
            Object obj = this.h.x.get(d);
            Intrinsics.checkNotNull(obj);
            ((NavControllerNavigatorState) obj).g(navBackStackEntry, z);
        }

        public void h(NavBackStackEntry navBackStackEntry) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
            Navigator d = this.h.w.d(navBackStackEntry.f().m());
            if (Intrinsics.areEqual((Object) d, (Object) this.g)) {
                Function1 c = this.h.y;
                if (c != null) {
                    c.invoke(navBackStackEntry);
                    k(navBackStackEntry);
                    return;
                }
                Log.i("NavController", "Ignoring add of destination " + navBackStackEntry.f() + " outside of the call to navigate(). ");
                return;
            }
            Object obj = this.h.x.get(d);
            if (obj != null) {
                ((NavControllerNavigatorState) obj).h(navBackStackEntry);
                return;
            }
            throw new IllegalStateException(("NavigatorBackStack for " + navBackStackEntry.f().m() + " should already be created").toString());
        }

        public final void k(NavBackStackEntry navBackStackEntry) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
            super.h(navBackStackEntry);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/navigation/NavController$OnDestinationChangedListener;", "", "Landroidx/navigation/NavController;", "controller", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "", "x", "(Landroidx/navigation/NavController;Landroidx/navigation/NavDestination;Landroid/os/Bundle;)V", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
    public interface OnDestinationChangedListener {
        void x(NavController navController, NavDestination navDestination, Bundle bundle);
    }

    public NavController(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1474a = context;
        Iterator it = SequencesKt.generateSequence(context, NavController$activity$1.INSTANCE).iterator();
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
        this.b = (Activity) obj;
        this.h = new ArrayDeque();
        MutableStateFlow a2 = StateFlowKt.a(CollectionsKt.emptyList());
        this.i = a2;
        this.j = FlowKt.c(a2);
        this.k = new LinkedHashMap();
        this.l = new LinkedHashMap();
        this.m = new LinkedHashMap();
        this.n = new LinkedHashMap();
        this.r = new CopyOnWriteArrayList();
        this.s = Lifecycle.State.INITIALIZED;
        this.t = new a(this);
        this.u = new NavController$onBackPressedCallback$1(this);
        this.v = true;
        this.w = new NavigatorProvider();
        this.x = new LinkedHashMap();
        this.A = new LinkedHashMap();
        NavigatorProvider navigatorProvider = this.w;
        navigatorProvider.b(new NavGraphNavigator(navigatorProvider));
        this.w.b(new ActivityNavigator(this.f1474a));
        this.C = new ArrayList();
        this.D = LazyKt.lazy(new NavController$navInflater$2(this));
        MutableSharedFlow b2 = SharedFlowKt.b(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);
        this.E = b2;
        this.F = FlowKt.b(b2);
    }

    public static final void L(NavController navController, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(navController, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "$noName_0");
        Intrinsics.checkNotNullParameter(event, "event");
        Lifecycle.State targetState = event.getTargetState();
        Intrinsics.checkNotNullExpressionValue(targetState, "event.targetState");
        navController.s = targetState;
        if (navController.d != null) {
            Iterator it = navController.x().iterator();
            while (it.hasNext()) {
                ((NavBackStackEntry) it.next()).j(event);
            }
        }
    }

    public static /* synthetic */ boolean b0(NavController navController, int i2, boolean z2, boolean z3, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z3 = false;
            }
            return navController.a0(i2, z2, z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
    }

    public static /* synthetic */ void d0(NavController navController, NavBackStackEntry navBackStackEntry, boolean z2, ArrayDeque arrayDeque, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z2 = false;
            }
            if ((i2 & 4) != 0) {
                arrayDeque = new ArrayDeque();
            }
            navController.c0(navBackStackEntry, z2, arrayDeque);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
    }

    public static /* synthetic */ void o(NavController navController, NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 8) != 0) {
                list = CollectionsKt.emptyList();
            }
            navController.n(navDestination, bundle, navBackStackEntry, list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
    }

    public final Context A() {
        return this.f1474a;
    }

    public NavBackStackEntry B() {
        return (NavBackStackEntry) x().lastOrNull();
    }

    public NavDestination C() {
        NavBackStackEntry B2 = B();
        if (B2 == null) {
            return null;
        }
        return B2.f();
    }

    public final int D() {
        ArrayDeque<NavBackStackEntry> x2 = x();
        int i2 = 0;
        if (!(x2 instanceof Collection) || !x2.isEmpty()) {
            for (NavBackStackEntry f2 : x2) {
                if ((!(f2.f() instanceof NavGraph)) && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i2;
    }

    public NavGraph E() {
        NavGraph navGraph = this.d;
        if (navGraph == null) {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()".toString());
        } else if (navGraph != null) {
            return navGraph;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavGraph");
        }
    }

    public final Lifecycle.State F() {
        return this.o == null ? Lifecycle.State.CREATED : this.s;
    }

    public NavInflater G() {
        return (NavInflater) this.D.getValue();
    }

    public NavigatorProvider H() {
        return this.w;
    }

    public NavBackStackEntry I() {
        Object obj;
        Iterator it = CollectionsKt.reversed(x()).iterator();
        if (it.hasNext()) {
            it.next();
        }
        Iterator it2 = SequencesKt.asSequence(it).iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (!(((NavBackStackEntry) obj).f() instanceof NavGraph)) {
                break;
            }
        }
        return (NavBackStackEntry) obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01e0 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean J(android.content.Intent r21) {
        /*
            r20 = this;
            r6 = r20
            r0 = r21
            r7 = 0
            if (r0 != 0) goto L_0x0008
            return r7
        L_0x0008:
            android.os.Bundle r1 = r21.getExtras()
            r8 = 0
            if (r1 != 0) goto L_0x0011
            r2 = r8
            goto L_0x0017
        L_0x0011:
            java.lang.String r2 = "android-support-nav:controller:deepLinkIds"
            int[] r2 = r1.getIntArray(r2)
        L_0x0017:
            if (r1 != 0) goto L_0x001b
            r3 = r8
            goto L_0x0021
        L_0x001b:
            java.lang.String r3 = "android-support-nav:controller:deepLinkArgs"
            java.util.ArrayList r3 = r1.getParcelableArrayList(r3)
        L_0x0021:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            if (r1 != 0) goto L_0x002a
            r1 = r8
            goto L_0x0030
        L_0x002a:
            java.lang.String r5 = "android-support-nav:controller:deepLinkExtras"
            android.os.Bundle r1 = r1.getBundle(r5)
        L_0x0030:
            if (r1 == 0) goto L_0x0035
            r4.putAll(r1)
        L_0x0035:
            r9 = 1
            if (r2 == 0) goto L_0x003b
            int r1 = r2.length
            if (r1 != 0) goto L_0x0063
        L_0x003b:
            androidx.navigation.NavGraph r1 = r6.d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.navigation.NavDeepLinkRequest r5 = new androidx.navigation.NavDeepLinkRequest
            r5.<init>(r0)
            androidx.navigation.NavDestination$DeepLinkMatch r1 = r1.p(r5)
            if (r1 == 0) goto L_0x0063
            androidx.navigation.NavDestination r2 = r1.d()
            int[] r3 = androidx.navigation.NavDestination.f(r2, r8, r9, r8)
            android.os.Bundle r1 = r1.f()
            android.os.Bundle r1 = r2.d(r1)
            if (r1 == 0) goto L_0x0060
            r4.putAll(r1)
        L_0x0060:
            r10 = r3
            r3 = r8
            goto L_0x0064
        L_0x0063:
            r10 = r2
        L_0x0064:
            if (r10 == 0) goto L_0x01e0
            int r1 = r10.length
            if (r1 != 0) goto L_0x006b
            goto L_0x01e0
        L_0x006b:
            java.lang.String r1 = r6.w(r10)
            if (r1 == 0) goto L_0x0090
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Could not find destination "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " in the navigation graph, ignoring the deep link from "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "NavController"
            android.util.Log.i(r1, r0)
            return r7
        L_0x0090:
            java.lang.String r1 = "android-support-nav:controller:deepLinkIntent"
            r4.putParcelable(r1, r0)
            int r1 = r10.length
            android.os.Bundle[] r11 = new android.os.Bundle[r1]
            r2 = r7
        L_0x0099:
            if (r2 >= r1) goto L_0x00b6
            int r5 = r2 + 1
            android.os.Bundle r12 = new android.os.Bundle
            r12.<init>()
            r12.putAll(r4)
            if (r3 == 0) goto L_0x00b2
            java.lang.Object r13 = r3.get(r2)
            android.os.Bundle r13 = (android.os.Bundle) r13
            if (r13 == 0) goto L_0x00b2
            r12.putAll(r13)
        L_0x00b2:
            r11[r2] = r12
            r2 = r5
            goto L_0x0099
        L_0x00b6:
            int r1 = r21.getFlags()
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r2 = r2 & r1
            if (r2 == 0) goto L_0x00e6
            r3 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r3
            if (r1 != 0) goto L_0x00e6
            r0.addFlags(r3)
            android.content.Context r1 = r6.f1474a
            androidx.core.app.TaskStackBuilder r1 = androidx.core.app.TaskStackBuilder.e(r1)
            androidx.core.app.TaskStackBuilder r0 = r1.b(r0)
            java.lang.String r1 = "create(context)\n        …ntWithParentStack(intent)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0.i()
            android.app.Activity r0 = r6.b
            if (r0 != 0) goto L_0x00df
            goto L_0x00e5
        L_0x00df:
            r0.finish()
            r0.overridePendingTransition(r7, r7)
        L_0x00e5:
            return r9
        L_0x00e6:
            java.lang.String r12 = "Deep Linking failed: destination "
            if (r2 == 0) goto L_0x014d
            kotlin.collections.ArrayDeque r0 = r20.x()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0106
            androidx.navigation.NavGraph r0 = r6.d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r1 = r0.k()
            r4 = 4
            r5 = 0
            r2 = 1
            r3 = 0
            r0 = r20
            b0(r0, r1, r2, r3, r4, r5)
        L_0x0106:
            int r0 = r10.length
            if (r7 >= r0) goto L_0x014c
            r0 = r10[r7]
            int r1 = r7 + 1
            r2 = r11[r7]
            androidx.navigation.NavDestination r3 = r6.u(r0)
            if (r3 == 0) goto L_0x0123
            androidx.navigation.NavController$handleDeepLink$2 r0 = new androidx.navigation.NavController$handleDeepLink$2
            r0.<init>(r3, r6)
            androidx.navigation.NavOptions r0 = androidx.navigation.NavOptionsBuilderKt.a(r0)
            r6.R(r3, r2, r0, r8)
            r7 = r1
            goto L_0x0106
        L_0x0123:
            androidx.navigation.NavDestination$Companion r1 = androidx.navigation.NavDestination.j
            android.content.Context r2 = r6.f1474a
            java.lang.String r0 = r1.b(r2, r0)
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r0)
            java.lang.String r0 = " cannot be found from the current destination "
            r2.append(r0)
            androidx.navigation.NavDestination r0 = r20.C()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x014c:
            return r9
        L_0x014d:
            androidx.navigation.NavGraph r0 = r6.d
            int r1 = r10.length
            r2 = r7
        L_0x0151:
            if (r2 >= r1) goto L_0x01dd
            int r3 = r2 + 1
            r4 = r10[r2]
            r5 = r11[r2]
            if (r2 != 0) goto L_0x015e
            androidx.navigation.NavGraph r13 = r6.d
            goto L_0x0165
        L_0x015e:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.navigation.NavDestination r13 = r0.y(r4)
        L_0x0165:
            if (r13 == 0) goto L_0x01b8
            int r4 = r10.length
            int r4 = r4 - r9
            if (r2 == r4) goto L_0x018e
            boolean r2 = r13 instanceof androidx.navigation.NavGraph
            if (r2 == 0) goto L_0x018c
            androidx.navigation.NavGraph r13 = (androidx.navigation.NavGraph) r13
            r0 = r13
        L_0x0172:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r2 = r0.E()
            androidx.navigation.NavDestination r2 = r0.y(r2)
            boolean r2 = r2 instanceof androidx.navigation.NavGraph
            if (r2 == 0) goto L_0x018c
            int r2 = r0.E()
            androidx.navigation.NavDestination r0 = r0.y(r2)
            androidx.navigation.NavGraph r0 = (androidx.navigation.NavGraph) r0
            goto L_0x0172
        L_0x018c:
            r2 = r3
            goto L_0x0151
        L_0x018e:
            androidx.navigation.NavOptions$Builder r14 = new androidx.navigation.NavOptions$Builder
            r14.<init>()
            androidx.navigation.NavGraph r2 = r6.d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r15 = r2.k()
            r18 = 4
            r19 = 0
            r16 = 1
            r17 = 0
            androidx.navigation.NavOptions$Builder r2 = androidx.navigation.NavOptions.Builder.i(r14, r15, r16, r17, r18, r19)
            androidx.navigation.NavOptions$Builder r2 = r2.b(r7)
            androidx.navigation.NavOptions$Builder r2 = r2.c(r7)
            androidx.navigation.NavOptions r2 = r2.a()
            r6.R(r13, r5, r2, r8)
            goto L_0x018c
        L_0x01b8:
            androidx.navigation.NavDestination$Companion r1 = androidx.navigation.NavDestination.j
            android.content.Context r2 = r6.f1474a
            java.lang.String r1 = r1.b(r2, r4)
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r12)
            r3.append(r1)
            java.lang.String r1 = " cannot be found in graph "
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x01dd:
            r6.g = r9
            return r9
        L_0x01e0:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.J(android.content.Intent):boolean");
    }

    public final List K(ArrayDeque arrayDeque) {
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) x().lastOrNull();
        NavDestination f2 = navBackStackEntry == null ? null : navBackStackEntry.f();
        if (f2 == null) {
            f2 = E();
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) it.next();
                NavDestination v2 = v(f2, navBackStackEntryState.getDestinationId());
                if (v2 != null) {
                    arrayList.add(navBackStackEntryState.instantiate(A(), v2, F(), this.q));
                    f2 = v2;
                } else {
                    String b2 = NavDestination.j.b(A(), navBackStackEntryState.getDestinationId());
                    throw new IllegalStateException(("Restore State failed: destination " + b2 + " cannot be found from the current destination " + f2).toString());
                }
            }
        }
        return arrayList;
    }

    public final void M(NavBackStackEntry navBackStackEntry, NavBackStackEntry navBackStackEntry2) {
        this.k.put(navBackStackEntry, navBackStackEntry2);
        if (this.l.get(navBackStackEntry2) == null) {
            this.l.put(navBackStackEntry2, new AtomicInteger(0));
        }
        Object obj = this.l.get(navBackStackEntry2);
        Intrinsics.checkNotNull(obj);
        ((AtomicInteger) obj).incrementAndGet();
    }

    public void N(int i2) {
        O(i2, (Bundle) null);
    }

    public void O(int i2, Bundle bundle) {
        P(i2, bundle, (NavOptions) null);
    }

    public void P(int i2, Bundle bundle, NavOptions navOptions) {
        Q(i2, bundle, navOptions, (Navigator.Extras) null);
    }

    public void Q(int i2, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        int i3;
        NavDestination f2 = x().isEmpty() ? this.d : ((NavBackStackEntry) x().last()).f();
        if (f2 != null) {
            NavAction h2 = f2.h(i2);
            Bundle bundle2 = null;
            if (h2 != null) {
                if (navOptions == null) {
                    navOptions = h2.c();
                }
                i3 = h2.b();
                Bundle a2 = h2.a();
                if (a2 != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(a2);
                }
            } else {
                i3 = i2;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putAll(bundle);
            }
            if (i3 == 0 && navOptions != null && navOptions.e() != -1) {
                W(navOptions.e(), navOptions.f());
            } else if (i3 != 0) {
                NavDestination u2 = u(i3);
                if (u2 == null) {
                    NavDestination.Companion companion = NavDestination.j;
                    String b2 = companion.b(this.f1474a, i3);
                    if (h2 == null) {
                        throw new IllegalArgumentException("Navigation action/destination " + b2 + " cannot be found from the current destination " + f2);
                    }
                    throw new IllegalArgumentException(("Navigation destination " + b2 + " referenced from action " + companion.b(A(), i2) + " cannot be found from the current destination " + f2).toString());
                }
                R(u2, bundle2, navOptions, extras);
            } else {
                throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo".toString());
            }
        } else {
            throw new IllegalStateException("no current navigation node");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x010e A[LOOP:1: B:34:0x0108->B:36:0x010e, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void R(androidx.navigation.NavDestination r21, android.os.Bundle r22, androidx.navigation.NavOptions r23, androidx.navigation.Navigator.Extras r24) {
        /*
            r20 = this;
            r6 = r20
            r3 = r23
            java.util.Map r0 = r6.x
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x000e:
            boolean r1 = r0.hasNext()
            r2 = 1
            if (r1 == 0) goto L_0x001f
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavController$NavControllerNavigatorState r1 = (androidx.navigation.NavController.NavControllerNavigatorState) r1
            r1.i(r2)
            goto L_0x000e
        L_0x001f:
            kotlin.jvm.internal.Ref$BooleanRef r7 = new kotlin.jvm.internal.Ref$BooleanRef
            r7.<init>()
            r8 = 0
            if (r3 == 0) goto L_0x0040
            int r0 = r23.e()
            r1 = -1
            if (r0 == r1) goto L_0x0040
            int r0 = r23.e()
            boolean r1 = r23.f()
            boolean r4 = r23.h()
            boolean r0 = r6.a0(r0, r1, r4)
            r9 = r0
            goto L_0x0041
        L_0x0040:
            r9 = r8
        L_0x0041:
            android.os.Bundle r0 = r21.d(r22)
            if (r3 != 0) goto L_0x0048
            goto L_0x006c
        L_0x0048:
            boolean r1 = r23.i()
            if (r1 != r2) goto L_0x006c
            java.util.Map r1 = r6.m
            int r4 = r21.k()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r1 = r1.containsKey(r4)
            if (r1 == 0) goto L_0x006c
            int r1 = r21.k()
            r4 = r24
            boolean r0 = r6.h0(r1, r0, r3, r4)
            r7.element = r0
            goto L_0x00fa
        L_0x006c:
            r4 = r24
            androidx.navigation.NavBackStackEntry r1 = r20.B()
            androidx.navigation.NavigatorProvider r5 = r6.w
            java.lang.String r10 = r21.m()
            androidx.navigation.Navigator r5 = r5.d(r10)
            if (r3 != 0) goto L_0x007f
            goto L_0x00cb
        L_0x007f:
            boolean r10 = r23.g()
            if (r10 != r2) goto L_0x00cb
            int r10 = r21.k()
            if (r1 != 0) goto L_0x008c
            goto L_0x00cb
        L_0x008c:
            androidx.navigation.NavDestination r11 = r1.f()
            if (r11 != 0) goto L_0x0093
            goto L_0x00cb
        L_0x0093:
            int r11 = r11.k()
            if (r10 != r11) goto L_0x00cb
            kotlin.collections.ArrayDeque r3 = r20.x()
            java.lang.Object r3 = r3.removeLast()
            androidx.navigation.NavBackStackEntry r3 = (androidx.navigation.NavBackStackEntry) r3
            r6.r0(r3)
            androidx.navigation.NavBackStackEntry r3 = new androidx.navigation.NavBackStackEntry
            r3.<init>(r1, r0)
            kotlin.collections.ArrayDeque r0 = r20.x()
            r0.addLast(r3)
            androidx.navigation.NavDestination r0 = r3.f()
            androidx.navigation.NavGraph r0 = r0.n()
            if (r0 == 0) goto L_0x00c7
            int r0 = r0.k()
            androidx.navigation.NavBackStackEntry r0 = r6.y(r0)
            r6.M(r3, r0)
        L_0x00c7:
            r5.g(r3)
            goto L_0x00fb
        L_0x00cb:
            androidx.navigation.NavBackStackEntry$Companion r10 = androidx.navigation.NavBackStackEntry.n
            android.content.Context r11 = r6.f1474a
            androidx.lifecycle.Lifecycle$State r14 = r20.F()
            androidx.navigation.NavControllerViewModel r15 = r6.q
            r18 = 96
            r19 = 0
            r16 = 0
            r17 = 0
            r12 = r21
            r13 = r0
            androidx.navigation.NavBackStackEntry r1 = androidx.navigation.NavBackStackEntry.Companion.b(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r1)
            androidx.navigation.NavController$navigate$4 r10 = new androidx.navigation.NavController$navigate$4
            r1 = r21
            r10.<init>(r7, r6, r1, r0)
            r0 = r20
            r1 = r5
            r3 = r23
            r4 = r24
            r5 = r10
            r0.S(r1, r2, r3, r4, r5)
        L_0x00fa:
            r2 = r8
        L_0x00fb:
            r20.t0()
            java.util.Map r0 = r6.x
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x0108:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0118
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavController$NavControllerNavigatorState r1 = (androidx.navigation.NavController.NavControllerNavigatorState) r1
            r1.i(r8)
            goto L_0x0108
        L_0x0118:
            if (r9 != 0) goto L_0x0125
            boolean r0 = r7.element
            if (r0 != 0) goto L_0x0125
            if (r2 == 0) goto L_0x0121
            goto L_0x0125
        L_0x0121:
            r20.s0()
            goto L_0x0128
        L_0x0125:
            r20.s()
        L_0x0128:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.R(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):void");
    }

    public final void S(Navigator navigator, List list, NavOptions navOptions, Navigator.Extras extras, Function1 function1) {
        this.y = function1;
        navigator.e(list, navOptions, extras);
        this.y = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r0 = r0.getIntent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean T() {
        /*
            r2 = this;
            int r0 = r2.D()
            r1 = 1
            if (r0 != r1) goto L_0x002e
            android.app.Activity r0 = r2.b
            r1 = 0
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            r0 = r1
            goto L_0x0019
        L_0x000e:
            android.content.Intent r0 = r0.getIntent()
            if (r0 != 0) goto L_0x0015
            goto L_0x000c
        L_0x0015:
            android.os.Bundle r0 = r0.getExtras()
        L_0x0019:
            if (r0 != 0) goto L_0x001c
            goto L_0x0022
        L_0x001c:
            java.lang.String r1 = "android-support-nav:controller:deepLinkIds"
            int[] r1 = r0.getIntArray(r1)
        L_0x0022:
            if (r1 == 0) goto L_0x0029
            boolean r2 = r2.p0()
            return r2
        L_0x0029:
            boolean r2 = r2.q0()
            return r2
        L_0x002e:
            boolean r2 = r2.V()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.T():boolean");
    }

    public final void U(Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.e;
        if (!(bundle2 == null || (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) == null)) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                NavigatorProvider navigatorProvider = this.w;
                Intrinsics.checkNotNullExpressionValue(next, "name");
                Navigator d2 = navigatorProvider.d(next);
                Bundle bundle3 = bundle2.getBundle(next);
                if (bundle3 != null) {
                    d2.h(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f;
        if (parcelableArr != null) {
            int length = parcelableArr.length;
            int i2 = 0;
            while (i2 < length) {
                Parcelable parcelable = parcelableArr[i2];
                i2++;
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                NavDestination u2 = u(navBackStackEntryState.getDestinationId());
                if (u2 != null) {
                    NavBackStackEntry instantiate = navBackStackEntryState.instantiate(A(), u2, F(), this.q);
                    Navigator d3 = this.w.d(u2.m());
                    Map map = this.x;
                    Object obj = map.get(d3);
                    if (obj == null) {
                        obj = new NavControllerNavigatorState(this, d3);
                        map.put(d3, obj);
                    }
                    x().add(instantiate);
                    ((NavControllerNavigatorState) obj).k(instantiate);
                    NavGraph n2 = instantiate.f().n();
                    if (n2 != null) {
                        M(instantiate, y(n2.k()));
                    }
                } else {
                    String b2 = NavDestination.j.b(A(), navBackStackEntryState.getDestinationId());
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + b2 + " cannot be found from the current destination " + C());
                }
            }
            t0();
            this.f = null;
        }
        Collection values = this.w.e().values();
        ArrayList<Navigator> arrayList = new ArrayList<>();
        for (Object next2 : values) {
            if (!((Navigator) next2).c()) {
                arrayList.add(next2);
            }
        }
        for (Navigator navigator : arrayList) {
            Map map2 = this.x;
            Object obj2 = map2.get(navigator);
            if (obj2 == null) {
                obj2 = new NavControllerNavigatorState(this, navigator);
                map2.put(navigator, obj2);
            }
            navigator.f((NavControllerNavigatorState) obj2);
        }
        if (this.d == null || !x().isEmpty()) {
            s();
            return;
        }
        if (!this.g && (activity = this.b) != null) {
            Intrinsics.checkNotNull(activity);
            if (J(activity.getIntent())) {
                return;
            }
        }
        NavGraph navGraph = this.d;
        Intrinsics.checkNotNull(navGraph);
        R(navGraph, bundle, (NavOptions) null, (Navigator.Extras) null);
    }

    public boolean V() {
        if (x().isEmpty()) {
            return false;
        }
        NavDestination C2 = C();
        Intrinsics.checkNotNull(C2);
        return W(C2.k(), true);
    }

    public boolean W(int i2, boolean z2) {
        return X(i2, z2, false);
    }

    public boolean X(int i2, boolean z2, boolean z3) {
        return a0(i2, z2, z3) && s();
    }

    public final void Y(NavBackStackEntry navBackStackEntry, Function0 function0) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
        Intrinsics.checkNotNullParameter(function0, "onComplete");
        int indexOf = x().indexOf(navBackStackEntry);
        if (indexOf < 0) {
            Log.i("NavController", "Ignoring pop of " + navBackStackEntry + " as it was not found on the current back stack");
            return;
        }
        int i2 = indexOf + 1;
        if (i2 != x().size()) {
            a0(((NavBackStackEntry) x().get(i2)).f().k(), true, false);
        }
        d0(this, navBackStackEntry, false, (ArrayDeque) null, 6, (Object) null);
        function0.invoke();
        t0();
        s();
    }

    public final void Z(Navigator navigator, NavBackStackEntry navBackStackEntry, boolean z2, Function1 function1) {
        this.z = function1;
        navigator.j(navBackStackEntry, z2);
        this.z = null;
    }

    public final boolean a0(int i2, boolean z2, boolean z3) {
        NavDestination navDestination;
        int i3 = i2;
        boolean z4 = z3;
        if (x().isEmpty()) {
            return false;
        }
        ArrayList<Navigator> arrayList = new ArrayList<>();
        Iterator it = CollectionsKt.reversed(x()).iterator();
        while (true) {
            if (!it.hasNext()) {
                navDestination = null;
                break;
            }
            NavDestination f2 = ((NavBackStackEntry) it.next()).f();
            Navigator d2 = this.w.d(f2.m());
            if (z2 || f2.k() != i3) {
                arrayList.add(d2);
            }
            if (f2.k() == i3) {
                navDestination = f2;
                break;
            }
        }
        if (navDestination == null) {
            String b2 = NavDestination.j.b(this.f1474a, i3);
            Log.i("NavController", "Ignoring popBackStack to destination " + b2 + " as it was not found on the current back stack");
            return false;
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        ArrayDeque arrayDeque = new ArrayDeque();
        for (Navigator Z : arrayList) {
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            NavController$popBackStackInternal$2 navController$popBackStackInternal$2 = r0;
            NavController$popBackStackInternal$2 navController$popBackStackInternal$22 = new NavController$popBackStackInternal$2(booleanRef2, booleanRef, this, z3, arrayDeque);
            Z(Z, (NavBackStackEntry) x().last(), z4, navController$popBackStackInternal$2);
            if (!booleanRef2.element) {
                break;
            }
        }
        if (z4) {
            if (!z2) {
                for (NavDestination k2 : SequencesKt.takeWhile(SequencesKt.generateSequence(navDestination, NavController$popBackStackInternal$3.INSTANCE), new NavController$popBackStackInternal$4(this))) {
                    Map map = this.m;
                    Integer valueOf = Integer.valueOf(k2.k());
                    NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) arrayDeque.firstOrNull();
                    map.put(valueOf, navBackStackEntryState == null ? null : navBackStackEntryState.getId());
                }
            }
            if (!arrayDeque.isEmpty()) {
                NavBackStackEntryState navBackStackEntryState2 = (NavBackStackEntryState) arrayDeque.first();
                for (NavDestination k3 : SequencesKt.takeWhile(SequencesKt.generateSequence(u(navBackStackEntryState2.getDestinationId()), NavController$popBackStackInternal$6.INSTANCE), new NavController$popBackStackInternal$7(this))) {
                    this.m.put(Integer.valueOf(k3.k()), navBackStackEntryState2.getId());
                }
                this.n.put(navBackStackEntryState2.getId(), arrayDeque);
            }
        }
        t0();
        return booleanRef.element;
    }

    public final void c0(NavBackStackEntry navBackStackEntry, boolean z2, ArrayDeque arrayDeque) {
        NavControllerViewModel navControllerViewModel;
        StateFlow c2;
        Set set;
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) x().last();
        if (Intrinsics.areEqual((Object) navBackStackEntry2, (Object) navBackStackEntry)) {
            x().removeLast();
            NavControllerNavigatorState navControllerNavigatorState = (NavControllerNavigatorState) this.x.get(H().d(navBackStackEntry2.f().m()));
            boolean z3 = true;
            if ((navControllerNavigatorState == null || (c2 = navControllerNavigatorState.c()) == null || (set = (Set) c2.getValue()) == null || !set.contains(navBackStackEntry2)) && !this.l.containsKey(navBackStackEntry2)) {
                z3 = false;
            }
            Lifecycle.State b2 = navBackStackEntry2.getLifecycle().b();
            Lifecycle.State state = Lifecycle.State.CREATED;
            if (b2.isAtLeast(state)) {
                if (z2) {
                    navBackStackEntry2.m(state);
                    arrayDeque.addFirst(new NavBackStackEntryState(navBackStackEntry2));
                }
                if (!z3) {
                    navBackStackEntry2.m(Lifecycle.State.DESTROYED);
                    r0(navBackStackEntry2);
                } else {
                    navBackStackEntry2.m(state);
                }
            }
            if (!z2 && !z3 && (navControllerViewModel = this.q) != null) {
                navControllerViewModel.d(navBackStackEntry2.g());
                return;
            }
            return;
        }
        throw new IllegalStateException(("Attempted to pop " + navBackStackEntry.f() + ", which is not the top of the back stack (" + navBackStackEntry2.f() + ')').toString());
    }

    public final List e0() {
        ArrayList arrayList = new ArrayList();
        for (NavControllerNavigatorState c2 : this.x.values()) {
            ArrayList arrayList2 = new ArrayList();
            for (Object next : (Iterable) c2.c().getValue()) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) next;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
                    arrayList2.add(next);
                }
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        ArrayDeque x2 = x();
        ArrayList arrayList3 = new ArrayList();
        for (Object next2 : x2) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) next2;
            if (!arrayList.contains(navBackStackEntry2) && navBackStackEntry2.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
                arrayList3.add(next2);
            }
        }
        CollectionsKt.addAll(arrayList, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object next3 : arrayList) {
            if (!(((NavBackStackEntry) next3).f() instanceof NavGraph)) {
                arrayList4.add(next3);
            }
        }
        return arrayList4;
    }

    public void f0(OnDestinationChangedListener onDestinationChangedListener) {
        Intrinsics.checkNotNullParameter(onDestinationChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.r.remove(onDestinationChangedListener);
    }

    public void g0(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(this.f1474a.getClassLoader());
            this.e = bundle.getBundle("android-support-nav:controller:navigatorState");
            this.f = bundle.getParcelableArray("android-support-nav:controller:backStack");
            this.n.clear();
            int[] intArray = bundle.getIntArray("android-support-nav:controller:backStackDestIds");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("android-support-nav:controller:backStackIds");
            if (!(intArray == null || stringArrayList == null)) {
                int length = intArray.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = intArray[i2];
                    i2++;
                    this.m.put(Integer.valueOf(i4), stringArrayList.get(i3));
                    i3++;
                }
            }
            ArrayList<String> stringArrayList2 = bundle.getStringArrayList("android-support-nav:controller:backStackStates");
            if (stringArrayList2 != null) {
                for (String str : stringArrayList2) {
                    Parcelable[] parcelableArray = bundle.getParcelableArray(Intrinsics.stringPlus("android-support-nav:controller:backStackStates:", str));
                    if (parcelableArray != null) {
                        Map map = this.n;
                        Intrinsics.checkNotNullExpressionValue(str, "id");
                        ArrayDeque arrayDeque = new ArrayDeque(parcelableArray.length);
                        Iterator it = ArrayIteratorKt.iterator(parcelableArray);
                        while (it.hasNext()) {
                            Parcelable parcelable = (Parcelable) it.next();
                            if (parcelable != null) {
                                arrayDeque.add((NavBackStackEntryState) parcelable);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        map.put(str, arrayDeque);
                    }
                }
            }
            this.g = bundle.getBoolean("android-support-nav:controller:deepLinkHandled");
        }
    }

    public final boolean h0(int i2, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        NavBackStackEntry navBackStackEntry;
        NavDestination f2;
        if (!this.m.containsKey(Integer.valueOf(i2))) {
            return false;
        }
        String str = (String) this.m.get(Integer.valueOf(i2));
        CollectionsKt.removeAll(this.m.values(), new NavController$restoreStateInternal$1(str));
        List K = K((ArrayDeque) this.n.remove(str));
        ArrayList<List> arrayList = new ArrayList<>();
        ArrayList<NavBackStackEntry> arrayList2 = new ArrayList<>();
        for (Object next : K) {
            if (!(((NavBackStackEntry) next).f() instanceof NavGraph)) {
                arrayList2.add(next);
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayList2) {
            List list = (List) CollectionsKt.lastOrNull(arrayList);
            String str2 = null;
            if (!(list == null || (navBackStackEntry = (NavBackStackEntry) CollectionsKt.last(list)) == null || (f2 = navBackStackEntry.f()) == null)) {
                str2 = f2.m();
            }
            if (Intrinsics.areEqual((Object) str2, (Object) navBackStackEntry2.f().m())) {
                list.add(navBackStackEntry2);
            } else {
                arrayList.add(CollectionsKt.mutableListOf(navBackStackEntry2));
            }
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        for (List list2 : arrayList) {
            S(this.w.d(((NavBackStackEntry) CollectionsKt.first(list2)).f().m()), list2, navOptions, extras, new NavController$restoreStateInternal$4(booleanRef, K, new Ref.IntRef(), this, bundle));
        }
        return booleanRef.element;
    }

    public Bundle i0() {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = new Bundle();
        for (Map.Entry entry : this.w.e().entrySet()) {
            String str = (String) entry.getKey();
            Bundle i2 = ((Navigator) entry.getValue()).i();
            if (i2 != null) {
                arrayList.add(str);
                bundle2.putBundle(str, i2);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle = new Bundle();
            bundle2.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle.putBundle("android-support-nav:controller:navigatorState", bundle2);
        } else {
            bundle = null;
        }
        if (!x().isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[x().size()];
            Iterator it = x().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                parcelableArr[i3] = new NavBackStackEntryState((NavBackStackEntry) it.next());
                i3++;
            }
            bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (!this.m.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int[] iArr = new int[this.m.size()];
            ArrayList arrayList2 = new ArrayList();
            int i4 = 0;
            for (Map.Entry entry2 : this.m.entrySet()) {
                iArr[i4] = ((Number) entry2.getKey()).intValue();
                arrayList2.add((String) entry2.getValue());
                i4++;
            }
            bundle.putIntArray("android-support-nav:controller:backStackDestIds", iArr);
            bundle.putStringArrayList("android-support-nav:controller:backStackIds", arrayList2);
        }
        if (!this.n.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            ArrayList arrayList3 = new ArrayList();
            for (Map.Entry entry3 : this.n.entrySet()) {
                String str2 = (String) entry3.getKey();
                ArrayDeque arrayDeque = (ArrayDeque) entry3.getValue();
                arrayList3.add(str2);
                Parcelable[] parcelableArr2 = new Parcelable[arrayDeque.size()];
                int i5 = 0;
                for (Object next : arrayDeque) {
                    int i6 = i5 + 1;
                    if (i5 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    parcelableArr2[i5] = (NavBackStackEntryState) next;
                    i5 = i6;
                }
                bundle.putParcelableArray(Intrinsics.stringPlus("android-support-nav:controller:backStackStates:", str2), parcelableArr2);
            }
            bundle.putStringArrayList("android-support-nav:controller:backStackStates", arrayList3);
        }
        if (this.g) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", this.g);
        }
        return bundle;
    }

    public void j0(int i2) {
        l0(G().b(i2), (Bundle) null);
    }

    public void k0(int i2, Bundle bundle) {
        l0(G().b(i2), bundle);
    }

    public void l0(NavGraph navGraph, Bundle bundle) {
        Intrinsics.checkNotNullParameter(navGraph, "graph");
        if (!Intrinsics.areEqual((Object) this.d, (Object) navGraph)) {
            NavGraph navGraph2 = this.d;
            if (navGraph2 != null) {
                for (Integer num : new ArrayList(this.m.keySet())) {
                    Intrinsics.checkNotNullExpressionValue(num, "id");
                    q(num.intValue());
                }
                b0(this, navGraph2.k(), true, false, 4, (Object) null);
            }
            this.d = navGraph;
            U(bundle);
            return;
        }
        int p2 = navGraph.C().p();
        int i2 = 0;
        while (i2 < p2) {
            int i3 = i2 + 1;
            NavDestination navDestination = (NavDestination) navGraph.C().q(i2);
            NavGraph navGraph3 = this.d;
            Intrinsics.checkNotNull(navGraph3);
            navGraph3.C().o(i2, navDestination);
            ArrayDeque x2 = x();
            ArrayList<NavBackStackEntry> arrayList = new ArrayList<>();
            for (Object next : x2) {
                int k2 = ((NavBackStackEntry) next).f().k();
                if (navDestination != null && k2 == navDestination.k()) {
                    arrayList.add(next);
                }
            }
            for (NavBackStackEntry l2 : arrayList) {
                Intrinsics.checkNotNullExpressionValue(navDestination, "newDestination");
                l2.l(navDestination);
            }
            i2 = i3;
        }
    }

    public void m0(LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        if (!Intrinsics.areEqual((Object) lifecycleOwner, (Object) this.o)) {
            LifecycleOwner lifecycleOwner2 = this.o;
            if (!(lifecycleOwner2 == null || (lifecycle = lifecycleOwner2.getLifecycle()) == null)) {
                lifecycle.d(this.t);
            }
            this.o = lifecycleOwner;
            lifecycleOwner.getLifecycle().a(this.t);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: androidx.navigation.NavGraph} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(androidx.navigation.NavDestination r31, android.os.Bundle r32, androidx.navigation.NavBackStackEntry r33, java.util.List r34) {
        /*
            r30 = this;
            r6 = r30
            r7 = r31
            r15 = r32
            r14 = r33
            r13 = r34
            androidx.navigation.NavDestination r12 = r33.f()
            boolean r0 = r12 instanceof androidx.navigation.FloatingWindow
            if (r0 != 0) goto L_0x004d
        L_0x0012:
            kotlin.collections.ArrayDeque r0 = r30.x()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x004d
            kotlin.collections.ArrayDeque r0 = r30.x()
            java.lang.Object r0 = r0.last()
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
            androidx.navigation.NavDestination r0 = r0.f()
            boolean r0 = r0 instanceof androidx.navigation.FloatingWindow
            if (r0 == 0) goto L_0x004d
            kotlin.collections.ArrayDeque r0 = r30.x()
            java.lang.Object r0 = r0.last()
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
            androidx.navigation.NavDestination r0 = r0.f()
            int r1 = r0.k()
            r4 = 4
            r5 = 0
            r2 = 1
            r3 = 0
            r0 = r30
            boolean r0 = b0(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x004d
            goto L_0x0012
        L_0x004d:
            kotlin.collections.ArrayDeque r5 = new kotlin.collections.ArrayDeque
            r5.<init>()
            boolean r0 = r7 instanceof androidx.navigation.NavGraph
            r18 = 0
            if (r0 == 0) goto L_0x0105
            r0 = r12
        L_0x0059:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.navigation.NavGraph r4 = r0.n()
            if (r4 == 0) goto L_0x00f0
            int r0 = r34.size()
            java.util.ListIterator r0 = r13.listIterator(r0)
        L_0x006a:
            boolean r1 = r0.hasPrevious()
            if (r1 == 0) goto L_0x0082
            java.lang.Object r1 = r0.previous()
            r2 = r1
            androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
            androidx.navigation.NavDestination r2 = r2.f()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r2 == 0) goto L_0x006a
            goto L_0x0084
        L_0x0082:
            r1 = r18
        L_0x0084:
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            if (r1 != 0) goto L_0x00ab
            androidx.navigation.NavBackStackEntry$Companion r8 = androidx.navigation.NavBackStackEntry.n
            android.content.Context r9 = r6.f1474a
            androidx.lifecycle.Lifecycle$State r0 = r30.F()
            androidx.navigation.NavControllerViewModel r1 = r6.q
            r16 = 96
            r17 = 0
            r2 = 0
            r3 = 0
            r10 = r4
            r11 = r32
            r19 = r12
            r12 = r0
            r0 = r13
            r13 = r1
            r1 = r14
            r14 = r2
            r2 = r15
            r15 = r3
            androidx.navigation.NavBackStackEntry r3 = androidx.navigation.NavBackStackEntry.Companion.b(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r8 = r1
            r1 = r3
            goto L_0x00b0
        L_0x00ab:
            r19 = r12
            r0 = r13
            r8 = r14
            r2 = r15
        L_0x00b0:
            r5.addFirst(r1)
            kotlin.collections.ArrayDeque r1 = r30.x()
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x00eb
            kotlin.collections.ArrayDeque r1 = r30.x()
            java.lang.Object r1 = r1.last()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            androidx.navigation.NavDestination r1 = r1.f()
            if (r1 != r4) goto L_0x00eb
            kotlin.collections.ArrayDeque r1 = r30.x()
            java.lang.Object r1 = r1.last()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            r9 = 6
            r10 = 0
            r3 = 0
            r11 = 0
            r12 = r0
            r0 = r30
            r13 = r2
            r2 = r3
            r3 = r11
            r11 = r4
            r4 = r9
            r9 = r5
            r5 = r10
            d0(r0, r1, r2, r3, r4, r5)
            goto L_0x00f7
        L_0x00eb:
            r12 = r0
            r13 = r2
            r11 = r4
            r9 = r5
            goto L_0x00f7
        L_0x00f0:
            r11 = r4
            r9 = r5
            r19 = r12
            r12 = r13
            r8 = r14
            r13 = r15
        L_0x00f7:
            if (r11 == 0) goto L_0x010b
            if (r11 != r7) goto L_0x00fc
            goto L_0x010b
        L_0x00fc:
            r14 = r8
            r5 = r9
            r0 = r11
            r15 = r13
            r13 = r12
            r12 = r19
            goto L_0x0059
        L_0x0105:
            r9 = r5
            r19 = r12
            r12 = r13
            r8 = r14
            r13 = r15
        L_0x010b:
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L_0x0114
            r0 = r19
            goto L_0x011e
        L_0x0114:
            java.lang.Object r0 = r9.first()
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
            androidx.navigation.NavDestination r0 = r0.f()
        L_0x011e:
            if (r0 == 0) goto L_0x017a
            int r1 = r0.k()
            androidx.navigation.NavDestination r1 = r6.u(r1)
            if (r1 != 0) goto L_0x017a
            androidx.navigation.NavGraph r0 = r0.n()
            if (r0 == 0) goto L_0x011e
            int r1 = r34.size()
            java.util.ListIterator r1 = r12.listIterator(r1)
        L_0x0138:
            boolean r2 = r1.hasPrevious()
            if (r2 == 0) goto L_0x0150
            java.lang.Object r2 = r1.previous()
            r3 = r2
            androidx.navigation.NavBackStackEntry r3 = (androidx.navigation.NavBackStackEntry) r3
            androidx.navigation.NavDestination r3 = r3.f()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r3 == 0) goto L_0x0138
            goto L_0x0152
        L_0x0150:
            r2 = r18
        L_0x0152:
            androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
            if (r2 != 0) goto L_0x0176
            androidx.navigation.NavBackStackEntry$Companion r20 = androidx.navigation.NavBackStackEntry.n
            android.content.Context r1 = r6.f1474a
            android.os.Bundle r23 = r0.d(r13)
            androidx.lifecycle.Lifecycle$State r24 = r30.F()
            androidx.navigation.NavControllerViewModel r2 = r6.q
            r28 = 96
            r29 = 0
            r26 = 0
            r27 = 0
            r21 = r1
            r22 = r0
            r25 = r2
            androidx.navigation.NavBackStackEntry r2 = androidx.navigation.NavBackStackEntry.Companion.b(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
        L_0x0176:
            r9.addFirst(r2)
            goto L_0x011e
        L_0x017a:
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L_0x0181
            goto L_0x018d
        L_0x0181:
            java.lang.Object r0 = r9.last()
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
            androidx.navigation.NavDestination r0 = r0.f()
            r19 = r0
        L_0x018d:
            kotlin.collections.ArrayDeque r0 = r30.x()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x01d9
            kotlin.collections.ArrayDeque r0 = r30.x()
            java.lang.Object r0 = r0.last()
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
            androidx.navigation.NavDestination r0 = r0.f()
            boolean r0 = r0 instanceof androidx.navigation.NavGraph
            if (r0 == 0) goto L_0x01d9
            kotlin.collections.ArrayDeque r0 = r30.x()
            java.lang.Object r0 = r0.last()
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
            androidx.navigation.NavDestination r0 = r0.f()
            androidx.navigation.NavGraph r0 = (androidx.navigation.NavGraph) r0
            int r1 = r19.k()
            r2 = 0
            androidx.navigation.NavDestination r0 = r0.z(r1, r2)
            if (r0 != 0) goto L_0x01d9
            kotlin.collections.ArrayDeque r0 = r30.x()
            java.lang.Object r0 = r0.last()
            r1 = r0
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            r0 = r30
            d0(r0, r1, r2, r3, r4, r5)
            goto L_0x018d
        L_0x01d9:
            kotlin.collections.ArrayDeque r0 = r30.x()
            java.lang.Object r0 = r0.firstOrNull()
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
            if (r0 != 0) goto L_0x01eb
            java.lang.Object r0 = r9.firstOrNull()
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
        L_0x01eb:
            if (r0 != 0) goto L_0x01f0
            r0 = r18
            goto L_0x01f4
        L_0x01f0:
            androidx.navigation.NavDestination r0 = r0.f()
        L_0x01f4:
            androidx.navigation.NavGraph r1 = r6.d
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x0255
            int r0 = r34.size()
            java.util.ListIterator r0 = r12.listIterator(r0)
        L_0x0204:
            boolean r1 = r0.hasPrevious()
            if (r1 == 0) goto L_0x0222
            java.lang.Object r1 = r0.previous()
            r2 = r1
            androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
            androidx.navigation.NavDestination r2 = r2.f()
            androidx.navigation.NavGraph r3 = r6.d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0204
            r18 = r1
        L_0x0222:
            androidx.navigation.NavBackStackEntry r18 = (androidx.navigation.NavBackStackEntry) r18
            if (r18 != 0) goto L_0x0250
            androidx.navigation.NavBackStackEntry$Companion r19 = androidx.navigation.NavBackStackEntry.n
            android.content.Context r0 = r6.f1474a
            androidx.navigation.NavGraph r1 = r6.d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.navigation.NavGraph r2 = r6.d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            android.os.Bundle r22 = r2.d(r13)
            androidx.lifecycle.Lifecycle$State r23 = r30.F()
            androidx.navigation.NavControllerViewModel r2 = r6.q
            r27 = 96
            r28 = 0
            r25 = 0
            r26 = 0
            r20 = r0
            r21 = r1
            r24 = r2
            androidx.navigation.NavBackStackEntry r18 = androidx.navigation.NavBackStackEntry.Companion.b(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
        L_0x0250:
            r0 = r18
            r9.addFirst(r0)
        L_0x0255:
            java.util.Iterator r0 = r9.iterator()
        L_0x0259:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x02a5
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            androidx.navigation.NavigatorProvider r2 = r6.w
            androidx.navigation.NavDestination r3 = r1.f()
            java.lang.String r3 = r3.m()
            androidx.navigation.Navigator r2 = r2.d(r3)
            java.util.Map r3 = r6.x
            java.lang.Object r2 = r3.get(r2)
            if (r2 == 0) goto L_0x0281
            androidx.navigation.NavController$NavControllerNavigatorState r2 = (androidx.navigation.NavController.NavControllerNavigatorState) r2
            r2.k(r1)
            goto L_0x0259
        L_0x0281:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "NavigatorBackStack for "
            r0.append(r1)
            java.lang.String r1 = r31.m()
            r0.append(r1)
            java.lang.String r1 = " should already be created"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x02a5:
            kotlin.collections.ArrayDeque r0 = r30.x()
            r0.addAll(r9)
            kotlin.collections.ArrayDeque r0 = r30.x()
            r0.add(r8)
            java.util.List r0 = kotlin.collections.CollectionsKt.plus(r9, r8)
            java.util.Iterator r0 = r0.iterator()
        L_0x02bb:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x02dd
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            androidx.navigation.NavDestination r2 = r1.f()
            androidx.navigation.NavGraph r2 = r2.n()
            if (r2 == 0) goto L_0x02bb
            int r2 = r2.k()
            androidx.navigation.NavBackStackEntry r2 = r6.y(r2)
            r6.M(r1, r2)
            goto L_0x02bb
        L_0x02dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.n(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavBackStackEntry, java.util.List):void");
    }

    public void n0(OnBackPressedDispatcher onBackPressedDispatcher) {
        Intrinsics.checkNotNullParameter(onBackPressedDispatcher, "dispatcher");
        if (!Intrinsics.areEqual((Object) onBackPressedDispatcher, (Object) this.p)) {
            LifecycleOwner lifecycleOwner = this.o;
            if (lifecycleOwner != null) {
                this.u.remove();
                this.p = onBackPressedDispatcher;
                onBackPressedDispatcher.i(lifecycleOwner, this.u);
                Lifecycle lifecycle = lifecycleOwner.getLifecycle();
                lifecycle.d(this.t);
                lifecycle.a(this.t);
                return;
            }
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()".toString());
        }
    }

    public void o0(ViewModelStore viewModelStore) {
        Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
        NavControllerViewModel navControllerViewModel = this.q;
        NavControllerViewModel.Companion companion = NavControllerViewModel.b;
        if (!Intrinsics.areEqual((Object) navControllerViewModel, (Object) companion.a(viewModelStore))) {
            if (x().isEmpty()) {
                this.q = companion.a(viewModelStore);
                return;
            }
            throw new IllegalStateException("ViewModelStore should be set before setGraph call".toString());
        }
    }

    public void p(OnDestinationChangedListener onDestinationChangedListener) {
        Intrinsics.checkNotNullParameter(onDestinationChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.r.add(onDestinationChangedListener);
        if (!x().isEmpty()) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) x().last();
            onDestinationChangedListener.x(this, navBackStackEntry.f(), navBackStackEntry.d());
        }
    }

    public final boolean p0() {
        int i2 = 0;
        if (!this.g) {
            return false;
        }
        Activity activity = this.b;
        Intrinsics.checkNotNull(activity);
        Intent intent = activity.getIntent();
        Bundle extras = intent.getExtras();
        Intrinsics.checkNotNull(extras);
        int[] intArray = extras.getIntArray("android-support-nav:controller:deepLinkIds");
        Intrinsics.checkNotNull(intArray);
        Intrinsics.checkNotNullExpressionValue(intArray, "extras!!.getIntArray(KEY_DEEP_LINK_IDS)!!");
        List<Integer> mutableList = ArraysKt.toMutableList(intArray);
        ArrayList parcelableArrayList = extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs");
        int intValue = ((Number) CollectionsKt.removeLast(mutableList)).intValue();
        if (parcelableArrayList != null) {
            Bundle bundle = (Bundle) CollectionsKt.removeLast(parcelableArrayList);
        }
        if (mutableList.isEmpty()) {
            return false;
        }
        NavDestination v2 = v(E(), intValue);
        if (v2 instanceof NavGraph) {
            intValue = NavGraph.p.a((NavGraph) v2).k();
        }
        NavDestination C2 = C();
        if (C2 == null || intValue != C2.k()) {
            return false;
        }
        NavDeepLinkBuilder r2 = r();
        Bundle a2 = BundleKt.a(TuplesKt.to("android-support-nav:controller:deepLinkIntent", intent));
        Bundle bundle2 = extras.getBundle("android-support-nav:controller:deepLinkExtras");
        if (bundle2 != null) {
            a2.putAll(bundle2);
        }
        r2.e(a2);
        for (T next : mutableList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            r2.a(((Number) next).intValue(), parcelableArrayList == null ? null : (Bundle) parcelableArrayList.get(i2));
            i2 = i3;
        }
        r2.b().i();
        Activity activity2 = this.b;
        if (activity2 == null) {
            return true;
        }
        activity2.finish();
        return true;
    }

    public final boolean q(int i2) {
        for (NavControllerNavigatorState i3 : this.x.values()) {
            i3.i(true);
        }
        boolean h0 = h0(i2, (Bundle) null, (NavOptions) null, (Navigator.Extras) null);
        for (NavControllerNavigatorState i4 : this.x.values()) {
            i4.i(false);
        }
        return h0 && a0(i2, true, false);
    }

    public final boolean q0() {
        NavDestination C2 = C();
        Intrinsics.checkNotNull(C2);
        int k2 = C2.k();
        for (NavGraph n2 = C2.n(); n2 != null; n2 = n2.n()) {
            if (n2.E() != k2) {
                Bundle bundle = new Bundle();
                Activity activity = this.b;
                if (activity != null) {
                    Intrinsics.checkNotNull(activity);
                    if (activity.getIntent() != null) {
                        Activity activity2 = this.b;
                        Intrinsics.checkNotNull(activity2);
                        if (activity2.getIntent().getData() != null) {
                            Activity activity3 = this.b;
                            Intrinsics.checkNotNull(activity3);
                            bundle.putParcelable("android-support-nav:controller:deepLinkIntent", activity3.getIntent());
                            NavGraph navGraph = this.d;
                            Intrinsics.checkNotNull(navGraph);
                            Activity activity4 = this.b;
                            Intrinsics.checkNotNull(activity4);
                            Intent intent = activity4.getIntent();
                            Intrinsics.checkNotNullExpressionValue(intent, "activity!!.intent");
                            NavDestination.DeepLinkMatch p2 = navGraph.p(new NavDeepLinkRequest(intent));
                            if (p2 != null) {
                                bundle.putAll(p2.d().d(p2.f()));
                            }
                        }
                    }
                }
                NavDeepLinkBuilder.g(new NavDeepLinkBuilder(this), n2.k(), (Bundle) null, 2, (Object) null).e(bundle).b().i();
                Activity activity5 = this.b;
                if (activity5 == null) {
                    return true;
                }
                activity5.finish();
                return true;
            }
            k2 = n2.k();
        }
        return false;
    }

    public NavDeepLinkBuilder r() {
        return new NavDeepLinkBuilder(this);
    }

    public final NavBackStackEntry r0(NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "child");
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) this.k.remove(navBackStackEntry);
        Integer num = null;
        if (navBackStackEntry2 == null) {
            return null;
        }
        AtomicInteger atomicInteger = (AtomicInteger) this.l.get(navBackStackEntry2);
        if (atomicInteger != null) {
            num = Integer.valueOf(atomicInteger.decrementAndGet());
        }
        if (num != null && num.intValue() == 0) {
            NavControllerNavigatorState navControllerNavigatorState = (NavControllerNavigatorState) this.x.get(this.w.d(navBackStackEntry2.f().m()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.e(navBackStackEntry2);
            }
            this.l.remove(navBackStackEntry2);
        }
        return navBackStackEntry2;
    }

    public final boolean s() {
        while (!x().isEmpty() && (((NavBackStackEntry) x().last()).f() instanceof NavGraph)) {
            d0(this, (NavBackStackEntry) x().last(), false, (ArrayDeque) null, 6, (Object) null);
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) x().lastOrNull();
        if (navBackStackEntry != null) {
            this.C.add(navBackStackEntry);
        }
        this.B++;
        s0();
        int i2 = this.B - 1;
        this.B = i2;
        if (i2 == 0) {
            List<NavBackStackEntry> mutableList = CollectionsKt.toMutableList(this.C);
            this.C.clear();
            for (NavBackStackEntry navBackStackEntry2 : mutableList) {
                Iterator it = this.r.iterator();
                while (it.hasNext()) {
                    ((OnDestinationChangedListener) it.next()).x(this, navBackStackEntry2.f(), navBackStackEntry2.d());
                }
                this.E.b(navBackStackEntry2);
            }
            this.i.b(e0());
        }
        return navBackStackEntry != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0094, code lost:
        r7 = (java.util.Set) (r7 = r7.c()).getValue();
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s0() {
        /*
            r11 = this;
            kotlin.collections.ArrayDeque r0 = r11.x()
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r0)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.Object r1 = kotlin.collections.CollectionsKt.last(r0)
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            androidx.navigation.NavDestination r1 = r1.f()
            boolean r2 = r1 instanceof androidx.navigation.FloatingWindow
            r3 = 0
            if (r2 == 0) goto L_0x003f
            java.util.List r2 = kotlin.collections.CollectionsKt.reversed(r0)
            java.util.Iterator r2 = r2.iterator()
        L_0x0026:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x003f
            java.lang.Object r4 = r2.next()
            androidx.navigation.NavBackStackEntry r4 = (androidx.navigation.NavBackStackEntry) r4
            androidx.navigation.NavDestination r4 = r4.f()
            boolean r5 = r4 instanceof androidx.navigation.NavGraph
            if (r5 != 0) goto L_0x0026
            boolean r5 = r4 instanceof androidx.navigation.FloatingWindow
            if (r5 != 0) goto L_0x0026
            goto L_0x0040
        L_0x003f:
            r4 = r3
        L_0x0040:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.List r5 = kotlin.collections.CollectionsKt.reversed(r0)
            java.util.Iterator r5 = r5.iterator()
        L_0x004d:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00f7
            java.lang.Object r6 = r5.next()
            androidx.navigation.NavBackStackEntry r6 = (androidx.navigation.NavBackStackEntry) r6
            androidx.lifecycle.Lifecycle$State r7 = r6.h()
            androidx.navigation.NavDestination r8 = r6.f()
            if (r1 == 0) goto L_0x00cd
            int r9 = r8.k()
            int r10 = r1.k()
            if (r9 != r10) goto L_0x00cd
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.RESUMED
            if (r7 == r8) goto L_0x00c8
            androidx.navigation.NavigatorProvider r7 = r11.H()
            androidx.navigation.NavDestination r9 = r6.f()
            java.lang.String r9 = r9.m()
            androidx.navigation.Navigator r7 = r7.d(r9)
            java.util.Map r9 = r11.x
            java.lang.Object r7 = r9.get(r7)
            androidx.navigation.NavController$NavControllerNavigatorState r7 = (androidx.navigation.NavController.NavControllerNavigatorState) r7
            if (r7 != 0) goto L_0x008d
        L_0x008b:
            r7 = r3
            goto L_0x00a5
        L_0x008d:
            kotlinx.coroutines.flow.StateFlow r7 = r7.c()
            if (r7 != 0) goto L_0x0094
            goto L_0x008b
        L_0x0094:
            java.lang.Object r7 = r7.getValue()
            java.util.Set r7 = (java.util.Set) r7
            if (r7 != 0) goto L_0x009d
            goto L_0x008b
        L_0x009d:
            boolean r7 = r7.contains(r6)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
        L_0x00a5:
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r9)
            if (r7 != 0) goto L_0x00c3
            java.util.Map r7 = r11.l
            java.lang.Object r7 = r7.get(r6)
            java.util.concurrent.atomic.AtomicInteger r7 = (java.util.concurrent.atomic.AtomicInteger) r7
            if (r7 != 0) goto L_0x00b8
            goto L_0x00bf
        L_0x00b8:
            int r7 = r7.get()
            if (r7 != 0) goto L_0x00bf
            goto L_0x00c3
        L_0x00bf:
            r2.put(r6, r8)
            goto L_0x00c8
        L_0x00c3:
            androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.STARTED
            r2.put(r6, r7)
        L_0x00c8:
            androidx.navigation.NavGraph r1 = r1.n()
            goto L_0x004d
        L_0x00cd:
            if (r4 == 0) goto L_0x00f0
            int r8 = r8.k()
            int r9 = r4.k()
            if (r8 != r9) goto L_0x00f0
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.RESUMED
            if (r7 != r8) goto L_0x00e3
            androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.STARTED
            r6.m(r7)
            goto L_0x00ea
        L_0x00e3:
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.STARTED
            if (r7 == r8) goto L_0x00ea
            r2.put(r6, r8)
        L_0x00ea:
            androidx.navigation.NavGraph r4 = r4.n()
            goto L_0x004d
        L_0x00f0:
            androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.CREATED
            r6.m(r7)
            goto L_0x004d
        L_0x00f7:
            java.util.Iterator r11 = r0.iterator()
        L_0x00fb:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0117
            java.lang.Object r0 = r11.next()
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
            java.lang.Object r1 = r2.get(r0)
            androidx.lifecycle.Lifecycle$State r1 = (androidx.lifecycle.Lifecycle.State) r1
            if (r1 == 0) goto L_0x0113
            r0.m(r1)
            goto L_0x00fb
        L_0x0113:
            r0.n()
            goto L_0x00fb
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.s0():void");
    }

    public void t(boolean z2) {
        this.v = z2;
        t0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        if (D() > 1) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t0() {
        /*
            r2 = this;
            androidx.activity.OnBackPressedCallback r0 = r2.u
            boolean r1 = r2.v
            if (r1 == 0) goto L_0x000e
            int r2 = r2.D()
            r1 = 1
            if (r2 <= r1) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r1 = 0
        L_0x000f:
            r0.setEnabled(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.t0():void");
    }

    public final NavDestination u(int i2) {
        NavGraph navGraph = this.d;
        NavDestination navDestination = null;
        if (navGraph == null) {
            return null;
        }
        Intrinsics.checkNotNull(navGraph);
        if (navGraph.k() == i2) {
            return this.d;
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) x().lastOrNull();
        if (navBackStackEntry != null) {
            navDestination = navBackStackEntry.f();
        }
        if (navDestination == null) {
            navDestination = this.d;
            Intrinsics.checkNotNull(navDestination);
        }
        return v(navDestination, i2);
    }

    public final NavDestination v(NavDestination navDestination, int i2) {
        NavGraph navGraph;
        if (navDestination.k() == i2) {
            return navDestination;
        }
        if (navDestination instanceof NavGraph) {
            navGraph = (NavGraph) navDestination;
        } else {
            navGraph = navDestination.n();
            Intrinsics.checkNotNull(navGraph);
        }
        return navGraph.y(i2);
    }

    public final String w(int[] iArr) {
        NavGraph navGraph = this.d;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            Object obj = null;
            if (i2 >= length) {
                return null;
            }
            int i3 = i2 + 1;
            int i4 = iArr[i2];
            if (i2 == 0) {
                NavGraph navGraph2 = this.d;
                Intrinsics.checkNotNull(navGraph2);
                if (navGraph2.k() == i4) {
                    obj = this.d;
                }
            } else {
                Intrinsics.checkNotNull(navGraph);
                obj = navGraph.y(i4);
            }
            if (obj == null) {
                return NavDestination.j.b(this.f1474a, i4);
            }
            if (i2 != iArr.length - 1 && (obj instanceof NavGraph)) {
                navGraph = (NavGraph) obj;
                while (true) {
                    Intrinsics.checkNotNull(navGraph);
                    if (!(navGraph.y(navGraph.E()) instanceof NavGraph)) {
                        break;
                    }
                    navGraph = (NavGraph) navGraph.y(navGraph.E());
                }
            }
            i2 = i3;
        }
    }

    public ArrayDeque x() {
        return this.h;
    }

    public NavBackStackEntry y(int i2) {
        Object obj;
        ArrayDeque x2 = x();
        ListIterator listIterator = x2.listIterator(x2.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (((NavBackStackEntry) obj).f().k() == i2) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException(("No destination with ID " + i2 + " is on the NavController's back stack. The current destination is " + C()).toString());
    }

    public final NavBackStackEntry z(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "route");
        ArrayDeque x2 = x();
        ListIterator listIterator = x2.listIterator(x2.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (Intrinsics.areEqual((Object) ((NavBackStackEntry) obj).f().o(), (Object) str)) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException(("No destination with route " + str + " is on the NavController's back stack. The current destination is " + C()).toString());
    }
}

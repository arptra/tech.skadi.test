package kotlinx.coroutines.channels;

import com.google.common.primitives.Longs;
import com.honey.account.i.a;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 7 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n+ 8 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 9 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 10 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 11 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,3055:1\n273#1,6:3058\n280#1,68:3065\n374#1,18:3156\n244#1:3174\n269#1,10:3175\n280#1,48:3186\n395#1:3234\n334#1,14:3235\n399#1,3:3250\n244#1:3263\n269#1,10:3264\n280#1,68:3275\n244#1:3353\n269#1,10:3354\n280#1,68:3365\n244#1:3437\n269#1,10:3438\n280#1,68:3449\n886#1,52:3519\n964#1,8:3575\n858#1:3583\n882#1,33:3584\n974#1:3617\n916#1,14:3618\n935#1,3:3633\n979#1,6:3636\n886#1,52:3650\n964#1,8:3706\n858#1:3714\n882#1,33:3715\n974#1:3748\n916#1,14:3749\n935#1,3:3764\n979#1,6:3767\n858#1:3782\n882#1,48:3783\n935#1,3:3832\n858#1:3835\n882#1,48:3836\n935#1,3:3885\n244#1:3897\n269#1,10:3898\n280#1,68:3909\n858#1:3978\n882#1,48:3979\n935#1,3:4028\n1#2:3056\n3038#3:3057\n3038#3:3064\n3038#3:3185\n3038#3:3274\n3038#3:3364\n3038#3:3436\n3038#3:3448\n3038#3:3518\n3038#3:3781\n3038#3:3888\n3038#3:3889\n3052#3:3890\n3052#3:3891\n3051#3:3892\n3051#3:3893\n3051#3:3894\n3052#3:3895\n3051#3:3896\n3038#3:3908\n3039#3:4031\n3038#3:4032\n3038#3:4033\n3038#3:4034\n3039#3:4035\n3038#3:4036\n3039#3:4059\n3038#3:4060\n3038#3:4061\n3039#3:4062\n3038#3:4112\n3039#3:4113\n3039#3:4114\n3039#3:4132\n3039#3:4133\n314#4,9:3133\n323#4,2:3150\n332#4,4:3152\n336#4,8:3253\n314#4,9:3344\n323#4,2:3434\n332#4,4:3571\n336#4,8:3642\n332#4,4:3702\n336#4,8:3773\n220#5:3142\n221#5:3145\n220#5:3146\n221#5:3149\n61#6,2:3143\n61#6,2:3147\n61#6,2:3261\n269#7:3249\n269#7:3343\n269#7:3433\n269#7:3517\n269#7:3977\n882#8:3632\n882#8:3763\n882#8:3831\n882#8:3884\n882#8:4027\n37#9,11:4037\n37#9,11:4048\n72#10,3:4063\n46#10,8:4066\n72#10,3:4074\n46#10,8:4077\n46#10,8:4085\n72#10,3:4093\n46#10,8:4096\n46#10,8:4104\n766#11:4115\n857#11,2:4116\n2310#11,14:4118\n766#11:4134\n857#11,2:4135\n2310#11,14:4137\n766#11:4151\n857#11,2:4152\n2310#11,14:4154\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n*L\n113#1:3058,6\n113#1:3065,68\n154#1:3156,18\n154#1:3174\n154#1:3175,10\n154#1:3186,48\n154#1:3234\n154#1:3235,14\n154#1:3250,3\n194#1:3263\n194#1:3264,10\n194#1:3275,68\n225#1:3353\n225#1:3354,10\n225#1:3365,68\n391#1:3437\n391#1:3438,10\n391#1:3449,68\n667#1:3519,52\n696#1:3575,8\n696#1:3583\n696#1:3584,33\n696#1:3617\n696#1:3618,14\n696#1:3633,3\n696#1:3636,6\n732#1:3650,52\n748#1:3706,8\n748#1:3714\n748#1:3715,33\n748#1:3748\n748#1:3749,14\n748#1:3764,3\n748#1:3767,6\n781#1:3782\n781#1:3783,48\n781#1:3832,3\n971#1:3835\n971#1:3836,48\n971#1:3885,3\n1464#1:3897\n1464#1:3898,10\n1464#1:3909,68\n1512#1:3978\n1512#1:3979,48\n1512#1:4028,3\n70#1:3057\n113#1:3064\n154#1:3185\n194#1:3274\n225#1:3364\n278#1:3436\n391#1:3448\n606#1:3518\n771#1:3781\n1007#1:3888\n1056#1:3889\n1374#1:3890\n1376#1:3891\n1406#1:3892\n1416#1:3893\n1425#1:3894\n1426#1:3895\n1433#1:3896\n1464#1:3908\n1865#1:4031\n1867#1:4032\n1869#1:4033\n1882#1:4034\n1893#1:4035\n1894#1:4036\n2196#1:4059\n2209#1:4060\n2219#1:4061\n2222#1:4062\n2539#1:4112\n2541#1:4113\n2566#1:4114\n2628#1:4132\n2629#1:4133\n134#1:3133,9\n134#1:3150,2\n153#1:3152,4\n153#1:3253,8\n221#1:3344,9\n221#1:3434,2\n695#1:3571,4\n695#1:3642,8\n746#1:3702,4\n746#1:3773,8\n138#1:3142\n138#1:3145\n141#1:3146\n141#1:3149\n138#1:3143,2\n141#1:3147,2\n183#1:3261,2\n154#1:3249\n194#1:3343\n225#1:3433\n391#1:3517\n1464#1:3977\n696#1:3632\n748#1:3763\n781#1:3831\n971#1:3884\n1512#1:4027\n2098#1:4037,11\n2153#1:4048,11\n2361#1:4063,3\n2361#1:4066,8\n2416#1:4074,3\n2416#1:4077,8\n2435#1:4085,8\n2465#1:4093,3\n2465#1:4096,8\n2526#1:4104,8\n2575#1:4115\n2575#1:4116,2\n2576#1:4118,14\n2640#1:4134\n2640#1:4135,2\n2641#1:4137,14\n2681#1:4151\n2681#1:4152,2\n2682#1:4154,14\n*E\n"})
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\bK\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004á\u0001â\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\"\b\u0002\u0010\b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ9\u0010\u0013\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0016\u001a\u00020\u0006*\u00020\u00152\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJG\u0010 \u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!JG\u0010\"\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\"\u0010!J\u0017\u0010$\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0011H\u0003¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0011H\u0002¢\u0006\u0004\b'\u0010%J\u001b\u0010(\u001a\u00020\u001e*\u00020\u001c2\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b(\u0010)J1\u0010+\u001a\u00028\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0004\b+\u0010,J)\u0010-\u001a\u00020\u0006*\u00020\u00152\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b-\u0010\u0017J\u001d\u0010.\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0002¢\u0006\u0004\b.\u0010/J@\u00101\u001a\b\u0012\u0004\u0012\u00028\u0000002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0011H@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b1\u0010,J&\u00102\u001a\u00020\u00062\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000000\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b2\u0010/J9\u00103\u001a\u0004\u0018\u00010\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b3\u00104J9\u00105\u001a\u0004\u0018\u00010\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b5\u00104J)\u00106\u001a\u00020\u001e*\u00020\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u00109J-\u0010;\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0011H\u0002¢\u0006\u0004\b;\u0010<J-\u0010=\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0011H\u0002¢\u0006\u0004\b=\u0010<J\u0019\u0010?\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u0011H\u0002¢\u0006\u0004\b?\u0010@J#\u0010C\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u00002\n\u0010B\u001a\u0006\u0012\u0002\b\u00030AH\u0002¢\u0006\u0004\bC\u0010DJ%\u0010G\u001a\u0004\u0018\u00010\u001c2\b\u0010E\u001a\u0004\u0018\u00010\u001c2\b\u0010F\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\bG\u0010HJ%\u0010I\u001a\u00020\u00062\n\u0010B\u001a\u0006\u0012\u0002\b\u00030A2\b\u0010E\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\bI\u0010JJ\u001b\u0010K\u001a\u00020\u00062\n\u0010B\u001a\u0006\u0012\u0002\b\u00030AH\u0002¢\u0006\u0004\bK\u0010LJ%\u0010M\u001a\u0004\u0018\u00010\u001c2\b\u0010E\u001a\u0004\u0018\u00010\u001c2\b\u0010F\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\bM\u0010HJ%\u0010N\u001a\u0004\u0018\u00010\u001c2\b\u0010E\u001a\u0004\u0018\u00010\u001c2\b\u0010F\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\bN\u0010HJ%\u0010O\u001a\u0004\u0018\u00010\u001c2\b\u0010E\u001a\u0004\u0018\u00010\u001c2\b\u0010F\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\bO\u0010HJ\u000f\u0010P\u001a\u00020\u0006H\u0002¢\u0006\u0004\bP\u00109J\u000f\u0010Q\u001a\u00020\u0006H\u0002¢\u0006\u0004\bQ\u00109J\u000f\u0010R\u001a\u00020\u0006H\u0002¢\u0006\u0004\bR\u00109J\u000f\u0010S\u001a\u00020\u0006H\u0002¢\u0006\u0004\bS\u00109J\u000f\u0010T\u001a\u00020\u0006H\u0002¢\u0006\u0004\bT\u00109J\u001d\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010U\u001a\u00020\u0011H\u0002¢\u0006\u0004\bV\u0010WJ\u0017\u0010X\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0011H\u0002¢\u0006\u0004\bX\u0010@J\u0015\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bY\u0010ZJ\u001d\u0010\\\u001a\u00020\u00112\f\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\b\\\u0010]J\u001d\u0010^\u001a\u00020\u00062\f\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\b^\u0010_J%\u0010a\u001a\u00020\u00062\f\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010`\u001a\u00020\u0011H\u0002¢\u0006\u0004\ba\u0010bJ\u0013\u0010c\u001a\u00020\u0006*\u00020\u0015H\u0002¢\u0006\u0004\bc\u0010dJ\u0013\u0010e\u001a\u00020\u0006*\u00020\u0015H\u0002¢\u0006\u0004\be\u0010dJ\u001b\u0010g\u001a\u00020\u0006*\u00020\u00152\u0006\u0010f\u001a\u00020\u001eH\u0002¢\u0006\u0004\bg\u0010hJ\u001f\u0010k\u001a\u00020\u001e2\u0006\u0010i\u001a\u00020\u00112\u0006\u0010j\u001a\u00020\u001eH\u0002¢\u0006\u0004\bk\u0010lJ-\u0010n\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010m\u001a\u00020\u0011H\u0002¢\u0006\u0004\bn\u0010<J-\u0010q\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010o\u001a\u00020\u00112\f\u0010p\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bq\u0010rJ-\u0010s\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010o\u001a\u00020\u00112\f\u0010p\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bs\u0010rJ5\u0010u\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010o\u001a\u00020\u00112\f\u0010p\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010t\u001a\u00020\u0011H\u0002¢\u0006\u0004\bu\u0010vJ%\u0010w\u001a\u00020\u00062\u0006\u0010o\u001a\u00020\u00112\f\u0010p\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bw\u0010xJ\u0017\u0010z\u001a\u00020\u00062\u0006\u0010y\u001a\u00020\u0011H\u0002¢\u0006\u0004\bz\u0010@J\u0017\u0010{\u001a\u00020\u00062\u0006\u0010y\u001a\u00020\u0011H\u0002¢\u0006\u0004\b{\u0010@J\u001b\u0010|\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b|\u0010\rJ&\u0010}\u001a\b\u0012\u0004\u0012\u00020\u0006002\u0006\u0010\u000b\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b}\u0010~J\u001b\u0010\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0010\rJ\u0012\u0010\u0001\u001a\u00020\u001eH\u0010¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u0001\u00109J\u0011\u0010\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u0001\u00109J\u0016\u0010\u0001\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J%\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u000000H@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u0011H\u0004¢\u0006\u0005\b\u0001\u0010@J\u0019\u0010\u0001\u001a\u00020\u00062\u0006\u0010m\u001a\u00020\u0011H\u0000¢\u0006\u0005\b\u0001\u0010@J'\u0010\u0001\u001a\u00020\u00062\n\u0010B\u001a\u0006\u0012\u0002\b\u00030A2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001cH\u0014¢\u0006\u0005\b\u0001\u0010JJ\u001a\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0001H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u0001\u00109J\u001e\u0010\u0001\u001a\u00020\u001e2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J#\u0010\u0001\u001a\u00020\u00062\u0011\u0010\u0001\u001a\f\u0018\u00010\u0001j\u0005\u0018\u0001`\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u001e2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0010¢\u0006\u0006\b\u0001\u0010\u0001J'\u0010\u0001\u001a\u00020\u001e2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\u001eH\u0014¢\u0006\u0006\b\u0001\u0010\u0001J<\u0010 \u0001\u001a\u00020\u00062(\u0010\u0001\u001a#\u0012\u0019\u0012\u0017\u0018\u00010\u0001¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0006\b \u0001\u0010¡\u0001J\u0012\u0010¢\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0006\b¢\u0001\u0010\u0001J\u0013\u0010¤\u0001\u001a\u00030£\u0001H\u0016¢\u0006\u0006\b¤\u0001\u0010¥\u0001R\u0015\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010'R/\u0010\b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00078\u0000X\u0004¢\u0006\u0007\n\u0005\b:\u0010¦\u0001R\u0001\u0010®\u0001\u001an\u0012\u0019\u0012\u0017\u0012\u0002\b\u00030A¢\u0006\u000e\b\u0001\u0012\t\b\u0001\u0012\u0004\b\b(B\u0012\u0018\u0012\u0016\u0018\u00010\u001c¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(¨\u0001\u0012\u0018\u0012\u0016\u0018\u00010\u001c¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(©\u0001\u0012\u0011\u0012\u000f\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010§\u0001j\u0005\u0018\u0001`ª\u00018\u0002X\u0004¢\u0006\u000f\n\u0006\b«\u0001\u0010¬\u0001\u0012\u0005\b­\u0001\u00109R\u0017\u0010±\u0001\u001a\u00020\u00118BX\u0004¢\u0006\b\u001a\u0006\b¯\u0001\u0010°\u0001R\u0017\u0010³\u0001\u001a\u00020\u001e8BX\u0004¢\u0006\b\u001a\u0006\b²\u0001\u0010\u0001R\u0018\u0010¶\u0001\u001a\u00030\u00018BX\u0004¢\u0006\b\u001a\u0006\b´\u0001\u0010µ\u0001R\u001a\u0010¸\u0001\u001a\u00020\u001e*\u00020\u00118BX\u0004¢\u0006\u0007\u001a\u0005\b·\u0001\u0010%R\u001a\u0010º\u0001\u001a\u00020\u001e*\u00020\u00118BX\u0004¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010%R\u0016\u0010`\u001a\u00020\u00118@X\u0004¢\u0006\b\u001a\u0006\b»\u0001\u0010°\u0001R\u0017\u0010½\u0001\u001a\u00020\u00118@X\u0004¢\u0006\b\u001a\u0006\b¼\u0001\u0010°\u0001R1\u0010Â\u0001\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000¾\u00018VX\u0004¢\u0006\u000f\u0012\u0005\bÁ\u0001\u00109\u001a\u0006\b¿\u0001\u0010À\u0001R%\u0010Ç\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000Ã\u00018VX\u0004¢\u0006\u000f\u0012\u0005\bÆ\u0001\u00109\u001a\u0006\bÄ\u0001\u0010Å\u0001R.\u0010Ê\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000000Ã\u00018VX\u0004ø\u0001\u0000¢\u0006\u000f\u0012\u0005\bÉ\u0001\u00109\u001a\u0006\bÈ\u0001\u0010Å\u0001R\u001a\u0010Ì\u0001\u001a\u0005\u0018\u00010\u00018DX\u0004¢\u0006\b\u001a\u0006\bË\u0001\u0010µ\u0001R\u0018\u0010Î\u0001\u001a\u00030\u00018DX\u0004¢\u0006\b\u001a\u0006\bÍ\u0001\u0010µ\u0001R\u0017\u0010Ð\u0001\u001a\u00020\u001e8TX\u0004¢\u0006\b\u001a\u0006\bÏ\u0001\u0010\u0001R\u001e\u0010Ó\u0001\u001a\u00020\u001e8VX\u0004¢\u0006\u000f\u0012\u0005\bÒ\u0001\u00109\u001a\u0006\bÑ\u0001\u0010\u0001R\u001d\u0010j\u001a\u00020\u001e8VX\u0004¢\u0006\u000f\u0012\u0005\bÕ\u0001\u00109\u001a\u0006\bÔ\u0001\u0010\u0001R\u0015\u0010×\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0Ö\u00018\u0002X\u0004R\r\u0010Ù\u0001\u001a\u00030Ø\u00018\u0002X\u0004R\u0019\u0010Ú\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0Ö\u00018\u0002X\u0004R\u0015\u0010Û\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0Ö\u00018\u0002X\u0004R\r\u0010Ü\u0001\u001a\u00030Ø\u00018\u0002X\u0004R\u0019\u0010Ý\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0Ö\u00018\u0002X\u0004R\r\u0010Þ\u0001\u001a\u00030Ø\u00018\u0002X\u0004R\u0019\u0010ß\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0Ö\u00018\u0002X\u0004R\r\u0010à\u0001\u001a\u00030Ø\u00018\u0002X\u0004\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006ã\u0001"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", "", "capacity", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "element", "y0", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelSegment;", "segment", "index", "", "s", "V0", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Waiter;", "D0", "(Lkotlinx/coroutines/Waiter;Lkotlinx/coroutines/channels/ChannelSegment;I)V", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "z0", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "", "waiter", "", "closed", "e1", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "f1", "curSendersAndCloseStatus", "W0", "(J)Z", "curSenders", "I", "Y0", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "r", "L0", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "C0", "v0", "(Lkotlinx/coroutines/CancellableContinuation;)V", "Lkotlinx/coroutines/channels/ChannelResult;", "K0", "u0", "c1", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLjava/lang/Object;)Ljava/lang/Object;", "d1", "Z0", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/ChannelSegment;I)Z", "T", "()V", "b", "a1", "(Lkotlinx/coroutines/channels/ChannelSegment;IJ)Z", "b1", "nAttempts", "e0", "(J)V", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "x0", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)V", "ignoredParam", "selectResult", "H0", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "M0", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "w0", "(Lkotlinx/coroutines/selects/SelectInstance;)V", "E0", "G0", "F0", "h0", "r0", "q0", "p0", "R", "sendersCur", "Q", "(J)Lkotlinx/coroutines/channels/ChannelSegment;", "P", "N", "()Lkotlinx/coroutines/channels/ChannelSegment;", "lastSegment", "o0", "(Lkotlinx/coroutines/channels/ChannelSegment;)J", "O0", "(Lkotlinx/coroutines/channels/ChannelSegment;)V", "sendersCounter", "M", "(Lkotlinx/coroutines/channels/ChannelSegment;J)V", "P0", "(Lkotlinx/coroutines/Waiter;)V", "Q0", "receiver", "R0", "(Lkotlinx/coroutines/Waiter;Z)V", "sendersAndCloseStatusCur", "isClosedForReceive", "j0", "(JZ)Z", "globalIndex", "i0", "id", "startFrom", "W", "(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", "V", "currentBufferEndCounter", "U", "(JLkotlinx/coroutines/channels/ChannelSegment;J)Lkotlinx/coroutines/channels/ChannelSegment;", "s0", "(JLkotlinx/coroutines/channels/ChannelSegment;)V", "value", "h1", "g1", "L", "q", "(Ljava/lang/Object;)Ljava/lang/Object;", "T0", "X0", "()Z", "B0", "A0", "K", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "y", "x", "()Ljava/lang/Object;", "globalCellIndex", "S", "i1", "N0", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "t0", "", "cause", "h", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "a", "(Ljava/util/concurrent/CancellationException;)V", "J", "cancel", "O", "(Ljava/lang/Throwable;Z)Z", "Lkotlin/ParameterName;", "name", "handler", "p", "(Lkotlin/jvm/functions/Function1;)V", "d0", "", "toString", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "Lkotlin/Function3;", "param", "internalResult", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "c", "Lkotlin/jvm/functions/Function3;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "onUndeliveredElementReceiveCancellationConstructor", "X", "()J", "bufferEndCounter", "n0", "isRendezvousOrUnlimited", "Z", "()Ljava/lang/Throwable;", "receiveException", "l0", "isClosedForSend0", "k0", "isClosedForReceive0", "c0", "a0", "receiversCounter", "Lkotlinx/coroutines/selects/SelectClause2;", "k", "()Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "onSend", "Lkotlinx/coroutines/selects/SelectClause1;", "G", "()Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "onReceive", "t", "getOnReceiveCatching$annotations", "onReceiveCatching", "Y", "closeCause", "b0", "sendException", "m0", "isConflatedDropOldest", "A", "isClosedForSend$annotations", "isClosedForSend", "D", "isClosedForReceive$annotations", "Lkotlinx/atomicfu/AtomicRef;", "_closeCause", "Lkotlinx/atomicfu/AtomicLong;", "bufferEnd", "bufferEndSegment", "closeHandler", "completedExpandBuffersAndPauseFlag", "receiveSegment", "receivers", "sendSegment", "sendersAndCloseStatus", "BufferedChannelIterator", "SendBroadcast", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
public class BufferedChannel<E> implements Channel<E> {
    public static final AtomicLongFieldUpdater d;
    public static final AtomicLongFieldUpdater e;
    public static final AtomicLongFieldUpdater f;
    public static final AtomicLongFieldUpdater g;
    public static final AtomicReferenceFieldUpdater h;
    public static final AtomicReferenceFieldUpdater i;
    public static final AtomicReferenceFieldUpdater j;
    public static final AtomicReferenceFieldUpdater k;
    public static final AtomicReferenceFieldUpdater l;
    @Volatile
    @Nullable
    private volatile Object _closeCause;

    /* renamed from: a  reason: collision with root package name */
    public final int f3751a;
    public final Function1 b;
    @Volatile
    private volatile long bufferEnd;
    @Volatile
    @Nullable
    private volatile Object bufferEndSegment;
    public final Function3 c;
    @Volatile
    @Nullable
    private volatile Object closeHandler;
    @Volatile
    private volatile long completedExpandBuffersAndPauseFlag;
    @Volatile
    @Nullable
    private volatile Object receiveSegment;
    @Volatile
    private volatile long receivers;
    @Volatile
    @Nullable
    private volatile Object sendSegment;
    @Volatile
    private volatile long sendersAndCloseStatus;

    @SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n+ 2 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3055:1\n886#2,52:3056\n964#2,8:3112\n858#2:3120\n882#2,33:3121\n974#2:3154\n916#2,14:3155\n935#2,3:3170\n979#2,6:3173\n332#3,4:3108\n336#3,8:3179\n882#4:3169\n61#5,2:3187\n61#5,2:3190\n1#6:3189\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n*L\n1590#1:3056,52\n1627#1:3112,8\n1627#1:3120\n1627#1:3121,33\n1627#1:3154\n1627#1:3155,14\n1627#1:3170,3\n1627#1:3173,6\n1625#1:3108,4\n1625#1:3179,8\n1627#1:3169\n1663#1:3187,2\n1708#1:3190,2\n*E\n"})
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0006\u001a\u00020\u0005HBø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\f2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u001b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u0015R\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001fR\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\"\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "<init>", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Segment;", "segment", "", "index", "", "b", "(Lkotlinx/coroutines/internal/Segment;I)V", "next", "()Ljava/lang/Object;", "element", "i", "(Ljava/lang/Object;)Z", "j", "()V", "g", "()Z", "Lkotlinx/coroutines/channels/ChannelSegment;", "", "r", "f", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h", "", "Ljava/lang/Object;", "receiveResult", "Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "continuation", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public final class BufferedChannelIterator implements ChannelIterator<E>, Waiter {

        /* renamed from: a  reason: collision with root package name */
        public Object f3752a = BufferedChannelKt.p;
        public CancellableContinuationImpl b;

        public BufferedChannelIterator() {
        }

        public Object a(Continuation continuation) {
            ChannelSegment channelSegment;
            BufferedChannel bufferedChannel = BufferedChannel.this;
            ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.i.get(bufferedChannel);
            while (!bufferedChannel.D()) {
                long andIncrement = BufferedChannel.e.getAndIncrement(bufferedChannel);
                int i = BufferedChannelKt.b;
                long j = andIncrement / ((long) i);
                int i2 = (int) (andIncrement % ((long) i));
                if (channelSegment2.c != j) {
                    ChannelSegment c2 = bufferedChannel.V(j, channelSegment2);
                    if (c2 == null) {
                        continue;
                    } else {
                        channelSegment = c2;
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                Object F = bufferedChannel.c1(channelSegment, i2, andIncrement, (Object) null);
                if (F == BufferedChannelKt.m) {
                    throw new IllegalStateException("unreachable".toString());
                } else if (F == BufferedChannelKt.o) {
                    if (andIncrement < bufferedChannel.c0()) {
                        channelSegment.b();
                    }
                    channelSegment2 = channelSegment;
                } else if (F == BufferedChannelKt.n) {
                    return f(channelSegment, i2, andIncrement, continuation);
                } else {
                    channelSegment.b();
                    this.f3752a = F;
                    return Boxing.boxBoolean(true);
                }
            }
            return Boxing.boxBoolean(g());
        }

        public void b(Segment segment, int i) {
            CancellableContinuationImpl cancellableContinuationImpl = this.b;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.b(segment, i);
            }
        }

        public final Object f(ChannelSegment channelSegment, int i, long j, Continuation continuation) {
            Boolean boxBoolean;
            BufferedChannel bufferedChannel = BufferedChannel.this;
            CancellableContinuationImpl b2 = CancellableContinuationKt.b(IntrinsicsKt.intercepted(continuation));
            try {
                this.b = b2;
                Object F = bufferedChannel.c1(channelSegment, i, j, this);
                if (F == BufferedChannelKt.m) {
                    bufferedChannel.C0(this, channelSegment, i);
                } else {
                    Function1 function1 = null;
                    if (F == BufferedChannelKt.o) {
                        if (j < bufferedChannel.c0()) {
                            channelSegment.b();
                        }
                        ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.i.get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.D()) {
                                h();
                                break;
                            }
                            long andIncrement = BufferedChannel.e.getAndIncrement(bufferedChannel);
                            int i2 = BufferedChannelKt.b;
                            long j2 = andIncrement / ((long) i2);
                            int i3 = (int) (andIncrement % ((long) i2));
                            if (channelSegment2.c != j2) {
                                ChannelSegment c2 = bufferedChannel.V(j2, channelSegment2);
                                if (c2 != null) {
                                    channelSegment2 = c2;
                                }
                            }
                            Object F2 = bufferedChannel.c1(channelSegment2, i3, andIncrement, this);
                            if (F2 == BufferedChannelKt.m) {
                                bufferedChannel.C0(this, channelSegment2, i3);
                                break;
                            } else if (F2 == BufferedChannelKt.o) {
                                if (andIncrement < bufferedChannel.c0()) {
                                    channelSegment2.b();
                                }
                            } else if (F2 != BufferedChannelKt.n) {
                                channelSegment2.b();
                                this.f3752a = F2;
                                this.b = null;
                                boxBoolean = Boxing.boxBoolean(true);
                                Function1 function12 = bufferedChannel.b;
                                if (function12 != null) {
                                    function1 = OnUndeliveredElementKt.a(function12, F2, b2.getContext());
                                }
                            } else {
                                throw new IllegalStateException("unexpected".toString());
                            }
                        }
                    } else {
                        channelSegment.b();
                        this.f3752a = F;
                        this.b = null;
                        boxBoolean = Boxing.boxBoolean(true);
                        Function1 function13 = bufferedChannel.b;
                        if (function13 != null) {
                            function1 = OnUndeliveredElementKt.a(function13, F, b2.getContext());
                        }
                    }
                    b2.m(boxBoolean, function1);
                }
                Object u = b2.u();
                if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return u;
            } catch (Throwable th) {
                b2.K();
                throw th;
            }
        }

        public final boolean g() {
            this.f3752a = BufferedChannelKt.z();
            Throwable Y = BufferedChannel.this.Y();
            if (Y == null) {
                return false;
            }
            throw StackTraceRecoveryKt.a(Y);
        }

        public final void h() {
            CancellableContinuationImpl cancellableContinuationImpl = this.b;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.b = null;
            this.f3752a = BufferedChannelKt.z();
            Throwable Y = BufferedChannel.this.Y();
            if (Y == null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m20constructorimpl(Boolean.FALSE));
                return;
            }
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(Y)));
        }

        public final boolean i(Object obj) {
            CancellableContinuationImpl cancellableContinuationImpl = this.b;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            Function1 function1 = null;
            this.b = null;
            this.f3752a = obj;
            Boolean bool = Boolean.TRUE;
            Function1 function12 = BufferedChannel.this.b;
            if (function12 != null) {
                function1 = OnUndeliveredElementKt.a(function12, obj, cancellableContinuationImpl.getContext());
            }
            return BufferedChannelKt.B(cancellableContinuationImpl, bool, function1);
        }

        public final void j() {
            CancellableContinuationImpl cancellableContinuationImpl = this.b;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.b = null;
            this.f3752a = BufferedChannelKt.z();
            Throwable Y = BufferedChannel.this.Y();
            if (Y == null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m20constructorimpl(Boolean.FALSE));
                return;
            }
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(Y)));
        }

        public Object next() {
            Object obj = this.f3752a;
            if (obj != BufferedChannelKt.p) {
                this.f3752a = BufferedChannelKt.p;
                if (obj != BufferedChannelKt.z()) {
                    return obj;
                }
                throw StackTraceRecoveryKt.a(BufferedChannel.this.Z());
            }
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\f\u001a\u00020\u000b2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "Lkotlinx/coroutines/CancellableContinuation;", "", "cont", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;)V", "Lkotlinx/coroutines/internal/Segment;", "segment", "", "index", "", "b", "(Lkotlinx/coroutines/internal/Segment;I)V", "a", "Lkotlinx/coroutines/CancellableContinuation;", "()Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public static final class SendBroadcast implements Waiter {

        /* renamed from: a  reason: collision with root package name */
        public final CancellableContinuation f3753a;
        public final /* synthetic */ CancellableContinuationImpl b;

        public SendBroadcast(CancellableContinuation cancellableContinuation) {
            this.f3753a = cancellableContinuation;
            Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.b = (CancellableContinuationImpl) cancellableContinuation;
        }

        public final CancellableContinuation a() {
            return this.f3753a;
        }

        public void b(Segment segment, int i) {
            this.b.b(segment, i);
        }
    }

    static {
        Class<BufferedChannel> cls = BufferedChannel.class;
        d = AtomicLongFieldUpdater.newUpdater(cls, "sendersAndCloseStatus");
        e = AtomicLongFieldUpdater.newUpdater(cls, "receivers");
        f = AtomicLongFieldUpdater.newUpdater(cls, "bufferEnd");
        g = AtomicLongFieldUpdater.newUpdater(cls, "completedExpandBuffersAndPauseFlag");
        Class<Object> cls2 = Object.class;
        h = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "sendSegment");
        i = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "receiveSegment");
        j = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "bufferEndSegment");
        k = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_closeCause");
        l = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "closeHandler");
    }

    public BufferedChannel(int i2, Function1 function1) {
        this.f3751a = i2;
        this.b = function1;
        if (i2 >= 0) {
            this.bufferEnd = BufferedChannelKt.A(i2);
            this.completedExpandBuffersAndPauseFlag = X();
            ChannelSegment channelSegment = new ChannelSegment(0, (ChannelSegment) null, this, 3);
            this.sendSegment = channelSegment;
            this.receiveSegment = channelSegment;
            if (n0()) {
                channelSegment = BufferedChannelKt.f3754a;
                Intrinsics.checkNotNull(channelSegment, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment = channelSegment;
            this.c = function1 != null ? new BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1(this) : null;
            this._closeCause = BufferedChannelKt.s;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i2 + ", should be >=0").toString());
    }

    /* access modifiers changed from: private */
    public final Object H0(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.z()) {
            return this;
        }
        throw b0();
    }

    public static /* synthetic */ Object I0(BufferedChannel bufferedChannel, Continuation continuation) {
        ChannelSegment channelSegment = (ChannelSegment) i.get(bufferedChannel);
        while (!bufferedChannel.D()) {
            long andIncrement = e.getAndIncrement(bufferedChannel);
            int i2 = BufferedChannelKt.b;
            long j2 = andIncrement / ((long) i2);
            int i3 = (int) (andIncrement % ((long) i2));
            if (channelSegment.c != j2) {
                ChannelSegment c2 = bufferedChannel.V(j2, channelSegment);
                if (c2 == null) {
                    continue;
                } else {
                    channelSegment = c2;
                }
            }
            Object F = bufferedChannel.c1(channelSegment, i3, andIncrement, (Object) null);
            if (F == BufferedChannelKt.m) {
                throw new IllegalStateException("unexpected".toString());
            } else if (F == BufferedChannelKt.o) {
                if (andIncrement < bufferedChannel.c0()) {
                    channelSegment.b();
                }
            } else if (F == BufferedChannelKt.n) {
                return bufferedChannel.L0(channelSegment, i3, andIncrement, continuation);
            } else {
                channelSegment.b();
                return F;
            }
        }
        throw StackTraceRecoveryKt.a(bufferedChannel.Z());
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object J0(kotlinx.coroutines.channels.BufferedChannel r13, kotlin.coroutines.Continuation r14) {
        /*
            boolean r0 = r14 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.label = r1
        L_0x0012:
            r6 = r0
            goto L_0x001a
        L_0x0014:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r13, r14)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r14 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x003a
            if (r1 != r2) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r14)
            kotlinx.coroutines.channels.ChannelResult r14 = (kotlinx.coroutines.channels.ChannelResult) r14
            java.lang.Object r13 = r14.l()
            goto L_0x00b2
        L_0x0032:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = i
            java.lang.Object r14 = r14.get(r13)
            kotlinx.coroutines.channels.ChannelSegment r14 = (kotlinx.coroutines.channels.ChannelSegment) r14
        L_0x0047:
            boolean r1 = r13.D()
            if (r1 == 0) goto L_0x0058
            kotlinx.coroutines.channels.ChannelResult$Companion r14 = kotlinx.coroutines.channels.ChannelResult.b
            java.lang.Throwable r13 = r13.Y()
            java.lang.Object r13 = r14.a(r13)
            goto L_0x00b2
        L_0x0058:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = e
            long r4 = r1.getAndIncrement(r13)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r7 = (long) r1
            long r7 = r4 / r7
            long r9 = (long) r1
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r14.c
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0077
            kotlinx.coroutines.channels.ChannelSegment r1 = r13.V(r7, r14)
            if (r1 != 0) goto L_0x0076
            goto L_0x0047
        L_0x0076:
            r14 = r1
        L_0x0077:
            r12 = 0
            r7 = r13
            r8 = r14
            r9 = r3
            r10 = r4
            java.lang.Object r1 = r7.c1(r8, r9, r10, r12)
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.m
            if (r1 == r7) goto L_0x00b3
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.o
            if (r1 != r7) goto L_0x0098
            long r7 = r13.c0()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x0047
            r14.b()
            goto L_0x0047
        L_0x0098:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.n
            if (r1 != r7) goto L_0x00a9
            r6.label = r2
            r1 = r13
            r2 = r14
            java.lang.Object r13 = r1.K0(r2, r3, r4, r6)
            if (r13 != r0) goto L_0x00b2
            return r0
        L_0x00a9:
            r14.b()
            kotlinx.coroutines.channels.ChannelResult$Companion r13 = kotlinx.coroutines.channels.ChannelResult.b
            java.lang.Object r13 = r13.c(r1)
        L_0x00b2:
            return r13
        L_0x00b3:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.J0(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object S0(BufferedChannel bufferedChannel, Object obj, Continuation continuation) {
        ChannelSegment channelSegment = (ChannelSegment) h.get(bufferedChannel);
        while (true) {
            long andIncrement = d.getAndIncrement(bufferedChannel);
            long j2 = 1152921504606846975L & andIncrement;
            boolean m = bufferedChannel.l0(andIncrement);
            int i2 = BufferedChannelKt.b;
            long j3 = j2 / ((long) i2);
            int i3 = (int) (j2 % ((long) i2));
            if (channelSegment.c != j3) {
                ChannelSegment d2 = bufferedChannel.W(j3, channelSegment);
                if (d2 != null) {
                    channelSegment = d2;
                } else if (m) {
                    Object y0 = bufferedChannel.y0(obj, continuation);
                    if (y0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return y0;
                    }
                }
            }
            int H = bufferedChannel.e1(channelSegment, i3, obj, j2, (Object) null, m);
            if (H == 0) {
                channelSegment.b();
                break;
            } else if (H == 1) {
                break;
            } else if (H != 2) {
                if (H == 3) {
                    Object V0 = bufferedChannel.V0(channelSegment, i3, obj, j2, continuation);
                    if (V0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return V0;
                    }
                } else if (H == 4) {
                    if (j2 < bufferedChannel.a0()) {
                        channelSegment.b();
                    }
                    Object y02 = bufferedChannel.y0(obj, continuation);
                    if (y02 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return y02;
                    }
                } else if (H == 5) {
                    channelSegment.b();
                }
            } else if (m) {
                channelSegment.p();
                Object y03 = bufferedChannel.y0(obj, continuation);
                if (y03 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return y03;
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00aa, code lost:
        r0 = kotlin.Result.Companion;
        r9.resumeWith(kotlin.Result.m20constructorimpl(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true)));
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b8 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object U0(kotlinx.coroutines.channels.BufferedChannel r18, java.lang.Object r19, kotlin.coroutines.Continuation r20) {
        /*
            r8 = r18
            kotlinx.coroutines.CancellableContinuationImpl r9 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r20)
            r10 = 1
            r9.<init>(r0, r10)
            r9.x()
            kotlin.jvm.functions.Function1 r0 = r8.b
            if (r0 != 0) goto L_0x00cc
            kotlinx.coroutines.channels.BufferedChannel$SendBroadcast r11 = new kotlinx.coroutines.channels.BufferedChannel$SendBroadcast
            r11.<init>(r9)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = h
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
        L_0x0022:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = d
            long r1 = r1.getAndIncrement(r8)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r12 = r1 & r3
            boolean r14 = r8.l0(r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r2 = (long) r1
            long r2 = r12 / r2
            long r4 = (long) r1
            long r4 = r12 % r4
            int r15 = (int) r4
            long r4 = r0.c
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            r16 = 0
            if (r1 == 0) goto L_0x005f
            kotlinx.coroutines.channels.ChannelSegment r1 = r8.W(r2, r0)
            if (r1 != 0) goto L_0x005d
            if (r14 == 0) goto L_0x0022
        L_0x004e:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r16)
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)
            r9.resumeWith(r0)
            goto L_0x00be
        L_0x005d:
            r7 = r1
            goto L_0x0060
        L_0x005f:
            r7 = r0
        L_0x0060:
            r0 = r18
            r1 = r7
            r2 = r15
            r3 = r19
            r4 = r12
            r6 = r11
            r17 = r7
            r7 = r14
            int r0 = r0.e1(r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00b8
            if (r0 == r10) goto L_0x00aa
            r1 = 2
            if (r0 == r1) goto L_0x009e
            r1 = 3
            if (r0 == r1) goto L_0x0092
            r1 = 4
            if (r0 == r1) goto L_0x0086
            r1 = 5
            if (r0 == r1) goto L_0x0080
            goto L_0x0083
        L_0x0080:
            r17.b()
        L_0x0083:
            r0 = r17
            goto L_0x0022
        L_0x0086:
            long r0 = r18.a0()
            int r0 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x004e
            r17.b()
            goto L_0x004e
        L_0x0092:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x009e:
            if (r14 == 0) goto L_0x00a4
            r17.p()
            goto L_0x004e
        L_0x00a4:
            r0 = r17
            r8.D0(r11, r0, r15)
            goto L_0x00be
        L_0x00aa:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)
            r9.resumeWith(r0)
            goto L_0x00be
        L_0x00b8:
            r0 = r17
            r0.b()
            goto L_0x00aa
        L_0x00be:
            java.lang.Object r0 = r9.u()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r1) goto L_0x00cb
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r20)
        L_0x00cb:
            return r0
        L_0x00cc:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.U0(kotlinx.coroutines.channels.BufferedChannel, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void g0(BufferedChannel bufferedChannel, long j2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                j2 = 1;
            }
            bufferedChannel.e0(j2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    public boolean A() {
        return l0(d.get(this));
    }

    public void A0() {
    }

    public void B0() {
    }

    public final void C0(Waiter waiter, ChannelSegment channelSegment, int i2) {
        B0();
        waiter.b(channelSegment, i2);
    }

    public boolean D() {
        return k0(d.get(this));
    }

    public final void D0(Waiter waiter, ChannelSegment channelSegment, int i2) {
        waiter.b(channelSegment, i2 + BufferedChannelKt.b);
    }

    public final Object E0(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.z()) {
            return obj2;
        }
        throw Z();
    }

    public final Object F0(Object obj, Object obj2) {
        return ChannelResult.b(obj2 == BufferedChannelKt.z() ? ChannelResult.b.a(Y()) : ChannelResult.b.c(obj2));
    }

    public SelectClause1 G() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$2, 3), this.c);
    }

    public final Object G0(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.z()) {
            return obj2;
        }
        if (Y() == null) {
            return null;
        }
        throw Z();
    }

    public final boolean I(long j2) {
        return j2 < X() || j2 < a0() + ((long) this.f3751a);
    }

    public boolean J(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return O(th, true);
    }

    public Object K(Continuation continuation) {
        return I0(this, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object K0(kotlinx.coroutines.channels.ChannelSegment r11, int r12, long r13, kotlin.coroutines.Continuation r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1
            r0.<init>(r10, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r10 = r0.L$1
            kotlinx.coroutines.channels.ChannelSegment r10 = (kotlinx.coroutines.channels.ChannelSegment) r10
            java.lang.Object r10 = r0.L$0
            kotlinx.coroutines.channels.BufferedChannel r10 = (kotlinx.coroutines.channels.BufferedChannel) r10
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0134
        L_0x0032:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r15)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.I$0 = r12
            r0.J$0 = r13
            r0.label = r3
            kotlin.coroutines.Continuation r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            kotlinx.coroutines.CancellableContinuationImpl r15 = kotlinx.coroutines.CancellableContinuationKt.b(r15)
            kotlinx.coroutines.channels.ReceiveCatching r8 = new kotlinx.coroutines.channels.ReceiveCatching     // Catch:{ all -> 0x006d }
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$35>>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15, r2)     // Catch:{ all -> 0x006d }
            r8.<init>(r15)     // Catch:{ all -> 0x006d }
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r7 = r8
            java.lang.Object r2 = r2.c1(r3, r4, r5, r7)     // Catch:{ all -> 0x006d }
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.m     // Catch:{ all -> 0x006d }
            if (r2 != r3) goto L_0x0070
            r10.C0(r8, r11, r12)     // Catch:{ all -> 0x006d }
            goto L_0x0124
        L_0x006d:
            r10 = move-exception
            goto L_0x013b
        L_0x0070:
            kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.channels.BufferedChannelKt.o     // Catch:{ all -> 0x006d }
            r9 = 0
            if (r2 != r12) goto L_0x010a
            long r2 = r10.c0()     // Catch:{ all -> 0x006d }
            int r12 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x0082
            r11.b()     // Catch:{ all -> 0x006d }
        L_0x0082:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r11 = i     // Catch:{ all -> 0x006d }
            java.lang.Object r11 = r11.get(r10)     // Catch:{ all -> 0x006d }
            kotlinx.coroutines.channels.ChannelSegment r11 = (kotlinx.coroutines.channels.ChannelSegment) r11     // Catch:{ all -> 0x006d }
        L_0x008c:
            boolean r12 = r10.D()     // Catch:{ all -> 0x006d }
            if (r12 == 0) goto L_0x0097
            r10.u0(r15)     // Catch:{ all -> 0x006d }
            goto L_0x0124
        L_0x0097:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r12 = e     // Catch:{ all -> 0x006d }
            long r12 = r12.getAndIncrement(r10)     // Catch:{ all -> 0x006d }
            int r14 = kotlinx.coroutines.channels.BufferedChannelKt.b     // Catch:{ all -> 0x006d }
            long r2 = (long) r14     // Catch:{ all -> 0x006d }
            long r2 = r12 / r2
            long r4 = (long) r14     // Catch:{ all -> 0x006d }
            long r4 = r12 % r4
            int r14 = (int) r4     // Catch:{ all -> 0x006d }
            long r4 = r11.c     // Catch:{ all -> 0x006d }
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00b6
            kotlinx.coroutines.channels.ChannelSegment r2 = r10.V(r2, r11)     // Catch:{ all -> 0x006d }
            if (r2 != 0) goto L_0x00b5
            goto L_0x008c
        L_0x00b5:
            r11 = r2
        L_0x00b6:
            r2 = r10
            r3 = r11
            r4 = r14
            r5 = r12
            r7 = r8
            java.lang.Object r2 = r2.c1(r3, r4, r5, r7)     // Catch:{ all -> 0x006d }
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.m     // Catch:{ all -> 0x006d }
            if (r2 != r3) goto L_0x00c9
            r10.C0(r8, r11, r14)     // Catch:{ all -> 0x006d }
            goto L_0x0124
        L_0x00c9:
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.o     // Catch:{ all -> 0x006d }
            if (r2 != r14) goto L_0x00db
            long r2 = r10.c0()     // Catch:{ all -> 0x006d }
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x008c
            r11.b()     // Catch:{ all -> 0x006d }
            goto L_0x008c
        L_0x00db:
            kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.channels.BufferedChannelKt.n     // Catch:{ all -> 0x006d }
            if (r2 == r12) goto L_0x00fe
            r11.b()     // Catch:{ all -> 0x006d }
            kotlinx.coroutines.channels.ChannelResult$Companion r11 = kotlinx.coroutines.channels.ChannelResult.b     // Catch:{ all -> 0x006d }
            java.lang.Object r11 = r11.c(r2)     // Catch:{ all -> 0x006d }
            kotlinx.coroutines.channels.ChannelResult r11 = kotlinx.coroutines.channels.ChannelResult.b(r11)     // Catch:{ all -> 0x006d }
            kotlin.jvm.functions.Function1 r10 = r10.b     // Catch:{ all -> 0x006d }
            if (r10 == 0) goto L_0x00fa
            kotlin.coroutines.CoroutineContext r12 = r15.getContext()     // Catch:{ all -> 0x006d }
            kotlin.jvm.functions.Function1 r9 = kotlinx.coroutines.internal.OnUndeliveredElementKt.a(r10, r2, r12)     // Catch:{ all -> 0x006d }
        L_0x00fa:
            r15.m(r11, r9)     // Catch:{ all -> 0x006d }
            goto L_0x0124
        L_0x00fe:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x006d }
            java.lang.String r11 = "unexpected"
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x006d }
            r10.<init>(r11)     // Catch:{ all -> 0x006d }
            throw r10     // Catch:{ all -> 0x006d }
        L_0x010a:
            r11.b()     // Catch:{ all -> 0x006d }
            kotlinx.coroutines.channels.ChannelResult$Companion r11 = kotlinx.coroutines.channels.ChannelResult.b     // Catch:{ all -> 0x006d }
            java.lang.Object r11 = r11.c(r2)     // Catch:{ all -> 0x006d }
            kotlinx.coroutines.channels.ChannelResult r11 = kotlinx.coroutines.channels.ChannelResult.b(r11)     // Catch:{ all -> 0x006d }
            kotlin.jvm.functions.Function1 r10 = r10.b     // Catch:{ all -> 0x006d }
            if (r10 == 0) goto L_0x00fa
            kotlin.coroutines.CoroutineContext r12 = r15.getContext()     // Catch:{ all -> 0x006d }
            kotlin.jvm.functions.Function1 r9 = kotlinx.coroutines.internal.OnUndeliveredElementKt.a(r10, r2, r12)     // Catch:{ all -> 0x006d }
            goto L_0x00fa
        L_0x0124:
            java.lang.Object r15 = r15.u()
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r15 != r10) goto L_0x0131
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x0131:
            if (r15 != r1) goto L_0x0134
            return r1
        L_0x0134:
            kotlinx.coroutines.channels.ChannelResult r15 = (kotlinx.coroutines.channels.ChannelResult) r15
            java.lang.Object r10 = r15.l()
            return r10
        L_0x013b:
            r15.K()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.K0(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object L(Object obj, Continuation continuation) {
        return S0(this, obj, continuation);
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v2, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: type inference failed for: r7v3, types: [kotlinx.coroutines.Waiter] */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object L0(kotlinx.coroutines.channels.ChannelSegment r9, int r10, long r11, kotlin.coroutines.Continuation r13) {
        /*
            r8 = this;
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r13)
            kotlinx.coroutines.CancellableContinuationImpl r0 = kotlinx.coroutines.CancellableContinuationKt.b(r0)
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r6 = r0
            java.lang.Object r1 = r1.c1(r2, r3, r4, r6)     // Catch:{ all -> 0x001c }
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.m     // Catch:{ all -> 0x001c }
            if (r1 != r2) goto L_0x001f
            r8.C0(r0, r9, r10)     // Catch:{ all -> 0x001c }
            goto L_0x00c6
        L_0x001c:
            r8 = move-exception
            goto L_0x00d4
        L_0x001f:
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.channels.BufferedChannelKt.o     // Catch:{ all -> 0x001c }
            r7 = 0
            if (r1 != r10) goto L_0x00b6
            long r1 = r8.c0()     // Catch:{ all -> 0x001c }
            int r10 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r10 >= 0) goto L_0x0031
            r9.b()     // Catch:{ all -> 0x001c }
        L_0x0031:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r9 = i     // Catch:{ all -> 0x001c }
            java.lang.Object r9 = r9.get(r8)     // Catch:{ all -> 0x001c }
            kotlinx.coroutines.channels.ChannelSegment r9 = (kotlinx.coroutines.channels.ChannelSegment) r9     // Catch:{ all -> 0x001c }
        L_0x003b:
            boolean r10 = r8.D()     // Catch:{ all -> 0x001c }
            if (r10 == 0) goto L_0x0046
            r8.v0(r0)     // Catch:{ all -> 0x001c }
            goto L_0x00c6
        L_0x0046:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r10 = e     // Catch:{ all -> 0x001c }
            long r10 = r10.getAndIncrement(r8)     // Catch:{ all -> 0x001c }
            int r12 = kotlinx.coroutines.channels.BufferedChannelKt.b     // Catch:{ all -> 0x001c }
            long r1 = (long) r12     // Catch:{ all -> 0x001c }
            long r1 = r10 / r1
            long r3 = (long) r12     // Catch:{ all -> 0x001c }
            long r3 = r10 % r3
            int r12 = (int) r3     // Catch:{ all -> 0x001c }
            long r3 = r9.c     // Catch:{ all -> 0x001c }
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0065
            kotlinx.coroutines.channels.ChannelSegment r1 = r8.V(r1, r9)     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0064
            goto L_0x003b
        L_0x0064:
            r9 = r1
        L_0x0065:
            r1 = r8
            r2 = r9
            r3 = r12
            r4 = r10
            r6 = r0
            java.lang.Object r1 = r1.c1(r2, r3, r4, r6)     // Catch:{ all -> 0x001c }
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.m     // Catch:{ all -> 0x001c }
            if (r1 != r2) goto L_0x007f
            boolean r10 = r0 instanceof kotlinx.coroutines.Waiter     // Catch:{ all -> 0x001c }
            if (r10 == 0) goto L_0x0079
            r7 = r0
        L_0x0079:
            if (r7 == 0) goto L_0x00c6
            r8.C0(r7, r9, r12)     // Catch:{ all -> 0x001c }
            goto L_0x00c6
        L_0x007f:
            kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.channels.BufferedChannelKt.o     // Catch:{ all -> 0x001c }
            if (r1 != r12) goto L_0x0091
            long r1 = r8.c0()     // Catch:{ all -> 0x001c }
            int r10 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r10 >= 0) goto L_0x003b
            r9.b()     // Catch:{ all -> 0x001c }
            goto L_0x003b
        L_0x0091:
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.channels.BufferedChannelKt.n     // Catch:{ all -> 0x001c }
            if (r1 == r10) goto L_0x00aa
            r9.b()     // Catch:{ all -> 0x001c }
            kotlin.jvm.functions.Function1 r8 = r8.b     // Catch:{ all -> 0x001c }
            if (r8 == 0) goto L_0x00a6
            kotlin.coroutines.CoroutineContext r9 = r0.getContext()     // Catch:{ all -> 0x001c }
            kotlin.jvm.functions.Function1 r7 = kotlinx.coroutines.internal.OnUndeliveredElementKt.a(r8, r1, r9)     // Catch:{ all -> 0x001c }
        L_0x00a6:
            r0.m(r1, r7)     // Catch:{ all -> 0x001c }
            goto L_0x00c6
        L_0x00aa:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x001c }
            java.lang.String r9 = "unexpected"
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x001c }
            r8.<init>(r9)     // Catch:{ all -> 0x001c }
            throw r8     // Catch:{ all -> 0x001c }
        L_0x00b6:
            r9.b()     // Catch:{ all -> 0x001c }
            kotlin.jvm.functions.Function1 r8 = r8.b     // Catch:{ all -> 0x001c }
            if (r8 == 0) goto L_0x00a6
            kotlin.coroutines.CoroutineContext r9 = r0.getContext()     // Catch:{ all -> 0x001c }
            kotlin.jvm.functions.Function1 r7 = kotlinx.coroutines.internal.OnUndeliveredElementKt.a(r8, r1, r9)     // Catch:{ all -> 0x001c }
            goto L_0x00a6
        L_0x00c6:
            java.lang.Object r8 = r0.u()
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r8 != r9) goto L_0x00d3
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r13)
        L_0x00d3:
            return r8
        L_0x00d4:
            r0.K()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.L0(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void M(ChannelSegment channelSegment, long j2) {
        Object b2 = InlineList.b((Object) null, 1, (DefaultConstructorMarker) null);
        loop0:
        while (channelSegment != null) {
            for (int i2 = BufferedChannelKt.b - 1; -1 < i2; i2--) {
                if ((channelSegment.c * ((long) BufferedChannelKt.b)) + ((long) i2) < j2) {
                    break loop0;
                }
                while (true) {
                    Object w = channelSegment.w(i2);
                    if (w == null || w == BufferedChannelKt.e) {
                        if (channelSegment.r(i2, w, BufferedChannelKt.z())) {
                            channelSegment.p();
                            break;
                        }
                    } else if (w instanceof WaiterEB) {
                        if (channelSegment.r(i2, w, BufferedChannelKt.z())) {
                            b2 = InlineList.e(b2, ((WaiterEB) w).f3760a);
                            channelSegment.x(i2, true);
                            break;
                        }
                    } else if (!(w instanceof Waiter)) {
                        break;
                    } else if (channelSegment.r(i2, w, BufferedChannelKt.z())) {
                        b2 = InlineList.e(b2, w);
                        channelSegment.x(i2, true);
                        break;
                    }
                }
            }
            channelSegment = (ChannelSegment) channelSegment.g();
        }
        if (b2 == null) {
            return;
        }
        if (!(b2 instanceof ArrayList)) {
            P0((Waiter) b2);
            return;
        }
        Intrinsics.checkNotNull(b2, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList arrayList = (ArrayList) b2;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            P0((Waiter) arrayList.get(size));
        }
    }

    public final void M0(SelectInstance selectInstance, Object obj) {
        ChannelSegment channelSegment = (ChannelSegment) i.get(this);
        while (!D()) {
            long andIncrement = e.getAndIncrement(this);
            int i2 = BufferedChannelKt.b;
            long j2 = andIncrement / ((long) i2);
            int i3 = (int) (andIncrement % ((long) i2));
            if (channelSegment.c != j2) {
                ChannelSegment c2 = V(j2, channelSegment);
                if (c2 == null) {
                    continue;
                } else {
                    channelSegment = c2;
                }
            }
            Object F = c1(channelSegment, i3, andIncrement, selectInstance);
            if (F == BufferedChannelKt.m) {
                Waiter waiter = selectInstance instanceof Waiter ? (Waiter) selectInstance : null;
                if (waiter != null) {
                    C0(waiter, channelSegment, i3);
                    return;
                }
                return;
            } else if (F == BufferedChannelKt.o) {
                if (andIncrement < c0()) {
                    channelSegment.b();
                }
            } else if (F != BufferedChannelKt.n) {
                channelSegment.b();
                selectInstance.c(F);
                return;
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
        }
        w0(selectInstance);
    }

    public final ChannelSegment N() {
        ChannelSegment channelSegment = j.get(this);
        ChannelSegment channelSegment2 = (ChannelSegment) h.get(this);
        if (channelSegment2.c > ((ChannelSegment) channelSegment).c) {
            channelSegment = channelSegment2;
        }
        ChannelSegment channelSegment3 = (ChannelSegment) i.get(this);
        if (channelSegment3.c > ((ChannelSegment) channelSegment).c) {
            channelSegment = channelSegment3;
        }
        return (ChannelSegment) ConcurrentLinkedListKt.b((ConcurrentLinkedListNode) channelSegment);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0086, code lost:
        r14.c(kotlin.Unit.INSTANCE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void N0(kotlinx.coroutines.selects.SelectInstance r14, java.lang.Object r15) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = h
            java.lang.Object r0 = r0.get(r13)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
        L_0x000a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = d
            long r1 = r1.getAndIncrement(r13)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r3 = r3 & r1
            boolean r1 = r13.l0(r1)
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r5 = (long) r2
            long r5 = r3 / r5
            long r7 = (long) r2
            long r7 = r3 % r7
            int r2 = (int) r7
            long r7 = r0.c
            int r7 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0039
            kotlinx.coroutines.channels.ChannelSegment r5 = r13.W(r5, r0)
            if (r5 != 0) goto L_0x0038
            if (r1 == 0) goto L_0x000a
        L_0x0033:
            r13.x0(r15, r14)
            goto L_0x0090
        L_0x0038:
            r0 = r5
        L_0x0039:
            r5 = r13
            r6 = r0
            r7 = r2
            r8 = r15
            r9 = r3
            r11 = r14
            r12 = r1
            int r5 = r5.e1(r6, r7, r8, r9, r11, r12)
            if (r5 == 0) goto L_0x008c
            r6 = 1
            if (r5 == r6) goto L_0x0086
            r6 = 2
            if (r5 == r6) goto L_0x0072
            r1 = 3
            if (r5 == r1) goto L_0x0066
            r1 = 4
            if (r5 == r1) goto L_0x005a
            r1 = 5
            if (r5 == r1) goto L_0x0056
            goto L_0x000a
        L_0x0056:
            r0.b()
            goto L_0x000a
        L_0x005a:
            long r1 = r13.a0()
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0033
            r0.b()
            goto L_0x0033
        L_0x0066:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L_0x0072:
            if (r1 == 0) goto L_0x0078
            r0.p()
            goto L_0x0033
        L_0x0078:
            boolean r15 = r14 instanceof kotlinx.coroutines.Waiter
            if (r15 == 0) goto L_0x007f
            kotlinx.coroutines.Waiter r14 = (kotlinx.coroutines.Waiter) r14
            goto L_0x0080
        L_0x007f:
            r14 = 0
        L_0x0080:
            if (r14 == 0) goto L_0x0090
            r13.D0(r14, r0, r2)
            goto L_0x0090
        L_0x0086:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            r14.c(r13)
            goto L_0x0090
        L_0x008c:
            r0.b()
            goto L_0x0086
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.N0(kotlinx.coroutines.selects.SelectInstance, java.lang.Object):void");
    }

    public boolean O(Throwable th, boolean z) {
        if (z) {
            p0();
        }
        boolean a2 = a.a(k, this, BufferedChannelKt.s, th);
        if (z) {
            q0();
        } else {
            r0();
        }
        R();
        t0();
        if (a2) {
            h0();
        }
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b3, code lost:
        r12 = (kotlinx.coroutines.channels.ChannelSegment) r12.g();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void O0(kotlinx.coroutines.channels.ChannelSegment r12) {
        /*
            r11 = this;
            kotlin.jvm.functions.Function1 r0 = r11.b
            r1 = 0
            r2 = 1
            java.lang.Object r3 = kotlinx.coroutines.internal.InlineList.b(r1, r2, r1)
        L_0x0008:
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.b
            int r4 = r4 - r2
        L_0x000b:
            r5 = -1
            if (r5 >= r4) goto L_0x00b3
            long r6 = r12.c
            int r8 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L_0x0016:
            java.lang.Object r8 = r12.w(r4)
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.i
            if (r8 == r9) goto L_0x00bb
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.d
            if (r8 != r9) goto L_0x0048
            long r9 = r11.a0()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x00bb
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r12.r(r4, r8, r9)
            if (r8 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0040
            java.lang.Object r5 = r12.v(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.c(r0, r5, r1)
        L_0x0040:
            r12.s(r4)
            r12.p()
            goto L_0x00af
        L_0x0048:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.e
            if (r8 == r9) goto L_0x00a2
            if (r8 != 0) goto L_0x0051
            goto L_0x00a2
        L_0x0051:
            boolean r9 = r8 instanceof kotlinx.coroutines.Waiter
            if (r9 != 0) goto L_0x006e
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r9 == 0) goto L_0x005a
            goto L_0x006e
        L_0x005a:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.g
            if (r8 == r9) goto L_0x00bb
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.f
            if (r8 != r9) goto L_0x0067
            goto L_0x00bb
        L_0x0067:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.g
            if (r8 == r9) goto L_0x0016
            goto L_0x00af
        L_0x006e:
            long r9 = r11.a0()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x00bb
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r9 == 0) goto L_0x0080
            r9 = r8
            kotlinx.coroutines.channels.WaiterEB r9 = (kotlinx.coroutines.channels.WaiterEB) r9
            kotlinx.coroutines.Waiter r9 = r9.f3760a
            goto L_0x0083
        L_0x0080:
            r9 = r8
            kotlinx.coroutines.Waiter r9 = (kotlinx.coroutines.Waiter) r9
        L_0x0083:
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r12.r(r4, r8, r10)
            if (r8 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0097
            java.lang.Object r5 = r12.v(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.c(r0, r5, r1)
        L_0x0097:
            java.lang.Object r3 = kotlinx.coroutines.internal.InlineList.e(r3, r9)
            r12.s(r4)
            r12.p()
            goto L_0x00af
        L_0x00a2:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r12.r(r4, r8, r9)
            if (r8 == 0) goto L_0x0016
            r12.p()
        L_0x00af:
            int r4 = r4 + -1
            goto L_0x000b
        L_0x00b3:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r12 = r12.g()
            kotlinx.coroutines.channels.ChannelSegment r12 = (kotlinx.coroutines.channels.ChannelSegment) r12
            if (r12 != 0) goto L_0x0008
        L_0x00bb:
            if (r3 == 0) goto L_0x00e1
            boolean r12 = r3 instanceof java.util.ArrayList
            if (r12 != 0) goto L_0x00c7
            kotlinx.coroutines.Waiter r3 = (kotlinx.coroutines.Waiter) r3
            r11.Q0(r3)
            goto L_0x00e1
        L_0x00c7:
            java.lang.String r12 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r12)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r12 = r3.size()
            int r12 = r12 - r2
        L_0x00d3:
            if (r5 >= r12) goto L_0x00e1
            java.lang.Object r0 = r3.get(r12)
            kotlinx.coroutines.Waiter r0 = (kotlinx.coroutines.Waiter) r0
            r11.Q0(r0)
            int r12 = r12 + -1
            goto L_0x00d3
        L_0x00e1:
            if (r1 != 0) goto L_0x00e4
            return
        L_0x00e4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.O0(kotlinx.coroutines.channels.ChannelSegment):void");
    }

    public final void P(long j2) {
        O0(Q(j2));
    }

    public final void P0(Waiter waiter) {
        R0(waiter, true);
    }

    public final ChannelSegment Q(long j2) {
        ChannelSegment N = N();
        if (m0()) {
            long o0 = o0(N);
            if (o0 != -1) {
                S(o0);
            }
        }
        M(N, j2);
        return N;
    }

    public final void Q0(Waiter waiter) {
        R0(waiter, false);
    }

    public final void R() {
        A();
    }

    public final void R0(Waiter waiter, boolean z) {
        if (waiter instanceof SendBroadcast) {
            CancellableContinuation a2 = ((SendBroadcast) waiter).a();
            Result.Companion companion = Result.Companion;
            a2.resumeWith(Result.m20constructorimpl(Boolean.FALSE));
        } else if (waiter instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) waiter;
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(z ? Z() : b0())));
        } else if (waiter instanceof ReceiveCatching) {
            CancellableContinuationImpl cancellableContinuationImpl = ((ReceiveCatching) waiter).f3759a;
            Result.Companion companion3 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m20constructorimpl(ChannelResult.b(ChannelResult.b.a(Y()))));
        } else if (waiter instanceof BufferedChannelIterator) {
            ((BufferedChannelIterator) waiter).j();
        } else if (waiter instanceof SelectInstance) {
            ((SelectInstance) waiter).e(this, BufferedChannelKt.z());
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
        }
    }

    public final void S(long j2) {
        UndeliveredElementException d2;
        ChannelSegment channelSegment = (ChannelSegment) i.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = e;
            long j3 = atomicLongFieldUpdater.get(this);
            if (j2 >= Math.max(((long) this.f3751a) + j3, X())) {
                if (atomicLongFieldUpdater.compareAndSet(this, j3, j3 + 1)) {
                    int i2 = BufferedChannelKt.b;
                    long j4 = j3 / ((long) i2);
                    int i3 = (int) (j3 % ((long) i2));
                    if (channelSegment.c != j4) {
                        ChannelSegment V = V(j4, channelSegment);
                        if (V == null) {
                            continue;
                        } else {
                            channelSegment = V;
                        }
                    }
                    Object c1 = c1(channelSegment, i3, j3, (Object) null);
                    if (c1 != BufferedChannelKt.o) {
                        channelSegment.b();
                        Function1 function1 = this.b;
                        if (!(function1 == null || (d2 = OnUndeliveredElementKt.d(function1, c1, (UndeliveredElementException) null, 2, (Object) null)) == null)) {
                            throw d2;
                        }
                    } else if (j3 < c0()) {
                        channelSegment.b();
                    }
                }
            } else {
                return;
            }
        }
    }

    public final void T() {
        if (!n0()) {
            ChannelSegment channelSegment = (ChannelSegment) j.get(this);
            while (true) {
                long andIncrement = f.getAndIncrement(this);
                int i2 = BufferedChannelKt.b;
                long j2 = andIncrement / ((long) i2);
                if (c0() <= andIncrement) {
                    if (channelSegment.c < j2 && channelSegment.e() != null) {
                        s0(j2, channelSegment);
                    }
                    g0(this, 0, 1, (Object) null);
                    return;
                }
                if (channelSegment.c != j2) {
                    ChannelSegment U = U(j2, channelSegment, andIncrement);
                    if (U == null) {
                        continue;
                    } else {
                        channelSegment = U;
                    }
                }
                if (a1(channelSegment, (int) (andIncrement % ((long) i2)), andIncrement)) {
                    g0(this, 0, 1, (Object) null);
                    return;
                }
                g0(this, 0, 1, (Object) null);
            }
        }
    }

    public Object T0(Object obj, Continuation continuation) {
        return U0(this, obj, continuation);
    }

    public final ChannelSegment U(long j2, ChannelSegment channelSegment, long j3) {
        Object c2;
        long j4 = j2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
        Function2 function2 = (Function2) BufferedChannelKt.y();
        ChannelSegment channelSegment2 = channelSegment;
        loop0:
        while (true) {
            c2 = ConcurrentLinkedListKt.c(channelSegment2, j4, function2);
            if (SegmentOrClosed.e(c2)) {
                break;
            }
            Segment c3 = SegmentOrClosed.c(c2);
            while (true) {
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                if (segment.c >= c3.c) {
                    break loop0;
                } else if (c3.q()) {
                    if (a.a(atomicReferenceFieldUpdater, this, segment, c3)) {
                        if (segment.m()) {
                            segment.k();
                        }
                    } else if (c3.m()) {
                        c3.k();
                    }
                }
            }
        }
        if (SegmentOrClosed.e(c2)) {
            R();
            s0(j2, channelSegment);
            g0(this, 0, 1, (Object) null);
            return null;
        }
        ChannelSegment channelSegment3 = (ChannelSegment) SegmentOrClosed.c(c2);
        long j5 = channelSegment3.c;
        if (j5 <= j4) {
            return channelSegment3;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f;
        int i2 = BufferedChannelKt.b;
        if (atomicLongFieldUpdater.compareAndSet(this, j3 + 1, ((long) i2) * j5)) {
            e0((channelSegment3.c * ((long) i2)) - j3);
            return null;
        }
        g0(this, 0, 1, (Object) null);
        return null;
    }

    public final ChannelSegment V(long j2, ChannelSegment channelSegment) {
        Object c2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
        Function2 function2 = (Function2) BufferedChannelKt.y();
        loop0:
        while (true) {
            c2 = ConcurrentLinkedListKt.c(channelSegment, j2, function2);
            if (SegmentOrClosed.e(c2)) {
                break;
            }
            Segment c3 = SegmentOrClosed.c(c2);
            while (true) {
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                if (segment.c >= c3.c) {
                    break loop0;
                } else if (c3.q()) {
                    if (a.a(atomicReferenceFieldUpdater, this, segment, c3)) {
                        if (segment.m()) {
                            segment.k();
                        }
                    } else if (c3.m()) {
                        c3.k();
                    }
                }
            }
        }
        if (SegmentOrClosed.e(c2)) {
            R();
            if (channelSegment.c * ((long) BufferedChannelKt.b) >= c0()) {
                return null;
            }
            channelSegment.b();
            return null;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) SegmentOrClosed.c(c2);
        if (!n0() && j2 <= X() / ((long) BufferedChannelKt.b)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = j;
            while (true) {
                Segment segment2 = (Segment) atomicReferenceFieldUpdater2.get(this);
                if (segment2.c >= channelSegment2.c || !channelSegment2.q()) {
                    break;
                } else if (a.a(atomicReferenceFieldUpdater2, this, segment2, channelSegment2)) {
                    if (segment2.m()) {
                        segment2.k();
                    }
                } else if (channelSegment2.m()) {
                    channelSegment2.k();
                }
            }
        }
        long j3 = channelSegment2.c;
        if (j3 <= j2) {
            return channelSegment2;
        }
        int i2 = BufferedChannelKt.b;
        g1(j3 * ((long) i2));
        if (channelSegment2.c * ((long) i2) >= c0()) {
            return null;
        }
        channelSegment2.b();
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0125 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object V0(kotlinx.coroutines.channels.ChannelSegment r21, int r22, java.lang.Object r23, long r24, kotlin.coroutines.Continuation r26) {
        /*
            r20 = this;
            r0 = r20
            r9 = r23
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r26)
            kotlinx.coroutines.CancellableContinuationImpl r10 = kotlinx.coroutines.CancellableContinuationKt.b(r1)
            r8 = 0
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r7 = r10
            int r1 = r1.e1(r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x0104
            r11 = 1
            if (r1 == r11) goto L_0x00fb
            r12 = 2
            if (r1 == r12) goto L_0x00f3
            r13 = 4
            if (r1 == r13) goto L_0x00e6
            java.lang.String r14 = "unexpected"
            r15 = 5
            if (r1 != r15) goto L_0x00dc
            r21.b()     // Catch:{ all -> 0x0068 }
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = h     // Catch:{ all -> 0x0068 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0068 }
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1     // Catch:{ all -> 0x0068 }
        L_0x0039:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = d     // Catch:{ all -> 0x0068 }
            long r2 = r2.getAndIncrement(r0)     // Catch:{ all -> 0x0068 }
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r16 = r2 & r4
            boolean r18 = r0.l0(r2)     // Catch:{ all -> 0x0068 }
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.b     // Catch:{ all -> 0x0068 }
            long r3 = (long) r2     // Catch:{ all -> 0x0068 }
            long r3 = r16 / r3
            long r5 = (long) r2     // Catch:{ all -> 0x0068 }
            long r5 = r16 % r5
            int r8 = (int) r5     // Catch:{ all -> 0x0068 }
            long r5 = r1.c     // Catch:{ all -> 0x0068 }
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x006d
            kotlinx.coroutines.channels.ChannelSegment r2 = r0.W(r3, r1)     // Catch:{ all -> 0x0068 }
            if (r2 != 0) goto L_0x006b
            if (r18 == 0) goto L_0x0039
        L_0x0063:
            r0.z0(r9, r10)     // Catch:{ all -> 0x0068 }
            goto L_0x0112
        L_0x0068:
            r0 = move-exception
            goto L_0x0129
        L_0x006b:
            r7 = r2
            goto L_0x006e
        L_0x006d:
            r7 = r1
        L_0x006e:
            r1 = r20
            r2 = r7
            r3 = r8
            r4 = r23
            r5 = r16
            r21 = r7
            r7 = r10
            r19 = r8
            r8 = r18
            int r1 = r1.e1(r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x00ce
            if (r1 == r11) goto L_0x00c2
            if (r1 == r12) goto L_0x00ab
            r2 = 3
            if (r1 == r2) goto L_0x00a1
            if (r1 == r13) goto L_0x0095
            if (r1 == r15) goto L_0x008f
            goto L_0x0092
        L_0x008f:
            r21.b()     // Catch:{ all -> 0x0068 }
        L_0x0092:
            r1 = r21
            goto L_0x0039
        L_0x0095:
            long r1 = r20.a0()     // Catch:{ all -> 0x0068 }
            int r1 = (r16 > r1 ? 1 : (r16 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0063
            r21.b()     // Catch:{ all -> 0x0068 }
            goto L_0x0063
        L_0x00a1:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0068 }
            java.lang.String r1 = r14.toString()     // Catch:{ all -> 0x0068 }
            r0.<init>(r1)     // Catch:{ all -> 0x0068 }
            throw r0     // Catch:{ all -> 0x0068 }
        L_0x00ab:
            if (r18 == 0) goto L_0x00b1
            r21.p()     // Catch:{ all -> 0x0068 }
            goto L_0x0063
        L_0x00b1:
            boolean r1 = r10 instanceof kotlinx.coroutines.Waiter     // Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x00b7
            r1 = r10
            goto L_0x00b8
        L_0x00b7:
            r1 = 0
        L_0x00b8:
            if (r1 == 0) goto L_0x0112
            r3 = r21
            r2 = r19
            r0.D0(r1, r3, r2)     // Catch:{ all -> 0x0068 }
            goto L_0x0112
        L_0x00c2:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0068 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0068 }
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)     // Catch:{ all -> 0x0068 }
        L_0x00ca:
            r10.resumeWith(r0)     // Catch:{ all -> 0x0068 }
            goto L_0x0112
        L_0x00ce:
            r3 = r21
            r3.b()     // Catch:{ all -> 0x0068 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0068 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0068 }
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)     // Catch:{ all -> 0x0068 }
            goto L_0x00ca
        L_0x00dc:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0068 }
            java.lang.String r1 = r14.toString()     // Catch:{ all -> 0x0068 }
            r0.<init>(r1)     // Catch:{ all -> 0x0068 }
            throw r0     // Catch:{ all -> 0x0068 }
        L_0x00e6:
            long r1 = r20.a0()     // Catch:{ all -> 0x0068 }
            int r1 = (r24 > r1 ? 1 : (r24 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0063
            r21.b()     // Catch:{ all -> 0x0068 }
            goto L_0x0063
        L_0x00f3:
            r1 = r21
            r2 = r22
            r0.D0(r10, r1, r2)     // Catch:{ all -> 0x0068 }
            goto L_0x0112
        L_0x00fb:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0068 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0068 }
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)     // Catch:{ all -> 0x0068 }
            goto L_0x00ca
        L_0x0104:
            r1 = r21
            r21.b()     // Catch:{ all -> 0x0068 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0068 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0068 }
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)     // Catch:{ all -> 0x0068 }
            goto L_0x00ca
        L_0x0112:
            java.lang.Object r0 = r10.u()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r1) goto L_0x011f
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r26)
        L_0x011f:
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r1) goto L_0x0126
            return r0
        L_0x0126:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0129:
            r10.K()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.V0(kotlinx.coroutines.channels.ChannelSegment, int, java.lang.Object, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final ChannelSegment W(long j2, ChannelSegment channelSegment) {
        Object c2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
        Function2 function2 = (Function2) BufferedChannelKt.y();
        loop0:
        while (true) {
            c2 = ConcurrentLinkedListKt.c(channelSegment, j2, function2);
            if (SegmentOrClosed.e(c2)) {
                break;
            }
            Segment c3 = SegmentOrClosed.c(c2);
            while (true) {
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                if (segment.c >= c3.c) {
                    break loop0;
                } else if (c3.q()) {
                    if (a.a(atomicReferenceFieldUpdater, this, segment, c3)) {
                        if (segment.m()) {
                            segment.k();
                        }
                    } else if (c3.m()) {
                        c3.k();
                    }
                }
            }
        }
        if (SegmentOrClosed.e(c2)) {
            R();
            if (channelSegment.c * ((long) BufferedChannelKt.b) >= a0()) {
                return null;
            }
            channelSegment.b();
            return null;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) SegmentOrClosed.c(c2);
        long j3 = channelSegment2.c;
        if (j3 <= j2) {
            return channelSegment2;
        }
        int i2 = BufferedChannelKt.b;
        h1(j3 * ((long) i2));
        if (channelSegment2.c * ((long) i2) >= a0()) {
            return null;
        }
        channelSegment2.b();
        return null;
    }

    public final boolean W0(long j2) {
        if (l0(j2)) {
            return false;
        }
        return !I(j2 & 1152921504606846975L);
    }

    public final long X() {
        return f.get(this);
    }

    public boolean X0() {
        return W0(d.get(this));
    }

    public final Throwable Y() {
        return (Throwable) k.get(this);
    }

    public final boolean Y0(Object obj, Object obj2) {
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).e(this, obj2);
        }
        Function1 function1 = null;
        if (obj instanceof ReceiveCatching) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            ReceiveCatching receiveCatching = (ReceiveCatching) obj;
            CancellableContinuationImpl cancellableContinuationImpl = receiveCatching.f3759a;
            ChannelResult b2 = ChannelResult.b(ChannelResult.b.c(obj2));
            Function1 function12 = this.b;
            if (function12 != null) {
                function1 = OnUndeliveredElementKt.a(function12, obj2, receiveCatching.f3759a.getContext());
            }
            return BufferedChannelKt.B(cancellableContinuationImpl, b2, function1);
        } else if (obj instanceof BufferedChannelIterator) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((BufferedChannelIterator) obj).i(obj2);
        } else if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Function1 function13 = this.b;
            if (function13 != null) {
                function1 = OnUndeliveredElementKt.a(function13, obj2, cancellableContinuation.getContext());
            }
            return BufferedChannelKt.B(cancellableContinuation, obj2, function1);
        } else {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
    }

    public final Throwable Z() {
        Throwable Y = Y();
        return Y == null ? new ClosedReceiveChannelException("Channel was closed") : Y;
    }

    public final boolean Z0(Object obj, ChannelSegment channelSegment, int i2) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.C((CancellableContinuation) obj, Unit.INSTANCE, (Function1) null, 2, (Object) null);
        } else if (obj instanceof SelectInstance) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult y = ((SelectImplementation) obj).y(this, Unit.INSTANCE);
            if (y == TrySelectDetailedResult.REREGISTER) {
                channelSegment.s(i2);
            }
            return y == TrySelectDetailedResult.SUCCESSFUL;
        } else if (obj instanceof SendBroadcast) {
            return BufferedChannelKt.C(((SendBroadcast) obj).a(), Boolean.TRUE, (Function1) null, 2, (Object) null);
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
    }

    public final void a(CancellationException cancellationException) {
        J(cancellationException);
    }

    public final long a0() {
        return e.get(this);
    }

    public final boolean a1(ChannelSegment channelSegment, int i2, long j2) {
        Object w = channelSegment.w(i2);
        if (!(w instanceof Waiter) || j2 < e.get(this) || !channelSegment.r(i2, w, BufferedChannelKt.g)) {
            return b1(channelSegment, i2, j2);
        }
        if (Z0(w, channelSegment, i2)) {
            channelSegment.A(i2, BufferedChannelKt.d);
            return true;
        }
        channelSegment.A(i2, BufferedChannelKt.j);
        channelSegment.x(i2, false);
        return false;
    }

    public final Throwable b0() {
        Throwable Y = Y();
        return Y == null ? new ClosedSendChannelException("Channel was closed") : Y;
    }

    public final boolean b1(ChannelSegment channelSegment, int i2, long j2) {
        while (true) {
            Object w = channelSegment.w(i2);
            if (w instanceof Waiter) {
                if (j2 < e.get(this)) {
                    if (channelSegment.r(i2, w, new WaiterEB((Waiter) w))) {
                        return true;
                    }
                } else if (channelSegment.r(i2, w, BufferedChannelKt.g)) {
                    if (Z0(w, channelSegment, i2)) {
                        channelSegment.A(i2, BufferedChannelKt.d);
                        return true;
                    }
                    channelSegment.A(i2, BufferedChannelKt.j);
                    channelSegment.x(i2, false);
                    return false;
                }
            } else if (w == BufferedChannelKt.j) {
                return false;
            } else {
                if (w == null) {
                    if (channelSegment.r(i2, w, BufferedChannelKt.e)) {
                        return true;
                    }
                } else if (w == BufferedChannelKt.d || w == BufferedChannelKt.h || w == BufferedChannelKt.i || w == BufferedChannelKt.k || w == BufferedChannelKt.z()) {
                    return true;
                } else {
                    if (w != BufferedChannelKt.f) {
                        throw new IllegalStateException(("Unexpected cell state: " + w).toString());
                    }
                }
            }
        }
        return true;
    }

    public final long c0() {
        return d.get(this) & 1152921504606846975L;
    }

    public final Object c1(ChannelSegment channelSegment, int i2, long j2, Object obj) {
        Object w = channelSegment.w(i2);
        if (w == null) {
            if (j2 >= (d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return BufferedChannelKt.n;
                }
                if (channelSegment.r(i2, w, obj)) {
                    T();
                    return BufferedChannelKt.m;
                }
            }
        } else if (w == BufferedChannelKt.d && channelSegment.r(i2, w, BufferedChannelKt.i)) {
            T();
            return channelSegment.y(i2);
        }
        return d1(channelSegment, i2, j2, obj);
    }

    public final boolean d0() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
            ChannelSegment channelSegment = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
            long a0 = a0();
            if (c0() <= a0) {
                return false;
            }
            int i2 = BufferedChannelKt.b;
            long j2 = a0 / ((long) i2);
            if (channelSegment.c == j2 || (channelSegment = V(j2, channelSegment)) != null) {
                channelSegment.b();
                if (i0(channelSegment, (int) (a0 % ((long) i2)), a0)) {
                    return true;
                }
                e.compareAndSet(this, a0, a0 + 1);
            } else if (((ChannelSegment) atomicReferenceFieldUpdater.get(this)).c < j2) {
                return false;
            }
        }
    }

    public final Object d1(ChannelSegment channelSegment, int i2, long j2, Object obj) {
        while (true) {
            Object w = channelSegment.w(i2);
            if (w == null || w == BufferedChannelKt.e) {
                if (j2 < (d.get(this) & 1152921504606846975L)) {
                    if (channelSegment.r(i2, w, BufferedChannelKt.h)) {
                        T();
                        return BufferedChannelKt.o;
                    }
                } else if (obj == null) {
                    return BufferedChannelKt.n;
                } else {
                    if (channelSegment.r(i2, w, obj)) {
                        T();
                        return BufferedChannelKt.m;
                    }
                }
            } else if (w == BufferedChannelKt.d) {
                if (channelSegment.r(i2, w, BufferedChannelKt.i)) {
                    T();
                    return channelSegment.y(i2);
                }
            } else if (w == BufferedChannelKt.j) {
                return BufferedChannelKt.o;
            } else {
                if (w == BufferedChannelKt.h) {
                    return BufferedChannelKt.o;
                }
                if (w == BufferedChannelKt.z()) {
                    T();
                    return BufferedChannelKt.o;
                } else if (w != BufferedChannelKt.g && channelSegment.r(i2, w, BufferedChannelKt.f)) {
                    boolean z = w instanceof WaiterEB;
                    if (z) {
                        w = ((WaiterEB) w).f3760a;
                    }
                    if (Z0(w, channelSegment, i2)) {
                        channelSegment.A(i2, BufferedChannelKt.i);
                        T();
                        return channelSegment.y(i2);
                    }
                    channelSegment.A(i2, BufferedChannelKt.j);
                    channelSegment.x(i2, false);
                    if (z) {
                        T();
                    }
                    return BufferedChannelKt.o;
                }
            }
        }
    }

    public final void e0(long j2) {
        if ((g.addAndGet(this, j2) & Longs.MAX_POWER_OF_TWO) != 0) {
            do {
            } while ((g.get(this) & Longs.MAX_POWER_OF_TWO) != 0);
        }
    }

    public final int e1(ChannelSegment channelSegment, int i2, Object obj, long j2, Object obj2, boolean z) {
        channelSegment.B(i2, obj);
        if (z) {
            return f1(channelSegment, i2, obj, j2, obj2, z);
        }
        Object w = channelSegment.w(i2);
        if (w == null) {
            if (I(j2)) {
                if (channelSegment.r(i2, (Object) null, BufferedChannelKt.d)) {
                    return 1;
                }
            } else if (obj2 == null) {
                return 3;
            } else {
                if (channelSegment.r(i2, (Object) null, obj2)) {
                    return 2;
                }
            }
        } else if (w instanceof Waiter) {
            channelSegment.s(i2);
            if (Y0(w, obj)) {
                channelSegment.A(i2, BufferedChannelKt.i);
                A0();
                return 0;
            }
            if (channelSegment.t(i2, BufferedChannelKt.k) != BufferedChannelKt.k) {
                channelSegment.x(i2, true);
            }
            return 5;
        }
        return f1(channelSegment, i2, obj, j2, obj2, z);
    }

    public final int f1(ChannelSegment channelSegment, int i2, Object obj, long j2, Object obj2, boolean z) {
        while (true) {
            Object w = channelSegment.w(i2);
            if (w == null) {
                if (!I(j2) || z) {
                    if (z) {
                        if (channelSegment.r(i2, (Object) null, BufferedChannelKt.j)) {
                            channelSegment.x(i2, false);
                            return 4;
                        }
                    } else if (obj2 == null) {
                        return 3;
                    } else {
                        if (channelSegment.r(i2, (Object) null, obj2)) {
                            return 2;
                        }
                    }
                } else if (channelSegment.r(i2, (Object) null, BufferedChannelKt.d)) {
                    return 1;
                }
            } else if (w == BufferedChannelKt.e) {
                if (channelSegment.r(i2, w, BufferedChannelKt.d)) {
                    return 1;
                }
            } else if (w == BufferedChannelKt.k) {
                channelSegment.s(i2);
                return 5;
            } else if (w == BufferedChannelKt.h) {
                channelSegment.s(i2);
                return 5;
            } else if (w == BufferedChannelKt.z()) {
                channelSegment.s(i2);
                R();
                return 4;
            } else {
                channelSegment.s(i2);
                if (w instanceof WaiterEB) {
                    w = ((WaiterEB) w).f3760a;
                }
                if (Y0(w, obj)) {
                    channelSegment.A(i2, BufferedChannelKt.i);
                    A0();
                    return 0;
                }
                if (channelSegment.t(i2, BufferedChannelKt.k) != BufferedChannelKt.k) {
                    channelSegment.x(i2, true);
                }
                return 5;
            }
        }
    }

    public final void g1(long j2) {
        long j3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = e;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            if (j3 >= j2 || e.compareAndSet(this, j3, j2)) {
            }
            j3 = atomicLongFieldUpdater.get(this);
            return;
        } while (e.compareAndSet(this, j3, j2));
    }

    public boolean h(Throwable th) {
        return O(th, false);
    }

    public final void h0() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!a.a(atomicReferenceFieldUpdater, this, obj, obj == null ? BufferedChannelKt.q : BufferedChannelKt.r));
        if (obj != null) {
            Function1 function1 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
            ((Function1) obj).invoke(Y());
        }
    }

    public final void h1(long j2) {
        long j3;
        long j4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = d;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            j4 = 1152921504606846975L & j3;
            if (j4 < j2) {
            } else {
                return;
            }
        } while (!d.compareAndSet(this, j3, BufferedChannelKt.w(j4, (int) (j3 >> 60))));
    }

    public final boolean i0(ChannelSegment channelSegment, int i2, long j2) {
        Object w;
        do {
            w = channelSegment.w(i2);
            if (w != null && w != BufferedChannelKt.e) {
                if (w == BufferedChannelKt.d) {
                    return true;
                }
                if (w == BufferedChannelKt.j || w == BufferedChannelKt.z() || w == BufferedChannelKt.i || w == BufferedChannelKt.h) {
                    return false;
                }
                if (w == BufferedChannelKt.g) {
                    return true;
                }
                return w != BufferedChannelKt.f && j2 == a0();
            }
        } while (!channelSegment.r(i2, w, BufferedChannelKt.h));
        T();
        return false;
    }

    public final void i1(long j2) {
        long j3;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j4;
        if (!n0()) {
            do {
            } while (X() <= j2);
            int g2 = BufferedChannelKt.c;
            int i2 = 0;
            while (i2 < g2) {
                long X = X();
                if (X != (DurationKt.MAX_MILLIS & g.get(this)) || X != X()) {
                    i2++;
                } else {
                    return;
                }
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = g;
            do {
                j3 = atomicLongFieldUpdater2.get(this);
            } while (!atomicLongFieldUpdater2.compareAndSet(this, j3, BufferedChannelKt.v(j3 & DurationKt.MAX_MILLIS, true)));
            while (true) {
                long X2 = X();
                atomicLongFieldUpdater = g;
                long j5 = atomicLongFieldUpdater.get(this);
                long j6 = j5 & DurationKt.MAX_MILLIS;
                boolean z = (Longs.MAX_POWER_OF_TWO & j5) != 0;
                if (X2 == j6 && X2 == X()) {
                    break;
                } else if (!z) {
                    atomicLongFieldUpdater.compareAndSet(this, j5, BufferedChannelKt.v(j6, true));
                }
            }
            do {
                j4 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(this, j4, BufferedChannelKt.v(j4 & DurationKt.MAX_MILLIS, false)));
        }
    }

    public ChannelIterator iterator() {
        return new BufferedChannelIterator();
    }

    public final boolean j0(long j2, boolean z) {
        int i2 = (int) (j2 >> 60);
        if (i2 == 0 || i2 == 1) {
            return false;
        }
        if (i2 == 2) {
            Q(j2 & 1152921504606846975L);
            if (z && d0()) {
                return false;
            }
        } else if (i2 == 3) {
            P(j2 & 1152921504606846975L);
        } else {
            throw new IllegalStateException(("unexpected close status: " + i2).toString());
        }
        return true;
    }

    public SelectClause2 k() {
        BufferedChannel$onSend$1 bufferedChannel$onSend$1 = BufferedChannel$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        BufferedChannel$onSend$2 bufferedChannel$onSend$2 = BufferedChannel$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$2, 3), (Function3) null, 8, (DefaultConstructorMarker) null);
    }

    public final boolean k0(long j2) {
        return j0(j2, true);
    }

    public final boolean l0(long j2) {
        return j0(j2, false);
    }

    public boolean m0() {
        return false;
    }

    public final boolean n0() {
        long X = X();
        return X == 0 || X == LongCompanionObject.MAX_VALUE;
    }

    public final long o0(ChannelSegment channelSegment) {
        do {
            int i2 = BufferedChannelKt.b;
            while (true) {
                i2--;
                if (-1 < i2) {
                    long j2 = (channelSegment.c * ((long) BufferedChannelKt.b)) + ((long) i2);
                    if (j2 < a0()) {
                        return -1;
                    }
                    while (true) {
                        Object w = channelSegment.w(i2);
                        if (w == null || w == BufferedChannelKt.e) {
                            if (channelSegment.r(i2, w, BufferedChannelKt.z())) {
                                channelSegment.p();
                                break;
                            }
                        } else if (w == BufferedChannelKt.d) {
                            return j2;
                        }
                    }
                } else {
                    channelSegment = (ChannelSegment) channelSegment.g();
                }
            }
        } while (channelSegment != null);
        return -1;
    }

    public void p(Function1 function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
        if (!a.a(atomicReferenceFieldUpdater, this, (Object) null, function1)) {
            do {
                Object obj = atomicReferenceFieldUpdater.get(this);
                if (obj != BufferedChannelKt.q) {
                    if (obj == BufferedChannelKt.r) {
                        throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                    }
                    throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                }
            } while (!a.a(l, this, BufferedChannelKt.q, BufferedChannelKt.r));
            function1.invoke(Y());
        }
    }

    public final void p0() {
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = d;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            if (((int) (j2 >> 60)) == 0) {
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, BufferedChannelKt.w(1152921504606846975L & j2, 1)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return kotlinx.coroutines.channels.ChannelResult.b.c(kotlin.Unit.INSTANCE);
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object q(java.lang.Object r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = d
            long r0 = r0.get(r14)
            boolean r0 = r14.W0(r0)
            if (r0 == 0) goto L_0x0013
            kotlinx.coroutines.channels.ChannelResult$Companion r14 = kotlinx.coroutines.channels.ChannelResult.b
            java.lang.Object r14 = r14.b()
            return r14
        L_0x0013:
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.channels.BufferedChannelKt.j
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = h
            java.lang.Object r0 = r0.get(r14)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
        L_0x0021:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = d
            long r1 = r1.getAndIncrement(r14)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r9 = r1 & r3
            boolean r11 = r14.l0(r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r2 = (long) r1
            long r2 = r9 / r2
            long r4 = (long) r1
            long r4 = r9 % r4
            int r12 = (int) r4
            long r4 = r0.c
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0059
            kotlinx.coroutines.channels.ChannelSegment r1 = r14.W(r2, r0)
            if (r1 != 0) goto L_0x0057
            if (r11 == 0) goto L_0x0021
        L_0x004b:
            kotlinx.coroutines.channels.ChannelResult$Companion r15 = kotlinx.coroutines.channels.ChannelResult.b
            java.lang.Throwable r14 = r14.b0()
            java.lang.Object r14 = r15.a(r14)
            goto L_0x00be
        L_0x0057:
            r13 = r1
            goto L_0x005a
        L_0x0059:
            r13 = r0
        L_0x005a:
            r0 = r14
            r1 = r13
            r2 = r12
            r3 = r15
            r4 = r9
            r6 = r8
            r7 = r11
            int r0 = r0.e1(r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00ba
            r1 = 1
            if (r0 == r1) goto L_0x00b1
            r1 = 2
            if (r0 == r1) goto L_0x0094
            r1 = 3
            if (r0 == r1) goto L_0x0088
            r1 = 4
            if (r0 == r1) goto L_0x007c
            r1 = 5
            if (r0 == r1) goto L_0x0077
            goto L_0x007a
        L_0x0077:
            r13.b()
        L_0x007a:
            r0 = r13
            goto L_0x0021
        L_0x007c:
            long r0 = r14.a0()
            int r15 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r15 >= 0) goto L_0x004b
            r13.b()
            goto L_0x004b
        L_0x0088:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L_0x0094:
            if (r11 == 0) goto L_0x009a
            r13.p()
            goto L_0x004b
        L_0x009a:
            boolean r15 = r8 instanceof kotlinx.coroutines.Waiter
            if (r15 == 0) goto L_0x00a1
            kotlinx.coroutines.Waiter r8 = (kotlinx.coroutines.Waiter) r8
            goto L_0x00a2
        L_0x00a1:
            r8 = 0
        L_0x00a2:
            if (r8 == 0) goto L_0x00a7
            r14.D0(r8, r13, r12)
        L_0x00a7:
            r13.p()
            kotlinx.coroutines.channels.ChannelResult$Companion r14 = kotlinx.coroutines.channels.ChannelResult.b
            java.lang.Object r14 = r14.b()
            goto L_0x00be
        L_0x00b1:
            kotlinx.coroutines.channels.ChannelResult$Companion r14 = kotlinx.coroutines.channels.ChannelResult.b
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            java.lang.Object r14 = r14.c(r15)
            goto L_0x00be
        L_0x00ba:
            r13.b()
            goto L_0x00b1
        L_0x00be:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.q(java.lang.Object):java.lang.Object");
    }

    public final void q0() {
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = d;
        do {
            j2 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, BufferedChannelKt.w(1152921504606846975L & j2, 3)));
    }

    public final void r0() {
        long j2;
        long b2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = d;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            int i2 = (int) (j2 >> 60);
            if (i2 == 0) {
                b2 = BufferedChannelKt.w(j2 & 1152921504606846975L, 2);
            } else if (i2 == 1) {
                b2 = BufferedChannelKt.w(j2 & 1152921504606846975L, 3);
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, b2));
    }

    public final void s0(long j2, ChannelSegment channelSegment) {
        ChannelSegment channelSegment2;
        ChannelSegment channelSegment3;
        while (channelSegment.c < j2 && (channelSegment3 = (ChannelSegment) channelSegment.e()) != null) {
            channelSegment = channelSegment3;
        }
        while (true) {
            if (!channelSegment.h() || (channelSegment2 = (ChannelSegment) channelSegment.e()) == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.c < channelSegment.c) {
                        if (!channelSegment.q()) {
                            continue;
                            break;
                        } else if (a.a(atomicReferenceFieldUpdater, this, segment, channelSegment)) {
                            if (segment.m()) {
                                segment.k();
                                return;
                            }
                            return;
                        } else if (channelSegment.m()) {
                            channelSegment.k();
                        }
                    } else {
                        return;
                    }
                }
            } else {
                channelSegment = channelSegment2;
            }
        }
    }

    public SelectClause1 t() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$2, 3), this.c);
    }

    public void t0() {
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01d9, code lost:
        r3 = r3.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e0, code lost:
        if (r3 != null) goto L_0x0200;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r16 = this;
            r0 = r16
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = d
            long r2 = r2.get(r0)
            r4 = 60
            long r2 = r2 >> r4
            int r2 = (int) r2
            r3 = 3
            r4 = 2
            if (r2 == r4) goto L_0x001e
            if (r2 == r3) goto L_0x0018
            goto L_0x0023
        L_0x0018:
            java.lang.String r2 = "cancelled,"
            r1.append(r2)
            goto L_0x0023
        L_0x001e:
            java.lang.String r2 = "closed,"
            r1.append(r2)
        L_0x0023:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "capacity="
            r2.append(r5)
            int r5 = r0.f3751a
            r2.append(r5)
            r5 = 44
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r2 = "data=["
            r1.append(r2)
            kotlinx.coroutines.channels.ChannelSegment[] r2 = new kotlinx.coroutines.channels.ChannelSegment[r3]
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = i
            java.lang.Object r3 = r3.get(r0)
            r6 = 0
            r2[r6] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = h
            java.lang.Object r3 = r3.get(r0)
            r7 = 1
            r2[r7] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = j
            java.lang.Object r3 = r3.get(r0)
            r2[r4] = r3
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r2)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x006c:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0083
            java.lang.Object r4 = r2.next()
            r8 = r4
            kotlinx.coroutines.channels.ChannelSegment r8 = (kotlinx.coroutines.channels.ChannelSegment) r8
            kotlinx.coroutines.channels.ChannelSegment r9 = kotlinx.coroutines.channels.BufferedChannelKt.f3754a
            if (r8 == r9) goto L_0x006c
            r3.add(r4)
            goto L_0x006c
        L_0x0083:
            java.util.Iterator r2 = r3.iterator()
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0203
            java.lang.Object r3 = r2.next()
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x0098
            goto L_0x00b2
        L_0x0098:
            r4 = r3
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            long r8 = r4.c
        L_0x009d:
            java.lang.Object r4 = r2.next()
            r10 = r4
            kotlinx.coroutines.channels.ChannelSegment r10 = (kotlinx.coroutines.channels.ChannelSegment) r10
            long r10 = r10.c
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x00ac
            r3 = r4
            r8 = r10
        L_0x00ac:
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x009d
        L_0x00b2:
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
            long r10 = r16.a0()
            long r12 = r16.c0()
        L_0x00bc:
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.b
            r2 = r6
        L_0x00bf:
            if (r2 >= r0) goto L_0x01d9
            long r8 = r3.c
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r14 = (long) r4
            long r8 = r8 * r14
            long r14 = (long) r2
            long r8 = r8 + r14
            int r4 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r4 < 0) goto L_0x00d1
            int r14 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r14 >= 0) goto L_0x01e2
        L_0x00d1:
            java.lang.Object r14 = r3.w(r2)
            java.lang.Object r15 = r3.v(r2)
            boolean r6 = r14 instanceof kotlinx.coroutines.CancellableContinuation
            if (r6 == 0) goto L_0x00f3
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 >= 0) goto L_0x00e7
            if (r4 < 0) goto L_0x00e7
            java.lang.String r4 = "receive"
            goto L_0x01a0
        L_0x00e7:
            if (r4 >= 0) goto L_0x00ef
            if (r6 < 0) goto L_0x00ef
            java.lang.String r4 = "send"
            goto L_0x01a0
        L_0x00ef:
            java.lang.String r4 = "cont"
            goto L_0x01a0
        L_0x00f3:
            boolean r6 = r14 instanceof kotlinx.coroutines.selects.SelectInstance
            if (r6 == 0) goto L_0x010d
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 >= 0) goto L_0x0101
            if (r4 < 0) goto L_0x0101
            java.lang.String r4 = "onReceive"
            goto L_0x01a0
        L_0x0101:
            if (r4 >= 0) goto L_0x0109
            if (r6 < 0) goto L_0x0109
            java.lang.String r4 = "onSend"
            goto L_0x01a0
        L_0x0109:
            java.lang.String r4 = "select"
            goto L_0x01a0
        L_0x010d:
            boolean r4 = r14 instanceof kotlinx.coroutines.channels.ReceiveCatching
            if (r4 == 0) goto L_0x0115
            java.lang.String r4 = "receiveCatching"
            goto L_0x01a0
        L_0x0115:
            boolean r4 = r14 instanceof kotlinx.coroutines.channels.BufferedChannel.SendBroadcast
            if (r4 == 0) goto L_0x011d
            java.lang.String r4 = "sendBroadcast"
            goto L_0x01a0
        L_0x011d:
            boolean r4 = r14 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r4 == 0) goto L_0x0139
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "EB("
            r4.append(r6)
            r4.append(r14)
            r6 = 41
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            goto L_0x01a0
        L_0x0139:
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.channels.BufferedChannelKt.f
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0145
            r4 = r7
            goto L_0x014d
        L_0x0145:
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.channels.BufferedChannelKt.g
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r4)
        L_0x014d:
            if (r4 == 0) goto L_0x0152
            java.lang.String r4 = "resuming_sender"
            goto L_0x01a0
        L_0x0152:
            if (r14 != 0) goto L_0x0156
            r4 = r7
            goto L_0x015e
        L_0x0156:
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.channels.BufferedChannelKt.e
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r4)
        L_0x015e:
            if (r4 == 0) goto L_0x0162
            r4 = r7
            goto L_0x016a
        L_0x0162:
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.channels.BufferedChannelKt.i
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r4)
        L_0x016a:
            if (r4 == 0) goto L_0x016e
            r4 = r7
            goto L_0x0176
        L_0x016e:
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.channels.BufferedChannelKt.h
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r4)
        L_0x0176:
            if (r4 == 0) goto L_0x017a
            r4 = r7
            goto L_0x0182
        L_0x017a:
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.channels.BufferedChannelKt.k
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r4)
        L_0x0182:
            if (r4 == 0) goto L_0x0186
            r4 = r7
            goto L_0x018e
        L_0x0186:
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.channels.BufferedChannelKt.j
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r4)
        L_0x018e:
            if (r4 == 0) goto L_0x0192
            r4 = r7
            goto L_0x019a
        L_0x0192:
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r4)
        L_0x019a:
            if (r4 != 0) goto L_0x01d4
            java.lang.String r4 = r14.toString()
        L_0x01a0:
            if (r15 == 0) goto L_0x01c2
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r8 = 40
            r6.append(r8)
            r6.append(r4)
            r6.append(r5)
            r6.append(r15)
            java.lang.String r4 = "),"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r1.append(r4)
            goto L_0x01d4
        L_0x01c2:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            r1.append(r4)
        L_0x01d4:
            int r2 = r2 + 1
            r6 = 0
            goto L_0x00bf
        L_0x01d9:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r3.e()
            r3 = r0
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
            if (r3 != 0) goto L_0x0200
        L_0x01e2:
            char r0 = kotlin.text.StringsKt.last(r1)
            if (r0 != r5) goto L_0x01f6
            int r0 = r1.length()
            int r0 = r0 - r7
            java.lang.StringBuilder r0 = r1.deleteCharAt(r0)
            java.lang.String r2 = "this.deleteCharAt(index)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
        L_0x01f6:
            java.lang.String r0 = "]"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            return r0
        L_0x0200:
            r6 = 0
            goto L_0x00bc
        L_0x0203:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    public final void u0(CancellableContinuation cancellableContinuation) {
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m20constructorimpl(ChannelResult.b(ChannelResult.b.a(Y()))));
    }

    public final void v0(CancellableContinuation cancellableContinuation) {
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(Z())));
    }

    public final void w0(SelectInstance selectInstance) {
        selectInstance.c(BufferedChannelKt.z());
    }

    public Object x() {
        ChannelSegment channelSegment;
        long j2 = e.get(this);
        long j3 = d.get(this);
        if (k0(j3)) {
            return ChannelResult.b.a(Y());
        }
        if (j2 >= (j3 & 1152921504606846975L)) {
            return ChannelResult.b.b();
        }
        Symbol i2 = BufferedChannelKt.k;
        ChannelSegment channelSegment2 = (ChannelSegment) i.get(this);
        while (!D()) {
            long andIncrement = e.getAndIncrement(this);
            int i3 = BufferedChannelKt.b;
            long j4 = andIncrement / ((long) i3);
            int i4 = (int) (andIncrement % ((long) i3));
            if (channelSegment2.c != j4) {
                ChannelSegment c2 = V(j4, channelSegment2);
                if (c2 == null) {
                    continue;
                } else {
                    channelSegment = c2;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object F = c1(channelSegment, i4, andIncrement, i2);
            if (F == BufferedChannelKt.m) {
                Waiter waiter = i2 instanceof Waiter ? (Waiter) i2 : null;
                if (waiter != null) {
                    C0(waiter, channelSegment, i4);
                }
                i1(andIncrement);
                channelSegment.p();
                return ChannelResult.b.b();
            } else if (F == BufferedChannelKt.o) {
                if (andIncrement < c0()) {
                    channelSegment.b();
                }
                channelSegment2 = channelSegment;
            } else if (F != BufferedChannelKt.n) {
                channelSegment.b();
                return ChannelResult.b.c(F);
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
        }
        return ChannelResult.b.a(Y());
    }

    public final void x0(Object obj, SelectInstance selectInstance) {
        Function1 function1 = this.b;
        if (function1 != null) {
            OnUndeliveredElementKt.b(function1, obj, selectInstance.getContext());
        }
        selectInstance.c(BufferedChannelKt.z());
    }

    public Object y(Continuation continuation) {
        return J0(this, continuation);
    }

    public final Object y0(Object obj, Continuation continuation) {
        UndeliveredElementException d2;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        Function1 function1 = this.b;
        if (function1 == null || (d2 = OnUndeliveredElementKt.d(function1, obj, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            Throwable b0 = b0();
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(b0)));
        } else {
            ExceptionsKt.addSuppressed(d2, b0());
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(d2)));
        }
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? u : Unit.INSTANCE;
    }

    public final void z0(Object obj, CancellableContinuation cancellableContinuation) {
        Function1 function1 = this.b;
        if (function1 != null) {
            OnUndeliveredElementKt.b(function1, obj, cancellableContinuation.getContext());
        }
        Throwable b0 = b0();
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(b0)));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BufferedChannel(int i2, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? null : function1);
    }
}

package kotlinx.coroutines;

import com.honey.account.i.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 7 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 8 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n+ 9 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n+ 10 CompletionHandler.common.kt\nkotlinx/coroutines/CompletionHandler_commonKt\n+ 11 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 12 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 13 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,1454:1\n706#1,2:1461\n367#1,2:1471\n369#1,4:1476\n373#1,4:1482\n377#1,2:1489\n367#1,2:1491\n369#1,4:1496\n373#1,4:1502\n377#1,2:1509\n178#1,2:1518\n707#1:1520\n178#1,2:1521\n178#1,2:1540\n178#1,2:1555\n706#1,2:1557\n706#1,2:1559\n178#1,2:1561\n706#1,2:1563\n178#1,2:1565\n178#1,2:1572\n178#1,2:1574\n1#2:1455\n1#2:1480\n1#2:1500\n28#3,4:1456\n28#3,4:1523\n28#3,4:1567\n28#3,4:1576\n20#4:1460\n20#4:1527\n20#4:1571\n20#4:1580\n288#5,2:1463\n288#5,2:1465\n19#6:1467\n163#7:1468\n163#7:1469\n153#7,4:1583\n75#8:1470\n75#8:1481\n75#8:1501\n75#8:1514\n341#9,3:1473\n344#9,3:1486\n341#9,3:1493\n344#9,3:1506\n341#9,3:1511\n344#9,3:1515\n47#10:1528\n22#11:1529\n22#11:1530\n13#11:1551\n13#11:1554\n13#11:1581\n13#11:1582\n13#11:1587\n13#11:1588\n134#12:1531\n73#12,3:1532\n135#12,5:1535\n314#13,9:1542\n323#13,2:1552\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n250#1:1461,2\n332#1:1471,2\n332#1:1476,4\n332#1:1482,4\n332#1:1489,2\n364#1:1491,2\n364#1:1496,4\n364#1:1502,4\n364#1:1509,2\n381#1:1518,2\n426#1:1520\n461#1:1521,2\n553#1:1540,2\n594#1:1555,2\n621#1:1557,2\n630#1:1559,2\n694#1:1561,2\n723#1:1563,2\n736#1:1565,2\n809#1:1572,2\n831#1:1574,2\n332#1:1480\n364#1:1500\n213#1:1456,4\n478#1:1523,4\n739#1:1567,4\n884#1:1576,4\n213#1:1460\n478#1:1527\n739#1:1571\n884#1:1580\n261#1:1463,2\n265#1:1465,2\n273#1:1467\n279#1:1468\n281#1:1469\n1218#1:1583,4\n284#1:1470\n332#1:1481\n364#1:1501\n372#1:1514\n332#1:1473,3\n332#1:1486,3\n364#1:1493,3\n364#1:1506,3\n368#1:1511,3\n368#1:1515,3\n483#1:1528\n495#1:1529\n505#1:1530\n561#1:1551\n577#1:1554\n924#1:1581\n974#1:1582\n1237#1:1587\n1259#1:1588\n526#1:1531\n526#1:1532,3\n526#1:1535,5\n559#1:1542,9\n559#1:1552,2\n*E\n"})
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\n¸\u0001¹\u0001º\u0001»\u0001¼\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0019\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\u00020\u0014*\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b$\u0010!J\u0019\u0010&\u001a\u00020%2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b&\u0010'J@\u0010/\u001a\u00020.2'\u0010,\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00140(j\u0002`+2\u0006\u0010-\u001a\u00020\u0004H\u0002¢\u0006\u0004\b/\u00100J'\u00103\u001a\u00020\u00042\u0006\u00101\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u00102\u001a\u00020.H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u00020\u00142\u0006\u0010\t\u001a\u000205H\u0002¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020.H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0004H\u0002¢\u0006\u0004\b:\u0010;J\u0013\u0010<\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0004\b<\u0010=J%\u0010A\u001a\u00020\u00142\n\u0010?\u001a\u0006\u0012\u0002\b\u00030>2\b\u0010@\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bA\u0010BJ\u001b\u0010C\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bC\u0010DJ\u0019\u0010E\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bE\u0010FJ\u001b\u0010G\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bG\u0010DJ\u0019\u0010H\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\t\u001a\u00020\u0017H\u0002¢\u0006\u0004\bH\u0010IJ\u001f\u0010J\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\bJ\u0010KJ%\u0010L\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bL\u0010MJ#\u0010N\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bN\u0010OJ\u0019\u0010Q\u001a\u0004\u0018\u00010P2\u0006\u0010\t\u001a\u00020\u0017H\u0002¢\u0006\u0004\bQ\u0010RJ*\u0010T\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010S\u001a\u00020P2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0010¢\u0006\u0004\bT\u0010UJ)\u0010W\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010V\u001a\u00020P2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bW\u0010XJ\u0015\u0010Z\u001a\u0004\u0018\u00010P*\u00020YH\u0002¢\u0006\u0004\bZ\u0010[J\u0019\u0010]\u001a\u00020\\2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b]\u0010^J\u0015\u0010_\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0004\b_\u0010=J%\u0010`\u001a\u00020\u00142\n\u0010?\u001a\u0006\u0012\u0002\b\u00030>2\b\u0010@\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b`\u0010BJ%\u0010b\u001a\u0004\u0018\u00010\n2\b\u0010@\u001a\u0004\u0018\u00010\n2\b\u0010a\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bb\u0010MJ\u0019\u0010d\u001a\u00020\u00142\b\u0010c\u001a\u0004\u0018\u00010\u0001H\u0004¢\u0006\u0004\bd\u0010eJ\r\u0010f\u001a\u00020\u0004¢\u0006\u0004\bf\u0010;J\u000f\u0010g\u001a\u00020\u0014H\u0014¢\u0006\u0004\bg\u0010hJ\u0011\u0010k\u001a\u00060ij\u0002`j¢\u0006\u0004\bk\u0010lJ#\u0010n\u001a\u00060ij\u0002`j*\u00020\u000f2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\\H\u0004¢\u0006\u0004\bn\u0010oJ6\u0010q\u001a\u00020p2'\u0010,\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00140(j\u0002`+¢\u0006\u0004\bq\u0010rJF\u0010t\u001a\u00020p2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010s\u001a\u00020\u00042'\u0010,\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00140(j\u0002`+¢\u0006\u0004\bt\u0010uJ\u0013\u0010v\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0004\bv\u0010=J\u0017\u0010w\u001a\u00020\u00142\u0006\u00102\u001a\u00020.H\u0000¢\u0006\u0004\bw\u00109J\u001f\u0010x\u001a\u00020\u00142\u000e\u0010\u001f\u001a\n\u0018\u00010ij\u0004\u0018\u0001`jH\u0016¢\u0006\u0004\bx\u0010yJ\u000f\u0010z\u001a\u00020\\H\u0014¢\u0006\u0004\bz\u0010{J\u0017\u0010|\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\b|\u0010}J\u0016\u0010\u001a\u00020\u00142\u0006\u0010~\u001a\u00020\u0003¢\u0006\u0005\b\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0005\b\u0001\u0010#J\u0019\u0010\u0001\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f¢\u0006\u0005\b\u0001\u0010#J\u001c\u0010\u0001\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0015\u0010\u0001\u001a\u00060ij\u0002`jH\u0016¢\u0006\u0005\b\u0001\u0010lJ\u001c\u0010\u0001\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0005\b\u0001\u0010DJ\u0019\u0010\u0001\u001a\u00030\u00012\u0006\u0010S\u001a\u00020\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020\u000fH\u0010¢\u0006\u0005\b\u0001\u0010}J\u001b\u0010\u0001\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0005\b\u0001\u0010}J\u001a\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u000fH\u0014¢\u0006\u0005\b\u0001\u0010#J\u001c\u0010\u0001\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\\H\u0016¢\u0006\u0005\b\u0001\u0010{J\u0011\u0010\u0001\u001a\u00020\\H\u0007¢\u0006\u0005\b\u0001\u0010{J\u0011\u0010\u0001\u001a\u00020\\H\u0010¢\u0006\u0005\b\u0001\u0010{J\u0014\u0010\u0001\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0001\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010=R\u001e\u0010\u0001\u001a\u0004\u0018\u00010\u000f*\u0004\u0018\u00010\n8BX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010FR\u0019\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030\u00018F¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R0\u0010£\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00018@@@X\u000e¢\u0006\u0010\u001a\u0006\b\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R\u0018\u0010c\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\b\u001a\u0006\b¤\u0001\u0010¥\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8@X\u0004¢\u0006\b\u001a\u0006\b¦\u0001\u0010\u0001R\u0016\u0010§\u0001\u001a\u00020\u00048VX\u0004¢\u0006\u0007\u001a\u0005\b§\u0001\u0010;R\u0013\u0010¨\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b¨\u0001\u0010;R\u0013\u0010©\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b©\u0001\u0010;R\u0019\u0010¬\u0001\u001a\u0004\u0018\u00010\u000f8DX\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001R\u0016\u0010®\u0001\u001a\u00020\u00048DX\u0004¢\u0006\u0007\u001a\u0005\b­\u0001\u0010;R\u0016\u0010°\u0001\u001a\u00020\u00048PX\u0004¢\u0006\u0007\u001a\u0005\b¯\u0001\u0010;R\u0016\u0010²\u0001\u001a\u00020\u00048TX\u0004¢\u0006\u0007\u001a\u0005\b±\u0001\u0010;R\u0016\u0010´\u0001\u001a\u00020\u00048PX\u0004¢\u0006\u0007\u001a\u0005\b³\u0001\u0010;R\u0016\u0010¶\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u00010µ\u00018\u0002X\u0004R\u0015\u0010·\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\n0µ\u00018\u0002X\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006½\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "", "active", "<init>", "(Z)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "state", "", "proposedUpdate", "o0", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "", "", "exceptions", "A0", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "rootCause", "", "W", "(Ljava/lang/Throwable;Ljava/util/List;)V", "Lkotlinx/coroutines/Incomplete;", "update", "j1", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "l0", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/NodeList;", "list", "cause", "S0", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "h0", "(Ljava/lang/Throwable;)Z", "T0", "", "e1", "(Ljava/lang/Object;)I", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "onCancelling", "Lkotlinx/coroutines/JobNode;", "P0", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "expect", "node", "V", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "Lkotlinx/coroutines/Empty;", "Z0", "(Lkotlinx/coroutines/Empty;)V", "a1", "(Lkotlinx/coroutines/JobNode;)V", "K0", "()Z", "L0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "ignoredParam", "b1", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "g0", "(Ljava/lang/Object;)Ljava/lang/Object;", "n0", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "M0", "D0", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "k1", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "l1", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "m1", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/ChildHandleNode;", "s0", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "child", "n1", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "lastChild", "m0", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "R0", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "", "f1", "(Ljava/lang/Object;)Ljava/lang/String;", "Z", "V0", "result", "U0", "parent", "I0", "(Lkotlinx/coroutines/Job;)V", "start", "Y0", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "U", "()Ljava/util/concurrent/CancellationException;", "message", "g1", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/DisposableHandle;", "r", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "invokeImmediately", "S", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "i0", "c1", "a", "(Ljava/util/concurrent/CancellationException;)V", "j0", "()Ljava/lang/String;", "e0", "(Ljava/lang/Throwable;)V", "parentJob", "n", "(Lkotlinx/coroutines/ParentJob;)V", "k0", "a0", "b0", "(Ljava/lang/Object;)Z", "c0", "N0", "O0", "Lkotlinx/coroutines/ChildHandle;", "N", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "exception", "H0", "W0", "G0", "X0", "(Ljava/lang/Object;)V", "X", "toString", "i1", "Q0", "u0", "()Ljava/lang/Object;", "Y", "z0", "exceptionOrNull", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "value", "E0", "()Lkotlinx/coroutines/ChildHandle;", "d1", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getParent", "()Lkotlinx/coroutines/Job;", "F0", "isActive", "isCompleted", "isCancelled", "v0", "()Ljava/lang/Throwable;", "completionCause", "w0", "completionCauseHandled", "C0", "onCancelComplete", "J0", "isScopedCoroutine", "B0", "handlesException", "Lkotlinx/atomicfu/AtomicRef;", "_parentHandle", "_state", "AwaitContinuation", "ChildCompletion", "Finishing", "SelectOnAwaitCompletionHandler", "SelectOnJoinCompletionHandler", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
public class JobSupport implements Job, ChildJob, ParentJob {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f3737a;
    public static final AtomicReferenceFieldUpdater b;
    @Volatile
    @Nullable
    private volatile Object _parentHandle;
    @Volatile
    @Nullable
    private volatile Object _state;

    @SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$AwaitContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/JobSupport;", "job", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "Lkotlinx/coroutines/Job;", "parent", "", "s", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "", "G", "()Ljava/lang/String;", "i", "Lkotlinx/coroutines/JobSupport;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        public final JobSupport i;

        public AwaitContinuation(Continuation continuation, JobSupport jobSupport) {
            super(continuation, 1);
            this.i = jobSupport;
        }

        public String G() {
            return "AwaitContinuation";
        }

        public Throwable s(Job job) {
            Throwable e;
            Object F0 = this.i.F0();
            return (!(F0 instanceof Finishing) || (e = ((Finishing) F0).e()) == null) ? F0 instanceof CompletedExceptionally ? ((CompletedExceptionally) F0).f3715a : job.U() : e;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/JobSupport;", "parent", "Lkotlinx/coroutines/JobSupport$Finishing;", "state", "Lkotlinx/coroutines/ChildHandleNode;", "child", "", "proposedUpdate", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "", "cause", "", "s", "(Ljava/lang/Throwable;)V", "e", "Lkotlinx/coroutines/JobSupport;", "f", "Lkotlinx/coroutines/JobSupport$Finishing;", "g", "Lkotlinx/coroutines/ChildHandleNode;", "h", "Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public static final class ChildCompletion extends JobNode {
        public final JobSupport e;
        public final Finishing f;
        public final ChildHandleNode g;
        public final Object h;

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
            this.e = jobSupport;
            this.f = finishing;
            this.g = childHandleNode;
            this.h = obj;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            s((Throwable) obj);
            return Unit.INSTANCE;
        }

        public void s(Throwable th) {
            this.e.m0(this.f, this.g, this.h);
        }
    }

    @SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$Finishing\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B!\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r2\b\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0017j\b\u0012\u0004\u0012\u00020\b`\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b8F@FX\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010\u0013R\u0011\u0010'\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b&\u0010 R\u0011\u0010)\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b(\u0010 R\u0014\u0010*\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010 R(\u0010/\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00018B@BX\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0013\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001008\u0002X\u0004R\u000b\u00103\u001a\u0002028\u0002X\u0004R\u0013\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b008\u0002X\u0004¨\u00065"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "proposedException", "", "i", "(Ljava/lang/Throwable;)Ljava/util/List;", "exception", "", "b", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "()Ljava/util/ArrayList;", "a", "Lkotlinx/coroutines/NodeList;", "()Lkotlinx/coroutines/NodeList;", "value", "g", "()Z", "j", "(Z)V", "e", "()Ljava/lang/Throwable;", "l", "h", "isSealed", "f", "isCancelling", "isActive", "d", "()Ljava/lang/Object;", "k", "(Ljava/lang/Object;)V", "exceptionsHolder", "Lkotlinx/atomicfu/AtomicRef;", "_exceptionsHolder", "Lkotlinx/atomicfu/AtomicBoolean;", "_isCompleting", "_rootCause", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public static final class Finishing implements Incomplete {
        public static final AtomicIntegerFieldUpdater b;
        public static final AtomicReferenceFieldUpdater c;
        public static final AtomicReferenceFieldUpdater d;
        @Volatile
        @Nullable
        private volatile Object _exceptionsHolder;
        @Volatile
        private volatile int _isCompleting;
        @Volatile
        @Nullable
        private volatile Object _rootCause;

        /* renamed from: a  reason: collision with root package name */
        public final NodeList f3738a;

        static {
            Class<Finishing> cls = Finishing.class;
            b = AtomicIntegerFieldUpdater.newUpdater(cls, "_isCompleting");
            Class<Object> cls2 = Object.class;
            c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_rootCause");
            d = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_exceptionsHolder");
        }

        public Finishing(NodeList nodeList, boolean z, Throwable th) {
            this.f3738a = nodeList;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        public NodeList a() {
            return this.f3738a;
        }

        public final void b(Throwable th) {
            Throwable e = e();
            if (e == null) {
                l(th);
            } else if (th != e) {
                Object d2 = d();
                if (d2 == null) {
                    k(th);
                } else if (d2 instanceof Throwable) {
                    if (th != d2) {
                        ArrayList c2 = c();
                        c2.add(d2);
                        c2.add(th);
                        k(c2);
                    }
                } else if (d2 instanceof ArrayList) {
                    ((ArrayList) d2).add(th);
                } else {
                    throw new IllegalStateException(("State is " + d2).toString());
                }
            }
        }

        public final ArrayList c() {
            return new ArrayList(4);
        }

        public final Object d() {
            return d.get(this);
        }

        public final Throwable e() {
            return (Throwable) c.get(this);
        }

        public final boolean f() {
            return e() != null;
        }

        public final boolean g() {
            return b.get(this) != 0;
        }

        public final boolean h() {
            return d() == JobSupportKt.e;
        }

        public final List i(Throwable th) {
            ArrayList arrayList;
            Object d2 = d();
            if (d2 == null) {
                arrayList = c();
            } else if (d2 instanceof Throwable) {
                ArrayList c2 = c();
                c2.add(d2);
                arrayList = c2;
            } else if (d2 instanceof ArrayList) {
                arrayList = (ArrayList) d2;
            } else {
                throw new IllegalStateException(("State is " + d2).toString());
            }
            Throwable e = e();
            if (e != null) {
                arrayList.add(0, e);
            }
            if (th != null && !Intrinsics.areEqual((Object) th, (Object) e)) {
                arrayList.add(th);
            }
            k(JobSupportKt.e);
            return arrayList;
        }

        public boolean isActive() {
            return e() == null;
        }

        public final void j(boolean z) {
            b.set(this, z ? 1 : 0);
        }

        public final void k(Object obj) {
            d.set(this, obj);
        }

        public final void l(Throwable th) {
            c.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + a() + ']';
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/JobSupport$SelectOnAwaitCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "", "cause", "", "s", "(Ljava/lang/Throwable;)V", "e", "Lkotlinx/coroutines/selects/SelectInstance;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public final class SelectOnAwaitCompletionHandler extends JobNode {
        public final SelectInstance e;

        public SelectOnAwaitCompletionHandler(SelectInstance selectInstance) {
            this.e = selectInstance;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            s((Throwable) obj);
            return Unit.INSTANCE;
        }

        public void s(Throwable th) {
            Object F0 = JobSupport.this.F0();
            if (!(F0 instanceof CompletedExceptionally)) {
                F0 = JobSupportKt.h(F0);
            }
            this.e.e(JobSupport.this, F0);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/JobSupport$SelectOnJoinCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "", "cause", "", "s", "(Ljava/lang/Throwable;)V", "e", "Lkotlinx/coroutines/selects/SelectInstance;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public final class SelectOnJoinCompletionHandler extends JobNode {
        public final SelectInstance e;

        public SelectOnJoinCompletionHandler(SelectInstance selectInstance) {
            this.e = selectInstance;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            s((Throwable) obj);
            return Unit.INSTANCE;
        }

        public void s(Throwable th) {
            this.e.e(JobSupport.this, Unit.INSTANCE);
        }
    }

    static {
        Class<JobSupport> cls = JobSupport.class;
        Class<Object> cls2 = Object.class;
        f3737a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state");
        b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_parentHandle");
    }

    public JobSupport(boolean z) {
        this._state = z ? JobSupportKt.g : JobSupportKt.f;
    }

    public static /* synthetic */ CancellationException h1(JobSupport jobSupport, Throwable th, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            return jobSupport.g1(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Throwable A0(kotlinx.coroutines.JobSupport.Finishing r3, java.util.List r4) {
        /*
            r2 = this;
            boolean r0 = r4.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0018
            boolean r3 = r3.f()
            if (r3 == 0) goto L_0x0017
            kotlinx.coroutines.JobCancellationException r3 = new kotlinx.coroutines.JobCancellationException
            java.lang.String r4 = r2.j0()
            r3.<init>(r4, r1, r2)
            return r3
        L_0x0017:
            return r1
        L_0x0018:
            java.util.Iterator r2 = r4.iterator()
        L_0x001c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0030
            java.lang.Object r3 = r2.next()
            r0 = r3
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            boolean r0 = r0 instanceof java.util.concurrent.CancellationException
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x001c
            goto L_0x0031
        L_0x0030:
            r3 = r1
        L_0x0031:
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            if (r3 == 0) goto L_0x0036
            return r3
        L_0x0036:
            r2 = 0
            java.lang.Object r2 = r4.get(r2)
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            boolean r3 = r2 instanceof kotlinx.coroutines.TimeoutCancellationException
            if (r3 == 0) goto L_0x005e
            java.util.Iterator r3 = r4.iterator()
        L_0x0045:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0059
            java.lang.Object r4 = r3.next()
            r0 = r4
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            if (r0 == r2) goto L_0x0045
            boolean r0 = r0 instanceof kotlinx.coroutines.TimeoutCancellationException
            if (r0 == 0) goto L_0x0045
            r1 = r4
        L_0x0059:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            if (r1 == 0) goto L_0x005e
            return r1
        L_0x005e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.A0(kotlinx.coroutines.JobSupport$Finishing, java.util.List):java.lang.Throwable");
    }

    public boolean B0() {
        return true;
    }

    public boolean C0() {
        return false;
    }

    public final NodeList D0(Incomplete incomplete) {
        NodeList a2 = incomplete.a();
        if (a2 != null) {
            return a2;
        }
        if (incomplete instanceof Empty) {
            return new NodeList();
        }
        if (incomplete instanceof JobNode) {
            a1((JobNode) incomplete);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + incomplete).toString());
    }

    public final ChildHandle E0() {
        return (ChildHandle) b.get(this);
    }

    public final Object F0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3737a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).a(this);
        }
    }

    public boolean G0(Throwable th) {
        return false;
    }

    public void H0(Throwable th) {
        throw th;
    }

    public final void I0(Job job) {
        if (job == null) {
            d1(NonDisposableHandle.f3741a);
            return;
        }
        job.start();
        ChildHandle N = job.N(this);
        d1(N);
        if (isCompleted()) {
            N.dispose();
            d1(NonDisposableHandle.f3741a);
        }
    }

    public boolean J0() {
        return false;
    }

    public final boolean K0() {
        Object F0;
        do {
            F0 = F0();
            if (!(F0 instanceof Incomplete)) {
                return false;
            }
        } while (e1(F0) < 0);
        return true;
    }

    public final Object L0(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        CancellableContinuationKt.a(cancellableContinuationImpl, r(new ResumeOnCompletion(cancellableContinuationImpl)));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? u : Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        if (r0 == null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0042, code lost:
        S0(((kotlinx.coroutines.JobSupport.Finishing) r2).a(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004f, code lost:
        return kotlinx.coroutines.JobSupportKt.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object M0(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r6.F0()
            boolean r3 = r2 instanceof kotlinx.coroutines.JobSupport.Finishing
            if (r3 == 0) goto L_0x0052
            monitor-enter(r2)
            r3 = r2
            kotlinx.coroutines.JobSupport$Finishing r3 = (kotlinx.coroutines.JobSupport.Finishing) r3     // Catch:{ all -> 0x001a }
            boolean r3 = r3.h()     // Catch:{ all -> 0x001a }
            if (r3 == 0) goto L_0x001c
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.JobSupportKt.d     // Catch:{ all -> 0x001a }
            monitor-exit(r2)
            return r6
        L_0x001a:
            r6 = move-exception
            goto L_0x0050
        L_0x001c:
            r3 = r2
            kotlinx.coroutines.JobSupport$Finishing r3 = (kotlinx.coroutines.JobSupport.Finishing) r3     // Catch:{ all -> 0x001a }
            boolean r3 = r3.f()     // Catch:{ all -> 0x001a }
            if (r7 != 0) goto L_0x0027
            if (r3 != 0) goto L_0x0033
        L_0x0027:
            if (r1 != 0) goto L_0x002d
            java.lang.Throwable r1 = r6.n0(r7)     // Catch:{ all -> 0x001a }
        L_0x002d:
            r7 = r2
            kotlinx.coroutines.JobSupport$Finishing r7 = (kotlinx.coroutines.JobSupport.Finishing) r7     // Catch:{ all -> 0x001a }
            r7.b(r1)     // Catch:{ all -> 0x001a }
        L_0x0033:
            r7 = r2
            kotlinx.coroutines.JobSupport$Finishing r7 = (kotlinx.coroutines.JobSupport.Finishing) r7     // Catch:{ all -> 0x001a }
            java.lang.Throwable r7 = r7.e()     // Catch:{ all -> 0x001a }
            r1 = r3 ^ 1
            if (r1 == 0) goto L_0x003f
            r0 = r7
        L_0x003f:
            monitor-exit(r2)
            if (r0 == 0) goto L_0x004b
            kotlinx.coroutines.JobSupport$Finishing r2 = (kotlinx.coroutines.JobSupport.Finishing) r2
            kotlinx.coroutines.NodeList r7 = r2.a()
            r6.S0(r7, r0)
        L_0x004b:
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.JobSupportKt.f3739a
            return r6
        L_0x0050:
            monitor-exit(r2)
            throw r6
        L_0x0052:
            boolean r3 = r2 instanceof kotlinx.coroutines.Incomplete
            if (r3 == 0) goto L_0x00a3
            if (r1 != 0) goto L_0x005c
            java.lang.Throwable r1 = r6.n0(r7)
        L_0x005c:
            r3 = r2
            kotlinx.coroutines.Incomplete r3 = (kotlinx.coroutines.Incomplete) r3
            boolean r4 = r3.isActive()
            if (r4 == 0) goto L_0x0070
            boolean r2 = r6.k1(r3, r1)
            if (r2 == 0) goto L_0x0002
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.JobSupportKt.f3739a
            return r6
        L_0x0070:
            kotlinx.coroutines.CompletedExceptionally r3 = new kotlinx.coroutines.CompletedExceptionally
            r4 = 0
            r5 = 2
            r3.<init>(r1, r4, r5, r0)
            java.lang.Object r3 = r6.l1(r2, r3)
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.JobSupportKt.f3739a
            if (r3 == r4) goto L_0x0088
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.JobSupportKt.c
            if (r3 == r2) goto L_0x0002
            return r3
        L_0x0088:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Cannot happen in "
            r7.append(r0)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x00a3:
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.JobSupportKt.d
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.M0(java.lang.Object):java.lang.Object");
    }

    public final ChildHandle N(ChildJob childJob) {
        DisposableHandle d = Job.DefaultImpls.d(this, true, false, new ChildHandleNode(childJob), 2, (Object) null);
        Intrinsics.checkNotNull(d, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (ChildHandle) d;
    }

    public final boolean N0(Object obj) {
        Object l1;
        do {
            l1 = l1(F0(), obj);
            if (l1 == JobSupportKt.f3739a) {
                return false;
            }
            if (l1 == JobSupportKt.b) {
                return true;
            }
        } while (l1 == JobSupportKt.c);
        X(l1);
        return true;
    }

    public final Object O0(Object obj) {
        Object l1;
        do {
            l1 = l1(F0(), obj);
            if (l1 == JobSupportKt.f3739a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, z0(obj));
            }
        } while (l1 == JobSupportKt.c);
        return l1;
    }

    public final JobNode P0(Function1 function1, boolean z) {
        JobNode jobNode = null;
        if (z) {
            if (function1 instanceof JobCancellingNode) {
                jobNode = (JobCancellingNode) function1;
            }
            if (jobNode == null) {
                jobNode = new InvokeOnCancelling(function1);
            }
        } else {
            if (function1 instanceof JobNode) {
                jobNode = (JobNode) function1;
            }
            if (jobNode == null) {
                jobNode = new InvokeOnCompletion(function1);
            }
        }
        jobNode.u(this);
        return jobNode;
    }

    public String Q0() {
        return DebugStringsKt.a(this);
    }

    public final ChildHandleNode R0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.n()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.m();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.l();
            if (!lockFreeLinkedListNode.n()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    public final DisposableHandle S(boolean z, boolean z2, Function1 function1) {
        JobNode P0 = P0(function1, z);
        while (true) {
            Object F0 = F0();
            if (F0 instanceof Empty) {
                Empty empty = (Empty) F0;
                if (!empty.isActive()) {
                    Z0(empty);
                } else if (a.a(f3737a, this, F0, P0)) {
                    return P0;
                }
            } else {
                Throwable th = null;
                if (F0 instanceof Incomplete) {
                    NodeList a2 = ((Incomplete) F0).a();
                    if (a2 == null) {
                        Intrinsics.checkNotNull(F0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        a1((JobNode) F0);
                    } else {
                        DisposableHandle disposableHandle = NonDisposableHandle.f3741a;
                        if (z && (F0 instanceof Finishing)) {
                            synchronized (F0) {
                                try {
                                    th = ((Finishing) F0).e();
                                    if (th != null) {
                                        if ((function1 instanceof ChildHandleNode) && !((Finishing) F0).g()) {
                                        }
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    if (V(F0, a2, P0)) {
                                        if (th == null) {
                                            return P0;
                                        }
                                        disposableHandle = P0;
                                        Unit unit2 = Unit.INSTANCE;
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                        if (th != null) {
                            if (z2) {
                                function1.invoke(th);
                            }
                            return disposableHandle;
                        } else if (V(F0, a2, P0)) {
                            return P0;
                        }
                    }
                } else {
                    if (z2) {
                        CompletedExceptionally completedExceptionally = F0 instanceof CompletedExceptionally ? (CompletedExceptionally) F0 : null;
                        if (completedExceptionally != null) {
                            th = completedExceptionally.f3715a;
                        }
                        function1.invoke(th);
                    }
                    return NonDisposableHandle.f3741a;
                }
            }
        }
    }

    public final void S0(NodeList nodeList, Throwable th) {
        W0(th);
        Object k = nodeList.k();
        Intrinsics.checkNotNull(k, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) k; !Intrinsics.areEqual((Object) lockFreeLinkedListNode, (Object) nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.l()) {
            if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.s(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        ExceptionsKt.addSuppressed(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            H0(completionHandlerException);
        }
        h0(th);
    }

    public final void T0(NodeList nodeList, Throwable th) {
        Object k = nodeList.k();
        Intrinsics.checkNotNull(k, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) k; !Intrinsics.areEqual((Object) lockFreeLinkedListNode, (Object) nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.l()) {
            if (lockFreeLinkedListNode instanceof JobNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.s(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        ExceptionsKt.addSuppressed(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            H0(completionHandlerException);
        }
    }

    public final CancellationException U() {
        Object F0 = F0();
        if (F0 instanceof Finishing) {
            Throwable e = ((Finishing) F0).e();
            if (e != null) {
                CancellationException g1 = g1(e, DebugStringsKt.a(this) + " is cancelling");
                if (g1 != null) {
                    return g1;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (F0 instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (F0 instanceof CompletedExceptionally) {
            return h1(this, ((CompletedExceptionally) F0).f3715a, (String) null, 1, (Object) null);
        } else {
            return new JobCancellationException(DebugStringsKt.a(this) + " has completed normally", (Throwable) null, this);
        }
    }

    public final Object U0(Object obj, Object obj2) {
        if (!(obj2 instanceof CompletedExceptionally)) {
            return obj2;
        }
        throw ((CompletedExceptionally) obj2).f3715a;
    }

    public final boolean V(Object obj, NodeList nodeList, JobNode jobNode) {
        int r;
        JobSupport$addLastAtomic$$inlined$addLastIf$1 jobSupport$addLastAtomic$$inlined$addLastIf$1 = new JobSupport$addLastAtomic$$inlined$addLastIf$1(jobNode, this, obj);
        do {
            r = nodeList.m().r(jobNode, nodeList, jobSupport$addLastAtomic$$inlined$addLastIf$1);
            if (r == 1) {
                return true;
            }
        } while (r != 2);
        return false;
    }

    public final void V0(SelectInstance selectInstance, Object obj) {
        Object F0;
        do {
            F0 = F0();
            if (!(F0 instanceof Incomplete)) {
                if (!(F0 instanceof CompletedExceptionally)) {
                    F0 = JobSupportKt.h(F0);
                }
                selectInstance.c(F0);
                return;
            }
        } while (e1(F0) < 0);
        selectInstance.d(r(new SelectOnAwaitCompletionHandler(selectInstance)));
    }

    public final void W(Throwable th, List list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Throwable th2 = (Throwable) it.next();
                if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                    ExceptionsKt.addSuppressed(th, th2);
                }
            }
        }
    }

    public void W0(Throwable th) {
    }

    public void X(Object obj) {
    }

    public void X0(Object obj) {
    }

    public final Object Y(Continuation continuation) {
        Object F0;
        do {
            F0 = F0();
            if (!(F0 instanceof Incomplete)) {
                if (!(F0 instanceof CompletedExceptionally)) {
                    return JobSupportKt.h(F0);
                }
                throw ((CompletedExceptionally) F0).f3715a;
            }
        } while (e1(F0) < 0);
        return Z(continuation);
    }

    public void Y0() {
    }

    public final Object Z(Continuation continuation) {
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt.intercepted(continuation), this);
        awaitContinuation.x();
        CancellableContinuationKt.a(awaitContinuation, r(new ResumeAwaitOnCompletion(awaitContinuation)));
        Object u = awaitContinuation.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [kotlinx.coroutines.InactiveNodeList] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Z0(kotlinx.coroutines.Empty r3) {
        /*
            r2 = this;
            kotlinx.coroutines.NodeList r0 = new kotlinx.coroutines.NodeList
            r0.<init>()
            boolean r1 = r3.isActive()
            if (r1 == 0) goto L_0x000c
            goto L_0x0012
        L_0x000c:
            kotlinx.coroutines.InactiveNodeList r1 = new kotlinx.coroutines.InactiveNodeList
            r1.<init>(r0)
            r0 = r1
        L_0x0012:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f3737a
            com.honey.account.i.a.a(r1, r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.Z0(kotlinx.coroutines.Empty):void");
    }

    public void a(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(j0(), (Throwable) null, this);
        }
        e0(cancellationException);
    }

    public final boolean a0(Throwable th) {
        return b0(th);
    }

    public final void a1(JobNode jobNode) {
        jobNode.g(new NodeList());
        a.a(f3737a, this, jobNode, jobNode.l());
    }

    public final boolean b0(Object obj) {
        Object a2 = JobSupportKt.f3739a;
        if (C0() && (a2 = g0(obj)) == JobSupportKt.b) {
            return true;
        }
        if (a2 == JobSupportKt.f3739a) {
            a2 = M0(obj);
        }
        if (a2 == JobSupportKt.f3739a || a2 == JobSupportKt.b) {
            return true;
        }
        if (a2 == JobSupportKt.d) {
            return false;
        }
        X(a2);
        return true;
    }

    public final void b1(SelectInstance selectInstance, Object obj) {
        if (!K0()) {
            selectInstance.c(Unit.INSTANCE);
        } else {
            selectInstance.d(r(new SelectOnJoinCompletionHandler(selectInstance)));
        }
    }

    public CancellationException c0() {
        Throwable th;
        Object F0 = F0();
        CancellationException cancellationException = null;
        if (F0 instanceof Finishing) {
            th = ((Finishing) F0).e();
        } else if (F0 instanceof CompletedExceptionally) {
            th = ((CompletedExceptionally) F0).f3715a;
        } else if (!(F0 instanceof Incomplete)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + F0).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        }
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + f1(F0), th, this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c1(kotlinx.coroutines.JobNode r4) {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Object r0 = r3.F0()
            boolean r1 = r0 instanceof kotlinx.coroutines.JobNode
            if (r1 == 0) goto L_0x0018
            if (r0 == r4) goto L_0x000b
            return
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f3737a
            kotlinx.coroutines.Empty r2 = kotlinx.coroutines.JobSupportKt.g
            boolean r0 = com.honey.account.i.a.a(r1, r3, r0, r2)
            if (r0 == 0) goto L_0x0000
            return
        L_0x0018:
            boolean r3 = r0 instanceof kotlinx.coroutines.Incomplete
            if (r3 == 0) goto L_0x0027
            kotlinx.coroutines.Incomplete r0 = (kotlinx.coroutines.Incomplete) r0
            kotlinx.coroutines.NodeList r3 = r0.a()
            if (r3 == 0) goto L_0x0027
            r4.o()
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.c1(kotlinx.coroutines.JobNode):void");
    }

    public final void d1(ChildHandle childHandle) {
        b.set(this, childHandle);
    }

    public void e0(Throwable th) {
        b0(th);
    }

    public final int e1(Object obj) {
        if (obj instanceof Empty) {
            if (((Empty) obj).isActive()) {
                return 0;
            }
            if (!a.a(f3737a, this, obj, JobSupportKt.g)) {
                return -1;
            }
            Y0();
            return 1;
        } else if (!(obj instanceof InactiveNodeList)) {
            return 0;
        } else {
            if (!a.a(f3737a, this, obj, ((InactiveNodeList) obj).a())) {
                return -1;
            }
            Y0();
            return 1;
        }
    }

    public final String f1(Object obj) {
        if (!(obj instanceof Finishing)) {
            return obj instanceof Incomplete ? ((Incomplete) obj).isActive() ? "Active" : "New" : obj instanceof CompletedExceptionally ? "Cancelled" : "Completed";
        }
        Finishing finishing = (Finishing) obj;
        return finishing.f() ? "Cancelling" : finishing.g() ? "Completing" : "Active";
    }

    public Object fold(Object obj, Function2 function2) {
        return Job.DefaultImpls.b(this, obj, function2);
    }

    public final Object g0(Object obj) {
        Object l1;
        do {
            Object F0 = F0();
            if (!(F0 instanceof Incomplete) || ((F0 instanceof Finishing) && ((Finishing) F0).g())) {
                return JobSupportKt.f3739a;
            }
            l1 = l1(F0, new CompletedExceptionally(n0(obj), false, 2, (DefaultConstructorMarker) null));
        } while (l1 == JobSupportKt.c);
        return l1;
    }

    public final CancellationException g1(Throwable th, String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = j0();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    public CoroutineContext.Element get(CoroutineContext.Key key) {
        return Job.DefaultImpls.c(this, key);
    }

    public final CoroutineContext.Key getKey() {
        return Job.b0;
    }

    public Job getParent() {
        ChildHandle E0 = E0();
        if (E0 != null) {
            return E0.getParent();
        }
        return null;
    }

    public final boolean h0(Throwable th) {
        if (J0()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ChildHandle E0 = E0();
        return (E0 == null || E0 == NonDisposableHandle.f3741a) ? z : E0.b(th) || z;
    }

    public final Object i0(Continuation continuation) {
        if (!K0()) {
            JobKt.i(continuation.getContext());
            return Unit.INSTANCE;
        }
        Object L0 = L0(continuation);
        return L0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? L0 : Unit.INSTANCE;
    }

    public final String i1() {
        return Q0() + '{' + f1(F0()) + '}';
    }

    public boolean isActive() {
        Object F0 = F0();
        return (F0 instanceof Incomplete) && ((Incomplete) F0).isActive();
    }

    public final boolean isCancelled() {
        Object F0 = F0();
        return (F0 instanceof CompletedExceptionally) || ((F0 instanceof Finishing) && ((Finishing) F0).f());
    }

    public final boolean isCompleted() {
        return !(F0() instanceof Incomplete);
    }

    public String j0() {
        return "Job was cancelled";
    }

    public final boolean j1(Incomplete incomplete, Object obj) {
        if (!a.a(f3737a, this, incomplete, JobSupportKt.g(obj))) {
            return false;
        }
        W0((Throwable) null);
        X0(obj);
        l0(incomplete, obj);
        return true;
    }

    public boolean k0(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return b0(th) && B0();
    }

    public final boolean k1(Incomplete incomplete, Throwable th) {
        NodeList D0 = D0(incomplete);
        if (D0 == null) {
            return false;
        }
        if (!a.a(f3737a, this, incomplete, new Finishing(D0, false, th))) {
            return false;
        }
        S0(D0, th);
        return true;
    }

    public final void l0(Incomplete incomplete, Object obj) {
        ChildHandle E0 = E0();
        if (E0 != null) {
            E0.dispose();
            d1(NonDisposableHandle.f3741a);
        }
        Throwable th = null;
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            th = completedExceptionally.f3715a;
        }
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).s(th);
            } catch (Throwable th2) {
                H0(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
            }
        } else {
            NodeList a2 = incomplete.a();
            if (a2 != null) {
                T0(a2, th);
            }
        }
    }

    public final Object l1(Object obj, Object obj2) {
        return !(obj instanceof Incomplete) ? JobSupportKt.f3739a : (((obj instanceof Empty) || (obj instanceof JobNode)) && !(obj instanceof ChildHandleNode) && !(obj2 instanceof CompletedExceptionally)) ? j1((Incomplete) obj, obj2) ? obj2 : JobSupportKt.c : m1((Incomplete) obj, obj2);
    }

    public final void m0(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        ChildHandleNode R0 = R0(childHandleNode);
        if (R0 == null || !n1(finishing, R0, obj)) {
            X(o0(finishing, obj));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0066, code lost:
        if (r2 == null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0068, code lost:
        S0(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006b, code lost:
        r8 = s0(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006f, code lost:
        if (r8 == null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0075, code lost:
        if (n1(r1, r8, r9) == false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0079, code lost:
        return kotlinx.coroutines.JobSupportKt.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x007e, code lost:
        return o0(r1, r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1(kotlinx.coroutines.Incomplete r8, java.lang.Object r9) {
        /*
            r7 = this;
            kotlinx.coroutines.NodeList r0 = r7.D0(r8)
            if (r0 != 0) goto L_0x000b
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.c
            return r7
        L_0x000b:
            boolean r1 = r8 instanceof kotlinx.coroutines.JobSupport.Finishing
            r2 = 0
            if (r1 == 0) goto L_0x0014
            r1 = r8
            kotlinx.coroutines.JobSupport$Finishing r1 = (kotlinx.coroutines.JobSupport.Finishing) r1
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            r3 = 0
            if (r1 != 0) goto L_0x001d
            kotlinx.coroutines.JobSupport$Finishing r1 = new kotlinx.coroutines.JobSupport$Finishing
            r1.<init>(r0, r3, r2)
        L_0x001d:
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            monitor-enter(r1)
            boolean r4 = r1.g()     // Catch:{ all -> 0x002f }
            if (r4 == 0) goto L_0x0031
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.f3739a     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            return r7
        L_0x002f:
            r7 = move-exception
            goto L_0x007f
        L_0x0031:
            r4 = 1
            r1.j(r4)     // Catch:{ all -> 0x002f }
            if (r1 == r8) goto L_0x0045
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = f3737a     // Catch:{ all -> 0x002f }
            boolean r5 = com.honey.account.i.a.a(r5, r7, r8, r1)     // Catch:{ all -> 0x002f }
            if (r5 != 0) goto L_0x0045
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.c     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            return r7
        L_0x0045:
            boolean r5 = r1.f()     // Catch:{ all -> 0x002f }
            boolean r6 = r9 instanceof kotlinx.coroutines.CompletedExceptionally     // Catch:{ all -> 0x002f }
            if (r6 == 0) goto L_0x0051
            r6 = r9
            kotlinx.coroutines.CompletedExceptionally r6 = (kotlinx.coroutines.CompletedExceptionally) r6     // Catch:{ all -> 0x002f }
            goto L_0x0052
        L_0x0051:
            r6 = r2
        L_0x0052:
            if (r6 == 0) goto L_0x0059
            java.lang.Throwable r6 = r6.f3715a     // Catch:{ all -> 0x002f }
            r1.b(r6)     // Catch:{ all -> 0x002f }
        L_0x0059:
            java.lang.Throwable r6 = r1.e()     // Catch:{ all -> 0x002f }
            r4 = r4 ^ r5
            if (r4 == 0) goto L_0x0061
            r2 = r6
        L_0x0061:
            r3.element = r2     // Catch:{ all -> 0x002f }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            if (r2 == 0) goto L_0x006b
            r7.S0(r0, r2)
        L_0x006b:
            kotlinx.coroutines.ChildHandleNode r8 = r7.s0(r8)
            if (r8 == 0) goto L_0x007a
            boolean r8 = r7.n1(r1, r8, r9)
            if (r8 == 0) goto L_0x007a
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.b
            return r7
        L_0x007a:
            java.lang.Object r7 = r7.o0(r1, r9)
            return r7
        L_0x007f:
            monitor-exit(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.m1(kotlinx.coroutines.Incomplete, java.lang.Object):java.lang.Object");
    }

    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return Job.DefaultImpls.e(this, key);
    }

    public final void n(ParentJob parentJob) {
        b0(parentJob);
    }

    public final Throwable n0(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new JobCancellationException(j0(), (Throwable) null, this) : th;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ParentJob) obj).c0();
    }

    public final boolean n1(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        while (Job.DefaultImpls.d(childHandleNode.e, false, false, new ChildCompletion(this, finishing, childHandleNode, obj), 1, (Object) null) == NonDisposableHandle.f3741a) {
            childHandleNode = R0(childHandleNode);
            if (childHandleNode == null) {
                return false;
            }
        }
        return true;
    }

    public final Object o0(Finishing finishing, Object obj) {
        boolean f;
        Throwable A0;
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.f3715a : null;
        synchronized (finishing) {
            f = finishing.f();
            List i = finishing.i(th);
            A0 = A0(finishing, i);
            if (A0 != null) {
                W(A0, i);
            }
        }
        if (!(A0 == null || A0 == th)) {
            obj = new CompletedExceptionally(A0, false, 2, (DefaultConstructorMarker) null);
        }
        if (A0 != null && (h0(A0) || G0(A0))) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((CompletedExceptionally) obj).b();
        }
        if (!f) {
            W0(A0);
        }
        X0(obj);
        a.a(f3737a, this, finishing, JobSupportKt.g(obj));
        l0(finishing, obj);
        return obj;
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return Job.DefaultImpls.f(this, coroutineContext);
    }

    public final DisposableHandle r(Function1 function1) {
        return S(false, true, function1);
    }

    public final ChildHandleNode s0(Incomplete incomplete) {
        ChildHandleNode childHandleNode = incomplete instanceof ChildHandleNode ? (ChildHandleNode) incomplete : null;
        if (childHandleNode != null) {
            return childHandleNode;
        }
        NodeList a2 = incomplete.a();
        if (a2 != null) {
            return R0(a2);
        }
        return null;
    }

    public final boolean start() {
        int e1;
        do {
            e1 = e1(F0());
            if (e1 == 0) {
                return false;
            }
        } while (e1 != 1);
        return true;
    }

    public String toString() {
        return i1() + '@' + DebugStringsKt.b(this);
    }

    public final Object u0() {
        Object F0 = F0();
        if (!(!(F0 instanceof Incomplete))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        } else if (!(F0 instanceof CompletedExceptionally)) {
            return JobSupportKt.h(F0);
        } else {
            throw ((CompletedExceptionally) F0).f3715a;
        }
    }

    public final Throwable v0() {
        Object F0 = F0();
        if (F0 instanceof Finishing) {
            Throwable e = ((Finishing) F0).e();
            if (e != null) {
                return e;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (F0 instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (F0 instanceof CompletedExceptionally) {
            return ((CompletedExceptionally) F0).f3715a;
        } else {
            return null;
        }
    }

    public final boolean w0() {
        Object F0 = F0();
        return (F0 instanceof CompletedExceptionally) && ((CompletedExceptionally) F0).a();
    }

    public final Throwable z0(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.f3715a;
        }
        return null;
    }
}

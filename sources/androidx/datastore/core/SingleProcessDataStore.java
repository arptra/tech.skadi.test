package androidx.datastore.core;

import com.upuphone.starrynet.core.ble.channel.packet.Packet;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 W*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0003XYZB\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012?\b\u0002\u0010\u0011\u001a9\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\t0\b\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017JF\u0010\u001a\u001a\u00028\u000021\u0010\u0019\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\tH@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010!\u001a\u00020\u000f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J!\u0010%\u001a\u00020\u000f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#H@ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u0013\u0010'\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0004\b)\u0010(J\u0013\u0010\u0018\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010(J\u0013\u0010*\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b*\u0010(J\u0013\u0010+\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b+\u0010(JN\u0010.\u001a\u00028\u000021\u0010\u0019\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\t2\u0006\u0010-\u001a\u00020,H@ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u0013\u00100\u001a\u00020\u000f*\u00020\u0004H\u0002¢\u0006\u0004\b0\u00101R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u00102R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R \u0010>\u001a\b\u0012\u0004\u0012\u00028\u0000098\u0016X\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002XD¢\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR&\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000I0H8\u0002X\u0004¢\u0006\f\n\u0004\bJ\u0010K\u0012\u0004\bL\u0010MRR\u0010Q\u001a;\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\t\u0018\u00010\b8\u0002@\u0002X\u000eø\u0001\u0000¢\u0006\u0006\n\u0004\bO\u0010PR \u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000S0R8\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010U\u0002\u0004\n\u0002\b\u0019¨\u0006["}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore;", "T", "Landroidx/datastore/core/DataStore;", "Lkotlin/Function0;", "Ljava/io/File;", "produceFile", "Landroidx/datastore/core/Serializer;", "serializer", "", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "", "initTasksList", "Landroidx/datastore/core/CorruptionHandler;", "corruptionHandler", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/datastore/core/Serializer;Ljava/util/List;Landroidx/datastore/core/CorruptionHandler;Lkotlinx/coroutines/CoroutineScope;)V", "t", "transform", "a", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newData", "z", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "read", "r", "(Landroidx/datastore/core/SingleProcessDataStore$Message$Read;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "update", "s", "(Landroidx/datastore/core/SingleProcessDataStore$Message$Update;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "u", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "v", "x", "w", "Lkotlin/coroutines/CoroutineContext;", "callerContext", "y", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "p", "(Ljava/io/File;)V", "Lkotlin/jvm/functions/Function0;", "b", "Landroidx/datastore/core/Serializer;", "c", "Landroidx/datastore/core/CorruptionHandler;", "d", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/Flow;", "e", "Lkotlinx/coroutines/flow/Flow;", "getData", "()Lkotlinx/coroutines/flow/Flow;", "data", "", "f", "Ljava/lang/String;", "SCRATCH_SUFFIX", "g", "Lkotlin/Lazy;", "q", "()Ljava/io/File;", "file", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/datastore/core/State;", "h", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getDownstreamFlow$annotations", "()V", "downstreamFlow", "i", "Ljava/util/List;", "initTasks", "Landroidx/datastore/core/SimpleActor;", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "j", "Landroidx/datastore/core/SimpleActor;", "actor", "k", "Companion", "Message", "UncloseableOutputStream", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class SingleProcessDataStore<T> implements DataStore<T> {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public static final Set l = new LinkedHashSet();
    public static final Object m = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Function0 f1019a;
    public final Serializer b;
    public final CorruptionHandler c;
    public final CoroutineScope d;
    public final Flow e = FlowKt.C(new SingleProcessDataStore$data$1(this, (Continuation<? super SingleProcessDataStore$data$1>) null));
    public final String f = DiskFileUpload.postfix;
    public final Lazy g = LazyKt.lazy(new SingleProcessDataStore$file$2(this));
    public final MutableStateFlow h = StateFlowKt.a(UnInitialized.f1026a);
    public List i;
    public final SimpleActor j;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00018\u0000X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Companion;", "", "<init>", "()V", "", "", "activeFiles", "Ljava/util/Set;", "a", "()Ljava/util/Set;", "activeFilesLock", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set a() {
            return SingleProcessDataStore.l;
        }

        public final Object b() {
            return SingleProcessDataStore.m;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0002\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message;", "T", "", "<init>", "()V", "Read", "Update", "Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "datastore-core"}, k = 1, mv = {1, 5, 1})
    public static abstract class Message<T> {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00038\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "T", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "Landroidx/datastore/core/State;", "lastState", "<init>", "(Landroidx/datastore/core/State;)V", "a", "Landroidx/datastore/core/State;", "()Landroidx/datastore/core/State;", "datastore-core"}, k = 1, mv = {1, 5, 1})
        public static final class Read<T> extends Message<T> {

            /* renamed from: a  reason: collision with root package name */
            public final State f1022a;

            public Read(State state) {
                super((DefaultConstructorMarker) null);
                this.f1022a = state;
            }

            public State a() {
                return this.f1022a;
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002Bc\u00121\u0010\t\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00020\n\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011RE\u0010\t\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00038\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0018R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\f8\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u0016\u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "T", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "t", "Lkotlin/coroutines/Continuation;", "", "transform", "Lkotlinx/coroutines/CompletableDeferred;", "ack", "Landroidx/datastore/core/State;", "lastState", "Lkotlin/coroutines/CoroutineContext;", "callerContext", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CompletableDeferred;Landroidx/datastore/core/State;Lkotlin/coroutines/CoroutineContext;)V", "a", "Lkotlin/jvm/functions/Function2;", "d", "()Lkotlin/jvm/functions/Function2;", "b", "Lkotlinx/coroutines/CompletableDeferred;", "()Lkotlinx/coroutines/CompletableDeferred;", "c", "Landroidx/datastore/core/State;", "()Landroidx/datastore/core/State;", "Lkotlin/coroutines/CoroutineContext;", "()Lkotlin/coroutines/CoroutineContext;", "datastore-core"}, k = 1, mv = {1, 5, 1})
        public static final class Update<T> extends Message<T> {

            /* renamed from: a  reason: collision with root package name */
            public final Function2 f1023a;
            public final CompletableDeferred b;
            public final State c;
            public final CoroutineContext d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Update(Function2 function2, CompletableDeferred completableDeferred, State state, CoroutineContext coroutineContext) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(function2, "transform");
                Intrinsics.checkNotNullParameter(completableDeferred, Packet.ACK);
                Intrinsics.checkNotNullParameter(coroutineContext, "callerContext");
                this.f1023a = function2;
                this.b = completableDeferred;
                this.c = state;
                this.d = coroutineContext;
            }

            public final CompletableDeferred a() {
                return this.b;
            }

            public final CoroutineContext b() {
                return this.d;
            }

            public State c() {
                return this.c;
            }

            public final Function2 d() {
                return this.f1023a;
            }
        }

        public /* synthetic */ Message(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Message() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\t\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$UncloseableOutputStream;", "Ljava/io/OutputStream;", "Ljava/io/FileOutputStream;", "fileOutputStream", "<init>", "(Ljava/io/FileOutputStream;)V", "", "b", "", "write", "(I)V", "", "([B)V", "bytes", "off", "len", "([BII)V", "close", "()V", "flush", "a", "Ljava/io/FileOutputStream;", "getFileOutputStream", "()Ljava/io/FileOutputStream;", "datastore-core"}, k = 1, mv = {1, 5, 1})
    public static final class UncloseableOutputStream extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        public final FileOutputStream f1024a;

        public UncloseableOutputStream(FileOutputStream fileOutputStream) {
            Intrinsics.checkNotNullParameter(fileOutputStream, "fileOutputStream");
            this.f1024a = fileOutputStream;
        }

        public void close() {
        }

        public void flush() {
            this.f1024a.flush();
        }

        public void write(int i) {
            this.f1024a.write(i);
        }

        public void write(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "b");
            this.f1024a.write(bArr);
        }

        public void write(byte[] bArr, int i, int i2) {
            Intrinsics.checkNotNullParameter(bArr, "bytes");
            this.f1024a.write(bArr, i, i2);
        }
    }

    public SingleProcessDataStore(Function0 function0, Serializer serializer, List list, CorruptionHandler corruptionHandler, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(list, "initTasksList");
        Intrinsics.checkNotNullParameter(corruptionHandler, "corruptionHandler");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.f1019a = function0;
        this.b = serializer;
        this.c = corruptionHandler;
        this.d = coroutineScope;
        this.i = CollectionsKt.toList(list);
        this.j = new SimpleActor(coroutineScope, new SingleProcessDataStore$actor$1(this), SingleProcessDataStore$actor$2.INSTANCE, new SingleProcessDataStore$actor$3(this, (Continuation<? super SingleProcessDataStore$actor$3>) null));
    }

    public Object a(Function2 function2, Continuation continuation) {
        CompletableDeferred c2 = CompletableDeferredKt.c((Job) null, 1, (Object) null);
        this.j.e(new Message.Update(function2, c2, (State) this.h.getValue(), continuation.getContext()));
        return c2.c(continuation);
    }

    public Flow getData() {
        return this.e;
    }

    public final void p(File file) {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException(Intrinsics.stringPlus("Unable to create parent directories of ", file));
            }
        }
    }

    public final File q() {
        return (File) this.g.getValue();
    }

    public final Object r(Message.Read read, Continuation continuation) {
        State state = (State) this.h.getValue();
        if (!(state instanceof Data)) {
            if (state instanceof ReadException) {
                if (state == read.a()) {
                    Object v = v(continuation);
                    return v == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? v : Unit.INSTANCE;
                }
            } else if (Intrinsics.areEqual((Object) state, (Object) UnInitialized.f1026a)) {
                Object v2 = v(continuation);
                return v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? v2 : Unit.INSTANCE;
            } else if (state instanceof Final) {
                throw new IllegalStateException("Can't read in final state.".toString());
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object s(androidx.datastore.core.SingleProcessDataStore.Message.Update r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.SingleProcessDataStore$handleUpdate$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.datastore.core.SingleProcessDataStore$handleUpdate$1 r0 = (androidx.datastore.core.SingleProcessDataStore$handleUpdate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$handleUpdate$1 r0 = new androidx.datastore.core.SingleProcessDataStore$handleUpdate$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0057
            if (r2 == r5) goto L_0x0052
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.CompletableDeferred r8 = (kotlinx.coroutines.CompletableDeferred) r8
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0034 }
            goto L_0x00bc
        L_0x0034:
            r9 = move-exception
            goto L_0x00d9
        L_0x0037:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003f:
            java.lang.Object r8 = r0.L$2
            kotlinx.coroutines.CompletableDeferred r8 = (kotlinx.coroutines.CompletableDeferred) r8
            java.lang.Object r9 = r0.L$1
            androidx.datastore.core.SingleProcessDataStore r9 = (androidx.datastore.core.SingleProcessDataStore) r9
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore$Message$Update r2 = (androidx.datastore.core.SingleProcessDataStore.Message.Update) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0034 }
            r10 = r8
            r8 = r9
            r9 = r2
            goto L_0x00a4
        L_0x0052:
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.CompletableDeferred r8 = (kotlinx.coroutines.CompletableDeferred) r8
            goto L_0x002f
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.CompletableDeferred r10 = r9.a()
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0083 }
            kotlinx.coroutines.flow.MutableStateFlow r2 = r8.h     // Catch:{ all -> 0x0083 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0083 }
            androidx.datastore.core.State r2 = (androidx.datastore.core.State) r2     // Catch:{ all -> 0x0083 }
            boolean r6 = r2 instanceof androidx.datastore.core.Data     // Catch:{ all -> 0x0083 }
            if (r6 == 0) goto L_0x0086
            kotlin.jvm.functions.Function2 r2 = r9.d()     // Catch:{ all -> 0x0083 }
            kotlin.coroutines.CoroutineContext r9 = r9.b()     // Catch:{ all -> 0x0083 }
            r0.L$0 = r10     // Catch:{ all -> 0x0083 }
            r0.label = r5     // Catch:{ all -> 0x0083 }
            java.lang.Object r8 = r8.y(r2, r9, r0)     // Catch:{ all -> 0x0083 }
            if (r8 != r1) goto L_0x007f
            return r1
        L_0x007f:
            r7 = r10
            r10 = r8
            r8 = r7
            goto L_0x00bc
        L_0x0083:
            r9 = move-exception
            r8 = r10
            goto L_0x00d9
        L_0x0086:
            boolean r6 = r2 instanceof androidx.datastore.core.ReadException     // Catch:{ all -> 0x0083 }
            if (r6 == 0) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            boolean r5 = r2 instanceof androidx.datastore.core.UnInitialized     // Catch:{ all -> 0x0083 }
        L_0x008d:
            if (r5 == 0) goto L_0x00c8
            androidx.datastore.core.State r5 = r9.c()     // Catch:{ all -> 0x0083 }
            if (r2 != r5) goto L_0x00c1
            r0.L$0 = r9     // Catch:{ all -> 0x0083 }
            r0.L$1 = r8     // Catch:{ all -> 0x0083 }
            r0.L$2 = r10     // Catch:{ all -> 0x0083 }
            r0.label = r4     // Catch:{ all -> 0x0083 }
            java.lang.Object r2 = r8.u(r0)     // Catch:{ all -> 0x0083 }
            if (r2 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            kotlin.jvm.functions.Function2 r2 = r9.d()     // Catch:{ all -> 0x0083 }
            kotlin.coroutines.CoroutineContext r9 = r9.b()     // Catch:{ all -> 0x0083 }
            r0.L$0 = r10     // Catch:{ all -> 0x0083 }
            r4 = 0
            r0.L$1 = r4     // Catch:{ all -> 0x0083 }
            r0.L$2 = r4     // Catch:{ all -> 0x0083 }
            r0.label = r3     // Catch:{ all -> 0x0083 }
            java.lang.Object r8 = r8.y(r2, r9, r0)     // Catch:{ all -> 0x0083 }
            if (r8 != r1) goto L_0x007f
            return r1
        L_0x00bc:
            java.lang.Object r9 = kotlin.Result.m20constructorimpl(r10)     // Catch:{ all -> 0x0034 }
            goto L_0x00e3
        L_0x00c1:
            androidx.datastore.core.ReadException r2 = (androidx.datastore.core.ReadException) r2     // Catch:{ all -> 0x0083 }
            java.lang.Throwable r8 = r2.a()     // Catch:{ all -> 0x0083 }
            throw r8     // Catch:{ all -> 0x0083 }
        L_0x00c8:
            boolean r8 = r2 instanceof androidx.datastore.core.Final     // Catch:{ all -> 0x0083 }
            if (r8 == 0) goto L_0x00d3
            androidx.datastore.core.Final r2 = (androidx.datastore.core.Final) r2     // Catch:{ all -> 0x0083 }
            java.lang.Throwable r8 = r2.a()     // Catch:{ all -> 0x0083 }
            throw r8     // Catch:{ all -> 0x0083 }
        L_0x00d3:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x0083 }
            r8.<init>()     // Catch:{ all -> 0x0083 }
            throw r8     // Catch:{ all -> 0x0083 }
        L_0x00d9:
            kotlin.Result$Companion r10 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m20constructorimpl(r9)
        L_0x00e3:
            kotlinx.coroutines.CompletableDeferredKt.d(r8, r9)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.s(androidx.datastore.core.SingleProcessDataStore$Message$Update, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0116 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object t(kotlin.coroutines.Continuation r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInit$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            androidx.datastore.core.SingleProcessDataStore$readAndInit$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInit$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInit$1
            r0.<init>(r13, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x007b
            if (r2 == r6) goto L_0x0067
            if (r2 == r4) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r13 = r0.L$3
            kotlinx.coroutines.sync.Mutex r13 = (kotlinx.coroutines.sync.Mutex) r13
            java.lang.Object r1 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0118
        L_0x0042:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x004a:
            java.lang.Object r13 = r0.L$5
            java.util.Iterator r13 = (java.util.Iterator) r13
            java.lang.Object r2 = r0.L$4
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1 r2 = (androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1) r2
            java.lang.Object r8 = r0.L$3
            kotlin.jvm.internal.Ref$BooleanRef r8 = (kotlin.jvm.internal.Ref.BooleanRef) r8
            java.lang.Object r9 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r0.L$1
            kotlinx.coroutines.sync.Mutex r10 = (kotlinx.coroutines.sync.Mutex) r10
            java.lang.Object r11 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r11 = (androidx.datastore.core.SingleProcessDataStore) r11
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00db
        L_0x0067:
            java.lang.Object r13 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r9 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r9 = (androidx.datastore.core.SingleProcessDataStore) r9
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00ba
        L_0x007b:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlinx.coroutines.flow.MutableStateFlow r14 = r13.h
            java.lang.Object r14 = r14.getValue()
            androidx.datastore.core.UnInitialized r2 = androidx.datastore.core.UnInitialized.f1026a
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r2)
            if (r14 != 0) goto L_0x0099
            kotlinx.coroutines.flow.MutableStateFlow r14 = r13.h
            java.lang.Object r14 = r14.getValue()
            boolean r14 = r14 instanceof androidx.datastore.core.ReadException
            if (r14 == 0) goto L_0x0097
            goto L_0x0099
        L_0x0097:
            r14 = r5
            goto L_0x009a
        L_0x0099:
            r14 = r6
        L_0x009a:
            if (r14 == 0) goto L_0x0139
            kotlinx.coroutines.sync.Mutex r8 = kotlinx.coroutines.sync.MutexKt.b(r5, r6, r7)
            kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
            r14.<init>()
            r0.L$0 = r13
            r0.L$1 = r8
            r0.L$2 = r14
            r0.L$3 = r14
            r0.label = r6
            java.lang.Object r2 = r13.x(r0)
            if (r2 != r1) goto L_0x00b6
            return r1
        L_0x00b6:
            r9 = r13
            r13 = r14
            r14 = r2
            r2 = r13
        L_0x00ba:
            r13.element = r14
            kotlin.jvm.internal.Ref$BooleanRef r13 = new kotlin.jvm.internal.Ref$BooleanRef
            r13.<init>()
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1 r14 = new androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1
            r14.<init>(r8, r13, r2, r9)
            java.util.List r10 = r9.i
            if (r10 != 0) goto L_0x00d0
            r14 = r0
            r0 = r9
            r12 = r8
            r8 = r13
            r13 = r12
            goto L_0x0100
        L_0x00d0:
            java.util.Iterator r10 = r10.iterator()
            r11 = r9
            r9 = r2
            r2 = r14
            r12 = r8
            r8 = r13
            r13 = r10
            r10 = r12
        L_0x00db:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x00fc
            java.lang.Object r14 = r13.next()
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r0.L$0 = r11
            r0.L$1 = r10
            r0.L$2 = r9
            r0.L$3 = r8
            r0.L$4 = r2
            r0.L$5 = r13
            r0.label = r4
            java.lang.Object r14 = r14.invoke(r2, r0)
            if (r14 != r1) goto L_0x00db
            return r1
        L_0x00fc:
            r14 = r0
            r2 = r9
            r13 = r10
            r0 = r11
        L_0x0100:
            r0.i = r7
            r14.L$0 = r0
            r14.L$1 = r2
            r14.L$2 = r8
            r14.L$3 = r13
            r14.L$4 = r7
            r14.L$5 = r7
            r14.label = r3
            java.lang.Object r14 = r13.c(r7, r14)
            if (r14 != r1) goto L_0x0117
            return r1
        L_0x0117:
            r1 = r8
        L_0x0118:
            r1.element = r6     // Catch:{ all -> 0x0134 }
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0134 }
            r13.d(r7)
            kotlinx.coroutines.flow.MutableStateFlow r13 = r0.h
            androidx.datastore.core.Data r14 = new androidx.datastore.core.Data
            T r0 = r2.element
            if (r0 == 0) goto L_0x012b
            int r5 = r0.hashCode()
        L_0x012b:
            r14.<init>(r0, r5)
            r13.setValue(r14)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x0134:
            r14 = move-exception
            r13.d(r7)
            throw r14
        L_0x0139:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "Check failed."
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.t(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object u(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r4 = (androidx.datastore.core.SingleProcessDataStore) r4
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0045
        L_0x002d:
            r5 = move-exception
            goto L_0x0048
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4     // Catch:{ all -> 0x002d }
            r0.label = r3     // Catch:{ all -> 0x002d }
            java.lang.Object r4 = r4.t(r0)     // Catch:{ all -> 0x002d }
            if (r4 != r1) goto L_0x0045
            return r1
        L_0x0045:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0048:
            kotlinx.coroutines.flow.MutableStateFlow r4 = r4.h
            androidx.datastore.core.ReadException r0 = new androidx.datastore.core.ReadException
            r0.<init>(r5)
            r4.setValue(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.u(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object v(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r4 = (androidx.datastore.core.SingleProcessDataStore) r4
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x002d }
            goto L_0x004f
        L_0x002d:
            r5 = move-exception
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4     // Catch:{ all -> 0x002d }
            r0.label = r3     // Catch:{ all -> 0x002d }
            java.lang.Object r4 = r4.t(r0)     // Catch:{ all -> 0x002d }
            if (r4 != r1) goto L_0x004f
            return r1
        L_0x0045:
            kotlinx.coroutines.flow.MutableStateFlow r4 = r4.h
            androidx.datastore.core.ReadException r0 = new androidx.datastore.core.ReadException
            r0.<init>(r5)
            r4.setValue(r0)
        L_0x004f:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.v(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0065, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006d, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0071, code lost:
        throw r7;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:23:0x0061, B:29:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object w(kotlin.coroutines.Continuation r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.datastore.core.SingleProcessDataStore$readData$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readData$1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r6 = r0.L$2
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.lang.Object r1 = r0.L$1
            java.io.Closeable r1 = (java.io.Closeable) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0035 }
            goto L_0x0061
        L_0x0035:
            r6 = move-exception
            goto L_0x006c
        L_0x0037:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r7)
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0072 }
            java.io.File r2 = r6.q()     // Catch:{ FileNotFoundException -> 0x0072 }
            r7.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0072 }
            androidx.datastore.core.Serializer r2 = r6.b     // Catch:{ all -> 0x0067 }
            r0.L$0 = r6     // Catch:{ all -> 0x0067 }
            r0.L$1 = r7     // Catch:{ all -> 0x0067 }
            r4 = 0
            r0.L$2 = r4     // Catch:{ all -> 0x0067 }
            r0.label = r3     // Catch:{ all -> 0x0067 }
            java.lang.Object r0 = r2.b(r7, r0)     // Catch:{ all -> 0x0067 }
            if (r0 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r1 = r7
            r7 = r0
            r0 = r6
            r6 = r4
        L_0x0061:
            kotlin.io.CloseableKt.closeFinally(r1, r6)     // Catch:{ FileNotFoundException -> 0x0065 }
            return r7
        L_0x0065:
            r6 = move-exception
            goto L_0x0075
        L_0x0067:
            r0 = move-exception
            r1 = r7
            r5 = r0
            r0 = r6
            r6 = r5
        L_0x006c:
            throw r6     // Catch:{ all -> 0x006d }
        L_0x006d:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r6)     // Catch:{ FileNotFoundException -> 0x0065 }
            throw r7     // Catch:{ FileNotFoundException -> 0x0065 }
        L_0x0072:
            r7 = move-exception
            r0 = r6
            r6 = r7
        L_0x0075:
            java.io.File r7 = r0.q()
            boolean r7 = r7.exists()
            if (r7 != 0) goto L_0x0086
            androidx.datastore.core.Serializer r6 = r0.b
            java.lang.Object r6 = r6.getDefaultValue()
            return r6
        L_0x0086:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.w(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object x(kotlin.coroutines.Continuation r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0055
            if (r2 == r5) goto L_0x004b
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r7 = r0.L$1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.CorruptionException r0 = (androidx.datastore.core.CorruptionException) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ IOException -> 0x0035 }
            goto L_0x0085
        L_0x0035:
            r7 = move-exception
            goto L_0x0089
        L_0x0037:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003f:
            java.lang.Object r7 = r0.L$1
            androidx.datastore.core.CorruptionException r7 = (androidx.datastore.core.CorruptionException) r7
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r2 = (androidx.datastore.core.SingleProcessDataStore) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0077
        L_0x004b:
            java.lang.Object r7 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r7 = (androidx.datastore.core.SingleProcessDataStore) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ CorruptionException -> 0x0053 }
            goto L_0x0063
        L_0x0053:
            r8 = move-exception
            goto L_0x0064
        L_0x0055:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r7     // Catch:{ CorruptionException -> 0x0053 }
            r0.label = r5     // Catch:{ CorruptionException -> 0x0053 }
            java.lang.Object r8 = r7.w(r0)     // Catch:{ CorruptionException -> 0x0053 }
            if (r8 != r1) goto L_0x0063
            return r1
        L_0x0063:
            return r8
        L_0x0064:
            androidx.datastore.core.CorruptionHandler r2 = r7.c
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r2 = r2.a(r8, r0)
            if (r2 != r1) goto L_0x0073
            return r1
        L_0x0073:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L_0x0077:
            r0.L$0 = r7     // Catch:{ IOException -> 0x0086 }
            r0.L$1 = r8     // Catch:{ IOException -> 0x0086 }
            r0.label = r3     // Catch:{ IOException -> 0x0086 }
            java.lang.Object r7 = r2.z(r8, r0)     // Catch:{ IOException -> 0x0086 }
            if (r7 != r1) goto L_0x0084
            return r1
        L_0x0084:
            r7 = r8
        L_0x0085:
            return r7
        L_0x0086:
            r8 = move-exception
            r0 = r7
            r7 = r8
        L_0x0089:
            kotlin.ExceptionsKt.addSuppressed(r0, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.x(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object y(kotlin.jvm.functions.Function2 r9, kotlin.coroutines.CoroutineContext r10, kotlin.coroutines.Continuation r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = (androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            r0.<init>(r8, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 == r5) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            java.lang.Object r8 = r0.L$1
            java.lang.Object r9 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r9 = (androidx.datastore.core.SingleProcessDataStore) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x008f
        L_0x0033:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003b:
            java.lang.Object r8 = r0.L$2
            java.lang.Object r9 = r0.L$1
            androidx.datastore.core.Data r9 = (androidx.datastore.core.Data) r9
            java.lang.Object r10 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r10 = (androidx.datastore.core.SingleProcessDataStore) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0074
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.flow.MutableStateFlow r11 = r8.h
            java.lang.Object r11 = r11.getValue()
            androidx.datastore.core.Data r11 = (androidx.datastore.core.Data) r11
            r11.a()
            java.lang.Object r2 = r11.b()
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1 r6 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1
            r6.<init>(r9, r2, r3)
            r0.L$0 = r8
            r0.L$1 = r11
            r0.L$2 = r2
            r0.label = r5
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.g(r10, r6, r0)
            if (r9 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r10 = r8
            r8 = r2
            r7 = r11
            r11 = r9
            r9 = r7
        L_0x0074:
            r9.a()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r11)
            if (r9 == 0) goto L_0x007e
            goto L_0x00a1
        L_0x007e:
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r3
            r0.label = r4
            java.lang.Object r8 = r10.z(r11, r0)
            if (r8 != r1) goto L_0x008d
            return r1
        L_0x008d:
            r9 = r10
            r8 = r11
        L_0x008f:
            kotlinx.coroutines.flow.MutableStateFlow r9 = r9.h
            androidx.datastore.core.Data r10 = new androidx.datastore.core.Data
            if (r8 == 0) goto L_0x009a
            int r11 = r8.hashCode()
            goto L_0x009b
        L_0x009a:
            r11 = 0
        L_0x009b:
            r10.<init>(r8, r11)
            r9.setValue(r10)
        L_0x00a1:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.y(kotlin.jvm.functions.Function2, kotlin.coroutines.CoroutineContext, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a2 A[SYNTHETIC, Splitter:B:30:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object z(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.datastore.core.SingleProcessDataStore$writeData$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            androidx.datastore.core.SingleProcessDataStore$writeData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$writeData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$writeData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$writeData$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r7 = r0.L$4
            java.io.FileOutputStream r7 = (java.io.FileOutputStream) r7
            java.lang.Object r8 = r0.L$3
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            java.lang.Object r1 = r0.L$2
            java.io.Closeable r1 = (java.io.Closeable) r1
            java.lang.Object r2 = r0.L$1
            java.io.File r2 = (java.io.File) r2
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x003d }
            goto L_0x0089
        L_0x003d:
            r7 = move-exception
            goto L_0x00c2
        L_0x0040:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r9)
            java.io.File r9 = r7.q()
            r7.p(r9)
            java.io.File r2 = new java.io.File
            java.io.File r9 = r7.q()
            java.lang.String r9 = r9.getAbsolutePath()
            java.lang.String r4 = r7.f
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r4)
            r2.<init>(r9)
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00be }
            r9.<init>(r2)     // Catch:{ IOException -> 0x00be }
            androidx.datastore.core.Serializer r4 = r7.b     // Catch:{ all -> 0x00c0 }
            androidx.datastore.core.SingleProcessDataStore$UncloseableOutputStream r5 = new androidx.datastore.core.SingleProcessDataStore$UncloseableOutputStream     // Catch:{ all -> 0x00c0 }
            r5.<init>(r9)     // Catch:{ all -> 0x00c0 }
            r0.L$0 = r7     // Catch:{ all -> 0x00c0 }
            r0.L$1 = r2     // Catch:{ all -> 0x00c0 }
            r0.L$2 = r9     // Catch:{ all -> 0x00c0 }
            r6 = 0
            r0.L$3 = r6     // Catch:{ all -> 0x00c0 }
            r0.L$4 = r9     // Catch:{ all -> 0x00c0 }
            r0.label = r3     // Catch:{ all -> 0x00c0 }
            java.lang.Object r8 = r4.a(r8, r5, r0)     // Catch:{ all -> 0x00c0 }
            if (r8 != r1) goto L_0x0085
            return r1
        L_0x0085:
            r0 = r7
            r7 = r9
            r1 = r7
            r8 = r6
        L_0x0089:
            java.io.FileDescriptor r7 = r7.getFD()     // Catch:{ all -> 0x003d }
            r7.sync()     // Catch:{ all -> 0x003d }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003d }
            kotlin.io.CloseableKt.closeFinally(r1, r8)     // Catch:{ IOException -> 0x00be }
            java.io.File r7 = r0.q()     // Catch:{ IOException -> 0x00be }
            boolean r7 = r2.renameTo(r7)     // Catch:{ IOException -> 0x00be }
            if (r7 == 0) goto L_0x00a2
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x00a2:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ IOException -> 0x00be }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00be }
            r8.<init>()     // Catch:{ IOException -> 0x00be }
            java.lang.String r9 = "Unable to rename "
            r8.append(r9)     // Catch:{ IOException -> 0x00be }
            r8.append(r2)     // Catch:{ IOException -> 0x00be }
            java.lang.String r9 = ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file."
            r8.append(r9)     // Catch:{ IOException -> 0x00be }
            java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x00be }
            r7.<init>(r8)     // Catch:{ IOException -> 0x00be }
            throw r7     // Catch:{ IOException -> 0x00be }
        L_0x00be:
            r7 = move-exception
            goto L_0x00c8
        L_0x00c0:
            r7 = move-exception
            r1 = r9
        L_0x00c2:
            throw r7     // Catch:{ all -> 0x00c3 }
        L_0x00c3:
            r8 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r7)     // Catch:{ IOException -> 0x00be }
            throw r8     // Catch:{ IOException -> 0x00be }
        L_0x00c8:
            boolean r8 = r2.exists()
            if (r8 == 0) goto L_0x00d1
            r2.delete()
        L_0x00d1:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.z(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

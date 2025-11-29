package io.ktor.websocket;

import com.meizu.common.widget.MzContactsContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\rR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/websocket/WebSocketExtensionHeader;", "", "", "name", "", "parameters", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "c", "()Lkotlin/sequences/Sequence;", "toString", "()Ljava/lang/String;", "b", "a", "Ljava/lang/String;", "Ljava/util/List;", "getParameters", "()Ljava/util/List;", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
public final class WebSocketExtensionHeader {

    /* renamed from: a  reason: collision with root package name */
    public final String f9142a;
    public final List b;

    public WebSocketExtensionHeader(String str, List list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "parameters");
        this.f9142a = str;
        this.b = list;
    }

    public final String a() {
        return this.f9142a;
    }

    public final String b() {
        if (this.b.isEmpty()) {
            return "";
        }
        return ", " + CollectionsKt.joinToString$default(this.b, MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final Sequence c() {
        return SequencesKt.map(CollectionsKt.asSequence(this.b), WebSocketExtensionHeader$parseParameters$1.INSTANCE);
    }

    public String toString() {
        return this.f9142a + ' ' + b();
    }
}

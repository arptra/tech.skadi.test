package io.ktor.utils.io.jvm.javaio;

import com.upuphone.runasone.api.ApiConstant;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/utils/io/jvm/javaio/ProhibitParking;", "Lio/ktor/utils/io/jvm/javaio/Parking;", "Ljava/lang/Thread;", "<init>", "()V", "", "timeNanos", "", "a", "(J)V", "token", "d", "(Ljava/lang/Thread;)V", "", "c", "()Ljava/lang/Void;", "ktor-io"}, k = 1, mv = {1, 8, 0})
final class ProhibitParking implements Parking<Thread> {

    /* renamed from: a  reason: collision with root package name */
    public static final ProhibitParking f9114a = new ProhibitParking();

    public void a(long j) {
        c();
        throw new KotlinNothingValueException();
    }

    public final Void c() {
        throw new UnsupportedOperationException("Parking is prohibited on this thread. Most likely you are using blocking operation on the wrong thread/dispatcher that doesn't allow blocking. Consider wrapping you blocking code withContext(Dispatchers.IO) {...}.");
    }

    /* renamed from: d */
    public void b(Thread thread) {
        Intrinsics.checkNotNullParameter(thread, ApiConstant.KEY_TOKEN);
        DefaultParking.f9110a.b(thread);
    }
}

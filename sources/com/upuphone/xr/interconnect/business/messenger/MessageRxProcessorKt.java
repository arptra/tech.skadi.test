package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.xr.interconnect.business.messenger.compat.Version0MessageConsumer;
import com.upuphone.xr.interconnect.business.messenger.compat.Version1MessageConsumer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0001\u0010\u0000\u001a~\u0012\u0004\u0012\u00020\u0002\u00124\u00122\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00030\u0001j>\u0012\u0004\u0012\u00020\u0002\u00124\u00122\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003`\u000bX\u0004¢\u0006\u0002\n\u0000\"\u0001\u0010\f\u001a~\u0012\u0004\u0012\u00020\u0002\u00124\u00122\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00030\u0001j>\u0012\u0004\u0012\u00020\u0002\u00124\u00122\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003`\u000bX\u0004¢\u0006\u0002\n\u0000*l\b\u0000\u0010\r\"2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u000322\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003¨\u0006\u000e"}, d2 = {"messageConsumerMap", "Ljava/util/HashMap;", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "data", "", "logTag", "", "Lkotlin/collections/HashMap;", "messageConsumerMapFroPro", "MessageConsumer", "SharedImpl_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class MessageRxProcessorKt {
    /* access modifiers changed from: private */
    @NotNull
    public static final HashMap<Integer, Function2<byte[], String, Unit>> messageConsumerMap = MapsKt.hashMapOf(TuplesKt.to(0, new Version0MessageConsumer()), TuplesKt.to(1, new Version1MessageConsumer()), TuplesKt.to(2, new Version1MessageConsumer()), TuplesKt.to(3, new Version1MessageConsumer()), TuplesKt.to(4, new Version1MessageConsumer()), TuplesKt.to(5, new Version1MessageConsumer()), TuplesKt.to(6, new Version1MessageConsumer()), TuplesKt.to(7, new Version1MessageConsumer()), TuplesKt.to(8, new Version1MessageConsumer()));
    /* access modifiers changed from: private */
    @NotNull
    public static final HashMap<Integer, Function2<byte[], String, Unit>> messageConsumerMapFroPro = MapsKt.hashMapOf(TuplesKt.to(0, new Version0MessageConsumer()), TuplesKt.to(1, new Version1MessageConsumer()), TuplesKt.to(2, new Version1MessageConsumer()), TuplesKt.to(3, new Version1MessageConsumer()), TuplesKt.to(4, new Version1MessageConsumer()), TuplesKt.to(5, new Version1MessageConsumer()), TuplesKt.to(6, new Version1MessageConsumer()), TuplesKt.to(7, new Version1MessageConsumer()), TuplesKt.to(100, new Version1MessageConsumer()));
}

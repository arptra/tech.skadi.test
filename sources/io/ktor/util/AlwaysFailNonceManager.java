package io.ktor.util;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/util/AlwaysFailNonceManager;", "Lio/ktor/util/NonceManager;", "<init>", "()V", "ktor-utils"}, k = 1, mv = {1, 8, 0})
@Deprecated(level = DeprecationLevel.ERROR, message = "This should be removed with OAuth2StateProvider")
@InternalAPI
public final class AlwaysFailNonceManager implements NonceManager {

    /* renamed from: a  reason: collision with root package name */
    public static final AlwaysFailNonceManager f9016a = new AlwaysFailNonceManager();
}

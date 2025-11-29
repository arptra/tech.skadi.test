package io.ktor.util.cio;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lio/ktor/util/cio/Semaphore;", "", "ktor-utils"}, k = 1, mv = {1, 8, 0})
@Deprecated(level = DeprecationLevel.ERROR, message = "Ktor Semaphore is deprecated and will be removed in ktor 2.0.0. Consider using kotlinx.coroutines Semaphore instead.", replaceWith = @ReplaceWith(expression = "Semaphore", imports = {"kotlinx.coroutines.sync.Semaphore"}))
public final class Semaphore {
}

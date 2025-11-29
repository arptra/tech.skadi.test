package io.netty.buffer;

import java.util.List;

public interface PoolArenaMetric extends SizeClassesMetric {
    List<PoolChunkListMetric> chunkLists();

    long numActiveAllocations();

    long numActiveBytes();

    long numActiveHugeAllocations();

    long numActiveNormalAllocations();

    long numActiveSmallAllocations();

    @Deprecated
    long numActiveTinyAllocations();

    long numAllocations();

    int numChunkLists();

    long numDeallocations();

    long numHugeAllocations();

    long numHugeDeallocations();

    long numNormalAllocations();

    long numNormalDeallocations();

    long numSmallAllocations();

    long numSmallDeallocations();

    int numSmallSubpages();

    int numThreadCaches();

    @Deprecated
    long numTinyAllocations();

    @Deprecated
    long numTinyDeallocations();

    @Deprecated
    int numTinySubpages();

    List<PoolSubpageMetric> smallSubpages();

    @Deprecated
    List<PoolSubpageMetric> tinySubpages();
}

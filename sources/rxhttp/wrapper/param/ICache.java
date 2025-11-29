package rxhttp.wrapper.param;

import rxhttp.wrapper.cache.CacheMode;
import rxhttp.wrapper.cache.CacheStrategy;
import rxhttp.wrapper.param.Param;

public interface ICache<P extends Param<P>> {
    CacheMode getCacheMode();

    CacheStrategy h();
}

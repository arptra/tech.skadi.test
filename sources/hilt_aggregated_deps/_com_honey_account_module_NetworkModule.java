package hilt_aggregated_deps;

import dagger.hilt.processor.internal.aggregateddeps.AggregatedDeps;

@AggregatedDeps(components = {"dagger.hilt.components.SingletonComponent"}, modules = {"com.honey.account.module.NetworkModule"})
public class _com_honey_account_module_NetworkModule {
}

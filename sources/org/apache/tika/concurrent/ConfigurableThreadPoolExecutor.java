package org.apache.tika.concurrent;

import java.util.concurrent.ExecutorService;

public interface ConfigurableThreadPoolExecutor extends ExecutorService {
    void setCorePoolSize(int i);

    void setMaximumPoolSize(int i);
}

package org.apache.tika.config;

import java.util.Map;

public interface Initializable {
    void checkInitialization(InitializableProblemHandler initializableProblemHandler);

    void initialize(Map map);
}

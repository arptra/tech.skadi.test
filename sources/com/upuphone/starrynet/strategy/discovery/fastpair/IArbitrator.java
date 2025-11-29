package com.upuphone.starrynet.strategy.discovery.fastpair;

public interface IArbitrator {
    public static final int RESULT_DIRECT_PAIR = 1;
    public static final int RESULT_NEED_DISPATCH = 3;
    public static final int RESULT_NEED_FOUND = 4;
    public static final int RESULT_NEED_POP = 2;
    public static final int RESULT_NO_NEED_POP = 0;
}

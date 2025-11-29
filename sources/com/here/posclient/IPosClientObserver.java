package com.here.posclient;

public interface IPosClientObserver {
    void positionUpdate(PositionEstimate positionEstimate);

    void positioningError(int i, int i2);

    void positioningInfo(int i);
}

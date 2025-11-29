package com.upuphone.starrynet.api;

import android.os.Bundle;

public interface IStarryNetConfig {
    Bundle getConfig(int i);

    Bundle getConfigAll();

    void updateConfig(Bundle bundle);
}
